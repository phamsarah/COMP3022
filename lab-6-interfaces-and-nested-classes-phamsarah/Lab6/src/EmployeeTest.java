import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void test() {

			Employee Sarah = new Employee(2.0, "Sarah Pham");
			assertEquals("First name: Sarah    Last name: Pham     Makes: 2.00", Sarah.print());
	}

}
