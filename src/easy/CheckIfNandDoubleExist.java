package easy;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class CheckIfNandDoubleExist {

	public static boolean checkIfExist(int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			int val = arr[i];
			if (!map.containsKey(val * 2) || !map.containsKey(val / 2)) {
				map.put(val, i);
			}else {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 1, 14, 11 };
		System.out.println(checkIfExist(arr));

	}

}
