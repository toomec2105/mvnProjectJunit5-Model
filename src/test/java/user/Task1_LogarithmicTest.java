package user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import matura2019.Task1;

public class Task1_LogarithmicTest {
	private int[] twoNumberArray = { 1, 2 };
	private int[] fourNumberArray = { 1, 5, 6, 2 };
	private int[] sevenNumberArrayWith15 = { 1, 8, 15, 17, 99, 100, 102 };
	private Task1 task1 = new Task1();

	@Disabled
	@Test
	void givenTwoNumbers_findsFirstEven() {
		assertEquals(2, task1.findFirstEven_Logarithmic(twoNumberArray));

	}

	@Test
	void binarySearchTest() {
		
		int[][] nums = {
				  {15},
				  {15,20},
				  {20,15},
				  {3,15,20},
				  {15,16,20},
				  {1,2,15},
				  {1,2,15,20},
				  {5,15,17,20},
				  {1,10,11,14,15,20},
				  {15,16,19,200,210,215}
			};
		for (int[] arr : nums) {
			
			assertEquals(15, task1.binarySearch(arr));
		}
	}
}
