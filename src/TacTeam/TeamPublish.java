package TacTeam;

import java.io.IOException;

import javax.rmi.CORBA.Tie;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataSource.Team.Team;
import DataSource.Team.TeamHibernate;
import DataSource.User.UserHibernate;

public class TeamPublish extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TeamPublish() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title=null;
		try {
			title=new String(request.getParameter("title").getBytes("iso-8859-1"), "gbk");
		} catch (Exception e) {
		}
		
		String content=null;
		try {
			content=new String(request.getParameter("content").getBytes("iso-8859-1"), "gbk");
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		int type=0;
		try {
			type=Integer.parseInt(request.getParameter("type"));
		} catch (Exception e) {
			// TODO: handle exception
			type=0;
		}
		if (title==null || title.equals("") || content==null || content.equals(""))
		{
			request.getRequestDispatcher("/TacTeam/TeamPublish.jsp").forward(request, response);
			return ;
		}
		
		
		TeamHibernate teamHibernate=TeamHibernate.sharedTeamHibernate();
		HttpSession session=request.getSession();
		
		Team team=new Team();
		team.setTitle(title);
		team.setPublishUser(UserHibernate.sharedUserHibernate().find_by_account((String)session.getAttribute("account")));
		team.setContent(content);
		team.setType(type);
		teamHibernate.insert(team);
		
		response.sendRedirect("/Tac/Team");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
