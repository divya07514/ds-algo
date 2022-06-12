package ds_algo.divya.leetcode.practice;

public class MinimumRemovetoMakeValidParentheses {

	public static String minRemoveToMakeValid(String s) {
		if(s==null) {
			return null;
		}
		if(s.isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int open = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				open++;
			} else if (ch == ')') {
				if (open == 0) {
					continue;
				}
				open--;
			}
			sb.append(ch);
		}
        System.out.println(sb);
		StringBuilder res = new StringBuilder();
		for (int i = sb.length() - 1; i >= 0; i--) {
			char ch = sb.charAt(i);
			if (ch == '(' && open-- > 0) {
				continue;
			}
			res.append(ch);
		}
		return res.reverse().toString();
	}

	public static void main(String[] args) {
		String s = "())()(((";
		System.out.println(minRemoveToMakeValid(s));

	}

}
