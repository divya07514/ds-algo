package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class ShovelsAndSwords {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		int t= sc.nextInt();
		
		for(int i=0;i<t;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int result = Math.min(a, Math.min(b, (a+b)/3));
			System.out.println(result);
		}
	}

}
