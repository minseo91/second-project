package alcohol.mvc.dto;

public class OrderLineDTO {
	private int orderLineCode;
	private int orderCode;
	private String pCode;
	private int orderLineCount;

	public OrderLineDTO() {
	}
	
	

	public OrderLineDTO(String pCode, int orderLineCount) {
		super();
		this.pCode = pCode;
		this.orderLineCount = orderLineCount;
	}



	public OrderLineDTO(int orderLineCode, int orderCode, String pCode, int orderLineCount) {
		super();
		this.orderLineCode = orderLineCode;
		this.orderCode = orderCode;
		this.pCode = pCode;
		this.orderLineCount = orderLineCount;
	}

	public int getOrderLineCode() {
		return orderLineCode;
	}

	public void setOrderLineCode(int orderLineCode) {
		this.orderLineCode = orderLineCode;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public int getOrderLineCount() {
		return orderLineCount;
	}

	public void setOrderLineCount(int orderLineCount) {
		this.orderLineCount = orderLineCount;
	}
	
	
	
}
