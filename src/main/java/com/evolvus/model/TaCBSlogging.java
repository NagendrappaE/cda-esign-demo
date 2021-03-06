//package com.evolvus.model;
//
//import java.io.Serializable;
//import java.util.Date;
//
////import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
////@Entity
////@Table(name = "TA_CBS_LOGGING")
//public class TaCBSlogging implements Serializable {
//	
//	
//	
//	
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "mandate_seq")
//	@SequenceGenerator(name = "mandate_seq", sequenceName = "SWS_TA_CBS_LOGGING")
//	@Column(name = "LOG_ID ")
//	private Integer logId;
//
//	@Column(name = "WS_NAME", unique = true, nullable = false, length = 50)
//
//	private String name;
//
//	@Column(name = "WS_TIME_SEC", unique = true, nullable = false, length = 50)
//
//	private String webServiceTime;
//
//	@Column(name = "PROCESS_TIME_SEC", unique = true, nullable = false, length = 50)
//
//	private String processTime;
//
//	@Column(name = "INITIATED_DATE", unique = true, nullable = false, length = 50)
//
//	private Date initiatedDate;
//
//	@Column(name = "REQUEST_STR", unique = true, nullable = false, length = 50)
//
//	private String requestStr;
//
//	@Column(name = "RESPONSE_STR", unique = true, nullable = false, length = 50)
//
//	private String responseStr;
//
//	public Integer getLogId() {
//		return logId;
//	}
//
//	public void setLogId(Integer logId) {
//		this.logId = logId;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getWebServiceTime() {
//		return webServiceTime;
//	}
//
//	public void setWebServiceTime(String webServiceTime) {
//		this.webServiceTime = webServiceTime;
//	}
//
//	public String getProcessTime() {
//		return processTime;
//	}
//
//	public void setProcessTime(String processTime) {
//		this.processTime = processTime;
//	}
//
//	public Date getInitiatedDate() {
//		return initiatedDate;
//	}
//
//	public void setInitiatedDate(Date initiatedDate) {
//		this.initiatedDate = initiatedDate;
//	}
//
//	public String getRequestStr() {
//		return requestStr;
//	}
//
//	public void setRequestStr(String requestStr) {
//		this.requestStr = requestStr;
//	}
//
//	public String getResponseStr() {
//		return responseStr;
//	}
//
//	public void setResponseStr(String responseStr) {
//		this.responseStr = responseStr;
//	}
//
//	
//	
//	
//	
//}
