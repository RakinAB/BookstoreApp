package hw5;

/**
 * @author rakinbhuyan
 *
 */
public class Book {
	
	private String title, author, publisher, category;
	private int numPages, year, copies;
	
	public Book(String title, String author, String publisher, String category, int pages, int year, int copies) {
		this.setTitle(title);
		this.setAuthor(author);
		this.setPublisher(publisher);
		this.setCategory(category);
		this.setNumPages(pages);
		this.setYear(year);
		this.setCopies(copies);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNumPages() {
		return numPages;
	}

	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}
	
	/*
	 * This toString method will only return the full information of the book
	 */
	public String toString() {
		return "Title: \"" + this.title + "\"	Author: " + this.author +"\nPublisher: " + this.publisher + " 	Genre: " + this.category
				+ "	Year: " + this.year + "\nCopies: " + this.copies + "\n\n";
	}

}
