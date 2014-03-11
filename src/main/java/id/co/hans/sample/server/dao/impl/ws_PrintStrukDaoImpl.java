package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.cls_CetakUlang;
import id.co.hans.sample.server.dao.ws_PrintStrukDao;
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
public class ws_PrintStrukDaoImpl implements ws_PrintStrukDao {
    public static final Log log = LogFactory.getLog(ws_PrintStrukDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> cetakRekg12(String tTgKoreksi, String tIdpel, String tBlth, String tNorek) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            ResultSet rs;
            String sql = "";

            if (tIdpel.substring(0,2) == "52") {
                sql = "{ call PARAMETERVIEW.SetTGKOREKSI(?) }";
                cst = con.prepareCall(sql);
                cst.setString(1, tTgKoreksi);
                cst.execute();
                sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
                cst = con.prepareCall(sql);
                cst.setString(1, tIdpel);
                cst.execute();

                sql = " select BLTH, IDPEL, NOPEL, KDGERAKMASUK, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, UNITUP, KOREKSIBY, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA ";
                sql += " ,BPAKAI1,BPAKAI2,BPAKAI3,BKVAR ";
                sql += " select BLTH, IDPEL, NOPEL, KDGERAKMASUK, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, UNITUP, KOREKSIBY, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP,SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, ";
                sql += " CETAK, PERIODE, BPAKAI1, BPAKAI2, BPAKAI3, BKVAR, PESAN, TELPPENGADUAN, TGLCETAK,IDPEL AS NO_PELANGGAN";
                sql += " from VIEW_CETAKREKG_12ABCG_TFORM ";
                sql += " where ";
                sql += " idpel = '" + tIdpel + "' ";
                sql += " and tgkoreksi = '" + tTgKoreksi + "' ";
                sql += " and kdpembpp = 'R1' ";
                sql += " and kdgerakmasuk = '12' ";
                sql += " and blth = '" + tBlth + "' ";
                sql += " and norek = '" + tNorek + "' ";
            } else {
                sql = "{ call PARAMETERVIEW.SetBLTH(?) }";
                cst = con.prepareCall(sql);
                cst.setString(1, tBlth);
                cst.execute();
                sql = "{ call PARAMETERVIEW.SetTGKOREKSI(?) }";
                cst = con.prepareCall(sql);
                cst.setString(1, tTgKoreksi);
                cst.execute();
                sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
                cst = con.prepareCall(sql);
                cst.setString(1, tIdpel);
                cst.execute();

                sql = " SELECT * ";
                sql += " from VIEW_CETAK303_KOREKSIBARU ";
            }

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
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

    @Override
    public Map<String, Object> cetakRekg41(String tTgKoreksi, String tIdpel, String tBlth, String tNorek) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetTGKOREKSI(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tTgKoreksi);
            cst.execute();
            sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tIdpel);
            cst.execute();

            sql = " select BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, KOREKSIBY ";
            sql += " ,BPAKAI1,BPAKAI2,BPAKAI3,BKVAR ";
            sql += " from VIEW_CETAKREKG_41_TFORM ";
            sql += " where ";
            sql += " idpel = '" + tIdpel + "' ";
            sql += " and tgkoreksi = '" + tTgKoreksi + "' ";
            sql += " and kdpembpp = 'R1' ";
            sql += " and kdgerakmasuk = '41' ";
            sql += " and blth = '" + tBlth + "' ";
            sql += " and norek = '" + tNorek + "' ";

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

    @Override
    public Map<String, Object> cetakRekg12D(String tKodePetugas,
                                     String tIDPEL,
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
            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tKodePetugas);
            cst.execute();

            sql = " SELECT * ";
            sql += " from VIEW_CETAK303_12D ";

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

    @Override
    public Map<String, Object> cetakRekg23(String tTglbayar, String tIdpel, String tBlth, String tNorek) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetTGLBAYAR(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tTglbayar);
            cst.execute();
            sql = "{ call PARAMETERVIEW.SetIDPEL(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tIdpel);
            cst.execute();

            sql = " select BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql += " ,BPAKAI1,BPAKAI2,BPAKAI3,BKVAR ";
            sql += " from VIEW_CETAKREKG_233132_TFORM ";
            sql += " where ";
            sql += " idpel = '" + tIdpel + "' ";
            sql += " and tglbayar = '" + tTglbayar + "' ";
            sql += " and kdpembpp = 'R1' ";
            sql += " and kdgerakkeluar = '23' ";
            sql += " and blth = '" + tBlth + "' ";
            sql += " and norek = '" + tNorek + "' ";

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

    @Override
    public Map<String, Object> cetakRekg31(String tTglbayar, String tIdpel, String tBlth, String tNorek) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetTGLBAYAR(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tTglbayar);
            cst.execute();
            sql = "{ call PARAMETERVIEW.SetIDPEL(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tIdpel);
            cst.execute();

            sql = " select BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql += " ,BPAKAI1,BPAKAI2,BPAKAI3,BKVAR ";
            sql += " from VIEW_CETAKREKG_233132_TFORM ";
            sql += " where ";
            sql += " idpel = '" + tIdpel + "' ";
            sql += " and tglbayar = '" + tTglbayar + "' ";
            sql += " and kdpembpp = 'R1' ";
            sql += " and kdgerakkeluar = '31' ";
            sql += " and blth = '" + tBlth + "' ";
            sql += " and norek = '" + tNorek + "' ";

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

    @Override
    public Map<String, Object> cetakRekg32(String tTglbayar, String tIdpel, String tBlth, String tNorek) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetTGLBAYAR(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tTglbayar);
            cst.execute();
            sql = "{ call PARAMETERVIEW.SetIDPEL(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tIdpel);
            cst.execute();

            sql = " select BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql += " ,BPAKAI1,BPAKAI2,BPAKAI3,BKVAR ";
            sql += " from VIEW_CETAKREKG_233132_TFORM ";
            sql += " where ";
            sql += " idpel = '" + tIdpel + "' ";
            sql += " and tglbayar = '" + tTglbayar + "' ";
            sql += " and kdpembpp = 'R1' ";
            sql += " and kdgerakkeluar = '32' ";
            sql += " and blth = '" + tBlth + "' ";
            sql += " and norek = '" + tNorek + "' ";

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


    @Override
    public Map<String, Object> cetakRekg21(String tTglbayar, String tIdpel, String tBlth, String tNorek) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetTGLBAYAR(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tTglbayar);
            cst.execute();
            sql = "{ call PARAMETERVIEW.SetIDPEL(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tIdpel);
            cst.execute();

            sql = " select BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql += " ,BPAKAI1,BPAKAI2,BPAKAI3,BKVAR ";
            sql += " from VIEW_CETAKREKG_21_TFORM ";
            sql += " where ";
            sql += " idpel = '" + tIdpel + "' ";
            sql += " and tglbayar = '" + tTglbayar + "' ";
            sql += " and kdpembpp = 'R1' ";
            sql += " and kdgerakkeluar = '21' ";
            sql += " and blth = '" + tBlth + "' ";
            sql += " and norek = '" + tNorek + "' ";

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


    @Override
    public Map<String, Object> cetakRekg21Giralisasi(String tTglBayar,
                                              String tKDPP,
                                              String tKodeGiral) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetKODEPP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tKDPP);
            cst.execute();
            sql = "{ call PARAMETERVIEW.SetTGLBAYAR(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tTglBayar);
            cst.execute();
            sql = "{ call PARAMETERVIEW.SetKODEKOLEKTIF(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tKodeGiral);
            cst.execute();

            sql = "SELECT * ";
            sql += " from VIEW_CETAK303_LUNASGIRAL ";

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

    @Override
    public Map<String, Object> cetakRekg21NotaBuku(String tKodePetugas,
                                            String tKodeNota, String tUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetKODEKOLEKTIF(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tKodeNota);
            cst.execute();
            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tKodePetugas);
            cst.execute();
            sql = "{ call PARAMETERVIEW.SetUNITUP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tUnitup);
            cst.execute();

            sql = "SELECT * ";
            sql += " from VIEW_CETAK303_LUNASNOTA ";

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


    @Override
    public Map<String, Object> cetakRekg21NotaTerpusat(String tKodePetugas,
                                                String tKodeNota,
                                                String tUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetKODEKOLEKTIF(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tKodeNota);
            cst.execute();
            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tKodePetugas);
            cst.execute();
            sql = "{ call PARAMETERVIEW.SetUNITUP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tUnitup);
            cst.execute();

            sql = "SELECT * ";
            sql += " from VIEW_CETAK303_LUNASTERPUSAT ";

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


    @Override
    public Map<String, Object> cetakRekg21EntriLunas(String tKodePetugas,
                                              String tIDPEL,
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
            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tKodePetugas);
            cst.execute();

            sql = "SELECT * ";
            sql += " from VIEW_CETAK303_LUNASENTRI ";

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

    @Override
    public Map<String, Object> getCetul_21Giralisasi(String strPetugas,
                                              String sKodeKolektif, String sTglLunas,
                                              String sKDPP) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_CetakUlang cCetul = new cls_CetakUlang();
        retValue = cCetul.getCetul_21Giralisasi(strPetugas, sKodeKolektif, sTglLunas, sKDPP);

        return retValue;
    }

    @Override
    public Map<String, Object> SetCetul_21Giralisasi(Map<String, Object> dsTrans) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_CetakUlang cCetul = new cls_CetakUlang();
        retValue = cCetul.SetCetul_21Giralisasi(dsTrans);

        return retValue;
    }

    @Override
    public Map<String, Object> getCetul_23NotaBuku(String strPetugas,
                                                   String sKodeKolektif,
                                                   String sTglLunas,
                                                   String tUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_CetakUlang cCetul = new cls_CetakUlang();
        retValue = cCetul.getCetul_23NotaBuku(strPetugas, sKodeKolektif, sTglLunas, tUnitup);

        return retValue;
    }

    @Override
    public Map<String, Object> SetCetul_23NotaBuku(Map<String, Object> dsTrans) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_CetakUlang cCetul = new cls_CetakUlang();
        retValue = cCetul.SetCetul_23NotaBuku(dsTrans);

        return retValue;
    }


    @Override
    public Map<String, Object> getCetul_23Terpusat(String strPetugas,
                                            String sKodeKolektif, String sTglLunas,
                                            String sUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_CetakUlang cCetul = new cls_CetakUlang();
        retValue = cCetul.getCetul_23Terpusat(strPetugas, sKodeKolektif, sTglLunas, sUnitup);

        return retValue;
    }

    @Override
    public Map<String, Object> SetCetul_23Perpusat(Map<String, Object> dsTrans) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_CetakUlang cCetul = new cls_CetakUlang();
        retValue = cCetul.SetCetul_23Terpusat(dsTrans);

        return retValue;
    }
}
