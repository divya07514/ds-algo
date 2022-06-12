package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LetterCombinationOfPhoneNumber {

	public static List<String> letterCombinations(String digits) {
		if(digits.isEmpty()) {
			return new ArrayList<String>();
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("2", "abc");
		map.put("3", "def");
		map.put("4", "ghi");
		map.put("5", "jkl");
		map.put("6", "mno");
		map.put("7", "pqrs");
		map.put("8", "tuv");
		map.put("9", "wxyz");
		return combinations(digits, map);
	}

	private static List<String> combinations(String digits, Map<String, String> map) {
		List<String> result = new ArrayList<>();
		String[] input = new String[digits.length()];
		int index = 0;
		for (int i = 0; i < digits.length(); i++) {
			String s = String.valueOf(digits.charAt(i));
			input[i] = map.get(s);
		}
		Queue<String> q = new LinkedList<String>();
		String first = input[index++];
		for (int i = 0; i < first.length(); i++) {
			String s = String.valueOf(first.charAt(i));
			q.add(s);
		}
		if(input.length==1) {
			while(q.size() > 0) {
				result.add(q.poll());
			}
		}else {
			while (!q.isEmpty()) {
				if (index == input.length) {
					break;
				}
				int qs = q.size();
				String fromArray = input[index++];
				while (qs > 0) {
					String temp = q.poll();
					for (int i = 0; i < fromArray.length(); i++) {
						String s = String.valueOf(fromArray.charAt(i));
						String addition = temp + s;
						q.add(temp + s);
						if(addition.length()==input.length) {
							result.add(temp + s);
						}
					}
					qs--;
				}
			}	
		}

		return result;
	}

	public static void main(String[] args) {
		String digits = "234";
		System.out.println(letterCombinations(digits));

	}

}
