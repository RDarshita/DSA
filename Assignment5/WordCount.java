package com.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        String[] words = str.toLowerCase().split("\\s+");
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String word : words) {
        	map.put(word , map.getOrDefault(word, 0)+1);
        }
        
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
        	System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}