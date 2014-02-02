import java.util.*;

enum Difficulty{
		NORMAL,HARD
}


public class Mastermind{

	private char[] colors = {'R', 'G', 'B', 'Y', 'P', 'O'};
	private int codeLength = 4;
	private Board gameBoard;
	private Row codeRow;
	private Difficulty difficulty;

	public Mastermind(Difficulty difficulty){
		this.difficulty=difficulty;
		System.out.println("Mastermind game created");

		//Do something with difficulty

		new Board(getCode());
	}

	public Row getCode(){
		if (difficulty == Difficulty.HARD){
			colors[7] = 'W';
			codeLength = 5;
		}
		
		String code = "";
		for (int i=0; i<codeLength; i++){
			int randInt = (int)(Math.random() * ((colors.length) + 1));
			code += colors[randInt];
		}
		codeRow = new Row(code);
		return codeRow;
	}
}