package ds_algo.divya.codeforces.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Snacktower {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int max = n;
		Set<Integer> present = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			int current = nums[i];
			if (current == max) {
				System.out.print(max--+" ");
				while (present.contains(max)) {
					System.out.print(max--+" ");
				}
			} else {
				present.add(current);
			}
			if(i<n-1) {
				System.out.println("");
			}
		}

	}

}
