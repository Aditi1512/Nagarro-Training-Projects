package com.nagarro.stack;

import java.util.Scanner;

public class Stack {

	Node head;
	int size;

	Stack() {
		this.size = 0;
	}

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
			size++;
		}
	}

	// isEmpty - Checking if Stack is Empty
	public boolean isEmpty() {
		return head == null;
	}

	// Push - Insert an element
	public void pushElement(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	// Pop - Delete an element
	public int popElement() {
		int element = 0;
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			element = -1;
		} else {
			size--;
			int top = head.data;
			head = head.next;
			element = top;
		}
		return element;

	}

	// Peek - Returns top element
	public int peekOfStack() {
		int peek = 0;
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			peek = -1;
		} else {
			peek = head.data;
		}
		return peek;
	}

	// Reverse Stack
	public void reverseStack() {
		if (head == null || head.next == null) {
			System.out.println("Stack is Empty");
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
	}

	// Middle element of Stack
	public Node middleElement(Node head) {
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

	// Merge sort
	public Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node midnode = middleElement(head);

		Node left = head;
		Node right = midnode.next;
		midnode.next = null;

		left = mergeSort(left);
		right = mergeSort(right);

		Node mergedList = merge(left, right);
		head = mergedList;
		return mergedList;
	}

	// Merging
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
		head = mergedList;
		return mergedList;
	}

	// contains, searching for an element
	public void containsElement(int data) {
		try {
			if (isEmpty()) {
				throw new IndexOutOfBoundsException("Empty Stack");
			}
			Node node = head;
			int found = 0;
			while (node != null) {
				if (node.data == data) {
					found = 1;
				}
				node = node.next;
			}
			if (found == 1) {
				System.out.println("Element " + data + " is present in the stack.");
			} else {
				System.out.println("Element is not present in the Stack.");
			}
		} catch (Exception e) {
			System.out.println("Exception in containsElement method" + e.getMessage() + e.getStackTrace());
		}
	}

	// Size
	public void sizeOfStack() {
		System.out.println(size);
	}

	// Printing Stack
	public void printStack() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.print("null \n");
	}

	// Iterator For Stack
	public void iteratorForStack(Node head) {
		Node temp = head;
		System.out.println("Elements are: ");
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}

	}

	// Creating Stack
	public static Stack getInputForStack() {
		Stack stack = new Stack();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of Stack you want to create: ");
		int length = sc.nextInt();
		System.out.println("Enter the values in Stack: ");
		for (int i = 0; i < length; i++) {
			stack.pushElement(sc.nextInt());
		}
		return stack;

	}

	public static void outputOfStack(Stack stack) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Stack is: ");
		stack.printStack();

		System.out.println("Center Element = " + stack.middleElement(stack.head).data);

		System.out.println("Size Of Stack is: ");
		stack.sizeOfStack();

		System.out.println("Item is deleted from top of Stack is: " + stack.popElement());
		System.out.println("Stack after deletion of an item from top: ");
		stack.printStack();

		System.out.println("Size Of Stack is: ");
		stack.sizeOfStack();

		System.out.println("Center Element = " + stack.middleElement(stack.head).data);

		stack.mergeSort(stack.head);
		System.out.println("Stack after Sorting: ");
		stack.printStack();

		System.out.println("Stack after Reverse: ");
		stack.reverseStack();
		stack.printStack();

		System.out.println("Enter the data you want to search: ");
		int data = sc.nextInt();
		stack.containsElement(data);

		System.out.println("Iterating: ");
		stack.iteratorForStack(stack.head);
	}
}
