package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.ws_tul6generalDao;
import id.co.hans.sample.server.utility.CommonModule;
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
public class ws_Tul6generalDaoImpl implements ws_tul6generalDao{
    public static final Log log = LogFactory.getLog(ws_Tul6generalDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> ambilTanggalDatabase() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select sysdate from dual ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords.get(0).get(0));

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }

    @Override
    public  Map<String, Object> ambilUnitUp() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql;
            sql = " select unitup from unitup order by unitup ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }

    @Override
    public Map<String, Object> isicbUnitup(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql;
            sql = " select unitup from unitup where unitap = (select unitap from unitup where unitup = '" + unitUp + "') order by unitup ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> ambilNamaUp(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql;
            sql = " select nama from unitup where unitup = '" + unitUp + "' ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords.get(0).get(0));

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> ambilKota(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql;
            sql = " select kota from unitup where unitup = '" + unitUp + "' ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords.get(0).get(0));

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> ambilPejabat(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql;
            sql =" select manager from unitup where unitup = '" + unitUp + "' ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords.get(0).get(0));

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> ambilNamaApdariUp(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql;

            sql = "  select nama from unitap where unitap = ";
            sql = sql + "  (";
            sql = sql + "  select unitap from unitup";
            sql = sql + "  where unitup = '" + unitUp + "' ";
            sql = sql + "  )";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords.get(0).get(0));

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> ambilNamaKddariUp(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql;
            sql = "  select nama from unitupi where unitupi =";
            sql = sql + "  (";
            sql = sql + "  select unitupi from unitap where unitap = ";
            sql = sql + "  (";
            sql = sql + "  select unitap from unitup";
            sql = sql + "  where unitup = '" + unitUp + "' ";
            sql = sql + "  )";
            sql = sql + "  )";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords.get(0).get(0));

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> ambilAlamatdariUp(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql;
            sql = " select alamat from unitup where unitup = '" + unitUp + "' ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords.get(0).get(0));

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> ambilKodeKolektif() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="SELECT KODEKOLEKTIF FROM tab_NAMAKOLEKTIF ORDER BY KODEKOLEKTIF";
            sql = " select distinct kodekolektif from view_kolektifwaskit order by kodekolektif";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> ambilKodePaymentPoint(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="SELECT kodepp,namapp FROM payment_point where kode_ranting_numerik='" + unitUp + "' ORDER BY kodepp";
            sql = " select kodepp, namapp from paymentpointbaru where unitup = '" + unitUp + "' ORDER BY kodepp ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> ambilKodeSiklis(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" SELECT DISTINCT KELOMPOK_BAYAR FROM V_DIL ORDER BY KELOMPOK_BAYAR";
            sql = " select distinct kodesiklis from tab_jatuhtempo order by kodesiklis ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }
}
