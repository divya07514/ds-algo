package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {

	String characters;
	int length;
	List<String> result;

	public CombinationIterator(String characters, int combinationLength) {
		this.characters = characters;
		this.length = combinationLength;
		this.result = new ArrayList<String>();
		generateStrings(result, characters, length, 0, "");
	}

	private void generateStrings(List<String> result, String s, int length, int index, String temp) {

		if (temp.length() == length) {
			result.add(temp);
			return;
		}
		if (index >= s.length()) {
			return;
		}

		temp = temp + s.charAt(index);
		generateStrings(result, s, length, index + 1, temp);
		temp = temp.substring(0, temp.length() - 1);
		generateStrings(result, s, length, index + 1, temp);

	}

	public String next() {
		return result.remove(0);
	}

	public boolean hasNext() {
		return result.size() > 0;
	}

	public static void main(String[] args) {
		CombinationIterator obj = new CombinationIterator("abc", 2);
		obj.hasNext();
	}

}
