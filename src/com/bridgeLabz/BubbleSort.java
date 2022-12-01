package com.bridgeLabz;

import java.util.Scanner;

public class BubbleSort {
	
	public static int[] sort(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i;j<arr.length;j++)
			{
				if(arr[i] > arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of nums to sort");
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		
		arr = BubbleSort.sort(arr);
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + "  ");
		}
	}

}
