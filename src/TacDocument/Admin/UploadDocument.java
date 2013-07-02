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

		// ��������Ƿ���һ���ϴ���(������post���󣬺�enctype=��multipart/form-date��)

		Boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {
			// ����һ����ʱ�ļ����Ҫ�ϴ����ļ�����һ���������ϴ��ļ���С���ڶ��������Ǵ�ŵ���ʱĿ¼
			request.setCharacterEncoding("utf-8");
			DiskFileItemFactory factory = new DiskFileItemFactory(
					1024 * 1024 * 500, new File("/upload"));

			// ����һ���ļ��ϴ��ľ��
			ServletFileUpload upload = new ServletFileUpload(factory);

			// �����ļ��ϴ���������С���ϴ��ĵ����ļ���С
			upload.setSizeMax(1024 * 1024 * 5000);
			upload.setFileSizeMax(1024 * 1024 * 500);

			String title = "";
			String contentString = "";
			String catalogString = "";

			for (Enumeration<String> e = request.getParameterNames(); e
					.hasMoreElements();)
				System.out.println(e.nextElement());

			try {

				// ��ҳ�����ÿһ����Ԫ������һ��Fileitem
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem fileItem : items) {
					// �����һ����ͨ�ı�Ԫ�أ�type����files�ı�Ԫ�أ�
					if (fileItem.isFormField()) {
						// System.out.println(fileItem.getFieldName());
						// //�õ���Ӧ��Ԫ�ص�����
						System.out.println(fileItem.getString("utf-8"));// �õ���Ԫ�ص�ֵ
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
					// �����һ����ͨ�ı�Ԫ�أ�type����files�ı�Ԫ�أ�
					if (!fileItem.isFormField()) {
						// ��ȡ�ļ��ĺ�׺��
						String filename = fileItem.getName();// �õ��ļ���
						String fileExt = filename.substring(
								filename.lastIndexOf(".") + 1,
								filename.length());

						if (Arrays.binarySearch(fileExts, fileExt) != -1) {
							try {

								// ���ļ��ϴ���uploadĿ¼������
								// ,getRealPath���Եõ���Ŀ¼�°���/upload�ľ���·��
								String filePathString = getServletContext()
										.getRealPath("/upload")
										+ "/"
										+ UUID.randomUUID().toString()
										+ "."
										+ fileExt;
								fileItem.write(new File(filePathString));
								System.out.println("���ļ��ϴ��ɹ�����");
								Document newDocument = new Document(title,
										contentString, filePathString,
										catalogString);
								System.out.println(title + contentString
										+ filePathString + catalogString);
								DocumentDAO dao = DocumentDAO
										.sharedDocumentDAO();
								dao.save(newDocument);
								System.out.println("�������ݿ⣡��");

							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						} else {
							System.out.println("���ļ����Ͳ����ϴ�");
						}
					}
				}
			} catch (SizeLimitExceededException e) {
				// TODO: handle exception
				System.out.println("��������Ĵ�С�����˹涨�Ĵ�С...");
			}

			catch (FileSizeLimitExceededException e) {
				System.out.println("������һ���ϴ��ļ��Ĵ�С�����˹涨�Ĵ�С...");
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
