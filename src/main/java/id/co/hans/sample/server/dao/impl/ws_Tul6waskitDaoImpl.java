package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.ws_tul6waskitDao;
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
public class ws_Tul6waskitDaoImpl implements ws_tul6waskitDao {
    public static final Log log = LogFactory.getLog(ws_Tul6waskitDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> sp_waskit_verifikasi(Integer nav) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " { call proc_verifikasiwaskit('" + nav + "') } ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            cst.execute();

            retValue.put("wsReturn", true);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
        }
        return retValue;
    }


    @Override
    public Map<String, Object> sp_waskit_verifikasi_up(Integer nav,
                                                       String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " { call PROC_VERIFIKASIWASKIT_UNITUP('" + nav + "','" + unitup + "') } ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            cst.execute();

            retValue.put("wsReturn", true);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
        }
        return retValue;
    }

    //---tambahan cari stand di sorekbaru terakhir dan saat putus
    @Override
    public Map<String, Object> ambilstand_sorekakhir(String unitUp,
                                                     String tgl_tul601,
                                                     String no_tul601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "  SELECT SAHLWBP,SAHWBP,SAHKVARH FROM DPP ";
            sql = sql + "  WHERE IDPEL = (SELECT IDPELANGGAN from tul601  where to_char(tgl_tul601,'yyyymmdd') = '" + tgl_tul601 + "'  and no_tul601 = '" + no_tul601 + "'  AND unitUp = '" + unitUp + "' ";
            sql = sql + " ) ";
            sql = sql + "  AND BLTH = (SELECT THBLREK from tul601  where to_char(tgl_tul601,'yyyymmdd') = '" + tgl_tul601 + "'  and no_tul601 = '" + no_tul601 + "'  AND unitUp = '" + unitUp + "' ";
            sql = sql + " ) ";
            sql += "";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }

    @Override
    public Map<String, Object> ambilstand_putus(String unitUp,
                                                String tgl_tul601,
                                                String no_tul601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="  SELECT stand_lwbp_putus,stand_wbp_putus,stand_kvarh_putus from tul601  where to_char(tgl_tul601,'yyyymmdd') = '" + tgl_tul601 + "'  and no_tul601 = '" + no_tul601 + "'  AND unitUp = '" + unitUp + "' ";
            sql += "";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }
    //---end tambahan cari stand di sorekbaru terakhir

    @Override
    public Map<String, Object> ambilNomerTulVI01(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select nvl(max(no_tul601),0) as nomer from tul601 ";
            sql += " where unitup = '" + unitUp + "' ";
            sql += " and to_char(tgl_tul601,'yyyymmdd') = to_char(sysdate,'yyyymmdd') ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", Integer.parseInt(lMapPetugas.get(0).get(0)));

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", 0);
        }
        return retValue;
    }


    @Override
    public Map<String, Object> insertTulVI01(Integer No_60,
                                             String UnitUP,
                                             String ThBlRek,
                                             String IdPelanggan,
                                             String NoKontrak,
                                             String NoKontrol,
                                             String Nama,
                                             String Alamat,
                                             String ThBlRek_akhir,
                                             String Lembar_601,
                                             String Tagihan_601,
                                             String NOtul601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" INSERT INTO TUL601 ";
            sql += " (no_601,No_60,UnitUP,ThBlRek,IdPelanggan,";
            sql += " NoKontrak,NoKontrol,";
            sql += " Nama,Alamat,No_TUL601,Tgl_TUL601,Stand_Lwbp_601,Stand_Wbp_601,";
            sql += " Stand_Kvarh_601,ThBlRek_akhir,Lembar_601,Tagihan_601,";
            sql += " BlThRek_601,Tgl_jatuh_tempo_601)";
            sql += " VALUES( seq_tul601.nextval, ";
            sql += " '" + No_60 + "', '" + UnitUP + "', '" + ThBlRek + "', '" + IdPelanggan + "', ";
            sql += " '" + NoKontrak + "', '" + NoKontrol + "', ";
            sql += " '" + Nama + "', '" + Alamat + "', '" + NOtul601 + "', ";
            sql += " sysdate, '" + "" + "', '" + "" + "', '" + "" + "', ";
            sql += " '" + ThBlRek_akhir + "', '" + Lembar_601 + "', '" + Tagihan_601 + "', '',";
            sql += " add_months(sysdate,2)) ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("insertTulVI01", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> AmbilTul601(String unitUp,
                                           String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select ";
            sql = sql + " 	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + " 	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + " 	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + "      dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kdkelompok, dpp.kdinkaso, dpp.kddk as nokontrol, dpp.nogardu as kdgardu, dpp.notiang as notiang, ";
            sql = sql + "      dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kdkelompok, dpp.kdinkaso, dpp.kddk as nokontrol, (select nama from master_gardu where NOGARDU=dpp.nogardu and unitup=dpp.unitup) as kdgardu, (select nama from master_gardu where NOGARDU=dpp.nogardu and unitup=dpp.unitup)||'/'||dpp.notiang as notiang, ";
            sql = sql + "  	   dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, dpp.kogol, ";
            sql = sql + "  	   dpp.nama, DPP.PNJ||' '||TRIM(DPP.NAMAPNJ)||' '||DPP.NOBANG||' '||DECODE(DECODE(TRIM(DPP.RT),NULL,'0',DPP.RT),'0',' ',' RT.'||DPP.RT)||DECODE(DECODE(TRIM(DPP.RW),NULL,'0',DPP.RW),'0',' ',' RW.'||DPP.RW)||' '||DPP.LINGKUNGAN AS NAMAPNJ, dpp.tarip, dpp.daya, dpp.kogol, ";
            sql = sql + " 	   dppTab.thblawal, dppTab.thblakhir, dppTab.lembar, dppTab.rptag, dppTab.rpbk,";
            sql = sql + " 	   tul60.tgl_catat_60, tul60.no_60, tul60.thblrek, DECODE(tul60.cetak_601,null,0,1) as SUDAHCETAK,0 as no_tul601 ";
            sql = sql + " from";
            sql = sql + " 	(";
            sql = sql + "     SELECT   idpel, MIN (blth) AS thblawal, MAX (blth) AS thblakhir, " ;
            sql = sql + "                   SUM(LEMBAR) AS lembar, SUM (rptag) AS rptag, ";
            sql = sql + "                   SUM (rpbk1 + rpbk2 + rpbk3) AS rpbk ";
            sql = sql + "              FROM ";
            sql = sql + "              (  ";
            sql = sql + "              SELECT IDPEL,DECODE(NOAGENDA,NULL,BLTH,NULL) AS BLTH,RPTAG,RPBK1,RPBK2,RPBK3, ";
            sql = sql + "              DECODE (noagenda, NULL, 1, DECODE (norek, 'KE0001', 1, 0))  AS LEMBAR     ";
            sql = sql + "              FROM dpp PARTITION (saldo) ";
            sql = sql + "             WHERE dpp.tglbayar IS NULL ";
            sql = sql + "               AND kdgerakkeluar IS NULL ";
            sql = sql + "               AND substr(tgljttempo,1,6) <= TO_CHAR (SYSDATE, 'yyyymm') ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilTul601_Deposit(String unitUp,
                                                   String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select ";
            sql = sql + " 	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + " 	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + " 	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + "      dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.nogardu as kdgardu, dpp.notiang as notiang, ";
            sql = sql + "  	   dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, dpp.kogol, ";
            sql = sql + " 	   dppTab.thblawal, dppTab.thblakhir, dppTab.lembar, dppTab.rptag, dppTab.rpbk,";
            sql = sql + " 	   tul60.tgl_catat_60, tul60.no_60, tul60.thblrek, DECODE(tul60.cetak_601,null,0,1) as SUDAHCETAK ";
            sql = sql + " from";
            sql = sql + " 	(";
            sql = sql + "     SELECT   idpel, MIN (blth) AS thblawal, MAX (blth) AS thblakhir, ";
            sql = sql + "                   SUM(LEMBAR) AS lembar, SUM (rptag) AS rptag, ";
            sql = sql + "                   SUM (rpbk1 + rpbk2 + rpbk3) AS rpbk ";
            sql = sql + "              FROM ";
            sql = sql + "              (  ";
            sql = sql + "              SELECT IDPEL,DECODE(NOAGENDA,NULL,BLTH,NULL) AS BLTH,RPTAG,RPBK1,RPBK2,RPBK3, ";
            sql = sql + "              DECODE (noagenda, NULL, 1, DECODE (norek, 'KE0001', 1, 0))  AS LEMBAR     ";
            sql = sql + "              FROM dpp PARTITION (saldo) ";
            sql = sql + "             WHERE dpp.tglbayar IS NULL ";
            sql = sql + "               AND kdgerakkeluar IS NULL ";
            sql = sql + "               AND substr(tgljttempo,1,6) <= TO_CHAR (SYSDATE, 'yyyymm') ";
            sql = sql + "               AND dpp.unitup = '" + unitUp + "' ";
            sql = sql + "               AND dpp.kdgerakmasuk IN ('11', '12', '13') ";
            sql = sql + "               UNION ALL ";
            sql = sql + "              SELECT IDPEL,BLTH,RPTAG,RPBK1,RPBK2,RPBK3,DECODE (noagenda, NULL, 1, DECODE (norek, 'KE0001', 1, 0))  AS LEMBAR     ";
            sql = sql + "              FROM dppanja dpp ";
            sql = sql + "             WHERE kdgerakkeluaranja IS NULL ";
            sql = sql + "               AND blth <= TO_CHAR (SYSDATE, 'yyyymm') ";
            sql = sql + "               AND dpp.unitup = '" + unitUp + "' ";
            sql = sql + "               AND dpp.kdgerakmasuk IN ('11', '12', '13') ";
            sql = sql + "               UNION ALL ";
            sql = sql + "              SELECT IDPEL,BLTH,RPTAG,RPBK1,RPBK2,RPBK3,DECODE (noagenda, NULL, 1, DECODE (norek, 'KE0001', 1, 0))  AS LEMBAR     ";
            sql = sql + "              FROM dppdeposit partition (saldo) dpp ";
            sql = sql + "             WHERE kdgerakkeluardeposit IS NULL ";
            sql = sql + "               AND blth <= TO_CHAR (SYSDATE, 'yyyymm') ";
            sql = sql + "               AND dpp.unitup = '" + unitUp + "' ";
            sql = sql + "               AND dpp.kdgerakmasuk IN ('11', '12', '13') ";
            sql = sql + "               ) ";
            sql = sql + "          GROUP BY idpel ";
            sql = sql + " 			) ";
            sql = sql + " 	dppTab, DIL DPP, tul60";
            sql = sql + " where ";

            sql += " DPP.UNITUP = '" + unitUp + "' AND ";
            sql += " DPP.IDPEL = DPPTAB.IDPEL AND ";

            sql = sql + " 	tul60.idpelanggan = dppTab.idpel and" ;
            sql = sql + " 	tul60.idpelanggan = dpp.idpel and";
            sql = sql + " 	tul60.thblrek = dppTab.thblawal and";
            sql = sql + " 	tul60.cetak_601 is null and";
            sql = sql + " 	tul60.tgl_pelunasan_60 is null and";
            sql = sql + "   tul60.unitup = '" + unitUp + "' " ;
            sql += sqlKriteria;
            sql += "" ;
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601_Deposit", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilTul601_incl_sdh_ctk(String unitUp,
                                                        String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select ";
            sql = sql + " 	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + " 	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + " 	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + "      dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kdkelompok, dpp.kdinkaso, dpp.kddk as nokontrol, (select nama from master_gardu where NOGARDU=dpp.nogardu and unitup=dpp.unitup) as kdgardu,  dpp.notiang as notiang, ";
            sql = sql + "  	   dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, dpp.kogol, ";
            sql = sql + " 	   dppTab.thblawal, dppTab.thblakhir, dppTab.lembar, dppTab.rptag, " ;
            sql = sql + "      dpptab.RPPTL, dpptab.RPINVOICE, dpptab.RPPPN, dpptab.RPBPJU, dpptab.RPTRAFO, dpptab.RPSEWATRAFO, ";
            sql = sql + "      dpptab.RPSEWAKAP, dpptab.RPANGS, dpptab.RPMAT, ";
            sql = sql + "      dppTab.rpbk, ";
            sql = sql + " 	   tul60.tgl_catat_60, tul60.no_60, tul60.thblrek, DECODE(tul60.cetak_601,null,0,1) as SUDAHCETAK";
            sql = sql + "      ,(select max(no_601) from tul601 where tul60.no_60=tul601.no_60 and tul601.idpelanggan=tul60.idpelanggan) as no_tul601";
            sql = sql + " from";
            sql = sql + " 	(";
            sql = sql + "     SELECT   idpel, MIN (blth) AS thblawal, MAX (blth) AS thblakhir, " ;
            sql = sql + "         SUM (lembar) AS lembar,";
            sql = sql + "         SUM (rptag) AS rptag, " ;
            sql = sql + "         SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPINVOICE, SUM(RPPPN) AS RPPPN, " ;
            sql = sql + "         SUM(RPBPJU) AS RPBPJU, SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, " ;
            sql = sql + "         SUM(RPANGSA + RPANGSB + RPANGSC) AS RPANGS, SUM(RPMAT) AS RPMAT, " ;
            sql = sql + "         SUM (rpbk1 + rpbk2 + rpbk3) AS rpbk ";
            sql = sql + "              FROM ";
            sql = sql + "              (  ";
            sql = sql + "              SELECT IDPEL,DECODE(NOAGENDA,NULL,BLTH,NULL) AS BLTH,RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPBK1,RPBK2,RPBK3,DECODE (noagenda, NULL, 1, DECODE (norek, 'KE0001', 1, 0)) AS lembar  ";
            sql = sql + "              FROM dpp PARTITION (saldo) ";
            sql = sql + "             WHERE dpp.kdpembpp = 'R1' ";
            sql = sql + "               AND dpp.tglbayar IS NULL " ;
            sql = sql + "               AND kdgerakkeluar IS NULL ";
            sql = sql + "               AND substr(tgljttempo,1,6) <= TO_CHAR (SYSDATE, 'yyyymm') ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601_incl_sdh_ctk", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilTul601_incl_sdh_ctk_Deposit(String unitUp,
                                                                String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select ";
            sql = sql + " 	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + " 	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + " 	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + "      dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.nogardu as kdgardu, dpp.notiang as notiang, ";
            sql = sql + "  	   dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, dpp.kogol, ";
            sql = sql + " 	   dppTab.thblawal, dppTab.thblakhir, dppTab.lembar, dppTab.rptag, dppTab.rpbk,";
            sql = sql + " 	   tul60.tgl_catat_60, tul60.no_60, tul60.thblrek, DECODE(tul60.cetak_601,null,0,1) as SUDAHCETAK";
            sql = sql + " from";
            sql = sql + " 	(";
            sql = sql + "     SELECT   idpel, MIN (blth) AS thblawal, MAX (blth) AS thblakhir, ";
            sql = sql + "                   SUM (lembar) AS lembar,";
            sql = sql + "         SUM (rptag) AS rptag, ";
            sql = sql + "                   SUM (rpbk1 + rpbk2 + rpbk3) AS rpbk ";
            sql = sql + "              FROM ";
            sql = sql + "              (  ";
            sql = sql + "              SELECT IDPEL,DECODE(NOAGENDA,NULL,BLTH,NULL) AS BLTH,RPTAG,RPBK1,RPBK2,RPBK3,DECODE (noagenda, NULL, 1, DECODE (norek, 'KE0001', 1, 0)) AS lembar  ";
            sql = sql + "              FROM dpp PARTITION (saldo) ";
            sql = sql + "             WHERE dpp.kdpembpp = 'R1' ";
            sql = sql + "               AND dpp.tglbayar IS NULL ";
            sql = sql + "               AND kdgerakkeluar IS NULL ";
            sql = sql + "               AND substr(tgljttempo,1,6) <= TO_CHAR (SYSDATE, 'yyyymm') ";
            sql = sql + "               AND dpp.unitup = '" + unitUp + "' ";
            sql = sql + "               AND dpp.kdgerakmasuk IN ('11', '12', '13') ";
            sql = sql + "               UNION ALL ";
            sql = sql + "              SELECT IDPEL,BLTH,RPTAG,RPBK1,RPBK2,RPBK3,DECODE (noagenda, NULL, 1, DECODE (norek, 'KE0001', 1, 0))  AS lembar    ";
            sql = sql + "              FROM dppanja partition (saldo) dpp ";
            sql = sql + "             WHERE dpp.kdpembpp = 'R1' ";
            sql = sql + "               AND blth <= TO_CHAR (SYSDATE, 'yyyymm') ";
            sql = sql + "               AND dpp.unitup = '" + unitUp + "' ";
            sql = sql + "               AND dpp.kdgerakmasuk IN ('11', '12', '13') ";
            sql = sql + "               UNION ALL ";
            sql = sql + "              SELECT IDPEL,BLTH,RPTAG,RPBK1,RPBK2,RPBK3,DECODE (noagenda, NULL, 1, DECODE (norek, 'KE0001', 1, 0))  AS lembar    ";
            sql = sql + "              FROM dppdeposit partition (saldo) dpp ";
            sql = sql + "             WHERE dpp.kdpembpp = 'R1' ";
            sql = sql + "               AND blth <= TO_CHAR (SYSDATE, 'yyyymm') ";
            sql = sql + "               AND dpp.unitup = '" + unitUp + "' ";
            sql = sql + "               AND dpp.kdgerakmasuk IN ('11', '12', '13') ";
            sql = sql + "               ) ";
            sql = sql + "          GROUP BY idpel ";
            sql = sql + " 			) ";
            sql = sql + " 	dppTab, DIL DPP, tul60";
            sql = sql + " where ";

            sql += " DPP.UNITUP = '" + unitUp + "' AND ";
            sql += " DPP.IDPEL = DPPTAB.IDPEL AND ";

            sql = sql + " 	tul60.idpelanggan = dppTab.idpel and";
            sql = sql + " 	tul60.idpelanggan = dpp.idpel and";
            sql = sql + " 	tul60.thblrek = dppTab.thblawal and";
            sql = sql + " 	tul60.cetak_601 is null and";
            sql = sql + " 	tul60.tgl_pelunasan_60 is null and";
            sql = sql + "   tul60.unitup = '" + unitUp + "' ";

            sql += sqlKriteria;
            sql += "";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601_incl_sdh_ctk_Deposit", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    //--- Laporan VI-03
    @Override
    public Map<String, Object> ambilDaftarPantauCetak603(String unitUp,
                                                         Date awal,
                                                         Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "  SELECT ";
            sql = sql + "  tgl_tul603,TO_CHAR(tgl_tul603,'yyyy-mm-dd')||'/TULVI-03/'||no_tul603 AS no_tul603,idpelanggan,nokontrak,nokontrol,nama,alamat,lembar_603,thblrek,thblrek_akhir,tagihan_603,";
            sql = sql + "  Tgl_Pelaksanaan_bongkar,Nama_bongkar,Stand_Lwbp_bongkar,stand_wbp_bongkar,stand_kvarh_bongkar,Tgl_Pelunasan_603 ";
            sql = sql + "  FROM tul603";
            sql = sql + "  WHERE TO_CHAR(tgl_tul603,'yyyymmdd') >= '"; // + strAwal + "' ";
            sql = sql + "  AND TO_CHAR(tgl_tul603,'yyyymmdd') <= '"; // + strAkhir + "' ";
            sql = sql + "  AND unitUp = '" + unitUp + "' ";
            sql += "";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDaftarPantauCetak603", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilDaftarPantauCetak603Lunas(String unitUp,
                                                              Date awal,
                                                              Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "  SELECT ";
            sql = sql + "  tgl_tul603,TO_CHAR(tgl_tul603,'yyyy-mm-dd')||'/TULVI-03/'||no_tul603 AS no_tul603,idpelanggan,nokontrak,nokontrol,nama,alamat,lembar_603,thblrek,thblrek_akhir,tagihan_603,";
            sql = sql + "  Tgl_Pelaksanaan_bongkar,Nama_bongkar,Stand_Lwbp_bongkar,stand_wbp_bongkar,stand_kvarh_bongkar,Tgl_Pelunasan_603 ";
            sql = sql + "  FROM tul603";
            sql = sql + "  WHERE TO_CHAR(tgl_tul603,'yyyymmdd') >= '"; // + strAwal + "' ";
            sql = sql + "  AND TO_CHAR(tgl_tul603,'yyyymmdd') <= '"; // + strAkhir + "' ";
            sql = sql + "  AND unitUp = '" + unitUp + "' and Tgl_Pelunasan_603 is not null ";
            sql += "";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDaftarPantauCetak603Lunas", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilRekapPantauCetak603(String unitUp,
                                                        Date awal,
                                                        Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "     select ";
            sql = sql + " 		trunc(t1.Tgl_TUL603) as tglCetak_603,";
            sql = sql + " 		t1.UnitUP,";
            sql = sql + " 		sum(t1.Lembar_603) as Lembar_603,";
            sql = sql + " 		sum(t1.Tagihan_603) as Tagihan_603, ";
            sql = sql + "       sum(t1.Lembar_603_lunas) as Lembar_603_lunas,";
            sql = sql + "       sum(t1.Tagihan_603_lunas) as Tagihan_603_lunas,";
            sql = sql + "       sum(t1.Lembar_603_bongkar) as Lembar_603_bongkar,";
            sql = sql + "       sum(t1.Tagihan_603_bongkar) as Tagihan_603_bongkar,";
            sql = sql + "       sum(t1.Lembar_603) as Lembar_603_bongkar,";
            sql = sql + "       sum(t1.Tagihan_603) as Tagihan_603_bongkar,";
            sql = sql + "       sum(t1.Lembar_603_tidak_lunas) as Lembar_603_tidak_lunas,";
            sql = sql + "       sum(t1.Tagihan_603_tidak_lunas) as Tagihan_603_tidak_lunas";
            sql = sql + " 	from";
            sql = sql + " 	(select ";
            sql = sql + " 		tul603.Tgl_TUL603,";
            sql = sql + " 		tul603.UnitUP,";
            sql = sql + " 		1 as Lembar_603,";
            sql = sql + " 		tul603.Tagihan_603, ";
            sql = sql + " 		case ";
            sql = sql + "              when Tgl_Pelunasan_603 is null then 0";
            sql = sql + "              else 1";
            sql = sql + "              end as Lembar_603_lunas,";
            sql = sql + "              case ";
            sql = sql + "              when Tgl_Pelunasan_603 is null then 0";
            sql = sql + "              else tul603.Tagihan_603";
            sql = sql + "              end as Tagihan_603_lunas,";
            sql = sql + "              case ";
            sql = sql + "              when Tgl_Pelaksanaan_Bongkar is null then 0";
            sql = sql + "              else 1";
            sql = sql + "              end as Lembar_603_Bongkar,";
            sql = sql + "              case ";
            sql = sql + "              when Tgl_Pelaksanaan_Bongkar is null then 0";
            sql = sql + "              else tul603.Tagihan_603";
            sql = sql + "              end as Tagihan_603_Bongkar,";
            sql = sql + "          case      when Tgl_Pelunasan_603 is null";
            sql = sql + "          then 1 	else 0 	end as Lembar_603_Tidak_lunas,";
            sql = sql + "          case  	when Tgl_Pelunasan_603 is null";
            sql = sql + "          then tul603.Tagihan_603 	else 0 	end as Tagihan_603_Tidak_lunas";
            sql = sql + "         from tul603 ";
            sql = sql + "         where to_char(tul603.Tgl_TUL603,'yyyymmdd') >= '"; // + strAwal + "' ";
            sql = sql + "         and   to_char(tul603.Tgl_TUL603,'yyyymmdd') <= '"; // + strAkhir + "' ";
            sql = sql + " 		  and   tul603.unitup = '" + unitUp + "' ";
            sql = sql + " 	) t1";
            sql = sql + " 	group by";
            sql = sql + " 		trunc(t1.Tgl_TUL603),";
            sql = sql + " 		t1.UnitUP order by 1 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilRekapPantauCetak603", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilRekapPantauCetak603lunas(String unitUp,
                                                             Date awal,
                                                             Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "     select ";
            sql = sql + " 		trunc(t1.Tgl_TUL603) as tglCetak_603,";
            sql = sql + " 		t1.UnitUP,";
            sql = sql + " 		sum(t1.Lembar_603) as Lembar_603,";
            sql = sql + " 		sum(t1.Tagihan_603) as Tagihan_603, ";
            sql = sql + "       sum(t1.Lembar_603_lunas) as Lembar_603_lunas,";
            sql = sql + "       sum(t1.Tagihan_603_lunas) as Tagihan_603_lunas,";
            sql = sql + "       sum(t1.Lembar_603_bongkar) as Lembar_603_bongkar,";
            sql = sql + "       sum(t1.Tagihan_603_bongkar) as Tagihan_603_bongkar,";
            sql = sql + "       sum(t1.Lembar_603) as Lembar_603_bongkar,";
            sql = sql + "       sum(t1.Tagihan_603) as Tagihan_603_bongkar,";
            sql = sql + "       sum(t1.Lembar_603_tidak_lunas) as Lembar_603_tidak_lunas,";
            sql = sql + "       sum(t1.Tagihan_603_tidak_lunas) as Tagihan_603_tidak_lunas";
            sql = sql + " 	from";
            sql = sql + " 	(select ";
            sql = sql + " 		tul603.Tgl_TUL603,";
            sql = sql + " 		tul603.UnitUP,";
            sql = sql + " 		1 as Lembar_603,";
            sql = sql + " 		tul603.Tagihan_603, ";
            sql = sql + " 		case ";
            sql = sql + "              when Tgl_Pelunasan_603 is null then 0";
            sql = sql + "              else 1";
            sql = sql + "              end as Lembar_603_lunas,";
            sql = sql + "              case ";
            sql = sql + "              when Tgl_Pelunasan_603 is null then 0";
            sql = sql + "              else tul603.Tagihan_603";
            sql = sql + "              end as Tagihan_603_lunas,";
            sql = sql + "              case ";
            sql = sql + "              when Tgl_Pelaksanaan_Bongkar is null then 0";
            sql = sql + "              else 1";
            sql = sql + "              end as Lembar_603_Bongkar,";
            sql = sql + "              case ";
            sql = sql + "              when Tgl_Pelaksanaan_Bongkar is null then 0";
            sql = sql + "              else tul603.Tagihan_603";
            sql = sql + "              end as Tagihan_603_Bongkar,";
            sql = sql + "          case      when Tgl_Pelunasan_603 is null";
            sql = sql + "          then 1 	else 0 	end as Lembar_603_Tidak_lunas,";
            sql = sql + "          case  	when Tgl_Pelunasan_603 is null";
            sql = sql + "          then tul603.Tagihan_603 	else 0 	end as Tagihan_603_Tidak_lunas";
            sql = sql + "         from tul603 ";
            sql = sql + "         where to_char(tul603.Tgl_TUL603,'yyyymmdd') >= '"; // + strAwal + "' ";
            sql = sql + "         and   to_char(tul603.Tgl_TUL603,'yyyymmdd') <= '"; // + strAkhir + "' ";
            sql = sql + " 		  and   tul603.unitup = '" + unitUp + "' and Tgl_Pelunasan_603 is not null ";
            sql = sql + " 	) t1";
            sql = sql + " 	group by";
            sql = sql + " 		trunc(t1.Tgl_TUL603),";
            sql = sql + " 		t1.UnitUP order by 1 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilRekapPantauCetak603lunas", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambil603BelumLunas(String unitUp,
                                                  Date awal,
                                                  Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "  SELECT ";
            sql = sql + "  tgl_tul603,TO_CHAR(tgl_tul603,'yyyy-mm-dd')||'/TULVI-03/'||no_tul603 AS no_tul603,idpelanggan,nokontrak,nokontrol,nama,alamat,lembar_603,thblrek,thblrek_akhir,tagihan_603,";
            sql = sql + "  Tgl_Pelaksanaan_bongkar,Nama_bongkar,Stand_Lwbp_bongkar,stand_wbp_bongkar,stand_kvarh_bongkar,Tgl_Pelunasan_603 ";
            sql = sql + "  FROM tul603";
            sql = sql + "  WHERE TO_CHAR(tgl_tul603,'yyyymmdd') >= '"; // + strAwal + "' ";
            sql = sql + "  AND TO_CHAR(tgl_tul603,'yyyymmdd') <= '"; // + strAkhir + "' ";
            sql = sql + "  AND unitUp = '" + unitUp + "' and Tgl_Pelunasan_603 is null ";
            sql += "";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambil603BelumLunas", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    //--- Laporan VI-01
    @Override
    public Map<String, Object> ambilDaftarPantauCetak601(String unitUp,
                                                         Date awal,
                                                         Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select ";
            sql = sql + " tgl_tul601,to_char(tgl_tul601,'yyyy-mm-dd')||'/TULVI-01/'||no_tul601 as no_tul601,idpelanggan,nokontrak,nokontrol,nama,alamat,lembar_601,thblrek,thblrek_akhir,tagihan_601,";
            sql = sql + " Tgl_Pelaksanaan_Putus,Nama_Putus,Stand_Lwbp_Putus,stand_wbp_putus,stand_kvarh_putus,";
            sql = sql + " Tgl_Pelaksanaan_Sambung,Nama_Sambung,Stand_Lwbp_Sambung,stand_wbp_sambung,stand_kvarh_sambung,";
            sql = sql + " Tgl_Pelunasan_601 ";
            sql = sql + " from tul601";
            sql = sql + " where to_char(tgl_tul601,'yyyymmdd') >= '"; // + strAwal + "' ";
            sql = sql + "   and to_char(tgl_tul601,'yyyymmdd') <= '"; // + strAkhir + "' ";
            sql = sql + "   and unitUp = '" + unitUp + "' ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDaftarPantauCetak601", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilDaftarPantauCetak601_kriteria(String unitUp,
                                                                  Date awal,
                                                                  Date akhir,
                                                                  String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select ";
            sql = sql + " tgl_tul601,to_char(tgl_tul601,'yyyy-mm-dd')||'/TULVI-01/'||no_tul601 as no_tul601,idpelanggan,nokontrak,nokontrol,nama,alamat,lembar_601,thblrek,thblrek_akhir,tagihan_601,";
            sql = sql + " Tgl_Pelaksanaan_Putus,Nama_Putus,Stand_Lwbp_Putus,stand_wbp_putus,stand_kvarh_putus,";
            sql = sql + " Tgl_Pelaksanaan_Sambung,Nama_Sambung,Stand_Lwbp_Sambung,stand_wbp_sambung,stand_kvarh_sambung,";
            sql = sql + " Tgl_Pelunasan_601 ";
            sql = sql + " from tul601";
            sql = sql + " where to_char(tgl_tul601,'yyyymmdd') >= '"; // + strAwal + "' ";
            sql = sql + "   and to_char(tgl_tul601,'yyyymmdd') <= '"; // + strAkhir + "' ";
            sql = sql + "   and unitUp = '" + unitUp + "' ";
            sql += sqlKriteria;
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDaftarPantauCetak601_kriteria", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilRekapPantauCetak601(String unitUp,
                                                        Date awal,
                                                        Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "     select ";
            sql = sql + " 		trunc(t1.Tgl_TUL601) as tglCetak_601,";
            sql = sql + " 		t1.UnitUP,";
            sql = sql + " 		sum(t1.Lembar_601) as Lembar_601,";
            sql = sql + " 		sum(t1.Tagihan_601) as Tagihan_601,";
            sql = sql + " 		sum(t1.Lembar_601_lunas) as Lembar_601_lunas,";
            sql = sql + " 		sum(t1.Tagihan_601_lunas) as Tagihan_601_lunas,";
            sql = sql + " 		sum(t1.Lembar_601_putus) as Lembar_601_putus,";
            sql = sql + " 		sum(t1.Tagihan_601_putus) as Tagihan_601_putus,";
            sql = sql + " 		sum(t1.Lembar_601_putuslunas) as Lembar_601_putuslunas,";
            sql = sql + " 		sum(t1.Tagihan_601_putuslunas) as Tagihan_601_putuslunas,";
            sql = sql + " 		sum(t1.Lembar_601_sambung) as Lembar_601_sambung, ";

            sql = sql + " sum(t1.Lembar_601_Tidak_lunas) as Lembar_601_Tidak_lunas, 		";
            sql = sql + " sum(t1.Tagihan_601_Tidak_lunas) as Tagihan_601_Tidak_lunas		 	";

            sql = sql + " 	from";
            sql = sql + " 	(select ";
            sql = sql + " 		tul601.Tgl_TUL601,";
            sql = sql + " 		tul601.UnitUP,";
            sql = sql + " 		1 as Lembar_601,";
            sql = sql + " 		tul601.Tagihan_601,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelunasan_601 is null then 0";
            sql = sql + " 	else 1";
            sql = sql + " 	end as Lembar_601_lunas,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelunasan_601 is null then 0";
            sql = sql + " 	else tul601.Tagihan_601";
            sql = sql + " 	end as Tagihan_601_lunas,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is null then 0";
            sql = sql + " 	else 1";
            sql = sql + " 	end as Lembar_601_putus,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is null then 0";
            sql = sql + " 	else tul601.Tagihan_601";
            sql = sql + " 	end as Tagihan_601_putus,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is not null and ";
            sql = sql + " 		Tgl_Pelunasan_601 is not null then 1";
            sql = sql + " 	else 0";
            sql = sql + " 	end as Lembar_601_putuslunas,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is not null and ";
            sql = sql + " 		Tgl_Pelunasan_601 is not null then tul601.Tagihan_601";
            sql = sql + " 	else 0";
            sql = sql + " 	end as Tagihan_601_putuslunas,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Sambung is null then 0";
            sql = sql + " 	else 1";
            sql = sql + " 	end as Lembar_601_sambung, ";

            sql = sql + " case  	when Tgl_Pelunasan_601 is null  	";
            sql = sql + " then 1 	else 0 	end as Lembar_601_Tidak_lunas, 	";
            sql = sql + " case  	when Tgl_Pelunasan_601 is null  	";
            sql = sql + " then tul601.Tagihan_601 	else 0 	end as Tagihan_601_Tidak_lunas         ";

            sql = sql + "         from tul601 ";
            sql = sql + "         where to_char(tul601.Tgl_TUL601,'yyyymmdd') >= '"; // + strAwal + "' ";
            sql = sql + "         and   to_char(tul601.Tgl_TUL601,'yyyymmdd') <= '"; // + strAkhir + "' ";
            sql = sql + " 		  and   tul601.unitup = '" + unitUp + "' ";
            sql = sql + " 	) t1";
            sql = sql + " 	group by";
            sql = sql + " 		trunc(t1.Tgl_TUL601),";
            sql = sql + " 		t1.UnitUP ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilRekapPantauCetak601", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilRekapPantauCetak601_kriteria(String unitUp,
                                                                 Date awal,
                                                                 Date akhir,
                                                                 String sqlkriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "     select ";
            sql = sql + " 		trunc(t1.Tgl_TUL601) as tglCetak_601,";
            sql = sql + " 		t1.UnitUP,";
            sql = sql + " 		sum(t1.Lembar_601) as Lembar_601,";
            sql = sql + " 		sum(t1.Tagihan_601) as Tagihan_601,";
            sql = sql + " 		sum(t1.Lembar_601_lunas) as Lembar_601_lunas," ;
            sql = sql + " 		sum(t1.Tagihan_601_lunas) as Tagihan_601_lunas,";
            sql = sql + " 		sum(t1.Lembar_601_putus) as Lembar_601_putus,";
            sql = sql + " 		sum(t1.Tagihan_601_putus) as Tagihan_601_putus,";
            sql = sql + " 		sum(t1.Lembar_601_putuslunas) as Lembar_601_putuslunas,";
            sql = sql + " 		sum(t1.Tagihan_601_putuslunas) as Tagihan_601_putuslunas,";
            sql = sql + " 		sum(t1.Lembar_601_sambung) as Lembar_601_sambung, ";

            sql = sql + " sum(t1.Lembar_601_Tidak_lunas) as Lembar_601_Tidak_lunas, 		";
            sql = sql + " sum(t1.Tagihan_601_Tidak_lunas) as Tagihan_601_Tidak_lunas		 	";

            sql = sql + " 	from";
            sql = sql + " 	(select ";
            sql = sql + " 		tul601.Tgl_TUL601,";
            sql = sql + " 		tul601.UnitUP,";
            sql = sql + " 		1 as Lembar_601," ;
            sql = sql + " 		tul601.Tagihan_601,";
            sql = sql + " 	case " ;
            sql = sql + " 	when Tgl_Pelunasan_601 is null then 0";
            sql = sql + " 	else 1";
            sql = sql + " 	end as Lembar_601_lunas,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelunasan_601 is null then 0";
            sql = sql + " 	else tul601.Tagihan_601";
            sql = sql + " 	end as Tagihan_601_lunas,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is null then 0";
            sql = sql + " 	else 1";
            sql = sql + " 	end as Lembar_601_putus,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is null then 0";
            sql = sql + " 	else tul601.Tagihan_601";
            sql = sql + " 	end as Tagihan_601_putus,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is not null and ";
            sql = sql + " 		Tgl_Pelunasan_601 is not null then 1";
            sql = sql + " 	else 0";
            sql = sql + " 	end as Lembar_601_putuslunas,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is not null and ";
            sql = sql + " 		Tgl_Pelunasan_601 is not null then tul601.Tagihan_601";
            sql = sql + " 	else 0";
            sql = sql + " 	end as Tagihan_601_putuslunas,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Sambung is null then 0";
            sql = sql + " 	else 1";
            sql = sql + " 	end as Lembar_601_sambung, ";

            sql = sql + " case  	when Tgl_Pelunasan_601 is null  	" ;
            sql = sql + " then 1 	else 0 	end as Lembar_601_Tidak_lunas, 	";
            sql = sql + " case  	when Tgl_Pelunasan_601 is null  	";
            sql = sql + " then tul601.Tagihan_601 	else 0 	end as Tagihan_601_Tidak_lunas         ";

            sql = sql + "         from tul601 ";
            sql = sql + "         where to_char(tul601.Tgl_TUL601,'yyyymmdd') >= '"; // + strAwal + "' ";
            sql = sql + "         and   to_char(tul601.Tgl_TUL601,'yyyymmdd') <= '"; // + strAkhir + "' ";
            sql = sql + " 		  and   tul601.unitup = '" + unitUp + "' " ;
            sql += sqlkriteria;
            sql = sql + " 	) t1";
            sql = sql + " 	group by";
            sql = sql + " 		trunc(t1.Tgl_TUL601),";
            sql = sql + " 		t1.UnitUP ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilRekapPantauCetak601_kriteria", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilDaftar601Lunas(String unitUp,
                                                   Date awalPk,
                                                   Date akhirPk,
                                                   Date awalLns,
                                                   Date akhirLns,
                                                   String kriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select ";
            sql = sql + " tgl_tul601,to_char(tgl_tul601,'yyyy-mm-dd')||'/TULVI-01/'||no_tul601 as no_tul601,idpelanggan,nokontrak,nokontrol,nama,alamat,lembar_601,thblrek,thblrek_akhir,tagihan_601,";
            sql = sql + " Tgl_Pelaksanaan_Putus,Nama_Putus,Stand_Lwbp_Putus,";
            sql = sql + " Tgl_Pelaksanaan_Sambung,Nama_Sambung,Stand_Lwbp_Sambung,";
            sql = sql + " Tgl_Pelunasan_601 ";
            sql = sql + " from tul601";
            sql = sql + " where ";
            sql = sql + " 	unitup = '" + unitUp + "' ";
            sql = sql + " 	and to_char(Tgl_TUL601,'yyyymmdd') >= '"; // + strPkAwal + "' ";
            sql = sql + " 	and to_char(Tgl_TUL601,'yyyymmdd') <= '"; // + strPkAkhir + "' ";
            sql = sql + " 	and to_char(Tgl_Pelunasan_601,'yyyymmdd') >= '"; // + strLnsAwal + "' ";
            sql = sql + " 	and to_char(Tgl_Pelunasan_601,'yyyymmdd') <= '"; // + strLnsAkhir + "' " ;
            sql = sql + " 	and Tgl_Pelunasan_601 is not null" + kriteria;
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDaftar601Lunas", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilDaftar601Lunas_kriteria(String unitUp,
                                                            Date awalPk,
                                                            Date akhirPk,
                                                            Date awalLns,
                                                            Date akhirLns,
                                                            String kriteria,
                                                            String sqlkriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select ";
            sql = sql + " tgl_tul601,to_char(tgl_tul601,'yyyy-mm-dd')||'/TULVI-01/'||no_tul601 as no_tul601,idpelanggan,nokontrak,nokontrol,nama,alamat,lembar_601,thblrek,thblrek_akhir,tagihan_601,";
            sql = sql + " Tgl_Pelaksanaan_Putus,Nama_Putus,Stand_Lwbp_Putus,";
            sql = sql + " Tgl_Pelaksanaan_Sambung,Nama_Sambung,Stand_Lwbp_Sambung,";
            sql = sql + " Tgl_Pelunasan_601 ";
            sql = sql + " from tul601";
            sql = sql + " where ";
            sql = sql + " 	unitup = '" + unitUp + "' ";
            sql = sql + " 	and to_char(Tgl_TUL601,'yyyymmdd') >= '"; // + strPkAwal + "' ";
            sql = sql + " 	and to_char(Tgl_TUL601,'yyyymmdd') <= '"; // + strPkAkhir + "' ";
            sql = sql + " 	and to_char(Tgl_Pelunasan_601,'yyyymmdd') >= '"; // + strLnsAwal + "' ";
            sql = sql + " 	and to_char(Tgl_Pelunasan_601,'yyyymmdd') <= '"; // + strLnsAkhir + "' ";
            sql = sql + " 	and Tgl_Pelunasan_601 is not null" + kriteria ;
            sql += sqlkriteria;
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDaftar601Lunas_kriteria", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilRekap601Lunas(String unitUp,
                                                  Date awalPk,
                                                  Date akhirPk,
                                                  Date awalLns,
                                                  Date akhirLns) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "     select ";
            sql = sql + " 		trunc(t1.Tgl_TUL601) as tglCetak_601,";
            sql = sql + " 		t1.UnitUP,";
            sql = sql + " 		sum(t1.Lembar_601) as Lembar_601,";
            sql = sql + " 		sum(t1.Tagihan_601) as Tagihan_601,";
            sql = sql + " 		sum(t1.Lembar_601_lunas) as Lembar_601_lunas,";
            sql = sql + " 		sum(t1.Tagihan_601_lunas) as Tagihan_601_lunas,";
            sql = sql + " 		sum(t1.Lembar_601_putus) as Lembar_601_putus,";
            sql = sql + " 		sum(t1.Tagihan_601_putus) as Tagihan_601_putus,";
            sql = sql + " 		sum(t1.Lembar_601_putuslunas) as Lembar_601_putuslunas,";
            sql = sql + " 		sum(t1.Tagihan_601_putuslunas) as Tagihan_601_putuslunas,";
            sql = sql + " 		sum(t1.Lembar_601_sambung) as Lembar_601_sambung, ";

            sql = sql + " sum(t1.Lembar_601_Tidak_lunas) as Lembar_601_Tidak_lunas, 		";
            sql = sql + " sum(t1.Tagihan_601_Tidak_lunas) as Tagihan_601_Tidak_lunas		 	";

            sql = sql + " 	from";
            sql = sql + " 	(select ";
            sql = sql + " 		tul601.Tgl_TUL601,";
            sql = sql + " 		tul601.UnitUP,";
            sql = sql + " 		1 as Lembar_601,";
            sql = sql + " 		tul601.Tagihan_601,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelunasan_601 is null ";
            sql = sql + " or (to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') < '"; // + strLnsAwal + "'          " ;
            sql = sql + " or to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') > '"; // + strLnsAkhir + "') then 0";
            sql = sql + " 	else 1";
            sql = sql + " 	end as Lembar_601_lunas,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelunasan_601 is null ";
            sql = sql + " or (to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') < '"; // + strLnsAwal + "'          ";
            sql = sql + " or to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') > '"; // + strLnsAkhir + "') then 0";
            sql = sql + " 	else tul601.Tagihan_601";
            sql = sql + " 	end as Tagihan_601_lunas," ;
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is null then 0";
            sql = sql + " 	else 1";
            sql = sql + " 	end as Lembar_601_putus,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is null then 0";
            sql = sql + " 	else tul601.Tagihan_601";
            sql = sql + " 	end as Tagihan_601_putus,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is not null and ";
            sql = sql + " 		Tgl_Pelunasan_601 is not null then 1";
            sql = sql + " 	else 0";
            sql = sql + " 	end as Lembar_601_putuslunas,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is not null and ";
            sql = sql + " 		Tgl_Pelunasan_601 is not null then tul601.Tagihan_601";
            sql = sql + " 	else 0";
            sql = sql + " 	end as Tagihan_601_putuslunas,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Sambung is null then 0";
            sql = sql + " 	else 1";
            sql = sql + " 	end as Lembar_601_sambung, ";

            sql = sql + " case  	when Tgl_Pelunasan_601 is null  	";
            sql = sql + " or (to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') < '"; // + strLnsAwal + "'          ";
            sql = sql + " or to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') > '"; // + strLnsAkhir + "') " ;
            sql = sql + " then 1 	else 0 	end as Lembar_601_Tidak_lunas, 	";
            sql = sql + " case  	when Tgl_Pelunasan_601 is null  	";
            sql = sql + " or (to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') < '";// +  strLnsAwal + "'          ";
            sql = sql + " or to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') > '"; // + strLnsAkhir + "') ";
            sql = sql + " then tul601.Tagihan_601 	else 0 	end as Tagihan_601_Tidak_lunas         " ;

            sql = sql + "         from tul601 ";
            sql = sql + "         where to_char(tul601.Tgl_TUL601,'yyyymmdd') >= '"; // + strPkAwal + "' ";
            sql = sql + "         and   to_char(tul601.Tgl_TUL601,'yyyymmdd') <= '"; //  + strPkAkhir + "' ";
            sql = sql + " 		  and   tul601.unitup = '" + unitUp + "' ";
            sql = sql + " 	) t1";
            sql = sql + " 	group by";
            sql = sql + " 		trunc(t1.Tgl_TUL601),";
            sql = sql + " 		t1.UnitUP ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilRekap601Lunas", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilRekap601Lunas_kriteria(String unitUp,
                                                           Date awalPk,
                                                           Date akhirPk,
                                                           Date awalLns,
                                                           Date akhirLns,
                                                           String sqlkriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "     select ";
            sql = sql + " 		trunc(t1.Tgl_TUL601) as tglCetak_601,";
            sql = sql + " 		t1.UnitUP,";
            sql = sql + " 		sum(t1.Lembar_601) as Lembar_601,";
            sql = sql + " 		sum(t1.Tagihan_601) as Tagihan_601,";
            sql = sql + " 		sum(t1.Lembar_601_lunas) as Lembar_601_lunas,";
            sql = sql + " 		sum(t1.Tagihan_601_lunas) as Tagihan_601_lunas,";
            sql = sql + " 		sum(t1.Lembar_601_putus) as Lembar_601_putus,";
            sql = sql + " 		sum(t1.Tagihan_601_putus) as Tagihan_601_putus,";
            sql = sql + " 		sum(t1.Lembar_601_putuslunas) as Lembar_601_putuslunas,";
            sql = sql + " 		sum(t1.Tagihan_601_putuslunas) as Tagihan_601_putuslunas,";
            sql = sql + " 		sum(t1.Lembar_601_sambung) as Lembar_601_sambung, ";

            sql = sql + " sum(t1.Lembar_601_Tidak_lunas) as Lembar_601_Tidak_lunas, 		";
            sql = sql + " sum(t1.Tagihan_601_Tidak_lunas) as Tagihan_601_Tidak_lunas		 	" ;

            sql = sql + " 	from";
            sql = sql + " 	(select ";
            sql = sql + " 		tul601.Tgl_TUL601,";
            sql = sql + " 		tul601.UnitUP,";
            sql = sql + " 		1 as Lembar_601,";
            sql = sql + " 		tul601.Tagihan_601,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelunasan_601 is null ";
            sql = sql + " or (to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') < '"; // + strLnsAwal + "'          ";
            sql = sql + " or to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') > '"; // + strLnsAkhir + "') then 0";
            sql = sql + " 	else 1";
            sql = sql + " 	end as Lembar_601_lunas,";
            sql = sql + " 	case " ;
            sql = sql + " 	when Tgl_Pelunasan_601 is null ";
            sql = sql + " or (to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') < '"; // + strLnsAwal + "'          ";
            sql = sql + " or to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') > '"; // + strLnsAkhir + "') then 0";
            sql = sql + " 	else tul601.Tagihan_601";
            sql = sql + " 	end as Tagihan_601_lunas,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is null then 0" ;
            sql = sql + " 	else 1";
            sql = sql + " 	end as Lembar_601_putus,";
            sql = sql + " 	case " ;
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is null then 0";
            sql = sql + " 	else tul601.Tagihan_601";
            sql = sql + " 	end as Tagihan_601_putus,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is not null and ";
            sql = sql + " 		Tgl_Pelunasan_601 is not null then 1";
            sql = sql + " 	else 0";
            sql = sql + " 	end as Lembar_601_putuslunas,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is not null and ";
            sql = sql + " 		Tgl_Pelunasan_601 is not null then tul601.Tagihan_601";
            sql = sql + " 	else 0";
            sql = sql + " 	end as Tagihan_601_putuslunas," ;
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Sambung is null then 0";
            sql = sql + " 	else 1";
            sql = sql + " 	end as Lembar_601_sambung, ";

            sql = sql + " case  	when Tgl_Pelunasan_601 is null  	" ;
            sql = sql + " or (to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') < '"; // + strLnsAwal + "'          ";
            sql = sql + " or to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') > '"; // + strLnsAkhir + "') ";
            sql = sql + " then 1 	else 0 	end as Lembar_601_Tidak_lunas, 	";
            sql = sql + " case  	when Tgl_Pelunasan_601 is null  	" ;
            sql = sql + " or (to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') < '"; // + strLnsAwal + "'          ";
            sql = sql + " or to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') > '"; // + strLnsAkhir + "') ";
            sql = sql + " then tul601.Tagihan_601 	else 0 	end as Tagihan_601_Tidak_lunas         ";

            sql = sql + "         from tul601 ";
            sql = sql + "         where to_char(tul601.Tgl_TUL601,'yyyymmdd') >= '"; // + strPkAwal + "' ";
            sql = sql + "         and   to_char(tul601.Tgl_TUL601,'yyyymmdd') <= '"; // + strPkAkhir + "' ";
            sql = sql + " 		  and   tul601.unitup = '" + unitUp + "' ";
            sql += sqlkriteria;
            sql = sql + " 	) t1";
            sql = sql + " 	group by";
            sql = sql + " 		trunc(t1.Tgl_TUL601),";
            sql = sql + " 		t1.UnitUP ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilRekap601Lunas_kriteria", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }



    @Override
    public Map<String, Object> ambilTulVIperNamaPutus(String nama,
                                                      Date tglAwal,
                                                      Date tglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "     select ";
            sql = sql + " 	UnitUP,Tgl_TUL601,No_TUL601,IdPelanggan,";
            sql = sql + " 	Nama,Alamat,ThBlRek,ThBlRek_akhir,Lembar_601,Tagihan_601,";
            sql = sql + " 	Tgl_Pelaksanaan_Putus,Nama_Putus,Stand_Lwbp_Putus,";
            sql = sql + " 	Tgl_Pelunasan_601,";
            sql = sql + " 	Tgl_Pelaksanaan_Sambung,Nama_Sambung,Stand_Lwbp_Sambung,";
            sql = sql + " 	Tgl_jatuh_tempo_601";
            sql = sql + " 	from tul601";
            sql = sql + " 	where NAMA_PUTUS = '" + nama + "' ";
            sql = sql + "   and to_char(tgl_tul601,'yyyymmdd') >= '"; // + strawal + "' ";
            sql = sql + "   and to_char(tgl_tul601,'yyyymmdd') <= '"; // + strakhir + "' ";
            sql += "";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilTulVIperNamaPutus", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilDetailTulVIperNamaPetugas(String nama,
                                                              Date tglAwal,
                                                              Date tglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select * from";
            sql = sql + " (";
            sql = sql + " select nama_putus as petugas, 'a) Pelanggan yang di-PUTUS' as kriteria, ";
            sql = sql + " 	   tgl_tul601 as tgl_PK, No_TUL601 as no_PK, tgl_pelaksanaan_putus as tgl_Realisasi, idpelanggan, nama, alamat, ";
            sql = sql + " 	   thblrek as thbl_awal, thblrek_akhir as thbl_akhir, lembar_601 as lembar, tagihan_601 as rptag, ";
            sql = sql + " 	   stand_lwbp_putus as lwbp, stand_wbp_putus as wbp, stand_kvarh_putus as kvarh, tgl_pelunasan_601 as tgl_lunas ";
            sql = sql + " from tul601 ";
            sql = sql + " where nama_putus = '" + nama + "' ";
            sql = sql + "  	  and to_char(tgl_tul601,'yyyymmdd') >= '"; // + strawal + "' ";
            sql = sql + "  	  and to_char(tgl_tul601,'yyyymmdd') <= '"; // + strakhir + "' " ;
            sql = sql + " order by kriteria, tgl_pk, tgl_realisasi, idpelanggan";
            sql = sql + " )";
            sql = sql + " union all";
            sql = sql + " select * from";
            sql = sql + " (";
            sql = sql + " select nama_putus as petugas, 'b) Pelanggan yang di-SAMBUNG' as kriteria, " ;
            sql = sql + " 	   tgl_tul601 as tgl_PK, No_TUL601 as no_PK, tgl_pelaksanaan_sambung as tgl_Realisasi, idpelanggan, nama, alamat, ";
            sql = sql + " 	   thblrek as thbl_awal, thblrek_akhir as thbl_akhir, lembar_601 as lembar, tagihan_601 as rptag, ";
            sql = sql + " 	   stand_lwbp_sambung as lwbp, stand_wbp_sambung as wbp, stand_kvarh_sambung as kvarh, tgl_pelunasan_601 as tgl_lunas ";
            sql = sql + " from tul601 " ;
            sql = sql + " where nama_sambung = '" + nama + "' " ;
            sql = sql + "  	  and to_char(tgl_tul601,'yyyymmdd') >= '"; // + strawal + "' ";
            sql = sql + "  	  and to_char(tgl_tul601,'yyyymmdd') <= '"; // + strakhir + "' ";
            sql = sql + " order by kriteria, tgl_pk, tgl_realisasi, idpelanggan";
            sql = sql + " )";
            sql = sql + " union all" ;
            sql = sql + " select * from";
            sql = sql + " (" ;
            sql = sql + " select nama_bongkar as petugas, 'c) Pelanggan yang di-BONGKAR' as kriteria, ";
            sql = sql + " 	   tgl_tul603 as tgl_PK, No_TUL603 as no_PK, tgl_pelaksanaan_bongkar as tgl_Realisasi, idpelanggan, nama, alamat, ";
            sql = sql + " 	   thblrek as thbl_awal, thblrek_akhir as thbl_akhir, lembar_603 as lembar, tagihan_603 as rptag, ";
            sql = sql + " 	   stand_lwbp_bongkar as lwbp, stand_wbp_bongkar as wbp, stand_kvarh_bongkar as kvarh, null as tgl_lunas ";
            sql = sql + " from tul603 " ;
            sql = sql + " where nama_bongkar = '" + nama + "' ";
            sql = sql + "  	  and to_char(tgl_tul603,'yyyymmdd') >= '"; // + strawal + "' ";
            sql = sql + "  	  and to_char(tgl_tul603,'yyyymmdd') <= '"; // + strakhir + "' ";
            sql = sql + " order by kriteria, tgl_pk, tgl_realisasi, idpelanggan";
            sql = sql + " )";
            sql += "";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDetailTulVIperNamaPetugas", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilTulVIRekapKinerja(String unitup,
                                                      Date tglAwal,
                                                      Date tglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "  select * from ";
            sql = sql + "  (";
            sql = sql + "  select petugas_penerima_pk as namapetugas, 'a) Jumlah PK PUTUS yang di-TERIMA' as kriteria, count(no_tul601) as jumlah from pkputus";
            sql = sql + "  where unitup = '" + unitup + "' and petugas_penerima_pk is not null ";
            sql = sql + "  	  and to_char(tgl_terima_pk,'yyyymmdd') >= '"; // + strawal + "' and to_char(tgl_terima_pk,'yyyymmdd') <= '"; // + strakhir + "'";
            sql = sql + "  group by petugas_penerima_pk " ;
            sql = sql + "  union";
            sql = sql + "  select nama_putus as namapetugas, 'b) Jumlah Pelanggan yang di-PUTUS' as kriteria, count(idpelanggan) as jumlah from tul601";
            sql = sql + "  where unitup = '" + unitup + "' and nama_putus is not null " ;
            sql = sql + "  	  and to_char(tgl_pelaksanaan_putus,'yyyymmdd') >= '"; // + strawal + "' and to_char(tgl_pelaksanaan_putus,'yyyymmdd') <= '"; // + strakhir + "'" ;
            sql = sql + "  group by nama_putus";
            sql = sql + "  union";
            sql = sql + "  select petugas_sambung as namapetugas, 'c) Jumlah PK SAMBUNG yang di-TERIMA' as kriteria, count(no_pk_sambung) as jumlah from pksambung";
            sql = sql + "  where unitup = '" + unitup + "' and petugas_sambung is not null " ;
            sql = sql + "  	  and to_char(created_at,'yyyymmdd') >= '"; // + strawal + "' and to_char(created_at,'yyyymmdd') <= '"; // + strakhir + "'";
            sql = sql + "  group by petugas_sambung ";
            sql = sql + "  union";
            sql = sql + "  select nama_sambung as namapetugas, 'd) Jumlah Pelanggan yang di-SAMBUNG' as kriteria, count(idpelanggan) as jumlah from tul601";
            sql = sql + "  where unitup = '" + unitup + "' and nama_sambung is not null ";
            sql = sql + "  	  and to_char(TGL_pelaksanaan_SAMBUNG,'yyyymmdd') >= '"; // + strawal + "' and to_char(TGL_pelaksanaan_SAMBUNG,'yyyymmdd') <= '"; // + strakhir + "'";
            sql = sql + "  group by nama_sambung";
            sql = sql + "  union";
            sql = sql + "  select petugas_penerima_pk as namapetugas, 'e) Jumlah PK BONGKAR yang di-TERIMA' as kriteria, count(no_tul603) as jumlah from pkbongkar";
            sql = sql + "  where unitup = '" + unitup + "' and petugas_penerima_pk is not null ";
            sql = sql + "  	  and to_char(tgl_terima_pk,'yyyymmdd') >= '"; // + strawal + "' and to_char(tgl_terima_pk,'yyyymmdd') <= '" + strakhir + "'"
            sql = sql + "  group by petugas_penerima_pk ";
            sql = sql + "  union" ;
            sql = sql + "  select nama_bongkar as namapetugas, 'f) Jumlah Pelanggan yang di-BONGKAR' as kriteria, count(idpelanggan) as jumlah from tul603" ;
            sql = sql + "  where unitup = '" + unitup + "' and nama_bongkar is not null " ;
            sql = sql + "  	  and to_char(tgl_pelaksanaan_bongkar,'yyyymmdd') >= '"; // + strawal + "' and to_char(tgl_pelaksanaan_bongkar,'yyyymmdd') <= '" + strakhir + "'"
            sql = sql + "  group by nama_bongkar";
            sql = sql + "  )" ;
            sql = sql + "  order by namapetugas, kriteria ";
            sql += "";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilTulVIRekapKinerja", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilTulVIperIdPel(String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "     select ";
            sql = sql + " 	UnitUP,Tgl_TUL601,No_TUL601,IdPelanggan,";
            sql = sql + " 	Nama,Alamat,ThBlRek,ThBlRek_akhir,Lembar_601,Tagihan_601,";
            sql = sql + " 	Tgl_Pelaksanaan_Putus,Nama_Putus,Stand_Lwbp_Putus,";
            sql = sql + " 	Tgl_Pelunasan_601,";
            sql = sql + " 	Tgl_Pelaksanaan_Sambung,Nama_Sambung,Stand_Lwbp_Sambung,";
            sql = sql + " 	Tgl_jatuh_tempo_601";
            sql = sql + " 	from tul601";
            sql = sql + " 	where IdPelanggan = '" + idpel + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilTulVIperIdPel", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambil601BelumLunas(String unitUp,
                                                  Date awal,
                                                  Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select ";
            sql = sql + " tgl_tul601,to_char(tgl_tul601,'yyyy-mm-dd')||'/TULVI-01/'||no_tul601 as no_tul601,idpelanggan,nokontrak,nokontrol,nama,alamat,lembar_601,thblrek,thblrek_akhir,tagihan_601,";
            sql = sql + " Tgl_Pelaksanaan_Putus,Nama_Putus,Stand_Lwbp_Putus,";
            sql = sql + " Tgl_Pelaksanaan_Sambung,Nama_Sambung,Stand_Lwbp_Sambung,";
            sql = sql + " Tgl_Pelunasan_601 ";
            sql = sql + " from tul601";
            sql = sql + " 	where unitup = '" + unitUp + "'";
            sql = sql + " 	and to_char(Tgl_TUL601,'yyyymmdd') >= '"; // + strAwal + "' ";
            sql = sql + " 	and to_char(Tgl_TUL601,'yyyymmdd') <= '"; // + strAkhir + "' ";
            sql = sql + " 	and Tgl_Pelunasan_601 is null";
            sql = sql + " 	";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambil601BelumLunas", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilTul601CetakUlang(String unitUp,
                                                     Date tglPk,
                                                     Integer noAwal,
                                                     Integer noAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " SELECT ";
            sql = sql + " 	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + " 	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + " 	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + " 	   dpp.unitup, dpp.idpel, dpp.nopel nokontrak, dpp.kdkelompok, dpp.kdinkaso, dpp.kddk nokontrol, dpp.nogardu AS";
            sql = sql + "        kdgardu, dpp.notiang AS notiang, dpp.nama, dpp.namapnj as namapnj, dpp.tarip, dpp.daya, ";
            sql = sql + "        kdgardu, dpp.nogardu||'/'||dpp.notiang AS notiang, dpp.nama, DPP.PNJ||' '||DPP.NAMAPNJ||DPP.NOBANG||DECODE(DECODE(TRIM(DPP.RT),NULL,'0',DPP.RT),'0',' ',' RT.'||DPP.RT)||DECODE(DECODE(TRIM(DPP.RW),NULL,'0',DPP.RW),'0',' ',' RW.'||DPP.RW)||' '||DPP.LINGKUNGAN AS NAMAPNJ, dpp.tarip, dpp.daya, ";
            sql = sql + "        dpp.kogol, dpptab.thblawal, dpptab.thblakhir, dpptab.lembar, ";
            sql = sql + "        dpptab.rptag, dpptab.rpbk, tul601.tgl_tul601, tul601.no_tul601, ";
            sql = sql + "        tul601.thblrek";
            sql = sql + "     FROM (SELECT ";
            sql = sql + " 	   	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + " 		   	  	idpel, min(blth)";
            sql = sql + "                  AS thblawal, max(blth) ";
            sql = sql + "                  AS thblakhir, count(idpel) AS lembar, sum(rptag) AS rptag, ";
            sql = sql + "                  sum(rpbk1 + rpbk2 + rpbk3) AS rpbk";
            sql = sql + "               FROM dpp PARTITION (saldo)";
            sql = sql + "               WHERE dpp.kdpembpp = 'R1'";
            sql = sql + "                 and dpp.kdgerakkeluar is null ";
            sql = sql + "                 AND dpp.unitup = '" + unitUp + "'";
            sql += " and dpp.blth <= to_char(sysdate,'yyyymm') ";
            sql = sql + "               GROUP BY idpel";
            sql = sql + " ) dpptab, DIL dpp,tul601";
            sql = sql + "     WHERE ";

            sql += " DPP.UNITUP = '" + unitUp + "' AND ";
            sql += " DPP.IDPEL = DPPTAB.IDPEL ";

            sql = sql + "       AND tul601.idpelanggan = dpptab.idpel";
            sql = sql + "       AND tul601.idpelanggan = dpp.idpel";
            sql = sql + "       AND tul601.thblrek = dpptab.thblawal";
            sql = sql + "       AND tul601.tgl_pelunasan_601 IS NULL";

            sql = sql + "   and tul601.unitup = '" + unitUp + "' ";
            sql = sql + " 	and to_char(tul601.Tgl_TUL601,'yyyymmdd') = '"; // + strTglPk + "' " ;
            sql = sql + " 	and tul601.No_TUL601 >=  " + noAwal + " " ;
            sql = sql + " 	and tul601.No_TUL601 <=  " + noAkhir + "";
            sql = sql + "   and tul601.TGL_PELAKSANAAN_PUTUS is null " ;
            sql = sql + "   order by tul601.No_TUL601 ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601CetakUlang", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    //---tambahan cetak PK Penyambungan Weleri 20090115
    @Override
    public Map<String, Object> AmbilTul601Penyambungan(String unitUp,
                                                       Date tglPk,
                                                       Integer noAwal,
                                                       Integer noAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " SELECT ";
            sql = sql + " 	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + " 	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + " 	   /* +index(dpp idx_dpp_unitup) */ " ;
            sql = sql + " 	   dpp.unitup, dpp.idpel, dpp.nopel nokontrak, dpp.kdkelompok, dpp.kdinkaso, dpp.kddk nokontrol, dpp.nogardu AS";
            sql = sql + "        kdgardu, dpp.notiang AS notiang, dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, ";
            sql = sql + "        kdgardu, dpp.nogardu||'/'||dpp.notiang AS notiang, dpp.nama, DPP.PNJ||' '||DPP.NAMAPNJ||' '||DPP.NOBANG||' '||DECODE(DECODE(TRIM(DPP.RT),NULL,'0',DPP.RT),'0',' ',' RT.'||DPP.RT)||DECODE(DECODE(TRIM(DPP.RW),NULL,'0',DPP.RW),'0',' ',' RW.'||DPP.RW)||' '||DPP.LINGKUNGAN AS NAMAPNJ, dpp.tarip, dpp.daya, ";
            sql = sql + "        dpp.kogol, dpptab.thblawal, dpptab.thblakhir, dpptab.lembar, " ;
            sql = sql + "        dpptab.rptag, dpptab.rpbk, tul601.tgl_tul601, tul601.no_tul601, ";
            sql = sql + "        tul601.thblrek";
            sql = sql + "     FROM (SELECT ";
            sql = sql + " 	   	   /* +index(dpp idx_dpp_unitup) */ " ;
            sql = sql + " 		   	  	idpel, min(blth)";
            sql = sql + "                  AS thblawal, max(blth) ";
            sql = sql + "                  AS thblakhir, count(idpel) AS lembar, sum(rptag) AS rptag, ";
            sql = sql + "                  sum(rpbk1 + rpbk2 + rpbk3) AS rpbk";
            sql = sql + "               FROM dpp PARTITION (lunas)";
            sql = sql + "               WHERE dpp.kdpembpp = 'R1'";
            sql = sql + "                 and dpp.kdgerakkeluar is not null ";
            sql = sql + "                 AND dpp.unitup = '" + unitUp + "'";
            sql += " and dpp.blth <= to_char(sysdate,'yyyymm') ";
            sql = sql + " and dpp.tglbayar >= '"; // + strTglPk + "' ";
            sql = sql + "               GROUP BY idpel";
            sql = sql + " ) dpptab, DIL dpp,tul601";
            sql = sql + "     WHERE ";

            sql += " DPP.UNITUP = '" + unitUp + "' AND ";
            sql += " DPP.IDPEL = DPPTAB.IDPEL ";

            sql = sql + "       AND tul601.idpelanggan = dpptab.idpel";
            sql = sql + "       AND tul601.idpelanggan = dpp.idpel";
            sql = sql + "       AND tul601.thblrek = dpptab.thblawal";
            sql = sql + "       AND tul601.tgl_pelunasan_601 IS NOT NULL";

            sql = sql + "   and tul601.unitup = '" + unitUp + "' " ;
            sql = sql + " 	and to_char(tul601.Tgl_TUL601,'yyyymmdd') = '"; // + strTglPk + "' " ;
            sql = sql + " 	and tul601.No_TUL601 >=  " + noAwal + " ";
            sql = sql + " 	and tul601.No_TUL601 <=  " + noAkhir + "";
            sql = sql + "   and tul601.TGL_PELAKSANAAN_PUTUS is not null ";
            sql = sql + "   order by tul601.No_TUL601 ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601Penyambungan", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    //---end tambahan cetak PK Penyambungan
    @Override
    public Map<String, Object> AmbilTul601CetakUlang_Deposit(String unitUp,
                                                             Date tglPk,
                                                             Integer noAwal,
                                                             Integer noAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " SELECT ";
            sql = sql + " 	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + " 	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + " 	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + " 	   dpp.unitup, dpp.idpel, dpp.nopel nokontrak, dpp.kddk nokontrol, dpp.nogardu AS";
            sql = sql + "        kdgardu, dpp.notiang AS notiang, dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, ";
            sql = sql + "        dpp.kogol, dpptab.thblawal, dpptab.thblakhir, dpptab.lembar, ";
            sql = sql + "        dpptab.rptag, dpptab.rpbk, tul601.tgl_tul601, tul601.no_tul601, ";
            sql = sql + "        tul601.thblrek";
            sql = sql + "     FROM (SELECT ";
            sql = sql + " 	   	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + " 		   	  	idpel, min(blth)";
            sql = sql + "                  AS thblawal, max(blth) ";
            sql = sql + "                  AS thblakhir, count(idpel) AS lembar, sum(rptag) AS rptag, ";
            sql = sql + "                  sum(rpbk1 + rpbk2 + rpbk3) AS rpbk";
            sql = sql + "               FROM dpp PARTITION (saldo)";
            sql = sql + "               WHERE dpp.kdpembpp = 'R1'";
            sql = sql + "                 and dpp.kdgerakkeluar is null ";
            sql = sql + "                 AND dpp.unitup = '" + unitUp + "'";
            sql += " and dpp.blth <= to_char(sysdate,'yyyymm') ";
            sql = sql + "               GROUP BY idpel";
            sql = sql + "     UNION ALL ";
            sql = sql + " 	   SELECT     ";
            sql = sql + " 		   	  	idpel, min(blth)";
            sql = sql + "                  AS thblawal, max(blth) ";
            sql = sql + "                  AS thblakhir, count(idpel) AS lembar, sum(rptag) AS rptag, ";
            sql = sql + "                  sum(rpbk1 + rpbk2 + rpbk3) AS rpbk";
            sql = sql + "               FROM dppdeposit PARTITION (saldo) dpp ";
            sql = sql + "               WHERE dpp.kdpembpp = 'R1'";
            sql = sql + "                 AND dpp.unitup = '" + unitUp + "'";
            sql += " and dpp.blth <= to_char(sysdate,'yyyymm') ";
            sql = sql + "               GROUP BY idpel";
            sql = sql + " ) dpptab, DIL dpp,tul601";
            sql = sql + "     WHERE ";

            sql += " DPP.UNITUP = '" + unitUp + "' AND ";
            sql += " DPP.IDPEL = DPPTAB.IDPEL ";

            sql = sql + "       AND tul601.idpelanggan = dpptab.idpel";
            sql = sql + "       AND tul601.idpelanggan = dpp.idpel";
            sql = sql + "       AND tul601.thblrek = dpptab.thblawal";
            sql = sql + "       AND tul601.tgl_pelunasan_601 IS NULL";

            sql = sql + "   and tul601.unitup = '" + unitUp + "' ";
            sql = sql + " 	and to_char(tul601.Tgl_TUL601,'yyyymmdd') = '"; // + strTglPk + "' " ;
            sql = sql + " 	and tul601.No_TUL601 >=  " + noAwal + " ";
            sql = sql + " 	and tul601.No_TUL601 <=  " + noAkhir + "";
            sql = sql + "   and tul601.TGL_PELAKSANAAN_PUTUS is null ";
            sql = sql + "   order by tul601.No_TUL601 ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601CetakUlang_Deposit", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> AmbilTul601CetakUlangKriteria(String unitUp,
                                                             Date tglPk,
                                                             Integer noAwal,
                                                             Integer noAkhir,
                                                             Date tglpk2,
                                                             String kolok) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " SELECT ";
            sql = sql + " 	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + " 	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + " 	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + " 	   dpp.unitup, dpp.idpel, dpp.nopel nokontrak, dpp.kdkelompok, dpp.kdinkaso, dpp.kddk nokontrol, dpp.nogardu AS";
            sql = sql + "        kdgardu, dpp.notiang AS notiang, dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, ";
            sql = sql + "        dpp.kogol, dpptab.thblawal, dpptab.thblakhir, dpptab.lembar, ";
            sql = sql + "        dpptab.rptag, dpptab.rpbk, tul601.tgl_tul601, tul601.no_tul601, ";
            sql = sql + "        tul601.thblrek";
            sql = sql + "     FROM (SELECT ";
            sql = sql + " 	   	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + " 		   	  	idpel, min(blth)";
            sql = sql + "                  AS thblawal, max(blth) ";
            sql = sql + "                  AS thblakhir, count(idpel) AS lembar, sum(rptag) AS rptag, ";
            sql = sql + "                  sum(rpbk1 + rpbk2 + rpbk3) AS rpbk";
            sql = sql + "               FROM dpp PARTITION (saldo)";
            sql = sql + "               WHERE dpp.kdpembpp = 'R1'";
            sql = sql + "                 and dpp.kdgerakkeluar is null ";
            sql = sql + "                 AND dpp.unitup = '" + unitUp + "'" ;
            sql += " and dpp.blth <= to_char(sysdate,'yyyymm') ";
            sql = sql + "               GROUP BY idpel" ;

            sql = sql + " ) dpptab, DIL dpp,tul601";
            sql = sql + "     WHERE ";

            sql += " DPP.UNITUP = '" + unitUp + "' AND ";
            sql += " DPP.IDPEL = DPPTAB.IDPEL ";

            sql = sql + "       AND tul601.idpelanggan = dpptab.idpel";
            sql = sql + "       AND tul601.idpelanggan = dpp.idpel";
            sql = sql + "       AND tul601.thblrek = dpptab.thblawal" ;
            sql = sql + "       AND tul601.tgl_pelunasan_601 IS NULL";
            sql = sql + "   and tul601.unitup = '" + unitUp + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601CetakUlangKriteria", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilTul601CetakUlangKriteria_Deposit(String unitUp,
                                                                     Date tglPk,
                                                                     Integer noAwal,
                                                                     Integer noAkhir,
                                                                     Date tglpk2,
                                                                     String kolok) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " SELECT ";
            sql = sql + " 	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + " 	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + " 	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + " 	   dpp.unitup, dpp.idpel, dpp.nopel nokontrak, dpp.kddk nokontrol, dpp.nogardu AS";
            sql = sql + "        kdgardu, dpp.notiang AS notiang, dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, ";
            sql = sql + "        dpp.kogol, dpptab.thblawal, dpptab.thblakhir, dpptab.lembar, ";
            sql = sql + "        dpptab.rptag, dpptab.rpbk, tul601.tgl_tul601, tul601.no_tul601, ";
            sql = sql + "        tul601.thblrek";
            sql = sql + "     FROM (SELECT ";
            sql = sql + " 	   	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + " 		   	  	idpel, min(blth)";
            sql = sql + "                  AS thblawal, max(blth) ";
            sql = sql + "                  AS thblakhir, count(idpel) AS lembar, sum(rptag) AS rptag, ";
            sql = sql + "                  sum(rpbk1 + rpbk2 + rpbk3) AS rpbk";
            sql = sql + "               FROM dpp PARTITION (saldo)";
            sql = sql + "               WHERE dpp.kdpembpp = 'R1'";
            sql = sql + "                 and dpp.kdgerakkeluar is null ";
            sql = sql + "                 AND dpp.unitup = '" + unitUp + "'";
            sql += " and dpp.blth <= to_char(sysdate,'yyyymm') " ;
            sql = sql + "               GROUP BY idpel";
            sql = sql + "           UNION ALL ";
            sql = sql + "          SELECT /* +index(dpp idx_dpp_unitup) */ idpel, ";
            sql = sql + "                    MIN (blth) AS thblawal, MAX (blth) AS thblakhir, ";
            sql = sql + "                    COUNT (idpel) AS lembar, SUM (rptag) AS rptag, ";
            sql = sql + "                    SUM (rpbk1 + rpbk2 + rpbk3) AS rpbk ";
            sql = sql + "              FROM dppdeposit PARTITION (saldo) dpp ";
            sql = sql + "             WHERE dpp.kdpembpp = 'R1' ";
            sql = sql + "                 AND dpp.unitup = '" + unitUp + "'" ;
            sql = sql + "               AND dpp.blth <= TO_CHAR (SYSDATE, 'yyyymm') ";
            sql = sql + "          GROUP BY idpel           ";

            sql = sql + " ) dpptab, DIL dpp,tul601" ;
            sql = sql + "     WHERE ";

            sql += " DPP.UNITUP = '" + unitUp + "' AND ";
            sql += " DPP.IDPEL = DPPTAB.IDPEL ";

            sql = sql + "       AND tul601.idpelanggan = dpptab.idpel";
            sql = sql + "       AND tul601.idpelanggan = dpp.idpel";
            sql = sql + "       AND tul601.thblrek = dpptab.thblawal";
            sql = sql + "       AND tul601.tgl_pelunasan_601 IS NULL";
            sql = sql + "   and tul601.unitup = '" + unitUp + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601CetakUlangKriteria_Deposit", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilTul601Lampiran(String unitUp,
                                                   Date tglPk,
                                                   Integer noTul) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select ";
            sql = sql + " /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + " /* +index(dpp idx_dpp_idpel) */";
            sql = sql + " /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + " d.unitup, d.idpel, to_char(to_date(d.blth,'yyyymm'),'Mon-yyyy') as bulan, ";
            sql = sql + " d.pnj, d.nama, d.namapnj, d.rt, d.lingkungan, d.kodepos, d.tarip, d.daya, d.kogol, d.nopel, d.kddk, ";
            sql = sql + " d.slalwbp, d.sahlwbp, d.slawbp, d.sahwbp, d.slakvarh, d.sahkvarh, d.fakm, d.fakmkvarh, d.kwhlwbp, d.kwhwbp, d.blok3, d.pemkwh, d.kwhkvarh,";
            sql = sql + " to_date(d.tglbayar,'yyyymmdd') as tglbayar, d.kdpp, d.kdpembayar, ";
            sql = sql + " d.uploadtime, to_date(d.tgljttempo,'yyyymmdd') as tgljatuhtempo, d.kdgerakmasuk, d.kdgerakkeluar, d.tgkoreksi,";
            sql = sql + " d.rpptl, d.rpppn, d.rpbpju, d.rptrafo, d.rpmat, d.rpbk1+d.rpbk2+d.rpbk3 as rpbk,";
            sql = sql + " t.lembar_601, t.tagihan_601, t.thblrek, t.thblrek_akhir, t.tgl_tul601 as tgl_601, t.No_TUL601 as no_601, t.unitup || '/VI-01/' || to_char(t.tgl_Tul601,'ddMMyyyy') || '-' || t.no_tul601 as blth ";
            sql = sql + " from dpp PARTITION(SALDO) d, tul601 t";
            sql = sql + " where d.kdpembpp = 'R1'";
            sql += " and d.blth <= to_char(sysdate,'yyyymm') ";
            sql = sql + " and t.idpelanggan = d.idpel";
            sql = sql + " and d.blth >= t.thblrek" ;

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601Lampiran", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilTul601LampiranKriteria(String unitUp,
                                                           Date tglPk,
                                                           Integer noTul,
                                                           Date tglPk2,
                                                           String kolok) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select ";
            sql = sql + " /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + " /* +index(dpp idx_dpp_idpel) */";
            sql = sql + " /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + " d.unitup, d.idpel, to_char(to_date(d.blth,'yyyymm'),'Mon-yyyy') as bulan, ";
            sql = sql + " d.pnj, d.nama, d.namapnj, d.rt, d.lingkungan, d.kodepos, d.tarip, d.daya, d.kogol, d.nopel, d.kddk, ";
            sql = sql + " d.slalwbp, d.sahlwbp, d.slawbp, d.sahwbp, d.slakvarh, d.sahkvarh, d.fakm, d.fakmkvarh, d.kwhlwbp, d.kwhwbp, d.blok3, d.pemkwh, d.kwhkvarh,";
            sql = sql + " to_date(d.tglbayar,'yyyymmdd') as tglbayar, d.kdpp, d.kdpembayar, ";
            sql = sql + " d.uploadtime, to_date(d.tgljttempo,'yyyymmdd') as tgljatuhtempo, d.kdgerakmasuk, d.kdgerakkeluar, d.tgkoreksi,";
            sql = sql + " d.rpptl, d.rpppn, d.rpbpju, d.rptrafo, d.rpmat, d.rpbk1+d.rpbk2+d.rpbk3 as rpbk," ;
            sql = sql + " t.lembar_601, t.tagihan_601, t.thblrek, t.thblrek_akhir, t.tgl_tul601 as tgl_601, t.No_TUL601 as no_601, t.unitup || '/VI-01/' || to_char(t.tgl_Tul601,'ddMMyyyy') || '-' || t.no_tul601 as blth ";
            sql = sql + " from dpp PARTITION(SALDO) d, tul601 t";
            sql = sql + " where d.kdpembpp = 'R1'";
            sql += " and d.blth <= to_char(sysdate,'yyyymm') ";
            sql = sql + " and t.idpelanggan = d.idpel";
            sql = sql + " and d.blth >= t.thblrek";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601LampiranKriteria", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    //--- Tul VI-03
    @Override
    public Map<String, Object> ambilNomerTulVI03(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select max(no_tul603) as nomer from tul603 ";
            sql += " where ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNomerTulVI03", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> AmbilTul603(Boolean is60hari,
                                           String unitUp,
                                           String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select xxx.unitup, idpel, xxx.nokontrak, xxx.nokontrol, kdgardu, notiang, ";
            sql = sql + "      xxx.nama, namapnj, tarip, daya, kogol, ";
            sql = sql + "  	   thblawal, thblakhir, lembar, rptag, rpbk,";
            sql = sql + "  	   tgl_jatuh_tempo_601, xxx.no_60, xxx.no_601, xxx.no_tul601, xxx.tgl_tul601, xxx.thblrek, sysdate as tgl_catat_60,0 as SUDAHCETAK ";
            sql = sql + " from";
            sql = sql + " (";
            sql = sql + " select ";
            sql = sql + "  	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + "  	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + "  	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + "        dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.nogardu as kdgardu, dpp.notiang as notiang, ";
            sql = sql + "        dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.nogardu as kdgardu, dpp.nogardu||'/'||dpp.notiang as notiang, ";
            sql = sql + "   	 dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, dpp.kogol, ";
            sql = sql + "   	 dpp.nama, DPP.PNJ||' '||DPP.NAMAPNJ||' '||DPP.NOBANG||' '||DECODE(DECODE(TRIM(DPP.RT),NULL,'0',DPP.RT),'0',' ',' RT.'||DPP.RT)||DECODE(DECODE(TRIM(DPP.RW),NULL,'0',DPP.RW),'0',' ',' RW.'||DPP.RW)||' '||DPP.LINGKUNGAN AS NAMAPNJ, dpp.tarip, dpp.daya, dpp.kogol, ";
            sql = sql + "  	     dppTab.thblawal, dppTab.thblakhir, dppTab.lembar, dppTab.rptag, dppTab.rpbk,";
            sql = sql + "  	     tul601.tgl_jatuh_tempo_601, tul601.no_60, tul601.no_601, tul601.no_tul601, tul601.tgl_tul601, tul601.thblrek" ;
            sql = sql + " from";
            sql = sql + "  	   (SELECT  idpel, MIN(DECODE(NOAGENDA,NULL,BLTH,NULL)) as thblawal, MAX(DECODE(NOAGENDA,NULL,BLTH,NULL)) as thblakhir, ";
            sql = sql + "  	   SUM(DECODE (noagenda, NULL, 1, DECODE (norek, 'KE0001', 1, 0)))  as Lembar, sum(RpTag) as rpTag,sum(RpBK1+RpBK2+RpBK3) as RpBK" ;
            sql = sql + "  	   FROM  dpp partition(saldo) ";
            sql = sql + "  	   where ";
            sql = sql + "  			dpp.kdpembPp = 'R1' ";
            sql = sql + "           and kdgerakkeluar is null ";
            sql += " and substr(dpp.tgljttempo,1,6) <= to_char(sysdate,'yyyymm') ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul603", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilTul603_Incl_Sdhcetak(Boolean is60hari,
                                                         String unitUp,
                                                         String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select xxx.unitup, idpel, xxx.nokontrak, xxx.nokontrol, kdgardu, notiang, ";
            sql = sql + "      xxx.nama, namapnj, tarip, daya, kogol, ";
            sql = sql + "  	   thblawal, thblakhir, lembar, rptag, rpbk,";
            sql = sql + "  	   tgl_jatuh_tempo_601, xxx.no_60, xxx.no_601, xxx.no_tul601, xxx.tgl_tul601, xxx.thblrek, sysdate as tgl_catat_60 ";
            sql = sql + " ,    DECODE(tul603.No_601,null,0,1) as SUDAHCETAK";
            sql = sql + " from";
            sql = sql + " (";
            sql = sql + " select ";
            sql = sql + "  	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + "  	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + "  	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + "        dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.nogardu as kdgardu, dpp.notiang as notiang, ";
            sql = sql + "   	 dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, dpp.kogol, ";
            sql = sql + "  	     dppTab.thblawal, dppTab.thblakhir, dppTab.lembar, dppTab.rptag, dppTab.rpbk,";
            sql = sql + "  	     tul601.tgl_jatuh_tempo_601, tul601.no_60, tul601.no_601, tul601.no_tul601, tul601.tgl_tul601, tul601.thblrek";
            sql = sql + " from" ;
            sql = sql + "  	   (SELECT  idpel, MIN(DECODE(NOAGENDA,NULL,BLTH,NULL)) as thblawal, MAX(DECODE(NOAGENDA,NULL,BLTH,NULL)) as thblakhir, " ;
            sql = sql + "  	   SUM(DECODE (noagenda, NULL, 1, DECODE (norek, 'KE0001', 1, 0)))  as Lembar, sum(RpTag) as rpTag,sum(RpBK1+RpBK2+RpBK3) as RpBK" ;
            sql = sql + "  	   FROM  dpp partition(saldo) " ;
            sql = sql + "  	   where ";
            sql = sql + "  			dpp.kdpembPp = 'R1' ";
            sql = sql + "           and kdgerakkeluar is null ";
            sql += " and substr(dpp.tgljttempo,1,6) <= to_char(sysdate,'yyyymm') ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul603_Incl_Sdhcetak", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> insertTulVI03(Integer No_60,
                                             Integer no_601,
                                             String UnitUP,
                                             String ThBlRek,
                                             String IdPelanggan,
                                             String NoKontrak,
                                             String NoKontrol,
                                             String Nama,
                                             String Alamat,
                                             String ThBlRek_akhir,
                                             String Lembar_603,
                                             String Tagihan_603,
                                             String NOtul603,
                                             String NOtul601,
                                             Date tglTul601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "  INSERT INTO TUL603 ";
            sql = sql + "  (no_603,no_601,No_60,UnitUP,ThBlRek,IdPelanggan, NoKontrak,NoKontrol, Nama,Alamat,";
            sql = sql + "  No_TUL601,Tgl_TUL601, no_tul603, tgl_tul603, ThBlRek_akhir,Lembar_603,Tagihan_603)";
            sql = sql + "  VALUES( seq_tul603.nextval, ";
            sql = sql + "  '" + no_601 + "', '" + No_60 + "', '" + UnitUP + "', '" + ThBlRek + "', '" + IdPelanggan + "', ";
            sql = sql + "  '" + NoKontrak + "', '" + NoKontrol + "', " ;
            sql = sql + "  '" + Nama + "', '" + Alamat + "', '" + NOtul601 + "', to_date('"; // + strTglTul601 + "','yyyymmdd'), '" + NOtul603 + "', sysdate, ";
            sql = sql + "  '" + ThBlRek_akhir + "', '" + Lembar_603 + "', '" + Tagihan_603 + "')";
            sql += "";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("insertTulVI03", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilCetakKertasTulVI() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select par_value from sip3_konfigurasi where par_name = 'KERTASWASKIT' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("insertTulVI03", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    //--- Pemutusan Penyambungan
    @Override
    public Map<String, Object> ambilDetailTul601(String strtgl,
                                                 String noTul,
                                                 String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select NO_601, NO_60, UNITUP, THBLREK, IDPELANGGAN, NOKONTRAK, NOKONTROL, NAMA, ALAMAT, NO_TUL601, TGL_TUL601, STAND_LWBP_601, STAND_WBP_601, STAND_KVARH_601, THBLREK_AKHIR, LEMBAR_601, TAGIHAN_601, BLTHREK_601, TGL_PELAKSANAAN_PUTUS, NAMA_PUTUS, STAND_LWBP_PUTUS, STAND_WBP_PUTUS, STAND_KVARH_PUTUS, TGL_PELUNASAN_601, NO_601_SAMBUNG, TGL_601_SAMBUNG, TGL_PELAKSANAAN_SAMBUNG, NAMA_SAMBUNG, STAND_LWBP_SAMBUNG, STAND_WBP_SAMBUNG, STAND_KVARH_SAMBUNG, TGL_JATUH_TEMPO_601 ";
            sql = sql + " from tul601 ";
            sql = sql + " where to_char(tgl_tul601,'yyyymmdd') = '" + strtgl + "' " ;
            sql = sql + " and no_tul601 = '" + noTul + "' ";
            sql = sql + " AND UNITUP='" + unitup + "'";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDetailTul601", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    //--- Pemutusan Penyambungan
    @Override
    public Map<String, Object> ambilDetailTul603(String strtgl,
                                                 String noTul,
                                                 String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select NO_603,NO_60,UNITUP, THBLREK, IDPELANGGAN, NOKONTRAK, NOKONTROL, NAMA, ALAMAT,NO_TUL603, TGL_TUL603,  ";
            sql = sql + " THBLREK_AKHIR, LEMBAR_603, TAGIHAN_603,TGL_PELAKSANAAN_BONGKAR, NAMA_BONGKAR,STAND_LWBP_BONGKAR, STAND_WBP_BONGKAR, STAND_KVARH_BONGKAR ";
            sql = sql + " from tul603 ";
            sql = sql + " where to_char(tgl_tul603,'yyyymmdd') = '" + strtgl + "' ";
            sql = sql + " and no_tul603 = '" + noTul + "' ";
            sql = sql + " and  UNITUP='" + unitup + "'";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDetailTul603", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilDetailTul601SdhPutus(String strtgl,
                                                         String noTul,
                                                         String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select NO_601, NO_60, UNITUP, THBLREK, IDPELANGGAN, NOKONTRAK, NOKONTROL, NAMA, ALAMAT, NO_TUL601, TGL_TUL601, STAND_LWBP_601, STAND_WBP_601, STAND_KVARH_601, THBLREK_AKHIR, LEMBAR_601, TAGIHAN_601, BLTHREK_601, TGL_PELAKSANAAN_PUTUS, NAMA_PUTUS, STAND_LWBP_PUTUS, STAND_WBP_PUTUS, STAND_KVARH_PUTUS, TGL_PELUNASAN_601, NO_601_SAMBUNG, TGL_601_SAMBUNG, TGL_PELAKSANAAN_SAMBUNG, NAMA_SAMBUNG, STAND_LWBP_SAMBUNG, STAND_WBP_SAMBUNG, STAND_KVARH_SAMBUNG, TGL_JATUH_TEMPO_601 ";
            sql = sql + " from tul601 ";
            sql = sql + " where to_char(tgl_tul601,'yyyymmdd') = '" + strtgl + "' ";
            sql = sql + " and no_tul601 = '" + noTul + "' ";
            sql = sql + " and unitup = '" + unitup + "' ";
            sql = sql + " and tgl_pelaksanaan_putus is not null ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDetailTul601SdhPutus", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilDetailTul601SdhPutusLunas(String strtgl,
                                                              String noTul,
                                                              String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select NO_601, NO_60, UNITUP, THBLREK, IDPELANGGAN, NOKONTRAK, NOKONTROL, NAMA, ALAMAT, NO_TUL601, TGL_TUL601, STAND_LWBP_601, STAND_WBP_601, STAND_KVARH_601, THBLREK_AKHIR, LEMBAR_601, TAGIHAN_601, BLTHREK_601, TGL_PELAKSANAAN_PUTUS, NAMA_PUTUS, STAND_LWBP_PUTUS, STAND_WBP_PUTUS, STAND_KVARH_PUTUS, TGL_PELUNASAN_601, NO_601_SAMBUNG, TGL_601_SAMBUNG, TGL_PELAKSANAAN_SAMBUNG, NAMA_SAMBUNG, STAND_LWBP_SAMBUNG, STAND_WBP_SAMBUNG, STAND_KVARH_SAMBUNG, TGL_JATUH_TEMPO_601 ";
            sql = sql + " from tul601 ";
            sql = sql + " where to_char(tgl_tul601,'yyyymmdd') = '" + strtgl + "' ";
            sql = sql + " and no_tul601 = '" + noTul + "' ";
            sql = sql + " and unitup = '" + unitup + "' ";
            sql = sql + " and tgl_pelaksanaan_putus is not null ";
            sql = sql + " and tgl_pelunasan_601 is not null ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDetailTul601SdhPutusLunas", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpanPutus(Date tglPutus,
                                           String namaPutus,
                                           String lwbp,
                                           String wbp,
                                           String kvarh,
                                           Date tgl601,
                                           String no601,
                                           String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " update tul601 set";
            sql = sql + " tgl_pelaksanaan_putus = to_date('"; // + strTglPutus + "','yyyymmdd'), ";
            sql = sql + " nama_putus = '" + namaPutus + "'," ;
            sql = sql + " stand_lwbp_putus = '" + lwbp + "',";
            sql = sql + " stand_wbp_putus = '" + wbp + "',";
            sql = sql + " stand_kvarh_putus = '" + kvarh + "'";
            sql = sql + " where ";
            sql = sql + " to_char(tgl_tul601,'yyyymmdd') = '"; // + strTgl601 + "'" ;
            sql = sql + " and no_tul601 = '" + no601 + "'";
            sql = sql + " and unitup = '" + unitUp + "' ";
            sql = sql + "  ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanPutus", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpanSambung(Date tglsambung,
                                             String namasambung,
                                             String lwbp,
                                             String wbp,
                                             String kvarh,
                                             Date tgl601,
                                             String no601,
                                             String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " update tul601 set";
            sql = sql + " tgl_pelaksanaan_sambung = to_date('"; // + strTglsambung + "','yyyymmdd'), ";
            sql = sql + " nama_sambung = '" + namasambung + "',";
            sql = sql + " stand_lwbp_sambung = '" + lwbp + "',";
            sql = sql + " stand_wbp_sambung = '" + wbp + "',";
            sql = sql + " stand_kvarh_sambung = '" + kvarh + "'";
            sql = sql + " where ";
            sql = sql + " to_char(tgl_tul601,'yyyymmdd') = '"; // + strTgl601 + "'";
            sql = sql + " and no_tul601 = '" + no601 + "'";
            sql = sql + " and unitup = '" + unitUp + "' ";
            sql = sql + "  ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanSambung", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpanBongkar(Date tglbongkar,
                                             String namabongkar,
                                             String lwbp,
                                             String wbp,
                                             String kvarh,
                                             Date tgl603,
                                             String no603,
                                             String unitUp,
                                             Date tglkode3,
                                             String nokode3) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " update tul603 set";
            sql = sql + " tgl_pelaksanaan_bongkar = to_date('"; // + strTglbongkar + "','yyyymmdd'), " ;
            sql = sql + " nama_bongkar = '" + namabongkar + "',";
            sql = sql + " stand_lwbp_bongkar = '" + lwbp + "',";
            sql = sql + " stand_wbp_bongkar = '" + wbp + "',";
            sql = sql + " stand_kvarh_bongkar = '" + kvarh + "'," ;
            sql = sql + " no_kode_3 = '" + nokode3 + "',";
            sql = sql + " tgl_kode_3 = to_date('"; // + strtglkode3 + "','yyyymmdd') " ;
            sql = sql + " where ";
            sql = sql + " to_char(tgl_tul603,'yyyymmdd') = '"; // + strTgl603 + "'";
            sql = sql + " and no_tul603 = '" + no603 + "'";
            sql = sql + " and unitup = '" + unitUp + "' ";
            sql = sql + "  " ;

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanBongkar", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> UPDATE_DIL_N(String p_unitup,
                                            String p_idpel,
                                            String p_catatby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " BEGIN";
            sql += " UPDATE_DIL_PDL_N('" + p_unitup + "','" + p_idpel + "','" + p_catatby + "');";
            sql += " END; ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("UPDATE_DIL_N", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> UPDATE_DIL_O(String p_unitup,
                                            String p_idpel,
                                            String p_catatby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " BEGIN";
            sql += " UPDATE_DIL_PDL_O('" + p_unitup + "','" + p_idpel + "','" + p_catatby + "');";
            sql += " END; ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("UPDATE_DIL_O", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilBuatCetakTul603(String txtIdpel,
                                                    String unitUp,
                                                    String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "  select t.*,d.* from ";
            sql = sql + "  (" ;
            sql = sql + " select ";
            sql = sql + " xxx.unitup || '/VI-01/' || to_char(xxx.tgl_tul601,'ddmmyyyy') || '-' || xxx.no_tul601 as nomer601, ";
            sql = sql + " xxx.unitup, idpel, xxx.nokontrak, xxx.nokontrol, kdgardu,  notiang, ";
            sql = sql + "      xxx.nama, namapnj, tarip, daya, kogol, ";
            sql = sql + "  	   thblawal, thblakhir, lembar, rptag, rpbk,";
            sql = sql + "  	   xxx.tgl_jatuh_tempo_601 as tgl_jatuh_tempo_601, xxx.no_60, xxx.no_601, " ;
            sql = sql + " tul603.no_tul603 as no_tul601, nvl(tul603.tgl_tul603,sysdate) tgl_tul601, xxx.unitup || '/VI-03/' || to_char(tul603.tgl_tul603,'ddmmyyyy') || '-' || tul603.no_tul603 as thblrek,sysdate as tglcetak " ;
            sql = sql + " from" ;
            sql = sql + " (";
            sql = sql + " select ";
            sql = sql + "  	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + "  	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + "  	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + "        dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.nogardu as kdgardu, dpp.nogardu||'/'||dpp.notiang as notiang, ";
            sql = sql + "        dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.nogardu as kdgardu, dpp.notiang as notiang, " ;
            sql = sql + "   	 dpp.nama, DPP.PNJ||' '||TRIM(DPP.NAMAPNJ)||' '||DPP.NOBANG||' '||DECODE(DECODE(TRIM(DPP.RT),NULL,'0',DPP.RT),'0',' ',' RT.'||DPP.RT)||DECODE(DECODE(TRIM(DPP.RW),NULL,'0',DPP.RW),'0',' ',' RW.'||DPP.RW)||' '||DPP.LINGKUNGAN AS NAMAPNJ, dpp.tarip, dpp.daya, dpp.kogol, " ;
            sql = sql + "  	     dppTab.thblawal, dppTab.thblakhir, dppTab.lembar, dppTab.rptag, dppTab.rpbk,";
            sql = sql + "  	     tul601.tgl_jatuh_tempo_601, tul601.no_60, tul601.no_601, tul601.no_tul601, tul601.tgl_tul601, tul601.thblrek";
            sql = sql + " from";
            sql = sql + "  	   (SELECT  idpel, MIN(DECODE(NOAGENDA,NULL,BLTH,NULL)) as thblawal, MAX(DECODE(NOAGENDA,NULL,BLTH,NULL)) as thblakhir, ";
            sql = sql + "  	   SUM(DECODE (noagenda, NULL, 1, DECODE (norek, 'KE0001', 1, 0))) as Lembar, sum(RpTag) as rpTag,sum(RpBK1+RpBK2+RpBK3) as RpBK";
            sql = sql + "  	   FROM  dpp partition(saldo) ";
            sql = sql + "  	   where ";
            sql = sql + "  			dpp.kdpembPp = 'R1' ";
            sql = sql + "           and dpp.kdgerakkeluar is null ";
            sql += " and substr(dpp.tgljttempo,1,6) <= to_char(sysdate,'yyyymm') ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilBuatCetakTul603", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilBuatCetakTul603_BA(String txtIdpel,
                                                       String unitUp,
                                                       String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "  select t.*,d.* from ";
            sql = sql + "  (";
            sql = sql + " select ";
            sql = sql + " xxx.unitup || '/VI-01/' || to_char(xxx.tgl_tul601,'ddmmyyyy') || '-' || xxx.no_tul601 as nomer601, ";
            sql = sql + " xxx.unitup, idpel, xxx.nokontrak, xxx.nokontrak as no_kontrak, xxx.nokontrol, kdgardu, notiang,'WILAYAH KALIMANTAN TIMUR' AS NAMA_INDUK, ";
            sql = sql + "      xxx.nama, xxx.nama as nama_pelanggan, namapnj,namapnj as nama_jalan, tarip, daya, kogol, ";
            sql = sql + "  	   thblawal, thblakhir, lembar, rptag, rpbk,(select ap.nama from unitap ap,unitup up where ap.unitap=up.unitap and xxx.unitup=up.unitup) as NAMA_CABANG,";
            sql = sql + "    (SELECT NAMA FROM UNITUP UP WHERE UP.UNITUP=XXX.UNITUP) AS NAMA_RANTING, ";
            sql = sql + "    (SELECT ALAMAT FROM UNITUP UP WHERE UP.UNITUP=XXX.UNITUP) AS ALAMAT, ";
            sql = sql + "    (SELECT TELEPON FROM UNITUP UP WHERE UP.UNITUP=XXX.UNITUP) AS TELEPON, ";
            sql = sql + "      xxx.nokontrol as kode_kedudukan, ";
            sql = sql + "  	   tul603.tgl_tul603 as tgl_jatuh_tempo_601, tul603.tgl_tul603 as TANGGAL_PERINTAH_KERJA, xxx.no_60, xxx.no_601, " ;
            sql = sql + " tul603.no_tul603 as no_tul601, xxx.tgl_tul601, xxx.unitup || '/VI-03/' || to_char(tul603.tgl_tul603,'ddmmyyyy') || '-' || tul603.no_tul603 as thblrek,xxx.unitup || '/VI-03/' || to_char(tul603.tgl_tul603,'ddmmyyyy') || '-' || tul603.no_tul603 as NOCETAKTUL603 ";
            sql = sql + " , rptag + rpbk as TAGIHAN,LEMBAR AS TOTALLEMBAR ";
            sql = sql + " from" ;
            sql = sql + " (";
            sql = sql + " select " ;
            sql = sql + "  	   /* +index(dpp idx_dpp_blth) */ " ;
            sql = sql + "  	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + "  	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + "        dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.nogardu as kdgardu, dpp.notiang as notiang, ";
            sql = sql + "   	 dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, dpp.kogol, ";
            sql = sql + "  	     dppTab.thblawal, dppTab.thblakhir, dppTab.lembar, dppTab.rptag, dppTab.rpbk,";
            sql = sql + "  	     tul601.tgl_jatuh_tempo_601, tul601.no_60, tul601.no_601, tul601.no_tul601, tul601.tgl_tul601, tul601.thblrek" ;
            sql = sql + " from";
            sql = sql + "  	   (SELECT  idpel, MIN(DECODE(NOAGENDA,NULL,BLTH,NULL)) as thblawal, MAX(DECODE(NOAGENDA,NULL,BLTH,NULL)) as thblakhir, ";
            sql = sql + "  	   SUM(DECODE (noagenda, NULL, 1, DECODE (norek, 'KE0001', 1, 0))) as Lembar, sum(RpTag) as rpTag,sum(RpBK1+RpBK2+RpBK3) as RpBK";
            sql = sql + "  	   FROM  dpp partition(saldo) " ;
            sql = sql + "  	   where " ;
            sql = sql + "  			dpp.kdpembPp = 'R1' ";
            sql = sql + "           and dpp.kdgerakkeluar is null " ;
            sql += " and substr(dpp.tgljttempo,1,6) <= to_char(sysdate,'yyyymm') ";
            sql = sql + "        and dpp.unitup = '" + unitUp + "' ";
            sql = sql + "  			GROUP BY idpel";
            sql = sql + "  			) ";
            sql = sql + "  	   dppTab, DIL dpp, tul601";
            sql = sql + " where ";

            sql += " DPP.UNITUP = '" + unitUp + "' AND ";
            sql += " DPP.IDPEL = DPPTAB.IDPEL AND ";

            sql = sql + "  	tul601.idpelanggan = dppTab.idpel and";
            sql = sql + "  	tul601.idpelanggan = dpp.idpel and";
            sql = sql + "  	tul601.thblrek = dppTab.thblawal and";
            sql = sql + "  	tul601.tgl_pelunasan_601 is null and";
            sql = sql + "   tul601.unitup = '" + unitUp + "'";
            sql += sqlKriteria;
            sql = sql + " ) xxx " ;
            sql = sql + " , tul603";
            sql = sql + " where" ;
            sql = sql + " xxx.No_601 = tul603.No_601(+)";
            sql = sql + "  ) t,";
            sql = sql + "  (" ;
            sql = sql + "  select idpel as didpel, blth as dthbl,to_char(to_date(blth,'yyyymm'),'Mon-yyyy') as dbulan,";
            sql = sql + "  rpptl as dprppal, rpppn as drpppn, rpbpju as drpppj, rptrafo + RPANGSA + RPANGSB + RPANGSC as drptrafo, rpmat as drpmat, rpbk1+rpbk2+rpbk3 as drpbk ";
            sql = sql + "  from dpp partition(saldo) ";
            sql = sql + "  ) d ";
            sql = sql + "  where " ;
            sql = sql + "  d.dthbl >= t.thblawal and d.dthbl <= t.thblakhir";
            sql = sql + "  and d.didpel = t.idpel" ;
            sql = sql + "  and d.didpel = '" + txtIdpel + "' " ;
            sql = sql + "  order by d.dthbl";
            sql = sql + " " ;

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilBuatCetakTul603_BA", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> AmbilBuatCetakUlangTul603(String unitUp,
                                                         Date TglPk,
                                                         Integer noTul) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "  select t.*,d.* from ";
            sql = sql + "  (";
            sql = sql + " select ";
            sql = sql + " xxx.unitup || '/VI-01/' || to_char(xxx.tgl_tul601,'ddmmyyyy') || '-0' as nomer601, ";
            sql = sql + " xxx.unitup, idpel, xxx.nokontrak, xxx.nokontrol, kdgardu, notiang, ";
            sql = sql + "      xxx.nama, NAMAPNJ, tarip, daya, kogol, ";
            sql = sql + "  	   thblawal, thblakhir, lembar, rptag, rpbk,";
            sql = sql + "  	   tul603.tgl_tul603 as tgl_jatuh_tempo_601, xxx.no_60, xxx.no_601, ";
            sql = sql + " tul603.no_tul603 as no_tul601, xxx.tgl_tul601, xxx.unitup || '/VI-03/' || to_char(tul603.tgl_tul603,'ddmmyyyy') || '-' || tul603.no_tul603 as thblrek, SYSDATE AS tglcetak " ;
            sql = sql + " from";
            sql = sql + " (";
            sql = sql + " select ";
            sql = sql + "  	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + "  	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + "  	   /* +index(dpp idx_dpp_unitup) */ " ;
            sql = sql + "        dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.nogardu as kdgardu, dpp.nogardu||'/'||dpp.notiang as notiang, ";
            sql = sql + "        dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.nogardu as kdgardu, dpp.notiang as notiang, ";
            sql = sql + "   	 dpp.nama, DPP.PNJ||' '||DPP.NAMAPNJ||DPP.NOBANG||DECODE(DECODE(TRIM(DPP.RT),NULL,'0',DPP.RT),'0',' ',' RT.'||DPP.RT)||DECODE(DECODE(TRIM(DPP.RW),NULL,'0',DPP.RW),'0',' ',' RW.'||DPP.RW)||' '||DPP.LINGKUNGAN AS namapnj, dpp.tarip, dpp.daya, dpp.kogol, " ;
            sql = sql + "  	     dppTab.thblawal, dppTab.thblakhir, dppTab.lembar, dppTab.rptag, dppTab.rpbk,";
            sql = sql + "  	     tul601.tgl_jatuh_tempo_601, tul601.no_60, tul601.no_601, tul601.no_tul601, tul601.tgl_tul601, tul601.thblrek" ;
            sql = sql + " from";
            sql = sql + "  	   (SELECT  idpel, MIN(dpp.blth) as thblawal, MAX(dpp.blth) as thblakhir, " ;
            sql = sql + "  	   count(idpel) as Lembar, sum(RpTag) as rpTag,sum(RpBK1+RpBK2+RpBK3) as RpBK";
            sql = sql + "  	   FROM  dpp partition(saldo) ";
            sql = sql + "  	   where ";
            sql = sql + "  			dpp.kdpembPp = 'R1' ";
            sql = sql + "           and dpp.kdgerakkeluar is null ";
            sql += " and substr(dpp.tgljttempo,1,6) <= to_char(sysdate,'yyyymm') ";
            sql = sql + "        and dpp.unitup = '" + unitUp + "' ";
            sql = sql + "  			GROUP BY idpel";
            sql = sql + "  			) " ;
            sql = sql + "  	   dppTab, DIL dpp, tul601";
            sql = sql + " where ";

            sql += " DPP.UNITUP = '" + unitUp + "' AND ";
            sql += " DPP.IDPEL = DPPTAB.IDPEL AND " ;

            sql = sql + "  	tul601.idpelanggan = dppTab.idpel and";
            sql = sql + "  	tul601.idpelanggan = dpp.idpel and";
            sql = sql + "  	tul601.thblrek = dppTab.thblawal and";
            sql = sql + " 	tul601.Tgl_jatuh_tempo_601 < sysdate and";
            sql = sql + "  	tul601.tgl_pelunasan_601 is null and";
            sql = sql + "   tul601.unitup = '" + unitUp + "'";
            sql = sql + " ) xxx ";
            sql = sql + " , tul603";
            sql = sql + " where";
            sql = sql + " xxx.No_601 = tul603.No_601(+)";
            sql = sql + "  ) t,";
            sql = sql + "  (";
            sql = sql + "  select idpel as didpel, blth as dthbl,to_char(to_date(blth,'yyyymm'),'Mon-yyyy') as dbulan,";
            sql = sql + "  rpptl as dprppal, rpppn as drpppn, rpbpju as drpppj, rptrafo as drptrafo, rpmat as drpmat, rpbk1+rpbk2+rpbk3 as drpbk ";
            sql = sql + "  from dpp partition(saldo) ";
            sql = sql + "  ) d ";
            sql = sql + "  where ";
            sql = sql + "  d.dthbl >= t.thblawal and d.dthbl <= t.thblakhir";
            sql = sql + "  and d.didpel = t.idpel";

            sql = sql + " and to_char(t.tgl_jatuh_tempo_601,'yyyymmdd') = '"; // + strTgl + "' " ;
            sql = sql + " and t.no_tul601 = '" + noTul + "' ";

            sql = sql + "  order by d.dthbl";
            sql = sql + " ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilBuatCetakUlangTul603", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilBuatCetakUlangTul603Kriteria(String unitUp,
                                                                 Date TglPk,
                                                                 Integer noTul,
                                                                 Date TglPk2,
                                                                 String kolok) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "  select t.*,d.* from ";
            sql = sql + "  (" ;
            sql = sql + " select ";
            sql = sql + " xxx.unitup || '/VI-01/' || to_char(xxx.tgl_tul601,'ddmmyyyy') || '-0' as nomer601, ";
            sql = sql + " xxx.unitup, idpel, xxx.nokontrak, xxx.nokontrol, kdgardu, notiang, ";
            sql = sql + "      xxx.nama, NAMAPNJ, tarip, daya, kogol, ";
            sql = sql + "  	   thblawal, thblakhir, lembar, rptag, rpbk,";
            sql = sql + "  	   tul603.tgl_tul603 as tgl_jatuh_tempo_601, xxx.no_60, xxx.no_601, ";
            sql = sql + " tul603.no_tul603 as no_tul601, xxx.tgl_tul601, xxx.unitup || '/VI-03/' || to_char(tul603.tgl_tul603,'ddmmyyyy') || '-0' as thblrek, SYSDATE AS tglcetak ";
            sql = sql + " from";
            sql = sql + " (";
            sql = sql + " select ";
            sql = sql + "  	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + "  	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + "  	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + "        dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.nogardu as kdgardu, dpp.nogardu||'/'||dpp.notiang as notiang, ";
            sql = sql + "        dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.nogardu as kdgardu, dpp.notiang as notiang, ";
            sql = sql + "   	 dpp.nama, DPP.PNJ||' '||TRIM(DPP.NAMAPNJ)||' '||DPP.NOBANG||' '||DECODE(DECODE(TRIM(DPP.RT),NULL,'0',DPP.RT),'0',' ',' RT.'||DPP.RT)||DECODE(DECODE(TRIM(DPP.RW),NULL,'0',DPP.RW),'0',' ',' RW.'||DPP.RW)||' '||DPP.LINGKUNGAN AS namapnj, dpp.tarip, dpp.daya, dpp.kogol, ";
            sql = sql + "  	     dppTab.thblawal, dppTab.thblakhir, dppTab.lembar, dppTab.rptag, dppTab.rpbk,";
            sql = sql + "  	     tul601.tgl_jatuh_tempo_601, tul601.no_60, tul601.no_601, tul601.no_tul601, tul601.tgl_tul601, tul601.thblrek";
            sql = sql + " from";
            sql = sql + "  	   (SELECT  idpel, MIN(dpp.blth) as thblawal, MAX(dpp.blth) as thblakhir, ";
            sql = sql + "  	   count(idpel) as Lembar, sum(RpTag) as rpTag,sum(RpBK1+RpBK2+RpBK3) as RpBK";
            sql = sql + "  	   FROM  dpp partition(saldo) " ;
            sql = sql + "  	   where ";
            sql = sql + "  			dpp.kdpembPp = 'R1' " ;
            sql = sql + "           and dpp.kdgerakkeluar is null ";
            sql += " and substr(dpp.tgljttempo,1,6) <= to_char(sysdate,'yyyymm') ";
            sql = sql + "        and dpp.unitup = '" + unitUp + "' " ;
            sql = sql + "  			GROUP BY idpel";
            sql = sql + "  			) ";
            sql = sql + "  	   dppTab, DIL dpp, tul601";
            sql = sql + " where ";

            sql += " DPP.UNITUP = '" + unitUp + "' AND ";
            sql += " DPP.IDPEL = DPPTAB.IDPEL AND ";

            sql = sql + "  	tul601.idpelanggan = dppTab.idpel and";
            sql = sql + "  	tul601.idpelanggan = dpp.idpel and" ;
            sql = sql + "  	tul601.thblrek = dppTab.thblawal and" ;
            sql = sql + " 	tul601.Tgl_jatuh_tempo_601 < sysdate and" ;
            sql = sql + "  	tul601.tgl_pelunasan_601 is null and";
            sql = sql + "   tul601.unitup = '" + unitUp + "'" ;
            sql = sql + " ) xxx ";
            sql = sql + " , tul603";
            sql = sql + " where";
            sql = sql + " xxx.No_601 = tul603.No_601(+)" ;
            sql = sql + "  ) t,";
            sql = sql + "  (" ;
            sql = sql + "  select idpel as didpel, blth as dthbl,to_char(to_date(blth,'yyyymm'),'Mon-yyyy') as dbulan,";
            sql = sql + "  rpptl as dprppal, rpppn as drpppn, rpbpju as drpppj, rptrafo as drptrafo, rpmat as drpmat, rpbk1+rpbk2+rpbk3 as drpbk ";
            sql = sql + "  from dpp partition(saldo) ";
            sql = sql + "  ) d " ;
            sql = sql + "  where ";
            sql = sql + "  d.dthbl >= t.thblawal and d.dthbl <= t.thblakhir" ;
            sql = sql + "  and d.didpel = t.idpel" ;

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilBuatCetakUlangTul603Kriteria", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    //--- Penanganan Petugas
    @Override
    public Map<String, Object> simpanGroup(String unitup,
                                           String namagroup,
                                           String deskripsi,
                                           String jenisgroup,
                                           String statusaktif,
                                           String created_by) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " insert into groupwaskit (unitup,namagroup,deskripsi,jenisgroup,statusaktif,created_by,created_at)";
            sql = sql + " values ('" + unitup + "','" + namagroup + "','" + deskripsi + "','" + jenisgroup + "','" + 1 + "','" + created_by + "',sysdate)";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanGroup", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> simpanPetugas(String unitup,
                                             String namapetugas,
                                             String keterangan,
                                             String namagroup,
                                             String statusaktif,
                                             String created_by) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " insert into petugaswaskit (unitup,namapetugas,keterangan,namagroup,statusaktif,created_by,created_at)";
            sql = sql + " values ('" + unitup + "','" + namapetugas + "','" + keterangan + "','" + namagroup + "','" + statusaktif + "','" + created_by + "',sysdate) ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanPetugas", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> lihatGroup() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select created_at,namagroup,statusaktif,unitup,deskripsi,jenisgroup,created_by";
            sql = sql + " from groupwaskit";
            sql = sql + " order by created_at desc";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("lihatGroup", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> lihatGroup_ByUnitup(String sUNITUP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select created_at,namagroup,statusaktif,unitup,deskripsi,jenisgroup,created_by";
            sql = sql + " from groupwaskit";
            sql = sql + " where unitup='" + sUNITUP + "'";
            sql = sql + " order by created_at desc";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("lihatGroup_ByUnitup", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> lihatPetugas() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select created_at,namapetugas,statusaktif,unitup,keterangan,namagroup,created_by";
            sql = sql + " from petugaswaskit";
            sql = sql + " order by created_at desc";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("lihatPetugas", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> lihatPetugas_ByUnitup(String sUNITUP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select created_at,namapetugas,statusaktif,unitup,keterangan,namagroup,created_by";
            sql = sql + " from petugaswaskit";
            sql = sql + " where unitup='" + sUNITUP + "'";
            sql = sql + " order by created_at desc";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("lihatPetugas_ByUnitup", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> nonAktifGroup(String group) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " update groupwaskit ";
            sql += " set statusaktif = 0 ";
            sql += " where namagroup = '" + group + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("nonAktifGroup", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> aktifkanGroup(String group) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " update groupwaskit ";
            sql += " set statusaktif = 1 ";
            sql += " where namagroup = '" + group + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("aktifkanGroup", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> nonAktifPetugas(String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " update petugaswaskit ";
            sql += " set statusaktif = 0 ";
            sql += " where namapetugas = '" + petugas + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("nonAktifPetugas", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> aktifkanPetugas(String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " update petugaswaskit ";
            sql += " set statusaktif = 1 ";
            sql += " where namapetugas = '" + petugas + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("aktifkanPetugas", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilPetugasWaskit() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select namapetugas,namagroup,unitup from petugaswaskit where statusaktif = 1 order by namapetugas ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilPetugasWaskit", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilPetugasWaskit_up(String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select namapetugas,namagroup,unitup from petugaswaskit where statusaktif = 1 and unitup = '" + unitup + "' order by namapetugas ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilPetugasWaskit_up", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilPetugasWaskit_up_group(String unitup,
                                                           String group) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select namapetugas,namagroup,unitup from petugaswaskit where statusaktif = 1 and unitup = '" + unitup + "' and namagroup = '" + group + "' order by namapetugas ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilPetugasWaskit_up_group", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilGroupPetugas() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select namagroup,unitup from groupwaskit where statusaktif = 1 order by namagroup ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilGroupPetugas", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> ambilGroupPetugas_ByUnitup(String sUNITUP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select namagroup,unitup from groupwaskit where statusaktif = 1 and unitup = '" + sUNITUP + "' order by namagroup ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilGroupPetugas_ByUnitup", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpanPenugasan(String unitup,
                                               String no_pk_sambung,
                                               String pemberi_material,
                                               String no_pk_tul6,
                                               String petugas_sambung,
                                               String material1,
                                               String material2,
                                               String material3,
                                               String keterangan,
                                               String created_by) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " insert into pksambung (UNITUP, NO_PK_SAMBUNG, PEMBERI_MATERIAL, NO_PK_TUL6, PETUGAS_SAMBUNG, MATERIAL1, MATERIAL2, MATERIAL3, KETERANGAN, CREATED_BY, CREATED_AT)";
            sql = sql + " values ('" + unitup + "','" + no_pk_sambung + "','" + pemberi_material + "','" + no_pk_tul6 + "','" + petugas_sambung + "','" + material1 + "','" + material2 + "','" + material3 + "','" + keterangan + "','" + created_by + "',sysdate)";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanPenugasan", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> hapusPenugasan(String noPkSambung) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " delete pksambung";
            sql += " where no_pk_sambung = '" + noPkSambung + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("hapusPenugasan", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> lihatPenugasan(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select UNITUP, NO_PK_SAMBUNG, PEMBERI_MATERIAL, NO_PK_TUL6, PETUGAS_SAMBUNG, MATERIAL1, MATERIAL2, MATERIAL3, KETERANGAN, CREATED_BY, CREATED_AT";
            sql = sql + " from pksambung";
            sql = sql + " where unitup = '" + unitUp + "'";
            sql = sql + " 	  and 0 = 0";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("lihatPenugasan", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    //--- Distribusi PK per-Petugas
    @Override
    public Map<String, Object> simpanDistribusiPKPutus(String unitup,
                                                       String tgltul,
                                                       String notul,
                                                       String iKodePetugas,
                                                       String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " insert into pkputus";
            sql = sql + " 	   		(UNITUP, TGL_TUL601, NO_TUL601, PEMBERI_PK, PETUGAS_PENERIMA_PK, TGL_TERIMA_PK, ALASANTIDAKPUTUS, CREATED_BY, CREATED_AT)";
            sql = sql + " values";
            sql = sql + " 	  		('" + unitup + "',to_date('" + tgltul + "','yyyymmdd'),'" + notul + "','" + iKodePetugas + "','" + petugas + "',trunc(sysdate),'','" + iKodePetugas + "',sysdate)";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanDistribusiPKPutus", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpanDistribusiPKBongkar(String unitup,
                                                         String tgltul,
                                                         String notul,
                                                         String iKodePetugas,
                                                         String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " insert into pkbongkar";
            sql = sql + " 	   		(UNITUP, TGL_TUL603, NO_TUL603, PEMBERI_PK, PETUGAS_PENERIMA_PK, TGL_TERIMA_PK, ALASANTIDAKBONGKAR, CREATED_BY, CREATED_AT)";
            sql = sql + " values" ;
            sql = sql + " 	  		('" + unitup + "',to_date('" + tgltul + "','yyyymmdd'),'" + notul + "','" + iKodePetugas + "','" + petugas + "',trunc(sysdate),'','" + iKodePetugas + "',sysdate)";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanDistribusiPKPutus", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> lihatDistribusiPKPutus(String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select a.no_tul601 nocetaktul, a.idpelanggan no_pelanggan, a.nama nama_pelanggan, ";
            sql = sql + " 	   a.lembar_601 totallembar, a.tagihan_601 tagihan,";
            sql = sql + " 	   a.tgl_tul601 tanggal_cetak, b.tgl_terima_pk tanggal_perintah_kerja, ";
            sql = sql + " 	   a.tgl_pelaksanaan_putus tanggal_pelaksanaan, ";
            sql = sql + " 	   b.petugas_penerima_pk nama_pelaksana, b.alasantidakputus keterangan";
            sql = sql + " from tul601 A, pkputus B";
            sql = sql + " where trunc(a.tgl_tul601) = b.tgl_tul601 (+) and a.no_tul601 = b.no_tul601 (+)";
            sql = sql + " 	   and 0 = 0" ;
            sql += sqlKriteria;
            sql = sql + " order by a.tgl_tul601, a.no_tul601, a.nokontrol";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("lihatDistribusiPKPutus", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> lihatDistribusiPKBongkar(String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select a.no_tul603 nocetaktul, a.idpelanggan no_pelanggan, a.nama nama_pelanggan, ";
            sql = sql + " 	   a.lembar_603 totallembar, a.tagihan_603 tagihan,";
            sql = sql + " 	   a.tgl_tul603 tanggal_cetak, b.tgl_terima_pk tanggal_perintah_kerja, ";
            sql = sql + " 	   a.tgl_pelaksanaan_bongkar tanggal_pelaksanaan, " ;
            sql = sql + " 	   b.petugas_penerima_pk nama_pelaksana, b.alasantidakbongkar keterangan";
            sql = sql + " from tul603 A, pkbongkar B";
            sql = sql + " where trunc(a.tgl_tul603) = b.tgl_tul603 (+) and a.no_tul603 = b.no_tul603 (+)";
            sql = sql + " 	   and 0 = 0";
            sql += sqlKriteria;
            sql = sql + " order by a.tgl_tul603, a.no_tul603, a.nokontrol";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("lihatDistribusiPKBongkar", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> getView_ReportPantauTULVI01(String sTglAwal,
                                                           String sTglAkhir,
                                                           String sUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String SQL = " SELECT * FROM view_report_waskit_ptg_lns ";
            SQL += " WHERE tgl_tul601 between TO_DATE('" + sTglAwal + "','yyyyMMdd') " ;
            SQL += " AND TO_DATE('" + sTglAkhir + "','yyyyMMdd') " ;

            CallableStatement cst;
            String sql = null;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getView_ReportPantauTULVI01", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;
    }

    @Override
    public Map<String, Object> AmbilBuatCetakUlangTul601Kriteria_pkg(String _unitup, String _idpelAwal_A, String _idpelAwal_B, String _idpelAkhir_A, String _idpelAkhir_B, String _jumlahLembarAwal, String _jumlahLembarAkhir, String _rupiahTagihAwal, String _rupiahTagihAkhir, String _dayaAwal, String _dayaAkhir, String _kogolAwal, String _kogolAkhir, String _noRBM, String _kantorPelayanan, String _noGardu, String _paymentPoint, String _tarip, String _petugasPemutusan, String _cekUrutanKolom, String _cekUrutan, String _maxJmlPK, String _cekCetakanTiap) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Map<String, Object> AmbilBuatCetakUlangTul601Kriteria_usingRef_pkg(String _unitup,
                                                                     String _idpelAwal_A,
                                                                     String _idpelAwal_B,
                                                                     String _idpelAkhir_A,
                                                                     String _idpelAkhir_B,
                                                                     String _jumlahLembarAwal,
                                                                     String _jumlahLembarAkhir,
                                                                     String _rupiahTagihAwal,
                                                                     String _rupiahTagihAkhir,
                                                                     String _dayaAwal,
                                                                     String _dayaAkhir,
                                                                     String _kogolAwal,
                                                                     String _kogolAkhir,
                                                                     String _noRBM,
                                                                     String _kantorPelayanan,
                                                                     String _noGardu,
                                                                     String _paymentPoint,
                                                                     String _tarip,
                                                                     String _petugasPemutusan,
                                                                     String _cekUrutanKolom,
                                                                     String _cekUrutan,
                                                                     String _maxJmlPK,
                                                                     String _cekCetakanTiap) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "AmbilBuatCetakUlangTul601Kriteria_usingRef_pkg";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put(" AmbilBuatCetakUlangTul601Kriteria_usingRef_pkg ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilBuatCetakUlangTul603Kriteria_pkg(String _unitup,
                                                                     String _idpelAwal_A,
                                                                     String _idpelAwal_B,
                                                                     String _idpelAkhir_A,
                                                                     String _idpelAkhir_B,
                                                                     String _jumlahLembarAwal,
                                                                     String _jumlahLembarAkhir,
                                                                     String _rupiahTagihAwal,
                                                                     String _rupiahTagihAkhir,
                                                                     String _dayaAwal,
                                                                     String _dayaAkhir,
                                                                     String _kogolAwal,
                                                                     String _kogolAkhir,
                                                                     String _noRBM,
                                                                     String _kantorPelayanan,
                                                                     String _noGardu,
                                                                     String _paymentPoint,
                                                                     String _tarip,
                                                                     String _petugasPemutusan,
                                                                     String _cekUrutanKolom,
                                                                     String _cekUrutan,
                                                                     String _maxJmlPK,
                                                                     String _cekCetakanTiap,
                                                                     String _is60hari) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "AmbilBuatCetakUlangTul603Kriteria_pkg";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put(" AmbilBuatCetakUlangTul603Kriteria_pkg ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }



    @Override
    public Map<String, Object> AmbilTul601Penyambungan_pkg(String _unitup,
                                                           String _idpelAwal_A,
                                                           String _idpelAwal_B,
                                                           String _idpelAkhir_A,
                                                           String _idpelAkhir_B,
                                                           String _jumlahLembarAwal,
                                                           String _jumlahLembarAkhir,
                                                           String _rupiahTagihAwal,
                                                           String _rupiahTagihAkhir,
                                                           String _dayaAwal,
                                                           String _dayaAkhir,
                                                           String _kogolAwal,
                                                           String _kogolAkhir,
                                                           String _noRBM,
                                                           String _kantorPelayanan,
                                                           String _noGardu,
                                                           String _paymentPoint,
                                                           String _tarip,
                                                           String _petugasPemutusan,
                                                           String _cekUrutanKolom,
                                                           String _cekUrutan,
                                                           String _maxJmlPK,
                                                           String _cekCetakanTiap) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "AmbilTul601Penyambungan_pkg";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put(" AmbilTul601Penyambungan_pkg ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilTul601LampiranKriteria_pkg(String _unitup,
                                                               String _idpelAwal_A,
                                                               String _idpelAwal_B,
                                                               String _idpelAkhir_A,
                                                               String _idpelAkhir_B,
                                                               String _jumlahLembarAwal,
                                                               String _jumlahLembarAkhir,
                                                               String _rupiahTagihAwal,
                                                               String _rupiahTagihAkhir,
                                                               String _dayaAwal,
                                                               String _dayaAkhir,
                                                               String _kogolAwal,
                                                               String _kogolAkhir,
                                                               String _noRBM,
                                                               String _kantorPelayanan,
                                                               String _noGardu,
                                                               String _paymentPoint,
                                                               String _tarip,
                                                               String _petugasPemutusan,
                                                               String _cekUrutanKolom,
                                                               String _cekUrutan,
                                                               String _maxJmlPK,
                                                               String _cekCetakanTiap) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "AmbilTul601LampiranKriteria_pkg";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put(" AmbilTul601LampiranKriteria_pkg ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilTul603LampiranKriteria_pkg(String _unitup,
                                                               String _idpelAwal_A,
                                                               String _idpelAwal_B,
                                                               String _idpelAkhir_A,
                                                               String _idpelAkhir_B,
                                                               String _jumlahLembarAwal,
                                                               String _jumlahLembarAkhir,
                                                               String _rupiahTagihAwal,
                                                               String _rupiahTagihAkhir,
                                                               String _dayaAwal,
                                                               String _dayaAkhir,
                                                               String _kogolAwal,
                                                               String _kogolAkhir,
                                                               String _noRBM,
                                                               String _kantorPelayanan,
                                                               String _noGardu,
                                                               String _paymentPoint,
                                                               String _tarip,
                                                               String _petugasPemutusan,
                                                               String _cekUrutanKolom,
                                                               String _cekUrutan,
                                                               String _maxJmlPK,
                                                               String _cekCetakanTiap,
                                                               String _is60hari) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "AmbilTul603LampiranKriteria_pkg";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put(" AmbilTul603LampiranKriteria_pkg ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> TulVI_Main_Eksekusi601_pkg(String _unitup,
                                                          String _idpelAwal_A,
                                                          String _idpelAwal_B,
                                                          String _idpelAkhir_A,
                                                          String _idpelAkhir_B,
                                                          String _jumlahLembarAwal,
                                                          String _jumlahLembarAkhir,
                                                          String _rupiahTagihAwal,
                                                          String _rupiahTagihAkhir,
                                                          String _dayaAwal,
                                                          String _dayaAkhir,
                                                          String _kogolAwal,
                                                          String _kogolAkhir,
                                                          String _noRBM,
                                                          String _kantorPelayanan,
                                                          String _noGardu,
                                                          String _paymentPoint,
                                                          String _tarip,
                                                          String _petugasPemutusan,
                                                          String _cekUrutanKolom,
                                                          String _cekUrutan,
                                                          String _maxJmlPK,
                                                          String _cekCetakanTiap) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "TulVI_Main_Eksekusi601_pkg";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("TulVI_Main_Eksekusi601_pkg ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> TulVI_Main_Eksekusi601_RowCount_pkg(String _unitup,
                                                                   String _idpelAwal_A,
                                                                   String _idpelAwal_B,
                                                                   String _idpelAkhir_A,
                                                                   String _idpelAkhir_B,
                                                                   String _jumlahLembarAwal,
                                                                   String _jumlahLembarAkhir,
                                                                   String _rupiahTagihAwal,
                                                                   String _rupiahTagihAkhir,
                                                                   String _dayaAwal,
                                                                   String _dayaAkhir,
                                                                   String _kogolAwal,
                                                                   String _kogolAkhir,
                                                                   String _noRBM,
                                                                   String _kantorPelayanan,
                                                                   String _noGardu,
                                                                   String _paymentPoint,
                                                                   String _tarip,
                                                                   String _petugasPemutusan,
                                                                   String _cekUrutanKolom,
                                                                   String _cekUrutan,
                                                                   String _maxJmlPK,
                                                                   String _cekCetakanTiap) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "TulVI_Main_Eksekusi601_RowCount_pkg";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("TulVI_Main_Eksekusi601_RowCount_pkg ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }



    @Override
    public Map<String, Object> TulVI_Main_Eksekusi603_pkg(String _unitup,
                                                          String _idpelAwal_A,
                                                          String _idpelAwal_B,
                                                          String _idpelAkhir_A,
                                                          String _idpelAkhir_B,
                                                          String _jumlahLembarAwal,
                                                          String _jumlahLembarAkhir,
                                                          String _rupiahTagihAwal,
                                                          String _rupiahTagihAkhir,
                                                          String _dayaAwal,
                                                          String _dayaAkhir,
                                                          String _kogolAwal,
                                                          String _kogolAkhir,
                                                          String _noRBM,
                                                          String _kantorPelayanan,
                                                          String _noGardu,
                                                          String _paymentPoint,
                                                          String _tarip,
                                                          String _petugasPemutusan,
                                                          String _cekUrutanKolom,
                                                          String _cekUrutan,
                                                          String _maxJmlPK,
                                                          String _cekCetakanTiap,
                                                          String _is60hari,
                                                          String noUrutAwal, String noUrutAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "TulVI_Main_Eksekusi603_pkg";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("TulVI_Main_Eksekusi603_pkg ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }



    @Override
    public Map<String, Object> TulVI_Main_Eksekusi603_RowCount_pkg(String _unitup,
                                                                   String _idpelAwal_A,
                                                                   String _idpelAwal_B,
                                                                   String _idpelAkhir_A,
                                                                   String _idpelAkhir_B,
                                                                   String _jumlahLembarAwal,
                                                                   String _jumlahLembarAkhir,
                                                                   String _rupiahTagihAwal,
                                                                   String _rupiahTagihAkhir,
                                                                   String _dayaAwal,
                                                                   String _dayaAkhir,
                                                                   String _kogolAwal,
                                                                   String _kogolAkhir,
                                                                   String _noRBM,
                                                                   String _kantorPelayanan,
                                                                   String _noGardu,
                                                                   String _paymentPoint,
                                                                   String _tarip,
                                                                   String _petugasPemutusan,
                                                                   String _cekUrutanKolom,
                                                                   String _cekUrutan,
                                                                   String _maxJmlPK,
                                                                   String _cekCetakanTiap,
                                                                   String _is60hari) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "TulVI_Main_Eksekusi603_RowCount_pkg";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("TulVI_Main_Eksekusi603_RowCount_pkg ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> TulVI_Main_Eksekusi601_RPT_pkg(String _unitup,
                                                              String _idpelAwal_A,
                                                              String _idpelAwal_B,
                                                              String _idpelAkhir_A,
                                                              String _idpelAkhir_B,
                                                              String _jumlahLembarAwal,
                                                              String _jumlahLembarAkhir,
                                                              String _rupiahTagihAwal,
                                                              String _rupiahTagihAkhir,
                                                              String _dayaAwal,
                                                              String _dayaAkhir,
                                                              String _kogolAwal,
                                                              String _kogolAkhir,
                                                              String _noRBM,
                                                              String _kantorPelayanan,
                                                              String _noGardu,
                                                              String _paymentPoint,
                                                              String _tarip,
                                                              String _petugasPemutusan,
                                                              String _cekUrutanKolom,
                                                              String _cekUrutan,
                                                              String _maxJmlPK,
                                                              String _cekCetakanTiap,
                                                              String _isCetakUlang) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "TulVI_Main_Eksekusi601_RPT_pkg";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("TulVI_Main_Eksekusi601_RPT_pkg ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> TulVI_Main_Eksekusi603_RPT_pkg(String _unitup,
                                                              String _idpelAwal_A,
                                                              String _idpelAwal_B,
                                                              String _idpelAkhir_A,
                                                              String _idpelAkhir_B,
                                                              String _jumlahLembarAwal,
                                                              String _jumlahLembarAkhir,
                                                              String _rupiahTagihAwal,
                                                              String _rupiahTagihAkhir,
                                                              String _dayaAwal,
                                                              String _dayaAkhir,
                                                              String _kogolAwal,
                                                              String _kogolAkhir,
                                                              String _noRBM,
                                                              String _kantorPelayanan,
                                                              String _noGardu,
                                                              String _paymentPoint,
                                                              String _tarip,
                                                              String _petugasPemutusan,
                                                              String _cekUrutanKolom,
                                                              String _cekUrutan,
                                                              String _maxJmlPK,
                                                              String _cekCetakanTiap,
                                                              String _is60hari,
                                                              String _isCetakUlang) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "TulVI_Main_Eksekusi603_RPT_pkg";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("TulVI_Main_Eksekusi603_RPT_pkg ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> AmbilBuatCetakUlangTul601Kriteria_usingRef_pkg(String unitup,
                                                                              String _noPelangganAwal,
                                                                              String _noPelangganAkhir,
                                                                              String _jumlahLembarAwal,
                                                                              String _jumlahLembarAkhir,
                                                                              String _rupiahTagihAwal,
                                                                              String _rupiahTagihAkhir,
                                                                              String _besarDayaAwal,
                                                                              String _besarDayaAkhir,
                                                                              String _kodeGolonganAwal,
                                                                              String _kodeGolonganAkhir,
                                                                              String _noRBM,
                                                                              String _kantorPelayanan,
                                                                              String _petugasPemutusan,
                                                                              String _noKontrol,
                                                                              String _namaGardu,
                                                                              String _paymentPoint,
                                                                              String _tarif) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "AmbilBuatCetakUlangTul601Kriteria_usingRef_pkg";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilBuatCetakUlangTul601Kriteria_usingRef_pkg ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> PetugasWaskitRBM_AmbilData(String _unitup,
                                                          String _group,
                                                          String _petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select * from petugaswaskit_rbm  " ;

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("PetugasWaskitRBM_AmbilData ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> PetugasWaskitRBM_Simpan(String unitup,
                                                       String namagroup,
                                                       String namapetugas,
                                                       String noRbm,
                                                       String statusaktif,
                                                       String keterangan,
                                                       String created_by) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " insert into petugaswaskit_rbm (unitup,namagroup,namapetugas,no_rbm,statusaktif,keterangan,created_by,created_at)";
            sql = sql + " values ('" + unitup + "','" + namagroup + "','" + namapetugas + "','" + noRbm + "','" + statusaktif + "', '" + keterangan + "','" + created_by + "',sysdate) ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("PetugasWaskitRBM_Simpan ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> PetugasWaskitRBM_Aktifkan(String unitup,
                                                         String namagroup,
                                                         String namapetugas,
                                                         String noRbm) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " update petugaswaskit_rbm ";
            sql += " set statusaktif = 1 ";
            sql += " where unitup = '" + unitup + "' ";
            sql += "   and namagroup = '" + namagroup + "' ";
            sql += "   and namapetugas = '" + namapetugas + "' ";
            sql += "   and no_rbm = '" + noRbm + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("PetugasWaskitRBM_Aktifkan ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> PetugasWaskitRBM_NonAktifkan(String unitup,
                                                            String namagroup,
                                                            String namapetugas,
                                                            String noRbm) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " update petugaswaskit_rbm ";
            sql += " set statusaktif = 0 ";
            sql += " where unitup = '" + unitup + "' ";
            sql += "   and namagroup = '" + namagroup + "' ";
            sql += "   and namapetugas = '" + namapetugas + "' ";
            sql += "   and no_rbm = '" + noRbm + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("PetugasWaskitRBM_NonAktifkan ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    //waskit
    @Override
    public Map<String, Object> ambilDetailTul601_Pemutusan(String _strtgl,
                                                           String _noTulAwal,
                                                           String _noTulAkhir,
                                                           String _unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " update petugaswaskit_rbm ";
            sql += " set statusaktif = 0 ";
            sql += " where unitup = '"; // + unitup + "' ";
            sql += "   and namagroup = '"; // + namagroup + "' ";
            sql += "   and namapetugas = '"; // + namapetugas + "' ";
            sql += "   and no_rbm = '"; // + noRbm + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDetailTul601_Pemutusan ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilDetailTul603_Pembongkaran(String _strtgl,
                                                              String _noTulAwal,
                                                              String _noTulAkhir,
                                                              String _unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select NO_603,NO_60,UNITUP, THBLREK, IDPELANGGAN, NOKONTRAK, NOKONTROL, NAMA, ALAMAT,NO_TUL603, TGL_TUL603,  ";
            sql = sql + " THBLREK_AKHIR, LEMBAR_603, TAGIHAN_603,TGL_PELAKSANAAN_BONGKAR, NAMA_BONGKAR,STAND_LWBP_BONGKAR, STAND_WBP_BONGKAR, STAND_KVARH_BONGKAR, TGL_KODE_3, NO_KODE_3 " ;
            sql = sql + " from tul603 ";
            sql = sql + " where to_char(tgl_tul603,'yyyymmdd') = '" + _strtgl + "' ";
            Object sqlWhereNoTul = null;
            sql = sql + sqlWhereNoTul;
            sql = sql + " AND UNITUP='" + _unitup + "'" ;
            sql = sql + " AND TGL_PELAKSANAAN_BONGKAR is null ";
            sql = sql + " AND TGL_PELUNASAN_603 is null";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDetailTul603_Pembongkaran ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilDetailTul601_Penyambungan(String strtgl,
                                                              String noTul,
                                                              String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select NO_601, NO_60, UNITUP, THBLREK, IDPELANGGAN, NOKONTRAK, NOKONTROL, NAMA, ALAMAT, NO_TUL601, TGL_TUL601, STAND_LWBP_601, STAND_WBP_601, STAND_KVARH_601, THBLREK_AKHIR, LEMBAR_601, TAGIHAN_601, BLTHREK_601, TGL_PELAKSANAAN_PUTUS, NAMA_PUTUS, STAND_LWBP_PUTUS, STAND_WBP_PUTUS, STAND_KVARH_PUTUS, TGL_PELUNASAN_601, NO_601_SAMBUNG, TGL_601_SAMBUNG, TGL_PELAKSANAAN_SAMBUNG, NAMA_SAMBUNG, STAND_LWBP_SAMBUNG, STAND_WBP_SAMBUNG, STAND_KVARH_SAMBUNG, TGL_JATUH_TEMPO_601 ";
            sql = sql + " from tul601 " ;
            sql = sql + " where to_char(tgl_tul601,'yyyymmdd') = '" + strtgl + "' ";
            sql = sql + "   and no_tul601 = '" + noTul + "' ";
            sql = sql + "   and unitup = '" + unitup + "' " ;
            sql = sql + "   and tgl_pelaksanaan_putus is not null ";
            sql = sql + "   and tgl_pelunasan_601 is not null ";
            sql = sql + "   and tgl_pelaksanaan_sambung is null ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDetailTul601_Penyambungan ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> TulVI_Eksekusi_Lapangan_Bongkar_Simpan(Date _tglbongkar,
                                                                      String _namabongkar,
                                                                      String _lwbp,
                                                                      String _wbp,
                                                                      String _kvarh,
                                                                      String _idpelanggan,
                                                                      String _no60,
                                                                      Date _tgl603,
                                                                      String _no603,
                                                                      String _unitUp,
                                                                      Date _tglkode3,
                                                                      String _nokode3,
                                                                      String _transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =   "";


            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("TulVI_Eksekusi_Lapangan_Bongkar_Simpan ", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


}
