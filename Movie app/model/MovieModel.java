package com.tss.model;

import java.io.Serializable;

public class MovieModel implements Serializable{
	
    private static final long serialVersionUID = 1L;
	
	private String movieId;
	private String movieName;
	private String genre;
	private String year;
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "MovieModel [movieId=" + movieId + ", movieName=" + movieName + ", genre=" + genre + ", year=" + year
				+ "]";
	}
}
