package alcohol.mvc.dto;

public class UserDTO {
	private String userId;
	private String userPwd;
	private String userName;
	private String userJumin;
	private String userPhone;
	private String userEmail;
	private String userAddr;
	private String userAddr2;
	private String userAddr3;
	private int userGrade;
	private int userPoint;
	private String joinDate;
	private String price;
	public UserDTO() {
	}

	public UserDTO(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public UserDTO(String userId, String userPwd, String userName, String userJumin, String userPhone, String userEmail,
			String userAddr, String userAddr2, String userAddr3, int userGrade, int userPoint, String joinDate) {
		this(userId, userPwd);
		this.userName = userName;
		this.userJumin = userJumin;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userAddr = userAddr;
		this.userAddr2 = userAddr2;
		this.userAddr3 = userAddr3;
		this.userGrade = userGrade;
		this.userPoint = userPoint;
		this.joinDate = joinDate;
	}

	public UserDTO(String joinDate,String userId, String userName, String userPhone, String price) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.joinDate = joinDate;
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserJumin() {
		return userJumin;
	}

	public void setUserJumin(String userJumin) {
		this.userJumin = userJumin;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserAddr2() {
		return userAddr2;
	}

	public void setUserAddr2(String userAddr2) {
		this.userAddr2 = userAddr2;
	}

	public String getUserAddr3() {
		return userAddr3;
	}

	public void setUserAddr3(String userAddr3) {
		this.userAddr3 = userAddr3;
	}

	public int getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

}
