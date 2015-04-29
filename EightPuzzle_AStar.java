import java.io.*;
import java.util.*;

class EightPuzzle_AStar
{
	static ArrayList<String> open = new ArrayList<String>();
	static ArrayList<String> close = new ArrayList<String>();

	static int hfunc(String str)
	{
		
		String s = "123804765";
		int total =0;
		for (int i=0;i<str.length();i++)
		{
			if (str.charAt(i)==s.charAt(i))
			{
				total += 1;
			}
		}
		return total;
	}
	
	static boolean checkopenList(String test)
	{
		for (String str:open)
		{
			if (str.equals(test))
			{
				return false;
			}
		}
		return true;
	}


	static boolean checkcloseList(String test)
	{
		for (String str:close)
		{
			if (str.equals(test))
			{
				return false;
			}
		}
		return true;
	}

	static String swap(String str, int i1, int i2)
	{
		StringBuilder sb = new StringBuilder(str);
        char l = sb.charAt(i1), r = sb.charAt(i2);
        sb.setCharAt(i2, l);
        sb.setCharAt(i1, r);
        return sb.toString();
	}
	static void moveUp(String str, int index)
	{
		String s = str;
		if (index-3 >= 0)
		{
			s = swap(s,index,index-3);
			 
		}
		else
		{
			s= null;
		}

		if (s != null)
		{
			if (isFinal(s))
			{
				getInFormat(s);
				System.out.println("Final State Reached");
				System.exit(0);
			}
			else
			{
				if (checkcloseList(s)&&checkopenList(s))
				{
					System.out.println("Moved up");
					getInFormat(s);
					open.add(s);
				}
				
			}
		}
	}

	static void moveDown(String str, int index)
	{
		String s = str;
		if (index+3 < 9)
		{
			s = swap(s,index,index+3);
			 
		}
		else
		{
			s = null;
		}

		if (s != null)
		{
			if (isFinal(s))
			{
				getInFormat(s);
				System.out.println("Final State Reached");
				System.exit(0);
			}
			else
			{
				if (checkcloseList(s)&&checkopenList(s))
				{
					System.out.println("Moved down");
					getInFormat(s);
					open.add(s);
				}
				
			}
		}

	}

	static void moveLeft(String str, int index)
	{
		String s = str;
		if (index-1 >= 0)
		{
			
			if (index%3!=0)
			{
				s = swap(s,index,index-1);
				 
			}
			
		}
		else
		{
			s= null;
		}

		if (s != null)
		{
			if (isFinal(s))
			{
				getInFormat(s);
				System.out.println("Final State Reached");
				System.exit(0);
			}
			else
			{

				if (checkcloseList(s)&&checkopenList(s))
				{
					System.out.println("Moved left");
					getInFormat(s);
					open.add(s);
				}
			}
		}
	}

	static void moveRight(String str, int index)
	{
		String s = str;
		if (index+1 < 9)
		{
			
			if ((index+1)%3!=0)
			{
				s = swap(s,index,index+1);
				 
			}
		}
		else
		{
			s= null;
		}

		if (s != null)
		{
			if (isFinal(s))
			{
				getInFormat(s);
				System.out.println("Final State Reached");
				System.exit(0);
			}
			else
			{

				if (checkcloseList(s)&&checkopenList(s))
				{
					System.out.println("Moved right");
					getInFormat(s);
					open.add(s);
				}
			}
		}
	}

	static boolean isFinal(String test)
	{
		if (test.equals("123804765"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	static void findChild()
	{
		String s = open.get(0);
		
		int index = s.indexOf("0");
		
		moveUp(s,index);
		moveDown(s,index);
		moveLeft(s,index);
		moveRight(s,index);
		
	}

	static void putFromOpenToClose()
	{
		close.add(open.get(0));
		getInFormat(open.get(0));
		open.remove(0);
	}

	static void getInFormat(String str)
	{
		int count = 1;
		System.out.println("Current:\n");
		for(int i =0;i<str.length();i++)
		{
			char c = str.charAt(i);
			System.out.print(c+"\t");
			if(count == 3)
			{
				System.out.println();
				count = 1;
			}
			else
			{
				count++;	
			}
			
		}
	}



	public static void main(String[] args) throws Exception
	{
		System.out.println("Enter the String :\t");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		open.add(str);

		while (true)
		{
			if (isFinal(open.get(0)))
			{
				System.out.println("Final State Reached");
				getInFormat(open.get(0));
			}
			else
			{
				findChild(); //find the child of first element of open list and put it in open list || first element is placed in closed list
				putFromOpenToClose();
			}
		}
	}
}