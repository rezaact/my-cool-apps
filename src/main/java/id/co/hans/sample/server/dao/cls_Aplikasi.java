package id.co.hans.sample.server.dao;

import id.co.hans.sample.server.dao.impl.ws_MenuDaoImpl;
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
import java.util.*;

@Service
public class cls_Aplikasi {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> cekBKSudahDibuat() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select hasil from view_cekloginbk " ;
            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.get(0).get(0).equals("0")) {
                throw new Exception("Gagal Login. Pembuatan BK Belum di-Cek untuk Hari ini.");
            }

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

    public Map<String, Object> login(String uname, String strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Map<String, Object> cekBk = cekBKSudahDibuat();

            if ((Boolean)cekBk.get("wsReturn") == false) {
                throw new Exception(cekBk.get("wsByRefError").toString());
            }

            //CEK VERSI SINGLE AGAR BACK DATE TIDAK BERFUNGSI LAGI
            if (strData.equals("") || !strData.equals("v.2.0.6")) {
                throw new Exception("Versi SIP3 yang anda gunakan sudah kadaluarsa, harap gunakan versi terbaru SIP 3. Versi terbaru SIP 3 adalah v.2.0.6, jika ada pertanyaan hubungi operator KD Dist. Jatim!");
            }

            Integer ROLEID = -1;
            strData = "";

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select KODEPETUGAS, NAMAPETUGAS, JENISKELAMIN, NIP, UNIT, PETUGAS.UNITUP, KODEPP, KASIRID, USERNAME, PASSWORD, ROLEID, NOSKNOTADINAS, SKFROMDATE, SKENDDATE, TGLCATAT, CATATBY, TGLUPDATE, UPDATEBY, RIGHTSLOGIN, RIGHTSLOGINBY, LOGINFROMDATE, LOGINTHRUDATE, LOGINPASSTRUE, HOSTNAME, HOSTID, MACADDRESS, " ;
            sql = sql + " nvl(unitup.nama,' ') as NAMAUNITUP from PETUGAS left join unitup on petugas.unitup = unitup.unitup where " ;
            sql = sql + " username = '" + uname + "' " ;
            sql = sql + " " ;
            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            ROLEID = Integer.parseInt(lMapData.get(0).get("ROLEID"));

            ws_MenuDaoImpl wsMenu = new ws_MenuDaoImpl();
            Map<String, Object> wsMenuData =  wsMenu.getRolesMenus(ROLEID);

            if (!wsMenuData.get("wsByRefError").equals("")) {
                throw new Exception(wsMenuData.get("wsByRefError").toString());
            }

            //todo: pembuatan wsStrXMLschema dan wsStrData
            retValue.put("wsReturn", lMapData);
            retValue.put("wsStrXMLschema", "xxxx");
            retValue.put("wsStrData", "xxxx");
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsStrXMLschema", "");
            retValue.put("wsStrData", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> getMasterUnit(String in_unitpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String unitupi = in_unitpetugas.substring(1,2);

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " SELECT * FROM UNITUPI " ;
            sql = sql + " WHERE UNITUPI = '" + unitupi + "'" ;
            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);
            retValue.put("wsReturn_UNITUPI", lMapData);


            sql = " SELECT DECODE(LENGTH(UNITAP),5,UNITAP,TRIM(UNITAP) || '  ') AS UNITAP,  ";
            sql = sql + "UNITUPI, SATUAN, NAMA, ALAMAT, TELEPON, FAXIMILE, MANAGER, KOTA  ";
            sql = sql + "FROM UNITAP  ";
            sql = sql + " WHERE UNITUPI = '" + unitupi + "' ";
            sql = sql + "ORDER BY UNITAP ";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);
            retValue.put("wsReturn_UNITAP", lMapData);


            sql = "SELECT * FROM UNITUP ";
            sql = sql + " WHERE UNITUP LIKE '" + unitupi + "%' ";
            sql = sql + "ORDER BY UNITAP,UNITUP ";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);
            retValue.put("wsReturn_UNITUP", lMapData);


            sql = "SELECT * FROM PAYMENTPOINT ORDER BY UNITUP,KODEPP ";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);
            retValue.put("wsReturn_PP", lMapData);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn_UNITUPI", "");
            retValue.put("wsReturn_UNITAP", "");
            retValue.put("wsReturn_UNITUP", "");
            retValue.put("wsReturn_PP", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> ubahPassword(String uname, String pwd) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "  update PETUGAS set ";
            sql = sql + " password = '" + pwd + "' ";
            sql = sql + " where ";
            sql = sql + " username = '" + uname + "' ";
            sql = sql + " ";

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

    public Map<String, Object> getunitap_user(String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " SELECT UNITAP FROM UNITUP WHERE UNITUP = '" + unitup + "'" ;
            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);
            retValue.put("wsReturn", lMapData);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }
}
