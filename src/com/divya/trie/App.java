package com.divya.trie;

public class App {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.put("apple", 3);
		System.out.println(trie.get("apple"));
		System.out.println(trie.get("app"));
	}

}
