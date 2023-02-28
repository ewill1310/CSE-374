// Copyright 2023 Evan Williams
import java.util.ArrayList;

public class tester {

	public static void main(String[] args) {
		int[] list = {12, 11, 13, 5, 6};
		list = insertionSort(list, 6);
		for(int i : list) {
			System.out.print(i + ",");
		}
		System.out.println("");
	}
	
	/**
	 * This method will sort the given array by means of insertion
	 * @param list - the given array
	 * @param N - 
	 * @return
	 */
	@SuppressWarnings("null")
	public static int[] insertionSort(int[] list,int N) { 
		int n = list.length;
		int[][] ans = new int[(n*n)][n];
		int k=0;
		for (int i = 1; i < n; ++i) { 
			int key = list[i]; 
			int j = i - 1; 

			while (j >= 0 && list[j] > key) 
			{ 
			    int temp=list[j+1];
				list[j + 1] = list[j]; 
				list[j]=temp;
				j = j - 1;
				for(int l=0;l<n;l++)
				{
				    ans[k][l]=list[l];
				}
				k++;
			} 
			list[j + 1] = key;
			for(int l=0;l<n;l++)
			{
			    ans[k][l]=list[l];
			}
		} 
		for (int i = 0; i < n; ++i) {
			list[i] = ans[N-1][i];
		}
		return list;
	}

}
