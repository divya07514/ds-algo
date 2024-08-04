package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CombinationSum4 {
	
    public static int combinationSum4(int[] nums, int target) {
        	
    	Arrays.sort(nums);
    	Map<Integer, Integer> map = new HashMap();
    	
    	int result = sum(nums,target,map);
    	System.out.println(map);
    	return result;
    }
    
    private static int sum(int[] nums, int target, Map<Integer,Integer> map) {
    	if(target==0) {
    		return 1;
    	}
    	
    	if(map.containsKey(target)) {
    		return map.get(target);
    	}
    	
    	int result = 0;
    	for(int i : nums) {
    		if(target - i>=0) {
    			result = result + sum(nums,target-i,map);
    		}
    	}
    	map.put(target, result);
    	return result;
    }

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		int target = 4;
		System.out.println(combinationSum4(nums, target));

	}

}
