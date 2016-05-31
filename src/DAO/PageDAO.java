package DAO;

import java.util.List;

public interface PageDAO {

	/**
	 * 
	 * @return 得到mood的总记录数
	 */
	public int getAllRowCount();
	 /**
     * 分页查询
     *
     * @param offset 开始记录
     * @param length 一次查询几条记录
     * @return
     */
    public List queryForPage(final int offset,final int length);
}
