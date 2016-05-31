package DAO;

import java.util.List;

import entity.Mood;

public interface MoodDAO {

	/**
	 * 添加一行mood数据到数据库
	 * 
	 * @param moodtitle 心情标题
	 * @param moodcontent 心情内容
	 * @param imgUrl 心情的图片地址
	 * 
	 * @return 插入正确与否
	 */
	public boolean publishDD(String moodtitle,String moodcontent,String imgUrl);
	/**
	 * 
	 * @return 所有的Mood列表
	 */
	public List<Mood> showMoods();
	
}
