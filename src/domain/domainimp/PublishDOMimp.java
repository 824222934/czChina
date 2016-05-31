package domain.domainimp;

import DAO.MoodDAO;
import DAO.imp.MoodDAOimp;
import domain.PublishDOM;

public class PublishDOMimp implements PublishDOM{

	@Override
	public boolean publish(String moodTitle, String moodContent, String imgUrl) {
		// TODO Auto-generated method stub
		
		MoodDAO publishDAO = new MoodDAOimp();
		return publishDAO.publishDD(moodTitle, moodContent, imgUrl);
	}

	
}
