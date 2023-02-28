//Copyright 2023 Evan Williams
import java.util.*;

public class Solution {
	/**
	 * This method will run insertion sort on a given array
	 * @param list the given array
	 * @param N the step number we want to return
	 * @return return the results of the Nth step in the sorting process
	 */
	public int[] insertionSort(int[] list,int N) { 
		int n = list.length;
		//This 2 dimensional array is there so we can keep track of the position of all the elements
		//and will be used to recall the wanted step
		int[][] steps = new int[(n*n)][n];
		//This integer will be used to assign a step number to the steps 2 dimensional array
		int step=0;
		//Loops through the array and sorts the array
		for (int i = 1; i < n; ++i) { 
			int key = list[i]; 
			int j = i - 1; 
			//loops through the array and places the element in the correct position
			while (j >= 0 && list[j] > key) { 
			    int temp=list[j+1];
				list[j + 1] = list[j]; 
				list[j]=temp;
				j = j - 1;
				//loops so it can place the elements positions in the 2 dimensional array for each shift
				for(int l=0;l<n;l++) {
				    steps[step][l]=list[l];
				}
				step++;
			} 
			list[j + 1] = key;
			//loops so it can place the elements positions in the 2 dimensional array for each comparison
			for(int l=0;l<n;l++) {
			    steps[step][l]=list[l];
			}
		} 
		//loops the original array so we can associate the positions of the elements at the Nth step
		for (int i = 0; i < n; ++i) {
			//Reassigns the arrays elements to the step we want
			//We do N-1 because an array starts at 0 and not 1
			//So the first step is locates at 0
			list[i] = steps[N-1][i];
		}
		//returns our array that is now holding the Nth steps results
		return list;
	}
	
	
}