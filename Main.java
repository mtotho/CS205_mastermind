import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("What is your name?:");
		String name = scanner.nextLine();
		Player p1 = new Player(name);
		p1.newGame();

		//Logic to switch easy hard

		//if hard
		//Mastermind game = new Mastermind(Mastermind.difficulty.HARD);
		//else
		Mastermind game = new Mastermind();

	}

}
