package user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
	User user = new User();

	@BeforeEach
	public void setUp() throws Exception {
		user.setName("Hil");
	}

	@Test
	public void shouldReturnCorrectName() {
		assertEquals("Hil", user.getName());
	}

	@Test
	public void shouldFail() {
		assertEquals("######", user.getName());
	}

}
