package cs152;

public class Book {
	
	private String isbn, author, area;
	private int length;
	private static int totalNumBooks;
		
	Book (String isbn, String author, String area, int length) {
		this.isbn = isbn;
		this.author = author;
		this.area = area;
		this.length = length;
		totalNumBooks++;
	}
	boolean isShort(){
		boolean flag = false;
		if (length < 500){
			flag = true;
			return flag;
		}
		return flag;
	}
	
	String getAuthor(){
		return author;
	}
	String getArea(){
		return area;
	}
	int getLength(){
		return length;
	}
	static int getTotalNumBooks(){
		return totalNumBooks;
	}
	String chemCS(){
		if (area.equalsIgnoreCase("CS"))
			return "CS";
		if (area.equalsIgnoreCase("CHEM"))
			return "Chem";
		return "Other";
	}
	public String toString() {
		String result;
		result = "BOOK ISBN: " + isbn + ", AUTHOR: " + author + ", AREA: " + area +
				", PAGES: " + length;
		return result;
	}

}
