package medium;

public class CountAndSay {
	public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		String start = "1";
		for (int i = 0; i < n - 1; i++) {
			start = generate(start);
		}
		return start;
	}

	private String generate(String start) {

		StringBuilder sb = new StringBuilder();
		char c = start.charAt(0);
		int count = 1;

		for (int i = 1; i < start.length(); i++) {
			char next = start.charAt(i);
			if (c == next) {
				count++;
			} else {
				sb.append(count);
				sb.append(c);
				c = next;
				count = 1;
			}
		}
		sb.append(count);
		sb.append(c);
		return sb.toString();
	}
}
