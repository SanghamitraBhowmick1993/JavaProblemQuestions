package com.crm.qa.pages;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class duplicateCharactersinString {

	public static void main(String[] args) {
		// Seleniumm e: 2 m:2
		// Selenium is a collection of api's - doesnot work, considers space as char, doesnot handle uppper case
		printDupCharacters("Selenium is a collection of api's");

	}
	
	public static void printDupCharacters(String str){
		if(str == null){
			System.out.println("NULL STRING");
			return; //void
		}
		if(str.isEmpty()){
			System.out.println("EMPTY STRING");
			return;
		}
		if(str.length()==1){
			System.out.println("One CHAR STRING");
			return;
		}
		char words[] = str.toCharArray();
		Map<Character,Integer> charMap = new HashMap<Character,Integer>();
		for(Character ch :words ){
			if(charMap.containsKey(ch)){
				charMap.put(ch, charMap.get(ch)+1);
			}
			else{
				charMap.put(ch,1);
			}
		}
		//print Map
		Set<Map.Entry<Character,Integer>> entrySet = charMap.entrySet();
		for(Map.Entry<Character, Integer> entry : entrySet){
			if(entry.getValue()>1){
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}
		}
	}

}
