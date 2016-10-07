package com.metadata.daoImp;

import com.metadata.bean.permission.User;
import com.metadata.dao.UserDao;
import com.metadata.utils.BaseImpl;
import com.metadata.utils.BaseQueryModel;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/10/7.
 */
@Repository("userDao")
public class UserDaoImp extends BaseImpl<User> implements UserDao{
    @Override
    public void doQbc(DetachedCriteria dc, BaseQueryModel qm) {

    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext_bean.xml");
        UserDao dao = (UserDao) ac.getBean("userDao");
        User user = new User();
        user.setUserName("test");
        dao.save(user);
    }
}
