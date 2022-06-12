package com.divya.bst;

import java.util.PriorityQueue;

public class App {

	public static void main(String[] args) {

		Node root = new Node(24);
		
		BinarySearchTree bst = new BinarySearchTree(root);
		
		bst.insert(15);
		bst.insert(34);
		bst.insert(8);
		bst.insert(18);
		bst.insert(45);
		bst.insert(12);
		bst.insert(40);
		
		bst.traversal();
		System.out.println();
		System.out.println();
		System.out.println(bst.countNodes(bst.getRoot()));
		System.out.println(bst.kthSmallest(bst.getRoot(), 7));
		bst.deleteMax();
		
	}

}
