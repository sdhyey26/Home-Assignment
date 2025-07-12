package com.tss.exception;

public class MoviesListFullException extends RuntimeException {
	public String getMessage()
	{
		return "The list is Full you cannot add!!";
	}
}
