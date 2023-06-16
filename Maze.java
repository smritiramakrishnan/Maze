import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Maze
{
   private Square[][] maze;
   private Square start, exit;

   public Maze()
   {
   }

   public boolean loadMaze(String fileName) throws IOException
   {
       try
       {
           File file = new File(fileName);
           Scanner input = new Scanner(file);
           int tempRow = input.nextInt();
           int tempCol = input.nextInt();
           maze = new Square[tempRow][tempCol];
           for (int r = 0; r < tempRow; r++)
           {
               for (int c = 0; c < tempCol; c++)
               {
                   int temp = input.nextInt();
                   maze[r][c] = new Square(r, c, temp);
                   if (temp == 2)
                   {
                       start = maze[r][c];
                   }
                   else if (temp == 3)
                   {
                       exit = maze[r][c];
                   }
               }
           }
           return true;
       }
       catch(FileNotFoundException e)
       {
           System.out.println("The file input was not found :(");
           return false;
       }
   }

   public List<Square> getNeighbors(Square s)
   {
       ArrayList<Square> neighbors = new ArrayList<Square>();
       if (s.getRow() > 0) //North
       {
           neighbors.add(maze[s.getRow() - 1][s.getCol()]);
       }
       if (s.getCol() < maze[0].length - 1 ) //East
       {
           neighbors.add(maze[s.getRow()][s.getCol() + 1]);
       }
       if (s.getRow() < maze.length - 1 ) //South
       {
           neighbors.add(maze[s.getRow() + 1][s.getCol()]);
       }
       if (s.getCol() > 0) //West
       {
           neighbors.add(maze[s.getRow()][s.getCol() - 1]);
       }
       return neighbors;
   }

   public Square getStart()
   {
       return start;
   }

   public Square getExit()
   {
       return exit;
   }

   public void reset()
   {
       for (int r = 0; r < maze.length; r++)
       {
           for (int c = 0; c < maze[0].length; c++)
           {
               if(maze[r][c].getType() < 1)
               {
                   maze[r][c].setStatus(Square.UNKNOWN);
               }
           }
       }
   }

   public String toString()
   {
       String ret = "";
       for (int r = 0; r < maze.length; r ++)
       {
           for (int c = 0; c < maze[r].length; c ++)
           {
               ret += "" + maze[r][c].toString() + " ";
           }
           ret += "\n";
       }
       return ret;
   }
}

