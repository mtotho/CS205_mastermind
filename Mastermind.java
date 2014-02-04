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
	private static int BOARD_LENGTH = 10;
	private String pname;
	private Scanner scanner = new Scanner(System.in);

	public Mastermind(Difficulty difficulty, String pname){
		this.difficulty=difficulty;
		this.pname=pname;

		String gameOutput = "";
		gameOutput+="/*\n";
		gameOutput+="/*>> NEW MASTERMIND GAME STARTED\n";
		gameOutput+="/*\n";
		gameOutput+="/* Player:     " + pname + "\n";
		gameOutput+="/* Difficulty: " + difficulty + "\n";
	//	gameOutput+="/*\n";
		gameOutput+="/*<<>><<>><<>><<>><<>><<>><<>><<>>";
		//System.out.println("## New Mastermind Game is starting ## \n");
		System.out.println(gameOutput);

	

		
	}

	public int run(){
		//Construct new board object with generated code row
		gameBoard = new Board(this.getCode(), BOARD_LENGTH);
		boolean winner = false;

		//Loop for each turn
		int i=0;
		for (i=0; i<BOARD_LENGTH; i++) {
			
			//Action to take if game has not ended
			if (! gameOver) {

				//Get the next guest from user input
				String nextGuess = this.getGuess();

				//prematurely quit game
				if(nextGuess.equalsIgnoreCase("quit")){
					gameOver=true;
					break;
				}

				//Add the guess to the gameboard, return true if the user has guessed correctly
				winner = gameBoard.addRow(nextGuess);

				//Print the gameboard out
				System.out.println(gameBoard.toString());

				//Check to see if no rows remain and set gameover if that is the case
				if(gameBoard.rowsRemaining()==0){
					gameOver=true;
				}

				if (winner) {
					gameOver = true;
				}

			}else{
				break;
			}
		}//for

		//Return number of turns required to win, 0 for failed
		if(!winner){
			return -1;
		}else{
			return i;
		}
	}

	public Row getCode(){
		if (difficulty == Difficulty.HARD){
			colors += "W";
			codeLength = 5;
		}
	
		String code=shuffle(colors);

		code=code.substring(0, codeLength);

		codeRow = new Row(code);
		return codeRow;
	}

	public String shuffle(String input){
        List<Character> characters = new ArrayList<Character>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
       
       return output.toString();
    }

	public String getGuess(){

		System.out.println("/*\n/*[Peg Color Options: " + colors + "]");

		System.out.println(">>Enter a guess (or type quit to give up):");

		String guess = scanner.nextLine();
		boolean valid = false;
		while (!valid){

			valid = true;

			if(guess.equalsIgnoreCase("quit")){
				return "quit";
			}

			if(guess.length() != codeLength){
				valid=false;
			}

			//For check
			for(int i = 0; i < guess.length(); i++){

				if (!colors.contains("" + Character.toUpperCase(guess.charAt(i)))){

					valid = false;
				}
			}
			if(!valid){
				System.out.println("/* Your guess is invalid! Make sure it is the correct length and uses the correct colors!");
				guess = scanner.nextLine();
			}
		}
		
		return guess;
	}
}