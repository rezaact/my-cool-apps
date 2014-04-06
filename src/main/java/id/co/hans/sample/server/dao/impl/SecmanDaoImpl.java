package id.co.hans.sample.server.dao.impl;

import id.co.hans.sample.server.dao.SecmanDao;
import id.co.hans.sample.server.utility.CommonModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SecmanDaoImpl implements SecmanDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> getUserMenuByIdsesion(String idSesion, String page) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Map<String, Object> getUserDataByIdSession(String idSession) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "";

            sql = " SELECT * FROM F$VIEW_INTEGRASI_PRR_CIS123 WHERE ID_SESSION_ = '" + idSession + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsByRefError", "");
            if (lMapRecords.size() == 0) {
                retValue.put("wsReturn", null);
                retValue.put("wsByRefError", "DATA SESSION USER TIDAK DITEMUKAN");
            } else {
                retValue.put("wsReturn", lMapRecords);
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", null);
            retValue.put("wsByRefError", ex.getMessage());
        }
        return retValue;
    }
}
