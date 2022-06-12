package com.divya.tree.avl;

public class AVLTree {

	private Node root;

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node node, int data) {
		if (node == null) {
			return new Node(data);
		}
		if (data < node.getData()) {
			node.setLeftNode(insert(node.getLeftNode(), data));
		} else {
			node.setRightNode(insert(node.getRightNode(), data));
		}
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
		node = rebalance(node, data);
		return node;
	}

	private Node rebalance(Node node, int data) {
		int balance = getBalance(node);

		// double left heavy situation. root->left->left
		if (balance > 1 && data < node.getLeftNode().getData()) {
			return rightRotation(node);
		}

		// double right heavy situation. root->right->right
		if (balance < -1 && data > node.getRightNode().getData()) {
			return leftRotation(node);
		}

		// root->left->right
		if (balance > 1 && data > node.getLeftNode().getData()) {
			node.setLeftNode(leftRotation(node.getLeftNode()));
			return rightRotation(node);
		}

		// root->right->left
		if (balance < -1 && data < node.getRightNode().getData()) {
			node.setRightNode(rightRotation(node.getRightNode()));
			return leftRotation(node);
		}

		return node;
	}

	public void traverse() {
		if (root == null) {
			return;
		}
		inOrderTraversal(root);
	}

	private void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.getLeftNode());
			System.out.print(root.getData() + " ");
			inOrderTraversal(root.getRightNode());
		}
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		return node.getHeight();
	}

	private int getBalance(Node node) {
		if (root == null) {
			return 0;
		}
		return height(node.getLeftNode()) - height(node.getRightNode());
	}

	private Node rightRotation(Node node) {
		System.out.println("Rotating to the right on node: " + node);
		Node temp = node.getLeftNode();
		Node t = temp.getRightNode();
		temp.setRightNode(node);
		node.setLeftNode(t);
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
		temp.setHeight(Math.max(height(temp.getLeftNode()), height(temp.getRightNode())) + 1);
		return temp;
	}

	private Node leftRotation(Node node) {
		System.out.println("Rotating to the left on node: " + node);
		Node temp = node.getRightNode();
		Node t = temp.getLeftNode();
		temp.setLeftNode(node);
		node.setRightNode(t);
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
		temp.setHeight(Math.max(height(temp.getLeftNode()), height(temp.getRightNode())) + 1);
		return temp;
	}

}
