package id.co.hans.sample.server.dao;

import id.co.hans.sample.server.utility.CommonModule;
import oracle.jdbc.OracleTypes;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class cls_Package_View {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> get_Koreksi_TampilForm_ABC(String idpel,
                                                          String blth,
                                                          String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call PKG_VIEW_TAMPILFORM.NEW_12ABC_TAMPILFORM(?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.setString("vIDPEL", idpel);
            cst.setString("vBLTH", blth);
            cst.setString("vPETUGAS", petugas);
            cst.registerOutParameter("OUT_DATA", OracleTypes.CURSOR);
            cst.execute();

            ResultSet rs = (ResultSet)cst.getObject("OUT_DATA");

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> get_Koreksi_TampilForm_DE(String idpel,
                                                          String blth,
                                                          String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call PKG_VIEW_TAMPILFORM.NEW_12DE_TAMPILFORM(?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.setString("vIDPEL", idpel);
            cst.setString("vBLTH", blth);
            cst.setString("vPETUGAS", petugas);
            cst.registerOutParameter("OUT_DATA", OracleTypes.CURSOR);
            cst.execute();

            ResultSet rs = (ResultSet)cst.getObject("OUT_DATA");

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    public Map<String, Object> get_BatalPiutang_TampilForm(String idpel,
                                                         String blth,
                                                         String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call PKG_VIEW_TAMPILFORM.NEW_31_TAMPILFORM(?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.setString("vIDPEL", idpel);
            cst.setString("vBLTH", blth);
            cst.setString("vPETUGAS", petugas);
            cst.registerOutParameter("OUT_DATA", OracleTypes.CURSOR);
            cst.execute();

            ResultSet rs = (ResultSet)cst.getObject("OUT_DATA");

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }
}
