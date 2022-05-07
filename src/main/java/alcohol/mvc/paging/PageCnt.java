package alcohol.mvc.paging;


public class PageCnt {
	public static int pageCnt; // 전체 페이지 수  
	public static  int pagesize = 5;// 한 페이지당 출력될 게시물 수 
	public static int pageNo=1; // 현재 페이지 번호 
	
	public static int blockcount=2; // 한 블록당 보여질 페이지 번호 개수  
	
	//String keyField;
	
	public PageCnt() {
		super();
	}

	public PageCnt(int pageCnt) {
		super();
		this.pageCnt = pageCnt;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public static int getPagesize() {
		return pagesize;
	}

	public static void setPagesize(int pagesize) {
		PageCnt.pagesize = pagesize;
	}

	public static int getPageNo() {
		return pageNo;
	}

	public static void setPageNo(int pageNo) {
		PageCnt.pageNo = pageNo;
	}

	public int getBlockcount() {
		return blockcount;
	}

	public void setBlockcount(int blockcount) {
		this.blockcount = blockcount;
	}

	
}
