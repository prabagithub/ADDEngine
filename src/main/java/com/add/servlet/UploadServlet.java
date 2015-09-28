package com.add.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.add.db.MongoDBDAO;
import com.add.domain.Client;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contentType = request.getContentType();		
		int maxFileSize = 5000 * 1024;
		int maxMemSize = 5000 * 1024;		
		String filePath = System.getProperty("user.dir")+"\\";
			
		File file;
		String viewName = "/error.jsp";
		MongoDBDAO mongoDAO = new MongoDBDAO();		
		RequestDispatcher rd = null;
		try{
			Client client = (Client)request.getSession().getAttribute("client");
			request.setAttribute("client", client);

			if(null != client){
				 if ((contentType.indexOf("multipart/form-data") >= 0)) {				 				 				    					   						    					 					  
					   DiskFileItemFactory factory = new DiskFileItemFactory();
					      // maximum size that will be stored in memory
					      factory.setSizeThreshold(maxMemSize);
					      // Location to save data that is larger than maxMemSize.
					      factory.setRepository(new File("c:\\temp"));
					      // Create a new file upload handler
					      ServletFileUpload upload = new ServletFileUpload(factory);
					      // maximum file size to be uploaded.
					      upload.setSizeMax( maxFileSize ); 
					         // Parse the request to get file items.
					         List fileItems = upload.parseRequest(request);
					         // Process the uploaded file items
					         Iterator i = fileItems.iterator();			        
					         while ( i.hasNext () ) 
					         {
					            FileItem fi = (FileItem)i.next();
					            if (null != fi && !fi.isFormField () )	
					            {
					            // Get the uploaded file parameters			            
					            String fileName = fi.getName();
					            boolean isInMemory = fi.isInMemory();
					            long sizeInBytes = fi.getSize();
					            // Write the file
					            if(null != fileName && !"".equalsIgnoreCase(fileName.trim())){					            	
					            	String username = null != client.getUserName() ? client.getUserName().trim() : "";					            	
					            	long timestamp = System.currentTimeMillis();
					            	
					            	   if( fileName.lastIndexOf("\\") >= 0 ){
					            		   fileName = fileName.substring( fileName.lastIndexOf("\\"));					            		   
								            file = new File( filePath + username+
								            +timestamp+
								            fileName.substring(1));
								            }else{								            									            	
								            file = new File( filePath+username+timestamp+
								            fileName.substring(fileName.lastIndexOf("\\")+1)) ;
								            }
								            fi.write( file ) ;
								            client.setFileFullPath(file.getAbsolutePath());
					            }
					         
					            }
					         }
				   }
				 
				if(mongoDAO.insertADDDetails(client)){
					viewName = "/post.jsp";
				}

			}
		
		rd = request.getRequestDispatcher(viewName);
		}catch(Exception e){
			 rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
		 	}

}
