package com.bridgeLabz;

class myList extends LinkedList{
	
	public String deleteLastString()
	{
		if (head == null) {
			System.out.println("List is empty! nothing to remove!");
			return null;
		}
		
		if(head.next == null)
		{
			String s = head.data;
			deleteFirst();
			return s;
		}
		
		Node secondLast = head;
		Node last = head.next;

		while (last.next != null) {
			secondLast = secondLast.next;
			last = last.next;
		}
		secondLast.next = null;
		return last.data;
	}
}
class Queue{
	myList li = new myList();
	
	public void enqueue(String data)
	{
		li.addLast(data);;
		return;
	}
	
	public void display()
	{
		li.display();
	}
	
	public void dequeue()
	{
		li.deleteFirst();
	}
	
	public String dequeueRear()
	{
		return li.deleteLastString();
	}
}
public class Palindrome {

	public boolean checkPalindrome(String s)
	{
		Queue q = new Queue();
		for(int i=0;i<s.length();i++)
		{
			//System.out.println("adding "+s.charAt(i));
			q.enqueue(""+s.charAt(i));
		}
		
		//q.display();
		String s2 = "";
		
		while(q.li.head != null)
		{
			s2 += q.dequeueRear();
		}
		
		if(s.equals(s2))
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Palindrome pn = new Palindrome();
		String s = "tobot";
		
		if(pn.checkPalindrome(s))
			System.out.println("String " + s+ " is a palindrome");
		else
			System.out.println("String " + s+ " is not a palindrome");
	}

}
