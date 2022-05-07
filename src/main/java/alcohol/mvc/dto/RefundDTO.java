package alcohol.mvc.dto;

public class RefundDTO {
	private int reCode;
	private int orderCode;
	private String reReason;
	private String reStatus;
	
	public RefundDTO() {}

	public RefundDTO(int reCode, int orderCode, String reReason, String reStatus) {
		super();
		this.reCode = reCode;
		this.orderCode = orderCode;
		this.reReason = reReason;
		this.reStatus = reStatus;
	}

	public int getReCode() {
		return reCode;
	}

	public void setReCode(int reCode) {
		this.reCode = reCode;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public String getReReason() {
		return reReason;
	}

	public void setReReason(String reReason) {
		this.reReason = reReason;
	}

	public String getReStatus() {
		return reStatus;
	}

	public void setReStatus(String reStatus) {
		this.reStatus = reStatus;
	}
	
	
}
