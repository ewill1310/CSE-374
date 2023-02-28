import java.util.*;

public class Solution {
	/**
	 * This method is called to sort the array by means of heap sort
	 * @param list - the given array
	 * @return a 2d array containing:
	 * a ascending sorted list and a descending sorted list
	 */
	public int[][] sort(int[] list) {
		int n = list.length;
		int[][] ans = new int[2][n];
		int[] copy = Arrays.copyOf(list, n);
		heapSort(list, true);
		ans[0] = list;
		heapSort(copy, false);
		ans[1] = copy;
		return ans;
	}

	/**
	 * This method will create a heap from the array and
	 * sort it through max or min heapification.
	 * @param arr - the given array
	 * @param flag - if true: ascending sort. if false: descending sort.
	 */
	void heapSort(int arr[], boolean flag) {
		int N = arr.length;
		for (int i = N / 2 - 1; i >= 0; i--) {
			if (flag) {
				maxHeapify(arr, N, i);
			} else {
				minHeapify(arr, N, i);
			}
		}
		for (int i = N - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			if(flag) {
				maxHeapify(arr, i, 0);
			}else {
				minHeapify(arr, i, 0);
			}
			
		}
	}

	/**
	 * This method sorts the made heap in an acscending way
	 * to where the greatest value is at the top.
	 * @param arr - The given array
	 * @param N - size of heap
	 * @param i - index in arr[]
	 */
	void maxHeapify(int arr[], int N, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < N && arr[l] > arr[largest]) {
			largest = l;
		}	
		if (r < N && arr[r] > arr[largest]) {
			largest = r;
		}
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			maxHeapify(arr, N, largest);
		}
	}
	
	/**
	 * This method sorts the made heap in an descending way
	 * to where the smallest value is at the top.
	 * @param arr - the given array
	 * @param N - size of heap
	 * @param i - index in arr[]
	 */
	void minHeapify(int arr[], int N, int i) {
		int smallest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < N && arr[l] < arr[smallest]) {
			smallest = l;
		}
		if (r < N && arr[r] < arr[smallest]) {
			smallest = r;
		}
		if (smallest != i) {
			int swap = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = swap;
			minHeapify(arr, N, smallest);
		}
	}
}