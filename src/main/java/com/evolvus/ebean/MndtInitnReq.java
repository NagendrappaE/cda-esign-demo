/**
 * 
 */
package com.evolvus.ebean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author EVOLVUS\nagendrappae
 *
 */
import javax.xml.bind.annotation.XmlRootElement;

public class MndtInitnReq {
	
	
/*	private Date mndStartDate;
	
	private Date mndEndDate;

	private String utilityCode;
	
	
	
	private String acctType;
	
	private  String  accountNumber;
	
	private  String accountHolderName;
	
	private String adharNumber;
	
	private String ifscMicrCode;


	
    private String frequency;
    
	private String sponserBankCode;
	
	private String payeeBankCode;
	
	private  String  colltnAmt;
	
	private  String maxAmount;
	
	
	private  String mobileNo;
	
	private String  phoneNo;
	
	private  String emailId;
	
	//for  reference1
	private String panNumber;

	*//**
	 * @return the mndStartDate
	 *//*
	public Date getMndStartDate() {
		return mndStartDate;
	}

	*//**
	 * @param mndStartDate the mndStartDate to set
	 *//*
	public void setMndStartDate(Date mndStartDate) {
		this.mndStartDate = mndStartDate;
	}

	*//**
	 * @return the mndEndDate
	 *//*
	public Date getMndEndDate() {
		return mndEndDate;
	}

	*//**
	 * @param mndEndDate the mndEndDate to set
	 *//*
	public void setMndEndDate(Date mndEndDate) {
		this.mndEndDate = mndEndDate;
	}

	*//**
	 * @return the utilityCode
	 *//*
	public String getUtilityCode() {
		return utilityCode;
	}

	*//**
	 * @param utilityCode the utilityCode to set
	 *//*
	public void setUtilityCode(String utilityCode) {
		this.utilityCode = utilityCode;
	}

	*//**
	 * @return the acctType
	 *//*
	public String getAcctType() {
		return acctType;
	}

	*//**
	 * @param acctType the acctType to set
	 *//*
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	*//**
	 * @return the accountNumber
	 *//*
	public String getAccountNumber() {
		return accountNumber;
	}

	*//**
	 * @param accountNumber the accountNumber to set
	 *//*
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	*//**
	 * @return the accountHolderName
	 *//*
	public String getAccountHolderName() {
		return accountHolderName;
	}

	*//**
	 * @param accountHolderName the accountHolderName to set
	 *//*
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	*//**
	 * @return the adharNumber
	 *//*
	public String getAdharNumber() {
		return adharNumber;
	}

	*//**
	 * @param adharNumber the adharNumber to set
	 *//*
	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	*//**
	 * @return the ifscMicrCode
	 *//*
	public String getIfscMicrCode() {
		return ifscMicrCode;
	}

	*//**
	 * @param ifscMicrCode the ifscMicrCode to set
	 *//*
	public void setIfscMicrCode(String ifscMicrCode) {
		this.ifscMicrCode = ifscMicrCode;
	}

	*//**
	 * @return the frequency
	 *//*
	public String getFrequency() {
		return frequency;
	}

	*//**
	 * @param frequency the frequency to set
	 *//*
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	*//**
	 * @return the sponserBankCode
	 *//*
	public String getSponserBankCode() {
		return sponserBankCode;
	}

	*//**
	 * @param sponserBankCode the sponserBankCode to set
	 *//*
	public void setSponserBankCode(String sponserBankCode) {
		this.sponserBankCode = sponserBankCode;
	}

	*//**
	 * @return the payeeBankCode
	 *//*
	public String getPayeeBankCode() {
		return payeeBankCode;
	}

	*//**
	 * @param payeeBankCode the payeeBankCode to set
	 *//*
	public void setPayeeBankCode(String payeeBankCode) {
		this.payeeBankCode = payeeBankCode;
	}

	*//**
	 * @return the colltnAmt
	 *//*
	public String getColltnAmt() {
		return colltnAmt;
	}

	*//**
	 * @param colltnAmt the colltnAmt to set
	 *//*
	public void setColltnAmt(String colltnAmt) {
		this.colltnAmt = colltnAmt;
	}

	*//**
	 * @return the maxAmount
	 *//*
	public String getMaxAmount() {
		return maxAmount;
	}

	*//**
	 * @param maxAmount the maxAmount to set
	 *//*
	public void setMaxAmount(String maxAmount) {
		this.maxAmount = maxAmount;
	}

	*//**
	 * @return the mobileNo
	 *//*
	public String getMobileNo() {
		return mobileNo;
	}

	*//**
	 * @param mobileNo the mobileNo to set
	 *//*
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	*//**
	 * @return the phoneNo
	 *//*
	public String getPhoneNo() {
		return phoneNo;
	}

	*//**
	 * @param phoneNo the phoneNo to set
	 *//*
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	*//**
	 * @return the emailId
	 *//*
	public String getEmailId() {
		return emailId;
	}

	*//**
	 * @param emailId the emailId to set
	 *//*
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	*//**
	 * @return the panNumber
	 *//*
	public String getPanNumber() {
		return panNumber;
	}

	*//**
	 * @param panNumber the panNumber to set
	 *//*
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	*/
	
	
	
	//private GrpHdr grpHdr;
	//old  details
	private String startDate;

	private String orgOic;

	private String payerAccountType;

	private String frequency;

	private String expirydate;

	private String sponserBankCode;

	private String minAmt;

	private String payerEmail;

	private String payerAccountNum;

	private String adharNumber;

	private String payerMobileContact;

	private String payerBankCode;

	private String payerName;

	private String maxAmt;

	private String amountType;
	
	
	

	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getOrgOic() {
		return orgOic;
	}

	public void setOrgOic(String orgOic) {
		this.orgOic = orgOic;
	}

	public String getPayerAccountType() {
		return payerAccountType;
	}

	public void setPayerAccountType(String payerAccountType) {
		this.payerAccountType = payerAccountType;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}

	public String getSponserBankCode() {
		return sponserBankCode;
	}

	public void setSponserBankCode(String sponserBankCode) {
		this.sponserBankCode = sponserBankCode;
	}

	public String getMinAmt() {
		return minAmt;
	}

	public void setMinAmt(String minAmt) {
		this.minAmt = minAmt;
	}

	public String getPayerEmail() {
		return payerEmail;
	}

	public void setPayerEmail(String payerEmail) {
		this.payerEmail = payerEmail;
	}

	public String getPayerAccountNum() {
		return payerAccountNum;
	}

	public void setPayerAccountNum(String payerAccountNum) {
		this.payerAccountNum = payerAccountNum;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getPayerMobileContact() {
		return payerMobileContact;
	}

	public void setPayerMobileContact(String payerMobileContact) {
		this.payerMobileContact = payerMobileContact;
	}

	public String getPayerBankCode() {
		return payerBankCode;
	}

	public void setPayerBankCode(String payerBankCode) {
		this.payerBankCode = payerBankCode;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getMaxAmt() {
		return maxAmt;
	}

	public void setMaxAmt(String maxAmt) {
		this.maxAmt = maxAmt;
	}

	public String getAmountType() {
		return amountType;
	}

	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}

	@Override
	public String toString() {
		return "ClassPojo [startDate = " + startDate + ", orgOic = " + orgOic + ", payerAccountType = "
				+ payerAccountType + ", frequency = " + frequency + ", expirydate = " + expirydate
				+ ", sponserBankCode = " + sponserBankCode + ", minAmt = " + minAmt + ", payerEmail = " + payerEmail
				+ ", payerAccountNum = " + payerAccountNum + ", adharNumber = " + adharNumber
				+ ", payerMobileContact = " + payerMobileContact + ", payerBankCode = " + payerBankCode
				+ ", payerName = " + payerName + ", maxAmt = " + maxAmt + ", amountType = " + amountType + "]";
	}
}
