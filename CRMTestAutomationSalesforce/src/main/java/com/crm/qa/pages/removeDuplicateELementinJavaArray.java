package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class removeDuplicateELementinJavaArray {

	public static void main(String[] args) {
		//ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,3,2,4,3,7,5,7));
		
		ArrayList<String> names = new ArrayList<String>(Arrays.asList("Java", "Python","Java","Python","Ruby","C"));

		
		//using linkedHashSet for Integers
		/*LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>(numbers);
		ArrayList<Integer> numberListwithoutDups = new ArrayList<Integer>(linkedHashSet);
		System.out.println(numberListwithoutDups);
		*/
		
		
		//using linkedHashSet for Strings
				LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>(names);
				ArrayList<String> numberListwithoutDups = new ArrayList<String>(linkedHashSet);
				System.out.println(numberListwithoutDups);
				
	}

}
