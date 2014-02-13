package cs152;

import java.util.Random;
import java.util.ArrayList;

public class Algotest {
	
	public static void main(String[] args) {
		
		Random genRands = new Random();
		int arrayLength = genRands.nextInt(10);
		int[] sortMe = new int[arrayLength];
		
		// populate array with random integers
		for (int i = 0; i < sortMe.length; i++){
			sortMe[i] = genRands.nextInt(30);
			// System.out.println(sortMe[i]);
		}
		
		int arraySize = sortMe.length;
		int key = sortMe[genRands.nextInt(arrayLength)];
		
		// print contents of the array pre-sorting
		for (int index : sortMe)
			System.out.print(index + "\t");
		
		// SelectSort(sortMe);
		System.out.println();
		System.out.println("The key is " + key);
		
		// print contents of the array post-sorting
		//for (int index : sortMe)
		//	System.out.print(index + "\t");
		LinearSearch(sortMe, arrayLength, key);
	}
	
	public static void SelectSort (int[] array) { // least to greatest
		int min, temp, size;
		size = array.length;
		for (int index = 0; index < size-1; index++){ // size-1 because if n-1 are correctly sorted, the last position sorted too.
			min = index; // starts by assuming the smallest number is at index 0
			for (int scan = index + 1; scan < size; scan++){ // starts comparing all the numbers after the index location in outer loop
				if (array[scan] < array[min]) // checks every position against current min
					min = scan; // updates min-index tracker if scan is smaller than current min
			} // min now holds the index of the smallest integer in the array
			temp = array[min]; // stores current smallest integer
			array[min] = array[index]; // wherever the smallest is located it gets assigned the the value at the current "start position"
			array[index] = temp; // current "start position" now holds smallest value from previous scan
		}
	} // end SelectSort method
	public static void InsertSort (int[] array) {
		int size = array.length;
		for (int index = 1; index < size; index++) {
			int key = array[index];
			int position = index;
			
			while (position > 0 && array[position-1] > key) {
				array[position] = array[position-1];
				position--;
			}
			array[position] = key;
		}
	} // end InsertSort method
	public static void LinearSearch (int[] array, int size, int keyy) {
		
		ArrayList<Integer> locs = new ArrayList<Integer>();
		boolean flag = false;
		
		for (int index = 0; index < size; index++){
			if (array[index] == keyy){
				locs.add(index);
				flag = true;
			}
		}
		if (flag)
			for (Integer x : locs)
				System.out.print( x + " ");
		else
			System.out.println("The search key was not located");
	}


} // end class
