package com.vdong.models;

import java.util.Calendar;
import java.util.Date;

public class BookCopy {
	private Book bookInstance;
	private Patron borrower;
	private Date dueDate;
	
	public BookCopy(Book book) {
		this.setBookInstance(book);
	}
	
	public void assignBookCopyToPatron(Patron patron) {
		dueDate = new Date();
		updateDueDateWithDuration(patron.checkOutDuration());
		this.borrower = patron; 
	}
	
	public Book getBookInstance() {
		return this.bookInstance;
	}

	public void setBookInstance(Book bookInstance) {
		this.bookInstance = bookInstance;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void updateDueDateWithDuration(int duration) { // day unit
		Calendar c = Calendar.getInstance(); 
		c.setTime(dueDate); 
		c.add(Calendar.DATE, duration);
		dueDate = c.getTime();
	}
	
	public Patron getBorrower() {
		return this.borrower;
	}

	public void setBorrower(Patron borrower) {
		this.borrower = borrower;
	}
	
	
}
