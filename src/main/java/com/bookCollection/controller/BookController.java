package com.bookCollection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookCollection.entity.Book;
import com.bookCollection.entity.MyBookList;
import com.bookCollection.service.BookSearchService;
import com.bookCollection.service.BookService;
import com.bookCollection.service.MyBookListService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private MyBookListService myBookService;

	@Autowired
	private BookSearchService bookSearchService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}

	@GetMapping("/available_books")
	public ModelAndView getAllBooks() {
		List<Book> books = bookService.getAllBooks();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bookList");
		mav.addObject("book", books);
		return new ModelAndView("bookList", "book", books);
	}

	@GetMapping("/my_books")
	public String myBooks(Model model) {
		List<MyBookList> myBooks = myBookService.getAllMyBooks();
		model.addAttribute("book", myBooks);
		return "myBooks";
	}

	@GetMapping("/searchForBooks")
	public String myBooks() {
		return "searchForBooks";
	}

	@GetMapping("/search")
	public String search(@RequestParam("title") String title, Model model) {
		Book book = bookSearchService.searchBookByTitle(title);
		model.addAttribute("book", book);
		return "searchForBooks";
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book) {
		bookService.save(book);
		return "redirect:/available_books";
	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book book = bookService.getBookById(id);
		MyBookList myBookList = new MyBookList(book.getId(), book.getName(), book.getAuthor(), book.getSummary());
		myBookService.saveMyBooks(myBookList);
		// Delete the book from available books
		bookService.deleteById(id);
		return "redirect:/my_books";
	}

	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book book = bookService.getBookById(id);
		model.addAttribute("book", book);
		return "bookEdit";
	}

	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookService.deleteById(id);
		return "redirect:/available_books";
	}
}
