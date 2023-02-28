import java.util.*;

public class Solution {
	/**
	 * This method is called to sort the given array in both a ascending and descending manner
	 * @param list - the given array
	 * @return a 2d array that contains the 2 sorted arrays
	 */
	public int[][] sort(int[] list) { 
		int n = list.length;
		int[][] ans = new int[2][n];
		int[] copy = Arrays.copyOf(list, n);
		quickSort(list, 0, n-1, true);
		ans[0] = list;
		quickSort(copy, 0, n-1, false);
		ans[1] = copy;
		return ans;
	}

	/**
	 * This is the method called to sort the given array
	 * @param list - the given array
	 * @param left - the beginning of the array
	 * @param right- the end of the array
	 * @param flag - determines if we sort in a descending or ascending manner
	 */
	void quickSort(int[] list, int low, int high, boolean flag) {
		if (low < high)
        {
			int pi = 0;
			if(flag) {
				pi = partitionAsc(list, low, high);
			}else if(!flag) {
				pi = partitionDesc(list, low, high);
			}
            quickSort(list, low, pi-1, flag);
            quickSort(list, pi+1, high, flag);
        }
	}
	
	/**
	 * This method creates the partition for the array and sorts it in a ascending manner
	 * @param arr - given array
	 * @param low - the left side of array
	 * @param high - the right side of array
	 * @return an int that was the partition
	 */
	int partitionAsc(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
	
	/**
	 * This method creates the partition for the array and sorts it in a descending manner
	 * @param arr - given array
	 * @param low - the left side of array
	 * @param high - the right side of array
	 * @return an int that was the partition
	 */
	int partitionDesc(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            // If current element is larger than or
            // equal to pivot
            if (arr[j] >= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}