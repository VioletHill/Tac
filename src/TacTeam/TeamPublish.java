package TacTeam;

import java.io.IOException;

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

		TeamHibernate teamHibernate=TeamHibernate.sharedTeamHibernate();
		HttpSession session=request.getSession();
		for (int i=0; i<10; i++)
		{
			Team team=new Team();
			team.setTitle("abc");
			team.setPublishUser(UserHibernate.sharedUserHibernate().find_by_account((String)session.getAttribute("account")));
			team.setContent("wwwwccccc");
			team.setType(i%2);
			teamHibernate.insert(team);
		}
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
