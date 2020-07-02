package matura2019;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Task4 {

	public static void main(String[] args) {
		/*
		 * int actual = countPowersOf3("przyklad.txt");
		 * System.out.println("expected 2, actual " + actual);
		 * 
		 * actual = countPowersOf3("oneLetter");
		 * System.out.println("expected 1, actual " + actual);
		 * 
		 * actual = countPowersOf3("liczby.txt");
		 * System.out.println("expected ?, actual " + actual);
		 */
		
		// ---------------------------
		
		
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
