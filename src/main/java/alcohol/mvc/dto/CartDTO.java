package alcohol.mvc.dto;

public class CartDTO {
	private int cartNumber;
	private String uId;
	private String pCode;
	private int cartCount;
	
	public CartDTO() {}

	public CartDTO(int cartNumber, String uId, String pCode, int cartCount) {
		super();
		this.cartNumber = cartNumber;
		this.uId = uId;
		this.pCode = pCode;
		this.cartCount = cartCount;
	}

	public int getCartNumber() {
		return cartNumber;
	}

	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public int getCartCount() {
		return cartCount;
	}

	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}

	
	
	
}
