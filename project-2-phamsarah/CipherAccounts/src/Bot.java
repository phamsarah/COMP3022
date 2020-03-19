public class Bot extends Account{
	private String userAgent;
	private String category;
	private String createdBy;
	
	public Bot(String agent, String subject, String creator, String password, int salt) {
		super(password, salt);
		this.setUserAgent(agent);
		this.setCategory(subject);
		this.setCreatedBy(creator);
	}
	
	public void setUserAgent(String agent) {
		this.userAgent = agent;
	}
	
	public String getUserAgent() {
		return this.userAgent;
	}
	
	public void setCategory(String subject) {
		this.category = subject;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public void setCreatedBy(String creator) {
		this.createdBy = creator;
	}
	
	public String getCreatedBy() {
		return this.createdBy;
	}
	
	public String toString() {
		return (this.category + ", User-Agent string = " + this.userAgent + " was created by " + this.createdBy + ".\n" + super.toString());
	}
}
