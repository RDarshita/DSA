package com.demo;

class CLinkedList{
	class Node{
		private int data;
		private Node next;
		
		public Node(int value){
			data = value;
			next = null;
		}
	}
	
	private Node head,tail;
	public CLinkedList() {
		head = tail = null;
	}
	
	public void addFirst(int value) {
		Node newNode = new Node(value);
		if(head == null) {
			head = tail = newNode;
			tail.next = head;
		}else {
			newNode.next = head;
			tail.next = newNode;
			head = newNode;
		}
	}
	
	public void addPosition(int value,int pos) {
		Node newNode = new Node(value);
		if(head == null) {
			head = tail = newNode;
			tail.next = head;
		}else if(pos <= 1) {
			newNode.next = head;
			head = newNode;
			tail.next = newNode;
		}
		else {
			Node trav = head;
			for(int i=1;i<pos-1 && trav.next!=null;i++) {
				trav = trav.next;
			}
			newNode.next = trav.next;
			trav.next = newNode;
			if(trav == tail) {
				tail = newNode;
			}
		}
	}
	
	public void deletePosition(int pos) {
		if(head == null|| pos < 1) {
			return;
		}else if(pos == 1){
			head = head.next;
			tail.next = head;
		}
		else {
			Node trav = head;
			for(int i=1;i<pos-1&& trav.next != head;i++) {
				trav = trav.next;
			}
			if(trav.next == head) {
	            return;
	        }
			trav.next = trav.next.next;
		}
	}
	
	public void display() {
		if(head == null) {
			return;
		}
		Node trav = head;
		do {
			System.out.println(trav.data);
			trav = trav.next;
		}while(trav != head);
	}
}

public class Question3 {

	public static void main(String[] args) {
		CLinkedList list = new CLinkedList();
//		list.addPosition(10, 1);
//		list.addPosition(20, 2);
		list.addPosition(40, 5);
		
		list.addFirst(30);
		list.addFirst(20);
		list.addFirst(10);
		
		list.deletePosition(2);
		
		list.display();
	}

}
