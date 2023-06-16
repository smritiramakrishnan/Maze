public class MazeSolverStack extends MazeSolver
{
   private MyStack worklist;

   public MazeSolverStack(Maze maze)
   {
       super(maze);
       makeEmpty();
       add(maze.getStart());
   }

   public void makeEmpty()
   {
       worklist = new MyStack();
   }

   public boolean isEmpty()
   {
       return worklist.size() == 0;
   }

   public void add(Square s)
   {
       worklist.push(s);
   }

   public Square next()
   {
       return worklist.peek();
   }
}
