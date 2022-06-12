package ds_algo.divya.codeforces.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Taxi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int next = sc.nextInt();
			if (next == 4) {
				count++;
			} else {
				list.add(next);
			}
		}
		Collections.sort(list);
		int left = 0;
		int right = list.size() - 1;
		while (left < right) {
			int sum = list.get(left) + list.get(right);
			if (sum == 4) {
				count++;
				left++;
				right--;
			} else if (sum > 4) {
				right--;
				count++;
			} else {
				while (sum <= 4 && left + 1 < list.size()) {
					sum = sum + list.get(++left);
				}
				count++;
				right--;
			}
		}
		if (left > right) {
			System.out.println(count);
		} else {
			System.out.println(count + 1);
		}
	}

}
