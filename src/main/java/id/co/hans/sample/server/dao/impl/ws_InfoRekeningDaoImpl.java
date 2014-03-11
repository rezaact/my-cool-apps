package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.ws_InfoRekeningDao;
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
public class ws_InfoRekeningDaoImpl implements ws_InfoRekeningDao {
    public static final Log log = LogFactory.getLog(ws_InfoRekeningDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> ambilDilWhere(String sqlWhere) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select distinct idpel,nopel,kddk,nama,namapnj,kogol,tarip,daya from dpp where 0=0 ";
            sql = sqlWhere;
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

    // #Region "view info"
    @Override
    public Map<String, Object> getPiutangInfo(String[] clsAR, String strXMLschema) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        retValue.put("wsReturn", "");
        return retValue;
    }
    // #End Region


    @Override
    public Map<String, Object> cariIdPelDIL(String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "select IDPEL from DPP where IDPEL = '" + idpel + "'";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            if (lMapRecords.size() > 0) {
                retValue.put("wsReturn", true);
            } else {
                retValue.put("wsReturn", false);
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
        }
        return retValue;
    }

    @Override
    public Map<String, Object> cariIdPelDIS(String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "select IDPEL from DPP where IDPEL = '" + idpel + "'";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            if (lMapRecords.size() > 0) {
                retValue.put("wsReturn", true);
            } else {
                retValue.put("wsReturn", false);
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
        }
        return retValue;
    }

    @Override
    public Map<String, Object> ambilDil(String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select DPP.NOPEL AS no_kontrak, DPP.IDPEL AS no_pelanggan, DPP.NAMA AS nama_pelanggan, DPP.NAMAPNJ AS nama_jalan, DPP.TARIP AS tarip, DPP.DAYA AS daya, ";
            sql = sql + " DPP.KDPP AS kodepp, DPP.KOGOL AS kode_golongan, DPP.PNJ AS kelompok_bayar, DPP.KDDK AS no_kontrol, DPP.UNITUP AS kode_ranting_numerik,";
            sql = sql + " RR.NAMA_RANTING AS nama_ranting, '' AS periode  ";
            sql = sql + " from DPP,rantingrayon RR ";
            sql = sql + " where DPP.IDPEL = '" + idpel + "' and rownum = 1 ";
            sql = sql + " and dpp.unitup = rr.kode_ranting_numerik ";
            sql = sql + " order by to_date(blth,'mmyyyy') desc ";

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
    public Map<String, Object> ambilDis1(String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "select to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') as Bulan, RPTAG as Tagihan, ";
            sql += " TO_DATE(TGLBAYAR,'DDMMYYYY') AS tgl_pelunasan, KDPEMBAYAR as Petugas,decode(KDGERAKMASUK,'11','Lancar','41','DUPR','12','Koreksi','13','Batal') Status, '' AS Kirim, '' AS Terima from DPP";
            sql += " where DPP.IDPEL ='" + idpel + "'";
            sql += " order by to_date(BLTH,'MMYYYY') desc";

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
    public Map<String, Object> ambilDis2(String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select count(distinct BLTH) as Lembar, sum(RPTAG)+sum(rpbk1+rpbk2+rpbk3) as Rupiah ";
            sql += " from DPP ";
            sql += " where TGLBAYAR is null and IDPEL = '" + idpel + "'";

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
    public Map<String, Object> ambilDis3(String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select sum(RPTAG) as rupiah from DPP ";
            sql += " where TGLBAYAR is null ";
            sql += " and idpel = '" + idpel + "' ";

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
    public Map<String, Object> ambilDis4(String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " SELECT sum(RPPTL) AS RPREK, sum(RPBK1)+sum(RPBK2)+sum(RPBK3) AS RPBK ";
            sql += " FROM DPP WHERE ";
            sql += " IDPEL = '" + idpel + "' AND TGLBAYAR IS NULL ";

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
    public Map<String, Object> ambilDis5(String idpel, String bulanrek, String kdgerak) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql;
            sql = " SELECT to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') AS BULAN, 'a. Rp Biaya Beban' as nmpiutang, RPBEBAN as Rupiah from DPP ";
            sql += " WHERE IDPEL = '" + idpel + "' AND to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') = '" + bulanrek + "' AND KDGERAKMASUK ='" + kdgerak + "' ";

            sql += " union ";
            sql += " SELECT to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') AS BULAN, 'b. Rp Blok 1 / LWBP' as nmpiutang, RPLWBP as Rupiah from DPP ";
            sql += " WHERE IDPEL = '" + idpel + "' AND to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') = '" + bulanrek + "' AND KDGERAKMASUK ='" + kdgerak + "' ";

            sql += " union ";
            sql += " SELECT to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') AS BULAN, 'c. Rp Blok 2 / WBP' as nmpiutang, RPWBP as Rupiah from DPP ";
            sql += " WHERE IDPEL = '" + idpel + "' AND to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') = '" + bulanrek + "' AND KDGERAKMASUK ='" + kdgerak + "' ";

            sql += " union ";
            sql += " SELECT to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') AS BULAN, 'd. Rp Blok 3' as nmpiutang, RPBLOK3 as Rupiah from DPP ";
            sql += " WHERE IDPEL = '" + idpel + "' AND to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') = '" + bulanrek + "' AND KDGERAKMASUK ='" + kdgerak + "' ";

            sql += " union ";
            sql += " SELECT to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') AS BULAN, 'e. Rp KVARH' as nmpiutang, RPKVARH as Rupiah from DPP ";
            sql += " WHERE IDPEL = '" + idpel + "' AND to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') = '" + bulanrek + "' AND KDGERAKMASUK ='" + kdgerak + "' ";

            sql += " union ";
            sql += " SELECT to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') AS BULAN, 'f. Rp PPN' as nmpiutang, RPPPN as Rupiah from DPP ";
            sql += " WHERE IDPEL = '" + idpel + "' AND to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') = '" + bulanrek + "' AND KDGERAKMASUK ='" + kdgerak + "' ";

            sql += " union ";
            sql += " SELECT to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') AS BULAN, 'g. Rp PPJ' as nmpiutang, RPBPJU as Rupiah from DPP ";
            sql += " WHERE IDPEL = '" + idpel + "' AND to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') = '" + bulanrek + "' AND KDGERAKMASUK ='" + kdgerak + "' ";

            sql += " union ";
            sql += " SELECT to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') AS BULAN, 'h. Rp Trafo' as nmpiutang, RPTRAFO as Rupiah from DPP ";
            sql += " WHERE IDPEL = '" + idpel + "' AND to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') = '" + bulanrek + "' AND KDGERAKMASUK ='" + kdgerak + "' ";

            sql += " union ";
            sql += " SELECT to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') AS BULAN, 'i. Rp Angsuran' as nmpiutang, RPANGSA+RPANGSB+RPANGSC as Rupiah from DPP ";
            sql += " WHERE IDPEL = '" + idpel + "' AND to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') = '" + bulanrek + "' AND KDGERAKMASUK ='" + kdgerak + "' ";

            sql += " union ";
            sql += " SELECT to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') AS BULAN, 'j. Rp Materai' as nmpiutang, RPMAT as Rupiah from DPP ";
            sql += " WHERE IDPEL = '" + idpel + "' AND to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') = '" + bulanrek + "' AND KDGERAKMASUK ='" + kdgerak + "' ";

            sql += " union ";
            sql += " SELECT to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') AS BULAN, 'k. Rp Diskon' as nmpiutang, RPREDUKSI as Rupiah from DPP ";
            sql += " WHERE IDPEL = '" + idpel + "' AND to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') = '" + bulanrek + "' AND KDGERAKMASUK ='" + kdgerak + "' ";

            sql += " union ";
            sql += " SELECT to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') AS BULAN, 'l. Rp Denda' as nmpiutang, RPBK1+RPBK2+RPBK3 as Rupiah from DPP ";
            sql += " WHERE IDPEL = '" + idpel + "' AND to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') = '" + bulanrek + "' AND KDGERAKMASUK ='" + kdgerak + "' ";

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
    public Map<String, Object> ambilDis6(String idpel, String bulanrek, String kdgerak) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " SELECT TO_CHAR(TO_DATE(TGKOREKSI,'DDMMYYYY'),'DD Mon YYYY') TGLTRANSAKSI, SUM(RPPTL) AS RPREK, SUM(RPTAG) AS RPTAG ";
            sql += " FROM DPP ";
            sql += " WHERE IDPEL = '" + idpel + "' AND KDGERAKMASUK = '" + kdgerak + "' AND to_char(to_date(BLTH,'MMYYYY'),'Mon-yyyy') = '" + bulanrek + "' ";
            sql += " group by TO_CHAR(TO_DATE(TGKOREKSI,'DDMMYYYY'),'DD Mon YYYY')";

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
    public Map<String, Object> ambilDildata(String idpel, String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select SLALWBP AS standawallwbpkwh, SAHLWBP AS standakhirlwbpkwh, SLAWBP AS standawalwbp, SAHWBP AS standakhirwbp, SLAKVARH AS standawalkvarh, SAHKVARH AS standakhirkvarh ";
            sql += " from DPP ";
            sql += " where IDPEL = '" + idpel + "'";
            sql += " and BLTH = to_char(add_months(to_date('" + thbl + "','Mon-yyyy'),0),'mmyyyy') ";

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
    public Map<String, Object> ambilInfo(String idpel, String blnawal, String blnakhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  "  select ";
            sql = sql + "  DPP.IDPEL AS no_pelanggan, DPP.NAMA AS nama_pelanggan, DPP.NAMAPNJ AS nama_jalan, DPP.PNJ AS no_tiang, DPP.NOPEL AS kode_gardu, ";
            sql = sql + "  DPP.KDPP AS kodepp, DPP.KDDK AS no_kontrol, to_date(BLTH,'MMYYYY') as tgl_jatuh_tempo, DPP.KDPP as pp_lunas, ";
            sql = sql + "  DPP.KOGOL AS kode_golongan, DPP.TARIP AS tarip, DPP.DAYA AS daya, DPP.FAKM AS faktor_kali_kwh, ";
            sql = sql + "  'a. Biaya Beban' as nmpiutang, RPBEBAN AS mutasi, ";
            sql = sql + "  TO_DATE(TGLBAYAR,'DDMMYYYY') AS tgl_pelunasan, DPP.KDPEMBAYAR AS kodepetugas, ";
            sql = sql + "  SLALWBP AS STANDAWALLWBPKWH, SAHLWBP AS STANDAKHIRLWBPKWH, KWHLWBP, ";
            sql = sql + "  SLAWBP AS STANDAWALWBP, SAHWBP AS STANDAKHIRWBP, KWHWBP, BLOK3 AS KWHBLOK3, ";
            sql = sql + "  SLAKVARH AS STANDAWALKVARH, SAHKVARH AS STANDAKHIRKVARH, KWHKVARH AS KVARH, PEMKWH AS TOTALKWH ";
            sql = sql + "  from ";
            sql = sql + "  DPP ";
            sql = sql + "  where ";
            sql = sql + "  DPP.IDPEL = '" + idpel + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) >= '" + blnawal + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) <= '" + blnakhir + "' ";

            sql += "  union select ";
            sql = sql + "  DPP.IDPEL AS no_pelanggan, DPP.NAMA AS nama_pelanggan, DPP.NAMAPNJ AS nama_jalan, DPP.PNJ AS no_tiang, DPP.NOPEL AS kode_gardu, ";
            sql = sql + "  DPP.KDPP AS kodepp, DPP.KDDK AS no_kontrol, to_date(BLTH,'MMYYYY') as tgl_jatuh_tempo, DPP.KDPP as pp_lunas, ";
            sql = sql + "  DPP.KOGOL AS kode_golongan, DPP.TARIP AS tarip, DPP.DAYA AS daya, DPP.FAKM AS faktor_kali_kwh, ";
            sql = sql + "  'b. Rp. Blok 1 / LWBP' as nmpiutang, RPLWBP AS mutasi, ";
            sql = sql + "  TO_DATE(TGLBAYAR,'DDMMYYYY') AS tgl_pelunasan, DPP.KDPEMBAYAR AS kodepetugas, ";
            sql = sql + "  SLALWBP AS STANDAWALLWBPKWH, SAHLWBP AS STANDAKHIRLWBPKWH, KWHLWBP, " ;
            sql = sql + "  SLAWBP AS STANDAWALWBP, SAHWBP AS STANDAKHIRWBP, KWHWBP, BLOK3 AS KWHBLOK3, ";
            sql = sql + "  SLAKVARH AS STANDAWALKVARH, SAHKVARH AS STANDAKHIRKVARH, KWHKVARH AS KVARH, PEMKWH AS TOTALKWH ";
            sql = sql + "  from ";
            sql = sql + "  DPP ";
            sql = sql + "  where ";
            sql = sql + "  DPP.IDPEL = '" + idpel + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) >= '" + blnawal + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) <= '" + blnakhir + "' ";

            sql += "  union select ";
            sql = sql + "  DPP.IDPEL AS no_pelanggan, DPP.NAMA AS nama_pelanggan, DPP.NAMAPNJ AS nama_jalan, DPP.PNJ AS no_tiang, DPP.NOPEL AS kode_gardu, ";
            sql = sql + "  DPP.KDPP AS kodepp, DPP.KDDK AS no_kontrol, to_date(BLTH,'MMYYYY') as tgl_jatuh_tempo, DPP.KDPP as pp_lunas, ";
            sql = sql + "  DPP.KOGOL AS kode_golongan, DPP.TARIP AS tarip, DPP.DAYA AS daya, DPP.FAKM AS faktor_kali_kwh, ";
            sql = sql + "  'c. Rp. Blok 2 / WBP' as nmpiutang, RPWBP AS mutasi, ";
            sql = sql + "  TO_DATE(TGLBAYAR,'DDMMYYYY') AS tgl_pelunasan, DPP.KDPEMBAYAR AS kodepetugas, " ;
            sql = sql + "  SLALWBP AS STANDAWALLWBPKWH, SAHLWBP AS STANDAKHIRLWBPKWH, KWHLWBP, ";
            sql = sql + "  SLAWBP AS STANDAWALWBP, SAHWBP AS STANDAKHIRWBP, KWHWBP, BLOK3 AS KWHBLOK3, ";
            sql = sql + "  SLAKVARH AS STANDAWALKVARH, SAHKVARH AS STANDAKHIRKVARH, KWHKVARH AS KVARH, PEMKWH AS TOTALKWH ";
            sql = sql + "  from ";
            sql = sql + "  DPP ";
            sql = sql + "  where " ;
            sql = sql + "  DPP.IDPEL = '" + idpel + "' " ;
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) >= '" + blnawal + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) <= '" + blnakhir + "' ";

            sql += "  union select ";
            sql = sql + "  DPP.IDPEL AS no_pelanggan, DPP.NAMA AS nama_pelanggan, DPP.NAMAPNJ AS nama_jalan, DPP.PNJ AS no_tiang, DPP.NOPEL AS kode_gardu, ";
            sql = sql + "  DPP.KDPP AS kodepp, DPP.KDDK AS no_kontrol, to_date(BLTH,'MMYYYY') as tgl_jatuh_tempo, DPP.KDPP as pp_lunas, ";
            sql = sql + "  DPP.KOGOL AS kode_golongan, DPP.TARIP AS tarip, DPP.DAYA AS daya, DPP.FAKM AS faktor_kali_kwh, ";
            sql = sql + "  'd. Rp. Blok 3' as nmpiutang, RPBLOK3 AS mutasi, ";
            sql = sql + "  TO_DATE(TGLBAYAR,'DDMMYYYY') AS tgl_pelunasan, DPP.KDPEMBAYAR AS kodepetugas, ";
            sql = sql + "  SLALWBP AS STANDAWALLWBPKWH, SAHLWBP AS STANDAKHIRLWBPKWH, KWHLWBP, ";
            sql = sql + "  SLAWBP AS STANDAWALWBP, SAHWBP AS STANDAKHIRWBP, KWHWBP, BLOK3 AS KWHBLOK3, ";
            sql = sql + "  SLAKVARH AS STANDAWALKVARH, SAHKVARH AS STANDAKHIRKVARH, KWHKVARH AS KVARH, PEMKWH AS TOTALKWH ";
            sql = sql + "  from ";
            sql = sql + "  DPP ";
            sql = sql + "  where ";
            sql = sql + "  DPP.IDPEL = '" + idpel + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) >= '" + blnawal + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) <= '" + blnakhir + "' ";

            sql += "  union select ";
            sql = sql + "  DPP.IDPEL AS no_pelanggan, DPP.NAMA AS nama_pelanggan, DPP.NAMAPNJ AS nama_jalan, DPP.PNJ AS no_tiang, DPP.NOPEL AS kode_gardu, ";
            sql = sql + "  DPP.KDPP AS kodepp, DPP.KDDK AS no_kontrol, to_date(BLTH,'MMYYYY') as tgl_jatuh_tempo, DPP.KDPP as pp_lunas, ";
            sql = sql + "  DPP.KOGOL AS kode_golongan, DPP.TARIP AS tarip, DPP.DAYA AS daya, DPP.FAKM AS faktor_kali_kwh, ";
            sql = sql + "  'e. Rp. KVARH' as nmpiutang, RPKVARH AS mutasi, ";
            sql = sql + "  TO_DATE(TGLBAYAR,'DDMMYYYY') AS tgl_pelunasan, DPP.KDPEMBAYAR AS kodepetugas, ";
            sql = sql + "  SLALWBP AS STANDAWALLWBPKWH, SAHLWBP AS STANDAKHIRLWBPKWH, KWHLWBP, ";
            sql = sql + "  SLAWBP AS STANDAWALWBP, SAHWBP AS STANDAKHIRWBP, KWHWBP, BLOK3 AS KWHBLOK3, " ;
            sql = sql + "  SLAKVARH AS STANDAWALKVARH, SAHKVARH AS STANDAKHIRKVARH, KWHKVARH AS KVARH, PEMKWH AS TOTALKWH ";
            sql = sql + "  from " ;
            sql = sql + "  DPP ";
            sql = sql + "  where " ;
            sql = sql + "  DPP.IDPEL = '" + idpel + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) >= '" + blnawal + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) <= '" + blnakhir + "' " ;

            sql += "  union select ";
            sql = sql + "  DPP.IDPEL AS no_pelanggan, DPP.NAMA AS nama_pelanggan, DPP.NAMAPNJ AS nama_jalan, DPP.PNJ AS no_tiang, DPP.NOPEL AS kode_gardu, ";
            sql = sql + "  DPP.KDPP AS kodepp, DPP.KDDK AS no_kontrol, to_date(BLTH,'MMYYYY') as tgl_jatuh_tempo, DPP.KDPP as pp_lunas, ";
            sql = sql + "  DPP.KOGOL AS kode_golongan, DPP.TARIP AS tarip, DPP.DAYA AS daya, DPP.FAKM AS faktor_kali_kwh, ";
            sql = sql + "  'f. Rp. PPN' as nmpiutang, RPPPN AS mutasi, " ;
            sql = sql + "  TO_DATE(TGLBAYAR,'DDMMYYYY') AS tgl_pelunasan, DPP.KDPEMBAYAR AS kodepetugas, ";
            sql = sql + "  SLALWBP AS STANDAWALLWBPKWH, SAHLWBP AS STANDAKHIRLWBPKWH, KWHLWBP, ";
            sql = sql + "  SLAWBP AS STANDAWALWBP, SAHWBP AS STANDAKHIRWBP, KWHWBP, BLOK3 AS KWHBLOK3, ";
            sql = sql + "  SLAKVARH AS STANDAWALKVARH, SAHKVARH AS STANDAKHIRKVARH, KWHKVARH AS KVARH, PEMKWH AS TOTALKWH ";
            sql = sql + "  from ";
            sql = sql + "  DPP ";
            sql = sql + "  where " ;
            sql = sql + "  DPP.IDPEL = '" + idpel + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) >= '" + blnawal + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) <= '" + blnakhir + "' " ;

            sql += "  union select ";
            sql = sql + "  DPP.IDPEL AS no_pelanggan, DPP.NAMA AS nama_pelanggan, DPP.NAMAPNJ AS nama_jalan, DPP.PNJ AS no_tiang, DPP.NOPEL AS kode_gardu, ";
            sql = sql + "  DPP.KDPP AS kodepp, DPP.KDDK AS no_kontrol, to_date(BLTH,'MMYYYY') as tgl_jatuh_tempo, DPP.KDPP as pp_lunas, ";
            sql = sql + "  DPP.KOGOL AS kode_golongan, DPP.TARIP AS tarip, DPP.DAYA AS daya, DPP.FAKM AS faktor_kali_kwh, ";
            sql = sql + "  'g. Rp. BPJU' as nmpiutang, RPBPJU AS mutasi, ";
            sql = sql + "  TO_DATE(TGLBAYAR,'DDMMYYYY') AS tgl_pelunasan, DPP.KDPEMBAYAR AS kodepetugas, ";
            sql = sql + "  SLALWBP AS STANDAWALLWBPKWH, SAHLWBP AS STANDAKHIRLWBPKWH, KWHLWBP, ";
            sql = sql + "  SLAWBP AS STANDAWALWBP, SAHWBP AS STANDAKHIRWBP, KWHWBP, BLOK3 AS KWHBLOK3, ";
            sql = sql + "  SLAKVARH AS STANDAWALKVARH, SAHKVARH AS STANDAKHIRKVARH, KWHKVARH AS KVARH, PEMKWH AS TOTALKWH ";
            sql = sql + "  from ";
            sql = sql + "  DPP ";
            sql = sql + "  where " ;
            sql = sql + "  DPP.IDPEL = '" + idpel + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) >= '" + blnawal + "' " ;
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) <= '" + blnakhir + "' " ;

            sql += "  union select ";
            sql = sql + "  DPP.IDPEL AS no_pelanggan, DPP.NAMA AS nama_pelanggan, DPP.NAMAPNJ AS nama_jalan, DPP.PNJ AS no_tiang, DPP.NOPEL AS kode_gardu, ";
            sql = sql + "  DPP.KDPP AS kodepp, DPP.KDDK AS no_kontrol, to_date(BLTH,'MMYYYY') as tgl_jatuh_tempo, DPP.KDPP as pp_lunas, ";
            sql = sql + "  DPP.KOGOL AS kode_golongan, DPP.TARIP AS tarip, DPP.DAYA AS daya, DPP.FAKM AS faktor_kali_kwh, ";
            sql = sql + "  'h. Rp. TRAFO' as nmpiutang, RPTRAFO AS mutasi, ";
            sql = sql + "  TO_DATE(TGLBAYAR,'DDMMYYYY') AS tgl_pelunasan, DPP.KDPEMBAYAR AS kodepetugas, ";
            sql = sql + "  SLALWBP AS STANDAWALLWBPKWH, SAHLWBP AS STANDAKHIRLWBPKWH, KWHLWBP, ";
            sql = sql + "  SLAWBP AS STANDAWALWBP, SAHWBP AS STANDAKHIRWBP, KWHWBP, BLOK3 AS KWHBLOK3, ";
            sql = sql + "  SLAKVARH AS STANDAWALKVARH, SAHKVARH AS STANDAKHIRKVARH, KWHKVARH AS KVARH, PEMKWH AS TOTALKWH ";
            sql = sql + "  from ";
            sql = sql + "  DPP ";
            sql = sql + "  where " ;
            sql = sql + "  DPP.IDPEL = '" + idpel + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) >= '" + blnawal + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) <= '" + blnakhir + "' ";

            sql += "  union select ";
            sql = sql + "  DPP.IDPEL AS no_pelanggan, DPP.NAMA AS nama_pelanggan, DPP.NAMAPNJ AS nama_jalan, DPP.PNJ AS no_tiang, DPP.NOPEL AS kode_gardu, ";
            sql = sql + "  DPP.KDPP AS kodepp, DPP.KDDK AS no_kontrol, to_date(BLTH,'MMYYYY') as tgl_jatuh_tempo, DPP.KDPP as pp_lunas, ";
            sql = sql + "  DPP.KOGOL AS kode_golongan, DPP.TARIP AS tarip, DPP.DAYA AS daya, DPP.FAKM AS faktor_kali_kwh, ";
            sql = sql + "  'i. Rp. Angsuran' as nmpiutang, RPANGSA+RPANGSB+RPANGSC AS mutasi, ";
            sql = sql + "  TO_DATE(TGLBAYAR,'DDMMYYYY') AS tgl_pelunasan, DPP.KDPEMBAYAR AS kodepetugas, ";
            sql = sql + "  SLALWBP AS STANDAWALLWBPKWH, SAHLWBP AS STANDAKHIRLWBPKWH, KWHLWBP, ";
            sql = sql + "  SLAWBP AS STANDAWALWBP, SAHWBP AS STANDAKHIRWBP, KWHWBP, BLOK3 AS KWHBLOK3, " ;
            sql = sql + "  SLAKVARH AS STANDAWALKVARH, SAHKVARH AS STANDAKHIRKVARH, KWHKVARH AS KVARH, PEMKWH AS TOTALKWH " ;
            sql = sql + "  from ";
            sql = sql + "  DPP ";
            sql = sql + "  where ";
            sql = sql + "  DPP.IDPEL = '" + idpel + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) >= '" + blnawal + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) <= '" + blnakhir + "' ";

            sql += "  union select ";
            sql = sql + "  DPP.IDPEL AS no_pelanggan, DPP.NAMA AS nama_pelanggan, DPP.NAMAPNJ AS nama_jalan, DPP.PNJ AS no_tiang, DPP.NOPEL AS kode_gardu, ";
            sql = sql + "  DPP.KDPP AS kodepp, DPP.KDDK AS no_kontrol, to_date(BLTH,'MMYYYY') as tgl_jatuh_tempo, DPP.KDPP as pp_lunas, ";
            sql = sql + "  DPP.KOGOL AS kode_golongan, DPP.TARIP AS tarip, DPP.DAYA AS daya, DPP.FAKM AS faktor_kali_kwh, ";
            sql = sql + "  'j. Rp. Materai' as nmpiutang, RPMAT AS mutasi, ";
            sql = sql + "  TO_DATE(TGLBAYAR,'DDMMYYYY') AS tgl_pelunasan, DPP.KDPEMBAYAR AS kodepetugas, ";
            sql = sql + "  SLALWBP AS STANDAWALLWBPKWH, SAHLWBP AS STANDAKHIRLWBPKWH, KWHLWBP, ";
            sql = sql + "  SLAWBP AS STANDAWALWBP, SAHWBP AS STANDAKHIRWBP, KWHWBP, BLOK3 AS KWHBLOK3, ";
            sql = sql + "  SLAKVARH AS STANDAWALKVARH, SAHKVARH AS STANDAKHIRKVARH, KWHKVARH AS KVARH, PEMKWH AS TOTALKWH ";
            sql = sql + "  from ";
            sql = sql + "  DPP ";
            sql = sql + "  where ";
            sql = sql + "  DPP.IDPEL = '" + idpel + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) >= '" + blnawal + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) <= '" + blnakhir + "' ";

            sql += "  union select ";
            sql = sql + "  DPP.IDPEL AS no_pelanggan, DPP.NAMA AS nama_pelanggan, DPP.NAMAPNJ AS nama_jalan, DPP.PNJ AS no_tiang, DPP.NOPEL AS kode_gardu, " ;
            sql = sql + "  DPP.KDPP AS kodepp, DPP.KDDK AS no_kontrol, to_date(BLTH,'MMYYYY') as tgl_jatuh_tempo, DPP.KDPP as pp_lunas, ";
            sql = sql + "  DPP.KOGOL AS kode_golongan, DPP.TARIP AS tarip, DPP.DAYA AS daya, DPP.FAKM AS faktor_kali_kwh, ";
            sql = sql + "  'k. Rp. Diskon' as nmpiutang, RPSUBSIDI AS mutasi, " ;
            sql = sql + "  TO_DATE(TGLBAYAR,'DDMMYYYY') AS tgl_pelunasan, DPP.KDPEMBAYAR AS kodepetugas, ";
            sql = sql + "  SLALWBP AS STANDAWALLWBPKWH, SAHLWBP AS STANDAKHIRLWBPKWH, KWHLWBP, ";
            sql = sql + "  SLAWBP AS STANDAWALWBP, SAHWBP AS STANDAKHIRWBP, KWHWBP, BLOK3 AS KWHBLOK3, ";
            sql = sql + "  SLAKVARH AS STANDAWALKVARH, SAHKVARH AS STANDAKHIRKVARH, KWHKVARH AS KVARH, PEMKWH AS TOTALKWH ";
            sql = sql + "  from ";
            sql = sql + "  DPP ";
            sql = sql + "  where " ;
            sql = sql + "  DPP.IDPEL = '" + idpel + "' " ;
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) >= '" + blnawal + "' " ;
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) <= '" + blnakhir + "' " ;

            sql += "  union select ";
            sql = sql + "  DPP.IDPEL AS no_pelanggan, DPP.NAMA AS nama_pelanggan, DPP.NAMAPNJ AS nama_jalan, DPP.PNJ AS no_tiang, DPP.NOPEL AS kode_gardu, " ;
            sql = sql + "  DPP.KDPP AS kodepp, DPP.KDDK AS no_kontrol, to_date(BLTH,'MMYYYY') as tgl_jatuh_tempo, DPP.KDPP as pp_lunas, " ;
            sql = sql + "  DPP.KOGOL AS kode_golongan, DPP.TARIP AS tarip, DPP.DAYA AS daya, DPP.FAKM AS faktor_kali_kwh, ";
            sql = sql + "  'l. Rp. Denda' as nmpiutang, RPBK1+RPBK2+RPBK3 AS mutasi, ";
            sql = sql + "  TO_DATE(TGLBAYAR,'DDMMYYYY') AS tgl_pelunasan, DPP.KDPEMBAYAR AS kodepetugas, ";
            sql = sql + "  SLALWBP AS STANDAWALLWBPKWH, SAHLWBP AS STANDAKHIRLWBPKWH, KWHLWBP, " ;
            sql = sql + "  SLAWBP AS STANDAWALWBP, SAHWBP AS STANDAKHIRWBP, KWHWBP, BLOK3 AS KWHBLOK3, ";
            sql = sql + "  SLAKVARH AS STANDAWALKVARH, SAHKVARH AS STANDAKHIRKVARH, KWHKVARH AS KVARH, PEMKWH AS TOTALKWH ";
            sql = sql + "  from ";
            sql = sql + "  DPP ";
            sql = sql + "  where ";
            sql = sql + "  DPP.IDPEL = '" + idpel + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) >= '" + blnawal + "' ";
            sql = sql + "  and SUBSTR(DPP.BLTH,3,4)||SUBSTR(DPP.BLTH,1,2) <= '" + blnakhir + "' ";

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
    public Map<String, Object> ambilTunggakan(String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select min(to_date(blth,'mmyyyy')) as tgkawal, max(to_date(blth,'mmyyyy')) as tgkakhir, count(distinct blth) as lembar, sum(rptag+rpbk1+rpbk2+rpbk3) as rupiah ";
            sql += " from dpp ";
            sql += " where tglbayar is null ";
            sql += " and idpel = '" + idpel + "' ";

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
