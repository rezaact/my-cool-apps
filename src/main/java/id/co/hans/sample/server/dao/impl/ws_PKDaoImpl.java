package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.ws_PKDao;
import id.co.hans.sample.server.dao.ws_PPDao;
import id.co.hans.sample.server.utility.CommonModule;
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
public class ws_PKDaoImpl implements ws_PKDao{
    public static final Log log = LogFactory.getLog(ws_PKDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> setSimpanCreditNote(String nocn,
                                                   Date tgl,
                                                   String kodebank,
                                                   String kodepp,
                                                   Double mutasi,
                                                   String kodePetugas,
                                                   String kb,
                                                   String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strTanggal = formatter.format(tgl);

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "INSERT INTO CREDITNOTE(NO_CN,tgl_transaksi,mutasi,kode_bank,kodepp,kodepetugas,jenisbank" +
                        ",blthrek) VALUES " +
                        " ('" + nocn + "', TO_DATE('" + strTanggal + "','mm-dd-yyyy')," + mutasi + ",'" + kodebank + "','" + kodepp + "','" + kodePetugas + "','" + kb + "','" + blth + "')";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            cst.execute();

            retValue.put("wsReturn", "berhasil");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
        }
        return retValue;
    }

    @Override
    public Map<String, Object> getRanting(String strKodeCabang) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SELECT Nama_Ranting, Kode_Cabang_Numerik, Kode_Ranting,Kode_Ranting_Numerik From RantingRayon Where Kode_Cabang_Numerik = '" + strKodeCabang + "' ORDER BY Nama_Ranting";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }

    @Override
    public Map<String, Object> getPP(String strKodeRanting) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SELECT * From Payment_point Where kode_ranting_numerik = '" + strKodeRanting + "' ORDER BY namapp";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> getInduk() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "select Kode_Induk, Kode_Induk_Numerik, Nama_Induk  From Induk";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }

    @Override
    public Map<String, Object> getCabang() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SELECT Nama_Cabang, Kode_Cabang, Kode_cabang_Numerik, Kode_Induk_Numerik From cabang";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }

    @Override
    public Map<String, Object> setVerifikasiPiutang(String strKodeInduk,
                                                    String strKodeCabang,
                                                    String strKodeRanting) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            CekPenghapusanTUL63(strKodeRanting);
            CekPenghapusanTUL62(strKodeRanting);
            CekPenghapusanTUL61(strKodeRanting);
            setTUL61(strKodeInduk, strKodeCabang, strKodeRanting);
            SetTUL62(strKodeInduk, strKodeCabang, strKodeRanting);
            SetTUL63(strKodeInduk, strKodeCabang, strKodeRanting);
            IsiTULVILAPORANSemuaTunggakan(strKodeRanting);

            retValue.put("wsReturn", true);
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
        }
        return retValue;
    }


    @Override
    public Map<String, Object> getBongkar(String Nomor,
                                          Byte bytTypeNo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SELECT * FROM TUL63, TUL61, DIL";
            sql = sql + " WHERE TUL63.NO_PELANGGAN=TUL61.NO_PELANGGAN AND ";
            sql = sql + " TUL63.NO_PELANGGAN=DIL.NO_PELANGGAN AND ";
            sql = sql + " TUL61.NOCETAKTUL601='" + Nomor + "' AND TUL63.TANGGAL_PELAKSANAAN is NULL";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> setBongkar(String strNomor,
                                          String strPelaksana,
                                          String Byte,
                                          String NoPelanggan) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String tgl = formatter.format(new Date());

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;

            String sql = "update TUL63";
            sql = sql + " set Tanggal_Pelaksanaan = TO_DATE('" + tgl + "','mm-dd-yyyy'),";
            sql = sql + " Nama_Pelaksana='" + strPelaksana + "', ";
            sql = sql + " TUL63.NOCETAKTUL603='" + strNomor + "'";
            sql = sql + " where TUL63.NO_PELANGGAN='" + NoPelanggan + "'";

            cst = con.prepareCall(sql);
            cst.execute();

            sql = "UPDATE DIS SET KODE_GERAK_MASUK='41' WHERE NO_PELANGGAN='" + NoPelanggan + "' AND LUNAS IS NULL";

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
    public Map<String, Object> getTusBung(String Nomor,
                                          Byte bytType,
                                          Byte bytTypeNo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;

            String sql;

            sql = "SELECT *";
            sql = sql + " FROM TUL62,dil";

            if (bytTypeNo == 0) {
                sql = sql + " where TUL62.NO_TUL60='" + Nomor + "'";
            } else {
                sql = sql + " where TUL62.NOCETAKTUL602='" + Nomor + "'";
            }

            sql = sql + " and dil.No_Pelanggan=tul62.No_Pelanggan";

            if (bytType == 0) {
                sql = sql + " and tul62.tanggal_pelaksanaan_pemutusan is null";
            } else {
                sql = sql + " and UPPER(tul62.Penyambungan)='PENYAMBUNGAN'";
            }

            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();
            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> setTusBung(String strNomor,
                                          String strPelaksana,
                                          String strWBP,
                                          String strLWBP,
                                          String strKVARH,
                                          Byte bytType,
                                          String bytTypeNo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "update TUL62";

            if (bytType == 0) {
                sql = sql + " set Tanggal_Pelaksanaan_Pemutusan = TO_DATE(SYSDATE ,'DD-MM-YYYY'),";
                sql = sql + " Nama_Pelaksana_Pemutusan='" + strPelaksana + "',";
                sql = sql + " Stand_wbp_Putus='" + strWBP + "',";
                sql = sql + " Stand_Lwbp_Putus='" + strLWBP + "',";
                sql = sql + " Stand_kvarh_Putus='" + strKVARH + "'";

                if (bytTypeNo == "0") {
                    sql = sql + " where TUL62.NO_TUL60='" + strNomor + "'";
                }else{
                    sql = sql + " where TUL62.NOCETAKTUL602='" + strNomor + "'";
                }

                sql = sql + " and tul62.CETAK_TUL62='Ya'";
            } else if (bytType == 1) {
                sql = sql + " set Tanggal_Plk_Penyambungan = TO_DATE(sysdate,'DD-MM-YYYY'),";
                sql = sql + " Nama_Pelaksana_Penyambungan='" + strPelaksana + "',";
                sql = sql + " Stand_wbp_sambung='" + strWBP + "',";
                sql = sql + " Stand_Lwbp_sambung='" + strLWBP + "',";
                sql = sql + " Stand_kvarh_sambung='" + strKVARH + "'";

                if (bytTypeNo == "0") {
                    sql = sql + " where TUL62.NO_TUL60='" + strNomor + "'";
                } else {
                    sql = sql + " where TUL62.NOCETAKTUL602='" + strNomor + "'";
                }

                sql = sql + " and tul62.CETAK_TUL62='Ya'";
                sql = sql + " and tul62.Penyambungan='Penyambungan'";
            }

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
    public Map<String, Object> getCustomer(String strNomor,
                                           Byte bytType) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql = "";
            
            if (bytType == 0) {
                sql = "SELECT No_Pelanggan,No_Kontrak,Nama_Pelanggan,Tarip,Daya,Jalan,Nama_Jalan,No_Bangunan,";
                sql = sql + " Kodya_Kabupaten,Kode_pos,Telepon FROM DIL ";
                sql = sql + " Where DIL.No_Kontrak = '" + strNomor + "'";
            } else if (bytType == 1) {
                sql = "SELECT No_Pelanggan,No_Kontrak,Nama_Pelanggan,Tarip,Daya,Jalan,Nama_Jalan,No_Bangunan,";
                sql = sql + " Kodya_Kabupaten,Kode_pos,Telepon FROM DIL ";
                sql = sql + " Where DIL.No_Pelanggan = '" + strNomor + "'";
            }

            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", lMapRecords);
        }
        return retValue;
    }


    @Override
    public Map<String, Object> formatINDO(Date strTgl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        SimpleDateFormat formatterMonth = new SimpleDateFormat("MMM");
        SimpleDateFormat formatterYear = new SimpleDateFormat("MMM");

        String m,y;

        try
        {
            m = formatterMonth.format(strTgl);
            y = formatterYear.format(strTgl);

            switch (m) {
                case "May" : m = "Mei"; break;
                case "Oct" : m = "Okt"; break;
                case "Aug" : m = "Agu"; break;
                case "Dec" : m = "Des"; break;
                case "Nov" : m = "Nop"; break;
                case "Agust" : m = "Agu"; break;
                default: m = m.substring(1,3);
            }

            retValue.put("wsReturn", m + "-" + y);
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> getMasterInduk() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SELECT * From Induk";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }

    @Override
    public Map<String, Object> setMasterInduk(Map<String, Object> dsChanged) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            throw new Exception("Not Implemented yet");

//            Connection con = jdbcTemplate.getDataSource().getConnection();
//
//            String sql = "SELECT KODE_INDUK, KODE_INDUK_NUMERIK, NAMA_INDUK, TELEPON, PLG, PENYULANG, TRAFO, DAYA, GARDU, JTM, JTR FROM INDUK";
//
//            CallableStatement cst;
//            cst = con.prepareCall(sql);
//
//            ResultSet rs = cst.executeQuery();
//
//            lMapRecords = CommonModule.convertResultsetToListStr(rs);
//
//            retValue.put("wsReturn", "Data successfully updated");
//
//            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
        }
        return retValue;
    }


    @Override
    public Map<String, Object> getTablePejabat(String strKode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;

            String sql = "SELECT * From Pejabat";
            sql = sql + " where kd_pejabat='" + strKode + "'";

            cst = con.prepareCall(sql);
            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
        }
        return retValue;
    }


    @Override
    public Map<String, Object> getData(String strQuery) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        retValue.put("wsReturn", false);
        retValue.put("wsByRefError", "deprecated");
        return retValue;
    }

    @Override
    public Map<String, Object> setData(String strQuery) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        retValue.put("wsReturn", false);
        retValue.put("wsByRefError", "deprecated");
        return retValue;
    }


    @Override
    public Map<String, Object> CekPenghapusanTUL63(String strKodeRanting) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();
        List<Map<String,String>> lMapRecordsProses = new ArrayList<Map<String,String>>();

        String strNoPelanggan = "";
        Boolean blnReturn = false;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            ResultSet rs;

            String sql = "SELECT TUL63.No_Pelanggan,TUL63.No_Kontrak,";
            sql = sql + " Tul63.No_tul60,";
            sql = sql + " max(dis.tgl_pelunasan)as Tanggal";
            sql = sql + " FROM TUL63 ";
            sql = sql + " inner join dil on TUL63.No_Pelanggan=DIL.No_Pelanggan ";
            sql = sql + " inner join dis";
            sql = sql + " on TUL63.No_Pelanggan=DIS.No_Pelanggan ";
            sql = sql + " where DIL.Kode_Ranting_Numerik='" + strKodeRanting + "'";
            sql = sql + " and dis.Lunas ='Lunas'";
            sql = sql + " and dis.NmPiutang='Biaya Keterlambatan'";
            sql = sql + " and dis.uraian='BK III'";
            sql = sql + " GROUP BY TUL63.No_Pelanggan,TUL63.No_Kontrak,";
            sql = sql + " Tul63.No_tul60";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            if (lMapRecords.size() > 0) {
                for (Map<String, String> rowData : lMapRecords) {
                    strNoPelanggan = rowData.get("No_Pelanggan");

                    //get data FROM TUl63
                    sql = "select NO_TUL60, NO_PELANGGAN, NO_KONTRAK, NO_AGENDA, ";
                    sql = sql + "NAMA_PELANGGAN, JENIS_TUL60, PEMUTUSAN_PENYAMBUNGAN, ";
                    sql = sql + "TANGGAL_PERINTAH_KERJA, TANGGAL_PELAKSANAAN, NAMA_PELAKSANA, ";
                    sql = sql + "URAIAN, CETAK,  NOCETAKTUL603, TANGGAL_CETAK, ";
                    sql = sql + "TOTALLEMBAR, TAGIHAN, BLTHREK ";
                    sql = sql + "FROM TUL63 ";
                    sql = sql + "where No_Pelanggan='" + strNoPelanggan + "'";

                    cst = con.prepareCall(sql);
                    rs = cst.executeQuery();
                    lMapRecordsProses = CommonModule.convertResultsetToListStr(rs);

                    if (lMapRecordsProses.size() > 0) {
                        //insert to TUl63history
                        sql = "INSERT INTO TUL63History(NO_TUL60, NO_PELANGGAN, NO_KONTRAK, NO_AGENDA, ";
                        sql = sql + "NAMA_PELANGGAN, JENIS_TUL60, PEMUTUSAN_PENYAMBUNGAN, ";
                        sql = sql + "TANGGAL_PERINTAH_KERJA, TANGGAL_PELAKSANAAN, NAMA_PELAKSANA, ";
                        sql = sql + "URAIAN, CETAK,  NOCETAKTUL603, TANGGAL_CETAK, ";
                        sql = sql + "TOTALLEMBAR, TAGIHAN, BLTHREK)";
                        sql = sql + " VALUES('" + lMapRecordsProses.get(0).get("No_TUL60") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NO_PELANGGAN") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NO_KONTRAK") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NO_AGENDA") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NAMA_PELANGGAN") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("JENIS_TUL60") + "'";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("PEMUTUSAN_PENYAMBUNGAN") + "',";
                        sql = sql + lMapRecordsProses.get(0).get("TANGGAL_PERINTAH_KERJA") + ",";
                        sql = sql + lMapRecordsProses.get(0).get("TANGGAL_PELAKSANAAN") + ",";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NAMA_PELAKSANA") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("URAIAN") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("CETAK") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NOCETAKTUL603") + "',";
                        sql = sql + lMapRecordsProses.get(0).get("TANGGAL_CETAK") + ",";
                        sql = sql + lMapRecordsProses.get(0).get("TOTALLEMBAR") + ",";
                        sql = sql + lMapRecordsProses.get(0).get("TAGIHAN") + ",";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("BLTHREK") + "')";

                        cst = con.prepareCall(sql);
                        cst.execute();

                        sql = "delete TUL63 where No_Pelanggan='" + strNoPelanggan + "'";

                        cst = con.prepareCall(sql);
                        cst.execute();
                    }


                    //get data FROM TUl62
                    sql = "select NO_TUL60, NO_PELANGGAN, NO_KONTRAK, NAMA_PELANGGAN, JENIS_TUL60, ";
                    sql = sql + "PEMUTUSAN, TANGGAL_PK_PEMUTUSAN, TANGGAL_PELAKSANAAN_PEMUTUSAN, NAMA_PELAKSANA_PEMUTUSAN, ";
                    sql = sql + "URAIAN, PENYAMBUNGAN, TANGGAL_PK_PENYAMBUNGAN, TANGGAL_PLK_PENYAMBUNGAN, ";
                    sql = sql + "NAMA_PELAKSANA_PENYAMBUNGAN, TANGGAL_PELUNASAN, STAND_LWBP_PUTUS, STAND_WBP_PUTUS, ";
                    sql = sql + "STAND_KVARH_PUTUS, STAND_LWBP_SAMBUNG, STAND_WBP_SAMBUNG, STAND_KVARH_SAMBUNG, ";
                    sql = sql + "STAND_LWBP, STAND_WBP, STAND_KVARH, STATUS,CETAK,TANGGAL_CETAK, ";
                    sql = sql + "NOCETAKTUL602, TOTALLEMBAR, TAGIHAN, BLTHREK ";
                    sql = sql + "FROM TUL62";
                    sql = sql + "where No_Pelanggan='" + strNoPelanggan + "'";

                    cst = con.prepareCall(sql);
                    rs = cst.executeQuery();
                    lMapRecordsProses = CommonModule.convertResultsetToListStr(rs);

                    if (lMapRecordsProses.size() > 0) {
                        sql = "Insert into TUL62History (NO_TUL60, NO_PELANGGAN, NO_KONTRAK, NAMA_PELANGGAN, JENIS_TUL60, ";
                        sql = sql + "PEMUTUSAN, TANGGAL_PK_PEMUTUSAN, TANGGAL_PELAKSANAAN_PEMUTUSAN, NAMA_PELAKSANA_PEMUTUSAN, ";
                        sql = sql + "URAIAN, PENYAMBUNGAN, TANGGAL_PK_PENYAMBUNGAN, TANGGAL_PLK_PENYAMBUNGAN, ";
                        sql = sql + "NAMA_PELAKSANA_PENYAMBUNGAN, TANGGAL_PELUNASAN, STAND_LWBP_PUTUS, STAND_WBP_PUTUS, ";
                        sql = sql + "STAND_KVARH_PUTUS, STAND_LWBP_SAMBUNG, STAND_WBP_SAMBUNG, STAND_KVARH_SAMBUNG, ";
                        sql = sql + "STAND_LWBP, STAND_WBP, STAND_KVARH, STATUS,CETAK,TANGGAL_CETAK, ";
                        sql = sql + "NOCETAKTUL602, TOTALLEMBAR, TAGIHAN, BLTHREK)";
                        sql = sql + " VALUES('" + lMapRecordsProses.get(0).get("No_TUL60") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NO_PELANGGAN") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NO_KONTRAK") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NAMA_PELANGGAN") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("JENIS_TUL60") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("PEMUTUSAN") + "',";
                        sql = sql + "TO_DATE('" + lMapRecordsProses.get(0).get("TANGGAL_PK_PEMUTUSAN") + "','mm-dd-yyyy HH:MI:SS AM'),";
                        sql = sql + "TO_DATE('" + lMapRecordsProses.get(0).get("TANGGAL_PELAKSANAAN_PEMUTUSAN") + "','mm-dd-yyyy HH:MI:SS AM'),";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NAMA_PELAKSANA_PEMUTUSAN") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("URAIAN") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("PENYAMBUNGAN") + "',";
                        sql = sql + "TO_DATE('" + lMapRecordsProses.get(0).get("TANGGAL_PK_PENYAMBUNGAN") + "','mm-dd-yyyy HH:MI:SS AM'),";
                        sql = sql + "TO_DATE('" + lMapRecordsProses.get(0).get("TANGGAL_PLK_PENYAMBUNGAN") + "','mm-dd-yyyy HH:MI:SS AM'),";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NAMA_PELAKSANA_PENYAMBUNGAN") + "',";
                        sql = sql + "TO_DATE('" + lMapRecordsProses.get(0).get("TANGGAL_PELUNASAN") + "','mm-dd-yyyy HH:MI:SS AM'),";
                        sql = sql + lMapRecordsProses.get(0).get("STAND_LWBP_PUTUS") + ",";
                        sql = sql + lMapRecordsProses.get(0).get("STAND_WBP_PUTUS") + ",";
                        sql = sql + lMapRecordsProses.get(0).get("STAND_KVARH_PUTUS") + ",";
                        sql = sql + lMapRecordsProses.get(0).get("STAND_LWBP_SAMBUNG") + ",";
                        sql = sql + lMapRecordsProses.get(0).get("STAND_WBP_SAMBUNG") + ",";
                        sql = sql + lMapRecordsProses.get(0).get("STAND_KVARH_SAMBUNG") + ",";
                        sql = sql + lMapRecordsProses.get(0).get("STAND_LWBP") + ",";
                        sql = sql + lMapRecordsProses.get(0).get("STAND_WBP") + ",";
                        sql = sql + lMapRecordsProses.get(0).get("STAND_KVARH") + ",";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("STATUS") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("CETAK") + "',";
                        sql = sql + "TO_DATE('" + lMapRecordsProses.get(0).get("TANGGAL_CETAK") + "','mm-dd-yyyy HH:MI:SS AM'),";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NOCETAKTUL602") + "',";
                        sql = sql + lMapRecordsProses.get(0).get("TOTALLEMBAR") + ",";
                        sql = sql + lMapRecordsProses.get(0).get("TAGIHAN") + ",";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("BLTHREK") + "')";

                        cst = con.prepareCall(sql);
                        cst.execute();

                        sql = "delete TUL62 where No_Pelanggan='" + strNoPelanggan + "'";

                        cst = con.prepareCall(sql);
                        cst.execute();
                    }

                    //get data FROM TUl61
                    sql = "select NO_TUL60, NO_PELANGGAN, NO_KONTRAK, NO_AGENDA, NAMA_PELANGGAN, ";
                    sql = sql + "JENIS_TUL60, PEMUTUSAN_PENYAMBUNGAN, TANGGAL_PERINTAH_KERJA, TANGGAL_PELAKSANAAN, ";
                    sql = sql + "NAMA_PELAKSANA, URAIAN, CETAK, NOCETAKTUL601, ";
                    sql = sql + "TANGGAL_CETAK, TOTALLEMBAR, TAGIHAN, BLTHREK ";
                    sql = sql + "FROM TUL61 ";
                    sql = sql + "where No_Pelanggan='" + strNoPelanggan + "'";

                    cst = con.prepareCall(sql);
                    rs = cst.executeQuery();
                    lMapRecordsProses = CommonModule.convertResultsetToListStr(rs);

                    if (lMapRecordsProses.size() > 0) {
                        //insert to TUl61history
                        sql = "INSERT INTO TUL61History(NO_TUL60, NO_PELANGGAN, NO_KONTRAK, NO_AGENDA, ";
                        sql = sql + "NAMA_PELANGGAN, JENIS_TUL60, PEMUTUSAN_PENYAMBUNGAN, ";
                        sql = sql + "TANGGAL_PERINTAH_KERJA, TANGGAL_PELAKSANAAN, NAMA_PELAKSANA, ";
                        sql = sql + "URAIAN, CETAK,  NOCETAKTUL601, TANGGAL_CETAK, ";
                        sql = sql + "TOTALLEMBAR, TAGIHAN, BLTHREK)";
                        sql = sql + " VALUES('" + lMapRecordsProses.get(0).get("No_TUL60") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NO_PELANGGAN") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NO_KONTRAK") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NO_AGENDA") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NAMA_PELANGGAN") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("JENIS_TUL60") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("PEMUTUSAN_PENYAMBUNGAN") + "',";
                        sql = sql + "TO_DATE('" + lMapRecordsProses.get(0).get("TANGGAL_PERINTAH_KERJA") + "','mm-dd-yyyy HH:MI:SS AM'),";
                        sql = sql + "TO_DATE('" + lMapRecordsProses.get(0).get("TANGGAL_PELAKSANAAN") + "','mm-dd-yyyy HH:MI:SS AM'),";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NAMA_PELAKSANA") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("URAIAN") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("CETAK") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NOCETAKTUL601") + "',";
                        sql = sql + "TO_DATE('" + lMapRecordsProses.get(0).get("TANGGAL_CETAK") + "','mm-dd-yyyy HH:MI:SS AM'),";
                        sql = sql + lMapRecordsProses.get(0).get("TOTALLEMBAR") + ",";
                        sql = sql + lMapRecordsProses.get(0).get("TAGIHAN") + ",";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("BLTHREK") + "')";

                        cst = con.prepareCall(sql);
                        cst.execute();

                        sql = "delete TUL61 where No_Pelanggan='" + strNoPelanggan + "'";

                        cst = con.prepareCall(sql);
                        cst.execute();
                    }
                }
                blnReturn = true;
            } else {
                blnReturn = false;
            }

            retValue.put("wsReturn", blnReturn);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", blnReturn);
        }
        return retValue;
    }

    @Override
    public Map<String, Object> CekPenghapusanTUL62(String strKodeRanting) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();
        List<Map<String,String>> lMapRecordsProses = new ArrayList<Map<String,String>>();

        String strNoPelanggan = "";
        Boolean blnReturn = false;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            ResultSet rs;
            String sql;

            sql = "SELECT TUL62.No_Pelanggan,TUL62.No_Kontrak,";
            sql = sql + " TUL62.No_tul60,";
            sql = sql + " dis.tgl_pelunasan";
            sql = sql + " FROM TUL62 ";
            sql = sql + " inner join dil on TUL62.No_Pelanggan=DIL.No_Pelanggan ";
            sql = sql + " inner join dis";
            sql = sql + " on TUL62.No_Pelanggan=DIS.No_Pelanggan ";
            sql = sql + " where DIL.Kode_Ranting_Numerik='" + strKodeRanting + "'";
            sql = sql + " and dis.Lunas ='Lunas'";
            sql = sql + " and dis.NmPiutang='Biaya Keterlambatan'";
            sql = sql + " and dis.uraian='BK I'";
            sql = sql + " GROUP BY TUL62.No_Pelanggan,TUL62.No_Kontrak,";
            sql = sql + " TUL62.No_tul60, dis.tgl_pelunasan";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            if (lMapRecords.size() > 0) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
                SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");
                SimpleDateFormat formatterMonth = new SimpleDateFormat("MM");
                SimpleDateFormat formatterDay = new SimpleDateFormat("dd");
                Date Tanggal = new Date();
                String TGL, BLN;

                for (Map<String, String> rowData : lMapRecords) {
                    strNoPelanggan = rowData.get("No_Pelanggan");

                    Tanggal = formatter.parse(lMapRecords.get(0).get("tgl_pelunasan"));
                    BLN = formatterMonth.format(Tanggal);
                    if (BLN.length() == 1) {
                        BLN = "0" + BLN;
                    }
                    TGL = formatterDay.format(Tanggal) + "-" + BLN + "-" + formatterYear.format(Tanggal);

                    //get data FROM TUl62
                    sql = "select No_TUL60";
                    sql = sql + " FROM tul62";
                    sql = sql + " where tul62.No_Pelanggan='" + strNoPelanggan + "'";
                    sql = sql + " and Tanggal_Pelaksanaan_Pemutusan is null";

                    cst = con.prepareCall(sql);
                    rs = cst.executeQuery();
                    lMapRecordsProses = CommonModule.convertResultsetToListStr(rs);

                    if (lMapRecordsProses.size() > 0) {
                        sql = "UPDATE TUL62";
                        sql = sql + " set tul62.tanggal_pelunasan= to_date('" + TGL + "','DD-MM-YYYY')";
                        sql = sql + " where tul62.No_Pelanggan='" + strNoPelanggan + "'";
                    } else {
                        sql = "UPDATE TUL62";
                        sql = sql + " set tul62.tanggal_pelunasan= to_date('" + TGL + "','DD-MM-YYYY'),";
                        sql = sql + " tul62.Tanggal_PK_Penyambungan= to_date('" + TGL + "','DD-MM-YYYY'),";
                        sql = sql + " tul62.Penyambungan= 'Penyambungan'";
                        sql = sql + " where tul62.No_Pelanggan='" + strNoPelanggan + "'";
                    }

                    cst = con.prepareCall(sql);
                    cst.execute();
                }
                blnReturn = true;
            } else {
                blnReturn = false;
            }

            retValue.put("wsReturn", blnReturn);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", blnReturn);
        }
        return retValue;
    }

    @Override
    public Map<String, Object> CekPenghapusanTUL61(String strKodeRanting) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();
        List<Map<String,String>> lMapRecordsProses = new ArrayList<Map<String,String>>();

        String strNoPelanggan = "";
        Boolean blnReturn = false;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            ResultSet rs;
            String sql;

            sql = "SELECT TUL61.No_Pelanggan,TUL61.No_Kontrak,";
            sql = sql + " TUL61.No_tul60,";
            sql = sql + " max(dis.tgl_pelunasan)as Tanggal ";
            sql = sql + " FROM TUL61 ";
            sql = sql + " inner join dil on TUL61.No_Pelanggan=DIL.No_Pelanggan ";
            sql = sql + " inner join dis ";
            sql = sql + " on TUL61.No_Pelanggan=DIS.No_Pelanggan ";
            sql = sql + " where DIL.Kode_Ranting_Numerik='" + strKodeRanting + "'";
            sql = sql + " and dis.Lunas ='Lunas'";
            sql = sql + " and dis.NmPiutang='Biaya Keterlambatan'";
            sql = sql + " and dis.uraian='BK I'";
            sql = sql + " GROUP BY TUL61.No_Pelanggan,TUL61.No_Kontrak,";
            sql = sql + " TUL61.No_tul60";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            if (lMapRecords.size() > 0) {
                for (Map<String, String> rowData : lMapRecords) {
                    strNoPelanggan = rowData.get("No_Pelanggan");

                    //get data FROM TUl61
                    sql = "select NO_TUL60, NO_PELANGGAN, NO_KONTRAK, NO_AGENDA, NAMA_PELANGGAN, ";
                    sql = sql + "JENIS_TUL60, PEMUTUSAN_PENYAMBUNGAN, TANGGAL_PERINTAH_KERJA, TANGGAL_PELAKSANAAN, ";
                    sql = sql + "NAMA_PELAKSANA, URAIAN, CETAK, NOCETAKTUL601, ";
                    sql = sql + "TANGGAL_CETAK, TOTALLEMBAR, TAGIHAN, BLTHREK ";
                    sql = sql + "FROM TUL61 ";
                    sql = sql + "where No_Pelanggan='" + strNoPelanggan + "'";

                    cst = con.prepareCall(sql);
                    rs = cst.executeQuery();
                    lMapRecordsProses = CommonModule.convertResultsetToListStr(rs);

                    if (lMapRecordsProses.size() > 0) {
                        //insert to TUl61history
                        sql = "INSERT INTO TUL61History(NO_TUL60, NO_PELANGGAN, NO_KONTRAK, NO_AGENDA, ";
                        sql = sql + "NAMA_PELANGGAN, JENIS_TUL60, PEMUTUSAN_PENYAMBUNGAN, ";
                        sql = sql + "TANGGAL_PERINTAH_KERJA, TANGGAL_PELAKSANAAN, NAMA_PELAKSANA, ";
                        sql = sql + "URAIAN, CETAK,  NOCETAKTUL601, TANGGAL_CETAK, ";
                        sql = sql + "TOTALLEMBAR, TAGIHAN, BLTHREK)";
                        sql = sql + " VALUES('" + lMapRecordsProses.get(0).get("No_TUL60") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NO_PELANGGAN") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NO_KONTRAK") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NO_AGENDA") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NAMA_PELANGGAN") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("JENIS_TUL60") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("PEMUTUSAN_PENYAMBUNGAN") + "',";
                        sql = sql + "TO_DATE('" + lMapRecordsProses.get(0).get("TANGGAL_PERINTAH_KERJA") + "','mm-dd-yyyy HH:MI:SS AM'),";
                        sql = sql + "TO_DATE('" + lMapRecordsProses.get(0).get("TANGGAL_PELAKSANAAN") + "','mm-dd-yyyy HH:MI:SS AM'),";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NAMA_PELAKSANA") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("URAIAN") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("CETAK") + "',";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("NOCETAKTUL601") + "',";
                        sql = sql + "TO_DATE('" + lMapRecordsProses.get(0).get("TANGGAL_CETAK") + "','mm-dd-yyyy HH:MI:SS AM'),";
                        sql = sql + lMapRecordsProses.get(0).get("TOTALLEMBAR") + ",";
                        sql = sql + lMapRecordsProses.get(0).get("TAGIHAN") + ",";
                        sql = sql + "'" + lMapRecordsProses.get(0).get("BLTHREK") + "')";

                        cst = con.prepareCall(sql);
                        cst.execute();

                        sql = "delete TUL61 where No_Pelanggan='" + strNoPelanggan + "'";

                        cst = con.prepareCall(sql);
                        cst.execute();
                    }
                }
                blnReturn = true;
            } else {
                blnReturn = false;
            }

            retValue.put("wsReturn", blnReturn);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", blnReturn);
        }
        return retValue;
    }

    @Override
    public Map<String, Object> setTUL61(String strKodeInduk,
                                        String strKodeCabang,
                                        String strKodeRanting) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();
        List<Map<String,String>> lMapRecordsProses = new ArrayList<Map<String,String>>();

        String strSQLUpdate, strSQLRefVerifikasi = "";
        String strKategori = "TUL601";
        String NoTul60, TglPerintahKerja;
        Integer Bulan, JmlRec;
        String Bln, Thn;

        Boolean blnReturn = false;

        SimpleDateFormat formatter = new SimpleDateFormat("MM");

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            ResultSet rs;
            String sql;

            //ambil nomor dari reftul61
            Bulan = Integer.parseInt(formatter.format(new Date()));
            sql = "Select refTUL61.*, TO_CHAR(SYSDATE,'YYYY') as Thn,TO_CHAR(SYSDATE,'MM') as BLN  FROM refTUL61";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            //ganti bulan ganti nomor
            if (lMapRecords.size() > 0) {
                if (Bulan != Integer.parseInt(lMapRecords.get(0).get("Bulan"))) {
                    formatter = new SimpleDateFormat("yyyy");
                    strSQLUpdate = "update refTUL61 set Bulan='" + Bulan + "', tahun='" + formatter.format(new Date()) + "', notul60=1";
                    cst = con.prepareCall(strSQLUpdate);
                    cst.execute();
                    JmlRec = 1;
                } else {
                    JmlRec = Integer.parseInt(lMapRecords.get(0).get("NOTUL60"));
                }
            } else {
                formatter = new SimpleDateFormat("yyyy");
                strSQLUpdate = "INSERT INTO refTUL61(bulan,tahun,notul60) VALUES ('" + Bulan + "', '" + formatter.format(new Date()) + "', 1)";
                cst = con.prepareCall(strSQLUpdate);
                cst.execute();
                JmlRec = 1;
            }

            //ambil data dari refverifikasi sebagai acuan untuk penerbitan WO
            //tambahkan ambil data kelompok_kerja
            Bln = lMapRecords.get(0).get("Bln");
            Thn = lMapRecords.get(0).get("Thn");
            if (Bln.substring(1, 1) == "0") {
                Bln = Bln.substring(2, 1);
            }

            strSQLRefVerifikasi = "Select Tahun,Bulan,Tanggal FROM refVerifikasi where upper(kategori)='" + strKategori + "'";
            strSQLRefVerifikasi = strSQLRefVerifikasi + " and KODE_INDUK_NUMERIK='" + strKodeInduk + "' and KODE_CABANG_NUMERIK='" + strKodeCabang + "'";
            strSQLRefVerifikasi = strSQLRefVerifikasi + " and KODE_RANTING_NUMERIK='" + strKodeRanting + "'";
            strSQLRefVerifikasi = strSQLRefVerifikasi + " and tahun=TO_CHAR(SYSDATE,'YYYY')";
            strSQLRefVerifikasi = strSQLRefVerifikasi + "and bulan='" + Bln + "'";

            cst = con.prepareCall(strSQLRefVerifikasi);
            rs = cst.executeQuery();
            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            String strTanggal = "";
            if (lMapRecords.size() > 0) {
                strTanggal = lMapRecords.get(0).get("TANGGAL") + "-" + lMapRecords.get(0).get("BULAN") + "-" + lMapRecords.get(0).get("TAHUN");
            }


            sql = "select DIS.No_Kontrak,DIL.No_Pelanggan,DIL.Nama_Pelanggan,DIS.Uraian FROM DIS,DIL ";
            sql = sql + " where DIS.No_Pelanggan=DIL.No_Pelanggan ";
            sql = sql + " and Kode_Ranting_Numerik='" + strKodeRanting + "'";
            sql = sql + " and substr(DIL.Kode_Golongan,1,1)='0'";
            sql = sql + " and (TO_DATE('" + strTanggal + "','DD-MM-YYYY')- Tgl_Jatuh_Tempo)>=0";
            sql = sql + " and Uraian='BK I'";
            sql = sql + " and Lunas is NULL";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            for (Map<String, String> rowData : lMapRecords) {
                formatter = new SimpleDateFormat("MM/dd/yyyy");
                TglPerintahKerja = formatter.format(new Date());
                NoTul60 = TglPerintahKerja + "/" + "TULVI-01" + "/" + JmlRec;

                //insert data ke TUL61
                strSQLUpdate = "INSERT INTO tul61(no_tul60,";
                strSQLUpdate = strSQLUpdate + " No_Pelanggan,No_Kontrak,";
                strSQLUpdate = strSQLUpdate + " Nama_Pelanggan,Tanggal_Perintah_Kerja,";
                strSQLUpdate = strSQLUpdate + " Pemutusan_Penyambungan,Jenis_Tul60,";
                strSQLUpdate = strSQLUpdate + " Uraian)";
                strSQLUpdate = strSQLUpdate + " VALUES ('" + NoTul60 + "',";
                strSQLUpdate = strSQLUpdate + " '" + rowData.get("No_Pelanggan") + "','" + rowData.get("No_Kontrak") + "',";
                strSQLUpdate = strSQLUpdate + " '" + rowData.get("Nama_Pelanggan") + "',TO_DATE('" + TglPerintahKerja + "','mm-dd-yyyy'),";
                strSQLUpdate = strSQLUpdate + " 'Pemutusan','VI-01',";
                strSQLUpdate = strSQLUpdate + " '" + rowData.get("Uraian") + "')";

                cst = con.prepareCall(strSQLUpdate);
                cst.execute();

                JmlRec++;
            }

            //Update NoTUL60 di RefTUL61
            strSQLUpdate = "update refTUL61 set";
            strSQLUpdate = strSQLUpdate + " notul60='" + JmlRec + "'";

            cst = con.prepareCall(strSQLUpdate);
            cst.execute();


            blnReturn = true;

            retValue.put("wsReturn", blnReturn);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", blnReturn);
        }
        return retValue;
    }

    @Override
    public Map<String, Object> SetTUL62(String strKodeInduk,
                                        String strKodeCabang,
                                        String strKodeRanting) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();
        List<Map<String,String>> lMapRecordsProses = new ArrayList<Map<String,String>>();

        String strSQLUpdate, strSQLRefVerifikasi = "";
        String strKategori = "TUL602";
        String NoTul60, TglPerintahKerja;
        Integer Bulan, JmlRec;
        String Bln, Thn;

        Boolean blnReturn = false;

        SimpleDateFormat formatter = new SimpleDateFormat("MM");

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            ResultSet rs;
            String sql;

            //ambil nomor dari reftul61
            Bulan = Integer.parseInt(formatter.format(new Date()));
            sql = "Select refTUL61.*, TO_CHAR(SYSDATE,'YYYY') as Thn,TO_CHAR(SYSDATE,'MM') as BLN  FROM refTUL61";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            //ganti bulan ganti nomor
            if (lMapRecords.size() > 0) {
                if (Bulan != Integer.parseInt(lMapRecords.get(0).get("Bulan"))) {
                    formatter = new SimpleDateFormat("yyyy");
                    strSQLUpdate = "update refTUL62 set Bulan='" + Bulan + "', tahun='" + formatter.format(new Date()) + "', notul60=1";
                    cst = con.prepareCall(strSQLUpdate);
                    cst.execute();
                    JmlRec = 1;
                } else {
                    JmlRec = Integer.parseInt(lMapRecords.get(0).get("NOTUL60"));
                }
            } else {
                formatter = new SimpleDateFormat("yyyy");
                strSQLUpdate = "INSERT INTO refTUL62(bulan,tahun,notul60) VALUES ('" + Bulan + "', '" + formatter.format(new Date()) + "', 1)";
                cst = con.prepareCall(strSQLUpdate);
                cst.execute();
                JmlRec = 1;
            }

            //ambil data dari refverifikasi sebagai acuan untuk penerbitan WO
            //tambahkan ambil data kelompok_kerja
            Bln = lMapRecords.get(0).get("Bln");
            Thn = lMapRecords.get(0).get("Thn");
            if (Bln.substring(1, 1) == "0") {
                Bln = Bln.substring(2, 1);
            }

            strSQLRefVerifikasi = "Select Tahun,Bulan,Tanggal FROM refVerifikasi where upper(kategori)='" + strKategori + "'";
            strSQLRefVerifikasi = strSQLRefVerifikasi + " and KODE_INDUK_NUMERIK='" + strKodeInduk + "' and KODE_CABANG_NUMERIK='" + strKodeCabang + "'";
            strSQLRefVerifikasi = strSQLRefVerifikasi + " and KODE_RANTING_NUMERIK='" + strKodeRanting + "'";
            strSQLRefVerifikasi = strSQLRefVerifikasi + " and tahun=TO_CHAR(SYSDATE,'YYYY')";
            strSQLRefVerifikasi = strSQLRefVerifikasi + "and bulan='" + Bln + "'";

            cst = con.prepareCall(strSQLRefVerifikasi);
            rs = cst.executeQuery();
            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            String strTanggal = "";
            if (lMapRecords.size() > 0) {
                strTanggal = lMapRecords.get(0).get("BULAN") + "-" + lMapRecords.get(0).get("TANGGAL") + "-" + lMapRecords.get(0).get("TAHUN");
            }


            sql = " SELECT tul61.no_pelanggan,";
            sql = sql + " tul61.no_kontrak,";
            sql = sql + " tul61.uraian,";
            sql = sql + " tul61.nama_pelanggan,";
            sql = sql + " tul61.no_tul60, tul61.NOCETAKTUL601";
            sql = sql + " FROM TUL61 left outer join tul62";
            sql = sql + " on tul61.no_tul60 = tul62.no_tul60";
            sql = sql + " Where tul62.no_tul60 Is Null";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            for (Map<String, String> rowData : lMapRecords) {
                formatter = new SimpleDateFormat("MM/dd/yyyy");
                TglPerintahKerja = formatter.format(new Date());
                NoTul60 = TglPerintahKerja + "/" + "TULVI-01" + "/" + JmlRec;

                //insert data ke TUL62
                strSQLUpdate = "INSERT INTO TUL62(no_tul60,";
                strSQLUpdate = strSQLUpdate + " No_Pelanggan,No_Kontrak,";
                strSQLUpdate = strSQLUpdate + " Nama_Pelanggan,Tanggal_PK_Pemutusan,";
                strSQLUpdate = strSQLUpdate + " Pemutusan,Jenis_Tul60,";
                strSQLUpdate = strSQLUpdate + " Uraian)";
                strSQLUpdate = strSQLUpdate + " VALUES ('" + rowData.get("NO_TUL60") + "',";
                strSQLUpdate = strSQLUpdate + " '" + rowData.get("No_Pelanggan") + "','" + rowData.get("No_Kontrak") + "',";
                strSQLUpdate = strSQLUpdate + " '" + rowData.get("Nama_Pelanggan") + "',TO_DATE('" + TglPerintahKerja + "','mm-dd-yyyy'),";
                strSQLUpdate = strSQLUpdate + " 'Pemutusan','VI-01',";
                strSQLUpdate = strSQLUpdate + " '" + rowData.get("Uraian") + "')";

                cst = con.prepareCall(strSQLUpdate);
                cst.execute();

                JmlRec++;
            }

            //Update NoTUL60 di RefTUL61
            strSQLUpdate = "update refTUL61 set";
            strSQLUpdate = strSQLUpdate + " notul60='" + JmlRec + "'";

            cst = con.prepareCall(strSQLUpdate);
            cst.execute();


            blnReturn = true;

            retValue.put("wsReturn", blnReturn);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", blnReturn);
        }
        return retValue;
    }


    @Override
    public Map<String, Object> SetTUL63(String strKodeInduk,
                                        String strKodeCabang,
                                        String strKodeRanting) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();
        List<Map<String,String>> lMapRecordsProses = new ArrayList<Map<String,String>>();

        String strSQLUpdate, strSQLRefVerifikasi = "";
        String strKategori = "TUL603";
        String NoTul60, TglPerintahKerja;
        Integer Bulan, JmlRec;
        String Bln, Thn;

        Boolean blnReturn = false;

        SimpleDateFormat formatter = new SimpleDateFormat("MM");

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            ResultSet rs;
            String sql;

            //ambil nomor dari reftul61
            Bulan = Integer.parseInt(formatter.format(new Date()));
            sql = "Select refTUL61.*, TO_CHAR(SYSDATE,'YYYY') as Thn,TO_CHAR(SYSDATE,'MM') as BLN  FROM refTUL61";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            //ganti bulan ganti nomor
            if (lMapRecords.size() > 0) {
                if (Bulan != Integer.parseInt(lMapRecords.get(0).get("Bulan"))) {
                    formatter = new SimpleDateFormat("yyyy");
                    strSQLUpdate = "update refTUL63 set Bulan='" + Bulan + "', tahun='" + formatter.format(new Date()) + "', notul60=1";
                    cst = con.prepareCall(strSQLUpdate);
                    cst.execute();
                    JmlRec = 1;
                } else {
                    JmlRec = Integer.parseInt(lMapRecords.get(0).get("NOTUL60"));
                }
            } else {
                formatter = new SimpleDateFormat("yyyy");
                strSQLUpdate = "INSERT INTO refTUL63(bulan,tahun,notul60) VALUES ('" + Bulan + "', '" + formatter.format(new Date()) + "', 1)";
                cst = con.prepareCall(strSQLUpdate);
                cst.execute();
                JmlRec = 1;
            }

            //ambil data dari refverifikasi sebagai acuan untuk penerbitan WO
            //tambahkan ambil data kelompok_kerja
            Bln = lMapRecords.get(0).get("Bln");
            Thn = lMapRecords.get(0).get("Thn");
            if (Bln.substring(1, 1) == "0") {
                Bln = Bln.substring(2, 1);
            }

            strSQLRefVerifikasi = "Select Tahun,Bulan,Tanggal FROM refVerifikasi where upper(kategori)='" + strKategori + "'";
            strSQLRefVerifikasi = strSQLRefVerifikasi + " and KODE_INDUK_NUMERIK='" + strKodeInduk + "' and KODE_CABANG_NUMERIK='" + strKodeCabang + "'";
            strSQLRefVerifikasi = strSQLRefVerifikasi + " and KODE_RANTING_NUMERIK='" + strKodeRanting + "'";
            strSQLRefVerifikasi = strSQLRefVerifikasi + " and tahun=TO_CHAR(SYSDATE,'YYYY')";
            strSQLRefVerifikasi = strSQLRefVerifikasi + "and bulan='" + Bln + "'";

            cst = con.prepareCall(strSQLRefVerifikasi);
            rs = cst.executeQuery();
            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            String strTanggal = "";
            if (lMapRecords.size() > 0) {
                strTanggal = lMapRecords.get(0).get("BULAN") + "-" + lMapRecords.get(0).get("TANGGAL") + "-" + lMapRecords.get(0).get("TAHUN");
            }


            sql = "select DIS.No_Kontrak,DIL.No_Pelanggan,DIL.Nama_Pelanggan,DIS.Uraian FROM DIS,DIL ";
            sql = sql + " where DIS.No_Pelanggan=DIL.No_Pelanggan";
            sql = sql + " and Kode_Ranting_Numerik='" + strKodeRanting + "'";
            sql = sql + " and substr(DIL.Kode_Golongan,1,1)='0'";
            sql = sql + " and (TO_DATE('" + strTanggal + "','mm-dd-yyyy')- Tgl_Jatuh_Tempo)>=0";
            sql = sql + " and Uraian='BK III'";
            sql = sql + " and Lunas is NULL";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            for (Map<String, String> rowData : lMapRecords) {
                formatter = new SimpleDateFormat("MM/dd/yyyy");
                TglPerintahKerja = formatter.format(new Date());
                NoTul60 = TglPerintahKerja + "/" + "TULVI-02" + "/" + JmlRec;

                //insert data ke TUL63
                strSQLUpdate = "INSERT INTO TUL63(no_tul60,";
                strSQLUpdate = strSQLUpdate + " No_Pelanggan,No_Kontrak,";
                strSQLUpdate = strSQLUpdate + " Nama_Pelanggan,Tanggal_Perintah_Kerja,";
                strSQLUpdate = strSQLUpdate + " Pemutusan_Penyambungan,Jenis_Tul60,";
                strSQLUpdate = strSQLUpdate + " Uraian)";
                strSQLUpdate = strSQLUpdate + " VALUES ('" + NoTul60 + "',";
                strSQLUpdate = strSQLUpdate + " '" + rowData.get("No_Pelanggan") + "','" + rowData.get("No_Kontrak") + "',";
                strSQLUpdate = strSQLUpdate + " '" + rowData.get("Nama_Pelanggan") + "',TO_DATE('" + TglPerintahKerja + "','mm-dd-yyyy'),";
                strSQLUpdate = strSQLUpdate + " 'Pembongkaran','VI-03',";
                strSQLUpdate = strSQLUpdate + " '" + rowData.get("Uraian") + "')";

                cst = con.prepareCall(strSQLUpdate);
                cst.execute();

                JmlRec++;
            }

            //Update NoTUL60 di RefTUL61
            strSQLUpdate = "update refTUL61 set";
            strSQLUpdate = strSQLUpdate + " notul60='" + JmlRec + "'";

            cst = con.prepareCall(strSQLUpdate);
            cst.execute();


            blnReturn = true;

            retValue.put("wsReturn", blnReturn);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", blnReturn);
        }
        return retValue;
    }

    @Override
    public Map<String, Object> IsiTULVILAPORANSemuaTunggakan(String strKodeRanting) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();
        List<Map<String,String>> lMapRecordsProses = new ArrayList<Map<String,String>>();

        SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat formatterMonth = new SimpleDateFormat("MM");
        SimpleDateFormat formatterDay = new SimpleDateFormat("dd");

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            ResultSet rs;
            String sql;

            sql = "Delete TULVILaporanSemuaTunggakan";
            cst = con.prepareCall(sql);
            cst.execute();

            sql = "SELECT TUL61.No_Pelanggan, GrupNamaPiutang.GrupPiutang, dis.tgl_jatuh_tempo, ";
            sql = sql + "TO_CHAR(ADD_MONTHS(DIS.Tgl_Jatuh_Tempo,-1),'yyyy') as TahunRek, ";
            sql = sql + "TO_CHAR(ADD_MONTHS(DIS.Tgl_Jatuh_Tempo,-1),'mm') as BulanRek, ";
            sql = sql + "SUM(DIS.Mutasi) AS JmlRupiah ";
            sql = sql + "FROM TUL61 inner join dis on tul61.No_Pelanggan=dis.No_Pelanggan ";
            sql = sql + "inner join DIL on TUL61.No_Pelanggan=DIL.No_Pelanggan ";
            sql = sql + "inner join grupnamapiutang on dis.nmpiutang=grupnamapiutang.nmpiutang ";
            sql = sql + "where DIS.Lunas is NULL and DIL.Kode_Ranting_Numerik='" + strKodeRanting + "' ";
            sql = sql + "and substr(DIL.Kode_Golongan,1,1)='0' ";
            sql = sql + "and (grupnamapiutang.idrekening='1' or ";
            sql = sql + "grupnamapiutang.idrekening='2' or ";
            sql = sql + "grupnamapiutang.idrekening='9' or ";
            sql = sql + "grupnamapiutang.idrekening='14' or ";
            sql = sql + "grupnamapiutang.idrekening='8')";
            sql = sql + "group by tul61.no_Pelanggan,GrupNamaPiutang.GrupPiutang,DIS.Tgl_Jatuh_Tempo ";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            String strThBlRekening, ket, Nopel;
            String dsTanggal;

            if (lMapRecords.size() > 0) {
                dsTanggal = lMapRecords.get(0).get("Tgl_Jatuh_Tempo");

                for (Map<String, String> rowData : lMapRecords) {
                    String strblntemp;
                    if (rowData.get("BulanRek").length() > 1) {
                        strblntemp = rowData.get("BulanRek");
                    } else {
                        strblntemp = "0" + rowData.get("BulanRek");
                    }
                    strThBlRekening = rowData.get("TahunRek") + strblntemp;
                    ket = rowData.get("GrupPiutang");
                    Nopel = rowData.get("No_Pelanggan");

                    switch (rowData.get("GrupPiutang").toUpperCase()) {
                        case "REKENING" :
                            sql = "SELECT NO_PELANGGAN FROM TULVILAPORANsemuatunggakan WHERE TH_Bl_Rek = '" + strThBlRekening + "' AND NO_PELANGGAN='" + rowData.get("No_Pelanggan") + "'";
                            cst = con.prepareCall(sql);
                            rs = cst.executeQuery();
                            lMapRecordsProses = CommonModule.convertResultsetToListStr(rs);
                            if (lMapRecordsProses.size() == 0) {
                                sql = "Insert into TULVILAPORANsemuatunggakan (No_Pelanggan, TH_Bl_Rek, Tgl_Jatuh_Tempo, Rekening)";
                                sql = sql + " VALUES ('" + rowData.get("No_Pelanggan") + "', '" + strThBlRekening + "',to_date('" + formatterDay.format(dsTanggal) + "-" + formatterMonth.format(dsTanggal) + "-" + formatterYear.format(dsTanggal) + "','dd-mm-yyyy')," + rowData.get("JmlRupiah") + ")";
                            } else {
                                sql = "Update TULVILAPORANsemuatunggakan set Rekening = '" + rowData.get("JmlRupiah") + "' where TH_Bl_Rek = '" + strThBlRekening + "' AND NO_PELANGGAN='" + rowData.get("No_Pelanggan") + "'";
                            }
                            cst = con.prepareCall(sql);
                            cst.execute();
                            break;

                        case "PAJAK PENERANGAN JALAN UMUM" :
                            sql = "SELECT NO_PELANGGAN FROM TULVILAPORANsemuatunggakan WHERE TH_Bl_Rek = '" + strThBlRekening + "' AND NO_PELANGGAN='" + rowData.get("No_Pelanggan") + "'";
                            cst = con.prepareCall(sql);
                            rs = cst.executeQuery();
                            lMapRecordsProses = CommonModule.convertResultsetToListStr(rs);
                            if (lMapRecordsProses.size() == 0) {
                                sql = "Insert into TULVILAPORANsemuatunggakan (No_Pelanggan, TH_Bl_Rek, Tgl_Jatuh_Tempo, PPJU)";
                                sql = sql + " VALUES ('" + rowData.get("No_Pelanggan") + "', '" + strThBlRekening + "',to_date('" + formatterDay.format(dsTanggal) + "-" + formatterMonth.format(dsTanggal) + "-" + formatterYear.format(dsTanggal) + "','dd-mm-yyyy')," + rowData.get("JmlRupiah") + ")";
                            } else {
                                sql = "Update TULVILAPORANsemuatunggakan set PPJU = '" + rowData.get("JmlRupiah") + "' where TH_Bl_Rek = '" + strThBlRekening + "' AND NO_PELANGGAN='" + rowData.get("No_Pelanggan") + "'";
                            }
                            cst = con.prepareCall(sql);
                            cst.execute();
                            break;
                        case "BIAYA KETERLAMBATAN" :
                            sql = "SELECT NO_PELANGGAN, bk FROM TULVILAPORANsemuatunggakan WHERE TH_Bl_Rek = '" + strThBlRekening + "' AND NO_PELANGGAN='" + rowData.get("No_Pelanggan") + "'";
                            cst = con.prepareCall(sql);
                            rs = cst.executeQuery();
                            lMapRecordsProses = CommonModule.convertResultsetToListStr(rs);
                            if (lMapRecordsProses.size() == 0) {
                                sql = "Insert into TULVILAPORANsemuatunggakan (No_Pelanggan, TH_Bl_Rek, Tgl_Jatuh_Tempo, BK)";
                                sql = sql + " VALUES ('" + rowData.get("No_Pelanggan") + "', '" + strThBlRekening + "',to_date('" + formatterDay.format(dsTanggal) + "-" + formatterMonth.format(dsTanggal) + "-" + formatterYear.format(dsTanggal) + "','dd-mm-yyyy')," + rowData.get("JmlRupiah") + ")";
                            } else {
                                Integer RpBK1, RpBK2, Total;
                                RpBK1 = Integer.parseInt(lMapRecordsProses.get(0).get("BK"));
                                RpBK2 = Integer.parseInt(rowData.get("JmlRupiah"));
                                Total = (RpBK1 + RpBK2);
                                sql = "Update TULVILAPORANsemuatunggakan set BK = '" + Total + "' where TH_Bl_Rek = '" + strThBlRekening + "' AND NO_PELANGGAN='" + rowData.get("No_Pelanggan") + "'";
                            }
                            cst = con.prepareCall(sql);
                            cst.execute();
                            break;
                        case "MATERAI REKENING" :
                            sql = "SELECT NO_PELANGGAN FROM TULVILAPORANsemuatunggakan WHERE TH_Bl_Rek = '" + strThBlRekening + "' AND NO_PELANGGAN='" + rowData.get("No_Pelanggan") + "'";
                            cst = con.prepareCall(sql);
                            rs = cst.executeQuery();
                            lMapRecordsProses = CommonModule.convertResultsetToListStr(rs);
                            if (lMapRecordsProses.size() == 0) {
                                sql = "Insert into TULVILAPORANsemuatunggakan (No_Pelanggan, TH_Bl_Rek, Tgl_Jatuh_Tempo, MateraiRekening)";
                                sql = sql + " VALUES ('" + rowData.get("No_Pelanggan") + "', '" + strThBlRekening + "',to_date('" + formatterDay.format(dsTanggal) + "-" + formatterMonth.format(dsTanggal) + "-" + formatterYear.format(dsTanggal) + "','dd-mm-yyyy')," + rowData.get("JmlRupiah") + ")";
                            } else {
                                sql = "Update TULVILAPORANsemuatunggakan set MateraiRekening = '" + rowData.get("JmlRupiah") + "' where TH_Bl_Rek = '" + strThBlRekening + "' AND NO_PELANGGAN='" + rowData.get("No_Pelanggan") + "'";
                            }
                            cst = con.prepareCall(sql);
                            cst.execute();
                            break;
                        case "PPN" :
                            sql = "SELECT NO_PELANGGAN FROM TULVILAPORANsemuatunggakan WHERE TH_Bl_Rek = '" + strThBlRekening + "' AND NO_PELANGGAN='" + rowData.get("No_Pelanggan") + "'";
                            cst = con.prepareCall(sql);
                            rs = cst.executeQuery();
                            lMapRecordsProses = CommonModule.convertResultsetToListStr(rs);
                            if (lMapRecordsProses.size() == 0) {
                                sql = "Insert into TULVILAPORANsemuatunggakan (No_Pelanggan, TH_Bl_Rek, Tgl_Jatuh_Tempo, PPN)";
                                sql = sql + " VALUES ('" + rowData.get("No_Pelanggan") + "', '" + strThBlRekening + "',to_date('" + formatterDay.format(dsTanggal) + "-" + formatterMonth.format(dsTanggal) + "-" + formatterYear.format(dsTanggal) + "','dd-mm-yyyy') ," + rowData.get("JmlRupiah") + ")";
                            } else {
                                sql = "Update TULVILAPORANsemuatunggakan set PPN = '" + rowData.get("JmlRupiah") + "' where TH_Bl_Rek = '" + strThBlRekening + "' AND NO_PELANGGAN='" + rowData.get("No_Pelanggan") + "'";
                            }
                            cst = con.prepareCall(sql);
                            cst.execute();
                            break;
                    }
                }
            }

            retValue.put("wsReturn", true);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
        }
        return retValue;
    }
}
