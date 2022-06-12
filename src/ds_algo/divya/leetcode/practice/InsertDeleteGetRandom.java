package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {
	Map<Integer,Integer> map ;
    List<Integer> list;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	 if(map.containsKey(val)){
             return false;
         }
         list.add(val);
         map.put(val, list.size() - 1);
         return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	 if(!map.containsKey(val)){
             return false;
         }
         int index = map.get(val);
         int lastElement = list.get(list.size() - 1);
         list.set(index, lastElement);
         map.put(lastElement, index);
         list.remove(list.size() - 1);
         map.remove(val);
         return true;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if(list.size()==1){
            return list.get(0);
        }else{
            Random rand = new Random(); 
            int randNum= rand.nextInt(list.size());
            return list.get(randNum);
        }
        
    }
}
