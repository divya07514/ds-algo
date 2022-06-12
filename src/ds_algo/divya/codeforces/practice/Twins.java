package ds_algo.divya.codeforces.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Twins {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int coins = scanner.nextInt();
		List<Integer> values = new ArrayList<>();
		for (int i = 0; i < coins; i++) {
			values.add(scanner.nextInt());
		}

		Collections.sort(values);

		int total = 0;
		for (int i : values) {
			total = total + i;
		}

		int current = 0;
		int result = 0;

		for (int i = values.size() - 1; i >= 0; i--) {
			current = current + values.get(i);
			total = total - values.get(i);
			if (current > total) {
				result++;
				break;
			}
			result++;
		}

		System.out.println(result);
		scanner.close();
	}

}
