package com.vdong.models;

import java.util.LinkedList;
import java.util.Queue;

public class Book {
	private String title;
	private Queue<Patron> waitingPatronsList = new LinkedList<Patron>();
	private int numberOfCopies;
	
	public Book(String title) {
		this.setTitle(title);
	}
	
	public void placeOnReserve(Patron patron) {
		waitingPatronsList.add(patron);
	}
	
	public boolean onReserve() {
		return !waitingPatronsList.isEmpty();
	}
	
	public void notifyBookCopyAvailability() {
		if (onReserve()) {
			Patron firstPatron = this.waitingPatronsList.poll();
			firstPatron.notifyPatronOfBookAvailability(this);
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumberOfCopies() {
		return numberOfCopies;
	}

	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
}
