package com.divya.trie;

import java.util.LinkedList;
import java.util.Queue;

public class Trie {

	private static int R = 26;
	private Node root = new Node();

	public int get(String key) {
		int startIndex = 0;
		Node node = get(root, key, startIndex);
		if (node == null) {
			return -1;
		}
		return node.value;
	}

	public void put(String key, int val) {
		int startIndex = 0;
		root = put(root, key, val, startIndex);
	}

	public Iterable<String> keys() {
		return keysWithPrefix("");
	}

	public Iterable<String> keysWithPrefix(String prefix) {
		Queue<String> q = new LinkedList<>();
		Node starterNode = get(root, prefix, 0);
		collect(starterNode, prefix, q);
		return q;
	}

	public String longestPrefixOf(String s) {
		int index = 0;
		int length = search(root, s, index, 0);
		return s.substring(0, length);
	}

	public void delete(String key) {
		root = delete(root, key, 0);
	}

	private Node delete(Node root, String key, int index) {
		if (root == null) {
			return null;
		}
		if (index == key.length()) {
			root.value = 0;
		} else {
			char c = key.charAt(index);
			root.next[c - 'a'] = delete(root.next[c - 'a'], key, index + 1);
		}
		if (root.value != 0) {
			return root;
		}
		for (int i = 0; i < R; i++) {
			if (root.next[i] != null) {
				return root;
			}
		}
		return null;
	}

	private int search(Node root, String s, int index, int length) {
		if (root == null) {
			return length;
		}
		if (root.value != 0) {
			length = index;
		}
		if (index == s.length()) {
			return length;
		}
		char c = s.charAt(index);
		return search(root.next[c - 'a'], s, index + 1, length);
	}

	private void collect(Node starterNode, String prefix, Queue<String> q) {
		if (starterNode == null) {
			return;
		}
		if (starterNode.value != 0) {
			q.add(prefix);
		}
		for (int c = 0; c < R; c++) {
			char ch = (char) (c + 97);
			collect(starterNode.next[c], prefix + ch, q);
		}
	}

	private Node put(Node root, String key, int val, int startIndex) {
		if (root == null) {
			root = new Node();
		}
		if (startIndex == key.length()) {
			root.value = val;
			return root;
		}
		char c = key.charAt(startIndex);
		root.next[c - 'a'] = put(root.next[c - 'a'], key, val, startIndex + 1);
		return root;
	}

	private Node get(Node root, String key, int startIndex) {
		if (root == null) {
			return null;
		}
		if (startIndex == key.length()) {
			return root;
		}
		char c = key.charAt(startIndex);
		return get(root.next[c - 'a'], key, startIndex + 1);
	}

	private static class Node {
		private int value;
		private Node[] next = new Node[R];

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}

	}
}
