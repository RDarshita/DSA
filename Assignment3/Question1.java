package com.demo;

class SinglyLinkedList{
	class Node{
		private int data;
		private Node next;
		
		public Node(int value){
			data = value;
			next = null;
		}
	}
	
	private Node head;
	
	public SinglyLinkedList(){
		head = null;
	}
	
	public void addFirst(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
	}
	
	public void display() {
		Node trav = head;
		while(trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
	}
	
	public void afterData(int value,int givenData) {
		Node newNode = new Node(value);
		Node trav = head;
		while(trav != null) {
			if(trav.data == givenData) {
				newNode.next = trav.next;
				trav.next = newNode;
			}
			trav = trav.next;
		}
	}
	
	public void beforeData(int value,int givenData) {
		Node newNode = new Node(value);
		if(head == null) {
			return;
		}else if(head.data == givenData) {
				newNode.next = head;
				head = newNode;
		}
		else {
			Node trav = head;
			while(trav != null && trav.next.data != givenData) {
				if(trav.next != null ) {
					newNode.next = trav.next;
					trav.next = newNode;
					return;
				}
				trav = trav.next;
			}
		}
	}
}

public class Question1 {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addFirst(30);
		list.addFirst(20);
		list.addFirst(10);
		list.afterData(60, 10);
		list.beforeData(25,10);
		
		list.display();
	}

}
