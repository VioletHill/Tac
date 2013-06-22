package TacRegister;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
		int x = 0;
		int y = 0;
		try
		{
			RequestContext requestContext = new ServletRequestContext(request);
			if(ServletFileUpload.isMultipartContent(requestContext))
			{
				User user=new User();

				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				
		//		factory.setSizeThreshold(4 * 1024);
				//设置文件的缓存路径
//				String webRootPath=request.getContextPath();
				//设置上传文件大小的上限，-1表示无上限 
				upload.setSizeMax(10*1024*1024);
				
				List<FileItem> items = null;
				try 
				{
					//上传文件，并解析出所有的表单字段，包括普通字段和文件字段
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
				    //如果是普通字段
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
				    	else if (fileItem.getFieldName().equals("txt_top"))
				    	{
				    		try 
				    		{
				    			y=Integer.parseInt(fileItem.getString());
							} 
				    		catch (Exception e) 
							{
								y=0;
							}
				    	}
				    	else if (fileItem.getFieldName().equals("txt_left"))
				    	{
				    		try 
				    		{
				    			x=Integer.parseInt(fileItem.getString());
							} 
				    		catch (Exception e) 
							{
								x=0;
							}
				    	}
				    	else if (fileItem.getFieldName().equals("phone"))
				    	{
				    		user.setPhone(fileItem.getString());
				    	}
				    	else if (fileItem.getFieldName().equals("headerImg"))
				    	{
				    		try 
				    		{
				    			if (fileItem.getString().isEmpty()) continue;
					    		String dir=new String(request.getSession().getServletContext().getRealPath("/")+"User/"+user.getAccount());
					        	File userFile=new File(dir);
					        			        	
					        	try 
					        	{
					        		userFile.mkdirs();
								}
					        	catch (Exception e) 
					        	{
									// TODO: handle exception
								}
					        	
					        	String fileName=fileItem.getString();
					        	fileName=fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();
					        	File newFile = new File(dir+"/head."+fileName);
					        	
					        	user.setHeader_add("User/"+user.getAccount()+"/head."+fileName);
					        	if (newFile.exists())	newFile.delete();
					        
					            ImageCut o  =   new  ImageCut( x, y , 38 , 38);  
					            o.setSrcpath(request.getSession().getServletContext().getRealPath("/")+"/"+fileItem.getString());    
					            o.setSubpath( dir+"/head."+fileName );  
					            o.setExtendName(fileName);
					            o.cut() ;   
					  
					        	delFile(request.getSession().getServletContext().getRealPath("/")+"/"+fileItem.getString());
							} 
				    		catch (Exception e) 
							{
								continue;
							}
				    		
				    	}
				    }
				}
				UserHibernate.sharedUserHibernate().insert(user);
				request.getRequestDispatcher("/TacRegister/RegisterSuccess.jsp").forward(request, response);
			}
			else	//ajax 询问时候可以注册 
			{
				response.setContentType("text/plain; charset=gbk");
				String account=request.getParameter("account");
				//检测账号时候被注册
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
	
	public static void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { // 文件存在时
                InputStream inStream = new FileInputStream(oldPath); // 读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; // 字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();

        }

    }
	
	  public static void delFile(String filePathAndName) 
	  {
	        try {
	            String filePath = filePathAndName;
	            filePath = filePath.toString();
	            java.io.File myDelFile = new java.io.File(filePath);
	            myDelFile.delete();

	        } catch (Exception e) {
	            System.out.println("删除文件操作出错");
	            e.printStackTrace();

	        }

	    }
}

	