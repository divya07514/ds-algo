package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class GameWithSticks {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		boolean akshat = true;
		
		while(n > 0 && m > 0) {
			if(akshat) {
				n--;
				m--;
				akshat = false;
			}else {
				n--;
				m--;
				akshat = true;
			}
			
		}
		
		if(akshat) {
			System.out.println("Malvika");
		}else {
			System.out.println("Akshat");
		}

	}

}
