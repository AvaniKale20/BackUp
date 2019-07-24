package com.bridgelabz.ElasticSearchdemo.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.bridgelabz.ElasticSearchdemo.model.Book;

public interface BookRepository extends ElasticsearchRepository<Book, String>{

	List<Book> findByTitle(String title);

	Book findOne(String bookId);
}
