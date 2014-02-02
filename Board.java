import java.util.ArrayList;

public class Board{

	private ArrayList<Row> rows;
	private Row code;
	private int currentRow = 0;
	private String master;
	private String colorsEasy = "RGBOPY";
	private String colorsDifficult = "RGBOPYW";
	private int rowLength;
	private Difficulty difficulty;

	public Board(Row code){
		//Create code row with difficulty
		this.code=code;
	}

	/* adds guessed row to the board */
	public void addRow(String guessString){
		Row new_row= new Row(guessString);
		rows.add(new_row);

	}
}