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
public class clsBatalTransaksi_view {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> GetIdpel(String vJenis,
                                        String tPEL) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql = "";

            if (vJenis == "IdPel") {
                sql = " select IDPEL from dil where IDPEL = '" + tPEL + "'";
            } else if (vJenis == "NoPel") {
                sql = " select IDPEL from dil where NOPEL = '" + tPEL + "'";
            }

            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData.get(0).get(0));
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("IdPelanggan tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> ambilTanggalHariIni() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql = "";

            sql = " SELECT sysdate FROM dual";

            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData.get(0).get(0));
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("anggal Server tidak didapatkan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> BatalTransaksi_idpel(String Transaksi,
                                                    String tpel,
                                                    String vJenis,
                                                    String tKode,
                                                    String tPetugas,
                                                    String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        switch (Transaksi.trim()) {
            case "11 Rekening Baru":
                break;
            default:
                break;
        }

        return null;
    }

    public Map<String, Object> GetViewIdPel_12ABCG(String tpel,
                                                   String vJenis,
                                                   String tPetugas,
                                                   String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            wsReturn = GetIdpel(vJenis, tpel);

            if (wsReturn.get("wsByRefError") != "") {
                throw new Exception(wsReturn.get("wsByRefError").toString());
            }

            tpel = wsReturn.get("wsReturn").toString();

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI,KOREKSIBY, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql = sql + " ,TRANSAKSIID FROM VIEW_BATAL12ABCG_TAMPILFORM ";
            sql = sql + " where TGKOREKSI = '" + tblthbuku + "'";
            sql = sql + "  order by IDPEL,blth asc";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewIdPel_12DSuplisi(String tpel,
                                                   String vJenis,
                                                   String tPetugas,
                                                   String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            wsReturn = GetIdpel(vJenis, tpel);

            if (wsReturn.get("wsByRefError") != "") {
                throw new Exception(wsReturn.get("wsByRefError").toString());
            }

            tpel = wsReturn.get("wsReturn").toString();

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI,KOREKSIBY, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql = sql + " ,TRANSAKSIID FROM VIEW_BATAL12D_SUPLISI ";
            sql = sql + " where TGKOREKSI = '" + tblthbuku + "'";
            sql = sql + "  order by IDPEL,blth asc";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewIdPel_12DRestitusi(String tpel,
                                                   String vJenis,
                                                   String tPetugas,
                                                   String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            wsReturn = GetIdpel(vJenis, tpel);

            if (wsReturn.get("wsByRefError") != "") {
                throw new Exception(wsReturn.get("wsByRefError").toString());
            }

            tpel = wsReturn.get("wsReturn").toString();

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI,KOREKSIBY, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql = sql + " ,TRANSAKSIID FROM VIEW_BATAL12D_RESTITUSI ";
            sql = sql + " where TGKOREKSI = '" + tblthbuku + "'";
            sql = sql + "  order by IDPEL,blth asc";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewIdPel_12DSuplisiRestitusi(String tpel,
                                                   String vJenis,
                                                   String tPetugas,
                                                   String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            wsReturn = GetIdpel(vJenis, tpel);

            if (wsReturn.get("wsByRefError") != "") {
                throw new Exception(wsReturn.get("wsByRefError").toString());
            }

            tpel = wsReturn.get("wsReturn").toString();

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI,KOREKSIBY, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql = sql + " ,TRANSAKSIID FROM view_batal12d_suplisirestitusi ";
            sql = sql + " where TGKOREKSI = '" + tblthbuku + "'";
            sql = sql + "  order by IDPEL,blth asc";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewIdPel_21Suplisi(String tpel,
                                                   String vJenis,
                                                   String tPetugas,
                                                   String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            wsReturn = GetIdpel(vJenis, tpel);

            if (wsReturn.get("wsByRefError") != "") {
                throw new Exception(wsReturn.get("wsByRefError").toString());
            }

            tpel = wsReturn.get("wsReturn").toString();

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI,KOREKSIBY, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql = sql + " ,TRANSAKSIID FROM VIEW_BATAL21_SUPLISI ";
            sql = sql + " where TGKOREKSI = '" + tblthbuku + "'";
            sql = sql + "  order by IDPEL,blth asc";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewIdPel_13(String tpel,
                                                   String vJenis,
                                                   String tPetugas,
                                                   String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            wsReturn = GetIdpel(vJenis, tpel);

            if (wsReturn.get("wsByRefError") != "") {
                throw new Exception(wsReturn.get("wsByRefError").toString());
            }

            tpel = wsReturn.get("wsReturn").toString();

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI,KOREKSIBY, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql = sql + " ,TRANSAKSIID FROM VIEW_BATAL13_TAMPILFORM ";
            sql = sql + " where to_char(UPLOADTIME,'yyyymmdd') = '" + tblthbuku + "'";
            sql = sql + "  order by IDPEL,blth asc";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewIdPel_21(String tpel,
                                                   String vJenis,
                                                   String tPetugas,
                                                   String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            wsReturn = GetIdpel(vJenis, tpel);

            if (wsReturn.get("wsByRefError") != "") {
                throw new Exception(wsReturn.get("wsByRefError").toString());
            }

            tpel = wsReturn.get("wsReturn").toString();

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI,KOREKSIBY, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql = sql + " ,TRANSAKSIID FROM VIEW_BATAL21_TAMPILFORM ";
            sql = sql + " where TGLBAYAR = '" + tblthbuku + "'";
            sql = sql + "  order by IDPEL,blth asc";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewIdPel_23Nota(String tpel,
                                                   String vJenis,
                                                   String tPetugas,
                                                   String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            wsReturn = GetIdpel(vJenis, tpel);

            if (wsReturn.get("wsByRefError") != "") {
                throw new Exception(wsReturn.get("wsByRefError").toString());
            }

            tpel = wsReturn.get("wsReturn").toString();

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI,KOREKSIBY, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql = sql + " ,TRANSAKSIID FROM VIEW_BATAL23NOTA_TAMPILFORM ";
            sql = sql + " where TGLBAYAR = '" + tblthbuku + "'";
            sql = sql + "  order by IDPEL,blth asc";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewIdPel_23KIRIMUNIT(String tpel,
                                                   String vJenis,
                                                   String tPetugas,
                                                   String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            wsReturn = GetIdpel(vJenis, tpel);

            if (wsReturn.get("wsByRefError") != "") {
                throw new Exception(wsReturn.get("wsByRefError").toString());
            }

            tpel = wsReturn.get("wsReturn").toString();

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY,";
            sql = sql + "  KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, ";
            sql = sql + "  STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, ";
            sql = sql + " NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, ";
            sql = sql + " IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, ";
            sql = sql + " FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, ";
            sql = sql + " SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, ";
            sql = sql + " FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, ";
            sql = sql + " RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, ";
            sql = sql + " RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, ";
            sql = sql + " RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, ";
            sql = sql + " RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, ";
            sql = sql + " NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql = sql + " ,TRANSAKSIID,TGKOREKSI,KOREKSIBY ";
            sql = sql + " FROM VIEW_BATAL23KIRIMUNIT_TF";
            sql = sql + " where TGLBAYAR = '" + tblthbuku + "'";
            sql = sql + "  order by IDPEL,blth asc";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewIdPel_23TERIMAUNIT(String tpel,
                                                   String vJenis,
                                                   String tPetugas,
                                                   String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            wsReturn = GetIdpel(vJenis, tpel);

            if (wsReturn.get("wsByRefError") != "") {
                throw new Exception(wsReturn.get("wsByRefError").toString());
            }

            tpel = wsReturn.get("wsReturn").toString();

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY,";
            sql = sql + "  KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, ";
            sql = sql + "  STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, ";
            sql = sql + " NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, ";
            sql = sql + " IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, ";
            sql = sql + " FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, ";
            sql = sql + " SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, ";
            sql = sql + " FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, ";
            sql = sql + " RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, ";
            sql = sql + " RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, ";
            sql = sql + " RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, ";
            sql = sql + " RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, ";
            sql = sql + " NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql = sql + " ,TRANSAKSIID,TGKOREKSI,KOREKSIBY ";
            sql = sql + " FROM VIEW_BATAL23TERIMAUNIT_TF";
            sql = sql + " where TGLBAYAR = '" + tblthbuku + "'";
            sql = sql + "  order by IDPEL,blth asc";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewIdPel_23DLT(String tpel,
                                                   String vJenis,
                                                   String tPetugas,
                                                   String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            wsReturn = GetIdpel(vJenis, tpel);

            if (wsReturn.get("wsByRefError") != "") {
                throw new Exception(wsReturn.get("wsByRefError").toString());
            }

            tpel = wsReturn.get("wsReturn").toString();

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI,KOREKSIBY, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql = sql + " ,TRANSAKSIID FROM VIEW_BATAL23DLT_TAMPILFORM ";
            sql = sql + " where TGLBAYAR = '" + tblthbuku + "'";
            sql = sql + "  order by IDPEL,blth asc";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewIdPel_31(String tpel,
                                                   String vJenis,
                                                   String tPetugas,
                                                   String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            wsReturn = GetIdpel(vJenis, tpel);

            if (wsReturn.get("wsByRefError") != "") {
                throw new Exception(wsReturn.get("wsByRefError").toString());
            }

            tpel = wsReturn.get("wsReturn").toString();

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI,KOREKSIBY, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql = sql + " ,TRANSAKSIID FROM VIEW_BATAL31_TAMPILFORM ";
            sql = sql + " where TGLBAYAR = '" + tblthbuku + "'";
            sql = sql + "  order by IDPEL,blth asc";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewIdPel_41(String tpel,
                                                   String vJenis,
                                                   String tPetugas,
                                                   String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            wsReturn = GetIdpel(vJenis, tpel);

            if (wsReturn.get("wsByRefError") != "") {
                throw new Exception(wsReturn.get("wsByRefError").toString());
            }

            tpel = wsReturn.get("wsReturn").toString();

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI,KOREKSIBY, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql = sql + " ,TRANSAKSIID FROM VIEW_BATAL41_TAMPILFORM ";
            sql = sql + " where TGLBAYAR = '" + tblthbuku + "'";
            sql = sql + "  order by IDPEL,blth asc";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewIdPel_32(String tpel,
                                                   String vJenis,
                                                   String tPetugas,
                                                   String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            wsReturn = GetIdpel(vJenis, tpel);

            if (wsReturn.get("wsByRefError") != "") {
                throw new Exception(wsReturn.get("wsByRefError").toString());
            }

            tpel = wsReturn.get("wsReturn").toString();

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tPetugas);
            cst.execute();

            sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI,KOREKSIBY, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql = sql + " ,TRANSAKSIID FROM VIEW_BATAL32_TAMPILFORM ";
            sql = sql + " where TGLBAYAR = '" + tblthbuku + "'";
            sql = sql + "  order by IDPEL,blth asc";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewKODEPP(String vJenis,
                                                   String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "SELECT UNITKJ, UNITUP, KODEPP, NAMAPP FROM PAYMENTPOINT";
            sql += " WHERE PKSFROMDATE <= TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD'),'YYYYMMDD') AND PKSENDDATE >= TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD'),'YYYYMMDD')";
            if ( vJenis == "MANUAL" ) {
                sql += " AND JENISPP = 'MANUAL'";
            } else if ( vJenis == "OFFLINE" ) {
                sql += " AND JENISPP = 'OFFLINE'";
            } else if ( vJenis == "ONLINE" ) {
                sql += " AND JENISPP = 'ONLINE'";
            }
            sql += " and unitup = (select unitup from petugas ";
            sql += " where kodepetugas = '" + tPetugas + "')";
            sql += " ORDER BY KODEPP";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("KodePP tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewKODEKOLEKTIF23NOTA() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "SELECT KODEKOLEKTIF, NAMAKOLEKTIF FROM KODEKOLEKTIF23NOTA";
            sql += " WHERE TGLTHRU IS NULL ORDER BY KODEKOLEKTIF";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("KodePP tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewKODEKELOMPOK(String tTHBL,
                                             String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "SELECT UNITUP, KODESIKLIS, PERIODE,JATUHTEMPO,THBL,BK1,BK2,BK3 FROM TAB_JATUHTEMPO";
            sql += " WHERE THBL = '" + tTHBL + "'";
            sql += " and unitup = (select unitup from petugas ";
            sql += " where kodepetugas = '" + tPetugas + "')";
            sql += " ORDER BY KODESIKLIS";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("KodeKelompok tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewKODEKELOMPOKUNIT(String tTHBL,
                                             String tUNIT) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "SELECT UNITUP, KODESIKLIS, PERIODE,JATUHTEMPO,THBL,BK1,BK2,BK3 FROM TAB_JATUHTEMPO";
            sql += " WHERE THBL = '" + tTHBL + "'";
            sql += " and unitup = '" + tUNIT + "'";
            sql += " ORDER BY KODESIKLIS";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("KodeKelompok tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewKODERR(String tUNIT) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "SELECT UNITUP AS KODE_RANTING_NUMERIK, NAMA AS NAMA_RANTING,SATUAN AS RANTING_RAYON";
            sql += " FROM UNITUP ";
            //sql += " where unitup = '" + tUNIT + "'";
            sql += " ORDER BY UNITUP";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("Kodeunitup tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetViewKODEKOREKSI() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Map<String, Object> wsReturn = new HashMap<>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "SELECT KDKOREKSI, KD,DESKRIPSI FROM KODEKOREKSI";
            sql += " ORDER BY KD";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() >= 0) {
                retValue.put("wsReturn", lMapData);
                retValue.put("wsByRefError", "");

            } else {
                throw new Exception("KodeKoreksi tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }
}
