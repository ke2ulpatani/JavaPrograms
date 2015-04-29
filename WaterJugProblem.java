import java.io.*;
import java.util.*;



class tuple
{
	  int x;
	  int y;
	  tuple(int x, int y)
	  {
	    this.x = x;
	    this.y = y;
	  }

}


public class WaterJugProblem {


    static ArrayList<tuple> open = new ArrayList<tuple>();
    static tuple last = new tuple(0,0);

    static boolean checkOpen(tuple test)
    {
        for (tuple t:open)
        {
            if (t.x == test.x && t.y == test.y)
            {
                return true;
            }
        }

        return false;
    }

    static tuple findChild(tuple test)
    {
        int x = test.x;
        int y = test.y;


        if ( (x == 0 && y==0) || ( x == 0 && y < 3) )
        {
            x = 4;
            tuple output = new tuple(x,y);
            if (checkOpen(output) == false)
            {
                return output;
            }
        }

        if ( (x > 0 && y < 3) || (x > 0 && y == 0) )
        {
            if ( x+y >= 3)
            {
                x = x-(3-y);
                y = 3;
            }
            if (x+y < 3)
            {
                y = x+y;
                x =0;
            }

            tuple output = new tuple(x,y);
            if (checkOpen(output) == false)
            {
                return output;
            }
        }


        if ( (x ==0 && y>0) || (x <4 && y >0) )
        {
            y=0;
            tuple output = new tuple(x,y);
            if (checkOpen(output) == false)
            {
                return output;
            }

        }

        tuple error = new tuple(0,0);
        if (checkOpen(error) == false)
        {
            return error;
        }

        return error;
    }


    public static void main(String[] args)
    {
		 tuple current = new tuple(0,0);

         System.out.println("Enter the final state:\t");
         Scanner sc = new Scanner(System.in);
         last.x = sc.nextInt();
         last.y = sc.nextInt();

         System.out.println("Current:  "+current.x + "" + current.y);
         System.out.println("Last:  "+last.x + "" + last.y);
         open.add(current);
         System.out.println("("+current.x+","+current.y+")");
         while (current.x != last.x || current.y != last.y)
         {

            current = findChild(current); //find the child and add to open
            open.add(current);
            System.out.println("("+current.x+","+current.y+")");
        }

        System.out.println("Final State Reached");

    }

}
