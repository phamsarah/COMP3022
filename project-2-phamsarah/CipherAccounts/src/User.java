
public class User extends Account{
	private String username; 
	private String fullName;
	private int deptCode; 
		// username, fullname, deptcode, password and salt
	public User(String user, String name, int code, String password, int salt) {
		super(password, salt);
		this.setUsername(user);
		this.setfullName(name);
		this.setdeptCode(code);

	}
	
	public void setUsername(String user) {
		this.username = user;
	}
	
	public String getUsername() {
		return this.username; 
	}
	
	public void setfullName(String name) {
		this.fullName = name;
	}
	
	public String getfullName() {
		return this.fullName;
	}
	
	public void setdeptCode(int code) {
		this.deptCode = code;
	}
	
	public int getdeptCode() {
		return this.deptCode;
	}
	
	public String toString() {
		return (this.fullName + " (username: " + this.username + ")" + "works in department " + this.deptCode + ".\n" + super.toString());
	}
}
