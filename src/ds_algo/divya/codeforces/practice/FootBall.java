package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

// eg : 11110111011101
public class FootBall {

	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		String input = scanner.nextLine();
		int left = 0;
		int right = 0;
		boolean situation =  false;
		while(right < input.length()) {
			if(input.charAt(left)==input.charAt(right)) {
				if(right - left + 1 >=7) {
					situation = true;
					break;
				}
				right++;
			}else {
				left=right;
			}
		}
		if(situation) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

}
