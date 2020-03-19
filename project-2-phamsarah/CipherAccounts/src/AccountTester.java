import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Scanner;

public class AccountTester {

	@Test
	public void test() {
		
		
		Scanner file = new Scanner(System.in);
		
		String letter = file.next();
		String username = file.next();
		String fullName = file.next();
		int deptCode = file.nextInt();
		String password = file.next();
		int salt = file.nextInt();
		
		
		
		User Grace = new User(username,fullName,deptCode,password, salt);
		assertEquals("ADMHops", Grace.getUsername());
		assertEquals(12498, Grace.getdeptCode());
	}}