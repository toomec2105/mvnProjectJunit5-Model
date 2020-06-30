package matura2019;

public class Task1 {

	public Integer findFirstEvenWithForLoop_Linear(int[] A) {
		int w = 0;
		int n = A.length;

		for (int i = 0; i < n; i++) {

			if (A[i] % 2 == 0) {
				w = A[i];
				return w;
			}
		}

		return null;
	}

	public Integer findFirstEvenWithWhileLoop_Linear(int[] A) {
		int i = 0;
		int w = 0;

		while (A[i] % 2 == 1) {
			i++;
		}

		w = A[i];

		return w;
	}

	public Integer findFirstEven_Logarithmic_Iterative(int[] A) {
		int w = 0;
		int n = A.length;
		int start = 0;

		while (start <= n) {
			int middle = (start + n) / 2;

			if (A[middle] % 2 == 0) {
				n = middle - 1;
			} else {
				start = middle + 1;
			}
		}

		w = A[start];
		return w;
	}

	public Integer findFirstEven_Logarithmic_Recursive(int[] A, int start, int end) {
		int w = A[start];
		int middle = (start + end) / 2;
		
		if (start > end) {
			return A[start];
		} else if (A[middle] % 2 == 0) {
			w = findFirstEven_Logarithmic_Recursive(A, start, middle - 1);
		} else {
			w = findFirstEven_Logarithmic_Recursive(A, middle + 1, end);
		}
		return w;
	}

	public Integer binarySearch(int[] A, int searchedNumber) {

		int start = 0;
		int end = A.length;

		while (start <= end) {
			int middle = (start + end) / 2;

			if (A[middle] == searchedNumber) {
				return searchedNumber;
			} else if (A[middle] > searchedNumber) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}
		return null;
	}

}
