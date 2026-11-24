package com.demo;

import java.util.Scanner;

class LinearQ{
	private int arr[];
	private final int SIZE;
	private int front,rear;
	public LinearQ(int size) {
		SIZE = size;
		arr = new int[SIZE];
		front = rear = 0;
	}
	
	public void offer(int value) {
		if(rear >= SIZE) {
			System.out.println("Full");
		}else {
			arr[rear] = value;
			rear++;
		}
	}
	
	public int poll() {
		int temp = 0;
		if(front == rear) {
			System.out.println("Empty");
		}else {
			temp = arr[front];
			front++;
		}
		return temp;
	}
	
	public int peek() {
		int temp = 0;
		if(front == rear) {
			System.out.println("Empty");
		}else {
			temp = arr[front];
		}
		return temp;
	}
}
public class LinearQueue {

	public static void main(String[] args) {
		LinearQ q = new LinearQ(3);
		
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
