package com.demo;

import java.util.Scanner;

public class NthOccurrence {
	public static int linearSear(int nums[],int key,int n){
		int c = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i] == key) {
				c++;
				if(c == n) {
					return i;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int nums[] = {11,22,88,77,66,90,66,77,66,66};
		Scanner sc = new Scanner(System.in);
		System.out.print("Key : ");
		int key = sc.nextInt();
		System.out.print("N : ");
		int n = sc.nextInt();
		
		int idx = linearSear(nums,key,n);
		if(idx != -1) {
			System.out.println("Found" + idx);
		}else {
			System.out.println(-1);
		}
		sc.close();
	}
}
