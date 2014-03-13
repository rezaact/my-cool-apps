package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.clsSorek;
import id.co.hans.sample.server.dao.clsTransaksi_Proc;
import id.co.hans.sample.server.dao.cls_Aplikasi;
import id.co.hans.sample.server.dao.ws_TransaksiDao;
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
public class ws_TransaksiDaoImpl implements ws_TransaksiDao {
    public static final Log log = LogFactory.getLog(ws_TransaksiDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> HelloWorld() {
        Map<String, Object> retValue = new HashMap<String, Object>();

        try
        {
            String sql = "HelloWorld ";

            retValue.put("wsReturn", sql);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;
    }


    @Override
    public Map<String, Object> cekVersiAplikasi(String versi) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        if (versi == "v.2.0.2") {
            retValue.put("wsReturn", true);
        } else {
            retValue.put("wsReturn", false);
        }

        return retValue;
    }

    //---- common module ---
    private String getIdpel(String vJenis, String tpel) {
        String retVal = "";

        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql = "";

            if(vJenis == "IdPel") {
                sql = "select IDPEL from sip3single.dil where IDPEL = '" + tpel + "'";
            } else if(vJenis == "NoPel") {
                sql = "select IDPEL from sip3single.dil where NOPEL = '" + tpel + "'";
            }

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            while(rs.next()) {
                retVal = rs.getObject(1).toString();
                break;
            }
        }
        catch (Exception ex) {
            retVal = "";
        }
        return retVal;
    }

    private String getUnitupIdpel(String vJenis, String tpel) {
        String retVal = "";

        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql = "";

            if(vJenis == "IdPel") {
                sql = "select UNITUP as tUnitupidpel from sip3single.dil where IDPEL = '" + tpel + "'";
            } else if(vJenis == "NoPel") {
                sql = "select UNITUP as tUnitupidpel from sip3single.dil where NOPEL = '" + tpel + "'";
            }

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            while(rs.next()) {
                retVal = rs.getObject(1).toString();
                break;
            }
        }
        catch (Exception ex) {
            retVal = "";
        }
        return retVal;
    }


    //------------Transaksi View-------------------------------
    @Override
    public Map<String, Object> GetViewIdPel_21entri(String tpel,
                                                    String vJenis,
                                                    String tBLTH,
                                                    String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            tpel = getIdpel(vJenis, tpel);
            if (tpel == "") throw new Exception("ID Pelanggan tidak ditemukan");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString("idpel", tpel);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBlTh(?) }";
            cst = con.prepareCall(sql);
            cst.setString("BlTh", tBLTH);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetPetugas(?) }";
            cst = con.prepareCall(sql);
            cst.setString("Petugas", tPetugas);
            cst.execute();

            sql = " SELECT *  " +
                    " FROM sip3single.VIEW_21entri_TAMPILFORM order by IDPEL,SUBSTR(TGLJTTEMPO,1,6) DESC, NOURUT desc";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetView21(String unitup,
                                         String tglAwal,
                                         String tglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " SELECT *  " +
                    " FROM sip3single.VW_21DOWNLOAD " +
                    " WHERE " +
                    " TGLBAYAR BETWEEN '" + tglAwal + "' AND '" + tglAkhir + "'  " +
                    " AND UNITUP = '" + unitup + "' ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewIdPel_21Suplisi(String tpel,
                                                      String tBLTH,
                                                      String tKoreksi,
                                                      String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBlTh(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBLTH);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetPetugas(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetTglKoreksi(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tKoreksi);
            cst.execute();

            sql = " SELECT *  " +
                    " FROM sip3single.VIEW_21Suplisi_TAMPILFORM";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewIdPel_21HapusGagal(String tpel,
                                                         String vJenis,
                                                         String tBLTH,
                                                         String tPetugas,
                                                         String tTglBayar,
                                                         String tKodePp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            tpel = getIdpel(vJenis, tpel);
            if (tpel == "") throw new Exception("ID Pelanggan tidak ditemukan");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBlTh(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBLTH);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetPetugas(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetTglBayar(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tTglBayar);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetKodePp(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tKodePp);
            cst.execute();

            sql = " SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME " +
                    " FROM sip3single.VIEW_21HapusGagal_TAMPILFORM order by IDPEL,blth desc ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewIdPel_PembatalanDenda(String tpel,
                                                            String vJenis,
                                                            String tBLTH,
                                                            String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            tpel = getIdpel(vJenis, tpel);
            if (tpel == "") throw new Exception("ID Pelanggan tidak ditemukan");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBlTh(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBLTH);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetPetugas(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = " SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME  " +
                    " FROM sip3single.VIEW_BATALDENDA_TAMPILFORM order by IDPEL,blth asc ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewIdPel_31(String tpel,
                                               String vJenis,
                                               String tBLTH,
                                               String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            tpel = getIdpel(vJenis, tpel);
            if (tpel == "") throw new Exception("ID Pelanggan tidak ditemukan");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PKG_VIEW_TAMPILFORM.NEW_31_TAMPILFORM(?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.registerOutParameter("OUT_DATA", OracleTypes.CURSOR);
            cst.setString("vIDPEL", tpel);
            cst.setString("vBLTH", tpel);
            cst.setString("vPETUGAS", tpel);
            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject("OUT_DATA");

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewIdPel_41DUPR(String tpel,
                                                   String vJenis,
                                                   String tBLTH,
                                                   String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            tpel = getIdpel(vJenis, tpel);
            if (tpel == "") throw new Exception("ID Pelanggan tidak ditemukan");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBlTh(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBLTH);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetPetugas(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = " SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME  " +
                    " FROM sip3single.VIEW_41DUPR_TAMPILFORM order by IDPEL,blth asc ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewIdPel_32DUPP(String tpel,
                                                   String vJenis,
                                                   String tBLTH,
                                                   String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            tpel = getIdpel(vJenis, tpel);
            if (tpel == "") throw new Exception("ID Pelanggan tidak ditemukan");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBlTh(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBLTH);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetPetugas(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = " SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME  " +
                    " FROM sip3single.VIEW_32DUPP_TAMPILFORM order by IDPEL,blth asc ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewIdPel_41(String tpel,
                                               String vJenis,
                                               String tBLTH,
                                               String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            tpel = getIdpel(vJenis, tpel);
            if (tpel == "") throw new Exception("ID Pelanggan tidak ditemukan");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBlTh(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBLTH);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetPetugas(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = " SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME  " +
                    " FROM sip3single.VIEW_41_TAMPILFORM order by IDPEL,blth asc ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewIdPel_32(String tpel,
                                               String vJenis,
                                               String tBLTH,
                                               String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            tpel = getIdpel(vJenis, tpel);
            if (tpel == "") throw new Exception("ID Pelanggan tidak ditemukan");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBlTh(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBLTH);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetPetugas(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = " SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME  " +
                    " FROM sip3single.VIEW_32_TAMPILFORM order by IDPEL,blth asc ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    // todo: FVCK

    @Override
    public Map<String, Object> GetViewKolektif_32DUPP(String tkodekolektif,
                                                      String tBLTH,
                                                      String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            //todo: method ini mengembalikan dalam bentuk XML dan XMLSchema. Cek method pemanggil.

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            /*
            sql = "{ call sip3single.PARAMETERVIEW.SetBlTh(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBLTH);
            cst.execute();
            */

            sql = "{ call sip3single.PARAMETERVIEW.SetPetugas(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = " SELECT *  " +
                    " FROM VIEW_32DHPfromDUPP_TAMPILFORM order by IDPEL,SUBSTR(TGLJTTEMPO,1,6) DESC, NOURUT desc ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewKolektif_41DUPR(String tkodekolektif,
                                                      String tBLTH,
                                                      String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            //todo: method ini mengembalikan dalam bentuk XML dan XMLSchema. Cek method pemanggil.

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PARAMETERVIEW.SetPetugas(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetIDPEL(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tkodekolektif);
            cst.execute();

            sql = " SELECT *  " +
                    " FROM sip3single.VIEW_41PRRfromDUPR_TAMPILFORM WHERE IDPEL = '" + tkodekolektif + "'  order by IDPEL,SUBSTR(TGLJTTEMPO,1,6) DESC, NOURUT desc ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewKolektif_21giralisasi(String tkodekolektif,
                                                            String tBLTH,
                                                            String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            //todo: method ini mengembalikan dalam bentuk XML dan XMLSchema. Cek method pemanggil.

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PARAMETERVIEW.SetKodeKolektif(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tkodekolektif);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBlth(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBLTH);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetPetugas(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = " SELECT *  " +
                    " FROM sip3single.VIEW_21GIRALISASI_TAMPILFORM order by IDPEL,SUBSTR(TGLJTTEMPO,1,6) DESC, NOURUT desc ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewKolektif_23pusat(String tkodekolektif,
                                                       String tBLTH,
                                                       String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            //todo: method ini mengembalikan dalam bentuk XML dan XMLSchema. Cek method pemanggil.

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PARAMETERVIEW.SetKodeKolektif(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tkodekolektif);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBlth(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBLTH);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetPetugas(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = " SELECT *  " +
                    " FROM sip3single.VIEW_23NOTApusat_TAMPILFORM order by IDPEL,SUBSTR(TGLJTTEMPO,1,6) DESC, NOURUT desc ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewKolektif_23NOTA(String tkodekolektif,
                                                      String tBLTH,
                                                      String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            //todo: method ini mengembalikan dalam bentuk XML dan XMLSchema. Cek method pemanggil.

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PARAMETERVIEW.SetKodeKolektif(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tkodekolektif);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBlth(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBLTH);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetPetugas(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = " SELECT *  " +
                    " FROM sip3single.VIEW_23NOTA_TAMPILFORM order by IDPEL,SUBSTR(TGLJTTEMPO,1,6) DESC, NOURUT desc ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewIdPel_12ABC(String tpel,
                                                  String vJenis,
                                                  String tBLTH,
                                                  String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            //todo: method ini mengembalikan dalam bentuk XML dan XMLSchema. Cek method pemanggil.

            tpel = getIdpel(vJenis, tpel);
            if (tpel == "") throw new Exception("ID Pelanggan tidak ditemukan");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PKG_VIEW_TAMPILFORM.NEW_12ABC_TAMPILFORM(?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.setString("vIDPEL", tpel);
            cst.setString("vBLTH", tBLTH);
            cst.setString("vPETUGAS", tPetugas);
            cst.registerOutParameter("OUT_DATA", OracleTypes.CURSOR);
            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject("OUT_DATA");

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewIdPel_12ABCORATOORA(String tpel,
                                                          String vJenis,
                                                          String tBLTH,
                                                          String tPetugas,
                                                          Boolean ORATOORA,
                                                          String kdkrs) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String tUnitupidpel="";

        try
        {
            //todo: method ini mengembalikan dalam bentuk XML dan XMLSchema. Cek method pemanggil.

            tUnitupidpel = getUnitupIdpel(vJenis, tpel);
            if (tUnitupidpel == "") throw new Exception("ID Pelanggan tidak ditemukan");


            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PARAMETERVIEW.SetIDPEL(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBLTH(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBLTH);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            if(ORATOORA) {
                if(tUnitupidpel.substring(0,2) == "13") {
                    //---khusus untuk sumbar
                    sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME, ";
                    sql += " JNSMUT, BLTHMUT,  KDMUT,  TGLNYALA,  NOGARDU,  NOTIANG,  NOMETER, RPBP, RPUJL";
                    sql += " FROM VIEW_12ABC_ORASUMBAR ";
                    sql += " order by IDPEL,blth asc";
                } else {

                }
            } else {
                sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME, ";
                sql += " JNSMUT, BLTHMUT,  KDMUT,  TGLNYALA,  NOGARDU,  NOTIANG,  NOMETER, RPBP, RPUJL,RPINSENTIF_KVA, RPINSENTIF_KWH, RPDISINSENTIF_KVA, RPDISINSENTIF_KWH";
                sql += " FROM VIEW_12ABC_TAMPILFORM ";
                sql += " order by IDPEL,blth asc";
            }

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if(ORATOORA) {
                if (lMapData.size() == 2) {
                    if(lMapData.get(0).get("KDKOREKSI").toString() == kdkrs) {
                        retValue.put("wsReturn", lMapData);
                        retValue.put("wsByRefError", "");
                    }

                    if(lMapData.get(1).get("KDKOREKSI").toString() == kdkrs) {
                        retValue.put("wsReturn", lMapData);
                        retValue.put("wsByRefError", "");
                    }

                    retValue.put("wsByRefError", "Data Baru dengan KdKoreksi " + kdkrs + " , tidak ditemukan.");
                }  else {
                    retValue.put("wsByRefError", "Data Baru tidak ditemukan.");
                }
            } else {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");
            }

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewIdPel_12DE(String tpel,
                                                 String vJenis,
                                                 String tBLTH,
                                                 String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            //todo: method ini mengembalikan dalam bentuk XML dan XMLSchema. Cek method pemanggil.

            tpel = getIdpel(vJenis, tpel);
            if (tpel == "") throw new Exception("ID Pelanggan tidak ditemukan");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PKG_VIEW_TAMPILFORM.NEW_12DE_TAMPILFORM(?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.setString("vIDPEL", tpel);
            cst.setString("vBLTH", tBLTH);
            cst.setString("vPETUGAS", tPetugas);
            cst.registerOutParameter("OUT_DATA", OracleTypes.CURSOR);
            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject("OUT_DATA");

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewIdPel_12D(String tpel,
                                                String vJenis,
                                                String tBLTH,
                                                String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            tpel = getIdpel(vJenis, tpel);
            if (tpel == "") throw new Exception("ID Pelanggan tidak ditemukan");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call sip3single.PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBlth(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBLTH);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetPetugas(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = " SELECT *  " +
                    " FROM sip3single.VIEW_12D_TAMPILFORM order by IDPEL,blth asc ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewIdPel_13LAMA(String tpel,
                                                   String vJenis,
                                                   String tBLTH,
                                                   String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();
        List<Map<String,String>> lMapDil = new ArrayList<Map<String,String>>();
        List<Map<String,String>> lMapPet = new ArrayList<Map<String,String>>();

        try
        {
//            tpel = getIdpel(vJenis, tpel);
//            if (tpel == "") throw new Exception("ID Pelanggan tidak ditemukan");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;


            sql = " SELECT *  " +
                    " FROM sip3single.DIL WHERE IDPEL = '" + tpel + "'";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapDil = CommonModule.convertResultsetToListStr(rs);

            if(lMapDil.size() == 0) {
                throw new Exception("ID Pelanggan tidak ditemukan");
            }

            sql = " SELECT *  " +
                    " FROM sip3single.PETUGAS_2122OFFON WHERE ID_USER = '" + tPetugas + "'";

            cst = con.prepareCall(sql);

            rs = cst.executeQuery();

            lMapPet = CommonModule.convertResultsetToListStr(rs);

            if(lMapPet.size() == 0) {
                throw new Exception("KodePetugas tidak ada");
            }

            if(lMapDil.get(0).get("UNITUP") != lMapPet.get(0).get("UNITUP")) {
                throw new Exception("UnitUp pelanggan = " + lMapDil.get(0).get("UNITUP") + " tidak sesuai dengan UnitUp petugas entri = " + lMapPet.get(0).get("UNITUP") + ".");
            }




            sql = "{ call sip3single.PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBlth(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBLTH);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetPetugas(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = " SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME  " +
                    " FROM sip3single.VIEW_13_TAMPILFORM order by IDPEL,blth asc ";

            cst = con.prepareCall(sql);

            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    @Override
    public Map<String, Object> GetViewIdPel_13BARU(String tpel,
                                                   String vJenis,
                                                   String tBLTH,
                                                   String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();
        List<Map<String,String>> lMapDil = new ArrayList<Map<String,String>>();
        List<Map<String,String>> lMapPet = new ArrayList<Map<String,String>>();

        try
        {
//            tpel = getIdpel(vJenis, tpel);
//            if (tpel == "") throw new Exception("ID Pelanggan tidak ditemukan");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;


            sql = " SELECT *  " +
                    " FROM sip3single.DIL WHERE IDPEL = '" + tpel + "'";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapDil = CommonModule.convertResultsetToListStr(rs);

            if(lMapDil.size() > 0) {
                throw new Exception("Pelanggan sudah ada DIL.");
            }


            sql = "{ call sip3single.PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBlth(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBLTH);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetPetugas(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = " SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME  " +
                    " FROM sip3single.VIEW_13_TAMPILFORM order by IDPEL,blth asc ";

            cst = con.prepareCall(sql);

            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

//            retValue.put("wsData", lMapData);

            if(lMapData.size() > 0) {
                retValue.put("wsByRefError", "Piutang sudah ada di DPP.");
            }



            sql = " SELECT *  " +
                    " FROM sip3single.PETUGAS_2122OFFON WHERE ID_USER = '" + tPetugas + "'";

            cst = con.prepareCall(sql);

            rs = cst.executeQuery();

            lMapPet = CommonModule.convertResultsetToListStr(rs);

            if(lMapPet.size() == 0) {
                throw new Exception("KodePetugas tidak ada");
            }


            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    @Override
    public Map<String, Object> Getview_SOREKORATOORA(String unitap,
                                                     String unitup,
                                                     String thbl,
                                                     String KDKELOMPOK,
                                                     String strglobalkodepetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
//            tpel = getIdpel(vJenis, tpel);
//            if (tpel == "") throw new Exception("ID Pelanggan tidak ditemukan");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;


            sql = "{ call sip3single.PARAMETERVIEW.SetUNITAP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, unitap);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetUNITUP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, unitup);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBLTH(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, thbl);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetKDSIKLIS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, KDKELOMPOK);
            cst.execute();

            sql = "SELECT TGLCETAK AS TANGGAL, UNITUP, BLTH, KDKELOMPOK, TGLJTTEMPO,  KOGOL, LEMBAR, KWHLWBP, KWHWBP, BLOK3,  PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP,  RPBLOK3, RPKVARH, RPBEBAN, RPTTLB, RPPTL,  RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO,  RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT,  RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI,  RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3,  RPTDLLAMA, RPTDLBARU, RPSELISIH ";
            sql += " FROM INTEG_SOREK13000_GOL ";
            sql += " WHERE KDGERAKmasuk = '11'  ";
            sql += " AND STATUS = 'L'  ";
            sql += " AND KDPEMBPP = 'R1' ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    @Override
    public Map<String, Object> Getview_SOREKORATOORANEW(String unitap,
                                                        String unitup,
                                                        String thbl,
                                                        String KDKELOMPOK,
                                                        String strglobalkodepetugas,
                                                        String _package) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
//            tpel = getIdpel(vJenis, tpel);
//            if (tpel == "") throw new Exception("ID Pelanggan tidak ditemukan");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            //todo: _package <--- parameter ini

            sql = "{ call sip3single.PARAMETERVIEW.SetUNITAP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, unitap);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetUNITUP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, unitup);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetBLTH(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, thbl);
            cst.execute();

            sql = "{ call sip3single.PARAMETERVIEW.SetKDSIKLIS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, KDKELOMPOK);
            cst.execute();

            sql = "SELECT TGLCETAK AS TANGGAL, UNITUP, BLTH, KDKELOMPOK, TGLJTTEMPO,  KOGOL, LEMBAR, KWHLWBP, KWHWBP, BLOK3,  PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP,  RPBLOK3, RPKVARH, RPBEBAN, RPTTLB, RPPTL,  RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO,  RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT,  RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI,  RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3,  RPTDLLAMA, RPTDLBARU, RPSELISIH ";
            sql += " FROM INTEG_SOREK13000_GOL ";
            sql += " WHERE KDGERAKmasuk = '11'  ";
            sql += " AND STATUS = 'L'  ";
            sql += " AND KDPEMBPP = 'R1' ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    @Override
    public Map<String, Object> Getview_SUSULANORATOORA(String unitup,
                                                       String thbl,
                                                       String KDKELOMPOK,
                                                       String strglobalkodepetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
//            tpel = getIdpel(vJenis, tpel);
//            if (tpel == "") throw new Exception("ID Pelanggan tidak ditemukan");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "SELECT TGLCETAK AS TANGGAL, UNITUP, BLTH, KDKELOMPOK, TGLJTTEMPO,  KOGOL, LEMBAR, KWHLWBP, KWHWBP, BLOK3,  PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP,  RPBLOK3, RPKVARH, RPBEBAN, RPTTLB, RPPTL,  RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO,  RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT,  RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI,  RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3,  RPTDLLAMA, RPTDLBARU, RPSELISIH";
            if (unitup.substring(0, 2) == "13") {
                sql += " FROM INTEG_SOREK13000_GOL";
            }
            sql += " WHERE BLTH = '" + thbl + "'";
            sql += " AND KDGERAKmasuk = '13'  ";
            sql += " AND STATUS = 'L'  ";
            sql += " AND KDPEMBPP = 'R1'   ";
            sql += " AND UNITUP = '" + unitup + "'";
            sql += " AND kdKELOMPOK = '" + KDKELOMPOK + "'";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            if(lMapData.size() == 0) {
                retValue.put("wsByRefError", "Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    //---tambahan untuk cari idpel dari nopel
    @Override
    public Map<String, Object> GetIdpel(String vJenis,
                                        String tPEL) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        String retVal = "";

        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql = "";

            if(vJenis == "IdPel") {
                sql = "select IDPEL from sip3single.dil where IDPEL = '" + tPEL + "'";
            } else if(vJenis == "NoPel") {
                sql = "select IDPEL from sip3single.dil where NOPEL = '" + tPEL + "'";
            }

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            while(rs.next()) {
                retVal = rs.getObject(1).toString();
                break;
            }
        }
        catch (Exception ex) {
            retVal = "";
        }

        retValue.put("wsReturn", retVal);
        return retValue;
    }
    //---end tambahan untuk cari idpel dari nopel

    //------------Transaksi Proc-------------------------------
    @Override
    public Map<String, Object> SetData_11(String unitup,
                                          String thbl,
                                          String strglobalkodepetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetData_11(unitup, thbl, strglobalkodepetugas);

        return retValue;
    }

    @Override
    public Map<String, Object> SetData_11_New(String unitap,
                                              String unitup,
                                              String kdprosesklp,
                                              String blth,
                                              String strglobalkodepetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetData_11_New(unitap, unitup, kdprosesklp, blth, strglobalkodepetugas);

        return retValue;
    }


    @Override
    public Map<String, Object> SetData_11_Cutoff(String unitup,
                                                 String thbl,
                                                 String strglobalkodepetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetData_11_Cutoff(unitup, thbl, strglobalkodepetugas);

        return retValue;
    }


    @Override
    public Map<String, Object> SetData_13(String unitup,
                                          String thbl,
                                          String strglobalkodepetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetData_13(unitup, thbl, strglobalkodepetugas);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_31(Integer lbrproses,
                                               String tTransaksiBy,
                                               List<Map<String, String>> strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_31(tTransaksiBy, strData);   // note: parameter lbrproses

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_41DUPR(List<Map<String, String>> dtrans,
                                                   String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_41DUPR(dtrans, tTransaksiBy);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_32DUPP(List<Map<String, String>> dtrans,
                                                   String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_32DUPP(dtrans, tTransaksiBy);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_41(List<Map<String, String>> dtrans,
                                               String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_41(dtrans, tTransaksiBy);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_32(List<Map<String, String>> dtrans,
                                               String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_32(dtrans, tTransaksiBy);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_21entri(Integer lbrproses,
                                                    String tTransaksiBy,
                                                    String tTglBayar,
                                                    String tKdPP,
                                                    String tKDPEMBAYAR,
                                                    List<Map<String, String>> strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_21entri(tTransaksiBy, tTglBayar, tKdPP, tKDPEMBAYAR, strData);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_21HapusGagal(List<Map<String, String>> dtrans,
                                                         String tTransaksiBy,
                                                         String tTglBayar,
                                                         String tKdPP,
                                                         String tKDPEMBAYAR) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_21HapusGagal(dtrans, tTransaksiBy, tTglBayar, tKdPP, tKDPEMBAYAR);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_21Suplisi(List<Map<String, String>> dtrans,
                                                      String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_21Suplisi(dtrans, tTransaksiBy);

        return retValue;
    }


    @Override
    public Map<String, Object> SetData_21upload(List<Map<String, String>> dtrans,
                                                String tTransaksiBy,
                                                String tTglBayar,
                                                String tKdPP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();

        retFunc = clsTransaksiProc.SetData_21insert(dtrans, tTransaksiBy);

        if (retFunc.get("wsReturn") == "") {
            retValue = clsTransaksiProc.SetData_21upload(tTransaksiBy, tTglBayar, tKdPP);
        } else {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", retFunc.get("wsByRefError"));
        }

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_PembatalanDenda(List<Map<String, String>> dtrans,
                                                            String tTransaksiBy,
                                                            String tTglBayar,
                                                            String tKdPP,
                                                            String tKDPEMBAYAR) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_PembatalanDenda(dtrans, tTransaksiBy, tTglBayar, tKdPP, tKDPEMBAYAR);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_23NOTABUKU(Integer lbrproses,
                                                       String tTransaksiBy,
                                                       String tKirim,
                                                       List<Map<String, String>> strData,
                                                       Integer tBebanKantor) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_23NOTA(tTransaksiBy, tKirim, strData, tBebanKantor);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_23NOTATERPUSAT(Integer lbrproses,
                                                           String tTransaksiBy,
                                                           String tKirim,
                                                           List<Map<String, String>> strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_23NOTAPUSAT(tTransaksiBy, tKirim, strData);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_21GIRALISASI(Integer lbrproses,
                                                         String tTransaksiBy,
                                                         String tKirim,
                                                         String tKodePP,
                                                         String tTglBayar,
                                                         List<Map<String, String>> strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_21GIRALISASI(tTransaksiBy, tKirim, tKodePP, tTglBayar, strData);

        return retValue;
    }


    @Override
    public Map<String, Object> Server_Download_DPH_AJN(String parUNITUP,
                                                       Date parTglMulai,
                                                       Date parTglSampai) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.Server_Download_DPH_AJN(parUNITUP, parTglMulai, parTglSampai);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_32DHPfromDUPP(Integer lbrproses,
                                                          String tTransaksiBy,
                                                          String tKirim,
                                                          List<Map<String, String>> strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_32DHPfromDUPP(tTransaksiBy, tKirim, strData);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_41PRRfromDUPR(Integer lbrproses,
                                                          String tTransaksiBy,
                                                          String tKirim,
                                                          List<Map<String, String>> strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_41PRRfromDUPR(tTransaksiBy, tKirim, strData);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_12ABC(List<Map<String, String>> dtrans,
                                                  String tTransaksiBy,
                                                  String tKdkoreksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_12ABC(dtrans, tTransaksiBy, tKdkoreksi);

        return retValue;
    }


    @Override
    public Map<String, Object> New_SetDataIdpel_12ABC(List<Map<String, String>> dtrans,
                                                      String tTransaksiBy,
                                                      String tKdkoreksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.New_SetDataIdpel_12ABC(dtrans, tTransaksiBy, tKdkoreksi);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_12ABCNew(Integer hasil,
                                                     String idpel,
                                                     String thblrek,
                                                     Integer SLALWBP,
                                                     Integer SAHLWBP,
                                                     Integer SLAWBP,
                                                     Integer SAHWBP,
                                                     Integer SLAKVARH,
                                                     Integer SAHKVARH,
                                                     Integer SAHKVAMAKS,
                                                     String HITUNGBY) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_12ABCNew(idpel, thblrek, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SAHKVAMAKS, HITUNGBY);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_12ABCNewJabar(String idpel,
                                                          String thblrek,
                                                          Integer SLALWBP,
                                                          Integer SAHLWBP,
                                                          Integer SLAWBP,
                                                          Integer SAHWBP,
                                                          Integer SLAKVARH,
                                                          Integer SAHKVARH,
                                                          Integer SAHKVAMAKS,
                                                          String HITUNGBY,
                                                          Integer SLALWBP_PASANG,
                                                          Integer SAHLWBP_CABUT,
                                                          Integer SLAWBP_PASANG,
                                                          Integer SAHWBP_CABUT,
                                                          Integer SLAKVARH_PASANG,
                                                          Integer SAHKVARH_CABUT,
                                                          Integer SAHKVAMAKS_CABUT,
                                                          String _package) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_12ABCNewJabar(idpel, thblrek, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SAHKVAMAKS, HITUNGBY, SLALWBP_PASANG, SAHLWBP_CABUT, SLAWBP_PASANG, SAHWBP_CABUT, SLAKVARH_PASANG, SAHKVARH_CABUT, SAHKVAMAKS_CABUT, _package);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_12DE(List<Map<String, String>> dtrans,
                                                 String tTransaksiBy,
                                                 String tKdkoreksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_12DE(dtrans, tTransaksiBy, tKdkoreksi);

        return retValue;
    }


    @Override
    public Map<String, Object> exeprocORA(Boolean exec,
                                          String procedurename,
                                          List<Map<String, String>> paramvalue) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.exeprocKoreksi(exec, procedurename, paramvalue);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_12D(List<Map<String, String>> dtrans,
                                                String tTransaksiBy,
                                                String tKdkoreksi,
                                                Boolean bSuplisi) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_12D(dtrans, tTransaksiBy, tKdkoreksi, bSuplisi);

        return retValue;
    }


    @Override
    public Map<String, Object> SetDataIdpel_13(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String tJenis) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetDataIdpel_13(dtrans, tTransaksiBy, tJenis);

        return retValue;
    }


    //----tambahan sumbar sorek oratoora
    @Override
    public Map<String, Object> SetData_13UPLOAD(String unitup,
                                                String thbl,
                                                String strglobalkodepetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsTransaksi_Proc clsTransaksiProc = new clsTransaksi_Proc();
        retValue = clsTransaksiProc.SetData_13UPLOAD(unitup, thbl, strglobalkodepetugas);

        return retValue;
    }

    //----end tambahan sumbar sorek oratoora


    //---------------------------LAporan Pemantauan

    @Override
    public Map<String, Object> PemantauanTransaksi(String Transaksi,
                                                   String vJenis,
                                                   String vPilihTgl,
                                                   String tUnitKJ,
                                                   String tUnitUP,
                                                   String tUnitAP,
                                                   String tTglmulai,
                                                   String tTglsampai,
                                                   String tKdpp,
                                                   String tKdPembayar,
                                                   String tKode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "PemantauanTransaksi ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("PemantauanTransaksi", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> PemantauanJurnal(String vPilihTgl,
                                                String tUnitUP,
                                                String tUnitAP,
                                                String tTglmulai,
                                                String tTglsampai,
                                                String tBlTh) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "PemantauanJurnal ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("PemantauanJurnal", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> PemantauanSaldo(String vPilihSaldo,
                                               String vPilihRep,
                                               String tUnitUP,
                                               String tUnitAP,
                                               String tTglmulai,
                                               String tTglsampai,
                                               String tBlTh,
                                               String in_unitupi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "PemantauanSaldo ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("PemantauanSaldo", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> PemantauanSaldo_v2(String vPilihSaldo,
                                                  String vPilihRep,
                                                  String tUnitUP,
                                                  String tUnitAP,
                                                  String tUnitUPI,
                                                  String tTglmulai,
                                                  String tTglsampai,
                                                  String tBlTh,
                                                  String in_unitupi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "PemantauanSaldo_v2 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("PemantauanSaldo_v2", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    //-------GENERAL Transaksi dan Laporan-------------------

    @Override
    public Map<String, Object> GetViewALASANHAPUSBK(String vJenis,
                                                    String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewALASANHAPUSBK ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewALASANHAPUSBK", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilTanggalHariIni() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilTanggalHariIni ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilTanggalHariIni", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetViewKODEPP(String vJenis,
                                             String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewKODEPP ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewKODEPP", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetViewKODEKOLEKTIF21GIRALISASI() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewKODEKOLEKTIF21GIRALISASI ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewKODEKOLEKTIF21GIRALISASI", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetViewKODEKOLEKTIF21GIRALISASIUNITUP(String sUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewKODEKOLEKTIF21GIRALISASIUNITUP ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewKODEKOLEKTIF21GIRALISASIUNITUP", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetViewKODEKOLEKTIF23PUSAT() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewKODEKOLEKTIF23PUSAT ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewKODEKOLEKTIF23PUSAT", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetViewKODEKOLEKTIF23PUSATUNITUP(String sUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewKODEKOLEKTIF23PUSATUNITUP ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewKODEKOLEKTIF23PUSATUNITUP", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetViewKODEKOLEKTIF23NOTA() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewKODEKOLEKTIF23NOTA ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewKODEKOLEKTIF23NOTA", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetViewKODEKOLEKTIF23NOTAUNITUP(String sunitup,
                                                               Integer iBebanKantor) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewKODEKOLEKTIF23NOTAUNITUP ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewKODEKOLEKTIF23NOTAUNITUP", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetViewKODEKELOMPOK(String tTHBL,
                                                   String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewKODEKELOMPOK ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewKODEKELOMPOK", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetViewKODEKELOMPOKUNIT(String tTHBL,
                                                       String tUNIT) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewKODEKELOMPOKUNIT ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewKODEKELOMPOKUNIT", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetViewKODEKELOMPOKBYSIKLIS(String tTHBL,
                                                           String tSIKLIS) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewKODEKELOMPOKBYSIKLIS ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewKODEKELOMPOKBYSIKLIS", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetViewKODERR(String tUNIT) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewKODERR ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewKODERR", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetTempSorek() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetTempSorek ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetTempSorek", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetViewKODEKOREKSI() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewKODEKOREKSI ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewKODEKOREKSI", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetTempDKRP() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetTempDKRP ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetTempDKRP", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    //--------kolektif23nota
    @Override
    public Map<String, Object> GetDataKolektifNotaBuku() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataKolektifNotaBuku ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataKolektifNotaBuku", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> GetDataKolektifNotaBukuUnitup(String sUnitUp,
                                                             String iBebanKantor) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "select kodekolektif, NAMAKOLEKTIF from sip3single.kodekolektif23nota WHERE TGLTHRU IS NULL AND UNITUP='" + sUnitUp + "' AND BEBANKANTOR=" + iBebanKantor + " order by kodekolektif ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsData", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    //--------kolektif23KIRIM
    @Override
    public Map<String, Object> GetDataKolektifKirim() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataKolektifKirim ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataKolektifKirim", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> GetDataKolektifNotaTerpusat() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataKolektifNotaTerpusat ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataKolektifNotaTerpusat", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> GetDataKolektifNotaTerpusatUnitup(String sUnitUP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataKolektifNotaTerpusatUnitup ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataKolektifNotaTerpusatUnitup", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> GetDataKolektifGiralisasi() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataKolektifGiralisasi ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataKolektifGiralisasi", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> GetDataKolektifGiralisasiUnitup(String sUnitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataKolektifGiralisasiUnitup ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataKolektifGiralisasiUnitup", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetDataIdPelNotaBuku(String tkodekolektif) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataIdPelNotaBuku ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataIdPelNotaBuku", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetDataIdPelKirim(String tkodekolektif) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataIdPelKirim ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataIdPelKirim", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetDataIdPelNotaTerpusat(String tkodekolektif) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataIdPelNotaTerpusat ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataIdPelNotaTerpusat", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetDataIdPelDil(String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataIdPelDil ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataIdPelDil", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetDataNoPelDil(String tNopel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataNoPelDil ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataNoPelDil", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetDataIdPelDPP(String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataIdPelDPP ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataIdPelDPP", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetDataIdPelDPPNotaTerpusat(String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataIdPelDPPNotaTerpusat ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataIdPelDPPNotaTerpusat", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetDataIdPelDPPGiralisasi(String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataIdPelDPPGiralisasi ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataIdPelDPPGiralisasi", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetDataIdPelGiralisasi(String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataIdPelGiralisasi ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataIdPelGiralisasi", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpandatapel(String tidpel,
                                             String tKdKolektif,
                                             String ket,
                                             String Atransaksiby,
                                             String Atgl_transaksi,
                                             String tNopel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "simpandatapel ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpandatapel", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpandatapelKirim(String tidpel,
                                                  String tKdKolektif,
                                                  String ket,
                                                  String Atransaksiby,
                                                  String Atgl_transaksi,
                                                  String tNopel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "simpandatapelKirim ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpandatapelKirim", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpandatapelNotaTerpusat(String tidpel,
                                                         String tKdKolektif,
                                                         String ket,
                                                         String Atransaksiby,
                                                         String Atgl_transaksi,
                                                         String tNopel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "simpandatapelNotaTerpusat ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpandatapelNotaTerpusat", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpandatapelGIRALISASI(String tidpel,
                                                       String tKdKolektif,
                                                       String ket,
                                                       String Atransaksiby,
                                                       String Atgl_transaksi,
                                                       String tNopel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "simpandatapelGIRALISASI ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpandatapelGIRALISASI", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetDataValidasiKolektifNotaBuku(String tkodekolektif,
                                                               String tIdpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataValidasiKolektifNotaBuku ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataValidasiKolektifNotaBuku", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetDataValidasiKolektifKirim(String tkodekolektif,
                                                            String tIdpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataValidasiKolektifKirim ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataValidasiKolektifKirim", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetDataValidasiKolektifNotaTerpusat(String tkodekolektif,
                                                                   String tIdpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataValidasiKolektifNotaTerpusat ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataValidasiKolektifNotaTerpusat", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetDataValidasiKolektifGiralisasi(String tkodekolektif,
                                                                 String tIdpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataValidasiKolektifGiralisasi ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataValidasiKolektifGiralisasi", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> deletedatapelNotaTerpusat(String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "deletedatapelNotaTerpusat ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("deletedatapelNotaTerpusat", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> deletedatapelGiralisasi(String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "deletedatapelGiralisasi ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("deletedatapelGiralisasi", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> deletedatapel(String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "deletedatapel ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("deletedatapel", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> deletedatapelkirimkolektif(String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "deletedatapelkirimkolektif ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("deletedatapelkirimkolektif", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetNamaKolektifNotabuku(String tkodekolektif,
                                                       String nulll) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetNamaKolektifNotabuku ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetNamaKolektifNotabuku", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetNamaKolektifKirim(String tkodekolektif,
                                                    String nulll) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetNamaKolektifKirim ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetNamaKolektifKirim", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetNamaKolektifNotaTerpusat(String tkodekolektif,
                                                           String nulll) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetNamaKolektifNotaTerpusat ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetNamaKolektifNotaTerpusat", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetNamaKolektifGiralisasi(String tkodekolektif,
                                                         String nulll) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetNamaKolektifGiralisasi ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetNamaKolektifGiralisasi", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpandatakolektifNotaPusat(String tKdKolektif,
                                                           String tnamakolektif,
                                                           String tpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "simpandatakolektifNotaPusat ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpandatakolektifNotaPusat", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpandatakolektifNotaPusatunitup(String tKdKolektif,
                                                                 String tnamakolektif,
                                                                 String tpetugas,
                                                                 String tUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "simpandatakolektifNotaPusatunitup ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpandatakolektifNotaPusatunitup", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpandatakolektifGiralisasi(String tKdKolektif,
                                                            String tnamakolektif,
                                                            String tpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "simpandatakolektifGiralisasi ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpandatakolektifGiralisasi", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpandatakolektifGiralisasiunitup(String tKdKolektif,
                                                                  String tnamakolektif,
                                                                  String tpetugas,
                                                                  String tunitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "simpandatakolektifGiralisasiunitup ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpandatakolektifGiralisasiunitup", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpandatakolektifNotaBuku(String tKdKolektif,
                                                          String tnamakolektif,
                                                          String tpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "simpandatakolektifNotaBuku ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpandatakolektifNotaBuku", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> simpandatakolektifNotaBukuUnitup(String tKdKolektif,
                                                                String tnamakolektif,
                                                                String tpetugas,
                                                                String tunitup,
                                                                Integer tBebanKantor) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "simpandatakolektifNotaBukuUnitup ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpandatakolektifNotaBukuUnitup", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> simpandatakolektifKirim(String tKdKolektif,
                                                       String tnamakolektif,
                                                       String tpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "simpandatakolektifKirim ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpandatakolektifKirim", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> hapusdatakolektifNotaBuku(String tKdKolektif,
                                                         String tpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "hapusdatakolektifNotaBuku ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("hapusdatakolektifNotaBuku", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> hapusdatakolektifKirim(String tKdKolektif,
                                                      String tpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "hapusdatakolektifKirim ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("hapusdatakolektifKirim", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> hapusdatakolektifNotaTerpusat(String tKdKolektif,
                                                             String tpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "hapusdatakolektifNotaTerpusat ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("hapusdatakolektifNotaTerpusat", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> hapusdatakolektifGiralisasi(String tKdKolektif,
                                                           String tpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "hapusdatakolektifGiralisasi ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("hapusdatakolektifGiralisasi", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> tampilkodekolektifNotaBuku() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "tampilkodekolektifNotaBuku ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("tampilkodekolektifNotaBuku", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> tampilkodekolektifNotaBukuUnitup(String sUnitup,
                                                                Integer iBebanKantor) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "tampilkodekolektifNotaBukuUnitup ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("tampilkodekolektifNotaBukuUnitup", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> tampilkodekolektifKirim() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "tampilkodekolektifKirim ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("tampilkodekolektifKirim", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> tampilkodekolektifNotaPusat() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "tampilkodekolektifNotaPusat ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("tampilkodekolektifNotaPusat", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> tampilkodekolektifNotaPusatUnitup(String sUnitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "tampilkodekolektifNotaPusatUnitup ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("tampilkodekolektifNotaPusatUnitup", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> tampilkodekolektifGiralisasi() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "tampilkodekolektifGiralisasi ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("tampilkodekolektifGiralisasi", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> tampilkodekolektifGiralisasiUnitup(String sUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "tampilkodekolektifGiralisasiUnitup ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("tampilkodekolektifGiralisasiUnitup", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;      }


    //---------------------------------Upload Sorek
    @Override
    public Map<String, Object> CetakBeritaAcaraUpload(String unitUp,
                                                      String siklis,
                                                      String blth,
                                                      Date tempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "CetakBeritaAcaraUpload ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("CetakBeritaAcaraUpload", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> ambilstructureclsSorek() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilstructureclsSorek ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilstructureclsSorek", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> Server_executeSQLsWithConnection(String[] SQLs) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "Server_executeSQLsWithConnection ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("Server_executeSQLsWithConnection", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> DELETETEMPSOREK(String FileName,
                                               String unitup,
                                               String thbl,
                                               Date TglServer,
                                               String strGlobalKodePetugas,
                                               String KDKELOMPOK,
                                               String TGLJTTEMPO) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "DELETETEMPSOREK ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("DELETETEMPSOREK", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> iNSERTTEMPSOREK(Map<String, Object> tDTRANS,
                                               String TglServer,
                                               String strGlobalKodePetugas,
                                               String KDKELOMPOK,
                                               String TGLJTTEMPO) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "iNSERTTEMPSOREK ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("iNSERTTEMPSOREK", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> iNSERTTEMPSOREKup13(Map<String, Object> tDTRANS,
                                                   Date TglServer,
                                                   String strGlobalKodePetugas,
                                                   String KDKELOMPOK,
                                                   String TGLJTTEMPO) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "iNSERTTEMPSOREKup13 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("iNSERTTEMPSOREKup13", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    //----tambahan sumbar sorek oratoora
    @Override
    public Map<String, Object> INSERTTEMPSOREK_ORATOORA(String unitap,
                                                        String unitup,
                                                        String thbl,
                                                        String KDKELOMPOK,
                                                        String strglobalkodepetugas,
                                                        String tgljatuhtempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "INSERTTEMPSOREK_ORATOORA ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("INSERTTEMPSOREK_ORATOORA", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> INSERTTEMPSOREKSUSULAN_ORATOORA(String unitup,
                                                               String thbl,
                                                               String KDKELOMPOK,
                                                               String strglobalkodepetugas,
                                                               String tgljatuhtempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "INSERTTEMPSOREKSUSULAN_ORATOORA ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("INSERTTEMPSOREKSUSULAN_ORATOORA", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> iNSERTTEMPSOREKsusulan(Map<String, Object> tDTRANS,
                                                      Date TglServer,
                                                      String strGlobalKodePetugas,
                                                      String KDKELOMPOK,
                                                      String TGLJTTEMPO) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "iNSERTTEMPSOREKsusulan ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("iNSERTTEMPSOREKsusulan", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }
    //----end tambahan sumbar sorek oratoora

    //------------------bATAL TRANSAKSI
    @Override
    public Map<String, Object> BatalTransaksi_idpel(String Transaksi,
                                                    String tpel,
                                                    String vJenis,
                                                    String tKode,
                                                    String tPetugas,
                                                    String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "BatalTransaksi_idpel ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("BatalTransaksi_idpel", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    //----------------General TUL6 Waskit sorek
    @Override
    public Map<String, Object> ambilTanggalDatabase() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select sysdate from dual ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilTanggalDatabase", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilUnitUp() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select unitup kode_ranting_numerik from unitup order by unitup ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilUnitUp", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> ambilNamaUp(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select nama as nama_ranting from unitup where unitup = '" + unitUp + "' ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNamaUp", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> ambilNamaApdariUp(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select nama nama_cabang from unitap where unitap = ";
            sql = sql + " (";
            sql = sql + " select unitap as kode_cabang_numerik from unitup ";
            sql = sql + " where unitup = '" + unitUp + "' ";
            sql = sql + " )" ;           CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNamaApdariUp", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> ambilNamaKddariUp(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select nama nama_induk from unitupi where unitupi =";
            sql = sql + " (";
            sql = sql + " select unitupi as kode_induk_numerik from unitap where unitap = ";
            sql = sql + " (";
            sql = sql + " select unitap as kode_cabang_numerik from unitup ";
            sql = sql + " where unitup = '" + unitUp + "' " ;
            sql = sql + " )";
            sql = sql + " ) ";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNamaKddariUp", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilAlamatdariUp(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select alamat from unitup where unitup = '" + unitUp + "' ";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilAlamatdariUp", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> ambilKelompokSiklis(String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select distinct kodesiklis from tab_jatuhtempo ";
            sql += " where unitup = '" + unitup + "' ";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilKelompokSiklis", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    //----------------Waskit transaksi dan laporan

    @Override
    public Map<String, Object> sp_waskit_verifikasi(Integer nav) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "sp_waskit_verifikasi";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("sp_waskit_verifikasi", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilNomerTulVI01(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilNomerTulVI01";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNomerTulVI01", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

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
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilNomerTulVI01";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNomerTulVI01", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> AmbilTul601(String unitUp,
                                           String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "AmbilTul601";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601", lMapData);

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
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilDaftarPantauCetak601";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDaftarPantauCetak601", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    //--- Laporan VI-03
    //--- Added by H.Intellisys 27 June 2006
    @Override
    public Map<String, Object> ambilDaftarPantauCetak603(String unitUp,
                                                         Date awal,
                                                         Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilDaftarPantauCetak603";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDaftarPantauCetak603", lMapData);

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
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilRekapPantauCetak601";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilRekapPantauCetak601", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> ambilRekapPantauCetak603(String unitUp,
                                                        Date awal,
                                                        Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilRekapPantauCetak603";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilRekapPantauCetak603", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> ambilDaftar601Lunas(String unitUp,
                                                   Date awalPk,
                                                   Date akhirPk,
                                                   Date awalLns,
                                                   Date akhirLns) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilDaftar601Lunas";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDaftar601Lunas", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> ambilDaftar603Lunas(String unitUp,
                                                   Date awalPk,
                                                   Date akhirPk,
                                                   Date awalLns,
                                                   Date akhirLns) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilDaftar603Lunas";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDaftar603Lunas", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> ambilRekap601Lunas(String unitUp,
                                                  Date awalPk,
                                                  Date akhirPk,
                                                  Date awalLns,
                                                  Date akhirLns) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilRekap601Lunas";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilRekap601Lunas", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> ambilRekap603Lunas(String unitUp,
                                                  Date awalPk,
                                                  Date akhirPk,
                                                  Date awalLns,
                                                  Date akhirLns) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilRekap603Lunas";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilRekap603Lunas", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> ambilTulVIperIdPel(String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilTulVIperIdPel";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilTulVIperIdPel", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> ambilTulVI03perIdPel(String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilTulVI03perIdPel";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilTulVI03perIdPel", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> ambil601BelumLunas(String unitUp,
                                                  Date awal,
                                                  Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambil601BelumLunas";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambil601BelumLunas", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;      }


    @Override
    public Map<String, Object> ambil603BelumLunas(String unitUp,
                                                  Date awal,
                                                  Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambil603BelumLunas";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambil603BelumLunas", lMapData);

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
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "AmbilTul601CetakUlang";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601CetakUlang", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> AmbilTul601Lampiran(String unitUp,
                                                   Date tglPk,
                                                   Integer noTul) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "AmbilTul601Lampiran";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul601Lampiran", lMapData);

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
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilNomerTulVI03";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNomerTulVI03", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> AmbilTul603(Boolean is60hari,
                                           String unitUp,
                                           String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "AmbilTul603";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilTul603", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

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
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "  INSERT INTO TUL603 ";
            sql = sql + "  (no_603,no_601,No_60,UnitUP,ThBlRek,IdPelanggan, NoKontrak,NoKontrol, Nama,Alamat," ;
            sql = sql + "  No_TUL601,Tgl_TUL601, no_tul603, tgl_tul603, ThBlRek_akhir,Lembar_603,Tagihan_603)";
            sql = sql + "  VALUES( seq_tul603.nextval, ";
            sql = sql + "  '" + no_601 + "', '" + No_60 + "', '" + UnitUP + "', '" + ThBlRek + "', '" + IdPelanggan + "', ";
            sql = sql + "  '" + NoKontrak + "', '" + NoKontrol + "', ";
            sql = sql + "  '" + Nama + "', '" + Alamat + "', '" + NOtul601 + "', to_date('"; // + strTglTul601 + "','yyyymmdd'), '" + NOtul603 + "', sysdate, " ;
            sql = sql + "  '" + ThBlRek_akhir + "', '" + Lembar_603 + "', '" + Tagihan_603 + "')";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("insertTulVI03", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> ambilCetakKertasTulVI() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilCetakKertasTulVI";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilCetakKertasTulVI", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    //--- Pemutusan Penyambungan
    @Override
    public Map<String, Object> ambilDetailTul601(String strtgl,
                                                 String noTul) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilDetailTul601";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDetailTul601", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    //--- Pembongkaran
    //--- Added By H.Intellisys 27 June 2006
    @Override
    public Map<String, Object> ambilDetailTul603(String strtgl,
                                                 String noTul) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilDetailTul603";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDetailTul603", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;      }

    @Override
    public Map<String, Object> simpanPutus(Date tglPutus,
                                           String namaPutus,
                                           String lwbp,
                                           String wbp,
                                           String kvarh,
                                           Date tgl601,
                                           String no601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " update tul601 set";
            sql = sql + " tgl_pelaksanaan_putus = to_date('"; // + strTglPutus + "','yyyymmdd'), " ;
            sql = sql + " nama_putus = '" + namaPutus + "',";
            sql = sql + " stand_lwbp_putus = '" + lwbp + "',";
            sql = sql + " stand_wbp_putus = '" + wbp + "',";
            sql = sql + " stand_kvarh_putus = '" + kvarh + "'";
            sql = sql + " where ";
            sql = sql + " to_char(tgl_tul601,'yyyymmdd') = '"; // + strTgl601 + "'" ;
            sql = sql + " and no_tul601 = '" + no601 + "'";
            sql = sql + "  ";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanPutus", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> simpanBongkar(Date tglPutus,
                                             String namaPutus,
                                             String lwbp,
                                             String wbp,
                                             String kvarh,
                                             Date tgl601,
                                             String no601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " UPDATE TUL603 SET ";
            sql = sql + " TGL_PELAKSANAAN_BONGKAR = TO_DATE('"; // + strTglPutus + "','yyyymmdd'), " ;
            sql = sql + " NAMA_BONGKAR = '" + namaPutus + "', ";
            sql = sql + " STAND_LWBP_BONGKAR = '" + lwbp + "', ";
            sql = sql + " STAND_WBP_BONGKAR = '" + wbp + "', ";
            sql = sql + " STAND_KVARH_BONGKAR = '" + kvarh + "' ";
            sql = sql + " WHERE ";
            sql = sql + " TO_CHAR(tgl_tul603,'yyyymmdd') = '"; // + strTgl601 + "' " ;
            sql = sql + " AND no_tul603 = '" + no601 + "' " ;
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanBongkar", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> simpanSambung(Date tglsambung,
                                             String namasambung,
                                             String lwbp,
                                             String wbp,
                                             String kvarh,
                                             Date tgl601,
                                             String no601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

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
            sql = sql + "  ";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("simpanSambung", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    //--- Ambil Cetakan Tul VI-03
    @Override
    public Map<String, Object> AmbilBuatCetakTul603(String txtIdpel,
                                                    String unitUp,
                                                    String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "AmbilBuatCetakTul603";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilBuatCetakTul603", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> AmbilBuatCetakUlangTul603(String unitUp,
                                                         Date TglPk,
                                                         Integer noTul) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "AmbilBuatCetakUlangTul603";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilBuatCetakUlangTul603", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> cekBKSudahDibuat() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "cekBKSudahDibuat";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("cekBKSudahDibuat", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> login(String uname) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "login";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("login", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> getMasterUnit(String in_unitpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

//        try
//        {
//            Connection con = jdbcTemplate.getDataSource().getConnection();
//
//            String sql = "getMasterUnit";
//
//            CallableStatement cst = con.prepareCall(sql);
//
//            ResultSet rs = cst.executeQuery();
//
//            lMapData = CommonModule.convertResultsetToListStr(rs);
//
//            retValue.put("getMasterUnit", lMapData);
//
//            con.close();
//        } catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }

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

    @Override
    public Map<String, Object> ubahPassword(String uname,
                                            String pwd) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ubahPassword";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ubahPassword", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetViewIdPel_R2CICILAN(String tpel,
                                                      String vJenis,
                                                      String tBLTH,
                                                      String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewIdPel_R2CICILAN";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewIdPel_R2CICILAN", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> SetDataIdpel_R2cicilan(String tIDPel,
                                                      String tBlTh,
                                                      String tStatus,
                                                      Map<String, Object> dtrans,
                                                      String tTransaksiBy,
                                                      String tnorek,
                                                      String v_NOAGENDA,
                                                      Integer v_KALICICIL,
                                                      Double v_rptag,
                                                      Double v_rpbk) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpel_R2cicilan";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpel_R2cicilan", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    //=== KIRIM UNIT ===

    @Override
    public Map<String, Object> GetViewIdPel_23KIRIMUNIT(String tpel,
                                                        String vJenis,
                                                        String tBLTH,
                                                        String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewIdPel_23KIRIMUNIT";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewIdPel_23KIRIMUNIT", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    //=== KIRIM UNIT KOLEKTIF ===

    @Override
    public Map<String, Object> GetViewIdPel_23KIRIMUNITKolektif(String kodekolektif,
                                                                String vJenis,
                                                                String tBLTH,
                                                                String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewIdPel_23KIRIMUNITKolektif";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewIdPel_23KIRIMUNITKolektif", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> SaveTemp_23KIRIMUNIT(String tPetugas,
                                                    String tUnitKirim,
                                                    String tTglKirim) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SaveTemp_23KIRIMUNIT";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SaveTemp_23KIRIMUNIT", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> SetDataIdpel_23KIRIMUNIT(Map<String, Object> dtrans,
                                                        String tTransaksiBy,
                                                        String tKDTERIMA) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpel_23KIRIMUNIT";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpel_23KIRIMUNIT", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;      }


    @Override
    public Map<String, Object> PemantauanBatalTransaksi(String Transaksi,
                                                        String vpilihtglsama,
                                                        String vJenis,
                                                        String vPilihTgl,
                                                        String tUnitKJ,
                                                        String tUnitUP,
                                                        String tUnitAP,
                                                        String tTglmulai,
                                                        String tTglsampai,
                                                        String tKdpp,
                                                        String tKdPembayar,
                                                        String tKode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "PemantauanBatalTransaksi";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("PemantauanBatalTransaksi", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    ////=== END KIRIM UNIT ===

    //====TERIMA UNIT====

    @Override
    public Map<String, Object> GetViewIdPel_23TERIMAUNIT(String tpel,
                                                         String vJenis,
                                                         String tBLTH,
                                                         String tPetugas,
                                                         String tKdTerima) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewIdPel_23TERIMAUNIT";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewIdPel_23TERIMAUNIT", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> SetDataIdpel_23TERIMAUNIT(Map<String, Object> dtrans,
                                                         String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpel_23TERIMAUNIT";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpel_23TERIMAUNIT", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> SaveTemp_23TERIMAUNIT(String dtrans,
                                                     String tUnitUpDari,
                                                     String tUnitUpUntuk,
                                                     String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SaveTemp_23TERIMAUNIT";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SaveTemp_23TERIMAUNIT", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetVersion() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetVersion";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetVersion", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> DaftarUpdateVersi() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "(VERSI SIP3SINGLE.2008.06.10"; // + vbCrLf;
            String ver = "- Fitur IV-04 dengan TABLE BARU)";
            ver += "(VERSI SIP3SINGLE.2008.06.03"; // + vbCrLf;
            ver += "- Fitur Bayar di Muka)";
            ver += "(VERSI SIP3SINGLE.2008.06.02"; // + vbCrLf;
            ver += "- Cetak I-06 Rekening Suplisi)";
            ver += "(VERSI SIP3SINGLE.2008.07.09"; // + vbCrLf ;
            ver += "- 4-04 dengan kemampuan rekap ulang,modifikasi report 21 offline)";
            ver += "(VERSI SIP3SINGLE.2008.07.10"; // + vbCrLf;
            ver += "- perbaikan koreksi Jatelindo untuk daya besar)";
            ver += "(VERSI SIP3SINGLE.2008.07.14"; // + vbCrLf;
            ver += "- modifikasi report 22 ONLINE)";
            ver += "(VERSI SIP3SINGLE.2008.07.21"; // + vbCrLf ;
            ver += "- perbaikan report dan modul 4-04)";
            ver += "(VERSI SIP3SINGLE.2008.08.1"; // + vbCrLf;
            ver += "- report dobel bayar)";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("DaftarUpdateVersi", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    //====END TERIMA UNIT===


    @Override
    public Map<String, Object> SetImportUJL_File(Map<String, Object> dsPass) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "(VERSI SIP3SINGLE.2008.06.10"; // + vbCrLf;
            String ver = "- Fitur IV-04 dengan TABLE BARU)";
            ver += "(VERSI SIP3SINGLE.2008.06.03"; // + vbCrLf;
            ver += "- Fitur Bayar di Muka)";
            ver += "(VERSI SIP3SINGLE.2008.06.02"; // + vbCrLf;
            ver += "- Cetak I-06 Rekening Suplisi)";
            ver += "(VERSI SIP3SINGLE.2008.07.09"; // + vbCrLf ;
            ver += "- 4-04 dengan kemampuan rekap ulang,modifikasi report 21 offline)";
            ver += "(VERSI SIP3SINGLE.2008.07.10"; // + vbCrLf;
            ver += "- perbaikan koreksi Jatelindo untuk daya besar)";
            ver += "(VERSI SIP3SINGLE.2008.07.14"; // + vbCrLf;
            ver += "- modifikasi report 22 ONLINE)";
            ver += "(VERSI SIP3SINGLE.2008.07.21"; // + vbCrLf ;
            ver += "- perbaikan report dan modul 4-04)";
            ver += "(VERSI SIP3SINGLE.2008.08.1"; // + vbCrLf;
            ver += "- report dobel bayar)";
            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("DaftarUpdateVersi", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> SetImportUJL_Oracle() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetImportUJL_Oracle";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetImportUJL_Oracle", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> getDataHapusKolektif(Map<String, Object> dsFilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "getDataHapusKolektif";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getDataHapusKolektif", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> SetDataIdpel_21HapusGagalKolektif(String strDatarec,
                                                                 String strXMLschema,
                                                                 String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpel_21HapusGagalKolektif";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpel_21HapusGagalKolektif", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> setRekap(Map<String, Object> dsFilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "setRekap";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("setRekap", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> setLap_502_404(String sUnitup,
                                              String sBlthLap,
                                              String sKodePetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "setLap_502_404";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("setLap_502_404", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> setLap_404(String sBlthLap,
                                          String sKodePetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "setLap_404";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("setLap_404", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> getViewDppNonrek(String unitup,
                                                String sTglMulai,
                                                String sTglSelesai) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "getViewDppNonrek";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getViewDppNonrek", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> getViewDphNonrek(String unitup,
                                                String sTglMulai,
                                                String sTglSelesai) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "getViewDphNonrek";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getViewDphNonrek", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> setDownloadDppNonrek(String unitup,
                                                    String sTglMulai,
                                                    String sTglSelesai) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "setDownloadDppNonrek";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("setDownloadDppNonrek", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> SetKdGerak(String vKdGerak) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetKdGerak";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetKdGerak", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> setDownloadDphNonrek(String unitup,
                                                    String sTglMulai,
                                                    String sTglSelesai) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "setDownloadDphNonrek";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("setDownloadDphNonrek", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> getview212223Down(String TglMulai,
                                                 String TglSampai,
                                                 String Unitup,
                                                 String sView) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "getview212223Down";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getview212223Down", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetParamDownload(String NmTabel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetParamDownload";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetParamDownload", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetDowndLunasBlmLunas(String TglMulai,
                                                     String TglSampai,
                                                     String Unitup,
                                                     String Command,
                                                     String thblrep,
                                                     String kdkirim) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDowndLunasBlmLunas";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDowndLunasBlmLunas", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetBKxml(String vIDpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetBKxml";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetBKxml", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetTunggakan(String vIDpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetTunggakan";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetTunggakan", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetInfoPlgXML(String vIDpel,
                                             String tBLTH) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetInfoPlgXML";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetInfoPlgXML", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> setKirimDBPTemp(String sUnitup,
                                               String sIdpel,
                                               String sStatuskirim) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " ";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("setKirimDBPTemp", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> getTerimaDBPResp(String sIdpel,
                                                String sunitup,
                                                String sStatus_terima) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " ";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getTerimaDBPResp", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> SetSorektoDJBB(String unitap,
                                              String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " ";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetSorektoDJBB", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> SetSorektoDJBB_UP(String unitup,
                                                 String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " ";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetSorektoDJBB_UP", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> getMonitoringStatusPending(String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "getMonitoringStatusPending ";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getMonitoringStatusPending", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> getMonitoringUploadSorek(String unit,
                                                        String blth,
                                                        String satuan) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "getMonitoringUploadSorek ";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getMonitoringUploadSorek", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> SetBatalStatusPending(Integer lbrproses,
                                                     String tKirim,
                                                     String strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetBatalStatusPending ";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetBatalStatusPending", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> getunitap_user(String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "getunitap_user ";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getunitap_user", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    //" Region ====== Form Nota (23) ============ "
    @Override
    public Map<String, Object> GetDataKolektifNotaBukuUserid(String userId) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataKolektifNotaBukuUserid ";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataKolektifNotaBukuUserid", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetDataIdPelNotaBukuBatal(String tkodekolektif,
                                                         String tuserid) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataIdPelNotaBukuBatal ";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataIdPelNotaBukuBatal", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> Batal_23NotaKolektif(String _idpel,
                                                    String _blth,
                                                    String _transaksiid,
                                                    String _transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("Batal_23NotaKolektif", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }
    //End Region


    @Override
    public Map<String, Object> INSERTTEMPSOREK_ORATOORATEST(String unitup,
                                                            String thbl,
                                                            String KDKELOMPOK,
                                                            String strglobalkodepetugas,
                                                            String tgljatuhtempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "INSERTTEMPSOREK_ORATOORATEST";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("INSERTTEMPSOREK_ORATOORATEST", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetViewIdPel_21entriRestitusi(String tpel,
                                                             String vJenis) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewIdPel_21entriRestitusi";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewIdPel_21entriRestitusi", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> SetDataIdpel_21entriRestitusi(Integer lbrproses,
                                                             String tTransaksiBy,
                                                             String tTglBayar,
                                                             String tKDPEMBAYAR,
                                                             String strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpel_21entriRestitusi";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpel_21entriRestitusi", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> getTingkatSatker() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "getTingkatSatker";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getTingkatSatker", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetKotama(String vUnitap) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetKotama";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetKotama", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetSatker(String vUnitap,
                                         String vIDKotama) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetSatker";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetSatker", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetdataSatker(String vIDSatker) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetdataSatker";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetdataSatker", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetdataKotama(String vIDKotama) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetdataKotama";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetdataKotama", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> InsertKotama(String vIDSatker,
                                            String vUnitap,
                                            String vSetuju1Nama,
                                            String vSetuju1Kesatuan,
                                            String vSetuju1Jabatan,
                                            String vSetuju1Pangkat,
                                            String vSetuju1NIP, String vSetuju2Nama,
                                            String vSetuju2Jabatan,
                                            String vSetuju2Unit,
                                            String vSetuju2Kota,
                                            String vNamaKotama,
                                            String vSETUJU3NAMA, String vSETUJU3KESATUAN,
                                            String vSETUJU3JABATAN,
                                            String vSETUJU3PANGKAT,
                                            String vSETUJU3NIP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "InsertKotama";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("InsertKotama", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> UpdateKotama(String vIDSatker,
                                            String vUnitap,
                                            String vSetuju1Nama,
                                            String vSetuju1Kesatuan,
                                            String vSetuju1Jabatan,
                                            String vSetuju1Pangkat,
                                            String vSetuju1NIP,
                                            String vSetuju2Nama,
                                            String vSetuju2Jabatan,
                                            String vSetuju2Unit,
                                            String vSetuju2Kota,
                                            String vIdKotama,
                                            String vNamaKotama,
                                            String vSETUJU3NAMA,
                                            String vSETUJU3KESATUAN,
                                            String vSETUJU3JABATAN,
                                            String vSETUJU3PANGKAT,
                                            String vSETUJU3NIP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "UpdateKotama";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("UpdateKotama", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> InsertSatker(String vIdSatker,
                                            String vNoSurat,
                                            String vNoForm,
                                            String vUnitap,
                                            String vIDKotama,
                                            String vKesatuan,
                                            String vKodeSatker,
                                            String vAlamat,
                                            String vSetuju1Nama,
                                            String vSetuju1Kesatuan,
                                            String vSetuju1Jabatan,
                                            String vSetuju1Pangkat,
                                            String vSetuju1NIP,
                                            String vSetuju2Nama,
                                            String vSetuju2Kesatuan,
                                            String vSetuju2Jabatan,
                                            String vSetuju2Pangkat,
                                            String vSetuju2NIP,
                                            String vSetuju3Nama,
                                            String vSetuju3Jabatan,
                                            String vSetuju3Unit,
                                            String vSetuju3Kota) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "InsertSatker";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("InsertSatker", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> UpdateSatker(String vNoSurat,
                                            String vNoForm,
                                            String vIDKotama,
                                            String vKesatuan,
                                            String vKodeSatker,
                                            String vAlamat,
                                            String vSetuju1Nama,
                                            String vSetuju1Kesatuan,
                                            String vSetuju1Jabatan,
                                            String vSetuju1Pangkat,
                                            String vSetuju1NIP,
                                            String vSetuju2Nama,
                                            String vSetuju2Kesatuan,
                                            String vSetuju2Jabatan,
                                            String vSetuju2Pangkat,
                                            String vSetuju2NIP,
                                            String vSetuju3Nama,
                                            String vSetuju3Jabatan,
                                            String vSetuju3Unit,
                                            String vSetuju3Kota) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "UpdateSatker";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("UpdateSatker", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetNoForm(String vUnitap) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetNoForm";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetNoForm", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> getAnggotaSatket(String vNoForm) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "getAnggotaSatket";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getAnggotaSatket", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> getDataPelanggan(String vIdpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "getDataPelanggan";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getDataPelanggan", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> HapusAnggotaSatker(String vNoForm,
                                                  String vIDPel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "HapusAnggotaSatker";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("HapusAnggotaSatker", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> TambahAnggotaSatker(String vUnitap,
                                                   String vIDPel,
                                                   String vNoForm) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "TambahAnggotaSatker";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("TambahAnggotaSatker", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> cekSatker(String vNoForm,
                                         String vBlth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "cekSatker";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("cekSatker", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> SahSatker(String vNoForm,
                                         String vBlth,
                                         String SahBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SahSatker";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SahSatker", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetDataKoreksiBongkar(String vIdpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetDataKoreksiBongkar";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetDataKoreksiBongkar", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> InsertLogGagalDKRPBongkar(String in_unitup,
                                                         String in_idpel,
                                                         String in_blth,
                                                         String in_lwbp_bongkar,
                                                         String in_wbp_bongkar,
                                                         String in_kvarh_bongkar,
                                                         String in_notul603,
                                                         String in_tgltul603,
                                                         String in_petugas,
                                                         String in_no60,
                                                         String in_Log_Id,
                                                         String ErrMsg) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "InsertLogGagalDKRPBongkar";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("InsertLogGagalDKRPBongkar", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetLogDKRPBongkar(String _strtgl,
                                                 String _noTulAwal,
                                                 String _noTulAkhir,
                                                 String _unitup,
                                                 String _LogID) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetLogDKRPBongkar";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetLogDKRPBongkar", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> Create_LogId(String in_unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "Create_LogId";

            CallableStatement cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("Create_LogId", lMapData);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;
    }



    // Pemantauan Transaksi

//    List<Map<String,String>> GetViewRekap_11(String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP, String tUnitAP, String tTglmulai, String tTglsampai) {
//
//        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();
//        String mSQL = "", Sql = "";
//
//        if ( vJenis.toUpperCase() == "DAFTAR" ) {
////            Err = "TIDAK DAPAT DITAMPILKAN MELALUI MENU (HUB. ADMINISTRATOR)";
////            return;
//
//            Sql = "SELECT ' ' AS NOMOR, sysdate as TGLCETAK, ";
//            Sql = Sql + " TANGGAL, TGLBUKU, IDPEL, PETUGAS, KDGERAK, ";
//            Sql = Sql + " KOGOL, UNITUP, KDKELOMPOK, TARIP, DAYA, ";
//            Sql = Sql + " BLTH, KDPEMBPP, STATUS, NOREK, UNITKJ, ";
//            Sql = Sql + " KDINKASO, PEMDA, KDPPJ, KDPEMBAYARSIP3, NOPEL, ";
//            Sql = Sql + " NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, ";
//            Sql = Sql + " RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, ";
//            Sql = Sql + " KODEPOS, IDTARIP, KDPEMBTRF, ABONMETER, KDAYA, ";
//            Sql = Sql + " SUBKOGOL, FRT, FJN, TGLJTTEMPO, KDDK, ";
//            Sql = Sql + " TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, ";
//            Sql = Sql + " SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, ";
//            Sql = Sql + " FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, ";
//            Sql = Sql + " KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, ";
//            Sql = Sql + " RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, ";
//            Sql = Sql + " RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, ";
//            Sql = Sql + " RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, ";
//            Sql = Sql + " KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, ";
//            Sql = Sql + " RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, ";
//            Sql = Sql + " RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, ";
//            Sql = Sql + " RPSELISIH, FLAGSOPP, JNSMUT, BLTHMUT, KDMUT, ";
//            Sql = Sql + " TGLNYALA, NOGARDU, NOTIANG, NOMETER, DAYABULK, ";
//            Sql = Sql + " RPBP, RPUJL ";
//
//            mSQL = Sql + " FROM VIEW_PANTAU_11_DFT_B ";
//            mSQL = mSQL + " WHERE ";
//            if ( vPilihTgl.toUpperCase() == "PEMBUKUAN" ) {
//                mSQL = mSQL + "  TGLBUKU  >= '" + tTglmulai + "' ";
//                mSQL = mSQL + " AND TGLBUKU  <= '" + tTglsampai + "' ";
//            } else if ( vPilihTgl.toUpperCase() == "TRANSAKSI" ) {
//                mSQL = mSQL + "  TANGGAL  >= '" + tTglmulai + "' ";
//                mSQL = mSQL + " AND TANGGAL  <= '" + tTglsampai + "' ";
//            }
//            if ( tUnitUP.toUpperCase() == "ALL" ) {
//                mSQL = mSQL + " AND UNITUP IN(SELECT UNITUP FROM UNITUP WHERE UNITAP = RTRIM(LTRIM('" + tUnitAP + "'))) ";
//            } else {
//                mSQL = mSQL + " AND UNITUP  = RTRIM(LTRIM('" + tUnitUP + "')) ";
//            }
//            if ( vPilihTgl.toUpperCase() == "PEMBUKUAN" ) {
//                mSQL = mSQL + " ORDER BY KDGERAK,UNITUP,TGLBUKU,TANGGAL,IDPEL, KOGOL,KDPEMBPP,STATUS ";
//            } else if ( vPilihTgl.toUpperCase() == "TRANSAKSI" ) {
//                mSQL = mSQL + " ORDER BY KDGERAK,UNITUP,TANGGAL,TGLBUKU,IDPEL, KOGOL,KDPEMBPP,STATUS ";
//            }
//
//
//        } else if ( vJenis.toUpperCase() == "REKAP" ) {
//            mSQL = "SELECT ' ' AS NOMOR, sysdate as TGLCETAK, ";
//            mSQL = mSQL + " TANGGAL, TGLBUKU, KDGERAK, UNITUP, BLTH, KOGOL, KDPEMBPP, STATUS, ";
//            mSQL = mSQL + "   SUM(LEMBAR) AS LEMBAR,SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3 ";
//
//            mSQL = mSQL + " FROM VIEW_PANTAU_11_REKAP_T ";
//            mSQL = mSQL + " WHERE ";
//            if ( vPilihTgl.toUpperCase() == "PEMBUKUAN" ) {
//                mSQL = mSQL + "   TGLBUKU  >= '" + tTglmulai + "' ";
//                mSQL = mSQL + " AND TGLBUKU  <= '" + tTglsampai + "' ";
//            } else if ( vPilihTgl.toUpperCase() == "TRANSAKSI" ) {
//                mSQL = mSQL + "   TANGGAL  >= '" + tTglmulai + "' ";
//                mSQL = mSQL + " AND TANGGAL  <= '" + tTglsampai + "' ";
//            }
//            if ( tUnitUP.toUpperCase() == "ALL" ) {
//                mSQL = mSQL + " AND UNITUP IN(SELECT UNITUP FROM UNITUP WHERE UNITAP = RTRIM(LTRIM('" + tUnitAP + "'))) ";
//            } else {
//                mSQL = mSQL + " AND UNITUP  = RTRIM(LTRIM('" + tUnitUP + "')) ";
//            }
//            mSQL = mSQL + " GROUP BY KDGERAK,UNITUP,TANGGAL,TGLBUKU,BLTH,KOGOL,KDPEMBPP,STATUS ";
//
//            if ( vPilihTgl.toUpperCase() == "PEMBUKUAN" ) {
//                mSQL = mSQL + " ORDER BY KDGERAK,UNITUP,TGLBUKU,TANGGAL,BLTH,KOGOL,KDPEMBPP,STATUS ";
//            } else if ( vPilihTgl.toUpperCase() == "TRANSAKSI" ) {
//                mSQL = mSQL + " ORDER BY KDGERAK,UNITUP,TANGGAL,TGLBUKU,BLTH,KOGOL,KDPEMBPP,STATUS ";
//            }
//        }
//
//        try {
//
//            Connection con = jdbcTemplate.getDataSource().getConnection();
//
//            CallableStatement cst;
//        }
//
//        return lMapData;
//    }
}
