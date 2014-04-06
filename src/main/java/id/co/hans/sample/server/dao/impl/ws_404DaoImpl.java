package id.co.hans.sample.server.dao.impl;

import id.co.hans.sample.server.dao.clsTransaksi_Proc;
import id.co.hans.sample.server.dao.ws_404Dao;
import id.co.hans.sample.server.utility.CommonModule;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ws_404DaoImpl implements ws_404Dao {

    public static final Log log = LogFactory.getLog(ws_404DaoImpl.class);

    @Autowired
    private JdbcTemplate  jdbcTemplate;

    @Override
    public Map<String, Object> cekTabel404(String petugas, String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " SELECT * FROM T_404 ";

            sql += " WHERE PETUGAS = '" + petugas + "' AND THBL= '" + thbl + "' ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;
    }

    @Override
    public Map<String, Object> ambilUnsur404() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "select  distinct ID, unsur from t_kode_unsur ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;
    }

    @Override
    public Map<String, Object> ambilUnsur404_Baru() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select distinct nourut,group_unsur unsur ";
            sql += " from t_404unsur ";
            sql += " order by nourut ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;
    }

    @Override
    public Map<String, Object> verifikasi404_hapus(String thbl, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "delete t_404 where petugas='" + petugas + "' and thbl='" + thbl + "' ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            cst.execute();

            retValue.put("wsReturn", true);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            retValue.put("wsReturn", false);
        }
        return retValue;
    }

    @Override
    public Map<String, Object> verifikasi404_pengurangan(String thbl, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="{ call PROC_404pengurangan(?,?) }";
            CallableStatement cst;
            cst = con.prepareCall(sql);
            cst.setString("THBL", thbl);
            cst.setString("PETUGAS", petugas);

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
    public Map<String, Object> verifikasi404_penambahan(String thbl, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="{ call PROC_404penambahan(?,?) }";
            CallableStatement cst;
            cst = con.prepareCall(sql);
            cst.setString("THBL", thbl);
            cst.setString("PETUGAS", petugas);

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
    public Map<String, Object> verifikasi404_saldoawal(String thbl, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "{ call PROC_404saldoawal(?,?) }";
            CallableStatement cst;
            cst = con.prepareCall(sql);
            cst.setString("THBL", thbl);
            cst.setString("PETUGAS", petugas);

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
    public Map<String, Object> verifikasi404_saldoakhir(String thbl, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "{ call PROC_404saldoakhir(?,?) }";
            CallableStatement cst;
            cst = con.prepareCall(sql);
            cst.setString("THBL", thbl);
            cst.setString("PETUGAS", petugas);

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
    public Map<String, Object> ambilLaporan(String parUp, String parUnsur, String thbl, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql;

            if (parUp.length() == 5) {
                if (parUnsur == "Semua") {
                    sql = "SELECT b.HEADER1,b.HEADER2,b.HEADER3,b.HEADER4, ";
                    sql += " b.kode,a.keterangan,'CABANG' unit,'" + thbl + "' thbl,'GABUNGAN' unsur,PETUGAS,";
                    sql += " nvl(sum(lbr0),0) lbr0, nvl(sum(rp0),0) rp0, nvl(sum(lbr1),0) lbr1, ";
                    sql += " nvl(sum(rp1),0) rp1, nvl(sum(lbr2),0) lbr2, nvl(sum(rp2),0) rp2, nvl(sum(lbr3),0) lbr3, nvl(sum(rp3),0) rp3, ";
                    sql += " nvl(sum(lbr4),0) lbr4, nvl(sum(rp4),0) rp4, nvl(sum(lbr5),0) lbr5, nvl(sum(rp5),0) rp5, isposting, to_char(tanggal,'dd/mm/yyyy') tanggal, ";
                    sql += " '" + petugas + "' TEMP1,'' TEMP2,'' TEMP3,'' TEMP4,'' TEMP5 ";
                    sql += " from (select * from T_404 where unit='" + parUp + "' and thbl='" + thbl + "' ";
                    //sql += " and petugas='" + petugas + "' ";
                    sql += " ) a";
                    sql += " ,T_FORMAT_404 b ";
                    sql += " where  a.kode(+)=b.kode ";
                    sql += " group by b.HEADER1,b.HEADER2,b.HEADER3,b.HEADER4, ";
                    sql += " b.kode,a.keterangan,PETUGAS,isposting,tanggal ";
                    sql += " ORDER BY b.kode ";
                } else {
                    sql = "SELECT b.HEADER1,b.HEADER2,b.HEADER3,b.HEADER4, ";
                    sql += " b.kode,a.keterangan,'CABANG' unit,'" + thbl + "' thbl,'" + parUnsur + "' unsur,PETUGAS,";
                    sql += " nvl(sum(lbr0),0) lbr0, nvl(sum(rp0),0) rp0, nvl(sum(lbr1),0) lbr1, ";
                    sql += " nvl(sum(rp1),0) rp1, nvl(sum(lbr2),0) lbr2, nvl(sum(rp2),0) rp2, nvl(sum(lbr3),0) lbr3, nvl(sum(rp3),0) rp3, ";
                    sql += " nvl(sum(lbr4),0) lbr4, nvl(sum(rp4),0) rp4, nvl(sum(lbr5),0) lbr5, nvl(sum(rp5),0) rp5, isposting, to_char(tanggal,'dd/mm/yyyy') tanggal, ";
                    sql += " '" + petugas + "' TEMP1,'' TEMP2,'' TEMP3,'' TEMP4,'' TEMP5 ";
                    sql += " from (select * from T_404 ";
                    sql += " WHERE unit='" + parUp + "' and  unsur='" + parUnsur + "' ";
                    //sql += " and petugas='" + petugas + "' "
                    sql += " and thbl='" + thbl + "' ) a";
                    sql += " ,T_FORMAT_404 b ";
                    sql += " where  a.kode(+)=b.kode ";
                    sql += " group by b.HEADER1,b.HEADER2,b.HEADER3,b.HEADER4, ";
                    sql += " b.kode,a.keterangan,PETUGAS,isposting,tanggal ";
                    sql += " ORDER BY b.kode ";
                }
            } else {
                String sTableName = "";
                if (parUp.length() == 2) {
                    sTableName = "T_404UPI";
                } else {
                    sTableName = "T_404";
                }

                if (parUnsur == "Semua") {
                    sql = "SELECT b.HEADER1,b.HEADER2,b.HEADER3,b.HEADER4, ";
                    sql += " b.kode,a.keterangan,'" + parUp + "' unit,'" + thbl + "' thbl,'GABUNGAN' unsur,PETUGAS,";
                    sql += " nvl(sum(lbr0),0) lbr0, nvl(sum(rp0),0) rp0, nvl(sum(lbr1),0) lbr1, ";
                    sql += " nvl(sum(rp1),0) rp1, nvl(sum(lbr2),0) lbr2, nvl(sum(rp2),0) rp2, nvl(sum(lbr3),0) lbr3, nvl(sum(rp3),0) rp3, ";
                    sql += " nvl(sum(lbr4),0) lbr4, nvl(sum(rp4),0) rp4, nvl(sum(lbr5),0) lbr5, nvl(sum(rp5),0) rp5, isposting, to_char(tanggal,'dd/mm/yyyy') tanggal, ";
                    sql += " '" + petugas + "' TEMP1,'' TEMP2,'' TEMP3,'' TEMP4,'' TEMP5 ";
                    sql += " from (select * from " + sTableName;
                    sql += " WHERE unit='" + parUp + "' ";
                    sql += " and thbl='" + thbl + "') a";
                    sql += " ,T_FORMAT_404 b ";
                    sql += " where  a.kode(+)=b.kode ";
                    sql += " group by b.HEADER1,b.HEADER2,b.HEADER3,b.HEADER4, ";
                    sql += " b.kode,a.keterangan,PETUGAS,isposting,tanggal ";
                    sql += " ORDER BY b.kode ";
                } else {
                    sql = "SELECT b.HEADER1,b.HEADER2,b.HEADER3,b.HEADER4, ";
                    sql += " b.kode,a.keterangan,'" + parUp + "' unit,'" + thbl + "' thbl,'" + parUnsur + "' unsur,PETUGAS,";
                    sql += " nvl(sum(lbr0),0) lbr0, nvl(sum(rp0),0) rp0, nvl(sum(lbr1),0) lbr1, ";
                    sql += " nvl(sum(rp1),0) rp1, nvl(sum(lbr2),0) lbr2, nvl(sum(rp2),0) rp2, nvl(sum(lbr3),0) lbr3, nvl(sum(rp3),0) rp3, ";
                    sql += " nvl(sum(lbr4),0) lbr4, nvl(sum(rp4),0) rp4, nvl(sum(lbr5),0) lbr5, nvl(sum(rp5),0) rp5, isposting, to_char(tanggal,'dd/mm/yyyy') tanggal ,";
                    sql += " '" + petugas + "' TEMP1,'' TEMP2,'' TEMP3,'' TEMP4,'' TEMP5 ";
                    sql += " from (select * from  " + sTableName;
                    sql += " WHERE unit='" + parUp + "' and unsur='" + parUnsur + "' ";
                    //sql += " and petugas='" + petugas + "' ";
                    sql += " and thbl='" + thbl + "') a";
                    sql += " ,T_FORMAT_404 b ";
                    sql += " where  a.kode(+)=b.kode ";
                    sql += " group by b.HEADER1,b.HEADER2,b.HEADER3,b.HEADER4, "; // a.* ";
                    sql += " b.kode,a.keterangan,PETUGAS,isposting,tanggal ";
                    sql += " ORDER BY b.kode ";
                }
            }

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;
    }

    @Override
    public Map<String, Object> ambilLaporan404(String parUp, String parUnsur, String thbl, String petugas, String pembukuan, String satuan, String Err) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql = "";

            sql = "{ call SIP3SINGLE_AP2T.PARAMETERVIEW.SetBLTH(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, thbl);
            cst.execute();

            sql = "{ call SIP3SINGLE_AP2T.PARAMETERVIEW.SetUNITUP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, parUp);
            cst.execute();

            sql = "{ call SIP3SINGLE_AP2T.PARAMETERVIEW.SetKDKIRIM(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, parUnsur.toUpperCase());
            cst.execute();

            sql = "{ call SIP3SINGLE_AP2T.PARAMETERVIEW.SetKDTERIMA(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, pembukuan);
            cst.execute();

            sql = "{ call SIP3SINGLE_AP2T.PARAMETERVIEW.SetPETUGAS(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, petugas);
            cst.execute();

            sql = "{ call SIP3SINGLE_AP2T.PARAMETERVIEW.SetKODEPP(?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, satuan);
            cst.execute();



            sql = "SELECT * FROM SIP3SINGLE_AP2T.VIEW_REPORT404 ";
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;
    }

    @Override
    public Map<String, Object> RekapUlang404(String parBLTH, String parUnit, String parPetugas, String parJenisTrans, String parSatuan) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            clsTransaksi_Proc cProc = new clsTransaksi_Proc();

            String sJenis[] = parJenisTrans.split(",");
            for (String rowData : sJenis) {
                if (rowData.toLowerCase().equals("sorek") ) {
                    retValue = cProc.setLap_f_404_inserttemp(parBLTH, parUnit, parPetugas, "sorekbaru");
                }

                if (!String.valueOf(retValue.get("wsByRefError")).equals(""))
                    throw new Exception(String.valueOf(retValue.get("wsByRefError")));

                if (rowData.toLowerCase().equals("koreksi") ) {
                    retValue = cProc.setLap_f_404_inserttemp(parBLTH, parUnit, parPetugas, "dkrplama");
                    retValue = cProc.setLap_f_404_inserttemp(parBLTH, parUnit, parPetugas, "dkrpbaru");
                }

                if (!String.valueOf(retValue.get("wsByRefError")).equals(""))
                    throw new Exception(String.valueOf(retValue.get("wsByRefError")));

                if (rowData.toLowerCase().equals("susulan") ) {
                    retValue = cProc.setLap_f_404_inserttemp(parBLTH, parUnit, parPetugas, "soreksusulan");
                }

                if (!String.valueOf(retValue.get("wsByRefError")).equals(""))
                    throw new Exception(String.valueOf(retValue.get("wsByRefError")));

                if (rowData.toLowerCase().equals("dphoffline") ) {
                    retValue = cProc.setLap_f_404_inserttemp(parBLTH, parUnit, parPetugas, "dphoffline");
                }

                if (!String.valueOf(retValue.get("wsByRefError")).equals(""))
                    throw new Exception(String.valueOf(retValue.get("wsByRefError")));

                if (rowData.toLowerCase().equals("dphbaru") ) {
                    retValue = cProc.setLap_f_404_inserttemp(parBLTH, parUnit, parPetugas, "dphbaru");
                }

                if (!String.valueOf(retValue.get("wsByRefError")).equals(""))
                    throw new Exception(String.valueOf(retValue.get("wsByRefError")));

                if (rowData.toLowerCase().equals("dphnota") ) {
                    retValue = cProc.setLap_f_404_inserttemp(parBLTH, parUnit, parPetugas, "dphnota");
                }

                if (!String.valueOf(retValue.get("wsByRefError")).equals(""))
                    throw new Exception(String.valueOf(retValue.get("wsByRefError")));

                if (rowData.toLowerCase().equals("dltbaru") ) {
                    retValue = cProc.setLap_f_404_inserttemp(parBLTH, parUnit, parPetugas, "dltbaru");
                }

                if (!String.valueOf(retValue.get("wsByRefError")).equals(""))
                    throw new Exception(String.valueOf(retValue.get("wsByRefError")));

                if (rowData.toLowerCase().equals("dphresup") ) {
                    retValue = cProc.setLap_f_404_inserttemp(parBLTH, parUnit, parPetugas, "dphresup");
                }
                if (rowData.toLowerCase().equals("kirimterima") ) {
                    retValue = cProc.setLap_f_404_inserttemp(parBLTH, parUnit, parPetugas, "dppkirimbaru");
                    retValue = cProc.setLap_f_404_inserttemp(parBLTH, parUnit, parPetugas, "dppterima");
                }

                if (!String.valueOf(retValue.get("wsByRefError")).equals(""))
                    throw new Exception(String.valueOf(retValue.get("wsByRefError")));

                if (rowData.toLowerCase().equals("dbpbaru") ) {
                    retValue = cProc.setLap_f_404_inserttemp(parBLTH, parUnit, parPetugas, "dbpbaru");
                }

                if (!String.valueOf(retValue.get("wsByRefError")).equals(""))
                    throw new Exception(String.valueOf(retValue.get("wsByRefError")));

                if (rowData.toLowerCase().equals("bk") ) {
                    retValue = cProc.setLap_f_404_inserttemp(parBLTH, parUnit, parPetugas, "dppbkbaru");
                }

                if (!String.valueOf(retValue.get("wsByRefError")).equals(""))
                    throw new Exception(String.valueOf(retValue.get("wsByRefError")));


                if (String.valueOf(retValue.get("wsByRefError")).equals("")) {
                    retValue = cProc.setLap_f_404_insert404new(parBLTH, parUnit, parPetugas, parSatuan);
                }

                if (!String.valueOf(retValue.get("wsByRefError")).equals(""))
                    throw new Exception(String.valueOf(retValue.get("wsByRefError")));

            }
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", "Exception:" + ex.getMessage());
        }
        return retValue;
    }
}
