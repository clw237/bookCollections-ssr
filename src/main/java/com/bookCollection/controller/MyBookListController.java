package com.bookCollection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookCollection.service.MyBookListService;

@Controller
public class MyBookListController {
	@Autowired
	private MyBookListService myBookService;

	@RequestMapping("/deleteMyBook/{id}")
	public String deleteMyBook(@PathVariable("id") int id) {
		myBookService.deleteById(id);
		return "redirect:/my_books";
	}

}
