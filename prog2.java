//Book Class

package prog2;

public class Book {
	int id;
	String title;
	String author;
	String publisher;
	double price;
	
	Book() {}
	
	Book(int id, String title, String author, String publisher, double price) {
	this.id = id;
	this.title = title;
	this.author = author;
	this.publisher = publisher;
	this.price = price;
	}
}


// BookCompare

import java.util.Comparator;

class BookCompare implements Comparator<Book> {
	
public int compare(Book b1,Book b2) {
return (int) (b1.price-b2.price); 
}

}


//Main class

package prog2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	static void print(Book b1) {
		System.out.println(b1.id+" "+b1.title + " " + b1.author + " " + b1.publisher + " " + b1.price);
	}

	public static void main(String[] args) {

		ArrayList<Book> bookList = new ArrayList<Book>();

		int number_of_books;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of books you have : ");
		number_of_books = sc.nextInt();
		for(int i=0; i<number_of_books; i++) {
			String bookName, bookAuthor, bookPublisher;
			double bookPrice;
			System.out.println("Enter the book name : ");
			sc.nextLine();
			bookName = sc.nextLine();
			System.out.println("Enter the book author : ");
			bookAuthor = sc.nextLine();
			System.out.println("Enter the book publisher : ");
			bookPublisher=sc.nextLine();
			System.out.println("Enter the price of the book : ");
			bookPrice = sc.nextDouble();

			Book b1 = new Book(i+1,bookName,bookAuthor,bookPublisher,bookPrice);
			bookList.add(b1);
		}

		System.out.println("-------------Printing the details of the BOOKS-------------");
		System.out.println("Name\tAuthor\tPublisher\tPrice");
		for(Book b : bookList) {
			print(b);
		}

		ArrayList<Book> bookListClone = new ArrayList<Book>();
		bookListClone = bookList;
		bookListClone.sort(new BookCompare());
		System.out.println("--------Printing BOOKS in sorted order on the basis of price-------------");
		for(Book b : bookListClone) {
			print(b);
		}

		String authorName;
		System.out.print("Enter the author name to search for : ");
		authorName = sc.next();
		for(Book b : bookList) {
			if(b.author.equals(authorName)) {
				print(b);
			}
		}
		double buyerPrice;
		System.out.println("Enter the price to be looked up for : ");
		buyerPrice = sc.nextDouble();
		ArrayList<Book> priceList = new ArrayList<Book>();
		for(Book b : bookList) {
			if(b.price > buyerPrice) {
				priceList.add(b);
			}
		}
		System.out.println("Books which have price greater than " + buyerPrice);
		for(Book b : priceList) {
			print(b);
		}

		String publisherName;
		System.out.println("Enter the publisher name to search for : ");
		sc.nextLine();
		publisherName = sc.nextLine();
		for(Book b : bookList) {
			if(b.publisher.equals(publisherName)) {
				print(b);
			}
		}
		String searchTitle;
		System.out.println("Enter the title to be searched : ");
		searchTitle= sc.nextLine();
		for(Book b : bookList) {
			if(b.title.contains(searchTitle)) {
				print(b);
			}
		}
		String bookTitle;
		System.out.println("Enter the Title of the book whose publisher has to changed :");
		bookTitle = sc.nextLine();
		System.out.println("Enter the new publisher name : ");
		String newTitle = sc.nextLine();
		Book found = new Book();
		for(Book b: bookList) {
			if(b.title.equals(bookTitle)) {
				found = b;
				break;
			}
		}
		found.publisher = newTitle;
		print(found);
	}
}
