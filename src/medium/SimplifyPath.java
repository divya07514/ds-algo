package medium;

import java.util.LinkedList;

public class SimplifyPath {

	public static String simplifyPath(String path) {

		if (path == null || path.length() == 0) {
			return path;
		}
		LinkedList<String> stack = new LinkedList();
		String[] array = path.split("/");
		for (String s : array) {
			if (s.isEmpty() || s.equals(".")) {
				continue;
			}
			if (s.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}

			} else {
				stack.push(s);
			}
		}
		String result = "";
		while (!stack.isEmpty()) {
			result = "/" + stack.pop() + result;
		}
		if (result.length() == 0) {
			return "/";
		}
		return result;
	}

	public static String simplifyPath_ext(String current, String changed) {
		if (changed == null || changed.isEmpty()) {
			return current;
		}
		LinkedList<String> stack = new LinkedList();
		if (changed.charAt(0) != '/') {
			String[] paths = current.split("/");
			for (String s : paths) {
				if (s.isEmpty())
					continue;
				stack.push(s);
			}
		}

		String[] paths = changed.split("/");
		for (String s : paths) {
			if (s.isEmpty() || s.equals(".")) {
				continue;
			}
			if (s.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(s);
			}
		}
		if (stack.isEmpty()) {
			return "/";
		}
		String result = "";
		while (!stack.isEmpty()) {
			result = "/" + stack.pop() + result;
		}

		return result;
	}

	public static void main(String[] args) {
		String path = "/../";
		System.out.println(simplifyPath(path));

		System.out.println(simplifyPath_ext("/", "/facebook"));
		System.out.println(simplifyPath_ext("/facebook/anin", "../abc/def"));
		System.out.println(simplifyPath_ext("/facebook/instagram", "../../../.././bob"));

	}

}
