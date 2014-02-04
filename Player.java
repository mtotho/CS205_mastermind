/* C. Ryan Williams 1/29/14
	
Player class.  Includes variables;
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

//
	private String name;
	private int wins;
	private int losses;
	private int gamesplayed;
	private double average_turns;
	private int total_turns;
	//private int difficulty;

	
// Constructor - Creates Player with name, wins, losses and difficulty 

	public Player(String userName){

		// set Player fields
		name = userName;
		wins = 0;
		losses = 0;
		//difficulty = userDifficulty;


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
		
		

	}

// setName() - sets the Player's name 
	public void setName(String newName){
		name = newName;
	}

// getName() - returns the Player's name 
	public String getName(){
		return name;
	}

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
	}

// getWins() - returns the Player's wins 
	public int getWins(){
		return wins;
	}

// addLoss() - adds a loss to the Player's loss field 
	public void addLoss(){
		losses++;
	}

// getLosses() - returns the Player's losses 
	public int getLosses(){
		return losses;
	}

	public double getAverageTurns(){
		return average_turns;
	}

	public int newGame(Difficulty difficulty){
		int result;
		Mastermind game = new Mastermind(difficulty, name);
		result = game.run();
		gamesplayed++;

		if(result != -1){
			this.addWin();
			total_turns+=result;
			average_turns=(double)total_turns/wins;

		}else{
			this.addLoss();
		}

		
		return result;
	}

	public String toString(){
		return String.format("Your record:\t%d Wins - %d Losses", wins, losses);
	} 

}
