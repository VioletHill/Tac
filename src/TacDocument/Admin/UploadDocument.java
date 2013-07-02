package TacDocument.Admin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DataSource.Document.Document;
import DataSource.Document.DocumentDAO;

public class UploadDocument extends HttpServlet {

	private String[] fileExts = { "doc", "zip", "rar", "jpg", "txt", "pdf" };

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 检查请求是否是一个上传表单(必须是post请求，和enctype=“multipart/form-date”)

		Boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {
			// 创建一个临时文件存放要上传的文件，第一个参数是上传文件大小，第二个参数是存放的临时目录
			request.setCharacterEncoding("utf-8");
			DiskFileItemFactory factory = new DiskFileItemFactory(
					1024 * 1024 * 500, new File("/upload"));

			// 创建一个文件上传的句柄
			ServletFileUpload upload = new ServletFileUpload(factory);

			// 设置文件上传的整个大小和上传的单个文件大小
			upload.setSizeMax(1024 * 1024 * 5000);
			upload.setFileSizeMax(1024 * 1024 * 500);

			String title = "";
			String contentString = "";
			String catalogString = "";

			for (Enumeration<String> e = request.getParameterNames(); e
					.hasMoreElements();)
				System.out.println(e.nextElement());

			try {

				// 把页面表单中每一个表单元解析成一个Fileitem
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem fileItem : items) {
					// 如果是一个普通的表单元素（type不是files的表单元素）
					if (fileItem.isFormField()) {
						// System.out.println(fileItem.getFieldName());
						// //得到对应表单元素的名字
						System.out.println(fileItem.getString("utf-8"));// 得到表单元素的值
						if (fileItem.getFieldName().equals("title")) {
							title = fileItem.getString("utf-8");
						} else if (fileItem.getFieldName()
								.equals("description")) {
							contentString = fileItem.getString();
						} else if (fileItem.getFieldName().equals("catalog")) {
							catalogString = fileItem.getString("utf-8");
						}
					}
				}
				for (FileItem fileItem : items) {
					// 如果是一个普通的表单元素（type不是files的表单元素）
					if (!fileItem.isFormField()) {
						// 获取文件的后缀名
						String filename = fileItem.getName();// 得到文件名
						String fileExt = filename.substring(
								filename.lastIndexOf(".") + 1,
								filename.length());

						if (Arrays.binarySearch(fileExts, fileExt) != -1) {
							try {

								// 将文件上传到upload目录并命名
								// ,getRealPath可以得到该目录下包含/upload的绝对路径
								String filePathString = getServletContext()
										.getRealPath("/upload")
										+ "/"
										+ UUID.randomUUID().toString()
										+ "."
										+ fileExt;
								fileItem.write(new File(filePathString));
								System.out.println("该文件上传成功！！");
								Document newDocument = new Document(title,
										contentString, filePathString,
										catalogString);
								System.out.println(title + contentString
										+ filePathString + catalogString);
								DocumentDAO dao = DocumentDAO
										.sharedDocumentDAO();
								dao.save(newDocument);
								System.out.println("存入数据库！！");

							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						} else {
							System.out.println("该文件类型不能上传");
						}
					}
				}
			} catch (SizeLimitExceededException e) {
				// TODO: handle exception
				System.out.println("整个请求的大小超过了规定的大小...");
			}

			catch (FileSizeLimitExceededException e) {
				System.out.println("请求中一个上传文件的大小超过了规定的大小...");
			}

			catch (FileUploadException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
