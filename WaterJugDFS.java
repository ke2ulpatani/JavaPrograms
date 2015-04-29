//add one more list where put every thing after deleting and after becoming 

import java.io.*;
import java.util.*;

class tuple
{
	int x;
	int y;
	tuple(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
}

class WaterJugDFS
{
	static ArrayList<tuple> close = new ArrayList<tuple>();
	static ArrayList<tuple> open = new ArrayList<tuple>();

	static tuple current = new tuple(0,0);
	static tuple last = new tuple(0,0);

	static boolean checkinClose(tuple test)
	{
			

			for (tuple t:close)
			{
				if (t.x == test.x && t.y == test.y)
				{
					return false;
				}
			}

			return true;
	}	

	static void checkInput()
	{
		if (last.x == 2 && last.y == 1)
		{
			System.out.println("Sorry! State Unreachable");
			System.exit(0);
		}
	}


	static void findChild()
	{
		if (!close.isEmpty())
		{
			tuple t = close.get(close.size()-1);

			int x = t.x;
			int y = t.y;

			if ((x == 0 && y==0) || ( x == 0 && y <= 3)) // out to x
			{
				x=4;
				tuple out = new tuple(x,y);
				if (checkinClose(out))
				{
					open.add(out);
				}
			}

			x = t.x;
			y = t.y;

			if ((y == 0 && x==0) || ( y == 0 && x <= 4)) // out to y
			{
				y=3;
				tuple out = new tuple(x,y);
				if (checkinClose(out))
				{
					open.add(out);
				}
			}


			x = t.x;
			y = t.y;

			if ((x > 0 && y < 3) || (x > 0 && y == 0))  // from x to y
			{
				if ((x+y)<3)
				{
					y=y+x;
					x=0;
					tuple out = new tuple(x,y);
					if (checkinClose(out))
					{
						open.add(out);
					}
				}
				else
				{
					x=x-(3-y);
					y=3;
					tuple out = new tuple(x,y);
					if (checkinClose(out))
					{
						open.add(out);
					}	
				}
			}


			x = t.x;
			y = t.y;

			if ((y > 0 && x < 4) || (y > 0 && x == 0))  // from x to y
			{
				if ((x+y)<4)
				{
					x=y+x;
					y=0;
					tuple out = new tuple(x,y);
					if (checkinClose(out))
					{
						open.add(out);
					}
				}
				else
				{
					y=y-(4-x);
					x=4;
					tuple out = new tuple(x,y);
					if (checkinClose(out))
					{
						open.add(out);
					}	
				}
			}

			x = t.x;
			y = t.y;

			if ((x ==0 && y>0) || (x <4 && y >0)) // y to out
			{
				y=0;
				tuple out = new tuple(x,y);
				if (checkinClose(out))
				{
					open.add(out);
				}
			}

			x = t.x;
			y = t.y;

			if ((y ==0 && x>0) || (y <=3 && x >0)) // x to out
			{
				x=0;
				tuple out = new tuple(x,y);
				if (checkinClose(out))
				{
					open.add(out);
				}
			}
		}

		
	}
	

	static boolean checkOpen()
	{
		for (tuple t:open)
		{
			if (t.x == last.x && t.y == last.y)
			{
				return true;
			}
		}
			return false;
	}	

	static void putFromOpenToClose()
	{
		for(tuple t:open)
		{
			close.add(t);
			
		}
		open.clear();
		
	}

	static void removeChild()
	{
		if (!close.isEmpty())
			{
				close.remove(close.size()-1);
			}
	}
	
	static void printOpen()
	{
		if (!close.isEmpty())
		{
			tuple k = close.get(close.size()-1);
			System.out.print("Current Open(Child of"+"("+k.x+","+k.y+")"+"):");
			for(tuple t:open)
			{
				System.out.print("("+t.x+","+t.y+")");
			}
			System.out.println();
		}
	}

	static void printClose()
	{
		System.out.print("Close:");
		for(tuple t:close)
		{
			System.out.print("("+t.x+","+t.y+")");
		}
		
		
	}


	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the last stage:\t");
		last.x = sc.nextInt();
		last.y = sc.nextInt();



		close.add(current);
		

		while (true)
		{
			
			printClose();
			System.out.println();
			findChild(); //find the  child in close list first position and put it in open list
			if(checkOpen()) //check for last stage in open list
			{
				printOpen();
				System.out.println("Final State Reached");
				break;
			}
			else
			{
				printOpen();
				putFromOpenToClose();
				checkInput();
				removeChild();
			}
			
		}
	}

}
