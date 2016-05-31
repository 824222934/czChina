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
		int offset = pageSize*(currentPage - 1);//��ǰҳ��ʼ��¼
		int length = pageSize;//ÿҳ�ļ�¼��
		int allRow = pageDAO.getAllRowCount();//�ܼ�¼��
		int totalPage = PageBean.countTotalPage(pageSize, allRow);//��ҳ��
		int curPage = PageBean.countCurrentPage(currentPage);
		List<Mood> list = pageDAO.queryForPage(offset, length);
		
		//����ҳ����Ϣ���浽PageBean��
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
