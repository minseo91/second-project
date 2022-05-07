package alcohol.mvc.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlcoholDispatcherServlet
 */
@WebServlet(urlPatterns = "/front", loadOnStartup = 1)
public class AlcoholDispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, Controller> map;
	Map<String, Class<?>> clzMap;

	public void init() throws ServletException {
		
//		ServletContext application = super.getServletContext();
//		Object obj = application.getAttribute("map");
//		map = (Map<String, Controller>)obj;
		
		map = (Map<String, Controller>)super.getServletContext().getAttribute("map");
		
		clzMap = (Map<String, Class<?>>)super.getServletContext().getAttribute("clzMap");
		
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		String methodName = request.getParameter("methodName");

		
		System.out.println("key = " + key + ", methodName = " + methodName);
		
		try {
			
			Class<?> clz = clzMap.get(key);
			Method method = clz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class); // string을 method로 인식 
			
			Controller controller = map.get(key);
			
			ModelAndView mv = (ModelAndView)method.invoke(controller, request, response); // Controller클래스에서 메소드를 호출, request,response는 메소드 
			
			// ModelAndView mv = controller.handleRequest(request, response);
			if(mv.isRedirect()) { // redirect로 가겠다.
				response.sendRedirect(mv.getViewName());
			} else {
				request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
