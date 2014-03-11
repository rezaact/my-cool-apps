package id.co.hans.sample.server.dao;

import java.util.Date;
import java.util.Map;

public interface ws_tul6waskitDao {


    public Map<String, Object> sp_waskit_verifikasi(Integer nav);


    public Map<String, Object> sp_waskit_verifikasi_up(Integer nav,
                                           String unitup);

    //---tambahan cari stand di sorekbaru terakhir dan saat putus
    public Map<String, Object> ambilstand_sorekakhir(String unitUp,
                                                     String tgl_tul601,
                                                     String no_tul601);

    public Map<String, Object> ambilstand_putus(String unitUp,
                                                String tgl_tul601,
                                                String no_tul601);
    //---end tambahan cari stand di sorekbaru terakhir


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

    public Map<String, Object> AmbilTul601(String unitUp,
                                           String sqlKriteria);

    public Map<String, Object> AmbilTul601_Deposit(String unitUp,
                                                   String sqlKriteria);

    public Map<String, Object> AmbilTul601_incl_sdh_ctk(String unitUp,
                                                        String sqlKriteria);

    public Map<String, Object> AmbilTul601_incl_sdh_ctk_Deposit(String unitUp,
                                                                String sqlKriteria);

    //--- Laporan VI-03
    public Map<String, Object> ambilDaftarPantauCetak603(String unitUp,
                                                         Date awal,
                                                         Date akhir);

    public Map<String, Object> ambilDaftarPantauCetak603Lunas(String unitUp,
                                                              Date awal,
                                                              Date akhir);

    public Map<String, Object> ambilRekapPantauCetak603(String unitUp,
                                                        Date awal,
                                                        Date akhir);

    public Map<String, Object> ambilRekapPantauCetak603lunas(String unitUp,
                                                             Date awal,
                                                             Date akhir);

    public Map<String, Object> ambil603BelumLunas(String unitUp,
                                                  Date awal,
                                                  Date akhir);

    //--- Laporan VI-01
    public Map<String, Object> ambilDaftarPantauCetak601(String unitUp,
                                                         Date awal,
                                                         Date akhir);

    public Map<String, Object> ambilDaftarPantauCetak601_kriteria(String unitUp,
                                                                  Date awal,
                                                                  Date akhir,
                                                                  String sqlKriteria);

    public Map<String, Object> ambilRekapPantauCetak601(String unitUp,
                                                        Date awal,
                                                        Date akhir);

    public Map<String, Object> ambilRekapPantauCetak601_kriteria(String unitUp,
                                                                 Date awal,
                                                                 Date akhir,
                                                                 String sqlkriteria);

    public Map<String, Object> ambilDaftar601Lunas(String unitUp,
                                                   Date awalPk,
                                                   Date akhirPk,
                                                   Date awalLns,
                                                   Date akhirLns,
                                                   String kriteria);

    public Map<String, Object> ambilDaftar601Lunas_kriteria(String unitUp,
                                                            Date awalPk,
                                                            Date akhirPk,
                                                            Date awalLns,
                                                            Date akhirLns,
                                                            String kriteria,
                                                            String sqlkriteria);

    public Map<String, Object> ambilRekap601Lunas(String unitUp,
                                                  Date awalPk,
                                                  Date akhirPk,
                                                  Date awalLns,
                                                  Date akhirLns);

    public Map<String, Object> ambilRekap601Lunas_kriteria(String unitUp,
                                                           Date awalPk,
                                                           Date akhirPk,
                                                           Date awalLns,
                                                           Date akhirLns,
                                                           String sqlkriteria);

    public Map<String, Object> ambilTulVIperNamaPutus(String nama,
                                                      Date tglAwal,
                                                      Date tglAkhir);

    public Map<String, Object> ambilDetailTulVIperNamaPetugas(String nama,
                                                              Date tglAwal,
                                                              Date tglAkhir);


    public Map<String, Object> ambilTulVIRekapKinerja(String unitup,
                                                      Date tglAwal,
                                                      Date tglAkhir);


    public Map<String, Object> ambilTulVIperIdPel(String idpel);


    public Map<String, Object> ambil601BelumLunas(String unitUp,
                                                  Date awal,
                                                  Date akhir);


    public Map<String, Object> AmbilTul601CetakUlang(String unitUp,
                                                     Date tglPk,
                                                     Integer noAwal,
                                                     Integer noAkhir);

    //---tambahan cetak PK Penyambungan Weleri 20090115
    public Map<String, Object> AmbilTul601Penyambungan(String unitUp,
                                                       Date tglPk,
                                                       Integer noAwal,
                                                       Integer noAkhir);

    //---end tambahan cetak PK Penyambungan

    public Map<String, Object> AmbilTul601CetakUlang_Deposit(String unitUp,
                                                             Date tglPk,
                                                             Integer noAwal,
                                                             Integer noAkhir);

    public Map<String, Object> AmbilTul601CetakUlangKriteria(String unitUp,
                                                             Date tglPk,
                                                             Integer noAwal,
                                                             Integer noAkhir,
                                                             Date tglpk2,
                                                             String kolok);

    public Map<String, Object> AmbilTul601CetakUlangKriteria_Deposit(String unitUp,
                                                                     Date tglPk,
                                                                     Integer noAwal,
                                                                     Integer noAkhir,
                                                                     Date tglpk2,
                                                                     String kolok);

    public Map<String, Object> AmbilTul601Lampiran(String unitUp,
                                                   Date tglPk,
                                                   Integer noTul);

    public Map<String, Object> AmbilTul601LampiranKriteria(String unitUp,
                                                           Date tglPk,
                                                           Integer noTul,
                                                           Date tglPk2,
                                                           String kolok);


    //--- Tul VI-03
    public Map<String, Object> ambilNomerTulVI03(String unitUp);

    public Map<String, Object> AmbilTul603(Boolean is60hari,
                                           String unitUp,
                                           String sqlKriteria);

    public Map<String, Object> AmbilTul603_Incl_Sdhcetak(Boolean is60hari,
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
                                                 String noTul,
                                                 String unitup);

    //--- Pemutusan Penyambungan
    public Map<String, Object> ambilDetailTul603(String strtgl,
                                                 String noTul,
                                                 String unitup);

    public Map<String, Object> ambilDetailTul601SdhPutus(String strtgl,
                                                         String noTul,
                                                         String unitup);

    public Map<String, Object> ambilDetailTul601SdhPutusLunas(String strtgl,
                                                              String noTul,
                                                              String unitup);

    public Map<String, Object> simpanPutus(Date tglPutus,
                              String namaPutus,
                              String lwbp,
                              String wbp,
                              String kvarh,
                              Date tgl601,
                              String no601,
                              String unitUp);

    public Map<String, Object> simpanSambung(Date tglsambung,
                                String namasambung,
                                String lwbp,
                                String wbp,
                                String kvarh,
                                Date tgl601,
                                String no601,
                                String unitUp);

    public Map<String, Object> simpanBongkar(Date tglbongkar,
                                String namabongkar,
                                String lwbp,
                                String wbp,
                                String kvarh,
                                Date tgl603,
                                String no603,
                                String unitUp,
                                Date tglkode3,
                                String nokode3);

    public Map<String, Object> UPDATE_DIL_N(String p_unitup,
                                String p_idpel,
                                String p_catatby);

    public Map<String, Object> UPDATE_DIL_O(String p_unitup,
                                String p_idpel,
                                String p_catatby);

    public Map<String, Object> AmbilBuatCetakTul603(String txtIdpel,
                                                    String unitUp,
                                                    String sqlKriteria);

    public Map<String, Object> AmbilBuatCetakTul603_BA(String txtIdpel,
                                                       String unitUp,
                                                       String sqlKriteria);

    public Map<String, Object> AmbilBuatCetakUlangTul603(String unitUp,
                                                         Date TglPk,
                                                         Integer noTul);

    public Map<String, Object> AmbilBuatCetakUlangTul603Kriteria(String unitUp,
                                                                 Date TglPk,
                                                                 Integer noTul,
                                                                 Date TglPk2,
                                                                 String kolok);


    //--- Penanganan Petugas
    public Map<String, Object> simpanGroup(String unitup,
                               String namagroup,
                               String deskripsi,
                               String jenisgroup,
                               String statusaktif,
                               String created_by);

    public Map<String, Object> simpanPetugas(String unitup,
                                 String namapetugas,
                                 String keterangan,
                                 String namagroup,
                                 String statusaktif,
                                 String created_by);

    public Map<String, Object> lihatGroup();

    public Map<String, Object> lihatGroup_ByUnitup(String sUNITUP);

    public Map<String, Object> lihatPetugas();

    public Map<String, Object> lihatPetugas_ByUnitup(String sUNITUP);

    public Map<String, Object> nonAktifGroup(String group);

    public Map<String, Object> aktifkanGroup(String group);

    public Map<String, Object> nonAktifPetugas(String petugas);

    public Map<String, Object> aktifkanPetugas(String petugas);

    public Map<String, Object> ambilPetugasWaskit();

    public Map<String, Object> ambilPetugasWaskit_up(String unitup);

    public Map<String, Object> ambilPetugasWaskit_up_group(String unitup,
                                                           String group);

    public Map<String, Object> ambilGroupPetugas();

    public Map<String, Object> ambilGroupPetugas_ByUnitup(String sUNITUP);

    public Map<String, Object> simpanPenugasan(String unitup,
                                   String no_pk_sambung,
                                   String pemberi_material,
                                   String no_pk_tul6,
                                   String petugas_sambung,
                                   String material1,
                                   String material2,
                                   String material3,
                                   String keterangan,
                                   String created_by);

    public Map<String, Object> hapusPenugasan(String noPkSambung);

    public Map<String, Object> lihatPenugasan(String unitUp);

    //--- Distribusi PK per-Petugas
    public Map<String, Object> simpanDistribusiPKPutus(String unitup,
                                                       String tgltul,
                                                       String notul,
                                                       String iKodePetugas,
                                                       String petugas);

    public Map<String, Object> simpanDistribusiPKBongkar(String unitup,
                                                         String tgltul,
                                                         String notul,
                                                         String iKodePetugas,
                                                         String petugas);

    public Map<String, Object> lihatDistribusiPKPutus(String sqlKriteria);

    public Map<String, Object> lihatDistribusiPKBongkar(String sqlKriteria);


    public Map<String, Object> getView_ReportPantauTULVI01(String sTglAwal,
                                                           String sTglAkhir,
                                                           String sUnitup);


    public Map<String, Object> AmbilBuatCetakUlangTul601Kriteria_pkg(String _unitup,
                                                                     String _idpelAwal_A,
                                                                     String _idpelAwal_B,
                                                                     String _idpelAkhir_A,
                                                                     String _idpelAkhir_B,
                                                                     String _jumlahLembarAwal,
                                                                     String _jumlahLembarAkhir,
                                                                     String _rupiahTagihAwal,
                                                                     String _rupiahTagihAkhir,
                                                                     String _dayaAwal,
                                                                     String _dayaAkhir,
                                                                     String _kogolAwal,
                                                                     String _kogolAkhir,
                                                                     String _noRBM,
                                                                     String _kantorPelayanan,
                                                                     String _noGardu,
                                                                     String _paymentPoint,
                                                                     String _tarip,
                                                                     String _petugasPemutusan,
                                                                     String _cekUrutanKolom,
                                                                     String _cekUrutan,
                                                                     String _maxJmlPK,
                                                                     String _cekCetakanTiap);



    public Map<String, Object> AmbilBuatCetakUlangTul603Kriteria_pkg(String _unitup,
                                                                     String _idpelAwal_A,
                                                                     String _idpelAwal_B,
                                                                     String _idpelAkhir_A,
                                                                     String _idpelAkhir_B,
                                                                     String _jumlahLembarAwal,
                                                                     String _jumlahLembarAkhir,
                                                                     String _rupiahTagihAwal,
                                                                     String _rupiahTagihAkhir,
                                                                     String _dayaAwal,
                                                                     String _dayaAkhir,
                                                                     String _kogolAwal,
                                                                     String _kogolAkhir,
                                                                     String _noRBM,
                                                                     String _kantorPelayanan,
                                                                     String _noGardu,
                                                                     String _paymentPoint,
                                                                     String _tarip,
                                                                     String _petugasPemutusan,
                                                                     String _cekUrutanKolom,
                                                                     String _cekUrutan,
                                                                     String _maxJmlPK,
                                                                     String _cekCetakanTiap,
                                                                     String _is60hari);



    public Map<String, Object> AmbilTul601Penyambungan_pkg(String _unitup,
                                                           String _idpelAwal_A,
                                                           String _idpelAwal_B,
                                                           String _idpelAkhir_A,
                                                           String _idpelAkhir_B,
                                                           String _jumlahLembarAwal,
                                                           String _jumlahLembarAkhir,
                                                           String _rupiahTagihAwal,
                                                           String _rupiahTagihAkhir,
                                                           String _dayaAwal,
                                                           String _dayaAkhir,
                                                           String _kogolAwal,
                                                           String _kogolAkhir,
                                                           String _noRBM,
                                                           String _kantorPelayanan,
                                                           String _noGardu,
                                                           String _paymentPoint,
                                                           String _tarip,
                                                           String _petugasPemutusan,
                                                           String _cekUrutanKolom,
                                                           String _cekUrutan,
                                                           String _maxJmlPK,
                                                           String _cekCetakanTiap);



    public Map<String, Object> AmbilTul601LampiranKriteria_pkg(String _unitup,
                                                               String _idpelAwal_A,
                                                               String _idpelAwal_B,
                                                               String _idpelAkhir_A,
                                                               String _idpelAkhir_B,
                                                               String _jumlahLembarAwal,
                                                               String _jumlahLembarAkhir,
                                                               String _rupiahTagihAwal,
                                                               String _rupiahTagihAkhir,
                                                               String _dayaAwal,
                                                               String _dayaAkhir,
                                                               String _kogolAwal,
                                                               String _kogolAkhir,
                                                               String _noRBM,
                                                               String _kantorPelayanan,
                                                               String _noGardu,
                                                               String _paymentPoint,
                                                               String _tarip,
                                                               String _petugasPemutusan,
                                                               String _cekUrutanKolom,
                                                               String _cekUrutan,
                                                               String _maxJmlPK,
                                                               String _cekCetakanTiap);



    public Map<String, Object> AmbilTul603LampiranKriteria_pkg(String _unitup,
                                                               String _idpelAwal_A,
                                                               String _idpelAwal_B,
                                                               String _idpelAkhir_A,
                                                               String _idpelAkhir_B,
                                                               String _jumlahLembarAwal,
                                                               String _jumlahLembarAkhir,
                                                               String _rupiahTagihAwal,
                                                               String _rupiahTagihAkhir,
                                                               String _dayaAwal,
                                                               String _dayaAkhir,
                                                               String _kogolAwal,
                                                               String _kogolAkhir,
                                                               String _noRBM,
                                                               String _kantorPelayanan,
                                                               String _noGardu,
                                                               String _paymentPoint,
                                                               String _tarip,
                                                               String _petugasPemutusan,
                                                               String _cekUrutanKolom,
                                                               String _cekUrutan,
                                                               String _maxJmlPK,
                                                               String _cekCetakanTiap,
                                                               String _is60hari);



    public Map<String, Object> TulVI_Main_Eksekusi601_pkg(String _unitup,
                                                          String _idpelAwal_A,
                                                          String _idpelAwal_B,
                                                          String _idpelAkhir_A,
                                                          String _idpelAkhir_B,
                                                          String _jumlahLembarAwal,
                                                          String _jumlahLembarAkhir,
                                                          String _rupiahTagihAwal,
                                                          String _rupiahTagihAkhir,
                                                          String _dayaAwal,
                                                          String _dayaAkhir,
                                                          String _kogolAwal,
                                                          String _kogolAkhir,
                                                          String _noRBM,
                                                          String _kantorPelayanan,
                                                          String _noGardu,
                                                          String _paymentPoint,
                                                          String _tarip,
                                                          String _petugasPemutusan,
                                                          String _cekUrutanKolom,
                                                          String _cekUrutan,
                                                          String _maxJmlPK,
                                                          String _cekCetakanTiap);



    public Map<String, Object> TulVI_Main_Eksekusi601_RowCount_pkg(String _unitup,
                                                       String _idpelAwal_A,
                                                       String _idpelAwal_B,
                                                       String _idpelAkhir_A,
                                                       String _idpelAkhir_B,
                                                       String _jumlahLembarAwal,
                                                       String _jumlahLembarAkhir,
                                                       String _rupiahTagihAwal,
                                                       String _rupiahTagihAkhir,
                                                       String _dayaAwal,
                                                       String _dayaAkhir,
                                                       String _kogolAwal,
                                                       String _kogolAkhir,
                                                       String _noRBM,
                                                       String _kantorPelayanan,
                                                       String _noGardu,
                                                       String _paymentPoint,
                                                       String _tarip,
                                                       String _petugasPemutusan,
                                                       String _cekUrutanKolom,
                                                       String _cekUrutan,
                                                       String _maxJmlPK,
                                                       String _cekCetakanTiap);


    public Map<String, Object> TulVI_Main_Eksekusi603_pkg(String _unitup,
                                                          String _idpelAwal_A,
                                                          String _idpelAwal_B,
                                                          String _idpelAkhir_A,
                                                          String _idpelAkhir_B,
                                                          String _jumlahLembarAwal,
                                                          String _jumlahLembarAkhir,
                                                          String _rupiahTagihAwal,
                                                          String _rupiahTagihAkhir,
                                                          String _dayaAwal,
                                                          String _dayaAkhir,
                                                          String _kogolAwal,
                                                          String _kogolAkhir,
                                                          String _noRBM,
                                                          String _kantorPelayanan,
                                                          String _noGardu,
                                                          String _paymentPoint,
                                                          String _tarip,
                                                          String _petugasPemutusan,
                                                          String _cekUrutanKolom,
                                                          String _cekUrutan,
                                                          String _maxJmlPK,
                                                          String _cekCetakanTiap,
                                                          String _is60hari,
                                                          String noUrutAwal, String noUrutAkhir);



    public Map<String, Object> TulVI_Main_Eksekusi603_RowCount_pkg(String _unitup,
                                                       String _idpelAwal_A,
                                                       String _idpelAwal_B,
                                                       String _idpelAkhir_A,
                                                       String _idpelAkhir_B,
                                                       String _jumlahLembarAwal,
                                                       String _jumlahLembarAkhir,
                                                       String _rupiahTagihAwal,
                                                       String _rupiahTagihAkhir,
                                                       String _dayaAwal,
                                                       String _dayaAkhir,
                                                       String _kogolAwal,
                                                       String _kogolAkhir,
                                                       String _noRBM,
                                                       String _kantorPelayanan,
                                                       String _noGardu,
                                                       String _paymentPoint,
                                                       String _tarip,
                                                       String _petugasPemutusan,
                                                       String _cekUrutanKolom,
                                                       String _cekUrutan,
                                                       String _maxJmlPK,
                                                       String _cekCetakanTiap,
                                                       String _is60hari);



    public Map<String, Object> TulVI_Main_Eksekusi601_RPT_pkg(String _unitup,
                                                              String _idpelAwal_A,
                                                              String _idpelAwal_B,
                                                              String _idpelAkhir_A,
                                                              String _idpelAkhir_B,
                                                              String _jumlahLembarAwal,
                                                              String _jumlahLembarAkhir,
                                                              String _rupiahTagihAwal,
                                                              String _rupiahTagihAkhir,
                                                              String _dayaAwal,
                                                              String _dayaAkhir,
                                                              String _kogolAwal,
                                                              String _kogolAkhir,
                                                              String _noRBM,
                                                              String _kantorPelayanan,
                                                              String _noGardu,
                                                              String _paymentPoint,
                                                              String _tarip,
                                                              String _petugasPemutusan,
                                                              String _cekUrutanKolom,
                                                              String _cekUrutan,
                                                              String _maxJmlPK,
                                                              String _cekCetakanTiap,
                                                              String _isCetakUlang);


    public Map<String, Object> TulVI_Main_Eksekusi603_RPT_pkg(String _unitup,
                                                              String _idpelAwal_A,
                                                              String _idpelAwal_B,
                                                              String _idpelAkhir_A,
                                                              String _idpelAkhir_B,
                                                              String _jumlahLembarAwal,
                                                              String _jumlahLembarAkhir,
                                                              String _rupiahTagihAwal,
                                                              String _rupiahTagihAkhir,
                                                              String _dayaAwal,
                                                              String _dayaAkhir,
                                                              String _kogolAwal,
                                                              String _kogolAkhir,
                                                              String _noRBM,
                                                              String _kantorPelayanan,
                                                              String _noGardu,
                                                              String _paymentPoint,
                                                              String _tarip,
                                                              String _petugasPemutusan,
                                                              String _cekUrutanKolom,
                                                              String _cekUrutan,
                                                              String _maxJmlPK,
                                                              String _cekCetakanTiap,
                                                              String _is60hari,
                                                              String _isCetakUlang);


    public Map<String, Object> AmbilBuatCetakUlangTul601Kriteria_usingRef_pkg(String unitup,
                                                                              String _noPelangganAwal,
                                                                              String _noPelangganAkhir,
                                                                              String _jumlahLembarAwal,
                                                                              String _jumlahLembarAkhir,
                                                                              String _rupiahTagihAwal,
                                                                              String _rupiahTagihAkhir,
                                                                              String _besarDayaAwal,
                                                                              String _besarDayaAkhir,
                                                                              String _kodeGolonganAwal,
                                                                              String _kodeGolonganAkhir,
                                                                              String _noRBM,
                                                                              String _kantorPelayanan,
                                                                              String _petugasPemutusan,
                                                                              String _noKontrol,
                                                                              String _namaGardu,
                                                                              String _paymentPoint,
                                                                              String _tarif);



    public Map<String, Object> PetugasWaskitRBM_AmbilData(String _unitup,
                                                          String _group,
                                                          String _petugas);


    public Map<String, Object> PetugasWaskitRBM_Simpan(String unitup,
                                           String namagroup,
                                           String namapetugas,
                                           String noRbm,
                                           String statusaktif,
                                           String keterangan,
                                           String created_by);


    public Map<String, Object> PetugasWaskitRBM_Aktifkan(String unitup,
                                             String namagroup,
                                             String namapetugas,
                                             String noRbm);


    public Map<String, Object> PetugasWaskitRBM_NonAktifkan(String unitup,
                                                String namagroup,
                                                String namapetugas,
                                                String noRbm);

    //waskit

    public Map<String, Object> ambilDetailTul601_Pemutusan(String _strtgl,
                                                           String _noTulAwal,
                                                           String _noTulAkhir,
                                                           String _unitup);


    public Map<String, Object> ambilDetailTul603_Pembongkaran(String _strtgl,
                                                              String _noTulAwal,
                                                              String _noTulAkhir,
                                                              String _unitup);

    public Map<String, Object> ambilDetailTul601_Penyambungan(String strtgl,
                                                              String noTul,
                                                              String unitup);


    public Map<String, Object> TulVI_Eksekusi_Lapangan_Bongkar_Simpan(Date _tglbongkar,
                                                         String _namabongkar,
                                                         String _lwbp,
                                                         String _wbp,
                                                         String _kvarh,
                                                         String _idpelanggan,
                                                         String _no60,
                                                         Date _tgl603,
                                                         String _no603,
                                                         String _unitUp,
                                                         Date _tglkode3,
                                                         String _nokode3,
                                                         String _transaksiby);

    public Map<String, Object> AmbilBuatCetakUlangTul601Kriteria_usingRef_pkg(String _unitup,
                                                                       String _idpelAwal_A,
                                                                       String _idpelAwal_B,
                                                                       String _idpelAkhir_A,
                                                                       String _idpelAkhir_B,
                                                                       String _jumlahLembarAwal,
                                                                       String _jumlahLembarAkhir,
                                                                       String _rupiahTagihAwal,
                                                                       String _rupiahTagihAkhir,
                                                                       String _dayaAwal,
                                                                       String _dayaAkhir,
                                                                       String _kogolAwal,
                                                                       String _kogolAkhir,
                                                                       String _noRBM,
                                                                       String _kantorPelayanan,
                                                                       String _noGardu,
                                                                       String _paymentPoint,
                                                                       String _tarip,
                                                                       String _petugasPemutusan,
                                                                       String _cekUrutanKolom,
                                                                       String _cekUrutan,
                                                                       String _maxJmlPK,
                                                                       String _cekCetakanTiap);
}
