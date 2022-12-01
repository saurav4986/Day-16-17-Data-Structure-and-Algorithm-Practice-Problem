package com.bridgeLabz;

public class BinarySearchWord {
	
	public int binarySearch(String st,String arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i;j<arr.length;j++)
			{
				if(arr[i].compareTo(arr[j]) > 0)
				{
					String temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		int l = 0;
		int r = arr.length-1;
		int m = l + (r-l)/ 2;
		System.out.println("m is " + m + " and val is " + arr[m]);
		
		while(l < r)
		{
			System.out.println("in loop l="+l+"  r="+r+"  m="+m);
			System.out.println("arr[m] is "+arr[m]);
			if(arr[m].equals(st))
				return m;
			if(arr[m].compareTo(st) < 0)
			{
				//System.out.println("Inside less");
				l = m+1;
				m = l + (r-l) / 2;
			}
			else
			{
				System.out.println("Inside else");
				r = m;
				m = l + (r-l)/2;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String arr[] = {"Sonu","Jalu","Sagar","Anil","Shrikant","Ajinath","Vishwam","Tejas","Vishal"};
		BinarySearchWord wd = new BinarySearchWord();
		int ind = wd.binarySearch("Soni", arr);
		if(ind >= 0)
			System.out.println("String "+arr[ind]+" exists!");
		else
			System.out.println("String does not exist!");
	}

}
