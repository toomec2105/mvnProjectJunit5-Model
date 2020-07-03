package user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import matura2019.part1.Task1;

public class Task1_LogarithmicTest {
	private int[] twoNumberArray = { 1, 2 };
	private int[] fourNumberArray = { 1, 5, 6, 2 };
	private int[] threeNumberArray = {1, 8, 102 };
	private int[] exampleArray = { 5, 99, 35, 7, 111, 13, 4, 24, 4, 8 };
	private Task1 task1 = new Task1();

	@Test
	void findsFirstEvenIterative() {
		assertEquals(2, task1.findFirstEven_Logarithmic_Iterative(twoNumberArray));
		assertEquals(4, task1.findFirstEven_Logarithmic_Iterative(exampleArray));
		assertEquals(6, task1.findFirstEven_Logarithmic_Iterative(fourNumberArray));
		assertEquals(8, task1.findFirstEven_Logarithmic_Iterative(threeNumberArray));
	}
	
	@Test
	void findsFirstEvenRecursive() {
		assertEquals(2, task1.findFirstEven_Logarithmic_Recursive(twoNumberArray, 0 , 2));
		assertEquals(4, task1.findFirstEven_Logarithmic_Recursive(exampleArray, 0, 10));
		assertEquals(6, task1.findFirstEven_Logarithmic_Recursive(fourNumberArray, 0, 4));
		assertEquals(8, task1.findFirstEven_Logarithmic_Recursive(threeNumberArray, 0 ,3));
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
			
			assertEquals(15, task1.binarySearch(arr,15));
		}
	}
}
