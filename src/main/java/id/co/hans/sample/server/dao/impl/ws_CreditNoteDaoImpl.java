package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.ws_CreditNoteDao;
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
public class ws_CreditNoteDaoImpl implements ws_CreditNoteDao {
    public static final Log log = LogFactory.getLog(ws_CreditNoteDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> ambilNamaBank(String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select  ";
            sql = sql + "UNITUP, KODE_BANK, NAMA_BANK, ALAMAT, JENISBANK, REKNO, NO_REKENING, PENGELOLA, NO_PKS, PKS_FROMDATE, PKS_ENDDATE, TGLCATAT, CATATBY, TGLUPDATE, UPDATEBY ";
            sql = sql + "from view_banksip3_daftar ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsBtRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsBtRefError", ex.getMessage());
        }
        return retValue;    
    }

    @Override
    public Map<String, Object> ambilDataCN(String unitup,
                                           String kdpp, String tglbayar) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " SELECT  ";
            sql = sql + "UNITUP, KDPP, TGLBAYAR, LEMBAR, RPPTL, RPPPN, RPBPJU, RPTRAFO, RPLAIN, RPMAT, RPTAG, RPBK ";
            sql = sql + "FROM VIEW_CN_AMBILDATA ";
            sql += " where ";
            sql += " kdpp = '" + kdpp + "' ";
            sql += " and tglbayar = '" + tglbayar + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);

            retFunc = isCNExist(kdpp, tglbayar);

            if ((Boolean)retFunc.get("wsReturn")) {
                sql = "select *";
                sql += " from VIEW_CN_AMBILDATAEXIST";
                sql += " where ";
                sql += " kdpp = '" + kdpp + "' ";
                sql += " and TGL_PELUNASAN = '" + tglbayar + "' ";

                cst = con.prepareCall(sql);
                rs = cst.executeQuery();
                lMapData = CommonModule.convertResultsetToListStr(rs);

                retValue.put("wsReturn_cnsip3", lMapData);
            }

            retFunc = isCNPetugasExist(kdpp, tglbayar);

            if ((Boolean)retFunc.get("wsReturn")) {
                sql = "select *";
                sql += " from view_cn_ptg_ambildataexist";
                sql += " where ";
                sql += " kdpp = '" + kdpp + "' ";
                sql += " and TGL_PELUNASAN = '" + tglbayar + "' ";

                cst = con.prepareCall(sql);
                rs = cst.executeQuery();
                lMapData = CommonModule.convertResultsetToListStr(rs);

                retValue.put("wsReturn_cnsip3petugas", lMapData);
            }

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;
    }


    @Override
    public Map<String, Object> ambilDataCNPengelola(String unitup,
                                                    String kdpengelola, String tglbayar) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " SELECT  ";
            sql = sql + "UNITUP, TGLBAYAR, LEMBAR, RPPTL, RPPPN, RPBPJU, RPTRAFO, RPLAIN, RPMAT, RPTAG, RPBK ";
            sql = sql + "FROM view_cn_ambildata_pengelola ";
            sql += " where ";
            sql += " kodepengelola = '" + kdpengelola + "' ";
            sql += " and tglbayar = '" + tglbayar + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);

            retFunc = isCNPengelolaExist(kdpengelola, tglbayar);

            if ((Boolean)retFunc.get("wsReturn")) {

                sql = "select *";
                sql += " from view_cn_pll_ambildataexist";
                sql += " where ";
                sql += " KODEPENGELOLA = '" + kdpengelola + "' ";
                sql += " and TGL_PELUNASAN = '" + tglbayar + "' ";

                cst = con.prepareCall(sql);
                rs = cst.executeQuery();
                lMapData = CommonModule.convertResultsetToListStr(rs);

                retValue.put("wsReturn_cnsip", lMapData);

                sql = " SELECT  ";
                sql += "UNITUP, KDPP, TGL_PELUNASAN TGLBAYAR, KODEPENGELOLA, LEMBAR, RPPTL, RPPPN, RPBPJU, RPTRAFO, RPLAIN, RPMAT, RPTAG, RPBK ";
                sql += " FROM view_cnsip3_daftar ";
                sql += " where ";
                sql += " KODEPENGELOLA = '" + kdpengelola + "' ";
                sql += " and TGL_PELUNASAN = '" + tglbayar + "' ";

                cst = con.prepareCall(sql);
                rs = cst.executeQuery();
                lMapData = CommonModule.convertResultsetToListStr(rs);

                retValue.put("wsReturn_cnsip3pllkdpp", lMapData);
            } else {
                sql = " SELECT  * ";
                sql += " FROM view_cn_ambildata_pll_dtl ";
                sql += " where ";
                sql += " KODEPENGELOLA = '" + kdpengelola + "' ";
                sql += " and TGL_PELUNASAN = '" + tglbayar + "' ";

                cst = con.prepareCall(sql);
                rs = cst.executeQuery();
                lMapData = CommonModule.convertResultsetToListStr(rs);

                retValue.put("wsReturn_cnsip3pllkdpp", lMapData);
            }


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
    public Map<String, Object> ambilDataCNPetugas(String unitup,
                                                  String kdpp, String tglbayar, String ptgbayar) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" SELECT  ";
            sql = sql + "UNITUP, KDPP, TGLBAYAR, KDPEMBAYAR AS PTGLUNAS, LEMBAR, RPPTL, RPPPN, RPBPJU, RPTRAFO, RPLAIN, RPMAT, RPTAG, RPBK ";
            sql = sql + "FROM view_cn_ambildataperpetugas ";
            sql += " where ";
            sql += " kdpp = '" + kdpp + "' ";
            sql += " and tglbayar = '" + tglbayar + "' ";
            sql += " and kdpembayar = '" + ptgbayar + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);


            retFunc = isCNPetugasExist(kdpp, tglbayar, ptgbayar);

            if ((Boolean)retFunc.get("wsReturn")) {
                sql = "select *";
                sql += " from view_cnpetugas_ambildataexist";
                sql += " where ";
                sql += " kdpp = '" + kdpp + "' ";
                sql += " and TGL_PELUNASAN = '" + tglbayar + "' ";
                sql += " and PTGLUNAS = '" + ptgbayar + "'";

                cst = con.prepareCall(sql);
                rs = cst.executeQuery();
                lMapData = CommonModule.convertResultsetToListStr(rs);

                retValue.put("wsReturn_cnsip3", lMapData);
            }

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> isCNExist(String kdpp, String tglbayar) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" SELECT  COUNT(*) AS JML";
            sql += " FROM CNSIP3 ";
            sql += " where ";
            sql += " kdpp = '" + kdpp + "' ";
            sql += " and tgl_pelunasan = '" + tglbayar + "' " ;
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (Integer.parseInt(lMapData.get(0).get(0)) > 0) {
                retValue.put("wsReturn", true);
                retValue.put("wsBtRefError", "");
            } else {
                retValue.put("wsReturn", false);
                retValue.put("wsBtRefError", "");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsBtRefError", ex.getMessage());
        }
        return retValue;
    }

    @Override
    public Map<String, Object> isCNPengelolaExist(String kdpengelola, String tglbayar) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" SELECT  COUNT(*) AS JML";
            sql += " FROM CNSIP3_PENGELOLA ";
            sql += " where ";
            sql += " KODEPENGELOLA = '" + kdpengelola + "' ";
            sql += " and tgl_pelunasan = '" + tglbayar + "' " ;
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (Integer.parseInt(lMapData.get(0).get(0)) > 0) {
                retValue.put("wsReturn", true);
                retValue.put("wsBtRefError", "");
            } else {
                retValue.put("wsReturn", false);
                retValue.put("wsBtRefError", "");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsBtRefError", ex.getMessage());
        }
        return retValue;
    }

    @Override
    public Map<String, Object> isCNPetugasExist(String kdpp, String tglbayar, String ptglunas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" SELECT  COUNT(*) AS JML";
            sql += " FROM CNSIP3_PETUGAS ";
            sql += " where ";
            sql += " kdpp = '" + kdpp + "' ";
            sql += " and tgl_pelunasan = '" + tglbayar + "' ";
            sql += " and PTGLUNAS = '" + ptglunas + "' " ;
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (Integer.parseInt(lMapData.get(0).get(0)) > 0) {
                retValue.put("wsReturn", true);
                retValue.put("wsBtRefError", "");
            } else {
                retValue.put("wsReturn", false);
                retValue.put("wsBtRefError", "");
            }

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> isCNPetugasExist(String kdpp, String tglbayar) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" SELECT  COUNT(*) AS JML";
            sql += " FROM CNSIP3_PETUGAS ";
            sql += " where ";
            sql += " kdpp = '" + kdpp + "' ";
            sql += " and tgl_pelunasan = '" + tglbayar + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (Integer.parseInt(lMapData.get(0).get(0)) > 0) {
                retValue.put("wsReturn", true);
                retValue.put("wsBtRefError", "");
            } else {
                retValue.put("wsReturn", false);
                retValue.put("wsBtRefError", "");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }
        return retValue;
    }


   @Override
    public Map<String, Object> simpanDataCN(Map<String, Object> ds, Boolean bEdit) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

       lMapData = (List<Map<String, String>>) ds.get("data");

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" { call Proc_CreditNoteInsert(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            Integer indexParam = 0;
            cst.setString(indexParam++, lMapData.get(0).get("TRANSAKSIBY"));
            cst.setString(indexParam++, lMapData.get(0).get("NO_BATULV06"));
            cst.setString(indexParam++, lMapData.get(0).get("UNITUP"));
            cst.setString(indexParam++, lMapData.get(0).get("KDPP"));
            cst.setString(indexParam++, lMapData.get(0).get("TGL_PELUNASAN"));
            cst.setString(indexParam++, lMapData.get(0).get("TGL_SETOR"));
            cst.setString(indexParam++, lMapData.get(0).get("LEMBAR"));
            cst.setString(indexParam++, lMapData.get(0).get("RPPTL"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPPTL"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPPTL"));

            cst.setString(indexParam++, lMapData.get(0).get("RPPPN"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPPPN"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPPPN"));
            cst.setString(indexParam++, lMapData.get(0).get("RPBPJU"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPBPJU"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPBPJU"));
            cst.setString(indexParam++, lMapData.get(0).get("RPTRAFO"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPTRAFO"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPTRAFO"));
            cst.setString(indexParam++, lMapData.get(0).get("RPLAIN"));

            cst.setString(indexParam++, lMapData.get(0).get("BANKRPLAIN"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPLAIN"));
            cst.setString(indexParam++, lMapData.get(0).get("RPMAT"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPMAT"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPMAT"));
            cst.setString(indexParam++, lMapData.get(0).get("RPTAG"));
            cst.setString(indexParam++, lMapData.get(0).get("RPBK"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPBK"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPBK"));
            cst.setString(indexParam++, lMapData.get(0).get("1"));

            cst.setString(indexParam++, bEdit ? "1" : "0");

            cst.execute();

            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
        }
        return retValue;
   }

    @Override
    public Map<String, Object> simpanDataCNPengelola(Map<String, Object> ds, Boolean bEdit) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        lMapData = (List<Map<String, String>>) ds.get("data");

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" { call Proc_CNInsertPengelola(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            Integer indexParam = 0;
            cst.setString(indexParam++, lMapData.get(0).get("TRANSAKSIBY"));
            cst.setString(indexParam++, lMapData.get(0).get("NO_BATULV06"));
            cst.setString(indexParam++, lMapData.get(0).get("UNITUP"));
            cst.setString(indexParam++, lMapData.get(0).get("KODEPENGELOLA"));
            cst.setString(indexParam++, lMapData.get(0).get("TGL_PELUNASAN"));
            cst.setString(indexParam++, lMapData.get(0).get("TGL_SETOR"));
            cst.setString(indexParam++, lMapData.get(0).get("LEMBAR"));
            cst.setString(indexParam++, lMapData.get(0).get("RPPTL"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPPTL"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPPTL"));

            cst.setString(indexParam++, lMapData.get(0).get("RPPPN"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPPPN"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPPPN"));
            cst.setString(indexParam++, lMapData.get(0).get("RPBPJU"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPBPJU"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPBPJU"));
            cst.setString(indexParam++, lMapData.get(0).get("RPTRAFO"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPTRAFO"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPTRAFO"));
            cst.setString(indexParam++, lMapData.get(0).get("RPLAIN"));

            cst.setString(indexParam++, lMapData.get(0).get("BANKRPLAIN"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPLAIN"));
            cst.setString(indexParam++, lMapData.get(0).get("RPMAT"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPMAT"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPMAT"));
            cst.setString(indexParam++, lMapData.get(0).get("RPTAG"));
            cst.setString(indexParam++, lMapData.get(0).get("RPBK"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPBK"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPBK"));
            cst.setString(indexParam++, bEdit ? "1" : "0");

            cst.execute();

            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
        }
        return retValue;
    }

    @Override
    public Map<String, Object> simpanDataCNPerPetugas(Map<String, Object> ds, Boolean bEdit) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        lMapData = (List<Map<String, String>>) ds.get("data");

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" { call Proc_CreditNoteInsertPerPtgLns(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            Integer indexParam = 0;
            cst.setString(indexParam++, lMapData.get(0).get("PTGLUNAS"));
            cst.setString(indexParam++, lMapData.get(0).get("TRANSAKSIBY"));
            cst.setString(indexParam++, lMapData.get(0).get("NO_BATULV06"));
            cst.setString(indexParam++, lMapData.get(0).get("UNITUP"));
            cst.setString(indexParam++, lMapData.get(0).get("KDPP"));
            cst.setString(indexParam++, lMapData.get(0).get("TGL_PELUNASAN"));
            cst.setString(indexParam++, lMapData.get(0).get("TGL_SETOR"));
            cst.setString(indexParam++, lMapData.get(0).get("LEMBAR"));
            cst.setString(indexParam++, lMapData.get(0).get("RPPTL"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPPTL"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPPTL"));

            cst.setString(indexParam++, lMapData.get(0).get("RPPPN"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPPPN"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPPPN"));
            cst.setString(indexParam++, lMapData.get(0).get("RPBPJU"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPBPJU"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPBPJU"));
            cst.setString(indexParam++, lMapData.get(0).get("RPTRAFO"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPTRAFO"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPTRAFO"));
            cst.setString(indexParam++, lMapData.get(0).get("RPLAIN"));

            cst.setString(indexParam++, lMapData.get(0).get("BANKRPLAIN"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPLAIN"));
            cst.setString(indexParam++, lMapData.get(0).get("RPMAT"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPMAT"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPMAT"));
            cst.setString(indexParam++, lMapData.get(0).get("RPTAG"));
            cst.setString(indexParam++, lMapData.get(0).get("RPBK"));
            cst.setString(indexParam++, lMapData.get(0).get("BANKRPBK"));
            cst.setString(indexParam++, lMapData.get(0).get("CNRPBK"));
            cst.setString(indexParam++, bEdit ? "1" : "0");

            cst.execute();

            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
        }
        return retValue;
    }

    @Override
    public Map<String, Object> ambilFormatCN() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="SELECT * FROM view_cnsip3_daftar";

            CallableStatement cst;
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
    public Map<String, Object> ambilFormatCNPengelola() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="SELECT * FROM view_cnsip3_pll_daftar";

            CallableStatement cst;
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
    public Map<String, Object> ambilFormatCNPerPlg() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="SELECT * FROM view_cnsip3_daftar_perptglns";

            CallableStatement cst;
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
    public Map<String, Object> ambilRekapCN(String Jenis, String unitup, String kodepp, String tglAwal, String tglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" SELECT UNITUP, KDPP, NO_BATULV06, TGLTRANSAKSI, TRANSAKSIID, TRANSAKSIBY, TGL_PELUNASAN, TGL_SETOR, LEMBAR, RPPTL, BANKRPPTL, CNRPPTL, RPBPJU, BANKRPBPJU, CNRPBPJU, RPPPN, BANKRPPPN, CNRPPPN, RPMAT, BANKRPMAT, CNRPMAT, RPTRAFO, BANKRPTRAFO, CNRPTRAFO, RPLAIN, BANKRPLAIN, CNRPLAIN, RPBK, BANKRPBK, CNRPBK, RPTAG, TGLTRANSAKSIBATAL, TRANSAKSIIDBATAL, TRANSAKSIBATALBY ";
            sql += " FROM view_cnsip3_daftar ";
            sql += " where unitup = '" + unitup + "' ";
            sql += " and kdpp = '" + kodepp + "' ";

            if (Jenis == "lunas") {
                sql += " and tgl_pelunasan >= '" + tglAwal + "' and tgl_pelunasan <= '" + tglAkhir + "' ";
                sql += " order by tgl_pelunasan, tgltransaksi ";
            }
            if (Jenis == "setor") {
                sql += " and tgl_setor >= '" + tglAwal + "' and tgl_setor <= '" + tglAkhir + "' ";
                sql += " order by tgl_setor, tgltransaksi ";
            }
            if (Jenis == "Perptg") {
                sql = " select * from view_cnsip3_perptg ";
                sql += " where to_char(tgl_pelunasan,'yyyyMMdd') >= '" + tglAwal + "' and to_char(tgl_pelunasan,'yyyyMMdd') <= '" + tglAkhir + "' " ;
                sql += " and unitup='" + unitup + "'" ;
                if (kodepp.toUpperCase() == "SEMUA") {
                    sql += " and kodepp = '" + kodepp + "' " ;
                }
            }

            CallableStatement cst;
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
    public Map<String, Object> ambilDataDanaperTglPp(String unitup, String kodepp, String tglAwal, String tglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql = "";

            sql = "{ call PARAMETERVIEW.SetUNITUP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, unitup);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetKODEPP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, kodepp);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetTGLSTART(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tglAwal);
            cst.execute();

            sql = "{ call PARAMETERVIEW.SetTGLEND(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tglAkhir);
            cst.execute();


            sql =" SELECT UNITUP, KDPP, TGL_PELUNASAN, LEMBAR_DANA, RPPTL_DANA, RPBPJU_DANA, RPPPN_DANA, RPMAT_DANA, RPTRAFO_DANA, RPLAIN_DANA, RPBK_DANA, RPTAG_DANA, LEMBAR_DATA, RPPTL_DATA, RPBPJU_DATA, RPPPN_DATA, RPMAT_DATA, RPTRAFO_DATA, RPLAIN_DATA, RPBK_DATA, RPTAG_DATA ";
            sql += " FROM VIEW_CNDATADANA_KODEPP ";

            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", ex.getMessage());
        }
        return retValue;
    }
}
