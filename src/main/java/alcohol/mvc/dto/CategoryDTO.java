package alcohol.mvc.dto;

public class CategoryDTO {
	private String cateCode;
	private String cateName;
	public CategoryDTO() {}
	public CategoryDTO(String cateCode, String cateName) {
		super();
		this.cateCode = cateCode;
		this.cateName = cateName;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
	
}
