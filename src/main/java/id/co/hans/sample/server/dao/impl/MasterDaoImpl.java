package id.co.hans.sample.server.dao.impl;

import id.co.hans.sample.server.dao.MasterDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MasterDaoImpl implements MasterDao{

    @Override
    public List<Map<String, Object>> getMasterUnit(String inTipe, String inValue) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
