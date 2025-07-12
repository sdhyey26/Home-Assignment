package com.tss.exception;

public class MoviesListEmptyException extends RuntimeException {
	public String getMessage()
	{
		return "The list is empty nothing to display/delete/remove!!";
	}
}
