package com.bridgeLabz;

import java.util.Scanner;

class LinkedList2 {

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	public void addFirst(int data) {
		Node newnode = new Node(data);

		if (head == null) {
			head = newnode;
			return;
		}
		newnode.next = head;
		head = newnode;
	}

	public void addLast(int data) {
		Node newnode = new Node(data);
		Node tempnode = head;

		if (head == null) {
			head = newnode;
			return;
		}

		while (tempnode.next != null) {
			tempnode = tempnode.next;
		}
		tempnode.next = newnode;
	}

	public void add(int data) {
		Node newnode = new Node(data);
		Node prevnode = head;
		Node tempnode = head.next;

		if (head == null) {
			addFirst(data);
			return;
		}
		
		if(head.data > data)
		{
			addFirst(data);
			return;
		}

		while (tempnode != null) {
			if (tempnode.data > data) {
				prevnode.next = newnode;
				newnode.next = tempnode;
				return;
			} else {
				prevnode = prevnode.next;
				tempnode = tempnode.next;
			}
		}

		addLast(data);
	}

	public void deleteFirst() {
		if (head == null) {
			System.out.println("List is empty! nothing to remove!");
			return;
		}
		head = head.next;
	}

	public void deleteLast() {
		if (head == null) {
			System.out.println("List is empty! nothing to remove!");
		}
		Node secondLast = head;
		Node last = head.next;

		while (last.next != null) {
			secondLast = secondLast.next;
			last = last.next;
		}
		secondLast.next = null;
	}

	public void delete(int data) {
		if (head == null) {
			System.out.println("List is empty! Nothing to delete!");
			return;
		}

		if (head.data == data) {
			deleteFirst();
			return;
		}

		Node prevnode = head;
		Node currnode = head.next;
		Node nextnode = currnode.next;

		while (nextnode != null) {
			if (currnode.data == data) {
				prevnode.next = nextnode;
				return;
			} else {
				prevnode = prevnode.next;
				currnode = currnode.next;
				nextnode = nextnode.next;
			}
		}

		if (currnode.data == data) {
			prevnode.next = null;
			return;
		}
		System.out.println(data + " does not exist in List!");
	}

	public void size() {
		int l = 0;
		Node tempnode = head;
		while (tempnode != null) {
			l++;
			tempnode = tempnode.next;
		}
		System.out.println("Size of list is " + l);
	}

	public int search(int data) {
		if (head == null) {
			System.out.println("List is empty!");
			addFirst(data);
			return -1;
		}
		if (head.data == data) {
			deleteFirst();
			return 0;
		}
		Node prevnode = head;
		Node tempnode = head.next;

		while (tempnode != null) {
			if (tempnode.data == data) {
				System.out.println(data + " present in linked list");
				prevnode.next = tempnode.next;
				return 0;
			} else {
				prevnode = prevnode.next;
				tempnode = tempnode.next;
			}
		}
		System.out.println(data + " element is not present!");
		add(data);
		return -1;
	}

	public void display() {
		if (head == null) {
			System.out.println("Linked List is null ");
			return;
		}
		Node tempnode = head;

		while (tempnode.next != null) {
			System.out.print(tempnode.data + "=>");
			tempnode = tempnode.next;
		}
		System.out.println(tempnode.data);
	}
}

public class OrderedList {
	LinkedList2 li = new LinkedList2();
	
	public void addArr(int arr[])
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
		
		for(int i=0;i<arr.length;i++)
		{
			li.addLast(arr[i]);
		}
	}
	
	public void display()
	{
		li.display();
	}

	public int search(int n)
	{
		return li.search(n);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderedList od = new OrderedList();
		
		int arr[] = {15,56,89,47,12,35,48,95,41,22,26,94};
		od.addArr(arr);
		od.display();
		System.out.println("Enter number you want to search");
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int res = od.search(n);
		if(res == 0)
			System.out.println("Element " + n +" deleted from list");
		else
			System.out.println("Element " + n + " added in list");
		od.display();
		sc.close();
	}

}
