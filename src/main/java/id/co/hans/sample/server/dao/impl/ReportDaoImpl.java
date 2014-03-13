package id.co.hans.sample.server.dao.impl;

import id.co.hans.sample.server.utility.CommonModule;
import id.co.hans.sample.server.dao.ReportDao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.stereotype.Repository;

import com.inet.report.Engine;

import oracle.jdbc.OracleTypes;
import org.springframework.stereotype.Service;


@Service
public class ReportDaoImpl implements ReportDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void getLapRekapDimukaLPB(Engine engine, String unitupi, String unitap, String unitup, String jenislap, String thbl) {
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            String sql = "{call PKG_TMP_PRABAYAR.getLapRekapDimukaLPB(?,?,?,?,?,?)}";
            CallableStatement cst = con.prepareCall(sql);
            cst.setString(1, jenislap);
            cst.setString(2, unitupi);
            cst.setString(3, unitap);
            cst.setString(4, unitup);
            cst.setString(5, thbl);
            cst.registerOutParameter(6, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet) cst.getObject(6);
            engine.setData(rs);
            con.close();
        }catch (Exception ex){
            CommonModule.getLogger(this).info("Dao Error : "+ ex.getMessage());
        }
    }

    @Override
    public void getLapUnitPerThbl(Engine engine, String unitupi, String unitap, String unitup, String jenislap, String thbl) {
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            String sql = "{call PKG_LAPORAN.getlapbykriteria(?,?,?,?,?,?)}";
            CallableStatement cst = con.prepareCall(sql);
            cst.setString(1, jenislap);
            cst.setString(2, unitupi);
            cst.setString(3, unitap);
            cst.setString(4, unitup);
            cst.setString(5, thbl);
            cst.registerOutParameter(6, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet) cst.getObject(6);
            engine.setData(rs);
            con.close();
        }catch (Exception ex){
            CommonModule.getLogger(this).info("Dao Error : "+ ex.getMessage());
        }
    }

    @Override
    public void getLapSaldoBP(Engine engine, String unitupi, String unitap, String unitup, String thbl) {
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            String sql = "{call pkg_laporan_bp_nyalatahap.getLapSaldoBP(?,?,?,?,?)}";
            CallableStatement cst = con.prepareCall(sql);
            cst.setString(1, unitupi);
            cst.setString(2, unitap);
            cst.setString(3, unitup);
            cst.setString(4, thbl);
            cst.registerOutParameter(5, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet) cst.getObject(5);
            engine.setData(rs);
            con.close();
        }catch (Exception ex){
            CommonModule.getLogger(this).info("Dao Error : "+ ex.getMessage());
        }
    }

    @Override
    public void getInvoiceMultiTarifByIdpelThblrek(Engine engine, String idpel, String thblrek) {
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            String sql = "{? = call EMULSION.FUNC_RINCIAN_REK_MULTITARIF(?,?)}";
            CallableStatement cst = con.prepareCall(sql);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, idpel);
            cst.setString(3, thblrek);

            cst.execute();
            ResultSet rs = (ResultSet) cst.getObject(1);
            engine.setData(rs);
            con.close();
        }catch (Exception ex){
            CommonModule.getLogger(this).info("Dao Error : "+ ex.getMessage());
        }
    }

    @Override
    public void getMasterPlgMultiTarifByUnitThbl(Engine engine, String in_unitupi, String in_unitap, String in_unitup, String in_thblrek) {
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            String sql = "{call EMULSION.DML_MASTER_PLG_MULTITARIF.getLaporanMultiTarifByUnitThbl(?,?,?,?,?)}";
            CallableStatement cst = con.prepareCall(sql);
            cst.setString(1, in_unitupi);
            cst.setString(2, in_unitap);
            cst.setString(3, in_unitup);
            cst.setString(4, in_thblrek);
            cst.registerOutParameter(5, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet) cst.getObject(5);
            engine.setData(rs);
            con.close();
        }catch (Exception ex){
            CommonModule.getLogger(this).info("Dao Error : "+ ex.getMessage());
        }
    }


    //11
    @Override
    public void GetReport_11rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                  String kode, String tparAP, String in_unitupi) {
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql = "";

            sql = "{call PARAMETERVIEW.SetBlTh(?)}";
            cst = con.prepareCall(sql);
            cst.setString("BLTH", tBLTH);
            cst.execute();

            sql = "{call PARAMETERVIEW.SetUnitUP(?)}";
            cst = con.prepareCall(sql);
            cst.setString("unitup", tparUp);
            cst.execute();

            if (vJenis.toUpperCase() == "11REKAP_TARIPDAYA" ) {
                if ( tparAP.toString().toUpperCase() != "SEMUA" ) {
                    sql = "SELECT ' ' AS NOMOR, TGLCETAK,";
                    sql = sql + "   UNITUP, BLTH, KDKELOMPOK, TGLJTTEMPO, TARIP,DAYA, LEMBAR, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH";
                    sql = sql + " FROM VIEW_REPORT_11_TARIPDAYA";
                    sql = sql + " WHERE ";
                    sql = sql + "  BLTH  = '" + tBLTH + "'";
                    if ( kode.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND KDKELOMPOK  = '" + kode + "'";
                    }
                    sql = sql + " AND UNITAP  = RTRIM(LTRIM('" + tparAP + "'))";
                    if ( tparUp.toString().toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                    }
                    sql = sql + " order by TARIP ASC,DAYA asc";
                } else {
                    sql = "SELECT ' ' AS NOMOR, TGLCETAK,";
                    sql = sql + "   UNITAP, BLTH, KDKELOMPOK, TGLJTTEMPO, TARIP,DAYA, LEMBAR, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH";
                    sql = sql + " FROM VIEW_REPORT_11_TARIPDAYA_PERAP";
                    sql = sql + " WHERE ";
                    sql = sql + "  BLTH  = '" + tBLTH + "'";
                    if ( kode.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND KDKELOMPOK  = '" + kode + "'";
                    }
                    sql = sql + " AND SUBSTR(UNITAP, 1, 2) = RTRIM(LTRIM('" + in_unitupi + "'))";
                    sql = sql + " order by TARIP ASC,DAYA asc";
                }
            } else if ( vJenis.toUpperCase() == "11REKAP_GOL" ) {
                if ( tparAP.toUpperCase() != "SEMUA" ) {
                    sql = "SELECT ' ' AS NOMOR, TGLCETAK,";
                    sql = sql + "   UNITUP, BLTH, KDKELOMPOK, TGLJTTEMPO, KOGOL, LEMBAR, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH";
                    sql = sql + " FROM VIEW_REPORT_11_GOL";
                    sql = sql + " WHERE ";
                    sql = sql + "  BLTH  = '" + tBLTH + "'";
                    if ( kode.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND KDKELOMPOK  = '" + kode + "'";
                    }
                    sql = sql + " AND UNITAP  = RTRIM(LTRIM('" + tparAP + "'))";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                    }
                    sql = sql + " order by KOGOL asc";
                } else {
                    sql = "SELECT ' ' AS NOMOR, TGLCETAK,";
                    sql = sql + "   UNITAP as UNITUP, BLTH, KDKELOMPOK, TGLJTTEMPO, KOGOL, LEMBAR, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH";
                    sql = sql + " FROM VIEW_REPORT_11_GOL_PERAP";
                    sql = sql + " WHERE ";
                    sql = sql + "  BLTH  = '" + tBLTH + "'";
                    if ( kode.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND KDKELOMPOK  = '" + kode + "'";
                    }
                    sql = sql + " AND SUBSTR(UNITAP, 1, 2) = RTRIM(LTRIM('" + in_unitupi + "'))";
                    sql = sql + " order by KOGOL asc";
                }
            } else if ( vJenis.toUpperCase() == "11REKAP_INKASO" ) {
                if ( tparAP.toUpperCase() != "SEMUA" ) {
                    sql = "SELECT ' ' AS NOMOR, TGLCETAK,";
                    sql = sql + "   UNITUP, BLTH, KDKELOMPOK, TGLJTTEMPO, ";
                    sql = sql + "   KDINKASO,KOGOL, LEMBAR, KWHLWBP, KWHWBP, BLOK3, ";
                    sql = sql + " PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, ";
                    sql = sql + " RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, ";
                    sql = sql + " RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, ";
                    sql = sql + " RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH";
                    sql = sql + " FROM VIEW_REPORT_11_INKASO";
                    sql = sql + " WHERE ";
                    sql = sql + "  BLTH  = '" + tBLTH + "'";
                    if ( kode.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND KDKELOMPOK  = '" + kode + "'";
                    }
                    sql = sql + " AND UNITAP  = RTRIM(LTRIM('" + tparAP + "'))";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                    }
                    sql = sql + " order by KDINKASO ASC, KOGOL asc";
                } else {
                    sql = "SELECT ' ' AS NOMOR, TGLCETAK,";
                    sql = sql + "   UNITUP, BLTH, KDKELOMPOK, TGLJTTEMPO, ";
                    sql = sql + "   KDINKASO,KOGOL, LEMBAR, KWHLWBP, KWHWBP, BLOK3, ";
                    sql = sql + " PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, ";
                    sql = sql + " RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, ";
                    sql = sql + " RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, ";
                    sql = sql + " RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH";
                    sql = sql + " FROM VIEW_REPORT_11_INKASO_PERAP";
                    sql = sql + " WHERE ";
                    sql = sql + "  BLTH  = '" + tBLTH + "'";
                    if ( kode.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND KDKELOMPOK  = '" + kode + "'";
                    }
                    sql = sql + " AND SUBSTR(UNITAP, 1, 2) = RTRIM(LTRIM('" + in_unitupi + "'))";
                    sql = sql + " order by KDINKASO ASC, KOGOL asc";
                }
            //---tambahan BK
            } else if ( vJenis.toUpperCase() == "11BKREKAP_TARIP" ) {
                sql = "SELECT ' ' AS NOMOR, TGLCETAK,";
                sql = sql + "   UNITUP, KODETRANSAKSI, BLTH, KDKELOMPOK, TGLTRANSAKSI TGLJTTEMPO,  KOGOL, LBR_BK AS LEMBAR, '' AS KWHLWBP, '' KWHWBP, '' BLOK3, '' PEMKWH, '' KWHKVARH, '' KELBKVARH, '' RPLWBP, '' RPWBP, '' RPBLOK3, '' RPKVARH, '' RPBEBAN, '' RPTTLB, '' RPPTL, '' RPTB, '' RPPPN, '' RPBPJU, '' RPTRAFO, '' RPSEWATRAFO, '' RPSEWAKAP, LBR_BK1 AS RPANGSA, LBR_BK2 AS RPANGSB, LBR_BK3 AS RPANGSC, '' RPMAT, '' RPPLN, RP_BK AS RPTAG, '' RPPRODUKSI, '' RPSUBSIDI, '' RPREDUKSI, '' RPINSENTIF, '' RPDISINSENTIF, RP_BK1 AS RPBK1, RP_BK2 AS RPBK2, RP_BK3 AS RPBK3,  '' RPTDLLAMA, '' RPTDLBARU, '' RPSELISIH";
                sql = sql + " FROM VIEW_REPORT_11BK_TARIP";
                sql = sql + " WHERE ";
                //sql = sql + " BLTH  = '" + tBLTH + "'";
                sql = sql + "  TGLTRANSAKSI  >= '" + tBLTH + "01" + "'";
                sql = sql + " AND TGLTRANSAKSI  <= '" + tBLTH + "31" + "'";
                if ( tparUp.toUpperCase() != "SEMUA" ) {
                    sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                }
                //if ( kode.toUpperCase() != "SEMUA" ) {
                //    sql = sql + " AND KDKELOMPOK  = '" + kode + "'"
                //}
            } else if ( vJenis.toUpperCase() == "11BKREKAP_GOL" ) {
                sql = "SELECT ' ' AS NOMOR, TGLCETAK,";
                sql = sql + "   UNITUP, KODETRANSAKSI, BLTH, KDKELOMPOK, TGLTRANSAKSI TGLJTTEMPO,  KOGOL, LBR_BK AS LEMBAR, '' AS KWHLWBP, '' KWHWBP, '' BLOK3, '' PEMKWH, '' KWHKVARH, '' KELBKVARH, '' RPLWBP, '' RPWBP, '' RPBLOK3, '' RPKVARH, '' RPBEBAN, '' RPTTLB, '' RPPTL, '' RPTB, '' RPPPN, '' RPBPJU, '' RPTRAFO, '' RPSEWATRAFO, '' RPSEWAKAP, LBR_BK1 AS RPANGSA, LBR_BK2 AS RPANGSB, LBR_BK3 AS RPANGSC, '' RPMAT, '' RPPLN, RP_BK AS RPTAG, '' RPPRODUKSI, '' RPSUBSIDI, '' RPREDUKSI, '' RPINSENTIF, '' RPDISINSENTIF, RP_BK1 AS RPBK1, RP_BK2 AS RPBK2, RP_BK3 AS RPBK3,  '' RPTDLLAMA, '' RPTDLBARU, '' RPSELISIH";
                sql = sql + " FROM VIEW_REPORT_11BK_GOL";
                sql = sql + " WHERE ";
                //sql = sql + " BLTH  = '" + tBLTH + "'"
                sql = sql + "  TGLTRANSAKSI  >= '" + tBLTH + "01" + "'";
                sql = sql + " AND TGLTRANSAKSI  <= '" + tBLTH + "31" + "'";
                if ( tparUp.toUpperCase() != "SEMUA" ) {
                    sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                }
                //if ( kode.toUpperCase() != "SEMUA" ) {
                //    sql = sql + " AND KDKELOMPOK  = '" + kode + "'"
                //}
            }

            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();

            engine.setData(rs);
            con.close();
        }catch (Exception ex){
            CommonModule.getLogger(this).info("Dao Error : "+ ex.getMessage());
        }
    }

    @Override
    public void cetak_rekap11TglUpload(Engine engine, String tparUp, String tglAwal, String tglAkhir) {
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "";

            sql = " select tgltransaksi uploadtime,kogol unitap,lembar,rpptl,rpbpju,rpppn,rpmat, ";
            sql += " (rptb+rptrafo+rpsewatrafo+rpsewakap+rpangsa+rpangsb+rpangsc+rpreduksi) rpangsa, ";
            sql += " rptag,(rpbk1+rpbk2+rpbk3) rpbk1 ";
            sql += " from (SELECT    db.unitup, db.blth,db.kogol, ";
            sql += " COUNT (db.idpel) AS lembar, ";
            sql += " SUM (db.kwhlwbp) AS kwhlwbp, SUM (db.kwhwbp) AS kwhwbp, ";
            sql += " SUM (db.blok3) AS blok3, SUM (db.pemkwh) AS pemkwh, ";
            sql += " SUM (db.kwhkvarh) AS kwhkvarh, SUM (db.kelbkvarh) AS kelbkvarh, ";
            sql += " SUM (db.rplwbp) AS rplwbp, SUM (db.rpwbp) AS rpwbp, ";
            sql += " SUM (db.rpblok3) AS rpblok3, SUM (db.rpkvarh) AS rpkvarh, ";
            sql += " SUM (db.rpbeban) AS rpbeban, NVL (SUM (db.rpttlb), 0) AS rpttlb, ";
            sql += " SUM (db.rpptl) AS rpptl, NVL (SUM (db.rptb), 0) AS rptb, ";
            sql += " SUM (db.rpppn) AS rpppn, SUM (db.rpbpju) AS rpbpju, ";
            sql += " NVL (SUM (db.rptrafo), 0) AS rptrafo, ";
            sql += " NVL (SUM (db.rpsewatrafo), 0) AS rpsewatrafo,  ";
            sql += " NVL (SUM (db.rpsewakap), 0) AS rpsewakap, ";
            sql += " NVL (SUM (db.rpangsa), 0) AS rpangsa, ";
            sql += " NVL (SUM (db.rpangsb), 0) AS rpangsb, ";
            sql += " NVL (SUM (db.rpangsc), 0) AS rpangsc, SUM (db.rpmat) AS rpmat, ";
            sql += " SUM (db.rppln) AS rppln, SUM (db.rptag) AS rptag, ";
            sql += " NVL (SUM (db.rpproduksi), 0) AS rpproduksi, ";
            sql += " NVL (SUM (db.rpsubsidi), 0) AS rpsubsidi, ";
            sql += " SUM (db.rpreduksi) AS rpreduksi, SUM (db.rpinsentif) AS rpinsentif, ";
            sql += " SUM (db.rpdisinsentif) AS rpdisinsentif, ";
            sql += " 0 AS rpbk1, 0 AS rpbk2, 0 AS rpbk3,  ";
            sql += " SUM (db.rptdllama) AS rptdllama, SUM (db.rptdlbaru) AS rptdlbaru, ";
            sql += " SUM (db.rpselisih) AS rpselisih, ";
            sql += " (SELECT unitap ";
            sql += " FROM unitup UP ";
            sql += " WHERE UP.unitup = db.unitup) AS unitap,trunc(tgltransaksi) tgltransaksi ";
            sql += " FROM sorekbaru db ";
            sql += " WHERE db.tglbataltrans IS NULL AND db.kdgerakmasuk = '11'";
            sql += " and db.unitup = '" + tparUp + "' ";
            sql += " and tgltransaksi between to_date('" + tglAwal + "','MMddyyyy') and to_date('" + tglAkhir + "','MMddyyyy')+1 ";
            sql += " GROUP BY db.unitup, db.blth,trunc(tgltransaksi),kogol ";
            sql += " ) order by tgltransaksi";

            CallableStatement cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();

            engine.setData(rs);
            con.close();
        }catch (Exception ex){
            CommonModule.getLogger(this).info("Dao Error : "+ ex.getMessage());
        }
    }

    //12
    @Override
    public void GetReport_12rekapGabungan(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                  String kode, String tparAP, String in_unitupi) {
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql = "";

            if ( vJenis.toUpperCase() == "12REKAP502SEBELUM" ) {
                sql = "SELECT ' ' AS NOMOR, TGLCETAK, TANGGAL, KOGOL,";
                sql = sql + "   SUM(LEMBAR) AS LEMBAR,SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
                sql = sql + "   KDGERAK,KDPEMBPP,STATUS, UNITUP";
                sql = sql + " FROM VIEW_REPORT_12DLAMA502";
                sql = sql + " WHERE ";
                sql = sql + "  TANGGAL  >= '" + tBLTH + "01" + "'";
                sql = sql + " AND TANGGAL  <= '" + tBLTH + "31" + "'";
                if ( tparAP.toUpperCase() != "SEMUA" ) {
                    sql = sql + " AND UNITAP  = RTRIM(LTRIM('" + tparAP + "'))";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                    }
                }
                sql = sql + " AND SUBSTR(UNITAP, 1, 2) = RTRIM(LTRIM('" + in_unitupi + "'))";
                sql = sql + " Group by TGLCETAK, TANGGAL, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP";
                sql = sql + " order by TANGGAL asc";
            } else if ( vJenis.toUpperCase() == "12REKAP502SESUDAH" ) {
                sql = "SELECT ' ' AS NOMOR, TGLCETAK, TANGGAL, KOGOL,";
                sql = sql + "   SUM(LEMBAR) AS LEMBAR,SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
                sql = sql + "   KDGERAK,KDPEMBPP,STATUS, UNITUP";
                sql = sql + " FROM VIEW_REPORT_12DBARU502";
                sql = sql + " WHERE ";
                sql = sql + "  TANGGAL  >= '" + tBLTH + "01" + "'";
                sql = sql + " AND TANGGAL  <= '" + tBLTH + "31" + "'";
                if ( tparAP.toUpperCase() != "SEMUA" ) {
                    sql = sql + " AND UNITAP  = RTRIM(LTRIM('" + tparAP + "'))";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                    }
                }
                sql = sql + " AND SUBSTR(UNITAP, 1, 2) = RTRIM(LTRIM('" + in_unitupi + "'))";
                sql = sql + " Group by TGLCETAK, TANGGAL, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP";
                sql = sql + " order by TANGGAL asc";
            } else if ( vJenis.toUpperCase() == "12REKAP404SEBELUM" ) {
                sql = "SELECT ' ' AS NOMOR, TGLCETAK, TANGGAL,JALANTUNGGAK, KOGOL,";
                sql = sql + "   SUM(LEMBAR) AS LEMBAR,SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
                sql = sql + "   KDGERAK,KDPEMBPP,STATUS, UNITUP";
                sql = sql + " FROM VIEW_REPORT_12DLAMA404";
                sql = sql + " WHERE ";
                sql = sql + "  TANGGAL  >= '" + tBLTH + "01" + "'";
                sql = sql + " AND TANGGAL  <= '" + tBLTH + "31" + "'";
                if ( tparAP.toUpperCase() != "SEMUA" ) {
                    sql = sql + " AND UNITAP  = RTRIM(LTRIM('" + tparAP + "'))";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                    }
                }
                sql = sql + " AND SUBSTR(UNITAP, 1, 2) = RTRIM(LTRIM('" + in_unitupi + "'))";
                sql = sql + " Group by TGLCETAK, TANGGAL, JALANTUNGGAK,KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP";
                sql = sql + " order by TANGGAL asc";
            } else if ( vJenis.toUpperCase() == "12REKAP404SESUDAH" ) {
                sql = "SELECT ' ' AS NOMOR, TGLCETAK, TANGGAL,JALANTUNGGAK, KOGOL,";
                sql = sql + "   SUM(LEMBAR) AS LEMBAR,SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
                sql = sql + "   KDGERAK,KDPEMBPP,STATUS, UNITUP";
                sql = sql + " FROM VIEW_REPORT_12DBARU404";
                sql = sql + " WHERE ";
                sql = sql + "  TANGGAL  >= '" + tBLTH + "01" + "'";
                sql = sql + " AND TANGGAL  <= '" + tBLTH + "31" + "'";
                if ( tparAP.toUpperCase() != "SEMUA" ) {
                    sql = sql + " AND UNITAP  = RTRIM(LTRIM('" + tparAP + "'))";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                    }
                }
                sql = sql + " AND SUBSTR(UNITAP, 1, 2) = RTRIM(LTRIM('" + in_unitupi + "'))";
                sql = sql + " Group by TGLCETAK, TANGGAL, JALANTUNGGAK,KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP";
                sql = sql + " order by TANGGAL asc";
            } else if ( vJenis.toUpperCase() == "12DAFTARREKG306" ) {
                sql = "SELECT ' ' AS NOMOR, TGLCETAK, ";
                sql = sql + "  BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLBATALTRANS, TRANSAKSIIDBATAL, TGLTRANSAKSI, TRANSAKSIID, TRANSAKSIBY, TRANSAKSIBATALBY, KOREKSIBY,";
                sql = sql + "  BLTH_L, IDPEL_L, NOPEL_L, KDGERAKMASUK_L, UPLOADTIME_L, UPLOADBY_L, KDGERAKKELUAR_L, TGLBAYAR_L, WKTBAYAR_L, KDPP_L, KDPEMBAYAR_L, KDKOREKSI_L, TGKOREKSI_L, STATUS_L, KDPEMBPP_L, KDPEMBAYARSIP3_L, UNITUP_L, PEMDA_L, NAMA_L, PNJ_L, NAMAPNJ_L, NOBANG_L, KETNOBANG_L, RT_L, RW_L, NODLMRT_L, KETNODLMRT_L, LINGKUNGAN_L, KODEPOS_L, IDTARIP_L, TARIP_L, KDPEMBTRF_L, ABONMETER_L, DAYA_L, KDAYA_L, KOGOL_L, SUBKOGOL_L, FRT_L, FJN_L, KDPPJ_L, UNITKJ_L, KDINKASO_L, KDKELOMPOK_L, TGLJTTEMPO_L, KDDK_L, TGLBACA_L, SLALWBP_L, SAHLWBP_L, SLAWBP_L, SAHWBP_L, SLAKVARH_L, SAHKVARH_L, SKVAMAX_L, FAKM_L, FAKMKVARH_L, FAKMKVAMAX_L, KWHLWBP_L, KWHWBP_L, BLOK3_L, PEMKWH_L, KWHKVARH_L, KELBKVARH_L, RPLWBP_L, RPWBP_L, RPBLOK3_L, RPKVARH_L, RPBEBAN_L, CTTLB_L, RPTTLB_L, RPPTL_L, RPTB_L, RPPPN_L, RPBPJU_L, RPTRAFO_L, RPSEWATRAFO_L, RPSEWAKAP_L, KDANGSA_L, RPANGSA_L, KDANGSB_L, RPANGSB_L, KDANGSC_L, RPANGSC_L, RPMAT_L, RPPLN_L, RPTAG_L, RPPRODUKSI_L, RPSUBSIDI_L, RPREDUKSI_L, RPINSENTIF_L, RPDISINSENTIF_L, RPBK1_L, RPBK2_L, RPBK3_L, RPTDLLAMA_L, RPTDLBARU_L, RPSELISIH_L, NOREK_L, NOAGENDA_L, FLAGSOPP_L, FLAGANJA_L, KDKIRIM_L, KDTERIMA_L, TGLBATALTRANS_L, TRANSAKSIIDBATAL_L, TGLTRANSAKSI_L, TRANSAKSIID_L";
                sql = sql + " FROM VIEW_REPORT_12DAFTARREKG";
                sql = sql + " WHERE ";
                sql = sql + "  TGKOREKSI  >= '" + tBLTH + "01" + "'";
                sql = sql + " AND TGKOREKSI  <= '" + tBLTH + "31" + "'";
                if ( tparAP.toUpperCase() != "SEMUA" ) {
                    sql = sql + " AND UNITAP  = RTRIM(LTRIM('" + tparAP + "'))";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                    }
                }
                sql = sql + " AND SUBSTR(UNITAP, 1, 2) = RTRIM(LTRIM('" + in_unitupi + "'))";
                sql = sql + " order by TGKOREKSI asc,KDKOREKSI ASC ";
            } else if ( vJenis.toUpperCase() == "12KOREKSIPERTARIPSEBELUM" ) {
                sql = "SELECT ' ' AS NOMOR, TGLCETAK, ";
                sql = sql + " TGKOREKSI, STATUS, KDPEMBPP, UNITUP, TARIP, DAYA,  ";
                sql = sql + " LEMBAR, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH ";
                sql = sql + " FROM VIEW_REPORT_12DLAMATARIP";
                sql = sql + " WHERE ";
                sql = sql + "  TGKOREKSI  = '" + tBLTH + "'";
                if ( tparAP.toUpperCase() != "SEMUA" ) {
                    sql = sql + " AND UNITAP  = RTRIM(LTRIM('" + tparAP + "'))";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                    }
                }
                sql = sql + " AND SUBSTR(UNITAP, 1, 2) = RTRIM(LTRIM('" + in_unitupi + "'))";
                sql = sql + " order by TARIP asc,DAYA ASC ";
            } else if ( vJenis.toUpperCase() == "12KOREKSIPERTARIPSESUDAH" ) {
                sql = "SELECT ' ' AS NOMOR, TGLCETAK, ";
                sql = sql + " TGKOREKSI, STATUS, KDPEMBPP, UNITUP, TARIP, DAYA,  ";
                sql = sql + " LEMBAR, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH ";
                sql = sql + " FROM VIEW_REPORT_12DBARUTARIP";
                sql = sql + " WHERE ";
                sql = sql + "  TGKOREKSI  = '" + tBLTH + "'";
                if ( tparAP.toUpperCase() != "SEMUA" ) {
                    sql = sql + " AND UNITAP  = RTRIM(LTRIM('" + tparAP + "'))";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                    }
                }
                sql = sql + " AND SUBSTR(UNITAP, 1, 2) = RTRIM(LTRIM('" + in_unitupi + "'))";
                sql = sql + " order by TARIP asc,DAYA ASC ";
            } else if ( vJenis.toUpperCase() == "12REKAPKOREKSIREKENING" ) {
                sql = "SELECT * FROM VIEW_REPORT_12REKAPKOREKSINEW";
                sql = sql + "  WHERE TO_CHAR(TGKOREKSI,'YYYYMMDD')  BETWEEN '" + tBLTH + "01" + "'";
                sql = sql + " AND  '" + tBLTH + "31" + "'";
                if ( tparAP.toUpperCase() != "SEMUA" ) {
                    sql = sql + " AND UNITAP  = RTRIM(LTRIM('" + tparAP + "'))";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                    }
                }
                sql = sql + " AND SUBSTR(UNITAP, 1, 2) = RTRIM(LTRIM('" + in_unitupi + "'))";
                sql = sql + " ORDER BY IDPEL,BLTH ";
                //add by Andrie by CRF
            } else if ( vJenis.toUpperCase() == "12REKAPKOREKSIREKENINGNEW" ) {
                sql = "SELECT * FROM VIEW_REPORT_12REKAPNEW_KOREKSI";
                sql = sql + " WHERE ";
                sql = sql + "  TGKOREKSI  >= '" + tBLTH + "01" + "'";
                sql = sql + " AND TGKOREKSI  <= '" + tBLTH + "31" + "'";
                if ( tparAP.toUpperCase() != "SEMUA" ) {
                    sql = sql + " AND UNITAP  = RTRIM(LTRIM('" + tparAP + "'))";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                    }
                }
                sql = sql + " AND SUBSTR(UNITAP, 1, 2) = RTRIM(LTRIM('" + in_unitupi + "'))";
                sql = sql + " ORDER BY BLTHREK, KDKOREKSI, KOGOL";

            } else if ( vJenis.toUpperCase() == "12KOREKSIPERKODEKOREKSI" ) {
                sql = "SELECT LEMBAR, BLTHREK, KDKOREKSI, UNITUP, TOTAL_PEMKWH, TOTAL_RPTAG, TOTAL_PEMKWH_L, TOTAL_RPTAG_L, UNITAP ";
                sql = sql + " FROM  VIEW_REPORT_12REKAPNEW_KOREKSI";
                sql = sql + " WHERE ";
                sql = sql + "  TGKOREKSI  >= '" + tBLTH + "01" + "'";
                sql = sql + " AND TGKOREKSI  <= '" + tBLTH + "31" + "'";
                if ( tparAP.toUpperCase() != "SEMUA" ) {
                    sql = sql + " AND UNITAP  = RTRIM(LTRIM('" + tparAP + "'))";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                    }
                }
                sql = sql + " AND SUBSTR(UNITAP, 1, 2) = RTRIM(LTRIM('" + in_unitupi + "'))";
                sql = sql + " GROUP BY LEMBAR, BLTHREK, KDKOREKSI, UNITUP, TOTAL_PEMKWH, TOTAL_RPTAG, TOTAL_PEMKWH_L, TOTAL_RPTAG_L, UNITAP ";
                //End Andrie
            }

            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();

            engine.setData(rs);
            con.close();
        }catch (Exception ex){
            CommonModule.getLogger(this).info("Dao Error : "+ ex.getMessage());
        }
    }


    //13
    @Override
    public void GetReport_13rekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp,
                                  String tPetugas) {
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql = "";

            if ( vJenis.toUpperCase() == "13REKAP502" ) {
                sql = "SELECT ' ' AS NOMOR, TGLCETAK, TANGGAL, KOGOL,";
                sql = sql + "   SUM(LEMBAR) AS LEMBAR,SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
                sql = sql + "   KDGERAK,KDPEMBPP,STATUS, UNITUP";
                sql = sql + " FROM VIEW_REPORT_13REKAP502";
                sql = sql + " WHERE ";
                sql = sql + "  TANGGAL  >= '" + tBLTH + "01" + "'";
                sql = sql + " AND TANGGAL  <= '" + tBLTH + "31" + "'";
                //sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                if ( tparAp.toUpperCase() != "SEMUA" ) {
                    sql = sql + " AND UNITAP  = RTRIM(LTRIM('" + tparAp + "'))";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                    }
                }
                sql = sql + " Group by TGLCETAK, TANGGAL, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP";
                sql = sql + " order by TANGGAL asc";
            } else if ( vJenis.toUpperCase() == "13REKAP404" ) {
                sql = "SELECT ' ' AS NOMOR, TGLCETAK, TANGGAL,JALANTUNGGAK, KOGOL,";
                sql = sql + "   SUM(LEMBAR) AS LEMBAR,SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
                sql = sql + "   KDGERAK,KDPEMBPP,STATUS, UNITUP";
                sql = sql + " FROM VIEW_REPORT_13REKAP404";
                sql = sql + " WHERE ";
                sql = sql + "  TANGGAL  >= '" + tBLTH + "01" + "'";
                sql = sql + " AND TANGGAL  <= '" + tBLTH + "31" + "'";
                //sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                if ( tparAp.toUpperCase() != "SEMUA" ) {
                    sql = sql + " AND UNITAP  = RTRIM(LTRIM('" + tparAp + "'))";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                    }
                }
                sql = sql + " Group by TGLCETAK, TANGGAL, JALANTUNGGAK,KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP";
                sql = sql + " order by TANGGAL asc";
            } else if ( vJenis.toUpperCase() == "13DAFTARREKG" ) {
                sql = "SELECT ' ' AS NOMOR, TGLCETAK, TANGGAL, BLTH, IDPEL, NOPEL, ";
                sql = sql + "   KDGERAKMASUK, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, JNSMUT, BLTHMUT, KDMUT, TGLNYALA, NOGARDU, NOTIANG, NOMETER, DAYABULK, RPBP, RPUJL, TGLBATALTRANS, TRANSAKSIIDBATAL, TGLTRANSAKSI, TRANSAKSIID, UPLOADBY, UPLOADTIME, TRANSAKSIBY, TRANSAKSIBATALBY";
                sql = sql + " FROM VIEW_REPORT_13DAFTARREKG";
                sql = sql + " WHERE ";
                sql = sql + "  TANGGAL  >= '" + tBLTH + "01" + "'";
                sql = sql + " AND TANGGAL  <= '" + tBLTH + "31" + "'";
                //sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                if ( tparAp.toUpperCase() != "SEMUA" ) {
                    sql = sql + " AND UNITAP  = RTRIM(LTRIM('" + tparAp + "'))";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND UNITUP  = RTRIM(LTRIM('" + tparUp + "'))";
                    }
                }
                sql = sql + " order by TANGGAL asc";
            }

            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();

            engine.setData(rs);
            con.close();
        }catch (Exception ex){
            CommonModule.getLogger(this).info("Dao Error : "+ ex.getMessage());
        }
    }


    //21
    @Override
    public void GetReport_21_BA(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                String tanggal, String tanggalend, String kode, String pengelola) {
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            ResultSet rs = null;
            String sql = "";

            if ( tparUp.substring(0, 2) == "52" ) {
                sql = "{call PARAMETERVIEW.SetTGLBAYAR(?)}";
                cst = con.prepareCall(sql);
                cst.setString("TGLBAYAR", tBLTH + tanggal);
                cst.execute();

                sql = "{call PARAMETERVIEW.SetUnitUP(?)}";
                cst = con.prepareCall(sql);
                cst.setString("unitup", tparUp);
                cst.execute();

                sql = "{call PARAMETERVIEW.SetTGLSTART(?)}";
                cst = con.prepareCall(sql);
                cst.setString("tglend", tBLTH + tanggal);
                cst.execute();

                sql = "{call PARAMETERVIEW.SetTGLEND(?)}";
                cst = con.prepareCall(sql);
                cst.setString("unitup", tBLTH + tanggalend);
                cst.execute();

                if ( vJenis.toUpperCase() == "21BA" ) {
                    String partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
                    if ( pengelola.toUpperCase() != "SEMUA" && pengelola.trim() != "" ) {
                        sql = " SELECT * ";
                        sql = sql + " FROM VIEW_REPORT_21_BA_OFFLINE ";
                        sql = sql + "   WHERE  ";
                        sql = sql + "   PENGELOLA  = RTRIM(LTRIM('" + pengelola + " ')) ";
                    } else {
                        sql = " SELECT  TGLLUNAS, TGLBAYAR, KOGOL,  ";
                        sql = sql + "       SUM(LBR_LCR) AS LBR_LCR ,  ";
                        sql = sql + "       SUM(LBR_TGK) AS LBR_TGK,  ";
                        sql = sql + "       SUM(LBR_ROAMING) AS LBR_ROAMING,  ";
                        sql = sql + "       SUM(LBR_DIROAMING) AS LBR_DIROAMING,  ";
                        sql = sql + "       SUM(RP_LCR) AS RP_LCR,  ";
                        sql = sql + "       SUM(RP_TGK) AS RP_TGK,  ";
                        sql = sql + "       SUM(RP_ROAMING) AS RP_ROAMING,  ";
                        sql = sql + "       SUM(RP_DIROAMING) AS RP_DIROAMING ";
                        sql = sql + "FROM VIEW_REPORT_21_BA_OFFLINE ";
                        sql = sql + "GROUP BY TGLLUNAS, TGLBAYAR, KOGOL ";
                    }

                    cst = con.prepareCall(sql);
                    rs = cst.executeQuery();
                } else if ( vJenis.toUpperCase() == "21REKAPLUNASOFFLINE" ) {
                    String partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
                    if ( pengelola.toUpperCase() != "SEMUA" && pengelola.trim() != "" ) {
                        sql = " SELECT * ";
                        sql += " FROM VIEW_REPORT21_REKAPTOTLNS ";
                        sql += "   WHERE PENGELOLA  = RTRIM(LTRIM('" + pengelola + " ')) ";
                        sql += " ORDER BY NOMOR,KOGOL,TGLLUNAS";
                    } else {
                        sql = " SELECT JNSLUNAS, TGLLUNAS, KOGOL, TGLBAYAR, NOMOR,  ";
                        sql = sql + "      SUM(LEMBAR) AS LEMBAR,  ";
                        sql = sql + "      SUM(RPMAT) AS RPMAT,  ";
                        sql = sql + "      SUM(RPPPJ) AS RPPPJ,  ";
                        sql = sql + "      SUM(RPPPN) AS RPPPN,  ";
                        sql = sql + "      SUM(RPANG) AS RPANG,  ";
                        sql = sql + "      SUM(RPSEWAKAPTRF) AS RPSEWAKAPTRF,  ";
                        sql = sql + "      SUM(RPBK) AS RPBK,  ";
                        sql = sql + "      SUM(RPPTL) AS RPPTL,  ";
                        sql = sql + "      SUM(RPTAG) AS RPTAG ";
                        sql = sql + "FROM VIEW_REPORT21_REKAPTOTLNS ";
                        sql = sql + "GROUP BY JNSLUNAS, TGLLUNAS, KOGOL, TGLBAYAR, NOMOR ";
                        sql = sql + " ORDER BY NOMOR,KOGOL,TGLLUNAS";
                    }

                    cst = con.prepareCall(sql);
                    rs = cst.executeQuery();
                }
            } else {
                if ( vJenis.toUpperCase() == "21BA" ) {
                    sql = "{ call SELECT_BA_21OFFLINE.GetReport_21BA(?,?,?,?) }";
                    cst = con.prepareCall(sql);
                    cst.setString("v_Tglbayar", tBLTH + tanggal);
                    cst.setString("v_unitup", tparUp);
                    cst.setString("v_Pengelola", pengelola);
                    cst.registerOutParameter("cur_Result", OracleTypes.CURSOR);
                    cst.execute();

                    rs = (ResultSet) cst.getObject("cur_Result");
                } else if ( vJenis.toUpperCase() == "21REKAPLUNASOFFLINE" ) {
                    sql = "{ call SELECT_BA_21OFFLINE.GetReport_21BA_Rekap(?,?,?,?,?) }";
                    cst = con.prepareCall(sql);
                    cst.setString("v_TglStart", tBLTH + tanggal);
                    cst.setString("v_TglEnd", tparUp);
                    cst.setString("v_unitup", tparUp);
                    cst.setString("v_Pengelola", pengelola);
                    cst.registerOutParameter("cur_Result", OracleTypes.CURSOR);
                    cst.execute();

                    rs = (ResultSet) cst.getObject("cur_Result");
                }
            }

            engine.setData(rs);
            con.close();
        }catch (Exception ex){
            CommonModule.getLogger(this).info("Dao Error : "+ ex.getMessage());
        }
    }

    @Override
    public void GetReport_21kdpp(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                String tanggal, String tanggalend, String kode) {
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            ResultSet rs = null;
            String sql = "";

            sql = "{call PARAMETERVIEW.SetTGLSTART(?)}";
            cst = con.prepareCall(sql);
            cst.setString("tglstrt", tBLTH + "01");
            cst.execute();

            sql = "{call PARAMETERVIEW.SetTGLEND(?)}";
            cst = con.prepareCall(sql);
            cst.setString("tglend", tBLTH + tanggalend);
            cst.execute();

            sql = "{call PARAMETERVIEW.SetKODEPP(?)}";
            cst = con.prepareCall(sql);
            cst.setString("KDPP", kode);
            cst.execute();


            if ( tparUp.substring(0, 2) == "51" || tparUp.substring(0, 2) == "23" ) {
                sql = "select * from B$_RPT_21KDPP_PPTGLREKAP";
            } else {
                if ( vJenis.toUpperCase() == "21KDPP_PPTGLREKAP" ) {
                    sql = "SELECT TGLCETAK, TANGGAL, SUM(LEMBAR) AS LEMBAR, ";
                    sql = sql + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
                    sql = sql + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
                    sql = sql + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
                    sql = sql + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
                    sql = sql + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
                    sql = sql + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
                    sql = sql + " KDGERAK,KDPEMBPP,STATUS, KDPP ";
                    sql = sql + " FROM VIEW_REPORT_21KDPP";
                    sql = sql + " WHERE ";
                    sql = sql + "  TANGGAL  >= '" + tBLTH + tanggal + "'";
                    sql = sql + " AND TANGGAL  <= '" + tBLTH + tanggalend + "'";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND KDPP  = '" + kode + "'";
                    }
                    sql = sql + " Group by TGLCETAK, TANGGAL, KDGERAK,KDPEMBPP,STATUS, KDPP ";
                    sql = sql + " order by KDPP asc,TANGGAL asc";
                } else if ( vJenis.toUpperCase() == "21KDPP_PPTGLREKAPGOL" ) {
                    sql = "SELECT TGLCETAK, TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
                    sql = sql + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
                    sql = sql + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
                    sql = sql + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
                    sql = sql + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
                    sql = sql + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
                    sql = sql + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
                    sql = sql + " KDGERAK,KDPEMBPP,STATUS,  KDPP ";
                    sql = sql + " FROM VIEW_REPORT_21KDPP";
                    sql = sql + " WHERE ";
                    sql = sql + "  TANGGAL  >= '" + tBLTH + tanggal + "'";
                    sql = sql + " AND TANGGAL  <= '" + tBLTH + tanggalend + "'";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND KDPP  = '" + kode + "'";
                    }
                    sql = sql + " Group by TGLCETAK, TANGGAL, KOGOL,KDGERAK,KDPEMBPP,STATUS, KDPP ";
                    sql = sql + " order by KDPP asc,KOGOL,TANGGAL asc";
                } else if ( vJenis.toUpperCase() == "21KDPP_PPTGLDAFTAR" ) {
                    sql = "SELECT TGLCETAK, TANGGAL,WKTBAYAR, IDPEL, KOGOL, BLTH, ";
                    sql = sql + " KDPEMBPP, STATUS, NOREK, NAMA, NAMAPNJ, ";
                    sql = sql + " RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, ";
                    sql = sql + " RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, ";
                    sql = sql + " RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, ";
                    sql = sql + " RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAK, ";
                    sql = sql + " UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, PEMDA, ";
                    sql = sql + " KDPPJ, TARIP, DAYA, KDKIRIM, ";
                    sql = sql + " KDPP";
                    sql = sql + " FROM VIEW_REPORT_21DAFTARREKG";
                    sql = sql + " WHERE ";
                    sql = sql + "  TANGGAL  >= '" + tBLTH + tanggal + "'";
                    sql = sql + " AND TANGGAL  <= '" + tBLTH + tanggalend + "'";
                    sql = sql + " AND KDPP  = '" + kode + "'";
                    sql = sql + " order by TANGGAL asc,WKTBAYAR asc";
                    //-----------============================================================
                } else if ( vJenis.toUpperCase() == "21KDPP_UNITTGLREKAP" ) {
                    sql = "SELECT TGLCETAK, TANGGAL, SUM(LEMBAR) AS LEMBAR, ";
                    sql = sql + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
                    sql = sql + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
                    sql = sql + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
                    sql = sql + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
                    sql = sql + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
                    sql = sql + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
                    sql = sql + " KDGERAK,KDPEMBPP,STATUS, UNITUP, KDPP ";
                    sql = sql + " FROM VIEW_REPORT_21KDPP";
                    sql = sql + " WHERE ";
                    sql = sql + "  TANGGAL  >= '" + tBLTH + tanggal + "'";
                    sql = sql + " AND TANGGAL  <= '" + tBLTH + tanggalend + "'";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND KDPP  = '" + kode + "'";
                    }
                    sql = sql + " Group by TGLCETAK, TANGGAL, KDGERAK,KDPEMBPP,STATUS, UNITUP,  KDPP ";
                    sql = sql + " order by KDPP asc,TANGGAL asc, UNITUP asc";
                } else if ( vJenis.toUpperCase() == "21KDPP_UNITTGLREKAPGOL" ) {
                    sql = "SELECT TGLCETAK, TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
                    sql = sql + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
                    sql = sql + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
                    sql = sql + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
                    sql = sql + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
                    sql = sql + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
                    sql = sql + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
                    sql = sql + " KDGERAK,KDPEMBPP,STATUS, UNITUP, KDPP ";
                    sql = sql + " FROM VIEW_REPORT_21KDPP";
                    sql = sql + " WHERE ";
                    sql = sql + "  TANGGAL  >= '" + tBLTH + tanggal + "'";
                    sql = sql + " AND TANGGAL  <= '" + tBLTH + tanggalend + "'";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND KDPP  = '" + kode + "'";
                    }
                    sql = sql + " Group by TGLCETAK, TANGGAL, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP,  KDPP ";
                    sql = sql + " order by KDPP asc,TANGGAL asc, UNITUP asc";
                } else if ( vJenis.toUpperCase() == "21KDPP_UNITTGLDAFTAR" ) {
                    sql = "SELECT TGLCETAK, TANGGAL,WKTBAYAR, IDPEL, KOGOL, BLTH, ";
                    sql = sql + " KDPEMBPP, STATUS, NOREK, NAMA, NAMAPNJ, ";
                    sql = sql + " RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, ";
                    sql = sql + " RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, ";
                    sql = sql + " RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, ";
                    sql = sql + " RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAK, ";
                    sql = sql + " UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, PEMDA, ";
                    sql = sql + " KDPPJ, TARIP, DAYA, KDKIRIM, UNITUPKDPP, ";
                    sql = sql + " KDPP";
                    sql = sql + " FROM VIEW_REPORT_21DAFTARREKG";
                    sql = sql + " WHERE ";
                    sql = sql + "  TANGGAL  >= '" + tBLTH + tanggal + "'";
                    sql = sql + " AND TANGGAL  <= '" + tBLTH + tanggalend + "'";
                    if ( tparUp.toUpperCase() != "SEMUA" ) {
                        sql = sql + " AND KDPP  = '" + kode + "'";
                    }
                    sql = sql + " order by TANGGAL asc,WKTBAYAR asc";
                }
            }

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            engine.setData(rs);
            con.close();
        }catch (Exception ex){
            CommonModule.getLogger(this).info("Dao Error : "+ ex.getMessage());
        }
    }

    @Override
    public void GetReport_21Petugas(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                 String tanggal, String tanggalend, String kode, String kdPembayar) {
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            ResultSet rs = null;
            String sql = "";

//            sql = "{call PARAMETERVIEW.SetTGLSTART(?)}";
//            cst = con.prepareCall(sql);
//            cst.setString("tglstrt", tBLTH + "01");
//            cst.execute();
//
//            sql = "{call PARAMETERVIEW.SetTGLEND(?)}";
//            cst = con.prepareCall(sql);
//            cst.setString("tglend", tBLTH + tanggalend);
//            cst.execute();
//
//            sql = "{call PARAMETERVIEW.SetKODEPP(?)}";
//            cst = con.prepareCall(sql);
//            cst.setString("KDPP", kode);
//            cst.execute();


            if ( vJenis.toUpperCase() == "21PETUGAS_PPTGLREKAP" ) {
                sql = "SELECT TGLCETAK, TANGGAL, SUM(LEMBAR) AS LEMBAR, ";
                sql += " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
                sql += " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
                sql += " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
                sql += " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
                sql += " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
                sql += " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
                sql += " KDGERAK,KDPEMBPP,STATUS,KDPP,KDPEMBAYAR ";
                sql += " FROM VIEW_REPORT_21PETUGAS";
                sql += " WHERE ";
                sql += "  TANGGAL  >= '" + tBLTH + tanggal + "'";
                sql += " AND TANGGAL  <= '" + tBLTH + tanggalend + "'";
                if ( tparUp.toUpperCase() != "SEMUA" ) {
                    sql += " AND KDPP  = '" + kode + "'";
                }
                if ( tparUp.toUpperCase() != "SEMUA" ) {
                    sql += " AND KDPEMBAYAR = '" + kdPembayar + "' ";
                }
                sql += " Group by TGLCETAK, TANGGAL, KDGERAK,KDPEMBPP,STATUS, KDPP, KDPEMBAYAR ";
                sql += " order by KDPEMBAYAR asc, KDPP asc,TANGGAL asc";
            } else if ( vJenis.toUpperCase() == "21PETUGAS_PPTGLREKAPGOL" ) {
                sql = "SELECT TGLCETAK, TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
                sql += " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
                sql += " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
                sql += " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
                sql += " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
                sql += " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
                sql += " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
                sql += " KDGERAK,KDPEMBPP,STATUS,KDPP,KDPEMBAYAR ";
                sql += " FROM VIEW_REPORT_21PETUGAS";
                sql += " WHERE ";
                sql += "  TANGGAL  >= '" + tBLTH + tanggal + "'";
                sql += " AND TANGGAL  <= '" + tBLTH + tanggalend + "'";
                if ( tparUp.toUpperCase() != "SEMUA" ) {
                    sql += " AND KDPP  = '" + kode + "'";
                }
                if ( tparUp.toUpperCase() != "SEMUA" ) {
                    sql += " AND KDPEMBAYAR = '" + kdPembayar + "' ";
                }
                sql += " Group by TGLCETAK, TANGGAL, KOGOL,KDGERAK,KDPEMBPP,STATUS,KDPP,KDPEMBAYAR ";
                sql += " order by KDPEMBAYAR asc, KDPP asc,KOGOL,TANGGAL asc";
            } else if ( vJenis.toUpperCase() == "21PETUGAS_PPTGLDAFTAR" ) {
                sql = "SELECT TGLCETAK, TANGGAL,WKTBAYAR, IDPEL, KOGOL, BLTH, ";
                sql += " KDPEMBPP, STATUS, NOREK, NAMA, NAMAPNJ, ";
                sql += " RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, ";
                sql += " RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, ";
                sql += " RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, ";
                sql += " RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAK, ";
                sql += " UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, PEMDA, ";
                sql += " KDPPJ, TARIP, DAYA, KDKIRIM, ";
                sql += " KDPP, UNITUPKDPP ";
                sql += " FROM VIEW_REPORT_21DAFTARREKGBPP";
                sql += " WHERE ";
                sql += "  TANGGAL  >= '" + tBLTH + tanggal + "'";
                sql += " AND TANGGAL  <= '" + tBLTH + tanggalend + "'";
                if ( tparUp.toUpperCase() != "SEMUA" ) {
                    sql += " AND KDPP  = '" + kode + "'";
                }
                if ( tparUp.toUpperCase() != "SEMUA" ) {
                    sql += " AND KDPEMBAYAR = '" + kdPembayar + "' ";
                }
                sql += " order by UNITUP, TANGGAL asc, IDPEL asc,BLTH ";
            } else if ( vJenis.toUpperCase() == "21PETUGAS_UNITTGLREKAP" ) {
                sql = "SELECT TGLCETAK, TANGGAL, SUM(LEMBAR) AS LEMBAR, ";
                sql += " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
                sql += " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
                sql += " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
                sql += " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
                sql += " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
                sql += " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
                sql += " KDGERAK,KDPEMBPP,STATUS, UNITUP, KDPP, KDPEMBAYAR ";
                sql += " FROM VIEW_REPORT_21PETUGAS";
                sql += " WHERE ";
                sql += "  TANGGAL  >= '" + tBLTH + tanggal + "'";
                sql += " AND TANGGAL  <= '" + tBLTH + tanggalend + "'";
                if ( tparUp.toUpperCase() != "SEMUA" ) {
                    sql += " AND KDPP  = '" + kode + "'";
                }
                if ( tparUp.toUpperCase() != "SEMUA" ) {
                    sql += " AND KDPEMBAYAR = '" + kdPembayar + "' ";
                }
                sql += " Group by TGLCETAK, TANGGAL, KDGERAK,KDPEMBPP,STATUS, UNITUP,  KDPP, kdpembayar ";
                sql += " order by KDPEMBAYAR asc, KDPP asc,TANGGAL asc, UNITUP asc";
            } else if ( vJenis.toUpperCase() == "21PETUGAS_UNITTGLREKAPGOL" ) {
                sql = "SELECT TGLCETAK, TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
                sql += " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
                sql += " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
                sql += " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
                sql += " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
                sql += " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
                sql += " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
                sql += " KDGERAK,KDPEMBPP,STATUS, UNITUP, KDPP,KDPEMBAYAR ";
                sql += " FROM VIEW_REPORT_21PETUGAS";
                sql += " WHERE ";
                sql += "  TANGGAL  >= '" + tBLTH + tanggal + "'";
                sql += " AND TANGGAL  <= '" + tBLTH + tanggalend + "'";
                if ( tparUp.toUpperCase() != "SEMUA" ) {
                    sql += " AND KDPP  = '" + kode + "'";
                }
                if ( tparUp.toUpperCase() != "SEMUA" ) {
                    sql += " AND KDPEMBAYAR = '" + kdPembayar + "' ";
                }
                sql += " Group by TGLCETAK, TANGGAL, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP,  KDPP,KDPEMBAYAR ";
                sql += " order by KDPEMBAYAR asc, KDPP asc,TANGGAL asc, UNITUP asc";
            } else if ( vJenis.toUpperCase() == "21PETUGAS_UNITTGLDAFTAR" ) {
                sql = "SELECT TGLCETAK, TANGGAL,WKTBAYAR, IDPEL, KOGOL, BLTH, ";
                sql += " KDPEMBPP, STATUS, NOREK, NAMA, NAMAPNJ, ";
                sql += " RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, ";
                sql += " RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, ";
                sql += " RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, ";
                sql += " RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAK, ";
                sql += " UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, PEMDA, ";
                sql += " KDPPJ, TARIP, DAYA, KDKIRIM, UNITUPKDPP, ";
                sql += " KDPP ";
                sql += " FROM VIEW_REPORT_21DAFTARREKGBPP";
                sql += " WHERE ";
                sql += "  TANGGAL  >= '" + tBLTH + tanggal + "'";
                sql += " AND TANGGAL  <= '" + tBLTH + tanggalend + "'";
                if ( tparUp.toUpperCase() != "SEMUA" ) {
                    sql += " AND KDPP  = '" + kode + "'";
                }
                if ( tparUp.toUpperCase() != "SEMUA" ) {
                    sql += " AND KDPEMBAYAR = '" + kdPembayar + "' ";
                }
                sql += " order by UNITUP ASC,TANGGAL asc,WKTBAYAR asc";
            }

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            engine.setData(rs);
            con.close();
        }catch (Exception ex){
            CommonModule.getLogger(this).info("Dao Error : "+ ex.getMessage());
        }
    }

    @Override
    public void GetReport21Restitusi(Engine engine, String in_unitupi, String in_unitap, String in_unitup, String in_blth,
                                    String in_jenis) {
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            ResultSet rs = null;
            String sql = "";

            sql = "{call PARAMETERVIEW.SetUnitUPI(?)}";
            cst = con.prepareCall(sql);
            cst.setString("tglstrt", in_unitupi);
            cst.execute();

            sql = "{call PARAMETERVIEW.SetUnitAP(?)}";
            cst = con.prepareCall(sql);
            cst.setString("tglstrt", in_unitap);
            cst.execute();

            sql = "{call PARAMETERVIEW.SetUnitUP(?)}";
            cst = con.prepareCall(sql);
            cst.setString("tglend", in_unitup);
            cst.execute();

            sql = "{call PARAMETERVIEW.SetBlTh(?)}";
            cst = con.prepareCall(sql);
            cst.setString("KDPP", in_blth);
            cst.execute();

            if (in_jenis.toUpperCase() == "REKAP") {
                sql = "SELECT * FROM VIEW_REKAP21_RESUP";
            } else if(in_jenis.toUpperCase() == "DAFTAR") {
                sql = "SELECT * FROM VIEW_DAFTAR21_RESUP";
            }

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            engine.setData(rs);
            con.close();
        }catch (Exception ex){
            CommonModule.getLogger(this).info("Dao Error : "+ ex.getMessage());
        }
    }
}
