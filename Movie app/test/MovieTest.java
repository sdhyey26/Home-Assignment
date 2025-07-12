package com.tss.test;

import com.tss.exception.MoviesListEmptyException;
import com.tss.exception.MoviesListFullException;
import com.tss.model.MovieModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieTest {

	private static final String FILE_NAME = "movies.ser";

	public static void main(String[] args) {

		List<MovieModel> movies = deserializeMovies();

		Scanner sc = new Scanner(System.in);
		boolean isTrue = true;

		while (isTrue) {
			System.out.println("\n=== Simple Movie System ===");
			System.out.println("1. Display movies");
			System.out.println("2. Add movies");
			System.out.println("3. Delete Movies");
			System.out.println("4. Clear All");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1: {
				movies = deserializeMovies();
				if (movies.isEmpty()) {
					throw new MoviesListEmptyException();
				} else {
					for (MovieModel movie : movies) {
						System.out.println(movie);
					}
				}
				break;
			}
			case 2: {
				if (movies.size() >= 5) {
					System.out.println("Maximum of 5 movies allowed!");
					throw new MoviesListFullException();
				} else {
					addMovie(movies, sc);
					serializeMovies(movies);
				}
				break;
			}
			case 3: {
				if (movies.isEmpty()) {
					throw new MoviesListEmptyException();
				} else {
					for (MovieModel movie : movies) {
						System.out.println(movie);
					}
					System.out.print("Enter the movieId you want to delete: ");
					String movieId = sc.next();
					boolean isFound = false;
					MovieModel toRemove = null;
					for (MovieModel movie : movies) {
						if (movieId.equals(movie.getMovieId())) {
							toRemove = movie;
							System.out.println("Movie deleted successfully.");
							isFound = true;
						} 
					}
					if(!isFound) {
						System.out.println("Enter a valid Movie ID to delete");
					}
					else {
						movies.remove(toRemove);
						serializeMovies(movies);
					}
				}
				break;
			}
			case 4: {
				if (movies.isEmpty()) {
					throw new MoviesListEmptyException();
				} else {
					movies.clear();
					serializeMovies(movies);
					System.out.println("All movies removed successfully!");
				}
				break;
			}
			case 5: {
				serializeMovies(movies);
				isTrue = false;
				System.out.println("Exiting... Data saved.");
				break;
			}
			default:
				System.out.println("Invalid choice!");
			}
		}

		sc.close();
	}

	private static void addMovie(List<MovieModel> movies, Scanner sc) {
		MovieModel movie = new MovieModel();

		System.out.print("Enter Movie name: ");
		movie.setMovieName(sc.nextLine());

		System.out.print("Enter Genre name: ");
		movie.setGenre(sc.nextLine());

		System.out.print("Enter the year: ");
		movie.setYear(sc.next());

		String id = "";

		for (int i = 0; i < 2; i++) {
			id += movie.getMovieName().charAt(i);
		}
		for (int i = 0; i < 2; i++) {
			id += movie.getGenre().charAt(i);
		}
		for (int i = movie.getYear().length() - 2; i < movie.getYear().length(); i++) {
			id += movie.getYear().charAt(i);
		}
		movie.setMovieId(id);

		movies.add(movie);
		System.out.println("Movie added successfully.");
	}

	private static void serializeMovies(List<MovieModel> movies) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movies.txt"))) {
			oos.writeObject(movies);
		} catch (IOException e) {
			System.out.println("Error saving movies: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private static List<MovieModel> deserializeMovies() {
		File file = new File("movies.txt");
		if (!file.exists()) {
			return new ArrayList<>();
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("movies.txt"))) {
			return (List<MovieModel>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error loading movies: " + e.getMessage());
			return new ArrayList<>();
		}
	}
}
