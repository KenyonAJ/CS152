package cs152;

import java.io.*;
import java.util.Scanner;

public class TestBookCollection {
	
	public static void main(String[] args) throws IOException {
		
		Scanner keyboard = new Scanner(System.in);
		String str;
		BookCollection test = new BookCollection();
		
		test.toString();
		test.displayShortBooks();
		
		System.out.println("\nPlease enter the name of an author: ");
		str = keyboard.nextLine();
				
		test.displayBooksFromAuthor(str);
		
		System.out.println("\nPlease enter the name of an another author: ");
		str = keyboard.nextLine();
		
		test.displayBooksFromAuthor(str);
		
		System.out.println("\nPlease enter a subject area: ");
		str = keyboard.nextLine();
		keyboard.close();
				
		test.displayBooksFromArea(str);
		
		test.displayAverageLength();
		
		test.displayChemCSBooks();
		test.displayOtherBooks();
	}

}
