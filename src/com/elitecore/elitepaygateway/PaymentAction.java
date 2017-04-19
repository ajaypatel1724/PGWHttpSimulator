package com.elitecore.elitepaygateway;

import java.sql.Time;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.elitecore.base.BaseActionSupport;
import com.opensymphony.xwork2.ActionContext;

public class PaymentAction extends BaseActionSupport {
	private static final long serialVersionUID = 1L;
	private static final String MODULE = "[PAY_ACTION]";
	private String customerId;
	private String merchantId;
	private String amount;
	private String ru;
	private String additionalInfo1;
	private String additionalInfo2;
	private String additionalInfo3;
	private String additionalInfo4;
	private String additionalInfo5;
	private String additionalInfo6;
	private String additionalInfo7;
	private String additionalInfo8;
	private String additionalInfo9;
	private String additionalInfo10;
	private String url;
	private String responseCode;
	private String responseMessage;
	private String pgwtransId;

	public String processPayment() {
		System.out.println(MODULE + "Processing Payment .... ");
		try {
			System.out.println(MODULE + "Request Details");
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");

			System.out.println(MODULE + "Header Information...");
			Enumeration<String> enumeration = request.getHeaderNames();
			while (enumeration.hasMoreElements()) {
				String paramName = (String) enumeration.nextElement();
				System.out.println(MODULE + "Header Param=" + paramName + ", Value=" + request.getHeader(paramName));
			}
			
			System.out.println(MODULE + "Request Parameter Information...");
			enumeration = request.getParameterNames();
			while (enumeration.hasMoreElements()) {
				String paramName = (String) enumeration.nextElement();
				System.out.println(MODULE + "Parameter=" + paramName + ", Value=" + request.getParameter(paramName));
			}
			
			boolean isProcessAllowed = validateRequiredParameter();
			System.out.println(MODULE + "Validation  : " + isProcessAllowed);
			setUrl(getReturnURL());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	private boolean validateRequiredParameter() {
		if ((getCustomerId() == null) || (getCustomerId().trim().length() == 0)) {
			setResponseCode("400");
			setResponseMessage("Invalid Parameter. Reason: Customer Id Not found in request");
			return false;
		}
		if ((getMerchantId() == null) || (getMerchantId().trim().length() == 0) || (!getMerchantId().equals("WEBIN"))) {
			setResponseCode("400");
			setResponseMessage("Invalid Parameter. Reason: Merchant Id Not found in request");
			return false;
		}
		if ((getRu() == null) || (getRu().trim().length() == 0)) {
			setResponseCode("400");
			setResponseMessage("Invalid Parameter. Reason: Return URL Not Found");
			return false;
		}
		if ((getAmount() == null) || (getAmount().trim().length() == 0)) {
			boolean isAmountValid = true;
			try {
				long lAmount = Long.parseLong(getAmount());
			} catch (NumberFormatException nfe) {
				setResponseCode("400");
				setResponseMessage("Invalid Parameter. Reason: Amount should be in number");
				isAmountValid = false;
			}
			return isAmountValid;
		}
		setResponseCode("200");
		setResponseMessage("Success");
		return true;
	}

	private String getReturnURL() {
		this.url = getRu();
		StringBuilder builder = new StringBuilder(this.url);
		if (this.url.contains("?")) {
			builder.append("&");
		} else {
			builder.append("?");
		}
		
		setPgwtransId(Long.toString(new Date().getTime()));
		
		builder.append("responseCode=").append(getResponseCode())
		.append("&responseMessage=").append(getResponseMessage())
		.append("&customerId=").append(getCustomerId())
		.append("&merchantId=").append(getMerchantId())
		.append("&pgwtransId=").append(getPgwtransId())
		.append("&amount=").append(getAmount());
		
		if (getAdditionalInfo1() != null) {
			builder.append("&additionalInfo1=").append(getAdditionalInfo1());
		}
		if (getAdditionalInfo2() != null) {
			builder.append("&additionalInfo2=").append(getAdditionalInfo2());
		}
		if (getAdditionalInfo3() != null) {
			builder.append("&additionalInfo3=").append(getAdditionalInfo3());
		}
		if (getAdditionalInfo4() != null) {
			builder.append("&additionalInfo4=").append(getAdditionalInfo4());
		}
		if (getAdditionalInfo5() != null) {
			builder.append("&additionalInfo5=").append(getAdditionalInfo5());
		}
		if (getAdditionalInfo6() != null) {
			builder.append("&additionalInfo6=").append(getAdditionalInfo6());
		}
		if (getAdditionalInfo7() != null) {
			builder.append("&additionalInfo7=").append(getAdditionalInfo7());
		}
		if (getAdditionalInfo8() != null) {
			builder.append("&additionalInfo8=").append(getAdditionalInfo8());
		}
		if (getAdditionalInfo9() != null) {
			builder.append("&additionalInfo9=").append(getAdditionalInfo9());
		}
		if (getAdditionalInfo10() != null) {
			builder.append("&additionalInfo10=").append(getAdditionalInfo10());
		}
		return builder.toString();
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getRu() {
		return this.ru;
	}

	public void setRu(String ru) {
		this.ru = ru;
	}

	public String getAdditionalInfo1() {
		return this.additionalInfo1;
	}

	public void setAdditionalInfo1(String additionalInfo1) {
		this.additionalInfo1 = additionalInfo1;
	}

	public String getAdditionalInfo2() {
		return this.additionalInfo2;
	}

	public void setAdditionalInfo2(String additionalInfo2) {
		this.additionalInfo2 = additionalInfo2;
	}

	public String getAdditionalInfo3() {
		return this.additionalInfo3;
	}

	public void setAdditionalInfo3(String additionalInfo3) {
		this.additionalInfo3 = additionalInfo3;
	}

	public String getAdditionalInfo4() {
		return this.additionalInfo4;
	}

	public void setAdditionalInfo4(String additionalInfo4) {
		this.additionalInfo4 = additionalInfo4;
	}

	public String getAdditionalInfo5() {
		return this.additionalInfo5;
	}

	public void setAdditionalInfo5(String additionalInfo5) {
		this.additionalInfo5 = additionalInfo5;
	}

	public String getAdditionalInfo6() {
		return this.additionalInfo6;
	}

	public void setAdditionalInfo6(String additionalInfo6) {
		this.additionalInfo6 = additionalInfo6;
	}

	public String getAdditionalInfo7() {
		return this.additionalInfo7;
	}

	public void setAdditionalInfo7(String additionalInfo7) {
		this.additionalInfo7 = additionalInfo7;
	}

	public String getAdditionalInfo8() {
		return this.additionalInfo8;
	}

	public void setAdditionalInfo8(String additionalInfo8) {
		this.additionalInfo8 = additionalInfo8;
	}

	public String getAdditionalInfo9() {
		return this.additionalInfo9;
	}

	public void setAdditionalInfo9(String additionalInfo9) {
		this.additionalInfo9 = additionalInfo9;
	}

	public String getAdditionalInfo10() {
		return this.additionalInfo10;
	}

	public void setAdditionalInfo10(String additionalInfo10) {
		this.additionalInfo10 = additionalInfo10;
	}

	public static long getSerialversionuid() {
		return 1L;
	}

	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public String getResponseCode() {
		return this.responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return this.responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getPgwtransId() {
		return pgwtransId;
	}

	public void setPgwtransId(String pgwtransId) {
		this.pgwtransId = pgwtransId;
	}
	
}
