package com.tss.basic.iterative;

import java.util.Random;
import java.util.Scanner;

public class PigDiceGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		int totalScore = 0;
		int turn = 1;

		while (totalScore < 20) {
			if (turn <= 5) {
				System.out.println("TURN " + turn);
				int turnScore = 0;
				boolean turnOver = false;

				while (!turnOver) {
					System.out.print("Roll or hold? (r/h): ");
					String choice = sc.next().toLowerCase();

					if (choice.equals("r")) {
						int die = r.nextInt(6) + 1;
						System.out.println("Die: " + die);

						if (die == 1) {
							System.out.println("Turn over. No score.\n");
							turnScore = 0;
							turnOver = true;
						} else {
							turnScore += die;
						}
					} else if (choice.equals("h")) {
						totalScore += turnScore;
						System.out.println("Score for turn: " + turnScore);
						System.out.println("Total score: " + totalScore + "\n");
						turnOver = true;
					} else {
						System.out.println("Invalid input! Enter 'r' to roll or 'h' to hold.");
					}
				}

				if (totalScore >= 20) {
					System.out.println("You finished in " + turn + " turns!");
					System.out.println("\nGame over!");
					break;
				}

				turn++;
			} else {
				System.out.println("OOPS , You ran out of tries !!");
			}
		}
	}
}
