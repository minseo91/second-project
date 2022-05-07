package alcohol.mvc.dto;

public class ReviewDTO {
	private int viewNumber;
	private String userId;
	private String pCode;
	private String viewContent;
	private int viewScore;
	private String viewImage;
	
	public ReviewDTO() {}

	public ReviewDTO(int viewNumber, String userId, String pCode, String viewContent, int viewScore, String viewImage) {
		super();
		this.viewNumber = viewNumber;
		this.userId = userId;
		this.pCode = pCode;
		this.viewContent = viewContent;
		this.viewScore = viewScore;
		this.viewImage = viewImage;
	}

	public int getViewNumber() {
		return viewNumber;
	}

	public void setViewNumber(int viewNumber) {
		this.viewNumber = viewNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getViewContent() {
		return viewContent;
	}

	public void setViewContent(String viewContent) {
		this.viewContent = viewContent;
	}

	public int getViewScore() {
		return viewScore;
	}

	public void setViewScore(int viewScore) {
		this.viewScore = viewScore;
	}

	public String getViewImage() {
		return viewImage;
	}

	public void setViewImage(String viewImage) {
		this.viewImage = viewImage;
	}
	
	
}
