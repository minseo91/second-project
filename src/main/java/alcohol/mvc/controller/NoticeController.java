package alcohol.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import alcohol.mvc.dto.NoticeDTO;
import alcohol.mvc.dto.QADTO;
import alcohol.mvc.service.NoticeService;
import alcohol.mvc.service.NoticeServiceImpl;
import net.sf.json.JSONArray;






public class NoticeController implements Controller {
	
	private NoticeService noService = new NoticeServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			return null;
	}
	
	/**
	 * 전체검색하기
	 * */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String field = request.getParameter("field");
		

		///paging처리하기 //////////////////////////////////////
		String pageNo = request.getParameter("pageNo");//현재페이지번호 
		if(pageNo==null || pageNo.equals("")) {
			pageNo="1";
		}
		
		//List<NoticeDTO> noticeList = noService.noticeAll();
		List<NoticeDTO> noticeList = noService.noticeAll(Integer.parseInt(pageNo));
		
		request.setAttribute("noticeList", noticeList);
		
		 request.setAttribute("pageNo", pageNo); //뷰에서 사용하기 위해서 ${pageNo}
		
		for (NoticeDTO n : noticeList) {
			System.out.println(n.getNoContent());
		}
		System.out.println(noticeList.size());
		return new ModelAndView("board/notice.jsp");
	}
	
//	/**
//	 * 로그인한게 관리자라면..
//	 * */
//	public ModelAndView getNoticesView(HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		
//		int userGrade = Integer.parseInt(request.getParameter("userGrade"));
//		boolean isAdmin = false;
//		if (userGrade==1)  {
//			isAdmin = true;
//		}
//		List<NoticeDTO> noticeList = noService.noticeAll();
//		request.setAttribute("noticeList", noticeList);
//		request.setAttribute("isAdmin", isAdmin);
//		return new ModelAndView("board/notice.jsp");
//	}
	
	/**
	 * 등록하기
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//폼에서 enctype="multipart/form-data" 설정되어 있기 때문에
				//request로는 안되고 MultipartRequest객체를 이용한다.
				//String saveDir= request.getServletContext().getRealPath("/save"); //서버를 한번 내리면 save폴더도 사라진다.
				String saveDir = "C:\\Edu\\log";
				int maxSize =1024*1024*100;//100M
			    String encoding="UTF-8";
				
				MultipartRequest m = 
					new MultipartRequest(request, saveDir,maxSize,encoding , new DefaultFileRenamePolicy());

				//전송된 데이터 받기
				String userId = m.getParameter("u_id");
				String noTitle = m.getParameter("no_title");
				String noContent = m.getParameter("no_content");
				
				
				NoticeDTO notice = new NoticeDTO(userId, noTitle, noContent);
				
//				//파일첨부가 되었다면..
//				if(m.getFilesystemName("file") != null) {
//					//파일이름 저장
//					notice.setFname(m.getFilesystemName("file"));
//					
//					//파일크기 저장
//					notice.setFsize((int)m.getFile("file").length());
//					
//				}
				
				noService.noticeInsert(notice);
				
				ModelAndView mv = this.select(request,response);
				

				return mv;
	}
	
	/**
	 * 글 상세보기
	 * */
	public ModelAndView selectByNoticeNum(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int noNumber = Integer.parseInt(request.getParameter("noNumber"));
		NoticeDTO notice =  noService.noticeSelect(noNumber, true); //true는 조회수 증가시킨다!!
		request.setAttribute("notice", notice);
		
		return new ModelAndView("board/noticeRead.jsp");
	}
	
	/**
	 * 수정폼
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int noNumber = Integer.parseInt(request.getParameter("noNumber"));
		NoticeDTO notice = noService.noticeSelect(noNumber, false); //false는 조회수 증가시키지 않는다.
		request.setAttribute("notice", notice);
		
		return new ModelAndView("board/noticeUpdate.jsp");
	}
	
	/**
	 * 수정하기
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int noNumber = Integer.parseInt(request.getParameter("noNumber"));
		String noTitle = request.getParameter("noTitle");
		String noContent = request.getParameter("noContent");
		String 	noDate	= request.getParameter("noDate");
		System.out.println(noTitle);
		System.out.println(noContent);
		NoticeDTO notice = new NoticeDTO(noNumber, noTitle, noContent,noDate);
		
		noService.noticeUpdate(notice);
		
		//상세보기페이지로 이동
		NoticeDTO noticeDetail = noService.noticeSelect(noNumber, false);
		request.setAttribute("notice", noticeDetail);
		System.out.println(noticeDetail);
		return new ModelAndView("board/noticeRead.jsp");
	}
	
	/**
	 * 삭제하기
	 * */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int noNumber = Integer.parseInt(request.getParameter("noNumber"));
		
		//String path = request.getServletContext().getRealPath("/save");
		//String path = "C:\\Edu\\log";
		
		noService.noticeDelete(noNumber);
		
		ModelAndView mv = this.select(request,response);
		

		return mv;
	}

}
