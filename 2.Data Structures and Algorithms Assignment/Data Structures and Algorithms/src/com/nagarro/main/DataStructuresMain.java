package com.nagarro.main;

import java.util.Scanner;

import com.nagarro.hastable.Hashtable;
import com.nagarro.linkedList.LinkedList;
import com.nagarro.priorityQueue.PriorityQueue;
import com.nagarro.queue.Queue;
import com.nagarro.stack.Stack;

public class DataStructuresMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char dsChoices;
		do {
			System.out.println("Choose choice from the given options.");
			System.out.println("Choose a Choice for the Data Structures: ");
			System.out.println("Enter 1: For Linked List.");
			System.out.println("Enter 2: For Stack.");
			System.out.println("Enter 3: For Queue.");
			System.out.println("Enter 4: For Hashtable.");
			System.out.println("Enter 5: For Priority Queues.");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Linked List Data Structure: ");
				LinkedList list = LinkedList.getInputForLinkedList();
				LinkedList.outputOfLinkedList(list);
				break;
			case 2:
				System.out.println("Stack Data Structure: ");
				Stack stack = Stack.getInputForStack();
				Stack.outputOfStack(stack);
				break;
			case 3:
				System.out.println("Queue Data Structure: ");
				Queue queue = Queue.getInputForQueue();
				Queue.outputOfQueue(queue);
				break;
			case 4:
				System.out.println("HashTable Data Structure: ");
				Hashtable hashtable = Hashtable.getInputForHashtable();
				Hashtable.outputOfHashtable(hashtable);
				break;
			case 5:
				System.out.println("Priority Queue Data Structure: ");
				PriorityQueue pqueue = PriorityQueue.getInputForPriorityQueue();
				PriorityQueue.outputOfPriorityQueue(pqueue);
				break;
			default:
				System.out.println("Wrong Choice");
				
			}
			System.out.println("Do you want more choices Y/N?");
			 dsChoices = sc.next().charAt(0);
		} while ( dsChoices == 'Y' ||  dsChoices == 'y');
		
	}
}
