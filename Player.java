import java.util.*;

public class Player{

	String name;
	Mastermind currGame;
	Scanner scanner = new Scanner(System.in);

	public Player(String name){
		this.name = name;
		System.out.println("player created");
	}

	public void newGame(){
		System.out.println("Select a Difficulty Level:");
		System.out.println("1. Normal (6 colors and 4-peg codes)");
		System.out.println("2. Challenge (7 colors and 5-peg codes)");
		int level = scanner.nextInt();
		currGame = new Mastermind(level);
		System.out.println("Game created.");
	}
}