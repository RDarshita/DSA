package com.demo;

public class FibonacciSeries {
	public static int fib(int n) {
		if(n == 1) {
			return 0;
		}
		if(n == 2) {
			return 1;
		}
		int f1 = fib(n-1);
		int f2 = fib(n-2);
		return f1+f2;
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(fib(n));
	}

}
