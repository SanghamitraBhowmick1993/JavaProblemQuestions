package com.crm.qa.pages;

public class ArmStrongNumber {

	public static void main(String[] args) {
		System.out.println(isArmStrongNumber(153));
	}
	public static int power(int numbr){
		int n=0;
		while(numbr!=0){
			n++;
			numbr = numbr/10;
		}
		return n;
	}
	public static boolean isArmStrongNumber(int num){
		
		if(num<0){
			return false;
		}
		if(num>=0 && num<=9){
			return true;
		}
		int power = power(num);
		int copyNum = num;
		int sum = 0;
		while(copyNum!=0){
			int lastDigit = copyNum%10;
			int fact = 1;
			for(int i =0;i<power;i++){
				fact = fact* lastDigit;
			}
			sum = sum+fact;
			copyNum = copyNum/10;
		}
		if(sum == num){
			return true;
		}
		return false;
	}
	
}
