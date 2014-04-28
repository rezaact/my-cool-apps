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
    public Map<String, Object> getMasterUser(String idUser) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        //leveluser = PUSAT, UPI, AP, UP, VENDOR, (null)

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "select * from secman.usertab where id_user = ?";
            CallableStatement cst = con.prepareCall(sql);
            cst.setString(1, idUser);

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
    public Map<String, Object> getMasterUnit(String inTipe, String userUnit, String selectedUnit) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        //leveluser = PUSAT, UPI, AP, UP, VENDOR, (null)

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "select * from dual";
            CallableStatement cst = con.prepareCall(sql);

            //get UPI
            if (inTipe.toUpperCase().equals("UPI_BY_PUSAT")){
                sql = "select * from unitupi";
                cst = con.prepareCall(sql);
            }else if (inTipe.toUpperCase().equals("UPI_BY_UPI")){
                sql = "select * from unitupi where unitupi=?";
                cst = con.prepareCall(sql);
                cst.setString(1, userUnit);
            }else if (inTipe.toUpperCase().equals("UPI_BY_AP")){
                sql = "";
                sql+= "select * from unitupi upi";
                sql+= " where upi.unitupi = ";
                sql+= "  (";
                sql+= "    select ap.unitupi ";
                sql+= "      from unitap ap";
                sql+= "     where ap.unitap = ?";
                sql+= "  )";
                cst = con.prepareCall(sql);
                cst.setString(1, userUnit);
            }else if (inTipe.toUpperCase().equals("UPI_BY_UP")){
                sql = "";
                sql+= "select * from unitupi upi ";
                sql+= " where upi.unitupi = ";
                sql+= "  (";
                sql+= "    select ap.unitupi ";
                sql+= "      from unitap ap ";
                sql+= "     where ap.unitap = ";
                sql+= "      (";
                sql+= "        select up.unitap ";
                sql+= "          from unitup up ";
                sql+= "         where up.unitup = ? ";
                sql+= "      ) ";
                sql+= "  ) ";
                cst = con.prepareCall(sql);
                cst.setString(1, userUnit);
            }

            //get AP
            else if(inTipe.toUpperCase().equals("AP_BY_PUSAT")){
                sql = "";
                sql+="select * from unitap where unitupi=?";
                cst = con.prepareCall(sql);
                cst.setString(1, selectedUnit);
            }else if(inTipe.toUpperCase().equals("AP_BY_UPI")){
                sql = "";
                sql+="select * from unitap where unitupi=?";
                cst = con.prepareCall(sql);
                cst.setString(1, selectedUnit);
            }else if(inTipe.toUpperCase().equals("AP_BY_AP")){
                sql = "";
                sql+="select * from unitap where unitupi=? and unitap=?";
                cst = con.prepareCall(sql);
                cst.setString(1, selectedUnit);
                cst.setString(2, userUnit);
            }else if(inTipe.toUpperCase().equals("AP_BY_UP")){
                sql = "";
                sql+="select * from unitap ap ";
                sql+="  where ap.unitupi = ?";
                sql+="        and ap.unitap = ";
                sql+="          (";
                sql+="            select up.unitap ";
                sql+="              from unitup up";
                sql+="             where up.unitup = ?";
                sql+="          )";
                cst = con.prepareCall(sql);
                cst.setString(1, selectedUnit);
                cst.setString(2, userUnit);
            }

            //get UP
            else if(inTipe.toUpperCase().equals("UP_BY_PUSAT")){
                sql = "";
                sql+="select * from unitup where unitap = ?";
                cst = con.prepareCall(sql);
                cst.setString(1, selectedUnit);
            }else if(inTipe.toUpperCase().equals("UP_BY_UPI")){
                sql = "";
                sql+="select * from unitup where unitap = ?";
                cst = con.prepareCall(sql);
                cst.setString(1, selectedUnit);
            }else if(inTipe.toUpperCase().equals("UP_BY_AP")){
                sql = "";
                sql+="select * from unitup where unitap = ?";
                cst = con.prepareCall(sql);
                cst.setString(1, selectedUnit);
            }else if(inTipe.toUpperCase().equals("UP_BY_UP")){
                sql = "";
                sql+="select * from unitup where unitap = ? and unitup = ?";
                cst = con.prepareCall(sql);
                cst.setString(1, selectedUnit);
                cst.setString(2, userUnit);
            }

            //khusus combounit
            else if(inTipe.toUpperCase().equals("UP_BY_COMBOUP")){
                sql = "";
                sql+="select * from unitup where unitup = ?";
                cst = con.prepareCall(sql);
                cst.setString(1, userUnit);
            }

            //get untuk laporan
            else if(inTipe.toUpperCase().equals("UPI_BY_REPORT")){
                sql = "";
                sql+="select * from unitupi where unitupi = ?";
                cst = con.prepareCall(sql);
                cst.setString(1, selectedUnit);
            }else if(inTipe.toUpperCase().equals("AP_BY_REPORT")){
                sql = "";
                sql+="select * from unitap where unitap = ?";
                cst = con.prepareCall(sql);
                cst.setString(1, selectedUnit);
            }else if(inTipe.toUpperCase().equals("UP_BY_REPORT")){
                sql = "";
                sql+="select * from unitup where unitup = ?";
                cst = con.prepareCall(sql);
                cst.setString(1, selectedUnit);
            }

            CommonModule.getLogger(this).info("sql :: " + sql);

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
    public Map<String, Object> getKodeSiklis(String parUp, String parTHBL) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "";


//            sql = "SELECT '" + parUp + "' as UNITUP,'SEMUA' AS KODESIKLIS, 'PERIODE' as PERIODE FROM DUAL ";
//            sql += " UNION ALL ";
//            sql += " SELECT * FROM (";
//            sql += " SELECT UNITUP, KODESIKLIS, 'PERIODE' as PERIODE FROM TAB_JATUHTEMPO";
//            sql += " WHERE "; //'''''THBL = '" + tTHBL + "' and";
//            sql += " unitup =  ";
//            sql += " '" + parUp + "'";
//            sql += " group BY UNITUP,KODESIKLIS";
//            sql += " ORDER BY KODESIKLIS";
//            sql += " )";

            sql = "SELECT UNITAP, UNITUP, KDPROSESKLP KDSIKLIS, TGLBAYAR_AWAL, TGLBAYAR_AKHIR, KETPROSESKLP, KETPROSESKLP|| ' periode bayar ' || TGLBAYAR_AWAL || ' s/d ' || TGLBAYAR_AKHIR AS PERIODE FROM V_BILL_TABPROSES ";
            sql += " WHERE THBLREK = '" + parTHBL + "'";
            sql += " and unitup =  ";
            sql += " '" + parUp + "'";
            sql += " and AKTIF = '1' ";
            sql += " ORDER BY KDPROSESKLP";

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
    public Map<String, Object> getKodePaymentPoint(String parUp, String jenisPP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "";


            sql = "SELECT UNITKJ, UNITUP, KODEPP, NAMAPP FROM PAYMENTPOINT ";
            sql += " WHERE ";

            if (jenisPP.equals("MANUAL")) {
                sql += " JENISPP = 'MANUAL'";
            } else if (jenisPP.equals("OFFLINE")) {
                sql += " JENISPP = 'OFFLINE'";
            } else if (jenisPP.equals("ONLINE")) {
                sql += " JENISPP = 'ONLINE'";
            }

            sql += " and kode_ranting_numerik =  " + " '" + parUp + "'";
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


    @Override
    public Map<String, Object> getKodeProses(String parUp, String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "";


            sql = " SELECT UNITAP, UNITUP, KDPROSESKLP KDSIKLIS, TGLBAYAR_AWAL, TGLBAYAR_AKHIR, KETPROSESKLP, KETPROSESKLP|| ' periode bayar ' || TGLBAYAR_AWAL || ' s/d ' || TGLBAYAR_AKHIR AS PERIODE FROM V_BILL_TABPROSES ";
            sql += " WHERE THBLREK = '" + blth + "' ";
            sql += " and unitup = '" + parUp + "' ";
            sql += " and AKTIF =  '1' ";
            sql += " ORDER BY KDPROSESKLP";

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
