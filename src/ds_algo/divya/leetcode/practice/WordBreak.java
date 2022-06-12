package ds_algo.divya.leetcode.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

	public static boolean wordBreak(String s, List<String> wordDict) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		Set<String> set = new HashSet<String>();
		for (String str : wordDict) {
			set.add(str);
		}
		return wordMemo(s, set, map);
	}

	private static boolean wordMemo(String s, Set<String> wordDict , Map<String, Boolean> map) {
		if(s.length()==0) {
			return true;
		}
		if(map.containsKey(s)) {
			return map.get(s);
		}
		for(int i=1;i<=s.length();i++) {
			String temp = s.substring(0,i);
			if(wordDict.contains(temp)) {
				map.put(temp,true);
				if(wordMemo(s.substring(i), wordDict, map)){
					return true;
				}
			}
		}
		map.put(s,false);
		return map.get(s);
	}

	public static boolean word_recursive1(String s, List<String> wordDict, int index) {
		int n = s.length();
		if (n == index) {
			return true;
		}
		for (int i = index; i < s.length(); i++) {
			String temp = s.substring(index, i + 1);
			if (wordDict.contains(temp) && word_recursive1(s, wordDict, i + 1)) {
				return true;
			}
		}
		return false;
	}

	public static boolean word_recursive2(String s, List<String> wordDict) {
		if (s.length() == 0) {
			return true;
		}
		for (int i = 1; i <= s.length(); i++) {
			String temp = s.substring(0, i);
			if (wordDict.contains(temp)) {
				if (word_recursive2(s.substring(i), wordDict)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String s = "leetycode";
		String[] array = { "leet","code","leety"};
		System.out.println(wordBreak(s, Arrays.asList(array)));
		System.out.println(word_recursive2(s, Arrays.asList(array)));
	}

}
