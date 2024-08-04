package medium;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
		int lo = 0;
		int hi = arr.length-1;
		sort(arr,lo,hi);
		
		for(int i : arr) {
			System.out.print(i+" ");
		}

	}

	private static void sort(int[] arr, int lo, int hi) {
			if(lo<hi) {
				int mid = (hi+lo)/2;
				sort(arr,lo,mid);
				sort(arr,mid+1,hi);
				merge(arr,lo,mid,hi);
			}
		
	}

	private static void merge(int[] arr, int lo, int mid, int hi) {
		List<Integer> list = new ArrayList<>();
		int left = lo;
		int right = mid+1;
		
		while(left<=mid && right<=hi) {
			if(arr[left]<=arr[right]) {
				list.add(arr[left]);
				left++;
			}else{
				list.add(arr[right]);
				right++;
			}
		}
		
		while(left<=mid) {
			list.add(arr[left++]);
		}
		
		while(right<=hi) {
			list.add(arr[right++]);
		}
		
		for(int i=lo;i<=hi;i++) {
			arr[i] = list.get(i-lo);
		}
		
	}

}
