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

import alcohol.mvc.dto.CouponDTO;
import alcohol.mvc.dto.ProductDTO;
import alcohol.mvc.dto.SubDTO;
import alcohol.mvc.dto.UserDTO;
import alcohol.mvc.service.CartService;
import alcohol.mvc.service.CartServiceImpl;
import alcohol.mvc.service.CouponService;
import alcohol.mvc.service.CouponServiceImpl;
import alcohol.mvc.service.SubService;
import alcohol.mvc.service.SubServiceImpl;
import alcohol.mvc.service.UserService;
import alcohol.mvc.service.UserServiceImpl;
import net.sf.json.JSONArray;

public class UserController implements Controller {

	private UserService userService = new UserServiceImpl();

	@Override   
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UserController 제대로 오나?");
		return null;
	}

	/**
	 * 로그인 
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserController login도 제대로 오나?");
		// 넘어오는 userID,pwd 받기
		String userId = request.getParameter("id");
		String userPwd = request.getParameter("pwd");
		//System.out.println(userId + userPwd);
		
		// 서비스 호출
		UserDTO dbDTO = userService.loginCheck(new UserDTO(userId, userPwd));
		
		// 그결과를 받아서 성공했으면 sessionScope에 저장 
		//System.out.println(dbDTO);
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", dbDTO); // ${loginUser.userId}
		session.setAttribute("loginId", dbDTO.getUserId());
		session.setAttribute("loginName", dbDTO.getUserName());
		session.setAttribute("loginGrade", dbDTO.getUserGrade());
		session.setAttribute("loginPoint", dbDTO.getUserPoint());
		session.setAttribute("loginAddr", dbDTO.getUserAddr()+" "+dbDTO.getUserAddr2());

		// index.jsp -> redirect
		ModelAndView mv = new ModelAndView("index.jsp", true);

		return mv;

	}

	
	/**
	 * 회원가입
	 */
	public ModelAndView join(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("UserController join입니다.");

		// 전송된 데이터 받기
		String userId = request.getParameter("id");
		String userPwd = request.getParameter("pwd");
		String userName = request.getParameter("name");
		String userJumin = request.getParameter("jumin");
		String userPhone = request.getParameter("tel");
		String userEmail = request.getParameter("email");
		String userAddr = request.getParameter("addr");
		String userAddr2 = request.getParameter("addr2");
		String userAddr3 = request.getParameter("addr3");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String date = df.format(new Date());

		UserDTO userDTO = new UserDTO(userId, userPwd, userName, userJumin, userPhone, userEmail, userAddr, userAddr2,
				userAddr3, 0, 0, date);

		userService.insert(userDTO);

		// index.jsp -> redirect
		ModelAndView mv = new ModelAndView("index.jsp", true);

		return mv;

	}
	

	/**
	 * 아이디 중복체크
	 */
	public void idCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=utf-8");

		String id = request.getParameter("id");
		
		userService.idCheck(id);

	}
	
	/**
	 * 아이디 찾기 
	 */
	public ModelAndView idFind(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		System.out.println("나오냐아아ㅏ" + name);
		System.out.println("나오냐아아ㅏ" + phone);
		System.out.println("나오냐아아ㅏ" + email);
		
		userService.idFind(name, phone, email);
		
		ModelAndView mv = new ModelAndView("user/idFindAfter.jsp");

		return mv;
	
		
	}
	
	/**
	 * 비밀번호 찾기 
	 */
	public ModelAndView pwdFind(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		System.out.println("나오냐야아아으ㅏ으아으ㅏ " + id);
		System.out.println("나오냐야아아으ㅏ으아으ㅏ " + name);
		System.out.println("나오냐야아아으ㅏ으아으ㅏ " + phone);
		System.out.println("나오냐야아아으ㅏ으아으ㅏ " + email);
		
		userService.pwdFind(id, name, phone, email);
		
		ModelAndView mv = new ModelAndView("user/pwdFindAfter.jsp");

		return mv;
		
	}

	/**
	 * 로그아웃 
	 */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("로그아웃 되냥");
		
		// 모든 세션의 정보를 삭제 
		HttpSession session = request.getSession();
		session.invalidate();
		
		return new ModelAndView("index.jsp", true);
	}
	
	
	
	
	
	public void memberAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");

		List<UserDTO> dto=userService.memeberAll();

		
		
		JSONArray arr = JSONArray.fromObject(dto); //System.out.println(dto.getpName()+"나와라");
		PrintWriter out = response.getWriter();
		out.print(arr);
		 

	}
	
	
	public ModelAndView couponInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("bbbb");
		String items = request.getParameter("items");//갯수
		int coupon = Integer.parseInt(request.getParameter("coupon"));
		
		CouponService couService = new CouponServiceImpl();
		CouponDTO dto = new CouponDTO(id, coupon, items);
		

		for(int i=1;i<=Integer.parseInt(dto.getCount());i++) {
			couService.couponInsert(dto);
			System.out.println(i);
		}
		ModelAndView mv = new ModelAndView("admin/member.jsp",true);

		return mv;
	
		
	}
	public void mypage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");


		SubService subService = new SubServiceImpl();
		CouponService couService = new CouponServiceImpl();
		List<CouponDTO> clist=couService.couponAll(id);
		SubDTO sDTO=subService.subSelect(id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("clist", clist);
		map.put("sDTO", sDTO);

		JSONArray arr = JSONArray.fromObject(map); //System.out.println(dto.getpName()+"나와라");
		PrintWriter out = response.getWriter();
		out.print(arr);
	
		
	}	
	
	
	
	
	
}
