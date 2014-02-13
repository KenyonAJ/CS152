package cs152;

import java.io.*;

public class TestProject3 {

	
	public static void main(String[] args) throws IOException {
		
		String file = "sortresults.txt";
		FileWriter fw = new FileWriter (file);
		BufferedWriter bw = new BufferedWriter (fw);
		PrintWriter outFile = new PrintWriter (bw);
		
		 Contact[] friends = new Contact[10];
	        
	        friends[0] = new Contact ("John", "Smith", "610-555-7384");
	        friends[1] = new Contact ("Sarah", "Barnes", "215-555-3827");
	        friends[2] = new Contact ("Mark", "Riley", "733-555-2969");
	        friends[3] = new Contact ("Laura", "Getz", "663-555-3984");
	        friends[4] = new Contact ("Larry", "Smith", "464-555-3489");
	        friends[5] = new Contact ("Frank", "Phelps", "322-555-2284");
	        friends[6] = new Contact ("Mario", "Guzman", "804-555-9066");
	        friends[7] = new Contact ("Marsha", "Grant", "243-555-2837");
	        friends[8] = new Contact ("John", "Smith", "610-555-7777");
	        friends[9] = new Contact ("Larry", "Smith", "610-555-7388");
	        
	        int length = friends.length;
	        
	        Contact[] friendsClone = friends.clone();
	        
	        outFile.println("Friends before sort: ");
	        for (Contact friend : friends)
	        	outFile.println(friend);
	        
	        Sorting.bubbleSortRecursive(friends, length);
	        
	        outFile.println("\n\n\nFriends after recursive bubble sort: ");
	        for (Contact friend : friends)
	        	outFile.println(friend);
	        
	        outFile.println("\n\n\nFriends clone before sort: ");
	        for (Contact friend : friendsClone)
	        	outFile.println(friend);
	        
	        
	        Sorting.selectionSortRecursive(friendsClone, length);
	        
	        outFile.println("\n\n\nFriends clone after recursive selection sort: ");
	        for (Contact friend : friendsClone)
	        	outFile.println(friend);
	        
	        outFile.close();
	        
	       
	        System.out.println("\n\n");
		

	}

}
