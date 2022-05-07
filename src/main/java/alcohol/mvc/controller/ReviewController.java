package alcohol.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alcohol.mvc.dto.ProductDTO;
import alcohol.mvc.dto.ReviewDTO;
import alcohol.mvc.service.ReviewService;
import alcohol.mvc.service.ReviewServiceImpl;

public class ReviewController implements Controller {
	private ReviewService service = new ReviewServiceImpl();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ModelAndView reviewSelect(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pageNo = request.getParameter("pageNo");
		if(pageNo==null ||pageNo.equals("")) {
			pageNo="1";
		}
		
		String name = request.getParameter("pName");
		System.out.println(name);
		
		
		
		List<ReviewDTO> reviewList=service.reviewSelect(name, Integer.parseInt(pageNo));
		int star=0;
		if(reviewList != null && reviewList.size()!=0) {
		  star = service.avgReview(reviewList.get(0).getpCode());
		}else {
			star=0;
		}
		System.out.println(star);
		request.setAttribute("reviewList", reviewList); 
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("star", star);

		
		return new ModelAndView("store/productDetail.jsp");


		//JSONArray arr = JSONArray.fromObject(dto);
		// System.out.println(dto.getpName()+"나와라");
		//PrintWriter out = response.getWriter();
		//out.print(arr);

	}
}
