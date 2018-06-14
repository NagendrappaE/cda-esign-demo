/**
 * 
 */
package com.evolvus.bean;

/**
 * @author EVOLVUS\nagendrappae
 *
 */
public class Response {
	private String successMsg;

    private  String responseString;


	private String errMsg;

	private String txnStatusFlg;

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}

	public String getResponseString() {
		return responseString;
	}

	public void setResponseString(String responseString) {
		this.responseString = responseString;
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
	
}
