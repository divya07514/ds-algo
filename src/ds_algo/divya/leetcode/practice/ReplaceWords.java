package ds_algo.divya.leetcode.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {

	public static String replaceWords(List<String> dict, String sentence) {
		if(sentence.isEmpty()) {
			return "";
		}
		if(dict==null || dict.size()==0) {
			return sentence;
		}
		Set<String> set = new HashSet<String>();
		for (String str : dict) {
			set.add(str);
		}
		StringBuilder sb = new StringBuilder();
		String[] array = sentence.split(" ");
		for (int i = 0; i < array.length; i++) {
			String temp = array[i];
			String substr = "";
			for (int j = 0; j <= temp.length(); j++) {
				substr = temp.substring(0, j);
				if (set.contains(substr)) {
					break;
				}
			}
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(substr);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] dict = { "cat", "bat", "rat" };
		String sentence = "the cattle was rattled by the battery";
		System.out.println(replaceWords(Arrays.asList(dict), sentence));

	}

}
