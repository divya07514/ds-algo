package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {

	Map<Integer, Integer> map;
	List<Integer> list;
	Random rand;

	public InsertDeleteGetRandom() {
        this.map = new HashMap();
        this.list = new ArrayList();
        this.rand = new Random();
    }

	public boolean insert(int val) {
		if (!map.containsKey(val)) {
			map.put(val, list.size());
			list.add(list.size(), val);
			return true;
		}
		return false;
	}

	public boolean remove(int val) {
		if (map.containsKey(val)) {
			int index = map.get(val);
			int last = list.get(list.size() - 1);
			list.set(index, last);
			list.remove(list.size() - 1);
			map.put(last, index);
			map.remove(val);
			return true;
		}
		return false;
	}

	public int getRandom() {
		int index = rand.nextInt(list.size());
		return list.get(index);
	}

}
