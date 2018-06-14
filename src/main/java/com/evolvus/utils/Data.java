package com.evolvus.utils;

import java.sql.Date;

public class Data {
	
	private String  issueName;
	
	private String issueDesc;
	
	private String  createdBy;
	
	private Date createdDate;
	
	private String noofBids;
	
	private String noofApp;

	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public String getIssueDesc() {
		return issueDesc;
	}

	public void setIssueDesc(String issueDesc) {
		this.issueDesc = issueDesc;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getNoofBids() {
		return noofBids;
	}

	public void setNoofBids(String noofBids) {
		this.noofBids = noofBids;
	}

	public String getNoofApp() {
		return noofApp;
	}

	public void setNoofApp(String noofApp) {
		this.noofApp = noofApp;
	}

}
