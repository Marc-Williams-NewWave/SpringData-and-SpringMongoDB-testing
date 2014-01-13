package hello.springmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String userBio;
	private double accountBalance;
	
	
	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String name){
		this.firstName = name;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String name){
		this.lastName = name;
	}
	
	public String getUserBio() {
		return userBio;
	}

	public void setUserBio(String userBio) {
		this.userBio = userBio;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	

}
