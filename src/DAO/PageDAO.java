package DAO;

import java.util.List;

public interface PageDAO {

	/**
	 * 
	 * @return �õ�mood���ܼ�¼��
	 */
	public int getAllRowCount();
	 /**
     * ��ҳ��ѯ
     *
     * @param offset ��ʼ��¼
     * @param length һ�β�ѯ������¼
     * @return
     */
    public List queryForPage(final int offset,final int length);
}
