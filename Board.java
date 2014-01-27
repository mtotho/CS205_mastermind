public class Board{

	int rowLength;	

	public Board(){
		System.out.println("Board created");
	}

	public Board(int difficulty, Row code){
		rowLength = code.length;
	}

}