package alcohol.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alcohol.mvc.dto.QADTO;
import alcohol.mvc.paging.PageCnt;
import alcohol.mvc.service.QAService;
import alcohol.mvc.service.QAServiceImpl;
import net.sf.json.JSONArray;

public class QAController implements Controller {

	private QAService qaService = new QAServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return null;
	}

	/**
	 * 전체검색하기
	 */
	public void select(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		String paging = request.getParameter("paging"); // 현재 페이지 번호
		if (paging == null || paging.equals("")) {
			paging = "1";
		}

		List<QADTO> qaList = qaService.qaAll(Integer.parseInt(paging));
		Map<String, Object> map = new HashMap<String, Object>();

		System.out.println(qaList.size()+"페이징처리 값 나옴?");

	
		map.put("qaList", qaList);
		map.put("pageNo", paging);
		
		JSONArray arr = JSONArray.fromObject(map);
		System.out.println("나옴?" + qaList.size());
		PrintWriter out = response.getWriter();
		out.print(arr);

	}

	/**
	 * 글 상세보기
	 */
	public ModelAndView selectByQANum(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int qaNumber = Integer.parseInt(request.getParameter("qaNumber"));
		QADTO qa = qaService.qaSelect(qaNumber);
		request.setAttribute("qa", qa);

		System.out.println("상세보기 나오냐아아아아아아ㅏ아ㅓㄱ악" + qaNumber );
		
		return new ModelAndView("board/qaRead.jsp");
	}

	/**
	 * 등록하기
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 전송된 데이터 받기
		HttpSession session = request.getSession();
		

		String userId = request.getParameter("userId");
		String qaTitle = request.getParameter("qaTitle");
		String qaContent = request.getParameter("qaContent");
		int qaCategory = Integer.parseInt(request.getParameter("qa_category"));
		System.out.println(qaCategory);
		System.out.println("QA등록하기 잘 나오니잉");
		
		QADTO qa = new QADTO(userId, qaCategory, qaTitle, qaContent);
		
		qaService.qaInsert(qa);
		
		
		//ModelAndView mv = this.select(request, response);
		
		return new ModelAndView("board/qa.jsp",true);
		
//		int qaNumber = Integer.parseInt(request.getParameter("qaNumber"));
//		String userId = request.getParameter("userId");
//		int qaCategory = Integer.parseInt(request.getParameter("qaCategory"));
//		String qaTitle = request.getParameter("qaTitle");
//		String qaContent = request.getParameter("qaContent");
//		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//		String qaDate = df.format(new Date());
//		int qaSecret = Integer.parseInt(request.getParameter("qaSecret"));
//
//		System.out.println("QA등록하기 잘 나오니잉");
//		
//		QADTO qa = new QADTO(qaNumber, userId, qaCategory, qaTitle, qaContent, qaDate, qaSecret);
//		
//		qaService.qaInsert(qa);
//		
//		ModelAndView mv = this.select(request, response);
//
//		return mv;
	}

	/**
	 * 수정하기
	 */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int qaNumber = Integer.parseInt(request.getParameter("qaNumber"));
		String qaContent = request.getParameter("qaContent");
		
		QADTO qaDTO = new QADTO(qaNumber, qaContent);
		
		qaService.qaUpdate(qaDTO);
		
		// 페이지 이동 
		QADTO qa = qaService.qaSelect(qaNumber);
		request.setAttribute("qa", qa);
		
		System.out.println("qa수정수정수정" + qaContent);
		
		ModelAndView mv = new ModelAndView("board/qaRead.jsp");
		
		return mv;
	}

	/**
	 * 삭제하기
	 */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int qaNumber = Integer.parseInt(request.getParameter("qaNumber"));
		
		qaService.qaDelete(qaNumber);
		
		System.out.println("qa삭제잘되나");
		
		//ModelAndView mv = this.select(request,response);
		
		return new ModelAndView("board/qa.jsp",true);
	}
	
	public void selectFilter(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		response.setContentType("text/html;charset=UTF-8");
		String pageNo =request.getParameter("pageNo"); // 현재 페이지 번호
		if (pageNo == null || pageNo.equals("")) {
			pageNo = "1";
		}
		int categoryNum = Integer.parseInt(request.getParameter("cate"));
		System.out.println("categoryNum"+categoryNum);
		List<QADTO> qaList = qaService.qaFilter(categoryNum,Integer.parseInt(pageNo));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qaList", qaList);
		map.put("pageNo", pageNo);
		map.put("blockcount", PageCnt.blockcount);
		map.put("pageCnt", PageCnt.pageCnt);
		map.put("categoryNum", categoryNum);
		
		JSONArray arr = JSONArray.fromObject(map);
		System.out.println("사이즈 "+qaList.size());
	
		PrintWriter out = response.getWriter();
		out.print(arr);
		
	}
	
	
	

}
