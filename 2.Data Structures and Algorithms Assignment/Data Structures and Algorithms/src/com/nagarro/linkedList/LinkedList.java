package com.nagarro.linkedList;

import java.util.Scanner;

import com.nagarro.constant.ConsoleMessages;

public class LinkedList {
	Node head;
	private int size;

	LinkedList() {
		this.size = 0;
	}

	public class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
			size++;
		}
	}

	// insert at first
	public void insertAtBeginning(int data) {

		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	// insert at end
	public Node insertAtEnd(int data) {

		Node node = head;
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			node = head;
		} else {
			Node currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
		return node;
	}

	// insert at given position
	public void insertAtPosition(int data, int position) {
		if (position > size || position < 0) {
			System.out.println(ConsoleMessages.INVALID_POSITION);
		}
		Node newNode = new Node(data);
		if (head == null || position == 0) {
			newNode.next = head;
			head = newNode;
		}

		Node currentNode = head;
		for (int elementPosition = 1; elementPosition <= size; elementPosition++) {

			if (elementPosition == position) {
				Node nextNode = currentNode.next;
				currentNode.next = newNode;
				newNode.next = nextNode;
				break;
			}

			currentNode = currentNode.next;
		}
	}

	// delete at first
	public void deleteAtBeginning() {
		if (head == null) {
			System.out.println(ConsoleMessages.EMPTY_STRUCTURE);
		}

		head = head.next;
		size--;
	}

	// delete at last
	public void deleteAtEnd() {
		if (head == null) {
			System.out.println(ConsoleMessages.EMPTY_STRUCTURE);
		}
		size--;
		if (head.next == null) {
			head = null;
		}

		Node secondLastNode = head;
		Node lastNode = head.next;
		while (lastNode.next != null) {
			lastNode = lastNode.next;
			secondLastNode = secondLastNode.next;
		}
		secondLastNode.next = null;

	}

	// delete at given position
	public void deleteAtPosition(int position) {
		if (position > size || position < 0) {
			System.out.println(ConsoleMessages.INVALID_POSITION);
		}
		if (head == null) {
			System.out.println(ConsoleMessages.EMPTY_STRUCTURE);
		}

		size--;
		Node temp = head;
		if (position == 0) {
			head = temp.next;
		}
		for (int i = 0; i < position - 1; i++) {
			temp = temp.next;
		}
		Node nextNode = temp.next;
		temp.next = nextNode.next;
	}

	// reversing the linked list using iterator
	public void reverseLinkedList() {
		try {
			if (head == null || head.next == null) {
				throw new IndexOutOfBoundsException("Empty Linked List");
			}
			Node previousNode = head;
			Node currentNode = head.next;
			while (currentNode != null) {
				Node nextNode = currentNode.next;
				currentNode.next = previousNode;
				// update
				previousNode = currentNode;
				currentNode = nextNode;
			}
			head.next = null;
			head = previousNode;
		} catch (Exception e) {
			System.out.println("Exception in reverseLinkedList method");
		}
	}

	public void printLinkedList() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.print("null");
		System.out.println();

	}

	// Iterator For Linked List
	public void iteratorForLinkedList(Node head) {
		Node temp = head;
		System.out.println("Elements are: ");
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}

	}

	// get the size of linked list
	public int sizeOfLinkedList() {
		return size;
	}

	// middle node of linked list
	public Node middleNode(Node head) {
		Node node = head;
		if (head == null || head.next == null) {
			node = head;
		}

		Node fast = head.next;
		Node slow = head;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				node = slow;
				fast = fast.next;
			}
		}
		return node;
	}

	// merge sort on two linked list
	public Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node midNode = middleNode(head);

		Node left = head;
		Node right = midNode.next;
		midNode.next = null;

		left = mergeSort(left);
		right = mergeSort(right);

		Node result = merge(left, right);

		return result;
	}

	// merge two linked list
	public Node merge(Node left, Node right) {
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}

		Node mergedList = new Node(-1);
		Node temp = mergedList;

		while (left != null && right != null) {
			if (left.data < right.data) {
				temp.next = left;
				temp = left;
				left = left.next;
			} else {
				temp.next = right;
				temp = right;
				right = right.next;
			}
		}

		while (left != null) {
			temp.next = left;
			temp = left;
			left = left.next;
		}

		while (right != null) {
			temp.next = right;
			temp = right;
			right = right.next;
		}

		mergedList = mergedList.next;
		return mergedList;
	}

	@Override
	public String toString() {
		return "LinkedListClass [head=" + head + ", size=" + size + "]";
	}

	public static LinkedList getInputForLinkedList() {
		LinkedList list = new LinkedList();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// Creating LinkedList
		System.out.println("Enter the length of list you want to create: ");
		int length = sc.nextInt();
		System.out.println("Enter the values in linkedlist: ");
		for (int i = 0; i < length; i++) {
			list.insertAtEnd(sc.nextInt());
		}
		System.out.print("LinkedList: ");
		list.printLinkedList();
		System.out.println();
		return list;

	}

	public static void outputOfLinkedList(LinkedList list) {

		Scanner sc = new Scanner(System.in);

		System.out.println("LinkedList: ");
		list.printLinkedList();

		System.out.println("Size of LinkedList: " + list.sizeOfLinkedList());
		System.out.println("Enter the element at the beginning.");
		int first = sc.nextInt();
		list.insertAtBeginning(first);
		list.printLinkedList();

		System.out.println("Enter the element at the end.");
		int last = sc.nextInt();
		list.insertAtEnd(last);
		list.printLinkedList();

		System.out.println("Enter position to insert the element.");
		int position = sc.nextInt();
		System.out.println("Enter element at given position.");
		int data = sc.nextInt();
		list.insertAtPosition(data, position);
		list.printLinkedList();

		list.deleteAtBeginning();
		System.out.println("First element deleted.");
		list.printLinkedList();

		list.deleteAtEnd();
		System.out.println("Last element deleted.");
		list.printLinkedList();

		System.out.println("Enter the position of element you want to delete.");
		int delete = sc.nextInt();
		list.deleteAtPosition(delete);
		System.out.println("Element from position " + delete + " is deleted.");
		list.printLinkedList();

		System.out.println("Size of LinkedList: " + list.sizeOfLinkedList());

		Node mid = list.middleNode(list.head);
		System.out.println("Middle element of LinkedList: " + mid.data);

		System.out.print("LinkedList after Sorting: ");
		list.head = list.mergeSort(list.head);
		list.printLinkedList();

		System.out.print("Reverse of LinkedList: ");
		list.reverseLinkedList();
		list.printLinkedList();

		System.out.println("Iterating: ");
		list.iteratorForLinkedList(list.head);
	}

}
