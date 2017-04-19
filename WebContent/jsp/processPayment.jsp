<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.Enumeration" %>
<html>
	<head>
		<title>Elitecore Payment Gateway</title>
		<script src="${pageContext.request.contextPath}/js/TimeCounter.js" ></script>		
	</head>
	<body>
	<%
		Enumeration<String> enumeration = request.getHeaderNames();
		while (enumeration.hasMoreElements()) {
			String paramName = (String) enumeration.nextElement();
			System.out.println("Header Param=" + paramName + ", Value=" + request.getHeader(paramName));
		}
	%>
		<center>
			<br>
			<h1>Elitecore Payment Gateway Simulator</h1>
			<br>
			<br><img src="${pageContext.request.contextPath}/images/loading.gif">
			<div id='timer'>Please wait while redirecting to bank page in ... </div>
		</center>		
		<%
			String strCustomerId = request.getParameter("customerId");
			String strMerchantId = request.getParameter("merchantId");
			String strAmount = request.getParameter("amount");
			String strRU = request.getParameter("ru");		
		%>	
		<s:form action="processPayment" theme="xhtml" id="frmProcessPayment" >
			<s:hidden id="customerId" name="customerId" value="" />
			<s:hidden id="merchantId" name="merchantId" value="" />
			<s:hidden id="amount" name="amount" value="" />
			<s:hidden id="ru" name="ru" value="" />
		</s:form>
		<script>
			document.getElementById("customerId").value='<%=strCustomerId%>';
			document.getElementById("merchantId").value='<%=strMerchantId%>';
			document.getElementById("amount").value='<%=strAmount%>';
			document.getElementById("ru").value='<%=strRU%>';
			
			function submitForm(){
				document.getElementById("frmProcessPayment").submit();
			}
			window.onload = CreateTimer("timer", "10", submitForm);
		</script>
	</body>
</html>