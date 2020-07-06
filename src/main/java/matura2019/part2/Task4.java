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

		/*
		 * ArrayList<String> actual = new ArrayList<>(); actual =
		 * checkFactorials("przyklad.txt"); System.out.println("expected true, actual "
		 * + actual.contains("145")); System.out.println("expected 1, actual " +
		 * actual.size()); System.out.println("expected 145, actual " + actual.get(0));
		 * 
		 * actual = checkFactorials("liczby.txt");
		 * 
		 * // all 3 metods print: expected: [2, 145, 1, 40585], actual: [2, 145, 1,
		 * 40585] System.out.println("expected: [2, 145, 1, 40585], actual: " +
		 * actual.toString());
		 * System.out.println("expected: [2, 145, 1, 40585], actual: " + actual);
		 * System.out.println("expected: [2, 145, 1, 40585], actual: " +
		 * Arrays.toString(actual.toArray()));
		 * 
		 * //prints: expected: [2, 145, 1, 40585], actual: [Ljava.lang.Object;@f6f4d33
		 * System.out.println("expected: [2, 145, 1, 40585], actual: " +
		 * actual.toArray());
		 */

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

		// String[] results = null;

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

		// --------------------------4.3---------------------------

		/*
		 * System.out.println("expexted [2], actual: " + Arrays.toString(getNWDs(2,
		 * 4))); System.out.println("expexted [4,2], actual: " +
		 * Arrays.toString(getNWDs(4, 4)));
		 */
		/*
		 * System.out.println("expexted [9,3], actual: " + Arrays.toString(getNWDs(9,
		 * 18)));
		 * 
		 * System.out.println( "expexted [2    ,4,6,10,2], actual: " +
		 * getLongestSequence(Arrays.asList(3, 7, 4, 6, 10, 2, 5))); System.out.println(
		 * "expexted [14    ,70,28,42,98], actual: " +
		 * getLongestSequence(Arrays.asList(5, 70, 28, 42, 98, 1)));
		 * 
		 * System.out.println("expexted [2    ,2,2,4], actual: " +
		 * getLongestSequence(Arrays.asList(2, 2, 4)));
		 * 
		 * System.out.println("expexted [2    ,2,4], actual: " +
		 * getLongestSequence(Arrays.asList(2, 3, 2, 4)));
		 * System.out.println("expexted [9    ,9,18], actual: " +
		 * getLongestSequence(Arrays.asList(9, 18)));
		 * System.out.println("expexted [2 ,2,2,4], actual: " +
		 * getLongestSequence(Arrays.asList(2, 2, 4, 3)));
		 * 
		 * List<String> list = getNumberList("przyklad.txt"); List<Integer> nums = new
		 * ArrayList<>(); for (String stringNum : list) {
		 * nums.add(Integer.parseInt(stringNum)); } //
		 * System.out.println("expexted [10, 90,x, x, x, x], actual: " + //
		 * getLongestSequence(nums));
		 * 
		 * list = getNumberList("liczby.txt"); nums.clear(); for (String stringNum :
		 * list) { nums.add(Integer.parseInt(stringNum)); }
		 * 
		 * System.out.println("expexted [????], actual: " + getLongestSequence(nums));
		 * System.out.println(getLongestSequence(nums).size() - 1);
		 */

		// --------------------------------------------------------------------------

	}

	// --------------------------4.3---------------------------
	private static Integer[] getNWDs(int a, int b) {
		List<Integer> nwd = new ArrayList<>();
		int smallerNumber = a > b ? b : a;

		for (int i = smallerNumber; i > 1; i--) {

			if (a % i == 0 && b % i == 0) {
				nwd.add(i);
			}
		}

		return nwd.toArray(new Integer[] {});
	}

	private static List<Integer> getLongestSequence(List<Integer> numbers) {
		List<Integer> longestSequence = new ArrayList<>();

		for (int i = 0; i < numbers.size() - 1; i++) {

			int num1 = numbers.get(i);
			int num2 = numbers.get(i + 1);
			List<Integer> nwds = Arrays.asList(getNWDs(num1, num2));

			if (nwds.size() == 0) {
				continue;
			}
			
			for (Integer currCommonDenom : nwds) {

				List<Integer> candidateList = new ArrayList<>(Arrays.asList(currCommonDenom, num1, num2));

				if (longestSequence.size() == 0) {
					longestSequence = candidateList;
				}

				for (int k = i + 2; k < numbers.size(); k++) {
					int next = numbers.get(k);

					if (next % currCommonDenom == 0) {
						candidateList.add(next);

						if (candidateList.size() > longestSequence.size()) {
							longestSequence = candidateList;
						}
					} else {
						break;
					}
				}
			}
		}
		return longestSequence;
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

	// ------------------- 4.2 Darek---------------------
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
