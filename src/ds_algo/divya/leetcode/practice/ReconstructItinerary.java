package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ReconstructItinerary {

	HashMap<String, List<String>> map = new HashMap<>();
	List<String> result = null;

	public List<String> findItinerary(List<List<String>> tickets) {
		for (List<String> ticket : tickets) {
			String origin = ticket.get(0);
			String dest = ticket.get(1);
			if (this.map.containsKey(origin)) {
				List<String> destList = this.map.get(origin);
				destList.add(dest);
			} else {
				List<String> destList = new LinkedList<String>();
				destList.add(dest);
				this.map.put(origin, destList);
			}
		}
		this.map.forEach((key, value) -> Collections.sort(value));
		this.result = new ArrayList<String>();
		this.DFS("JFK");
		return this.result;
	}

	protected void DFS(String origin) {
		if (this.map.containsKey(origin)) {
			List<String> destList = this.map.get(origin);
			while (!destList.isEmpty()) {
				String dest = destList.remove(0);
				DFS(dest);
			}
		}
		this.result.add(0,origin);
	}
}
