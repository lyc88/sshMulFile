package com.metadata.action;

import com.metadata.bean.Data;
import com.metadata.bean.DataFile;
import com.metadata.servicesImp.DataFileSevicesImp;
import com.metadata.sevice.DataFileSevices;
import com.metadata.sevice.DataSevices;
import com.metadata.utils.BaseAction;
import com.metadata.utils.PageModel;
import com.sun.deploy.net.HttpResponse;
import com.sun.deploy.net.URLEncoder;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
@Controller("dataAction")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class DataAction extends BaseAction {

    @Resource
    private DataSevices dataSevices;

    @Resource
    private DataFileSevices dataFileSevices;
    private Data data;

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public String save(){
        String[] str = getRequest().getParameterValues("files");
        //data.setDescription(getRequest().getParameter("data.description"));
        if(data != null)
        dataSevices.save(data);
        if(str != null)
        for (String s:str){
            String[] file = s.split("--");
            DataFile df1 = new DataFile();
            df1.setFilePath(file[0]);
            df1.setFileName(file[1]);
            if(data != null)
            df1.setDataId(data.getId());
            dataFileSevices.save(df1);
        }
        return SUCCESS;
    }

    public String downFile(){
        try {
            String path = getRequest().getParameter("path");
            getResponse().setCharacterEncoding("utf-8");
            getRequest().setCharacterEncoding("utf-8");
            String fileName = getRequest().getParameter("fileName");
            getResponse().setHeader("filename=",new String(fileName.getBytes(), "ISO8859-1"));
            HttpServletResponse response = getResponse();
            InputStream in = new FileInputStream(new File(path));
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(),"ISO8859-1"));
            response.addHeader("Content-Length", "" + in.available());
            OutputStream out = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            byte[] buffer = new byte[2048];
            in.read(buffer);
            while((in.read(buffer))!=-1){
                out.write(buffer);
                //System.out.println("文件大小"+buffer.length);
            }
            System.out.println(buffer.length);
            out.write(buffer);
            out.flush();
            //out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return SUCCESS;
    }

    public String list(){
       List<Data> l = dataSevices.getAll();
        getRequest().setAttribute("list",dataSevices.getAll());
        return SUCCESS;
    }


    public String listPage(){
        String page = getRequest().getParameter("pager.offset");
        if(page != null && !(page.trim()).equals("")){
            pageNum = Integer.parseInt(page)%pageCount==0?Integer.parseInt(page)/pageCount:Integer.parseInt(page)/pageCount+1;
        }else{
        }
        PageModel pm = dataSevices.getPageModel(pageNum,pageCount);
        getRequest().setAttribute("pageModel",pm);

        return SUCCESS;
    }

}
