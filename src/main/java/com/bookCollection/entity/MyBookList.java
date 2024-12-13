package com.bookCollection.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MyBooks")
public class MyBookList {

	@Id
	@Column(name = "book_id")
	private int id;
	private String name;
	private String author;
	private String summary;

	public MyBookList(int id, String name, String author, String summary) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.summary = summary;
	}

	public MyBookList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSummary() {
		return summary;
	}

	public void SetSummary(String summary) {
		this.summary = summary;
	}

}
