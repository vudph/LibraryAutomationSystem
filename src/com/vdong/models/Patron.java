package com.vdong.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Patron {
	private String name;
	private List<BookCopy> booksCheckedOut = new ArrayList<BookCopy>();
	
	public Patron(String name) {
		this.name = name;
	}
	
	public void checkOutBookCopy(BookCopy bookCopy) {
		int n = getBooksCheckedOut().size();
		if (n < maxNumberOfBooksThatCanBeCheckedOut()) {
			booksCheckedOut.add(bookCopy);
			bookCopy.assignBookCopyToPatron(this);
			System.out.println("Successfull to check out: " + bookCopy.getBookInstance().getTitle());
		} else {
			System.out.println("Sorry! You have reached the limit for the number of books you can check out!");
		}
	}
	
	public void returnBookCopy(BookCopy bookCopy) {
		updateBooksCheckedOut(bookCopy);
		bookCopy.setBorrower(null);
		bookCopy.getBookInstance().notifyBookCopyAvailability();
	}
	
	private void updateBooksCheckedOut(BookCopy bookCopy) {
		this.booksCheckedOut.remove(bookCopy);
	}
	
	public void renewBookCopy(BookCopy bookCopy) {
		if (bookCopy.getBookInstance().onReserve()) {
			System.out.println("Sorry! The book '" + bookCopy.getBookInstance().getTitle() + "' cannot be renewed. It's on reserve by someone!");
		} else {
			int checkOutDuration = this.checkOutDuration();
			bookCopy.updateDueDateWithDuration(checkOutDuration);
		}
	}
	
	public void notifyPatronOfBookAvailability(Book book) {
		System.out.println("Hey " + this.name + ": A book copy of '" + book.getTitle() + "' which you placed on reserve has just arrived!");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BookCopy> getBooksCheckedOut() {
		return booksCheckedOut;
	}

	public void setBooksCheckedOut(List<BookCopy> booksCheckedOut) {
		this.booksCheckedOut = booksCheckedOut;
	}
	
	public abstract int maxNumberOfBooksThatCanBeCheckedOut(); //for CommunityPatron is 5, for ScholarPatron is 10 
	public abstract int checkOutDuration(); //for CommunityPatron is 3 weeks, for ScholarPatron is 6 weeks
}
