package alcohol.mvc.dto;

public class SubDTO {
	private String subCode;
	private String userId;
	private String subStartDate;
	private String subPrice;
	
	public SubDTO() {}

	public SubDTO(String subCode, String userId, String subStartDate, String subPrice) {
		super();
		this.subCode = subCode;
		this.userId = userId;
		this.subStartDate = subStartDate.substring(0,10);
		this.subPrice = subPrice;
	}

	public SubDTO(String userId, String subPrice) {
		super();
		this.userId = userId;
		this.subPrice = subPrice;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSubStartDate() {
		return subStartDate;
	}
	
	public String DBgetSubStartDate() {
		String date= DBgetSubStartDate();
		String a=date.substring(0,10);
		
		return a;
	}
	

	public void setSubStartDate(String subStartDate) {
		this.subStartDate = subStartDate;
	}

	public String getSubPrice() {
		return subPrice;
	}

	public void setSubPrice(String subPrice) {
		this.subPrice = subPrice;
	}
	
}
