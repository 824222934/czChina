package core;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MoodListDOM;
import domain.PageDivideDOM;
import domain.domainimp.MoodListDOMimp;
import domain.domainimp.PageDivideDOMimp;
import entity.Mood;
import entity.PageBean;

public class MoodListServlet extends HttpServlet{

	/**
	 * 用户发表成功以后，页面跳转到显示所有心情的列表页面
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		String page = req.getParameter("page");
		PageDivideDOM pageDivideDOM = new PageDivideDOMimp();
		PageBean pageBean = null;
		//每页显示5条信息。当前是第一页
		if(page == null){
			pageBean = pageDivideDOM.queryForPage(5, 1);
		}else{
			pageBean = pageDivideDOM.queryForPage(5, Integer.parseInt(page));
		}
		
		req.setAttribute("pageBean", pageBean);
		RequestDispatcher re = req.getRequestDispatcher("/moodList.jsp");
		re.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
		
	}

}
