package cs152;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

public class BookCollection {
	
	
	private ArrayList<Book> bookList;
		
	BookCollection () throws IOException {
		
		bookList = new ArrayList<>();
		String line, isbn, author, area;
		int length;
		Scanner fileScan, lineScan;
		fileScan = new Scanner (new File ("books.txt"));
		fileScan.useDelimiter("/n");
		Book tempBook;
		
		do
		{
			line = fileScan.nextLine();
			lineScan = new Scanner (line);
			isbn = lineScan.next();
			author = lineScan.next();
			area = lineScan.next();
			length = lineScan.nextInt();
			tempBook = new Book (isbn, author, area, length);
			bookList.add(tempBook);
			lineScan.close();
		}
		while (fileScan.hasNext());
		fileScan.close();
	}
	
	void displayShortBooks(){
		System.out.print("\nSHORT BOOKS\n");
		for (Book temp : bookList)
			if (temp.isShort())
				System.out.println(temp);
	}
	void displayBooksFromAuthor(String author){
		boolean flag = false;
		for (Book temp : bookList){
			String x = temp.getAuthor();
			if (x.equals(author)){
				flag = true;
				System.out.println(temp);
			}
		}
		if (flag == false)
			System.out.printf("There are no books authored by %s.\n", author);
	}
	void displayBooksFromArea(String area){
		for (Book temp : bookList){
			String x = temp.getArea();
			if (x.equalsIgnoreCase(area))
				System.out.println(temp);
		}
	}
	void displayAverageLength(){
		int n = Book.getTotalNumBooks();
		int totalPages = 0;
		DecimalFormat fmt = new DecimalFormat ("0.##");
		for (Book temp : bookList)
			totalPages += temp.getLength();
		double averageLength = ((double)totalPages/n);
		System.out.println("\nAverage length of all books is " 
				+ fmt.format(averageLength) + ".");
	}
	void displayChemCSBooks(){
		System.out.println("\nCHEMISTRY and COMPUTER SCIENCE BOOKS");
		String x;
		for (Book temp : bookList){
			x = temp.chemCS();
			if (x.equalsIgnoreCase("CS") || x.equalsIgnoreCase("Chem"))
				System.out.println(temp);
		}
	}
	void displayOtherBooks(){
		System.out.println("\nOther Books");
		String x;
		for (Book temp : bookList){
			x = temp.chemCS();
			if (x.equalsIgnoreCase("Other"))
				System.out.println(temp);
		}
	}
	
	
	
	
	
	
	
	
	public String toString(){
		String result = "";
		for (Book temp : bookList)
			System.out.println(temp);
		return result;
	}

}
