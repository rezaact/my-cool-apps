package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.clsKODE_GERAK;
import id.co.hans.sample.server.dao.ws_KodeGerakDao;
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
public class ws_KodeGerakDaoImpl implements ws_KodeGerakDao{

    public static final Log log = LogFactory.getLog(ws_KodeGerakDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> GetKODE_GERAK() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SELECT * FROM KODE_GERAK";
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
    public Map<String, Object> InsertKODE_GERAK(clsKODE_GERAK KODE_GERAK) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        boolean errCode = true;
        String errMessage = "";

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "INSERT INTO KODE_GERAK " +
                    "(KDGERAK, KETERANGAN, GERAKPIUTANG) " +
                    "VALUES " +
                    "('" + KODE_GERAK.KODE_GERAK +
                    "','" + KODE_GERAK.KETERANGAN +
                    "','" + KODE_GERAK.GERAK_PIUTANG + "')";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            try{
                cst.execute();

                errCode = false;
                errMessage = "";
            } catch (Exception ex){
                errCode = true;
                errMessage = ex.getMessage();
            }

            con.close();
        } catch (Exception ex)
        {
            errCode = true;
            errMessage = ex.getMessage();
        }

        retValue.put("wsReturn", errMessage);
        retValue.put("wsByRefError", errMessage);

        return retValue;
    }


    @Override
    public Map<String, Object> UpdateKODE_GERAK(clsKODE_GERAK KODE_GERAK) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        boolean errCode = true;
        String errMessage = "";

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "UPDATE KODE_GERAK SET " +
            "KETERANGAN = '" + KODE_GERAK.KETERANGAN + "'," +
            "GERAKPIUTANG = '" + KODE_GERAK.GERAK_PIUTANG + "'" +
            "WHERE KDGERAK = '" + KODE_GERAK.KODE_GERAK + "' "
            ;

            CallableStatement cst;
            cst = con.prepareCall(sql);

            try{
                cst.execute();

                errCode = false;
                errMessage = "";
            } catch (Exception ex){
                errCode = true;
                errMessage = ex.getMessage();
            }

            con.close();
        } catch (Exception ex)
        {
            errCode = true;
            errMessage = ex.getMessage();
        }

        retValue.put("wsReturn", errMessage);
        retValue.put("wsByRefError", errMessage);

        return retValue;
    }

    @Override
    public Map<String, Object> DeleteKODE_GERAK(clsKODE_GERAK KODE_GERAK) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        boolean errCode = true;
        String errMessage = "";

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "DELETE FROM KODE_GERAK WHERE " +
            "KDGERAK = '" + KODE_GERAK.KODE_GERAK + "'";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            try{
                cst.execute();

                errCode = false;
                errMessage = "";
            } catch (Exception ex){
                errCode = true;
                errMessage = ex.getMessage();
            }

            con.close();
        } catch (Exception ex)
        {
            errCode = true;
            errMessage = ex.getMessage();
        }

        retValue.put("wsReturn", errMessage);
        retValue.put("wsByRefError", errMessage);

        return retValue;
    }
}
