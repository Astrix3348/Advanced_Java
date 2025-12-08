package cdac;

public class Book {
	String title;
	String author;
	String genre;
	int year;

	public Book(String title, String author, String genre, int year) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.year = year;
	}
	public Book() {
		
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public int getYear() {
		return year;
	}

}
