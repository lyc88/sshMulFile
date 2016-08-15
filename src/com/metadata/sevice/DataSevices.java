package com.metadata.sevice;

import com.metadata.bean.Data;
import com.metadata.utils.BaseEbi;
import com.metadata.utils.PageModel;

/**
 * Created by Administrator on 2016/8/13.
 */
public interface DataSevices extends BaseEbi<Data> {
    public PageModel getPageModel(int pageNum,int pageCount);
}
