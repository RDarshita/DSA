package com.demo;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {
	public static int findFirst(int arr[]) {
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int num : arr) {
			map.put(num,map.getOrDefault(num,0)+1);
		}
		
		for(int num : arr) {
			if(map.get(num) == 1) {
				return num;
			}
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, -1, 2, 1, 0, 4, -1, 7, 8};
		int result = findFirst(arr);
		if(result != Integer.MIN_VALUE) {
			System.out.println("Result : "+result);
		}else {
			System.out.println("Non repeating");
		}
 	}

}
