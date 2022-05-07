package alcohol.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.InternalFrameFocusTraversalPolicy;

import com.oreilly.servlet.MultipartRequest;

import alcohol.mvc.dto.CouponDTO;
import alcohol.mvc.dto.OrderLineDTO;
import alcohol.mvc.dto.OrdersDTO;
import alcohol.mvc.dto.PaymentDTO;
import alcohol.mvc.dto.ProductDTO;
import alcohol.mvc.dto.UserDTO;
import alcohol.mvc.service.CartService;
import alcohol.mvc.service.CartServiceImpl;
import alcohol.mvc.service.CouponService;
import alcohol.mvc.service.CouponServiceImpl;
import alcohol.mvc.service.OrderService;
import alcohol.mvc.service.OrderServiceImpl;
import alcohol.mvc.service.PaymentService;
import alcohol.mvc.service.PaymentServiceImpl;
import alcohol.mvc.service.ProductService;
import alcohol.mvc.service.ProductServiceImpl;
import alcohol.mvc.service.UserService;
import alcohol.mvc.service.UserServiceImpl;
import net.sf.json.JSONArray;

public class OrderController implements Controller{
	
	private OrderService orderService = new OrderServiceImpl();
	private PaymentService payService = new PaymentServiceImpl();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return null;
	}
	
	//주문하기 (여러개) insert 
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CartService cartService= new CartServiceImpl();
		UserService userService = new UserServiceImpl();
		CouponService couService = new CouponServiceImpl();
		
		String pCode [] = request.getParameterValues("pCode");
		String orderQty [] = request.getParameterValues("orderQty");
		String id = request.getParameter("id");
		String addr = request.getParameter("addr");
		String addr2= request.getParameter("addr2");
		String phone= request.getParameter("phone");
		String couponList = request.getParameter("couponList");
		int paytype = Integer.parseInt(request.getParameter("flexRadioDefault"));
		int point = Integer.parseInt(request.getParameter("point"));
		int bepoint = Integer.parseInt(request.getParameter("aftPoint"));
		int toPoint = point-bepoint;
		OrdersDTO oDTO= new OrdersDTO(0, id, 0, null, null, null, addr, addr2, phone);
		OrderLineDTO oLineDTO = null;
		List<OrderLineDTO> oLineList = new ArrayList<OrderLineDTO>();
		
		for(int i =0 ; i<pCode.length;i++) {
			oLineDTO=new OrderLineDTO(pCode[i], Integer.parseInt(orderQty[i]));
			oLineList.add(oLineDTO);
		}
		//결재 방식 시작 
		payService.selectPay(paytype,oDTO,oLineList);
		
		cartService.cartOrderDelete(id);	
		userService.pointDelet(id,toPoint);
		couService.couponDelete(id,couponList);
		
		
		 ModelAndView mv = new ModelAndView("myPage/myPage.jsp",true);
		 return mv;
	}
	
	
	
	//주문하기 한개 insert 
		public ModelAndView onlyInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
			CartService cartService= new CartServiceImpl();
			UserService userService = new UserServiceImpl();
			CouponService couService = new CouponServiceImpl();
			
			String pCode [] = request.getParameterValues("pCode");
			String orderQty [] = request.getParameterValues("orderQty");
			String id = request.getParameter("id");
			String addr = request.getParameter("addr");
			String addr2= request.getParameter("addr2");
			String phone= request.getParameter("phone");
			String couponList = request.getParameter("couponList");
			int paytype = Integer.parseInt(request.getParameter("flexRadioDefault"));
			int point = Integer.parseInt(request.getParameter("point"));
			int bepoint = Integer.parseInt(request.getParameter("aftPoint"));
			int toPoint = point-bepoint;
			OrdersDTO oDTO= new OrdersDTO(0, id, 0, null, null, null, addr, addr2, phone);
			OrderLineDTO oLineDTO = null;
			List<OrderLineDTO> oLineList = new ArrayList<OrderLineDTO>();
			
			for(int i =0 ; i<pCode.length;i++) {
				oLineDTO=new OrderLineDTO(pCode[i], Integer.parseInt(orderQty[i]));
				oLineList.add(oLineDTO);
			}
			//결재 방식 시작 
			payService.selectPay(paytype,oDTO,oLineList);
			
			//cartService.cartOrderDelete(id);	
			//userService.pointDelet(id,toPoint);
			
			//if(!couponList.equals("")|| couponList != null|| !couponList.equals("0")) {
				//couService.couponDelete(id,couponList);
			//}

			
			
			 ModelAndView mv = new ModelAndView("myPage/myPage.jsp",true);
			 return mv;
		}
	
	//주문수정 update orders
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String orderCode = request.getParameter("ordercode");
		String uId = request.getParameter("uid");
		String payCode = request.getParameter("paycode");
		String orderDate = request.getParameter("orderdate");
		String orderStatus = request.getParameter("orderstatus");
		String deliStatus = request.getParameter("delistatus");
		String deliAddr = request.getParameter("deliaddr");
		String deliAddr2 = request.getParameter("deliaddr2");
		String orderphone = request.getParameter("orderphone");
		
		OrdersDTO orDto = new OrdersDTO(Integer.parseInt(orderCode), uId, Integer.parseInt(payCode), orderDate, orderStatus, deliStatus, deliAddr, deliAddr2, orderphone);
		
		return new ModelAndView("store/order.jsp");
	}
	
	//주문상태출력 select ORDER_STATUS
	public void selectorder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String pName = request.getParameter("pName");
		
		HttpSession session = request.getSession();
		UserDTO uId = (UserDTO)session.getAttribute("userId");
		
		
		
		//String Name = uId.getUserName();
		//String Addr = uId.getUserAddr();
		//String Addr2 = uId.getUserAddr2();
		//String Phone = uId.getUserPhone();
		//int Point = uId.getUserPoint();		
		

		
		 //DTO dto = proService.searchBy(name); 
		// JSONArray arr = JSONArray.fromObject(dto); //System.out.println(dto.getpName()+"나와라");
		// PrintWriter out = response.getWriter(); out.print(arr);
		 
		
		//return new ModelAndView("store/order.jsp");
	}
	
	//배송상태수정 update orders
	public ModelAndView updateorder(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String deliStatus = request.getParameter("delistatus");
		
		//OrdersDTO orDto = new OrdersDTO(deliStatus);
		
		return new ModelAndView("store/order.jsp");
	}
	
	//배송상태출력 SELECT DELI_STATUS FROM ORDERS WHERE ORDER_CODE=?
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String deliStatus = request.getParameter("delistatus");
		
		request.setAttribute("deliStatus", deliStatus);
		
		return new ModelAndView("store/order.jsp");
	}

	
	/**
	 * 주문결재창 출력
	 * */
	public void orderSelect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		String pName = request.getParameter("pName");//사진이랑 
		
		String uId = request.getParameter("id");//쿠폰이랑 적립금 때문에 불러옴
		int count =Integer.parseInt(request.getParameter("count"));
		System.out.println(uId+" 이름출력");
		
		UserService userService = new UserServiceImpl();
		

		
		CouponService couService = new CouponServiceImpl();
		List<CouponDTO> couList=couService.couponAll(uId);
		
	
		ProductService pservice = new ProductServiceImpl();
		ProductDTO dto =pservice.searchBy(pName);
		int toPrice = (dto.getpPrice()*count);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("couList", couList); //쿠폰내역
		map.put("pDTO", dto);//사진 가격 등등
		map.put("toPrice",toPrice);//토탈가격
		

		JSONArray arr = JSONArray.fromObject(map); //System.out.println(dto.getpName()+"나와라");
		PrintWriter out = response.getWriter();
		out.print(arr);
		 

	}
	
	
	public void couponSelect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");//사진이랑 
		System.out.println(id+"안나오는거?");
		CouponService couService = new CouponServiceImpl(); 
		
		List<CouponDTO> couList=couService.couponAll(id);
		System.out.println(couList.size());
		JSONArray arr = JSONArray.fromObject(couList); //System.out.println(dto.getpName()+"나와라");
		PrintWriter out = response.getWriter();
		out.print(arr);
		 

	}
	
	/**
	 * 배송관리 전체 검색 
	 */
	public void orderAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String pageNo = request.getParameter("pageNo"); // 현재 페이지 번호 
		
		if(pageNo==null || pageNo.equals("")) {
			pageNo="1";
		} 
		
		List<OrdersDTO> orderList = orderService.orderAll(Integer.parseInt(pageNo));
		response.setContentType("text/html;charset=UTF-8");
		JSONArray arr= JSONArray.fromObject(orderList);
		PrintWriter out = response.getWriter();
		out.print(arr);

		
	}
	
	
	/**
	 * cart주문결재창 출력
	 * */
	public void CartorderSelect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");

		String uId = request.getParameter("id");//쿠폰이랑 적립금 때문에 불러옴
		System.out.println(uId+" 이름출력");

		CartService cartService = new CartServiceImpl();
		List<ProductDTO> plist=cartService.cartOrders(uId);

		JSONArray arr = JSONArray.fromObject(plist); //System.out.println(dto.getpName()+"나와라");
		PrintWriter out = response.getWriter();
		out.print(arr);
		 

	}
	
}
