package cs152;

import java.util.Scanner;

public class Movies {

    public static void main (String[] args) {
    	
    	Scanner keyboard = new Scanner(System.in);
    	String choice, userSearchTerm;
    	int searchResult;
        
        DVDCollection movies = new DVDCollection();
        
        movies.addDVD("The Godfather", "Francis Ford Coppola", 1972, 24.95, true);
        movies.addDVD("District 9", "Neill Blomkamp", 2009, 19.95, false);
        movies.addDVD("Iron Man", "Jon Favreau", 2008, 15.95, false);
        movies.addDVD("All About Eve", "Joseph Mankiewicz", 1950, 17.50, false);
        movies.addDVD("The Matrix", "Andy & Lana Wachowski", 1999, 19.95, true);
        
        System.out.println(movies);
        
        movies.addDVD("Iron Man 2", "Jon Favreau", 2010, 22.99, false);
        movies.addDVD("Casablanca", "Michael Curtiz", 1942, 19.95, false);
        
        System.out.println(movies);
        
        do {
        	System.out.println("Please enter the director's name: ");
        	userSearchTerm = keyboard.nextLine();
        	searchResult = movies.searchForDVD(userSearchTerm);
        	if (searchResult == -1)
        		System.out.println("No DVD by that director was located.");
        	else
        		System.out.println("That DVD is located at " + searchResult);
        	System.out.println("Would you like to search again? (y or n)");
        	choice = keyboard.nextLine();
        	}
        while (choice.equalsIgnoreCase("y"));
        keyboard.close();
       }
}