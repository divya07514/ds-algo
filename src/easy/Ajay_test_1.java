package easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Ajay_test_1 {

	public static void main(String[] args) {

		String[] str = { "11100", "10011", "10101","10011" };
		System.out.println(MatrixChallenge(str));

	}

	public static String MatrixChallenge(String[] str) {

		if (str == null || str.length == 0) {
			return "0";
		}

		int r = str.length;
		int c = str[0].length();

		char[][] grid = new char[r][c];
		int ind = 0;
		for (int i = 0; i < str.length; i++) {
			String s = str[i];
			int len = s.length();
			char[] temp = new char[len];
			int index = 0;
			for (int j = 0; j < s.length(); j++) {
				char ch = s.charAt(j);
				temp[index++] = ch;
			}
			grid[ind++] = temp;
		}
		
		LinkedList<int[]> q = new LinkedList();
		int count = 0;
		Set<String> set = new HashSet();

		int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
		boolean result = false;
		
		while(!q.isEmpty()) {
			int qs = q.size();
			while(qs > 0) {
				int[] temp = q.poll();
				int i = temp[0];
				int j = temp[1];
				for(int[] dir : dirs) {
					int ni = i+dir[0];
					int nj = j+dir[1];
					if(ni>=0 && ni<r && nj>=0 && nj<c && grid[ni][nj]=='1') {
						String add = ni+","+nj;
						if(!set.contains(add)) {
							set.add(add);
							q.add(new int[] {ni,nj});
							if(ni==r-1 && nj==c-1) {
								return String.valueOf(true);
							}
						}
					}
					
				}
				qs--;
			}
		}

		return "false";
	}

}
