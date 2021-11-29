package com.crm.qa.pages;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class duplicateELementinJavaArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String names[] = {"Java", "JavaScript","Ruby","Java"};
		
		//Brute Force: O(n)square
		for(int i = 0; i<names.length;i++){
			for(int j=i+1; j<names.length;j++){
				if(names[i]==names[j]){
					System.out.println("Duplicate element is :" + names[i]);
				}
			}
		}
		//Using HashSet, child class object can be referred by parent interface reference variable
		Set<String> store = new HashSet<String>();
		for(String name : names){
			if(store.add(name)==false){
				System.out.println("Duplicate element is :" + name);
			}
		}
		//using hashMap
		Map<String,Integer> storeMap = new HashMap<String,Integer>();
		for(String name: names){
			Integer count = storeMap.get(name);
			if(count == null){
				storeMap.put(name, 1);
			}
			else{
				storeMap.put(name, storeMap.get(name)+1);
			}
		}
		//iterate values from hashMap object
		Set<Entry<String,Integer>> entrySet = storeMap.entrySet();
		for(Entry<String,Integer> entry : entrySet){
			if(entry.getValue()>1){
				System.out.println("Duplicate element is :" + entry.getKey() + ":" + entry.getValue());
			}
		}
		
	}

}
