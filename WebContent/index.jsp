<!DOCTYPE html>
<html>
<head>	
</head>
 <body style="font-family:Georgia,Serif;font-size: 15px;"> 
 	<center><h3 style="color:#005197">Welcome to "WebIn" Payment Gateway Simulator</h3></center>
 	<p> 
 	1) Why we generate simulator
 		<ul>
	 		<li>Now <b>no need to wait </b> untill payment gateway connectivity available for WebIn/WIP development.</li>
	 		<li>No Credit/Debit Card is required to payment <img src="${pageContext.request.contextPath}/images/smilly.jpg" align="top" height="15px" width="15px" /></li>
	 		<li>Developer can test their Payment Gateway functionality using this simulator.</li>
	 		<li>We have develop this simulator to make sure the functionality is correctly working after payment response (Success/Fail).</li>
	 	</ul>
	2) How to use it
			For use of "WebIn Payment Gateway" you are required to pass below parameters,</li>
 			<ul>
	 			<li>customerId</li>
	 			<li>merchantId (must be "<b>WEBIN</b>")</li>
	 			<li>amount</li>
	 			<li>ru</li>
 			</ul> 			
 		<p style="color:#005197;font-style:oblique;font-weight:bold;">WebIn Configuration Screen</p>
 		<b>URL :</b> http://10.106.1.37:8282/WebInPGSim/processPay.do?customerId={Sub.UserName}&merchantId=WEBIN&amount={PaymentAmount}&ru=http://10.106.1.121:39090/webin/PaymentResponse.do?ECSimTID={TransactionID}
 		<br><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/images/webin_config.jpg" />
 		<br>
 			
 	</p>
 </body>
</html>