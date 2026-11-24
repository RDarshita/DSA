package com.demo;

public class Successor {
	static class BinSearchTree{
		
		static class Node{
			private int data;
			private Node left;
			private Node right;
			
			public Node(int value){
				data = value;
				left = right = null;
			}
			
			public int getData() {
		        return data;
		    }
		}
		
		private Node root;
		
		public BinSearchTree() {
			root = null;
		}

		public void addNode(int value) {
			Node newnode = new Node(value);
			if(root == null) {
				root = newnode;
			}else {
				Node trav = root;
				while(true) {
					if(trav.data > value) {
						if(trav.left == null) {
							trav.left = newnode;
							return;
						}else {
							trav = trav.left;
						}
					}else {
						if(trav.data < value) {
							if(trav.right == null) {
								trav.right = newnode;
								return;
							}else {
								trav = trav.right; 
							}
						}
					}
				}
			}
		}
		
		public void inorder(Node trav) {
			if(trav == null) {
				return;
			}
			
			inorder(trav.left);
			System.out.println(trav.data + " ");
			inorder(trav.right);
		}
		
		public Node successor(int key) {
			Node trav = root;
			Node succ = null;
			
			while(trav!=null) {
				if(key<trav.data) {
					succ = trav;
					trav = trav.left;
				}else if(trav.data < key) {
					trav = trav.right;
				}else {
					if(trav.right != null) {
						succ = trav.right;
						
						while(succ.left != null) {
							succ = succ.left;
						}
					}
					break;
				}
			}
			return succ;
		}

		public void display() {
	        inorder(root);
	        System.out.println();
	    }
		
	}

	public static void main(String[] args) {

        BinSearchTree bst = new BinSearchTree();

        bst.addNode(20);
        bst.addNode(10);
        bst.addNode(30);
        bst.addNode(25);
        bst.addNode(40);
        bst.addNode(22);

        System.out.print("Inorder: ");
        bst.display();

        int key = 20;

        BinSearchTree.Node result = bst.successor(key);

        if (result != null)
            System.out.println("Successor of " + key + " = " + result.getData());
        else
            System.out.println("Successor does not exist");
    }

}
