package ds_algo.divya.leetcode.practice;

public class TrappingRainWater {
	
	public static int trap(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int maxIndex = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
       
        int sum  =0;
        int left = nums[0];
        for(int i=1;i<maxIndex;i++){
            if(nums[i]>left){
                left=nums[i];
            }else{
                sum = sum + left - nums[i];
            }
        }
        
        int right =nums[nums.length-1];
        for(int i=nums.length-2;i>maxIndex;i--){
            if(nums[i]>right){
                right = nums[i];
            }else{
                sum = sum + right -nums[i];
            }
        }
        
        return sum;
    }

	public static void main(String[] args) {
		int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(nums));

	}

}
