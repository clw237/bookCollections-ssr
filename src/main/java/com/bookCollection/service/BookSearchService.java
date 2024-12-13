package com.bookCollection.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookCollection.entity.Book;
import com.bookCollection.entity.OpenLibraryResponse;

@Service
public class BookSearchService {
	private final RestTemplate restTemplate;

	public BookSearchService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Book searchBookByTitle(String title) {
		String url = "https://openlibrary.org/search.json?title=" + title;
		OpenLibraryResponse response = restTemplate.getForObject(url, OpenLibraryResponse.class);

		if (response != null && response.getDocs().length > 0) {
			// Extracting the first book's details (you can modify this as needed)
			var doc = response.getDocs()[0];
			Book book = new Book();
			book.setName(doc.getTitle());
			book.setAuthor(doc.getAuthorName()[0]); // Assuming there's at least one author
			book.setSummary(doc.getFirstSentence()); // You may need to adjust this based on available fields

			return book;
		}
		return null;
	}
}