package domain.domainimp;

import java.util.List;

import DAO.PageDAO;
import DAO.imp.PageDAOimp;
import domain.PageDivideDOM;
import entity.Mood;
import entity.PageBean;

public class PageDivideDOMimp implements PageDivideDOM{

	@SuppressWarnings("unchecked")
	@Override
	public PageBean queryForPage(int pageSize, int currentPage) {
		PageDAO pageDAO = new PageDAOimp();
		int offset = pageSize*(currentPage - 1);//当前页开始记录
		int length = pageSize;//每页的记录数
		int allRow = pageDAO.getAllRowCount();//总记录数
		int totalPage = PageBean.countTotalPage(pageSize, allRow);//总页数
		int curPage = PageBean.countCurrentPage(currentPage);
		List<Mood> list = pageDAO.queryForPage(offset, length);
		
		//将分页的信息保存到PageBean中
		PageBean pageBean = new PageBean();
		pageBean.setAllRow(allRow);
		pageBean.setCurrentPage(curPage);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		
		return pageBean;
	}

}
