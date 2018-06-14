<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>E-mandate</title>

<%-- <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-combined.min.css"> --%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/dashboard.css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/family.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/fluxdemo.css">

<script>
	$(document).ready(function() {
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
			<form class="emandateForm" action="register" name="formBean" modelAttribute="formBean" method="post">
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
										<input id="utilityCode" type="text" readonly="readonly"
											class="form-control" name=utilityCode value="${utilityCode}" />
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
											class="form-control" name=sponserBankifsc
											value="${sponserBankifsc}" />
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
										class="form-control" id="utilityDesc" value="${utilityDesc}">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<input readonly="readonly" type="text" name=sponserBankName
										class="form-control" id="sponserLabel"
										value="${sponserBankName}">
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
										<label for="customerName" class="col-sm-4">Customer
											Name:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" readonly="readonly"
												name="customerName" value="${customerName}">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="col-sm-4">Aadhar Number:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" readonly="readonly"
												name="aadhar" value="${aadharNumber}" maxlength="12">
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
											<input type="email" readonly="readonly" class="form-control"
												name="email" value="${email}">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="col-sm-4">Mobile Number:</label>
										<div class="col-sm-8">
											<input type="text" readonly="readonly" class="form-control"
												name="mobile" value="${mobile}" maxlength="12">
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
												readonly="readonly" class="form-control" name="bankIfsc"
												value="${bankIfsc}" style="text-transform: uppercase;" />
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label for="accountnumber" class="col-sm-4">Account
											Number:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" name="accountnumber"
												readonly="readonly" maxlength="14" value="${accountnumber}" />
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
											class="form-control" name="branchName" value="${branchName}" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label for="confirmAccountNumber" class="col-sm-4">Confirm
											Account Number:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" readonly="readonly"
												name="confirmAccountNumber" value="${confirmAccountNumber}"
												maxlength="14" />
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label for="accountType" class="col-sm-4">Account Type:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" readonly="readonly"
											name="accountType" value="${accountType}" />
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
											<input type="text" readonly="readonly" class="form-control"
												value="${collectionType}">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label for="startDate" class="col-sm-4">Start Date:</label>
										<div class="col-sm-8">
											<input type="text" readonly="readonly" value="${startDate}" class="form-control"/>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label for="amount" class="col-sm-4">Collection
											Amount:</label>
										<div class="col-sm-8">
											<input type="text" readonly="readonly" value="${maxAmt}" 
												name="amount" class="form-control" maxlength="12" />
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
											<input type="text" readonly="readonly" value="${frequency}" class="form-control">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label for="endDate" class="col-sm-4">End Date:</label>
										<div class="col-sm-8">
											<input type="text" readonly="readonly" value="${endDate}" class="form-control"/>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label for="maxamount" class="col-sm-4">Max Amount:</label>
										<div class="col-sm-8">
											<input type="text" readonly="readonly"
												value="${collectAmount}" name="maxamount"
												class="form-control" maxlength="12" />
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row btnFormat text-center">
						
						<textarea id="cdacRequestXml" >${eSignRequestXML}</textarea>
						<%-- <input type="text" id="cdacRequestXml" disabled="disabled"
		value="${eSignRequestXML}"> --%>
	<button type="button" onclick="return callFunction()">Save</button>
						</div>
						
					
						
			</form>
		</div>
	</div>
	</body>

<script type="text/javascript">
	function callFunction() {
	var aspUrl="https://192.168.1.177:8443/FLUX/ONFAILURE";
		var cdacRequestXmldata = document.getElementById("cdacRequestXml").value;
		alert(cdacRequestXmldata);
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
				alert(status);
				
				if(status==0)
				{
				responseXML = result.responseXml;
				alert(responseXML);
				
				console.log('responseXML:' + responseXML);
				window.location.href=aspUrl;
				//callASPFailure();
				}else{
				var url = result.responseUrl;
				alert(url);
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
</html>
