package com.bridgeLabz;

public class MergeSort {
	
	int arr[];
	
	MergeSort(int arr[])
	{
		this.arr = arr;
	}
//	
//	public int[] sort()
//	{
//		arr = mergeSort(arr,0,arr.length-1);
//		return arr;
//	}
	
	private void mergeSort(int l, int r,int iteration)
	{
		System.out.println("In mergeSort with values l="+l+" r="+r+" in "+iteration+" iteration");
		if(l>=r)
			return;
		int m = (l+r)/2;
		System.out.println("Dividing left in "+iteration+" iteration");
		mergeSort(l,m,iteration+1);
		System.out.println("Dividing right in "+iteration+" iteration");
		mergeSort(m+1,r,iteration+1);
		merge(l,m,r);
	}
	
	public void merge(int l,int m,int r)
	{
		//int arr1[] = new int[m-l+1];
		//int arr2[] = new int[r-m];
		System.out.println("Called merge with values l="+l+"  m=" +m+"  r="+r);
		int merged[] = new int[r-l+1];
		int ind1 = l;
		int ind2 = m+1;
		int mind = 0;
		
		while(ind1 <= m && ind2 <= r)
		{
			if(arr[ind1] < arr[ind2])
			{
				merged[mind] = arr[ind1];
				mind++;
				ind1++;
			}
			else
			{
				merged[mind] = arr[ind2];
				mind++;
				ind2++;
			}
		}
		
		while(ind1<=m)
		{
			merged[mind++] = arr[ind1++];
		}
		
		while(ind2<=r)
		{
			merged[mind++] = arr[ind2++];
		}
		
		System.out.println("Merged array is ");
		for(int i=0;i<merged.length;i++)
		{
			System.out.print(merged[i] + " ");
		}
		System.out.println();
		
		int mergind = 0;
		for(int i=l;i<=r;i++)
		{
			arr[i] = merged[mergind++];
			//System.out.print("Merged " + merged[mergind-1]+" in arr  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		int arr[] = {23,56,74,13,94,7,26,2,28};
		MergeSort mg = new MergeSort(arr);
		mg.mergeSort(0, arr.length-1,1);
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(mg.arr[i]);
		}
		
	}

}
