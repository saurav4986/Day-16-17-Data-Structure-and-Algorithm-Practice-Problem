package com.bridgeLabz;

import java.util.Hashtable;

public class Anagram {
	
	public boolean isAnagram(String s1, String s2)
	{
		if(s1.length() != s2.length())
			return false;
//		String arr1 = s1.toCharArray();
//		char arr2[] = s2.toCharArray();

		Hashtable<String, Integer> h1 = new Hashtable<>();
		Hashtable<String, Integer> h2 = new Hashtable<>();
		
		for(int i=0;i<s1.length();i++)
		{
			if(h1.containsKey(""+s1.charAt(i)))
				h1.put(""+s1.charAt(i), h1.get(""+s1.charAt(i))+1);
			else
				h1.put(""+s1.charAt(i), 1);
		}
		for(int i=0;i<s2.length();i++)
		{
			if(h2.containsKey(s2.charAt(i)))
				h2.put(""+s2.charAt(i), h2.get(""+s2.charAt(i))+1);
			else
				h2.put(""+s2.charAt(i), 1);
		}
		
		//System.out.println(h1.toString());

		return h1.equals(h2);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "earth";
		String s2 = "heart";
		
		Anagram an = new Anagram();
		if(an.isAnagram(s1, s2))
		{
			System.out.println("String "+s1+" and String "+s2+" are anagram!");
		}
		else
		{
			System.out.println("String "+s1+" and String "+s2+" are not anagram!");
		}
	}

}
