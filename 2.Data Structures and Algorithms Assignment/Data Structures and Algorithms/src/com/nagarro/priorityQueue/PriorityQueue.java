package com.nagarro.priorityQueue;

import java.util.Scanner;

import com.nagarro.constant.ConsoleMessages;

public class PriorityQueue {

	int size;
	Node head;

	PriorityQueue() {
		this.size = 0;
	}

	class Node {
		int data;
		int priority;
		Node next;

		Node(int data, int priority) {
			this.data = data;
			this.priority = priority;
			next = null;
			size++;
		}
	}

	// empty
	public boolean isEmpty() {
		return head == null;
	}

	// peek (highest priority)
	public int peek() {
		return head.data;
	}

	// enqueue - inserting an element
	public void addElements(int data, int priority) {
		Node start = head;
		Node newNode = new Node(data, priority);

		if (isEmpty()) {
			head = newNode;
		} else {

			if ((head).priority < priority) {
				newNode.next = head;
				head = newNode;
			}

			else {
				while (start != null && start.next != null && start.next.priority > priority) {
					start = start.next;
				}

				newNode.next = start.next;
				start.next = newNode;
			}
		}
	}

	// dequeue - deleting an element
	public int delete() {

		int deletedElement = 0;
		if (isEmpty()) {
			System.out.println(ConsoleMessages.EMPTY_STRUCTURE);
			deletedElement = -1;
		} else {

			int temp = head.data;
			head = head.next;
			deletedElement = temp;

		}
		return deletedElement;
	}

	// middle element
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

	// contains, searching for an element
	public void contains(int data) {
		try {
			if (isEmpty()) {
				throw new IndexOutOfBoundsException("Empty Priority Queue");
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
				System.out.println("Item " + data + "id present is the Priority Queue");
			} else {
				System.out.println("Item " + data + " not found");
			}
		} catch (Exception e) {
			System.out.println("Exception in contains method");
		}

	}

	// reverse
	public void reverse() {
		if (head == null || head.next == null) {
			System.out.println("Priority Queue is Empty");
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

	// size
	public void size() {
		System.out.println("Size : " + size);
	}

	// Iterator For Priority Queue
	public void iteratorForPriorityQueue(Node head) {
		Node temp = head;
		System.out.println("Elements are: ");
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}

	}

	// print
	public void printPriorityQueue() {
		Node node = head;
		while (node != null) {
			System.out.print("(" + node.data + ", " + node.priority + ")" + "->");
			node = node.next;
		}
		System.out.print("null \n");
	}

	// Creating Queue
	public static PriorityQueue getInputForPriorityQueue() {
		PriorityQueue pqueue = new PriorityQueue();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the length of Priority Queue you want to create: ");
		int length = sc.nextInt();
		System.out.println("Enter the values in Priority Queue with there Priorities: ");
		for (int i = 0; i < length; i++) {
			pqueue.addElements(sc.nextInt(), sc.nextInt());
		}
		return pqueue;

	}

	// Output
	public static void outputOfPriorityQueue(PriorityQueue pqueue) {
		Scanner sc = new Scanner(System.in);

		// printing
		System.out.println("Priority Queue is: ");
		pqueue.printPriorityQueue();

		pqueue.size();

		System.out.println("Element dequeued is : " + pqueue.delete());

		System.out.println("Priority Queue is: ");
		pqueue.printPriorityQueue();

		System.out.println("Middle Element is: " + pqueue.middleElement(pqueue.head).data);

		System.out.println("Enter an element you want to search: ");
		int data = sc.nextInt();
		pqueue.contains(data);

		System.out.println("Peek is: " + pqueue.peek());

		System.out.println("Priority Queue after Reversing");
		pqueue.reverse();
		pqueue.printPriorityQueue();

		System.out.println("Iterating: ");
		pqueue.iteratorForPriorityQueue(pqueue.head);

	}

}