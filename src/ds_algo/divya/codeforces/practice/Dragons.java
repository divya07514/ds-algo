package ds_algo.divya.codeforces.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Dragons {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int s = sc.nextInt();
			int n = sc.nextInt();
			Map<Integer,List<Integer>> map = new TreeMap<>();
			for(int i=0;i<n;i++) {
				int key = sc.nextInt();
				int value = sc.nextInt();
				if(!map.containsKey(key)) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(value);
					map.put(key, list);
				}else {
					map.get(key).add(value);
				}
			}
			String result ="";
			boolean lost = false;
			for(int i : map.keySet()) {
				if(i < s) {
					for(int str : map.get(i)) {
						s = s + str;
					}
				}else {
					lost = true;
					break;
				}
			}
			if(lost) {
				result  = "NO";
			}else {
				result = "YES";
			}
			System.out.println(result);
	}

}
