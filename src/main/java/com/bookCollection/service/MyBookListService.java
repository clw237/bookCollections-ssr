package com.bookCollection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bookCollection.entity.MyBookList;
import com.bookCollection.repository.MyBookRepository;

@Service
public class MyBookListService {

	@Autowired
	private MyBookRepository myBookRepository;

	public void saveMyBooks(MyBookList myBookList) {
		myBookRepository.save(myBookList);
	}

	public List<MyBookList> getAllMyBooks() {
		return myBookRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

	public void deleteById(int id) {
		myBookRepository.deleteById(id);
	}
}
