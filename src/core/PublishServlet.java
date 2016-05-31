package core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import domain.PublishDOM;
import domain.domainimp.PublishDOMimp;

public class PublishServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); 
		
		InputStream in = null;
		FileOutputStream fos = null;
		String imgUrl = null;
		
		Map<String,String> formData = new HashMap<String, String>();//��Ż�õı�����ʱ����
		
		String path = "/upload";
		//����һ�����̹���
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//�õ��ļ��ľ���·��
		
		String filePath = this.getServletContext().getRealPath(path);
		//���ù������ļ��ֿ�
		factory.setRepository(new File(filePath));
		//����һ���µ��ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(req);
			Iterator<FileItem> iter = items.iterator();
			while(iter.hasNext()){
				FileItem item = iter.next();
				//�����Ŀ��һ���򵥵ı���
				if(item.isFormField()){
					String name = item.getFieldName();
					String content = item.getString("UTF-8");
					formData.put(name, content);
					
				}else{
					if(item == null | item.getSize()==0){
						imgUrl = null;
						continue;
					}
					String filename = item.getName();
					//����ϴ��ļ���������
					in = item.getInputStream();
					fos = new FileOutputStream(new File(filePath, filename));
					imgUrl = filename;
					
					byte[] buf = new byte[2048];
					int len = -1;
					while((len = in.read(buf)) != -1){
						fos.write(buf, 0, len);
					}
	
				}
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fos != null)
				fos.close();
			if(in != null)
				in.close();
		}
		
			
		PublishDOM publishDom = new PublishDOMimp();
		boolean result = publishDom.publish(formData.get("DDtitle"), formData.get("DDcontent"), imgUrl);
		if(result == true){
			//resp.sendRedirect(req.getContextPath()+"/core/MoodListServlet");
			RequestDispatcher re = req.getRequestDispatcher("MoodListServlet");
			re.forward(req, resp);
		}else{
			//TODO ����ʧ��
			req.getRequestDispatcher("");
		}
		
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
}
