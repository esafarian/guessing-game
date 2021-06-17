import java.util.*;
public class GuessingGame {
	private static int game = 0;
	private static int guessCount = 0;
	private static int minGuess = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		playGame(reader);
		
		System.out.println("Do you want to play again? ");
		
		
		String userInput = reader.next();
		
		
		while(userInput.indexOf("y")!=-1 || userInput.indexOf("Y")!=-1) {
	        guessCount = playGame(reader);
	        
	        System.out.println("Do you want to play again?");
	        userInput = reader.next();
		}
		
		
		overallStatistics(game, guessCount, minGuess);

		}
	

	public static int playGame(Scanner reader) {
		System.out.println("I'm thinking of a number between 1 and 100... " + "\nYour guess?");
		int guess = 0;
		int number = (int)(java.lang.Math.random()*100)+1;
		int count = 1;
		guess = reader.nextInt();

		for(; guess < number || guess > number; count++) {

			if (guess > number) {
				System.out.println("It's lower.");
				guessCount++;
			}
			if (guess < number) {
				System.out.println("It's higher.");
				guessCount++;
			}
			System.out.println("Your guess? ");
			guess = reader.nextInt();
		}
		if (guess == number) {
			System.out.println("You got it right in " + count + " guesses!");
			guessCount++;
			game++;
			
		}
		if(guessCount < minGuess) {
			minGuess = guessCount;
			}
		
		return guessCount;
	}


	public static void overallStatistics(int game, int guessCount, int minGuess) {
		double avgGuess = guessCount/game;
		System.out.println("Overall results: ");
		System.out.println("Total games  = " + game);
		System.out.println("Total guesses  = " + guessCount);
		System.out.println("Guesses/game  = " + avgGuess);
		System.out.println("Best game  = " + minGuess + " guesses.");
	}

}