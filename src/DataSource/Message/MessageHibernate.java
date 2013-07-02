package DataSource.Message;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import DataSource.User.User;
import DataSource.User.UserDAO;


public class MessageHibernate implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private static MessageHibernate messageHibernate = null;
	
	public boolean insert(Message message)
	{
		MessageDAO dao=new MessageDAO();
		if(message.getUser_account()==null)
		{
			return false;
		}
		else if((message.getContent()==null)&&(message.getPicture()==null))
		{
			return false;
		}
		else {
			UserDAO dao2=new UserDAO();
			User user=dao2.find_by_account(message.getUser_account());
			message.setPicture(user.getHeader_add());
			dao.save(message);
			return true;
		}
		
	}
	public void update(Message message)
	{
		MessageDAO dao=new MessageDAO();
		dao.update(message);
	}
	public void choose(Message message)
	{
		MessageDAO dao=new MessageDAO();
		Message test=dao.findById(message.getId());
		if(test==null)
		{
			insert(message);
		}
		else {
			update(message);
		}
	}
	public void delete(int id)
	{
		MessageDAO dao=new MessageDAO();
		dao.delete(id);
	}
	public List<Message> find()
	{
		MessageDAO dao=new MessageDAO();
		List<Message> list=dao.find();
		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
			{
				if(list.get(i).getTime()==null)
				{
					list.get(i).setTime(dao.findById(list.get(i).getId()).getTime());
				}
			}
		}
		return list;
	}
	
	public MessageHibernate() {
		// TODO Auto-generated constructor stub
	}

	synchronized static public MessageHibernate sharedMessageHibernate() {
		if (messageHibernate == null) {
			messageHibernate = new MessageHibernate();
		}
		return messageHibernate;
	}
}
