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
}
