import java.util.ArrayList;

public class Row{

	private int hardhit; //right color right place
	private int softhit; //right color wrong place

	public ArrayList<Peg> items;

	public Row(String pegstring){
		//parse row string, create peg object and add to items array
		for (int i = 0; i < pegstring.length();i++){

			items.add(new Peg(pegstring.charAt(i)));

		}

	}

	public void compare(Row code){

		//ArrayList<Peg> code_items=code.items;

		//Loop through each item in the code row
		for(int j=0; j<code.items.size(); j++){

			boolean hard=false;
			boolean soft=false;

			//For each code row item, loop through each guess row item
			for(int k=0; k<items.size(); k++){

				//get the guess and code values for the specific column
				int guessval=items.get(k).getValue();
				int codeval =code.items.get(j).getValue();

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

	public String toString(){

		String output ="";

		for(int i=0; i<items.size(); i++){
			Peg peg = items.get(i);
			output+=peg.getColor();
		}

		return output;
	}
}