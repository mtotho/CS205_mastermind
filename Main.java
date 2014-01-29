import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		/* initialize variables for player */
		int userWins = 0;
		int userLosses = 0;
		Scanner userInput = new Scanner(System.in);

		/* Get player's name */
		System.out.println("Enter Your Name:");
		
		String userName = userInput.nextLine();

		System.out.println("Choose a difficulty:\n1 = Easy\n2 = Hard");

		String diffString = userInput.nextLine();
		int userDifficulty = Integer.parseInt(diffString);
		Player p1 = new Player(userName, userWins, userLosses, userDifficulty);

		/* test player functions */
		/*System.out.println("Test functions:");

		String testName = "Walter White";
		p1.setName(testName);
		System.out.println("\n1) Set Name & Get Name:");
		System.out.println("Name = " + p1.getName());

		p1.addWin();
		System.out.println("\n2) Add Win:");
		System.out.println("Win = " + p1.getWins());

		p1.addLoss();
		System.out.println("\n3) Add Loss:");
		System.out.println("Loss = " + p1.getLosses());*/





		//Logic to switch easy hard

		//if hard
		//Mastermind game = new Mastermind(Mastermind.difficulty.HARD);
		//else
		Mastermind game = new Mastermind();

	}

}
