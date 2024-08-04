package easy;

public class AddStrings {

	public static String addStrings(String str1, String str2) {
		String[] parts1 = splitNumber(str1);
		String[] parts2 = splitNumber(str2);

		String[] fracResult = addFractionalParts(parts1[1], parts2[1]);

		String intPart = addIntegerParts(parts1[0], parts2[0], fracResult[1]);

		return intPart + "." + fracResult[0];
	}

	private static String[] splitNumber(String str) {
		String[] parts = str.split("\\.");
		if (parts.length == 1) {
			return new String[] { parts[0], "0" };
		}
		return parts;
	}

	private static String addIntegerParts(String one, String two, String carryOver) {
		StringBuilder sb = new StringBuilder();
		int i = one.length() - 1;
		int j = two.length() - 1;
		int carry = Integer.parseInt(carryOver);
		while (i >= 0 || j >= 0) {
			int a = i >= 0 ? one.charAt(i--) - '0' : 0;
			int b = j >= 0 ? two.charAt(j--) - '0' : 0;

			int sum = a + b + carry;
			sb.insert(0, sum % 10);
			carry = sum / 10;
		}

		if (carry == 1) {
			sb.insert(0, 1);
		}

		return sb.toString();
	}

	private static String[] addFractionalParts(String frac1, String frac2) {
		int length = Math.max(frac1.length(), frac2.length());
		StringBuilder sb = new StringBuilder();

		int carry = 0;
		for (int i = length - 1; i >= 0; i--) {
			int digit1 = i < frac1.length() ? frac1.charAt(i) - '0' : 0;
			int digit2 = i < frac2.length() ? frac2.charAt(i) - '0' : 0;

			int sum = digit1 + digit2 + carry;
			sb.insert(0, sum % 10);
			carry = sum / 10;
		}

		return new String[] { sb.toString(), Integer.toString(carry) };
	}

	public static void main(String[] args) {
		String one = "17.91";
		String two = "1718.821";
		System.out.println(addStrings(one, two));

	}

}
