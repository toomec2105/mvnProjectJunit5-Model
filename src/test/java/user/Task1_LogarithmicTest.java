package user;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import matura2019.Task1;


public class Task1_LogarithmicTest {
	private int[] twoNumberArray = {1,2};
	private int[] fourNumberArray = {1,5,6,2};

	private Task1 task1 = new Task1();
	@Test
	void givenTwoNumbers_findsFirstEven() {
		assertEquals(2, task1.findFirstEven_Logarithmic(twoNumberArray));
		
	}
}
