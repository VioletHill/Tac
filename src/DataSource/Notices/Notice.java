package DataSource.Notices;

import java.io.Serializable;

public class Notice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int notice_id;
	private String notice_title;
	private String notice_html;
	private int notice_year;
	private int notice_month;
	private int notice_week;
	private int notice_day;

	public String getData() {
		return new Integer(notice_year).toString() + '-'
				+ new Integer(notice_month).toString() + '-'
				+ new Integer(notice_day).toString();
	}

	public int getNotice_year() {
		return notice_year;
	}

	public void setNotice_year(int notice_year) {
		this.notice_year = notice_year;
	}

	public int getNotice_month() {
		return notice_month;
	}

	public void setNotice_month(int notice_month) {
		this.notice_month = notice_month;
	}

	public int getNotice_week() {
		return notice_week;
	}

	public void setNotice_week(int notice_week) {
		this.notice_week = notice_week;
	}

	public int getNotice_day() {
		return notice_day;
	}

	public void setNotice_day(int notice_day) {
		this.notice_day = notice_day;
	}

	public int getNotice_id() {
		return notice_id;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public Notice(int notice_id, String notice_title, int notice_year,
			int notice_month, int notice_day) {
		super();
		this.notice_id = notice_id;
		this.notice_title = notice_title;
		this.notice_year = notice_year;
		this.notice_month = notice_month;
		this.notice_day = notice_day;
		// TODO Auto-generated constructor stub
	}

	public Notice() {

	}
}
