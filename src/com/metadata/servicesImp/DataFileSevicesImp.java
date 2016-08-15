package com.metadata.servicesImp;

import com.metadata.bean.DataFile;
import com.metadata.dao.DataFileDao;
import com.metadata.daoImp.DataFileDaoImp;
import com.metadata.sevice.DataFileSevices;
import com.metadata.utils.BaseQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/8/14.
 */
@Service("dataFileSevices")
public class DataFileSevicesImp implements DataFileSevices {
    @Resource
    private DataFileDao dataFileDao;
    @Override
    public void save(DataFile dataFile) {
        dataFileDao.save(dataFile);
    }

    @Override
    public void update(DataFile dataFile) {

    }

    @Override
    public void delete(DataFile dataFile) {

    }

    @Override
    public List<DataFile> getAll() {
        return null;
    }

    @Override
    public DataFile get(Serializable uuid) {
        return null;
    }

    @Override
    public List<DataFile> getAll(BaseQueryModel qm, Integer pageNum, Integer pageCount) {
        return null;
    }

    @Override
    public Integer getCount(BaseQueryModel qm) {
        return null;
    }
}
