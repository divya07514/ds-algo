package medium;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {

	public static int numTilePossibilities(String tiles) {

		if (tiles.length() == 1) {
			return 1;
		}

		Set<String> set = new HashSet<>();
		boolean[] visited = new boolean[tiles.length()];
		dfs(set, "", visited, tiles);
		return set.size() - 1;
	}

	private static void dfs(Set<String> set, String s, boolean[] visited, String tiles) {
		set.add(s);
		for (int i = 0; i < tiles.length(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(set, s + tiles.charAt(i), visited, tiles);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		String tiles = "AAB";
		System.out.println(numTilePossibilities(tiles));
	}

}
