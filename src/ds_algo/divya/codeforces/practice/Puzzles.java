package ds_algo.divya.codeforces.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Puzzles {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m =  scanner.nextInt();
		int[] values = new int[m];
		int index = 0;
		for(int i=0;i<m;i++) {
			values[index++] = scanner.nextInt();
		}
		Arrays.sort(values);
		int left  = 0;
		int right = n-1;
		int min = Integer.MAX_VALUE;
		while(right < m) {
			
			min = Math.min(min, values[right] - values[left]);
			left++;
			right++;
		}
		System.out.println(min);
		scanner.close();
	}

}
