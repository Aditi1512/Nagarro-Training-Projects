package com.nagarro.hastable;

import java.util.Scanner;

public class Hashtable {

	private StudentPair[] hashtable;

	public Hashtable(int capacity) {
		hashtable = new StudentPair[capacity];
	}

	private int hashKey(String key) {
		return key.length() % hashtable.length;
	}

	public void put(String key, Student value) {
		int hashedKey = hashKey(key);
		if (isOccupied(hashedKey)) {
			int stopIndex = hashedKey;
			if (hashedKey == hashtable.length - 1) {
				hashedKey = 0;
			} else {
				hashedKey++;
			}

			while (isOccupied(hashedKey + 1) && hashedKey != stopIndex) {
				hashedKey = (hashedKey + 1) % hashtable.length;
			}
		}
		hashtable[hashedKey] = new StudentPair(key, value);

	}

	public int containsKey(String key) {
		int hashedKey = hashKey(key);
		if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		}

		int stopIndex = hashedKey;
		if (hashedKey == hashtable.length - 1) {
			hashedKey = 0;
		} else {
			hashedKey++;
		}

		while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)) {
			hashedKey = (hashedKey + 1) % hashtable.length;
		}
		if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		} else {
			return -1;
		}
	}

	public Student get(String key) {
		Student getStudent;
		int hashedKey = containsKey(key);
		if (hashedKey == -1) {
			getStudent = null;
		} else {
			getStudent = hashtable[hashedKey].student;
		}
		return getStudent;
	}

	private boolean isOccupied(int index) {
		return hashtable[index] != null;
	}

	public Student delete(String key) {
		Student recordOfStudent;
		int hashedKey = containsKey(key);
		if (hashedKey == -1) {
			recordOfStudent = null;
			System.out.println("Hashtable is empty");
		} else {

			Student student = hashtable[hashedKey].student;
			hashtable[hashedKey] = null;

			StudentPair[] oldHashtable = hashtable;
			hashtable = new StudentPair[oldHashtable.length];
			for (int i = 0; i < oldHashtable.length; i++) {
				if (oldHashtable[i] != null) {
					put(oldHashtable[i].key, oldHashtable[i].student);
				}
			}
			recordOfStudent = student;
		}
		return recordOfStudent;
	}

	// size
	public void sizeOfHashtable() {
		int sizeCount = 0;
		for (int i = 0; i < hashtable.length; i++) {
			if (hashtable[i] != null) {
				sizeCount++;
			}
		}
		System.out.println("Size : " + sizeCount);
	}

	// Iterator
	public void iteratorForHashTable() {
		for (int i = 0; i < hashtable.length; i++) {
			if (hashtable[i] == null) {
				System.out.println("Empty");
			} else {
				System.out.println(hashtable[i].student);
			}
		}
	}

	public void printHashTable() {
		for (int i = 0; i < hashtable.length; i++) {
			if (hashtable[i] == null) {
				System.out.println("Empty");
			} else {
				System.out.println(hashtable[i].student);
			}
		}
	}

	public static Hashtable getInputForHashtable() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Maximum Capacity for Hashtable: ");
		int capacity = sc.nextInt();
		sc.nextLine();
		Hashtable hashtable = new Hashtable(capacity);

		System.out.println("Enter the number of records you want to enter: ");
		int length = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < length; i++) {
			Student student = new Student();
			System.out.println("Enter first Name: ");
			String firstName = sc.nextLine();
			System.out.println("Enter last Name: ");
			String lastName = sc.nextLine();
			System.out.println("Enter enrollment number: ");
			String enrollmentId = sc.nextLine();
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setEnrollmentId(enrollmentId);
			hashtable.put(enrollmentId, student);
		}
		return hashtable;
	}

	public static void outputOfHashtable(Hashtable hashtable) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hashtable is: ");
		hashtable.printHashTable();

		System.out.println("Size of Hashtable is:");
		hashtable.sizeOfHashtable();

		System.out.println("Size of Hashtable is:");
		hashtable.sizeOfHashtable();

		System.out.println("Enter key(enrollmentId) you want to return detail of the student");
		String key = sc.nextLine();
		System.out.println("Student detail is: " + hashtable.get(key));

		System.out.println("Enter the key(enrollmentId) of student you want to delete");
		System.out.println(hashtable.delete(sc.nextLine()) + " is deleted.");
		System.out.println("Hashtable after deletion of a record.");
		hashtable.printHashTable();

		System.out.println("Size of Hashtable is:");
		hashtable.sizeOfHashtable();

		System.out.println("Iterating: ");
		hashtable.iteratorForHashTable();
	}
}
