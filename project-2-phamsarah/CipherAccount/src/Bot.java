/**
 * This is the Bot user class that is a subclass of Account. It takes care of the bot's userAgent, category, and creator name.
 * Also print's all information in a String.
 * 
 * @author Sarah Pham
 * @version 1.0
 * 
 * COP3022 Project #: 2
 * File name: Bot.java
 * 
 * 
 */
public class Bot extends Account{
	private String userAgent;
	private String category;
	private String createdBy;
	
	/**
	 * Parameterized constructor that sends the password and salt to the super class Account
	 * and calls mutators to set variables userAgent, category, and creator
	 * @param agent the userAgent
	 * @param subject the category
	 * @param creator the createdBy
	 * @param password the plain text password
	 * @param salt the shift for the encryption
	 */
	
	public Bot(String agent, String category, String creator, String password, int salt) {
		super(password, salt);
		this.setUserAgent(agent);
		this.setCategory(category);
		this.setCreatedBy(creator);
	}
	
	/**
	 * Mutator method that sets the given user agent passed from constructor to the instance variable
	 * userAgent
	 * @param agent the user agent
	 */
	
	public void setUserAgent(String agent) {
		this.userAgent = agent;
	}
	
	/**
	 * Accessor method for the userAgent
	 * @return userAgent
	 */
	
	public String getUserAgent() {
		return this.userAgent;
	}
	
	/**
	 * Mutator method to set the given category to the instance variable category
	 * @param category the category of the bot
	 */
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * Accessor method for the category
	 * @return category
	 */
	
	public String getCategory() {
		return this.category;
	}
	
	/**
	 * Mutator method to set the given creator to the instance variable createdBy
	 * @param creator whoever created the Bot
	 */
	
	public void setCreatedBy(String creator) {
		this.createdBy = creator;
	}
	
	/**
	 * Accessor method for createdBy
	 * @return createdBy
	 */
	
	public String getCreatedBy() {
		return this.createdBy;
	}
	
	/**
	 * String method that returns all information in a nicely formatted string and call the Account toString() to also
	 * include the password and encrypted password to the output
	 */
	
	public String toString() {
		return (this.getCategory() + " bot, User-Agent string = " + this.getUserAgent() + " was created by " + this.getCreatedBy() + ".\n" + super.toString());
	}
}
