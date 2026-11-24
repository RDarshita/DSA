package com.demo;

import java.util.Scanner;

public class BinarySearchDesc {
	public static int binary(int nums[],int key) {
		int left = 0,right = nums.length-1;
		int mid;
		while(left <= right) {
			mid = (left+right)/2;
			if(key == nums[mid]) {
				return mid;
			}else if(key > nums[mid]) {
				right = mid-1;
			}else if(key < nums[mid]) {
				left = mid+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int nums[] = {99,88,66,44,33,11};
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter key : ");
		int key = sc.nextInt();
		
		int idx = binary(nums,key);
		if(idx != -1) {
			System.out.println("Found" + (idx+1));
		}else {
			System.out.println("Not Found");
		}
	}

}
