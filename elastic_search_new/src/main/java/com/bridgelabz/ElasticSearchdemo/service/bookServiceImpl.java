package com.bridgelabz.ElasticSearchdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.ElasticSearchdemo.model.Book;
import com.bridgelabz.ElasticSearchdemo.repository.BookRepository;

@Service
public class bookServiceImpl implements BookService {
	
	private BookRepository bookRepository;

	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public void delete(Book book) {
		// TODO Auto-generated method stub
		bookRepository.delete(book);
	}

	@Override
	public Book findOne(String bookId) {
		// TODO Auto-generated method stub
		return bookRepository.findOne(bookId);
	}

	@Override
	public List<Book> findByTitle(String title) {
		// TODO Auto-generated method stub
		return bookRepository.findByTitle(title);
	}
	
	

	
	
	

}
