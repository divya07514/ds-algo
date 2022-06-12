package ds_algo.divya.codeforces.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SubstringsSort {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		List<String > list = new ArrayList<String>();
		for (int i = 0; i <= n; i++) {
			list.add(sc.nextLine());
		}
		list.remove(0);
		
		Comparator<String> c = (a,b) -> a.length() - b.length();
		Collections.sort(list, c);
		
		boolean result = true;
		
		for(int i=0;i<list.size()-1;i++) {
			String two = list.get(i+1);
			String one = list.get(i);
			
			if(!two.contains(one)) {
				result = false;
				break;
			}
		}
		
		if(result) {
			System.out.println("YES");
			for(String s : list) {
				System.out.println(s);
			}
		}else {
			System.out.println("NO");
		}

	}

}
