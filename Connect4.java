/*
Chase Balmer
2/10/2022
This is my own work, cjb
Project Grid Game
This program runs a two player connect 4 game
*/
import java.util.Scanner;
public class Connect4
{
	public static void main(String[]args)
	{
		//Variables
		int[][] board = new int[6][7];	//vert and then horiz
		Scanner reader = new Scanner(System.in);

		//Initiialize board to all 0 values
		for(int i=0; i<6; i++)
		{
			for(int x=0; x<7; x++)
			{
				board[i][x] = 0;
			}
		}


		//Speak to players
		System.out.println("Welcome to Connect 4. This is a two player game. You will alternate dropping chips on the board until you reach 4 in a row.");
		System.out.println("You can win horizontally, vertically, or diagonally. A zero on the board represents an unused space, a 1 represents a player");
		System.out.println("1 chip, and 2 represents a player 2 chip.");
		System.out.println("\n\nBegin the game:");

		printBoard(board);

		while(boardOpen(board))
		{
			//User 1 goes
			dropChip(board, 1, reader);
			isWin(board, 1);
			printBoard(board);

			//User 2 goes
			dropChip(board, 2, reader);
			isWin(board, 2);
			printBoard(board);
		}
		System.out.println("Game is over. No winner");

	}//End main
//Methods
static void dropChip(int[][]board, int user, Scanner reader)
{
	//Method will handle chip dropping, user parameter will represent the type of chip
	//Loop runs until chip has been sucessfully dropped
	boolean running = true;
	while(boardOpen(board))
	{
		//Obtain column to drop chip
		System.out.println("Player " + user + " please enter which column in which you would like to drop your chip (1-7)");
		int column = reader.nextInt();

		while(column < 1 || column > 7)
		{
			System.out.println("Player " + user + " please enter which column in which you would like to drop your chip (1-7)");
			column = reader.nextInt();
		}
		column -= 1;

		//Drop chip
		for(int i=5; i>=0; i--)
		{
			if(board[i][column] == 0)
			{
				board[i][column] = user;
				running = false;	//Not really needed because of the following statement but it looks more readable
				return;				//Break from method if chip is palced

			}
		}

		//Redo Method if column is full
		System.out.println("Column was full");
	}//while loop

}//End drop chip

static boolean boardOpen(int[][]board)
{
	//Check if there is an open spot on the board
	for(int i=0; i<6; i++)
	{
		for(int x=0; x<7; x++)
		{
			if(board[i][x] == 0)
				return true;
		}
	}
	return false;
}

static void isWin(int[][]board, int user)
{
	//Check for a win with the given user passed to the method
	int streak = 0;

	//Horizontal
	for(int i=0; i<6; i++)
	{
		for(int x=0; x<7; x++)
		{
			if(board[i][x] == user)
			{
				//Add to streak if values align, return win if 4 in a row
				streak += 1;
				if(streak == 4)
				{
					printBoard(board);
					System.out.println("\n\nUser " + user + " wins!!");
					System.exit(0);
				}
			}
			else
			{
				streak = 0;
			}

		}
	}

	streak = 0;

	//Vertical
	for(int x=0; x<7; x++)
	{
		for(int i=0; i<6; i++)
		{
			if(board[i][x] == user)
			{
				//Add to streak if values align, return win if 4 in a row
				streak += 1;
				if(streak == 4)
				{
					printBoard(board);
					System.out.println("\n\nUser " + user + " wins!!");
					System.exit(0);
				}
			}
			else
			{
				streak = 0;
			}
		}
	}

	streak = 0;

	//Diagonal
		//right to left
		for(int i=5; i>2; i--)
		{
			for(int x=6; x>2; x--)
			{
				if(board[i][x] == user)	//From here we will go up diagonally and check for matches
				{
					streak+=1;
					if(board[i-1][x-1] == user)
					{
						streak += 1;
						if(board[i-2][x-2] == user)
						{
							streak+=1;
							if(board[i-3][x-3] == user)
							{
								streak+=1;
							}
						}
					}
					if(streak == 4)
					{
						printBoard(board);
						System.out.println("\n\nUser " + user + " wins!!");
						System.exit(0);
					}
					streak = 0;
				}
				else
				{
					streak = 0;
				}

			}
		}

		streak = 0;

		//vert (left to right)
		for(int i=5; i>2; i--)
		{
			for(int x=0; x<4; x++)
			{
				if(board[i][x] == user)	//From here we will go up diagonally and check for matches (other direction diagonally)
				{
					streak+=1;
					if(board[i-1][x+1] == user)
					{
						streak += 1;
						if(board[i-2][x+2] == user)
						{
							streak+=1;
							if(board[i-3][x+3] == user)
							{
								streak+=1;
							}
						}
					}
					if(streak == 4)
					{
						printBoard(board);
						System.out.println("\n\nUser " + user + " wins!!");
						System.exit(0);
					}
					streak = 0;
				}
				else
				{
					streak = 0;
				}

			}
		}

}//end gameRunning

static void printBoard(int[][] board)
{
	//Output array in board like manner
	for(int i=0; i<6; i++)
	{
		for(int x=0; x<7; x++)
		{
			System.out.print(board[i][x] + "\t");
		}
		System.out.println("\n");
	}

}//End print board


//Output
	/*
		We played together, you said I didnt need to put output
	*/
}//End program