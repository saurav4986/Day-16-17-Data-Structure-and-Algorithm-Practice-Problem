package com.bridgeLabz;

import java.util.Scanner;

class LinkedList3 extends LinkedList {
	
	public String deleteFirst2()
	{
		if (head == null) {
			System.out.println("List is empty! nothing to remove!");
			return null;
		}
		Node temp = head;
		head = head.next;
		return temp.data;
	}
}

class Queue2{
	LinkedList3 li = new LinkedList3();
	
	public void enqueue(String name)
	{
		li.addLast(name);
		return;
	}
	
	public void display()
	{
		li.display();
	}
	
	public String dequeue()
	{
		return li.deleteFirst2();
	}
}

public class BankingCashCounter {

	Queue2 q;
	int balance = 0;
	int sz = 0;
	
	BankingCashCounter()
	{
		q = new Queue2();
	}
	
	public void addpeople(String name,int amount,String op)
	{
		sz++;
		q.enqueue(name);
		if(op.equals("deposit"))
			balance += amount;
		else
		{
			if(balance > amount)
				balance -= amount;
			else
				System.out.println("Insufficient balance");
		}
	}
	
	public void finish()
	{
		for(int i=0;i<sz;i++)
		{
			String na = q.dequeue();
			System.out.println(na+ " banking operation completed!");
		}
	}
	
	public static void main(String args[])
	{
		System.out.println("Add people to bank queue");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of people");
		int n = sc.nextInt();
		BankingCashCounter bc = new BankingCashCounter();
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter peron name");
			String name = sc.next();
			System.out.println("Enter \"deposit\" for deposition and \"withdraw\" for withdrawal of money");
			String op = sc.next();
			System.out.println("Enter amout");
			int amount = sc.nextInt();
			bc.addpeople(name, amount, op);
		}
		
		System.out.println("Doing bank procedure...");
		bc.finish();
	}
}
