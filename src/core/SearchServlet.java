package core;

import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entity.ResourceBean;



public class SearchServlet extends HttpServlet{

	/**
	 * 抓取开源中国中的搜索的数据
	 */
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = Jsoup.connect("http://www.oschina.net/search?scope=blog&q=http&p=2");
		conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");  
		conn.header("Accept-Encoding", "gzip, deflate, sdch");  
		conn.header("Accept-Language", "gzip, deflate, sdch");  
		conn.header("Connection", "keep-alive");  
		conn.header("Host", "www.oschina.net");  
		conn.header("Cookie", "aliyungf_tc=AQAAAEY+iFLIyw4AeguMcQN2lso+pp3E");
		conn.header("Referer", "http://www.oschina.net/search?scope=blog&q=http");
		conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.75 Safari/537.36");
		Document doc = conn.get();
		Element result = doc.getElementById("results");
		Elements content = result.getElementsByTag("li");
		
		List<ResourceBean> list = new ArrayList<ResourceBean>();
		for (Element element : content) {
			ResourceBean resourceBean = new ResourceBean();
			
			Elements h3Elements = element.getElementsByTag("h3");
			for (Element element2 : h3Elements) {
				Elements aElements = element2.getElementsByTag("a");
				for (Element element3 : aElements) {
					String hrefString = element3.attr("href");
					resourceBean.setHref(hrefString);
					String teString = element3.text();
					resourceBean.setTitle(teString);
				}
				
			}
			Elements outlinElements = element.getElementsByClass("outline");
			for (Element element2 : outlinElements) {
				String outline = element2.text();
				resourceBean.setOutLine(outline);
			}
			list.add(resourceBean);
		}
		req.setAttribute("resourceList", list);
		RequestDispatcher rd = req.getRequestDispatcher("/resourceList.jsp");
		rd.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
