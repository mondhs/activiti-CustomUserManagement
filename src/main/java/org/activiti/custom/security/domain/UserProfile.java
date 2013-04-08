package org.activiti.custom.security.domain;
/**
 * Class that represent custom security entity that represent system user.
 * 
 * @author mondhs
 *
 */
public class UserProfile {

	private String loginName;
	private String firstName;
	private String emailAddress;
	private String lastName;
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
