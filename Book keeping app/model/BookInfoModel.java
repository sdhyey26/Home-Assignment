package com.tss.model;

public class BookInfoModel {
	
	private int id;
	private String title;
	private String author;
	private boolean isIssued;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isIssued() {
		return isIssued;
	}
	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}
	@Override
	public String toString() {
		return "BookInfoModel [id=" + id + ", title=" + title + ", author=" + author + ", isIssued=" + isIssued + "]";
	}

}
