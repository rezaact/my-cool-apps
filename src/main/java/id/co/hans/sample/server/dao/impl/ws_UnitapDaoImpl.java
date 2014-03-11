package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.clsUNITAP;
import id.co.hans.sample.server.dao.ws_UnitapDao;
import id.co.hans.sample.server.utility.CommonModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ws_UnitapDaoImpl implements ws_UnitapDao {

    public static final Log log = LogFactory.getLog(ws_UnitapDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> GetUNITAP() {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SELECT * FROM UNITAP";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }
        return retValue;
    }

    @Override
    public Map<String, Object> InsertUNITAP(clsUNITAP UNITAP) {

        Map<String, Object> retValue = new HashMap<String, Object>();

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "INSERT INTO UNITAP " +
                    "(UNITAP,  SATUAN, NAMA, ALAMAT, TELEPON, FAXIMILE, UNITUPI,MANAGER, KOTA) " +
                    "VALUES " +
                    "('" + UNITAP.UNITAP +
                    "','" + UNITAP.SATUAN +
                    "','" + UNITAP.NAMA +
                    "','" + UNITAP.ALAMAT +
                    "','" + UNITAP.TELEPON +
                    "','" + UNITAP.FAXIMILE +
                    "','" + UNITAP.UNITUPI +
                    "','" + UNITAP.MANAGER +
                    "','" + UNITAP.KOTA + "')";

            CallableStatement cst;
            cst = con.prepareCall(sql);
            cst.execute();

            retValue.put("wsReturn", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> UpdateUNITAP(clsUNITAP UNITAP) {

        Map<String, Object> retValue = new HashMap<String, Object>();

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "UPDATE UNITAP SET " +
                    "SATUAN = '" + UNITAP.SATUAN + "', " +
                    "NAMA = '" + UNITAP.NAMA + "', " +
                    "ALAMAT = '" + UNITAP.ALAMAT + "', " +
                    "TELEPON = '" + UNITAP.TELEPON + "', " +
                    "FAXIMILE = '" + UNITAP.FAXIMILE + "', " +
                    "UNITUPI = '" + UNITAP.UNITUPI + "', " +
                    "MANAGER = '" + UNITAP.MANAGER + "', " +
                    "KOTA = '" + UNITAP.KOTA + "' " +
                    "WHERE UNITAP = '" + UNITAP.UNITAP + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);
            cst.execute();

            retValue.put("wsReturn", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
        }

        return retValue;
    }

    @Override
    public Map<String, Object> DeleteUNITAP(clsUNITAP UNITAP) {

        Map<String, Object> retValue = new HashMap<String, Object>();

        boolean errCode = true;
        String errMessage = "";

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "DELETE FROM UNITAP WHERE " +
                  "UNITAP = '" + UNITAP.UNITAP + "'";

            CallableStatement cst;
            cst = con.prepareCall(sql);
            cst.execute();

            retValue.put("wsReturn", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
        }

        return retValue;
    }


}
