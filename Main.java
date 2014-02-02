import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("What is your name?:");
		String name = scanner.nextLine();
		Player p1 = new Player(name);
		
		String  diff = getDifficulty();
		if (diff == "1"){
			p1.newGame(Difficulty.NORMAL);
		}
		if (diff == "2"){
			p1.newGame(Difficulty.HARD);
		}
		

	}

	public String getDifficulty(){
		System.out.println("Select a Difficulty:");
		System.out.println("1. Normal (6 Colors, 4-Peg Code)");
		System.out.println("2. Challenge (7 Colors, 5-Peg Code)");
		String diff = scanner.nextLine();
		while (diff != "1" && diff != "2"){
			System.out.println("Enter 1 or 2.");
			String diff = getDifficulty();
		}
		return diff;
	}

}
