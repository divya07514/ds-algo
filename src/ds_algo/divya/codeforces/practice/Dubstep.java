package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class Dubstep {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String s = scanner.nextLine();
		
		String[] array = s.split("WUB");
		
		StringBuilder sb = new StringBuilder();
		
		for(String str : array) {
			if(!str.isEmpty()) {
				sb.append(str).append(" ");
			}
		}

		String result = sb.toString().trim();
		System.out.println(result);
	}

}
