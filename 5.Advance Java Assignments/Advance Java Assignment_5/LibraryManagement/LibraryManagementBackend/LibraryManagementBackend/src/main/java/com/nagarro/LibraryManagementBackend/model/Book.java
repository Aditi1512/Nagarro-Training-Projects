package com.nagarro.LibraryManagementBackend.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Book {

	@Id
	@Column(unique = true)
	private long code;
	private String name;
	private String author;
	private String date;

//	@ManyToOne
//	private User user;

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

	public void setDate(String date) {
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
		String strDate = formatter.format(d);
		this.date = strDate;
	}

}