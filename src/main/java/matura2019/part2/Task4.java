package matura2019.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 {

	public static void main(String[] args) {
		
		// -------- 4.1-------------------
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

		// ---------- 4.2-----------------

		ArrayList<String> actual = new ArrayList<>();
		actual = checkFactorials("przyklad.txt");
		System.out.println("expected true, actual " + actual.contains("145"));
		System.out.println("expected 1, actual " + actual.size());
		System.out.println("expected 145, actual " + actual.get(0));

		 actual = checkFactorials("liczby.txt");
		
		 // all 3 metods print: expected: [2, 145, 1, 40585], actual: [2, 145, 1, 40585]
		System.out.println("expected: [2, 145, 1, 40585], actual: " + actual.toString());
		System.out.println("expected: [2, 145, 1, 40585], actual: " + actual);		
		System.out.println("expected: [2, 145, 1, 40585], actual: " + Arrays.toString(actual.toArray()));
		
		//prints: expected: [2, 145, 1, 40585], actual: [Ljava.lang.Object;@f6f4d33
		System.out.println("expected: [2, 145, 1, 40585], actual: " + actual.toArray());
		

		// ---------- 4.2 Darek-----------------
		/*
		 * System.out.println("expected 1, actual " + getFactorial(0));
		 * System.out.println("expected 1, actual " + getFactorial(1));
		 * System.out.println("expected 2, actual " + getFactorial(2));
		 * System.out.println("expected 6, actual " + getFactorial(3));
		 * System.out.println("expected 24, actual " + getFactorial(4));
		 */

		// System.out.println("expected false, actual " + isFactorialEqualNumber(0)); //
		// 1 != 0

		/*
		 * System.out.println("expected true, actual " + isFactorialEqualNumber("1"));
		 * // 1 System.out.println("expected true, actual " +
		 * isFactorialEqualNumber("2")); // 1 * 2
		 * System.out.println("expected false, actual " + isFactorialEqualNumber("3"));
		 * // 2 * 3 = 6 System.out.println("expected false, actual " +
		 * isFactorialEqualNumber("343")); // 3! + 4! + 3! = 36
		 * System.out.println("expected true, actual " + isFactorialEqualNumber("145"));
		 */

		//String[] results = null;

		/*
		 * results = getAllEqual("przyklad.txt");
		 * System.out.println("expected 1, actual length: " + results.length);
		 * System.out.println("expected 145, actual: " + results[0]);
		 */

		/*
		 * results = getAllEqual("4.2/threeOutOfSixCorrect.txt");
		 * System.out.println("expected 3, actual length: " + results.length);
		 * System.out.println("expected 2, 145, 1, actual: " +
		 * Arrays.toString(results));
		 * 
		 * results = getAllEqual("liczby.txt");
		 * System.out.println("expected ?, actual: " + Arrays.toString(results));
		 */

	}

//------------------- 4.2--------------------------
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
//---------------------4.1------------------------
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
	//------------------- 4.2 Darek---------------------
		private static String[] getAllEqual(String path) {

			List<String> input = getNumberList(path);
			List<String> output = new ArrayList<String>();

			for (String stringNum : input) {
				if (isFactorialEqualNumber(stringNum)) {
					output.add(stringNum);
				}
			}

			return output.toArray(new String[] {});
		}

		private static boolean isFactorialEqualNumber(String stringNum) {
			String[] digits = stringNum.split("");
			int factorialSum = 0;

			for (String digit : digits) {
				factorialSum += getFactorial(Integer.parseInt(digit));
			}

			return factorialSum == Integer.parseInt(stringNum);
		}

		private static int getFactorial(int i) {

			if (i < 0) {
				throw new IllegalArgumentException("Argument for factorial cannot be nagative");
			}

			// stop
			if (i == 0 || i == 1) {
				return 1;
			} else {
				return i * getFactorial(--i);
			}

		}

		private static List<String> getNumberList(String path) {

			try {
				return Files.readAllLines(Paths.get(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;

		}
}
