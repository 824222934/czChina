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
		
		Map<String,String> formData = new HashMap<String, String>();//存放获得的表单的临时数据
		
		String path = "/upload";
		//创建一个磁盘工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//得到文件的绝对路径
		
		String filePath = this.getServletContext().getRealPath(path);
		//设置工厂的文件仓库
		factory.setRepository(new File(filePath));
		//创建一个新的文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(req);
			Iterator<FileItem> iter = items.iterator();
			while(iter.hasNext()){
				FileItem item = iter.next();
				//如果项目是一个简单的表单域
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
					//获得上传文件的输入流
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
			//TODO 发表失败
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
