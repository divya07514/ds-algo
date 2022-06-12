package ds_algo.divya.leetcode.practice;

public class CountNegativesInMatrix {

	public static int countNegatives(int[][] grid) {
		int neg_count = 0;
		int m = grid.length, n = grid[0].length;
		for (int r = 0; r < m; r++) {
			int l = 0, end = n - 1;
			while (l <= end) {
				int mid = l + (end - l) / 2;
				if (grid[r][mid] >= 0)
					l = mid + 1;
				else {
					// update -ve counter before moving end to mid
					neg_count += end - mid + 1;
					end = mid - 1;
				}
			}
		}
		return neg_count;
	}
	
	public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int i=0;
        while(i<n && n<2*n){
            result[i]=nums[i];
            result[i++]=nums[n];
            i++;
            n++;
        }
        return result;
    }

	public static void main(String[] args) {
		int[][] grid = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
		
		int[] nums = {2,5,1,3,4,7};
		shuffle(nums, 3);

		System.out.println(countNegatives(grid));

	}

}
