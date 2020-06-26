package user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import matura2019.Task1;

class Task1Test {
	private int[] twoNumberArray = {1,2};
	private int[] fourNumberArray = {1,5,6,2};

	private Task1 task1 = new Task1();
	
	@Test
	void givenTwoNumbers_findsFirstEven_withForLoop() {
		assertEquals(2, task1.findFirstEvenWithForLoop(twoNumberArray));
		
	}
	
	@Test
	void givenTwoNumbers_findsFirstEven_withWhileLoop() {
		assertEquals(2, task1.findFirstEvenWithWhileLoop(twoNumberArray));
	}
	
	@Test
	void givenFourNumbers_findsFirstEven_withForLoop() {
		assertEquals(6, task1.findFirstEvenWithForLoop(fourNumberArray));
		
	}
	
	@Test
	void givenFourNumbers_findsFirstEven_withWhileLoop() {
		assertEquals(6, task1.findFirstEvenWithWhileLoop(fourNumberArray));
	}

}
