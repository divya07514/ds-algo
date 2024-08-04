package medium;

public class Reverse {

    public static void solution(int N) {
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1;
            }
            if (enable_print != 0) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
        System.out.println();
    }

	public static void solution1(int N) {
	    // Special case for zero
	    if (N == 0) {
	        System.out.print(0);
	        return;
	    }

	    // Step 1: Skip all trailing zeros
	    while (N > 0 && N % 10 == 0) {
	        N = N / 10;
	    }
	    
	    // Step 2: Collect digits in reverse order
	    StringBuilder result = new StringBuilder();
	    while (N > 0) {
	        result.append(N % 10);
	        N = N / 10;
	    }

	    // Print the result (already in reverse order)
	    System.out.print(result);
	}

	public static void main(String[] args) {
		solution(5000);
		solution(110);
		solution(106798);
		solution(106798000);
		solution(1100145);
		solution(1100111111);
	}

}
