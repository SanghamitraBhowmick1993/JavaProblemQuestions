package com.crm.qa.pages;

public class PallindromeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pallindromString("MADAM");

	}
	public static void pallindromString(String str){
		String org_str = str;
		String rev = "";
		int len = str.length();
		for(int i = len-1;i>=0;i--){
			rev = rev + str.charAt(i);
		}
		if(org_str.equals(rev)){
			System.out.println("Pallindrome string: " + org_str);
		}
		else{
			System.out.println("Not a Pallindrome String");
		}
	}

}
