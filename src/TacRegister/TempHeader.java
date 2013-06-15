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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.dialect.function.VarArgsSQLFunction;

public class TempHeader extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TempHeader() {
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
		
		String filePath = null;
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(10*1024*1024);
		String headerType[] = {".jpg",".png",".jpeg",".gif"};
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
			File newFile=null;
		    FileItem fileItem = it.next();
		    if(!fileItem.isFormField())
		    {   
		    	 //保存文件，其实就是把缓存里的数据写到目标路径下
		        if(fileItem.getName()!=null && fileItem.getSize()!=0)
		        {
		        	String dir=new String(request.getSession().getServletContext().getRealPath("/")+"/Temp/");
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
	        		
		        	for (int i=0; i>=0; i++)
		        	{	
		        		filePath="Temp/"+i+"."+fileName;
			        	newFile = new File(dir+"/"+i+"."+fileName);
			        	if (newFile.exists()) continue;
			        	else break;
		        	}
		        	
		        	
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
		       response.setContentType("text/html; charset=gbk");
				//检测账号时候被注册
		       PrintWriter out = response.getWriter();
		       out.println("<script>parent.callback("+"'"+filePath+"'"+")</script>");
		       
		       out.flush();
		     }
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
