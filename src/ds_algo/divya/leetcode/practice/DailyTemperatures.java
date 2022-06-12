package ds_algo.divya.leetcode.practice;

import java.util.LinkedList;

public class DailyTemperatures {


	public static int[] dailyTemperatures(int[] nums) {
		LinkedList<Integer> stack = new LinkedList<>();
        int[] result = new int[nums.length];
        
        for(int i=nums.length -1;i>=0;i--){
            while(!stack.isEmpty() && nums[i]>=nums[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i] = 0;
            }else{
                result[i] = stack.peek() - i;
            }
         stack.push(i);   
        }
        
        return result;
	}

	public static void main(String[] args) {
		int[] nums = { 73, 74, 75, 71, 69, 72, 76, 73 };
		ArrayUtil.printArray(dailyTemperatures(nums));

	}

}
