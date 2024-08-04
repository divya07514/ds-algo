package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {

	public static String[] findRestaurant(String[] a, String[] b) {
		Map<String, Integer> mapa = getMap(a);
		Map<String, Integer> mapb = getMap(b);
		List<String> list = new ArrayList<>();
		int max = Integer.MAX_VALUE;
		for (String s : mapa.keySet()) {
			if (mapb.containsKey(s)) {
				int sum = mapa.get(s) + mapb.get(s);
				if (sum < max) {
					list.clear();
					list.add(s);
					max = sum;
				} else if (sum == max) {
					list.add(s);
				}
			}
		}
		String[] result = new String[list.size()];
		int index = 0;
		for (String s : list) {
			result[index++] = s;
		}
		return result;
	}

	private static Map<String, Integer> getMap(String[] array) {
		Map<String, Integer> map = new HashMap();
		for (int i = 0; i < array.length; i++) {
			map.put(array[i], i);
		}
		return map;
	}

	public static void main(String[] args) {
		String[] list1 = new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" };
		String[] list2 = new String[] { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };
		System.out.println(findRestaurant(list1, list2));

	}

}
