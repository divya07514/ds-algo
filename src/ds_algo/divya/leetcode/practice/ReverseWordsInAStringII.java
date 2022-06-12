package ds_algo.divya.leetcode.practice;

public class ReverseWordsInAStringII {

	public static void reverseWords(char[] s) {
		int left = 0;
		int right = 0;
		while (right < s.length) {
			char ch = s[right];
			if (ch == ' ') {
				reverse(left, right - 1, s);
				left = right + 1;
			}
			right++;
		}
		reverse(left, right - 1, s);
		reverse(0, s.length - 1, s);
	}

	public static void reverse(int i, int j, char[] s) {
		while (i <= j) {
			char ch = s[i];
			s[i] = s[j];
			s[j] = ch;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		char[] s = { 't', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e' };
		reverseWords(s);
	}

}
