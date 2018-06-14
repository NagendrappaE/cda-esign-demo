package com.evolvus.utils;

public interface NSDL {

	public static String NSDL_REQUEST = "<Esign ver =\"${esignVersion}\" sc =\"Y\" ts=\"${dateTime}\" txn=\"${txnId}\" ekycMode=\"${eKYCMode}\" ekycId=\"${ekycId}\" ekycIdType=\"${eKYCIdType}\" aspId=\"${aspId}\" AuthMode=\"${authMode}\" responseSigType=\"${responseSigType}\"  preVerified=\"n\" organizationFlag=\"n\"  responseUrl=\"${responseURL}\">"+
			"<Docs>"
			+ "<InputHash id=\"\" hashAlgorithm=\"\" docInfo=\"\"></InputHash>" + "</Docs>"
			+ "<AspKycData>${hashXMLData}</AspKycData>" +
			/*
			 * "<OrgDetails></OrgDetails>"+ "<Signature></Signature>"+
			 */
			"</Esign>";

}
