import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("What is your name?:");
		String name = scanner.nextLine();
		Player p1 = new Player(name);
		
		boolean playAgain=true;
		while(playAgain){


			String  diff = getDifficulty();
			if (diff.equals("1")){
				p1.newGame(Difficulty.NORMAL);
			}
			if (diff.equals("2")){
				p1.newGame(Difficulty.HARD);
			}

			System.out.println("Would you like to play again? (y/n)");
			String option = scanner.nextLine();

			if(option.equalsIgnoreCase("n")){
				playAgain=false;
			}
		}
		

	}

	public static String getDifficulty(){
		Scanner scanner = new Scanner(System.in);

		System.out.println("Select a Difficulty:");
		System.out.println("1. Normal (6 Colors, 4-Peg Code)");
		System.out.println("2. Challenge (7 Colors, 5-Peg Code)");
		String diff = scanner.nextLine();
		while (!diff.equals("1")  && !diff.equals("2")){
			System.out.println("Enter 1 or 2.");
			diff = getDifficulty();
		}
		return diff;
	}

}
