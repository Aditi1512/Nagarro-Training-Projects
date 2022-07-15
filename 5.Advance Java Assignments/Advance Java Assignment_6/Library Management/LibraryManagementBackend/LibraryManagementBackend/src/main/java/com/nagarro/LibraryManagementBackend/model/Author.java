package com.nagarro.LibraryManagementBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * This is the model class for Author
 *
 */
@Data
@Entity
public class Author {

	@Id
	@Column(unique = true)
	private int id;
	private String authorName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}