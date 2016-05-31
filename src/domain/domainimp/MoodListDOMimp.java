package domain.domainimp;

import java.util.List;

import DAO.MoodDAO;
import DAO.imp.MoodDAOimp;
import domain.MoodListDOM;
import entity.Mood;

public class MoodListDOMimp implements MoodListDOM{

	@Override
	public List<Mood> moodList() {
		// TODO Auto-generated method stub
		MoodDAO moodDAO = new MoodDAOimp();
		return moodDAO.showMoods();
	}

}
