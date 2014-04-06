package id.co.hans.sample.server.dao;

import com.inet.report.Engine;

import java.util.Map;

public interface ReportDao {
    public void getLapRekapDimukaLPB(Engine engine, String unitupi, String unitap, String unitup, String jenislap, String thbl);
    public void getLapUnitPerThbl(Engine engine, String unitupi, String unitap, String unitup, String jenislap, String thbl);
    public void getLapSaldoBP(Engine engine, String unitupi, String unitap, String unitup, String thbl);
    public void getInvoiceMultiTarifByIdpelThblrek(Engine engine, String idpel, String thblrek);
    public void getMasterPlgMultiTarifByUnitThbl(Engine engine, String in_unitupi, String in_unitap, String in_unitup, String in_thblrek);


    // 11
    public Map<String, Object> GetReport_11rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                  String kode, String tparAP, String in_unitupi);
    public Map<String, Object> cetak_rekap11TglUpload(Engine engine, String tparUp, String tglAwal, String tglAkhir);

    //12
    public Map<String, Object> GetReport_12rekapGabungan(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                          String kode, String tparAP, String in_unitupi);

    //13
    public Map<String, Object> GetReport_13rekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp,
                                  String tPetugas);

    //21
    public Map<String, Object> GetReport_21_BA(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                String tanggal, String tanggalend, String kode, String pengelola);
    public Map<String, Object> GetReport_21kdpp(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                 String tanggal, String tanggalend, String kode);
    public Map<String, Object> GetReport_21Petugas(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                    String tanggal, String tanggalend, String kode, String kdPembayar);
    public Map<String, Object> GetReport21Restitusi(Engine engine, String in_unitupi, String in_unitap, String in_unitup, String in_blth,
                                     String in_jenis);
    public Map<String, Object> GetReport_21rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                  String tanggal, String tanggalend, String kode);
    public Map<String, Object> GetReport_21upload(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                   String tanggal, String tanggalend, String kode);
    public Map<String, Object> GetReport_21Giral_Kode(Engine engine, String tBLTH, String tPetugas, String kode,
                                       String jenis);

    //22
    public Map<String, Object> GetReport_22rekap_Global(Engine engine, String vJenis, String vFilterUnit, String tparUpi,
                                         String tparAp, String tparUp, String tanggal, String tanggalend);
    public Map<String, Object> GetReport_22kdpp(Engine engine, String vJenis, String tBLTH, String tanggal,
                                 String tanggalend, String tparUp, String kode);
    public Map<String, Object> GetReport_22petugas(Engine engine, String vJenis, String tBLTH, String tparUp,
                        String tPetugas, String tanggal, String tanggalend,
                        String kode, String kdPembayar, String sATM);
    public Map<String, Object> GetReport_22petugasDaya(Engine engine, String vJenis, String tBLTH, String tparUp,
                                        String tPetugas, String tanggal, String tanggalend,
                                        String kode, String kdPembayar, String sATM,
                                        String vDayaAwal, String vDayaAkhir);
    public Map<String, Object> GetReport_22rekap_V2(Engine engine, String vJenis, String tBLTH, String tparUp,
                                     String tparAp, String tparUpi, String tPetugas,
                                     String kode);

    //23
    public Map<String, Object> GetReport_23Kirim_Rekap(Engine engine, String tThbl, String tParUp, String tPetugas);
    public Map<String, Object> GetReport_23Kirim_Daftar(Engine engine, String tThbl, String tParUp, String tPetugas);
    public Map<String, Object> GetReport_23Terima_Rekap(Engine engine, String tThbl, String tParUp, String tPetugas);
    public Map<String, Object> GetReport_23Terima_Daftar(Engine engine, String tThbl, String tParUp, String tPetugas);
    public Map<String, Object> GetReport_23Nota_Kode(Engine engine, String tBLTH, String tPetugas, String kode, String jenis, String iBebanKantor);
    public Map<String, Object> GetReport_23dltrekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp, String tPetugas,
                                     String tanggal, String kode, String tparUPI);
    public Map<String, Object> GetReport_23notarekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp, String tPetugas,
                                      String tanggal, String kode);
    public Map<String, Object> GetReport_23Terpusat_Kode(Engine engine, String tBLTH, String tPetugas, String kode, String jenis);

    //24
    public Map<String, Object> GetReport_24notarekap(Engine engine, String vJenis, String tBLTH, String tparUPI, String tparAp, String tparUp,
                                      String tPetugas, String tanggal, String kode);

    //31
    public Map<String, Object> GetReport_31rekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp, String tPetugas);

    //32
    public Map<String, Object> GetReport_32rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas);

    //41
    public Map<String, Object> GetReport_41rekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp, String tPetugas);

    //2122dobelbayar
    public Map<String, Object> GetReport_2122DoubleBayarNew(Engine engine, String sUnit, String sBlnBayar);

    //pemda
    public Map<String, Object> GetReport_Pemda(Engine engine, String tparAP, String tparUp, String tBLTH, String vJenis, String tPetugas, String in_unitupi);

    //restitusi
    public Map<String, Object> GetReportRestitusi(Engine engine, String in_unitap, String in_unitup, String in_blth, String in_jenis);

    //212223
    public Map<String, Object> GetReport_BK_212223rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas, String kode);

    //reportpantau_monitoringsaldotunggakan
    public Map<String, Object> getLaporanMonitoringTunggakan(Engine engine, String in_jenis, String in_unitupi, String in_unitap, String in_unitup);
    public Map<String, Object> GetTunggakanPemda(Engine engine, String in_unitupi, String in_unitap, String in_unitup, String in_blth, String in_jenis);
    public Map<String, Object> PemantauanJurnal(Engine engine, String vPilihTgl, String tUnitUP, String tUnitAP, String tTglmulai, String tTglsampai
            , String tBlTh);
    public Map<String, Object> PemantauanSaldo(Engine engine, String vPilihSaldo, String vPilihRep, String tUnitUP, String tUnitAP, String tTglmulai
            , String tTglsampai, String tBlTh, String in_unitupi);
    public Map<String, Object> PemantauanTransaksi(Engine engine, String Transaksi, String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP
            , String tUnitAP, String tTglmulai, String tTglsampai, String tKdpp, String tKdPembayar, String tKode);
    public Map<String, Object> PemantauanBatalTransaksi(Engine engine, String Transaksi, String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP
            , String tUnitAP, String tTglmulai, String tTglsampai, String tKdpp, String tKdPembayar, String tKode);

    //tul
    public Map<String, Object> ambilLaporan404(Engine engine, String parUp, String parUnsur, String thbl, String petugas, String pembukuan
            , String satuan);
    public Map<String, Object> ambilLaporanV02(Engine engine, String parUp, String parGol, String thbl, String petugas);

    //PRR
    public Map<String, Object> prr_getLampiran(Engine engine, String unitupi, String unitap, String unitup, String blth, String lampiran, String no,
                    String idpel, String unsur, String pembukuan, String tglmulai, String tglsampai);
}
