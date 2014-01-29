/* C. Ryan Williams 1/27/14
	
Set Player class. Will include;
	- string name
	- int wins
	- int losses
	- int difficulty
	 */

import java.util.Scanner;
/*import java.util.*; */

public class Player{

	private String name;
	private int wins;
	private int losses;
	private int difficulty;

	Scanner userInput = new Scanner(System.in);

	public Player(String userName, int userWins, int userLosses, int userDifficulty){
		System.out.println("Creating Player...");
		System.out.println("Player created.");


		name = userName;
		wins = userWins;
		losses = userLosses;
		difficulty = userDifficulty;


		System.out.println("\n\n\nWelcome to Mastermind " + name + ".");

		String difficultyString;

		switch (difficulty){
			case 1: difficultyString = "Easy";
										break;
			case 2: difficultyString = "Hard";
										break;
			default: difficultyString = "Error";
										break;
		}
		System.out.println("You are playing Mastermind on " + difficultyString + ".");
		System.out.println("\nYour record:");
		System.out.println("Wins - " + wins);
		System.out.println("Losses - " + losses + "\n");

	}

	public void setName(String newName){
		name = newName;
	}

	public String getName(){
		return name;
	}

	public void setDifficulty(int newDifficulty){
		difficulty = newDifficulty;
	}

	public int getDifficulty(){
		return difficulty;
	}

	public void addWin(){
		wins++;
	}

	public int getWins(){
		return wins;
	}

	public void addLoss(){
		losses++;
	}
	public int getLosses(){
		return losses;
	}

}
