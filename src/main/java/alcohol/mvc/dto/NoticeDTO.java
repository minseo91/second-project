package alcohol.mvc.dto;

public class NoticeDTO {
	private int noNumber;
	private String userId;
	private String noTitle;
	private String noContent;
	private String noDate;
	private int viewCount;
	
	public NoticeDTO() {}
	

	public NoticeDTO(int noNumber, String noTitle, String noContent, String noDate) {
		super();
		this.noNumber = noNumber;
		this.noTitle = noTitle;
		this.noContent = noContent;
		this.noDate = noDate;
	}


	public NoticeDTO(String userId, String noTitle, String noContent) {
		super();
		this.userId = userId;
		this.noTitle = noTitle;
		this.noContent = noContent;
	}

	public NoticeDTO(int noNumber, String userId, String noTitle, String noContent, String noDate, int viewCount) {
		super();
		this.noNumber = noNumber;
		this.userId = userId;
		this.noTitle = noTitle;
		this.noContent = noContent;
		this.noDate = noDate;
		this.viewCount = viewCount;
	}

	public int getNoNumber() {
		return noNumber;
	}

	public void setNoNumber(int noNumber) {
		this.noNumber = noNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNoTitle() {
		return noTitle;
	}

	public void setNoTitle(String noTitle) {
		this.noTitle = noTitle;
	}

	public String getNoContent() {
		return noContent;
	}

	public void setNoContent(String noContent) {
		this.noContent = noContent;
	}

	public String getNoDate() {
		return noDate;
	}

	public void setNoDate(String noDate) {
		this.noDate = noDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	
	
}
