<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>E-mandate</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-combined.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/dashboard.css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/static/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	href="${pageContext.request.contextPath}/resources/static/js/bootstrap-datetimepicker.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/family.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/fluxdemo.css">
<script>
	$(document).ready(function() {
		$("#startDate").datepicker();
		$("#endDate").datepicker();

		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
</head>
<body>
	<nav class="navbar navbar-inverse mainheader">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><img
				src="/resources/images/evolvus-logo.png" width="168"></a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/FLUX/login" data-toggle="tooltip"
				data-placement="bottom" title="Esign"><span
					class="glyphicon glyphicon-edit"></span></a></li>
			<li><a href="/FLUX/enq" data-toggle="tooltip"
				data-placement="bottom" title="Search"><span
					class="glyphicon glyphicon-search"></span></a></li>
		</ul>
	</div>
	</nav>
	
	<div class="container">
		<div class="row">
			<form class="emandateForm" name="emandateFormName" action="register" method="post" onsubmit="return validateForm()">
				<div id="legend">
					<h4>E-SIGN MANDATE</h4>
				</div>
				<fieldset>
					<legend>Corporate Details</legend>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="utilityCode" class="col-sm-4">Utility Code:</label>
									<div class="col-sm-8">
										<select class="form-control" id="corpDetails"
											name="utilityCode" onchange="fun();">
											<option value="choose">NACH00000000001</option>
											<c:forEach var="utilityCodeValues" items="${utilityCodes}">
												<option value="${utilityCodeValues}">${utilityCodeValues}</option>
    										</c:forEach>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="sponserBank" class="col-sm-4">SponserBank:</label>
									<div class="col-sm-8">
										<input id="sponserBankifsc" type="text" readonly="readonly"
											class="form-control" name="sponserBankifsc"
											style="text-transform: uppercase;" value="Federal Bank" />
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4" style="margin-bottom: -30px;">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group" style="margin-bottom: 5% !important;">
									<input readonly="readonly" name=utilityDesc type="text"
										class="form-control" id="utilityDesc" value="Home Loans">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<input readonly="readonly" type="text" name=sponserBankName
										class="form-control" id="sponserLabel" value="FDRL000001">
								</div>
							</div>
						</div>
					</div>
				</fieldset>
				
				<fieldset>
					<legend>Customer Details</legend>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="customerName" class="col-sm-4">Customer	Name:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="customerName" value="${customerName}">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="col-sm-4">Aadhar Number:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="aadhar"
											maxlength="12" value="${aadharNumber}">
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="col-sm-4">Reference Number1:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="reference1"
											maxlength="12" value="12345678887788">
									</div>
								</div>
							</div>
						</div>
						
						
						
						
					
						
						
						
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-4">Email Id:</label>
									<div class="col-sm-8">
										<input type="email" class="form-control" name="email" value="${email}">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="col-sm-4">Mobile Number:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="mobile"
											maxlength="12" value="${mobile}" >
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="col-sm-4">Reference Number2:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="reference2"
											maxlength="12" value="1234567888778898">
									</div>
								</div>
							</div>
						</div>
					</div>
				</fieldset>
				
				<fieldset>
					<legend>Customer Account Details</legend>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="mandate" class="col-sm-4">Bank IFSC:</label>
									<div class="col-sm-8">
										<input id="bankIfsc" type="text" maxlength="11"
											class="form-control" name="bankIfsc" onblur="getData();"
											style="text-transform: uppercase;" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="accountnumber" class="col-sm-4">Account	Number:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="accountnumber"
											id="accountnumber" maxlength="14" />
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group" style="margin-bottom: 5% !important;">
									<input readonly="readonly" id="bankIfscId" type="text"
										class="form-control" name="branchName" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="confirmAccountNumber" class="col-sm-4">Confirm
										Account Number:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control"
											name="confirmAccountNumber" maxlength="14" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="accountType" class="col-sm-4">Account Type:</label>
								<div class="col-sm-8">
									<select class="form-control" name="accountType" id="accountType" onchange="return accountTypeValidation();" >
										<option value="choose">Choose</option>
										<c:forEach var="accountTypeValues" items="${accountTypes}">
										<option value="${accountTypeValues}">${accountTypeValues}</option>
										</c:forEach>
									</select> 
								</div>
							</div>
						</div>
					</div>
				</fieldset>

				<fieldset style="margin-bottom: 15px;">
					<legend>Mandate Details</legend>
					<div class="col-md-4">
						<!-- <div class="row">
						<div class="col-md-12">
							<div class="form-group">
							    <label for="Type" class="col-sm-4">Collection Type:</label>
							    <div class="col-sm-8">
							     <select class="form-control" name="collectionType">
								   	<option value="choose">Choose</option>
									<option>Reccuring</option>
									<option>One-Time</option></select>
								  </select>
							    </div>
							  </div>
						</div>
					</div> -->
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="Type" class="col-sm-4">Collection Type:</label>
									<div class="col-sm-8">
										<select class="form-control" name="collectionType" id="collectionType" onchange="return collectionTypeValidation();">
											<option value="choose">Fixed</option>
											<c:forEach var="collectionTypeVal" items="${collectionTypes}">
											<option value="${collectionTypeVal}">${collectionTypeVal}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="startDate" class="col-sm-4">Start Date:</label>
									<div class="col-sm-8">
										<input type="text" id="startDate" class="form-control"
											name="startDate"  value="${startDate}"/>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="amount" class="col-sm-4">Collection Amount:</label>
									<div class="col-sm-8">
										<input type="text" name="amount" class="form-control"
											maxlength="12" value="3500" />
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="frequency" class="col-sm-4">Frequency:</label>
									<div class="col-sm-8">
										<select class="form-control" name="frequency" id="frequency" onchange="return validateFrequency();">
											<option value="choose">Monthly</option>
											<c:forEach  var="frequencyvalue" items="${frequency}">
											<option value="${frequencyvalue}">${frequencyvalue}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="endDate" class="col-sm-4">End Date:</label>
									<div class="col-sm-8">
										<input type="date" id="endDate" class="form-control"
											name="endDate" value="22-09-2018" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="maxamount" class="col-sm-4">Max Amount:</label>
									<div class="col-sm-8">
										<input type="text" name="maxamount" id="maxamount" class="form-control"
											maxlength="12"  value="2500000"/>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- <div class="row btnFormat text-center">
						<input class="btn btn-primary" name="Save" type="submit" value="Save" />
						<input class="btn btn-primary" name="Cancel" type="hidden" value="Cancel" align="right" />
						<input class="btn btn-primary" name="Reset" type="reset" value="Reset" align="right" />
					</div>
					 --> 
					<div class="row btnFormat text-center">
						
						<textarea id="cdacRequestXml" style="display:none;">${eSignRequestXML}</textarea>
						<%-- <input type="text" id="cdacRequestXml" disabled="disabled"
		value="${eSignRequestXML}">
 --%>	<button type="button" onclick="return callFunction()">Save</button>
						</div>
			</form>
		</div>
	</div>
</body>
</html>

<script type="text/javascript">
	function fun() {
		var e = document.getElementById("corpDetails");
		var dropDownValues = e.options[e.selectedIndex].value;
		var sponserBankifsc = document.getElementById("sponserBankifsc");
		var utilityDesc = document.getElementById("utilityDesc");
		var sponserLabelNames = document.getElementById("sponserLabel");
		if (dropDownValues == 'NACH00000000001') {
			sponserBankifsc.value = "FDRL00000012";
			utilityDesc.value = "DHFL Home Loans";
			sponserLabelNames.value = "Federal Bank";
		}
		if (dropDownValues == 'NACH00000000002') {
			sponserBankifsc.value = "INDB00001212";
			utilityDesc.value = "AUTO LOANS";
			sponserLabelNames.value = "IndusIndBank";
		}
		if (dropDownValues == 'NACH00000000003') {
			sponserBankifsc.value = "SYND000000125";
			utilityDesc.value = "Airtel Limited";
			sponserLabelNames.value = "Syndicate Bank";
		}
		if (dropDownValues == "choose") {
			sponserBankifsc.value = "";
			utilityDesc.value = "";
			sponserLabelNames.value = "";
		}
	}

	function getData() {
		var labelName = document.getElementById("bankIfsc").value;
		var names = labelName.toUpperCase();
		var labelOne = document.getElementById("bankIfscId");
		if (names == 'FDRL0000001') {
			labelOne.value = "Federal Bank";
		}
		if (names == 'INDB0000001') {
			labelOne.value = "Indus Ind Bank";
		}
		if (names == 'VIJB0000001') {
			labelOne.value = "Vijaya Bank";
		}
	}
	
	
	function validateForm() {

		var utilityCode = document.forms["emandateFormName"]["utilityCode"].value;
		var customerName = document.forms["emandateFormName"]["customerName"].value;
		var aadhar = document.forms["emandateFormName"]["aadhar"].value;
		var email = document.forms["emandateFormName"]["email"].value;
		var mobile = document.forms["emandateFormName"]["mobile"].value;
		var bankIfsc = document.forms["emandateFormName"]["bankIfsc"].value;
		var confirmAccountNumber = document.forms["emandateFormName"]["confirmAccountNumber"].value;
		var accountType = document.forms["emandateFormName"]["accountType"].value;
		var collectionType = document.forms["emandateFormName"]["collectionType"].value;
		var amount = document.forms["emandateFormName"]["amount"].value;
		var frequency = document.forms["emandateFormName"]["frequency"].value;
		var endDate = document.forms["emandateFormName"]["endDate"].value;
		var maxamount = document.forms["emandateFormName"]["maxamount"].value;
		var accountnumber = document.forms["emandateFormName"]["accountnumber"].value;

		/* if (utilityCode == "choose") {
			alert("Utility Code must be filled out");
			return false;
		}
		if (customerName == "") {
			alert("Customer Name must be filled out");
			return false;
		}
		if (aadhar == "") {
			alert("Aadhar Number must be filled out");
			return false;
		}
		if (mobile == "") {
			alert("Mobile Number must be filled out");
			return false;
		}
		if (email == "") {
			alert("Email must be filled out");
			return false;
		}
		if (bankIfsc == "") {
			alert("Bank IFSC must be filled out");
			return false;
		}
		if (accountnumber == "") {
			alert("Account Number must be filled out");
			return false;
		}
		if (confirmAccountNumber == "") {
			alert("Confirm Account Number must be filled out");
			return false;
		}
		if (accountType == "choose") {
			alert("AccountType must be filled out");
			return false;
		}
		if (collectionType == "choose") {
			alert("Collection Type must be filled out");
			return false;
		}
		if (amount == "") {
			alert("Amount must be filled out");
			return false;
		}
		if (frequency == "choose") {
			alert("Frequency must be filled out");
			return false;
		}
		if (endDate == "") {
			alert("End Date must be filled out");
			return false;
		}
		if (maxamount == "") {
			alert("Maximum Amount must be filled out");
			return false;
		} */
	}
</script>


<script type="text/javascript">
	function callFunction() {
	var aspUrl="https://192.168.1.177:8443/FLUX/ONFAILURE";
		var cdacRequestXmldata = document.getElementById("cdacRequestXml").value;
		//alert(cdacRequestXmldata);
		$.ajax({
			url : "https://es-staging.cdac.in/esignlevelone/2.0/signdoc",
			type : "POST",
			//crossDomain : true,
			contentType : "application/xml",
			data : cdacRequestXmldata,
			xhrFields: {
      		 withCredentials: true
    		},
			success : function(result) {
				var status= result.status;
				var  responseXML;
			//	alert(status);
				
				if(status==0)
				{
				responseXML = result.responseXml;
				//alert(responseXML);
				
				console.log('responseXML:' + responseXML);
				window.location.href=aspUrl;
				//callASPFailure();
				}else{
				var url = result.responseUrl;
				//alert(url);
				window.location.href=url;
				}
				/* alert(result);
				console.log('url:' + url);
				$("#div1").html(result);
 */			}
		});

	}
	
	function callASPFailure(){
	$.ajax({
			url : "${pageContext.request.contextPath}/FLUX/getData",
			type : "POST",
		 	//data : $('form[name=formBean]').serialize(),
			success : function(result) {
				//alert(result);
				console.log('resp:' + result);
				$("#div1").html(result);
			}
		});
	}
</script>
