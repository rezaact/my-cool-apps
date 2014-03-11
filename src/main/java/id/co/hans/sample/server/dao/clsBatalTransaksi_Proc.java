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
public class clsBatalTransaksi_Proc {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> SetDataIdpel_11(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String Alasan,
                                               String tglTransaksi) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        String tAlasan, tTgUpload, tTransID;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dtrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    //kdgerakK = null
                    tBlTh = rowData.get("BLTH").substring(3, 4) + rowData.get("BLTH").substring(0, 2);
                    tStatus = rowData.get("STATUS");

                    tNorek = rowData.get("NOREK");
                    tAlasan = Alasan;
                    tTgUpload = tglTransaksi;
                    tTransID = rowData.get("TRANSAKSIID");

                    sql = "{ call PROC_BATAL11_SOREKDILDKRP(?,?,?,?,?,?,?,?,?,?,?) }";

                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, null);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tAlasan);
                        cst.setString(10, tTgUpload);
                        cst.setString(11, tTransID);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() > 0) {
                            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                                rowData.remove("HASIL");
                                rowData.put("HASIL", lMapData.get(0).get(0));
                            } else {
                                idpelErr = tIDPel;
                                rowData.remove("HASIL");
                                rowData.put("HASIL", "0, " + lMapData.get(0).get(0));
                            }
                        } else {
                            throw new Exception("Gagal Proses.");
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

    public Map<String, Object> SetDataIdpel_12ABCG(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String Alasan,
                                               String tglTransaksi,
                                               Boolean bJathelindo) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        if (null == bJathelindo) {
            bJathelindo = false;
        }

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek;
        String tKdkoreksi;
        String tAlasan, tTgkoreksi, tTransID;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dtrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    //kdgerakK = null
                    tBlTh = rowData.get("BLTH").substring(3, 4) + rowData.get("BLTH").substring(0, 2);
                    tStatus = rowData.get("STATUS");
                    tKdkoreksi = rowData.get("KDKOREKSI");
                    tNorek = rowData.get("NOREK");
                    tAlasan = Alasan;
                    tTgkoreksi = tglTransaksi;
                    tTransID = rowData.get("TRANSAKSIID");


                    //If tIDPel.Substring(0, 2) = "52" Then
                    //    If Not bJathelindo Then
                    //        mSql = "PROC_BATAL12ABCG_KOREKSI('" & tTransaksiBy & "','" & tIDPel & "','" & tKdPembPP & "','" & tKdGerakM & "',null,'" & tBlTh & "','" & tStatus & "','" & tNorek & "','" & tKdkoreksi & "','" & tAlasan & "','" & tTgkoreksi & "','" & tTransID & "')"
                    //    Else
                    //        mSql = "Proc_Batal12ABCG_KOREKSIJATEL('" & tTransaksiBy & "','" & tIDPel & "','" & tKdPembPP & "','" & tKdGerakM & "',null,'" & tBlTh & "','" & tStatus & "','" & tNorek & "','" & tKdkoreksi & "','" & tAlasan & "','" & tTgkoreksi & "','" & tTransID & "')"
                    //    End If
                    //Else
                    //    mSql = "PROC_BATAL12ABCG_KOREKSI('" & tTransaksiBy & "','" & tIDPel & "','" & tKdPembPP & "','" & tKdGerakM & "',null,'" & tBlTh & "','" & tStatus & "','" & tNorek & "','" & tKdkoreksi & "','" & tAlasan & "','" & tTgkoreksi & "','" & tTransID & "')"
                    //End If

                    if (!bJathelindo) {
                        sql = "{ call PROC_BATAL12ABCG_KOREKSI(?,?,?,?,?,?,?,?,?,?,?,?) }";
                    } else {
                        sql = "{ call Proc_Batal12ABCG_KOREKSIJATEL(?,?,?,?,?,?,?,?,?,?,?,?) }";
                    }


                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, null);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tKdkoreksi);
                        cst.setString(10, tAlasan);
                        cst.setString(11, tTgkoreksi);
                        cst.setString(12, tTransID);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() > 0) {
                            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                                rowData.remove("HASIL");
                                rowData.put("HASIL", lMapData.get(0).get(0));
                            } else {
                                idpelErr = tIDPel;
                                rowData.remove("HASIL");
                                rowData.put("HASIL", "0, " + lMapData.get(0).get(0));
                            }
                        } else {
                            throw new Exception("Gagal Proses.");
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

    public Map<String, Object> SetDataIdpelBatal_12DSuplisi(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String Alasan,
                                               String tglTransaksi) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek, kdgerakK;
        String tKdkoreksi;
        String tAlasan, tTgkoreksi, tTransID;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dtrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    kdgerakK = rowData.get("KDGERAKKELUAR");
                    tBlTh = rowData.get("BLTH").substring(3, 4) + rowData.get("BLTH").substring(0, 2);
                    tStatus = rowData.get("STATUS");
                    tKdkoreksi = rowData.get("KDKOREKSI");
                    tNorek = rowData.get("NOREK");
                    tAlasan = Alasan;
                    tTgkoreksi = tglTransaksi;
                    tTransID = rowData.get("TRANSAKSIID");

                    sql = "{ call Proc_Batal12d_Suplisi(?,?,?,?,?,?,?,?,?,?,?,?) }";

                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, kdgerakK);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tKdkoreksi);
                        cst.setString(10, tAlasan);
                        cst.setString(11, tTgkoreksi);
                        cst.setString(12, tTransID);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() > 0) {
                            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                                rowData.remove("HASIL");
                                rowData.put("HASIL", lMapData.get(0).get(0));
                            } else {
                                idpelErr = tIDPel;
                                rowData.remove("HASIL");
                                rowData.put("HASIL", "0, " + lMapData.get(0).get(0));
                            }
                        } else {
                            throw new Exception("Gagal Proses.");
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

    public Map<String, Object> SetDataIdpelBatal_12DRestitusi(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String Alasan,
                                               String tglTransaksi) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek, kdgerakK;
        String tKdkoreksi;
        String tAlasan, tTgkoreksi, tTransID;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dtrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    kdgerakK = rowData.get("KDGERAKKELUAR");
                    tBlTh = rowData.get("BLTH").substring(3, 4) + rowData.get("BLTH").substring(0, 2);
                    tStatus = rowData.get("STATUS");
                    tKdkoreksi = rowData.get("KDKOREKSI");
                    tNorek = rowData.get("NOREK");
                    tAlasan = Alasan;
                    tTgkoreksi = tglTransaksi;
                    tTransID = rowData.get("TRANSAKSIID");

                    sql = "{ call Proc_Batal12d_Restitusi(?,?,?,?,?,?,?,?,?,?,?,?) }";

                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, kdgerakK);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tKdkoreksi);
                        cst.setString(10, tAlasan);
                        cst.setString(11, tTgkoreksi);
                        cst.setString(12, tTransID);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() > 0) {
                            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                                rowData.remove("HASIL");
                                rowData.put("HASIL", lMapData.get(0).get(0));
                            } else {
                                idpelErr = tIDPel;
                                rowData.remove("HASIL");
                                rowData.put("HASIL", "0, " + lMapData.get(0).get(0));
                            }
                        } else {
                            throw new Exception("Gagal Proses.");
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

    public Map<String, Object> SetDataIdpel_13(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String Alasan,
                                               String tglTransaksi) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek, kdgerakK;
        String tKdkoreksi;
        String tAlasan, tTgUpload, tTransID;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dtrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    //kdgerakK = rowData.get("KDGERAKKELUAR");
                    tBlTh = rowData.get("BLTH").substring(3, 4) + rowData.get("BLTH").substring(0, 2);
                    tStatus = rowData.get("STATUS");
                    tKdkoreksi = rowData.get("KDKOREKSI");
                    tNorek = rowData.get("NOREK");
                    tAlasan = Alasan;
                    tTgUpload = tglTransaksi;
                    tTransID = rowData.get("TRANSAKSIID");

                    sql = "{ call PROC_BATAL13_SOREKDILDPP(?,?,?,?,?,?,?,?,?,?,?,?) }";

                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, null);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tKdkoreksi);
                        cst.setString(10, tAlasan);
                        cst.setString(11, tTgUpload);
                        cst.setString(12, tTransID);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() > 0) {
                            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                                rowData.remove("HASIL");
                                rowData.put("HASIL", lMapData.get(0).get(0));
                            } else {
                                idpelErr = tIDPel;
                                rowData.remove("HASIL");
                                rowData.put("HASIL", "0, " + lMapData.get(0).get(0));
                            }
                        } else {
                            throw new Exception("Gagal Proses.");
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

    public Map<String, Object> SetDataIdpel_21(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String Alasan,
                                               String tglTransaksi) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakk, tBlTh, tStatus, tNorek;
        String tTGLBAYAR, tKDPP, tKDPEMBAYAR;
        String tAlasan, tTransID;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dtrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    //tKdGerakM = rowData.get("KDGERAKMASUK");
                    tKdGerakk = rowData.get("KDGERAKKELUAR");
                    tBlTh = rowData.get("BLTH").substring(3, 4) + rowData.get("BLTH").substring(0, 2);
                    tStatus = rowData.get("STATUS");

                    tNorek = rowData.get("NOREK");
                    tTGLBAYAR = tglTransaksi;
                    tKDPP = rowData.get("KDPP");
                    tKDPEMBAYAR = rowData.get("KDPEMBAYAR");

                    tAlasan = Alasan;
                    tTransID = rowData.get("TRANSAKSIID");

                    sql = "{ call PROC_BATAL21_LUNAS(?,?,?,?,?,?,?,?,?,?,?,?) }";

                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakk);
                        cst.setString(5, tBlTh);
                        cst.setString(6, tStatus);
                        cst.setString(7, tNorek);
                        cst.setString(8, tTGLBAYAR);
                        cst.setString(9, tKDPP);
                        cst.setString(10, tKDPEMBAYAR);
                        cst.setString(11, tAlasan);
                        cst.setString(12, tTransID);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() > 0) {
                            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                                rowData.remove("HASIL");
                                rowData.put("HASIL", lMapData.get(0).get(0));
                            } else {
                                idpelErr = tIDPel;
                                rowData.remove("HASIL");
                                rowData.put("HASIL", "0, " + lMapData.get(0).get(0));
                            }
                        } else {
                            throw new Exception("Gagal Proses.");
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

    public Map<String, Object> SetDataIdpel_21Suplisi(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String Alasan,
                                               String tglTransaksi) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakk, tBlTh, tStatus, tNorek;
        String tTGLBAYAR, tKDPP, tKDPEMBAYAR;
        String tAlasan, tTransID;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dtrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    //tKdGerakM = rowData.get("KDGERAKMASUK");
                    tKdGerakk = rowData.get("KDGERAKKELUAR");
                    tBlTh = rowData.get("BLTH").substring(3, 4) + rowData.get("BLTH").substring(0, 2);
                    tStatus = rowData.get("STATUS");

                    tNorek = rowData.get("NOREK");
                    tTGLBAYAR = tglTransaksi;
                    tKDPP = rowData.get("KDPP");
                    tKDPEMBAYAR = rowData.get("KDPEMBAYAR");

                    tAlasan = Alasan;
                    tTransID = rowData.get("TRANSAKSIID");

                    sql = "{ call PROC_BATAL21_SUPLISI(?,?,?,?,?,?,?,?,?,?,?,?) }";

                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakk);
                        cst.setString(5, tBlTh);
                        cst.setString(6, tStatus);
                        cst.setString(7, tNorek);
                        cst.setString(8, tTGLBAYAR);
                        cst.setString(9, tKDPP);
                        cst.setString(10, tKDPEMBAYAR);
                        cst.setString(11, tAlasan);
                        cst.setString(12, tTransID);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() > 0) {
                            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                                rowData.remove("HASIL");
                                rowData.put("HASIL", lMapData.get(0).get(0));
                            } else {
                                idpelErr = tIDPel;
                                rowData.remove("HASIL");
                                rowData.put("HASIL", "0, " + lMapData.get(0).get(0));
                            }
                        } else {
                            throw new Exception("Gagal Proses.");
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

    public Map<String, Object> SetDataIdpel_23NOTA(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String Alasan,
                                               String tglTransaksi) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakK, tBlTh, tStatus, tNorek;
        String tTGLBAYAR;
        String tAlasan, tTransID;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dtrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    //tKdGerakM = rowData.get("KDGERAKMASUK");
                    tKdGerakK = rowData.get("KDGERAKKELUAR");
                    tBlTh = rowData.get("BLTH").substring(3, 4) + rowData.get("BLTH").substring(0, 2);
                    tStatus = rowData.get("STATUS");

                    tNorek = rowData.get("NOREK");
                    tTGLBAYAR = tglTransaksi;

                    tAlasan = Alasan;
                    tTransID = rowData.get("TRANSAKSIID");

                    sql = "{ call PROC_BATAL23_NOTABUKU(?,?,?,?,?,?,?,?,?,?) }";

                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakK);
                        cst.setString(5, tBlTh);
                        cst.setString(6, tStatus);
                        cst.setString(7, tNorek);
                        cst.setString(8, tAlasan);
                        cst.setString(9, tTGLBAYAR);
                        cst.setString(10, tTransID);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() > 0) {
                            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                                rowData.remove("HASIL");
                                rowData.put("HASIL", lMapData.get(0).get(0));
                            } else {
                                idpelErr = tIDPel;
                                rowData.remove("HASIL");
                                rowData.put("HASIL", "0, " + lMapData.get(0).get(0));
                            }
                        } else {
                            throw new Exception("Gagal Proses.");
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

    public Map<String, Object> SetDataIdpel_23DLT(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String Alasan,
                                               String tglTransaksi) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakK, tBlTh, tStatus, tNorek;
        String tTGLBAYAR;
        String tAlasan, tTransID;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dtrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    //tKdGerakM = rowData.get("KDGERAKMASUK");
                    tKdGerakK = rowData.get("KDGERAKKELUAR");
                    tBlTh = rowData.get("BLTH").substring(3, 4) + rowData.get("BLTH").substring(0, 2);
                    tStatus = rowData.get("STATUS");

                    tNorek = rowData.get("NOREK");
                    tTGLBAYAR = tglTransaksi;

                    tAlasan = Alasan;
                    tTransID = rowData.get("TRANSAKSIID");

                    sql = "{ call PROC_BATAL23_DLT(?,?,?,?,?,?,?,?,?,?) }";

                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakK);
                        cst.setString(5, tBlTh);
                        cst.setString(6, tStatus);
                        cst.setString(7, tNorek);
                        cst.setString(8, tAlasan);
                        cst.setString(9, tTGLBAYAR);
                        cst.setString(10, tTransID);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() > 0) {
                            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                                rowData.remove("HASIL");
                                rowData.put("HASIL", lMapData.get(0).get(0));
                            } else {
                                idpelErr = tIDPel;
                                rowData.remove("HASIL");
                                rowData.put("HASIL", "0, " + lMapData.get(0).get(0));
                            }
                        } else {
                            throw new Exception("Gagal Proses.");
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

    public Map<String, Object> SetDataIdpel_31(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String Alasan,
                                               String tglTransaksi) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakK, tBlTh, tStatus, tNorek;
        String tTGLBAYAR;
        String tAlasan, tTransID;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dtrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    //tKdGerakM = rowData.get("KDGERAKMASUK");
                    tKdGerakK = rowData.get("KDGERAKKELUAR");
                    tBlTh = rowData.get("BLTH").substring(3, 4) + rowData.get("BLTH").substring(0, 2);
                    tStatus = rowData.get("STATUS");

                    tNorek = rowData.get("NOREK");
                    tTGLBAYAR = tglTransaksi;

                    tAlasan = Alasan;
                    tTransID = rowData.get("TRANSAKSIID");

                    sql = "{ call PROC_BATAL31_BATALPIUTANG(?,?,?,?,?,?,?,?,?,?) }";

                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakK);
                        cst.setString(5, tBlTh);
                        cst.setString(6, tStatus);
                        cst.setString(7, tNorek);
                        cst.setString(8, tAlasan);
                        cst.setString(9, tTGLBAYAR);
                        cst.setString(10, tTransID);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() > 0) {
                            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                                rowData.remove("HASIL");
                                rowData.put("HASIL", lMapData.get(0).get(0));
                            } else {
                                idpelErr = tIDPel;
                                rowData.remove("HASIL");
                                rowData.put("HASIL", "0, " + lMapData.get(0).get(0));
                            }
                        } else {
                            throw new Exception("Gagal Proses.");
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

    public Map<String, Object> SetDataIdpel_41(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String Alasan,
                                               String tglTransaksi) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek ;
        String tTgkoreksi;
        String tAlasan, tTransID;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dtrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    //tKdGerakK = rowData.get("KDGERAKKELUAR");
                    tBlTh = rowData.get("BLTH").substring(3, 4) + rowData.get("BLTH").substring(0, 2);
                    tStatus = rowData.get("STATUS");

                    tNorek = rowData.get("NOREK");
                    tTgkoreksi = tglTransaksi;

                    tAlasan = Alasan;
                    tTransID = rowData.get("TRANSAKSIID");

                    sql = "{ call PROC_BATAL41_LANCARKERAGU(?,?,?,?,?,?,?,?,?,?,?) }";

                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, null);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tAlasan);
                        cst.setString(10, tTgkoreksi);
                        cst.setString(11, tTransID);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() > 0) {
                            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                                rowData.remove("HASIL");
                                rowData.put("HASIL", lMapData.get(0).get(0));
                            } else {
                                idpelErr = tIDPel;
                                rowData.remove("HASIL");
                                rowData.put("HASIL", "0, " + lMapData.get(0).get(0));
                            }
                        } else {
                            throw new Exception("Gagal Proses.");
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

    public Map<String, Object> SetDataIdpel_32(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String Alasan,
                                               String tglTransaksi) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakK, tBlTh, tStatus, tNorek ;
        String tTGLBAYAR;
        String tAlasan, tTransID;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dtrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    //tKdGerakM = rowData.get("KDGERAKMASUK");
                    tKdGerakK = rowData.get("KDGERAKKELUAR");
                    tBlTh = rowData.get("BLTH").substring(3, 4) + rowData.get("BLTH").substring(0, 2);
                    tStatus = rowData.get("STATUS");

                    tNorek = rowData.get("NOREK");
                    tTGLBAYAR = tglTransaksi;

                    tAlasan = Alasan;
                    tTransID = rowData.get("TRANSAKSIID");

                    sql = "{ call PROC_BATAL32_HAPUSPIUTANG(?,?,?,?,?,?,?,?,?,?) }";

                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakK);
                        cst.setString(5, tBlTh);
                        cst.setString(6, tStatus);
                        cst.setString(7, tNorek);
                        cst.setString(8, tAlasan);
                        cst.setString(9, tTGLBAYAR);
                        cst.setString(10, tTransID);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() > 0) {
                            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                                rowData.remove("HASIL");
                                rowData.put("HASIL", lMapData.get(0).get(0));
                            } else {
                                idpelErr = tIDPel;
                                rowData.remove("HASIL");
                                rowData.put("HASIL", "0, " + lMapData.get(0).get(0));
                            }
                        } else {
                            throw new Exception("Gagal Proses.");
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

    public Map<String, Object> SetDataIdpel_CicilRek(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String Alasan,
                                               String tglTransaksi) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek, tNoAgenda ;
        String tTgCicilan;
        String tAlasan, tTransID;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dtrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    //tKdGerakK = rowData.get("KDGERAKKELUAR");
                    tBlTh = rowData.get("BLTH").substring(3, 4) + rowData.get("BLTH").substring(0, 2);
                    tStatus = rowData.get("STATUS");

                    tNorek = rowData.get("NOREK");
                    tTgCicilan = tglTransaksi;

                    tAlasan = Alasan;
                    tNoAgenda = rowData.get("NOAGENDA");
                    tTransID = rowData.get("TRANSAKSIID");

                    sql = "{ call PROC_BATALCICILREK(?,?,?,?,?,?,?,?,?,?,?,?) }";

                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, null);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tNoAgenda);
                        cst.setString(10, tAlasan);
                        cst.setString(11, tTgCicilan);
                        cst.setString(12, tTransID);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() > 0) {
                            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                                rowData.remove("HASIL");
                                rowData.put("HASIL", lMapData.get(0).get(0));
                            } else {
                                idpelErr = tIDPel;
                                rowData.remove("HASIL");
                                rowData.put("HASIL", "0, " + lMapData.get(0).get(0));
                            }
                        } else {
                            throw new Exception("Gagal Proses.");
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

    public Map<String, Object> SetDataIdpel_23Kirim(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String Alasan,
                                               String tglTransaksi) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek ;
        String tTgkoreksi;
        String tAlasan, tTransID;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dtrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    //tKdGerakK = rowData.get("KDGERAKKELUAR");
                    tBlTh = rowData.get("BLTH").substring(3, 4) + rowData.get("BLTH").substring(0, 2);
                    tStatus = rowData.get("STATUS");

                    tNorek = rowData.get("NOREK");
                    tTgkoreksi = tglTransaksi;

                    tAlasan = Alasan;
                    tTransID = rowData.get("TRANSAKSIID");

                    sql = "{ call PROC_BATAL23_KIRIMREKENING(?,?,?,?,?,?,?,?,?,?,?,?) }";

                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, null);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, null);
                        cst.setString(10, tAlasan);
                        cst.setString(11, tTgkoreksi);
                        cst.setString(12, tTransID);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() > 0) {
                            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                                rowData.remove("HASIL");
                                rowData.put("HASIL", lMapData.get(0).get(0));
                            } else {
                                idpelErr = tIDPel;
                                rowData.remove("HASIL");
                                rowData.put("HASIL", "0, " + lMapData.get(0).get(0));
                            }
                        } else {
                            throw new Exception("Gagal Proses.");
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

    public Map<String, Object> SetDataIdpel_23Terima(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String Alasan,
                                               String tglTransaksi) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        String idpelErr = "", tPetugas, tIDPel, tKdPembPP, tKdGerakM, tBlTh, tStatus, tNorek ;
        String tTgkoreksi;
        String tAlasan, tTransID;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;

            for (Map<String, String> rowData : dtrans) {
                if (rowData.get("Simpan") == "true" && rowData.get("HASIL") == "") {
                    tPetugas = tTransaksiBy;
                    tIDPel = rowData.get("IDPEL");
                    tKdPembPP = rowData.get("KDPEMBPP");
                    tKdGerakM = rowData.get("KDGERAKMASUK");
                    //tKdGerakK = rowData.get("KDGERAKKELUAR");
                    tBlTh = rowData.get("BLTH").substring(3, 4) + rowData.get("BLTH").substring(0, 2);
                    tStatus = rowData.get("STATUS");

                    tNorek = rowData.get("NOREK");
                    tTgkoreksi = tglTransaksi;

                    tAlasan = Alasan;
                    tTransID = rowData.get("TRANSAKSIID");

                    sql = "{ call PROC_BATAL23_TERIMAREKENING(?,?,?,?,?,?,?,?,?,?,?) }";

                    if (idpelErr == tIDPel) {
                        rowData.remove("HASIL");
                        rowData.put("HASIL", " ");
                    } else {
                        cst = con.prepareCall(sql);
                        cst.setString(1, tTransaksiBy);
                        cst.setString(2, tIDPel);
                        cst.setString(3, tKdPembPP);
                        cst.setString(4, tKdGerakM);
                        cst.setString(5, null);
                        cst.setString(6, tBlTh);
                        cst.setString(7, tStatus);
                        cst.setString(8, tNorek);
                        cst.setString(9, tAlasan);
                        cst.setString(10, tTgkoreksi);
                        cst.setString(11, tTransID);

                        cst.execute();

                        sql = "select parhasil.getHasil AS HASIL FROM dual";
                        cst = con.prepareCall(sql);
                        rs = cst.executeQuery();

                        lMapData = CommonModule.convertResultsetToListStr(rs);

                        if (lMapData.size() > 0) {
                            if (lMapData.get(0).get(0).substring(0,1) == "1") {
                                rowData.remove("HASIL");
                                rowData.put("HASIL", lMapData.get(0).get(0));
                            } else {
                                idpelErr = tIDPel;
                                rowData.remove("HASIL");
                                rowData.put("HASIL", "0, " + lMapData.get(0).get(0));
                            }
                        } else {
                            throw new Exception("Gagal Proses.");
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
}
