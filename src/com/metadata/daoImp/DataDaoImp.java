package com.metadata.daoImp;

import com.metadata.bean.Data;
import com.metadata.dao.DataDao;
import com.metadata.utils.BaseImpl;
import com.metadata.utils.BaseQueryModel;
import com.metadata.utils.PageModel;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
@Repository("dataDao")
public class DataDaoImp extends BaseImpl<Data> implements DataDao{
    @Override
    public void doQbc(DetachedCriteria dc, BaseQueryModel qm) {

    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext_bean.xml");
        DataDao dataDao = (DataDao) ac.getBean("dataDao");
        Data data = new Data();
        data.setName("hello");
        data.setDescription("gagag");
        dataDao.save(data);
    }

    @Override
    public PageModel getPageModel(int pageNum,int pageCount) {
        PageModel pm = new PageModel();
        //hql
        //String sql = "select count(id) from Data";
        //Long lon = (Long) getSession().createQuery(sql).uniqueResult();
        //List list = getSession().createQuery("from Data").setFirstResult((pageNum-1)*pageCount).setMaxResults(pageCount).list();
        //数量 qbc
        DetachedCriteria dc = DetachedCriteria.forClass(Data.class);
        //doQbc(dc,new DataQueryModel());
        dc.setProjection(Projections.rowCount());
        List<Long> count = this.getHibernateTemplate().findByCriteria(dc);
        //数据
        DetachedCriteria dc1 = DetachedCriteria.forClass(Data.class);
        this.getHibernateTemplate().findByCriteria(dc,(pageNum-1)*pageCount,pageCount);
        List data = this.getHibernateTemplate().findByCriteria(dc1,(pageNum-1)*pageCount,pageCount);
        pm.setTotal(count.get(0).intValue());
        pm.setDatas(data);

        return pm;
    }
}
