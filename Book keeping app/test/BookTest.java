package com.tss.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import com.tss.model.BookComparator;

import com.tss.model.BookInfoModel;

public class BookTest {
	public static void main(String[] args) {
		int bookIdCounter = 0;
		List<BookInfoModel> books = new ArrayList<>();
		List<BookInfoModel> isIssued = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		boolean isTrue = true;

		while (isTrue) {
			System.out.println("\n=== Book Management System ===");
			System.out.println("1. Add new book");
			System.out.println("2. Issue book");
			System.out.println("3. Display all available books");
			System.out.println("4. Display all issued books");
			System.out.println("5. Return a book");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();
			sc.nextLine(); 

			switch (choice) {
				case 1: {
					readBook(books, sc, bookIdCounter);
					bookIdCounter++;
					break;
				}
				case 2: {
					if (books.isEmpty()) {
						System.out.println("No books available to issue.");
						break;
					}

					System.out.print("Enter the book ID you want to issue: ");
					int issueId = sc.nextInt();
					sc.nextLine();

					BookInfoModel bookToIssue = null;
					for (BookInfoModel book : books) {
						if (book.getId() == issueId) {
							bookToIssue = book;
							break;
						}
					}

					if (bookToIssue != null) {
						bookToIssue.setIssued(true);
						isIssued.add(bookToIssue);
						books.remove(bookToIssue);
						System.out.println("Book issued successfully.");
					} else {
						System.out.println("Book with the given ID not found.");
					}
					break;
				}
				case 3: {
					if (books.isEmpty()) {
						System.out.println("No books available.");
					} else {
						Collections.sort(books, new BookComparator());;
						System.out.println("Available Books:");
						for (BookInfoModel book : books) {
							System.out.println(book);
						}
					}
					break;
				}
				case 4: {
					if (isIssued.isEmpty()) {
						System.out.println("No books have been issued.");
					} else {
						Collections.sort(isIssued, new BookComparator());;
						System.out.println("Issued Books:");
						for (BookInfoModel book : isIssued) {
							System.out.println(book);
						}
					}
					break;
				}
				case 5: {
					if (isIssued.isEmpty()) {
						System.out.println("No books have been issued.");
						break;
					}

					System.out.println("Issued Books:");
					for (BookInfoModel book : isIssued) {
						System.out.println(book);
					}

					System.out.print("Enter the ID of the book you want to return: ");
					int returnId = sc.nextInt();
					sc.nextLine();
					boolean isFound = false;

					BookInfoModel bookToReturn = null;
					for (BookInfoModel book : isIssued) {
						if (book.getId() == returnId) {
							bookToReturn = book;
							break;
						}
					}

					if (bookToReturn != null) {
						bookToReturn.setIssued(false);
						books.add(bookToReturn);
						isIssued.remove(bookToReturn);
						System.out.println("Book returned successfully.");
						isFound = true;
					}

					if (!isFound) {
						System.out.println("Invalid ID. No such book was issued.");
					}
					break;
				}
				case 6: {
					isTrue = false;
					System.out.println("Exiting the program. Goodbye!");
					break;
				}
				default: {
					System.out.println("Invalid choice. Please enter a number between 1 and 6.");
					break;
				}
			}
		}
		sc.close();
	}

	private static void readBook(List<BookInfoModel> books, Scanner sc, int id) {
		BookInfoModel book = new BookInfoModel();

		System.out.print("Enter book title: ");
		book.setTitle(sc.nextLine());

		System.out.print("Enter author's name: ");
		book.setAuthor(sc.nextLine());

		book.setId(id);
		book.setIssued(false);

		books.add(book);

		System.out.println("Book added successfully. ID: " + book.getId());
		System.out.println("Book Details: " + book);
	}
}
