package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.ws_502Dao;
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
public class ws_502DaoImpl implements ws_502Dao {
    public static final Log log = LogFactory.getLog(ws_502DaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> ambilLaporanV02(String parUp, String parGol, String thbl, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        Map<String, Object> retFunc = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            String view="", kriteria="", namaUnit="";
            retFunc = IsAp(parUp);

            if (parUp.length() == 5) {
                if ((Boolean)retFunc.get("wsReturn")) {
                    namaUnit = "AP";
                    if (parGol == "Semua") {
                        view = "VIEW_REPORT_TUL502APGAB";
                        kriteria = " WHERE UNITUP = '" + parUp + "' ";
                        kriteria += " AND THBLLAPORAN = '" + thbl + "' ";
                    } else {
                        view = "VIEW_REPORT_TUL502APGOL";
                        kriteria = " WHERE UNITUP = '" + parUp + "' ";
                        kriteria += " AND GOL = '" + parGol + "' ";
                        kriteria += " AND THBLLAPORAN = '" + thbl + "' ";
                    }
                } else {
                    namaUnit = "UP";
                    if (parGol == "Semua") {
                        view = "VIEW_REPORT_TUL502UPGAB";
                        kriteria = " WHERE UNITUP = '" + parUp + "' ";
                        kriteria += " AND THBLLAPORAN = '" + thbl + "' ";
                    } else {
                        parGol = parGol.substring(1,1);
                        view = "VIEW_REPORT_TUL502UPGOL";
                        kriteria = " WHERE UNITUP = '" + parUp + "' ";
                        kriteria += " AND GOL = '" + parGol + "' ";
                        kriteria += " AND THBLLAPORAN = '" + thbl + "' ";
                    }
                }
            } else {
                namaUnit = "UPI";
                if (parGol == "Semua") {
                    view = "VIEW_REPORT_TUL502UPIGAB";
                    kriteria = " WHERE UNITUP = '" + parUp + "' ";
                    kriteria += " AND THBLLAPORAN = '" + thbl + "' ";
                } else {
                    parGol = parGol.substring(1,1);
                    view = "VIEW_REPORT_TUL502UPIGOL";
                    kriteria = " WHERE UNITUP = '" + parUp + "' ";
                    kriteria += " AND GOL = '" + parGol + "' ";
                    kriteria += " AND THBLLAPORAN = '" + thbl + "' ";
                }
            }


            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select ";

            sql += " TGLCETAK, UNITUP, THBLLAPORAN, GOL, NOMOR, KDGOL, TANGGALKALENDER, NOKALENDER, LEMBAR_TAMBAH, RPPTL_TAMBAH, RPTB_TAMBAH, RPPPN_TAMBAH, RPBPJU_TAMBAH, RPBPTRAFO_TAMBAH, RPANGSURANA_TAMBAH, RPANGSURANB_TAMBAH, RPANGSURANC_TAMBAH, RPMATERAI_TAMBAH, RPPLN_TAMBAH, RPTAGIHAN_TAMBAH, RPPRODUKSI_TAMBAH, RPSUBSIDI_TAMBAH, RPINSENTIF_TAMBAH, RPDISINSENTIF_TAMBAH, RPBK1_TAMBAH, RPBK2_TAMBAH, RPBK3_TAMBAH, RPSELISIH_TAMBAH, RPREDUKSI_TAMBAH, LEMBAR_LUNAS, RPPTL_LUNAS, RPTB_LUNAS, RPPPN_LUNAS, RPBPJU_LUNAS, RPBPTRAFO_LUNAS, RPANGSURANA_LUNAS, RPANGSURANB_LUNAS, RPANGSURANC_LUNAS, RPMATERAI_LUNAS, RPPLN_LUNAS, RPTAGIHAN_LUNAS, RPPRODUKSI_LUNAS, RPSUBSIDI_LUNAS, RPINSENTIF_LUNAS, RPDISINSENTIF_LUNAS, RPBK1_LUNAS, RPBK2_LUNAS, RPBK3_LUNAS, RPSELISIH_LUNAS, RPREDUKSI_LUNAS, LEMBAR_KURANG, RPPTL_KURANG, RPTB_KURANG, RPPPN_KURANG, RPBPJU_KURANG, RPBPTRAFO_KURANG, RPANGSURANA_KURANG, RPANGSURANB_KURANG, RPANGSURANC_KURANG, RPMATERAI_KURANG, RPPLN_KURANG, RPTAGIHAN_KURANG, RPPRODUKSI_KURANG, RPSUBSIDI_KURANG, RPINSENTIF_KURANG, RPDISINSENTIF_KURANG, RPBK1_KURANG, RPBK2_KURANG, RPBK3_KURANG, RPSELISIH_KURANG, RPREDUKSI_KURANG, LEMBAR_AKHIR, RPPTL_AKHIR, RPTB_AKHIR, RPPPN_AKHIR, RPBPJU_AKHIR, RPBPTRAFO_AKHIR, RPANGSURANA_AKHIR, RPANGSURANB_AKHIR, RPANGSURANC_AKHIR, RPMATERAI_AKHIR, RPPLN_AKHIR, RPTAGIHAN_AKHIR, RPPRODUKSI_AKHIR, RPSUBSIDI_AKHIR, RPINSENTIF_AKHIR, RPDISINSENTIF_AKHIR, RPBK1_AKHIR, RPBK2_AKHIR, RPBK3_AKHIR, RPSELISIH_AKHIR, RPREDUKSI_AKHIR, TANGGALENTRI ";
            sql += " from ";
            sql += view;
            sql += kriteria;

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);
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
    public Map<String, Object> IsAp(String Unit) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SELECT COUNT(*) AS HASIL FROM UNITAP WHERE UNITAP='" + Unit + "'";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            if (lMapRecords.size() == 0) {
                retValue.put("wsReturn", false);
            } else {
                retValue.put("wsReturn", true);
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
