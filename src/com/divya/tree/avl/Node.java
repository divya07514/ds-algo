package com.divya.tree.avl;

public class Node {

	private int data;
	private Node leftNode;
	private Node rightNode;
	private int height;

	public Node(int data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
