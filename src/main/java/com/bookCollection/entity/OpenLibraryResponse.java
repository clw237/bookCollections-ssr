package com.bookCollection.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenLibraryResponse {
	@JsonProperty("docs")
	private Doc[] docs;

	public Doc[] getDocs() {
		return docs;
	}

	public void setDocs(Doc[] docs) {
		this.docs = docs;
	}

	public static class Doc {
		@JsonProperty("title")
		private String title;

		@JsonProperty("author_name")
		private String[] authorName;

		@JsonProperty("first_sentence")
		private String[] firstSentence;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String[] getAuthorName() {
			return authorName;
		}

		public void setAuthorName(String[] authorName) {
			this.authorName = authorName;
		}

		public String getFirstSentence() {
			return firstSentence != null && firstSentence.length > 0 ? firstSentence[0] : "No summary available.";
		}

		public void setFirstSentence(String[] firstSentence) {
			this.firstSentence = firstSentence;
		}
	}
}