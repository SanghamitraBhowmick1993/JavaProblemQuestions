package com.crm.qa.pages;

public class MissingNumInIntegerArray {

	public static void main(String[] args) {
		int num[] ={1,2,4,5};
		int n1 = findMissingNumber(num,5);
		System.out.println(n1);

	}
	public static int findMissingNumber(int num[], int totalCount){
		int expSum = totalCount *((totalCount+1)/2);
		int actualSum =0;
		for(int i : num){
			actualSum =actualSum+i;
		}
		return expSum-actualSum;
	}

}
