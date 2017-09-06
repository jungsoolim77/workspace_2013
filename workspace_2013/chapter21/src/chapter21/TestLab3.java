package chapter21;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TestLab3 {
	static HashMap<String, Integer> hm;
	static TreeMap<String, Integer> tm;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		hm = new HashMap<String, Integer>();
		tm = new TreeMap<String, Integer>();
		hm.put("one", 1);
		hm.put("two", 2);
		hm.put("three", 3);
		tm.putAll(hm);
		System.out.println(tm.toString());
		

	}
	
	
	public static void testing(Map<String, Integer> list1, Map<String, Integer> list2){
		list1.putAll(list2);
		
	}

}
