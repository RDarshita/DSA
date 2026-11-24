package com.demo;

import java.util.Stack;

class BinSearch{
	static class Node{
		private int data;
		private Node left;
		private Node right;
		public boolean visited;
		
		public Node(int value) {
			data = value;
			right = left = null;
			visited = false;
		}
	}
	
	private Node root;
	
	public BinSearch(){
		root = null;
	}
	
	public void addNode(int value) {
		Node newnode = new Node(value);
		if(root == null) {
			root = newnode;
		}else {
			Node trav = root;
			while(true) {
				if(value<trav.data) {
					if(trav.left == null) {
						trav.left = newnode;
						return;
					}
					trav = trav.left;
				}else {
					if(trav.right == null) {
						trav.right = newnode;
						return;
					}
					trav = trav.right;
				}
			}
		}
	}
	
	public void nonRecursivePreorder() {
		Stack<Node> stack = new Stack<>();
		Node trav = root;
		while(trav!=null || stack.isEmpty()) {
			while(trav!=null) {
				System.out.println(trav.data);
				if(trav.right!=null) {
					stack.push(trav.right);
				}
				trav = trav.left;
			}
			
			if(!stack.isEmpty()) {
				trav = stack.pop();
			}
		}
	}
	
	public void nonRecursiveInorder() {
		Stack<Node> stack = new Stack<>();
		Node trav = root;
		while(trav!=null || !stack.isEmpty()) {
			while(trav!=null) {
				stack.push(trav);
				trav = trav.left;
			}
			if(!stack.isEmpty()) {
				trav = stack.pop();	
			}
			System.out.println(trav.data);
			trav = trav.right;
		}
	}
	
	public void nonRecursivePostorder() {
		Stack<Node> stack = new Stack<BinSearch.Node>();
		Node trav = root;
		while(trav!=null || !stack.isEmpty()) {
			while(trav!=null) {
				stack.push(trav);
				trav = trav.left;
			}
			
			if(!stack.isEmpty()) {
				trav = stack.pop();
				if(trav.right==null || trav.right.visited==true) {
					System.out.println(trav.data);
					trav.visited = true;
					trav = null;
				}else {
					stack.push(trav);
					trav = trav.right;
				}
			}
		}
	}
	
	public void deleteNode(int key) {
		Node trav = root,parent=null;
		while(trav!=null) {
			if(trav.data == key) break;
			
			parent = trav;
			if(trav.data > key) {
				trav = trav.left;
			}else {
				trav = trav.right;
			}
		}
		
		if(trav == null) {
			return;
		}
		
		//two child
		if(trav.left != null && trav.right!=null) {
			Node pred = trav.left;
			parent = pred;
			while(pred.right != null) {
				parent = pred;
				pred = pred.right;
			}
			
			trav.data = pred.data;
			
			if(pred == parent.left) {
				parent.left = pred.left;
			}else {
				parent.right = pred.left;
			}
			
		}
		//single child left
		else if(trav.right == null) {
			if(trav == root) {
				root = trav.left;
			}else if(trav == parent.left) {
				parent.left = trav.left;
			}else if(trav == parent.right){
				parent.right = trav.left;
			}
		}
		//single right child
		else {
			if(trav == root) {
				root = trav.right;
			}else if(trav == parent.left) {
				parent.left = trav.right;
			}else if(trav == parent.right) {
				parent.right = trav.right;
			}
		}
	}
	
	private int height(Node trav) {
		if(trav == null) {
			return -1;
		}
		
		int hl = height(trav.left);
		int hr = height(trav.right);
		int max = hl>hr?hl:hr;
		return max+1;
	}
	
	public int height() {
		return height(root);
	}
	
	public void deleteAll() {
		root = null;
	}
}

public class DeleteNode {

	public static void main(String[] args) {
		BinSearch bst = new BinSearch();
		
		bst.addNode(8);
		bst.addNode(3);
		bst.addNode(10);
		bst.addNode(2);
		bst.addNode(15);
		bst.addNode(6);
		bst.addNode(14);
		bst.addNode(4);
		bst.addNode(7);
		
		bst.deleteNode(15);
		
//		System.out.println(bst.height());
//		bst.deleteAll();
//		bst.nonRecursivePreorder();
//		bst.nonRecursiveInorder();
		bst.nonRecursivePostorder();
	}

}
