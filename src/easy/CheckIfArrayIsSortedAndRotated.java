package easy;

import java.util.ArrayList;
import java.util.List;

public class CheckIfArrayIsSortedAndRotated {
	
	public static List<Integer> getRegions(List<String> list) {
		
		List<Integer> result = new ArrayList<>();
		for (String ip : list) {
			String[] array = ip.split("\\.");
			System.out.println(array[0]);
			int start = Integer.parseInt(array[0]);
			int one = Integer.parseInt(array[1]);
			int two = Integer.parseInt(array[2]);
			int three = Integer.parseInt(array[3]);
			if (start >= 0 && start <= 127) {
				if (!checkRange(one) || !checkRange(two) || !checkRange(three)) {
					result.add(-1);
				} else {
					result.add(1);
				}
			} else if (start >= 128 && start <= 191) {
				if (!checkRange(one) || !checkRange(two) || !checkRange(three)) {
					result.add(-1);
				} else {
					result.add(2);
				}
			} else if (start >= 192 && start <= 223) {
				if (!checkRange(one) || !checkRange(two) || !checkRange(three)) {
					result.add(-1);
				} else {
					result.add(3);
				}
			} else if (start >= 224 && start <= 239) {
				if (!checkRange(one) || !checkRange(two) || !checkRange(three)) {
					result.add(-1);
				} else {
					result.add(4);
				}
			} else if (start >= 240 && start <= 255) {
				if (!checkRange(one) || !checkRange(two) || !checkRange(three)) {
					result.add(-1);
				} else {
					result.add(5);
				}
			} else {
				result.add(-1);
			}
		}
		return result;
	}

	private static boolean checkRange(int i) {
		if (i >= 0 && i <= 255) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList();
		list.add("123.211.102.13");
		System.out.println(getRegions(list));

	}

}
