package medium;

public class RobotBoundedInCircle {

	public boolean isRobotBounded(String ins) {

		int n = ins.length();
		if (n == 0) {
			return true;
		}

		char dir = 'N';
		int x = 0;
		int y = 0;

		for (int i = 0; i < n; i++) {
			char c = ins.charAt(i);
			if (c == 'L') {
				if (dir == 'N') {
					dir = 'W';
				} else if (dir == 'W') {
					dir = 'S';
				} else if (dir == 'S') {
					dir = 'E';
				} else {
					dir = 'N';
				}
			} else if (c == 'R') {
				if (dir == 'N') {
					dir = 'E';
				} else if (dir == 'E') {
					dir = 'S';
				} else if (dir == 'S') {
					dir = 'W';
				} else {
					dir = 'N';
				}
			} else {
				if (dir == 'N') {
					x = x + 1;
				} else if (dir == 'W') {
					y = y - 1;
				} else if (dir == 'E') {
					y = y + 1;
				} else {
					x = x - 1;
				}
			}
		}
		if (dir == 'N' && !(x == 0 && y == 0)) {
			return false;
		}
		return true;
	}

}
