package com.metadata.daoImp;

import com.metadata.bean.permission.Role;
import com.metadata.dao.RoleDao;
import com.metadata.utils.BaseImpl;
import com.metadata.utils.BaseQueryModel;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/10/7.
 */
@Repository("roleDao")
public class RoleDaoImp extends BaseImpl<Role> implements RoleDao {
    @Override
    public void doQbc(DetachedCriteria dc, BaseQueryModel qm) {

    }
}
