package com.bridgeLabz;

import java.util.ArrayList;

public class PrimeNumbers {
	int rng = 0;
	ArrayList<Integer> arr = new ArrayList<>();
	
	public void findPrime(int n)
	{
		this.rng = n;
		System.out.println("Prime numbers from 0 to "+ n +" are ");
		int s = 2;
		while(s <= n)
		{
			boolean prime = true;
			for(int i=2;i<=s/2;i++)
			{
				if(s%i == 0) {
					prime = false;
					break;
				}
			}
			
			if(prime)
			{
				arr.add(s);
				System.out.print(s+"  ");
			}
			s++;
		}
		System.out.println();
	}
	
	public void printAnagrams()
	{
		Anagram an = new Anagram();
		System.out.println("Anagrams in 0-"+rng+" prime numbers are ...");
		
		for(int i=0;i<arr.size()-1;i++)
		{
			int n = arr.get(i);
			String s1 = Integer.toString(n);
			for(int j=i+1;j<arr.size();j++)
			{
				int n2 = arr.get(j);
				String s2 = Integer.toString(n2);
				if(an.isAnagram(s1, s2))
					System.out.print("( "+s1+","+s2+" ) ");
			}
		}
		System.out.println();
	}
	
	public void printPalindromes()
	{
		System.out.println("Palindromes in 0-"+rng+" prime numbers are ...");
		Palindrome p = new Palindrome();
		for(int i=0;i<arr.size();i++)
		{
			int n = arr.get(i);
			String s = Integer.toString(n);
			if(p.checkPalindrome(s))
				System.out.print(s+ "  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrimeNumbers pm = new PrimeNumbers();
		pm.findPrime(1000);
		pm.printAnagrams();
		pm.printPalindromes();
	}

}
