import java.util.Arraylist;

public class Row{

	private int hardhit; //right color right place
	private int softhit; //right color wrong place

	private Arraylist<Peg> items;

	public Row(String pegstring){
		//parse row string, create peg object and add to items array
		for (int i = 0; i++; i < pegstring.length()){

			items.add(i, new Peg(pegstring(charAt(i))));

		}

	}

	public boolean compare(Row code){

		//Loop through each item in the code row
		for(int j=0; j<code.length(); j++){

			boolean hard=false;
			boolean soft=false;

			//For each code row item, loop through each guess row item
			for(int k=0; k<items.length(); k++){

				//get the guess and code values for the specific column
				int guessval=items.val(k).getValue();
				int codeval =code.val(j).getValue();

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
				softhit++;
			}

		}//end outer for

	}//end compare

	public int getHardHits(){
		return hardhit;
	}

	public int getSoftHits(){
		return softhit;
	}
}