
public class Employee {
	private double salary;
	Name worker;
	
	Employee(double salary, String fullName){
		this.salary = salary;
		this.worker = new Name(fullName);
	}
	
	public String print() {
	    worker.print();
		return "     Makes: " + String.format("%.2f", this.salary);
	}
	
	private class Name implements Printable {
		private String firstName;
		private String lastName;
		
		Name(String fullName){
			String[] parts = fullName.split("\\s+");
			this.firstName = parts[0];
			this.lastName = parts[1];
		}
		
		public void print(){
			System.out.print("First name: " + this.firstName + "    Last name: " + this.lastName);
		}
	}
}
