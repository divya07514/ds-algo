package ds_algo.divya.leetcode.practice;

public class Tomtom {

	public static int solution(String s) {

		int max = 0;
		
		for(int i=0;i<s.length()-1;i++) {
			String temp = s.substring(i, i+2);
			max = Math.max(max, Integer.parseInt(temp));
			System.out.println(temp);
		}
		
		return max;
	}

	public static void main(String[] args) {
		System.out.println(solution("25012457844879541820099"));

	}

}
