//Mickey P.
//Object Oriented Programming in Java I - Fall 2015
//Assignment #3

import java.util.Scanner;

public class TicTacToe {
	
	//the following method checks if there is a win.
	//if there is a winner, 'X' or 'O' will be returned
	//if the board is full, but there is no winner, 'F' will be returned
	//if the game is not complete, 'I' will be returned
	public static char Winner (char[][] gameboard) {
		//checks for horizontal wins
		if ((gameboard[0][0] == gameboard[0][1]) && (gameboard[0][1] == gameboard[0][2]))
			return gameboard[0][0];
		else if ((gameboard[1][0] == gameboard[1][1]) && (gameboard[1][1] == gameboard[1][2]))
			return gameboard[1][0];
		else if ((gameboard[2][0] == gameboard[2][1]) && (gameboard[2][1] == gameboard[2][2]))
			return gameboard[2][0];

		//checks for vertical wins
		if ((gameboard[0][0] == gameboard[1][0]) && (gameboard[1][0] == gameboard[2][0]))
			return gameboard[0][0];
		else if ((gameboard[0][1] == gameboard[1][1]) && (gameboard[1][1] == gameboard[2][1]))
			return gameboard[0][1];
		else if ((gameboard[0][2] == gameboard[1][2]) && (gameboard[1][2] == gameboard[2][2]))
			return gameboard[0][2];
		
		//checks for diagonal wins
		if ((gameboard[0][0] == gameboard[1][1]) && (gameboard[1][1] == gameboard[2][2]))	
			return gameboard[0][0];
		else if ((gameboard[0][2] == gameboard[1][1]) && (gameboard[1][1] == gameboard[2][0]))	
			return gameboard[0][2];
		
		//checks if the gameboard is full
		int count = 0;
		for (int index=0 ; index < 3 ; index++) {
			int indextwo;
			for(indextwo = 0 ; indextwo < 3 ; indextwo++) {
				if ((gameboard[index][indextwo] == 'X') || (gameboard[index][indextwo] == 'O'))
					count++;
			}
		}//end of for-loop
		
		if (count == 9)
			return 'F'; //if the gameboard is full
		else
			return 'I'; //if the game is incomplete
		
	}
	//end of Winner method
	

	

	public static void main(String[] args) {
		
		//Create Scanner
		Scanner Keys = new Scanner(System.in);

		//Player tile
		char Tile; //will be either 'O' or 'X' depending on the boolean isX -- defined below
		
		//boolean that will determine whose turn it is
		boolean isX = true;
		
		//number of games played + number of times each player has won
		int GamesPlayed = 0;
		int XWins = 0;
		int OWins = 0;
		
		//creating the tic tic toe board
		char[][] board = new char[3][3];
		
		//creating exit condition for the overall do-while loop
		String LowerAns;
		boolean exit = false;
		
		
		//START OF GAME!
		//Will repeat ONCE PER GAME
		do{
		
			//assigning number 1-9 to the places on the board
			int unicode = 49; //49 is the unicode value for '1'
			while (unicode < 58) {
				for (int firstindex = 0 ; firstindex < 3 ; firstindex++) {
					for (int secondindex = 0 ; secondindex < 3 ; secondindex++) {
						board[firstindex][secondindex] = (char)(unicode);
						unicode += 1;
					}
				}
			}
			
			GamesPlayed += 1;
			
			//will determine if the game is complete of not
			boolean won = false;
			
			
			//Will repeat for EVERY TURN
			do {
				
				//printing board
				for (int firstindex = 0 ; firstindex < 3 ; firstindex++){
					for(int secondindex = 0 ; secondindex < 3 ; secondindex++) {
						System.out.print(board[firstindex][secondindex] + " ");
					}
					System.out.println();
				}
				
				//checking whose turn it is and accessing the correct Tile
				if (isX)
					Tile = 'X';
				else
					Tile = 'O';
				
				//exit condition for the following do-while loop
				boolean valid = false;
				
				//will be the position inputed by the user
				int position;
				
		
				do {
					System.out.println("Player " + Tile + " - Enter the position you want to mark:");
					position = Keys.nextInt();
					System.out.println();
					
					//checks if position number is okay
					if ((position < 1) || (position > 9)) {
						System.out.println("Your number is out of bounds! Please enter a number between 1 and 9 inclusively.");
						continue;
					} else { //checks if the position space is already occupied
						switch(position) {
						case 1 : if ((board[0][0] == 'X') || (board[0][0] == 'O')) {
									System.out.println("Oops! Position 1 is already taken! Please choose another one.");
									continue;
								 } else {
									break;
								 }
						case 2 : if ((board[0][1] == 'X') || (board[0][1] == 'O')) {
									System.out.println("Oops! Position 2 is already taken! Please choose another one.");
									continue;
						 		} else {
						 			break;
						 		}
						case 3 : if ((board[0][2] == 'X') || (board[0][2] == 'O')) {
									System.out.println("Oops! Position 3 is already taken! Please choose another one.");
									continue;
				 				} else {
				 					break;
				 				}
						case 4 : if ((board[1][0] == 'X') || (board[1][0] == 'O')) {
									System.out.println("Oops! Position 4 is already taken! Please choose another one.");
									continue;
				 				} else {
				 					break;
				 				}
						case 5 : if ((board[1][1] == 'X') || (board[1][1] == 'O')) {
									System.out.println("Oops! Position 5 is already taken! Please choose another one.");
									continue;
								} else {
									break;
				 				}
						case 6 : if ((board[1][2] == 'X') || (board[1][2] == 'O')) {
									System.out.println("Oops! Position 6 is already taken! Please choose another one.");
									continue;
				 				} else {
				 					break;
				 				}
						case 7 : if ((board[2][0] == 'X') || (board[2][0] == 'O')) {
									System.out.println("Oops! Position 7 is already taken! Please choose another one.");
									continue;
				 				} else {
				 					break;
				 				}
						case 8 : if ((board[2][1] == 'X') || (board[2][1] == 'O')) {
									System.out.println("Oops! Position 8 is already taken! Please choose another one.");
									continue;
								} else {
									break;
								}
						case 9 : if ((board[2][2] == 'X') || (board[2][2] == 'O')) {
									System.out.println("Oops! Position 9 is already taken! Please choose another one.");
									continue;
								} else {
									break;
								}					 
								 
						}//end of switch
					}//end of else
					
					valid = !valid;
					
				} while(!valid);
				//end of loop for the input
				
				//assigns 'X' or 'O' to the correct position depending on the turn.
				switch (position) {
				case 1 : board[0][0] = Tile;
						 break;
				case 2 : board[0][1] = Tile;
						 break;
				case 3 : board[0][2] = Tile;
						 break;
				case 4 : board[1][0] = Tile;
						 break;
				case 5 : board[1][1] = Tile;
						 break;
				case 6 : board[1][2] = Tile;
						 break;
				case 7 : board[2][0] = Tile;
						 break;
				case 8 : board[2][1] = Tile;
						 break;
				case 9 : board[2][2] = Tile;
						 break;
				default: break;	
			}
				
				//switches turns between 'X' and 'O'
				isX = !isX;
				
				//checks if the game is won
				if ((Winner(board) == 'X') || (Winner(board) == 'O') || (Winner(board) == 'F'))
					won = true;
			
			} while(!won);
			
			//printing board
			System.out.println();
			for (int firstindex = 0 ; firstindex < 3 ; firstindex++){
				for(int secondindex = 0 ; secondindex < 3 ; secondindex++) {
					System.out.print(board[firstindex][secondindex] + " ");
				}
				System.out.println();
			}
			
			if (Winner(board) == 'X') {
				XWins += 1;
				System.out.println("Player X is the winner :)");
			} else if (Winner(board) == 'O') {
				OWins += 1;
				System.out.println("Player O is the winner :)");
			} else //(if Winner(board) == 'F') is the only option left, so it doesn't need to be stated.
				System.out.println("The board is full! No one won this round :(");
			
			System.out.println("Games played to date: " + GamesPlayed);
			System.out.println("Player X has won " + XWins + " game(s) and Player O has won " + OWins + " game(s).");
			
			//the following do-while does a full loop before asking for input!
			boolean complete = false;
			do {
				System.out.println();
				System.out.println("Would you like to play another game? (yes/no)");
				String input = Keys.nextLine();
				LowerAns = input.toLowerCase();
			
				if (LowerAns.equals("yes")) {
					complete = !complete;
				} else if (LowerAns.equals("no")) {
					exit = !exit;
					complete = !complete;
				} else
					continue;
				
			} while(!complete);
			//end of asking for input again.
			
		} while(!exit);
		//end of game!

		
		Keys.close();
		
		//calculating percentage of wins
		int Xpercent = (int)Math.round((((double)XWins)/GamesPlayed)*100);
		int Opercent = (int)Math.round((((double)OWins)/GamesPlayed)*100);
		
		//printing final statements
		System.out.println();
		System.out.println("Total number of games played = " + GamesPlayed);
		System.out.println("Player X has won " + XWins + " (" + Xpercent + "%) games and Player O has won " + OWins + " (" + Opercent + "%) games");
		
		if (XWins > OWins)
			System.out.println("The grand champion is Player X!");
		else if (OWins > XWins)
			System.out.println("The grand champion is Player O!");
		else if (OWins == XWins)
			System.out.println("There is no grand champion. It was a tie!");
		
		System.exit(0);
		
	}

}
