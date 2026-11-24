package com.demo;

import java.util.HashMap;
import java.util.Map;

public class Mode {

	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 2, 5, 2, 3, 4,4,4,4};
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int a : arr) {
			map.put(a, map.getOrDefault(a, 0)+1);
		}
		
		int mode = arr[0];
		int count = 0;
		
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			if(entry.getValue() > count) {
				count = entry.getValue();
				mode = entry.getKey();
			}
		}
		
		System.out.println(mode);
		System.out.println(count);
	}

}
