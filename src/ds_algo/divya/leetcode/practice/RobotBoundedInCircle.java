package ds_algo.divya.leetcode.practice;

public class RobotBoundedInCircle {

	public static boolean isRobotBounded(String s) {

		String direction = "N";
		int x = 0;
		int y = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'G') {
				if (direction.equals("N")) {
					y = y + 1;
				}
				if (direction.equals("S")) {
					y = y - 1;
				}
				if (direction.equals("E")) {
					x = x + 1;
				}
				if (direction.equals("W")) {
					x = x - 1;
				}
			} else if (c == 'L') {
				if (direction.equals("N")) {
					direction = "W";
				}
				else if (direction.equals("S")) {
					direction = "E";
				}
				else if (direction.equals("E")) {
					direction = "N";
				}
				else if (direction.equals("W")) {
					direction = "S";
				}
			} else {
				if (direction.equals("N")) {
					direction = "E";
				}
				else if (direction.equals("S")) {
					direction = "W";
				}
				else if (direction.equals("E")) {
					direction = "S";
				}
				else if (direction.equals("W")) {
					direction = "N";
				}
			}
		}
		System.out.print(x + " " + y);
		if ((x == 0 && y == 0) || !direction.equals("N")) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String instructions = "GGRGGRGGRGGR";
		System.out.println(isRobotBounded(instructions));

	}

}
