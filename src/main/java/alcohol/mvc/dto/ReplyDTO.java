package alcohol.mvc.dto;

public class ReplyDTO {
	private int reNumber;
	private int qaNumber;
	private String userId;
	private String reContent;
	private String reDate;
	private int reSecret;
	
	public ReplyDTO() {}

	public ReplyDTO(int reNumber, int qaNumber, String userId, String reContent, String reDate, int reSecret) {
		super();
		this.reNumber = reNumber;
		this.qaNumber = qaNumber;
		this.userId = userId;
		this.reContent = reContent;
		this.reDate = reDate.substring(0,10);
		this.reSecret = reSecret;
	}

	public int getReNumber() {
		return reNumber;
	}

	public void setReNumber(int reNumber) {
		this.reNumber = reNumber;
	}

	public int getQaNumber() {
		return qaNumber;
	}

	public void setQaNumber(int qaNumber) {
		this.qaNumber = qaNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public String getReDate() {
		return reDate;
	}
	
	public String DBgetReDate() {
		String date= DBgetReDate();
		String a=date.substring(0,10);
		
		return a;
	}
	

	public void setReDate(String reDate) {
		this.reDate = reDate;
	}

	public int getReSecret() {
		return reSecret;
	}

	public void setReSecret(int reSecret) {
		this.reSecret = reSecret;
	}
	
	
}
