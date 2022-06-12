package ds_algo.divya.codeforces.practice;

import java.util.Arrays;
import java.util.Scanner;

public class GravityFlip {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int size = scanner.nextInt();
		int[] nums = new int[size];
		int index = 0;
		for(int i=0;i<size;i++) {
			nums[index++] =scanner.nextInt();
		}
		Arrays.sort(nums);
		
		for(int i : nums) {
			System.out.print(i+" ");
		}
		
		scanner.close();
	}

}
