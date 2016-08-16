package com.metadata.dao;

import com.metadata.bean.Data;
import com.metadata.utils.BaseDao;
import com.metadata.utils.Page;
import com.metadata.utils.PageModel;

/**
 * Created by Administrator on 2016/8/13.
 */
public interface DataDao extends BaseDao<Data> {
    public PageModel getPageModel(int pageNum,int pageCount);

    public Page getPage(String action, String formId, Integer target, String total);
}
