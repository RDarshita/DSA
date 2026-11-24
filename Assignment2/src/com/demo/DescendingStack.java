package com.demo;

import java.util.Scanner;

class Dstack{
	private int arr[];
	private int top;
	private int SIZE;
	public Dstack(int size) {
		SIZE = size;
		top = size;
		arr = new int[size];
	}
	
	public void push(int value) {
		if(top <= 0) {
			System.out.println("full");
		}else {
			arr[--top] = value;
		}
	}
	
	public int pop() {
		int temp = -1;
		if(top == SIZE) {
			System.out.println("Empty");
		}else {
			temp = arr[top++];
		}
		return temp;
	}
	public int peek() {
		int temp = -1;
		if(top == SIZE) {
			System.out.println("Empty");
		}else {
			temp = arr[top];
		}
		return temp;
	}
}
public class DescendingStack {

	public static void main(String[] args) {
		Dstack st = new Dstack(2);
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("0. Exit\n1. Push\n2. Pop\n3. Peek");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.print("Enter value to be added : ");
				int value = sc.nextInt();
				st.push(value);
				break;
			case 2:
				System.out.println("Removed value : " + st.pop());
				break;
			case 3:
				System.out.println("Peeked value : " + st.peek());
				break;
			}
		}while(choice != 0);
		
		
		sc.close();
	}

}
