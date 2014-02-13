package cs152;

import java.text.NumberFormat;

public class DVDCollection   {

    private DVD[] collection;
    private int count;
    private double totalCost;
    
    public DVDCollection () {
        
        collection = new DVD[100];
        count = 0;
        totalCost = 0.0;
    }
        
    public void addDVD (String title, String director, int year, double cost, boolean bluray) {
        
    	DVD temp;
    	
    	if (count == collection.length)
            increaseSize();
               
        if (count > 0){
          	collection[count] = new DVD (title, director, year, cost, bluray);
        	temp = collection[count];
        	totalCost += cost;
        	count++;
        for (int i = count-1; i > 0; i--){
        	int pos = i;
        	while (pos > 0 && (collection[pos-1].getDirector()).compareTo(collection[pos].getDirector()) > 0){ 
        		collection[pos] = collection[pos-1];
        		collection[pos-1] = temp;
        		pos--;
            }
         }
         }
        
        if (count == 0) {
          	 collection[count] = new DVD (title, director, year, cost, bluray);
          	 totalCost += cost;
          	 count++;
          	 }
    }
    
    int searchForDVD(String target) {
    	for (int i = 0; i < count-1; i++)
    		if (target.equalsIgnoreCase(collection[i].getDirector()))
    			return i;
    	return -1;
    }
        
     
    
    public String toString() {
        
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        
        String report = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        report += "My DVD Collection\n\n";
        report += "Number of DVDs: " + count + "\n";
        report += "Total cost: " + fmt.format(totalCost) + "\n";
        report += "Average cost: " + fmt.format(totalCost/count);
        report += "\n\nDVD List:\n\n";
        
        for (int dvd = 0; dvd < count; dvd++)
            report += collection[dvd].toString() + "\n";
            
        return report;
    }
    
    private void increaseSize() {
        
        DVD[] temp = new DVD[collection.length * 2];
        
        for (int dvd = 0; dvd < collection.length; dvd++)
            temp[dvd] = collection[dvd];
            
        collection = temp;
    }
}
