<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Payment Information</title>
		<link href="css/style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<center>
		<%			
			String url = (String) request.getAttribute("url");
			String customerId = request.getParameter("customerId");
			String merchantId = request.getParameter("merchantId");
			String amount = request.getParameter("amount");
			String pgwtransId = request.getParameter("pgwtransId");
			String additionalInfo1 = request.getParameter("additionalInfo1");
			String additionalInfo2 = request.getParameter("additionalInfo2");
			String additionalInfo3 = request.getParameter("additionalInfo3");
			String additionalInfo4 = request.getParameter("additionalInfo4");
			String additionalInfo5 = request.getParameter("additionalInfo5");
			String additionalInfo6 = request.getParameter("additionalInfo6");
			String additionalInfo7 = request.getParameter("additionalInfo7");
			String additionalInfo8 = request.getParameter("additionalInfo8");
			String additionalInfo9 = request.getParameter("additionalInfo9");
			String additionalInfo10 = request.getParameter("additionalInfo10");
		%>
		<h1>Elitecore Payment Gateway Simulator</h1>		
		<form action="<%=url %>" name="frmPGSubmit" method="post">
			<div class="CSSTableGenerator" style="width: 350px; height: auto;">		
				<table>	
					<tr>
						<td>Parameter</td>
						<td>Value</td>
					</tr>		
					<tr>
						<td>Payment Transaction ID</td>
						<td><s:property value="pgwtransId" /></td>
					</tr>				
					<tr>
						<td>Customer ID</td>
						<td><s:property value="customerId" /></td>
					</tr>
					<tr>
						<td>Merchant ID</td>
						<td><s:property value="merchantId" /></td>
					</tr>
					<tr>
						<td>Amount</td>
						<td><s:property value="amount" /></td>
					</tr>
					<tr>
						<td>Additional Info 1</td>
						<td><s:property value="additionalInfo1" /></td>
					</tr>
					<tr>
						<td>Additional Info 2</td>
						<td><s:property value="additionalInfo2" /></td>
					</tr>
					<tr>
						<td>Additional Info 3</td>
						<td><s:property value="additionalInfo3" /></td>
					</tr>
					<tr>
						<td>Additional Info 4</td>
						<td><s:property value="additionalInfo4" /></td>
					</tr>
					<tr>
						<td>Additional Info 5</td>
						<td><s:property value="additionalInfo5" /></td>
					</tr>
					<tr>
						<td>Additional Info 6</td>
						<td><s:property value="additionalInfo6" /></td>
					</tr>
					<tr>
						<td>Additional Info 7</td>
						<td><s:property value="additionalInfo7" /></td>
					</tr>
					<tr>
						<td>Additional Info 8</td>
						<td><s:property value="additionalInfo8" /></td>
					</tr>
					<tr>
						<td>Additional Info 9</td>
						<td><s:property value="additionalInfo9" /></td>
					</tr>
					<tr>
						<td>Additional Info 10</td>
						<td><s:property value="additionalInfo10" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<center>
								<s:submit></s:submit>
							</center>
						</td>
					</tr>
				</table>
			</div>
		</form>
		</center>
	</body>
</html>