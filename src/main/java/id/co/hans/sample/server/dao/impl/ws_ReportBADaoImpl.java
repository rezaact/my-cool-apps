package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.cls_ReportBA;
import id.co.hans.sample.server.dao.ws_ReportBADao;
import id.co.hans.sample.server.utility.CommonModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

@Service
public class ws_ReportBADaoImpl implements ws_ReportBADao{
    public static final Log log = LogFactory.getLog(ws_ReportBADaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> ambilUnitPetugas(String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_ReportBA ba = new cls_ReportBA();
        retValue = ba.ambilUnitPetugas(petugas);

        return retValue;
    }

    @Override
    public Map<String, Object> rptVIEW_BA21_Upload(String unitup, String tgltransaksi, String tglbayar, String kdpp, String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_ReportBA ba = new cls_ReportBA();
        retValue = ba.rptVIEW_BA21_Upload(unitup, tgltransaksi, tglbayar, kdpp, transaksiby);

        return retValue;
    }


    @Override
    public Map<String, Object> rptVIEW_BA21_Entri(String unitup, String tgltransaksi, String tglbayar, String kdpp, String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_ReportBA ba = new cls_ReportBA();
        retValue = ba.rptVIEW_BA21_Entri(unitup, tgltransaksi, tglbayar, kdpp, transaksiby);

        return retValue;
    }


    @Override
    public Map<String, Object> rptVIEW_BA21Daftar_Entri(String unitup, String tgltransaksi, String tglbayar, String kdpp, String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_ReportBA ba = new cls_ReportBA();
        retValue = ba.rptVIEW_BA21Daftar_Entri(unitup, tgltransaksi, tglbayar, kdpp, transaksiby);

        return retValue;
    }


    @Override
    public Map<String, Object> rptVIEW_BADENDA(String unitup, String tgltransaksi, String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_ReportBA ba = new cls_ReportBA();
        retValue = ba.rptVIEW_BADENDA(unitup, tgltransaksi, transaksiby);

        return retValue;
    }

    @Override
    public Map<String, Object> rptVIEW_BA11(String unitUp, String siklis, String blth, Date tempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_ReportBA ba = new cls_ReportBA();
        retValue = ba.rptVIEW_BA11(unitUp, siklis, blth, tempo);

        return retValue;
    }

    // ----tambahan sumbar sorek oratoora
    @Override
    public Map<String, Object> rptVIEW_BA13upload(String unitUp, String siklis, String blth, Date tempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_ReportBA ba = new cls_ReportBA();
        retValue = ba.rptVIEW_BA13upload(unitUp, siklis, blth, tempo);

        return retValue;
    }
    // ----end tambahan sumbar sorek oratoora

    // TAMBAHAN CICILAN REKENING
    @Override
    public Map<String, Object> rpt_BA_CicilanRek(String petugas, String idpel, String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_ReportBA ba = new cls_ReportBA();
        retValue = ba.rpt_BA_CicilanRek(petugas, idpel, blth);

        return retValue;
    }
    // END TAMBAHAN CICILAN REKENING

    //======BA KIRIM UNIT--
    @Override
    public Map<String, Object> rpt_BA_23KirimUnit(String tPetugas, String tUnitKirim, String tTglKirim) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_ReportBA ba = new cls_ReportBA();
        retValue = ba.rpt_BA_23KirimUnit(tPetugas, tUnitKirim, tTglKirim);

        return retValue;
    }
    //======END BA KIRIM UNIT

    //=== BA TERIMA UNIT ===
    @Override
    public Map<String, Object> rpt_BA_23TerimaUnit(String tPetugas, String tUnitKirim, String tTglKirim) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_ReportBA ba = new cls_ReportBA();
        retValue = ba.rpt_BA_23TerimaUnit(tPetugas, tUnitKirim, tTglKirim);

        return retValue;
    }
    //=== END BA TERIMA UNIT

    //BA Koreksi Rekening
    @Override
    public Map<String, Object> rpt_BA_12KoreksiRekening(String tIDPEL, String tBLTH) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_ReportBA ba = new cls_ReportBA();
        retValue = ba.rpt_BA_12KoreksiRekening(tIDPEL, tBLTH);

        return retValue;
    }


    @Override
    public Map<String, Object> rpt_BA23Pusat_Daftar(String tglBayar, String petugas, String kode, String kdkirim) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_ReportBA ba = new cls_ReportBA();
        retValue = ba.rpt_BA23Pusat_Daftar(tglBayar, petugas, kode, kdkirim);

        return retValue;
    }

    //Kuitansi Resup
    @Override
    public Map<String, Object> rpt_Kuitansi_RESUP(String tIDPEL) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_ReportBA ba = new cls_ReportBA();
        retValue = ba.rpt_Kuitansi_RESUP(tIDPEL);

        return retValue;
    }
}
