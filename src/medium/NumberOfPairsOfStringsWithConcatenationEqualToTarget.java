package medium;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPairsOfStringsWithConcatenationEqualToTarget {
	
    public static  int numOfPairs(String[] nums, String target) {
        
        Map<String,Integer> map = new HashMap<>();
        
        int count = 0;
        
        for(int i=0;i<nums.length;i++){
            String s = nums[i];
            if(target.startsWith(s)){
                String sub = target.substring(s.length());
                if(map.containsKey(sub)){
                    count = count + map.get(sub);
                }
            }
            if(target.endsWith(s)){
                String sub = target.substring(0,target.length() - s.length());
                if(map.containsKey(sub)){
                    count = count + map.get(sub);
                }
                
            }
            if(!map.containsKey(s)){
                map.put(s,1);
            }else{
                map.put(s,map.get(s)+1);
            }
        }
        return count ; 
    }

	public static void main(String[] args) {
		String[] nums = {"123","4","12","34"};
		String target = "1234";
		System.out.println(numOfPairs(nums, target));

	}

}
