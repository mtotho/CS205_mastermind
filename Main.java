import java.util.*;
import java.io.*;
import java.text.*;
 
public class Main{

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);

		String gameOutput="";

		gameOutput+="/*###################################*/\n";
		gameOutput+="/*                                   */\n";
		gameOutput+="/*     Welcome to Mastermind Game    */\n";
		gameOutput+="/*                                   */\n";
		gameOutput+="/*###################################*/\n";
		gameOutput+="/*";
		System.out.println(gameOutput);

		System.out.println("/* What is your name?:");
		String name = scanner.nextLine();
		Player p1 = new Player(name);
		
		boolean playAgain=true;
		while(playAgain){

			int game_result =0;

			String  diff = getDifficulty();
			if (diff.equals("1")){
				game_result=p1.newGame(Difficulty.NORMAL);
			}
			if (diff.equals("2")){
				game_result=p1.newGame(Difficulty.HARD);
			}


			String resultOutput="";
			resultOutput += "/*\n";
			resultOutput += "/*######################*/\n";
		    resultOutput += "/*                      */\n";
			//Display win or loss output
			if (game_result!=-1) {	
				resultOutput += "/*       You Win!!      */\n";
			}else{
				resultOutput += "/*       You Lose :(    */\n";
			}
			DecimalFormat df = new DecimalFormat("#.##");

			resultOutput += "/*                      */\n";
			resultOutput += "/*######################*/\n";
			resultOutput += "/* Player statistics:   */\n";
			resultOutput += "/* > Name  : "+name+"\n";
			resultOutput += "/* > Wins  : "+p1.getWins()+"\n";
			resultOutput += "/* > Losses: "+p1.getLosses() + "\n";
			resultOutput += "/* \n";
			resultOutput += "/* > Average Turns to win: "+df.format(p1.getAverageTurns()) + "\n";

			System.out.println(resultOutput);
			System.out.println("/*\n/*Would you like to play again? (y/n)");
			String option = scanner.nextLine();

			if(option.equalsIgnoreCase("n")){
				playAgain=false;
			}
		}
		

	}

	public static String getDifficulty(){
		Scanner scanner = new Scanner(System.in);

		System.out.println("/*\n/* Select a Difficulty:");
		System.out.println("/* 1. Normal (6 Colors, 4-Peg Code)");
		System.out.println("/* 2. Hard (7 Colors, 5-Peg Code)");
		String diff = scanner.nextLine();
		while (!diff.equals("1")  && !diff.equals("2")){
			System.out.println("Enter 1 or 2.");
			diff = getDifficulty();
		}
		return diff;
	}

}
