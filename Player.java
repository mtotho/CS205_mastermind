/* Player.java - C. Ryan Williams
	
Player class.  

Variables:
	- string name
	- int wins
	- int losses
	- int difficulty
	
Methods:
	- setName()
	- getName()
	- setDifficulty()
	- getDifficulty()
	- addWin()
	- getWins()
	- addLoss()
	- getLosses()
	 */

import java.util.Scanner;


public class Player{

	private String name;
	private int wins;
	private int losses;
	private int gamesplayed;
	private double average_turns;
	private int total_turns;
	//private int difficulty;

	
// Constructor() - Creates Player with name, wins, losses  
	public Player(String userName){

		// set Player fields
		name = userName;
		wins = 0;
		losses = 0;
		//difficulty = userDifficulty;

		//Display text confirming player's name 
		System.out.println("/*\n/* Welcome " + name + ", let's get started.");

	
	/*	String difficultyString;

		switch (difficulty){
			case 1: difficultyString = "Easy";
										break;
			case 2: difficultyString = "Hard";
										break;
			default: difficultyString = "Error";
										break;*/
		//}
		
		

	}// end Player()

// setName() - sets the Player's name 
	public void setName(String newName){
		name = newName;
	}// end setName()

// getName() - returns the Player's name 
	public String getName(){
		return name;
	}// end getName()

/*
// setDifficulty() - sets the Player's difficulty 
	public void setDifficulty(int newDifficulty){
		difficulty = newDifficulty;
	}

// getDifficulty() - returns the Player's difficulty 
	public int getDifficulty(){
		return difficulty;
	}
	*/

// addWin() - adds a win to the Player's win field 
	public void addWin(){
		wins++;
	}// end addWin()

// getWins() - returns the Player's wins 
	public int getWins(){
		return wins;
	}// end getWins()

// addLoss() - adds a loss to the Player's loss field 
	public void addLoss(){
		losses++;
	}// end addLoss()

// getLosses() - returns the Player's losses 
	public int getLosses(){
		return losses;
	}// end getLosses()

// getAverageTurns() - returns player's average turns to solve puzzle
	public double getAverageTurns(){
		return average_turns;
	}

// newGame() - creates a new Mastermind game
	public int newGame(Difficulty difficulty){
		int result;

		// start new game
		Mastermind game = new Mastermind(difficulty, name);
		result = game.run();
		gamesplayed++;

		// if player wins:
		// 		- add win to record
		// 		- determine number of average turns
		if(result != -1){
			this.addWin();
			total_turns+=result;
			average_turns=(double)total_turns/wins;

		}else{ // add loss to record
			this.addLoss();
		}// end if..else

		
		return result;
	}// end newGame()

// toString() - Returns the player's win/loss record
	public String toString(){
		return String.format("Your record:\t%d Wins - %d Losses", wins, losses);
	}// end toString()

}
