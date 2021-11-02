import java.util.Scanner;
public class Battleship {
	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in);
		char[][] ocean = initBoard();
		printBoat(ocean); //Prints coordinates

		System.out.println("__        __   ___            ____   ____                ___   ");
		System.out.println("\\ \\  /\\  / /  |      |       |      |    |   |\\    /|   |      |");
		System.out.println(" \\ \\/  \\/ /   |--    |       |      |    |   | \\  / |   |--    |");
		System.out.println("  \\______/    |___   |____   |____  |____|   |  \\/  |   |___   .");

		System.out.println("\n\nThis is Battleship. A miss will be marked with an X,");
		System.out.println("a hit ship is marked with an h, and an unsunk ship is marked with a b. Good luck!\n");

		System.out.println("You have 7 tries to guess the ship's location.");
		printBoard(ocean);
		System.out.println();

		int hit = 0;
		int tries = 7;

		while(hit < 2) {
			System.out.print("Enter a row (Starts from 0): ");
			int row = reader.nextInt();
			System.out.print("Enter a column (Starts from 0): ");
			int column = reader.nextInt();
			System.out.println();

			if((row<0) || (row > 6) || (column < 0) || (column > 6)) {
				System.out.println("That coordinate does not exist. Please try again and enter a valid input.");
			}

			else if((ocean[row][column] == 'X') || (ocean[row][column] == 'h')) {
				System.out.println("You have already guesssed there. Please try again.");
			}

			else {
				tries--;

				if(ocean[row][column] == 'b') {
					hit++;
					if(hit < 2) {
						System.out.println("Tries left: " + tries);
						ocean[row][column] = 'h';
					}

					else {
						ocean[row][column] = 'h';
						System.out.println("__        __         ");
						System.out.println("\\ \\  /\\  / /    |   |\\  |   |");
						System.out.println(" \\ \\/  \\/ /     |   | \\ |   |");
						System.out.println("  \\______/      |   |  \\|   .\n");
					}

					printBoard(ocean);
				}

				else {
					ocean[row][column] = 'X';

					if(tries > 0) {
						System.out.println("Tries left: " + tries);
						printBoard(ocean);
					}

					else {
						System.out.println("\nYou lose! Here is where the ship was: ");
						printEndBoard(ocean);
						hit = 2;
					}
				}
			}

			System.out.println();
		}
	}

	public static char[][] initBoard() {
		char[][] board = new char[7][7];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++)
				board[i][j] = '~';
		}

		int random_row = (int)(Math.random()*6);
		int random_column = (int)(Math.random()*6);
		board[random_row][random_column] = 'b';

		if(random_row == 0 && random_column == 0) {
			int rand = (int)(Math.random()*2);
			if(rand == 0)
				board[random_row][random_column+1] = 'b';
			else
				board[random_row+1][random_column] = 'b';
		}

		else if(random_row == 6 && random_column == 0) {
			int rand = (int)(Math.random()*2);
			if(rand == 0)
				board[random_row][random_column+1] = 'b';
			else
				board[random_row-1][random_column] = 'b';
		}

		else if(random_column == 0) {
			int rand = (int)(Math.random()*3);
			if(rand == 0)
				board[random_row-1][random_column] = 'b';
			else if(rand == 1)
				board[random_row][random_column+1] = 'b';
			else
				board[random_row+1][random_column] = 'b';
		}

		else if(random_row == 0 && random_column == 6) {
			int rand = (int)(Math.random()*2);
			if(rand == 0)
				board[random_row][random_column-1] = 'b';
			else
				board[random_row+1][random_column] = 'b';
		}

		else if(random_row == 6 && random_column == 6) {
			int rand = (int)(Math.random()*2);
			if(rand == 0)
				board[random_row][random_column-1] = 'b';
			else
				board[random_row-1][random_column] = 'b';
		}

		else if(random_column == 6) {
			int rand = (int)(Math.random()*3);
			if(rand == 0)
				board[random_row-1][random_column] = 'b';
			else if(rand == 1)
				board[random_row][random_column-1] = 'b';
			else
				board[random_row+1][random_column] = 'b';
		}

		else if(random_row == 0) {
			int rand = (int)(Math.random()*3);
			if(rand == 0)
				board[random_row][random_column-1] = 'b';
			else if(rand == 1)
				board[random_row+1][random_column] = 'b';
			else
				board[random_row][random_column+1] = 'b';
		}

		else if(random_row == 6) {
			int rand = (int)(Math.random()*3);
			if(rand == 0)
				board[random_row][random_column-1] = 'b';
			else if(rand == 1)
				board[random_row-1][random_column] = 'b';
			else
				board[random_row][random_column+1] = 'b';
		}

		else {
			int rand = (int)(Math.random()*4);
			if(rand == 0)
				board[random_row][random_column-1] = 'b';
			else if(rand == 1)
				board[random_row-1][random_column] = 'b';
			else if(rand == 2)
				board[random_row+1][random_column] = 'b';
			else
				board[random_row][random_column+1] = 'b';
		}

		return board;
	}

	public static void printBoard(char[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 'b')
					System.out.print("~ ");
				else
					System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printEndBoard(char[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
					System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printBoat(char[][] board) {
		System.out.print("Ship Coordinates: ");
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 'b') {
					System.out.print("(" + i + "," + j + ") ");
				}
			}
		}
		System.out.println();
	}
}