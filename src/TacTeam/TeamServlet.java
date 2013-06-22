package TacTeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.jspsmart.upload.Request;

import DataSource.Team.AllTeam;
import DataSource.Team.Team;
import DataSource.Team.TeamHibernate;
import DataSource.User.User;

public class TeamServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TeamServlet() {
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
		final int pageNum=10;
		
		HttpSession session=request.getSession();
		
		AllTeam allTeam=new AllTeam();
		TeamHibernate hibernate=TeamHibernate.sharedTeamHibernate();
		List<Team> testList=hibernate.findByPage(pageNum, 1);
		allTeam.setAllTeams(hibernate.findByPage(pageNum, 1));
		
		String account=(String)session.getAttribute("account");
		for (int i=0; i<allTeam.getAllTeams().size(); i++)
		{
			allTeam.getAllTeams().get(i).setIsInterested(hibernate.IsInterested(allTeam.getAllTeams().get(i).getId(),account));
			allTeam.getAllTeams().get(i).setIsJoin(hibernate.IsJoin(allTeam.getAllTeams().get(i).getId(), account));
		}
		request.setAttribute("allTeam", allTeam);
		request.getRequestDispatcher("/TacTeam/Team.jsp").forward(request, response);
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
