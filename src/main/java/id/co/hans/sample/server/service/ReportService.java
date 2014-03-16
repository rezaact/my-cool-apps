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
    public void GetReport_21rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                  String tanggal, String tanggalend, String kode){
        reportDao.GetReport_21rekap(engine, vJenis, tBLTH, tparUp, tPetugas,
                                    tanggal, tanggalend, kode);
    }
    public void GetReport_21upload(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                   String tanggal, String tanggalend, String kode){
        reportDao.GetReport_21upload(engine, vJenis, tBLTH, tparUp, tPetugas,
                                    tanggal, tanggalend, kode);
    }
    public void GetReport_21Giral_Kode(Engine engine, String tBLTH, String tPetugas, String kode,
                                       String jenis){
        reportDao.GetReport_21Giral_Kode(engine, tBLTH, tPetugas, kode,
                jenis);
    }

    //22
    public void GetReport_22rekap_Global(Engine engine, String vJenis, String vFilterUnit, String tparUpi,
                                         String tparAp, String tparUp, String tanggal, String tanggalend){
        reportDao.GetReport_22rekap_Global(engine, vJenis, vFilterUnit, tparUpi,
                tparAp, tparUp, tanggal, tanggalend);
    }
    public void GetReport_22kdpp(Engine engine, String vJenis, String tBLTH, String tanggal,
                                 String tanggalend, String tparUp, String kode){
        reportDao.GetReport_22kdpp(engine, vJenis, tBLTH, tanggal,
                tanggalend, tparUp, kode);
    }
    public void GetReport_22petugas(Engine engine, String vJenis, String tBLTH, String tparUp,
                                    String tPetugas, String tanggal, String tanggalend,
                                    String kode, String kdPembayar, String sATM){
        reportDao.GetReport_22petugas(engine, vJenis, tBLTH, tparUp,
                tPetugas, tanggal, tanggalend,
                kode, kdPembayar, sATM);
    }
    public void GetReport_22petugasDaya(Engine engine, String vJenis, String tBLTH, String tparUp,
                                        String tPetugas, String tanggal, String tanggalend,
                                        String kode, String kdPembayar, String sATM,
                                        String vDayaAwal, String vDayaAkhir){
        reportDao.GetReport_22petugasDaya(engine, vJenis, tBLTH, tparUp,
                tPetugas, tanggal, tanggalend,
                kode, kdPembayar, sATM, vDayaAwal, vDayaAkhir);
    }
    public void GetReport_22rekap_V2(Engine engine, String vJenis, String tBLTH, String tparUp,
                                                 String tparAp, String tparUpi, String tPetugas,
                                                 String kode){
        reportDao.GetReport_22rekap_V2(engine, vJenis, tBLTH, tparUp,
                tparAp, tparUpi, tPetugas,
                kode);
    }

    //23
    public void GetReport_23Kirim_Rekap(Engine engine, String tThbl, String tParUp, String tPetugas){
        reportDao.GetReport_23Kirim_Rekap(engine, tThbl, tParUp, tPetugas);
    }
    public void GetReport_23Kirim_Daftar(Engine engine, String tThbl, String tParUp, String tPetugas){
        reportDao.GetReport_23Kirim_Daftar(engine, tThbl, tParUp, tPetugas);
    }
    public void GetReport_23Terima_Rekap(Engine engine, String tThbl, String tParUp, String tPetugas){
        reportDao.GetReport_23Terima_Rekap(engine, tThbl, tParUp, tPetugas);
    }
    public void GetReport_23Terima_Daftar(Engine engine, String tThbl, String tParUp, String tPetugas){
        reportDao.GetReport_23Terima_Daftar(engine, tThbl, tParUp, tPetugas);
    }
    public void GetReport_23Nota_Kode(Engine engine, String tBLTH, String tPetugas, String kode, String jenis, String iBebanKantor){
        reportDao.GetReport_23Nota_Kode( engine, tBLTH, tPetugas, kode, jenis, iBebanKantor);
    }
    public void GetReport_23dltrekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp, String tPetugas,
                                     String tanggal, String kode, String tparUPI){
        reportDao.GetReport_23dltrekap( engine, vJenis, tBLTH, tparAp, tparUp, tPetugas,
                tanggal, kode, tparUPI);
    }
    public void GetReport_23notarekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp, String tPetugas,
                                      String tanggal, String kode) {
        reportDao.GetReport_23notarekap( engine, vJenis, tBLTH, tparAp, tparUp, tPetugas,
                tanggal, kode);
    }
    public void GetReport_23Terpusat_Kode(Engine engine, String tBLTH, String tPetugas, String kode, String jenis) {
        reportDao.GetReport_23Terpusat_Kode( engine, tBLTH, tPetugas, kode, jenis);
    }

    //31
    public void GetReport_31rekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp, String tPetugas) {
        reportDao.GetReport_31rekap( engine, vJenis, tBLTH, tparAp, tparUp, tPetugas);
    }

    //32
    public void GetReport_32rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas) {
        reportDao.GetReport_32rekap( engine, vJenis, tBLTH, tparUp, tPetugas);
    }

    //41
    public void GetReport_41rekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp, String tPetugas) {
        reportDao.GetReport_41rekap( engine, vJenis, tBLTH, tparAp, tparUp, tPetugas);
    }

    //2122dobelbayar
    public void GetReport_2122DoubleBayarNew(Engine engine, String sUnit, String sBlnBayar) {
        reportDao.GetReport_2122DoubleBayarNew( engine, sUnit, sBlnBayar);
    }

    //pemda
    public void GetReport_Pemda(Engine engine, String tparAP, String tparUp, String tBLTH, String vJenis, String tPetugas, String in_unitupi) {
        reportDao.GetReport_Pemda( engine, tparAP, tparUp, tBLTH, vJenis, tPetugas, in_unitupi);
    }

    //restitusi
    public void GetReportRestitusi(Engine engine, String in_unitap, String in_unitup, String in_blth, String in_jenis) {
        reportDao.GetReportRestitusi( engine, in_unitap, in_unitup, in_blth, in_jenis);
    }

    //212223
    public void GetReport_BK_212223rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas, String kode) {
        reportDao.GetReport_BK_212223rekap( engine, vJenis, tBLTH, tparUp, tPetugas, kode);
    }

    //reportpantau
    public void getLaporanMonitoringTunggakan(Engine engine, String in_jenis, String in_unitupi, String in_unitap, String in_unitup) {
        getLaporanMonitoringTunggakan( engine, in_jenis, in_unitupi, in_unitap, in_unitup);
    }
}
