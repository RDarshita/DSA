package com.demo;

import java.util.Scanner;

class Circular{
	private int arr[];
	private int front,rear;
	private final int SIZE;
	private int count = 0;
	public Circular(int size) {
		SIZE = size;
		arr = new int[SIZE];
		front = rear = -1;
	}
	
	public void offer(int value) {
		if(count == SIZE) {
			System.out.println("Full");
		}else {
			rear = (rear+1)%SIZE;
			arr[rear] = value;
			count++;
		}
	}
	
	public int poll() {
		int temp = -1;
		if(count == 0) {
			System.out.println("Empty");
		}else {
			temp = arr[(front+1)%SIZE];
			front = (front+1)%SIZE;
			if(front == rear) {
				front=rear=-1;
			}
			count--;
		}
		return temp;
	}
	
	public int peek() {
		int temp = -1;
		if(count == 0) {
			System.out.println("Empty");
		}else {
			temp = arr[(front+1)%SIZE];
		}
		return temp;
	}
}

public class QueueCounter {

	public static void main(String[] args) {
		Circular q = new Circular(2);
		
		Scanner sc = new Scanner(System.in);
		int choice;
		do{
			System.out.println("1.Push\n2.Pop\n3.Peek");
			System.out.print("Enter your choice :");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.print("Enter your value :");
				int value = sc.nextInt();
				q.offer(value);
				break;
			case 2:
				System.out.println("Removed value : " + q.poll());
				break;
			case 3:
				System.out.println("Peeked value : " + q.peek());
				break;
			}
		}while(choice != 0);
	}

}
