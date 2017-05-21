package com.vdong.models;

public class CommunityPatron extends Patron {
	
	public CommunityPatron(String name) {
		super(name);
	}

	@Override
	public int maxNumberOfBooksThatCanBeCheckedOut() {
		return 5;
	}

	@Override
	public int checkOutDuration() {
		return 3 * 7; // 3 weeks
	}

}
