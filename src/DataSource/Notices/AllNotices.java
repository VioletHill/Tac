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
//		notices.setContent("��λ����ͬѧΪ��ǿ��У��ѧ������������ʶ��<p>�����Կ����;���<p>�������ʵ���и��õس�ʵ֪ʶ����߼��ܣ������ͬ�ζ������ֹ�ͬ���̣�������չ�����������ΪΪ����Ժ�����˹�һ�����ա��ζ�������Ϊ��У��ѧ��־Ը�ߴ־Ը����ƽ̨�����������ں�����ϵ����ͬ�ƽ��䡰Ϊ�Ϸ��������ˡ�������Ŀ�Ŀ�չ������ļ4��26�ջƶ�־Ը��3�����������ݺ�ʱ�䰲�����£�4��26�գ����壩13:20��F¥���ż�������������ѧԺ�жӵ�־Ը��һͬ�˹���ǰ���ƶɾ���Ժ����Ҫ��������Ϊ��չһЩ�ھ���Ժ�����ڵġ�С���������Ϊ����׼�����պؿ��ȡ���ӻ�Ϊÿλ־Ը�߰䷢־Ը֤�飬����־Ը�߽���������������־Ը���ṩ��ͨ����ͬ����Ŀ���ֽ���Ϊ�Բ����Ĳ�����ʱ����ȣ����һ���ת�档ϣ���а��ġ���־Ը�����Ȥ��ͬѧӻԾ������");
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
