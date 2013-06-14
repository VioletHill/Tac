package TacRegister;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import DataSource.User.User;
import DataSource.User.UserHibernate;


public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
			throws ServletException, IOException 
	{			
		try
		{
			RequestContext requestContext = new ServletRequestContext(request);
			if(ServletFileUpload.isMultipartContent(requestContext))
			{
				User user=new User();

				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				
		//		factory.setSizeThreshold(4 * 1024);
				//�����ļ��Ļ���·��
//				String webRootPath=request.getContextPath();
				//�����ϴ��ļ���С�����ޣ�-1��ʾ������ 
				upload.setSizeMax(10*1024*1024);
				
				String headerType[] = {".jpg",".png",".jpeg",".gif"};
				List<FileItem> items = null;
				try 
				{
					//�ϴ��ļ��������������еı��ֶΣ�������ͨ�ֶκ��ļ��ֶ�
				    items = upload.parseRequest(request);
				}
				catch (SizeLimitExceededException e) 
				{
	                System.out.println("size limit exception!");
	            }
				catch (FileUploadException e1) 
				{	
					e1.printStackTrace();
				    log("parseRequest wrong");
				    return ;
				}
				
				Iterator<FileItem> it = items.iterator();
				while(it.hasNext())
				{
				    FileItem fileItem = it.next();
				    //�������ͨ�ֶ�
				    if(fileItem.isFormField())
				    {   
				 
				    	if (fileItem.getFieldName().equals("account"))
				    	{
				    		user.setAccount(fileItem.getString());
				    	}
				    	else if (fileItem.getFieldName().equals("password"))
				    	{	
				    		user.setPassword(fileItem.getString());
				    	}
				    	else if (fileItem.getFieldName().equals("email"))
				    	{
				    		user.setEmail(fileItem.getString());
				    	}
				    	else if (fileItem.getFieldName().equals("phone"))
				    	{
				    		user.setPhone(fileItem.getString());
				    	}
				    }
				    else
				    {
				        //�����ļ�����ʵ���ǰѻ����������д��Ŀ��·����
				        if(fileItem.getName()!=null && fileItem.getSize()!=0)
				        {
				        	String dir=new String(request.getSession().getServletContext().getRealPath("/")+"/User/"+user.getAccount());
				        	File userFile=new File(dir);
				        			        	
				        	try 
				        	{
				        		userFile.mkdirs();
							}
				        	catch (Exception e) 
				        	{
								// TODO: handle exception
							}
				        
				        	String fileName=fileItem.getName();
				        	fileName=fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();
				        	File newFile = new File(dir+"/"+"head."+fileName);
				        	user.setHeader_add("User/"+user.getAccount()+"/head."+fileName);
				        	if (newFile.exists())	newFile.delete();
				        	
				        	newFile.createNewFile();
				        	
				        	try 
				        	{
				        		fileItem.write(newFile);
				        	} 
				        	catch (Exception e) 
				        	{
				        		e.printStackTrace();
				        	}
				       }
				       else
				       {
				    	    System.out.println("�ļ�û��ѡ�� �� �ļ�����Ϊ��");
				       }
				     }
				}
				UserHibernate.sharedUserHibernate().insert(user);
				request.getRequestDispatcher("/TacRegister/RegisterSuccess.jsp").forward(request, response);
			}
			else	//ajax ѯ��ʱ�����ע�� 
			{
				response.setContentType("text/html; charset=gbk");
				String account=request.getParameter("account");
				//����˺�ʱ��ע��
				PrintWriter out = response.getWriter();
				if (UserHibernate.sharedUserHibernate().judge(account)) out.write("true");
				else out.write("false");
				out.flush();
		
				return ;
			}
			

			
		}
		catch (Exception e) 
		{
			log("can not read the user");
			request.getRequestDispatcher("/ErrorPage/ErrorPage.html").forward(request, response);
			return ;
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
			throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
