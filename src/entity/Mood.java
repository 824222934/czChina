package entity;

public class Mood {
	
	private String moodTitle;//动态的标题
	private String moodContent;//动态的内容
	private String photoUrl;//添加照片的url
	
	public String getMoodTitle() {
		return moodTitle;
	}
	public void setMoodTitle(String moodTitle) {
		this.moodTitle = moodTitle;
	}
	public String getMoodContent() {
		return moodContent;
	}
	public void setMoodContent(String moodContent) {
		this.moodContent = moodContent;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	
}
