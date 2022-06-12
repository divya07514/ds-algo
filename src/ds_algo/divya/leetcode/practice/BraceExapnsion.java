package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BraceExapnsion {

	public static String[] expand(String S) {

		List<List<String>> lists = new ArrayList<>();
		char[] arr = S.toCharArray();
		StringBuilder sb = new StringBuilder();
		getStringList(lists, arr, sb, new ArrayList<String>());

		List<String> result = new ArrayList<>();
		sb = new StringBuilder();
		dfs(lists, 0, sb, result);
		
		String[] array = new String[result.size()];
		Collections.sort(result);
		int i = 0;
		for(String s : result) {
			array[i++] = s;
		}
		return array;
	}

	private static void dfs(List<List<String>> lists, int index, StringBuilder sb, List<String> result) {
		if (index == lists.size()) {
			result.add(sb.toString());
			return;
		}
		List<String> temp = lists.get(index);
		for (String s : temp) {
			StringBuilder builder = new StringBuilder(sb);
			builder.append(s);
			dfs(lists, index + 1, builder, result);
		}

	}

	private static void getStringList(List<List<String>> lists, char[] arr, StringBuilder sb, List<String> list) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '{') {
				if (sb.length() > 0) {
					list.add(sb.toString());
					lists.add(list);
					list = new ArrayList<>();
					sb = new StringBuilder();
				}
				i++;
				while (arr[i] != '}') {
					if (arr[i] != ',') {
						sb.append(arr[i]);
					} else {
						list.add(sb.toString());
						sb = new StringBuilder();
					}
					i++;
				}
				list.add(sb.toString());
				lists.add(list);
				list = new ArrayList<>();
				sb = new StringBuilder();
			} else {
				sb.append(arr[i]);
				if (i == arr.length - 1) {
					list.add(sb.toString());
					lists.add(list);
					list = new ArrayList<>();
					sb = new StringBuilder();
				}
			}
		}
	}

	public static void main(String[] args) {
		String S = "{a,b}c{d,e}";
		System.out.println(expand(S));
	}

}
