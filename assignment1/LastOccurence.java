package com.demo;

import java.util.Scanner;

public class LastOccurence {
	public static int linear(int nums[], int key) {
		for(int i=nums.length-1;i>0;i--) {
			if(nums[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int nums[] = {11,22,88,77,66,90,66,77};
		Scanner sc = new Scanner(System.in);
		System.out.println("Key : ");
		int key = sc.nextInt();
		
		int idx = linear(nums,key);
		if(idx != -1) {
			System.out.println("Found" + idx);
		}else {
			System.out.println("Not Found");
		}
		sc.close();
	}

}
