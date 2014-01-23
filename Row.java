import java.util.Arraylist;

public class Row{

	private int hardhit; //right color right place
	private int softhit; //right color wrong place

	private Arraylist<Peg> items;

	public Row(String pegstring){
		//parse row string, create peg object and add to items array
	}

	public boolean compare(Row code){

		//Loop through each item in the guess row
		for(int j=0; j<items.length(); j++){

			boolean hard=false;
			boolean soft=false;

			//For each guess row item, loop through each code row item
			for(int k=0; k<code.length(); k++){

				//get the guess and code values for the specific column
				int guessval=items.val(j).getValue();
				int codeval =code.val(k).getValue();

				//Determine if it is a hard hit or 
				if(guessval==codeval && j==k){
					hard=true;
				}else if(guessval==codeval && j!=k){
					soft=true;
				}

			}//end inner for

			if(hard){
				hardhit++;
			}else if(soft && !hard){
				softhit++''
			}


		}//end outer for

	}
}