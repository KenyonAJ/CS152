package cs152;


public class Sorting
{
   public static void bubbleSortRecursive ( Comparable[] list, int n ) {
       
	   Comparable temp;
       if ( n == 0 || n == 1 ) 
        return;
       else {
    	   for ( int i = n-2; i >= 0; i-- ) {
    	      if (list[i].compareTo(list[i+1]) > 0) {
    	    	  temp = list[i];
    	    	  list[i] = list[i+1];
    	    	  list[i+1] = temp;
    	      }
    	      bubbleSortRecursive(list, n-1);
    	   }
    	}
   }
   
    public static void selectionSortRecursive ( Comparable[] list, int n ) {
        
        if (n == 0 || n == 1)
        	return;
        int max = n-1;
        for (int i = n-2; i >= 0; i--) {
        	if (list[i].compareTo(list[max]) > 0)
        		max = i;
        }
        Comparable temp = list[n-1];
        list[n-1] = list[max];
        list[max] = temp;
        selectionSortRecursive (list, n-1);
    }
    
    public static void selectionSort (Comparable[] list){
    	int min;
    	Comparable temp;
    	
    	for (int index = 0; index < list.length-1; index++){
    		min = index;
    		for (int scan = index+1; scan < list.length; scan++)
    			if (list[scan].compareTo(list[min]) < 0)
    				min = scan;
    		temp = list[min];
    		list[min] = list[index];
    		list[index] = temp;
    	}
    }
}
    
    
        
