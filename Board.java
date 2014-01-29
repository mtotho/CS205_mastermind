public class Board{

	private Arraylist<Row> board;
	private int currentRow = 0;
	private string guess;
	private string master;
	private string colorsEasy = "RGBOPY"
	private string colorsDifficult = "RGBOPYW"
	private int random;


	public Board(int difficulty){

		Random random = new Random();

		System.out.println("Board created for difficulty " + difficulty);

	}

	/* adds guessed row to the board */
	public addRow(){

		//if guess is to many pegs, rejects
		if (code.length() > difficulty + 3){

			System.out.println("Your guess is too long, try again with " + difficulty + 3 + " pegs.");
		}
		//creates a new row with the guess string
		else{

			board.add(currentRow, new Row(Guess);
			currentRow++;

		}



	}
	//generates random numbers and creates a row of length 4 or 5 based on difficulty.
	public createMasterRow(){


		if (difficulty = 1){

			for (int i = 0; i < 4, i++){
				random = random.nextInt(100) % 4;
				master = master.concat(colorsEasy.charAt(random));

			}

		}
		else{


			for (int i = 0; i < 5, i++){
				random = random.nextInt(100) % 5;
				master = master.concat(colorsDifficult.charAt(random));

			}
		}

		Row masterRow = new Row(master);

	}




}