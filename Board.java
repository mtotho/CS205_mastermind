import java.util.ArrayList;

public class Board{

	private ArrayList<Row> rows;
	private ArrayList<Integer> hardhits;
	private ArrayList<Integer> softhits;
	private Row code;
	private int currentRow = 0;
	//private String master;
	//private String colorsEasy = "RGBOPY";
	//private String colorsDifficult = "RGBOPYW";
	//private int rowLength;
	private Difficulty difficulty;
	private int rows_remaining;

	public Board(Row code, int board_length){
		//Create code row with difficulty
		this.code=code;
		this.rows_remaining=board_length;

		rows = new ArrayList<Row>();
		hardhits=new ArrayList<Integer>();
		softhits=new ArrayList<Integer>();
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

		rows_remaining--;

		if(new_row.getHardHits()==guessString.length()){
			return true;
		}else{
			return false;
		}
	}

	public int rowsRemaining(){
		return rows_remaining;
	}

	public String toString(){
		//System.out.println("CODE: " + code.toString());

		//Change the blanks size so formatting stays consistent for different size
		String blanks="----";
		String guess =" Guess";
		if(code.items.size()==5){
			blanks="-----";
			guess= " Guess ";
		}

		String output = "/*\n/*>> Game Board\n";
		output+="/* Soft Hits |"+guess+"| Hard Hits";
		for(int i=0; i<rows.size(); i++){

			output+="\n/*     "+ softhits.get(i)+"     | "+rows.get(i).toString() + " |    " + hardhits.get(i);
		}

		//Print out empty rows 
		if(rows_remaining>0){
			for(int j=0; j<rows_remaining; j++){
				output+="\n/*     -     | "+ blanks + " |    -";
			}
		}
		output+="\n/*\n/* **" + rows_remaining + " Guesses remain**";

		if(rows_remaining==0){
			output+="\n/*\n/* The secret code: " + code.toString(); 
		}

		return output;
	}
}