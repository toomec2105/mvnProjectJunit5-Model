package matura2019.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 {

	public static void main(String[] args) {
		/*
		 * int actual = countPowersOf3("przyklad.txt");
		 * System.out.println("expected 2, actual " + actual);
		 * 
		 * actual = countPowersOf3("./4.1/oneLetter");
		 * System.out.println("expected 1, actual " + actual);
		 * 
		 * actual = countPowersOf3("liczby.txt");
		 * System.out.println("expected ?, actual " + actual);
		 */

		// ---------------------------
		/*
		 * ArrayList<String> actual = checkFactorials("przyklad.txt");
		 * System.out.println("expected true, actual " + actual.contains("145"));
		 * System.out.println("expected 1, actual " + actual.size());
		 * System.out.println("expected 145, actual " + actual.get(0));
		 */
		/*
		 * ArrayList<String> actual = checkFactorials("liczby.txt"); for (int j = 0; j <
		 * actual.size(); j++) { System.out.println("actual " + actual.get(j)); }
		 */

	}

	private static ArrayList<String> checkFactorials(String path) {
		List<String> numbers = null;
		ArrayList<String> output = new ArrayList<>();
		try {
			numbers = Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String num : numbers) {
			int digit = 0;
			int sum = 0;

			for (int i = 0; i < num.length(); i++) {
				int factorial = 1;
				digit = num.charAt(i) - 48;
				for (int j = 0; j < digit; j++) {
					factorial *= digit - j;
				}
				sum += factorial;
			}
			
			if (sum == Integer.parseInt(num) && Integer.parseInt(num) != 0) {
				output.add(num);
			}
		}
		
		return output;
	}

	private static int countPowersOf3(String path) {

		List<String> numbers = null;
		int counter = 0;

		try {
			numbers = Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String number : numbers) {
			Integer num = Integer.parseInt(number);

			while (num % 3 == 0) {
				num /= 3;
			}

			if (num == 1) {
				counter++;
			}
		}

		return counter;
	}

}
