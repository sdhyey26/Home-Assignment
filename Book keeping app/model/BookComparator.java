package com.tss.model;

import java.util.Comparator;

public class BookComparator implements  Comparator<BookInfoModel>{

	@Override
	public int compare(BookInfoModel o1, BookInfoModel o2) {
		// TODO Auto-generated method stub
		return o1.getTitle().compareTo(o2.getTitle());
	}
	
}
