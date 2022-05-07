package alcohol.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alcohol.mvc.dto.FactoryDTO;
import alcohol.mvc.dto.ProductDTO;
import alcohol.mvc.service.FactoryService;
import alcohol.mvc.service.FactoryServiceImpl;
import net.sf.json.JSONArray;



public class FactoryController implements Controller {
	private FactoryService facService = new FactoryServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("FactoryController 확인용");
				return null;
	}

	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("FactoryController select 확인용");
		//서비스 호출
				List<FactoryDTO> facList = facService.factoryAll();
				request.setAttribute("facList", facList);
				
				return new ModelAndView("store/factory.jsp");
	}
	
	public void selectByName(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");

		List<FactoryDTO> facList = facService.factoryAll();
		request.setAttribute("facList", facList);
		
		FactoryDTO fac = facService.factorySelect(name);
		
		JSONArray arr = JSONArray.fromObject(fac);
		System.out.println("나오냐" + fac.getfName());
		
		PrintWriter out = response.getWriter();
		out.print(arr);
	}

}
