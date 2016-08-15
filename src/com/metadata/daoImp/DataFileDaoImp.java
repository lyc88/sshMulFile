package com.metadata.daoImp;

import com.metadata.action.DataAction;
import com.metadata.bean.DataFile;
import com.metadata.dao.DataFileDao;
import com.metadata.utils.BaseImpl;
import com.metadata.utils.BaseQueryModel;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/8/14.
 */
@Repository("dataFileDao")
public class DataFileDaoImp extends BaseImpl<DataFile> implements DataFileDao{
    @Override
    public void doQbc(DetachedCriteria dc, BaseQueryModel qm) {

    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
       // DataFileDao dao = (DataFileDao) ac.getBean("dataFileDao");
        DataAction dao1 = (DataAction) ac.getBean("dataAction");
       /* DataFile s = new DataFile();
        s.setDataId(12);
        s.setFileName("sjjs");
        dao.save(s);*/
    }
}
