package id.co.hans.sample.server.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ws_TransaksiDao {
    public Map<String, Object> HelloWorld();


    public Map<String, Object> cekVersiAplikasi(String versi);


    //------------Transaksi View-------------------------------

    public Map<String, Object> GetViewIdPel_21entri(String tpel,
                                                    String vJenis,
                                                    String tBLTH,
                                                    String tPetugas);


    public Map<String, Object> GetView21(String unitup,
                                         String tglAwal,
                                         String tglAkhir);


    public Map<String, Object> GetViewIdPel_21Suplisi(String tpel,
                                                      String tBLTH,
                                                      String tKoreksi,
                                                      String tPetugas);


    public Map<String, Object> GetViewIdPel_21HapusGagal(String tpel,
                                                         String vJenis,
                                                         String tBLTH,
                                                         String tPetugas,
                                                         String tTglBayar,
                                                         String tKodePp);


    public Map<String, Object> GetViewIdPel_PembatalanDenda(String tpel,
                                                            String vJenis,
                                                            String tBLTH,
                                                            String tPetugas);


    public Map<String, Object> GetViewIdPel_31(String tpel,
                                               String vJenis,
                                               String tBLTH,
                                               String tPetugas);


    public Map<String, Object> GetViewIdPel_41DUPR(String tpel,
                                                   String vJenis,
                                                   String tBLTH,
                                                   String tPetugas);


    public Map<String, Object> GetViewIdPel_32DUPP(String tpel,
                                                   String vJenis,
                                                   String tBLTH,
                                                   String tPetugas);


    public Map<String, Object> GetViewIdPel_41(String tpel,
                                               String vJenis,
                                               String tBLTH,
                                               String tPetugas);


    public Map<String, Object> GetViewIdPel_32(String tpel,
                                               String vJenis,
                                               String tBLTH,
                                               String tPetugas);


    public Map<String, Object> GetViewKolektif_32DUPP(String tkodekolektif,
                                                      String tBLTH,
                                                      String tPetugas);


    public Map<String, Object> GetViewKolektif_41DUPR(String tkodekolektif,
                                                      String tBLTH,
                                                      String tPetugas);


    public Map<String, Object> GetViewKolektif_21giralisasi(String tkodekolektif,
                                                            String tBLTH,
                                                            String tPetugas);


    public Map<String, Object> GetViewKolektif_23pusat(String tkodekolektif,
                                                       String tBLTH,
                                                       String tPetugas);


    public Map<String, Object> GetViewKolektif_23NOTA(String tkodekolektif,
                                                      String tBLTH,
                                                      String tPetugas);



    public Map<String, Object> GetViewIdPel_12ABC(String tpel,
                                                  String vJenis,
                                                  String tBLTH,
                                                  String tPetugas);


    public Map<String, Object> GetViewIdPel_12ABCORATOORA(String tpel,
                                                          String vJenis,
                                                          String tBLTH,
                                                          String tPetugas,
                                                          Boolean ORATOORA,
                                                          String kdkrs);


    public Map<String, Object> GetViewIdPel_12DE(String tpel,
                                                 String vJenis,
                                                 String tBLTH,
                                                 String tPetugas);


    public Map<String, Object> GetViewIdPel_12D(String tpel,
                                                String vJenis,
                                                String tBLTH,
                                                String tPetugas);


    public Map<String, Object> GetViewIdPel_13LAMA(String tpel,
                                                   String vJenis,
                                                   String tBLTH,
                                                   String tPetugas);


    public Map<String, Object> GetViewIdPel_13BARU(String tpel,
                                                   String vJenis,
                                                   String tBLTH,
                                                   String tPetugas);

    public Map<String, Object> Getview_SOREKORATOORA(String unitap,
                                                     String unitup,
                                                     String thbl,
                                                     String KDKELOMPOK,
                                                     String strglobalkodepetugas);

    public Map<String, Object> Getview_SOREKORATOORANEW(String unitap,
                                                        String unitup,
                                                        String thbl,
                                                        String KDKELOMPOK,
                                                        String strglobalkodepetugas,
                                                        String _package);

    public Map<String, Object> Getview_SUSULANORATOORA(String unitup,
                                                       String thbl,
                                                       String KDKELOMPOK,
                                                       String strglobalkodepetugas);

    //---tambahan untuk cari idpel dari nopel
    public Map<String, Object> GetIdpel(String vJenis,
                           String tPEL);
    //---end tambahan untuk cari idpel dari nopel

    //------------Transaksi Proc-------------------------------
    public Map<String, Object> SetData_11(String unitup,
                                   String thbl,
                                   String strglobalkodepetugas);

    public Map<String, Object> SetData_11_New(String unitap,
                          String unitup,
                          String kdprosesklp,
                          String blth,
                          String strglobalkodepetugas);


    public Map<String, Object> SetData_11_Cutoff(String unitup,
                                          String thbl,
                                          String strglobalkodepetugas);


    public Map<String, Object> SetData_13(String unitup,
                                   String thbl,
                                   String strglobalkodepetugas);


    public Map<String, Object> SetDataIdpel_31(Integer lbrproses,
                                  String tTransaksiBy,
                                  List<Map<String, String>> strData);


    public Map<String, Object> SetDataIdpel_41DUPR(List<Map<String, String>> dtrans,
                                                   String tTransaksiBy);


    public Map<String, Object> SetDataIdpel_32DUPP(List<Map<String, String>> dtrans,
                                                   String tTransaksiBy);


    public Map<String, Object> SetDataIdpel_41(List<Map<String, String>> dtrans,
                                               String tTransaksiBy);


    public Map<String, Object> SetDataIdpel_32(List<Map<String, String>> dtrans,
                                               String tTransaksiBy);


    public Map<String, Object> SetDataIdpel_21entri(Integer lbrproses,
                                       String tTransaksiBy,
                                       String tTglBayar,
                                       String tKdPP,
                                       String tKDPEMBAYAR,
                                       List<Map<String, String>> strData);


    public Map<String, Object> SetDataIdpel_21HapusGagal(List<Map<String, String>> dtrans,
                                                         String tTransaksiBy,
                                                         String tTglBayar,
                                                         String tKdPP,
                                                         String tKDPEMBAYAR);



    public Map<String, Object> SetDataIdpel_21Suplisi(List<Map<String, String>> dtrans,
                                                      String tTransaksiBy);



    public Map<String, Object> SetData_21upload(List<Map<String, String>> dtrans,
                                                String tTransaksiBy,
                                                String tTglBayar,
                                                String tKdPP);


    public Map<String, Object> SetDataIdpel_PembatalanDenda(List<Map<String, String>> dtrans,
                                                            String tTransaksiBy,
                                                            String tTglBayar,
                                                            String tKdPP,
                                                            String tKDPEMBAYAR);


    public Map<String, Object> SetDataIdpel_23NOTABUKU(Integer lbrproses,
                                                       String tTransaksiBy,
                                                       String tKirim,
                                                       List<Map<String, String>> strData,
                                                       Integer tBebanKantor);


    public Map<String, Object> SetDataIdpel_23NOTATERPUSAT(Integer lbrproses,
                                                           String tTransaksiBy,
                                                           String tKirim,
                                                           List<Map<String, String>> strData);


    public Map<String, Object> SetDataIdpel_21GIRALISASI(Integer lbrproses,
                                                         String tTransaksiBy,
                                                         String tKirim,
                                                         String tKodePP,
                                                         String tTglBayar,
                                                         List<Map<String, String>> strData);



    public Map<String, Object> Server_Download_DPH_AJN(String parUNITUP,
                                                       Date parTglMulai,
                                                       Date parTglSampai);


    public Map<String, Object> SetDataIdpel_32DHPfromDUPP(Integer lbrproses,
                                                          String tTransaksiBy,
                                                          String tKirim,
                                                          List<Map<String, String>> strData);


    public Map<String, Object> SetDataIdpel_41PRRfromDUPR(Integer lbrproses,
                                                          String tTransaksiBy,
                                                          String tKirim,
                                                          List<Map<String, String>> strData);



    public Map<String, Object> SetDataIdpel_12ABC(List<Map<String, String>> dtrans,
                                                  String tTransaksiBy,
                                                  String tKdkoreksi);



    public Map<String, Object> New_SetDataIdpel_12ABC(List<Map<String, String>> dtrans,
                                                      String tTransaksiBy,
                                                      String tKdkoreksi);



    public Map<String, Object> SetDataIdpel_12ABCNew(Integer hasil,
                                                     String idpel,
                                                     String thblrek,
                                                     Integer SLALWBP,
                                                     Integer SAHLWBP,
                                                     Integer SLAWBP,
                                                     Integer SAHWBP,
                                                     Integer SLAKVARH,
                                                     Integer SAHKVARH,
                                                     Integer SAHKVAMAKS,
                                                     String HITUNGBY);


    public Map<String, Object> SetDataIdpel_12ABCNewJabar(String idpel,
                                                          String thblrek,
                                                          Integer SLALWBP,
                                                          Integer SAHLWBP,
                                                          Integer SLAWBP,
                                                          Integer SAHWBP,
                                                          Integer SLAKVARH,
                                                          Integer SAHKVARH,
                                                          Integer SAHKVAMAKS,
                                                          String HITUNGBY,
                                                          Integer SLALWBP_PASANG,
                                                          Integer SAHLWBP_CABUT,
                                                          Integer SLAWBP_PASANG,
                                                          Integer SAHWBP_CABUT,
                                                          Integer SLAKVARH_PASANG,
                                                          Integer SAHKVARH_CABUT,
                                                          Integer SAHKVAMAKS_CABUT,
                                                          String _package);


    public Map<String, Object> SetDataIdpel_12DE(List<Map<String, String>> dtrans,
                                                 String tTransaksiBy,
                                                 String tKdkoreksi);


    public Map<String, Object> exeprocORA(Boolean exec,
                                          String procedurename,
                                          List<Map<String, String>> paramvalue);


    public Map<String, Object> SetDataIdpel_12D(List<Map<String, String>> dtrans,
                                                String tTransaksiBy,
                                                String tKdkoreksi,
                                                Boolean bSuplisi);


    public Map<String, Object> SetDataIdpel_13(List<Map<String, String>> dtrans,
                                               String tTransaksiBy,
                                               String tJenis);


    //----tambahan sumbar sorek oratoora
    public Map<String, Object> SetData_13UPLOAD(String unitup,
                                         String thbl,
                                         String strglobalkodepetugas);

    //----end tambahan sumbar sorek oratoora


    //---------------------------LAporan Pemantauan

    public Map<String, Object> PemantauanTransaksi(String Transaksi,
                                                   String vJenis,
                                                   String vPilihTgl,
                                                   String tUnitKJ,
                                                   String tUnitUP,
                                                   String tUnitAP,
                                                   String tTglmulai,
                                                   String tTglsampai,
                                                   String tKdpp,
                                                   String tKdPembayar,
                                                   String tKode);



    public Map<String, Object> PemantauanJurnal(String vPilihTgl,
                                                String tUnitUP,
                                                String tUnitAP,
                                                String tTglmulai,
                                                String tTglsampai,
                                                String tBlTh);


    public Map<String, Object> PemantauanSaldo(String vPilihSaldo,
                                               String vPilihRep,
                                               String tUnitUP,
                                               String tUnitAP,
                                               String tTglmulai,
                                               String tTglsampai,
                                               String tBlTh,
                                               String in_unitupi);


    public Map<String, Object> PemantauanSaldo_v2(String vPilihSaldo,
                                                  String vPilihRep,
                                                  String tUnitUP,
                                                  String tUnitAP,
                                                  String tUnitUPI,
                                                  String tTglmulai,
                                                  String tTglsampai,
                                                  String tBlTh,
                                                  String in_unitupi);


    //-------GENERAL Transaksi dan Laporan-------------------

    public Map<String, Object> GetViewALASANHAPUSBK(String vJenis,
                                                    String tPetugas);


    public Map<String, Object> ambilTanggalHariIni();


    public Map<String, Object> GetViewKODEPP(String vJenis,
                                             String tPetugas);


    public Map<String, Object> GetViewKODEKOLEKTIF21GIRALISASI();


    public Map<String, Object> GetViewKODEKOLEKTIF21GIRALISASIUNITUP(String sUnitup);


    public Map<String, Object> GetViewKODEKOLEKTIF23PUSAT();


    public Map<String, Object> GetViewKODEKOLEKTIF23PUSATUNITUP(String sUnitup);


    public Map<String, Object> GetViewKODEKOLEKTIF23NOTA();


    public Map<String, Object> GetViewKODEKOLEKTIF23NOTAUNITUP(String sunitup,
                                                               Integer iBebanKantor);


    public Map<String, Object> GetViewKODEKELOMPOK(String tTHBL,
                                                   String tPetugas);


    public Map<String, Object> GetViewKODEKELOMPOKUNIT(String tTHBL,
                                                       String tUNIT);


    public Map<String, Object> GetViewKODEKELOMPOKBYSIKLIS(String tTHBL,
                                                           String tSIKLIS);


    public Map<String, Object> GetViewKODERR(String tUNIT);


    public Map<String, Object> GetTempSorek();


    public Map<String, Object> GetViewKODEKOREKSI();


    public Map<String, Object> GetTempDKRP();


    //--------kolektif23nota
    public Map<String, Object> GetDataKolektifNotaBuku();

    public Map<String, Object> GetDataKolektifNotaBukuUnitup(String sUnitUp,
                                                             String iBebanKantor);


    //--------kolektif23KIRIM
    public Map<String, Object> GetDataKolektifKirim();

    public Map<String, Object> GetDataKolektifNotaTerpusat();

    public Map<String, Object> GetDataKolektifNotaTerpusatUnitup(String sUnitUP);

    public Map<String, Object> GetDataKolektifGiralisasi();

    public Map<String, Object> GetDataKolektifGiralisasiUnitup(String sUnitUp);


    public Map<String, Object> GetDataIdPelNotaBuku(String tkodekolektif);


    public Map<String, Object> GetDataIdPelKirim(String tkodekolektif);



    public Map<String, Object> GetDataIdPelNotaTerpusat(String tkodekolektif);


    public Map<String, Object> GetDataIdPelDil(String tidpel);


    public Map<String, Object> GetDataNoPelDil(String tNopel);


    public Map<String, Object> GetDataIdPelDPP(String tidpel);


    public Map<String, Object> GetDataIdPelDPPNotaTerpusat(String tidpel);


    public Map<String, Object> GetDataIdPelDPPGiralisasi(String tidpel);



    public Map<String, Object> GetDataIdPelGiralisasi(String tidpel);



    public Map<String, Object> simpandatapel(String tidpel,
                                 String tKdKolektif,
                                 String ket,
                                 String Atransaksiby,
                                 String Atgl_transaksi,
                                 String tNopel);



    public Map<String, Object> simpandatapelKirim(String tidpel,
                                      String tKdKolektif,
                                      String ket,
                                      String Atransaksiby,
                                      String Atgl_transaksi,
                                      String tNopel);



    public Map<String, Object> simpandatapelNotaTerpusat(String tidpel,
                                             String tKdKolektif,
                                             String ket,
                                             String Atransaksiby,
                                             String Atgl_transaksi,
                                             String tNopel);


    public Map<String, Object> simpandatapelGIRALISASI(String tidpel,
                                           String tKdKolektif,
                                           String ket,
                                           String Atransaksiby,
                                           String Atgl_transaksi,
                                           String tNopel);


    public Map<String, Object> GetDataValidasiKolektifNotaBuku(String tkodekolektif,
                                                               String tIdpel);


    public Map<String, Object> GetDataValidasiKolektifKirim(String tkodekolektif,
                                                            String tIdpel);


    public Map<String, Object> GetDataValidasiKolektifNotaTerpusat(String tkodekolektif,
                                                                   String tIdpel);


    public Map<String, Object> GetDataValidasiKolektifGiralisasi(String tkodekolektif,
                                                                 String tIdpel);


    public Map<String, Object> deletedatapelNotaTerpusat(String tidpel);


    public Map<String, Object> deletedatapelGiralisasi(String tidpel);


    public Map<String, Object> deletedatapel(String tidpel);


    public Map<String, Object> deletedatapelkirimkolektif(String tidpel);


    public Map<String, Object> GetNamaKolektifNotabuku(String tkodekolektif,
                                                       String nulll);


    public Map<String, Object> GetNamaKolektifKirim(String tkodekolektif,
                                                    String nulll);


    public Map<String, Object> GetNamaKolektifNotaTerpusat(String tkodekolektif,
                                                           String nulll);


    public Map<String, Object> GetNamaKolektifGiralisasi(String tkodekolektif,
                                                         String nulll);


    public Map<String, Object> simpandatakolektifNotaPusat(String tKdKolektif,
                                               String tnamakolektif,
                                               String tpetugas);


    public Map<String, Object> simpandatakolektifNotaPusatunitup(String tKdKolektif,
                                                     String tnamakolektif,
                                                     String tpetugas,
                                                     String tUnitup);


    public Map<String, Object> simpandatakolektifGiralisasi(String tKdKolektif,
                                                String tnamakolektif,
                                                String tpetugas);


    public Map<String, Object> simpandatakolektifGiralisasiunitup(String tKdKolektif,
                                                      String tnamakolektif,
                                                      String tpetugas,
                                                      String tunitup);


    public Map<String, Object> simpandatakolektifNotaBuku(String tKdKolektif,
                                              String tnamakolektif,
                                              String tpetugas);



    public Map<String, Object> simpandatakolektifNotaBukuUnitup(String tKdKolektif,
                                                    String tnamakolektif,
                                                    String tpetugas,
                                                    String tunitup,
                                                    Integer tBebanKantor);



    public Map<String, Object> simpandatakolektifKirim(String tKdKolektif,
                                           String tnamakolektif,
                                           String tpetugas);



    public Map<String, Object> hapusdatakolektifNotaBuku(String tKdKolektif,
                                             String tpetugas);


    public Map<String, Object> hapusdatakolektifKirim(String tKdKolektif,
                                          String tpetugas);


    public Map<String, Object> hapusdatakolektifNotaTerpusat(String tKdKolektif,
                                                 String tpetugas);


    public Map<String, Object> hapusdatakolektifGiralisasi(String tKdKolektif,
                                               String tpetugas);



    public Map<String, Object> tampilkodekolektifNotaBuku();


    public Map<String, Object> tampilkodekolektifNotaBukuUnitup(String sUnitup,
                                                                Integer iBebanKantor);


    public Map<String, Object> tampilkodekolektifKirim();


    public Map<String, Object> tampilkodekolektifNotaPusat();



    public Map<String, Object> tampilkodekolektifNotaPusatUnitup(String sUnitUp);


    public Map<String, Object> tampilkodekolektifGiralisasi();


    public Map<String, Object> tampilkodekolektifGiralisasiUnitup(String sUnitup);


    //---------------------------------Upload Sorek
    public Map<String, Object> CetakBeritaAcaraUpload(String unitUp,
                                               String siklis,
                                               String blth,
                                               Date tempo);

    public Map<String, Object> ambilstructureclsSorek();

    public Map<String, Object> Server_executeSQLsWithConnection(String[] SQLs);

    public Map<String, Object> DELETETEMPSOREK(String FileName,
                                        String unitup,
                                        String thbl,
                                        Date TglServer,
                                        String strGlobalKodePetugas,
                                        String KDKELOMPOK,
                                        String TGLJTTEMPO);

    public Map<String, Object> iNSERTTEMPSOREK(Map<String, Object> tDTRANS,
                                        String TglServer,
                                        String strGlobalKodePetugas,
                                        String KDKELOMPOK,
                                        String TGLJTTEMPO);

    public Map<String, Object> iNSERTTEMPSOREKup13(Map<String, Object> tDTRANS,
                                            Date TglServer,
                                            String strGlobalKodePetugas,
                                            String KDKELOMPOK,
                                            String TGLJTTEMPO);


    //----tambahan sumbar sorek oratoora
    public Map<String, Object> INSERTTEMPSOREK_ORATOORA(String unitap,
                                                        String unitup,
                                                        String thbl,
                                                        String KDKELOMPOK,
                                                        String strglobalkodepetugas,
                                                        String tgljatuhtempo);

    public Map<String, Object> INSERTTEMPSOREKSUSULAN_ORATOORA(String unitup,
                                                               String thbl,
                                                               String KDKELOMPOK,
                                                               String strglobalkodepetugas,
                                                               String tgljatuhtempo);

    public Map<String, Object> iNSERTTEMPSOREKsusulan(Map<String, Object> tDTRANS,
                                               Date TglServer,
                                               String strGlobalKodePetugas,
                                               String KDKELOMPOK,
                                               String TGLJTTEMPO);
    //----end tambahan sumbar sorek oratoora

    //------------------bATAL TRANSAKSI
    public Map<String, Object> BatalTransaksi_idpel(String Transaksi,
                                                    String tpel,
                                                    String vJenis,
                                                    String tKode,
                                                    String tPetugas,
                                                    String tblthbuku);


    //----------------General TUL6 Waskit sorek
    public Map<String, Object> ambilTanggalDatabase();

    public Map<String, Object> ambilUnitUp();

    public Map<String, Object> ambilNamaUp(String unitUp);

    public Map<String, Object> ambilNamaApdariUp(String unitUp);

    public Map<String, Object> ambilNamaKddariUp(String unitUp);

    public Map<String, Object> ambilAlamatdariUp(String unitUp);

    public Map<String, Object> ambilKelompokSiklis(String unitup);

    //----------------Waskit transaksi dan laporan

    public Map<String, Object> sp_waskit_verifikasi(Integer nav);

    public Map<String, Object> ambilNomerTulVI01(String unitUp);

    public Map<String, Object> insertTulVI01(Integer No_60,
                          String UnitUP,
                          String ThBlRek,
                          String IdPelanggan,
                          String NoKontrak,
                          String NoKontrol,
                          String Nama,
                          String Alamat,
                          String ThBlRek_akhir,
                          String Lembar_601,
                          String Tagihan_601,
                          String NOtul601);

   public  Map<String, Object> AmbilTul601(String unitUp,
                                    String sqlKriteria);


    //--- Laporan VI-01
    public Map<String, Object> ambilDaftarPantauCetak601(String unitUp,
                                                  Date awal,
                                                  Date akhir);


    //--- Laporan VI-03
    //--- Added by H.Intellisys 27 June 2006
    public Map<String, Object> ambilDaftarPantauCetak603(String unitUp,
                                                  Date awal,
                                                  Date akhir);


    public Map<String, Object> ambilRekapPantauCetak601(String unitUp,
                                                 Date awal,
                                                 Date akhir);


    public Map<String, Object> ambilRekapPantauCetak603(String unitUp,
                                                 Date awal,
                                                 Date akhir);


    public Map<String, Object> ambilDaftar601Lunas(String unitUp,
                                            Date awalPk,
                                            Date akhirPk,
                                            Date awalLns,
                                            Date akhirLns);

    public Map<String, Object> ambilDaftar603Lunas(String unitUp,
                                            Date awalPk,
                                            Date akhirPk,
                                            Date awalLns,
                                            Date akhirLns);


    public Map<String, Object> ambilRekap601Lunas(String unitUp,
                                           Date awalPk,
                                           Date akhirPk,
                                           Date awalLns,
                                           Date akhirLns);


    public Map<String, Object> ambilRekap603Lunas(String unitUp,
                                           Date awalPk,
                                           Date akhirPk,
                                           Date awalLns,
                                           Date akhirLns);


    public Map<String, Object> ambilTulVIperIdPel(String idpel);


    public Map<String, Object> ambilTulVI03perIdPel(String idpel);


    public Map<String, Object> ambil601BelumLunas(String unitUp,
                                           Date awal,
                                           Date akhir);


    public Map<String, Object> ambil603BelumLunas(String unitUp,
                                           Date awal,
                                           Date akhir);


    public Map<String, Object> AmbilTul601CetakUlang(String unitUp,
                                              Date tglPk,
                                              Integer noAwal,
                                              Integer noAkhir);


    public Map<String, Object> AmbilTul601Lampiran(String unitUp,
                                            Date tglPk,
                                            Integer noTul);



    //--- Tul VI-03
    public Map<String, Object> ambilNomerTulVI03(String unitUp);


    public Map<String, Object> AmbilTul603(Boolean is60hari,
                                    String unitUp,
                                    String sqlKriteria);

    public Map<String, Object> insertTulVI03(Integer No_60,
                          Integer no_601,
                          String UnitUP,
                          String ThBlRek,
                          String IdPelanggan,
                          String NoKontrak,
                          String NoKontrol,
                          String Nama,
                          String Alamat,
                          String ThBlRek_akhir,
                          String Lembar_603,
                          String Tagihan_603,
                          String NOtul603,
                          String NOtul601,
                          Date tglTul601);

    public Map<String, Object> ambilCetakKertasTulVI();


    //--- Pemutusan Penyambungan
    public Map<String, Object> ambilDetailTul601(String strtgl,
                                          String noTul);


    //--- Pembongkaran
    //--- Added By H.Intellisys 27 June 2006
    public Map<String, Object> ambilDetailTul603(String strtgl,
                                          String noTul);

    public Map<String, Object> simpanPutus(Date tglPutus,
                        String namaPutus,
                        String lwbp,
                        String wbp,
                        String kvarh,
                        Date tgl601,
                        String no601);

    public Map<String, Object> simpanBongkar(Date tglPutus,
                          String namaPutus,
                          String lwbp,
                          String wbp,
                          String kvarh,
                          Date tgl601,
                          String no601);

    public Map<String, Object> simpanSambung(Date tglsambung,
                          String namasambung,
                          String lwbp,
                          String wbp,
                          String kvarh,
                          Date tgl601,
                          String no601);

    //--- Ambil Cetakan Tul VI-03 
    public Map<String, Object> AmbilBuatCetakTul603(String txtIdpel,
                                             String unitUp,
                                             String sqlKriteria);

    public Map<String, Object> AmbilBuatCetakUlangTul603(String unitUp,
                                                  Date TglPk,
                                                  Integer noTul);

    public Map<String, Object> cekBKSudahDibuat();

    public Map<String, Object> login(String uname);

    public Map<String, Object> getMasterUnit(String in_unitpetugas);

    public Map<String, Object> ubahPassword(String uname,
                         String pwd);


    public Map<String, Object> GetViewIdPel_R2CICILAN(String tpel,
                                                      String vJenis,
                                                      String tBLTH,
                                                      String tPetugas);


    public Map<String, Object> SetDataIdpel_R2cicilan(String tIDPel,
                                                      String tBlTh,
                                                      String tStatus,
                                                      Map<String, Object> dtrans,
                                                      String tTransaksiBy,
                                                      String tnorek,
                                                      String v_NOAGENDA,
                                                      Integer v_KALICICIL,
                                                      Double v_rptag,
                                                      Double v_rpbk);


    //=== KIRIM UNIT ===

    public Map<String, Object> GetViewIdPel_23KIRIMUNIT(String tpel,
                                                        String vJenis,
                                                        String tBLTH,
                                                        String tPetugas);


    //=== KIRIM UNIT KOLEKTIF ===

    public Map<String, Object> GetViewIdPel_23KIRIMUNITKolektif(String kodekolektif,
                                                                String vJenis,
                                                                String tBLTH,
                                                                String tPetugas);


    public Map<String, Object> SaveTemp_23KIRIMUNIT(String tPetugas,
                                                    String tUnitKirim,
                                                    String tTglKirim);


    public Map<String, Object> SetDataIdpel_23KIRIMUNIT(Map<String, Object> dtrans,
                                                        String tTransaksiBy,
                                                        String tKDTERIMA);


    public Map<String, Object> PemantauanBatalTransaksi(String Transaksi,
                                                        String vpilihtglsama,
                                                        String vJenis,
                                                        String vPilihTgl,
                                                        String tUnitKJ,
                                                        String tUnitUP,
                                                        String tUnitAP,
                                                        String tTglmulai,
                                                        String tTglsampai,
                                                        String tKdpp,
                                                        String tKdPembayar,
                                                        String tKode);

    ////=== END KIRIM UNIT ===

    //====TERIMA UNIT====

    public Map<String, Object> GetViewIdPel_23TERIMAUNIT(String tpel,
                                                         String vJenis,
                                                         String tBLTH,
                                                         String tPetugas,
                                                         String tKdTerima);


    public Map<String, Object> SetDataIdpel_23TERIMAUNIT(Map<String, Object> dtrans,
                                                         String tTransaksiBy);


    public Map<String, Object> SaveTemp_23TERIMAUNIT(String dtrans,
                                                     String tUnitUpDari,
                                                     String tUnitUpUntuk,
                                                     String tPetugas);


    public Map<String, Object> GetVersion();


    public Map<String, Object> DaftarUpdateVersi();

    //====END TERIMA UNIT===


    public Map<String, Object> SetImportUJL_File(Map<String, Object> dsPass);


    public Map<String, Object> SetImportUJL_Oracle();


    public Map<String, Object> getDataHapusKolektif(Map<String, Object> dsFilter);


    public Map<String, Object> SetDataIdpel_21HapusGagalKolektif( String strDatarec,
                                                                  String strXMLschema,
                                                                  String tTransaksiBy);


    public Map<String, Object> setRekap(Map<String, Object> dsFilter);


    public Map<String, Object> setLap_502_404(String sUnitup,
                                       String sBlthLap,
                                       String sKodePetugas);


    public Map<String, Object> setLap_404(String sBlthLap,
                                   String sKodePetugas);


    public Map<String, Object> getViewDppNonrek(String unitup,
                                         String sTglMulai,
                                         String sTglSelesai);


    public Map<String, Object> getViewDphNonrek(String unitup,
                                         String sTglMulai,
                                         String sTglSelesai);


    public Map<String, Object> setDownloadDppNonrek(String unitup,
                                             String sTglMulai,
                                             String sTglSelesai);


    public Map<String, Object> SetKdGerak(String vKdGerak);


    public Map<String, Object> setDownloadDphNonrek(String unitup,
                                             String sTglMulai,
                                             String sTglSelesai);


    public Map<String, Object> getview212223Down(String TglMulai,
                                          String TglSampai,
                                          String Unitup,
                                          String sView);


    public Map<String, Object> GetParamDownload(String NmTabel);


    public Map<String, Object> GetDowndLunasBlmLunas(String TglMulai,
                                              String TglSampai,
                                              String Unitup,
                                              String Command,
                                              String thblrep,
                                              String kdkirim);


    public Map<String, Object> GetBKxml(String vIDpel);


    public Map<String, Object> GetTunggakan(String vIDpel);


    public Map<String, Object> GetInfoPlgXML(String vIDpel,
                         String tBLTH);


    public Map<String, Object> setKirimDBPTemp(String sUnitup,
                           String sIdpel,
                           String sStatuskirim);


    public Map<String, Object> getTerimaDBPResp(String sIdpel,
                            String sunitup,
                            String sStatus_terima);


    public Map<String, Object> SetSorektoDJBB(String unitap,
                                       String thbl);


    public Map<String, Object> SetSorektoDJBB_UP(String unitup,
                                          String thbl);


    public Map<String, Object> getMonitoringStatusPending(String unitup);


    public Map<String, Object> getMonitoringUploadSorek(String unit,
                                                 String blth,
                                                 String satuan);


    public Map<String, Object> SetBatalStatusPending(Integer lbrproses,
                                                     String tKirim,
                                                     String strData);


    public Map<String, Object> getunitap_user(String unitup);


    //" Region ====== Form Nota (23) ============ "
    public Map<String, Object> GetDataKolektifNotaBukuUserid(String userId);


    public Map<String, Object> GetDataIdPelNotaBukuBatal(String tkodekolektif,
                                                         String tuserid);


    public Map<String, Object> Batal_23NotaKolektif(String _idpel,
                                String _blth,
                                String _transaksiid,
                                String _transaksiby);
    //End Region


    public Map<String, Object> INSERTTEMPSOREK_ORATOORATEST(String unitup,
                                                            String thbl,
                                                            String KDKELOMPOK,
                                                            String strglobalkodepetugas,
                                                            String tgljatuhtempo);


    public Map<String, Object> GetViewIdPel_21entriRestitusi(String tpel,
                                                             String vJenis);


    public Map<String, Object> SetDataIdpel_21entriRestitusi(Integer lbrproses,
                                                             String tTransaksiBy,
                                                             String tTglBayar,
                                                             String tKDPEMBAYAR,
                                                             String strData);


    public Map<String, Object> getTingkatSatker();


    public Map<String, Object> GetKotama(String vUnitap);


    public Map<String, Object> GetSatker(String vUnitap,
                                         String vIDKotama);


    public Map<String, Object> GetdataSatker(String vIDSatker);


    public Map<String, Object> GetdataKotama(String vIDKotama);


    public Map<String, Object> InsertKotama(String vIDSatker,
                                            String vUnitap,
                                            String vSetuju1Nama,
                                            String vSetuju1Kesatuan,
                                            String vSetuju1Jabatan,
                                            String vSetuju1Pangkat,
                                            String vSetuju1NIP, String vSetuju2Nama,
                                            String vSetuju2Jabatan,
                                            String vSetuju2Unit,
                                            String vSetuju2Kota,
                                            String vNamaKotama,
                                            String vSETUJU3NAMA, String vSETUJU3KESATUAN,
                                            String vSETUJU3JABATAN,
                                            String vSETUJU3PANGKAT,
                                            String vSETUJU3NIP);


    public Map<String, Object> UpdateKotama(String vIDSatker,
                                            String vUnitap,
                                            String vSetuju1Nama,
                                            String vSetuju1Kesatuan,
                                            String vSetuju1Jabatan,
                                            String vSetuju1Pangkat,
                                            String vSetuju1NIP ,
                                            String vSetuju2Nama,
                                            String vSetuju2Jabatan,
                                            String vSetuju2Unit,
                                            String vSetuju2Kota,
                                            String vIdKotama,
                                            String vNamaKotama,
                                            String vSETUJU3NAMA,
                                            String vSETUJU3KESATUAN,
                                            String vSETUJU3JABATAN,
                                            String vSETUJU3PANGKAT,
                                            String vSETUJU3NIP);


    public Map<String, Object> InsertSatker(String vIdSatker,
                                            String vNoSurat,
                                            String vNoForm,
                                            String vUnitap,
                                            String vIDKotama,
                                            String vKesatuan,
                                            String vKodeSatker,
                                            String vAlamat,
                                            String vSetuju1Nama,
                                            String vSetuju1Kesatuan,
                                            String vSetuju1Jabatan,
                                            String vSetuju1Pangkat,
                                            String vSetuju1NIP,
                                            String vSetuju2Nama,
                                            String vSetuju2Kesatuan,
                                            String vSetuju2Jabatan,
                                            String vSetuju2Pangkat,
                                            String vSetuju2NIP,
                                            String vSetuju3Nama,
                                            String vSetuju3Jabatan,
                                            String vSetuju3Unit,
                                            String vSetuju3Kota);


    public Map<String, Object> UpdateSatker(String vNoSurat,
                                            String vNoForm,
                                            String vIDKotama,
                                            String vKesatuan,
                                            String vKodeSatker,
                                            String vAlamat,
                                            String vSetuju1Nama,
                                            String vSetuju1Kesatuan,
                                            String vSetuju1Jabatan,
                                            String vSetuju1Pangkat,
                                            String vSetuju1NIP,
                                            String vSetuju2Nama,
                                            String vSetuju2Kesatuan,
                                            String vSetuju2Jabatan,
                                            String vSetuju2Pangkat,
                                            String vSetuju2NIP,
                                            String vSetuju3Nama,
                                            String vSetuju3Jabatan,
                                            String vSetuju3Unit,
                                            String vSetuju3Kota);


    public Map<String, Object> GetNoForm(String vUnitap);


    public Map<String, Object> getAnggotaSatket(String vNoForm);


    public Map<String, Object> getDataPelanggan(String vIdpel);


    public Map<String, Object> HapusAnggotaSatker(String vNoForm,
                                                  String vIDPel);


    public Map<String, Object> TambahAnggotaSatker(String vUnitap,
                                                   String vIDPel,
                                                   String vNoForm);


    public Map<String, Object> cekSatker(String vNoForm,
                                         String vBlth);


    public Map<String, Object> SahSatker(String vNoForm,
                                         String vBlth,
                                         String SahBy);


    public Map<String, Object> GetDataKoreksiBongkar(String vIdpel);


    public Map<String, Object> InsertLogGagalDKRPBongkar(String in_unitup,
                                     String in_idpel,
                                     String in_blth,
                                     String in_lwbp_bongkar,
                                     String in_wbp_bongkar,
                                     String in_kvarh_bongkar,
                                     String in_notul603,
                                     String in_tgltul603,
                                     String in_petugas,
                                     String in_no60,
                                     String in_Log_Id,
                                     String ErrMsg);


    public Map<String, Object> GetLogDKRPBongkar(String _strtgl,
                                                 String _noTulAwal,
                                                 String _noTulAkhir,
                                                 String _unitup,
                                                 String _LogID);


    public Map<String, Object> Create_LogId(String in_unitup);
}
