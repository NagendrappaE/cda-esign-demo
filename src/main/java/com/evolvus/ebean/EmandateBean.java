/**
 * 
 */
package com.evolvus.ebean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author EVOLVUS\nagendrappae
 *
 */
public class EmandateBean {
	private  String  sourceId;
	
	private String msgId;

	private Date mandateInitDate;

	private String corporateId;

	private String corporateName;

	private String utilityCode;

	private String mandateAmountType;

	private String mandateCataogoryCode;

	private String umrn;

	private String reasonCode;

	private String adharNumber;

	private String phoneNo;

	private String mobileNo;

	private String emailId;

	private String others;

	private String declaration;

	private String authorization;

	private String payerName;

	private String customerAccType;

	private String legalAccountNumber;

	private String sponserBankCode;

	private String sponserBankName;

	private String destbankCode;

	private String destBankName;

	//private String ifscMicr;

	private BigDecimal amount;

	private BigDecimal collectAmount;

	private String consumerRefeNumber;

	private String schemeOrPlanRefNo;

	private String frequency;

	private Date mndStartDate;

	private Date mndEnddate;

	

	/**
	 * @return the mandateInitDate
	 */
	public Date getMandateInitDate() {
		return mandateInitDate;
	}

	/**
	 * @param mandateInitDate
	 *            the mandateInitDate to set
	 */
	public void setMandateInitDate(Date mandateInitDate) {
		this.mandateInitDate = mandateInitDate;
	}

	/**
	 * @return the corporateId
	 */
	public String getCorporateId() {
		return corporateId;
	}

	/**
	 * @param corporateId
	 *            the corporateId to set
	 */
	public void setCorporateId(String corporateId) {
		this.corporateId = corporateId;
	}

	/**
	 * @return the corporateName
	 */
	public String getCorporateName() {
		return corporateName;
	}

	/**
	 * @param corporateName
	 *            the corporateName to set
	 */
	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	/**
	 * @return the utilityCode
	 */
	public String getUtilityCode() {
		return utilityCode;
	}

	/**
	 * @param utilityCode
	 *            the utilityCode to set
	 */
	public void setUtilityCode(String utilityCode) {
		this.utilityCode = utilityCode;
	}

	/**
	 * @return the mandateAmountType
	 */
	public String getMandateAmountType() {
		return mandateAmountType;
	}

	/**
	 * @param mandateAmountType
	 *            the mandateAmountType to set
	 */
	public void setMandateAmountType(String mandateAmountType) {
		this.mandateAmountType = mandateAmountType;
	}

	/**
	 * @return the mandateCataogoryCode
	 */
	public String getMandateCataogoryCode() {
		return mandateCataogoryCode;
	}

	/**
	 * @param mandateCataogoryCode
	 *            the mandateCataogoryCode to set
	 */
	public void setMandateCataogoryCode(String mandateCataogoryCode) {
		this.mandateCataogoryCode = mandateCataogoryCode;
	}

	/**
	 * @return the umrn
	 */
	public String getUmrn() {
		return umrn;
	}

	/**
	 * @param umrn
	 *            the umrn to set
	 */
	public void setUmrn(String umrn) {
		this.umrn = umrn;
	}

	

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	/**
	 * @return the adharNumber
	 */
	public String getAdharNumber() {
		return adharNumber;
	}

	/**
	 * @param adharNumber
	 *            the adharNumber to set
	 */
	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo
	 *            the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo
	 *            the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the others
	 */
	public String getOthers() {
		return others;
	}

	/**
	 * @param others
	 *            the others to set
	 */
	public void setOthers(String others) {
		this.others = others;
	}

	/**
	 * @return the declaration
	 */
	public String getDeclaration() {
		return declaration;
	}

	/**
	 * @param declaration
	 *            the declaration to set
	 */
	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}

	/**
	 * @return the authorization
	 */
	public String getAuthorization() {
		return authorization;
	}

	/**
	 * @param authorization
	 *            the authorization to set
	 */
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	/**
	 * @return the payerName
	 */
	public String getPayerName() {
		return payerName;
	}

	/**
	 * @param payerName
	 *            the payerName to set
	 */
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	/**
	 * @return the customerAccType
	 */
	public String getCustomerAccType() {
		return customerAccType;
	}

	/**
	 * @param customerAccType
	 *            the customerAccType to set
	 */
	public void setCustomerAccType(String customerAccType) {
		this.customerAccType = customerAccType;
	}

	/**
	 * @return the legalAccountNumber
	 */
	public String getLegalAccountNumber() {
		return legalAccountNumber;
	}

	/**
	 * @param legalAccountNumber
	 *            the legalAccountNumber to set
	 */
	public void setLegalAccountNumber(String legalAccountNumber) {
		this.legalAccountNumber = legalAccountNumber;
	}

	/**
	 * @return the sponserBankCode
	 */
	public String getSponserBankCode() {
		return sponserBankCode;
	}

	/**
	 * @param sponserBankCode
	 *            the sponserBankCode to set
	 */
	public void setSponserBankCode(String sponserBankCode) {
		this.sponserBankCode = sponserBankCode;
	}

	/**
	 * @return the sponserBankName
	 */
	public String getSponserBankName() {
		return sponserBankName;
	}

	/**
	 * @param sponserBankName
	 *            the sponserBankName to set
	 */
	public void setSponserBankName(String sponserBankName) {
		this.sponserBankName = sponserBankName;
	}

	/**
	 * @return the destbankCode
	 */
	public String getDestbankCode() {
		return destbankCode;
	}

	/**
	 * @param destbankCode
	 *            the destbankCode to set
	 */
	public void setDestbankCode(String destbankCode) {
		this.destbankCode = destbankCode;
	}

	/**
	 * @return the destBankName
	 */
	public String getDestBankName() {
		return destBankName;
	}

	/**
	 * @param destBankName
	 *            the destBankName to set
	 */
	public void setDestBankName(String destBankName) {
		this.destBankName = destBankName;
	}

	/**
	 * @return the ifscMicr
	 *//*
	public String getIfscMicr() {
		return ifscMicr;
	}

	*//**
	 * @param ifscMicr
	 *            the ifscMicr to set
	 *//*
	public void setIfscMicr(String ifscMicr) {
		this.ifscMicr = ifscMicr;
	}*/

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the consumerRefeNumber
	 */
	public String getConsumerRefeNumber() {
		return consumerRefeNumber;
	}

	/**
	 * @param consumerRefeNumber
	 *            the consumerRefeNumber to set
	 */
	public void setConsumerRefeNumber(String consumerRefeNumber) {
		this.consumerRefeNumber = consumerRefeNumber;
	}

	/**
	 * @return the schemeOrPlanRefNo
	 */
	public String getSchemeOrPlanRefNo() {
		return schemeOrPlanRefNo;
	}

	/**
	 * @param schemeOrPlanRefNo
	 *            the schemeOrPlanRefNo to set
	 */
	public void setSchemeOrPlanRefNo(String schemeOrPlanRefNo) {
		this.schemeOrPlanRefNo = schemeOrPlanRefNo;
	}

	/**
	 * @return the frequency
	 */
	public String getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency
	 *            the frequency to set
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return the mndStartDate
	 */
	public Date getMndStartDate() {
		return mndStartDate;
	}

	/**
	 * @param mndStartDate
	 *            the mndStartDate to set
	 */
	public void setMndStartDate(Date mndStartDate) {
		this.mndStartDate = mndStartDate;
	}

	/**
	 * @return the mndEnddate
	 */
	public Date getMndEnddate() {
		return mndEnddate;
	}

	/**
	 * @param mndEnddate
	 *            the mndEnddate to set
	 */
	public void setMndEnddate(Date mndEnddate) {
		this.mndEnddate = mndEnddate;
	}

	/**
	 * @return the collectAmount
	 */
	public BigDecimal getCollectAmount() {
		return collectAmount;
	}

	/**
	 * @param collectAmount
	 *            the collectAmount to set
	 */
	public void setCollectAmount(BigDecimal collectAmount) {
		this.collectAmount = collectAmount;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

}
