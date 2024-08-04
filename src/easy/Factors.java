package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Factors {

	public static long pthFactor(long n, long p) {
		List<Long> list = new ArrayList<Long>();
		long sqrt = (long) Math.sqrt(n);
		for (long i = 1; i <= sqrt; i++) {
			if (n % i == 0) {
				list.add(i);
				if (i != sqrt) {
					list.add(n / i);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list);
		int index = (int) (p);
		if (list.size() < index) {
			return 0;
		}
		index = index - 1;
		long result = list.get(index);
		return result;
	}

	public static void main(String[] args) {
		long n = 1048576;
		long p = 12;
		System.out.println(pthFactor(n, p));

	}

}
