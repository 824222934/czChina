package domain;

import entity.PageBean;

public interface PageDivideDOM {

	 /**
     * ��ҳ��ѯ
     * @param pageSize ÿҳ��ʾ����
     * @param currentPage ��ǰ�ڼ�ҳ
     * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
     */
    public PageBean queryForPage(int pageSize,int currentPage);
}
