package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


//上传图片
public class FileUploadServlet extends HttpServlet {
    
    List piclist=new ArrayList();  //放上传的图片名
     
    public void destroy() {
        super.destroy(); 
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/image");
        
         
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload sfu=new ServletFileUpload(factory);
        sfu.setHeaderEncoding("UTF-8");  //处理中文问题
        sfu.setSizeMax(1024*1024);   //限制文件大小
        
        try {
            List<FileItem> fileItems= sfu.parseRequest(request);  //解码请求 得到所有表单元素
            for (FileItem fi : fileItems) {
                //有可能是 文件，也可能是普通文字 
                if (fi.isFormField()) { //这个选项是 文字 
                    System.out.println("表单值为："+fi.getString());
                }else{
                    // 是文件
                    String fn=fi.getName();
                    System.out.println("文件名是："+fn);  //文件名 
                    // fn 是可能是这样的 c:\abc\de\tt\fish.jpg
                    fi.write(new File(path,fn));
                    
                    if (fn.endsWith(".jpg")) {
                        piclist.add(fn);  //把图片放入集合
                    }
                }                
            }    
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        //去显示上传的文件
        request.setAttribute("pics", piclist);
        request.setAttribute("imageURL",  piclist.get(0));
        request.getRequestDispatcher("bookInfoInsert.jsp").forward(request, response);
        piclist.clear();
        

         
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // fix 修改过
        doGet(request, response);
    }
    
//    public void init() throws ServletException {
//        // Put your code here
//    }

}