package com.prac;

import java.util.LinkedList;
import java.util.Queue;

class BST{
	static class Node{
		private int data;
		private Node left;
		private Node right;
		
		public Node(int value) {
			data = value;
			left = right = null;
		}
	}
	
	private Node root;
	public BST(){
		root = null;
	}
	
	public void add(int value) {
		Node newnode = new Node(value);
		if(root == null) {
			root = newnode;
			return;
		}
		add(root,newnode);
	}
	
	private void add(Node trav,Node value) {
		if(value.data < trav.data) {
			if(trav.left == null) {
				trav.left = value;
				return;
			}
			add(trav.left,value);
		}else if(value.data >= trav.data) {
			if(trav.right == null) {
				trav.right = value;
				return;
			}
			add(trav.right,value);
		}
	}
	
	public void display() {
		display(root);
	}
	
	private void display(Node root) {
		if(root == null) {
			return;
		}
		System.out.println(root.data);
		display(root.left);
		display(root.right);
	}
	
	private boolean search(int key,Node trav) {
		if(root == null) {
			return false;
		}
		
		while(trav != null) {
			if(key == trav.data) {
				return true;
			}else if(key<trav.data) {
				return search(key,trav.left);
			}else {
				return search(key,trav.right);
			}
		}
		return false;
	}
	
	public boolean search(int key) {
		Node trav = root;
		return search(key,trav);
	}
}

public class AddSearchRecursive {

	public static void main(String[] args) {
		BST bst = new BST();
		
		bst.add(8);
		bst.add(3);
		bst.add(10);
		bst.add(2);
		bst.add(15);
		bst.add(6);
		bst.add(14);
		bst.add(4);
		bst.add(7);
		
		bst.display();
		System.out.println(bst.search(11));
	}

}
