import java.util.*;

public class Mastermind{

	char[] colors = {'R', 'G', 'B', 'Y', 'P', 'O'};
	int difficulty;
	int codeLength = 4;
	Board gameBoard;
	Row codeRow;

	public Mastermind(){
		System.out.println("Mastermind game created");

		new Board();
	}

	public Mastermind(int difficulty){
		this.difficulty = difficulty;
	}

	public Row getCode(){
		if (difficulty == 2){
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