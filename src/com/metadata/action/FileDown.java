package com.metadata.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Administrator on 2016/8/14.
 */
@WebServlet(name = "Servlet")
public class FileDown extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = request.getParameter("path");
            File f = new File(path);
            BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
            byte[] buf = new byte[1024];
            int len = 0;
            String fileName = request.getParameter("fileName");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
            response.addHeader("Content-Length", "" + br.available());
            response.setContentType("application/octet-stream");
            OutputStream out = response.getOutputStream();
            while ((len = br.read(buf)) > 0) {
                out.write(buf);
            }
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            //return null;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        //return SUCCESS;
    }
}
