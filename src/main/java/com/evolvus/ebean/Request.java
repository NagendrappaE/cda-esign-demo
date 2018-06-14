/**
 * 
 */
package com.evolvus.ebean;

import java.io.Serializable;


/**
 * @author EVOLVUS\nagendrappae
 *
 */

public class Request
{
	private  EmandateRoot emandateRoot;
	
	private  BankInfo bankInfo;

	private ContactDetails contactDetails;

	/**
	 * @return the emandateRoot
	 */
	public EmandateRoot getEmandateRoot() {
		return emandateRoot;
	}

	/**
	 * @param emandateRoot the emandateRoot to set
	 */
	public void setEmandateRoot(EmandateRoot emandateRoot) {
		this.emandateRoot = emandateRoot;
	}

	/**
	 * @return the bankInfo
	 */
	public BankInfo getBankInfo() {
		return bankInfo;
	}

	/**
	 * @param bankInfo the bankInfo to set
	 */
	public void setBankInfo(BankInfo bankInfo) {
		this.bankInfo = bankInfo;
	}

	/**
	 * @return the contactDetails
	 */
	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	/**
	 * @param contactDetails the contactDetails to set
	 */
	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}
}
		