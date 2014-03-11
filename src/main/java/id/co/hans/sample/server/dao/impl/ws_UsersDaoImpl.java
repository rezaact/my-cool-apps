package id.co.hans.sample.server.dao.impl;

import com.google.web.bindery.requestfactory.shared.ServiceName;
import id.co.hans.sample.server.dao.clsUsers;
import id.co.hans.sample.server.dao.ws_UsersDao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.co.hans.sample.server.utility.CommonModule;
import oracle.jdbc.OracleTypes;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ws_UsersDaoImpl implements ws_UsersDao {

    public static final Log log = LogFactory.getLog(ws_UsersDaoImpl.class);

    @Autowired
    private JdbcTemplate  jdbcTemplate;

    @Override
    public Map<String, Object> GetPetugas() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SELECT * FROM PETUGAS";
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
    public Map<String, Object> getPengelola() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SELECT * FROM PENGELOLA ORDER BY KODEPENGELOLA";
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
    public Map<String, Object> ubahPengelola(Integer jnstrans, String kode, String nama, String alamat, String notelp) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        boolean errCode = true;
        String errMessage = "";

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            if(jnstrans == 0){
                sql = "INSERT INTO SIP3SINGLE.PENGELOLA (KODEPENGELOLA, PENGELOLA, ALAMAT, TELPPENGELOLA) VALUES (" +
                        "'" + kode + "','" + nama + "','" + alamat + "','" + notelp + "')";
            } else if(jnstrans == 1) {
                sql = " UPDATE PENGELOLA " +
                        " SET PENGELOLA='" + nama + "'," +
                        "     ALAMAT='" + alamat + "'," +
                        "     TELPPENGELOLA='" + notelp + "'" +
                        " WHERE KODEPENGELOLA='" + kode + "'";
            }

            CallableStatement cst;
            cst = con.prepareCall(sql);
            cst.execute();

            retValue.put("wsReturn", true);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    @Override
    public Map<String, Object> InsertPetugas(clsUsers Users) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        boolean errCode = true;
        String errMessage = "";

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "insert into PETUGAS " +
                    "(KODEPETUGAS, NAMAPETUGAS, KODEPP, PASSWORD, ROLEID, UNITUP, ALAMAT) " +
                    "values ('" + Users.KODEPETUGAS + "','" + Users.NAMAPETUGAS +
                    "','" + Users.KODEPP + "','" + Users.PASSWORD + "'," + Users.ROLEID.toString() +
                    ",'" + Users.UNITUP + "','" + Users.ALAMAT + "')";

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
    public Map<String, Object> UpdatePetugas(clsUsers Users) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        boolean errCode = true;
        String errMessage = "";

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "update PETUGAS set " +
                    "NAMAPETUGAS = '" + Users.NAMAPETUGAS +
                    "', KODEPP = '" + Users.KODEPP +
                    "', PASSWORD = '" + Users.PASSWORD +
                    "', ROLEID = " + Users.ROLEID.toString() +
                    ", UNITUP = '" + Users.UNITUP +
                    "', ALAMAT = '" + Users.ALAMAT + "'" +
                    " Where KODEPETUGAS = '" + Users.KODEPETUGAS + "'";

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
    public Map<String, Object> DeletePetugas(String KodePetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        boolean errCode = true;
        String errMessage = "";

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "Delete PETUGAS where KODEPETUGAS = '" + KodePetugas + "'";

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
