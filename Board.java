import java.util.ArrayList;

public class Board{

	private ArrayList<Row> rows;
	private ArrayList<int> hardhits;
	private ArrayList<int> softhits;
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
	public boolean addRow(String guessString){
		Row new_row= new Row(guessString);

		//Compare guess row with code row
		new_row.compare(code);

		//add the hard hit, soft hit and row data to an array list
		hardhits.add(new_row.getHardHits());
		softhits.add(new_row.getSoftHits());
		rows.add(new_row);	

		if(new_row.getHardHits()==guessString.length()){
			return true;
		}else{
			return false;
		}
	}

	public String toString(){

		String output = "\n||Game Board";

		for(int i=0; i<rows.size(); i++){

			output+=softhits.get(i)+" | "+rows.get(i).toString() + " | " + hardhits.get(i) + "\n";

		}

		return output;
	}
}