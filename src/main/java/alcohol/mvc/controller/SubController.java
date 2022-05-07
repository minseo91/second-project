package alcohol.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import alcohol.mvc.dto.SubDTO;
import alcohol.mvc.service.SubService;
import alcohol.mvc.service.SubServiceImpl;

public class SubController implements Controller{

	private SubService subService = new SubServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 구독 등록하기
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String sid= request.getParameter("id");
		String sPrice = request.getParameter("totalPrice");
		
		//sPrice.substring(0,sPrice.length()-1);
		int ssPrice=Integer.parseInt(sPrice.substring(0,sPrice.length()-1));
		
		System.out.println(sid);
		System.out.println(ssPrice);
		
		SubDTO subDTO = new SubDTO(sid,ssPrice+"");
	
		
		subService.subInsert(subDTO);
		
		return new ModelAndView("index.jsp");
	}
	
	/**
	 * 구독 취소하기(삭제)
	 * */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String sCode = request.getParameter("sCode");
		
		//String path = request.getServletContext().getRealPath("/save");
		//String path = "C:\\Edu\\log";
		
		subService.subDelete(sCode);
		
		return new ModelAndView("front" , true);
	}

}
