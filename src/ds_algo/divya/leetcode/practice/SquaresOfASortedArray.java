package ds_algo.divya.leetcode.practice;

public class SquaresOfASortedArray {

	static public int[] sortedSquares(int[] array) {
		int[] result = new int[array.length];
		int i = 0;
		int j;
		for (j = 0; j < array.length; j++) {
			if(array[j]>=0) {
				break;
			}
		}
		i=j-1;
		int index = 0;
		while( j < array.length && i >= 0) {
			if(Math.pow(array[i], 2) > Math.pow(array[j],2)) {
				result[index] =(int) Math.pow(array[j],2);
				j++;
				index++;
			}else {
				result[index] = (int) Math.pow(array[i], 2);
				i--;
				index++;
			}
		}
		while(i>=0) {
			result[index] = (int) Math.pow(array[i], 2);
			i--;
			index++;
		}
		while(j < array.length) {
			result[index] =(int) Math.pow(array[j],2);
			j++;
			index++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] array = { -6,-5,1,2,3,4};
		int[] result = sortedSquares(array);
		for (int i : result) {
			System.out.print(i + " ");
		}

	}

}
