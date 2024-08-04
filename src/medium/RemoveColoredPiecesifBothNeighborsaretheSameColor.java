package medium;

/**
 * Keep count of valid positions for both A and B.
 *	because Alice moves first, she must have more valid moves than Bob to win
 * @author divya.thakur
 *
 */
public class RemoveColoredPiecesifBothNeighborsaretheSameColor {

	public boolean winnerOfGame(String s) {
		int n = s.length();
		if (n <= 2) {
			return false;
		}
		int posA = 0;
		int posB = 0;
		for (int i = 1; i < n - 1; i++) {
			char c = s.charAt(i);
			if (c == 'A') {
				if (s.charAt(i - 1) == 'A' && s.charAt(i + 1) == 'A') {
					posA++;
				}
			}
			if (c == 'B') {
				if (s.charAt(i - 1) == 'B' && s.charAt(i + 1) == 'B') {
					posB++;
				}
			}
		}
		 return posA - posB >=1;

	}
}
