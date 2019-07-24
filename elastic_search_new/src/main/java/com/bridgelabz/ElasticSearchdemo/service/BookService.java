package com.bridgelabz.ElasticSearchdemo.service;

import java.util.List;

import com.bridgelabz.ElasticSearchdemo.model.Book;

public interface BookService {

	Book save(Book book);
	void delete(Book book);
	Book findOne(String bookId);
    List<Book> findByTitle(String title);

}
