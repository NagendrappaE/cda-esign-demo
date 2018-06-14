/**
 * 
 */
package com.evolvus.bean;

/**
 * @author EVOLVUS\nagendrappae
 *
 */
public class Request {
	private  EmandateRoot emandateRoot;
	
	private  BankInfo bankInfo;

	private ContactDetails contactDetails;

	public EmandateRoot getEmandateRoot() {
		return emandateRoot;
	}

	public void setEmandateRoot(EmandateRoot emandateRoot) {
		this.emandateRoot = emandateRoot;
	}

	public BankInfo getBankInfo() {
		return bankInfo;
	}

	public void setBankInfo(BankInfo bankInfo) {
		this.bankInfo = bankInfo;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}
	
}
