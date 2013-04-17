package DataSource.Notices;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;


public class AllNotices 
{
	Vector<Notices> allNotices;
	
	public AllNotices()
	{
		allNotices=new Vector<Notices>();
		initNotices();
	}

	public void initNotices()
	{
		Notices notices=new Notices();
		notices.setTitle("hello apple club");
		notices.setContent("welcome to apple club");
		SimpleDateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd");
		notices.setData(dataFormat.format(new Date()));
		allNotices.add(notices);
	}
	
	public Vector<Notices> getAllNotices() {
		return allNotices;
	}

	public void setAllNotices(Vector<Notices> allNotices) {
		this.allNotices = allNotices;
	}
}
