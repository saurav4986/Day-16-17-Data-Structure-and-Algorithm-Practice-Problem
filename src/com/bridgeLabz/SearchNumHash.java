package com.bridgeLabz;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class HashNode<K, V> {
	K key;
	V value;

	final int hashcode;
	HashNode next;

	HashNode(K key, V value, int hashcode) {
		this.key = key;
		this.value = value;
		next = null;
		this.hashcode = hashcode;
	}

	HashNode(String key, Integer value, int hashcode) {
		this.key = (K) key;
		this.value = (V) value;
		next = null;
		this.hashcode = hashcode;
	}
}

class MyMapNode<K, V> {
	private ArrayList<HashNode<K, V>> bucketList;

	private int numBuckets;

	private int size;

	MyMapNode() {
		bucketList = new ArrayList<>();
		numBuckets = 10;
		size = 0;

		for (int i = 0; i < 10; i++) {
			bucketList.add(null);
		}
	}

	public final int hashcode(K key) {
		return Objects.hashCode(key);
	}

	public int getBucketIndex(K key) {
		int index = hashcode(key) % numBuckets;
		index = index < 0 ? index * -1 : index;
		return index;
	}

	public void add(K key, V value) {

		HashNode<K, V> newnode = new HashNode(key, value, hashcode(key));
		int index = getBucketIndex(key);

		HashNode head = bucketList.get(index);

		if (head == null) {
			bucketList.set(index, newnode);
			size++;
			return;
		}

		HashNode tempnode = head;

		while (tempnode != null) {
			if (tempnode.key.equals(key)) {
				tempnode.value = ((Integer) tempnode.value) + (Integer) value;
				return;
			}
			tempnode = tempnode.next;
		}

		newnode.next = head;
		bucketList.set(index, newnode);
		size++;
	}

	public void remove(K key) {
		int index = getBucketIndex(key);
		HashNode temp = bucketList.get(index);

		if (temp == null) {
			System.out.println("Key " + key + " not present!");
			return;
		}

		if (temp.key.equals(key) && temp.next == null) {
			bucketList.set(index, null);
			return;
		}

		HashNode slast = temp;
		HashNode last = temp.next;

		while (slast.next != null) {
			if (temp.key.equals(key)) {
				bucketList.set(index, last);
				return;
			}

			if (last.key.equals(key)) {
				slast.next = last.next;
				return;
			}

			slast = slast.next;
			last = last.next;
		}
		System.out.println("Key " + key + " not present!");
	}

	public void expandList() {
		for (int i = 0; i < 10; i++) {
			bucketList.add(null);
		}
		this.numBuckets = 20;
	}

	public void display() {
		int i = 0;
		for (HashNode<K, V> item : bucketList) {
			if (item == null) {
				System.out.println("[   ] => ");
				i++;
				continue;
			} else {
				System.out.print("[ " + i + " ] => ");
				while (item != null) {
					System.out.print("key =>" + item.key + ",  value => " + item.value + ", ");
					item = item.next;
				}
				i++;
			}
			System.out.println();
		}
		System.out.println();
	}

	public int search(K value) {
		int index = getBucketIndex(value);
		// System.out.println("index is " + index);
		HashNode<K, V> head = bucketList.get(index);

		while (head != null) {
			// System.out.println(" data is " + head.value+" and value is "+value);
			if (head.value.equals(value))
				return index;
			else
				head = head.next;
		}

		return -1;
	}

}

public class SearchNumHash {

	MyMapNode<Integer, Integer> MyMap;

	SearchNumHash(int arr[]) {
		MyMap = new MyMapNode<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			MyMap.add(arr[i], arr[i]);
		}
		MyMap.display();
	}

	public int searchNum(int num) {
		int res = MyMap.search(num);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 23, 56, 75, 32, 14, 5, 7, 53, 90, 996, 12, 346, 19, 31, 100, 213, 29, 1, 11, 108 };
		SearchNumHash sm = new SearchNumHash(arr);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number you wanna search");
		int n = sc.nextInt();
		int res = sm.searchNum(n);
		if (res >= 0)
			System.out.println(n + " is present at index " + res);
		else
			System.out.println(n + " is not present in list");
	}

}
