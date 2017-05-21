package com.vdong.models;

public class LibraryAutomationSystem {

	public static void main(String[] args) {
		Book designPattern = new Book("Design Pattern");
		BookCopy designPatternCopy0 = new BookCopy(designPattern);
		BookCopy designPatternCopy1 = new BookCopy(designPattern);
		BookCopy designPatternCopy2 = new BookCopy(designPattern);
		
		Book javaProgramming = new Book("Java Programming");
		BookCopy javaProgramming0 = new BookCopy(javaProgramming);
		BookCopy javaProgramming1 = new BookCopy(javaProgramming);
		
		Book tm = new Book("Transcedental Mediation");
		BookCopy tm0 = new BookCopy(tm);
		
		Patron vudong = new CommunityPatron("Vu Dong");
		vudong.checkOutBookCopy(designPatternCopy0);
		vudong.checkOutBookCopy(javaProgramming0);
		vudong.checkOutBookCopy(tm0);
		
		Patron nhim = new ScholarPatron("Nhim");
		nhim.checkOutBookCopy(javaProgramming1);
		nhim.checkOutBookCopy(designPatternCopy1);
		tm.placeOnReserve(nhim);
		
		Patron abc = new CommunityPatron("Abc Guy");
		tm.placeOnReserve(abc);
		
		vudong.renewBookCopy(javaProgramming0);
		vudong.returnBookCopy(tm0);
	}

}
