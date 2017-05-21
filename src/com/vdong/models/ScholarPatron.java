package com.vdong.models;

public class ScholarPatron extends Patron {

	public ScholarPatron(String name) {
		super(name);
	}

	@Override
	public int maxNumberOfBooksThatCanBeCheckedOut() {
		return 10;
	}

	@Override
	public int checkOutDuration() {
		return 6 * 7; // 6 weeks
	}

}
