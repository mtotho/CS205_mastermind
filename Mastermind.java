import java.util.*;

enum Difficulty{
		NORMAL,HARD
}


public class Mastermind{

	private String colors = "RGBYPO";
	private int codeLength = 4;
	private Board gameBoard;
	private Row codeRow;
	private Difficulty difficulty;
	private boolean gameOver = false;
	private static BOARD_LENGTH = 10;
	private Scanner scanner = new Scanner(System.in);

	public Mastermind(Difficulty difficulty){
		this.difficulty=difficulty;
		System.out.println("Mastermind game created");

		//Do something with difficulty

		gameBoard = new Board(this.getCode());

		for (int i=0; i<boardLength; i++;) {
			if (! gameOver) {
				String nextGuess = this.getGuess();
				boolean winner = gameBoard.addRow(nextGuess);
				System.out.println(gameBoard.toString());
				if (winner) {
					gameOver = true;
					System.out.println("You Win!");
					break;
				}
			}
		}
		if (gameOver == false) {
			gameOver = true;
			System.out.println("You Lose!");
		}
	}

	public Row getCode(){
		if (difficulty == Difficulty.HARD){
			colors += "W";
			codeLength = 5;
		}
		
		String code = "";
		for (int i=0; i<codeLength; i++){
			int randInt = (int)(Math.random() * ((colors.length()) + 1));
			code += colors.substring(randInt, randInt);
		}
		codeRow = new Row(code);
		return codeRow;
	}

	public Row getGuess(){
		System.out.println("Enter a guess:");
		String guess = scanner.nextLine();
		while (guess.length() != codeLength){
			System.out.println("Wrong length! Enter a guess:");
			String guess = scanner.nextLine();
		}
		
	}
}