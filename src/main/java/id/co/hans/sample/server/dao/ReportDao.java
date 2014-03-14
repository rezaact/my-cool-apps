package id.co.hans.sample.server.dao;

import com.inet.report.Engine;

public interface ReportDao {
    public void getLapRekapDimukaLPB(Engine engine, String unitupi, String unitap, String unitup, String jenislap, String thbl);
    public void getLapUnitPerThbl(Engine engine, String unitupi, String unitap, String unitup, String jenislap, String thbl);
    public void getLapSaldoBP(Engine engine, String unitupi, String unitap, String unitup, String thbl);
    public void getInvoiceMultiTarifByIdpelThblrek(Engine engine, String idpel, String thblrek);
    public void getMasterPlgMultiTarifByUnitThbl(Engine engine, String in_unitupi, String in_unitap, String in_unitup, String in_thblrek);


    // 11
    public void GetReport_11rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                  String kode, String tparAP, String in_unitupi);
    public void cetak_rekap11TglUpload(Engine engine, String tparUp, String tglAwal, String tglAkhir);

    //12
    public void GetReport_12rekapGabungan(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                          String kode, String tparAP, String in_unitupi);

    //13
    public void GetReport_13rekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp,
                                  String tPetugas);

    //21
    public void GetReport_21_BA(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                String tanggal, String tanggalend, String kode, String pengelola);
    public void GetReport_21kdpp(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                 String tanggal, String tanggalend, String kode);
    public void GetReport_21Petugas(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                    String tanggal, String tanggalend, String kode, String kdPembayar);
    public void GetReport21Restitusi(Engine engine, String in_unitupi, String in_unitap, String in_unitup, String in_blth,
                                     String in_jenis);
    public void GetReport_21rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                  String tanggal, String tanggalend, String kode);
    public void GetReport_21upload(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                   String tanggal, String tanggalend, String kode);
    public void GetReport_21Giral_Kode(Engine engine, String tBLTH, String tPetugas, String kode,
                                       String jenis);

    //22
    public void GetReport_22rekap_Global(Engine engine, String vJenis, String vFilterUnit, String tparUpi,
                                         String tparAp, String tparUp, String tanggal, String tanggalend);
    public void GetReport_22kdpp(Engine engine, String vJenis, String tBLTH, String tanggal,
                                 String tanggalend, String tparUp, String kode);
    public void GetReport_22petugas(Engine engine, String vJenis, String tBLTH, String tparUp,
                        String tPetugas, String tanggal, String tanggalend,
                        String kode, String kdPembayar, String sATM);
    public void GetReport_22petugasDaya(Engine engine, String vJenis, String tBLTH, String tparUp,
                                        String tPetugas, String tanggal, String tanggalend,
                                        String kode, String kdPembayar, String sATM,
                                        String vDayaAwal, String vDayaAkhir);
    public void GetReport_22rekap_V2(Engine engine, String vJenis, String tBLTH, String tparUp,
                                     String tparAp, String tparUpi, String tPetugas,
                                     String kode);

    //23
    public void GetReport_23Kirim_Rekap(Engine engine, String tThbl, String tParUp, String tPetugas);
    public void GetReport_23Kirim_Daftar(Engine engine, String tThbl, String tParUp, String tPetugas);
    public void GetReport_23Terima_Rekap(Engine engine, String tThbl, String tParUp, String tPetugas);
    public void GetReport_23Terima_Daftar(Engine engine, String tThbl, String tParUp, String tPetugas);
    public void GetReport_23Nota_Kode(Engine engine, String tBLTH, String tPetugas, String kode, String jenis, String iBebanKantor);
}
