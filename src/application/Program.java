package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {

		// Challenge: https://adventofcode.com/2022/day/2

		File file = new File("input.txt");

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String round = br.readLine();
			String opponent;
			String reason;
			Integer fScore = 0;
			Integer sScore = 0;
			Integer win, draw, lose;

			while (round != null) {
				win = 0;
				draw = 0;
				lose = 0;
				opponent = round.split(" ")[0];
				reason = round.split(" ")[1];

				if (reason.equals("X")) {
					fScore += 1;
				} else if (reason.equals("Y")) {
					fScore += 2;
				} else {
					fScore += 3;
				}

				if (opponent.equals("A") && reason.equals("Y") || opponent.equals("B") && reason.equals("Z")
						|| opponent.equals("C") && reason.equals("X")) {
					fScore += 6;
				} else if (opponent.equals("A") && reason.equals("X") || opponent.equals("B") && reason.equals("Y")
						|| opponent.equals("C") && reason.equals("Z")) {
					fScore += 3;
				}
				
				if (opponent.equals("A")){
					win += 2;
					draw += 1;
					lose += 3;	
				} else if (opponent.equals("B")) {
					win += 3;
					draw += 2;
					lose += 1;	
				}else if (opponent.equals("C")) {
					win += 1;
					draw += 3;
					lose += 2;	
				}
				
				if (reason.equals("Z")) {
					sScore += 6 + win;
				} else if (reason.equals("Y")) {
					sScore += 3 + draw;
				} else {
					sScore += lose;
				}

				round = br.readLine();
			}

			System.out.println("Your total score for first interpretation: " + fScore);
			System.out.println("Your total score for final interpretation: " + sScore);

		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}

	}

}
