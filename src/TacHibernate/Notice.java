package TacHibernate;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int notice_id;
	private String notice_html;
	private Date notice_date;
	public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_html() {
		return notice_html;
	}
	public void setNotice_html(String notice_html) {
		this.notice_html = notice_html;
	}
	public Date getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}
	public Notice() {
		// TODO Auto-generated constructor stub
	}

}
