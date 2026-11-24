package com.sunbeam;


class Heap{
	private int arr[];
	private int SIZE;
	
	public Heap(int length) {
		SIZE = 0;
		arr = new int[length + 1];
	}
	
	public boolean isEmpty() {
		return SIZE == 0;
	}
	
	public boolean isFull() {
		return SIZE == arr.length-1;
	}
	
	public int getMax() {
		return arr[1];
	}
	
	public void addHeap(int value) {
		if(isFull())
			return;
		SIZE++;
		arr[SIZE] = value;
		int ci = SIZE;
		int pi = ci / 2;
		while(pi > 0) {
			if(arr[pi] < arr[ci])
				break;
			int temp = arr[pi];
			arr[pi] = arr[ci];
			arr[ci] = temp;
			ci = pi;
			pi = ci / 2;
		}
	}
	
	public int deleteHeap() {
		if(isEmpty())
			return -1;
		int max = arr[1];
		
		arr[1] = arr[SIZE];
		
		SIZE--;
		
		//2. adjust position of promoted element
		int pi = 1;
		int ci = pi * 2;
		while(ci <= SIZE) {
			//2.1 find index of maximum child
			if((ci + 1) <= SIZE && arr[ci + 1] < arr[ci])
				ci = ci + 1;
			//2.2 if parent is greater than max child
			if(arr[pi] < arr[ci])
				break;
			//2.3 if parent is less than max child
			int temp = arr[ci];
			arr[ci] = arr[pi];
			arr[pi] = temp;
			//2.4 update parent and child index
			pi = ci;
			ci = pi * 2;
		}
		
		// return maximum/deleted value
		return max;
	}
}


class PriorityQueue{
	private Heap h;
	private int SIZE;
	
	public PriorityQueue(int size) {
		SIZE = size;
		h = new Heap(size);
	}
	
	public void push(int value) {
		h.addHeap(value);
	}
	
	public int pop() {
		return h.deleteHeap();
	}
	
	public int peek() {
		return h.getMax();
	}
	
	public boolean isEmpty() {
		return h.isEmpty();
	}
	
	public boolean isFull() {
		return h.isFull();
	}
}

public class PriorityQueueMainMin {

	public static void main(String[] args) {
		PriorityQueue q = new PriorityQueue(9);
		
		q.push(6);
		q.push(14);
		q.push(3);
		q.push(28);
		q.push(8);
		
		while(!q.isEmpty())
			System.out.println("Poped value : " + q.pop());
	}

}


