package chapter21;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lab3 {
	static String fileName = "E:\\Lincoln.txt";
	
	public static void main(String[] args) throws Exception {
//		readWords();
//		getWords();
//		getNoDupWords();
//		getNoDupWordsUsingSet();
//		readNonDuplicate();
//		countVowels();
		countWords();
		// TODO Auto-generated method stub
//		ArrayList<Integer> array = new ArrayList<>();
//		Integer[] temp = {1, 2 ,3};
//		array.addAll(Arrays.asList(temp));
				

	}
	
	public static void readWords(){
		Scanner in = new Scanner(System.in);
		List<String> list = new LinkedList<>();
		
		System.out.println("Please enter words and end with \"end\"");
		while(in.hasNext()){
			String temp = in.next();
			if(temp.equals("end"))
				break;
			else
				list.add(temp);
		}
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.print(it.next() + "  ");
		}
		
		System.out.println();
	}
	
	public static void getWords(){
		Scanner in = new Scanner(System.in);
		List<String> list = new LinkedList<>();
		
		System.out.println("Please enter your word and end with word end");
		
		while(in.hasNext()){
			String temp = in.next();
			if(temp.equals("end")){
				break;
			} else {
				list.add(temp);
			}
		}
		
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		in.close();
	}
	
	public static void getNoDupWords(){
		Scanner in = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		
		System.out.println("Please enter your word and end with word end");
		while(in.hasNext()){
			String temp = in.next();
			if(temp.equals("end")){
				break;
			} else if(!list.contains(temp)) {
				list.add(temp);
			}
		}
	
		Collections.sort(list);
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		in.close();
	}
	
	public static void getNoDupWordsUsingSet(){
		Scanner in = new Scanner(System.in);
		Set<String> set = new TreeSet<>();
		
		System.out.println("Please enter your word and end with word end");
		while(in.hasNext()){
			String temp = in.next();
			if(!temp.equals("end")){
				set.add(temp);
			} 
		}
	
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		in.close();
	}
	public static void readNonDuplicate() throws Exception{
		Scanner input = new Scanner(new File(fileName));
		Set<String> treeSet = new TreeSet<String>();
		while(input.hasNext()){
			treeSet.add((input.next()).replaceAll("[-,.?]", ""));
		}
		
		Iterator<String> it = treeSet.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		input.close();
	}
	
	public static void countVowels() throws Exception{
		Scanner input = new Scanner(new File(fileName));
		Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
		hashMap.put('A',0);
		hashMap.put('E',0);
		hashMap.put('I',0);
		hashMap.put('U',0);
		hashMap.put('O',0);
		
		
		while(input.hasNext()){
			String temp = (input.next()).toUpperCase();
//			System.out.println(temp);
			for(int i = 0; i < temp.length(); i++){
			switch(temp.charAt(i)){
				case 'A': hashMap.put(temp.charAt(i), hashMap.get(temp.charAt(i)) + 1 ); break;
				case 'E': hashMap.put(temp.charAt(i), hashMap.get(temp.charAt(i)) + 1 ); break;
				case 'I': hashMap.put(temp.charAt(i), hashMap.get(temp.charAt(i)) + 1 ); break;
				case 'U': hashMap.put(temp.charAt(i), hashMap.get(temp.charAt(i)) + 1 ); break;
				case 'O': hashMap.put(temp.charAt(i), hashMap.get(temp.charAt(i)) + 1 ); break;
			}
			}
		}
		
		Iterator it = hashMap.entrySet().iterator();
		Integer sum = 0;
		Set<Map.Entry<Character, Integer>> entrySet = hashMap.entrySet();
		for(Map.Entry<Character, Integer> entry: entrySet){
			sum+=entry.getValue();
		}

		while(it.hasNext()){
		 Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
		}
		 System.out.println("Total vowels are " + sum.toString());
		input.close();
		
	}
	
	
	public static void countWords() throws Exception{
		Scanner input = new Scanner(new File(fileName));
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
				
		while(input.hasNext()){
			String temp = input.next();
			temp = temp.replaceAll("[-,.?]", "");
			if(temp.length()>0){
				if(hashMap.containsKey(temp)){
					hashMap.put(temp, (hashMap.get(temp) + 1));
				}else{
					hashMap.put(temp, 1);
				}
			}
			
		}
		
		Iterator it = hashMap.entrySet().iterator();

		while(it.hasNext()){
		 Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getValue() + "\t = " + pair.getKey());
		}
		
		input.close();
		
	}
	


}
