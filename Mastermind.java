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
	private Scanner scanner = new Scanner(System.in);

	public Mastermind(Difficulty difficulty){
		this.difficulty=difficulty;
		System.out.println("## New Mastermind Game is starting ## \n");

		//Do something with difficulty

		gameBoard = new Board(this.getCode());

		for (int i=0; i<BOARD_LENGTH; i++) {
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

		System.out.println("Color Options: " + colors);

		System.out.println(">>Enter a guess:");

		String guess = scanner.nextLine();
		boolean valid = false;
		while (!valid){

			valid = true;

			if(guess.length() != codeLength){
				valid=false;
			}

			//For check
			for(int i = 0; i < guess.length(); i++){

				if (!colors.contains("" + guess.charAt(i))){

					valid = false;
				}

			}
		


			if(!valid){
				System.out.println("Your guess is invalid! Make sure it is the correct length and uses the correct colors!");
				guess = scanner.nextLine();
			}
		}
		
		return guess;
	}
}