package alcohol.mvc.dto;

public class QADTO {
	private int qaNumber;
	private String userId;
	private int qaCategory;
	private String qaTitle;
	private String qaContent;
	private String qaDate;
	private int qaSecret;

	public QADTO() {
	}

	public QADTO(String userId, String qaTitle, String qaContent) {
		this.userId = userId;
		this.qaTitle = qaTitle;
		this.qaContent = qaContent;

	}
	public QADTO(int qaNumber, String qaContent) {
		this.qaNumber = qaNumber;
		this.qaContent = qaContent;

	}
	
	public QADTO(String userId, int qaCategory, String qaTitle, String qaContent) {
		this(userId, qaTitle, qaContent);
		this.qaCategory = qaCategory;
	}

	public QADTO(int qaNumber, String userId, String qaTitle, String qaContent ,String qaDate) {
		super();
		this.qaNumber = qaNumber;
		this.userId = userId;
		this.qaContent = qaContent;
		this.qaTitle = qaTitle;
		this.qaDate = qaDate;
	}

	public QADTO(int qaNumber, String userId, int qaCategory, String qaTitle, String qaContent, String qaDate,
			int qaSecret) {
		this(userId, qaTitle, qaContent);
		
		this.qaNumber = qaNumber;
		this.qaCategory = qaCategory;
		this.qaDate = qaDate.substring(0,10);
		this.qaSecret = qaSecret;
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

	public int getQaCategory() {
		return qaCategory;
	}

	public void setQaCategory(int qaCategory) {
		this.qaCategory = qaCategory;
	}

	public String getQaTitle() {
		return qaTitle;
	}

	public void setQaTitle(String qaTitle) {
		this.qaTitle = qaTitle;
	}

	public String getQaContent() {
		return qaContent;
	}

	public void setQaContent(String qaContent) {
		this.qaContent = qaContent;
	}

	public String getQaDate() {
		return qaDate;
	}
	
	public String DBgetpDate() {
		String date= DBgetpDate();
		String a=date.substring(0,10);
		
		return a;
	}

	public void setQaDate(String qaDate) {
		this.qaDate = qaDate;
	}

	public int getQaSecret() {
		return qaSecret;
	}

	public void setQaSecret(int qaSecret) {
		this.qaSecret = qaSecret;
	}

}
