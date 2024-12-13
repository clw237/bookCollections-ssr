package com.bookCollection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bookCollection.entity.Book;
import com.bookCollection.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public void save(Book book) {
		bookRepository.save(book);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

	public Book getBookById(int id) {
		return bookRepository.findById(id).get();
	}

	public void deleteById(int id) {
		bookRepository.deleteById(id);
	}
}
