package com.metadata.daoImp;

import com.metadata.dao.RourcesDao;
import com.metadata.utils.BaseImpl;
import com.metadata.utils.BaseQueryModel;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/10/7.
 */
@Repository("resourceDao")
public class ResourceDaoImp extends BaseImpl<com.metadata.bean.permission.Resoure> implements RourcesDao {
    @Override
    public void doQbc(DetachedCriteria dc, BaseQueryModel qm) {

    }
}
