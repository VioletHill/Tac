package DataSource.Notices;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;


public class AllNotices 
{
	Vector<Notices> allNotices;
	static AllNotices instance;
	public synchronized static AllNotices sharedAllNotices()
	{
		if (instance==null)
		{
			instance=new AllNotices();
		}
		return instance;
	}
	
	public AllNotices()
	{
		allNotices=new Vector<Notices>();
	}

//	private void initNotices()
//	{
//		Notices notices=new Notices();
//		notices.setTitle("hello apple club");
//		notices.setContent("各位本科同学为增强我校大学生服务社会的意识，<p>培养吃苦耐劳精神<p>，在社会实践中更好地充实知识，提高技能，经大队同嘉定民政局共同磋商，决定开展本项活动，活动内容为为敬老院的老人过一次生日。嘉定民政局为我校大学生志愿者搭建志愿服务平台，并建立长期合作关系，共同推进其“为老服务爱心联盟”公益项目的开展。现招募4月26日黄渡志愿者3名，具体内容和时间安排如下：4月26日（周五）13:20在F楼北门集合与其他各个学院中队的志愿者一同乘公交前往黄渡敬老院。主要工作内容为拓展一些在敬老院活动框架内的“小活动”，比如为老人准备生日贺卡等。大队会为每位志愿者颁发志愿证书，并对志愿者进行评定，对优秀志愿者提供交通卡或同等数目的现金作为对参与活动的补偿。时间紧迫，请大家互相转告。希望有爱心、对志愿活动感兴趣的同学踊跃报名。");
//		SimpleDateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd");
//		notices.setData(dataFormat.format(new Date()));
//		allNotices.add(notices);
//	}
	
	public Vector<Notices> getAllNotices() {
		return allNotices;
	}

	public void setAllNotices(Vector<Notices> allNotices) {
		this.allNotices = allNotices;
	}
	
	public void addNotices(Notices notices)
	{
		SimpleDateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd");
		notices.setData(dataFormat.format(new Date()));
		allNotices.add(notices);
	}
}
