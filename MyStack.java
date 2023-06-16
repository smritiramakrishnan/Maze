import java.util.*;
import java.util.Arrays;
public class MyStack implements StackADT
{
   private Square[] stack;
   private int size;
   public MyStack(int initCap)
   {
       size = 0;
       stack = new Square[initCap];
   }
   public MyStack()
   {
       this(4);
   }

   public boolean isEmpty()
   {
       return size == 0;
   }

   public Square peek()
   {
       if (size > 0)
       {
           return stack[size-1];
       }
       else
       {
           throw new EmptyStackException();
       }
   }

   public Square pop()
   {
       if (size > 0)
       {
           Square temp = stack[size - 1];
           stack[size - 1] = null;
           size --;
           return temp;
       }
       else
       {
           throw new EmptyStackException();
       }
   }

   public void push(Object item)
   {
       if (size == stack.length)
       {
           doubleCapacity();
       }
       stack[size] = (Square)item;
       size++;
   }
   private void doubleCapacity()
   {
       Square[] temp = new Square[size * 2];
       for (int i = 0; i < size; i++)
       {
           temp[i] = stack[i];
       }
       stack = temp;
   }
   public String toString()
   {
       String ret = "";
       for (int i = size -1; i >= 0; i--)
       {
           ret += "" + stack[i] + "\n";
       }
       return ret;
   }

   public int size()
   {
       return size;
   }

   public void clear()
   {
       while (size < 0)
       {
           stack[size - 1] = null;
           size --;
       }
   }
}
