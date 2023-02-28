//Copyright 2023, Evan Williams
import java.util.*;

public class Solution {
	/**
	 * This method sorts the arrays in both a ascending and descending way
	 * @param list - the given array
	 * @return a double array containing ascending order and descending ordered arrays
	 */
	public int[][] mergeSort(int[] list) {
		int n = list.length;
		int[][] ans = new int[2][n];
		int[] copy = Arrays.copyOf(list, n);
		mergeSort(list, 0, n - 1, true);
		ans[0] = list;
		mergeSort(copy, 0, n - 1, false);
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
	void mergeSort(int[] list, int left, int right, boolean flag) {
		if (left >= right)
			return;
		int mid = (left + right) / 2;
		mergeSort(list, left, mid, flag);
		mergeSort(list, mid + 1, right, flag);
		merge(list, left, right, mid, flag);
	}

	/**
	 * The method called to merge the arrays back together
	 * @param list - the given array to be changed
	 * @param left - the left side of the array
	 * @param right - the right side of the array
	 * @param mid - the midpoint of the array
	 * @param flag - used to determine if we sort in an ascending or descending manner
	 */
	void merge(int[] list, int left, int right, int mid, boolean flag) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];
		for (int i = 0; i < n1; i++) {
			leftArray[i] = list[left + i];
		}
		for (int i = 0; i < n2; i++) {
			rightArray[i] = list[mid + 1 + i];
		}
		int i = 0, j = 0, k = left;
		if (flag) {
			while (i < n1 && j < n2) {
				if (leftArray[i] <= rightArray[j])
					list[k++] = leftArray[i++];
				else
					list[k++] = rightArray[j++];
			}
		}
		else {
			while (i < n1 && j < n2) {
				if (leftArray[i] >= rightArray[j])
					list[k++] = leftArray[i++];
				else
					list[k++] = rightArray[j++];
			}
		}
		while (i < n1)
			list[k++] = leftArray[i++];
		while (j < n2)
			list[k++] = rightArray[j++];
	}

	/**
	 * The helper method used to sort the array as it is being put back together
	 * @param a - the array to be sorted
	 * @param low - left side of array
	 * @param mid - midpoint of array
	 * @param high - right side of array
	 */
	void merge(int a[], int low, int mid, int high) {
		int n = high - low + 1;
		int[] sorted = new int[n];
		int left = low, right = mid + 1, index = 0;
		while (left <= mid && right <= high) {
			if (a[left] <= a[right]) {
				sorted[index++] = a[left++];
			} else {
				sorted[index++] = a[right++];
			}
		}
		while (left <= mid) {
			sorted[index++] = a[left++];
		}
		while (right <= high) {
			sorted[index++] = a[right++];
		}
		for (int k = 0; k < n; ++k) {
			a[low + k] = sorted[k];
		}
	}
}