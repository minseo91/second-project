package alcohol.mvc.dto;

public class PaymentDTO {
	private int payCode;
	private int payType;
	private String payAccount;
	
	public PaymentDTO() {}
	
	public PaymentDTO(int payCode, int payType, String payAccount) {
		super();
		this.payCode = payCode;
		this.payType = payType;
		this.payAccount = payAccount;
	}
	
	public int getPayCode() {
		return payCode;
	}

	public void setPayCode(int payCode) {
		this.payCode = payCode;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public String getPayAccount() {
		return payAccount;
	}

	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}
	
	
}
