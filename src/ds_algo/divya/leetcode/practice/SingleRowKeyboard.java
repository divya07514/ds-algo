package ds_algo.divya.leetcode.practice;

public class SingleRowKeyboard {

	public static int calculateTime(String keyboard, String word) {
		if (keyboard.isEmpty() || word.isEmpty()) {
			return 0;
		}
		
		int time =0;
		int start = 0;
		
		for(int i=0;i<word.length();i++) {
			int index = keyboard.indexOf(word.charAt(i));
			time = Math.abs(index-start)+ time;
			start = index;
		}
		
		return time;
	}

	public static void main(String[] args) {
		String keyboard = "pqrstuvwxyzabcdefghijklmno";
		String word = "leetcode";
		System.out.println(calculateTime(keyboard, word));
	}

}
