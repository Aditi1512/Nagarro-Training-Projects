package com.nagarro.LibraryManagementFrontend.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is a model class for book.
 *
 */
public class Book {

	private long code;
	private String name;
	private String author;
	private String date;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(long code, String name, String author, String date) {
		super();
		this.code = code;
		this.name = name;
		this.author = author;
		this.date = date;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate() {
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
		String strDate = formatter.format(d);
		this.date = strDate;
	}

}