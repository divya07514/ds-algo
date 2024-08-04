package medium;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {

    public static int totalFruit(int[] fruits) {
        if(fruits==null || fruits.length==0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap();
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        while(right < fruits.length){
            int i = fruits[right];
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.put(i,map.get(i)+1);
            }
            while(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max,right-left+1);
            right++;
        } 
        return max;
    }

	public static void main(String[] args) {
		int[] fruits = {1,2,3,2,2,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(totalFruit(fruits));

	}

}
