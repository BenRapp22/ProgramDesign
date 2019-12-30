//Ben Rapp
//Program Design and Abstraction, 1068-003
//This program is a recreation of the ancient viking game Havstra

import java.util.*;

public class game {

	public static void main(String[] args) {
		int rounds = 0;
		int uwins = 0;
		
		Intro();
		if(Prompt() == true) {
			do {
				rounds ++;
				Moves();
				uwins += Play();
				}while(Prompt2() == true);
			
			System.out.println("Thanks for playing!");
			System.out.println("You played: " + rounds + " rounds!");
			System.out.println("You won " + uwins + " games!");
			System.out.println("The computer won: " + ((int)Math.abs(rounds - uwins)) + " games!");
			
			}
		else{
			System.out.println("Have a lovely day! :)");
	}
		
	}
	//Prints the Rules
	public static void Intro() {
		System.out.println("Welcome to Havstra! Here are the rules:\n"
				+ "Applaro beats Svartrå and Tunholmen\r\n" + 
				"Svartrå beats Tunholmen\r\n" + 
				"Tunholmen beats Godafton\r\n" + 
				"Godafton beats Applaro and Svartrå\r\n" + 
				"The computer wins in the event of a tie.");
		System.out.println();
	}

	//Asks the user if they want to play
	public static boolean Prompt() {
		while(true){
			System.out.println("Please type 'y' or 'n'");
		
			Scanner yorn = new Scanner(System.in);
			String response = yorn.next();
		

			if(response.equals((String) "y")) {
				System.out.println("Great!");
				return(true);
			}
			else if(response.equals((String)"n")) {
				System.out.println("That's OK!");
				return(false);
			}
			else {
				System.out.println();
			}
		}}
	
	//Quantifies the moves
	public static void Moves() {
		System.out.println("1. Applaro\n2. Svartra\n3. Tunholmen\n4. Godafton\nPlease select one of the four moves!");
		
	}
	
	//Gameplay loop, returns the number of user wins
	public static int Play() {
		int u = 0;
		
		while(true){
		
		Random random = new Random();
		int cpuchoice = (random.nextInt(4) + 1);
		
		
		Scanner user = new Scanner(System.in);
		int userchoice = user.nextInt();
		
		if(userchoice == 1) {
			System.out.println("The computer picked: " + cpuchoice);
			if(cpuchoice == 2 || cpuchoice == 3) {
				System.out.println("You Win!");
				u++;
			} else {
				System.out.println("Computer Wins!");
				
			} break;
		} 
		
		else if(userchoice == 2){
			System.out.println("The computer picked: " + cpuchoice);
			if(cpuchoice == 1 || cpuchoice == 4 || cpuchoice == 2) {
				System.out.println("Computer Wins!");
				
			} else {
				System.out.println("You Win!");
				u++;
			}break;
		} 
		
		else if(userchoice == 3) {
			System.out.println("The computer picked: " + cpuchoice);
			if(cpuchoice == 1 || cpuchoice == 2 || cpuchoice == 3) {
				System.out.println("Computer wins!");
				
			} else {
				System.out.println("You win!");
				u++;
			}break;
		} 
		
		else if(userchoice == 4) {
			System.out.println("The computer picked: " + cpuchoice);
			if(cpuchoice == 3 || cpuchoice == 4) {
				System.out.println("Computer wins!");
				
			} else {
				System.out.println("You win!");
				u++;
			}break;
		} 
		
		else {
			System.out.println("Try Again!");
		}}
		return(u);
		}
		
	
	//Asks the user if they'd like to continue playing
	public static boolean Prompt2() {
			System.out.println("Type '1' to play again! Type any other integer to quit!");
			
			Scanner in = new Scanner(System.in);
			int z = in.nextInt();
			
			if(z == 1) {
				return(true);
			} else {
				return(false);
			}
		}
		}
