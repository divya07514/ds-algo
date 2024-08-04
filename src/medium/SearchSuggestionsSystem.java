package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {

	public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
		Arrays.sort(products);

		TNode root = new TNode();
		populateTrie(products, root);

		List<List<String>> result = new ArrayList();

		TNode temp = root;
		for (int i = 0; i < searchWord.length(); i++) {
			char c = searchWord.charAt(i);
			temp = temp.next[c - 'a'];
			if (temp != null) {
				result.add(new ArrayList(temp.words));
			} else {
				for (int j = i; j < searchWord.length(); j++) {
					result.add(new ArrayList());
				}
				break;
			}
		}

		return result;
	}

	private static void populateTrie(String[] products, TNode root) {
		for (String s : products) {
			TNode temp = root;
			for (char c : s.toCharArray()) {
				boolean present = temp.contains(c);
				if (!present) {
					temp.add(c, new TNode());
				}
				temp = temp.getNode(c);
				if (temp.words.size() < 3) {
					temp.words.add(s);
				}
			}
		}
	}

	public static void main(String[] args) {
		String[] products = { "havana" };
		String searchWord = "tasty";
		System.out.println(suggestedProducts(products, searchWord));

	}

}

class TNode {
	TNode[] next;
	List<String> words;

	public TNode() {
		next = new TNode[26];
		words = new ArrayList();
	}

	public boolean contains(char c) {
		return next[c - 'a'] != null;
	}

	public void add(char c, TNode node) {
		next[c - 'a'] = node;
	}

	public TNode getNode(char c) {
		return next[c - 'a'];
	}
}
