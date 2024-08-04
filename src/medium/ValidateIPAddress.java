package medium;

public class ValidateIPAddress {

	public String validIPAddress(String ip) {
		if (ip.length() == 0) {
			return "Neither";
		}
		boolean v4 = false;
		boolean v6 = false;
		if (ip.contains(".")) {
			v4 = checkV4(ip);
		} else {
			v6 = checkV6(ip);
		}
		if (!v4 && !v6) {
			return "Neither";
		}
		if (v4) {
			return "IPv4";
		}
		return "IPv6";
	}

	private boolean checkV4(String ip) {
		if (ip.charAt(ip.length() - 1) == '.') {
			return false;
		}
		String[] array = ip.split("\\.");

		if (array.length != 4) {
			return false;
		}
		for (String s : array) {
			if (s.length() == 0)
				return false;
			if (s.charAt(0) == '0' && s.length() > 1) {
				return false;
			}
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (!Character.isDigit(c)) {
					return false;
				}
			}
			if (s.length() > 10) {
				return false;
			}
			int n = Integer.parseInt(s);
			if (n < 0 || n > 255) {
				return false;
			}
		}
		return true;
	}

	private boolean checkV6(String ip) {
		if (ip.charAt(ip.length() - 1) == ':') {
			return false;
		}
		String[] array = ip.split(":");
		System.out.println(array.length);
		if (array.length != 8) {
			return false;
		}
		for (String s : array) {
			if (s.length() == 0)
				return false;
			int n = s.length();
			if (n < 1 || n > 4) {
				return false;
			}
			for (int i = 0; i < n; i++) {
				char c = s.charAt(i);
				if (!Character.isDigit(c)) {
					char ch = s.charAt(i);
					String temp = c + "";
					String upper = temp.toUpperCase();
					c = upper.charAt(0);
					if (c < 'A' || c > 'F') {
						return false;
					}
				}
			}
		}

		return true;
	}

}
