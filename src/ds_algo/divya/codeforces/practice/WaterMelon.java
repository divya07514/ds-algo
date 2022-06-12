package ds_algo.divya.codeforces.practice;

import java.util.Scanner;


public class WaterMelon {
	
	public static void solution(int input) {
		if(input%2==0 && input!=2) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		solution(input);
	}

}
