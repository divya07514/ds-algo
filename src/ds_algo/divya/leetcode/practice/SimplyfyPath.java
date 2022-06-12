package ds_algo.divya.leetcode.practice;

import java.util.Deque;
import java.util.LinkedList;

public class SimplyfyPath {

	public static String simplifyPath(String path) {
		Deque<String> deque = new LinkedList<String>();
		deque.push("/");
		String[] dirs = path.split("/");
		for (String dir : dirs) {
			if (dir.isEmpty() || dir.equals(".")) {
				continue;
			}
			if (dir.equals("..")) {
				if (!deque.isEmpty())
					deque.pollLast();
			} else {
				deque.offerLast(dir);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!deque.isEmpty()) {
			String cur = deque.pollFirst();
			if (!cur.equals("/"))
				sb.append("/").append(cur);
		}
		if (sb.length() == 0) {
			sb.append("/");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String path = "/a/../../b/../c//.//";
		System.out.println(simplifyPath(path));
	}
}
