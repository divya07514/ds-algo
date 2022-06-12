package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class KefaAndFirstSteps {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int count = scanner.nextInt();
		int[] values = new int[count];
		int index = 0;
		
		for(int i=0;i<count;i++) {
			values[index++] = scanner.nextInt();
		}
		
		int left = 0;
		int right = 1;
		
		int max = 1;
		int temp = 1;
		
		while(right < values.length) {
			if(values[left] <= values[right]) {
				temp++;
				max = Math.max(max, temp);
				right++;
				left++;
			}else {
				left=right;
				temp = 1;
				right++;
			}
		}

		System.out.println(max);
		scanner.close();
	}

}
