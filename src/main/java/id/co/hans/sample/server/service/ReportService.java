package id.co.hans.sample.server.service;

import id.co.hans.sample.server.dao.ReportDao;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Map<String, Object> GetReport_11rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                  String kode, String tparAP, String in_unitupi) {
        Map<String, Object> returnValue = reportDao.GetReport_11rekap(engine, vJenis, tBLTH, tparUp, tPetugas,
                                    kode, tparAP, in_unitupi);

        return returnValue;
    }

    public Map<String, Object> cetak_rekap11TglUpload(Engine engine, String tparUp, String tglAwal, String tglAkhir) {
        Map<String, Object> returnValue = reportDao.cetak_rekap11TglUpload(engine, tparUp, tglAwal, tglAkhir);

        return returnValue;
    }

    //12
    public Map<String, Object> GetReport_12rekapGabungan(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                          String kode, String tparAP, String in_unitupi) {
        Map<String, Object> returnValue = reportDao.GetReport_12rekapGabungan(engine, vJenis, tBLTH, tparUp, tPetugas,
                                            kode, tparAP, in_unitupi);

        return returnValue;
    }

    //13
    public Map<String, Object> GetReport_13rekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp,
                                  String tPetugas) {
        Map<String, Object> returnValue = reportDao.GetReport_13rekap(engine, vJenis, tBLTH, tparAp, tparUp,
                                    tPetugas);

        return returnValue;
    }

    //21
    public Map<String, Object> GetReport_21_BA(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                String tanggal, String tanggalend, String kode, String pengelola) {
        Map<String, Object> returnValue = reportDao.GetReport_21_BA(engine, vJenis, tBLTH, tparUp, tPetugas,
                                  tanggal, tanggalend, kode, pengelola);

        return returnValue;
    }
    public Map<String, Object> GetReport_21kdpp(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                 String tanggal, String tanggalend, String kode) {
        Map<String, Object> returnValue = reportDao.GetReport_21kdpp(engine, vJenis, tBLTH, tparUp, tPetugas,
                                   tanggal, tanggalend, kode);

        return returnValue;
    }
    public Map<String, Object> GetReport_21Petugas(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                    String tanggal, String tanggalend, String kode, String kdPembayar){
        Map<String, Object> returnValue = reportDao.GetReport_21Petugas(engine, vJenis, tBLTH, tparUp, tPetugas,
                                      tanggal, tanggalend, kode, kdPembayar);

        return returnValue;
    }
    public Map<String, Object> GetReport21Restitusi(Engine engine, String in_unitupi, String in_unitap, String in_unitup, String in_blth,
                                     String in_jenis){
        Map<String, Object> returnValue = reportDao.GetReport21Restitusi(engine, in_unitupi, in_unitap, in_unitup, in_blth, in_jenis);

        return returnValue;
    }
    public Map<String, Object> GetReport_21rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                  String tanggal, String tanggalend, String kode){
        Map<String, Object> returnValue = reportDao.GetReport_21rekap(engine, vJenis, tBLTH, tparUp, tPetugas,
                                    tanggal, tanggalend, kode);

        return returnValue;
    }
    public Map<String, Object> GetReport_21upload(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                   String tanggal, String tanggalend, String kode){
        Map<String, Object> returnValue = reportDao.GetReport_21upload(engine, vJenis, tBLTH, tparUp, tPetugas,
                                    tanggal, tanggalend, kode);

        return returnValue;
    }
    public Map<String, Object> GetReport_21Giral_Kode(Engine engine, String tBLTH, String tPetugas, String kode,
                                       String jenis){
        Map<String, Object> returnValue = reportDao.GetReport_21Giral_Kode(engine, tBLTH, tPetugas, kode,
                jenis);

        return returnValue;
    }

    //22
    public Map<String, Object> GetReport_22rekap_Global(Engine engine, String vJenis, String vFilterUnit, String tparUpi,
                                         String tparAp, String tparUp, String tanggal, String tanggalend){
        Map<String, Object> returnValue = reportDao.GetReport_22rekap_Global(engine, vJenis, vFilterUnit, tparUpi,
                tparAp, tparUp, tanggal, tanggalend);

        return returnValue;
    }
    public Map<String, Object> GetReport_22kdpp(Engine engine, String vJenis, String tBLTH, String tanggal,
                                 String tanggalend, String tparUp, String kode){
        Map<String, Object> returnValue = reportDao.GetReport_22kdpp(engine, vJenis, tBLTH, tanggal,
                tanggalend, tparUp, kode);

        return returnValue;
    }
    public Map<String, Object> GetReport_22petugas(Engine engine, String vJenis, String tBLTH, String tparUp,
                                    String tPetugas, String tanggal, String tanggalend,
                                    String kode, String kdPembayar, String sATM){
        Map<String, Object> returnValue = reportDao.GetReport_22petugas(engine, vJenis, tBLTH, tparUp,
                tPetugas, tanggal, tanggalend,
                kode, kdPembayar, sATM);

        return returnValue;
    }
    public Map<String, Object> GetReport_22petugasDaya(Engine engine, String vJenis, String tBLTH, String tparUp,
                                        String tPetugas, String tanggal, String tanggalend,
                                        String kode, String kdPembayar, String sATM,
                                        String vDayaAwal, String vDayaAkhir){
        Map<String, Object> returnValue = reportDao.GetReport_22petugasDaya(engine, vJenis, tBLTH, tparUp,
                tPetugas, tanggal, tanggalend,
                kode, kdPembayar, sATM, vDayaAwal, vDayaAkhir);

        return returnValue;
    }
    public Map<String, Object> GetReport_22rekap_V2(Engine engine, String vJenis, String tBLTH, String tparUp,
                                                 String tparAp, String tparUpi, String tPetugas,
                                                 String kode){
        Map<String, Object> returnValue = reportDao.GetReport_22rekap_V2(engine, vJenis, tBLTH, tparUp,
                tparAp, tparUpi, tPetugas,
                kode);

        return returnValue;
    }

    //23
    public Map<String, Object> GetReport_23Kirim_Rekap(Engine engine, String tThbl, String tParUp, String tPetugas){
        Map<String, Object> returnValue = reportDao.GetReport_23Kirim_Rekap(engine, tThbl, tParUp, tPetugas);

        return returnValue;
    }
    public Map<String, Object> GetReport_23Kirim_Daftar(Engine engine, String tThbl, String tParUp, String tPetugas){
        Map<String, Object> returnValue = reportDao.GetReport_23Kirim_Daftar(engine, tThbl, tParUp, tPetugas);

        return returnValue;
    }
    public Map<String, Object> GetReport_23Terima_Rekap(Engine engine, String tThbl, String tParUp, String tPetugas){
        Map<String, Object> returnValue = reportDao.GetReport_23Terima_Rekap(engine, tThbl, tParUp, tPetugas);

        return returnValue;
    }
    public Map<String, Object> GetReport_23Terima_Daftar(Engine engine, String tThbl, String tParUp, String tPetugas){
        Map<String, Object> returnValue = reportDao.GetReport_23Terima_Daftar(engine, tThbl, tParUp, tPetugas);

        return returnValue;
    }
    public Map<String, Object> GetReport_23Nota_Kode(Engine engine, String tBLTH, String tPetugas, String kode, String jenis, String iBebanKantor){
        Map<String, Object> returnValue = reportDao.GetReport_23Nota_Kode( engine, tBLTH, tPetugas, kode, jenis, iBebanKantor);

        return returnValue;
    }
    public Map<String, Object> GetReport_23dltrekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp, String tPetugas,
                                     String tanggal, String kode, String tparUPI){
        Map<String, Object> returnValue = reportDao.GetReport_23dltrekap( engine, vJenis, tBLTH, tparAp, tparUp, tPetugas,
                tanggal, kode, tparUPI);

        return returnValue;
    }
    public Map<String, Object> GetReport_23notarekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp, String tPetugas,
                                      String tanggal, String kode) {
        Map<String, Object> returnValue = reportDao.GetReport_23notarekap( engine, vJenis, tBLTH, tparAp, tparUp, tPetugas,
                tanggal, kode);

        return returnValue;
    }
    public Map<String, Object> GetReport_23Terpusat_Kode(Engine engine, String tBLTH, String tPetugas, String kode, String jenis) {
        Map<String, Object> returnValue = reportDao.GetReport_23Terpusat_Kode( engine, tBLTH, tPetugas, kode, jenis);

        return returnValue;
    }

    //24
    public Map<String, Object> GetReport_24notarekap(Engine engine, String vJenis, String tBLTH, String tparUPI, String tparAp, String tparUp,
                                      String tPetugas, String tanggal, String kode) {
        Map<String, Object> returnValue = reportDao.GetReport_24notarekap( engine, vJenis, tBLTH, tparUPI, tparAp, tparUp,
                tPetugas, tanggal, kode);

        return returnValue;
    }

    //31
    public Map<String, Object> GetReport_31rekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp, String tPetugas) {
        Map<String, Object> returnValue = reportDao.GetReport_31rekap( engine, vJenis, tBLTH, tparAp, tparUp, tPetugas);

        return returnValue;
    }

    //32
    public Map<String, Object> GetReport_32rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas) {
        Map<String, Object> returnValue = reportDao.GetReport_32rekap( engine, vJenis, tBLTH, tparUp, tPetugas);

        return returnValue;
    }

    //41
    public Map<String, Object> GetReport_41rekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp, String tPetugas) {
        Map<String, Object> returnValue = reportDao.GetReport_41rekap( engine, vJenis, tBLTH, tparAp, tparUp, tPetugas);

        return returnValue;
    }

    //2122dobelbayar
    public Map<String, Object> GetReport_2122DoubleBayarNew(Engine engine, String sUnit, String sBlnBayar) {
        Map<String, Object> returnValue = reportDao.GetReport_2122DoubleBayarNew( engine, sUnit, sBlnBayar);

        return returnValue;
    }

    //pemda
    public Map<String, Object> GetReport_Pemda(Engine engine, String tparAP, String tparUp, String tBLTH, String vJenis, String tPetugas, String in_unitupi) {
        Map<String, Object> returnValue = reportDao.GetReport_Pemda( engine, tparAP, tparUp, tBLTH, vJenis, tPetugas, in_unitupi);

        return returnValue;
    }

    //restitusi
    public Map<String, Object> GetReportRestitusi(Engine engine, String in_unitap, String in_unitup, String in_blth, String in_jenis) {
        Map<String, Object> returnValue = reportDao.GetReportRestitusi( engine, in_unitap, in_unitup, in_blth, in_jenis);

        return returnValue;
    }

    //212223
    public Map<String, Object> GetReport_BK_212223rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas, String kode) {
        Map<String, Object> returnValue = reportDao.GetReport_BK_212223rekap( engine, vJenis, tBLTH, tparUp, tPetugas, kode);

        return returnValue;
    }

    //reportpantau
    public Map<String, Object> getLaporanMonitoringTunggakan(Engine engine, String in_jenis, String in_unitupi, String in_unitap, String in_unitup) {
        Map<String, Object> returnValue = reportDao.getLaporanMonitoringTunggakan( engine, in_jenis, in_unitupi, in_unitap, in_unitup);

        return returnValue;
    }
    public Map<String, Object> GetTunggakanPemda(Engine engine, String in_unitupi, String in_unitap, String in_unitup, String in_blth, String in_jenis) {
        Map<String, Object> returnValue = reportDao.GetTunggakanPemda( engine, in_unitupi, in_unitap, in_unitup, in_blth, in_jenis);

        return returnValue;
    }
    public Map<String, Object> PemantauanJurnal(Engine engine, String vPilihTgl, String tUnitUP, String tUnitAP, String tTglmulai, String tTglsampai
            , String tBlTh) {
        Map<String, Object> returnValue = reportDao.PemantauanJurnal( engine, vPilihTgl, tUnitUP, tUnitAP, tTglmulai, tTglsampai, tBlTh);

        return returnValue;
    }
    public Map<String, Object> PemantauanSaldo(Engine engine, String vPilihSaldo, String vPilihRep, String tUnitUP, String tUnitAP, String tTglmulai
            , String tTglsampai, String tBlTh, String in_unitupi) {
        Map<String, Object> returnValue = reportDao.PemantauanSaldo( engine, vPilihSaldo, vPilihRep, tUnitUP, tUnitAP, tTglmulai
                , tTglsampai, tBlTh, in_unitupi);

        return returnValue;
    }
    public Map<String, Object> PemantauanTransaksi(Engine engine, String Transaksi, String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP
            , String tUnitAP, String tTglmulai, String tTglsampai, String tKdpp, String tKdPembayar, String tKode) {
        Map<String, Object> returnValue = reportDao.PemantauanTransaksi( engine, Transaksi, vJenis, vPilihTgl, tUnitKJ, tUnitUP
                , tUnitAP, tTglmulai, tTglsampai, tKdpp, tKdPembayar, tKode);

        return returnValue;
    }
    public Map<String, Object> PemantauanBatalTransaksi(Engine engine, String Transaksi, String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP
            , String tUnitAP, String tTglmulai, String tTglsampai, String tKdpp, String tKdPembayar, String tKode) {
        Map<String, Object> returnValue = reportDao.PemantauanBatalTransaksi( engine, Transaksi, vJenis, vPilihTgl, tUnitKJ, tUnitUP
                , tUnitAP, tTglmulai, tTglsampai, tKdpp, tKdPembayar, tKode);

        return returnValue;
    }

    //tul
    public Map<String, Object> ambilLaporan404(Engine engine, String parUp, String parUnsur, String thbl, String petugas, String pembukuan
            , String satuan) {
        Map<String, Object> returnValue = reportDao.ambilLaporan404( engine, parUp, parUnsur, thbl, petugas, pembukuan
                , satuan);

        return returnValue;
    }
    public Map<String, Object> ambilLaporanV02(Engine engine, String parUp, String parGol, String thbl, String petugas) {
        Map<String, Object> returnValue = reportDao.ambilLaporanV02( engine, parUp, parGol, thbl, petugas);

        return returnValue;
    }

    //PRR
    public Map<String, Object> prr_getLampiran(Engine engine, String unitupi, String unitap, String unitup, String blth, String lampiran, String no,
                                String idpel, String unsur, String pembukuan, String tglmulai, String tglsampai) {
        Map<String, Object> returnValue = reportDao.prr_getLampiran( engine, unitupi, unitap, unitup, blth, lampiran, no,
                idpel, unsur, pembukuan, tglmulai, tglsampai);

        return returnValue;
    }
}
