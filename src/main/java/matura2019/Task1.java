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

	public Integer findFirstEven_Logarithmic(int[] twoNumberArray) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
