package ds_algo.divya.leetcode.practice;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class FloodFill {

	public static int[][] floodFill_iterative(int[][] image, int sr, int sc, int newColor) {
		int oldColor = image[sr][sc];
		if(oldColor==newColor) {
			return image;
		}
		FFpair pair =  new FFpair(sr, sc);
		ArrayDeque<FFpair> stack = new ArrayDeque<FFpair>();
		stack.push(pair);
		while(!stack.isEmpty()) {
			FFpair temp = stack.poll();
			image[temp.x][temp.y] = newColor;
			//go left
			FFpair left = new FFpair(temp.x, temp.y-1);
			if(isValid(image, left.x, left.y) && image[left.x][left.y]==oldColor) {
				image[left.x][left.y]=newColor;
				stack.push(left);
			}
			//go right
			FFpair right = new FFpair(temp.x, temp.y+1);
			if(isValid(image, right.x, right.y) && image[right.x][right.y]==oldColor) {
				image[right.x][right.y]=newColor;
				stack.push(right);
			}
			//go up
			FFpair up = new FFpair(temp.x-1, temp.y);
			if(isValid(image, up.x, up.y) &&  image[up.x][up.y]==oldColor) {
				image[up.x][up.y]=newColor;
				stack.push(up);
			}
			//go down
			FFpair down = new FFpair(temp.x+1, temp.y);
			if(isValid(image, down.x, down.y) &&  image[down.x][down.y]==oldColor) {
				image[down.x][down.y]=newColor;
				stack.push(down);
			}
		}
		return image;
	}

	private static boolean isValid(int[][] image, int x, int y) {
		if (x >= 0 && x < image.length && y >= 0 && y < image[0].length) {
			return true;
		} else {
			return false;
		}
	}

	
	public static int[][] floodFill_recursive(int[][] image, int sr, int sc, int newColor){
		int oldColor = image[sr][sc];
		if(oldColor!=newColor) {
			fill(image,sr,sc,newColor,oldColor);
		}
		return image;
	}
	
	private static void fill(int[][] image, int r, int c, int newColor, int oldColor) {
		if(image[r][c]==oldColor) {
			image[r][c]=newColor;
			if(r>=1) {
				fill(image, r-1, c, newColor, oldColor);
			}
			if(c>=1) {
				fill(image, r, c-1, newColor, oldColor);
			}
			if(r+1<image.length) {
				fill(image, r+1, c, newColor, oldColor);
			}
			if(c+1<image[0].length) {
				fill(image, r, c+1, newColor, oldColor);
			}
		}
		
	}

	public static void main(String[] args) {
		int[][] image = { 
					{ 1, 1, 1 }, 
					{ 1, 1, 0 }, 
					{1, 0, 1 } 
				};
		int sr = 2, sc = 2, newColor = 2;
		int[][] result = floodFill_iterative(image, sr, sc, newColor);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
		
	}
}

class FFpair {
	int x;
	int y;

	public FFpair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "FFpair [x=" + x + ", y=" + y + "]";
	}

}
