package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Hashmap approach is not meta approved but a good starting point to start the conversation
 * Use either two pointer approach or binary search
 * @author divya.thakur
 *
 */
public class DotProductOfTwoSpaseMatrix {
	
	public static int dotProduct(int[] one, int[] two) {
		List<int[]> a = pairs(one);
		List<int[]> b = pairs(two);
		int i = 0;
		int j = 0;
		int result = 0;
		while(i<a.size() && j<b.size()) {
			if(a.get(i)[0]==b.get(j)[0]) {
				result = result + a.get(i)[1]*b.get(j)[1];
				i++;
				j++;
			}else if(a.get(i)[0] > b.get(j)[1]) {
				j++;
			}else {
				i++;
			}
		}
		return result;
		
	}
	
	private static List<int[]> pairs(int[] array) {
		List<int[]> list = new ArrayList();
		for(int i=0;i<array.length;i++) {
			if(array[i]!=0) {
				list.add(new int[] {i,array[i]});
			}
		}
		return list;
		
	}
	
	/**
	 * This is the follow up part where only one array is sparse and other is not
	 * @param one
	 * @param three
	 * @return
	 */
	public static int dotProduct_binary_search(int[] one, int[] three) {
		List<int[]> a = pairs(one);
		List<int[]> b = pairs(three);
		int result = 0;
		for(int[] i : a) {
			int[] match = search(i[0],b);
			if(match!=null) {
				result = result + match[1]*i[1];
			}
		}
		return result;
	}



	private static int[] search(int i, List<int[]> b) {
		int left = 0;
		int right = b.size()-1;
		
		while(left<=right) {
			int mid = (right-left)/2 + left;
			int index = b.get(mid)[0];
			if(index==i) {
				return b.get(mid);
			}else if(index > i) {
				right=mid-1;
			}else {
				left = mid+1;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] one = {0,1,0,0,2,0,2};
		int[] two = {1,0,0,0,3,0,4};
		int[] three={1,4,2,3,0,4,2};
		System.out.println(dotProduct(one, two));
		System.out.println(dotProduct_binary_search(one, three));
	}

}
