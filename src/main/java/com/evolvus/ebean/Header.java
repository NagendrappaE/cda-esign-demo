/**
 * 
 */
package com.evolvus.ebean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author EVOLVUS\nagendrappae
 *
 */




@JsonPropertyOrder(
	{"sourceId",
	"mndAction",
	"msgId",
	"errMsg",
	"errorCode",
	"txnStatusFlg",
	"successMsg"
	})

public class Header
{
	
    private String sourceId;
    
    private String mndAction;
    
    private String  msgId;
    
	private String successMsg;

    private String errMsg;

	private String txnStatusFlg;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private  String  errorCode;
	
	

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getTxnStatusFlg() {
		return txnStatusFlg;
	}

	public void setTxnStatusFlg(String txnStatusFlg) {
		this.txnStatusFlg = txnStatusFlg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the sourceId
	 */
	public String getSourceId() {
		return sourceId;
	}

	/**
	 * @param sourceId the sourceId to set
	 */
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * @return the mndAction
	 */
	public String getMndAction() {
		return mndAction;
	}

	/**
	 * @param mndAction the mndAction to set
	 */
	public void setMndAction(String mndAction) {
		this.mndAction = mndAction;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}


   
}
