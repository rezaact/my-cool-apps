package id.co.hans.sample.server.dao;

import java.util.Map;

public interface ws_ReportTransaksiDao {
    public Map<String, Object> ref_AmbilInduk();


    public Map<String, Object> ref_AmbilCabang(String induk);


    public Map<String, Object> ref_AmbilRanting(String cabang);


    public Map<String, Object> GetReport_41rekap(String vJenis,
                                                 String tBLTH,
                                                 String tparAp,
                                                 String tparUp,
                                                 String tPetugas);


    public Map<String, Object> GetReport_32rekap(String vJenis,
                                                 String tBLTH,
                                                 String tparUp,
                                                 String tPetugas);


    public Map<String, Object> GetReport_23notarekap(String vJenis,
                                                     String tBLTH,
                                                     String tparAp,
                                                     String tparUp,
                                                     String tPetugas,
                                                     String tanggal,
                                                     String kode);


    public Map<String, Object> GetReport_24notarekap(String vJenis,
                                                     String tBLTH,
                                                     String tparUPI,
                                                     String tparAp,
                                                     String tparUp,
                                                     String tPetugas,
                                                     String tanggal,
                                                     String kode);

    //---tgl 26 jan 07 00.00.00

    public Map<String, Object> Get_KODEPP(String unitup);


    public Map<String, Object> GetViewKODEKOLEKTIF23NOTA();


    public Map<String, Object> GetViewKODEsiklisUNIT(String tTHBL,
                                                     String tUNIT);


    public Map<String, Object> GetViewKODEsiklisUNITWithSemua(String tTHBL,
                                                              String tUNIT);


    public Map<String, Object> GetReport_21rekap(String vJenis,
                                                 String tBLTH,
                                                 String tparUp,
                                                 String tPetugas,
                                                 String tanggal,
                                                 String tanggalend,
                                                 String kode);


    public Map<String, Object> GetReport_21_BA(String vJenis,
                                               String tBLTH,
                                               String tparUp,
                                               String tPetugas,
                                               String tanggal,
                                               String tanggalend,
                                               String kode,
                                               String pengelola);


    public Map<String, Object> GetReport_21kdpp(String vJenis,
                                                String tBLTH,
                                                String tparUp,
                                                String tPetugas,
                                                String tanggal,
                                                String tanggalend,
                                                String kode);


    public Map<String, Object> GetReport_21upload(String vJenis,
                                                  String tBLTH,
                                                  String tparUp,
                                                  String tPetugas,
                                                  String tanggal,
                                                  String tanggalend,
                                                  String kode);


    public Map<String, Object> GetReport_31rekap(String vJenis,
                                                 String tBLTH,
                                                 String tparAp,
                                                 String tparUp,
                                                 String tPetugas);


    public Map<String, Object> GetReport_22kdpp(String vJenis,
                                                String tBLTH,
                                                String tparUp,
                                                String tPetugas,
                                                String tanggal,
                                                String tanggalend,
                                                String kode);


    public Map<String, Object> GetReport_22kdpp_v2(String vJenis,
                                                   String tBLTH,
                                                   String tanggal,
                                                   String tanggalend,
                                                   String tparup,
                                                   String kode);


    public Map<String, Object> GetReport_22kdpp_v3(String vJenis,
                                                   String tBLTH,
                                                   String tanggal,
                                                   String tanggalend,
                                                   String tparup,
                                                   String tparap,
                                                   String tparupi,
                                                   String kode);


    public Map<String, Object> GetReport_22rekap(String vJenis,
                                                 String tBLTH,
                                                 String tparUp,
                                                 String tPetugas,
                                                 String tanggal,
                                                 String tanggalend,
                                                 String kode);


    public Map<String, Object> GetReport_22rekap_V2(String vJenis,
                                                    String tBLTH,
                                                    String tparUp,
                                                    String tPetugas,
                                                    String tanggal,
                                                    String tanggalend,
                                                    String kode);


    public Map<String, Object> GetReport_22rekap_V3(String vJenis,
                                                    String tBLTH,
                                                    String tparUp,
                                                    String tparAp,
                                                    String tparUpi,
                                                    String tPetugas,
                                                    String tanggal,
                                                    String tanggalend,
                                                    String kode);


    public Map<String, Object> GetReport_22rekap_ap(String vJenis,
                                                    String tBLTH,
                                                    String tparUp,
                                                    String tPetugas,
                                                    String tanggal,
                                                    String tanggalend,
                                                    String kode);


    public Map<String, Object> GetReport_13rekap(String vJenis,
                                                 String tBLTH,
                                                 String tparAp,
                                                 String tparUp,
                                                 String tPetugas);


    public Map<String, Object> GetReport_12rekap(String vJenis,
                                                 String tBLTH,
                                                 String tparUp,
                                                 String tPetugas);

    public Map<String, Object> GetReport_12RekapGabungan(String vJenis,
                                                         String tBLTH,
                                                         String tparUp,
                                                         String tPetugas,
                                                         String tParAP,
                                                         String in_unitupi);


    public Map<String, Object> GetReport_12jnskoreksi(String vJenis,
                                                      String tBLTH,
                                                      String tparUp,
                                                      String tPetugas,
                                                      String kdKoreksi);


    public Map<String, Object> GetReport_12Jenis(String vJenis,
                                                 String tBLTH,
                                                 String tparUp,
                                                 String tPetugas);


    public Map<String, Object> GetReport_11rekap(String vJenis,
                                                 String tBLTH,
                                                 String tparUp,
                                                 String tPetugas,
                                                 String kode,
                                                 String tparAp,
                                                 String in_unitupi);

    //---tambahan BK
    public Map<String, Object> GetReport_BK_212223rekap(String vJenis,
                                                        String tBLTH,
                                                        String tparUp,
                                                        String tPetugas,
                                                        String kode);
    //---end BK

    //------------------------------

    public Map<String, Object> GetReport_23dltrekap(String vJenis,
                                                    String tBLTH,
                                                    String tparAp,
                                                    String tparUp,
                                                    String tPetugas,
                                                    String tanggal,
                                                    String kode,
                                                    String tparUPI);


    public Map<String, Object> GetViewKODEKOLEKTIF23NOTATERPUSAT();

    //--- Laporan Kolektif

    public Map<String, Object> GetReport_21Giral_Kode(String tBLTH,
                                                      String tPetugas,
                                                      String kode,
                                                      String jenis);


    public Map<String, Object> GetReport_23Nota_Kode(String tBLTH,
                                                     String tPetugas,
                                                     String kode,
                                                     String jenis,
                                                     Integer tBebanKantor);


    public Map<String, Object> GetReport_23Terpusat_Kode(String tBLTH,
                                                         String tPetugas,
                                                         String kode,
                                                         String jenis);


    //--- Cicilan Rekening

    public Map<String, Object> GetReport_Cilrek_Jurnal(String tKode,
                                                       String tThbl,
                                                       String tParUp,
                                                       String tPetugas);


    public Map<String, Object> GetReport_Cilrek_Daftar(String tKode,
                                                       String tThbl,
                                                       String tParUp,
                                                       String tPetugas);


    public Map<String, Object> GetReport_Cilrek_Idpel(String tIdpel);

    //----End cicilan rekening

    //----REPORT KIRIM UNIT

    public Map<String, Object> GetReport_23Kirim_Rekap(String tThbl,
                                                       String tParUp,
                                                       String tPetugas);


    public Map<String, Object> GetReport_23Kirim_Daftar(String tThbl,
                                                        String tParUp,
                                                        String tPetugas);
    //---END REPORT KIRIM UNIT

    //---REPORT TERIMA UNIT

    public Map<String, Object> GetReport_23Terima_Rekap(String tThbl,
                                                        String tParUp,
                                                        String tPetugas);


    public Map<String, Object> GetReport_23Terima_Daftar(String tThbl,
                                                         String tParUp,
                                                         String tPetugas);
    //---END REPORT TERIMA UNIT


    public Map<String, Object> getLaporan309(String jenis,
                                             String tparUP,
                                             String tParAP,
                                             String blth);


    public Map<String, Object> getLaporan309perUnit(String jenis,
                                                    String tParUnit,
                                                    String blth);


    public Map<String, Object> setLaporan309(String jenis,
                                             String tparUP,
                                             String tParAP,
                                             String blth,
                                             String transaksiby) ;


    public Map<String, Object> GetReport_22rekap_Global(String vJenis,
                                                        String vFilterUnit,
                                                        String tparUpi,
                                                        String tparAp,
                                                        String tparUp,
                                                        String tanggal,
                                                        String tanggalend);


    public Map<String, Object> GetReport_2122DoubleBayar(String sUnit,
                                                  String sBlnBayar,
                                                  String sKogol);


    public Map<String, Object> GetReport_2122DoubleBayarNew(String sUnit,
                                                     String sBlnBayar);


    public Map<String, Object> ref_AmbilPetugas(String kodePP);


    public Map<String, Object> GetReport_21petugas(String vJenis,
                                                   String tBLTH,
                                                   String tparUp,
                                                   String tPetugas,
                                                   String tanggal,
                                                   String tanggalend,
                                                   String kode,
                                                   String kdPembayar);


    public Map<String, Object> GetReport_22petugas(String vJenis,
                                                   String tBLTH,
                                                   String tparUp,
                                                   String tPetugas,
                                                   String tanggal,
                                                   String tanggalend,
                                                   String kode,
                                                   String kdPembayar,
                                                   String sATM);


    public Map<String, Object> GetReport_22petugasDaya(String vJenis,
                                                       String tBLTH,
                                                       String tparUp,
                                                       String tPetugas,
                                                       String tanggal,
                                                       String tanggalend,
                                                       String kode,
                                                       String kdPembayar,
                                                       String sATM,
                                                       String vDayaAwal,
                                                       String vDayaAkhir);


    public Map<String, Object> GetReport_Pemda(String tparAP,
                                               String tparUp,
                                               String tBLTH,
                                               String vJenis,
                                               String tPetugas,
                                               String in_unitupi);


    public Map<String, Object> cetak_rekap11TglUpload(String Unitup,
                                                      String TglMulai,
                                                      String TglAkhir);


    public Map<String, Object> getMonitoringSorekDJBB(String vUNITAP,
                                               String vTGLKIRIM);


    public Map<String, Object> getMonitoringLapSaldoTunggakan(String in_jenis,
                                                       String in_Unitupi,
                                                       String in_Unitap,
                                                       String in_Unitup);


    public Map<String, Object> GetTunggakanPemda(String in_unitupi,
                                          String in_unitap,
                                          String in_unitup,
                                          String in_blth,
                                          String in_jenis);


    public Map<String, Object> GetReportRestitusi(String in_unitap,
                                           String in_unitup,
                                           String in_blth,
                                           String in_jenis);


    public Map<String, Object> ambilLaporan508(String vNoForm,
                                               String thbl,
                                               String CekSatker);


    public Map<String, Object> ambilLaporan509(String vIDKotama,
                                               String thbl);


    public Map<String, Object> ambilLaporan509Rekap(String vIDKotama,
                                                    String thbl);


    public Map<String, Object> GetReport21Restitusi(String in_unitupi,
                                             String in_unitap,
                                             String in_unitup,
                                             String in_blth,
                                             String in_jenis);
}
