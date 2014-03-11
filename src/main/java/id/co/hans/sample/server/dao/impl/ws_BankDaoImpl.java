package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.clsBANK;
import id.co.hans.sample.server.dao.ws_BankDao;
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
public class ws_BankDaoImpl implements ws_BankDao{

    public static final Log log = LogFactory.getLog(ws_BankDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private clsBANK clsBANK;


    @Override
    public Map<String, Object> GetBANK() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;

            String sql = "SELECT * FROM BANK";
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

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

    @Override
    public Map<String, Object> InsertBANK(clsBANK BANK) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "INSERT INTO BANK " +
                    "(KODE_RANTING, KODE_RANTING_NUMERIK, KODE_BANK, NAMA_BANK, " +
                    "ALAMAT, JENISBANK, KODE_GERAK_KELUAR, PENGELOLA, REKNO, BANK) " +
                    "VALUES " +
                    "('" + BANK.KODE_RANTING +
                    "','" + BANK.KODE_RANTING_NUMERIK +
                    "','" + BANK.KODE_BANK +
                    "','" + BANK.NAMA_BANK +
                    "','" + BANK.ALAMAT +
                    "','" + BANK.JENISBANK +
                    "','" + BANK.KODE_GERAK_KELUAR +
                    "','" + BANK.PENGELOLA +
                    "','" + BANK.REKNO +
                    "','" + BANK.BANK + "')";

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
    public Map<String, Object> UpdateBANK(clsBANK BANK) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "UPDATE BANK SET " +
                    "KODE_RANTING = '" + BANK.KODE_RANTING + "'," +
                    "KODE_RANTING_NUMERIK = '" + BANK.KODE_RANTING_NUMERIK + "'" +
                    "NAMA_BANK = '" + BANK.NAMA_BANK + "'" +
                    "ALAMAT = '" + BANK.ALAMAT + "'" +
                    "JENISBANK = '" + BANK.JENISBANK + "'" +
                    "KODE_GERAK_KELUAR = '" + BANK.KODE_GERAK_KELUAR + "'" +
                    "PENGELOLA = '" + BANK.PENGELOLA + "'" +
                    "REKNO = '" + BANK.REKNO + "'" +
                    "BANK = '" + BANK.BANK + "'" +
                    "WHERE KODE_BANK = '" + BANK.KODE_BANK + "' "
            ;

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
    public Map<String, Object> DeleteBANK(clsBANK BANK) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        String sql = "";
        Connection con;

        try
        {
            con = jdbcTemplate.getDataSource().getConnection();

            sql = "DELETE FROM BANK WHERE " +
                    "KODE_BANK = '" + BANK.KODE_BANK + "'";

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
