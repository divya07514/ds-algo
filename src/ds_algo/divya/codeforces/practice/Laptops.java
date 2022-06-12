package ds_algo.divya.codeforces.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Laptops {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int count = sc.nextInt();
		List<LaptopPair> list = new ArrayList<LaptopPair>();
		for (int i = 0; i < count; i++) {

			int p = sc.nextInt();
			int q = sc.nextInt();
			list.add(new LaptopPair(p, q));

		}

		Comparator<LaptopPair> c = (a, b) -> a.price - b.price;
		Collections.sort(list, c);

		boolean found = false;
		for (int i = 0; i < list.size() - 1; i++) {
			LaptopPair one = list.get(i);
			LaptopPair two = list.get(i + 1);
			if (one.price < two.price && one.quality > two.quality) {
				found = true;
				break;
			}

		}
		if (found) {
			System.out.println("Happy Alex");
		} else {
			System.out.println("Poor Alex");
		}
	}

}

class LaptopPair {

	int price;
	int quality;

	public LaptopPair(int price, int quality) {
		super();
		this.price = price;
		this.quality = quality;
	}

}
