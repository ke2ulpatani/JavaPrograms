
import java.io.*;
import java.util.*;
import java.awt.*;

public class TicTacToe_One
{
	static int board[][] = new int[3][3];
	static HashMap<Integer,Point> freelist = new HashMap<Integer,Point>();

	static boolean checkMate()
	{
		printBoard();
		int total;
		for (int i=0;i<3;i++)
		{
			total =0;
			for (int j=0;j<3;j++)
			{
				total = total + board[i][j];
			}
			if (total == 3)
			{
				System.out.println("User Won");
				return true;
			}
			if (total == 0)
			{
				System.out.println("Computer Won");
				return true;
			}

		}
		
		for(int i=0;i<3;i++)
		{
			total =0;
			for (int j=0;j<3;j++)
			{
				total = total + board[j][i];
			}
			if (total==3)
			{
				System.out.println("User Won");
				return true;
			}
			if (total == 0)
			{
				System.out.println("Computer Won");
				return true;
			}
		}

		total=3;
		for(int i=0;i<3;i++)
		{
			total = total+board[i][i];
		}
		if (total == 3)
		{
			System.out.println("User Won");
			return true;
		}
		if (total == 0)
		{
			System.out.println("Computer Win");
			return true;
		}

		return false;
	}
	


	static int getComputerMove()
	{
		ArrayList<Integer> l = new ArrayList<Integer>(freelist.keySet());
		int R = take.nextInt(l.size());
		return l.get(R);
	}

	static void printBoard()
	{
		for(int i=0;i<3;i++)
		{
			for (int j=0;j<3;j++)
			{
				System.out.print(board[i][j]+"\t");
			}

			System.out.println();
		}
	}

	static Random take = new Random();

	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		int count=1;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				board[i][j] = 4;
				Point p = new Point(i,j);
				freelist.put(count,p);
				count++;
			}
		}

		printBoard();

		System.out.println("***************************");

		System.out.println("User:\t 1\nComputer:\t0\n");
		System.out.println("User Turn First\n");
		int user;
		int com;
		while (freelist.size()>0)
		{
			System.out.print("User(Enter the box number):\t");
			
			user = sc.nextInt();
			Point p = freelist.get(user);
			int x= p.x;
			int y = p.y;
			board[x][y] = 1;
			freelist.remove(user);
			if(checkMate())
			{
				System.exit(0);
			}
			
			com=getComputerMove();
			System.out.print("Computer turn:\t"+com);
			System.out.println();
			p = freelist.get(com);
			x = (int)p.x;
			y = (int)p.y;
			board[x][y] = 0;
			freelist.remove(com);
			if(checkMate())
			{
				System.exit(0);
			}
			
		}
		System.out.println("The game is drawn");
	}
}