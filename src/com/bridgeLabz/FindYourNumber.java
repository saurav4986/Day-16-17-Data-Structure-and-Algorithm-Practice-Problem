package com.bridgeLabz;

import java.util.Scanner;

public class FindYourNumber {

	public static int guessNumber(int high, int low,Scanner sc)
	{
		if(high == low)
			return high;
		int mid = low + (high-low)/2;
		int n = 0;
		System.out.println("Is number between "+low+" and "+mid+"  Enter yes or no");
		String check = sc.next();
		
		if(check.equals("yes"))
			n = guessNumber(mid,low,sc);
		else
			n = guessNumber(high,mid+1,sc);
		return n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter any number between 0 and 10000");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int guess = FindYourNumber.guessNumber(10000, 0, sc);
		System.out.println("guessed number is " + guess);
	}

}
