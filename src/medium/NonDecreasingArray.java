package medium;

public class NonDecreasingArray {
	
    public static boolean checkPossibility(int[] nums) {
        if(nums==null || nums.length==0){
            return false;
        }
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(count>1){
                return false;
            }
            if(nums[i-1]>nums[i]){
                count++;
                if(i-2<0 || nums[i-2]<=nums[i]){
                    nums[i-1]=nums[i];
                }else{
                    nums[i]=nums[i-1];
                }
            }
        }

        return count<=1;
    }
	public static void main(String[] args) {
		int[] nums = {5,7,1,8};
		System.out.println(checkPossibility(nums));

	}

}
