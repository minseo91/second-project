package alcohol.mvc.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxDispatcherServlet
 */
@WebServlet(urlPatterns = "/ajax", loadOnStartup = 1)
public class AjaxDispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Map<String, Controller> map;
	Map<String, Class<?>> clzMap;

	@Override
	public void init() throws ServletException {
		// map = (Map<String, Controller>)super.getServletContext().getAttribute("map");

		ServletContext application = super.getServletContext();
		Object obj = application.getAttribute("ajaxMap");
		map = (Map<String, Controller>) obj;

		clzMap = (Map<String, Class<?>>) super.getServletContext().getAttribute("ajaxClzMap");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String key = request.getParameter("key"); // customer 
		String methodName = request.getParameter("methodName"); // idCheck, insert, selectAll, update, delete 

		System.out.println("key2 = " + key + ", methodName2 = " + methodName); // 확인

		try {

			Class<?> clz = clzMap.get(key);
			Method method = clz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class); // string을																								// 인식

			Controller controller = map.get(key);

			method.invoke(controller, request, response); // Controller클래스에서 메소드를 호출, request,response는 메소드

		} catch (Exception e) {
			e.printStackTrace();

		}

	} // service End

}
