package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.clsUNITUPI;
import id.co.hans.sample.server.dao.ws_UnitupiDao;
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
public class ws_UnitupiDaoImpl implements ws_UnitupiDao {

    public static final Log log = LogFactory.getLog(ws_UnitupiDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> GetUNITUPI() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SELECT * FROM UNITUPI";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("UNITUPI", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;
    }

    @Override
    public String InsertUNITUPI(clsUNITUPI UNITUPI) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        boolean errCode = true;
        String errMessage = "";

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "INSERT INTO UNITUPI " +
            "(UNITUPI, SATUAN, NAMA, ALAMAT, TELEPON, FAXIMILE, MANAGER, KOTA) " +
            "VALUES " +
            "('" + UNITUPI.UNITUPI +
            "','" + UNITUPI.SATUAN +
            "','" + UNITUPI.NAMA +
            "','" + UNITUPI.ALAMAT +
            "','" + UNITUPI.TELEPON +
            "','" + UNITUPI.FAXIMILE +
            "','" + UNITUPI.MANAGER +
            "','" + UNITUPI.KOTA + "')";

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

        retValue.put("out_return", errCode);
        retValue.put("out_message", errMessage);

//        return retValue;
        return errMessage;
    }

    @Override
    public String UpdateUNITUPI(clsUNITUPI UNITUPI) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        boolean errCode = true;
        String errMessage = "";

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "UPDATE UNITUPI SET " +
            "SATUAN = '" + UNITUPI.SATUAN + "'," +
            "NAMA = '" + UNITUPI.NAMA + "'," +
            "ALAMAT = '" + UNITUPI.ALAMAT + "'," +
            "TELEPON = '" + UNITUPI.TELEPON + "'," +
            "FAXIMILE = '" + UNITUPI.FAXIMILE + "'," +
            "MANAGER = '" + UNITUPI.MANAGER + "'," +
            "KOTA = '" + UNITUPI.KOTA + "' " +
            "WHERE UNITUPI = '" + UNITUPI.UNITUPI + "' "
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

        retValue.put("out_return", errCode);
        retValue.put("out_message", errMessage);

//        return retValue;
        return errMessage;
    }

    @Override
    public String DeleteUNITUPI(clsUNITUPI UNITUPI) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        boolean errCode = true;
        String errMessage = "";

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "DELETE FROM UNITUPI WHERE " +
            "UNITUPI = '" + UNITUPI.UNITUPI + "'";

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

        retValue.put("out_return", errCode);
        retValue.put("out_message", errMessage);

//        return retValue;
        return errMessage;
    }
    }
