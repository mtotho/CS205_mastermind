/* Main.java - Michael Toth
*/

import java.util.*;
import java.io.*;
import java.text.*;
 
public class Main{

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);

		// Display welcome output
		String gameOutput="";
		gameOutput+="/*###################################*/\n";
		gameOutput+="/*                                   */\n";
		gameOutput+="/*     Welcome to Mastermind Game    */\n";
		gameOutput+="/*                                   */\n";
		gameOutput+="/*###################################*/\n";
		gameOutput+="/*";
		System.out.println(gameOutput);

		// User input for Player name
		System.out.println("/* What is your name?:");
		String name = scanner.nextLine();
		Player p1 = new Player(name);
		
		// playAgain 'while' loop - game continues until playAgain is false
		boolean playAgain=true;
		while(playAgain){

			int game_result =0;

			// get player's desired difficulty level and start a new game
			String  diff = getDifficulty();

			// Difficulty: Easy
			if (diff.equals("1")){
				game_result=p1.newGame(Difficulty.NORMAL);
			} // end if

			// Difficulty: Hard
			if (diff.equals("2")){
				game_result=p1.newGame(Difficulty.HARD);
			} // end if


			// Display result output after gameplay ends
			// - includes win/loss and statistics
			String resultOutput="";
			resultOutput += "/*\n";
			resultOutput += "/*######################*/\n";
		    resultOutput += "/*                      */\n";

			//Display win or loss output
			if (game_result!=-1) {	
				resultOutput += "/*       You Win!!      */\n";
			}else{
				resultOutput += "/*       You Lose :(    */\n";
			} // end if..else

			DecimalFormat df = new DecimalFormat("#.##");

			// Display player statistics output
			resultOutput += "/*                      */\n";
			resultOutput += "/*######################*/\n";
			resultOutput += "/* Player statistics:   */\n";
			resultOutput += "/* > Name  : "+name+"\n";
			resultOutput += "/* > Wins  : "+p1.getWins()+"\n";
			resultOutput += "/* > Losses: "+p1.getLosses() + "\n";
			resultOutput += "/* \n";
			resultOutput += "/* > Average Turns to win: "+df.format(p1.getAverageTurns()) + "\n";

			System.out.println(resultOutput);

			// Determine if user wants to continue play
			System.out.println("/*\n/*Would you like to play again? (y/n)");
			String option = scanner.nextLine();

			// if user indicates no, playAgain is false and loop ends, otherwise gameplay continues
			if(option.equalsIgnoreCase("n")){
				playAgain=false;
			} // end if

		}// end while
		

	} // end main()

// getDifficulty() - gets User input for difficulty and returns String diff
	public static String getDifficulty(){
		Scanner scanner = new Scanner(System.in);

		// establish difficulty lvls and ask user for selection
		System.out.println("/*\n/* Select a Difficulty:");
		System.out.println("/* 1. Normal (6 Colors, 4-Peg Code)");
		System.out.println("/* 2. Hard (7 Colors, 5-Peg Code)");
		String diff = scanner.nextLine();
		while (!diff.equals("1")  && !diff.equals("2")){
			System.out.println("Enter 1 or 2.");
			diff = getDifficulty();
		}
		return diff;
	} // end getDifficulty()

}
