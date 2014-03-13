package id.co.hans.sample.server.service;

import id.co.hans.sample.server.dao.ReportDao;
import java.sql.ResultSet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inet.report.Engine;

@Service
public class ReportService {

    @Autowired
    private ReportDao reportDao;

    public void getLapRekapDimukaLPB(Engine engine, String unitupi, String unitap, String unitup, String jenislap, String thbl){
        reportDao.getLapRekapDimukaLPB(engine, unitupi, unitap, unitup, jenislap, thbl);
    }

    public void getLapUnitPerThbl(Engine engine, String unitupi, String unitap, String unitup, String jenislap, String thbl){
        reportDao.getLapUnitPerThbl(engine, unitupi, unitap, unitup, jenislap, thbl);
    }

    public void getLapSaldoBP(Engine engine, String unitupi, String unitap, String unitup, String thbl){
        reportDao.getLapSaldoBP(engine, unitupi, unitap, unitup, thbl);
    }

    public void getInvoiceMultiTarifByIdpelThblrek(Engine engine, String idpel, String thblrek){
        reportDao.getInvoiceMultiTarifByIdpelThblrek(engine, idpel, thblrek);
    }

    public void getMasterPlgMultiTarifByUnitThbl(Engine engine, String unitupi, String unitap, String unitup, String thbl){
        reportDao.getMasterPlgMultiTarifByUnitThbl(engine, unitupi, unitap, unitup, thbl);
    }

    // 11
    public void GetReport_11rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                  String kode, String tparAP, String in_unitupi) {
        reportDao.GetReport_11rekap(engine, vJenis, tBLTH, tparUp, tPetugas,
                                    kode, tparAP, in_unitupi);
    }

    public void cetak_rekap11TglUpload(Engine engine, String tparUp, String tglAwal, String tglAkhir) {
        reportDao.cetak_rekap11TglUpload(engine, tparUp, tglAwal, tglAkhir);
    }

    //12
    public void GetReport_12rekapGabungan(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                          String kode, String tparAP, String in_unitupi) {
        reportDao.GetReport_12rekapGabungan(engine, vJenis, tBLTH, tparUp, tPetugas,
                                            kode, tparAP, in_unitupi);
    }

    //13
    public void GetReport_13rekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp,
                                  String tPetugas) {
        reportDao.GetReport_13rekap(engine, vJenis, tBLTH, tparAp, tparUp,
                                    tPetugas);
    }

    //21
    public void GetReport_21_BA(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                String tanggal, String tanggalend, String kode, String pengelola) {
        reportDao.GetReport_21_BA(engine, vJenis, tBLTH, tparUp, tPetugas,
                                  tanggal, tanggalend, kode, pengelola);
    }
    public void GetReport_21kdpp(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                 String tanggal, String tanggalend, String kode) {
        reportDao.GetReport_21kdpp(engine, vJenis, tBLTH, tparUp, tPetugas,
                                   tanggal, tanggalend, kode);
    }
    public void GetReport_21Petugas(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                    String tanggal, String tanggalend, String kode, String kdPembayar){
        reportDao.GetReport_21Petugas(engine, vJenis, tBLTH, tparUp, tPetugas,
                                      tanggal, tanggalend, kode, kdPembayar);
    }
    public void GetReport21Restitusi(Engine engine, String in_unitupi, String in_unitap, String in_unitup, String in_blth,
                                     String in_jenis){
        reportDao.GetReport21Restitusi(engine, in_unitupi, in_unitap, in_unitup, in_blth, in_jenis);
    }
}
