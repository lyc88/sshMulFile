package com.metadata.servicesImp;

import com.metadata.bean.Data;
import com.metadata.dao.DataDao;
import com.metadata.sevice.DataSevices;
import com.metadata.utils.BaseQueryModel;
import com.metadata.utils.Page;
import com.metadata.utils.PageModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
@Service("dataServices")
public class DataServicesImp implements DataSevices {
    @Resource
    private DataDao dataDao;
    @Override
    public void save(Data data) {
        dataDao.save(data);
    }

    @Override
    public void update(Data data) {
        dataDao.update(data);
    }

    @Override
    public void delete(Data data) {
        dataDao.delete(data);
    }

    @Override
    public List<Data> getAll() {
        return dataDao.getAll();
    }

    @Override
    public Data get(Serializable uuid) {
        return dataDao.get(uuid);
    }

    @Override
    public List<Data> getAll(BaseQueryModel qm, Integer pageNum, Integer pageCount) {
        return dataDao.getAll(qm,pageNum,pageCount);
    }

    @Override
    public Integer getCount(BaseQueryModel qm) {
        return dataDao.getCount(qm);
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSevices sevices = (DataSevices) ac.getBean("dataServices");

    }

    @Override
    public PageModel getPageModel(int pageNum,int pageCount) {
        PageModel pm = new PageModel();

        return dataDao.getPageModel(pageNum,pageCount);
    }

    @Override
    public Page getPage(String action, String formId, Integer target, String total) {
        return dataDao.getPage(action,formId,target,total);
    }
}
