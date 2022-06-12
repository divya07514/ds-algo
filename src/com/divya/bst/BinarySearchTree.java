package com.divya.bst;

public class BinarySearchTree {

	private Node root;

	public BinarySearchTree() {
		super();
	}

	public BinarySearchTree(Node root) {
		super();
		this.root = root;
	}

	public void insert(int item) {
		if (root == null) {
			root = new Node(item);
		} else {
			insertItem(item, root);
		}
	}

	public void traversal() {
		Node temp = root;
		inorderTraversal(temp);
	}

	public int getMax() {
		Node temp = root;
		int result = max(temp);
		System.out.println(result);
		return result;
	}

	public int getMin() {
		Node temp = root;
		int result = min(temp);
		System.out.println(result);
		return result;
	}

	public Node delete(int data) {
		Node temp = root;
		Node newRoot = null;
		if (root != null) {
			newRoot = deleteItem(temp, data);
		}
		return newRoot;
	}

	public void deleteMin() {
		if (root == null) {
			return;
		}
		deleteMin(root.getLeft());
	}

	public void deleteMax() {
		if (root == null) {
			return;
		}
		deleteMax(root.getRight());
	}

	public int kthSmallest(Node node, int k) {
		int count = countNodes(node.getLeft()) + 1;
		if (count == k) {
			return node.getData();
		}
		if (k < count) {
			return kthSmallest(node.getLeft(), k);
		}
		if (k > count) {
			return kthSmallest(node.getRight(), k - count);
		}
		return -1;
	}

	public int countNodes(Node node) {
		if (node == null) {
			return 0;
		}
		return countNodes(node.getLeft()) + countNodes(node.getRight()) + 1;
	}

	private Node deleteMax(Node root) {
		if (root.getRight() != null) {
			root.setRight(deleteMax(root.getRight()));
		}
		return root.getLeft();
	}

	private Node deleteMin(Node root) {
		if (root.getLeft() != null) {
			root.setLeft(deleteMin(root.getLeft()));
		}
		return root.getRight();
	}

	private Node deleteItem(Node root, int data) {

		return null;

	}

	private Node getPredecessor(Node left) {
		Node result = null;
		if (left != null) {
			int max = max(left);
			result = new Node(max);
		}
		return result;
	}

	private int max(Node root) {
		if (root == null) {
			return -1;
		}
		if (root.getRight() != null) {
			return max(root.getRight());
		}
		return root.getData();
	}

	private int min(Node root) {
		if (root == null) {
			return -1;
		}
		if (root.getLeft() != null) {
			return min(root.getLeft());
		}
		return root.getData();
	}

	private void insertItem(int item, Node root) {
		if (item < root.getData()) {
			if (root.getLeft() != null) {
				insertItem(item, root.getLeft());
			} else {
				Node newNode = new Node(item);
				root.setLeft(newNode);
			}
		} else {
			if (item > root.getData()) {
				if (root.getRight() != null) {
					insertItem(item, root.getRight());
				} else {
					Node newNode = new Node(item);
					root.setRight(newNode);
				}
			}
		}
	}

	private void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.getLeft());
			System.out.print(root.getData() + " ");
			inorderTraversal(root.getRight());
		}
	}

	public Node getRoot() {
		return root;
	}

}
