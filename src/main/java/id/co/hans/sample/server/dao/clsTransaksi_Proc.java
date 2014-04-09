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
public class clsTransaksi_Proc {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Map<String, Object> SetData_11(String unitup,
                                          String thbl,
                                          String strglobalkodepetugas) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String hasilGagal = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PROC_11_SOREKDILDPP(?,?,?,?,?,?) }";

            cst = con.prepareCall(sql);
            cst.setString(1, unitup);
            cst.setString(2, "R1");
            cst.setString(3, "L");
            cst.setString(4, "11");
            cst.setString(5, thbl);
            cst.setString(6, strglobalkodepetugas);

            cst.execute();

            sql = "select parhasil.getGagal AS GAGAL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal Proses, ");
            }

            hasilGagal = lMapData.get(0).get("GAGAL");

            sql = "select parhasil.getHasil AS HASIL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal Proses, ");
            }

            retValue.put("wsReturn", lMapData.get(0).get("HASIL"));
            retValue.put("wsByRefError", "");
            retValue.put("wsByRefHasilGagal", hasilGagal);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefHasilGagal", "");
        }

        return retValue;
    }

    public Map<String, Object> SetData_11_New(String unitap,
                                          String unitup,
                                          String kdprosesklp,
                                          String blth,
                                          String strglobalkodepetugas) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PROC_UPLOADSOREK(?,?,?,?,?) }";

            cst = con.prepareCall(sql);
            cst.setString(1, unitap);
            cst.setString(2, unitup);
            cst.setString(3, kdprosesklp);
            cst.setString(4, blth);
            cst.setString(5, strglobalkodepetugas);

            cst.execute();

            sql = "select parhasil.getHasil AS HASIL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal Proses, ");
            }

            retValue.put("wsReturn", lMapData.get(0).get("HASIL"));

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetData_11_Cutoff(String unitup,
                                          String thbl,
                                          String strglobalkodepetugas) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String hasilGagal = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PROC_11_DPP(?,?,?,?,?,?) }";

            cst = con.prepareCall(sql);
            cst.setString(1, unitup);
            cst.setString(2, "R1");
            cst.setString(3, "L");
            cst.setString(4, "11");
            cst.setString(5, thbl);
            cst.setString(6, strglobalkodepetugas);

            cst.execute();

            sql = "select parhasil.getGagal AS GAGAL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal Proses, ");
            }

            hasilGagal = lMapData.get(0).get("GAGAL");

            sql = "select parhasil.getHasil AS HASIL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal Proses, ");
            }

            retValue.put("wsReturn", lMapData.get(0).get("HASIL"));
            retValue.put("wsByRefError", "");
            retValue.put("wsByRefHasilGagal", hasilGagal);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefHasilGagal", "");
        }

        return retValue;
    }

    public Map<String, Object> SetData_13(String unitup,
                                          String thbl,
                                          String strglobalkodepetugas) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String hasilGagal = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call PROC_13_SOREKSUSULAN(?,?,?,?,?,?) }";

            cst = con.prepareCall(sql);
            cst.setString(1, unitup);
            cst.setString(2, "R1");
            cst.setString(3, "L");
            cst.setString(4, "13");
            cst.setString(5, thbl);
            cst.setString(6, strglobalkodepetugas);

            cst.execute();

            sql = "select parhasil.getGagal AS GAGAL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal Proses, ");
            }

            hasilGagal = lMapData.get(0).get("GAGAL");

            sql = "select parhasil.getHasil AS HASIL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal Proses, ");
            }

            retValue.put("wsReturn", lMapData.get(0).get("HASIL"));
            retValue.put("wsByRefError", "");
            retValue.put("wsByRefHasilGagal", hasilGagal);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefHasilGagal", "");
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_31(String tTransaksiBy,
                                               List<Map<String,String>> dTrans) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Integer j = 0;
        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;
        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            String tanggal = "", waktu = "";
            //todo: tanggal = ambilTanggaleksekusi(Err, waktu)

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").toString().substring(3, 4) + rowData.get("BLTH").toString().substring(0, 2);
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK"));

                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "{ call PROC_31_BATALPIUTANG(?,?,?,?,?,?,?,?,?,?,?,?) }";
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, "31");
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tRPTAG.toString());
                        cst.setString(10, tRPBK.toString());
                        cst.setString(11, tanggal);
                        cst.setString(12, waktu);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            List<Map<String, String>> dsDacen = new ArrayList<Map<String, String>>();

                            sql = "{ call PROC_DACEN_KIRIM_DBP(?,?,?) }";

                            cst = con.prepareCall(sql);
                            cst.setString(1, tIDPel);
                            cst.setString(2, tBlTh);
                            cst.setString(3, tanggal);

                            cst.execute();

                            sql = "select parhasil.getHasil AS HASIL FROM dual";
                            cst = con.prepareCall(sql);
                            rs = cst.executeQuery();

                            lMapData = CommonModule.convertResultsetToListStr(rs);

                            if (!lMapData.get(0).get(0).toString().substring(0,1).equals("1")) {
                                Err = lMapData.get(0).get(0).toString();
                            }

                            rowData.remove("HASIL");
                            rowData.put("HASIL", status);

                            j++;

                            sql = "SELECT TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKIRIM, CETAK, PERIODE, BPAKAI1, BPAKAI2, BPAKAI3, BKVAR, PESAN, TELPPENGADUAN, TGLCETAK";
                            sql = sql + " FROM VIEW_CETAKREKGNEW_21233132";
                            sql = sql + " where blth = '" + tBlTh + "'";
                            sql = sql + " and idpel = '" + tIDPel + "'";
                            sql = sql + " and kdpembpp = '" + tKdPembPP + "'";
                            sql = sql + " and norek = '" + tNorek + "'";

                            cst = con.prepareCall(sql);

                            rs = cst.executeQuery();

                            List<Map<String,String>> dsCetak = CommonModule.convertResultsetToListStr(rs);

                            if (dsCetak.size() == 0) {
                                throw new Exception("Gagal ambil dscetak.");
                            }

                            rowData.put("TGLBAYAR", dsCetak.get(0).get("TGLBAYAR"));
                            rowData.put("WKTBAYAR", dsCetak.get(0).get("WKTBAYAR"));
                            rowData.put("KDPP", dsCetak.get(0).get("KDPP"));
                            rowData.put("KDPEMBAYAR", dsCetak.get(0).get("KDPEMBAYAR"));
                            rowData.put("KDKIRIM", dsCetak.get(0).get("KDKIRIM"));
                            rowData.put("CETAK", dsCetak.get(0).get("CETAK"));
                            rowData.put("BPAKAI1", dsCetak.get(0).get("BPAKAI1"));
                            rowData.put("BPAKAI2", dsCetak.get(0).get("BPAKAI2"));
                            rowData.put("BPAKAI3", dsCetak.get(0).get("BPAKAI3"));
                            rowData.put("BKVAR", dsCetak.get(0).get("BKVAR"));
                            rowData.put("PERIODE", dsCetak.get(0).get("PERIODE"));
                            rowData.put("TELPPENGADUAN", dsCetak.get(0).get("TELPPENGADUAN"));
                            rowData.put("PESAN", dsCetak.get(0).get("PESAN"));
                            rowData.put("TGLCETAK", dsCetak.get(0).get("TGLCETAK"));
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + lMapData.get(0).get(0).toString());
                        }
                    }
                }

            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", "");
            retValue.put("wsByRefLbrProses", j);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefLbrProses", 0);
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_32DUPP(List<Map<String,String>> dTrans,
                                                   String tTransaksiBy) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").toString().substring(3, 4) + rowData.get("BLTH").toString().substring(0, 2);
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK"));

                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "{ call PROC_32DUPP_BUATDAFTAR(?,?,?,?,?,?,?,?,?,?) }";
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, null);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tRPTAG.toString());
                        cst.setString(10, tRPBK.toString());

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", lMapData.get(0).get(0).toString());
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + lMapData.get(0).get(0).toString());
                        }
                    }
                }

            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_41DUPR(List<Map<String,String>> dTrans,
                                                   String tTransaksiBy) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").toString().substring(3, 4) + rowData.get("BLTH").toString().substring(0, 2);
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK"));

                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "{ call PROC_41DUPR_BUATDAFTAR(?,?,?,?,?,?,?,?,?,?) }";
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, null);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tRPTAG.toString());
                        cst.setString(10, tRPBK.toString());

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", lMapData.get(0).get(0).toString());
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + lMapData.get(0).get(0).toString());
                        }
                    }
                }

            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_41(List<Map<String,String>> dTrans,
                                                   String tTransaksiBy) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").toString().substring(3, 4) + rowData.get("BLTH").toString().substring(0, 2);
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK"));

                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "{ call PROC_41_LANCARKERAGU(?,?,?,?,?,?,?,?,?,?) }";
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, null);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tRPTAG.toString());
                        cst.setString(10, tRPBK.toString());

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", lMapData.get(0).get(0).toString());
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + lMapData.get(0).get(0).toString());
                        }
                    }
                }

            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_32(List<Map<String,String>> dTrans,
                                                   String tTransaksiBy) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").toString().substring(3, 4) + rowData.get("BLTH").toString().substring(0, 2);
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK"));

                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "{ call PROC_32_HAPUSPIUTANG(?,?,?,?,?,?,?,?,?,?) }";
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, "32");
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tRPTAG.toString());
                        cst.setString(10, tRPBK.toString());

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", lMapData.get(0).get(0).toString());
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + lMapData.get(0).get(0).toString());
                        }
                    }
                }

            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_PembatalanDenda(List<Map<String,String>> dTrans,
                                                   String tTransaksiBy,
                                                   String tTglBayar,
                                                   String tKdPP,
                                                   String tKDPEMBAYAR) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK, tRPBK1, tRPBK2, tRPBK3;
        String tSiklis, tKdGerakK, tkodeAlasan, tdetailAlasan;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tKdGerakK = rowData.get("KDGERAKKELUAR");
                    tBlTh = rowData.get("BLTH").toString().substring(3, 4) + rowData.get("BLTH").toString().substring(0, 2);
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tSiklis = rowData.get("KELOMPOK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK"));
                    tRPBK1 = Integer.parseInt(rowData.get("RPBK1"));
                    tRPBK2 = Integer.parseInt(rowData.get("RPBK2"));
                    tRPBK3 = Integer.parseInt(rowData.get("RPBK3"));
                    tkodeAlasan = rowData.get("KODEALASAN");
                    tdetailAlasan = rowData.get("DETAILALASAN");

                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "{ call Proc_BKBATAL(?,?,?,?,?,?,?,?,?,?,?,?,?) }";
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tBlTh);
                        cst.setString(4, tRPBK1.toString());
                        cst.setString(5, tRPBK2.toString());
                        cst.setString(6, tRPBK3.toString());
                        cst.setString(7, tSiklis);
                        cst.setString(8, tKdPembPP);
                        cst.setString(9, tKdGerakK);
                        cst.setString(10, tStatus);
                        cst.setString(11, tNorek);
                        cst.setString(12, tkodeAlasan);
                        cst.setString(13, tdetailAlasan);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", lMapData.get(0).get(0).toString());
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + lMapData.get(0).get(0).toString());
                        }
                    }
                }

            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    public Map<String, Object> SetDataIdpel_21entri(String tTransaksiBy,
                                                    String tTglBayar,
                                                    String tKdPP,
                                                    String tKDPEMBAYAR,
                                                    List<Map<String,String>> dTrans) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Integer j = 0;
        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK, tRPBK1, tRPBK2, tRPBK3;
        String Err = "";

        try
        {
            cls_CloseDate cClose = new cls_CloseDate();
            Map<String, Object> retFunc = cClose.CekCloseDate("21E",tTglBayar);

            if (! (Boolean)retFunc.get("wsReturn")) {
                throw new Exception(retFunc.get("wsByRefError").toString());
            }


            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            String tanggal = "", waktu = "";
            //todo: tanggal = ambilTanggaleksekusi(Err, waktu)

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").toString().substring(3, 4) + rowData.get("BLTH").toString().substring(0, 2);
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK"));
                    tRPBK1 = Integer.parseInt(rowData.get("RPBK1"));
                    tRPBK2 = Integer.parseInt(rowData.get("RPBK2"));
                    tRPBK3 = Integer.parseInt(rowData.get("RPBK3"));

                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "{ call PROC_21ENTRI_LUNAS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, "21");
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tRPTAG.toString());
                        cst.setString(10, tRPBK.toString());
                        cst.setString(11, tTglBayar);
                        cst.setString(12, tKdPP);
                        cst.setString(13, tKDPEMBAYAR);
                        cst.setString(14, tRPBK1.toString());
                        cst.setString(15, tRPBK2.toString());
                        cst.setString(16, tRPBK3.toString());
                        cst.setString(17, tanggal);
                        cst.setString(18, waktu);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", status);

                            j++;

                            sql = "SELECT TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKIRIM, CETAK, PERIODE, BPAKAI1, BPAKAI2, BPAKAI3, BKVAR, PESAN, TELPPENGADUAN, TGLCETAK";
                            sql = sql + " FROM VIEW_CETAKREKGNEW_21233132";
                            sql = sql + " where blth = '" + tBlTh + "'";
                            sql = sql + " and idpel = '" + tIDPel + "'";
                            sql = sql + " and kdpembpp = '" + tKdPembPP + "'";
                            sql = sql + " and norek = '" + tNorek + "'";

                            cst = con.prepareCall(sql);

                            rs = cst.executeQuery();

                            List<Map<String,String>> dsCetak = CommonModule.convertResultsetToListStr(rs);

                            if (dsCetak.size() == 0) {
                                throw new Exception("Gagal ambil dscetak.");
                            }

                            rowData.put("TGLBAYAR", dsCetak.get(0).get("TGLBAYAR"));
                            rowData.put("WKTBAYAR", dsCetak.get(0).get("WKTBAYAR"));
                            rowData.put("KDPP", dsCetak.get(0).get("KDPP"));
                            rowData.put("KDPEMBAYAR", dsCetak.get(0).get("KDPEMBAYAR"));
                            rowData.put("KDKIRIM", dsCetak.get(0).get("KDKIRIM"));
                            rowData.put("CETAK", dsCetak.get(0).get("CETAK"));
                            rowData.put("BPAKAI1", dsCetak.get(0).get("BPAKAI1"));
                            rowData.put("BPAKAI2", dsCetak.get(0).get("BPAKAI2"));
                            rowData.put("BPAKAI3", dsCetak.get(0).get("BPAKAI3"));
                            rowData.put("BKVAR", dsCetak.get(0).get("BKVAR"));
                            rowData.put("PERIODE", dsCetak.get(0).get("PERIODE"));
                            rowData.put("TELPPENGADUAN", dsCetak.get(0).get("TELPPENGADUAN"));
                            rowData.put("PESAN", dsCetak.get(0).get("PESAN"));
                            rowData.put("TGLCETAK", dsCetak.get(0).get("TGLCETAK"));
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + lMapData.get(0).get(0).toString());
                        }
                    }
                }

            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", "");
            retValue.put("wsByRefLbrProses", j);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefLbrProses", 0);
        }

        return retValue;
    }
    public Map<String, Object> SetDataIdpel_21Suplisi(List<Map<String,String>> dTrans,
                                                      String sTransaksiBy) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Integer j = 0;
        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK, tRPBK1, tRPBK2, tRPBK3;
        String Err = "";

        try
        {

            String sIDPEL = dTrans.get(0).get("IDPEL");
            String sKDPembpp = dTrans.get(0).get("KDPEMBPP");
            String sKdGerakMasuk = dTrans.get(0).get("KDGERAKMASUK");
            String sKdGerakKeluar = dTrans.get(0).get("KDGERAKKELUAR");
            String sBlth = dTrans.get(0).get("BLTH");
            String sStatus = dTrans.get(0).get("STATUS");
            String sNorek = dTrans.get(0).get("NOREK");
            Integer dRpTagOri = Integer.parseInt(dTrans.get(0).get("RPTAGDPP"));
            Integer dBKOri = Integer.parseInt(dTrans.get(0).get("RPBKDPP"));
            String sKDKirim = dTrans.get(0).get("KDKIRIM");
            String sTglTransaksi = dTrans.get(0).get("TGLTRANSAKSI");
            String sWktTransaksi = dTrans.get(0).get("WKTTRANSAKSI");

            Integer dRpPTL = Integer.parseInt(dTrans.get(0).get("RPPTL")) - Integer.parseInt(dTrans.get(0).get("RPPTL_L"));
            Integer dRpTB = Integer.parseInt(dTrans.get(0).get("RPTB")) - Integer.parseInt(dTrans.get(0).get("RPTB_L"));
            Integer dRpPPN = Integer.parseInt(dTrans.get(0).get("RPPPN")) - Integer.parseInt(dTrans.get(0).get("RPPPN_L"));
            Integer dRpPPJ = Integer.parseInt(dTrans.get(0).get("RPBPJU")) - Integer.parseInt(dTrans.get(0).get("RPBPJU_L"));
            Integer dRpTrafo = Integer.parseInt(dTrans.get(0).get("RPTRAFO")) - Integer.parseInt(dTrans.get(0).get("RPTRAFO_L"));
            Integer dRpSewaTrf = Integer.parseInt(dTrans.get(0).get("RPSEWATRAFO")) - Integer.parseInt(dTrans.get(0).get("RPSEWATRAFO_L"));
            Integer dRpSewaKap = Integer.parseInt(dTrans.get(0).get("RPSEWAKAP")) - Integer.parseInt(dTrans.get(0).get("RPSEWAKAP_L"));
            Integer dRpAngsA = Integer.parseInt(dTrans.get(0).get("RPANGSA")) - Integer.parseInt(dTrans.get(0).get("RPANGSA_L"));
            Integer dRpAngsB = Integer.parseInt(dTrans.get(0).get("RPANGSB")) - Integer.parseInt(dTrans.get(0).get("RPANGSB_L"));
            Integer dRpAngsC = Integer.parseInt(dTrans.get(0).get("RPANGSC")) - Integer.parseInt(dTrans.get(0).get("RPANGSC"));
            Integer dRpMat = Integer.parseInt(dTrans.get(0).get("RPMAT")) - Integer.parseInt(dTrans.get(0).get("RPMAT_L"));
            Integer dRpPLN = Integer.parseInt(dTrans.get(0).get("RPPLN")) - Integer.parseInt(dTrans.get(0).get("RPPLN_L"));
            Integer dRpTag = Integer.parseInt(dTrans.get(0).get("RPTAG")) - Integer.parseInt(dTrans.get(0).get("RPTAG_L"));
            Integer dRpReduksi = Integer.parseInt(dTrans.get(0).get("RPTB")) - Integer.parseInt(dTrans.get(0).get("RPTB_L"));
            Integer dRpInsentif = Integer.parseInt(dTrans.get(0).get("RPINSENTIF")) - Integer.parseInt(dTrans.get(0).get("RPINSENTIF_L"));
            Integer dRpDisinsentif = Integer.parseInt(dTrans.get(0).get("RPDISINSENTIF")) - Integer.parseInt(dTrans.get(0).get("RPDISINSENTIF_L"));
            Integer dRpBk1 = Integer.parseInt(dTrans.get(0).get("RPBK1")) - Integer.parseInt(dTrans.get(0).get("RPBK1_L"));
            Integer dRpBk2 = Integer.parseInt(dTrans.get(0).get("RPBK2")) - Integer.parseInt(dTrans.get(0).get("RPBK2_L"));
            Integer dRpBk3 = Integer.parseInt(dTrans.get(0).get("RPBK3")) - Integer.parseInt(dTrans.get(0).get("RPBK3_L"));
            Integer dRpSelisih = Integer.parseInt(dTrans.get(0).get("RPSELISIH")) - Integer.parseInt(dTrans.get(0).get("RPSELISIH_L"));


            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call Proc_21_SUPLISI(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, sTransaksiBy);
            cst.setString(2, sIDPEL);
            cst.setString(3, sKDPembpp);
            cst.setString(4, sKdGerakMasuk);
            cst.setString(5, sKdGerakKeluar);
            cst.setString(6, sBlth);
            cst.setString(7, sStatus);
            cst.setString(8, sNorek);
            cst.setString(9, dRpTagOri.toString());
            cst.setString(10, dBKOri.toString());
            cst.setString(11, sKDKirim);
            cst.setString(12, sTglTransaksi);
            cst.setString(13, sWktTransaksi);
            cst.setString(14, dRpPTL.toString());
            cst.setString(15, dRpTB.toString());
            cst.setString(16, dRpPPN.toString());
            cst.setString(17, dRpPPJ.toString());
            cst.setString(18, dRpTrafo.toString());
            cst.setString(19, dRpSewaTrf.toString());
            cst.setString(20, dRpSewaKap.toString());
            cst.setString(21, dRpAngsA.toString());
            cst.setString(22, dRpAngsB.toString());
            cst.setString(23, dRpAngsC.toString());
            cst.setString(24, dRpMat.toString());
            cst.setString(25, dRpPLN.toString());
            cst.setString(26, dRpTag.toString());
            cst.setString(27, dRpReduksi.toString());
            cst.setString(28, dRpInsentif.toString());
            cst.setString(29, dRpDisinsentif.toString());
            cst.setString(30, dRpBk1.toString());
            cst.setString(31, dRpBk2.toString());
            cst.setString(32, dRpBk3.toString());

            cst.execute();

            sql = "select parhasil.getHasil AS HASIL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal proses,");
            }

            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                sql = "{ call PARAMETERVIEW.SetIdPel(?) }";
                cst = con.prepareCall(sql);
                cst.setString(1, dTrans.get(0).get("IDPEL"));
                cst.execute();

                sql = "{ call PARAMETERVIEW.SetBLTH(?) }";
                cst = con.prepareCall(sql);
                cst.setString(1, dTrans.get(0).get("BLTH"));
                cst.execute();

                sql = "SELECT * FROM VIEW_CETAKI06_SUPLISI ";

                cst = con.prepareCall(sql);

                rs = cst.executeQuery();
                retValue.put("wsByRefError", "");
            } else {
                retValue.put("wsByRefError", "Gagal update DPP ");
            }


            retValue.put("wsReturn", dTrans);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_21HapusGagal(List<Map<String,String>> dTrans,
                                                      String tTransaksiBy,
                                                      String tTglBayar,
                                                      String tKdPP,
                                                      String tKDPEMBAYAR) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK, tRPBK1, tRPBK2, tRPBK3;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            String tanggal = "", waktu = "";
            //todo: tanggal = ambilTanggaleksekusi(Err, waktu)

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").toString().substring(3, 4) + rowData.get("BLTH").toString().substring(0, 2);
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK"));
                    tRPBK1 = Integer.parseInt(rowData.get("RPBK1"));
                    tRPBK2 = Integer.parseInt(rowData.get("RPBK2"));
                    tRPBK3 = Integer.parseInt(rowData.get("RPBK3"));

                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "{ call PROC_21HAPUSGAGALUPLOAD(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, "21");
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tRPTAG.toString());
                        cst.setString(10, tRPBK.toString());
                        cst.setString(11, tTglBayar);
                        cst.setString(12, tKdPP);
                        cst.setString(13, tKDPEMBAYAR);
                        cst.setString(14, tRPBK1.toString());
                        cst.setString(15, tRPBK2.toString());
                        cst.setString(16, tRPBK3.toString());

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", status);
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + status);
                        }
                    }
                }

            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetData_21upload(String tTransaksiBy,
                                                      String tTglBayar,
                                                      String tKdPP) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();
        List<Map<String,String>> dTrans = new ArrayList<Map<String,String>>();

        String tKDPEMBAYAR;
        String mKdPP, mTglBayar, mWktBayar;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = " SELECT BLTH, IDPEL, KDPP, UNITUP, TGLBAYAR, WKTBAYAR, KDPEMBAYAR, STATUS, KDPEMBPP,RPTAG, (RPBK1 + RPBK2 + RPBK3) as RPBK,RPBK1, RPBK2, RPBK3, NOREK";
            sql = sql + " FROM TEMPDPHOFFLINE";
            sql = sql + " where TRANSAKSIBY = '" + tTransaksiBy + "'";
            //sql = sql + " and KDPP = '" & tKdPP & "'";
            //sql = sql + " and TGLBAYAR = '" & tTglBayar & "'";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            dTrans = CommonModule.convertResultsetToListStr(rs);

            if (dTrans.size() == 0) {
                throw new Exception("Data tidak ditemukan.");
            }

            String tUnitup, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
            Integer tRPTAG, tRPBK, tRPBK1, tRPBK2, tRPBK3;


            for (Map<String, String> rowData : dTrans) {
                rowData.put("Simpan", "true");
                rowData.put("HASIL", "");

                String tvidpel = rowData.get("IDPEL").toUpperCase();

                if (tvidpel.length() < 12) {
                    sql = " SELECT IDPEL";
                    sql = sql + " FROM DIL WHERE NOPEL = '" + tvidpel + "'";

                    cst = con.prepareCall(sql);
                    rs = cst.executeQuery();

                    lMapData = CommonModule.convertResultsetToListStr(rs);

                    if (lMapData.size() > 0) {
                        tIDPel = lMapData.get(0).get("IDPEL");

                        sql = "update TEMPDPHOFFLINE set IDPEL = '" + tIDPel + "'";
                        //sql = sql + " where TGLBAYAR = '" & tTglBayar & "'";
                        //sql = sql + " and KDPP = '" & tKdPP & "'";
                        sql = sql + " and TRANSAKSIBY = '" + tTransaksiBy + "'";
                        sql = sql + " and IDPEL  = '" + tvidpel + "'";

                        cst = con.prepareCall(sql);

                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);
                    } else {
                        tIDPel = tvidpel;
                    }
                } else {
                    tIDPel = rowData.get("IDPEL");
                }

                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    //tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = ""; //rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").toString();
                    tStatus = rowData.get("STATUS");
                    tNorek = ""; //rowData.get("NOREK");
                    mKdPP = rowData.get("KDPP");
                    mTglBayar = rowData.get("TGLBAYAR"); //rowData.get("NOREK");
                    mWktBayar = rowData.get("WKTBAYAR"); //rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK"));
                    tRPBK1 = Integer.parseInt(rowData.get("RPBK1"));
                    tRPBK2 = 0; //Integer.parseInt(rowData.get("RPBK2"));
                    tRPBK3 = 0; //Integer.parseInt(rowData.get("RPBK3"));
                    tKDPEMBAYAR = rowData.get("KDPEMBAYAR");
                    tUnitup = rowData.get("UNITUP");


                    sql = "{ call PROC_21UPLOAD_LUNAS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
                    cst = con.prepareCall(sql);
                    cst.setString(1, tUnitup);
                    cst.setString(2, tTransaksiBy);
                    cst.setString(3, tIDPel);
                    cst.setString(4, tKdPembPP);
                    cst.setString(5, tKdGerakM);
                    cst.setString(6, "21");
                    cst.setString(7, tBlTh);
                    cst.setString(8, tStatus);
                    cst.setString(9, tNorek);
                    cst.setString(10, tRPTAG.toString());
                    cst.setString(11, tRPBK.toString());
                    cst.setString(12, mTglBayar);
                    cst.setString(13, mWktBayar);
                    cst.setString(14, mKdPP);
                    cst.setString(15, tKDPEMBAYAR);
                    cst.setString(16, tRPBK1.toString());
                    cst.setString(17, tRPBK2.toString());
                    cst.setString(18, tRPBK3.toString());

                    cst.execute();

                    sql = "select parhasil.getHasil AS HASIL FROM dual";
                    cst = con.prepareCall(sql);
                    rs = cst.executeQuery();

                    lMapData = CommonModule.convertResultsetToListStr(rs);

                    if (lMapData.size() == 0) {
                        throw new Exception("Gagal ambil parhasil.");
                    }

                    String status = lMapData.get(0).get(0).toString();

                    if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                        sql = " { call PROC_DACEN_KIRIM_DPH(????)} ";
                        cst = con.prepareCall(sql);
                        cst.setString(1, tIDPel);
                        cst.setString(2, tBlTh);
                        cst.setString(3, mTglBayar);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) != 1) {
                            retValue.put("wsByRefError", lMapData.get(0).get(0));
                        }

                        rowData.put("HASIL", status);
                    } else {
                        rowData.put("HASIL", status);
                    }
                }

            }

            retValue.put("wsReturn", dTrans);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetData_21insert(List<Map<String,String>> dTrans,
                                                String tTransaksiBy) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        String Err = "";
        Integer i = 0;

        //todo: DeleteDPHOFFLINE(dTrans.get(0).get(0), tTransaksiBy);

        for (Map<String, String> rowData : dTrans) {
            i++;
            //todo: InsertTempDPHOFFLINE(rowData, tTransaksiBy);

            if (!Err.equals("")) {
                retValue.put("wsReturn", "Gagal Proses insert ke TempDPHoffline, record ke " + i + " , " + Err);
                retValue.put("wsByRefError", "Gagal Proses insert ke TempDPHoffline, record ke " + i + " , " + Err);
            }
        }

        retValue.put("wsReturn", "");
        retValue.put("wsByRefError", Err);

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_32DHPfromDUPP(String tTransaksiBy,
                                                String tKirim,
                                                List<Map<String,String>> dTrans) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String tanggal = "", waktu = "";
        //todo: tanggal = ambilTanggaleksekusi(Err, waktu)

        Integer j = 0;
        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").toString().substring(3,4) + rowData.get("BLTH").toString().substring(0,2);
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK"));

                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "{ call PROC_32DHPfromDUPP(?,?,?,?,?,?,?,?,?,?,?,?) }";
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, "32");
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tRPTAG.toString());
                        cst.setString(10, tRPBK.toString());
                        cst.setString(11, tanggal);
                        cst.setString(12, waktu);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            sql = "{ call PROC_DACEN_KIRIM_DHP(?,?,?,?) }";
                            cst = con.prepareCall(sql);
                            cst.setString(1, tIDPel);
                            cst.setString(2, tBlTh);
                            cst.setString(3, tKdPembPP);
                            cst.setString(4, tanggal);

                            cst.execute();

                            sql = "select parhasil.getHasil AS HASIL FROM dual";
                            cst = con.prepareCall(sql);
                            rs = cst.executeQuery();
                            lMapData = CommonModule.convertResultsetToListStr(rs);

                            if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) != 1) {
                                throw new Exception(lMapData.get(0).get(0));
                            }

                            rowData.put("HASIL", status);
                            j++;

                            sql = "SELECT TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKIRIM, CETAK, PERIODE, BPAKAI1, BPAKAI2, BPAKAI3, BKVAR, PESAN, TELPPENGADUAN, TGLCETAK";
                            sql = sql + " FROM VIEW_CETAKREKGNEW_21233132";
                            sql = sql + " where blth = '" + tBlTh + "'";
                            sql = sql + " and idpel = '" + tIDPel + "'";
                            sql = sql + " and kdpembpp = '" + tKdPembPP + "'";
                            sql = sql + " and norek = '" + tNorek + "'";

                            cst = con.prepareCall(sql);
                            rs = cst.executeQuery();
                            lMapData = CommonModule.convertResultsetToListStr(rs);

                            if (lMapData.size() == 0) {
                                throw new Exception("Gagal ambil dscetak.");
                            }

                            rowData.put("TGLBAYAR", lMapData.get(0).get("TGLBAYAR"));
                            rowData.put("WKTBAYAR", lMapData.get(0).get("WKTBAYAR"));
                            rowData.put("KDPP", lMapData.get(0).get("KDPP"));
                            rowData.put("KDPEMBAYAR", lMapData.get(0).get("KDPEMBAYAR"));
                            rowData.put("KDKIRIM", lMapData.get(0).get("KDKIRIM"));
                            rowData.put("CETAK", lMapData.get(0).get("CETAK"));
                            rowData.put("BPAKAI1", lMapData.get(0).get("BPAKAI1"));
                            rowData.put("BPAKAI2", lMapData.get(0).get("BPAKAI2"));
                            rowData.put("BPAKAI3", lMapData.get(0).get("BPAKAI3"));
                            rowData.put("BKVAR", lMapData.get(0).get("BKVAR"));
                            rowData.put("PERIODE", lMapData.get(0).get("PERIODE"));
                            rowData.put("TELPPENGADUAN", lMapData.get(0).get("TELPPENGADUAN"));
                            rowData.put("PESAN", lMapData.get(0).get("PESAN"));
                            rowData.put("TGLCETAK", lMapData.get(0).get("TGLCETAK"));
                        }
                    }
                }
            }

            retValue.put("wsReturn", dTrans);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_41PRRfromDUPR(String tTransaksiBy,
                                                String tKirim,
                                                List<Map<String,String>> dTrans) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String tanggal = "", waktu = "";
        //todo: tanggal = ambilTanggaleksekusi(Err, waktu)

        Integer j = 0;
        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").toString().substring(3,4) + rowData.get("BLTH").toString().substring(0,2);
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK"));
                    tanggal = rowData.get("TGLKOREKSI");

                    sql = "Select min(rc) rc from DBP_RESP where idpel='" + tIDPel + "' and status_terima='B'";
                    cst = con.prepareCall(sql);
                    rs = cst.executeQuery();
                    lMapData = CommonModule.convertResultsetToListStr(rs);

                    if (lMapData.size() == 0) {
                        throw new Exception("Belum / Tidak Ada Respon.");
                    }

                    if (lMapData.get(0).get(0) == "00") {
                        //VALIDASI CLOSE DATE
                        cls_CloseDate cClose = new cls_CloseDate();
                        Map<String, Object> retFunc = cClose.CekCloseDate("41", tanggal);
                        if (!retFunc.get("wsByRefError").toString().equals("")) {
                            throw new Exception("Gagal validasi close date. " + retFunc.get("wsByRefError").toString());
                        }
                        //END VALIDASI CLOSE DATE

                        if (idpelErr == tIDPel) {
                            rowData.put("HASIL", " ");
                        } else {
                            sql = "{ call PROC_41PRRfromDUPR(?,?,?,?,?,?,?,?,?,?,?) }";
                            cst = con.prepareCall(sql);
                            cst.setString(1, tTransaksiBy);
                            cst.setString(2, tIDPel);
                            cst.setString(3, tKdPembPP);
                            cst.setString(4, tKdGerakM);
                            cst.setString(5, tBlTh);
                            cst.setString(6, tStatus);
                            cst.setString(7, tNorek);
                            cst.setString(8, tRPTAG.toString());
                            cst.setString(9, tRPBK.toString());
                            cst.setString(10, tanggal);
                            cst.setString(11, waktu);

                            cst.execute();

                            sql = "select parhasil.getHasil AS HASIL FROM dual";
                            cst = con.prepareCall(sql);
                            rs = cst.executeQuery();
                            lMapData = CommonModule.convertResultsetToListStr(rs);

                            if (lMapData.size() == 0) {
                                throw new Exception("Gagal ambil parhasil.");
                            }

                            String status = lMapData.get(0).get(0).toString();

                            if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                                sql = "{ call PROC_DACEN_KIRIM_DPRR(?,?,?,?) }";
                                cst = con.prepareCall(sql);
                                cst.setString(1, tIDPel);
                                cst.setString(2, tBlTh);
                                cst.setString(3, tKdPembPP);
                                cst.setString(4, tanggal); //todo: ws_umum.ambilTanggalDatabase.ToString("yyyyMMdd")

                                cst.execute();

                                sql = "select parhasil.getHasil AS HASIL FROM dual";
                                cst = con.prepareCall(sql);
                                rs = cst.executeQuery();
                                lMapData = CommonModule.convertResultsetToListStr(rs);

                                if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) != 1) {
                                    throw new Exception(lMapData.get(0).get(0));
                                }

                                rowData.put("HASIL", status);
                                j++;

                                sql = "SELECT *";
                                sql = sql + " FROM VIEW_CETAKREKGNEW_41";
                                sql = sql + " where blth = '" + tBlTh + "'";
                                sql = sql + " and idpel = '" + tIDPel + "'";
                                sql = sql + " and kdpembpp = '" + tKdPembPP + "'";
                                sql = sql + " and norek = '" + tNorek + "'";
                                sql = sql + " and TGKOREKSI = '" + tanggal + "'";

                                cst = con.prepareCall(sql);
                                rs = cst.executeQuery();
                                lMapData = CommonModule.convertResultsetToListStr(rs);

                                if (lMapData.size() == 0) {
                                    throw new Exception("Gagal ambil dscetak.");
                                }

                                rowData.put("TGKOREKSI", lMapData.get(0).get("TGKOREKSI"));
                                rowData.put("KDKOREKSI", "" /*lMapData.get(0).get("KDKOREKSI")*/);
                                rowData.put("koreksiby", lMapData.get(0).get("koreksiby"));
                                rowData.put("KDPEMBAYAR", lMapData.get(0).get("KDPEMBAYAR"));
                                rowData.put("CETAK", lMapData.get(0).get("CETAK"));
                                rowData.put("BPAKAI1", lMapData.get(0).get("BPAKAI1"));
                                rowData.put("BPAKAI2", lMapData.get(0).get("BPAKAI2"));
                                rowData.put("BPAKAI3", lMapData.get(0).get("BPAKAI3"));
                                rowData.put("BKVAR", lMapData.get(0).get("BKVAR"));
                                rowData.put("PERIODE", lMapData.get(0).get("PERIODE"));
                                rowData.put("TELPPENGADUAN", lMapData.get(0).get("TELPPENGADUAN"));
                                rowData.put("PESAN", lMapData.get(0).get("PESAN"));
                                rowData.put("TGLCETAK", lMapData.get(0).get("TGLCETAK"));
                            }
                        }
                    } else {
                        throw new Exception("Respon Tidak Disetujui.");
                    }
                }
            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", "");
            retValue.put("wsByRefLbrProses", j);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefLbrProses", j);
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_23NOTAPUSAT(String tTransaksiBy,
                                                String tKirim,
                                                List<Map<String,String>> dTrans) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String tanggal = "", waktu = "";
        //todo: tanggal = ambilTanggaleksekusi(Err, waktu)

        Integer j = 0;
        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").toString().substring(3,4) + rowData.get("BLTH").toString().substring(0,2);
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK"));

                    //VALIDASI CLOSE DATE
                    cls_CloseDate cClose = new cls_CloseDate();
                    Map<String, Object> retFunc = cClose.CekCloseDate("23DLT", rowData.get("TGLBAYAR"));
                    if (!retFunc.get("wsByRefError").toString().equals("")) {
                        throw new Exception("Gagal validasi close date. " + retFunc.get("wsByRefError").toString());
                    }
                    //END VALIDASI CLOSE DATE

                    sql = "Select min(rc) rc from DBP_RESP where idpel='" + tIDPel + "' and status_terima='B'";
                    cst = con.prepareCall(sql);
                    rs = cst.executeQuery();
                    lMapData = CommonModule.convertResultsetToListStr(rs);

                    if (lMapData.size() == 0) {
                        throw new Exception("Belum / Tidak Ada Respon.");
                    }

                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {

                        if (rowData.get("IDPEL").substring(0,2) == "51" || rowData.get("IDPEL").substring(0,2) == "53") {
                            tanggal = rowData.get("TGLBAYAR");
                        }

                        sql = "{ call PROC_23_NOTAPUSAT(?,?,?,?,?,?,?,?,?,?,?,?,?) }";
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, "23");
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tRPTAG.toString());
                        cst.setString(10, tRPBK.toString());
                        cst.setString(11, tKirim);
                        cst.setString(12, tanggal);
                        cst.setString(13, waktu);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            //sql = "{ call PROC_DACEN_KIRIM_DPH(?,?,?,?) }";
                            //cst = con.prepareCall(sql);
                            //cst.setString(1, tIDPel);
                            //cst.setString(2, tBlTh);
                            //cst.setString(3, tKdPembPP);
                            //cst.setString(4, tanggal);

                            //cst.execute();

                            rowData.put("HASIL", status);
                            j++;

                            sql = "SELECT TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKIRIM, CETAK, PERIODE, BPAKAI1, BPAKAI2, BPAKAI3, BKVAR, PESAN, TELPPENGADUAN, TGLCETAK";
                            sql = sql + " FROM VIEW_CETAKREKGNEW_21233132";
                            sql = sql + " where blth = '" + tBlTh + "'";
                            sql = sql + " and idpel = '" + tIDPel + "'";
                            sql = sql + " and kdpembpp = '" + tKdPembPP + "'";
                            sql = sql + " and norek = '" + tNorek + "'";

                            cst = con.prepareCall(sql);
                            rs = cst.executeQuery();
                            lMapData = CommonModule.convertResultsetToListStr(rs);

                            if (lMapData.size() == 0) {
                                throw new Exception("Gagal ambil dscetak.");
                            }

                            rowData.put("TGLBAYAR", lMapData.get(0).get("TGLBAYAR"));
                            rowData.put("WKTBAYAR", lMapData.get(0).get("WKTBAYAR"));
                            rowData.put("KDPP", lMapData.get(0).get("KDPP"));
                            rowData.put("KDPEMBAYAR", lMapData.get(0).get("KDPEMBAYAR"));
                            rowData.put("KDKIRIM", lMapData.get(0).get("KDKIRIM"));
                            rowData.put("CETAK", lMapData.get(0).get("CETAK"));
                            rowData.put("BPAKAI1", lMapData.get(0).get("BPAKAI1"));
                            rowData.put("BPAKAI2", lMapData.get(0).get("BPAKAI2"));
                            rowData.put("BPAKAI3", lMapData.get(0).get("BPAKAI3"));
                            rowData.put("BKVAR", lMapData.get(0).get("BKVAR"));
                            rowData.put("PERIODE", lMapData.get(0).get("PERIODE"));
                            rowData.put("TELPPENGADUAN", lMapData.get(0).get("TELPPENGADUAN"));
                            rowData.put("PESAN", lMapData.get(0).get("PESAN"));
                            rowData.put("TGLCETAK", lMapData.get(0).get("TGLCETAK"));
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + status);
                        }
                    }
                }
            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", "");
            retValue.put("wsByRefLbrProses", j);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefLbrProses", j);
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_21GIRALISASI(String tTransaksiBy,
                                                String tKirim,
                                                String tKodePP,
                                                String tTglBayar,
                                                List<Map<String,String>> dTrans) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String tanggal = "", waktu = "";
        //todo: tanggal = ambilTanggaleksekusi(Err, waktu)

        Integer j = 0;
        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;

        try
        {
            //VALIDASI CLOSE DATE
            cls_CloseDate cClose = new cls_CloseDate();
            Map<String, Object> retFunc = cClose.CekCloseDate("21G", tTglBayar);
            if (!retFunc.get("wsByRefError").toString().equals("")) {
                //throw new Exception("Gagal validasi close date. " + retFunc.get("wsByRefError").toString());
                throw new Exception("");
            }
            //END VALIDASI CLOSE DATE

            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            String Err = "";

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").toString().substring(3,4) + rowData.get("BLTH").toString().substring(0,2);
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK"));

                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "{ call PROC_21_GIRALISASI(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
                        cst = con.prepareCall(sql);
                        cst.setString(1, tKodePP);
                        cst.setString(2, tTglBayar);
                        cst.setString(3, tTransaksiBy);
                        cst.setString(4, tIDPel);
                        cst.setString(5, tKdPembPP);
                        cst.setString(6, tKdGerakM);
                        cst.setString(7, "21");
                        cst.setString(8, tBlTh);
                        cst.setString(9, tStatus);
                        cst.setString(10, tNorek);
                        cst.setString(11, tRPTAG.toString());
                        cst.setString(12, tRPBK.toString());
                        cst.setString(13, tKirim);
                        cst.setString(14, tanggal);
                        cst.setString(15, waktu);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            sql = "{ call PROC_DACEN_KIRIM_DPH(?,?,?) }";
                            cst = con.prepareCall(sql);
                            cst.setString(1, tIDPel);
                            cst.setString(2, tBlTh);
                            cst.setString(3, tanggal);

                            cst.execute();

                            sql = "select parhasil.getHasil AS HASIL FROM dual";
                            cst = con.prepareCall(sql);
                            rs = cst.executeQuery();
                            lMapData = CommonModule.convertResultsetToListStr(rs);

                            if (!lMapData.get(0).get(0).substring(0,1).equals("1")) {
                                Err = lMapData.get(0).get(0);
                            }

                            rowData.put("HASIL", status);
                            j++;

                            sql = "SELECT TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKIRIM, CETAK, PERIODE, BPAKAI1, BPAKAI2, BPAKAI3, BKVAR, PESAN, TELPPENGADUAN, TGLCETAK";
                            sql = sql + " FROM VIEW_CETAKREKGNEW_21233132";
                            sql = sql + " where blth = '" + tBlTh + "'";
                            sql = sql + " and idpel = '" + tIDPel + "'";
                            sql = sql + " and kdpembpp = '" + tKdPembPP + "'";
                            sql = sql + " and norek = '" + tNorek + "'";

                            cst = con.prepareCall(sql);
                            rs = cst.executeQuery();
                            lMapData = CommonModule.convertResultsetToListStr(rs);

                            if (lMapData.size() == 0) {
                                throw new Exception("Gagal ambil dscetak.");
                            }

                            rowData.put("TGLBAYAR", lMapData.get(0).get("TGLBAYAR"));
                            rowData.put("WKTBAYAR", lMapData.get(0).get("WKTBAYAR"));
                            rowData.put("KDPP", lMapData.get(0).get("KDPP"));
                            rowData.put("KDPEMBAYAR", lMapData.get(0).get("KDPEMBAYAR"));
                            rowData.put("KDKIRIM", lMapData.get(0).get("KDKIRIM"));
                            rowData.put("CETAK", lMapData.get(0).get("CETAK"));
                            rowData.put("BPAKAI1", lMapData.get(0).get("BPAKAI1"));
                            rowData.put("BPAKAI2", lMapData.get(0).get("BPAKAI2"));
                            rowData.put("BPAKAI3", lMapData.get(0).get("BPAKAI3"));
                            rowData.put("BKVAR", lMapData.get(0).get("BKVAR"));
                            rowData.put("PERIODE", lMapData.get(0).get("PERIODE"));
                            rowData.put("TELPPENGADUAN", lMapData.get(0).get("TELPPENGADUAN"));
                            rowData.put("PESAN", lMapData.get(0).get("PESAN"));
                            rowData.put("TGLCETAK", lMapData.get(0).get("TGLCETAK"));
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + status);
                        }
                    }
                }
            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", Err);
            retValue.put("wsByRefLbrProses", j);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefLbrProses", j);
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_23NOTA(String tTransaksiBy,
                                                String tKirim,
                                                List<Map<String,String>> dTrans,
                                                Integer iBebanKantor) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String tanggal = "", waktu = "";
        //todo: tanggal = ambilTanggaleksekusi(Err, waktu)

        Integer j = 0;
        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        String tRPTAG, tRPBK;
        String sKDKIRIM;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            String Err = "";

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").toString().substring(3,4) + rowData.get("BLTH").toString().substring(0,2);
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = rowData.get("RPTAG");
                    tRPBK = rowData.get("RPBK");

                    if (iBebanKantor == 1) { //jika beban kantor
                        //diremark karena apabila digabung dengan tKirim ada yg lebih dari 20 karakter sementara kdkirim di dpp hanya menampung 20 karakter
                        //sKDKIRIM = "BEBAN KANTOR" & tKirim
                        sKDKIRIM = tKirim;

                        cls_CloseDate cClose = new cls_CloseDate();
                        Map<String, Object> retFunc = cClose.CekCloseDate("23BK", rowData.get("TGLBAYAR"));
                        if (!retFunc.get("wsByRefError").toString().equals("")) {
                            throw new Exception("Gagal validasi close date. " + retFunc.get("wsByRefError").toString());
                        }
                    } else if (iBebanKantor == 2) {
                        sKDKIRIM = tKirim;

                        cls_CloseDate cClose = new cls_CloseDate();
                        Map<String, Object> retFunc = cClose.CekCloseDate("23MD", rowData.get("TGLBAYAR"));
                        if (!retFunc.get("wsByRefError").toString().equals("")) {
                            throw new Exception("Gagal validasi close date. " + retFunc.get("wsByRefError").toString());
                        }
                    } else if (iBebanKantor == 3) {
                        sKDKIRIM = tKirim;

                        cls_CloseDate cClose = new cls_CloseDate();
                        Map<String, Object> retFunc = cClose.CekCloseDate("23BM", rowData.get("TGLBAYAR"));
                        if (!retFunc.get("wsByRefError").toString().equals("")) {
                            throw new Exception("Gagal validasi close date. " + retFunc.get("wsByRefError").toString());
                        }
                    } else {
                        sKDKIRIM = tKirim;

                        cls_CloseDate cClose = new cls_CloseDate();
                        Map<String, Object> retFunc = cClose.CekCloseDate("23NB", rowData.get("TGLBAYAR"));
                        if (!retFunc.get("wsByRefError").toString().equals("")) {
                            throw new Exception("Gagal validasi close date. " + retFunc.get("wsByRefError").toString());
                        }
                    }


                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "";
                        tanggal = rowData.get("TANGGAL");

                        if (iBebanKantor == 1) {
                            sql = "{ call PROC_24_BEBANKANTOR(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
                            cst = con.prepareCall(sql);
                            cst.setString(3, tTransaksiBy);
                            cst.setString(4, tIDPel);
                            cst.setString(5, tKdPembPP);
                            cst.setString(6, tKdGerakM);
                            cst.setString(7, "24");
                            cst.setString(8, tBlTh);
                            cst.setString(9, tStatus);
                            cst.setString(10, tNorek);
                            cst.setString(11, tRPTAG.toString());
                            cst.setString(12, tRPBK.toString());
                            cst.setString(13, sKDKIRIM);
                            cst.setString(14, tanggal);
                            cst.setString(15, waktu);

                            cst.execute();
                        } else if (iBebanKantor == 0) {
                            sql = "{ call PROC_23_NOTABUKU(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
                            cst = con.prepareCall(sql);
                            cst.setString(3, tTransaksiBy);
                            cst.setString(4, tIDPel);
                            cst.setString(5, tKdPembPP);
                            cst.setString(6, tKdGerakM);
                            cst.setString(7, "23");
                            cst.setString(8, tBlTh);
                            cst.setString(9, tStatus);
                            cst.setString(10, tNorek);
                            cst.setString(11, tRPTAG.toString());
                            cst.setString(12, tRPBK.toString());
                            cst.setString(13, sKDKIRIM);
                            cst.setString(14, tanggal);
                            cst.setString(15, waktu);

                            cst.execute();
                        }


                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", status);
                            j++;

                            sql = "SELECT TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKIRIM, CETAK, PERIODE, BPAKAI1, BPAKAI2, BPAKAI3, BKVAR, PESAN, TELPPENGADUAN, TGLCETAK";
                            sql = sql + " FROM VIEW_CETAKREKGNEW_21233132";
                            sql = sql + " where blth = '" + tBlTh + "'";
                            sql = sql + " and idpel = '" + tIDPel + "'";
                            sql = sql + " and kdpembpp = '" + tKdPembPP + "'";
                            sql = sql + " and norek = '" + tNorek + "'";

                            cst = con.prepareCall(sql);
                            rs = cst.executeQuery();
                            lMapData = CommonModule.convertResultsetToListStr(rs);

                            if (lMapData.size() == 0) {
                                throw new Exception("Gagal ambil dscetak.");
                            }

                            rowData.put("TGLBAYAR", lMapData.get(0).get("TGLBAYAR"));
                            rowData.put("WKTBAYAR", lMapData.get(0).get("WKTBAYAR"));
                            rowData.put("KDPP", lMapData.get(0).get("KDPP"));
                            rowData.put("KDPEMBAYAR", lMapData.get(0).get("KDPEMBAYAR"));
                            rowData.put("KDKIRIM", lMapData.get(0).get("KDKIRIM"));
                            rowData.put("CETAK", lMapData.get(0).get("CETAK"));
                            rowData.put("BPAKAI1", lMapData.get(0).get("BPAKAI1"));
                            rowData.put("BPAKAI2", lMapData.get(0).get("BPAKAI2"));
                            rowData.put("BPAKAI3", lMapData.get(0).get("BPAKAI3"));
                            rowData.put("BKVAR", lMapData.get(0).get("BKVAR"));
                            rowData.put("PERIODE", lMapData.get(0).get("PERIODE"));
                            rowData.put("TELPPENGADUAN", lMapData.get(0).get("TELPPENGADUAN"));
                            rowData.put("PESAN", lMapData.get(0).get("PESAN"));
                            rowData.put("TGLCETAK", lMapData.get(0).get("TGLCETAK"));
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + status);
                        }
                    }
                }
            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", Err);
            retValue.put("wsByRefLbrProses", j);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefLbrProses", j);
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_23KIRIMUNIT(List<Map<String,String>> dTrans,
                                                        String tTransaksiBy,
                                                        String tKDTERIMA) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String tanggal = "", waktu = "";
        //todo: tanggal = ambilTanggaleksekusi(Err, waktu)

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        String tRPTAG, tRPBK;
        String tKDKIRIM, sTransIDs = "", sUnitUp;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            String Err = "";

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").toString().substring(3,4) + rowData.get("BLTH").toString().substring(0,2);
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = rowData.get("RPTAG");
                    tRPBK = rowData.get("RPBK");
                    tKDKIRIM = "KIRIMKE";

                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "";
                        tanggal = rowData.get("TANGGAL");

                        sql = "{ call Proc_23KIRIM_UNIT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
                        cst = con.prepareCall(sql);
                        cst.setString(3, tTransaksiBy);
                        cst.setString(4, tIDPel);
                        cst.setString(5, tKdPembPP);
                        cst.setString(6, tKdGerakM);
                        cst.setString(7, "23");
                        cst.setString(8, tBlTh);
                        cst.setString(9, tStatus);
                        cst.setString(10, tNorek);
                        cst.setString(11, tRPTAG.toString());
                        cst.setString(12, tRPBK.toString());
                        cst.setString(13, tKDKIRIM);
                        cst.setString(14, tKDTERIMA);

                        cst.execute();


                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", status);
                            if (!sTransIDs.equals("")) {
                                sTransIDs += "," + lMapData.get(0).get(0);
                            } else {
                                sTransIDs += "" + lMapData.get(0).get(0);
                            }
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + status);
                        }
                    }
                }
            }

            if (!sTransIDs.trim().equals("") && !Err.trim().equals("")) {
                //todo: clsTransaksi_View clsView = new clsTransaksi_View();
                cls_ReportBA clsBA = new cls_ReportBA();
                Map<String, Object> retFuncClsView, retFuncClsBA;
            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", Err);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_12ABC(List<Map<String,String>> dTrans,
                                                        String tTransaksiBy,
                                                        String tKdkoreksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String tanggal = "", waktu = "";
        //todo: tanggal = ambilTanggaleksekusi(Err, waktu)

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;
        String tKDKIRIM, sTransIDs = "", sUnitUp;
        String IdTarip = "", ttarip;
        Integer tdaya;

        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").toString();
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK1")) + Integer.parseInt(rowData.get("RPBK2")) + Integer.parseInt(rowData.get("RPBK3"));
                    tdaya = Integer.parseInt(rowData.get("DAYA"));
                    ttarip = rowData.get("TARIP");

                    if (rowData.get("KDAYA") == "K") {
                        tdaya = tdaya * 1000;
                    } else {
                        tdaya = tdaya;
                    }

                    Map<String, Object> retFuncTarip = new HashMap<String, Object>();
                    //todo: retFuncTarip = cekTarip(ttarip, tdaya, tBlTh);

                    if (!retFuncTarip.get("wsByRefError").equals("")) {
                        Err = "";
                        IdTarip = "0000000000";
                    } else {
                        IdTarip = ((List<Map<String,String>>) retFuncTarip.get("wsReturn")).get(0).get("IDTARIP");
                    }
                    rowData.put("IDTARIP", IdTarip);

                    Map<String, Object> retFuncInsertTempDKRP = new HashMap<String, Object>();
                    //todo: retFuncInsertTempDKRP = InsertTempDKRP(dTrans);

                    if (!retFuncInsertTempDKRP.get("wsByRefError").equals("")) {
                        Err = retFuncInsertTempDKRP.get("wsByRefError").toString();
                        throw new Exception(Err);
                    }

                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "";
                        tanggal = rowData.get("TANGGAL");

                        sql = "{ call PROC_12ABC_KOREKSI(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
                        cst = con.prepareCall(sql);
                        cst.setString(3, tTransaksiBy);
                        cst.setString(4, tIDPel);
                        cst.setString(5, tKdPembPP);
                        cst.setString(6, tKdGerakM);
                        cst.setString(7, null);
                        cst.setString(8, tBlTh);
                        cst.setString(9, tStatus);
                        cst.setString(10, tNorek);
                        cst.setString(11, tRPTAG.toString());
                        cst.setString(12, tRPBK.toString());
                        cst.setString(13, tKdkoreksi);
                        cst.setString(14, rowData.get("TGKOREKSI"));

                        cst.execute();


                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", status);
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + status);
                        }
                    }
                }
            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", Err);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> New_SetDataIdpel_12ABC(List<Map<String,String>> dTrans,
                                                        String tTransaksiBy,
                                                        String tKdkoreksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String tanggal = "", waktu = "";
        //todo: tanggal = ambilTanggaleksekusi(Err, waktu)

        String idpelErr = "", tPetugas, tBLTH, tIDPEL, tNOPEL,
                tKDGERAKM, tUPLOADTIME, tUPLOADBY,
                tTGLBAYAR, tWKTBAYAR,
                tKDPP, tKDPEMBAYAR,
                tSTATUS, tKDPEMBPP,
                tKDPEMBAYARSIP3, tUNITUP, tPEMDA,
                tNAMA, tPNJ, tNAMAPNJ,
                tNOBANG, tKETNOBANG, tRT,
                tRW, tNODLMRT, tKETNODLMRT,
                tLINGKUNGAN, tKODEPOS, tIDTARIP,
                tTARIP, tKDPEMBTRF, tABONMETER,
                tKDAYA, tKOGOL,
                tSUBKOGOL, tFRT, tFJN,
                tKDPPJ, tUNITKJ, tKDINKASO,
                tKDKELOMPOK, tTGLJTTEMPO, tKDDK,
                tTGLBACA, tSLALWBP, tSAHLWBP,
                tSLAWBP, tSAHWBP, tSLAKVARH,
                tSAHKVARH, tSKVAMAX, tFAKM,
                tFAKMKVARH, tFAKMKVAMAX, tCTTLB,
                tKDANGSA, tKDANGSB, tKDANGSC,
                tNOREK, tNOAGENDA, tFLAGSOPP,
                tFLAGANJA, tKDKIRIM, tKDTERIMA,
                tTGLKONSLD, tUPDATEBY,
                tUPDATETIME, tTGLBATALTRANS, tBATALBY,
                tALASANBATAL, tTGLTRANSAKSI;
        Integer tDAYA, tKWHLWBP, tKWHWBP, tBLOK3, tPEMKWH, tKWHKVARH, tKELBKVARH, tRPLWBP,
                tRPWBP, tRPBLOK3, tRPKVARH, tRPBEBAN, tRPTTLB, tRPPTL, tRPTB, tRPPPN, tRPBPJU,
                tRPTRAFO, tRPSEWATRAFO, tRPSEWAKAP, tRPANGSA, tRPANGSB, tRPANGSC, tRPMAT, tRPPLN,
                tRPTAG, tRPPRODUKSI, tRPSUBSIDI, tRPREDUKSI, tRPINSENTIF, tRPDISINSENTIF, tRPBK1,
                tRPBK2, tRPBK3, tRPBK, tRPTDLLAMA, tRPTDLBARU, tRPSELISIH, tKONSLDKE;

        String IdTarip = "", ttarip;

        String Err = "";

        tKODEPOS = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {

                    tPetugas = tTransaksiBy;
                    tBLTH = rowData.get("BLTH");
                    tIDPEL = rowData.get("IDPEL");
                    tNOPEL = rowData.get("NOPEL");
                    tKDGERAKM = rowData.get("KDGERAKMASUK");
                    todo: tUPLOADTIME = rowData.get("UPLOADTIME");
                    tUPLOADBY = rowData.get("UPLOADBY");
                    //tKDGERAKKELUAR = rowData.get("KDGERAKKELUAR")
                    //tTGLBAYAR = rowData.get("TGLBAYAR")
                    //tWKTBAYAR = rowData.get("WKTBAYAR")
                    //tKDPP = rowData.get("KDPP")
                    //tKDPEMBAYAR = rowData.get("KDPEMBAYAR")
                    tSTATUS = rowData.get("STATUS");
                    tKDPEMBPP = rowData.get("KDPEMBPP");
                    //tKDPEMBAYARSIP3 = rowData.get("KDPEMBAYARSIP3")
                    tUNITUP = rowData.get("UNITUP");
                    tPEMDA = rowData.get("PEMDA");
                    tNAMA = rowData.get("NAMA");
                    tPNJ = rowData.get("PNJ");
                    tNAMAPNJ = rowData.get("NAMAPNJ");
                    tNOBANG = rowData.get("NOBANG");
                    tKETNOBANG = rowData.get("KETNOBANG");
                    tRT = rowData.get("RT");
                    tRW = rowData.get("RW");
                    tNODLMRT = rowData.get("NODLMRT");
                    //tKETNODLMRT = rowData.get("KETNODLMRT")
                    tLINGKUNGAN = rowData.get("LINGKUNGAN");
                    //tIDTARIP = rowData.get("IDTARIP")
                    tTARIP = rowData.get("TARIP");
                    tKDPEMBTRF = rowData.get("KDPEMBTRF");
                    tABONMETER = rowData.get("ABONMETER");
                    tKDAYA = rowData.get("KDAYA");
                    tKOGOL = rowData.get("KOGOL");
                    //tSUBKOGOL = rowData.get("SUBKOGOL")
                    tFRT = rowData.get("FRT");
                    tFJN = rowData.get("FJN");
                    tKDPPJ = rowData.get("KDPPJ");
                    //tUNITKJ = rowData.get("UNITKJ")
                    tKDINKASO = rowData.get("KDINKASO");
                    tKDKELOMPOK = rowData.get("KDKELOMPOK");
                    tTGLJTTEMPO = rowData.get("TGLJTTEMPO");
                    tKDDK = rowData.get("KDDK");
                    tTGLBACA = rowData.get("TGLBACA");
                    tSLALWBP = rowData.get("SLALWBP");
                    tSAHLWBP = rowData.get("SAHLWBP");
                    tSLAWBP = rowData.get("SLAWBP");
                    tSAHWBP = rowData.get("SAHWBP");
                    tSLAKVARH = rowData.get("SLAKVARH");
                    tSAHKVARH = rowData.get("SAHKVARH");
                    tSKVAMAX = rowData.get("SKVAMAX");
                    tFAKM = rowData.get("FAKM");
                    tFAKMKVARH = rowData.get("FAKMKVARH");
                    tFAKMKVAMAX = rowData.get("FAKMKVAMAX");
                    //tCTTLB = rowData.get("CTTLB")
                    tKDANGSA = rowData.get("KDANGSA");
                    tKDANGSB = rowData.get("KDANGSB");
                    tKDANGSC = rowData.get("KDANGSC");
                    tNOREK = rowData.get("NOREK");
                    //tNOAGENDA = rowData.get("NOAGENDA")
                    tFLAGSOPP = rowData.get("FLAGSOPP");
                    tFLAGANJA = rowData.get("FLAGANJA");
                    tDAYA = Integer.parseInt(rowData.get("DAYA"));
                    tKWHLWBP = Integer.parseInt(rowData.get("KWHLWBP"));
                    tKWHWBP = Integer.parseInt(rowData.get("KWHWBP"));
                    tBLOK3 = Integer.parseInt(rowData.get("BLOK3"));
                    tPEMKWH = Integer.parseInt(rowData.get("PEMKWH"));
                    tKWHKVARH = Integer.parseInt(rowData.get("KWHKVARH"));
                    tKELBKVARH = Integer.parseInt(rowData.get("KELBKVARH"));
                    tRPLWBP = Integer.parseInt(rowData.get("RPLWBP"));
                    tRPWBP = Integer.parseInt(rowData.get("RPWBP"));
                    tRPBLOK3 = Integer.parseInt(rowData.get("RPBLOK3"));
                    tRPKVARH = Integer.parseInt(rowData.get("RPKVARH"));
                    tRPBEBAN = Integer.parseInt(rowData.get("RPBEBAN"));
                    tRPTTLB = Integer.parseInt(rowData.get("RPTTLB"));
                    tRPPTL = Integer.parseInt(rowData.get("RPPTL"));
                    tRPTB = Integer.parseInt(rowData.get("RPTB"));
                    tRPPPN = Integer.parseInt(rowData.get("RPPPN"));
                    tRPBPJU = Integer.parseInt(rowData.get("RPBPJU"));
                    tRPTRAFO = Integer.parseInt(rowData.get("RPTRAFO"));
                    tRPSEWATRAFO = Integer.parseInt(rowData.get("RPSEWATRAFO"));
                    tRPSEWAKAP = Integer.parseInt(rowData.get("RPSEWAKAP"));
                    tRPANGSA = Integer.parseInt(rowData.get("RPANGSA"));
                    tRPANGSB = Integer.parseInt(rowData.get("RPANGSB"));
                    tRPANGSC = Integer.parseInt(rowData.get("RPANGSC"));
                    tRPMAT = Integer.parseInt(rowData.get("RPMAT"));
                    tRPPLN = Integer.parseInt(rowData.get("RPPLN"));
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPPRODUKSI = Integer.parseInt(rowData.get("RPPRODUKSI"));
                    tRPSUBSIDI = Integer.parseInt(rowData.get("RPSUBSIDI"));
                    tRPREDUKSI = Integer.parseInt(rowData.get("RPREDUKSI"));
                    tRPINSENTIF = Integer.parseInt(rowData.get("RPINSENTIF"));
                    tRPDISINSENTIF = Integer.parseInt(rowData.get("RPDISINSENTIF"));
                    tRPBK1 = Integer.parseInt(rowData.get("RPBK1"));
                    tRPBK2 = Integer.parseInt(rowData.get("RPBK2"));
                    tRPBK3 = Integer.parseInt(rowData.get("RPBK3"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK1")) + Integer.parseInt(rowData.get("RPBK2")) + Integer.parseInt(rowData.get("RPBK3"));
                    tRPTDLLAMA = Integer.parseInt(rowData.get("RPTDLLAMA"));
                    tRPTDLBARU = Integer.parseInt(rowData.get("RPTDLBARU"));
                    tRPSELISIH = Integer.parseInt(rowData.get("RPSELISIH"));

                    if (rowData.get("KDAYA") == "K") {
                        tDAYA = tDAYA * 1000;
                    } else {
                        tDAYA = tDAYA;
                    }

                    Map<String, Object> retFuncTarip = new HashMap<String, Object>();
                    //todo: retFuncTarip = cekTarip(ttarip, tdaya, tBlTh);

                    if (!retFuncTarip.get("wsByRefError").equals("")) {
                        Err = "";
                        IdTarip = "0000000000";
                    } else {
                        IdTarip = ((List<Map<String,String>>) retFuncTarip.get("wsReturn")).get(0).get("IDTARIP");
                    }
                    rowData.put("IDTARIP", IdTarip);

                    if (idpelErr == tIDPEL) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "";
                        tanggal = rowData.get("TANGGAL");

                        sql = "{ call PROC_12ABC_KOREKSI_NEW(?,?,?,?,?,?,?,?,?,?," +
                                "?,?,?,?,?,?,?,?,?,?," +
                                "?,?,?,?,?,?,?,?,?,?," +
                                "?,?,?,?,?,?,?,?,?,?," +
                                "?,?,?,?,?,?,?,?,?,?," +
                                "?,?,?,?,?,?,?,?,?,?," +
                                "?,?,?,?,?,?,?,?,?,?," +
                                "?,?,?,?,?,?,?,?,?,?," +
                                "?,?,?,?,?,?,?,?,?,?," +
                                "?,?,?,?,?,?,?,?,?,?," +
                                "?,?,?,?,?,?,?) }";
                        cst = con.prepareCall(sql);
                        cst.setString(1, tBLTH);
                        cst.setString(2, tIDPEL);
                        cst.setString(3, tNOPEL);
                        cst.setString(4, tKDGERAKM);
                        cst.setString(5, tUPLOADTIME);
                        cst.setString(6, tUPLOADBY);
                        cst.setString(7, null);
                        cst.setString(8, null);
                        cst.setString(9, null);
                        cst.setString(10, null);
                        cst.setString(11, null);
                        cst.setString(12, tKdkoreksi);
                        cst.setString(13, "TO_CHAR(SYSDATE, 'yyyyMMdd')");
                        cst.setString(14, tSTATUS);
                        cst.setString(15, tKDPEMBPP);
                        cst.setString(16, null);
                        cst.setString(17, tUNITUP);
                        cst.setString(18, tPEMDA);
                        cst.setString(19, tNAMA);
                        cst.setString(20, tPNJ);
                        cst.setString(21, tNAMAPNJ);
                        cst.setString(22, tNOBANG);
                        cst.setString(23, tKETNOBANG);
                        cst.setString(24, tRT);
                        cst.setString(25, tRW);
                        cst.setString(26, tNODLMRT);
                        cst.setString(27, null);
                        cst.setString(28, tLINGKUNGAN);
                        cst.setString(29, tKODEPOS);
                        cst.setString(30, IdTarip);
                        cst.setString(31, tTARIP);
                        cst.setString(32, tKDPEMBTRF);
                        cst.setString(33, tABONMETER);
                        cst.setString(34, tDAYA.toString());
                        cst.setString(35, tKDAYA);
                        cst.setString(36, tKOGOL);
                        cst.setString(37, " ");
                        cst.setString(38, tFRT);
                        cst.setString(39, tFJN);
                        cst.setString(40, tKDPPJ);
                        cst.setString(41, null);
                        cst.setString(42, tKDINKASO);
                        cst.setString(43, tKDKELOMPOK);
                        cst.setString(44, tTGLJTTEMPO);
                        cst.setString(45, tKDDK);
                        cst.setString(46, tTGLBACA);
                        cst.setString(47, tSLALWBP);
                        cst.setString(48, tSAHLWBP);
                        cst.setString(49, tSLAWBP);
                        cst.setString(50, tSAHWBP);
                        cst.setString(51, tSLAKVARH);
                        cst.setString(52, tSAHKVARH);
                        cst.setString(53, tSKVAMAX);
                        cst.setString(54, tFAKM);
                        cst.setString(55, tFAKMKVARH);
                        cst.setString(56, tFAKMKVAMAX);
                        cst.setString(57, tKWHLWBP.toString());
                        cst.setString(58, tKWHWBP.toString());
                        cst.setString(59, tBLOK3.toString());
                        cst.setString(60, tPEMKWH.toString());
                        cst.setString(61, tKWHKVARH.toString());
                        cst.setString(62, tKELBKVARH.toString());
                        cst.setString(63, tRPLWBP.toString());
                        cst.setString(64, tRPWBP.toString());
                        cst.setString(65, tRPBLOK3.toString());
                        cst.setString(66, tRPKVARH.toString());
                        cst.setString(67, tRPBEBAN.toString());
                        cst.setString(68, null);
                        cst.setString(69, tRPTTLB.toString());
                        cst.setString(70, tRPPTL.toString());
                        cst.setString(71, tRPTB.toString());
                        cst.setString(72, tRPPPN.toString());
                        cst.setString(73, tRPBPJU.toString());
                        cst.setString(74, tRPTRAFO.toString());
                        cst.setString(75, tRPSEWATRAFO.toString());
                        cst.setString(76, tRPSEWAKAP.toString());
                        cst.setString(77, tKDANGSA);
                        cst.setString(78, tRPANGSA.toString());
                        cst.setString(79, tKDANGSB);
                        cst.setString(80, tRPANGSB.toString());
                        cst.setString(81, tKDANGSC);
                        cst.setString(82, tRPANGSC.toString());
                        cst.setString(83, tRPMAT.toString());
                        cst.setString(84, tRPPLN.toString());
                        cst.setString(85, tRPTAG.toString());
                        cst.setString(86, tRPPRODUKSI.toString());
                        cst.setString(87, tRPSUBSIDI.toString());
                        cst.setString(88, tRPREDUKSI.toString());
                        cst.setString(89, tRPINSENTIF.toString());
                        cst.setString(90, tRPDISINSENTIF.toString());
                        cst.setString(91, tRPBK1.toString());
                        cst.setString(92, tRPBK2.toString());
                        cst.setString(93, tRPBK3.toString());
                        cst.setString(94, tRPTDLLAMA.toString());
                        cst.setString(95, tRPTDLBARU.toString());
                        cst.setString(96, tRPSELISIH.toString());
                        cst.setString(97, tNOREK);
                        cst.setString(98, null);
                        cst.setString(99, tFLAGSOPP);
                        cst.setString(100, tFLAGANJA);
                        cst.setString(101, null);
                        cst.setString(102, null);
                        cst.setString(103, null);
                        cst.setString(104, null);
                        cst.setString(105, null);
                        cst.setString(106, null);
                        cst.setString(107, tTransaksiBy);

                        cst.execute();


                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", status);
                        } else {
                            idpelErr = tIDPEL;
                            rowData.put("HASIL", "0, " + status);
                        }
                    }
                }
            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", Err);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_12ABCNew(String idpel,
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
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call emulsion.BILL$51_DKRP.SETIDPEL@billingjatim(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, idpel);
            cst.execute();

            sql = "{ call emulsion.BILL$51_DKRP.SETTHBLREK@billingjatim(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, thblrek);
            cst.execute();

            sql = "{ call emulsion.BILL$51_DKRP.SETSLALWBP@billingjatim(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SLALWBP.toString());
            cst.execute();

            sql = "{ call emulsion.BILL$51_DKRP.SETSAHLWBPL@billingjatim(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SAHLWBP.toString());
            cst.execute();

            sql = "{ call emulsion.BILL$51_DKRP.SETSLAWBP@billingjatim(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SLAWBP.toString());
            cst.execute();

            sql = "{ call emulsion.BILL$51_DKRP.SETSAHWBP@billingjatim(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SAHWBP.toString());
            cst.execute();

            sql = "{ call emulsion.BILL$51_DKRP.SETSLAKVARH@billingjatim(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SLAKVARH.toString());
            cst.execute();

            sql = "{ call emulsion.BILL$51_DKRP.SETSAHKVARH@billingjatim(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SAHKVARH.toString());
            cst.execute();

            sql = "{ call emulsion.BILL$51_DKRP.SETSAHKVAMAKS@billingjatim(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SAHKVAMAKS.toString());
            cst.execute();

            sql = "{ call emulsion.BILL$51_DKRP.SETHITUNGBY@billingjatim(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, HITUNGBY);
            cst.execute();


            sql = "{ call bill$51_dkrp.hitungkoreksi@billingjatim(?,?) }";
            cst = con.prepareCall(sql);
            cst.registerOutParameter("OUT_MESSAGE", OracleTypes.NVARCHAR);
            cst.registerOutParameter("OUT_RESULT", OracleTypes.BIGINT);
            cst.execute();

            String vPesanKoreksiBill = cst.getNString("OUT_MESSAGE");
            Integer vHasilKoreksiBill = cst.getInt("OUT_RESULT");


            if (vHasilKoreksiBill == 1) {
                sql = " select * from vw$bill51_dkrp@billingjatim WHERE ";
                sql = sql + "idpel='" + idpel + "' and blth='" + thblrek + "' ";

                cst = con.prepareCall(sql);
                rs = cst.executeQuery();
                lMapData = CommonModule.convertResultsetToListStr(rs);
            } else {
                Err = vPesanKoreksiBill;
            }


            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", Err);
            retValue.put("wsByRefHasil", vHasilKoreksiBill);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefHasil", -1);
        }

        return retValue;
    }

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
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call " + _package + ".SETIDPEL(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, idpel);
            cst.execute();

            sql = "{ call " + _package + ".SETTHBLREK(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, thblrek);
            cst.execute();

            sql = "{ call " + _package + ".SETSLALWBP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SLALWBP.toString());
            cst.execute();

            sql = "{ call " + _package + ".SETSAHLWBP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SAHLWBP.toString());
            cst.execute();

            sql = "{ call " + _package + ".SETSLAWBP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SLAWBP.toString());
            cst.execute();

            sql = "{ call " + _package + ".SETSAHWBP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SAHWBP.toString());
            cst.execute();

            sql = "{ call " + _package + ".SETSLAKVARH(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SLAKVARH.toString());
            cst.execute();

            sql = "{ call " + _package + ".SETSAHKVARH(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SAHKVARH.toString());
            cst.execute();

            sql = "{ call " + _package + ".SETSAHKVAMAKS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SAHKVAMAKS.toString());
            cst.execute();

            sql = "{ call " + _package + ".SETHITUNGBY(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, HITUNGBY);
            cst.execute();

            sql = "{ call " + _package + ".SETSLALWBP_PASANG(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SLALWBP_PASANG.toString());
            cst.execute();

            sql = "{ call " + _package + ".SETSAHLWBP_CABUT(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SAHLWBP_CABUT.toString());
            cst.execute();

            sql = "{ call " + _package + ".SETSLAWBP_PASANG(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SLAWBP_PASANG.toString());
            cst.execute();

            sql = "{ call " + _package + ".SETSAHWBP_CABUT(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SAHWBP_CABUT.toString());
            cst.execute();

            sql = "{ call " + _package + ".SETSLAKVARH_PASANG(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SLAKVARH_PASANG.toString());
            cst.execute();

            sql = "{ call " + _package + ".SETSAHKVARH_CABUT(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SAHKVARH_CABUT.toString());
            cst.execute();

            sql = "{ call " + _package + ".SETSAHKVAMAKS_CABUT(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, SAHKVAMAKS_CABUT.toString());
            cst.execute();


            sql = "{ call " + _package + ".hitungkoreksi(?,?) }";
            cst = con.prepareCall(sql);
            cst.registerOutParameter("OUT_MESSAGE", OracleTypes.NVARCHAR);
            cst.registerOutParameter("OUT_RESULT", OracleTypes.BIGINT);
            cst.execute();

            String vPesanKoreksiBill = cst.getNString("OUT_MESSAGE");
            Integer vHasilKoreksiBill = cst.getInt("OUT_RESULT");


            if (vHasilKoreksiBill == 1) {
                sql = " select * from vw$bill51_dkrp WHERE ";
                sql = sql + "idpel='" + idpel + "' and blth='" + thblrek + "' ";

                cst = con.prepareCall(sql);
                rs = cst.executeQuery();
                lMapData = CommonModule.convertResultsetToListStr(rs);
            } else {
                Err = vPesanKoreksiBill;
            }


            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", Err);
            retValue.put("wsByRefHasil", vHasilKoreksiBill);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefHasil", -1);
        }

        return retValue;
    }

    public Map<String, Object> exeprocKoreksi(Boolean exec,
                                                        String procedurename,
                                                        List<Map<String, String>> paramvalue) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call " + procedurename + " }";

            if (procedurename == "emulsion.bill$51_dkrp.HITUNGKOREKSI@BILLINGJATIM") {

            }

            cst = con.prepareCall(sql);
            cst.registerOutParameter("OUT_MESSAGE", OracleTypes.NVARCHAR);
            cst.registerOutParameter("OUT_RESULT", OracleTypes.BIGINT);
            cst.registerOutParameter("OUT_CURSOR", OracleTypes.CURSOR);
            cst.execute();

            String vPesanKoreksiBill = cst.getNString("OUT_MESSAGE");
            Integer vHasilKoreksiBill = cst.getInt("OUT_RESULT");
            rs = (ResultSet)cst.getObject("OUT_CURSOR");

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


    public Map<String, Object> SetDataIdpel_12ABCJatelindo(List<Map<String,String>> dTrans,
                                                      String tTransaksiBy,
                                                      String tKdkoreksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String tanggal = "", waktu = "";
        //todo: tanggal = ambilTanggaleksekusi(Err, waktu)

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;

        String IdTarip = "", ttarip;
        Integer tdaya;

        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {

                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH");
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK1")) + Integer.parseInt(rowData.get("RPBK2")) + Integer.parseInt(rowData.get("RPBK3"));
                    tdaya = Integer.parseInt(rowData.get("DAYA"));
                    ttarip = rowData.get("TARIP");

                    if (rowData.get("KDAYA") == "K") {
                        tdaya = tdaya * 1000;
                    } else {
                        tdaya = tdaya;
                    }

                    Map<String, Object> retFuncTarip = new HashMap<String, Object>();
                    //todo: retFuncTarip = cekTarip(ttarip, tdaya, tBlTh);

                    if (!retFuncTarip.get("wsByRefError").equals("")) {
                        throw new Exception("Gagal Proses, " + retFuncTarip.get("wsByRefError"));
                    }
                    IdTarip = ((List<Map<String,String>>) retFuncTarip.get("wsReturn")).get(0).get("IDTARIP");
                    rowData.put("IDTARIP", IdTarip);


                    //todo: InsertTempDKRP(dtrans, Err)


                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "";
                        tanggal = rowData.get("TANGGAL");

                        sql = "{ call Proc_12ABC_KOREKSIJATELINDO(?) }";
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, null);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tRPTAG.toString());
                        cst.setString(10, tRPBK.toString());
                        cst.setString(11, tKdkoreksi);

                        cst.execute();


                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", status);
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + status);
                        }
                    }
                }
            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", Err);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }
    public Map<String, Object> SetDataIdpel_12DE(List<Map<String,String>> dTrans,
                                                      String tTransaksiBy,
                                                      String tKdkoreksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String tanggal = "", waktu = "";
        //todo: tanggal = ambilTanggaleksekusi(Err, waktu)

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tKdGerakK, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;

        String IdTarip = "", ttarip;
        Integer tdaya;

        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {

                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tKdGerakK = rowData.get("KDGERAKKELUAR");
                    tBlTh = rowData.get("BLTH");
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK1")) + Integer.parseInt(rowData.get("RPBK2")) + Integer.parseInt(rowData.get("RPBK3"));

                    if (tKdkoreksi == "D") {
                        tdaya = Integer.parseInt(rowData.get("DAYA"));
                        ttarip = rowData.get("TARIP");

                        IdTarip = rowData.get("TARIP");
                        rowData.put("IDTARIP", IdTarip);

                        //todo: InsertTempDKRP(dtrans, Err)
                    }


                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "";

                        if (tKdkoreksi == "D") {
                            sql = "{ call PROC_12D_RESTITUSI(?,?,?,?,?,?,?,?,?,?,?,?) }";
                        } else if (tKdkoreksi == "E") {
                            sql = "{ call PROC_12D_SUPLISI(?,?,?,?,?,?,?,?,?,?,?,?) }";
                        }

                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, tKdGerakK);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tRPTAG.toString());
                        cst.setString(10, tRPBK.toString());
                        cst.setString(11, tKdkoreksi);
                        cst.setString(12, rowData.get("TGKOREKSI"));

                        cst.execute();


                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", status);
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + status);
                        }
                    }
                }
            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", Err);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_12D(List<Map<String,String>> dTrans,
                                                      String tTransaksiBy,
                                                      String tKdkoreksi,
                                                      Boolean bSuplisi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tKdGerakK, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;

        String IdTarip = "", ttarip;
        Integer tdaya;

        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {

                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    //asumsi sementara, kdgerakkeluarnya adalah 21
                    tKdGerakK = rowData.get("KDGERAKKELUAR");
                    //---------------------------------------------------------------
                    tBlTh = rowData.get("BLTH");
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK1")) + Integer.parseInt(rowData.get("RPBK2")) + Integer.parseInt(rowData.get("RPBK3"));

                    if (tKdkoreksi == "D") {
                        tdaya = Integer.parseInt(rowData.get("DAYA"));
                        ttarip = rowData.get("TARIP");

                        if (rowData.get("KDAYA") == "K") {
                            tdaya = tdaya * 1000;
                        } else {
                            tdaya = tdaya;
                        }

                        IdTarip = rowData.get("TARIP");
                        rowData.put("IDTARIP", IdTarip);


                        cls_CloseDate cClose = new cls_CloseDate();
                        Map<String, Object> retFunc = cClose.CekCloseDate("12",rowData.get("TGKOREKSI"));

                        if (! (Boolean)retFunc.get("wsReturn")) {
                            throw new Exception(retFunc.get("wsByRefError").toString());
                        }

                        //todo: InsertTempDKRP(dtrans, Err)
                    }


                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "";

                        if (tKdkoreksi == "D") {
                            if (bSuplisi) {
                                sql = "{ call PROC_12D_SUPLISI(?,?,?,?,?,?,?,?,?,?,?,?) }";
                            } else {
                                sql = "{ call PROC_12D_RESTITUSI(?,?,?,?,?,?,?,?,?,?,?,?) }";
                            }
                        }

                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, tKdGerakK);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tRPTAG.toString());
                        cst.setString(10, tRPBK.toString());
                        cst.setString(11, tKdkoreksi);
                        cst.setString(12, rowData.get("TGKOREKSI"));

                        cst.execute();


                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", status);
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + status);
                        }
                    }
                }
            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", Err);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_12DJatelindo(List<Map<String,String>> dTrans,
                                                      String tTransaksiBy,
                                                      String tKdkoreksi,
                                                      Boolean bSuplisi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tKdGerakK, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;

        String IdTarip = "", ttarip;
        Integer tdaya;

        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {

                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    //asumsi sementara, kdgerakkeluarnya adalah 23
                    tKdGerakK = rowData.get("KDGERAKKELUAR");
                    //---------------------------------------------------------------
                    tBlTh = rowData.get("BLTH");
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK1")) + Integer.parseInt(rowData.get("RPBK2")) + Integer.parseInt(rowData.get("RPBK3"));

                    if (tKdkoreksi == "D") {
                        tdaya = Integer.parseInt(rowData.get("DAYA"));
                        ttarip = rowData.get("TARIP");

                        if (rowData.get("KDAYA") == "K") {
                            tdaya = tdaya * 1000;
                        } else {
                            tdaya = tdaya;
                        }

                        IdTarip = rowData.get("TARIP");
                        rowData.put("IDTARIP", IdTarip);

                        //todo: InsertTempDKRP(dtrans, Err)
                    }


                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "";

                        if (tKdkoreksi == "D") {
                            if (bSuplisi) {
                                sql = "{ call PROC_12D_SUPLISIJATELINDO(?,?,?,?,?,?,?,?,?,?,?) }";
                            } else {
                                sql = "{ call PROC_12D_RESTITUSIJATELINDO(?,?,?,?,?,?,?,?,?,?,?) }";
                            }
                        }

                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, tKdGerakK);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tRPTAG.toString());
                        cst.setString(10, tRPBK.toString());
                        cst.setString(11, tKdkoreksi);

                        cst.execute();


                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", status);
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + status);
                        }
                    }
                }
            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", Err);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_13(List<Map<String,String>> dTrans,
                                                      String tTransaksiBy,
                                                      String tJenis) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;

        String IdTarip = "", ttarip;
        Integer tdaya;

        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {

                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH");
                    tStatus = rowData.get("STATUS");
                    //tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    //tRPBK = Integer.parseInt(rowData.get("RPBK1")) + Integer.parseInt(rowData.get("RPBK2")) + Integer.parseInt(rowData.get("RPBK3"));
                    tRPBK = 0;

                    tdaya = Integer.parseInt(rowData.get("DAYA"));
                    ttarip = rowData.get("TARIP");

                    //todo: dsTarip = cekTarip(ttarip, tdaya, tBlTh, Err)

                    IdTarip = lMapData.get(0).get("TARIP");
                    rowData.put("IDTARIP", IdTarip);

                    //todo: InsertTempSOREKSUSULAN(tTransaksiBy, dtrans, Err)

                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "";

                        sql = "{ call Proc_13_SOREKDILDPP(?,?,?,?,?,?,?,?,?,?) }";

                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, null);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tRPTAG.toString());
                        cst.setString(9, tRPBK.toString());
                        cst.setString(10, tJenis.toUpperCase());

                        cst.execute();


                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", status);
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + status);
                        }
                    }
                }
            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", Err);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }







    // ======
    public Map<String, Object> cekTarip( String trp,
                                         String daya,
                                         String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "select * from tarif ";
            sql += " WHERE  tarip = TRIM('" + trp + "')";
            sql += " AND Tarif.Daya_Min <= " + daya;
            sql += " AND Tarif.Daya_Max >= " + daya;
            sql += " AND TARIF.bl_th_berlaku =";
            sql += "     (SELECT MAX (bl_th_berlaku)";
            sql += "      FROM tarif";
            sql += "      WHERE bl_th_berlaku <= '" + thbl + "')";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("IdTarip tidak ditemukan.");
            }

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

    public Map<String, Object> InsertTempDKRP(List<Map<String, String>> ds) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for(Map<String, String> rowData : ds) {
                if (Integer.parseInt(rowData.get("RPSELISIH")) > 0) {
                    throw new Exception("Validasi Rupiah Tagihan Tidak Valid");
                }
                if (Integer.parseInt(rowData.get("RPANGSA")) > 0) {
                    String KDANGSA = rowData.get("KDANGSA");
                    if (!KDANGSA.equals("1")
                        && !KDANGSA.equals("3")
                        && !KDANGSA.equals("4")
                        && !KDANGSA.equals("8")
                        && !KDANGSA.equals("9")
                        && !KDANGSA.equals("A")
                        && !KDANGSA.equals("B")
                        && !KDANGSA.equals("C")
                        && !KDANGSA.equals("D")
                        && !KDANGSA.equals("E"))
                    throw new Exception("KODE ANGSA TIDAK VALID");
                }
                if (Integer.parseInt(rowData.get("RPANGSB")) > 0) {
                    String KDANGSB = rowData.get("KDANGSB");
                    if (!KDANGSB.equals("1")
                        && !KDANGSB.equals("3")
                        && !KDANGSB.equals("4")
                        && !KDANGSB.equals("8")
                        && !KDANGSB.equals("9")
                        && !KDANGSB.equals("A")
                        && !KDANGSB.equals("B")
                        && !KDANGSB.equals("D")
                        && !KDANGSB.equals("E"))
                    throw new Exception("KODE ANGSB TIDAK VALID");
                }
                if (Integer.parseInt(rowData.get("RPANGSC")) > 0) {
                    String KDANGSC = rowData.get("KDANGSC");
                    if (!KDANGSC.equals("1")
                        && !KDANGSC.equals("3")
                        && !KDANGSC.equals("4")
                        && !KDANGSC.equals("8")
                        && !KDANGSC.equals("9")
                        && !KDANGSC.equals("A")
                        && !KDANGSC.equals("B")
                        && !KDANGSC.equals("C")
                        && !KDANGSC.equals("D")
                        && !KDANGSC.equals("E"))
                    throw new Exception("KODE ANGSC TIDAK VALID");
                }

                sql = " DELETE TEMPDKRP ";
                sql = sql + " WHERE TRANSAKSIBY = '" + rowData.get("TRANSAKSIBY") + "'";

                cst = con.prepareCall(sql);
                cst.execute();

                sql = "";
                sql = "INSERT INTO TEMPDKRP";
                sql += " (BLTH, IDPEL, NOPEL, ";
                sql += "KDGERAKMASUK, UPLOADTIME, UPLOADBY, ";
                sql += "KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, ";
                sql += "KDPP, KDPEMBAYAR, KDKOREKSI, ";
                sql += "TGKOREKSI, ";
                //If .Item("UNITUP").ToString.Substring(0, 2) = "51" Then
                sql += "RPINSENTIF_KVA, RPINSENTIF_KWH, RPDISINSENTIF_KVA, RPDISINSENTIF_KWH,";
               //End If
                sql += "STATUS, KDPEMBPP, ";
                sql += "KDPEMBAYARSIP3, UNITUP, PEMDA, ";
                sql += "NAMA, PNJ, NAMAPNJ, ";
                sql += "NOBANG, KETNOBANG, RT, ";
                sql += "RW, NODLMRT, KETNODLMRT, ";
                sql += "LINGKUNGAN, KODEPOS, IDTARIP, ";
                sql += "TARIP, KDPEMBTRF, ABONMETER, ";
                sql += "DAYA, KDAYA, KOGOL, ";
                sql += "SUBKOGOL, FRT, FJN, ";
                sql += "KDPPJ, UNITKJ, KDINKASO, ";
                sql += "KDKELOMPOK, TGLJTTEMPO, KDDK, ";
                sql += "TGLBACA, SLALWBP, SAHLWBP, ";
                sql += "SLAWBP, SAHWBP, SLAKVARH, ";
                sql += "SAHKVARH, SKVAMAX, FAKM, ";
                sql += "FAKMKVARH, FAKMKVAMAX, KWHLWBP, ";
                sql += "KWHWBP, BLOK3, PEMKWH, ";
                sql += "KWHKVARH, KELBKVARH, RPLWBP, ";
                sql += "RPWBP, RPBLOK3, RPKVARH, ";
                sql += "RPBEBAN, CTTLB, RPTTLB, ";
                sql += "RPPTL, RPTB, RPPPN, ";
                sql += "RPBPJU, RPTRAFO, RPSEWATRAFO, ";
                sql += "RPSEWAKAP, KDANGSA, RPANGSA, ";
                sql += "KDANGSB, RPANGSB, KDANGSC, ";
                sql += "RPANGSC, RPMAT, RPPLN, ";
                sql += "RPTAG, RPPRODUKSI, RPSUBSIDI, ";
                sql += "RPREDUKSI, RPINSENTIF, RPDISINSENTIF, ";
                sql += "RPBK1, RPBK2, RPBK3, ";
                sql += "RPTDLLAMA, RPTDLBARU, RPSELISIH, ";
                sql += "NOREK, NOAGENDA, FLAGSOPP, ";
                sql += "FLAGANJA, KDKIRIM, KDTERIMA, ";
                sql += "TGLKONSLD, KONSLDKE, UPDATEBY, ";
                sql += "UPDATETIME, TGLBATALTRANS, BATALBY, ";
                sql += "ALASANBATAL, TGLTRANSAKSI, TRANSAKSIBY, ";
                sql += "TRANSAKSIID) ";
                sql += " VALUES (";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,? ";
                sql += ") ";

                cst = con.prepareCall(sql);

                Integer indexParam = 0;

                cst.setString(indexParam++, rowData.get("BLTH"));
                cst.setString(indexParam++, rowData.get("IDPEL"));
                cst.setString(indexParam++, rowData.get("NOPEL"));
                cst.setString(indexParam++, rowData.get("KDGERAKMASUK"));
                cst.setString(indexParam++, rowData.get("UPLOADTIME"));
                cst.setString(indexParam++, rowData.get("UPLOADBY"));
                cst.setString(indexParam++, rowData.get("KDGERAKKELUAR"));
                cst.setString(indexParam++, rowData.get("TGLBAYAR"));
                cst.setString(indexParam++, rowData.get("WKTBAYAR"));
                cst.setString(indexParam++, rowData.get("KDPP"));

                cst.setString(indexParam++, rowData.get("KDPEMBAYAR"));
                cst.setString(indexParam++, rowData.get("KDKOREKSI"));
                cst.setString(indexParam++, rowData.get("TO_CHAR(SYSDATE,'YYYYMMDD')"));  //todo: paremeter'a!!
                cst.setString(indexParam++, rowData.get("RPINSENTIF_KVA"));
                cst.setString(indexParam++, rowData.get("RPINSENTIF_KWH"));
                cst.setString(indexParam++, rowData.get("RPDISINSENTIF_KVA"));
                cst.setString(indexParam++, rowData.get("RPDISINSENTIF_KWH"));
                cst.setString(indexParam++, rowData.get("STATUS"));
                cst.setString(indexParam++, rowData.get("KDPEMBPP"));
                cst.setString(indexParam++, rowData.get("KDPEMBAYARSIP3"));

                cst.setString(indexParam++, rowData.get("UNITUP"));
                cst.setString(indexParam++, rowData.get("PEMDA"));
                cst.setString(indexParam++, rowData.get("NAMA"));
                cst.setString(indexParam++, rowData.get("PNJ"));
                cst.setString(indexParam++, rowData.get("NAMAPNJ"));
                cst.setString(indexParam++, rowData.get("NOBANG"));
                cst.setString(indexParam++, rowData.get("KETNOBANG"));
                cst.setString(indexParam++, rowData.get("RT"));
                cst.setString(indexParam++, rowData.get("RW"));
                cst.setString(indexParam++, rowData.get("NODLMRT"));

                cst.setString(indexParam++, rowData.get("KETNODLMRT"));
                cst.setString(indexParam++, rowData.get("LINGKUNGAN"));
                cst.setString(indexParam++, rowData.get("KODEPOS"));
                cst.setString(indexParam++, rowData.get("IDTARIP"));
                cst.setString(indexParam++, rowData.get("TARIP"));
                cst.setString(indexParam++, rowData.get("KDPEMBTRF"));
                cst.setString(indexParam++, rowData.get("ABONMETER"));
                cst.setString(indexParam++, rowData.get("DAYA"));
                cst.setString(indexParam++, rowData.get("KDAYA"));
                cst.setString(indexParam++, rowData.get("KOGOL"));

                cst.setString(indexParam++, rowData.get("SUBKOGOL"));
                cst.setString(indexParam++, rowData.get("FRT"));
                cst.setString(indexParam++, rowData.get("FJN"));
                cst.setString(indexParam++, rowData.get("KDPPJ"));
                cst.setString(indexParam++, rowData.get("UNITKJ"));
                cst.setString(indexParam++, rowData.get("KDINKASO"));
                cst.setString(indexParam++, rowData.get("KDKELOMPOK"));
                cst.setString(indexParam++, rowData.get("TGLJTTEMPO"));
                cst.setString(indexParam++, rowData.get("KDDK"));
                cst.setString(indexParam++, rowData.get("TGLBACA"));

                cst.setString(indexParam++, rowData.get("SLALWBP"));
                cst.setString(indexParam++, rowData.get("SAHLWBP"));
                cst.setString(indexParam++, rowData.get("SLAWBP"));
                cst.setString(indexParam++, rowData.get("SAHWBP"));
                cst.setString(indexParam++, rowData.get("SLAKVARH"));
                cst.setString(indexParam++, rowData.get("SAHKVARH"));
                cst.setString(indexParam++, rowData.get("SKVAMAX"));
                cst.setString(indexParam++, rowData.get("FAKM"));
                cst.setString(indexParam++, rowData.get("FAKMKVARH"));
                cst.setString(indexParam++, rowData.get("FAKMKVAMAX"));

                cst.setString(indexParam++, rowData.get("KWHLWBP"));
                cst.setString(indexParam++, rowData.get("KWHWBP"));
                cst.setString(indexParam++, rowData.get("BLOK3"));
                cst.setString(indexParam++, rowData.get("PEMKWH"));
                cst.setString(indexParam++, rowData.get("KWHKVARH"));
                cst.setString(indexParam++, rowData.get("KELBKVARH"));
                cst.setString(indexParam++, rowData.get("RPLWBP"));
                cst.setString(indexParam++, rowData.get("RPWBP"));
                cst.setString(indexParam++, rowData.get("RPBLOK3"));
                cst.setString(indexParam++, rowData.get("RPKVARH"));

                cst.setString(indexParam++, rowData.get("RPBEBAN"));
                cst.setString(indexParam++, rowData.get("CTTLB"));
                cst.setString(indexParam++, rowData.get("RPTTLB"));
                cst.setString(indexParam++, rowData.get("RPPTL"));
                cst.setString(indexParam++, rowData.get("RPTB"));
                cst.setString(indexParam++, rowData.get("RPPPN"));
                cst.setString(indexParam++, rowData.get("RPBPJU"));
                cst.setString(indexParam++, rowData.get("RPTRAFO"));
                cst.setString(indexParam++, rowData.get("RPSEWATRAFO"));
                cst.setString(indexParam++, rowData.get("RPSEWAKAP"));

                cst.setString(indexParam++, rowData.get("KDANGSA"));
                cst.setString(indexParam++, rowData.get("RPANGSA"));
                cst.setString(indexParam++, rowData.get("KDANGSB"));
                cst.setString(indexParam++, rowData.get("RPANGSB"));
                cst.setString(indexParam++, rowData.get("KDANGSC"));
                cst.setString(indexParam++, rowData.get("RPANGSC"));
                cst.setString(indexParam++, rowData.get("RPMAT"));
                cst.setString(indexParam++, rowData.get("RPPLN"));
                cst.setString(indexParam++, rowData.get("RPTAG"));
                cst.setString(indexParam++, rowData.get("RPPRODUKSI"));

                cst.setString(indexParam++, rowData.get("RPSUBSIDI"));
                cst.setString(indexParam++, rowData.get("RPREDUKSI"));
                cst.setString(indexParam++, rowData.get("RPINSENTIF"));
                cst.setString(indexParam++, rowData.get("RPDISINSENTIF"));
                cst.setString(indexParam++, rowData.get("RPBK1"));
                cst.setString(indexParam++, rowData.get("RPBK2"));
                cst.setString(indexParam++, rowData.get("RPBK3"));
                cst.setString(indexParam++, rowData.get("RPTDLLAMA"));
                cst.setString(indexParam++, rowData.get("RPTDLBARU"));
                cst.setString(indexParam++, rowData.get("RPSELISIH"));

                cst.setString(indexParam++, rowData.get("NOREK"));
                cst.setString(indexParam++, rowData.get("NOAGENDA"));
                cst.setString(indexParam++, rowData.get("FLAGSOPP"));
                cst.setString(indexParam++, rowData.get("FLAGANJA"));
                cst.setString(indexParam++, rowData.get("KDKIRIM"));
                cst.setString(indexParam++, rowData.get("KDTERIMA"));
                cst.setString(indexParam++, rowData.get("TGLKONSLD"));
                cst.setString(indexParam++, rowData.get("KONSLDKE"));
                cst.setString(indexParam++, rowData.get("UPDATEBY"));
                cst.setString(indexParam++, rowData.get("UPDATETIME"));

                cst.setString(indexParam++, rowData.get("TGLBATALTRANS"));
                cst.setString(indexParam++, rowData.get("BATALBY"));
                cst.setString(indexParam++, rowData.get("ALASANBATAL"));
                cst.setString(indexParam++, rowData.get("TGLTRANSAKSI"));
                cst.setString(indexParam++, rowData.get("TRANSAKSIBY"));
                cst.setString(indexParam++, rowData.get("TRANSAKSIID"));

                cst.execute();
            }

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

//    Function Convert2SQL_DKRP(ByVal Value As Object, Optional ByVal UsedLongDate As Boolean = False) As String
//    Dim Tmp As String
//    If TypeOf Value Is String Then
//    If UCase(Value) = "NULL" Or Value = "" Then
//            Tmp = "NULL"
//    Else
//            Tmp = "'" & Replace$(Value, "'", "''", , , CompareMethod.Text) & "'"
//    End If
//    Return Tmp
//    ElseIf TypeOf Value Is Date Then
//    Dim TheDate As Date = CType(Value, Date)
//    Dim Jam As Integer = Hour(TheDate)
//    If Not UsedLongDate Then
//    Tmp = "TO_DATE('" & TheDate.ToString("yyyy/MM/dd") & "','yyyy/mm/dd')"
//    Else
//            Tmp = "TO_DATE('" & TheDate.ToString("yyyy/MM/dd") & " " & Jam.ToString & ":" & TheDate.ToString("mm:ss") & "','YYYY/MM/DD HH24:MI:SS')"
//    End If
//    Return Tmp
//    ElseIf IsNumeric(Value) Then
//    If Val(Value) < 0 Then
//            Value = -1 * Val(Value)
//    End If
//    Tmp = Replace$(Value, ",", ".", , , CompareMethod.Text)
//    Return Tmp
//    Else
//    Return "NULL"
//    End If
//
//    End Function



    public Map<String, Object> InsertTempSOREKSUSULAN(String tTransaksiBy, List<Map<String, String>> ds) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for(Map<String, String> rowData : ds) {
                sql = " DELETE TEMPSOREK ";
                sql = sql + " WHERE TRANSAKSIBY = '" + tTransaksiBy + "'";

                cst = con.prepareCall(sql);
                cst.execute();

                sql = "";
                sql = "INSERT INTO TEMPSOREK";
                sql += " (BLTH, IDPEL, NOPEL, ";
                sql += "   KDGERAKMASUK, UPLOADTIME, UPLOADBY, ";
                //mSql += "KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, "
                //mSql += "KDPP, KDPEMBAYAR, KDKOREKSI, "
                //mSql += "TGKOREKSI, "
                sql += "STATUS, KDPEMBPP, ";
                sql += "KDPEMBAYARSIP3, UNITUP, PEMDA, ";
                sql += "NAMA, PNJ, NAMAPNJ, ";
                sql += "NOBANG, KETNOBANG, RT, ";
                sql += "RW, NODLMRT, KETNODLMRT, ";
                sql += "LINGKUNGAN, KODEPOS, IDTARIP, ";
                sql += "TARIP, KDPEMBTRF, ABONMETER, ";
                sql += "DAYA, KDAYA, KOGOL, ";
                sql += "SUBKOGOL, FRT, FJN, ";
                sql += "KDPPJ, UNITKJ, KDINKASO, ";
                sql += "KDKELOMPOK, TGLJTTEMPO, KDDK, ";
                sql += "TGLBACA, SLALWBP, SAHLWBP, ";
                sql += "SLAWBP, SAHWBP, SLAKVARH, ";
                sql += "SAHKVARH, SKVAMAX, FAKM, ";
                sql += "FAKMKVARH, FAKMKVAMAX, KWHLWBP, ";
                sql += "KWHWBP, BLOK3, PEMKWH, ";
                sql += "KWHKVARH, KELBKVARH, RPLWBP, ";
                sql += "RPWBP, RPBLOK3, RPKVARH, ";
                sql += "RPBEBAN, CTTLB, RPTTLB, ";
                sql += "RPPTL, RPTB, RPPPN, ";
                sql += "RPBPJU, RPTRAFO, RPSEWATRAFO, ";
                sql += "RPSEWAKAP, KDANGSA, RPANGSA, ";
                sql += "KDANGSB, RPANGSB, KDANGSC, ";
                sql += "RPANGSC, RPMAT, RPPLN, ";
                sql += "RPTAG, RPPRODUKSI, RPSUBSIDI, ";
                sql += "RPREDUKSI, RPINSENTIF, RPDISINSENTIF, ";
                sql += "RPBK1, RPBK2, RPBK3, ";
                sql += "RPTDLLAMA, RPTDLBARU, RPSELISIH, ";
                sql += "NOREK, NOAGENDA, FLAGSOPP, ";
                sql += "FLAGANJA, KDKIRIM, KDTERIMA, ";
                sql += "JNSMUT, ";
                sql += "BLTHMUT, KDMUT, TGLNYALA, ";
                sql += "NOGARDU, NOTIANG, NOMETER, ";
                sql += "DAYABULK, RPBP, RPUJL,";
                sql += "TGLKONSLD, KONSLDKE, UPDATEBY, ";
                sql += "UPDATETIME) ";
                sql += " VALUES (";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,?,?,?,?,?,?,?,?, ";
                sql += " ?,?,? ";
                sql += ") ";

                cst = con.prepareCall(sql);

                Integer indexParam = 0;
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                Date thisDate = new Date();

                cst.setString(indexParam++, rowData.get("BLTH"));
                cst.setString(indexParam++, rowData.get("IDPEL"));
                cst.setString(indexParam++, rowData.get("NOPEL"));
                cst.setString(indexParam++, rowData.get("KDGERAKMASUK"));
                //cst.setString(indexParam++, rowData.get("UPLOADTIME"));
                cst.setString(indexParam++, formatter.format(thisDate));
                cst.setString(indexParam++, rowData.get("UPLOADBY"));
                //cst.setString(indexParam++, rowData.get("KDGERAKKELUAR"));
                //cst.setString(indexParam++, rowData.get("TGLBAYAR"));
                //cst.setString(indexParam++, rowData.get("WKTBAYAR"));
                //cst.setString(indexParam++, rowData.get("KDPP"));

                //cst.setString(indexParam++, rowData.get("KDPEMBAYAR"));
                //cst.setString(indexParam++, rowData.get("KDKOREKSI"));
                //cst.setString(indexParam++, rowData.get("TO_CHAR(SYSDATE,'YYYYMMDD')"));
                cst.setString(indexParam++, rowData.get("STATUS"));
                cst.setString(indexParam++, rowData.get("KDPEMBPP"));
                cst.setString(indexParam++, rowData.get("KDPEMBAYARSIP3"));

                cst.setString(indexParam++, rowData.get("UNITUP"));
                cst.setString(indexParam++, rowData.get("PEMDA"));
                cst.setString(indexParam++, rowData.get("NAMA"));
                cst.setString(indexParam++, rowData.get("PNJ"));
                cst.setString(indexParam++, rowData.get("NAMAPNJ"));
                cst.setString(indexParam++, rowData.get("NOBANG"));
                cst.setString(indexParam++, rowData.get("KETNOBANG"));
                cst.setString(indexParam++, rowData.get("RT"));
                cst.setString(indexParam++, rowData.get("RW"));
                cst.setString(indexParam++, rowData.get("NODLMRT"));

                cst.setString(indexParam++, rowData.get("KETNODLMRT"));
                cst.setString(indexParam++, rowData.get("LINGKUNGAN"));
                cst.setString(indexParam++, rowData.get("KODEPOS"));
                cst.setString(indexParam++, rowData.get("IDTARIP"));
                cst.setString(indexParam++, rowData.get("TARIP"));
                cst.setString(indexParam++, rowData.get("KDPEMBTRF"));
                cst.setString(indexParam++, rowData.get("ABONMETER"));
                cst.setString(indexParam++, rowData.get("DAYA"));
                cst.setString(indexParam++, rowData.get("KDAYA"));
                cst.setString(indexParam++, rowData.get("KOGOL"));

                cst.setString(indexParam++, rowData.get("SUBKOGOL"));
                cst.setString(indexParam++, rowData.get("FRT"));
                cst.setString(indexParam++, rowData.get("FJN"));
                cst.setString(indexParam++, rowData.get("KDPPJ"));
                cst.setString(indexParam++, rowData.get("UNITKJ"));
                cst.setString(indexParam++, rowData.get("KDINKASO"));
                cst.setString(indexParam++, rowData.get("KDKELOMPOK"));
                cst.setString(indexParam++, rowData.get("TGLJTTEMPO"));
                cst.setString(indexParam++, rowData.get("KDDK"));
                cst.setString(indexParam++, rowData.get("TGLBACA"));

                cst.setString(indexParam++, rowData.get("SLALWBP"));
                cst.setString(indexParam++, rowData.get("SAHLWBP"));
                cst.setString(indexParam++, rowData.get("SLAWBP"));
                cst.setString(indexParam++, rowData.get("SAHWBP"));
                cst.setString(indexParam++, rowData.get("SLAKVARH"));
                cst.setString(indexParam++, rowData.get("SAHKVARH"));
                cst.setString(indexParam++, rowData.get("SKVAMAX"));
                cst.setString(indexParam++, rowData.get("FAKM"));
                cst.setString(indexParam++, rowData.get("FAKMKVARH"));
                cst.setString(indexParam++, rowData.get("FAKMKVAMAX"));

                cst.setString(indexParam++, rowData.get("KWHLWBP"));
                cst.setString(indexParam++, rowData.get("KWHWBP"));
                cst.setString(indexParam++, rowData.get("BLOK3"));
                cst.setString(indexParam++, rowData.get("PEMKWH"));
                cst.setString(indexParam++, rowData.get("KWHKVARH"));
                cst.setString(indexParam++, rowData.get("KELBKVARH"));
                cst.setString(indexParam++, rowData.get("RPLWBP"));
                cst.setString(indexParam++, rowData.get("RPWBP"));
                cst.setString(indexParam++, rowData.get("RPBLOK3"));
                cst.setString(indexParam++, rowData.get("RPKVARH"));

                cst.setString(indexParam++, rowData.get("RPBEBAN"));
                cst.setString(indexParam++, rowData.get("CTTLB"));
                cst.setString(indexParam++, rowData.get("RPTTLB"));
                cst.setString(indexParam++, rowData.get("RPPTL"));
                cst.setString(indexParam++, rowData.get("RPTB"));
                cst.setString(indexParam++, rowData.get("RPPPN"));
                cst.setString(indexParam++, rowData.get("RPBPJU"));
                cst.setString(indexParam++, rowData.get("RPTRAFO"));
                cst.setString(indexParam++, rowData.get("RPSEWATRAFO"));
                cst.setString(indexParam++, rowData.get("RPSEWAKAP"));

                cst.setString(indexParam++, rowData.get("KDANGSA"));
                cst.setString(indexParam++, rowData.get("RPANGSA"));
                cst.setString(indexParam++, rowData.get("KDANGSB"));
                cst.setString(indexParam++, rowData.get("RPANGSB"));
                cst.setString(indexParam++, rowData.get("KDANGSC"));
                cst.setString(indexParam++, rowData.get("RPANGSC"));
                cst.setString(indexParam++, rowData.get("RPMAT"));
                cst.setString(indexParam++, rowData.get("RPPLN"));
                cst.setString(indexParam++, rowData.get("RPTAG"));
                cst.setString(indexParam++, rowData.get("RPPRODUKSI"));

                cst.setString(indexParam++, rowData.get("RPSUBSIDI"));
                cst.setString(indexParam++, rowData.get("RPREDUKSI"));
                cst.setString(indexParam++, rowData.get("RPINSENTIF"));
                cst.setString(indexParam++, rowData.get("RPDISINSENTIF"));
                cst.setString(indexParam++, rowData.get("RPBK1"));
                cst.setString(indexParam++, rowData.get("RPBK2"));
                cst.setString(indexParam++, rowData.get("RPBK3"));
                cst.setString(indexParam++, rowData.get("RPTDLLAMA"));
                cst.setString(indexParam++, rowData.get("RPTDLBARU"));
                cst.setString(indexParam++, rowData.get("RPSELISIH"));

                cst.setString(indexParam++, rowData.get("NOREK"));
                cst.setString(indexParam++, rowData.get("NOAGENDA"));
                cst.setString(indexParam++, rowData.get("FLAGSOPP"));
                cst.setString(indexParam++, rowData.get("FLAGANJA"));
                cst.setString(indexParam++, rowData.get("KDKIRIM"));
                cst.setString(indexParam++, rowData.get("KDTERIMA"));
                cst.setString(indexParam++, rowData.get("JNSMUT"));
                cst.setString(indexParam++, rowData.get("BLTHMUT"));
                cst.setString(indexParam++, rowData.get("KDMUT"));
                cst.setString(indexParam++, rowData.get("TGLNYALA"));

                cst.setString(indexParam++, rowData.get("NOGARDU"));
                cst.setString(indexParam++, rowData.get("NOTIANG"));
                cst.setString(indexParam++, rowData.get("NOMETER"));
                cst.setString(indexParam++, rowData.get("DAYABULK"));
                cst.setString(indexParam++, rowData.get("RPBP"));
                cst.setString(indexParam++, rowData.get("RPUJL"));
                cst.setString(indexParam++, rowData.get("TGLKONSLD"));
                cst.setString(indexParam++, rowData.get("KONSLDKE"));
                cst.setString(indexParam++, tTransaksiBy);
                cst.setString(indexParam++, rowData.get("UPDATETIME"));

                cst.execute();
            }

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    //===================================================



    public Map<String, Object> INSERTTEMPSOREK_ORATOORA(String unitap,
                                                        String unitup,
                                                        String thbl,
                                                        String KDKELOMPOK,
                                                        String strglobalkodepetugas,
                                                        String tgljatuhtempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;

        String IdTarip = "", ttarip;
        Integer tdaya;

        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = "{ call emulsion.FILTER.SetUnitAP@billingjatim(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, unitap);
            cst.execute();

            sql = "{ call emulsion.FILTER.SetUNITUP@billingjatim(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, unitup);
            cst.execute();

            sql = "{ call emulsion.FILTER.SetBLTH@billingjatim(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, thbl);
            cst.execute();

            sql = "{ call emulsion.FILTER.SetKDSIKLIS@billingjatim(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, KDKELOMPOK);
            cst.execute();

            if (unitup.substring(0,2) == "13") {
                sql = "{ call PROC_InsertTempSOREK_SUMBAR(?,?,?,?,?,?,?,?) }";
            } else if (unitup.substring(0,2) == "51") {
                sql = "{ call PROC_InsertTempSOREK(?,?,?,?,?,?,?,?) }";
            } else {
                sql = "{ call PROC_InsertTempSOREK(?,?,?,?,?,?,?,?) }";
            }

            cst = con.prepareCall(sql);
            cst.setString(1, unitup);
            cst.setString(2, "R1");
            cst.setString(3, "L");
            cst.setString(4, "11");
            cst.setString(5, thbl);
            cst.setString(6, KDKELOMPOK);
            cst.setString(7, strglobalkodepetugas);
            cst.setString(8, tgljatuhtempo);
            cst.execute();


            sql = "select parhasil.getHasil AS HASIL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal Proses, " + lMapData.get(0).get(0).toString());
            }

            if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                retValue.put("wsByRefHasilInsert", lMapData.get(0).get(0).substring(0,2));
            } else {
                throw new Exception("Gagal Proses, " + lMapData.get(0).get(0).toString());
            }

            retValue.put("wsReturn", lMapData.get(0).get(0).substring(0,2));
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "0");
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefHasilInsert", "0");
        }

        return retValue;
    }

    public Map<String, Object> INSERTTEMPSOREKSUSULAN_ORATOORA(
                                                        String unitup,
                                                        String thbl,
                                                        String KDKELOMPOK,
                                                        String strglobalkodepetugas,
                                                        String tgljatuhtempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;

        String IdTarip = "", ttarip;
        Integer tdaya;

        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            if (unitup.substring(0,2) == "13") {
                sql = "{ call PROC_InsertTempSOREK_SUMBAR(?,?,?,?,?,?,?,?) }";
            }

            cst = con.prepareCall(sql);
            cst.setString(1, unitup);
            cst.setString(2, "R1");
            cst.setString(3, "L");
            cst.setString(4, "13");
            cst.setString(5, thbl);
            cst.setString(6, KDKELOMPOK);
            cst.setString(7, strglobalkodepetugas);
            cst.setString(8, tgljatuhtempo);
            cst.execute();


            sql = "select parhasil.getHasil AS HASIL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal Proses.");
            }

            if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                retValue.put("wsByRefHasilInsert", lMapData.get(0).get(0).substring(0,2));
            } else {
                throw new Exception("Gagal Proses, " + lMapData.get(0).get(0).toString());
            }

            retValue.put("wsReturn", lMapData.get(0).get(0).substring(0,2));
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "0");
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefHasilInsert", "0");
        }

        return retValue;
    }

    public Map<String, Object> SetData_13UPLOAD(
                                                String unitup,
                                                String thbl,
                                                String strglobalkodepetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK;

        String IdTarip = "", ttarip;
        Integer tdaya;

        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = "{ call PROC_13UPLOAD_SOREKDILDPP(?,?,?,?,?,?) }";

            cst = con.prepareCall(sql);
            cst.setString(1, unitup);
            cst.setString(2, "R1");
            cst.setString(3, "L");
            cst.setString(4, "13");
            cst.setString(5, thbl);
            cst.setString(6, strglobalkodepetugas);
            cst.execute();


            sql = "select parhasil.getGagal AS GAGAL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal Proses, " + lMapData.get(0).get(0));
            }

            String ASAS = "";
            ASAS = lMapData.get(0).get("GAGAL");
            retValue.put("wsByRefHasilGagal", ASAS);

            sql = "select parhasil.getHasil AS HASIL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal Proses, " + lMapData.get(0).get(0));
            }

            ASAS = lMapData.get(0).get("HASIL");

            retValue.put("wsReturn", ASAS);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> DeleteDPHOFFLINE(Map<String, String> dr,
                                                String tTRANSAKSIBY) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = " DELETE TEMPDPHOFFLINE ";
            sql = sql + "WHERE TRANSAKSIBY = '" + tTRANSAKSIBY + "'";

            cst = con.prepareCall(sql);
            cst.execute();

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> InsertTempDPHOFFLINE(Map<String, String> dr,
                                                String tTRANSAKSIBY) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = " INSERT INTO TEMPDPHOFFLINE ";
            sql = sql + " (IDPEL, BLTH, KDPP, TGLBAYAR,KDPEMBAYAR, RPTAG, KDGERAKKELUAR, RPBK1, KDPEMBPP, STATUS, UNITUP, CATATBY, WKTBAYAR, TGLTRANSAKSI, TRANSAKSIBY) ";
            sql = sql + " VALUES ";
            sql = sql + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            cst = con.prepareCall(sql);
            cst.setString(1, dr.get("IDPEL"));
            cst.setString(2, dr.get("BLTH"));
            cst.setString(3, dr.get("KDPP"));
            cst.setString(4, dr.get("TGLBAYAR"));
            cst.setString(5, dr.get("USERID"));
            cst.setString(6, dr.get("RPTAG"));
            cst.setString(7, "21");
            cst.setString(8, dr.get("RPBK"));
            cst.setString(9, dr.get("KDPEMBPP"));
            cst.setString(10, "L");
            cst.setString(11, dr.get("UNITUP"));
            cst.setString(12, dr.get("USERID"));
            cst.setString(13, dr.get("JAMBAYAR"));
            cst.setString(14, "sysdate"); //todo: parameter
            cst.setString(15, tTRANSAKSIBY);
            cst.execute();

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> ambilTanggaleksekusi() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = " SELECT TO_CHAR(SYSDATE,'yyyymmdd') as tanggal,TO_CHAR(SYSDATE,'hh24miss') as waktu FROM dual ";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Tanggal Server tidak didapatkan.");
            }

            retValue.put("wsReturn", lMapData.get(0).get("tanggal"));
            retValue.put("wsByRefError", "");
            retValue.put("wsByRefWaktu", lMapData.get(0).get("waktu"));

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn","");
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefWaktu", "");
        }

        return retValue;
    }



//    Function setzipperreceive(ByVal strData As String, ByVal strXMLschema As String) As DataSet
//    Try
//    Dim ds As New DataSet
//    Dim xRead As System.IO.StringReader
//    If strXMLschema.Trim <> "" Then
//    Dim strXMLOra1 As String = Zipper.zipper.DeCompress(strXMLschema)
//    xRead = Nothing
//            xRead = New IO.StringReader(strXMLOra1)
//            ds.ReadXmlSchema(xRead)
//    Else
//    Return Nothing
//    Exit Function
//    End If
//    If strData.Trim <> "" Then
//    Dim strXMLOra As String = Zipper.zipper.DeCompress(strData)
//    xRead = Nothing
//            xRead = New IO.StringReader(strXMLOra)
//            ds.ReadXml(xRead)
//    Else
//    Return Nothing
//    Exit Function
//    End If
//    Return ds
//    Catch ex As Exception
//    Return Nothing
//    Exit Function
//    End Try
//
//    End Function
//    Function setaddcoldtrans(ByVal ds As DataSet) As DataSet
//
//    Try
//    Dim objcolumn14 As DataColumn
//
//    If Not ds.Tables(0).Columns.Contains("TGLBAYAR") Then
//            objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.String")
//    objcolumn14.ColumnName = "TGLBAYAR"
//    objcolumn14.DefaultValue = ""
//            ds.Tables(0).Columns.Add(objcolumn14)
//    End If
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.String")
//    objcolumn14.ColumnName = "WKTBAYAR"
//    objcolumn14.DefaultValue = ""
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.String")
//    objcolumn14.ColumnName = "KDPP"
//    objcolumn14.DefaultValue = ""
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.String")
//    objcolumn14.ColumnName = "KDPEMBAYAR"
//    objcolumn14.DefaultValue = ""
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.String")
//    objcolumn14.ColumnName = "KDKIRIM"
//    objcolumn14.DefaultValue = ""
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.Decimal")
//    objcolumn14.ColumnName = "CETAK"
//    objcolumn14.DefaultValue = 0
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.Decimal")
//    objcolumn14.ColumnName = "BPAKAI1"
//    objcolumn14.DefaultValue = 0
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.Decimal")
//    objcolumn14.ColumnName = "BPAKAI2"
//    objcolumn14.DefaultValue = 0
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.Decimal")
//    objcolumn14.ColumnName = "BPAKAI3"
//    objcolumn14.DefaultValue = 0
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.Decimal")
//    objcolumn14.ColumnName = "BKVAR"
//    objcolumn14.DefaultValue = 0
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.String")
//    objcolumn14.ColumnName = "PERIODE"
//    objcolumn14.DefaultValue = ""
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.String")
//    objcolumn14.ColumnName = "TELPPENGADUAN"
//    objcolumn14.DefaultValue = ""
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.String")
//    objcolumn14.ColumnName = "PESAN"
//    objcolumn14.DefaultValue = ""
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.DateTime")
//    objcolumn14.ColumnName = "TGLCETAK"
//    objcolumn14.AllowDBNull = True
//    ds.Tables(0).Columns.Add(objcolumn14)
//
//            ds.AcceptChanges()
//    Return ds
//
//    Catch ex As Exception
//    Dim ess As String = ex.Message.ToString()
//    End Try
//    End Function
//
//    Function setaddcoldtrans4121(ByVal ds As DataSet) As DataSet
//
//    Try
//    Dim objcolumn14 As DataColumn
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.String")
//    objcolumn14.ColumnName = "TGKOREKSI"
//    objcolumn14.DefaultValue = ""
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//            'objcolumn14 = New DataColumn
//            'objcolumn14.DataType = System.Type.GetType("System.String")
//            'objcolumn14.ColumnName = "KDKOREKSI"
//            'objcolumn14.DefaultValue = ""
//            'ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.String")
//    objcolumn14.ColumnName = "koreksiby"
//    objcolumn14.DefaultValue = ""
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.Decimal")
//    objcolumn14.ColumnName = "CETAK"
//    objcolumn14.DefaultValue = 0
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.Decimal")
//    objcolumn14.ColumnName = "BPAKAI1"
//    objcolumn14.DefaultValue = 0
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.Decimal")
//    objcolumn14.ColumnName = "BPAKAI2"
//    objcolumn14.DefaultValue = 0
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.Decimal")
//    objcolumn14.ColumnName = "BPAKAI3"
//    objcolumn14.DefaultValue = 0
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.Decimal")
//    objcolumn14.ColumnName = "BKVAR"
//    objcolumn14.DefaultValue = 0
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.String")
//    objcolumn14.ColumnName = "PERIODE"
//    objcolumn14.DefaultValue = ""
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.String")
//    objcolumn14.ColumnName = "TELPPENGADUAN"
//    objcolumn14.DefaultValue = ""
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.String")
//    objcolumn14.ColumnName = "PESAN"
//    objcolumn14.DefaultValue = ""
//            ds.Tables(0).Columns.Add(objcolumn14)
//
//    objcolumn14 = New DataColumn
//    objcolumn14.DataType = System.Type.GetType("System.DateTime")
//    objcolumn14.ColumnName = "TGLCETAK"
//    objcolumn14.AllowDBNull = True
//    ds.Tables(0).Columns.Add(objcolumn14)
//
//            ds.AcceptChanges()
//    Return ds
//
//    Catch ex As Exception
//    Dim ess As String = ex.Message.ToString()
//    End Try
//    End Function



    public Map<String, Object> SetDataIdpel_R2cicilan(String tIDPel,
                                                        String tBlTh,
                                                        String tStatus,
                                                        List<Map<String, String>> dtrans,
                                                        String tTransaksiBy,
                                                        String tnorek,
                                                        String v_NOAGENDA,
                                                        Integer v_KALICICIL,
                                                        Integer v_rptag,
                                                        Integer v_rpbk) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas;
        tPetugas = tTransaksiBy;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = "DELETE TEMPcicilan WHERE UPLOADBY = '" + tTransaksiBy + "'";
            cst = con.prepareCall(sql);
            cst.execute();

            for (Map<String, String> rowData : dtrans) {
                if (rowData.get("HASIL") == "") {
                    //todo: InsertTempciciclan(i, dtrans, tTransaksiBy, Err, tnorek, v_NOAGENDA, tIDPel, tBlTh)

                    if (rowData == dtrans.get(dtrans.size() -1)) {
                        sql = "{ call PROC_R2_CICILAN(?,?,?,?,?,?) }";

                        cst = con.prepareCall(sql);
                        cst.setString(1, "R1");
                        cst.setString(2, tnorek);
                        cst.setString(3, tStatus);
                        cst.setString(4, tBlTh);
                        cst.setString(5, tTransaksiBy);
                        cst.setString(6, v_NOAGENDA);
                        cst.setString(6, tIDPel);
                        cst.setString(6, v_KALICICIL.toString());
                        cst.setString(6, v_rptag.toString());
                        cst.setString(6, v_rpbk.toString());
                        cst.execute();


                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal Proses. ");
                        }

                        for (Map<String, String> rowData2 : dtrans) {
                            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                                rowData2.put("HASIL", lMapData.get(0).get(0));
                            } else {
                                rowData2.put("HASIL", "0, " + lMapData.get(0).get(0));
                            }
                        }

                    }
                }
            }

            retValue.put("wsReturn", dtrans);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dtrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    public Map<String, Object> InsertTempciciclan(Integer I,
                                                  List<Map<String, String>> ds,
                                                  String tTransaksiBy,
                                                  String tnorek,
                                                  String v_NOAGENDA,
                                                  String v_IDPEL,
                                                  String v_BLTH) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            for(Map<String, String> rowData : ds) {
                sql = " insert into TEMPCICILAN ";
                sql = sql + " UPLOADBY,BLTH, IDPEL, NOPEL, KDGERAKMASUK,  KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI,  RPREDUKSI, RPINSENTIF, RPDISINSENTIF,   RPBK1, RPBK2, RPBK3,    RPTDLLAMA, RPTDLBARU, RPSELISIH,   NOREK, NOAGENDA, FLAGSOPP,    FLAGANJA, KDKIRIM, KDTERIMA) ";
                sql = sql + " SELECT ";
                sql = sql + " '" + tTransaksiBy + "', ";
                sql = sql + " BLTH, IDPEL, NOPEL, KDGERAKMASUK, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP,     KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK,, ";
                sql = sql + " '" + rowData.get("TGJATUHTEMPO") + "', ";
                sql = sql + " KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, ";
                sql = sql + " 0, 0, 0, 0, 0, 0, 0, ";
                sql = sql + " '" + rowData.get("RPPTL") + "', ";
                sql = sql + " '" + rowData.get("RPTB") + "', ";
                sql = sql + " '" + rowData.get("RPPPN") + "', ";
                sql = sql + " '" + rowData.get("RPBPJU") + "', ";
                sql = sql + " '" + rowData.get("RPTRAFO") + "', ";
                sql = sql + " '" + rowData.get("RPSEWATRAFO") + "', ";
                sql = sql + " '" + rowData.get("RPSEWAKAP") + "', ";
                sql = sql + " KDANGSA , ";
                sql = sql + " '" + rowData.get("RPANGSA") + "', ";
                sql = sql + " KDANGSB , ";
                sql = sql + " '" + rowData.get("RPANGSB") + "', ";
                sql = sql + " KDANGSC , ";
                sql = sql + " '" + rowData.get("RPANGSC") + "', ";
                sql = sql + " '" + rowData.get("RPMAT") + "', ";
                sql = sql + " 0, ";
                sql = sql + " '" + rowData.get("RPTAG") + "', ";
                sql = sql + " 0, 0, 0, 0, 0, ";
                sql = sql + " '" + rowData.get("RPBK1") + "', ";
                sql = sql + " '" + rowData.get("RPBK2") + "', ";
                sql = sql + " '" + rowData.get("RPBK3") + "', ";
                sql = sql + " 0, 0, 0, ";
                sql = sql + " '" + rowData.get("NOMOR") + "', ";
                sql = sql + " '" + v_NOAGENDA + "', ";
                sql = sql + " FLAGSOPP, FLAGANJA, NULL, NULL ";
                sql = sql + " FROM DPP partition(saldo) ";
                sql = sql + " where ";
                sql = sql + " kdgerakkeluar is null ";
                sql = sql + " and kdpembpp = 'R1' ";
                sql = sql + " and idpel = '" + v_IDPEL + "'";
                sql = sql + " and blth = '" + v_BLTH + "'";
                sql = sql + " and norek = '" + tnorek + "'";

                cst = con.prepareCall(sql);
                cst.execute();
            }

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }



    public Map<String, Object> SetDataIdpel_23TERIMAUNIT(List<Map<String,String>> dTrans,
                                                           String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek, tTglKirim;
        Integer tRPTAG, tRPBK;

        String tKDKIRIM = "", tKDTERIMA = "";

        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {

                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").substring(3,4) + rowData.get("BLTH").substring(0,2);
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK"));
                    tTglKirim = rowData.get("TGLBAYAR");
                    tKDKIRIM = "TERIMADARI";
                    tKDTERIMA = rowData.get("KDTERIMA");

                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "";

                        sql = "{ call Proc_23TERIMA_UNIT(?,?,?,?,?,?,?,?,?,?,?,?,?) }";

                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, "23");
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tRPTAG.toString());
                        cst.setString(10, tRPBK.toString());
                        cst.setString(11, tKDKIRIM);
                        cst.setString(12, tKDTERIMA);
                        cst.setString(13, tTglKirim);

                        cst.execute();


                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", status);
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + status);
                        }
                    }
                }
            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", Err);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }



    public Map<String, Object> SaveTemp_23TERIMAUNIT(List<Map<String, String>> dsFile,
                                                  String tUnitUpDari,
                                                  String tUnitUpUntuk,
                                                  String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = " delete tempterima where petugasterima = '" + tPetugas + "' ";
            cst = con.prepareCall(sql);
            cst.execute();

            for(Map<String, String> rowData : dsFile) {
                sql = "";
                sql = " INSERT INTO TEMPTERIMA (";
                sql = sql + "    PETUGASTERIMA, BLTH, IDPEL, ";
                sql = sql + "    NOPEL, KDGERAKMASUK, UPLOADTIME, ";
                sql = sql + "    UPLOADBY, KDGERAKKELUAR, TGLBAYAR, ";
                sql = sql + "    WKTBAYAR, KDPP, KDPEMBAYAR, ";
                sql = sql + "    KDKOREKSI, TGKOREKSI, STATUS, ";
                sql = sql + "    KDPEMBPP, KDPEMBAYARSIP3, UNITUP, ";
                sql = sql + "    PEMDA, NAMA, PNJ, ";
                sql = sql + "    NAMAPNJ, NOBANG, KETNOBANG, ";
                sql = sql + "    RT, RW, NODLMRT, ";
                sql = sql + "    KETNODLMRT, LINGKUNGAN, KODEPOS, ";
                sql = sql + "    IDTARIP, TARIP, KDPEMBTRF, ";
                sql = sql + "    ABONMETER, DAYA, KDAYA, ";
                sql = sql + "    KOGOL, SUBKOGOL, FRT, ";
                sql = sql + "    FJN, KDPPJ, UNITKJ, ";
                sql = sql + "    KDINKASO, KDKELOMPOK, TGLJTTEMPO, ";
                sql = sql + "    KDDK, TGLBACA, SLALWBP, ";
                sql = sql + "    SAHLWBP, SLAWBP, SAHWBP, ";
                sql = sql + "    SLAKVARH, SAHKVARH, SKVAMAX, ";
                sql = sql + "    FAKM, FAKMKVARH, FAKMKVAMAX, ";
                sql = sql + "    KWHLWBP, KWHWBP, BLOK3, ";
                sql = sql + "    PEMKWH, KWHKVARH, KELBKVARH, ";
                sql = sql + "    RPLWBP, RPWBP, RPBLOK3, ";
                sql = sql + "    RPKVARH, RPBEBAN, CTTLB, ";
                sql = sql + "    RPTTLB, RPPTL, RPTB, ";
                sql = sql + "    RPPPN, RPBPJU, RPTRAFO, ";
                sql = sql + "    RPSEWATRAFO, RPSEWAKAP, KDANGSA, ";
                sql = sql + "    RPANGSA, KDANGSB, RPANGSB, ";
                sql = sql + "    KDANGSC, RPANGSC, RPMAT, ";
                sql = sql + "    RPPLN, RPTAG, RPPRODUKSI, ";
                sql = sql + "    RPSUBSIDI, RPREDUKSI, RPINSENTIF, ";
                sql = sql + "    RPDISINSENTIF, RPBK1, RPBK2, ";
                sql = sql + "    RPBK3, RPTDLLAMA, RPTDLBARU, ";
                sql = sql + "    RPSELISIH, NOREK, NOAGENDA, ";
                sql = sql + "    FLAGSOPP, FLAGANJA, KDKIRIM, ";
                sql = sql + "    KDTERIMA, TGLBATALTRANS, TRANSAKSIIDBATAL, ";
                sql = sql + "    TGLTRANSAKSI, TRANSAKSIID, TGLKONSLD, ";
                sql = sql + "    KONSLDKE, UPDATEBY, UPDATETIME, ";
                sql = sql + "    TRANSAKSIBY, TRANSAKSIBATALBY) ";
                sql = sql + " VALUES ( ";
                sql += "'" + tPetugas + "', ";
                sql += "'" + rowData.get("BLTH") + "', ";
                sql += "'" + rowData.get("IDPEL") + "', ";
                sql += "'" + rowData.get("NOPEL") + "', ";
                sql += "'" + rowData.get("KDGERAKMASUK") + "', ";
                sql += "sysdate, ";  //UPLOADTIME;
                sql += "'" + rowData.get("UPLOADBY") + "', ";
                sql += "'" + rowData.get("KDGERAKKELUAR") + "', ";
                sql += "'" + rowData.get("TGLBAYAR") + "', ";
                sql += "'" + rowData.get("WKTBAYAR") + "', ";
                sql += "'" + rowData.get("KDPP") + "', ";
                sql += "'" + rowData.get("KDPEMBAYAR") + "', ";
                sql += "'" + rowData.get("KDKOREKSI") + "', ";
                sql += "'" + rowData.get("TGKOREKSI") + "', ";
                sql += "'" + rowData.get("STATUS") + "', ";
                sql += "'" + rowData.get("KDPEMBPP") + "', ";
                sql += "'" + rowData.get("KDPEMBAYARSIP3") + "', ";
                sql += "'" + rowData.get("UNITUP") + "', ";
                sql += "'" + rowData.get("PEMDA") + "', ";
                sql += "'" + rowData.get("NAMA") + "', ";
                sql += "'" + rowData.get("PNJ") + "', ";
                sql += "'" + rowData.get("NAMAPNJ") + "', ";
                sql += "'" + rowData.get("NOBANG") + "', ";
                sql += "'" + rowData.get("KETNOBANG") + "', ";
                sql += "'" + rowData.get("RT") + "', ";
                sql += "'" + rowData.get("RW") + "', ";
                sql += "'" + rowData.get("NODLMRT") + "', ";
                sql += "'" + rowData.get("KETNODLMRT") + "', ";
                sql += "'" + rowData.get("LINGKUNGAN") + "', ";
                sql += "'" + rowData.get("KODEPOS") + "', ";
                sql += "'" + rowData.get("IDTARIP") + "', ";
                sql += "'" + rowData.get("TARIP") + "', ";
                sql += "'" + rowData.get("KDPEMBTRF") + "', ";
                sql += "'" + rowData.get("ABONMETER") + "', ";
                sql += "'" + rowData.get("DAYA") + "', ";
                sql += "'" + rowData.get("KDAYA") + "', ";
                sql += "'" + rowData.get("KOGOL") + "', ";
                sql += "'" + rowData.get("SUBKOGOL") + "', ";
                sql += "'" + rowData.get("FRT") + "', ";
                sql += "'" + rowData.get("FJN") + "', ";
                sql += "'" + rowData.get("KDPPJ") + "', ";
                sql += "'" + rowData.get("UNITKJ") + "', ";
                sql += "'" + rowData.get("KDINKASO") + "', ";
                sql += "'" + rowData.get("KDKELOMPOK") + "', ";
                sql += "'" + rowData.get("TGLJTTEMPO") + "', ";
                sql += "'" + rowData.get("KDDK") + "', ";
                sql += "'" + rowData.get("TGLBACA") + "', ";
                sql += "'" + rowData.get("SLALWBP") + "', ";
                sql += "'" + rowData.get("SAHLWBP") + "', ";
                sql += "'" + rowData.get("SLAWBP") + "', ";
                sql += "'" + rowData.get("SAHWBP") + "', ";
                sql += "'" + rowData.get("SLAKVARH") + "', ";
                sql += "'" + rowData.get("SAHKVARH") + "', ";
                sql += "'" + rowData.get("SKVAMAX") + "', ";
                sql += "'" + rowData.get("FAKM") + "', ";
                sql += "'" + rowData.get("FAKMKVARH") + "', ";
                sql += "'" + rowData.get("FAKMKVAMAX") + "', ";
                sql += "'" + rowData.get("KWHLWBP") + "', ";
                sql += "'" + rowData.get("KWHWBP") + "', ";
                sql += "'" + rowData.get("BLOK3") + "', ";
                sql += "'" + rowData.get("PEMKWH") + "', ";
                sql += "'" + rowData.get("KWHKVARH") + "', ";
                sql += "'" + rowData.get("KELBKVARH") + "', ";
                sql += "'" + rowData.get("RPLWBP") + "', ";
                sql += "'" + rowData.get("RPWBP") + "', ";
                sql += "'" + rowData.get("RPBLOK3") + "', ";
                sql += "'" + rowData.get("RPKVARH") + "', ";
                sql += "'" + rowData.get("RPBEBAN") + "', ";
                sql += "'" + rowData.get("CTTLB") + "', ";
                sql += "'" + rowData.get("RPTTLB") + "', ";
                sql += "'" + rowData.get("RPPTL") + "', ";
                sql += "'" + rowData.get("RPTB") + "', ";
                sql += "'" + rowData.get("RPPPN") + "', " ;
                sql += "'" + rowData.get("RPBPJU") + "', ";
                sql += "'" + rowData.get("RPTRAFO") + "', ";
                sql += "'" + rowData.get("RPSEWATRAFO") + "', ";
                sql += "'" + rowData.get("RPSEWAKAP") + "', ";
                sql += "'" + rowData.get("KDANGSA") + "', ";
                sql += "'" + rowData.get("RPANGSA") + "', ";
                sql += "'" + rowData.get("KDANGSB") + "', ";
                sql += "'" + rowData.get("RPANGSB") + "', ";
                sql += "'" + rowData.get("KDANGSC") + "', ";
                sql += "'" + rowData.get("RPANGSC") + "', ";
                sql += "'" + rowData.get("RPMAT") + "', ";
                sql += "'" + rowData.get("RPPLN") + "', ";
                sql += "'" + rowData.get("RPTAG") + "', ";
                sql += "'" + rowData.get("RPPRODUKSI") + "', ";
                sql += "'" + rowData.get("RPSUBSIDI") + "', ";
                sql += "'" + rowData.get("RPREDUKSI") + "', ";
                sql += "'" + rowData.get("RPINSENTIF") + "', ";
                sql += "'" + rowData.get("RPDISINSENTIF") + "', ";
                sql += "'" + rowData.get("RPBK1") + "', ";
                sql += "'" + rowData.get("RPBK2") + "', ";
                sql += "'" + rowData.get("RPBK3") + "', ";
                sql += "'" + rowData.get("RPTDLLAMA") + "', ";
                sql += "'" + rowData.get("RPTDLBARU") + "', ";
                sql += "'" + rowData.get("RPSELISIH") + "', ";
                sql += "'" + rowData.get("NOREK") + "', ";
                sql += "'" + rowData.get("NOAGENDA") + "', ";
                sql += "'" + rowData.get("FLAGSOPP") + "', ";
                sql += "'" + rowData.get("FLAGANJA") + "', ";
                sql += "'" + rowData.get("KDKIRIM") + "', ";
                sql += "'" + rowData.get("KDTERIMA") + "', ";
                sql += "null, "; //TGLBATALTRANS;
                sql += "'" + rowData.get("TRANSAKSIIDBATAL") + "', ";
                sql += "to_date('" + rowData.get("TGLTRANSAKSI") + "','yyyyMMddhh24miss'), ";
                sql += "'" + rowData.get("TRANSAKSIID") + "', ";
                sql += "null, "; //TGLKONSLD;
                sql += "'" + rowData.get("KONSLDKE") + "', ";
                sql += "'" + rowData.get("UPDATEBY") + "', ";
                sql += "null, "; //UPDATETIME");
                sql += "'" + rowData.get("TRANSAKSIBY") + "', ";
                sql += "'" + rowData.get("TRANSAKSIBATALBY") + "' ";
                sql = sql + " )";

                cst = con.prepareCall(sql);
                cst.execute();

                sql = "select DISTINCT idpel from tempterima where unitup = '" + tUnitUpDari + "' and kdterima = '" + tUnitUpUntuk + "' and petugasterima = '" + tPetugas + "' ";
                cst = con.prepareCall(sql);
                rs = cst.executeQuery();
                lMapData = CommonModule.convertResultsetToListStr(rs);
            }

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

    public Map<String, Object> Server_Download_DPH_AJN(
                                                  String parUNITUP,
                                                  Date parTglMulai,
                                                  Date parTglSampai) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = "{ call PROC_21H2H_LUNAS(?,?,?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, parUNITUP);
            cst.setString(2, formatter.format(parTglMulai));
            cst.setString(3, formatter.format(parTglSampai));
            cst.execute();

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

    public Map<String, Object> SetImportUJL_File(List<Map<String, String>> dsPass) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            for (Map<String, String> rowData : dsPass) {
                sql = "INSERT /*+APPEND+*/ INTO TEMP_DIL_UJL(UNIT,IDPEL,NOBUKTI,TGLBUKTI,RPUJL,KETERANGAN,KDBATAL) ";
                sql += "VALUES('" + rowData.get("UNIT") + "','";
                sql += rowData.get("IDPEL") + "','";
                sql += rowData.get("NOBUKTI") + "',";
                sql += rowData.get("TGLBUKTI") + ",'";
                sql += rowData.get("RPUJL") + "','";
                sql += rowData.get("KETERANGAN") + "','";
                sql += rowData.get("KDBATAL") + "')";

                cst = con.prepareCall(sql);
                cst.execute();
            }

            for (Map<String, String> rowData : dsPass) {
                sql = "{ call PROC_INSERTUJLFILE(?,?) }";
                cst = con.prepareCall(sql);
                cst.registerOutParameter("v_idpel", OracleTypes.NVARCHAR);
                cst.registerOutParameter("v_Return", OracleTypes.NVARCHAR);
                try {
                    cst.execute();
                    rowData.put("HASIL", cst.getString("v_Return"));
                } catch (Exception ex) {
                    rowData.put("HASIL", ex.getMessage());
                }
            }

            retValue.put("wsReturn", dsPass);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SetImportUJL_Oracle() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        retValue.put("wsReturn", lMapData);

        return retValue;
    }

    public Map<String, Object> SetDataIdpel_21HapusGagalKolektif(List<Map<String,String>> dTrans,
                                                         String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK, tRPBK1, tRPBK2, tRPBK3;

        String tTglBayar, tKDPP, tKdPembayar;

        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("HASIL") == "") {

                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH");
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK1")) + Integer.parseInt(rowData.get("RPBK2")) + Integer.parseInt(rowData.get("RPBK3"));
                    tRPBK1 = Integer.parseInt(rowData.get("RPBK1"));
                    tRPBK2 = Integer.parseInt(rowData.get("RPBK2"));
                    tRPBK3 = Integer.parseInt(rowData.get("RPBK3"));
                    tTglBayar = rowData.get("TGLBAYAR");
                    tKDPP = rowData.get("KDPP");
                    tKdPembayar = "TDKDIPAKAI";

                    if (idpelErr == tIDPel) {
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "";

                        sql = "{ call PROC_21HAPUSGAGALUPLOAD(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";

                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, "21");
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tRPTAG.toString());
                        cst.setString(10, tRPBK.toString());
                        cst.setString(11, tTglBayar);
                        cst.setString(12, tKDPP);
                        cst.setString(13, tKdPembayar);
                        cst.setString(14, tRPBK1.toString());
                        cst.setString(15, tRPBK2.toString());
                        cst.setString(16, tRPBK3.toString());

                        cst.execute();


                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal proses.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", status);
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + status);
                        }
                    }
                }
            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", Err);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    //todo: function setRekap
    //todo: function fn_RekapTransaksi


    public Map<String, Object> setLap_502_404(String sUnitup,
                                              String sBlthLap,
                                              String sKodePetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Integer iFuncReturn;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;


            sql = "{ ? = call FUNC_BUAT502(?,?,?) }";
            cst = con.prepareCall(sql);
            cst.registerOutParameter("return", OracleTypes.BIGINT);
            cst.setString("V_BLTH", sBlthLap);
            cst.setString("v_PARUNIT", sUnitup);
            cst.setString("v_Transaksiby", sKodePetugas);
            cst.execute();

            iFuncReturn = cst.getInt("return");

            if (iFuncReturn == -1) {
                throw  new Exception("Terjadi kesalahan eksekusi func_502 !");
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

    public Map<String, Object> setLap_404(String sBlthLap,
                                          String sKodePetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Integer iFuncReturn;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;


            sql = "{ ? = call FUNC_BUAT404(?,?) }";
            cst = con.prepareCall(sql);
            cst.registerOutParameter("return", OracleTypes.BIGINT);
            cst.setString("V_BLTH", sBlthLap);
            cst.setString("v_PETUGAS", sKodePetugas);
            cst.execute();

            iFuncReturn = cst.getInt("return");

            if (iFuncReturn == -1) {
                throw  new Exception("Terjadi kesalahan eksekusi func_404 !");
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

    public Map<String, Object> setLap_404_New(String sBlthLap,
                                              String parUnit,
                                              String sKodePetugas,
                                              String v_tabeltrans) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Integer iFuncReturn;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;


            sql = "{ ? = call f$_404_buat404new(?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.registerOutParameter("return", OracleTypes.BIGINT);
            cst.setString("V_BLTH", sBlthLap);
            cst.setString("v_PETUGAS", sKodePetugas);
            cst.setString("v_UNITUP", parUnit);
            cst.setString("v_tabeltrans", v_tabeltrans);
            cst.execute();

            iFuncReturn = cst.getInt("return");

            if (iFuncReturn == -1) {
                throw  new Exception("Terjadi kesalahan eksekusi f$_404_buat404new !");
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

    public Map<String, Object> setLap_f_404_inserttemp(String sBlthLap,
                                              String parUnit,
                                              String sKodePetugas,
                                              String v_tabeltrans) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Integer iFuncReturn;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;


            sql = "{ ? = call f$_404_inserttemp(?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.registerOutParameter("return", OracleTypes.BIGINT);
            cst.setString("V_BLTH", sBlthLap);
            cst.setString("v_PETUGAS", sKodePetugas);
            cst.setString("v_UNITUP", parUnit);
            cst.setString("v_tabeltrans", v_tabeltrans);
            cst.execute();

            iFuncReturn = cst.getInt("return");

            if (iFuncReturn == -1) {
                throw  new Exception("Terjadi kesalahan eksekusi f$_404_inserttemp !");
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

    public Map<String, Object> setLap_f_404_insert404new(String sBlthLap,
                                              String parUnit,
                                              String sKodePetugas,
                                              String parSatuan) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Integer iFuncReturn;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;


            sql = "{ ? = call f$_404_insert404new(?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.registerOutParameter("return", OracleTypes.BIGINT);
            cst.setString("V_BLTH", sBlthLap);
            cst.setString("v_PETUGAS", sKodePetugas);
            cst.setString("v_UNITUP", parUnit);
            cst.setString("V_SATUAN", parSatuan);
            cst.execute();

            iFuncReturn = cst.getInt("return");

            if (iFuncReturn == -1) {
                throw  new Exception("Terjadi kesalahan eksekusi f$_404_insert404new !");
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

    public Map<String, Object> GetLogBkTerakhir() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "SELECT TO_CHAR(tglgenerator,'yyyymmdd') AS TGL FROM LOG_TERAKHIRCEKBK";
            cst = con.prepareCall(sql);
            cst.registerOutParameter("return", OracleTypes.BIGINT);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData.get(0).get("TGL"));
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> setDownloadDppNonrek(String unitup,
                                                         String sTglMulai,
                                                         String sTglSelesai) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;


            sql = "{ call Proc_Dpp_Nonrekjatelindo(?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.registerOutParameter("parError", OracleTypes.NVARCHAR);
            cst.setString("parUnitup", unitup);
            cst.setString("parTglMulai", sTglMulai);
            cst.setString("parTglSampai", sTglSelesai);
            cst.execute();

            Err = cst.getString("parError");

            if (!Err.trim().equals("")) {
                throw  new Exception(Err);
            }

            retValue.put("wsReturn", true);
            retValue.put("wsByRefError", Err);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> setDownloadDphNonrek(String unitup,
                                                         String sTglMulai,
                                                         String sTglSelesai) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;


            sql = "{ call Proc_Dph_Nonrekjatelindo(?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.registerOutParameter("parError", OracleTypes.NVARCHAR);
            cst.setString("parUnitup", unitup);
            cst.setString("parTglMulai", sTglMulai);
            cst.setString("parTglSampai", sTglSelesai);
            cst.execute();

            Err = cst.getString("parError");

            if (!Err.trim().equals("")) {
                throw  new Exception(Err);
            }

            retValue.put("wsReturn", true);
            retValue.put("wsByRefError", Err);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> setKirimDBPTemp(String pUNITUP,
                                               String pIDPEL,
                                               String pSTATUS_KIRIM,
                                               String pUSERID) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            if (pSTATUS_KIRIM == "B") {
                sql = "{ call PROC_DACEN_KIRIM_DBP_TEMP_DEP(?,?,?,?,?,?,?,?) }";
                cst = con.prepareCall(sql);
                cst.setString(1, "");
                cst.setString(2, pIDPEL);
                cst.setString(3, "");
                cst.setString(4, "");
                cst.setString(5, "");
                cst.setString(6, "");
                cst.setString(7, "B");
                cst.setInt(8, 0);
            } else {
                sql = "{ call PROC_DACEN_KIRIM_DBP_TEMP_DEP(?,?,?,?,?,?,?,?) }";
                cst = con.prepareCall(sql);
                cst.setString(1, "");
                cst.setString(2, pIDPEL);
                cst.setString(3, "");
                cst.setString(4, "");
                cst.setString(5, "");
                cst.setString(6, "");
                cst.setString(7, "A");
                cst.setInt(8, 0);
            }

            cst.execute();

            sql = "select parhasil.getHasil AS HASIL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (!lMapData.get(0).get(0).substring(0,1).equals("1")) {
                throw  new Exception(lMapData.get(0).get(0));
            }

            retValue.put("wsReturn", "TRUE");
            retValue.put("wsByRefError", lMapData.get(0).get(0));

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> getDBPRespon(String sIdpel,
                                               String sunitup,
                                               String sTglterima,
                                               String sStatus_terima) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String pesan = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            if (sStatus_terima == "B") {
                sql = "Select rc from V_GETRESPON_PRR where idpel='" + sIdpel + "'";
            } else {
                sql = "Select rc from V_GETRESPON_DKRP where idpel='" + sIdpel + "'";
            }

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Belum ada Respon.");
            }

            if (lMapData.get(0).get(0) == "00") {
                if (sStatus_terima == "A") {
                    sql = "select idpel from dkrpbaru where idpel='" + sIdpel + "' and tgkoreksi=to_char(sysdate,'yyyymmdd') and kdgerakmasuk='12'";
                } else if (sStatus_terima == "B") {
                    sql = "select idpel from dkrpbaru where idpel='" + sIdpel + "' and tgkoreksi=to_char(sysdate,'yyyymmdd') and kdgerakmasuk='12'";
                }

                cst = con.prepareCall(sql);
                rs = cst.executeQuery();
                lMapData = CommonModule.convertResultsetToListStr(rs);

                if (lMapData.size() > 0) {
                    pesan ="Transaksi sudah dieksekusi hari ini.";
                } else {
                    pesan ="Kode Respond diijinkan, silahkan lanjut";
                }
            } else if (lMapData.get(0).get(0) == "01") {
                pesan ="Data tidak ditemukan";
            } else if (lMapData.get(0).get(0) == "02") {
                pesan = "Sudah lunas (21,22,23)";
            } else if (lMapData.get(0).get(0) == "03") {
                pesan = "Sudah dibatalkan sebelumnya(31)";
            } else if (lMapData.get(0).get(0) == "04") {
                pesan = "Sudah PRR sebelumnya(41)";
            } else if (lMapData.get(0).get(0) == "05") {
                pesan = "Sudah diflag tusbung mandiri sebelumnya";
            } else if (lMapData.get(0).get(0) == "06") {
                pesan = "Lain-lain";
            } else if (lMapData.get(0).get(0) == "43") {
                pesan = "Pelanggan sudah dipending sebelumnya";
            } else if (lMapData.get(0).get(0) == "44") {
                pesan = "Pelanggan sudah diunpending sebelumnya";
            } else {
                pesan = "Belum ada Respon";
            }

            retValue.put("wsReturn", pesan);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }


    public Map<String, Object> sorektoDJBB(String unitap,
                                          String thbl) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String hasilGagal = "", hasilHasil = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call proc_dacen_kirim_sorekap(?,?) }";

            cst = con.prepareCall(sql);
            cst.setString(1, unitap);
            cst.setString(2, thbl);

            cst.execute();

            sql = "select parhasil.getGagal AS GAGAL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal Proses, ");
            }

            hasilGagal = lMapData.get(0).get("GAGAL");

            sql = "select parhasil.getHasil AS HASIL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal Proses, ");
            }

            hasilHasil = lMapData.get(0).get("HASIL");

            retValue.put("wsReturn", hasilHasil);
            retValue.put("wsByRefError", "");
            retValue.put("wsByRefHasilGagal", hasilGagal);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefHasilGagal", "");
        }

        return retValue;
    }

    public Map<String, Object> sorektoDJBB_UP(String unitup,
                                          String thbl) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String hasilGagal = "", hasilHasil = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call proc_dacen_kirim_sorek(?,?) }";

            cst = con.prepareCall(sql);
            cst.setString(1, unitup);
            cst.setString(2, "R1");
            cst.setString(3, "11");
            cst.setString(4, thbl);

            cst.execute();

            sql = "select parhasil.getGagal AS GAGAL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal Proses, ");
            }

            hasilGagal = lMapData.get(0).get("GAGAL");

            sql = "select parhasil.getHasil AS HASIL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal Proses, ");
            }

            hasilHasil = lMapData.get(0).get("HASIL");

            retValue.put("wsReturn", hasilHasil);
            retValue.put("wsByRefError", "");
            retValue.put("wsByRefHasilGagal", hasilGagal);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefHasilGagal", "");
        }

        return retValue;
    }



    public Map<String, Object> SetBatalStatusPending(String tKirim,
                                                     List<Map<String,String>> dTrans) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String tIdpel;
        String pesan = "";
        Integer j = 0;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true") {
                    tIdpel = rowData.get("IDPEL");

                    sql = "";

                    sql = "{ call proc_dacen_kirim_dbp_temp_dep(?,?,?,?,?,?,?,?) }";

                    cst = con.prepareCall(sql);
                    cst.setString(1, "");
                    cst.setString(2, tIdpel);
                    cst.setString(3, "");
                    cst.setString(4, "");
                    cst.setString(5, "");
                    cst.setString(6, "");
                    cst.setString(7, "D");
                    cst.setString(8, "");

                    cst.execute();

                    if (pesan == "") {
                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();
                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        if (lMapData.get(0).get(0) == "TRUE") {
                            pesan = "";
                        } else {
                            pesan = "Gagal Simpan Idpel : " + tIdpel + ", " + lMapData.get(0).get(0);
                        }
                    } else {
                        throw new Exception(pesan);
                    }
                }
            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", "");
            retValue.put("wsByRefLbrProses", j);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefLbrProses", j);
        }

        return retValue;
    }

//    Function setaddcoldtransBatalPending(ByVal ds As DataSet) As DataSet
//
//    Try
//    'Dim objcolumn14 As DataColumn
//            'objcolumn14 = New DataColumn
//            'objcolumn14.DataType = System.Type.GetType("System.String")
//            'objcolumn14.ColumnName = "IDPEL"
//            'objcolumn14.DefaultValue = ""
//            'ds.Tables(0).Columns.Add(objcolumn14)
//
//            ds.AcceptChanges()
//    Return ds
//
//    Catch ex As Exception
//    Dim ess As String = ex.Message.ToString()
//    End Try
//    End Function


    public Map<String, Object> INSERTTEMPSOREK_ORATOORATEST(String unitup,
                                                            String thbl,
                                                            String KDKELOMPOK,
                                                            String strglobalkodepetugas,
                                                            String tgljatuhtempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        String pesan = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = "{ call FILTER.SetUnitup(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, unitup);
            cst.execute();

            sql = "{ call FILTER.SetThbl(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, thbl);
            cst.execute();

            sql = "{ call FILTER.SetKodeKolektif(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, KDKELOMPOK);
            cst.execute();

            sql = "{ call PROC_INSERTTEMPSOREK_X(?,?,?,?,?,?,?,?) }";

            cst = con.prepareCall(sql);
            cst.setString(1, unitup);
            cst.setString(2, "R1");
            cst.setString(3, "L");
            cst.setString(4, "11");
            cst.setString(5, thbl);
            cst.setString(6, "A");
            cst.setString(7, strglobalkodepetugas);
            cst.setString(8, "20110220");

            cst.execute();


            sql = "select parhasil.getHasil AS HASIL FROM dual";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Gagal proses, ");
            }

            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                pesan = lMapData.get(0).get(0).substring(0,2);
            } else {
                throw new Exception("Gagal proses, " + lMapData.get(0).get(0));
            }

            retValue.put("wsReturn", pesan);
            retValue.put("wsByRefError", "");
            retValue.put("wsByRefHasilInsert", pesan);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", 0);
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefHasilInsert", 0);
        }

        return retValue;
    }



    public Map<String, Object> SetDataIdpel_21entriRestitusi(String tTransaksiBy,
                                                             String tTglBayar,
                                                             String tKDPEMBAYAR,
                                                             List<Map<String,String>> dTrans) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        Integer j = 0;
        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        Integer tRPTAG, tRPBK, tRPBK1, tRPBK2, tRPBK3;
        String Err = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            String tanggal = "", waktu = "";
            //todo: tanggal = ambilTanggaleksekusi(Err, waktu)

            for (Map<String, String> rowData : dTrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    tBlTh = rowData.get("BLTH").toString().substring(3, 4) + rowData.get("BLTH").toString().substring(0, 2);
                    tStatus = rowData.get("STATUS");
                    tNorek = rowData.get("NOREK");
                    tRPTAG = Integer.parseInt(rowData.get("RPTAG"));
                    tRPBK = Integer.parseInt(rowData.get("RPBK"));
                    tRPBK1 = Integer.parseInt(rowData.get("RPBK1"));
                    tRPBK2 = Integer.parseInt(rowData.get("RPBK2"));
                    tRPBK3 = Integer.parseInt(rowData.get("RPBK3"));

                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        sql = "{ call PROC_21ENTRI_LUNAS_RESTITUSI(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, "23");
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tRPTAG.toString());
                        cst.setString(10, tRPBK.toString());
                        cst.setString(11, "RESTITUSI");
                        cst.setString(12, tRPBK1.toString());
                        cst.setString(13, tRPBK2.toString());
                        cst.setString(14, tRPBK3.toString());
                        cst.setString(15, tanggal);
                        cst.setString(16, waktu);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() == 0) {
                            throw new Exception("Gagal ambil parhasil.");
                        }

                        String status = lMapData.get(0).get(0).toString();

                        if (Integer.parseInt(lMapData.get(0).get(0).substring(0,1)) == 1) {
                            rowData.put("HASIL", status);

                            j++;

                            sql = "SELECT TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKIRIM, CETAK, PERIODE, BPAKAI1, BPAKAI2, BPAKAI3, BKVAR, PESAN, TELPPENGADUAN, TGLCETAK";
                            sql = sql + " FROM VIEW_CETAKREKGNEW_21233132";
                            sql = sql + " where blth = '" + tBlTh + "'";
                            sql = sql + " and idpel = '" + tIDPel + "'";
                            sql = sql + " and kdpembpp = '" + tKdPembPP + "'";
                            sql = sql + " and norek = '" + tNorek + "'";

                            cst = con.prepareCall(sql);
                            rs = cst.executeQuery();
                            List<Map<String,String>> dsCetak = CommonModule.convertResultsetToListStr(rs);

                            if (dsCetak.size() == 0) {
                                throw new Exception("Gagal ambil dscetak.");
                            }

                            rowData.put("TGLBAYAR", dsCetak.get(0).get("TGLBAYAR"));
                            rowData.put("WKTBAYAR", dsCetak.get(0).get("WKTBAYAR"));
                            rowData.put("KDPP", dsCetak.get(0).get("KDPP"));
                            rowData.put("KDPEMBAYAR", dsCetak.get(0).get("KDPEMBAYAR"));
                            rowData.put("KDKIRIM", dsCetak.get(0).get("KDKIRIM"));
                            rowData.put("CETAK", dsCetak.get(0).get("CETAK"));
                            rowData.put("BPAKAI1", dsCetak.get(0).get("BPAKAI1"));
                            rowData.put("BPAKAI2", dsCetak.get(0).get("BPAKAI2"));
                            rowData.put("BPAKAI3", dsCetak.get(0).get("BPAKAI3"));
                            rowData.put("BKVAR", dsCetak.get(0).get("BKVAR"));
                            rowData.put("PERIODE", dsCetak.get(0).get("PERIODE"));
                            rowData.put("TELPPENGADUAN", dsCetak.get(0).get("TELPPENGADUAN"));
                            rowData.put("PESAN", dsCetak.get(0).get("PESAN"));
                            rowData.put("TGLCETAK", dsCetak.get(0).get("TGLCETAK"));
                        } else {
                            idpelErr = tIDPel;
                            rowData.put("HASIL", "0, " + lMapData.get(0).get(0).toString());
                        }
                    }
                }

            }

            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", "");
            retValue.put("wsByRefLbrProses", j);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", dTrans);
            retValue.put("wsByRefError", ex.getMessage());
            retValue.put("wsByRefLbrProses", 0);
        }

        return retValue;
    }

    public Map<String, Object> InsertKotama(String vIDSatker,
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
                                            String vNamaKotama,
                                            String vSETUJU3NAMA,
                                            String vSETUJU3KESATUAN,
                                            String vSETUJU3JABATAN,
                                            String vSETUJU3PANGKAT,
                                            String vSETUJU3NIP) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String vHasil, vIDKotama;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = " select NVL(max(to_number(substr(idkotama,2,length(idkotama)-1),9999999))+1,0) as makskotama from satkerkotama ";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            vIDKotama = "K" + lMapData.get(0).get(0);

            sql = " INSERT INTO SATKERKOTAMA ( ";
            sql += " IDSATKER, UNITAP, SETUJU1NAMA,  ";
            sql += " SETUJU1KESATUAN, SETUJU1JABATAN, SETUJU1PANGKAT,  ";
            sql += " SETUJU1NIP, SETUJU2NAMA, SETUJU2JABATAN, ";
            sql += " SETUJU2UNIT, SETUJU2KOTA, IDKOTAMA,  ";
            sql += " KOTAMA,SETUJU3NAMA,SETUJU3KESATUAN,SETUJU3JABATAN,SETUJU3PANGKAT,SETUJU3NIP) ";
            sql += " VALUES (";
            sql += " ?, ?, ?,  ";
            sql += " ?, ?, ?,  ";
            sql += " ?, ?, ?, ";
            sql += " ?, ?, ?,  ";
            sql += " ?, ?, ?, ?, ?, ? ";
            sql += " )";

            cst = con.prepareCall(sql);
            cst.setString(1, vIDSatker);
            cst.setString(2, vUnitap);
            cst.setString(3, vSetuju1Nama);
            cst.setString(4, vSetuju1Kesatuan);
            cst.setString(5, vSetuju1Jabatan);
            cst.setString(6, vSetuju1Pangkat);
            cst.setString(7, vSetuju1NIP);
            cst.setString(8, vSetuju2Nama);
            cst.setString(9, vSetuju2Jabatan);
            cst.setString(10, vSetuju2Unit);
            cst.setString(11, vSetuju2Kota);
            cst.setString(12, vIDKotama);
            cst.setString(13, vNamaKotama);
            cst.setString(14, vSETUJU3NAMA);
            cst.setString(15, vSETUJU3KESATUAN);
            cst.setString(16, vSETUJU3JABATAN);
            cst.setString(17, vSETUJU3PANGKAT);
            cst.setString(18, vSETUJU3NIP);

            cst.execute();

            retValue.put("wsReturn", "SUKSES");
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

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

        String vHasil, vIDKotama;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = " UPDATE SATKERKOTAMA ";
            sql += " SET    ";
            sql += "   SETUJU1NAMA     = ?, ";
            sql += "   SETUJU1KESATUAN = ?, ";
            sql += "   SETUJU1JABATAN  = ?, ";
            sql += "   SETUJU1PANGKAT  = ?, ";
            sql += "   SETUJU1NIP      = ?, ";
            sql += "   SETUJU2NAMA     = ?, ";
            sql += "   SETUJU2JABATAN  = ?, ";
            sql += "   SETUJU2UNIT     = ?, ";
            sql += "   SETUJU2KOTA     = ?, ";
            sql += "   IDSATKER        = ?, ";
            sql += "   KOTAMA          = ?, ";
            sql += "   SETUJU3NAMA     = ?, ";
            sql += "   SETUJU3KESATUAN = ?, ";
            sql += "   SETUJU3JABATAN  = ?, ";
            sql += "   SETUJU3PANGKAT  = ?, ";
            sql += "   SETUJU3NIP      = ? ";
            sql += " WHERE IDKOTAMA    = ? ";
            sql += "   AND UNITAP      = ? ";

            cst = con.prepareCall(sql);
            cst.setString(1, vSetuju1Nama);
            cst.setString(2, vSetuju1Kesatuan);
            cst.setString(3, vSetuju1Jabatan);
            cst.setString(4, vSetuju1Pangkat);
            cst.setString(5, vSetuju1NIP);
            cst.setString(6, vSetuju2Nama);
            cst.setString(7, vSetuju2Jabatan);
            cst.setString(8, vSetuju2Unit);
            cst.setString(9, vSetuju2Kota);
            cst.setString(10, vIDSatker);
            cst.setString(11, vNamaKotama);
            cst.setString(12, vSETUJU3NAMA);
            cst.setString(13, vSETUJU3KESATUAN);
            cst.setString(14, vSETUJU3JABATAN);
            cst.setString(15, vSETUJU3PANGKAT);
            cst.setString(16, vSETUJU3NIP);
            cst.setString(17, vIdKotama);
            cst.setString(18, vUnitap);

            cst.execute();

            retValue.put("wsReturn", "SUKSES");
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

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
            ResultSet rs;
            CallableStatement cst;
            String sql = "";

            sql = "select noform from SATKERKOLEKTIF where noform='" + vNoForm + "' ";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() == 0) {
                throw new Exception("Data Satker Tidak Ada");
            }

            sql = " UPDATE SATKERKOLEKTIF SET KESATUAN = ?, KODESATKER = ?, ";
            sql += " ALAMAT = ?, NOSURAT=?,";
            sql += " SETUJU1NAMA     = ?,SETUJU1KESATUAN = ?,SETUJU1JABATAN  = ?, ";
            sql += " SETUJU1PANGKAT  = ?,SETUJU1NIP = ?,SETUJU2NAMA     = ?,  ";
            sql += " SETUJU2KESATUAN = ?,SETUJU2JABATAN = ?,SETUJU2PANGKAT  = ?,  ";
            sql += " SETUJU2NIP      = ?,SETUJU3NAMA = ?,SETUJU3JABATAN  = ?, ";
            sql += " SETUJU3UNIT = ?,SETUJU3KOTA=?  ";
            sql += "  WHERE  NOFORM   = ?  AND IDKOTAMA= ? ";

            cst = con.prepareCall(sql);
            cst.setString(1, vKesatuan);
            cst.setString(2, vKodeSatker);
            cst.setString(3, vAlamat);
            cst.setString(4, vNoSurat);
            cst.setString(5, vSetuju1Nama);
            cst.setString(6, vSetuju1Kesatuan);
            cst.setString(7, vSetuju1Jabatan);
            cst.setString(8, vSetuju1Pangkat);
            cst.setString(9, vSetuju1NIP);
            cst.setString(10, vSetuju2Nama);
            cst.setString(11, vSetuju2Kesatuan);
            cst.setString(12, vSetuju2Jabatan);
            cst.setString(13, vSetuju2Pangkat);
            cst.setString(14, vSetuju2NIP);
            cst.setString(15, vSetuju3Nama);
            cst.setString(16, vSetuju3Jabatan);
            cst.setString(17, vSetuju3Unit);
            cst.setString(18, vSetuju3Kota);
            cst.setString(19, vNoForm);
            cst.setString(20, vIDKotama);

            cst.execute();

            retValue.put("wsReturn", "SUKSES");
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }



    public Map<String, Object> InsertSatker(String vIDSatker,
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
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = " select * from SATKERKOLEKTIF where noform='" + vNoForm + "' ";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() > 0) {
                throw new Exception("USED");
            }

            sql = " INSERT INTO SATKERKOLEKTIF (NOFORM, KESATUAN,KODESATKER, ALAMAT, UNITAP,IDSATKER, NOSURAT, SETUJU1NAMA,  ";
            sql += "  SETUJU1KESATUAN, SETUJU1JABATAN, SETUJU1PANGKAT,SETUJU1NIP, SETUJU2NAMA, SETUJU2KESATUAN,SETUJU2JABATAN, SETUJU2PANGKAT, SETUJU2NIP, SETUJU3NAMA, SETUJU3JABATAN, SETUJU3UNIT,SETUJU3KOTA,IDKOTAMA) ";
            sql += " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            cst = con.prepareCall(sql);
            cst.setString(1, vNoForm);
            cst.setString(2, vKesatuan);
            cst.setString(3, vKodeSatker);
            cst.setString(4, vAlamat);
            cst.setString(5, vUnitap);
            cst.setString(6, vNoSurat);
            cst.setString(7, vSetuju1Nama);
            cst.setString(8, vSetuju1Kesatuan);
            cst.setString(9, vSetuju1Jabatan);
            cst.setString(10, vSetuju1Pangkat);
            cst.setString(11, vSetuju1NIP);
            cst.setString(12, vSetuju2Nama);
            cst.setString(13, vSetuju2Kesatuan);
            cst.setString(14, vSetuju2Jabatan);
            cst.setString(15, vSetuju2Pangkat);
            cst.setString(16, vSetuju2NIP);
            cst.setString(17, vSetuju3Nama);
            cst.setString(18, vSetuju3Jabatan);
            cst.setString(19, vSetuju3Unit);
            cst.setString(20, vSetuju3Kota);
            cst.setString(21, vIDKotama);

            cst.execute();

            retValue.put("wsReturn", "SUKSES");
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "GAGAL");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> HapusAnggotaSatker(String vNoForm,
                                                  String vIDPel) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = " select * from satkeranggota where noform='" + vNoForm + "' and idpel='" + vIDPel + "' ";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() > 0) {
                throw new Exception("Idpel " + vIDPel + " tidak ditemukan!");
            }

            sql = " delete satkeranggota where noform= ? and idpel= ? ";

            cst = con.prepareCall(sql);
            cst.setString(1, vNoForm);
            cst.setString(2, vIDPel);

            cst.execute();

            retValue.put("wsReturn", "SUKSES");
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "GAGAL");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> TambahAnggotaSatker(String vUnitap,
                                                   String vIDPel,
                                                   String vNoForm) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String vHasil="";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = " select B.KESATUAN AS KESATUAN from satkeranggota A, SATKERKOLEKTIF B where A.NOFORM=B.NOFORM AND a.idpel= '" + vIDPel + "' ";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() > 0) {
                vHasil = lMapData.get(0).get("KESATUAN");
            } else {
                sql = " SELECT * FROM DIL where idpel='" + vIDPel + "' and unitup in (select unitup from unitup where unitap='" + vUnitap + "') and kogol = '1'";
                cst = con.prepareCall(sql);
                rs = cst.executeQuery();
                lMapData = CommonModule.convertResultsetToListStr(rs);

                if (lMapData.size() > 0) {
                    sql = " INSERT INTO SATKERANGGOTA (";
                    sql += " NOFORM, IDPEL, UNITAP) ";
                    sql += " VALUES ( '" + vNoForm + "','" + vIDPel + "' ,'" + vUnitap + "' ) ";
                    cst = con.prepareCall(sql);
                    cst.execute();

                    vHasil = "SUKSES";
                } else {
                    vHasil = "DIL";
                }
            }

            retValue.put("wsReturn", vHasil);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "GAGAL");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> SahSatker(String vNoForm,
                                         String vBlth,
                                         String SahBy) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String vHasil="";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = " SELECT COUNT(IDPEL) AS CEK FROM SATKERANGGOTA WHERE NOFORM='" + vNoForm + "' ";
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (!lMapData.get(0).get(0).equals("0")) {
                sql = " INSERT INTO SATKERSAH SELECT NOFORM,IDPEL,'" + vBlth + "' BLTH,'" + SahBy + "' SAHBY,SYSDATE AS TGLSAH FROM SATKERANGGOTA WHERE NOFORM='" + vNoForm + "' ";
                cst = con.prepareCall(sql);
                cst.execute();

                vHasil = "SUKSES";
            } else {
                vHasil = "KOSONG";
            }

            retValue.put("wsReturn", vHasil);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "GAGAL");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

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
                                                         String in_LogID,
                                                         String ErrMsg) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String vHasil="";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = " DELETE LOG_DKRP_BONGKAR ";
            sql = " WHERE TRANSAKSIBY = '" + in_petugas + "' AND IDPEL = '" + in_idpel + "'";
            sql = " AND NO_60 = '" + in_no60 + "'";
            cst = con.prepareCall(sql);
            cst.execute();


            sql = "";
            sql = "INSERT INTO LOG_DKRP_BONGKAR";
            sql += " (UNITUP, IDPEL, ";
            sql += " BLTH, LWBP_BONGKAR, WBP_BONGKAR, KVARH_BONGKAR, NO_TUL603, TGL_TUL603,";
            sql += " TGLTRANSAKSI, TRANSAKSIBY, DESC_EXEC, NO_60, LOG_ID) ";
            sql += " VALUES ";
            sql += " (?, ?, ";
            sql += " ?, ?, ?, ?, ?, ?,";
            sql += " ?, ?, ?, ?, ?) ";

            cst = con.prepareCall(sql);
            cst.setString(1, in_unitup);
            cst.setString(2, in_idpel);
            cst.setString(3, in_blth);
            cst.setString(4, in_lwbp_bongkar);
            cst.setString(5, in_wbp_bongkar);
            cst.setString(6, in_kvarh_bongkar);
            cst.setString(7, in_notul603);
            cst.setString(8, in_tgltul603);
            cst.setString(9, "SYSDATE"); //todo: sysdate
            cst.setString(10, in_petugas);
            cst.setString(11, ErrMsg);
            cst.setString(12, in_no60);
            cst.setString(13, in_LogID);

            cst.execute();

            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> Create_LogId(String in_unitup) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String vHasil="";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            sql = " SELECT TO_CHAR(SYSDATE, 'yyyyMMdd') || '/' || '" + in_unitup + "' || '/' || seq_autonumber.nextval";
            sql = " FROM DUAL";
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
}
