package com.demo;

class SLinkedList{
	class Node{
		private int data;
		private Node next;
		
		public Node(int value){
			data = value;
			next = null;
		}
	}
	
	private Node head;
	public SLinkedList() {
		head = null;
	}
	
	public void display() {
		Node trav = head;
		while(trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
	}
	
	public void addFirst(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
	}
	
	public void sortedInsertion(int value) {
		Node newNode = new Node(value);
		if(head == null || value < head.data) {
			newNode.next = head;
			head = newNode;
		}else {
			Node trav = head;
			while(trav != null) {
				if(trav.next != null && (trav.data < value && value < trav.next.data)) {
						newNode.next = trav.next;
						trav.next = newNode;
				}
				if(trav.next == null && value>trav.data) {
					trav.next = newNode;
				}
				trav = trav.next;
			}
		}
	}
}

public class Question2 {

	public static void main(String[] args) {
		SLinkedList list = new SLinkedList();
		list.addFirst(40);
		list.addFirst(20);
		list.addFirst(10);
		list.sortedInsertion(30);
		list.sortedInsertion(50);
		list.sortedInsertion(90);
		
		list.display();
	}

}
