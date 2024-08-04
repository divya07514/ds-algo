package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Mfst_1 {

	public static int solution(int N, int[] one, int[] two) {

		Map<Integer, Tuple> map = new HashMap<>();

		for (int i = 0; i < one.length; i++) {
			int a = one[i];
			int b = two[i];

			if (!map.containsKey(a)) {
				List<Integer> list = new ArrayList();
				list.add(b);
				Tuple p = new Tuple(a, list);
				map.put(a, p);
			} else {
				map.get(a).list.add(b);
			}

			if (!map.containsKey(b)) {
				List<Integer> list = new ArrayList();
				list.add(a);
				Tuple p = new Tuple(b, list);
				map.put(b, p);
			} else {
				map.get(b).list.add(a);
			}
		}

		List<Tuple> list = new ArrayList();
		for (int i : map.keySet()) {
			list.add(map.get(i));
		}

		Comparator<Tuple> c = (a, b) -> b.list.size() - a.list.size();
		Collections.sort(list, c);
		int index = 0;

		while (index < list.size()) {
			Tuple p = list.get(index);
			p.score = N;
			N--;
			index++;
		}

		int result = 0;

		Set<String> set = new HashSet();

		for (Tuple t : list) {
			if (t.list.size() > 0) {
				List<Integer> temp = t.list;
				int current = t.node;
				for (int i : temp) {
					String key1 = current + ", " + i;
					String key2 = i + ", " + current;
					if (!set.contains(key2) && !set.contains(key1)) {
						result = result + t.score + map.get(i).score;
						set.add(key2);
						set.add(key1);
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int N = 5;
		int[] one = { 2, 2, 1, 2 };
		int[] two = { 1, 3, 4, 4 };
		System.out.println(solution(N, one, two));

	}

}

class Tuple {

	public int node;
	public List<Integer> list;
	public int score;

	public Tuple(int node, List<Integer> list) {
		this.node = node;
		this.list = list;
		this.score = 0;
	}

	@Override
	public String toString() {
		return "Tuple [node=" + node + ", list=" + list + ", score=" + score + "]";
	}

}
