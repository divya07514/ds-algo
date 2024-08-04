package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Msft_2 {
	
	
	public static int solution(int[] nums) {

		int n = nums.length;
		if (n == 0) {
			return -1;
		}

		Map<String, List<Integer>> map = new HashMap();
		
		for(int i : nums) {
			String s = String.valueOf(i);
			char first = s.charAt(0);
			char last = s.charAt(s.length()-1);
			String key = first+", "+last;
			if(!map.containsKey(key)) {
				List<Integer> list = new ArrayList();
				list.add(i);
				map.put(key,list);
			}else {
				map.get(key).add(i);
			}
		}
		
		int result = Integer.MIN_VALUE;
		
		for(String key : map.keySet()) {
			List<Integer> list = map.get(key);
			if(list.size()>=2) {
				Collections.sort(list);
				int sum = list.get(list.size()-1) + list.get(list.size()-2);
				result = Math.max(result, sum);
			}
		}
		if(result==Integer.MIN_VALUE) {
			return -1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = {30,909,3190,99,3990,9009};
		System.out.println(solution(a));
	}
}
