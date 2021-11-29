package com.crm.qa.pages;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class duplicateWordsinString {

	public static void main(String[] args) {
		//Hey java java is a language is java
		//java: 3
		//is : 2
		// does not handle upper case and comma in between sentence
		findDuplicateWords("Hey java java is a language is java");
	}
	public static void findDuplicateWords(String inputString){
		//split
		String words[] = inputString.split(" ");
		//create Map
		Map<String,Integer> wordCount = new HashMap<String,Integer>();	
		// to check each word in array
		for(String word: words){
			if(wordCount.containsKey(word)){
				wordCount.put(word, wordCount.get(word)+1);
			}
			else{
				wordCount.put(word,1);
			}
		}
		//extracting the keys of map
		Set<String> wordsInString = wordCount.keySet();
		//loop all words in map
		for(String word: wordsInString){
			if(wordCount.get(word)>1){
				System.out.println(word + ":" + wordCount.get(word));
			}
			
		}
		
		
	}

}
