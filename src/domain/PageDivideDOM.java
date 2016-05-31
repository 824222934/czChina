package domain;

import entity.PageBean;

public interface PageDivideDOM {

	 /**
     * 分页查询
     * @param pageSize 每页显示几条
     * @param currentPage 当前第几页
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    public PageBean queryForPage(int pageSize,int currentPage);
}
