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
		String account=(String)session.getAttribute("account");
		
		int page=1;
		try 
		{
			page=Integer.parseInt(request.getParameter("page"));
			if (page==0) page=1;
		} 
		catch (Exception e) 
		{
			page=1;
		}
		int peopleType=2;
		try 
		{
			peopleType=Integer.parseInt(request.getParameter("peopleType"));
		}
		catch (Exception e)
		{
			 peopleType=2;
		}
		
		
		int type=2;
		try 
		{
			type=Integer.parseInt(request.getParameter("type"));
		} 
		catch (Exception e) 
		{
			type=2;
		}
		
		AllTeam allTeam=new AllTeam();
		TeamHibernate hibernate=TeamHibernate.sharedTeamHibernate();
		if (peopleType==2)
		{
			if (type==2)
			{
				allTeam.setAllTeams(hibernate.findByPage(pageNum, page));
				allTeam.setPageIndex(page);
				allTeam.setAllPage((hibernate.number_findByPage()- 1)/ pageNum + 1);
			}
			else if (type==0)
			{
				allTeam.setAllTeams(hibernate.findByType(0, pageNum, page));
				allTeam.setPageIndex(page);
				allTeam.setAllPage((hibernate.number_findByType(0)-1)/pageNum+1);
			}
			else if (type==1)
			{
				allTeam.setAllTeams(hibernate.findByType(1, pageNum, page));
				allTeam.setPageIndex(page);
				allTeam.setAllPage((hibernate.number_findByType(1)-1)/pageNum+1);
			}
		}
		else if (peopleType==0)//我发布的
		{
			if (type==2)
			{
				allTeam.setAllTeams(hibernate.findMyTeam(account, pageNum, page));
				allTeam.setPageIndex(page);
				allTeam.setAllPage((hibernate.number_findMyTeam(account)- 1)/ pageNum + 1);
			}
			else if (type==0)
			{
				allTeam.setAllTeams(hibernate.findMyType(0, account, pageNum, page));
				allTeam.setPageIndex(page);
				allTeam.setAllPage((hibernate.number_findMyType(0, account)- 1)/ pageNum + 1);
			}
			else if (type==1)
			{
				allTeam.setAllTeams(hibernate.findMyType(1, account, pageNum, page));
				allTeam.setPageIndex(page);
				allTeam.setAllPage((hibernate.number_findMyType(1, account)- 1)/ pageNum + 1);
			}
		}
		else if (peopleType==1)	//我感兴趣的
		{
			if (type==2)
			{
				allTeam.setAllTeams(hibernate.findInterestedTeam(account, pageNum, page));
				allTeam.setPageIndex(page);
				allTeam.setAllPage((hibernate.number_findInterestedTeam(account)- 1)/ pageNum + 1);
			}
			else if (type==0)
			{
				allTeam.setAllTeams(hibernate.findInterestedType(0, account, pageNum, page));
				allTeam.setPageIndex(page);
				allTeam.setAllPage((hibernate.number_findInterestedType(0, account)- 1)/ pageNum + 1);
			}
			else if (type==1)
			{
				allTeam.setAllTeams(hibernate.findInterestedType(1, account, pageNum, page));
				allTeam.setPageIndex(page);
				allTeam.setAllPage((hibernate.number_findInterestedType(1, account)- 1)/ pageNum + 1);
			}
		}
		allTeam.setType(type);
		allTeam.setPeopleType(peopleType);
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
