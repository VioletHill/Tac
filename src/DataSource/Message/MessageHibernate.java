package DataSource.Message;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;


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
		return dao.find();
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
