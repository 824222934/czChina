package DAO;

import java.util.List;

import entity.Mood;

public interface MoodDAO {

	/**
	 * ���һ��mood���ݵ����ݿ�
	 * 
	 * @param moodtitle �������
	 * @param moodcontent ��������
	 * @param imgUrl �����ͼƬ��ַ
	 * 
	 * @return ������ȷ���
	 */
	public boolean publishDD(String moodtitle,String moodcontent,String imgUrl);
	/**
	 * 
	 * @return ���е�Mood�б�
	 */
	public List<Mood> showMoods();
	
}
