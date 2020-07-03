package recursion;

public class Factorial {
	public static void main(String[] args) {
		test();
	}

	public static int factorialIterative(int num) {

		if (num == 0) {
			return 1;

		} else {
			int factorial = 1;

			for (int i = 1; i <= num; i++) {
				factorial *= i;
			}
			return factorial;
		}
	}

	public static int factorialRecursive(int num) {
		if (num == 0 || num == 1) {
			return 1;
		} else {
			num *= factorialRecursive(num - 1);
			return num;
		}
	}

	public static void test() {
		int num = 1;
		int expected = 1;
		/*
		 * System.out.println( "factorialIterative " + num + " expected: " + expected +
		 * ", actual: " + factorialIterative(num)); System.out.println(
		 * "factorialRecursive " + num + " expected: " + expected + ", actual: " +
		 * factorialRecursive(num)); num = 0; expected = 1; System.out.println(
		 * "factorialIterative " + num + " expected: " + expected + ", actual: " +
		 * factorialIterative(num)); System.out.println( "factorialRecursive " + num +
		 * " expected: " + expected + ", actual: " + factorialRecursive(num)); num = 2;
		 * expected = 2; System.out.println( "factorialIterative " + num + " expected: "
		 * + expected + ", actual: " + factorialIterative(num)); System.out.println(
		 * "factorialRecursive " + num + " expected: " + expected + ", actual: " +
		 * factorialRecursive(num));
		 */
		num = 4;
		expected = 24;
		/*
		 * System.out.println( "factorialIterative " + num + " expected: " + expected +
		 * ", actual: " + factorialIterative(num));
		 */
		System.out.println(
				"factorialRecursive " + num + " expected: " + expected + ", actual: " + factorialRecursive(num));
		/*
		 * num = 6; expected = 720; System.out.println( "factorialIterative " + num +
		 * " expected: " + expected + ", actual: " + factorialIterative(num));
		 * System.out.println( "factorialRecursive " + num + " expected: " + expected +
		 * ", actual: " + factorialRecursive(num));
		 */
	}

}