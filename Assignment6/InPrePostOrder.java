package com.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
	
	public BST() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void addNode(int value) {
		//1. create a newnode
		Node newnode = new Node(value);
		//2. if BST is empty, add newnode into root
		if(root == null)
			root = newnode;
		//3. if BST is not empty
		else {
			//3.1 create a reference to traverse and start at root
			Node trav = root;
			while(true) {
				//3.2 if value is less than current node data
				if(value < trav.data) {
					//3.2.1 if left of current node is empty
					if(trav.left == null) {
						// add newnode into left of current node
						trav.left = newnode;
						break;
					}
					//3.2.2 if left of current node is not empty
					else
						// go on left of current node
						trav = trav.left;
				}
				//3.3 if value is greater or equal than current node data
				else {
					//3.3.1 if right of current node is empty
					if(trav.right == null) {
						// add newnode into right of current node
						trav.right = newnode;
						break;
					}
					//3.3.2 if right of current node is not empty
					else
						// go on right of current node
						trav = trav.right;
				}
			}//3.4 repeat step 3.2 and 3.3 until node is added into BST
		}
	}
	
	public void preorder(Node trav) {
		Stack<Node> stack = new Stack<>();
		if(trav == null) return;
		stack.push(trav);
		while(!stack.isEmpty()) {
			Node curr = stack.pop();
			System.out.println(" " +curr.data);
			
			if(curr.right!=null) {
				stack.push(curr.right);
			}
			
			if(curr.left!=null) {
				stack.push(curr.left);
			}
		}
	}
	
	public void inorder(Node trav) {
		Stack<Node> stack = new Stack<>();
		if(trav == null) return;
		stack.push(trav);
		
		Node curr = stack.pop();
		while(curr !=null || !stack.isEmpty()) {
			while(curr!=null) {
				stack.push(curr);
				curr = curr.left;
			}
			
			curr = stack.pop();
			System.out.println(curr.data);
			
			curr = curr.right;
		}
	}
	
	public void postorder(Node trav) {
		Stack<Node> stack = new Stack<>();
		if(trav == null) return;
		
		Node curr = trav;
		Node lastVisited = null;
		
		while(curr != null || !stack.isEmpty()) {
			if(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}else {
				Node peekNode = stack.peek();
				if(peekNode.right != null && lastVisited!=peekNode.right) {
					curr = peekNode.right;
				}else {
					System.out.println(peekNode.data+" ");
					lastVisited = stack.pop();
				}
			}
		}
	}
	
	public void postorder() {
		inorder(root);
	}
	
	public void inorder() {
		inorder(root);
	}
	
	public void preorder() {
		preorder(root);
	}
	
	public int searchNode(int key) {
		Node trav = root;
		int count = 0;
		while(trav != null) {
			if(key == trav.data) {
				return count;
				
			}
			else if(key < trav.data) {
				trav = trav.left;
				count++;
			}
			else {
				trav = trav.right;
				count++;
			}
		}
		return -1;		
	}

	
	public void deleteAll() {
		root = null;
	}
	
}

public class InPrePostOrder {

	public static void main(String[] args) {
		BST bst = new BST();
		
		bst.addNode(8);
		bst.addNode(3);
		bst.addNode(10);
		bst.addNode(2);
		bst.addNode(15);
		bst.addNode(6);
		bst.addNode(14);
		bst.addNode(4);
		bst.addNode(7);
		
//		System.out.println(bst.searchNode(3));
//		bst.preorder();
//		bst.inorder();
		bst.postorder();
	}
}
