package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {

	static TrieNode root;

	public static List<String> findWords(char[][] board, String[] words) {

		if (board == null || board.length == 0) {
			return new ArrayList();
		}

		int r = board.length;
		int c = board[0].length;
		boolean[][] marked = new boolean[r][c];

		Set<String> set = new HashSet();
		root = new TrieNode();

		for (String s : words) {
			insert(s);
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				char ch = board[i][j];
				if (root.next[ch - 'a'] != null) {
					dfs(i, j, board, "", set, marked, root);
				}
			}
		}
		List<String> result = new ArrayList(set);
		return result;
	}

	private static void dfs(int i, int j, char[][] board, String word, Set<String> result, boolean[][] marked,
			TrieNode node) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || marked[i][j]) {
			return;
		}

		if (node.next[board[i][j] - 'a'] == null) {
			return;
		}

		marked[i][j] = true;

		node = node.getNode(board[i][j]);
		if (node.isWord) {
			result.add(word + board[i][j]);
		}

		dfs(i + 1, j, board, word + board[i][j], result, marked, node);
		dfs(i - 1, j, board, word + board[i][j], result, marked, node);
		dfs(i, j + 1, board, word + board[i][j], result, marked, node);
		dfs(i, j - 1, board, word + board[i][j], result, marked, node);
		marked[i][j] = false;

	}

	public static void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!node.containsKey(c)) {
				TrieNode temp = new TrieNode();
				node.addNode(c, temp);
			}
			node = node.getNode(c);
		}
		node.isWord = true;
	}

	public static void main(String[] args) {
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'q', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };

		String[] words = { "oath", "eat", "peat" };
		System.out.println(findWords(board, words));

	}

}

class TrieNode {

	boolean isWord = false;
	TrieNode[] next = new TrieNode[26];

	public TrieNode() {
	}

	public boolean containsKey(char c) {
		return next[c - 'a'] != null;
	}

	public TrieNode getNode(char c) {
		return next[c - 'a'];
	}

	public void addNode(char c, TrieNode node) {
		next[c - 'a'] = node;
	}
}
