package medium;

import java.util.LinkedList;

public class MinimumTimetoMakeRopeColorful {

	public int minCost(String colors, int[] time) {
		int n = colors.length();
		if (n == 0) {
			return 0;
		}
		LinkedList<PPair> stack = new LinkedList();
		int result = 0;
		for (int i = 0; i < n; i++) {
			char c = colors.charAt(i);
			int t = time[i];
			PPair p = new PPair(c, t);

			if (stack.isEmpty()) {
				stack.push(p);
			} else {
				PPair top = stack.peek();
				if (top.c != p.c) {
					stack.push(p);
				} else {
					if (top.t < p.t) {
						result = result + top.t;
						stack.pop();
						stack.push(p);
					} else {
						result = result + p.t;
					}
				}
			}
		}

		return result;
	}

}
class PPair {
    char c;
    int t;

    public PPair(char c, int t){
        this.c = c;
        this.t=t;
    }

    public String toString(){
        return c+", "+t;
    }
}