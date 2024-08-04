package easy;

public class PassThePillow {

	public int passThePillow(int n, int time) {

		if (n - 1 == time) {
			return n;
		}

		int count = 0;
		int i = n - 1;
		int idx = 1;
		while (i * idx < time) {
			count++;
			idx++;
		}
		int rem = time - i * count;
		int ans = 0;

		if (count % 2 == 0) {
			ans = 1 + rem;
		} else {
			ans = n - rem;
		}

		return ans;

	}

}
