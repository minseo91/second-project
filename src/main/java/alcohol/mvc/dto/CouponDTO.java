package alcohol.mvc.dto;

public class CouponDTO {
	private String cNumber;
	private String cName;
	private String userId;
	private int cRate;
	private String cStartDate;
	private String cEndDate;
	private String count;
	
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public CouponDTO() {}

	public CouponDTO(String cNumber, String cName, String userId, int cRate, String cStartDate, String cEndDate) {
		super();
		this.cNumber = cNumber;
		this.cName = cName;
		this.userId = userId;
		this.cRate = cRate;
		this.cStartDate = cStartDate;
		this.cEndDate = cEndDate;
	}

	public CouponDTO(String userId, int cRate, String count) {
		super();
		this.userId = userId;
		this.cRate = cRate;
		this.count = count;
	}

	public String getcNumber() {
		return cNumber;
	}

	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getcRate() {
		return cRate;
	}

	public void setcRate(int cRate) {
		this.cRate = cRate;
	}

	public String getcStartDate() {
		return cStartDate;
	}

	public void setcStartDate(String cStartDate) {
		this.cStartDate = cStartDate;
	}

	public String getcEndDate() {
		return cEndDate;
	}

	public void setcEndDate(String cEndDate) {
		this.cEndDate = cEndDate;
	}
	
	
}
