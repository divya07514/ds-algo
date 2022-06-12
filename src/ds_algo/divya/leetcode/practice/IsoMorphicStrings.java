package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsoMorphicStrings {

	public static boolean isIsomorphic(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		Map<Character, Character> maps = new HashMap<>();
		Set<Character> set = new HashSet<Character>();
		int i = 0;
		while (i < s.length()) {
			char sch = s.charAt(i);
			if(!maps.containsKey(sch)) {
				char tch = t.charAt(i);
				if(!set.contains(tch)) {
					maps.put(sch, tch);
					set.add(tch);
				}else {
					return false;
				}
				
			}else {
				if(maps.get(sch)!=t.charAt(i)) {
					return false;
				}
			}
			i++;
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "egg";
		String t = "add";
		System.out.println(isIsomorphic(s, t));
	}

}
