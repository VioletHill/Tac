package DataSource.Honor;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class HonorHibernate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static HonorHibernate honorHibernate = null;

	
	public void insert(Honor honor)
	{
		HonorDAO dao=new HonorDAO();
		String[] change=honor.getPicture();
		String to_string="";
		if(change!=null)
		{
			int size=change.length;
			for(int i=0;i<size;i++)
			{
				to_string+=change[i];
				to_string+=",";
			}
			honor.setPicture_add(to_string);
		}
		dao.save(honor);
	}
	public void update(Honor honor)
	{
		HonorDAO dao=new HonorDAO();
		String[] change=honor.getPicture();
		String to_string="";
		if(change!=null)
		{
			int size=change.length;
			for(int i=0;i<size;i++)
			{
				to_string+=change[i];
				to_string+=",";
			}
			honor.setPicture_add(to_string);
		}
		dao.update(honor);
	}
	public void choose(Honor honor)
	{
		HonorDAO dao=new HonorDAO();
		Honor n=dao.findById(honor.getHonor_id());
		if(n==null)
		{
			insert(honor);
		}
		else
		{
			update(honor);
		}
	}
	public boolean delete(int id)
	{
		boolean delete=true;
		HonorDAO dao=new HonorDAO();
		Honor honor=dao.findById(id);
		if(honor==null)
		{
			delete=false;
			return delete;
		}
		else
		{
			dao.delete(id);
			return delete;
		}
	}
	public Honor find(int id)
	{
		Honor honor=new Honor();
		HonorDAO dao=new HonorDAO();
		honor=dao.findById(id);
		String[] picture_add;
		String picture_string=honor.getPicture_add();
		if(picture_string!=null)
		{
			picture_add=picture_string.split(",");
			honor.setPicture(picture_add);
		}
		return honor;
	}
	public int Honor_number()
	{
		HonorDAO dao=new HonorDAO();
		return dao.find_number();
	}
	public List find_honor(int account,int page)
	{
		HonorDAO dao=new HonorDAO();
		List list=dao.FindHonorByPage(account, page);
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			String[] picture_add;
			Honor honor=new Honor();
			honor=(Honor)it.next();
			String picture_string=honor.getPicture_add();
			if(picture_string!=null)
			{
				picture_add=picture_string.split(",");
				honor.setPicture(picture_add);
			}			
		}
		return list;
	}

	public HonorHibernate() {

	}


	synchronized static public HonorHibernate sharedNoticesHibernate() {
		if (honorHibernate == null) {
			honorHibernate = new HonorHibernate();
		}
		return honorHibernate;
	}
}
