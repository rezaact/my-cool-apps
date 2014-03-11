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
public class clsJatelicon {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Map<String, Object> getPelangganLunas(String sIdpel,
                                               String sBlth) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            cls_Aplikasi cCekBK = new cls_Aplikasi();
            Map<String, Object> retCCekBK = cCekBK.cekBKSudahDibuat();

            if (retCCekBK.get("wsReturn") == false) {
                throw new Exception("Database sedang melakukan proses rekap,transaksi belum diijinkan !");
            }

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIDPEL(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, sIdpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetBLTH(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, sBlth);
            cst.execute();

            sql = "SELECT * FROM VIEW_KOREKSI_JATELINDO";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Data kosong.");
            }

            retValue.put("wsReturn", true);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> getPelangganKoreksi(String tIdpel,
                                               String tBlth,
                                               String sKdKoreksi) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            cls_Aplikasi cCekBK = new cls_Aplikasi();
            Map<String, Object> retCCekBK = cCekBK.cekBKSudahDibuat();

            if (retCCekBK.get("wsReturn") == false) {
                throw new Exception("Database sedang melakukan proses rekap,transaksi belum diijinkan !");
            }


            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PARAMETERVIEW.SetIDPEL(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tIdpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetBLTH(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tBlth);
            cst.execute();

            if (sKdKoreksi == "A" || sKdKoreksi == "B" || sKdKoreksi == "C" || sKdKoreksi == "G") {
                sql = "SELECT BLTH, IDPEL, NOPEL,  KDKOREKSI, TGKOREKSI, STATUS,  PEMDA, NAMA, PNJ, NAMAPNJ,";
                sql = sql + " NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, ";
                sql = sql + " TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, ";
                sql = sql + " UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, ";
                sql = sql + " SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, ";
                sql = sql + " KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, ";
                sql = sql + " RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, ";
                sql = sql + " RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, ";
                sql = sql + " RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, ";
                sql = sql + " RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, ";
                sql = sql + " JNSMUT, BLTHMUT,  KDMUT,  TGLNYALA,  NOGARDU,  NOTIANG,  NOMETER";
                sql = sql + " ,RPINSENTIF_KVA, RPINSENTIF_KWH, RPDISINSENTIF_KVA, RPDISINSENTIF_KWH";
                sql = sql + " FROM VIEW_12ABC_JATELINDO order by IDPEL,blth asc";
            } else if (sKdKoreksi == "D") {
                sql = "SELECT BLTH, IDPEL, NOPEL,  KDKOREKSI, TGKOREKSI, STATUS,  PEMDA, NAMA, PNJ, NAMAPNJ,";
                sql = sql + " NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, ";
                sql = sql + " TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, ";
                sql = sql + " UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, ";
                sql = sql + " SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, ";
                sql = sql + " KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, ";
                sql = sql + " RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, ";
                sql = sql + " RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, ";
                sql = sql + " RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, ";
                sql = sql + " RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, ";
                sql = sql + " JNSMUT, BLTHMUT,  KDMUT,  TGLNYALA,  NOGARDU,  NOTIANG,  NOMETER";
                sql = sql + " ,RPINSENTIF_KVA, RPINSENTIF_KWH, RPDISINSENTIF_KVA, RPDISINSENTIF_KWH";
                sql = sql + " ,TGLBAYAR,WKTBAYAR,KDPP,KDPEMBAYAR";
                sql = sql + " FROM VIEW_12DE_JATELINDO order by IDPEL,blth asc";
            } else {
                throw new Exception("Kode koreksi tidak ditemukan !");
            }

            Map<String, Object> retFunc = new HashMap<>();
            retFunc = GetIdpel("IdPel", tIdpel);

            if (retFunc.get("wsByRefError").toString() != "") {
                throw new Exception(retFunc.get("wsByRefError").toString());
            }

            tIdpel = retFunc.get("wsReturn").toString();

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() > 0) {
                //todo: conver to XML
            } else {
                String ErrMsg = "Piutang tidak ditemukan.";

                Date dDate = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

                sql = "select * from VIEW_INFODPP_INTEGJATELINDO";

                cst = con.prepareCall(sql);
                rs = cst.executeQuery();

                lMapData = CommonModule.convertResultsetToListStr(rs);

                if (lMapData.size() > 0) {
                    if (lMapData.get(0).get("TGKOREKSI") == formatter.format(dDate) && lMapData.get(0).get("TGLBAYAR") == ""){
                        ErrMsg = "Rekening sudah dikoreksi !";
                    } else if (lMapData.get(0).get("TGKOREKSI") == formatter.format(dDate) && lMapData.get(0).get("TGLBAYAR") != "") {
                        ErrMsg = "Rekening koreksi sudah lunas !";
                    } else if (lMapData.get(0).get("TGKOREKSI") != "") {
                        ErrMsg = "Rekening sudah lunas !";
                    }
                }

                retValue.put("wsReturn", " ");
                retValue.put("wsByRefError", ErrMsg);
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetIdpel(String vJenis,
                                               String tPEL) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            if (vJenis == "IdPel") {
                sql = "select IDPEL from dil where IDPEL = '" + tPEL + "'";
            } else if (vJenis == "NoPel") {
                sql = "select IDPEL from dil where NOPEL = '" + tPEL + "'";
            }

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() > 0 ) {
                retValue.put("wsReturn", lMapData.get(0).get(0));
                retValue.put("wsByRefError", "");
            } else {
                retValue.put("wsReturn", "");
                retValue.put("wsByRefError", "IdPelanggan tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> setBatalPelangganKorensi(String sIdpel,
                                               String sBlth,
                                               String sUserBatal,
                                               String sTglKoreksi,
                                               String sAlasan) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            if (sIdpel.trim() == "") {
                throw new Exception("IDPEL KOSONG");
            } else if (sBlth.trim() == "") {
                throw new Exception("BULAN REKENING KOSONG");
            } else if (sUserBatal.trim() == "") {
                throw new Exception("USER BATAL KOSONG");
            } else if (sTglKoreksi.trim() == "") {
                throw new Exception("TGL KOREKSI KOSONG");
            } else if (sAlasan.trim() == "") {
                throw new Exception("ALASAN KOREKSI KOSONG");
            }

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = "{ call PARAMETERVIEW.SetIDPEL(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, sIdpel);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, sUserBatal);
            cst.execute();

            sql = "SELECT SUBSTR(BLTH,5,2) || '/' || SUBSTR(BLTH,1,4) AS BLTH , IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI,KOREKSIBY, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME ";
            sql = sql + " ,TRANSAKSIID FROM VIEW_BATAL12ABCG_JATELINDO ";
            sql = sql + " where TGKOREKSI = '" + sTglKoreksi + "'";
            sql = sql + " AND BLTH = '" + sBlth + "'";
            sql = sql + "  order by IDPEL,blth asc";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() > 0 ) {
                clsBatalTransaksi_Proc clsBtl = new clsBatalTransaksi_Proc();
                Map<String, Object> retClsBtl = new HashMap<>();
                List<Map<String, String>> dsResult = new ArrayList<>();

                for (Map<String, String> rowData : lMapData) {
                    rowData.put("Simpan", "true");
                    rowData.put("HASIL", "");
                }

                retClsBtl = clsBtl.SetDataIdpel_12ABCG(lMapData, sUserBatal, sAlasan, sTglKoreksi, true);

                dsResult = (List<Map<String, String>>)retClsBtl.get("wsReturn");

                if (dsResult.get(0).get("HASIL").toString().substring(1,1) == "1") {
                    retValue.put("wsReturn", true);
                    retValue.put("wsByRefError", "");
                } else {
                    retValue.put("wsReturn", false);
                    retValue.put("wsByRefError", dsResult.get(0).get("HASIL").toString());
                }
            } else {
                retValue.put("wsReturn", "");
                retValue.put("wsByRefError", "Piutang tidak ditemukan.");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> setPelangganKoreksi(List<Map<String, String>> sRsXML,
                                               String sUserTrans,
                                               String sKDKoreksi) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            cls_Aplikasi cCekBK = new cls_Aplikasi();
            Map<String, Object> retCCekBK = cCekBK.cekBKSudahDibuat();

            if (! (Boolean)retCCekBK.get("wsByRefError")) {
                throw new Error("Database sedang melakukan proses rekap,transaksi belum diijinkan !");
            }

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            String tIdpel = "";
            Map<String, Object> retFunc = new HashMap<>();
            retFunc = GetIdpel("IdPel", sRsXML.get(0).get("IDPEL"));

            if (retFunc.get("wsByRefError").toString() != "") {
                throw new Exception("Pelanggan tidak ditemukan");
            }

            tIdpel = retFunc.get("wsReturn").toString();

            sql = "{ call PARAMETERVIEW.SetIDPEL(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, sRsXML.get(0).get("IDPEL"));
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetBLTH(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, sRsXML.get(0).get("BLTH"));
            cst.execute();

            if (sKDKoreksi == "A" || sKDKoreksi == "B" || sKDKoreksi == "C" || sKDKoreksi == "G") {
                //KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR,
                sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME, ";
                sql = sql + " JNSMUT, BLTHMUT,  KDMUT,  TGLNYALA,  NOGARDU,  NOTIANG,  NOMETER, RPBP, RPUJL";
                sql = sql + " ,RPINSENTIF_KVA, RPINSENTIF_KWH, RPDISINSENTIF_KVA, RPDISINSENTIF_KWH";
                sql = sql + " FROM VIEW_12ABC_JATELINDO order by IDPEL,blth asc";
            } else if (sKDKoreksi == "D") {
                sql = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME, ";
                sql = sql + " JNSMUT, BLTHMUT,  KDMUT,  TGLNYALA,  NOGARDU,  NOTIANG,  NOMETER, RPBP, RPUJL";
                sql = sql + " ,RPINSENTIF_KVA, RPINSENTIF_KWH, RPDISINSENTIF_KVA, RPDISINSENTIF_KWH";
                sql = sql + " FROM VIEW_12DE_JATELINDO order by IDPEL,blth asc";
            }

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0 ) {
                throw new Exception("Pelanggan tidak bisa dikoreksi");
            }

            Date sysDate = new Date(); //todo: GetSysdate
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

            Map<String, String> mnewrow = new HashMap<>();

            mnewrow.put("KDGERAKMASUK", "12");
            mnewrow.put("UPLOADTIME", formatter.format(sysDate));
            mnewrow.put("UPLOADBY", "JATELINDO");
            mnewrow.put("KDKOREKSI", sKDKoreksi);
            mnewrow.put("TGKOREKSI", formatter.format(sysDate));  //sRsXML.get(0).get("TGKOREKSI")

            if(lMapData.get(0).get("STATUS") == "") {
                mnewrow.put("STATUS", "L");
            } else {
                mnewrow.put("STATUS", lMapData.get(0).get("STATUS"));
            }

            if(lMapData.get(0).get("KDPEMBPP") == "") {
                mnewrow.put("KDPEMBPP", "R1");
            } else {
                mnewrow.put("KDPEMBPP", lMapData.get(0).get("KDPEMBPP"));
            }

            if(lMapData.get(0).get("KDPEMBAYARSIP3") == "") {
                mnewrow.put("KDPEMBAYARSIP3", "");
            } else {
                mnewrow.put("KDPEMBAYARSIP3", lMapData.get(0).get("KDPEMBAYARSIP3"));
            }

            if(sRsXML.get(0).get("KDAYA") == "") {
                mnewrow.put("KDAYA", "");
            } else {
                mnewrow.put("KDAYA", sRsXML.get(0).get("KDAYA"));
            }

            if(lMapData.get(0).get("NOREK") == "") {
                mnewrow.put("NOREK", "KOSONG");
            } else {
                mnewrow.put("NOREK", lMapData.get(0).get("NOREK"));
            }

            mnewrow.put("NOAGENDA", "");
            mnewrow.put("FLAGSOPP", "");
            mnewrow.put("FLAGANJA", "");

            mnewrow.put("TRANSAKSIBY", sUserTrans);

            mnewrow.put("Simpan", "true");
            mnewrow.put("HASIL", " ");
            //KDPEMBPP, KDPEMBAYARSIP3, UNITUP,
            mnewrow.put("BLTH", lMapData.get(0).get("BLTH"));
            mnewrow.put("KDKELOMPOK", lMapData.get(0).get("KDKELOMPOK"));
            mnewrow.put("TGLJTTEMPO", lMapData.get(0).get("TGLJTTEMPO"));
            mnewrow.put("IDPEL", lMapData.get(0).get("IDPEL"));
            mnewrow.put("NOPEL", lMapData.get(0).get("NOPEL"));
            mnewrow.put("UNITUP", lMapData.get(0).get("UNITUP"));
            mnewrow.put("UNITKJ", lMapData.get(0).get("UNITKJ"));
            mnewrow.put("KETNODLMRT", lMapData.get(0).get("KETNODLMRT"));

            if(sRsXML.get(0).get("NAMA") == "") {
                mnewrow.put("NAMA", lMapData.get(0).get("NOREK"));
            } else {
                mnewrow.put("NAMA", sRsXML.get(0).get("NOREK"));
            }

            if(lMapData.get(0).get("FRT") == "") {
                mnewrow.put("FRT", lMapData.get(0).get("FRT"));
            } else {
                mnewrow.put("FRT", sRsXML.get(0).get("FRT"));
            }

            mnewrow.put("NAMAPNJ", sRsXML.get(0).get("NAMAPNJ"));

            if(lMapData.get(0).get("FJN") == "") {
                mnewrow.put("FJN", lMapData.get(0).get("FJN"));
            } else {
                mnewrow.put("FJN", sRsXML.get(0).get("FJN"));
            }

            mnewrow.put("ABONMETER", lMapData.get(0).get("ABONMETER"));
            mnewrow.put("KDPPJ", sRsXML.get(0).get("KDPPJ"));
            mnewrow.put("PEMDA", sRsXML.get(0).get("PEMDA"));
            mnewrow.put("FAKMKVARH", sRsXML.get(0).get("FAKMKVARH"));
            mnewrow.put("FAKM", sRsXML.get(0).get("FAKM"));
            mnewrow.put("FAKMKVAMAX", sRsXML.get(0).get("FAKMKVAMAX"));
            mnewrow.put("TARIP", sRsXML.get(0).get("TARIP"));
            mnewrow.put("KDPEMBTRF", sRsXML.get(0).get("KDPEMBTRF"));
            mnewrow.put("DAYA", sRsXML.get(0).get("DAYA"));
            mnewrow.put("KOGOL", sRsXML.get(0).get("KOGOL"));
            mnewrow.put("SUBKOGOL", sRsXML.get(0).get("SUBKOGOL"));
            mnewrow.put("KDINKASO", sRsXML.get(0).get("KDINKASO"));
            mnewrow.put("KDDK", sRsXML.get(0).get("KDDK"));

            mnewrow.put("TGLBACA", sRsXML.get(0).get("TGLBACA"));
            mnewrow.put("BLOK3", sRsXML.get(0).get("BLOK3"));
            mnewrow.put("KWHLWBP", sRsXML.get(0).get("KWHLWBP"));
            mnewrow.put("KWHKVARH", sRsXML.get(0).get("KWHKVARH"));
            mnewrow.put("KELBKVARH", sRsXML.get(0).get("KELBKVARH"));
            mnewrow.put("PEMKWH", sRsXML.get(0).get("PEMKWH"));
            mnewrow.put("KWHWBP", sRsXML.get(0).get("KWHWBP"));
            mnewrow.put("SAHKVARH", sRsXML.get(0).get("SAHKVARH"));
            mnewrow.put("SAHLWBP", sRsXML.get(0).get("SAHLWBP"));
            mnewrow.put("SAHWBP", sRsXML.get(0).get("SAHWBP"));
            mnewrow.put("SLAKVARH", sRsXML.get(0).get("SLAKVARH"));
            mnewrow.put("SLALWBP", sRsXML.get(0).get("SLALWBP"));
            mnewrow.put("SLAWBP", sRsXML.get(0).get("SLAWBP"));
            mnewrow.put("SKVAMAX", sRsXML.get(0).get("SKVAMAX"));

            mnewrow.put("RPBEBAN", sRsXML.get(0).get("RPBEBAN"));
            mnewrow.put("RPWBP", sRsXML.get(0).get("RPWBP"));
            mnewrow.put("RPLWBP", sRsXML.get(0).get("RPLWBP"));
            mnewrow.put("RPBLOK3", sRsXML.get(0).get("RPBLOK3"));
            mnewrow.put("RPKVARH", sRsXML.get(0).get("RPKVARH"));
            mnewrow.put("RPTTLB", sRsXML.get(0).get("RPTTLB"));
            mnewrow.put("RPPTL", sRsXML.get(0).get("RPPTL"));
            mnewrow.put("RPTB", sRsXML.get(0).get("RPTB"));
            mnewrow.put("RPPPN", sRsXML.get(0).get("RPPPN"));
            mnewrow.put("RPBPJU", sRsXML.get(0).get("RPBPJU"));
            mnewrow.put("RPMAT", sRsXML.get(0).get("RPMAT"));
            mnewrow.put("RPTRAFO", sRsXML.get(0).get("RPTRAFO"));
            mnewrow.put("RPSEWATRAFO", sRsXML.get(0).get("RPSEWATRAFO"));
            mnewrow.put("RPSEWAKAP", sRsXML.get(0).get("RPSEWAKAP"));
            mnewrow.put("RPANGSA", sRsXML.get(0).get("RPANGSA"));
            mnewrow.put("RPANGSB", sRsXML.get(0).get("RPANGSB"));
            mnewrow.put("RPANGSC", sRsXML.get(0).get("RPANGSC"));
            mnewrow.put("RPPLN", sRsXML.get(0).get("RPPLN"));
            mnewrow.put("RPREDUKSI", sRsXML.get(0).get("RPREDUKSI"));
            mnewrow.put("RPINSENTIF", sRsXML.get(0).get("RPINSENTIF"));
            mnewrow.put("RPDISINSENTIF", sRsXML.get(0).get("RPDISINSENTIF"));
            //mnewrow.put("RPINSENTIF_KVA", sRsXML.get(0).get("RPINSENTIF_KVA"));
            //mnewrow.put("RPDISINSENTIF_KVA", sRsXML.get(0).get("RPDISINSENTIF_KVA"));
            //mnewrow.put("RPINSENTIF_KWH", sRsXML.get(0).get("RPINSENTIF_KWH"));
            //mnewrow.put("RPDISINSENTIF_KWH", sRsXML.get(0).get("RPDISINSENTIF_KWH"));
            mnewrow.put("RPTAG", sRsXML.get(0).get("rptag"));
            mnewrow.put("RPPRODUKSI", sRsXML.get(0).get("RPPRODUKSI"));
            mnewrow.put("RPSUBSIDI", sRsXML.get(0).get("RPSUBSIDI"));
            mnewrow.put("RPSELISIH", sRsXML.get(0).get("RPSELISIH"));
            mnewrow.put("RPTDLLAMA", sRsXML.get(0).get("RPTDLLAMA"));
            mnewrow.put("RPTDLBARU", sRsXML.get(0).get("RPTDLBARU"));
            mnewrow.put("RPBK1", sRsXML.get(0).get("RPBK1"));
            mnewrow.put("RPBK2", sRsXML.get(0).get("RPBK2"));
            mnewrow.put("RPBK3", sRsXML.get(0).get("RPBK3"));
            mnewrow.put("KDAngsA", sRsXML.get(0).get("KDANGSA"));
            mnewrow.put("KDAngsB", sRsXML.get(0).get("KDANGSB"));
            mnewrow.put("KDAngsC", sRsXML.get(0).get("KDANGSC"));

            List<Map<String, String>> dsTrans = new ArrayList<>();
            dsTrans.add(mnewrow);

            clsTransaksi_Proc clsProc = new clsTransaksi_Proc();
            Map<String, Object> dsResult = new HashMap<String, Object>();

            if (sKDKoreksi == "A" || sKDKoreksi == "B" || sKDKoreksi == "C" || sKDKoreksi == "G") {
                dsResult = clsProc.SetDataIdpel_12ABCJatelindo(dsTrans, sUserTrans, sKDKoreksi);
            } else if (sKDKoreksi == "K") {
                Boolean bSuplisi = false;
                if (Integer.parseInt(lMapData.get(0).get("RPTAG")) < Integer.parseInt(sRsXML.get(0).get("RPTAG"))) {
                    bSuplisi = true;
                }
                dsResult = clsProc.SetDataIdpel_12DJatelindo(dsTrans, sUserTrans, sKDKoreksi, bSuplisi);
            }

            retValue = dsResult;

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> getInfoPelanggan(String sIdpel) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, sIdpel);
            cst.execute();

            sql = " SELECT * ";
            sql += " FROM VIEW_INFOLNSTGK_PERPLG";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() > 0 ) {
                retValue.put("wsReturn",sIdpel + "," + lMapData.get(0).get("LBRLNS") + "," + lMapData.get(0).get("RPLNS") + "," + lMapData.get(0).get("LBRTGK") + "," + lMapData.get(0).get("RPTGK"));
            } else {
                retValue.put("wsReturn", sIdpel + ", , , , ");
            }

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", " ");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> getNotul603(String sIdpel) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = " SELECT  ";
            sql += " IDPELANGGAN, NOKONTRAK, NOKONTROL, NAMA, ALAMAT, NO_TUL601, TGL_TUL601,to_char(tgl_tul603,'yyyy-mm-dd')||'/TULVI-03/'||no_tul603 AS NO_TUL603, THBLREK_AKHIR,  ";
            sql += " LEMBAR_603, TAGIHAN_603, TGL_PELUNASAN_603, NO_BA_BONGKAR, TGL_BA_BONGKAR, TGL_PELAKSANAAN_BONGKAR,  ";
            sql += " NAMA_BONGKAR, STAND_LWBP_BONGKAR, STAND_WBP_BONGKAR, STAND_KVARH_BONGKAR, NO_PDL, TGL_PDL, THBL_PDL_BERHASIL, KETERANGAN ";
            sql += " FROM VIEW_TUL603 ";
            sql += " WHERE IDPELANGGAN='" + sIdpel + "'";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() > 0 ) {
                retValue.put("wsReturn", lMapData.get(0).get("NO_TUL603"));
            } else {
                retValue.put("wsReturn", " ");
            }

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", " ");
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
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = " SELECT SYSDATE FROM DUAL ";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData.get(0).get("SYSDATE"));
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", " ");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> setLunasKoreksi(String sIdpel,
                                               String sBlth,
                                               String sPetugas,
                                               String sKdpp,
                                               Integer dRptag,
                                               String sTglBayar,
                                               String sWktBayar,
                                               String sUnitLunas) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Boolean bResult = false;
        cls_Aplikasi cCekBK = new cls_Aplikasi();

        try
        {
            retFunc = cCekBK.cekBKSudahDibuat();

            if (!(Boolean)retFunc.get("wsReturn")) {
                throw new Exception("Database sedang melakukan proses rekap,transaksi belum diijinkan !");
            }

            if (sKdpp.trim() == "") {
                throw new Exception("Kodepp tidak boleh kosong !");
            }

            if (sPetugas.trim() == "") {
                throw new Exception("Kode petugas lunas tidak boleh kosong !");
            }

            if (sTglBayar.trim() == "") {
                throw new Exception("Tanggal bayar tidak boleh kosong !");
            }

            if (sWktBayar.trim() == "") {
                throw new Exception("Waktu bayar tidak boleh kosong !");
            }

            if (sUnitLunas.trim() == "") {
                throw new Exception("Unit lunas tidak boleh kosong !");
            }

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = " { call PARAMETERVIEW.SetIDPEL(?) } ";
            cst = con.prepareCall(sql);
            cst.setString(1, sIdpel);

            sql = " { call PARAMETERVIEW.SetBLTH(?) } ";
            cst = con.prepareCall(sql);
            cst.setString(1, sBlth);


            sql = " SELECT * FROM VIEW_KOREKSI_JATELINDO ";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Pelanggan tidak ditemukan !");
            }
            if (Integer.parseInt(lMapData.get(0).get("RPTAG")) != dRptag) {
                throw new Exception("Rupiah tagihan tidak sama !");
            }


            sql = "{ call Proc_21_LunasKoreksiJat('" + sKdpp + "','" + sTglBayar + "','" + sWktBayar + "'," +
                  "'" + sPetugas + "'" +
                  ",'" + sIdpel + "','12','21','" + sBlth + "'," + dRptag.toString() + ",'" + sUnitLunas + "','E') }";

            cst = con.prepareCall(sql);
            cst.execute();

            sql = "select parhasil.getHasil AS HASIL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() > 0) {
                if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                    bResult = true;
                } else {
                    throw new Exception(lMapData.get(0).get(0));
                }
            } else {
                throw new Exception("Gagal ambil parhasil");
            }

            retValue.put("wsReturn", bResult);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> getPelangganBatalLunasKoreksi(String sIdpel, String sBlth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Boolean bResult = false;
        cls_Aplikasi cCekBK = new cls_Aplikasi();

        try
        {
            retFunc = cCekBK.cekBKSudahDibuat();

            if (!(Boolean)retFunc.get("wsReturn")) {
                throw new Exception("Database sedang melakukan proses rekap,transaksi belum diijinkan !");
            }

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = " { call PARAMETERVIEW.SetIDPEL(?) } ";
            cst = con.prepareCall(sql);
            cst.setString(1, sIdpel);

            sql = " { call PARAMETERVIEW.SetBLTH(?) } ";
            cst = con.prepareCall(sql);
            cst.setString(1, sBlth);


            sql = " SELECT * FROM VIEW_LNSOFFLN_JATELINDO ";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() > 0) {
                bResult = true;
            } else {
                bResult = false;
            }

            retValue.put("wsReturn", bResult);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    public Map<String, Object> setBatalLunasKoreksi(String sIdpel,
                                               String sBlth,
                                               String sPetugasLns,
                                               String sPetugasBatal,
                                               String sAlasan) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Boolean bResult = false;
        cls_Aplikasi cCekBK = new cls_Aplikasi();

        try
        {
            retFunc = cCekBK.cekBKSudahDibuat();

            if (!(Boolean)retFunc.get("wsReturn")) {
                throw new Exception("Database sedang melakukan proses rekap,transaksi belum diijinkan !");
            }

            if (sPetugasLns.trim() == "") {
                throw new Exception("Petugas lunas tidak boleh kosong !");
            }

            if (sPetugasBatal.trim() == "") {
                throw new Exception("Petugas batal lunas tidak boleh kosong !");
            }

            if (sAlasan.trim() == "") {
                throw new Exception("Alasan pembatalan lunas tidak boleh kosong !");
            }

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = " { call PARAMETERVIEW.SetIDPEL(?) } ";
            cst = con.prepareCall(sql);
            cst.setString(1, sIdpel);

            sql = " { call PARAMETERVIEW.SetBLTH(?) } ";
            cst = con.prepareCall(sql);
            cst.setString(1, sBlth);


            sql = " SELECT * FROM VIEW_LNSOFFLN_JATELINDO ";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Pelanggan tidak ditemukan !");
            }
            if (lMapData.get(0).get("KDPEMBAYAR") != sPetugasLns) {
                throw new Exception("Petugas lunas tidak sama !");
            }


            sql = "{ call Proc_Batal21_LunasJatelindo('" + sPetugasBatal + "','" + sIdpel + "','" + sBlth + "'," +
                    "'" + sPetugasLns + "'" +
                    ",'" + sAlasan + "','" + lMapData.get(0).get("TRANSAKSIID") + "','" + lMapData.get(0).get("KDPP") + "','21') }";

            cst = con.prepareCall(sql);
            cst.execute();

            sql = "select parhasil.getHasil AS HASIL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() > 0) {
                if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                    bResult = true;
                } else {
                    throw new Exception(lMapData.get(0).get(0));
                }
            } else {
                throw new Exception("Gagal ambil parhasil");
            }

            retValue.put("wsReturn", bResult);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> getPelangganBatalPiutang(String sIdpel, String sBlth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Boolean bResult = false;
        cls_Aplikasi cCekBK = new cls_Aplikasi();

        try
        {
            retFunc = cCekBK.cekBKSudahDibuat();

            if (!(Boolean)retFunc.get("wsReturn")) {
                throw new Exception("Database sedang melakukan proses rekap,transaksi belum diijinkan !");
            }

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = " { call PARAMETERVIEW.SetIDPEL(?) } ";
            cst = con.prepareCall(sql);
            cst.setString(1, sIdpel);

            sql = " { call PARAMETERVIEW.SetBLTH(?) } ";
            cst = con.prepareCall(sql);
            cst.setString(1, sBlth);


            sql = " SELECT * FROM view_31_validasikrksijatel ";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() > 0) {
                bResult = true;
            } else {
                bResult = false;
            }

            retValue.put("wsReturn", bResult);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> getInfoDPPPelanggan(String sIdpel, String sBlth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        cls_Aplikasi cCekBK = new cls_Aplikasi();

        try
        {
            retFunc = cCekBK.cekBKSudahDibuat();

            if (!(Boolean)retFunc.get("wsReturn")) {
                throw new Exception("Database sedang melakukan proses rekap,transaksi belum diijinkan !");
            }

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = " { call PARAMETERVIEW.SetIDPEL(?) } ";
            cst = con.prepareCall(sql);
            cst.setString(1, sIdpel);

            sql = " { call PARAMETERVIEW.SetBLTH(?) } ";
            cst = con.prepareCall(sql);
            cst.setString(1, sBlth);


            sql = " SELECT * FROM VIEW_INFODPP_INTEGJATELINDO ";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() > 0) {
                retValue.put("wsReturn", lMapData);
            } else {
                retValue.put("wsReturn", "");
            }

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }
}
