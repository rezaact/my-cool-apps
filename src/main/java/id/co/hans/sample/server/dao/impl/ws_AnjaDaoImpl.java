package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.ws_AnjaDao;
import id.co.hans.sample.server.utility.CommonModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


@Service
public class ws_AnjaDaoImpl implements ws_AnjaDao  {
    public static final Log log = LogFactory.getLog(ws_AnjaDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //---- ### START WASKIT ####################################################################################
    @Override
    public Map<String, Object> sp_waskit_verifikasi(Integer nav) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " BEGIN";
            sql += " proc_verifikasiwaskit_anja('" + nav + "');";
            sql += " END; ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("sp_waskit_verifikasi", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilNomerTulVI01(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select max(no_tul601) as nomer from tul601_anja tul601 ";
            sql += " where unitup = '" + unitUp + "' ";
            sql += " and to_char(tgl_tul601,'yyyymmdd') = to_char(sysdate,'yyyymmdd') ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("sp_waskit_verifikasi", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> insertTulVI01(Integer No_60,
                                             String UnitUP, String ThBlRek, String IdPelanggan,
                                             String NoKontrak, String NoKontrol, String Nama,
                                             String Alamat, String ThBlRek_akhir,
                                             String Lembar_601, String Tagihan_601, String NOtul601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " INSERT INTO TUL601_anja ";
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

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("insertTulVI01", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> AmbilTul601(String unitUp, String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select ";
            sql = sql + " 	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + " 	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + " 	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + "      dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.ketnodlmrt as kdgardu, dpp.kdkelompok as notiang, ";
            sql = sql + "  	   dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, dpp.kogol, ";
            sql = sql + " 	   dppTab.thblawal, dppTab.thblakhir, dppTab.lembar, dppTab.rptag, dppTab.rpbk,";
            sql = sql + " 	   tul60.tgl_catat_60, tul60.no_60, tul60.thblrek" ;
            sql = sql + " from";
            sql = sql + " 	(SELECT  idpel, MIN(BLTH) as thblawal, MAX(BLTH) as thblakhir, ";
            sql = sql + " 	count(idpel) as Lembar, sum(RpTag) as rpTag,sum(RpBK1+RpBK2+RpBK3) as RpBK" ;
            sql = sql + " 	FROM  DPPANJA dpp ";
            sql = sql + " 		where ";
            sql = sql + " 			dpp.kdpembPp = 'R1' ";
            sql = sql + " 			and dpp.tglbayaranja is null ";
            sql = sql + "           and kdgerakkeluaranja is null ";
            sql += " and BLTH <= to_char(sysdate,'yyyymm') ";
            sql = sql + "           and dpp.unitup = '" + unitUp + "' ";
            sql = sql + " 			GROUP BY idpel";
            sql = sql + " 			) ";
            sql = sql + " 	dppTab, DIL DPP, tul60_anja tul60";
            sql = sql + " where ";

            sql += " DPP.UNITUP = '" + unitUp + "' AND ";
            sql += " DPP.IDPEL = DPPTAB.IDPEL AND ";

            sql = sql + " 	tul60.idpelanggan = dppTab.idpel and";
            sql = sql + " 	tul60.idpelanggan = dpp.idpel and";
            sql = sql + " 	tul60.thblrek = dppTab.thblawal and";
            sql = sql + " 	tul60.cetak_601 is null and";
            sql = sql + " 	tul60.tgl_pelunasan_60 is null and" ;
            sql = sql + "   tul60.unitup = '" + unitUp + "' ";
            sql += sqlKriteria ;
            sql += "" ;
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    //---- Laporan VI-03
    @Override
    public Map<String, Object> ambilDaftarPantauCetak603(String unitUp, Date awal, Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "  SELECT ";
            sql = sql + "  tgl_tul601,TO_CHAR(tgl_tul603,'yyyy-mm-dd')||'/TULVI-03/'||no_tul603 AS no_tul603,idpelanggan,nokontrak,nokontrol,nama,alamat,lembar_603,thblrek,thblrek_akhir,tagihan_603,";
            sql = sql + "  Tgl_Pelaksanaan_bongkar,Nama_bongkar,Stand_Lwbp_bongkar,stand_wbp_bongkar,stand_kvarh_bongkar," ;
            sql = sql + "  Tgl_Pelunasan_603 ";
            sql = sql + "  FROM tul603_anja tul603";
            sql = sql + "  WHERE TO_CHAR(tgl_tul603,'yyyymmdd') >= '" ;
            sql = sql + "  AND TO_CHAR(tgl_tul603,'yyyymmdd') <= '";
            sql = sql + "  AND unitUp = '" + unitUp + "' ";
            sql += "";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDaftarPantauCetak603", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    //---- Laporan VI-01
    @Override
    public Map<String, Object> ambilDaftarPantauCetak601(String unitUp, Date awal, Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select ";
            sql = sql + " tgl_tul601,to_char(tgl_tul601,'yyyy-mm-dd')||'/TULVI-01/'||no_tul601 as no_tul601,idpelanggan,nokontrak,nokontrol,nama,alamat,lembar_601,thblrek,thblrek_akhir,tagihan_601," ;
            sql = sql + " Tgl_Pelaksanaan_Putus,Nama_Putus,Stand_Lwbp_Putus,stand_wbp_putus,stand_kvarh_putus,";
            sql = sql + " Tgl_Pelaksanaan_Sambung,Nama_Sambung,Stand_Lwbp_Sambung,stand_wbp_sambung,stand_kvarh_sambung,";
            sql = sql + " Tgl_Pelunasan_601 ";
            sql = sql + " from tul601_anja tul601";
            sql = sql + " where to_char(tgl_tul601,'yyyymmdd') >= '";
            sql = sql + "   and to_char(tgl_tul601,'yyyymmdd') <= '" ;
            sql = sql + "   and unitUp = '" + unitUp + "' " ;
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDaftarPantauCetak601", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilRekapPantauCetak601(String unitUp, Date awal, Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

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
            sql = sql + " 		sum(t1.Lembar_601_sambung) as Lembar_601_sambung, " ;

            sql = sql + " sum(t1.Lembar_601_Tidak_lunas) as Lembar_601_Tidak_lunas, 		";
            sql = sql + " sum(t1.Tagihan_601_Tidak_lunas) as Tagihan_601_Tidak_lunas		 	";

            sql = sql + " 	from";
            sql = sql + " 	(select ";
            sql = sql + " 		tul601.Tgl_TUL601,";
            sql = sql + " 		tul601.UnitUP,";
            sql = sql + " 		1 as Lembar_601,";
            sql = sql + " 		tul601.Tagihan_601,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelunasan_601 is null then 0" ;
            sql = sql + " 	else 1";
            sql = sql + " 	end as Lembar_601_lunas,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelunasan_601 is null then 0";
            sql = sql + " 	else tul601.Tagihan_601";
            sql = sql + " 	end as Tagihan_601_lunas,";
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Putus is null then 0";
            sql = sql + " 	else 1" ;
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
            sql = sql + " 	end as Tagihan_601_putuslunas," ;
            sql = sql + " 	case ";
            sql = sql + " 	when Tgl_Pelaksanaan_Sambung is null then 0";
            sql = sql + " 	else 1";
            sql = sql + " 	end as Lembar_601_sambung, ";

            sql = sql + " case  	when Tgl_Pelunasan_601 is null  	";
            sql = sql + " then 1 	else 0 	end as Lembar_601_Tidak_lunas, 	";
            sql = sql + " case  	when Tgl_Pelunasan_601 is null  	";
            sql = sql + " then tul601.Tagihan_601 	else 0 	end as Tagihan_601_Tidak_lunas         " ;

            sql = sql + "         from tul601_anja tul601 ";
            sql = sql + "         where to_char(tul601.Tgl_TUL601,'yyyymmdd') >= '";
            sql = sql + "         and   to_char(tul601.Tgl_TUL601,'yyyymmdd') <= '";
            sql = sql + " 		  and   tul601.unitup = '" + unitUp + "' ";
            sql = sql + " 	) t1";
            sql = sql + " 	group by";
            sql = sql + " 		trunc(t1.Tgl_TUL601),";
            sql = sql + " 		t1.UnitUP " ;
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilRekapPantauCetak601", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilDaftar601Lunas(String unitUp, Date awalPk, Date akhirPk, Date awalLns, Date akhirLns) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select ";
            sql = sql + " tgl_tul601,to_char(tgl_tul601,'yyyy-mm-dd')||'/TULVI-01/'||no_tul601 as no_tul601,idpelanggan,nokontrak,nokontrol,nama,alamat,lembar_601,thblrek,thblrek_akhir,tagihan_601,";
            sql = sql + " Tgl_Pelaksanaan_Putus,Nama_Putus,Stand_Lwbp_Putus,";
            sql = sql + " Tgl_Pelaksanaan_Sambung,Nama_Sambung,Stand_Lwbp_Sambung,";
            sql = sql + " Tgl_Pelunasan_601 ";
            sql = sql + " from tul601_anja tul601";
            sql = sql + " where ";
            sql = sql + " 	unitup = '" + unitUp + "' ";
            sql = sql + " 	and to_char(Tgl_TUL601,'yyyymmdd') >= '";
            sql = sql + " 	and to_char(Tgl_TUL601,'yyyymmdd') <= '";
            sql = sql + " 	and to_char(Tgl_Pelunasan_601,'yyyymmdd') >= '";
            sql = sql + " 	and to_char(Tgl_Pelunasan_601,'yyyymmdd') <= '";
            sql = sql + " 	and Tgl_Pelunasan_601 is not null";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDaftar601Lunas", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilRekap601Lunas(String unitUp, Date awalPk, Date akhirPk, Date awalLns, Date akhirLns) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "     select ";
            sql = sql + " 		trunc(t1.Tgl_TUL601) as tglCetak_601,";
            sql = sql + " 		t1.UnitUP,";
            sql = sql + " 		sum(t1.Lembar_601) as Lembar_601," ;
            sql = sql + " 		sum(t1.Tagihan_601) as Tagihan_601,";
            sql = sql + " 		sum(t1.Lembar_601_lunas) as Lembar_601_lunas,";
            sql = sql + " 		sum(t1.Tagihan_601_lunas) as Tagihan_601_lunas,";
            sql = sql + " 		sum(t1.Lembar_601_putus) as Lembar_601_putus,";
            sql = sql + " 		sum(t1.Tagihan_601_putus) as Tagihan_601_putus," ;
            sql = sql + " 		sum(t1.Lembar_601_putuslunas) as Lembar_601_putuslunas,";
            sql = sql + " 		sum(t1.Tagihan_601_putuslunas) as Tagihan_601_putuslunas,";
            sql = sql + " 		sum(t1.Lembar_601_sambung) as Lembar_601_sambung, ";

            sql = sql + " sum(t1.Lembar_601_Tidak_lunas) as Lembar_601_Tidak_lunas, 		";
            sql = sql + " sum(t1.Tagihan_601_Tidak_lunas) as Tagihan_601_Tidak_lunas		 	";

            sql = sql + " 	from";
            sql = sql + " 	(select " ;
            sql = sql + " 		tul601.Tgl_TUL601," ;
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
            sql = sql + " 	end as Lembar_601_sambung, " ;

            sql = sql + " case  	when Tgl_Pelunasan_601 is null  	";
            sql = sql + " or (to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') < '";
            sql = sql + " or to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') > '";
            sql = sql + " then 1 	else 0 	end as Lembar_601_Tidak_lunas, 	";
            sql = sql + " case  	when Tgl_Pelunasan_601 is null  	";
            sql = sql + " or (to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') < '";
            sql = sql + " or to_char(tul601.Tgl_Pelunasan_601,'yyyymmdd') > '";
            sql = sql + " then tul601.Tagihan_601 	else 0 	end as Tagihan_601_Tidak_lunas";

            sql = sql + "         from tul601_anja tul601 ";
            sql = sql + "         where to_char(tul601.Tgl_TUL601,'yyyymmdd') >= '";
            sql = sql + "         and   to_char(tul601.Tgl_TUL601,'yyyymmdd') <= '";
            sql = sql + " 		  and   tul601.unitup = '" + unitUp + "' ";
            sql = sql + " 	) t1";
            sql = sql + " 	group by";
            sql = sql + " 		trunc(t1.Tgl_TUL601),";
            sql = sql + " 		t1.UnitUP ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilRekap601Lunas", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilTulVIperNamaPutus(String nama, Date tglAwal, Date tglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  "     select ";
            sql = sql + " 	UnitUP,Tgl_TUL601,No_TUL601,IdPelanggan,";
            sql = sql + " 	Nama,Alamat,ThBlRek,ThBlRek_akhir,Lembar_601,Tagihan_601,";
            sql = sql + " 	Tgl_Pelaksanaan_Putus,Nama_Putus,Stand_Lwbp_Putus,";
            sql = sql + " 	Tgl_Pelunasan_601,";
            sql = sql + " 	Tgl_Pelaksanaan_Sambung,Nama_Sambung,Stand_Lwbp_Sambung,";
            sql = sql + " 	Tgl_jatuh_tempo_601";
            sql = sql + " 	from tul601_anja tul601";
            sql = sql + " 	where NAMA_PUTUS = '" + nama + "' ";
            sql = sql + "   and to_char(tgl_tul601,'yyyymmdd') >= '";
            sql = sql + "   and to_char(tgl_tul601,'yyyymmdd') <= '";
            sql += "";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilTulVIperNamaPutus", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilDetailTulVIperNamaPetugas(String nama, Date tglAwal, Date tglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select * from";
            sql = sql + " (";
            sql = sql + " select nama_putus as petugas, 'a) Pelanggan yang di-PUTUS' as kriteria, ";
            sql = sql + " 	   tgl_tul601 as tgl_PK, No_TUL601 as no_PK, tgl_pelaksanaan_putus as tgl_Realisasi, idpelanggan, nama, alamat, ";
            sql = sql + " 	   thblrek as thbl_awal, thblrek_akhir as thbl_akhir, lembar_601 as lembar, tagihan_601 as rptag, ";
            sql = sql + " 	   stand_lwbp_putus as lwbp, stand_wbp_putus as wbp, stand_kvarh_putus as kvarh, tgl_pelunasan_601 as tgl_lunas ";
            sql = sql + " from tul601_anja tul601 ";
            sql = sql + " where nama_putus = '" + nama + "' ";
            sql = sql + "  	  and to_char(tgl_tul601,'yyyymmdd') >= '";
            sql = sql + "  	  and to_char(tgl_tul601,'yyyymmdd') <= '";
            sql = sql + " order by kriteria, tgl_pk, tgl_realisasi, idpelanggan";
            sql = sql + " )";
            sql = sql + " union all" ;
            sql = sql + " select * from";
            sql = sql + " (" ;
            sql = sql + " select nama_putus as petugas, 'b) Pelanggan yang di-SAMBUNG' as kriteria, ";
            sql = sql + " 	   tgl_tul601 as tgl_PK, No_TUL601 as no_PK, tgl_pelaksanaan_sambung as tgl_Realisasi, idpelanggan, nama, alamat, ";
            sql = sql + " 	   thblrek as thbl_awal, thblrek_akhir as thbl_akhir, lembar_601 as lembar, tagihan_601 as rptag, ";
            sql = sql + " 	   stand_lwbp_sambung as lwbp, stand_wbp_sambung as wbp, stand_kvarh_sambung as kvarh, tgl_pelunasan_601 as tgl_lunas ";
            sql = sql + " from tul601_anja tul601 ";
            sql = sql + " where nama_sambung = '" + nama + "' ";
            sql = sql + "  	  and to_char(tgl_tul601,'yyyymmdd') >= '" ;
            sql = sql + "  	  and to_char(tgl_tul601,'yyyymmdd') <= '";
            sql = sql + " order by kriteria, tgl_pk, tgl_realisasi, idpelanggan";
            sql = sql + " )";
            sql = sql + " union all";
            sql = sql + " select * from";
            sql = sql + " (";
            sql = sql + " select nama_bongkar as petugas, 'c) Pelanggan yang di-BONGKAR' as kriteria, ";
            sql = sql + " 	   tgl_tul603 as tgl_PK, No_TUL603 as no_PK, tgl_pelaksanaan_bongkar as tgl_Realisasi, idpelanggan, nama, alamat, ";
            sql = sql + " 	   thblrek as thbl_awal, thblrek_akhir as thbl_akhir, lembar_603 as lembar, tagihan_603 as rptag, ";
            sql = sql + " 	   stand_lwbp_bongkar as lwbp, stand_wbp_bongkar as wbp, stand_kvarh_bongkar as kvarh, null as tgl_lunas ";
            sql = sql + " from tul603_anja tul603 ";
            sql = sql + " where nama_bongkar = '" + nama + "' ";
            sql = sql + "  	  and to_char(tgl_tul603,'yyyymmdd') >= '";
            sql = sql + "  	  and to_char(tgl_tul603,'yyyymmdd') <= '";
            sql = sql + " order by kriteria, tgl_pk, tgl_realisasi, idpelanggan";
            sql = sql + " )";
            sql += "";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDetailTulVIperNamaPetugas", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilTulVIRekapKinerja(String unitup, Date tglAwal, Date tglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  "  select * from ";
            sql = sql + "  (" ;
            sql = sql + "  select petugas_penerima_pk as namapetugas, 'a) Jumlah PK PUTUS yang di-TERIMA' as kriteria, count(no_tul601) as jumlah from pkputus_anja";
            sql = sql + "  where unitup = '" + unitup + "' and petugas_penerima_pk is not null ";
            String strawal="";
            String strakhir="";
            sql = sql + "  	  and to_char(tgl_terima_pk,'yyyymmdd') >= '" + strawal + "' and to_char(tgl_terima_pk,'yyyymmdd') <= '" + strakhir + "'";
            sql = sql + "  group by petugas_penerima_pk ";
            sql = sql + "  union";
            sql = sql + "  select nama_putus as namapetugas, 'b) Jumlah Pelanggan yang di-PUTUS' as kriteria, count(idpelanggan) as jumlah from tul601_anja tul601";
            sql = sql + "  where unitup = '" + unitup + "' and nama_putus is not null ";
            sql = sql + "  	  and to_char(tgl_pelaksanaan_putus,'yyyymmdd') >= '" + strawal + "' and to_char(tgl_pelaksanaan_putus,'yyyymmdd') <= '" + strakhir + "'";
            sql = sql + "  group by nama_putus" ;
            sql = sql + "  union";
            sql = sql + "  select petugas_sambung as namapetugas, 'c) Jumlah PK SAMBUNG yang di-TERIMA' as kriteria, count(no_pk_sambung) as jumlah from pksambung_anja";
            sql = sql + "  where unitup = '" + unitup + "' and petugas_sambung is not null ";
            sql = sql + "  	  and to_char(created_at,'yyyymmdd') >= '" + strawal + "' and to_char(created_at,'yyyymmdd') <= '" + strakhir + "'";
            sql = sql + "  group by petugas_sambung ";
            sql = sql + "  union";
            sql = sql + "  select nama_sambung as namapetugas, 'd) Jumlah Pelanggan yang di-SAMBUNG' as kriteria, count(idpelanggan) as jumlah from tul601_anja tul601";
            sql = sql + "  where unitup = '" + unitup + "' and nama_sambung is not null " ;
            sql = sql + "  	  and to_char(TGL_pelaksanaan_SAMBUNG,'yyyymmdd') >= '" + strawal + "' and to_char(TGL_pelaksanaan_SAMBUNG,'yyyymmdd') <= '" + strakhir + "'";
            sql = sql + "  group by nama_sambung";
            sql = sql + "  union";
            sql = sql + "  select petugas_penerima_pk as namapetugas, 'e) Jumlah PK BONGKAR yang di-TERIMA' as kriteria, count(no_tul603) as jumlah from pkbongkar_anja";
            sql = sql + "  where unitup = '" + unitup + "' and petugas_penerima_pk is not null ";
            sql = sql + "  	  and to_char(tgl_terima_pk,'yyyymmdd') >= '" + strawal + "' and to_char(tgl_terima_pk,'yyyymmdd') <= '" + strakhir + "'";
            sql = sql + "  group by petugas_penerima_pk ";
            sql = sql + "  union";
            sql = sql + "  select nama_bongkar as namapetugas, 'f) Jumlah Pelanggan yang di-BONGKAR' as kriteria, count(idpelanggan) as jumlah from tul603_anja tul603";
            sql = sql + "  where unitup = '" + unitup + "' and nama_bongkar is not null ";
            sql = sql + "  	  and to_char(tgl_pelaksanaan_bongkar,'yyyymmdd') >= '" + strawal + "' and to_char(tgl_pelaksanaan_bongkar,'yyyymmdd') <= '" + strakhir + "'";
            sql = sql + "  group by nama_bongkar";
            sql = sql + "  )";
            sql = sql + "  order by namapetugas, kriteria " ;
            sql += "";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilTulVIRekapKinerja", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilTulVIperIdPel(String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  "     select ";
            sql = sql + " 	UnitUP,Tgl_TUL601,No_TUL601,IdPelanggan,";
            sql = sql + " 	Nama,Alamat,ThBlRek,ThBlRek_akhir,Lembar_601,Tagihan_601,";
            sql = sql + " 	Tgl_Pelaksanaan_Putus,Nama_Putus,Stand_Lwbp_Putus,";
            sql = sql + " 	Tgl_Pelunasan_601,";
            sql = sql + " 	Tgl_Pelaksanaan_Sambung,Nama_Sambung,Stand_Lwbp_Sambung,";
            sql = sql + " 	Tgl_jatuh_tempo_601";
            sql = sql + " 	from tul601_anja tul601";
            sql = sql + " 	where IdPelanggan = '" + idpel + "' ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilTulVIperIdPel", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambil601BelumLunas(String unitUp, Date awal, Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select ";
            sql = sql + " tgl_tul601,to_char(tgl_tul601,'yyyy-mm-dd')||'/TULVI-01/'||no_tul601 as no_tul601,idpelanggan,nokontrak,nokontrol,nama,alamat,lembar_601,thblrek,thblrek_akhir,tagihan_601,";
            sql = sql + " Tgl_Pelaksanaan_Putus,Nama_Putus,Stand_Lwbp_Putus,";
            sql = sql + " Tgl_Pelaksanaan_Sambung,Nama_Sambung,Stand_Lwbp_Sambung," ;
            sql = sql + " Tgl_Pelunasan_601 ";
            sql = sql + " from tul601_anja tul601";
            sql = sql + " 	where unitup = '" + unitUp + "'";
            sql = sql + " 	and to_char(Tgl_TUL601,'yyyymmdd') >= '" ;
            sql = sql + " 	and to_char(Tgl_TUL601,'yyyymmdd') <= '" ;
            sql = sql + " 	and Tgl_Pelunasan_601 is null";
            sql = sql + " 	";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambil601BelumLunas", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilTul601CetakUlang(String unitUp, Date tglPk, Date noAwal, Integer noAkhir) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        Connection con = null;
        try {
            con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " SELECT ";
            sql = sql + " 	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + " 	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + " 	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + " 	   dpp.unitup, dpp.idpel, dpp.nopel nokontrak, dpp.kddk nokontrol, dpp.ketnodlmrt AS";
            sql = sql + "        kdgardu, dpp.kdkelompok AS notiang, dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, ";
            sql = sql + "        dpp.kogol, dpptab.thblawal, dpptab.thblakhir, dpptab.lembar, ";
            sql = sql + "        dpptab.rptag, dpptab.rpbk, tul601.tgl_tul601, tul601.no_tul601, ";
            sql = sql + "        tul601.thblrek";
            sql = sql + "     FROM (SELECT ";
            sql = sql + " 	   	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + " 		   	  	idpel, min(blth)";
            sql = sql + "                  AS thblawal, max(blth) ";
            sql = sql + "                  AS thblakhir, count(idpel) AS lembar, sum(rptag) AS rptag, " ;
            sql = sql + "                  sum(rpbk1 + rpbk2 + rpbk3) AS rpbk";
            sql = sql + "               FROM dppanja dpp";
            sql = sql + "               WHERE dpp.kdpembpp = 'R1'";
            sql = sql + "                 and dpp.tglbayaranja is null ";
            sql = sql + "                 and dpp.kdgerakkeluaranja is null ";
            sql = sql + "                 AND dpp.unitup = '" + unitUp + "'";
            sql += " and dpp.blth <= to_char(sysdate,'yyyymm') ";
            sql = sql + "               GROUP BY idpel) dpptab, DIL dpp,tul601_anja tul601";
            sql = sql + "     WHERE ";

            sql += " DPP.UNITUP = '" + unitUp + "' AND ";
            sql += " DPP.IDPEL = DPPTAB.IDPEL " ;

            sql = sql + "       AND tul601.idpelanggan = dpptab.idpel";
            sql = sql + "       AND tul601.idpelanggan = dpp.idpel";
            sql = sql + "       AND tul601.thblrek = dpptab.thblawal";
            sql = sql + "       AND tul601.tgl_pelunasan_601 IS NULL";

            sql = sql + "   and tul601.unitup = '" + unitUp + "' ";
            sql = sql + " 	and to_char(tul601.Tgl_TUL601,'yyyymmdd') = '";
            sql = sql + " 	and tul601.No_TUL601 >=  " + noAwal + " ";
            sql = sql + " 	and tul601.No_TUL601 <=  " + noAkhir + "";
            sql = sql + "   order by tul601.No_TUL601 ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);
            con.close();

            retValue.put("AmbilTul601CetakUlang", lMapRecords);
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return retValue;

    }



    @Override
    public Map<String, Object> AmbilTul601Lampiran(String unitUp, Date tglPk, Integer noTul) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select ";
            sql = sql + " /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + " /* +index(dpp idx_dpp_idpel) */";
            sql = sql + " /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + " d.unitup, d.idpel, to_char(to_date(d.blth,'yyyymm'),'Mon-yyyy') as bulan, " ;
            sql = sql + " d.pnj, d.nama, d.namapnj, d.rt, d.lingkungan, d.kodepos, d.tarip, d.daya, d.kogol, d.nopel, d.kddk, ";
            sql = sql + " d.slalwbp, d.sahlwbp, d.slawbp, d.sahwbp, d.slakvarh, d.sahkvarh, d.fakm, d.fakmkvarh, d.kwhlwbp, d.kwhwbp, d.blok3, d.pemkwh, d.kwhkvarh,";
            sql = sql + " to_date(d.tglbayar,'yyyymmdd') as tglbayar, d.kdpp, d.kdpembayar, ";
            sql = sql + " d.uploadtime, to_date(d.tgljttempo,'yyyymmdd') as tgljatuhtempo, d.kdgerakmasuk, d.kdgerakkeluar, d.tgkoreksi,";
            sql = sql + " d.rpptl, d.rpppn, d.rpbpju, d.rptrafo, d.rpmat, d.rpbk1+d.rpbk2+d.rpbk3 as rpbk,";
            sql = sql + " t.lembar_601, t.tagihan_601, t.thblrek, t.thblrek_akhir, t.tgl_tul601 as tgl_601, t.No_TUL601 as no_601, t.unitup || '/VI-01/' || to_char(t.tgl_Tul601,'ddMMyyyy') || '-' || t.no_tul601 as blth ";
            sql = sql + " from dppanja d, tul601_anja t";
            sql = sql + " where d.kdpembpp = 'R1'";
            sql = sql + " and d.tglbayaranja is null and d.kdgerakkeluaranja is null ";
            sql += " and d.blth <= to_char(sysdate,'yyyymm') ";
            sql = sql + " and t.idpelanggan = d.idpel" ;
            sql = sql + " and d.blth >= t.thblrek" ;
            sql = sql + " and d.blth <= t.thblrek_akhir";
            sql = sql + " and t.tgl_pelunasan_601 IS NULL  ";
            sql = sql + " and d.unitup = '" + unitUp + "'";
            sql = sql + " and t.unitup = '" + unitUp + "'" ;
            Object strTglPk = null;
            sql = sql + " and to_char(t.Tgl_TUL601,'yyyymmdd') = '" + strTglPk + "' ";
            sql = sql + " and t.No_TUL601 =  " + noTul + " " ;
            sql += "";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601Lampiran", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    //---- Tul VI-03
    @Override
    public Map<String, Object> ambilNomerTulVI03(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select max(no_tul603) as nomer from tul603_anja tul603 ";
            sql += " where unitup = '" + unitUp + "' ";
            sql += " and to_char(tgl_tul603,'yyyymmdd') = to_char(sysdate,'yyyymmdd') ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNomerTulVI03", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilTul603(Boolean is60hari, String unitUp, String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select xxx.unitup, idpel, xxx.nokontrak, xxx.nokontrol, kdgardu, notiang, ";
            sql = sql + "      xxx.nama, namapnj, tarip, daya, kogol, ";
            sql = sql + "  	   thblawal, thblakhir, lembar, rptag, rpbk,";
            sql = sql + "  	   tgl_jatuh_tempo_601, xxx.no_60, xxx.no_601, xxx.no_tul601, xxx.tgl_tul601, xxx.thblrek, sysdate as tgl_catat_60 ";
            sql = sql + " from";
            sql = sql + " (";
            sql = sql + " select ";
            sql = sql + "  	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + "  	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + "  	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + "        dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.ketnodlmrt as kdgardu, dpp.kdkelompok as notiang, " ;
            sql = sql + "   	 dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, dpp.kogol, ";
            sql = sql + "  	     dppTab.thblawal, dppTab.thblakhir, dppTab.lembar, dppTab.rptag, dppTab.rpbk,";
            sql = sql + "  	     tul601.tgl_jatuh_tempo_601, tul601.no_60, tul601.no_601, tul601.no_tul601, tul601.tgl_tul601, tul601.thblrek";
            sql = sql + " from";
            sql = sql + "  	   (SELECT  idpel, MIN(dpp.blth) as thblawal, MAX(dpp.blth) as thblakhir, ";
            sql = sql + "  	   count(idpel) as Lembar, sum(RpTag) as rpTag,sum(RpBK1+RpBK2+RpBK3) as RpBK" ;
            sql = sql + "  	   FROM  dppanja dpp " ;
            sql = sql + "  	   where ";
            sql = sql + "  			dpp.kdpembPp = 'R1' " ;
            sql = sql + "           and kdgerakkeluar is null ";
            sql += " and dpp.blth <= to_char(sysdate,'yyyymm') ";
            sql = sql + "        and dpp.unitup = '" + unitUp + "' ";
            sql = sql + "  			GROUP BY idpel";
            sql = sql + "  			) ";
            sql = sql + "  	   dppTab, DIL dpp, tul601";
            sql = sql + " where " ;

            sql += " DPP.UNITUP = '" + unitUp + "' AND ";
            sql += " DPP.IDPEL = DPPTAB.IDPEL AND ";

            sql = sql + "  	tul601.idpelanggan = dppTab.idpel and";
            sql = sql + "  	tul601.idpelanggan = dpp.idpel and";
            sql = sql + "  	tul601.thblrek = dppTab.thblawal and";

                sql = sql + " 	tul601.Tgl_jatuh_tempo_601 < sysdate and";

            sql = sql + "  	tul601.tgl_pelunasan_601 is null and";
            sql = sql + "   tul601.unitup = '" + unitUp + "'";
            sql += sqlKriteria;
            sql = sql + " ) xxx ";

            sql = sql + " , tul603" ;
            sql = sql + " where" ;
            sql = sql + " xxx.No_601 = tul603.No_601(+)";
            sql = sql + " and tul603.no_601 is null";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul603", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> insertTulVI03(Integer No_60, Integer no_601,
                                             String UnitUP, String ThBlRek, String IdPelanggan,
                                             String NoKontrak, String NoKontrol, String Nama,
                                             String Alamat, String ThBlRek_akhir,
                                             String Lembar_603, String Tagihan_603, String NOtul603, String NOtul601, Date tglTul601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "  INSERT INTO TUL603 ";
            sql = sql + "  (no_603,no_601,No_60,UnitUP,ThBlRek,IdPelanggan, NoKontrak,NoKontrol, Nama,Alamat,";
            sql = sql + "  No_TUL601,Tgl_TUL601, no_tul603, tgl_tul603, ThBlRek_akhir,Lembar_603,Tagihan_603)";
            sql = sql + "  VALUES( seq_tul603.nextval, ";
            sql = sql + "  '" + no_601 + "', '" + No_60 + "', '" + UnitUP + "', '" + ThBlRek + "', '" + IdPelanggan + "', ";
            sql = sql + "  '" + NoKontrak + "', '" + NoKontrol + "', ";
            Object strTglTul601 = null;
            sql = sql + "  '" + Nama + "', '" + Alamat + "', '" + NOtul601 + "', to_date('" + strTglTul601 + "','yyyymmdd'), '" + NOtul603 + "', sysdate, ";
            sql = sql + "  '" + ThBlRek_akhir + "', '" + Lembar_603 + "', '" + Tagihan_603 + "')";
            sql += "";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("insertTulVI03", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilCetakKertasTulVI() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select par_value from sip3_konfigurasi where par_name = 'KERTASWASKIT' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilCetakKertasTulVI", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    //---- Pemutusan Penyambungan
    @Override
    public Map<String, Object> ambilDetailTul601(String strtgl, String noTul) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select NO_601, NO_60, UNITUP, THBLREK, IDPELANGGAN, NOKONTRAK, NOKONTROL, NAMA, ALAMAT, NO_TUL601, TGL_TUL601, STAND_LWBP_601, STAND_WBP_601, STAND_KVARH_601, THBLREK_AKHIR, LEMBAR_601, TAGIHAN_601, BLTHREK_601, TGL_PELAKSANAAN_PUTUS, NAMA_PUTUS, STAND_LWBP_PUTUS, STAND_WBP_PUTUS, STAND_KVARH_PUTUS, TGL_PELUNASAN_601, NO_601_SAMBUNG, TGL_601_SAMBUNG, TGL_PELAKSANAAN_SAMBUNG, NAMA_SAMBUNG, STAND_LWBP_SAMBUNG, STAND_WBP_SAMBUNG, STAND_KVARH_SAMBUNG, TGL_JATUH_TEMPO_601 ";
            sql = sql + " from tul601_anja tul601 ";
            sql = sql + " where to_char(tgl_tul601,'yyyymmdd') = '" + strtgl + "' ";
            sql = sql + " and no_tul601 = '" + noTul + "' ";
            sql = sql + " ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDetailTul601", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpanPutus(Date tglPutus, String namaPutus, String lwbp, String wbp, String kvarh, Date tgl601, String no601, String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " update tul601_anja set";

            sql = sql + " tgl_pelaksanaan_putus = to_date ";
            sql = sql + " nama_putus = '" + namaPutus + "',";
            sql = sql + " stand_lwbp_putus = '" + lwbp + "',";
            sql = sql + " stand_wbp_putus = '" + wbp + "',";
            sql = sql + " stand_kvarh_putus = '" + kvarh + "'";
            sql = sql + " where ";

            sql = sql + " to_char(tgl_tul601,'yyyymmdd') = '";
            sql = sql + " and no_tul601 = '" + no601 + "'";
            sql = sql + " and unitup = '" + unitUp + "' ";
            sql = sql + "  ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanPutus", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> simpanSambung(Date tglsambung, String namasambung, String lwbp, String wbp, String kvarh, Date tgl601, String no601, String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " update tul601_anja set";

            sql = sql + " tgl_pelaksanaan_sambung = to_date " ;
            sql = sql + " nama_sambung = '" + namasambung + "',";
            sql = sql + " stand_lwbp_sambung = '" + lwbp + "',";
            sql = sql + " stand_wbp_sambung = '" + wbp + "',";
            sql = sql + " stand_kvarh_sambung = '" + kvarh + "'";
            sql = sql + " where ";
            sql = sql + " to_char(tgl_tul601,'yyyymmdd') = '";
            sql = sql + " and no_tul601 = '" + no601 + "'";
            sql = sql + " and unitup = '" + unitUp + "' ";
            sql = sql + "  ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanSambung", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilBuatCetakTul603(String txtIdpel, String unitUp, String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "  select t.*,d.* from ";

            sql = sql + "  (";
            sql = sql + " select " ;
            sql = sql + " xxx.unitup || '/VI-01/' || to_char(xxx.tgl_tul601,'ddmmyyyy') || '-' || xxx.no_tul601 as nomer601, ";
            sql = sql + " xxx.unitup, idpel, xxx.nokontrak, xxx.nokontrol, kdgardu, notiang, ";
            sql = sql + "      xxx.nama, namapnj, tarip, daya, kogol, ";
            sql = sql + "  	   thblawal, thblakhir, lembar, rptag, rpbk,";
            sql = sql + "  	   tul603.tgl_tul603 as tgl_jatuh_tempo_601, xxx.no_60, xxx.no_601, " ;
            sql = sql + " tul603.no_tul603 as no_tul601, xxx.tgl_tul601, xxx.unitup || '/VI-03/' || to_char(tul603.tgl_tul603,'ddmmyyyy') || '-' || tul603.no_tul603 as thblrek ";
            sql = sql + " from";
            sql = sql + " (";
            sql = sql + " select ";
            sql = sql + "  	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + "  	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + "        dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.ketnodlmrt as kdgardu, dpp.kdkelompok as notiang, ";
            sql = sql + "   	 dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, dpp.kogol, ";
            sql = sql + "  	     dppTab.thblawal, dppTab.thblakhir, dppTab.lembar, dppTab.rptag, dppTab.rpbk,";
            sql = sql + "  	     tul601.tgl_jatuh_tempo_601, tul601.no_60, tul601.no_601, tul601.no_tul601, tul601.tgl_tul601, tul601.thblrek";
            sql = sql + " from";
            sql = sql + "  	   (SELECT  idpel, MIN(dpp.blth) as thblawal, MAX(dpp.blth) as thblakhir, ";
            sql = sql + "  	   count(idpel) as Lembar, sum(RpTag) as rpTag,sum(RpBK1+RpBK2+RpBK3) as RpBK" ;
            sql = sql + "  	   FROM  dppanja dpp ";
            sql = sql + "  	   where " ;
            sql = sql + "  			dpp.kdpembPp = 'R1' ";
            sql = sql + "           and dpp.kdgerakkeluaranja is null ";
            sql = sql + "           and dpp.tglbayaranja is null ";
            sql += " and dpp.blth <= to_char(sysdate,'yyyymm') ";
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
            sql = sql + " ) xxx ";
            sql = sql + " , tul603";
            sql = sql + " where";
            sql = sql + " xxx.No_601 = tul603.No_601(+)";
            sql = sql + "  ) t,";
            sql = sql + "  (" ;
            sql = sql + "  select idpel as didpel, blth as dthbl,to_char(to_date(blth,'yyyymm'),'Mon-yyyy') as dbulan,";
            sql = sql + "  rpptl as dprppal, rpppn as drpppn, rpbpju as drpppj, rptrafo as drptrafo, rpmat as drpmat, rpbk1+rpbk2+rpbk3 as drpbk ";
            sql = sql + "  from dppanja dpp where dpp.tglbayaranja is null and dpp.kdgerakkeluaranja is null ";
            sql = sql + "  ) d " ;
            sql = sql + "  where " ;
            sql = sql + "  d.dthbl >= t.thblawal and d.dthbl <= t.thblakhir";
            sql = sql + "  and d.didpel = t.idpel" ;
            sql = sql + "  and d.didpel = '" + txtIdpel + "' ";
            sql = sql + "  order by d.dthbl";
            sql = sql + " ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilBuatCetakTul603", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> AmbilBuatCetakUlangTul603(String unitUp, Date TglPk, Integer noTul) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "  select t.*,d.* from ";

            sql = sql + "  (";
            sql = sql + " select ";
            sql = sql + " xxx.unitup || '/VI-01/' || to_char(xxx.tgl_tul601,'ddmmyyyy') || '-' || xxx.no_tul601 as nomer601, ";
            sql = sql + " xxx.unitup, idpel, xxx.nokontrak, xxx.nokontrol, kdgardu, notiang, ";
            sql = sql + "      xxx.nama, namapnj, tarip, daya, kogol, ";
            sql = sql + "  	   thblawal, thblakhir, lembar, rptag, rpbk,";
            sql = sql + "  	   tul603.tgl_tul603 as tgl_jatuh_tempo_601, xxx.no_60, xxx.no_601, ";
            sql = sql + " tul603.no_tul603 as no_tul601, xxx.tgl_tul601, xxx.unitup || '/VI-03/' || to_char(tul603.tgl_tul603,'ddmmyyyy') || '-' || tul603.no_tul603 as thblrek ";
            sql = sql + " from";
            sql = sql + " (";
            sql = sql + " select " ;
            sql = sql + "  	   /* +index(dpp idx_dpp_blth) */ " ;
            sql = sql + "  	   /* +index(dpp idx_dpp_idpel) */" ;
            sql = sql + "  	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + "        dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.ketnodlmrt as kdgardu, dpp.kdkelompok as notiang, ";
            sql = sql + "   	 dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, dpp.kogol, ";
            sql = sql + "  	     dppTab.thblawal, dppTab.thblakhir, dppTab.lembar, dppTab.rptag, dppTab.rpbk,";
            sql = sql + "  	     tul601.tgl_jatuh_tempo_601, tul601.no_60, tul601.no_601, tul601.no_tul601, tul601.tgl_tul601, tul601.thblrek";
            sql = sql + " from";
            sql = sql + "  	   (SELECT  idpel, MIN(dpp.blth) as thblawal, MAX(dpp.blth) as thblakhir, ";
            sql = sql + "  	   count(idpel) as Lembar, sum(RpTag) as rpTag,sum(RpBK1+RpBK2+RpBK3) as RpBK";
            sql = sql + "  	   FROM  dppanja dpp ";
            sql = sql + "  	   where ";
            sql = sql + "  			dpp.kdpembPp = 'R1' ";
            sql = sql + "           and dpp.kdgerakkeluaranja is null " ;
            sql = sql + "           and dpp.tglbayaranja is null ";
            sql += " and dpp.blth <= to_char(sysdate,'yyyymm') ";
            sql = sql + "        and dpp.unitup = '" + unitUp + "' ";
            sql = sql + "  			GROUP BY idpel" ;
            sql = sql + "  			) " ;
            sql = sql + "  	   dppTab, DIL dpp, tul601_anja tul601";
            sql = sql + " where " ;

            sql += " DPP.UNITUP = '" + unitUp + "' AND ";
            sql += " DPP.IDPEL = DPPTAB.IDPEL AND ";

            sql = sql + "  	tul601.idpelanggan = dppTab.idpel and";
            sql = sql + "  	tul601.idpelanggan = dpp.idpel and";
            sql = sql + "  	tul601.thblrek = dppTab.thblawal and";
            sql = sql + "  	tul601.tgl_pelunasan_601 is null and" ;
            sql = sql + "   tul601.unitup = '" + unitUp + "'";
            sql = sql + " ) xxx ";
            sql = sql + " , tul603" ;
            sql = sql + " where";
            sql = sql + " xxx.No_601 = tul603.No_601(+)";
            sql = sql + "  ) t," ;
            sql = sql + "  (" ;
            sql = sql + "  select idpel as didpel, blth as dthbl,to_char(to_date(blth,'yyyymm'),'Mon-yyyy') as dbulan,";
            sql = sql + "  rpptl as dprppal, rpppn as drpppn, rpbpju as drpppj, rptrafo as drptrafo, rpmat as drpmat, rpbk1+rpbk2+rpbk3 as drpbk ";
            sql = sql + "  from dppanja dpp where kdgerakkeluaranja is null and tglbayaranja is null ";
            sql = sql + "  ) d ";
            sql = sql + "  where " ;
            sql = sql + "  d.dthbl >= t.thblawal and d.dthbl <= t.thblakhir" ;
            sql = sql + "  and d.didpel = t.idpel";

            sql = sql + " and to_char(t.tgl_jatuh_tempo_601,'yyyymmdd') = '";
            sql = sql + " and t.no_tul601 = '" + noTul + "' ";

            sql = sql + "  order by d.dthbl";
            sql = sql + " " ;

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilBuatCetakUlangTul603", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    //---- Penanganan Petugas
    @Override
    public Map<String, Object> simpanGroup(String unitup, String namagroup, String deskripsi, String jenisgroup, String statusaktif, String created_by) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " insert into groupwaskit (unitup,namagroup,deskripsi,jenisgroup,statusaktif,created_by,created_at)";

            sql = sql + " values ('" + unitup + "','" + namagroup + "','" + deskripsi + "','" + jenisgroup + "','" + 1 + "','" + created_by + "',sysdate)";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanGroup", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpanPetugas(String unitup, String namapetugas, String keterangan, String namagroup, String statusaktif, String created_by) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " insert into petugaswaskit (unitup,namapetugas,keterangan,namagroup,statusaktif,created_by,created_at)";

            sql = sql + " values ('" + unitup + "','" + namapetugas + "','" + keterangan + "','" + namagroup + "','" + statusaktif + "','" + created_by + "',sysdate) ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanPetugas", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> lihatGroup() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select created_at,namagroup,statusaktif,unitup,deskripsi,jenisgroup,created_by";

            sql = sql + " from groupwaskit";
            sql = sql + " order by created_at desc";            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("lihatGroup", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> lihatPetugas() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select created_at,namapetugas,statusaktif,unitup,keterangan,namagroup,created_by";

            sql = sql + " from petugaswaskit";
            sql = sql + " order by created_at desc";           CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("lihatPetugas", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> nonAktifGroup(String group) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " update groupwaskit ";

            sql += " set statusaktif = 0 ";
            sql += " where namagroup = '" + group + "' " ;        CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("nonAktifGroup", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;      }


    @Override
    public Map<String, Object> nonAktifPetugas(String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " update petugaswaskit ";

            sql += " set statusaktif = 0 ";
            sql += " where namapetugas = '" + petugas + "' ";        CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("nonAktifPetugas", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> ambilPetugasWaskit() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select namapetugas from petugaswaskit where statusaktif = 1 order by namapetugas ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilPetugasWaskit", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> ambilGroupPetugas() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select namagroup from groupwaskit where statusaktif = 1 order by namagroup ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilGroupPetugas", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> simpanPenugasan(String unitup, String no_pk_sambung, String pemberi_material, String no_pk_tul6, String petugas_sambung, String material1, String material2, String material3, String keterangan, String created_by) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " insert into pksambung_anja (UNITUP, NO_PK_SAMBUNG, PEMBERI_MATERIAL, NO_PK_TUL6, PETUGAS_SAMBUNG, MATERIAL1, MATERIAL2, MATERIAL3, KETERANGAN, CREATED_BY, CREATED_AT)";
            sql = sql + " values ('" + unitup + "','" + no_pk_sambung + "','" + pemberi_material + "','" + no_pk_tul6 + "','" + petugas_sambung + "','" + material1 + "','" + material2 + "','" + material3 + "','" + keterangan + "','" + created_by + "',sysdate)";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanPenugasan", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> hapusPenugasan(String noPkSambung) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " delete pksambung_anja";
            sql += " where no_pk_sambung = '" + noPkSambung + "' ";            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("hapusPenugasan", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> lihatPenugasan(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select UNITUP, NO_PK_SAMBUNG, PEMBERI_MATERIAL, NO_PK_TUL6, PETUGAS_SAMBUNG, MATERIAL1, MATERIAL2, MATERIAL3, KETERANGAN, CREATED_BY, CREATED_AT";
            sql = sql + " from pksambung_anja" ;
            sql = sql + " where unitup = '" + unitUp + "'";
            sql = sql + " 	  and 0 = 0";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("lihatPenugasan", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    //---- Distribusi PK per-Petugas
    @Override
    public Map<String, Object> simpanDistribusiPKPutus(String unitup, String tgltul, String notul, String iKodePetugas, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " insert into pkputus_anja";
            sql = sql + " 	   		(UNITUP, TGL_TUL601, NO_TUL601, PEMBERI_PK, PETUGAS_PENERIMA_PK, TGL_TERIMA_PK, ALASANTIDAKPUTUS, CREATED_BY, CREATED_AT)";
            sql = sql + " values" ;
            sql = sql + " 	  		('" + unitup + "',to_date('" + tgltul + "','yyyymmdd'),'" + notul + "','" + iKodePetugas + "','" + petugas + "',trunc(sysdate),'','" + iKodePetugas + "',sysdate)";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanDistribusiPKPutus", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> simpanDistribusiPKBongkar(String unitup, String tgltul, String notul, String iKodePetugas, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " insert into pkbongkar_anja";
            sql = sql + " 	   		(UNITUP, TGL_TUL603, NO_TUL603, PEMBERI_PK, PETUGAS_PENERIMA_PK, TGL_TERIMA_PK, ALASANTIDAKBONGKAR, CREATED_BY, CREATED_AT)";
            sql = sql + " values";
            sql = sql + " 	  		('" + unitup + "',to_date('" + tgltul + "','yyyymmdd'),'" + notul + "','" + iKodePetugas + "','" + petugas + "',trunc(sysdate),'','" + iKodePetugas + "',sysdate)";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanDistribusiPKBongkar", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> lihatDistribusiPKPutus(String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select a.no_tul601 nocetaktul, a.idpelanggan no_pelanggan, a.nama nama_pelanggan, ";
            sql = sql + " 	   a.lembar_601 totallembar, a.tagihan_601 tagihan,";
            sql = sql + " 	   a.tgl_tul601 tanggal_cetak, b.tgl_terima_pk tanggal_perintah_kerja, ";
            sql = sql + " 	   a.tgl_pelaksanaan_putus tanggal_pelaksanaan, ";
            sql = sql + " 	   b.petugas_penerima_pk nama_pelaksana, b.alasantidakputus keterangan";
            sql = sql + " from tul601_anja A, pkputus B";
            sql = sql + " where trunc(a.tgl_tul601) = b.tgl_tul601 (+) and a.no_tul601 = b.no_tul601 (+)";
            sql = sql + " 	   and 0 = 0";
            sql += sqlKriteria;
            sql = sql + " order by a.tgl_tul601, a.no_tul601, a.nokontrol";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("lihatDistribusiPKPutus", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> lihatDistribusiPKBongkar(String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select a.no_tul603 nocetaktul, a.idpelanggan no_pelanggan, a.nama nama_pelanggan, ";
            sql = sql + " 	   a.lembar_603 totallembar, a.tagihan_603 tagihan,";
            sql = sql + " 	   a.tgl_tul603 tanggal_cetak, b.tgl_terima_pk tanggal_perintah_kerja, ";
            sql = sql + " 	   a.tgl_pelaksanaan_bongkar tanggal_pelaksanaan, " ;
            sql = sql + " 	   b.petugas_penerima_pk nama_pelaksana, b.alasantidakbongkar keterangan";
            sql = sql + " from tul603_anja A, pkbongkar B";
            sql = sql + " where trunc(a.tgl_tul603) = b.tgl_tul603 (+) and a.no_tul603 = b.no_tul603 (+)";
            sql = sql + " 	   and 0 = 0";
            sql += sqlKriteria ;
            sql = sql + " order by a.tgl_tul603, a.no_tul603, a.nokontrol";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("lihatDistribusiPKBongkar", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> AmbilTul601_incl_sdh_ctk(String unitUp, String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =   " select ";
            sql = sql + " 	   /* +index(dpp idx_dpp_blth) */ ";
            sql = sql + " 	   /* +index(dpp idx_dpp_idpel) */";
            sql = sql + " 	   /* +index(dpp idx_dpp_unitup) */ ";
            sql = sql + "      dpp.unitup, dpp.idpel, dpp.nopel as nokontrak, dpp.kddk as nokontrol, dpp.ketnodlmrt as kdgardu, dpp.kdkelompok as notiang, ";
            sql = sql + "  	   dpp.nama, dpp.namapnj, dpp.tarip, dpp.daya, dpp.kogol, " ;
            sql = sql + " 	   dppTab.thblawal, dppTab.thblakhir, dppTab.lembar, dppTab.rptag, dppTab.rpbk,";
            sql = sql + " 	   tul60.tgl_catat_60, tul60.no_60, tul60.thblrek" ;
            sql = sql + " from" ;
            sql = sql + " 	(SELECT  idpel, MIN(BLTH) as thblawal, MAX(BLTH) as thblakhir, " ;
            sql = sql + " 	count(idpel) as Lembar, sum(RpTag) as rpTag,sum(RpBK1+RpBK2+RpBK3) as RpBK";
            sql = sql + " 	FROM  dppanja DPP ";
            sql = sql + " 		where ";
            sql = sql + " 			dpp.kdpembPp = 'R1' ";
            sql = sql + " 			and dpp.tglbayaranja is null " ;
            sql = sql + "           and kdgerakkeluaranja is null ";
            sql += " and BLTH <= to_char(sysdate,'yyyymm') ";
            sql = sql + "           and dpp.unitup = '" + unitUp + "' " ;
            sql = sql + " 			and dpp.kdgerakmasuk in ('11','12','13') " ;
            sql = sql + " 			GROUP BY idpel";
            sql = sql + " 			) ";
            sql = sql + " 	dppTab, DIL DPP, tul60";
            sql = sql + " where " ;

            sql += " DPP.UNITUP = '" + unitUp + "' AND " ;
            sql += " DPP.IDPEL = DPPTAB.IDPEL AND ";

            sql = sql + " 	tul60.idpelanggan = dppTab.idpel and";
            sql = sql + " 	tul60.idpelanggan = dpp.idpel and";
            sql = sql + " 	tul60.thblrek = dppTab.thblawal and" ;
            sql = sql + " 	tul60.tgl_pelunasan_60 is null and";
            sql = sql + "   tul60.unitup = '" + unitUp + "' " ;
            sql += sqlKriteria;
            sql += "" ;
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601_incl_sdh_ctk", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }
    //---- ### END WASKIT ####################################################################################


    //---- ### START BELI REKENING ANJA ####################################################################################
    @Override
    public Map<String, Object> beliAnja_TampilGrid(String unitup, String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select IDPEL, BLTH, RPTAG, RPBK, NAMA, NAMAPNJ, TARIP, DAYA, KOGOL, ";
            sql += "KDDK, KDINKASO, KDKELOMPOK, LEMBAR, KDPEMBPP, KDGERAKMASUK, STATUS, NOREK ";
            sql += "from view_21anjabeli_tampilform  ";
            sql += "where 1 = 1 ";
            sql += sqlKriteria;
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("beliAnja_TampilGrid", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> beliAnja_LunasiDPP21(Map<String, Object> dtrans, String tTransaksiBy, String tTglBayar, String tKdPP, String tKdPembayar) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  "";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("beliAnja_LunasiDPP21", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> rptVIEW_BA21_ANJA(String unitup, String tgltransaksi, String tglbayar, String kdpp, String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " SELECT ";
            sql = sql + " TGLCETAK, TGLTRANSAKSI, TGLBAYAR, KOGOL, LEMBAR, RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAKKELUAR, KDPEMBPP, STATUS, KDKIRIM, UNITUP, KODEPP, NAMAPP, ALAMATPP, TRANSAKSIBY, KODEGAGAL ";
            sql = sql + " FROM" ;
            sql = sql + " VIEW_BA21";
            sql += " WHERE ";
            sql += " flaganja = '1' ";
            sql += " AND to_char(tgltransaksi,'yyyymmdd') = '" + tgltransaksi + "' ";
            sql += " AND to_char(TGLBAYAR,'yyyymmdd') = '" + tglbayar + "'  ";
            sql += " AND KODEPP = '" + kdpp + "' ";
            sql += " AND TRANSAKSIBY = '" + transaksiby + "' ";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("rptVIEW_BA21_ANJA", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> rptVIEW_BA21Daftar_ANJA(String unitup, String tgltransaksi, String tglbayar, String kdpp, String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " SELECT ";
            sql = sql + " TGLCETAK, TGLTRANSAKSI, IDPEL, KOGOL, BLTH, KDPEMBPP, STATUS, NOREK, RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKIRIM, UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, PEMDA, KDPPJ, TARIP, DAYA, KODEPP, NAMAPP, ALAMATPP, TRANSAKSIBY, KODEGAGAL ";
            sql = sql + " FROM";
            sql = sql + " VIEW_BA21_DAFTAR";
            sql += " WHERE ";
            sql += " flaganja = '1' " ;
            sql += " AND to_char(tgltransaksi,'yyyymmdd') = '" + tgltransaksi + "'  ";
            sql += " AND to_char(TGLBAYAR,'yyyymmdd') = '" + tglbayar + "'  ";
            sql += " AND KDPP = '" + kdpp + "' ";
            sql += " AND TRANSAKSIBY = '" + transaksiby + "' ";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("rptVIEW_BA21Daftar_ANJA", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }
    //---- ### END BELI REKENING ANJA ####################################################################################


    //---- ### START UPLOAD LUNAS REKENING ANJA ####################################################################################
    @Override
    public Map<String, Object> SetData_21LUNASIANJA(Map<String, Object> dtrans, String tTransaksiBy, String tTglBayar, String tKdPP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  "SetData_21LUNASIANJA";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetData_21LUNASIANJA", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> SetData_21INSERTANJA(Map<String, Object> dtrans, String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  "";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetData_21INSERTANJA", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> DeleteDPHOFFLINE(Map<String, Object> dr, String tTRANSAKSIBY) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  "DELETE TEMPDPHOFFLINE";
            String mSql = " WHERE TRANSAKSIBY = '" + tTRANSAKSIBY + "'";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("DeleteDPHOFFLINE", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> InsertTempDPHOFFLINE(Map<String, Object> dr, String tTRANSAKSIBY) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  "";

            String mSql = " (BLTH, IDPEL, ";
            mSql += "   KDGERAKMASUK,  ";
            mSql += "KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, ";
            mSql += "KDPP, KDPEMBAYAR, ";
            mSql += "STATUS, KDPEMBPP, " ;
            mSql += "KDPEMBAYARSIP3, UNITUP, PEMDA, " ;
            mSql += "TARIP,  ";
            mSql += "DAYA, KOGOL, ";
            mSql += "SUBKOGOL, ";
            mSql += "KDPPJ, UNITKJ, KDINKASO, " ;
            mSql += "KDKELOMPOK, " ;
            mSql += "RPPTL, RPTB, RPPPN, ";
            mSql += "RPBPJU, RPTRAFO, RPSEWATRAFO, ";
            mSql += "RPSEWAKAP,  RPANGSA, ";
            mSql += " RPANGSB,  ";
            mSql += "RPANGSC, RPMAT, RPPLN, ";
            mSql += "RPTAG, ";
            mSql += "RPREDUKSI, RPINSENTIF, RPDISINSENTIF, ";
            mSql += "RPBK1, RPBK2, RPBK3, ";
            mSql += "RPSELISIH, ";
            mSql += "NOREK, NOAGENDA, FLAGSOPP, ";
            mSql += "FLAGANJA, KDKIRIM,  ";
            mSql += "TGLTRANSAKSI, ";
            mSql += "TRANSAKSIBY) ";
            String Values = "";
            Values += Convert2SQL_DKRP(dr.get("BLTH")) + "," ;
            Values += Convert2SQL_DKRP(dr.get("IDPEL")) + ",";
            Values += Convert2SQL_DKRP(dr.get("KDGERAKMASUK")) + ","; //Convert2SQL_DKRP(dr.get("KDGERAKMASUK")) + "," ;
            Values += "'21',"; // 'Convert2SQL_DKRP(dr.get("KDGERAKKELUAR")) + ",";
            Values += Convert2SQL_DKRP(dr.get("TGLBAYAR")) + "," ;
            Values += "null,"; // 'Convert2SQL_DKRP(dr.get("WKTBAYAR")) + ",";
            Values += Convert2SQL_DKRP(dr.get("KDPP")) + ",";
            Values += Convert2SQL_DKRP(dr.get("KDPEMBAYAR")) + "," ;
            Values += Convert2SQL_DKRP(dr.get("STATUS")) + ",";
            Values += "'R1',"; // 'Convert2SQL_DKRP(dr.get("KDPEMBPP")) + ",";
            Values += "null,"; // 'Convert2SQL_DKRP(dr.get("KDPEMBAYARSIP3")) + ",";
            Values += Convert2SQL_DKRP(dr.get("UNITUP")) + ",";
            Values += Convert2SQL_DKRP(dr.get("PEMDA")) + ",";
            Values += Convert2SQL_DKRP(dr.get("TARIP")) + ",";
            Values += Convert2SQL_DKRP(dr.get("DAYA")) + ",";
            Values += Convert2SQL_DKRP(dr.get("KOGOL")) + ",";
            Values += Convert2SQL_DKRP(dr.get("SUBKOGOL")) + "," ;
            Values += Convert2SQL_DKRP(dr.get("KDPPJ")) + ",";
            Values += Convert2SQL_DKRP(dr.get("UNITKJ")) + ",";
            Values += Convert2SQL_DKRP(dr.get("KDINKASO")) + ",";
            Values += Convert2SQL_DKRP(dr.get("KDKELOMPOK")) + ",";
            Values += Convert2SQL_DKRP(dr.get("RPPTL")) + ",";
            Values += Convert2SQL_DKRP(dr.get("RPTB")) + ",";
            Values += Convert2SQL_DKRP(dr.get("RPPPN")) + ",";
            Values += Convert2SQL_DKRP(dr.get("RPBPJU")) + "," ;
            Values += Convert2SQL_DKRP(dr.get("RPTRAFO")) + "," ;
            Values += Convert2SQL_DKRP(dr.get("RPSEWATRAFO")) + ",";
            Values += Convert2SQL_DKRP(dr.get("RPSEWAKAP")) + ",";
            Values += Convert2SQL_DKRP(dr.get("RPANGSA")) + ",";
            Values += Convert2SQL_DKRP(dr.get("RPANGSB")) + ",";
            Values += Convert2SQL_DKRP(dr.get("RPANGSC")) + "," ;
            Values += Convert2SQL_DKRP(dr.get("RPMAT")) + ",";
            Values += Convert2SQL_DKRP(dr.get("RPPLN")) + ",";
            Values += Convert2SQL_DKRP(dr.get("RPTAG")) + ",";
            Values += Convert2SQL_DKRP(dr.get("RPREDUKSI")) + ",";
            Values += Convert2SQL_DKRP(dr.get("RPINSENTIF")) + "," ;
            Values += Convert2SQL_DKRP(dr.get("RPDISINSENTIF")) + ",";
            Values += Convert2SQL_DKRP(dr.get("RPBK1")) + ",";
            Values += Convert2SQL_DKRP(dr.get("RPBK2")) + ",";
            Values += Convert2SQL_DKRP(dr.get("RPBK3")) + ",";
            Values += Convert2SQL_DKRP(dr.get("RPSELISIH")) + ",";
            Values += Convert2SQL_DKRP(dr.get("NOREK")) + ",";
            Values += Convert2SQL_DKRP(dr.get("NOAGENDA")) + ",";
            Values += Convert2SQL_DKRP(dr.get("FLAGSOPP")) + ",";
            Values += Convert2SQL_DKRP(dr.get("FLAGANJA")) + ",";
            Values += "'U',"; // 'Convert2SQL_DKRP(dr.get("KDKIRIM")) + ",";
            Values += "sysdate,";
            Values += "'" + tTRANSAKSIBY + "'";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("InsertTempDPHOFFLINE", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;
    }


    @Override
    public Map<String, Object> SetData_21UPDATEANJA(String tTransaksiBy, String tTglBayar, String tKdPP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =   "SELECT BLTH, IDPEL, KDPEMBAYAR, STATUS, KDPEMBPP,RPTAG, (RPBK1 + RPBK2 + RPBK3) as RPBK,RPBK1, RPBK2, RPBK3, NOREK";
            String mSql = null;
            mSql = mSql + " FROM TEMPDPHOFFLINE";
            mSql = mSql + " where TGLBAYAR = '" + tTglBayar + "'";
            mSql = mSql + " and KDPP = '" + tKdPP + "'";
            mSql = mSql + " and TRANSAKSIBY = '" + tTransaksiBy + "'" ;
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetData_21UPDATEANJA", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> Convert2SQL_DKRP(Object Value) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =   "Convert2SQL_DKRP";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("Convert2SQL_DKRP", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> Convert2SQL_DKRP(Object Value, Boolean UsedLongDate) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =   "Convert2SQL_DKRP";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("Convert2SQL_DKRP", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> rptVIEW_BA21_LUNASIANJA(String unitup, String tgltransaksi, String tglbayar, String kdpp, String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =   " SELECT ";
            sql = sql + " TGLCETAK, TGLTRANSAKSI, TGLBAYAR, KOGOL, LEMBAR, RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAKKELUAR, KDPEMBPP, STATUS, KDKIRIM, UNITUP, KODEPP, NAMAPP, ALAMATPP, TRANSAKSIBY, KODEGAGAL " ;
            sql = sql + " FROM";
            sql = sql + " VIEW_BAANJALUNASI_DAFTAR";
            sql += " WHERE ";
            sql += " flaganja = '1' " ;
            sql += " AND to_char(tgltransaksi,'yyyymmdd') = '" + tgltransaksi + "' ";
            sql += " AND to_char(TGLBAYAR,'yyyymmdd') = '" + tglbayar + "'  ";
            sql += " AND KODEPP = '" + kdpp + "' ";
            sql += " AND TRANSAKSIBY = '" + transaksiby + "' ";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("rptVIEW_BA21_LUNASIANJA", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }
    //---- ### END UPLOAD LUNAS REKENING ANJA ####################################################################################

}
