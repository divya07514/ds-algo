package easy;

public class ToeplitzMatrix {

	public static boolean isToeplitzMatrix(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return false;
		}

		int r = matrix.length;
		int c = matrix[0].length;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i > 0 && j > 0 && matrix[i - 1][j - 1] != matrix[i][j]) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
		System.out.println(isToeplitzMatrix(matrix));
	}

}
