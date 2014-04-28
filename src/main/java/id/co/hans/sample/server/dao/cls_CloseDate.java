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
public class Cls_CloseDate {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> ValidasiClosedate(String KodeTrans, String sTglBuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;
            ResultSet rs;


            sql = " SELECT * FROM CLOSEDATE WHERE KODETRANSAKSI='" + KodeTrans + "'";
            sql += "  AND " + Integer.parseInt(sTglBuku.substring(6,2)) + " BETWEEN TGLBUKUAWAL AND TGLBUKUAKHIR ";
            sql += " ORDER BY CLOSEDATE DESC ";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() > 0) { //sudah ada di master belum range tanggal tersebut
                //GetSysdate
                Calendar sysdate = Calendar.getInstance();

                if (Integer.parseInt(lMapData.get(0).get("CLOSEDATE").toString()) < Integer.parseInt(lMapData.get(0).get("TGLBUKUAKHIR").toString())) {  //BERARTI CLOSE DATE NYA LINTAS BULAN
                    Calendar dTglBuku = Calendar.getInstance();
                    dTglBuku.set(
                            Integer.parseInt(sTglBuku.substring(0,4)),
                            Integer.parseInt(sTglBuku.substring(4,2)),
                            Integer.parseInt(sTglBuku.substring(6,2))
                    );

                    if (
                            (Integer.parseInt(sTglBuku.substring(6,2)) >= Integer.parseInt(lMapData.get(0).get("TGLBUKUAWAL").toString()))
                            && (sysdate.get(Calendar.MONTH) - dTglBuku.get(Calendar.MONTH) == 0)
                       ) {
                        retValue.put("wsReturn", true);
                        retValue.put("wsByRefError", "");
                    } else {
                        Calendar dCloseDate = Calendar.getInstance();
                        dCloseDate.set(
                                sysdate.get(Calendar.YEAR),
                                sysdate.get(Calendar.MONTH),
                                Integer.parseInt(lMapData.get(0).get("CLOSEDATE").toString())
                        );

                        if ((dTglBuku.before(dCloseDate)) || (dTglBuku.equals(dCloseDate))) {
                            if (dTglBuku.get(Calendar.MONTH) - sysdate.get(Calendar.MONTH) == 1) {
                                retValue.put("wsReturn", true);
                                retValue.put("wsByRefError", "");
                            } else {
                                throw new Exception("Sudah melewati close date untuk tanggal buku tersebut !");
                            }
                        } else {
                            throw new Exception("Sudah melewati close date untuk tanggal buku tersebut !");
                        }
                    }
                } else {
                    //apakah tanggal sekarang kuran dari close date transaksi bersangkutan ?
                    if (sysdate.get(Calendar.DAY_OF_MONTH) <= Integer.parseInt(lMapData.get(0).get("CLOSEDATE").toString())) {
                        //cek dulu bulannya, sama ngak ?
                        if (Integer.parseInt(sTglBuku.substring(6,2)) == sysdate.get(Calendar.MONTH)) {
                            retValue.put("wsReturn", true);
                            retValue.put("wsByRefError", "");
                        } else {
                            throw new Exception("Transaksi lintas bulan tidak boleh lebih dari 1 bulan !");
                        }
                    } else {
                        throw new Exception("Sudah melewati close date, Transaksi tidak bisa dilakukan !");
                    }
                }
            } else {
                throw new Exception("KODE TRANSAKSI " + KodeTrans + " dengan range yang dimaksud tidak ditemukan !" + "<br>" + " Hubungi Admin Anda !");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> CekCloseDate(String KodeTrans, String sTglBuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;
            ResultSet rs;


            sql = "{ ? = call FUNC_VALIDASICLOSEDATE(?,?,?) }";
            cst = con.prepareCall(sql);
            cst.registerOutParameter(1, OracleTypes.BIGINT);
            cst.setString(2, KodeTrans);
            cst.setString(3, sTglBuku);
            cst.registerOutParameter(4, OracleTypes.NVARCHAR);
            cst.execute();

            Integer iFuncReturn = cst.getInt(1);

            if (iFuncReturn == 1) {
                retValue.put("wsReturn", true);
                retValue.put("wsByRefError", "");
            } else {
                retValue.put("wsReturn", false);
                retValue.put("wsByRefError", cst.getString(4));
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }
}
