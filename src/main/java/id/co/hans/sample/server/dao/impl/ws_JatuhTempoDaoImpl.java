package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.clsJatuhTempo;
import id.co.hans.sample.server.dao.ws_JatuhTempoDao;
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
public class ws_JatuhTempoDaoImpl implements ws_JatuhTempoDao{

    public static final Log log = LogFactory.getLog(ws_JatuhTempoDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> GetJatuhTempo() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SELECT * FROM TAB_JATUHTEMPO";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;
    }

    @Override
    public Map<String, Object> InsertJatuhTempo(clsJatuhTempo JatuhTempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        boolean errCode = true;
        String errMessage = "";

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "INSERT INTO TAB_JATUHTEMPO " +
                    "(UNITUP, KODESIKLIS, PERIODE, THBL, JATUHTEMPO, BK1, BK2, BK3, CREATEDON, CREATEBY) " +
                    "VALUES ('" + JatuhTempo.UNITUP + "','" + JatuhTempo.KODESIKLIS +
                    "','" + JatuhTempo.PERIODE + "','" + JatuhTempo.THBL + "'," +
                    "TO_DATE('" + JatuhTempo.JATUHTEMPO +"','yyyy/MM/dd')," +
                    "TO_DATE('" + JatuhTempo.BK1 + "','yyyy/MM/dd'), " +
                    "TO_DATE('" + JatuhTempo.BK2 + "','yyyy/MM/dd'), " +
                    "TO_DATE('" + JatuhTempo.BK3 + "','yyyy/MM/dd'), " +
                    "TO_DATE('" + JatuhTempo.CREATEDON + "','yyyy/MM/dd'), " +
                    "','" +JatuhTempo.CREATEBY + "')";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            try{
                cst.execute();

                errMessage = "";
            } catch (Exception ex){
                errMessage = ex.getMessage();
            }

            con.close();
        } catch (Exception ex)
        {
            errMessage = ex.getMessage();
        }

        retValue.put("wsReturn", errMessage);

        return retValue;
    }

    @Override
    public Map<String, Object> UpdateJatuhTempo(clsJatuhTempo JatuhTempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        boolean errCode = true;
        String errMessage = "";

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "UPDATE TAB_JATUHTEMPO SET " +
                    "PERIODE = '" + JatuhTempo.PERIODE + "'," +
                    "JATUHTEMPO = TO_DATE('" + JatuhTempo.JATUHTEMPO + "','yyyy/MM/dd HH24miss') , " +
                    "BK1 = TO_DATE('" + JatuhTempo.BK1 + "','yyyy/MM/dd HH24miss') , " +
                    "BK2 = TO_DATE('" + JatuhTempo.BK2 + "','yyyy/MM/dd HH24miss') , " +
                    "BK3 = TO_DATE('" + JatuhTempo.BK3 + "','yyyy/MM/dd HH24miss') " +
                    "WHERE UNITUP = '" + JatuhTempo.UNITUP + "' AND THBL = '" + JatuhTempo.THBL + "' AND KODESIKLIS = '" + JatuhTempo.KODESIKLIS + "'"
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

//        return retValue;
        return retValue;
    }

    @Override
    public Map<String, Object> DeleteJatuhTempo(clsJatuhTempo JatuhTempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        boolean errCode = true;
        String errMessage = "";

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "DELETE FROM TAB_JATUHTEMPO WHERE " +
                    "UNITUP = '" + JatuhTempo.UNITUP + "' AND " +
                    "KODESIKLIS = '" + JatuhTempo.KODESIKLIS + "'AND " +
                    "JATUHTEMPO =  TO_DATE('" + JatuhTempo.JATUHTEMPO + "','yyyy/MM/dd HH24miss')";

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

//        return retValue;
        return retValue;
    }

}
