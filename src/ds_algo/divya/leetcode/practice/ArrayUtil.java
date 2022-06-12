package ds_algo.divya.leetcode.practice;

import java.util.Random;

public class ArrayUtil {

	public static int[] arrayOfSize(int size) {
		Random random = new Random(10);
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			result[i] = random.nextInt(100);
		}
		return result;
	}

	public static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void print(int[][] board) {
		int r = board.length;
		int c = board[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void print(char[][] board) {
		int r = board.length;
		int c = board[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
