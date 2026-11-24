package com.demo;

import java.util.Arrays;

public class DescInsertionOrder {
	public static void insertion(int arr[]) {
		for(int i=1;i<arr.length;i++) {
			int temp = arr[i];
			int j;
			for(j=i-1;j>=0;j--) {
				if(arr[j]<temp) {
					arr[j+1]=arr[j];
				}else {
					break;
				}
			}
			arr[j+1] = temp;
		}
	}

	public static void main(String[] args) {
		int arr[] = {44, 11, 55, 22, 66, 33};
		
		System.out.println("Array before sort : " + Arrays.toString(arr));
		insertion(arr);
		System.out.println("Array after sort : " + Arrays.toString(arr));

	}

}
