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
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class cls_ReportBA {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Map<String, Object> ambilUnitPetugas(String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "select unit from petugas where kodepetugas = '" + petugas + "' ";
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData.get(0).get(0));
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> rptVIEW_BA11(String unitUp,
                                            String siklis,
                                            String blth,
                                            Date tempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        String strtempo = formatter.format(tempo);

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select TGLCETAK, TGLTRANSAKSI, TRANSAKSIBY, UNITUP, BLTH, KDKELOMPOK, KOGOL, KDGERAKMASUK, KDPEMBPP, LEMBAR, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK ";
            sql = sql + " from view_ba11 ";
            sql = sql + " where ";
            sql = sql + " UNITUP = '" + unitUp + "' ";
            if(siklis == "") {
                sql = sql + " and KDKELOMPOK = ' ' ";
            } else {
                    sql = sql + " and KDKELOMPOK = '" + siklis + "' ";
            }

            sql = sql + " and BLTH = '" + blth + "' ";
            sql = sql + "";
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

    public Map<String, Object> rptVIEW_BA21_Upload(String unitUp,
                                                   String tgltransaksi,
                                                   String tglbayar,
                                                   String kdpp,
                                                   String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            if (unitUp.substring(0, 2) == "52") {
                Date dServer = new Date(); //GetSysdate();
                cls_view_report_dphoffline clsSQL = new cls_view_report_dphoffline(dServer);

                sql = clsSQL.rptVIEW_BA21_Upload(unitUp, tgltransaksi, tglbayar, kdpp, transaksiby);
                sql = "";

            } else {
                sql = " SELECT ";
                sql = sql + " TGLCETAK, TGLTRANSAKSI, TGLBAYAR, KOGOL, LEMBAR, RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAKKELUAR, KDPEMBPP, STATUS, KDKIRIM, UNITUP, KODEPP, NAMAPP, ALAMATPP, TRANSAKSIBY, KODEGAGAL ";
                sql = sql + " FROM";
                sql = sql + " VIEW_BA21";
                sql = sql + " WHERE ";
                sql = sql +" kdkirim = 'U' ";
                sql = sql +" AND to_char(tgltransaksi,'yyyymmdd') = '" + tgltransaksi + "' ";
                sql = sql +" AND to_char(TGLBAYAR,'yyyymmdd') = '" + tglbayar + "'  ";
                sql = sql +" AND KODEPP = '" + kdpp + "' ";
                sql = sql +" AND TRANSAKSIBY = '" + transaksiby + "' ";
            }

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

    public Map<String, Object> rptVIEW_BA21_Entri(String unitUp,
                                                   String tgltransaksi,
                                                   String tglbayar,
                                                   String kdpp,
                                                   String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            if (unitUp.substring(0, 2) == "52") {
                Date dServer = new Date(); //GetSysdate();
                cls_view_report_dphoffline clsSQL = new cls_view_report_dphoffline(dServer);

                sql = clsSQL.rptVIEW_BA21_Entri(unitUp, tgltransaksi, tglbayar, kdpp, transaksiby);
                sql = "";

            } else {
                sql = " SELECT ";
                sql = sql + " TGLCETAK, TGLTRANSAKSI, TGLBAYAR, KOGOL, LEMBAR, RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAKKELUAR, KDPEMBPP, STATUS, KDKIRIM, UNITUP, KODEPP, NAMAPP, ALAMATPP, TRANSAKSIBY, KODEGAGAL ";
                sql = sql + " FROM";
                sql = sql + " VIEW_BA21";
                sql += " WHERE ";
                sql += " kdkirim = 'E' ";
                sql += " AND to_char(tgltransaksi,'yyyymmdd') = '" + tgltransaksi + "' ";
                sql += " AND to_char(TGLBAYAR,'yyyymmdd') = '" + tglbayar + "'  ";
                sql += " AND KODEPP = '" + kdpp + "' ";
                sql += " AND TRANSAKSIBY = '" + transaksiby + "' ";
            }

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

    public Map<String, Object> rptVIEW_BA21Daftar_Entri(String unitUp,
                                                  String tgltransaksi,
                                                  String tglbayar,
                                                  String kdpp,
                                                  String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            if (unitUp.substring(0, 2) == "52") {
                Date dServer = new Date(); //GetSysdate();
                cls_view_report_dphoffline clsSQL = new cls_view_report_dphoffline(dServer);

                sql = clsSQL.rptVIEW_BA21Daftar_Entri(unitUp, tgltransaksi, tglbayar, kdpp, transaksiby);
                sql = "";

            } else {
                sql = " SELECT ";
                sql = sql + " TGLCETAK, TGLTRANSAKSI, IDPEL, KOGOL, BLTH, KDPEMBPP, STATUS, NOREK, RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKIRIM, UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, PEMDA, KDPPJ, TARIP, DAYA, KODEPP, NAMAPP, ALAMATPP, TRANSAKSIBY, KODEGAGAL ";
                sql = sql + " FROM";
                sql = sql + " VIEW_BA21_DAFTAR";
                sql += " WHERE ";
                sql += " kdkirim = 'E' ";
                sql += " AND to_char(tgltransaksi,'yyyymmdd') = '" + tgltransaksi + "'  ";
                sql += " AND to_char(TGLBAYAR,'yyyymmdd') = '" + tglbayar + "'  ";
                sql += " AND KDPP = '" + kdpp + "' ";
                sql += " AND TRANSAKSIBY = '" + transaksiby + "' ";
            }

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

    public Map<String, Object> rptVIEW_BADENDA(String unitUp,
                                               String tgltransaksi,
                                               String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " SELECT ";
            sql = sql + " TGLCETAK, TGLTRANSAKSI, TRANSAKSIBY, JENISBK, IDPEL, KOGOL, BLTH, KDPEMBPP, TARIP, DAYA, RPBK, TGLJTTEMPO, ALASANBATAL ";
            sql = sql + " FROM";
            sql = sql + " VIEW_BADENDA";
            sql += " WHERE ";
            sql += " to_char(tgltransaksi,'yyyymmdd') = '" + tgltransaksi + "'  ";
            sql += " AND TRANSAKSIBY = '" + transaksiby + "' ";

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

    public Map<String, Object> rptVIEW_BA13upload(String unitUp,
                                                  String siklis,
                                                  String blth,
                                                  Date tempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();


        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String strtempo = formatter.format(tempo);

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select TGLCETAK, TGLTRANSAKSI, TRANSAKSIBY, UNITUP, BLTH, KDKELOMPOK, KOGOL, KDGERAKMASUK, KDPEMBPP, LEMBAR, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK ";
            sql = sql + " from view_ba13 ";
            sql = sql + " where ";
            sql = sql + " UNITUP = '" + unitUp + "' ";
            sql = sql + " and KDKELOMPOK = '" + siklis + "' ";
            sql = sql + " and BLTH = '" + blth + "' ";
            sql += "";

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

    public Map<String, Object> rpt_BA_CicilanRek(String petugas,
                                                  String idpel,
                                                  String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, petugas);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetIDPEL(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, idpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetBLTH(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, blth);
            cst.execute();

            sql = " select ";
            sql += " TGLCETAK, TGLTRANSAKSI, IDPEL, NAMA, NAMAPNJ, TGLJTTEMPO, NOAGENDA, BLTH, NOREK, UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, TARIP, DAYA, KOGOL, KDPEMBPP, STATUS, TRANSAKSIBY, RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTAG_LAMA, RPPTL_LAMA, TGLJTTEMPO_LAMA ";
            sql += " from ";
            sql += " view_bacicilrek ";

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

    public Map<String, Object> rpt_BA_23KirimUnit(String tPetugas,
                                                  String tUnitKirim,
                                                  String tTglKirim) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetUNITUP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tUnitKirim);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetTGLBAYAR(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tTglKirim);
            cst.execute();

            sql = " select ";
            sql += " TGLCETAK, KODE, ISIKODE, TGLTRANSAKSI, WKTTRANSAKSI, KDPP, KDPEMBAYAR, IDPEL, BLTH, NOREK, KDPEMBPP, KDGERAKMASUK, STATUS, NAMA, NAMAPNJ, UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, TARIP, DAYA, KOGOL, RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3 ";
            sql += " from ";
            sql += " VIEW_BA23KIRIMUNIT ";

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

    public Map<String, Object> rpt_BA_23KirimUnit(String tPetugas,
                                                  String tUnitKirim,
                                                  String sTransIDs,
                                                  String tTglKirim) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetUNITUP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tUnitKirim);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetTGLBAYAR(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tTglKirim);
            cst.execute();

            sql = " select ";
            sql += " TGLCETAK, KODE, ISIKODE, TGLTRANSAKSI, WKTTRANSAKSI, KDPP, KDPEMBAYAR, IDPEL, BLTH, NOREK, KDPEMBPP, KDGERAKMASUK, STATUS, NAMA, NAMAPNJ, UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, TARIP, DAYA, KOGOL, RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3 ";
            sql += " from ";
            sql += " view_ba23kirimunit_transid  ";
            sql += " WHERE TRANSAKSIID IN ( " + sTransIDs + ")";

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

    public Map<String, Object> rpt_BA_23TerimaUnit(String tPetugas,
                                                  String tUnitKirim,
                                                  String tTglKirim) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetUNITUP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tUnitKirim);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetTGLBAYAR(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tTglKirim);
            cst.execute();

            sql = " select ";
            sql += " TGLCETAK, KODE, ISIKODE, TGLTRANSAKSI, WKTTRANSAKSI, KDPP, KDPEMBAYAR, IDPEL, BLTH, NOREK, KDPEMBPP, KDGERAKMASUK, STATUS, NAMA, NAMAPNJ, UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, TARIP, DAYA, KOGOL, RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3 ";
            sql += " from ";
            sql += " VIEW_BA23TERIMAUNIT ";

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

    public Map<String, Object> GetSysdate() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " SELECT SYSDATE FROM DUAL ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData.get(0).get("SYSDATE"));
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }



    public Map<String, Object> rpt_BA_12KoreksiRekening(String tIDPEL,
                                                   String tBLTH) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIDPEL(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tIDPEL);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetBLTH(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBLTH);
            cst.execute();

            sql = " select ";
            sql += " TGLCETAK, BLTH, IDPEL, NAMA, KDGERAKMASUK, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, TARIP, DAYA, KOGOL, SUBKOGOL, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPTAG, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM ";
            sql += " from ";
            sql += " VIEW_BA23Pusat_Daftar ";

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

    public Map<String, Object> rpt_BA23Pusat_Daftar(String tglBayar,
                                                    String petugas,
                                                    String kode,
                                                    String kdkirim) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetTGLBAYAR(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tglBayar);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetKODEKOLEKTIF(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, petugas);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetKDKIRIM(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, kode);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, kdkirim);
            cst.execute();

            sql = " select ";
            sql += " TGLCETAK, BLTH, IDPEL, NAMA, KDGERAKMASUK, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, TARIP, DAYA, KOGOL, SUBKOGOL, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPTAG, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM ";
            sql += " from ";
            sql += " VIEW_BA23Pusat_Daftar ";

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

    public Map<String, Object> rpt_Kuitansi_RESUP(String tIDPEL) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIDPEL(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tIDPEL);
            cst.execute();

            sql = " select ";
            sql += " * ";
            sql += " from ";
            sql += " VIEW_KUITANSI_RESUP";

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
}
