package com.bridgelabz.ElasticSearchdemo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="information",type="book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String bookId;
	
	private String BookName;
	private String title;
	private String Author;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Book(String bookId, String bookName, String title, String author) {
		super();
		this.bookId = bookId;
		BookName = bookName;
		this.title = title;
		Author = author;
	}


	public String getBookId() {
		return bookId;
	}


	public void setBookId(String bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return BookName;
	}


	public void setBookName(String bookName) {
		BookName = bookName;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return Author;
	}


	public void setAuthor(String author) {
		Author = author;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", BookName=" + BookName + ", title=" + title + ", Author=" + Author + "]";
	}
	
	
	
	
}
