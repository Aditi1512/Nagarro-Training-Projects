package com.nagarro.queue;

import java.util.Scanner;

public class Queue {

	int size;
	Node head = null;
	Node tail = null;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
			size++;
		}
	}

	// isEmpty - Checking if Queue is Empty
	public boolean isEmpty() {
		return head == null && tail == null;
	}

	// Enqueue - adding elements
	public void addElement(int data) {
		Node newNode = new Node(data);
		if (tail == null) {

			tail = head = newNode;
		} else {

			tail.next = newNode;
			tail = newNode;
		}
	}

	// Dequeue - deleting elements
	public int deleteElement() {
		int deletedElement = 0;
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			deletedElement = -1;
		} else {
			int front = head.data;
			if (head == tail) {
				tail = null;
			}
			head = head.next;
			size--;
			deletedElement = front;
		}
		return deletedElement;
	}

	// Peek
	public int peek() {
		int peek = 0;
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			peek = -1;
		} else {
			peek = head.data;
		}
		return peek;
	}

	// Middle element of Queue
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

	// Iterator
	public Node iterator(Node head) {
		Node node = head;
		while (head == null || head.next == null) {
			node = head;
		}
		Node temp = head;
		while (temp != null && temp.next != null) {
			temp = temp.next;
			node = temp;
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
		tail = iterator(head);
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
		return mergedList;
	}

	// Reversing the queue
	public void reverseQueue() {
		if (head == null || head.next == null) {
			System.out.println("Queue is Empty");
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

		tail = head;
		tail.next = null;
		head = previousNode;
	}

	// Searching for an element in queue
	public void contains(int data) {
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
				System.out.println("Element " + data + " found.");
			} else {
				System.out.println("Element is not present in the Queue.");
			}
		} catch (Exception e) {
			System.out.println("Exception in contains method");
		}
	}

	// Size of queue
	public void sizeOfQueue() {
		System.out.println("Size of Queue : " + size);
	}

	// Printing the queue
	public void printQueue(Node node) {
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.print("null \n");
	}

	// Iterator For Queue
	public void iteratorForQueue(Node head) {
		Node temp = head;
		System.out.println("Elements are: ");
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}

	}

	// Creating Queue
	public static Queue getInputForQueue() {
		Queue queue = new Queue();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the length of queue you want to create: ");
		int length = sc.nextInt();
		System.out.println("Enter the values in Queue: ");
		for (int i = 0; i < length; i++) {
			queue.addElement(sc.nextInt());
		}
		return queue;

	}

	// Output
	public static void outputOfQueue(Queue queue) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Queue is: ");
		queue.printQueue(queue.head);

		System.out.println("Center Element = " + queue.middleElement(queue.head).data);

		queue.sizeOfQueue();

		System.out.println("Item is deleted from front of Queue is: " + queue.deleteElement());
		System.out.println("Queue after deletion of an item from Front: ");
		queue.printQueue(queue.head);

		queue.sizeOfQueue();

		System.out.println("Queue after Reverse: ");
		queue.reverseQueue();
		queue.printQueue(queue.head);

		queue.head = queue.mergeSort(queue.head);
		System.out.println("Queue after Sorting: ");
		queue.printQueue(queue.head);

		System.out.println("Enter the data you want to search: ");
		int data = sc.nextInt();
		queue.contains(data);

		System.out.println("Iterating: ");
		queue.iteratorForQueue(queue.head);
	}

}