package com.bridgeLabz;

class LinkedList {

	class Node {
		String data;
		Node next;

		Node(String data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	public void addFirst(String data) {
		Node newnode = new Node(data);

		if (head == null) {
			head = newnode;
			return;
		}
		newnode.next = head;
		head = newnode;
	}

	public void addLast(String data) {
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

	public void add(String data, int index) {
		int i = 1;
		Node newnode = new Node(data);
		Node prevnode = head;
		Node tempnode = head.next;

		if (head == null) {
			addFirst(data);
			return;
		}

		while (tempnode != null) {
			if (i == index) {
				prevnode.next = newnode;
				newnode.next = tempnode;
				return;
			} else {
				i++;
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

	public void delete(String data) {
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

	public int search(String data) {
		if (head == null) {
			System.out.println("List is empty!");
			addFirst(data);
			return -1;
		}
		if (head.data.equals(data)) {
			deleteFirst();
			return 0;
		}
		Node prevnode = head;
		Node tempnode = head.next;

		while (tempnode != null) {
			if (tempnode.data.equals(data)) {
				System.out.println(data + " present in linked list");
				prevnode.next = tempnode.next;
				return 0;
			} else {
				prevnode = prevnode.next;
				tempnode = tempnode.next;
			}
		}
		System.out.println(data + " element is not present!");
		addLast(data);
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

class Stack{
	LinkedList li = new LinkedList();
	
	public void push(String data)
	{
		li.addFirst(data);
		return;
	}
	
	public void display()
	{
		li.display();
	}
	
	public String peak()
	{
		if(li.head == null)
		{
			System.out.println("Stack is empty!");
			return null;
		}
		return li.head.data;
	}
	
	public String pop()
	{
		if(li.head == null)
		{
			System.out.println("Stack is empty!");
			return null;
		}
		String data = li.head.data;
		li.head = li.head.next;
		return data;
	}
	
	public boolean isEmpty()
	{
		if(li.head == null)
			return true;
		else
			return false;
	}
}


public class BalancedParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)";
		Stack st = new Stack();
		boolean earlyCheck = true;
		
		for(int i=0;i<s1.length();i++)
		{
			if(s1.charAt(i) == '(')
			{
				st.push(""+s1.charAt(i));
			}
			if(s1.charAt(i) == ')')
			{
				if(st.pop() == null)
				{
					System.out.println("No ( tag present for closing tag )!paranthesis not balanced!");
					earlyCheck = false;
					break;
				}
			}
		}
		
		if(earlyCheck)
		{
		if(st.isEmpty())
			System.out.println("Parenthesis are balanced");
		else
			System.out.println("paranthesis are not balanced!");
		}
	}

}
