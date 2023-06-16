import java.util.ArrayList;
import java.util.List;

public abstract class MazeSolver
{
   private Maze maze;

   public MazeSolver(Maze maze)
   {
       this.maze = maze;
       makeEmpty();
       add(maze.getStart());
   }

   public abstract void makeEmpty();

   public abstract boolean isEmpty();

   public abstract void add(Square s);

   public abstract Square next();

   public boolean isSolved()
   {
       boolean solvable = true;
       boolean solved = false;
       if (isEmpty())
       {
           solvable = false;
           solved = true;
       }
       if(solvable)
       {
           solved = next() == maze.getExit();
       }
       return solved;

   }

   public void step()
   {
       Square nextLoc = next();
       if (isEmpty() || nextLoc == maze.getExit())
       {
           return;
       }
       nextLoc.setStatus(Square.EXPLORED);

       List<Square> neighbors = maze.getNeighbors(nextLoc);
       for (Square n: neighbors)
       {
           if(n.getType() < 1 && n.getStatus() == Square.UNKNOWN)
           {
               add(n);
               n.setStatus(Square.WORKING);
           }
       }
       String thing = getPath();
   }

   public String getPath()
   {
// add an object and then use next so that ur basically deleting nothing -  ## next() should actually be popping, not peeking
       boolean solved = false;
       boolean solvable = true;
       return "";
   }

   public void solve()
   {
       while(!isSolved())
       {
           step();
       }
   }
}
