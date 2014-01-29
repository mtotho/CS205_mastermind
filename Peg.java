/* defines a peg color and integer value with respect to that color as defined below */
/* red = 1, green = 2, blue = 3, orange = 4, purple = 5, yellow = 6, white = 7 */


public class Peg{

	private int value;
	private char color;

	public Peg(char color){
		
		this.color = Character.toUpperCase(color);
		System.out.println(char color + " color peg created with value " + value);
		setValue();

	}
	/* sets a corresponding value to the color entered */
	public setValue(){

		switch(color){
			
			case 'R': value = 1;
				break;

			case 'G': value = 2;
				break;

			case 'B': value = 3;
				break;

			case 'O': value = 4;
				break;

			case 'P': value = 5;
				break;

			case 'Y': value = 6;
				break;

			case 'W': value = 7; 

		}
	}

	/*returns integer value of color*/
	public int getValue(){

		return value;

	}

	/* returns char value of color */
	public char getColor(){

		return color;

	}



}