package ds_algo.divya.leetcode.practice;

public class FindFirstAndLastPositionOfElementInSortedArray {
	
	public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(nums==null || nums.length == 0){
            return result;
        }
        result[0] = first(nums,target);
        result[1] = last(nums,target);
        return result;
    }
    
    private static int first(int[] nums, int target){
        int i = 0;
        int j = nums.length-1;
        int result = -1;
        while(i<=j){
            int mid = (i+j)/2;
            if(nums[mid]==target){
                result = mid;
                j=mid-1;
            }else if(nums[mid] < target){
                i = mid + 1;
            }else{
                j = mid -1;
            }       
            
        }
        return result;
    }
    
    private static int last(int[] nums, int target){
        int i=0;
        int j = nums.length-1;
        int result =-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(nums[mid]==target){
                result = mid;
                i = mid + 1;
            }else if(nums[mid] < target){
                i = mid + 1;
            }else{
                j = mid -1;
            }  
        }
        return result;
    }

	public static void main(String[] args) {
		int[] nums  = {5,7,7,8,8,10};
		int target = 8;
	
		int[] result = searchRange(nums, target);
		ArrayUtil.printArray(result);

	}

}
