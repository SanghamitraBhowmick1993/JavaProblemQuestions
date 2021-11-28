package com.crm.qa.pages;

public class PallindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pallindromeNum(121);

	}
	public static void pallindromeNum(int num){
		int org_num = num;
		int rev = 0;
		while(num!=0){
			rev = rev*10 + num%10;
			num = num/10;
		}
		if(org_num == rev){
			System.out.println("Pallindrome number :" + org_num);
		}
		else{
			System.out.println("Not a pallindrome");
		}
		
	}

}
