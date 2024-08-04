package medium;

public class FairIndex {

	
	public static int solution(int[] A, int[] B) {
		
		if(A.length!=B.length) {
			return 0;
		}
		
		int n = A.length;
		
		int sumA = 0;
		int sumB = 0;
		
		for(int i=0;i<n;i++) {
			sumA = sumA + A[i];
			sumB = sumB + B[i];
		}
		
		int count = 0;
		int currentA = A[0];
		int currentB = B[0];
		
		for(int i=1;i<n;i++) {
			
			if(i!=1 && currentA == currentB && currentA*2 == sumA && currentB*2 == sumB) {
				count++;
			}
			
			currentA = currentA + A[i];
			currentB = currentB + B[i];
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] A = {3,2,6};
		int[] B = {4,1,6};
		System.out.println(solution(A, B));
	}

}

