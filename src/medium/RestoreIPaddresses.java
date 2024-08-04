package medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPaddresses {
	static List<String> result;
	static int len;

	public static List<String> restoreIpAddresses(String s) {

		result = new ArrayList();
		len = s.length();
		if (len == 0) {
			return result;
		}
		getIps(s, 0, "", 0);
		return result;
	}

	private static void getIps(String s, int index, String ip, int dots) {
		if (dots == 3) {
			if (isValid(s.substring(index))) {
				ip = ip + s.substring(index);
				result.add(ip);
			}
			return;
		}

		for (int i = index; i < len; i++) {
			String current = s.substring(index, i + 1);
			if (isValid(current)) {
				int currentLen = current.length();
				ip = ip + current + ".";
				getIps(s, i + 1, ip, dots + 1);
				ip = ip.substring(0, ip.length() - currentLen - 1);
			}
		}
	}

	private static boolean isValid(String s) {
		if (s.length() > 3 || s.length() == 0) {
			return false;
		}
		if (s.length() >1 && s.charAt(0) == '0') {
			return false;
		}
		if (s.length() >0 && Integer.parseInt(s) > 255) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "101023";
		System.out.println(restoreIpAddresses(s));

	}

}
