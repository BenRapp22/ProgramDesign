/*Ben Rapp
1068-003
This project creates a list of book recommendations for a user based on the similarity of their taste to a group of sample users. 
I was not allowed to use ArrayLists in this project*/

import java.io.*;
import java.util.*;


public class BookRecommender{
	public static void main(String args[]) 
	throws FileNotFoundException{
		String[] booklist = bookRead();
		int[][] ratinglist = ratingRead();
		int[] userratings = userRatings(booklist);
		double[] simscores = similarityScores(userratings, ratinglist);
		double[] waverages = bookAv(ratinglist, simscores);
		String[] sortedBooklist = recOrder(waverages, booklist, userratings);

		
		
		System.out.println("The books that you'd like the most are ranked in the following order! ");
		System.out.println();
		for(int i = 19; i >= 0; i--) {
			if((sortedBooklist[i].equals("read")) == false){
				System.out.println(sortedBooklist[i]);
			}
			
		}
		
	}
	
	//Reads in a book list as a fixed-length array
	public static String[] bookRead() 
	throws FileNotFoundException{
		String[] booklist = new String[20];
		Scanner bookscan = new Scanner(new File("src/books.txt"));
		int i = 0;
		while(bookscan.hasNextLine()) {
			String line = bookscan.nextLine();
			booklist[i] = line;
			i += 1;
		}
		return booklist;
	}
	
	
	//Creates a 2D array of the sample scores for each book
	public static int[][] ratingRead() throws FileNotFoundException{
		int[][]ratingtable = new int[30][20];
		Scanner ratingscan = new Scanner(new File("src/ratings.txt"));
		int i = 0;
		int j = 0;
		while(ratingscan.hasNextInt()) {
			int nrating = ratingscan.nextInt();
			ratingtable[i][j] = nrating;
			j += 1;
			if(j == 20) {
				j = 0;
				i += 1;
			}
			}
		return ratingtable;
	}
	
	//Prompts the user for their scores for each book
	public static int[] userRatings(String[] booklist) {
		int[] userratings = new int[20];
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a rating from 1 to 5 for the given book! If you've never read it, please enter -1. ");
		for(int i = 0; i < 20; i++) {
			System.out.println("The book is: " + booklist[i]);
			while(true) {
			int response = in.nextInt();
			if(response == 0 || response > 5 || response < -1) {
				System.out.println("Out of Bounds. Try Again!");
			}else {
				userratings[i] = response;
				break;
			}
			}
		}
		return userratings;
	}
	
	
	//Method to help break up the similarity calculation for the user's book list and the sample table
	public static double calcSquare(int[] userratings) {
		double p = 0.0;
		for(int i = 0; i<20; i++) {
			p += userratings[i] * userratings[i];
		}
		p = Math.sqrt(p);
		return p;
	}
	
	//Helper method
	public static double productRatings(int[] userratings, int[] ratinglist) {
		double both = 0;
		for(int i = 0; i < 20; i++) {
			both += userratings[i] * ratinglist[i];
		}
		return both;
	}
	
	//Calculates the similarity of the user's score to other sample scores using Cosine Similarity
	public static double[] similarityScores(int[] userratings, int[][] ratinglist) {
		double user = calcSquare(userratings);
		
		double[] similarity = new double[30];
		
		for(int i = 0; i < 30; i++) {
			similarity[i] = productRatings(userratings, ratinglist[i])/ (calcSquare(ratinglist[i]) * user); 
		}
		
		return similarity;	
	}
	
	//Creates a table of weighted averages for each book score to help deliver a recommendation
	public static double[] bookAv(int[][] ratinglist, double[] simscores) {
		double[] wavarray = new double[20];
		
		double wnumerator = 0;
		double weightsum = 0;
		
		for(int i = 0; i < 30; i++) {
			weightsum += simscores[i];
		}
		
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 30; j++) {
				wnumerator += (simscores[j]*ratinglist[j][i]);
			}
			wavarray[i] = (wnumerator / weightsum);
			wnumerator = 0;
		}
		
		return wavarray;
	}
	
	//Orders the list of weighted averages for recommendation
	public static String[] recOrder(double[] waverages, String[] booklist, int[] userratings) {
		double[] wavsort = waverages.clone();
		Arrays.sort(wavsort);
		
		int[] order = new int[20];
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				if(wavsort[j] == waverages[i]) {
					order[i] = j;
				}
			}
		}
		String[] sortedBooklist = new String[20];
		String r = "read";
		for(int i = 0; i < 20; i++) {
			if(userratings[i] == -1) {
			sortedBooklist[i] = booklist[order[i]];
		}else {
			sortedBooklist[i] = r;
		}
		}
		
		return sortedBooklist;
	}
}
