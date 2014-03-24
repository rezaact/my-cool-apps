package id.co.hans.sample.server.dao.impl;

import id.co.hans.sample.server.dao.MasterDao;
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
public class MasterDaoImpl implements MasterDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> getMasterUnit(String inTipe, String inValue) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "";
            if (inTipe.equals("UPI")){
                sql="select * from unitupi";
            }else if (inTipe.equals("UPIbyUPI")){
                sql="select * from unitupi where unitupi=?";
            }else if(inTipe.equals("APbyUPI")){
                sql="select * from unitap where unitupi=?";
            }else if(inTipe.equals("APbyAP")){
                sql="select * from unitap where unitap=?";
            }else if(inTipe.equals("UPbyAP")){
                sql="select * from unitup where unitap=?";
            }else if(inTipe.equals("UPbyUP")){
                sql="select * from unitup where unitup=?";
            }

            CallableStatement cst;
            cst = con.prepareCall(sql);

            if (!inTipe.equals("UPI")){
                cst.setString(1, inValue);
            }

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            if (lMapRecords.size() == 0) {
                retValue.put("wsReturn", null);
            } else {
                retValue.put("wsReturn", lMapRecords);
            }

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", null);
            retValue.put("wsByRefError", ex.getMessage());
        }
        return retValue;
    }

    @Override
    public Map<String, Object> getKodeSiklis(String parUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "";


            sql = "SELECT '" + parUp + "' as UNITUP,'SEMUA' AS KODESIKLIS, 'PERIODE' as PERIODE FROM DUAL ";
            sql += " UNION ALL ";
            sql += " SELECT * FROM (";
            sql += " SELECT UNITUP, KODESIKLIS, 'PERIODE' as PERIODE FROM TAB_JATUHTEMPO";
            sql += " WHERE "; //'''''THBL = '" + tTHBL + "' and";
            sql += " unitup =  ";
            sql += " '" + parUp + "'";
            sql += " group BY UNITUP,KODESIKLIS";
            sql += " ORDER BY KODESIKLIS";
            sql += " )";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            if (lMapRecords.size() == 0) {
                retValue.put("wsReturn", null);
            } else {
                retValue.put("wsReturn", lMapRecords);
            }

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", null);
            retValue.put("wsByRefError", ex.getMessage());
        }
        return retValue;
    }

    @Override
    public Map<String, Object> getKodePaymentPoint(String parUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "";


            sql = "SELECT * FROM PAYMENTPOINT ";
            sql += " WHERE "; //'''''THBL = '" + tTHBL + "' and";
            sql += " kode_ranting_numerik =  " + " '" + parUp + "'";
            sql += " ORDER BY UNITUP,KODEPP";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            if (lMapRecords.size() == 0) {
                retValue.put("wsReturn", null);
            } else {
                retValue.put("wsReturn", lMapRecords);
            }

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", null);
            retValue.put("wsByRefError", ex.getMessage());
        }
        return retValue;
    }

    @Override
    public Map<String, Object> getKodePetugas(String kodePP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "";


            sql = " SELECT ID_USER, NAMA_USER, UNITUP, KDPP ";
            sql += " FROM PETUGAS_2122OFFON ";
            sql += " where KDPP = '" + kodePP + "'";
            sql += " ORDER BY ID_USER";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            if (lMapRecords.size() == 0) {
                retValue.put("wsReturn", null);
            } else {
                retValue.put("wsReturn", lMapRecords);
            }

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", null);
            retValue.put("wsByRefError", ex.getMessage());
        }
        return retValue;
    }

    @Override
    public Map<String, Object> getDataKolektifGiralisasi(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "";

            if (unitUp.trim().equals(""))
                sql = " select kodekolektif,NAMAKOLEKTIF from kodekolektif21giralisasi WHERE TGLTHRU IS NULL order by kodekolektif ";
            else
                sql = " select kodekolektif,NAMAKOLEKTIF from kodekolektif21giralisasi WHERE TGLTHRU IS NULL and unitup = '" + unitUp + "' order by kodekolektif ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            if (lMapRecords.size() == 0) {
                retValue.put("wsReturn", null);
            } else {
                retValue.put("wsReturn", lMapRecords);
            }

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", null);
            retValue.put("wsByRefError", ex.getMessage());
        }
        return retValue;
    }

    @Override
    public Map<String, Object> getDataKolektifNotaBuku(String sUnitup, String IBEBANKANTOR) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "";

            sql = " select kodekolektif,NAMAKOLEKTIF from kodekolektif23nota WHERE TGLTHRU IS NULL AND UNITUP='" + sUnitup + "' AND BEBANKANTOR=" + IBEBANKANTOR + " order by kodekolektif ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            if (lMapRecords.size() == 0) {
                retValue.put("wsReturn", null);
            } else {
                retValue.put("wsReturn", lMapRecords);
            }

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", null);
            retValue.put("wsByRefError", ex.getMessage());
        }
        return retValue;
    }

    @Override
    public Map<String, Object> getDataKolektifNotaTerpusat(String sUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "";

            sql = " select kodekolektif,NAMAKOLEKTIF from kodekolektif23notaTERpusat WHERE TGLTHRU IS NULL AND UNITUP='" + sUnitup + "' order by kodekolektif ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            if (lMapRecords.size() == 0) {
                retValue.put("wsReturn", null);
            } else {
                retValue.put("wsReturn", lMapRecords);
            }

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", null);
            retValue.put("wsByRefError", ex.getMessage());
        }
        return retValue;
    }
}
