package ds_algo.divya.codeforces.practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringTask {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		String input = s.nextLine();
		
		char[] array = input.toCharArray();
		
		Set<Character> set = new HashSet<Character>();
		set.add('A');
		set.add('O');
		set.add('Y');
		set.add('E');
		set.add('U');
		set.add('I');
		set.add('a');
		set.add('o');
		set.add('y');
		set.add('e');
		set.add('u');
		set.add('i');
		
		for(int i=0;i<array.length;i++) {
			char ch =array[i];
			if(set.contains(ch)){
				array[i] = '@';
			}else {
				array[i] =  Character.toLowerCase(ch);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char c : array) {
			if(c!='@') {
				sb.append(".").append(c);
			}
		}
		System.out.println(sb.toString());
	}

}
