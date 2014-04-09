package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.ws_InterfaceDao;
import id.co.hans.sample.server.utility.CommonModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

@Service
public class ws_InterfaceDaoImpl implements ws_InterfaceDao{
    public static final Log log = LogFactory.getLog(ws_InterfaceDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> simpanDPHLoad_AJN(String idPel,
                                                 String blth,
                                                 String tglbayar,
                                                 String rptag,
                                                 String rpbk,
                                                 String ipaddress) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String jambayar = "";
        SimpleDateFormat formatterRaw = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat formatterTanggal = new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat formatterJam = new SimpleDateFormat("HH:mm");

        try
        {
            jambayar = formatterJam.format(formatterRaw.parse(tglbayar));
            tglbayar = formatterTanggal.format(formatterRaw.parse(tglbayar));
            retFunc = uploadKeAJN();

            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "select * from sip3user.DPP where idpel='" + idPel + "'  and blth='" + blth + "'";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            sql = "insert into sip3user.dph_load (idPel,blth,kdpembpp,unitup,kdpp,kdgerak,tglbayar,jambayar,refno,rptag,rpbk,layerke,ipaddress,tglkonsld,konsldke) ";
            sql += "values ('" + idPel + "','" + blth + "','R1',";
            sql += "'" + lMapData.get(0).get("unitup") + "','" + lMapData.get(0).get("kdpp") + "','21'";
            sql += ",to_char(sysdate,'ddmmyyyy'),'" + jambayar + "',";
            sql += "'','" + rptag + "','" + rpbk + "',";
            sql += "'1','" + ipaddress + "',trunc(sysdate),'" + retFunc.get("wsReturn") + "')";

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
    public Map<String, Object> simpanDPHLoads(String idPel,
                                              String blth,
                                              String kdpembpp,
                                              String unitup,
                                              String kdpp,
                                              String kdgerak,
                                              String tglbayar,
                                              String refno,
                                              String rptag,
                                              String rpbk,
                                              String layerke,
                                              String ipaddress,
                                              String tglupload,
                                              String noupload) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String jambayar;

        try
        {
            retFunc = uploadKe("DPH");

            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "insert into sip3user.dph_load (idPel,blth,kdpembpp,unitup,kdpp,kdgerak,tglbayar,jambayar,refno,rptag,rpbk,layerke,ipaddress,tglupload,noupload) ";
            sql = "insert into sip3user.dph_load (idPel,blth,kdpembpp,unitup,kdpp,kdgerak,tglbayar,jambayar,refno,rptag,rpbk,layerke,ipaddress,tglkonsld,konsldke) ";
            sql += "values ('" + idPel + "','" + blth + "','" + kdpembpp + "',";
            sql += "'" + unitup + "','" + kdpp + "','" + kdgerak + "'";
            sql += ",to_char(sysdate,'ddmmyyyy'),'" ;
            sql += "'','" + rptag + "','" + rpbk + "',";
            sql += "'" + layerke + "','" + ipaddress + "',tRUNC(" + tglupload + "),'" + retFunc.get("wsReturn") + "')";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            cst.execute();

            retValue.put("wsRetrun", true);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsRetrun", false);
        }
        return retValue;
    }


    @Override
    public Map<String, Object> simpandphload_2(String idPel,
                                               String kdpembpp,
                                               String unitup,
                                               String kdpp,
                                               String kdgerak,
                                               String refno,
                                               String rpbk,
                                               String layerke,
                                               String ipaddress,
                                               String noupload,
                                               Integer type_rekening) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String blthtag, no_pelanggan, rptagih;
        String kdpembp;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql = "";

            if (type_rekening == 0) {
                sql =" select no_pelanggan,uraian as blth,sum(mutasi) as rptag from dis ";
                sql += " where no_pelanggan='" + idPel + "' ";
                sql += " and tgl_pelunasan=trunc(sysdate) ";
                sql += " group by no_pelanggan,uraian";
                kdpembp = "R1";
            } else {
                sql =" select no_pelanggan,tgl_transaksi as blth,sum(mutasi) as rptag from dis ";
                sql += " where no_pelanggan='" + idPel + "' ";
                sql += " and tgl_pelunasan=trunc(sysdate) ";
                sql += " group by no_pelanggan,uraian";
                kdpembp = "N1";
            }

            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            for (Map<String, String> rowData : lMapData) {
                no_pelanggan = rowData.get("no_pelanggan");
                rptagih = rowData.get("rptag");

                if (rowData.get("blth").length() == 10) {
                    blthtag = rowData.get("blth").substring(4,2) + "-" + rowData.get("blth").substring(7,4);
                } else {
                    retFunc = bl_th_tagihan(rowData.get("blth"));
                    blthtag = retFunc.get("wsReturn").toString();
                }

                retFunc = simpanDPHLoads(no_pelanggan, blthtag, kdpembp, unitup, kdpp, kdgerak, "now", refno, rptagih, rpbk, layerke, ipaddress, "sysdate", noupload);
            }

            retValue.put("wsReturn", true);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
        }
        return retValue;
    }


    @Override
    public Map<String, Object> simpanddphload_Kolektif(String kdpembpp,
                                                       String unitup,
                                                       String kdpp,
                                                       String kdgerak,
                                                       String refno,
                                                       String rpbk,
                                                       String layerke,
                                                       String ipaddress,
                                                       String noupload,
                                                       String kdkol) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String NoPelanggan, rptagih, blthtag;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql;


            sql ="select a.no_pelanggan,a.uraian as blth,sum(a.mutasi) as rptag from dis a, temptul504kolektif b ";
            sql += " where a.tgl_pelunasan=trunc(sysdate) ";
            sql += " and a.NO_PELANGGAN = b.NO_PELANGGAN ";
            sql += " and UPPER(b.kodekolektif) = '" ;
            sql += " group by a.no_pelanggan,a.uraian ";

            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            for (Map<String, String> rowData : lMapData) {
                NoPelanggan = rowData.get("no_pelanggan");
                rptagih = rowData.get("rptag");
                blthtag = rowData.get("blth");

                retFunc = simpanDPHLoads(NoPelanggan, blthtag, kdpembpp, unitup, kdpp, "23", "now", refno, rptagih, rpbk, layerke, ipaddress, "sysdate", noupload);

                sql = " update sip3user.dph_load set kdkolektif=upper('" + kdkol + "') ";
                sql += " where no_pelanggan='" + NoPelanggan + "' and blth='" + blthtag + "'";

                cst = con.prepareCall(sql);
                cst.execute();
            }

            retValue.put("wsReturn", true);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
        }
        return retValue;
    }


    @Override
    public Map<String, Object> bl_th_tagihan(String blthrek) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        if (blthrek.substring(0,3).equals("Jan")) {
            retValue.put("wsReturn", "02" + blthrek.substring(5,4));

        } else if (blthrek.substring(0,3).equals("Feb")) {
            retValue.put("wsReturn", "03" + blthrek.substring(5,4));

        } else if (blthrek.substring(0,3).equals("Mar")) {
            retValue.put("wsReturn", "04" + blthrek.substring(5,4));

        } else if (blthrek.substring(0,3).equals("Apr")) {
            retValue.put("wsReturn", "05" + blthrek.substring(5,4));

        } else if (blthrek.substring(0,3).equals("Mei")) {
            retValue.put("wsReturn", "06" + blthrek.substring(5,4));

        } else if (blthrek.substring(0,3).equals("Jun")) {
            retValue.put("wsReturn", "07" + blthrek.substring(5,4));

        } else if (blthrek.substring(0,3).equals("Jul")) {
            retValue.put("wsReturn", "08" + blthrek.substring(5,4));

        } else if (blthrek.substring(0,3).equals("Agu")) {
            retValue.put("wsReturn", "09" + blthrek.substring(5,4));

        } else if (blthrek.substring(0,3).equals("Sep")) {
            retValue.put("wsReturn", "10" + blthrek.substring(5,4));

        } else if (blthrek.substring(0,3).equals("Okt")) {
            retValue.put("wsReturn", "11" + blthrek.substring(5,4));

        } else if (blthrek.substring(0,3).equals("Nop")) {
            retValue.put("wsReturn", "12" + blthrek.substring(5,4));

        } else if (blthrek.substring(0,3).equals("Des")) {
            retValue.put("wsReturn", "01" + blthrek.substring(5,4));

        }

        return retValue;
    }


    @Override
    public Map<String, Object> fg_tgl_jatuh_tempo(String blth,
                                                  String kode_ranting_numerik) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String temp;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;

            String sql = "select tanggal from refverifikasi where kode_ranting_numerik='" + kode_ranting_numerik + "' and tahun='" + Integer.parseInt(blth.substring(3, 4)) + "' and bulan='" + Integer.parseInt(blth.substring(1,2)) + "' and kategori='JT'";

            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            temp = lMapData.get(0).get(0) + blth;

            if (temp.length() == 7) {
                temp = "0" + temp;
            }

            retValue.put("wsReturn", temp);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> getData(String sqlQuery) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        retValue.put("wsReturn", "deprecated");
        return retValue;
    }


    @Override
    public Map<String, Object> setData(String sqlQuery) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        retValue.put("wsReturn", "deprecated");
        return retValue;
    }


    @Override
    public Map<String, Object> isiDKRPLoad(String no_pelanggan,
                                           String uraian,
                                           String ipaddress,
                                           String tglkonsld,
                                           Integer konsldke,
                                           Integer layerke) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" { call SIP3USER.FILTER.SETIDPEL('523013163910') } " ;

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> rptBaOffline(String TglLunas,
                                            String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;

            String sql =" { call sip3rep.repmng.repFillBAOffline(?,?) } " ;
            cst = con.prepareCall(sql);
            cst.setDate("TglLunas", java.sql.Date.valueOf(TglLunas));
            cst.setString("par_Petugas", petugas);

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
    public Map<String, Object> rptRkpPelunasanHarian(String tglmulai,
                                                     String tglselesai,
                                                     String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;

            String sql =" { call sip3rep.repmng.repFillRkpLunasHarian(?,?,?) } " ;
            cst = con.prepareCall(sql);
            cst.setDate("TglMulai", java.sql.Date.valueOf(tglmulai));
            cst.setDate("TglSampai", java.sql.Date.valueOf(tglselesai));
            cst.setString("par_Petugas", petugas);

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
    public Map<String, Object> rptRkpPelunasanPeriode(String tglmulai,
                                                      String tglselesai, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;

            String sql =" { call sip3rep.repmng.repFillRkpLunasPeriode(?,?,?) } " ;
            cst = con.prepareCall(sql);
            cst.setDate("TglMulai", java.sql.Date.valueOf(tglmulai));
            cst.setDate("TglSampai", java.sql.Date.valueOf(tglselesai));
            cst.setString("par_Petugas", petugas);

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
    public Map<String, Object> simpanDPHLoad(String idPel,
                                             String blth,
                                             String kdpembpp,
                                             String unitup,
                                             String kdpp,
                                             String kdgerak,
                                             String tglbayar,
                                             String refno,
                                             String rptag,
                                             String rpbk,
                                             String layerke,
                                             String ipaddress,
                                             String tglupload,
                                             String noupload) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();
        String jambayar;

        //todo: cek format tanggal dan jam
        SimpleDateFormat formatterTgl = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatterJam = new SimpleDateFormat("h:m");

        try
        {
            jambayar = tglbayar.substring(1,6);
            tglbayar = tglbayar.substring(1,6);

            retFunc = uploadKe("DPH");

            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;

            String sql ="insert into dph_load (idPel,blth,kdpembpp,unitup,kdpp,kdgerak,tglbayar,jambayar,refno,rptag,rpbk,layerke,ipaddress,tglupload,noupload) " ;
            sql += "values ('" + idPel + "','" + blth + "','" + kdpembpp + "',";
            sql += "'" + unitup + "','" + kdpp + "','" + kdgerak + "'";
            sql += ",'" + tglbayar + ",'" + jambayar + "'" ;
            sql += "'" + refno + "','" + rptag + "','" + rpbk + "',";
            sql += "'" + layerke + "','" + ipaddress + "'," + tglupload + ",'" + retFunc.get("wsReturn") + "')";

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
    public Map<String, Object> simpanDpdtLoad(String idpel,
                                              String blth,
                                              String kdkoreksi,
                                              String ipaddress,
                                              String KRM,
                                              String TRM) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try {
            retFunc = uploadKe("DKRP");

            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            ResultSet rs;
            String sql;

            sql = "select * from sip3user.dpp where idpel='" + idpel + "' and blth='" + blth + "'";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            Map<String, String> rowData = lMapData.get(0);

            sql = "insert into sip3user.dpdt_load ";
            sql += "( UNITUP,KDPEMBAYAR,idpel,blth,KDPP,TGLBAYAR,PEMDA,NAMA,PNJ";
            sql += ",NAMAPNJ,NOBANG,KETNOBANG,RT,RW,NODLMRT,KETNODLMRT,LINGKUNGAN";
            sql += ",KODEPOS,TARIP,DAYA,KDAYA,KOGOL,NOPEL,FRT,KDDK,TGLBACA,SLALWBP";
            sql += ",SAHLWBP,SLAWBP,SAHWBP,SLAKVARH,SAHKVARH,FAKM,FAKMKVARH,KWHLWBP";
            sql += ",KWHWBP,BLOK3,PEMKWH,KWHKVARH,RPLWBP,RPWBP,RPBLOK3,RPKVARH,RPBEBAN";
            sql += ",CTTLB,RPTTLB,RPPTL,RPTB,RPPPN,RPBPJU,RPTRAFO,KDANGSA,RPANGSA";
            sql += ",KDANGSB,RPANGSB,KDANGSC,RPANGSC,RPMAT,RPPLN,RPTAG,RPPRODUKSI";
            sql += ",RPSUBSIDI,TGLJTTEMPO,RPBK1,RPBK2,RPBK3,KDGERAK,STATUS,kdkoreksi";
            sql += ",TGKOREKSI,KDPEMBPP,RPTDLLAMA,RPTDLBARU,RPSELISIH";
            sql += ",RPREDUKSI,NOREK,TGLKONSLD,KONSLDKE,ipaddress,LAYERKE,KIRIM,TERIMA) ";
            sql += "values( ";
            sql += "'" + rowData.get("UNITUP") + "','" + rowData.get("KDPEMBAYAR") + "','" + rowData.get("IDPEL") + "',";
            sql += "'" + rowData.get("BLTH") + "','" + rowData.get("KDPP") + "','" + rowData.get("TGLBAYAR") + "',";
            sql += "'" + rowData.get("PEMDA") + "','" + rowData.get("NAMA") + "','" + rowData.get("PNJ") + "',";
            sql += "'" + rowData.get("NAMAPNJ") + "','" + rowData.get("NOBANG") + "','" + rowData.get("KETNOBANG") + "',";
            sql += "'" + rowData.get("RT") + "','" + rowData.get("RW") + "','" + rowData.get("NODLMRT") + "',";
            sql += "'" + rowData.get("KETNODLMRT") + "','" + rowData.get("LINGKUNGAN") + "','" + rowData.get("KODEPOS") + "',";
            sql += "'" + rowData.get("TARIP") + "','" + rowData.get("DAYA") + "','" + rowData.get("KDAYA") + "',";
            sql += "'" + rowData.get("KOGOL") + "','" + rowData.get("NOPEL") + "','" + rowData.get("FRT") + "',";
            sql += "'" + rowData.get("KDDK") + "','" + rowData.get("TGLBACA") + "','" + rowData.get("SLALWBP") + "',";
            sql += "'" + rowData.get("SAHLWBP") + "','" + rowData.get("SLAWBP") + "','" + rowData.get("SAHWBP") + "',";
            sql += "'" + rowData.get("SLAKVARH") + "','" + rowData.get("SAHKVARH") + "','" + rowData.get("FAKM") + "',";
            sql += "'" + rowData.get("FAKMKVARH") + "','" + rowData.get("KWHLWBP") + "','" + rowData.get("KWHWBP") + "',";
            sql += "'" + rowData.get("BLOK3") + "','" + rowData.get("PEMKWH") + "','" + rowData.get("KWHKVARH") + "',";
            sql += "'" + rowData.get("RPLWBP") + "','" + rowData.get("RPWBP") + "','" + rowData.get("RPBLOK3") + "',";
            sql += "'" + rowData.get("RPKVARH") + "','" + rowData.get("RPBEBAN") + "','" + rowData.get("CTTLB") + "',";
            sql += "'" + rowData.get("RPTTLB") + "','" + rowData.get("RPPTL") + "','" + rowData.get("RPTB") + "',";
            sql += "'" + rowData.get("RPPPN") + "','" + rowData.get("RPBPJU") + "','" + rowData.get("RPTRAFO") + "',";
            sql += "'" + rowData.get("KDANGSA") + "','" + rowData.get("RPANGSA") + "','" + rowData.get("KDANGSB") + "',";
            sql += "'" + rowData.get("RPANGSB") + "','" + rowData.get("KDANGSC") + "','" + rowData.get("RPANGSC") + "',";
            sql += "'" + rowData.get("RPMAT") + "','" + rowData.get("RPPLN") + "','" + rowData.get("RPTAG") + "',";
            sql += "'" + rowData.get("RPPRODUKSI") + "','" + rowData.get("RPSUBSIDI") + "','" + rowData.get("TGLJTTEMPO") + "',";
            sql += "'" + rowData.get("RPBK1") + "','" + rowData.get("RPBK2") + "','" + rowData.get("RPBK3") + "',";
            sql += "'12','" + rowData.get("STATUS") + "','" + kdkoreksi + "',";
            sql += "to_char(sysdate,'ddmmyyyy'),'" + rowData.get("KDPEMBPP") + "','" + rowData.get("RPTDLLAMA") + "',";
            sql += "'" + rowData.get("RPTDLBARU") + "','" + rowData.get("RPSELISIH") + "','" + rowData.get("RPREDUKSI") + "',";
            sql += "'" + rowData.get("NOREK") + "',to_date('" + rowData.get("TGLKONSLD").substring(1, 10) + "','mm/dd/yyyy'),'" + retFunc.get("wsReturn") + "',";
            sql += "'" + ipaddress + "','1','" + KRM + "','" + TRM + "')";

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
    public Map<String, Object> simpanDpdtLoadTERIMA(String idpel,
                                                    String ur) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String blth;

        try {
            retFunc = bl_th_tagihan(ur);
            blth = retFunc.get("wsReturn").toString();

            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            ResultSet rs;
            String sql;

            sql = "select * from dil where no_pelanggan='" + idpel + "'";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            Map<String, String> rowData = lMapData.get(0);

            sql = "update sip3user.dpdt_load ";
            sql += "set NAMA= '" + rowData.get("NAMA_PELANGGAN") + "', ";
            sql += "PNJ = '" + rowData.get("JALAN") + "'";
            sql += ", NAMAPNJ = '" + rowData.get("NAMA_JALAN") + "'";
            sql += ", NOBANG = '" + rowData.get("NO_BANGUNAN") + "'";
            sql += ", RT= '" + rowData.get("RT") + "'";
            sql += ", RW= '" + rowData.get("RW") + "'";
            sql += ",  PEMDA = '" + rowData.get("KODYA_KABUPATEN") + "'";
            sql += ",  KOGOL = '" + rowData.get("KODE_GOLONGAN") + "'";
            sql += ", tarip = '" + rowData.get("TARIP") + "'";
            sql += ", daya = '" + rowData.get("DAYA") + "'";
            sql += ", KDAYA = '" + rowData.get("KODE_KVA") + "'";
            sql += ",  BLTH = '" + blth + "'";
            sql += ", KDPP = '" + rowData.get("KODEPP") + "'";
            sql += "where idpel='" + idpel + "'";
                    
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
    public Map<String, Object> simpanDKRPLoadS(String no_pelanggan,
                                               String blth,
                                               String URAIAN,
                                               String ipaddress,
                                               String kodegerak) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        Map<String, Object> retFunc2 = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try {
            retFunc = bl_th_tagihan(URAIAN);
            retFunc = fg_tgl_jatuh_tempo(retFunc.get("wsReturn").toString(), no_pelanggan.substring(1, 5));
            retFunc2 = uploadKe("DKRP");

            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            ResultSet rs;
            String sql;


            sql = "select no_pelanggan,uraian , mutasi,nmpiutang,tgl_jatuh_tempo ";
            sql += " from dis where no_pelanggan='" + no_pelanggan + "' and uraian='" + URAIAN + "'";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);
            Map<String, String> dr_dis = lMapData.get(0);

            sql = " select nama_pelanggan ,RT ,RW , ";
            sql += "kode_pos ,tarip ,daya ,kode_golongan ,kodepp, kode_kva,kodya_kabupaten, ";
            sql += " no_bangunan,jalan,nama_jalan from dil where no_pelanggan='" + no_pelanggan + "' ";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);
            Map<String, String> dr_dil = lMapData.get(0);

            sql = "select standawallwbpkwh ,standakhirlwbpkwh ,standawalwbp ,standakhirwbp , ";
            sql += "STANDAWALKVARH ,STANDAKHIRKVARH ,KWHLWBP ,KWHWBP ,KWHBLOK3  ,faktor_kali_meter,kvarh ";
            sql += " from dildatastandmeter where no_pelanggan='" + no_pelanggan + "' and bl_th_rekening='" + blth + "'";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);
            Map<String, String> dr_dildatastandmeter = lMapData.get(0);


            sql = "select faktor_kali_kvarh ";
            sql += " from dilmeter where no_pelanggan='" + no_pelanggan + "' ";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);
            Map<String, String> dr_dilmeter = lMapData.get(0);


            String RPPPN_VAL = "";
            String RPBPJU_VAL = "";
            String RPTRAFO_VAL = "";
            String RPMATERAI_VAL = "";
            String RPBK1_VAL = "";
            String RPBK2_VAL = "";
            String RPBK3_VAL = "";
            String RPBEBAN_VAL = "";
            String rppln_val = "";
            String rptag_val = "";
            String rpdiskon_val = "";
            String rplwbp = "";
            String rpwbp = "";
            String rpblok3 = "";
            String rpkvarh = "";
            String KDGERAK = "";

            sql = "INSERT INTO  /*+APPEND*/ sip3user.dkrp_load ";
            sql += "(UNITUP,IDPEL,BLTH,KDPP,PEMDA,NAMA,PNJ,NAMAPNJ,NOBANG,RT,RW,KODEPOS,TARIP,DAYA,";
            sql += "KDAYA,KOGOL,SLALWBP,SAHLWBP,SLAWBP,SAHWBP,SLAKVARH,SAHKVARH,FAKM,FAKMKVARH,KWHLWBP,KWHWBP,BLOK3,";
            sql += "KWHKVARH,RPLWBP,RPWBP,RPBLOK3,RPKVARH,RPBEBAN,RPPPN,RPBPJU,RPTRAFO,";
            sql += "RPMAT,RPPLN , RPTAG, RPSUBSIDI,";
            sql += "TGLJTTEMPO,RPBK1, RPBK2, RPBK3, KDGERAK,STATUS, KDKOREKSI, TGKOREKSI,KDPEMBPP,";
            sql += "NOREK,  TGLKONSLD, KONSLDKE,IPADDRESS, LAYERKE,KDGERAK2,KOREKSIKE) ";
            sql += "values (";
            sql += "'" + no_pelanggan.substring(1, 5) + "'";            // unitup
            sql += ",'" + no_pelanggan + "'";                           // idpel
            sql += ",'" + bl_th_tagihan(URAIAN) + "'";                  // blth
            sql += ",'" + dr_dil.get("kodepp").substring(1, 2) + "'";   //kodepp
            sql += ",'" + dr_dil.get("kodya_kabupaten") + "'";
            sql += ",'" + dr_dil.get("nama_pelanggan") + "'";
            sql += ",'" + dr_dil.get("jalan") + "'";
            sql += ",'" + dr_dil.get("nama_jalan") + "'";
            sql += ",'" + dr_dil.get("no_bangunan") + "'";
            sql += ",'" + dr_dil.get("rt") + "'";
            sql += ",'" + dr_dil.get("rw") + "'";
            sql += ",'" + dr_dil.get("kode_pos") + "'";
            sql += ",'" + dr_dil.get("tarip") + "'";
            sql += ",'" + dr_dil.get("daya") + "'";
            sql += ",'" + dr_dil.get("kode_kva") + "'";
            sql += ",'" + dr_dil.get("kode_golongan") + "'";
            sql += ",'" + dr_dildatastandmeter.get("standawallwbpkwh") + "'";
            sql += ",'" + dr_dildatastandmeter.get("standakhirlwbpkwh") + "'";
            sql += ",'" + dr_dildatastandmeter.get("standawalwbp") + "'";
            sql += ",'" + dr_dildatastandmeter.get("standakhirwbp") + "'";
            sql += ",'" + dr_dildatastandmeter.get("standawalkvarh") + "'";
            sql += ",'" + dr_dildatastandmeter.get("standakhirkvarh") + "'";
            sql += ",'" + dr_dildatastandmeter.get("faktor_kali_meter") + "'";
            sql += ",'" + dr_dilmeter.get("faktor_kali_kvarh") + "'";
            sql += ",'" + dr_dildatastandmeter.get("kwhlwbp") + "'";
            sql += ",'" + dr_dildatastandmeter.get("kwhwbp") + "'";
            sql += ",'" + dr_dildatastandmeter.get("kwhblok3") + "'";
            sql += ",'" + dr_dildatastandmeter.get("kvarh") + "'";
            sql += ",'" + rplwbp + "'";
            sql += ",'" + rpwbp + "'";
            sql += ",'" + rpblok3 + "'";
            sql += ",'" + rpkvarh + "'";
            sql += ",'" + RPBEBAN_VAL + "'";
            sql += ",'" + RPPPN_VAL + "'";
            sql += ",'" + RPBPJU_VAL + "'";
            sql += ",'" + RPTRAFO_VAL + "'";
            sql += ",'" + RPMATERAI_VAL + "'";
            sql += ",'" + rppln_val + "'";
            sql += ",'" + rptag_val + "'";
            sql += ",'" + rpdiskon_val + "'";
            sql += ",'" + retFunc.get("wsReturn") + "'";
            sql += ",'" + RPBK1_VAL + "'";
            sql += ",'" + RPBK2_VAL + "'";
            sql += ",'" + RPBK3_VAL + "'";
            sql += ",'" + KDGERAK + "'";            //' kodegerak
            sql += ",'L'";                          // status
            sql += ",''";                           // kdkoreksi
            sql += ",to_char(sysdate,'ddmmyyyy')";  // tgkoreksi
            sql += ",'R1'";                         // kdpembpp
            sql += ",''";                           //' norek
            sql += ",trunc(sysdate)";               //tglkonsld
            sql += ",'" + retFunc2.get("wsReturn") + "'";
            sql += ",'" + ipaddress + "'";
            sql += ",'1'";                          // layer ke
            sql += ",''";                           // kdgerak2
            sql += ",'1'";                          // koreksi ke
            sql += ") ";
                    
                    

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
    public Map<String, Object> simpanDKRPLoad(String idpel,
                                              String blth,
                                              String kdkoreksi,
                                              String ipaddress) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="select * from sip3user.dpp where idpel='" + idpel + "' and blth='" + blth + "'" ;

            CallableStatement cst;
            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);
            Map<String, String> rowData = lMapData.get(0);


            sql = "insert into sip3user.dkrp_load ";
            sql += "( UNITUP,KDPEMBAYAR,idpel,blth,KDPP,TGLBAYAR,PEMDA,NAMA,PNJ";
            sql += ",NAMAPNJ,NOBANG,KETNOBANG,RT,RW,NODLMRT,KETNODLMRT,LINGKUNGAN";
            sql += ",KODEPOS,TARIP,DAYA,KDAYA,KOGOL,NOPEL,FRT,KDDK,TGLBACA,SLALWBP";
            sql += ",SAHLWBP,SLAWBP,SAHWBP,SLAKVARH,SAHKVARH,FAKM,FAKMKVARH,KWHLWBP";
            sql += ",KWHWBP,BLOK3,PEMKWH,KWHKVARH,RPLWBP,RPWBP,RPBLOK3,RPKVARH,RPBEBAN";
            sql += ",CTTLB,RPTTLB,RPPTL,RPTB,RPPPN,RPBPJU,RPTRAFO,KDANGSA,RPANGSA";
            sql += ",KDANGSB,RPANGSB,KDANGSC,RPANGSC,RPMAT,RPPLN,RPTAG,RPPRODUKSI";
            sql += ",RPSUBSIDI,TGLJTTEMPO,RPBK1,RPBK2,RPBK3,KDGERAK,STATUS,kdkoreksi";
            sql += ",TGKOREKSI,KDPEMBPP,RPTDLLAMA,RPTDLBARU,RPSELISIH";
            sql += ",RPREDUKSI,NOREK,TGLKONSLD,KONSLDKE,ipaddress,LAYERKE,kdgerak2,koreksike) ";
            sql += "values( ";
            sql += "'" + rowData.get("UNITUP") + "','" + rowData.get("KDPEMBAYAR") + "','" + rowData.get("IDPEL") + "',";
            sql += "'" + rowData.get("BLTH") + "','" + rowData.get("KDPP") + "','" + rowData.get("TGLBAYAR") + "',";
            sql += "'" + rowData.get("PEMDA") + "','" + rowData.get("NAMA") + "','" + rowData.get("PNJ") + "',";
            sql += "'" + rowData.get("NAMAPNJ") + "','" + rowData.get("NOBANG") + "','" + rowData.get("KETNOBANG") + "',";
            sql += "'" + rowData.get("RT") + "','" + rowData.get("RW") + "','" + rowData.get("NODLMRT") + "',";
            sql += "'" + rowData.get("KETNODLMRT") + "','" + rowData.get("LINGKUNGAN") + "','" + rowData.get("KODEPOS") + "',";
            sql += "'" + rowData.get("TARIP") + "','" + rowData.get("DAYA") + "','" + rowData.get("KDAYA") + "',";
            sql += "'" + rowData.get("KOGOL") + "','" + rowData.get("NOPEL") + "','" + rowData.get("FRT") + "',";
            sql += "'" + rowData.get("KDDK") + "','" + rowData.get("TGLBACA") + "','" + rowData.get("SLALWBP") + "',";
            sql += "'" + rowData.get("SAHLWBP") + "','" + rowData.get("SLAWBP") + "','" + rowData.get("SAHWBP") + "',";
            sql += "'" + rowData.get("SLAKVARH") + "','" + rowData.get("SAHKVARH") + "','" + rowData.get("FAKM") + "',";
            sql += "'" + rowData.get("FAKMKVARH") + "','" + rowData.get("KWHLWBP") + "','" + rowData.get("KWHWBP") + "',";
            sql += "'" + rowData.get("BLOK3") + "','" + rowData.get("PEMKWH") + "','" + rowData.get("KWHKVARH") + "',";
            sql += "'" + rowData.get("RPLWBP") + "','" + rowData.get("RPWBP") + "','" + rowData.get("RPBLOK3") + "',";
            sql += "'" + rowData.get("RPKVARH") + "','" + rowData.get("RPBEBAN") + "','" + rowData.get("CTTLB") + "',";
            sql += "'" + rowData.get("RPTTLB") + "','" + rowData.get("RPPTL") + "','" + rowData.get("RPTB") + "',";
            sql += "'" + rowData.get("RPPPN") + "','" + rowData.get("RPBPJU") + "','" + rowData.get("RPTRAFO") + "',";
            sql += "'" + rowData.get("KDANGSA") + "','" + rowData.get("RPANGSA") + "','" + rowData.get("KDANGSB") + "',";
            sql += "'" + rowData.get("RPANGSB") + "','" + rowData.get("KDANGSC") + "','" + rowData.get("RPANGSC") + "',";
            sql += "'" + rowData.get("RPMAT") + "','" + rowData.get("RPPLN") + "','" + rowData.get("RPTAG") + "',";
            sql += "'" + rowData.get("RPPRODUKSI") + "','" + rowData.get("RPSUBSIDI") + "','" + rowData.get("TGLJTTEMPO") + "',";
            sql += "'" + rowData.get("RPBK1") + "','" + rowData.get("RPBK2") + "','" + rowData.get("RPBK3") + "',";
            sql += "'12','" + rowData.get("STATUS") + "','" + kdkoreksi + "',";
            sql += "to_char(sysdate,'ddmmyyyy'),'" + rowData.get("KDPEMBPP") + "','" + rowData.get("RPTDLLAMA") + "',";
            sql += "'" + rowData.get("RPTDLBARU") + "','" + rowData.get("RPSELISIH") + "','" + rowData.get("RPREDUKSI") + "',";
            sql += "'" + rowData.get("NOREK") + "',trunc(sysdate),'" + uploadKe("DKRP") + "',";
            sql += "'" + ipaddress + "','1','21','1')";

            retValue.put("wsReturn", true);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
        }
        return retValue;
    }


    @Override
    public Map<String, Object> simpandkrpload_Krk_kd_golongan(String kdkol,
                                                              String ipaddress) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();
        List<Map<String,String>> lMapDataNoPelanggan = new ArrayList<Map<String,String>>();

        String NoPelanggan;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="select a.no_pelanggan,a.uraian as blth,sum(a.mutasi) as rptag from dis a, temptul504kolektif b " ;
            sql += " where a.NO_PELANGGAN = b.NO_PELANGGAN ";
            sql += " and UPPER(b.kodekolektif) = '"; // + kdkol.ToUpper + "' ";
            sql += " group by a.no_pelanggan,a.uraian ";

            CallableStatement cst;
            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            for(Map<String, String> rowData : lMapData) {
                NoPelanggan = rowData.get("no_pelanggan");

                sql = "select * from sip3user.dpp where idpel='" + NoPelanggan + "' ";
                cst = con.prepareCall(sql);
                rs = cst.executeQuery();
                lMapDataNoPelanggan = CommonModule.convertResultsetToListStr(rs);
                Map<String, String> dr = lMapDataNoPelanggan.get(lMapDataNoPelanggan.size() -1);


                sql = "insert into sip3user.dkrp_load ";
                sql += "values( ";
                sql += "'" + dr.get("UNITUP") + "','" + dr.get("KDPEMBAYAR") + "','" + dr.get("IDPEL") + "',";
                sql += "'" + dr.get("BLTH") + "','" + dr.get("KDPP") + "','" + dr.get("TGLBAYAR") + "',";
                sql += "'" + dr.get("PEMDA") + "','" + dr.get("NAMA") + "','" + dr.get("PNJ") + "',";
                sql += "'" + dr.get("NAMAPNJ") + "','" + dr.get("NOBANG") + "','" + dr.get("KETNOBANG") + "',";
                sql += "'" + dr.get("RT") + "','" + dr.get("RW") + "','" + dr.get("NODLMRT") + "',";
                sql += "'" + dr.get("KETNODLMRT") + "','" + dr.get("LINGKUNGAN") + "','" + dr.get("KODEPOS") + "',";
                sql += "'" + dr.get("TARIP") + "','" + dr.get("DAYA") + "','" + dr.get("KDAYA") + "',";
                sql += "'1','" + dr.get("NOPEL") + "','" + dr.get("FRT") + "',";
                sql += "'" + dr.get("KDDK") + "','" + dr.get("TGLBACA") + "','" + dr.get("SLALWBP") + "',";
                sql += "'" + dr.get("SAHLWBP") + "','" + dr.get("SLAWBP") + "','" + dr.get("SAHWBP") + "',";
                sql += "'" + dr.get("SLAKVARH") + "','" + dr.get("SAHKVARH") + "','" + dr.get("FAKM") + "',";
                sql += "'" + dr.get("FAKMKVARH") + "','" + dr.get("KWHLWBP") + "','" + dr.get("KWHWBP") + "',";
                sql += "'" + dr.get("BLOK3") + "','" + dr.get("PEMKWH") + "','" + dr.get("KWHKVARH") + "',";
                sql += "'" + dr.get("RPLWBP") + "','" + dr.get("RPWBP") + "','" + dr.get("RPBLOK3") + "',";
                sql += "'" + dr.get("RPKVARH") + "','" + dr.get("RPBEBAN") + "','" + dr.get("CTTLB") + "',";
                sql += "'" + dr.get("RPTTLB") + "','" + dr.get("RPPTL") + "','" + dr.get("RPTB") + "',";
                sql += "'" + dr.get("RPPPN") + "','" + dr.get("RPBPJU") + "','" + dr.get("RPTRAFO") + "',";
                sql += "'" + dr.get("KDANGSA") + "','" + dr.get("RPANGSA") + "','" + dr.get("KDANGSB") + "',";
                sql += "'" + dr.get("RPANGSB") + "','" + dr.get("KDANGSC") + "','" + dr.get("RPANGSC") + "',";
                sql += "'" + dr.get("RPMAT") + "','" + dr.get("RPPLN") + "','" + dr.get("RPTAG") + "',";
                sql += "'" + dr.get("RPPRODUKSI") + "','" + dr.get("RPSUBSIDI") + "','" + dr.get("TGLJTTEMPO") + "',";
                sql += "'" + dr.get("RPBK1") + "','" + dr.get("RPBK2") + "','" + dr.get("RPBK3") + "',";
                sql += "'12','" + dr.get("STATUS") + "','F',";
                sql += "to_char(sysdate,'ddmmyyyy'),'" + dr.get("KDPEMBPP") + "','" + dr.get("RPTDLLAMA") + "',";
                sql += "'" + dr.get("RPTDLBARU") + "','" + dr.get("RPSELISIH") + "','" + dr.get("RPREDUKSI") + "',";
                sql += "'" + dr.get("NOREK") + "',trunc(sysdate),'" + uploadKe("DKRP") + "',";
                sql += "'" + ipaddress + "','1','','1')";

                cst = con.prepareCall(sql);
                cst.execute();

            }


            retValue.put("wsReturn", true);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
        }
        return retValue;
    }


    @Override
    public Map<String, Object> simpanDKRPL(String idpel,
                                           String no_kwitansi,
                                           String IPADDRESS) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;

            String sql ="select * from sip3user.dpp where idpel='" + idpel + "' ";

            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);
            Map<String, String> dr = lMapData.get(lMapData.size()-1);

            String kdkoreksi = "A";

            sql = "select * from rekappll where no_pelanggan='" + idpel + "' and nokwitansi LIKE '%" + no_kwitansi + "'";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);
            Map<String, String> dr2 = lMapData.get(0);


            sql = "insert into sip3user.dkrp_load values( ";
            sql += "'" + dr.get("unitup") + "','" + dr.get("KDPEMBAYAR") + "','" + idpel + "',";
            sql += "'" + dr.get("BLTH") + "','" + dr.get("KDPP") + "','" + dr.get("TGLBAYAR") + "',";
            sql += "'" + dr.get("PEMDA") + "','" + dr.get("NAMA") + "','" + dr.get("PNJ") + "',";
            sql += "'" + dr.get("NAMAPNJ") + "','" + dr.get("NOBANG") + "','" + dr.get("KETNOBANG") + "',";
            sql += "'" + dr.get("RT") + "','" + dr.get("RW") + "','" + dr.get("NODLMRT") + "',";
            sql += "'" + dr.get("KETNODLMRT") + "','" + dr.get("LINGKUNGAN") + "','" + dr.get("KODEPOS") + "',";
            sql += "'" + dr.get("TARIP") + "','" + dr.get("DAYA") + "','" + dr.get("KDAYA") + "',";
            sql += "'" + dr.get("KOGOL") + "','" + dr.get("NOPEL") + "','" + dr.get("FRT") + "',";
            sql += "'" + dr.get("KDDK") + "','" + dr.get("TGLBACA") + "','" + dr.get("SLALWBP") + "',";
            sql += "'" + dr.get("SAHLWBP") + "','" + dr.get("SLAWBP") + "','" + dr.get("SAHWBP") + "',";
            sql += "'" + dr.get("SLAKVARH") + "','" + dr.get("SAHKVARH") + "','" + dr.get("FAKM") + "',";
            sql += "'" + dr.get("FAKMKVARH") + "','" + dr2.get("KWH_LWBP") + "','" + dr2.get("KWH_WBP") + "',";
            sql += "'" + dr2.get("KWH_BLOK3") + "','" + dr2.get("KWH") + "','" + dr.get("KWHKVARH") + "',";
            sql += "'" + dr.get("RPLWBP") + "','" + dr.get("RPWBP") + "','" + dr.get("RPBLOK3") + "',";
            sql += "'" + dr.get("RPKVARH") + "','" + dr2.get("RP_BEBAN") + "','" + dr.get("CTTLB") + "',";
            sql += "'" + dr.get("RPTTLB") + "','" + dr2.get("RP_PLL") + "','" + dr.get("RPTB") + "',";
            sql += "'" + dr.get("RPPPN") + "','" + dr2.get("RP_PPJU") + "','" + dr.get("RPTRAFO") + "',";
            sql += "'" + dr.get("KDANGSA") + "','" + dr.get("RPANGSA") + "','" + dr.get("KDANGSB") + "',";
            sql += "'" + dr.get("RPANGSB") + "','" + dr.get("KDANGSC") + "','" + dr.get("RPANGSC") + "',";
            sql += "'" + dr2.get("RP_MATERAI") + "','" + dr.get("RPPLN") + "','" + dr.get("RPTAG") + "',";
            sql += "'" + dr.get("RPPRODUKSI") + "','" + dr.get("RPSUBSIDI") + "','" + dr.get("TGLJTTEMPO").replace("/","").replace("-","")  + "',";
            sql += "'" + dr.get("RPBK1") + "','" + dr.get("RPBK2") + "','" + dr.get("RPBK3") + "',";
            sql += "'11','" + dr.get("STATUS") + "','" + kdkoreksi + "',";
            sql += "to_char(sysdate,'ddmmyyyy'),'" + dr.get("KDPEMBPP") + "','" + dr.get("RPTDLLAMA") + "',";
            sql += "'" + dr.get("RPTDLBARU") + "','" + dr.get("RPSELISIH") + "','" + dr.get("RPREDUKSI") + "',";
            sql += "'" + dr.get("NOREK") + "',trunc(sysdate),'" + uploadKe("DKRP") + "',";
            sql += "'" + IPADDRESS + "','1','21','1')";

            retValue.put("wsReturn", true);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
        }
        return retValue;
    }


    @Override
    public Map<String, Object> simpanDBPLoad(String nopelanggan,
                                      String blth,
                                      String ipaddress,
                                      String kodegerak) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            retFunc = uploadKe("DBP");
            
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;

            String sql ="select * from sip3user.dpp where idpel='";

            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            Map<String, String> dr = lMapData.get(0);

            sql = "insert into sip3user.dbp_load ";
            sql += "(IDPEL,blth,KDPEMBPP,UNITUP,KDGERAK,TGKOREKSI,RPTAG,TGLKONSLD,KONSLDKE,ipaddress,LAYERKE,iskoreksi) ";
            sql += "values ('" + nopelanggan + "','" + blth + "',";
            sql += "'R1','" + dr.get("unitup") + "',";
            sql += "'" + kodegerak + "',to_char(sysdate,'ddmmyyyy'),";
            sql += "'" + dr.get("rptag") + "',trunc(sysdate),";
            sql += "'" + retFunc.get("wsReturn") + "','" + ipaddress + "','1','N')";

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
    public Map<String, Object> uploadKe(String jenisdata) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="select max(konsldke) from sip3user.log_upload where tgljamupload=to_date(sysdate,'dd-mm-yyyy') and jenisdata='" + jenisdata + "'" ;

            CallableStatement cst;
            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", Integer.parseInt(lMapData.get(0).get(0)) + 1);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", 1);
        }
        return retValue;
    }


    @Override
    public Map<String, Object> uploadKeAJN() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="select max(konsldke) from sip3user.dph_load where tglkonsld=to_date(sysdate,'dd-mm-yyyy') " ;

            CallableStatement cst;
            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", Integer.parseInt(lMapData.get(0).get(0)) + 1);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "1");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> kodeKoreksi(String alasan) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        //A = Daftar pelanggan yang perlu diperhatikan.
        //B = Gagal proses peremajaan DIL
        //C = Komplain Pelanggan
        //D = Pembetulan Piutang dengan restitusi.
        //E = Pembatalan Pelunasan salah-bayar.

        try
        {

            if (alasan.trim().toUpperCase().equals("DAFTAR PELANGGAN YANG PERLU DIPERHATIKAN")) {
                retValue.put("wsReturn", "A");
            } else if (alasan.trim().toUpperCase().equals("GAGAL PEREMAJAAN DIL")) {
                retValue.put("wsReturn", "B");
            } else if (alasan.trim().toUpperCase().equals("KOMPLAIN PELANGGAN")) {
                retValue.put("wsReturn", "C");
            } else if (alasan.trim().toUpperCase().equals("SUPLISI")) {
                retValue.put("wsReturn", "D");
            } else if (alasan.trim().toUpperCase().equals("RESTITUSI")) {
                retValue.put("wsReturn", "D");
            } else if (alasan.trim().toUpperCase().equals("PEMBATALAN PELUNASAN SALAH BAYAR")) {
                retValue.put("wsReturn", "E");
            } else if (alasan.trim().toUpperCase().equals("KOREKSI KODE GOLONGAN")) {
                retValue.put("wsReturn", "F");
            }

        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }

    @Override
    public Map<String, Object> bl_th(String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        if (blth.substring(4,2).equals("01")) {
            retValue.put("wsReturn", "01" + blth.substring(1,4));
        } else if (blth.substring(4,2).equals("02")) {
            retValue.put("wsReturn", "02" + blth.substring(1,4));
        } else if (blth.substring(4,2).equals("03")) {
            retValue.put("wsReturn", "03" + blth.substring(1,4));
        } else if (blth.substring(4,2).equals("04")) {
            retValue.put("wsReturn", "04" + blth.substring(1,4));
        } else if (blth.substring(4,2).equals("05")) {
            retValue.put("wsReturn", "05" + blth.substring(1,4));
        } else if (blth.substring(4,2).equals("06")) {
            retValue.put("wsReturn", "06" + blth.substring(1,4));
        } else if (blth.substring(4,2).equals("07")) {
            retValue.put("wsReturn", "07" + blth.substring(1,4));
        } else if (blth.substring(4,2).equals("08")) {
            retValue.put("wsReturn", "08" + blth.substring(1,4));
        } else if (blth.substring(4,2).equals("09")) {
            retValue.put("wsReturn", "09" + blth.substring(1,4));
        } else if (blth.substring(4,2).equals("10")) {
            retValue.put("wsReturn", "10" + blth.substring(1,4));
        } else if (blth.substring(4,2).equals("11")) {
            retValue.put("wsReturn", "11" + blth.substring(1,4));
        } else if (blth.substring(4,2).equals("12")) {
            retValue.put("wsReturn", "12" + blth.substring(1,4));
        }

        return retValue;
    }


    @Override
    public Map<String, Object> setRek_Sorek(String procedureName,
                                            String unitup,
                                            String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String namaTabel = "", thbl = blth.substring(3,4) + blth.substring(1,2);

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            for (Integer i = 1; i <=3; i++) {
                switch (i) {
                    case 1: namaTabel = "REK_" + unitup + "_A_" + thbl;
                        break;
                    case 2: namaTabel = "REK_" + unitup + "_B_" + thbl;
                        break;
                    case 3: namaTabel = "REK_" + unitup + "_K_" + thbl;
                        break;

                }

                String sql ="INSERT INTO SIP3user.SOREK_LOAD " ;
                sql += " (UNITUP,KDPEMBAYAR,IDPEL,blth,KDPP,TGLBAYAR,PEMDA";
                sql += ",NAMA,PNJ,NAMAPNJ,NOBANG,KETNOBANG,RT,RW,NODLMRT";
                sql += ",KETNODLMRT,LINGKUNGAN,KODEPOS,TARIP,DAYA,KDAYA,KOGOL";
                sql += ",NOPEL,FRT,KDDK,TGLBACA,SLALWBP,SAHLWBP,SLAWBP,SAHWBP,SLAKVARH";
                sql += ",SAHKVARH,FAKM,FAKMKVARH,KWHLWBP,KWHWBP,BLOK3,PEMKWH";
                sql += ",KWHKVARH,RPLWBP,RPWBP,RPBLOK3,RPKVARH,RPBEBAN,CTTLB,RPTTLB,RPPTL" ;
                sql += ",RPTB,RPPPN,RPBPJU,RPTRAFO,KDANGSA,RPANGSA,KDANGSB,RPANGSB,KDANGSC";
                sql += ",RPANGSC,RPMAT,RPPLN,RPTAG,RPPRODUKSI,RPSUBSIDI,TGLJTTEMPO,RPBK1,RPBK2";
                sql += ",RPBK3,KDGERAK,STATUS,KDKOREKSI,TGKOREKSI,KDPEMBPP,RPTDLLAMA";
                sql += ",RPTDLBARU,RPSELISIH,RPREDUKSI,NOREK,ALAMAT,KDPPJ,KELOMPOK,JNSMUT";
                sql += ",BLTHMUT,KDMUT,TGLNYALA, KDAM,NOGARDU,NOTIANG,RPSEWAKAP,KWHBLOK1";
                sql += ",KWHBLOK2,RPBLOK1,RPBLOK2,RPDISKON,TRPBEBAN,TRPBLOK1,TRPBLOK2,TRPBLOK3,TRPLWBP";
                sql += ",TRPWBP,TRPKVARH,TGLKONSLD,KONSLDKE,IPADDRESS,LAYERKE) ";
                sql += "SELECT ";
                sql += "UNIT ";
                sql += ",KDPEMBAYAR";
                sql += ",IDPEL";
                sql += ",SUBSTR(BLTHREK,5,2)||SUBSTR(BLTHREK,1,4) "; // 'blth;
                sql += ",KDPP" ;
                sql += ",NULL "; // 'TGLBAYAR";
                sql += ",KDPEMDA "; // 'PEMDA";
                sql += ",SUBSTR(NAMA,1,25)";
                sql += ",PNJ";
                sql += ",NAMAPNJ";
                sql += ",NOBANG";
                sql += ",NULL "; // 'KETNOBANG";
                sql += ",RT";
                sql += ",RW";
                sql += ",NODLMRT";
                sql += ",KETNODLMRT";
                sql += ",LINGKUNGAN";
                sql += ",NULL "; // 'KODEPOS";
                sql += ",TARIP";
                sql += ",DAYA";
                sql += ",KDDAYA "; // 'KDAYA";
                sql += ",KDGOL "; // 'KOGOL";
                sql += ",SUBSTR(IDPEL,1,11) "; // 'NOPEL";
                sql += ",FRT";
                sql += ",KDDK";
                sql += ",TO_CHAR(TGLBACA,'ddmmyyyy')";
                sql += ",SLALWBP";
                sql += ",SAHLWBP";
                sql += ",SLAWBP";
                sql += ",SAHWBP";
                sql += ",SLAKVARH" ;
                sql += ",SAHKVARH";
                sql += ",FAKM";
                sql += ",FAKMKVARH";
                sql += ",KWHLWBP";
                sql += ",KWHWBP";
                sql += ",KWHBLOK3 "; // 'BLOK3";
                sql += ",KWHLWBP+KWHWBP+KWHBLOK1+KWHBLOK2+KWHBLOK3 "; // 'PEMKWH" ;
                sql += ",KWHKVARH";
                sql += ",RPLWBP";
                sql += ",RPWBP";
                sql += ",RPBLOK3";
                sql += ",RPKVARH";
                sql += ",RPBEBAN";
                sql += ",NULL "; // 'CTTLB" ;
                sql += ",0 "; // 'RPTTLB" ;
                sql += ",RPPTL";
                sql += ",0 "; // 'RPTB";
                sql += ",RPPPN";
                sql += ",RPPJU "; // 'RPBPJU";
                sql += ",RPSEWATRF "; // 'RPTRAFO";
                sql += ",KDANGSA";
                sql += ",RPANGSA";
                sql += ",KDANGSB";
                sql += ",RPANGSB";
                sql += ",KDANGSC";
                sql += ",RPANGSC";
                sql += ",RPMAT";
                sql += ",RPPLN";
                sql += ",RPTAG";
                sql += ",RPRDUKSI "; // 'RPPRODUKSI";
                sql += ",0 "; // 'RPSUBSIDI";
                sql += ", TO_CHAR(TRUNC(LAST_DAY(TO_DATE(BLTHREK,'YYYYMM'))),'DDMMYYYY') "; // 'TGLJTTEMPO" ;
                sql += ",RPBK " ; //'RPBK1" ;
                sql += ",0 "; // 'RPBK2";
                sql += ",0 "; // 'RPBK3" ;
                sql += ",'11' "; // 'KDGERAK";
                sql += ",'L' "; // 'STATUS";
                sql += ",NULL "; // 'KDKOREKSI";
                sql += ",NULL "; // 'TGKOREKSI";
                sql += ",'R1' "; // 'KDPEMBPP";
                sql += ",0 "; // 'RPTDLLAMA";
                sql += ",0 " ; //'RPTDLBARU";
                sql += ",0 "; // 'RPSELISIH";
                sql += ",RPDISKON " ; //'RPREDUKSI";
                sql += ",'XXXXXX' "; // 'NOREK" ;
                sql += ",ALAMAT";
                sql += ",KDPPJ";
                sql += ",KELOMPOK";
                sql += ",JNSMUT";
                sql += ",BLTHMUT";
                sql += ",KDMUT";
                sql += ",TGLNYALA";
                sql += ",KDAM";
                sql += ",NOGARDU";
                sql += ",NOTIANG";
                sql += ",RPSEWAKAP";
                sql += ",KWHBLOK1";
                sql += ",KWHBLOK2";
                sql += ",RPBLOK1";
                sql += ",RPBLOK2";
                sql += ",RPDISKON";
                sql += ",TRPBEBAN";
                sql += ",TRPBLOK1";
                sql += ",TRPBLOK2";
                sql += ",TRPBLOK3";
                sql += ",TRPLWBP";
                sql += ",TRPWBP";
                sql += ",TRPKVARH";
                sql += ",TRUNC(SYSDATE)";   // 'TGLKONSLD" ;
                sql += ",'1' KONSLDKE";
                sql += ",'10.4.130.23' ";   // 'IPADDRESS";
                sql += ",1 ";               // 'LAYERKE ";
                sql += "FROM BILLING." + namaTabel + "" ;

                CallableStatement cst;
                cst = con.prepareCall(sql);
                cst.execute();
            }

            retValue.put("wsReturn", true);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
        }
        return retValue;     }


    @Override
    public Map<String, Object> setLunas(String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "update dis set lunas='Lunas' ," ;
            sql += "tgl_pelunasan=tgl_jatuh_tempo,cetak='YA',";
            sql += "kode_gerak_keluar=29,kodepetugas='" + petugas + "', ";
            sql += "jenis_pp='OFFLINE' where lunas is null ";

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
    public Map<String, Object> setSaldo(String baris_txt) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String item[] = baris_txt.split("#");
        try
        {
            retFunc = getBlThRekening(item[2]);

            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;

            String sql ="insert into saldo_awal (blthsaldo,no_pelanggan,blthrek,rptag) " ;
            sql += "values ('" + item[2] + "','" + item[1] + "','" + retFunc.get("wsReturn") + "','" + item[3] + "')";

            cst = con.prepareCall(sql);
            cst.execute();

            retFunc = getUraian(item[2]);

            sql = "update dis set lunas = null , tgl_pelunasan=null ,";
            sql += "cetak=null,kode_gerak_keluar=null,kodepetugas=null ";
            sql += ",jenis_pp=null where no_pelanggan='" + item[1] + "' ";
            sql += "and uraian='" + retFunc.get("wsReturn") + "' ";

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
    public Map<String, Object> getUraian(String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        if (blth.substring(4,2).equals("01")) {
            retValue.put("wsReturn", "Des-" + (Integer.parseInt(blth.substring(3, 4)) - 1));
        } else if (blth.substring(4,2).equals("02")) {
            retValue.put("wsReturn", "Jan-" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("03")) {
            retValue.put("wsReturn", "Feb-" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("04")) {
            retValue.put("wsReturn", "Mar-" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("05")) {
            retValue.put("wsReturn", "Apr-" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("06")) {
            retValue.put("wsReturn", "Mei-" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("07")) {
            retValue.put("wsReturn", "Jun-" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("08")) {
            retValue.put("wsReturn", "Jul-" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("09")) {
            retValue.put("wsReturn", "Agu-" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("10")) {
            retValue.put("wsReturn", "Sep-" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("11")) {
            retValue.put("wsReturn", "Okt-" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("12")) {
            retValue.put("wsReturn", "Nop-" + blth.substring(3,4));
        }

        return retValue;
    }


    @Override
    public Map<String, Object> getBlThRekening(String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        if (blth.substring(4,2).equals("01")) {
            retValue.put("wsReturn", "12" + (Integer.parseInt(blth.substring(3, 4)) - 1));
        } else if (blth.substring(4,2).equals("02")) {
            retValue.put("wsReturn", "01" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("03")) {
            retValue.put("wsReturn", "02" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("04")) {
            retValue.put("wsReturn", "03" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("05")) {
            retValue.put("wsReturn", "04" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("06")) {
            retValue.put("wsReturn", "05" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("07")) {
            retValue.put("wsReturn", "06" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("08")) {
            retValue.put("wsReturn", "07" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("09")) {
            retValue.put("wsReturn", "08" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("10")) {
            retValue.put("wsReturn", "09" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("11")) {
            retValue.put("wsReturn", "10" + blth.substring(3,4));
        } else if (blth.substring(4,2).equals("12")) {
            retValue.put("wsReturn", "11" + blth.substring(3,4));
        }

        return retValue;
    }


    @Override
    public Map<String, Object> cekrekbermasalah(String tgllunas,
                                                String idpel,
                                                String sbb) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;

            String sql ="" ;
            sql = sql + " SELECT NO_PELANGGAN FROM rekeningbermasalah";
            sql = sql + " WHERE NO_PELANGGAN='" + idpel + "'";
            sql = sql + " AND PENYEBAB='" + sbb + "'";
            sql = sql + " AND to_char(tglpelunasan,'dd-mm-yyyy')='" + tgllunas + "'";

            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() > 0) {
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
    public Map<String, Object> setPelunasanOffline(String strread,
                                                   String strGlobalKodePetugas,
                                                   String ipaddress) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String strNoPelanggan;   // 12 karakter
        String strNoPelangganmsl;
        String strTglLunas;      // 8 karakter
        String strBlthRekening;  // 6 karakter
        String strNomorRekening; // 6 karakter
        String strKodePP;        // 14 karakter
        String strKodePetugas;   // 6 karakter
        String strRpTagih;       // 11 karakter
        String strKwhPakai;      // 7 karakter
        String strRpPLN;         // 11 karakter
        String strRpMat;         // 5 karakter
        String strRpPPJU;        // 8 karakter
        String strRpPPn;         // 8 karakter
        String strRpDiskon;      // 7 karakter
        String strRpCilx;        // 7 karakter
        String strRpCilBP;       // 7 karakter
        String strRpCilUJL;      // 7 karakter
        String strRpSewa;        // 7 karakter
        String strKdGol;         // 1 karakter
        String strSQL;
        String strTahun, strTahun2;
        String strBulan;
        String strRekeningDouble;
        List<Map<String,String>> dsBlThRekening = new ArrayList<Map<String,String>>();
        List<Map<String,String>> dsPiutang = new ArrayList<Map<String,String>>();
        List<Map<String,String>> dsBelumLunas = new ArrayList<Map<String,String>>();
        List<Map<String,String>> dsSudahLunas = new ArrayList<Map<String,String>>();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

        String strTanggalUpload = formatter.format(new Date());
        Integer intTotalBermasalah = 0;
        Integer intTotalBerhasilUpload = 0;
        Integer intTotalKeseluruhanUpload = 0;
        Integer intTotalLembar = 0;
        Integer dblRupiahTotal = 0;
        Integer dblRupiahTerUpload = 0;
        Date datUraian;
        Integer dblTotalTagihan;
        Integer n;
        String Blth, Blth2;
        Integer i = 1;
        String kdPetugas;
        String kdGrkKeluar = "";


        strNoPelanggan = strread.substring(1, 12).trim();
        strTglLunas = strread.substring(13, 2) + "-" + strread.substring(15, 2) + "-" + strread.substring(17, 4);
        strBulan = strread.substring(21, 2);
        strTahun = strread.substring(23, 4);
        strTahun2 = strTahun.substring(3, 2);
        Blth2 = strBulan + strTahun2;
        Blth = strBulan + strTahun;
        String blthtag = "";

        switch (Integer.parseInt(Blth.substring(1,2))) {
            case 1 :
                strBulan = "Jan";
                blthtag = "02";
                break;
            case 2 :
                strBulan = "Feb";
                blthtag = "03";
                break;
            case 3 :
                strBulan = "Mar";
                blthtag = "04";
                break;
            case 4 :
                strBulan = "Apr";
                blthtag = "05";
                break;
            case 5 :
                strBulan = "Mei";
                blthtag = "06";
                break;
            case 6 :
                strBulan = "Jun";
                blthtag = "07";
                break;
            case 7 :
                strBulan = "Jul";
                blthtag = "08";
                break;
            case 8 :
                strBulan = "Agu";
                blthtag = "09";
                break;
            case 9 :
                strBulan = "Sep";
                blthtag = "10";
                break;
            case 10 :
                strBulan = "Okt";
                blthtag = "11";
                break;
            case 11 :
                strBulan = "Nop";
                blthtag = "12";
                break;
            case 12 :
                strBulan = "Des";
                blthtag = "01" + (Integer.parseInt(Blth.substring(3,4)));
                break;
        }

        strBlthRekening = strBulan + "-" + strTahun;
        strNomorRekening = strread.substring(27, 6).trim();
        strKodePP = strread.substring(33, 14).trim();
        strKodePetugas = strread.substring(47, 6).trim();
        strRpTagih = strread.substring(53, 11).trim();
        strKwhPakai = strread.substring(64, 6).trim();
        strRpPLN = strread.substring(70, 11).trim();
        strRpMat = strread.substring(81, 5).trim();
        strRpPPJU = strread.substring(86, 8).trim();
        strRpPPn = strread.substring(94, 8).trim();
        strRpDiskon = strread.substring(102, 7).trim();
        strRpCilx = strread.substring(109, 7).trim();
        strRpCilBP = strread.substring(116, 7).trim();
        strRpCilUJL = strread.substring(123, 7).trim();
        strRpSewa = strread.substring(130, 7).trim();
        strKdGol = strread.substring(137, 1).trim();
        if (strKdGol == null || strKdGol == "") {
            strKdGol = "0";
        }

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            ResultSet rs;

            retFunc = simpanDPHLoad_AJN(strNoPelanggan, blthtag, strTglLunas, strRpTagih, "0", ipaddress);


            strSQL = "SELECT No_pelanggan";
            strSQL = strSQL + " FROM DIS";
            strSQL = strSQL + " where No_Pelanggan = '" + strNoPelanggan + "'";
            cst = con.prepareCall(strSQL);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                strSQL = "insert into rekeningbermasalah";
                strSQL = strSQL + " (TglPelunasan,";
                strSQL = strSQL + " No_Pelanggan,";
                strSQL = strSQL + " Uraian,";
                strSQL = strSQL + " RupiahTagih,";
                strSQL = strSQL + " KodePetugas,";
                strSQL = strSQL + " Penyebab,";
                strSQL = strSQL + " tglupload)";
                strSQL = strSQL + " values (TO_DATE('" + strTglLunas + "','dd-mm-yyyy'),";
                strSQL = strSQL + " '" + strNoPelanggan + "',";
                strSQL = strSQL + " '" + strBlthRekening + "',";
                strSQL = strSQL + Integer.parseInt(strRpTagih) + ",";
                strSQL = strSQL + " '" + strKodePetugas + "',";
                strSQL = strSQL + " 'Bukan Pelanggan UP/AP ini',";
                strSQL = strSQL + " TO_DATE('" + strTanggalUpload + "','yyyy-mm-dd'))";

                retFunc = cekrekbermasalah(strTglLunas, strNoPelanggan, "Bukan Pelanggan UP/AP ini");

                if (!(Boolean)retFunc.get("wsReturn")) {
                    cst = con.prepareCall(strSQL);
                    cst.execute();

                    intTotalBermasalah++;

                    strSQL = "INSERT INTO DISLAIN";
                    strSQL = strSQL + " (Tgl_Pelunasan, No_Pelanggan,blthrek,RpTag,RPPln,RpMat,Tgl_transaksi,";
                    strSQL = strSQL + " RPPPJ,RpPPn,RpDisk,RpCilx,RpCilBP,RpCilUJL,RpSewa,kdgol,lunas,kode_petugas,tgl_upload) ";
                    strSQL = strSQL + " values (TO_DATE('" + strTglLunas + "','dd-mm-yyyy'),";
                    strSQL = strSQL + " '" + strNoPelanggan + "',";
                    strSQL = strSQL + " '" + Blth2 + "',";
                    strSQL = strSQL + Integer.parseInt(strRpTagih) + ",";
                    strSQL = strSQL + Integer.parseInt(strRpPLN) + ",";
                    strSQL = strSQL + Integer.parseInt(strRpMat) + ",";
                    strSQL = strSQL + " TO_DATE('" + strTanggalUpload + "','yyyy-mm-dd') ,";
                    strSQL = strSQL + Integer.parseInt(strRpPPJU) + ",";
                    strSQL = strSQL + Integer.parseInt(strRpPPn) + ",";
                    strSQL = strSQL + Integer.parseInt(strRpDiskon) + ",";
                    strSQL = strSQL + Integer.parseInt(strRpCilx) + ",";
                    strSQL = strSQL + Integer.parseInt(strRpCilBP) + ",";
                    strSQL = strSQL + Integer.parseInt(strRpCilUJL) + ",";
                    strSQL = strSQL + Integer.parseInt(strRpSewa) + ",";
                    strSQL = strSQL + " '" + strKdGol + "',";
                    strSQL = strSQL + " 'LUNAS',";
                    strSQL = strSQL + " '" + strKodePetugas + "',trunc(sysdate))";

                    cst = con.prepareCall(strSQL);
                    cst.execute();
                } else {
                    intTotalBermasalah++;
                }
            } else {
                dblRupiahTotal = dblRupiahTotal + Integer.parseInt(strRpTagih);

                strSQL = "SELECT to_char(Tgl_Jatuh_Tempo,'dd-mm-yyyy') tgl_jatuh_tempo";
                strSQL = strSQL + " FROM DIS";
                strSQL = strSQL + " WHERE (DIS.Lunas) is null ";
                strSQL = strSQL + " and DIS.No_Pelanggan ='" + strNoPelanggan + "'";
                strSQL = strSQL + " and DIS.Uraian= '" + strBlthRekening + "'";
                strSQL = strSQL + " group by DIS.Tgl_Jatuh_Tempo";

                if (!strBlthRekening.trim().equals("-")) {
                    cst = con.prepareCall(strSQL);
                    rs = cst.executeQuery();
                    dsBlThRekening = CommonModule.convertResultsetToListStr(rs);

                    if (dsBlThRekening.size() > 0) {
                        strSQL = "SELECT sum(DIS.MUTASI) as TotalMutasi ";
                        strSQL = strSQL + " FROM DIS";
                        strSQL = strSQL + " WHERE (DIS.Lunas) is null ";
                        strSQL = strSQL + " and DIS.No_Pelanggan= '" + strNoPelanggan + "'";
                        strSQL = strSQL + " and TO_CHAR(dis.Tgl_Jatuh_Tempo,'mm')= TO_CHAR(to_date('" + dsBlThRekening.get(0).get("Tgl_Jatuh_Tempo").replace("/", "-") + "','dd-mm-yyyy'),'mm')";
                        strSQL = strSQL + " and TO_CHAR(dis.Tgl_Jatuh_Tempo,'yy')= TO_CHAR(to_date('" + dsBlThRekening.get(0).get("Tgl_Jatuh_Tempo").replace("/", "-") + "','dd-mm-yyyy'),'yy')";
                        strSQL = strSQL + " group by DIS.Tgl_Jatuh_Tempo";

                        cst = con.prepareCall(strSQL);
                        rs = cst.executeQuery();
                        dsPiutang = CommonModule.convertResultsetToListStr(rs);

                        if(dsPiutang.size() > 0) {
                            if (Integer.parseInt(dsPiutang.get(0).get("TotalMutasi")) == Integer.parseInt(strRpTagih)) {
                                strSQL = "UPDATE DIS ";
                                strSQL = strSQL + " set tgl_Pelunasan=TO_DATE('" + strTglLunas + "','dd-mm-yyyy'),";
                                strSQL = strSQL + " kodepetugas='" + strKodePetugas + "',";
                                strSQL = strSQL + " saldo=0,";
                                strSQL = strSQL + " lunas='Lunas',";

                                if (strKodePetugas.trim().substring(1,4).toUpperCase() == "MANU") {
                                    strSQL = strSQL + " Jenis_PP='MANUAL',";
                                } else {
                                    strSQL = strSQL + " Jenis_PP='OFFLINE',";
                                }

                                strSQL = strSQL + " PetugasPenerimaOffline='" + strGlobalKodePetugas + "',";

                                if (strNoPelanggan.substring(3,3) == strKodePetugas.substring(1,3)) {
                                    kdGrkKeluar = "21";
                                } else {
                                    if (strKdGol.equals("1")) { kdGrkKeluar = "24";
                                    } else if (strKdGol.equals("2")) { kdGrkKeluar = "24";
                                    } else if (strKdGol.equals("3")) { kdGrkKeluar = "24";
                                    } else if (strKdGol.equals("4")) { kdGrkKeluar = "24";
                                    }
                                }

                                strSQL = strSQL + " KODE_GERAK_KELUAR='" + kdGrkKeluar + "',";
                                strSQL = strSQL + " cetak='Ya',";
                                strSQL = strSQL + " tgl_upload=trunc(sysdate) ";
                                strSQL = strSQL + " WHERE DIS.NO_PELANGGAN = '" + strNoPelanggan + "'";
                                strSQL = strSQL + " and dis.LUNAS IS NULL";
                                strSQL = strSQL + " and TO_CHAR(to_date(dis.Tgl_Jatuh_Tempo,'dd-mm-yyyy'),'mm')= TO_CHAR(to_date('" + dsBlThRekening.get(0).get("Tgl_Jatuh_Tempo") + "','dd-mm-yyyy'),'mm')";
                                strSQL = strSQL + " and TO_CHAR(to_date(dis.Tgl_Jatuh_Tempo,'dd-mm-yyyy'),'yy')= TO_CHAR(to_date('" + dsBlThRekening.get(0).get("Tgl_Jatuh_Tempo") + "','dd-mm-yyyy'),'yy')";
                                strSQL = strSQL + " and NO_AGENDA is null ";

                                cst = con.prepareCall(strSQL);
                                cst.execute();

                                dblRupiahTerUpload = dblRupiahTerUpload + Integer.parseInt(dsPiutang.get(0).get("TotalMutasi"));
                                intTotalBerhasilUpload++;

                            } else {  //tidak sama dgn Rupiah Tagih
                                strSQL = "INSERT INTO REKENINGBERMASALAH";
                                strSQL = strSQL + " (TglPelunasan,";
                                strSQL = strSQL + " No_Pelanggan,";
                                strSQL = strSQL + " Uraian,";
                                strSQL = strSQL + " RupiahTagih,";
                                strSQL = strSQL + " KodePetugas,";
                                strSQL = strSQL + " Penyebab,";
                                strSQL = strSQL + " tglupload)";
                                strSQL = strSQL + " values (TO_DATE('" + strTglLunas + "','dd-mm-yyyy'),";
                                strSQL = strSQL + " '" + strNoPelanggan + "',";
                                strSQL = strSQL + " '" + strBlthRekening + "',";
                                strSQL = strSQL + Integer.parseInt(strRpTagih) + ",";
                                strSQL = strSQL + " '" + strKodePetugas + "',";
                                strSQL = strSQL + " 'Total Tagihan Tidak Sama',";
                                strSQL = strSQL + " TO_DATE('" + strTanggalUpload + "','yyyy-mm-dd'))";

                                retFunc = cekrekbermasalah(strTglLunas, strNoPelanggan, "Total Tagihan Tidak Sama");

                                if (!(Boolean)retFunc.get("wsReturn")) {
                                    cst = con.prepareCall(strSQL);
                                    cst.execute();
                                    intTotalBermasalah++;
                                } else {
                                    intTotalBermasalah++;
                                }
                            }
                        } else {
                            strSQL = "SELECT sum(DIS.mutasi) as TotalMutasi ";
                            strSQL = strSQL + " FROM DIS";
                            strSQL = strSQL + " WHERE ucase(DIS.Lunas)='Lunas'";
                            strSQL = strSQL + " and DIS.No_Pelanggan = '" + strNoPelanggan + "'";
                            strSQL = strSQL + " and DIS.TO_CHAR(Tgl_Jatuh_Tempo,'mm')= TO_CHAR('" + dsBlThRekening.get(0).get("Tgl_Jatuh_Tempo") + "','mm')";
                            strSQL = strSQL + " and DIS.TO_CHAR(Tgl_Jatuh_Tempo,'yyyy')= TO_CHAR('" + dsBlThRekening.get(0).get("Tgl_Jatuh_Tempo") + "','yyyy')";
                            strSQL = strSQL + " group by DIS.Tgl_Jatuh_Tempo";

                            cst = con.prepareCall(strSQL);
                            rs = cst.executeQuery();
                            dsSudahLunas = CommonModule.convertResultsetToListStr(rs);

                            if (dsSudahLunas.size() > 0) {
                                strRekeningDouble = "Double Rekening Lunas Tanggal " +
                                        dsSudahLunas.get(0).get("Tgl_Pelunasan") + "-" +
                                        dsSudahLunas.get(0).get("Tgl_Pelunasan") + "-" +
                                        dsSudahLunas.get(0).get("Tgl_Pelunasan") +
                                        " Petugas : " + dsSudahLunas.get(0).get("KodePetugas");

                                strSQL = "INSERT INTO REKENINGBERMASALAH";
                                strSQL = strSQL + " (TglPelunasan,";
                                strSQL = strSQL + " No_Pelanggan,";
                                strSQL = strSQL + " Uraian,";
                                strSQL = strSQL + " RupiahTagih,";
                                strSQL = strSQL + " KodePetugas,";
                                strSQL = strSQL + " Penyebab,";
                                strSQL = strSQL + " tglupload,";
                                strSQL = strSQL + " namapelanggan)";
                                strSQL = strSQL + " values (TO_DATE('" + strTglLunas + "','dd-mm-yyyy'),";
                                strSQL = strSQL + " '" + strNoPelanggan + "',";
                                strSQL = strSQL + " '" + strBlthRekening + "',";
                                strSQL = strSQL + Integer.parseInt(strRpTagih) + ",";
                                strSQL = strSQL + " '" + strKodePetugas + "',";
                                strSQL = strSQL + " '" + strRekeningDouble + "',";
                                strSQL = strSQL + " TO_DATE('" + strTanggalUpload + "','yyyy-mm-dd'),";
                                strSQL = strSQL + " '" + dsSudahLunas.get(0).get("Nama_Pelanggan") + "')";

                                retFunc = cekrekbermasalah(strTglLunas, strNoPelanggan, strRekeningDouble);

                                if (!(Boolean)retFunc.get("wsReturn")) {
                                    cst = con.prepareCall(strSQL);
                                    cst.execute();
                                    intTotalBermasalah++;
                                } else {
                                    intTotalBermasalah++;
                                }
                                intTotalBermasalah++;
                            }
                        }
                    } else {  // sudah lunas
                        strSQL = "INSERT INTO REKENINGBERMASALAH";
                        strSQL = strSQL + " (TglPelunasan,";
                        strSQL = strSQL + " No_Pelanggan,";
                        strSQL = strSQL + " Uraian,";
                        strSQL = strSQL + " RupiahTagih,";
                        strSQL = strSQL + " KodePetugas,";
                        strSQL = strSQL + " Penyebab,";
                        strSQL = strSQL + " tglupload)";
                        strSQL = strSQL + " values (TO_DATE('" + strTglLunas + "','dd-mm-yyyy'),";
                        strSQL = strSQL + " '" + strNoPelanggan + "',";
                        strSQL = strSQL + " '" + strBlthRekening + "',";
                        strSQL = strSQL + Integer.parseInt(strRpTagih) + ",";
                        strSQL = strSQL + " '" + strKodePetugas + "',";
                        //strSQL = strSQL & " 'Bukan Pelanggan UP/AP ini',"
                        strSQL = strSQL + " 'Pelanggan sudah lunas',";
                        strSQL = strSQL + " TO_DATE('" + strTanggalUpload + "','yyyy-mm-dd'))";

                        retFunc = cekrekbermasalah(strTglLunas, strNoPelanggan, "Pelanggan sudah lunas");

                        if (!(Boolean)retFunc.get("wsReturn")) {
                            cst = con.prepareCall(strSQL);
                            cst.execute();
                            intTotalBermasalah++;
                        } else {
                            intTotalBermasalah++;
                        }
                    }
                } else {
                    strSQL = "INSERT INTO REKENINGBERMASALAH";
                    strSQL = strSQL + " (TGLPELUNASAN,";
                    strSQL = strSQL + " NO_PELANGGAN,";
                    strSQL = strSQL + " URAIAN,";
                    strSQL = strSQL + " RUPIAHTAGIH,";
                    strSQL = strSQL + " KODEPETUGAS,";
                    strSQL = strSQL + " PENYEBAB,";
                    strSQL = strSQL + " TGLUPLOAD)";
                    strSQL = strSQL + " values (TO_DATE('" + strTglLunas + "','dd-mm-yyyy'),";
                    strSQL = strSQL + " '" + strNoPelanggan + "',";
                    strSQL = strSQL + " '" + strBlthRekening + "',";
                    strSQL = strSQL + Integer.parseInt(strRpTagih) + ",";
                    strSQL = strSQL + " '" + strKodePetugas + "',";
                    strSQL = strSQL + " 'BL Th rekening data pelunasan kosong',";
                    strSQL = strSQL + " TO_DATE('" + strTanggalUpload + "','yyyy-mm-dd'))";

                    retFunc = cekrekbermasalah(strTglLunas, strNoPelanggan, "BL Th rekening data pelunasan kosong");

                    if (!(Boolean)retFunc.get("wsReturn")) {
                        cst = con.prepareCall(strSQL);
                        cst.execute();
                        intTotalBermasalah++;
                    } else {
                        intTotalBermasalah++;
                    }
                }

            }

            retValue.put("wsReturn", "#" + intTotalBermasalah.toString() + "#" + "1" + "#" + intTotalLembar.toString() + "#" + intTotalBerhasilUpload.toString() + "#" + dblRupiahTotal.toString() + "#" + dblRupiahTerUpload.toString());

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }

    //ADDED BY DJAINUL
    @Override
    public Map<String, Object> InsertDPPfromSOREK(String CustomConnectionString,
                                                  String pUNITUP,
                                                  String pBLTH) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="{ call sip3user.INSERT_DPP_FROM_SOREK(?,?) }" ;

            CallableStatement cst;
            cst = con.prepareCall(sql);
            cst.setString("parUNITUP", pUNITUP);
            cst.setString("parBlTh", pBLTH);

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
    public Map<String, Object> doRekapSOREK(String CustomConnectionString,
                                            String pUNITUP,
                                            Date pTGLKONSLD) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="{ call sip3user.Z_SOREK_KE_REKAP(?,?,?,?,?,?) }" ;

            CallableStatement cst;
            cst = con.prepareCall(sql);
            cst.setDate("v_TGLKONSLD", new java.sql.Date(pTGLKONSLD.getDate()));
            cst.setInt("v_KONSLDKE", 1);
            cst.setInt("v_FlagTipeBad", 4);
            cst.setInt("v_FlagTipeValid", 5);
            cst.setString("v_JNSUNIT","UP");
            cst.setString("v_UNIT", pUNITUP);

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
    public Map<String, Object> doRekapDPP(String CustomConnectionString,
                                          String pUNITUP,
                                          Date pTGLKONSLD) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="{ call sip3user.Z_DPP_KE_REKAP(?,?,?,?,?) }" ;

            CallableStatement cst;
            cst = con.prepareCall(sql);
            cst.setDate("v_TGLKONSLD", new java.sql.Date(pTGLKONSLD.getDate()));
            cst.setInt("v_KONSLDKE", 1);
            cst.setInt("v_FlagTipeValid", 5);
            cst.setString("v_JNSUNIT","UP");
            cst.setString("v_UNIT", pUNITUP);

            cst.execute();

            retValue.put("wsReturn", true);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
        }
        return retValue;
    }
}
