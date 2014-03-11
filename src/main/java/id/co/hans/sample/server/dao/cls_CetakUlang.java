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
import java.util.*;

@Service
public class cls_CetakUlang {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> getCetul_21Giralisasi(String strPetugas,
                                                     String sKodeKolektif,
                                                     String sTglLunas,
                                                     String sKDPP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetKODEPP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, sKDPP);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetTGLBAYAR(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, sTglLunas);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetKODEKOLEKTIF(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, sKodeKolektif);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, strPetugas);
            cst.execute();



            sql = "SELECT 0 AS TANDA,A.* from VIEW_CETAK303_LUNASGIRAL A ";
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

    public Map<String, Object> getCetul_23NotaBuku(String strPetugas,
                                                   String sKodeKolektif,
                                                   String sTglLunas,
                                                   String tUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetTGLBAYAR(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, sTglLunas);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetKODEKOLEKTIF(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, sKodeKolektif);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, strPetugas);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetUNITUP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tUnitup);
            cst.execute();



            sql = "SELECT 0 AS TANDA,A.* from VIEW_CEKUL303_LUNASNOTA A ";
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

    public Map<String, Object> getCetul_23Terpusat(String strPetugas,
                                                   String sKodeKolektif,
                                                   String sTglLunas,
                                                   String tUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetTGLBAYAR(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, sTglLunas);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetKODEKOLEKTIF(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, sKodeKolektif);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, strPetugas);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetUNITUP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tUnitup);
            cst.execute();



            sql = "SELECT 0 AS TANDA,A.* from VIEW_CETUL303_LUNASTERPUSAT A ";
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


    public Map<String, Object> SetCetul_21Giralisasi(Map<String, Object> dsTrans) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;
            ResultSet rs;

            List<Map<String, String>> dsFilter = (List<Map<String, String>>)dsTrans.get("FILTER");
            if (dsFilter.get(0).get("JENISCETUL") != "LUNASGIRAL") {
                throw new Exception("Jenis cetak ulang tidak sesuai !");
            }

            List<Map<String, String>> dsResult = (List<Map<String, String>>)dsTrans.get("DAFTAR");
            for (Map<String,String> dRow : dsResult) {
                if (dRow.get("TANDA") == "1") {
                    sql = "{ call Proc_Cetakurekg_21GIRAL(?,?,?,?,?,?,?,?,?,?) }";
                    cst = con.prepareCall(sql);
                    cst.registerOutParameter("V_HASIL", OracleTypes.NVARCHAR);
                    cst.setString("V_TRANSAKSIBY", dsFilter.get(0).get("PETUGAS"));
                    cst.setString("V_ALASANCETAKULANG", dsFilter.get(0).get("ALASAN"));
                    cst.setString("V_IDPEL", dRow.get("IDPEL"));
                    cst.setString("V_BLTH", dRow.get("BLTH"));
                    cst.setString("v_KDPEMBPP", dRow.get("KDPEMBPP"));
                    cst.setString("v_NOREK", dRow.get("NOREK"));
                    cst.setString("V_KDGERAKKELUAR", dRow.get("KDGERAKKELUAR"));
                    cst.setString("V_TGLBAYAR", dRow.get("TGLBAYAR"));
                    cst.setString("V_KDPP", dRow.get("KDPP"));
                    cst.execute();

                    dRow.put("hasil", cst.getString("V_HASIL"));
                }
            }

            retValue.put("wsReturn", dsResult);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetCetul_23NotaBuku(Map<String, Object> dsTrans) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;
            ResultSet rs;

            List<Map<String, String>> dsFilter = (List<Map<String, String>>)dsTrans.get("FILTER");
            if (dsFilter.get(0).get("JENISCETUL") != "LUNASNOTABUKU") {
                throw new Exception("Jenis cetak ulang tidak sesuai !");
            }

            List<Map<String, String>> dsResult = (List<Map<String, String>>)dsTrans.get("DAFTAR");
            for (Map<String,String> dRow : dsResult) {
                if (dRow.get("TANDA") == "1") {
                    sql = "{ call Proc_Cetakurekg_23NOTABUKU(?,?,?,?,?,?,?,?,?,?) }";
                    cst = con.prepareCall(sql);
                    cst.registerOutParameter("V_HASIL", OracleTypes.NVARCHAR);
                    cst.setString("V_TRANSAKSIBY", dsFilter.get(0).get("PETUGAS"));
                    cst.setString("V_ALASANCETAKULANG", dsFilter.get(0).get("ALASAN"));
                    cst.setString("V_IDPEL", dRow.get("IDPEL"));
                    cst.setString("V_BLTH", dRow.get("BLTH"));
                    cst.setString("v_KDPEMBPP", dRow.get("KDPEMBPP"));
                    cst.setString("v_NOREK", dRow.get("NOREK"));
                    cst.setString("V_KDGERAKKELUAR", dRow.get("KDGERAKKELUAR"));
                    cst.setString("V_TGLBAYAR", dRow.get("TGLBAYAR"));
                    cst.setString("V_KDPP", dRow.get("KDPP"));
                    cst.execute();

                    dRow.put("hasil", cst.getString("V_HASIL"));
                }
            }

            retValue.put("wsReturn", dsResult);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetCetul_23Terpusat(Map<String, Object> dsTrans) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;
            ResultSet rs;

            List<Map<String, String>> dsFilter = (List<Map<String, String>>)dsTrans.get("FILTER");
            if (dsFilter.get(0).get("JENISCETUL") != "LUNASTERPUSAT") {
                throw new Exception("Jenis cetak ulang tidak sesuai !");
            }

            List<Map<String, String>> dsResult = (List<Map<String, String>>)dsTrans.get("DAFTAR");
            for (Map<String,String> dRow : dsResult) {
                if (dRow.get("TANDA") == "1") {
                    sql = "{ call Proc_Cetakurekg_23TERPUSAT(?,?,?,?,?,?,?,?,?,?) }";
                    cst = con.prepareCall(sql);
                    cst.registerOutParameter("V_HASIL", OracleTypes.NVARCHAR);
                    cst.setString("V_TRANSAKSIBY", dsFilter.get(0).get("PETUGAS"));
                    cst.setString("V_ALASANCETAKULANG", dsFilter.get(0).get("ALASAN"));
                    cst.setString("V_IDPEL", dRow.get("IDPEL"));
                    cst.setString("V_BLTH", dRow.get("BLTH"));
                    cst.setString("v_KDPEMBPP", dRow.get("KDPEMBPP"));
                    cst.setString("v_NOREK", dRow.get("NOREK"));
                    cst.setString("V_KDGERAKKELUAR", dRow.get("KDGERAKKELUAR"));
                    cst.setString("V_TGLBAYAR", dRow.get("TGLBAYAR"));
                    cst.setString("V_KDPP", dRow.get("KDPP"));
                    cst.execute();

                    dRow.put("hasil", cst.getString("V_HASIL"));
                }
            }

            retValue.put("wsReturn", dsResult);
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
