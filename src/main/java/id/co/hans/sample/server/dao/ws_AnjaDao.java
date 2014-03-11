package id.co.hans.sample.server.dao;

import java.util.Date;
import java.util.Map;

public interface ws_AnjaDao {
    //---- ### START WASKIT ####################################################################################
    public Map<String, Object> sp_waskit_verifikasi(Integer nav);
    public Map<String, Object> ambilNomerTulVI01(String unitUp);
    public Map<String, Object> insertTulVI01(Integer No_60,
                                 String UnitUP, String ThBlRek, String IdPelanggan,
                                 String NoKontrak, String NoKontrol, String Nama,
                                 String Alamat, String ThBlRek_akhir,
                                 String Lembar_601, String Tagihan_601, String NOtul601);
    public Map<String, Object> AmbilTul601(String unitUp, String sqlKriteria);

    //---- Laporan VI-03
    public Map<String, Object> ambilDaftarPantauCetak603(String unitUp, Date awal, Date akhir);

    //---- Laporan VI-01
    public Map<String, Object> ambilDaftarPantauCetak601(String unitUp, Date awal, Date akhir);
    public Map<String, Object> ambilRekapPantauCetak601(String unitUp, Date awal, Date akhir);
    public Map<String, Object> ambilDaftar601Lunas(String unitUp, Date awalPk, Date akhirPk, Date awalLns, Date akhirLns);
    public Map<String, Object> ambilRekap601Lunas(String unitUp, Date awalPk, Date akhirPk, Date awalLns, Date akhirLns);
    public Map<String, Object> ambilTulVIperNamaPutus(String nama, Date tglAwal, Date tglAkhir);
    public Map<String, Object> ambilDetailTulVIperNamaPetugas(String nama, Date tglAwal, Date tglAkhir);
    public Map<String, Object> ambilTulVIRekapKinerja(String unitup, Date tglAwal, Date tglAkhir);
    public Map<String, Object> ambilTulVIperIdPel(String idpel);
    public Map<String, Object> ambil601BelumLunas(String unitUp, Date awal, Date akhir);
    public Map<String, Object> AmbilTul601CetakUlang(String unitUp, Date tglPk, Date noAwal, Integer noAkhir);
    public Map<String, Object> AmbilTul601Lampiran(String unitUp, Date tglPk, Integer noTul);

    //---- Tul VI-03
    public Map<String, Object> ambilNomerTulVI03(String unitUp);
    public Map<String, Object> AmbilTul603(Boolean is60hari, String unitUp, String sqlKriteria);
    public Map<String, Object> insertTulVI03(Integer No_60, Integer no_601,
                                 String UnitUP, String ThBlRek, String IdPelanggan,
                                 String NoKontrak, String NoKontrol, String Nama,
                                 String Alamat, String ThBlRek_akhir,
                                 String Lembar_603, String Tagihan_603, String NOtul603, String NOtul601, Date tglTul601);
    public Map<String, Object> ambilCetakKertasTulVI() ;

    //---- Pemutusan Penyambungan
    public Map<String, Object> ambilDetailTul601(String strtgl, String noTul);
    public Map<String, Object> simpanPutus(Date tglPutus, String namaPutus, String lwbp, String wbp, String kvarh, Date tgl601, String no601, String unitUp);
    public Map<String, Object> simpanSambung(Date tglsambung, String namasambung, String lwbp, String wbp, String kvarh, Date tgl601, String no601, String unitUp);
    public Map<String, Object> AmbilBuatCetakTul603(String txtIdpel, String unitUp, String sqlKriteria);
    public Map<String, Object> AmbilBuatCetakUlangTul603(String unitUp, Date TglPk, Integer noTul);

    //---- Penanganan Petugas
    public Map<String, Object> simpanGroup(String unitup, String namagroup, String deskripsi, String jenisgroup, String statusaktif, String created_by);
    public Map<String, Object> simpanPetugas(String unitup, String namapetugas, String keterangan, String namagroup, String statusaktif, String created_by);
    public Map<String, Object> lihatGroup();
    public Map<String, Object> lihatPetugas();
    public Map<String, Object> nonAktifGroup(String group);
    public Map<String, Object> nonAktifPetugas(String petugas);
    public Map<String, Object> ambilPetugasWaskit();
    public Map<String, Object> ambilGroupPetugas();
    public Map<String, Object> simpanPenugasan(String unitup, String no_pk_sambung, String pemberi_material, String no_pk_tul6, String petugas_sambung, String material1, String material2, String material3, String keterangan, String created_by);
    public Map<String, Object> hapusPenugasan(String noPkSambung);
    public Map<String, Object> lihatPenugasan(String unitUp);

    //---- Distribusi PK per-Petugas
    public Map<String, Object> simpanDistribusiPKPutus(String unitup, String tgltul, String notul, String iKodePetugas, String petugas);
    public Map<String, Object> simpanDistribusiPKBongkar(String unitup, String tgltul, String notul, String iKodePetugas, String petugas);
    public Map<String, Object> lihatDistribusiPKPutus(String sqlKriteria);
    public Map<String, Object> lihatDistribusiPKBongkar(String sqlKriteria);
    public Map<String, Object> AmbilTul601_incl_sdh_ctk(String unitUp, String sqlKriteria);
    //---- ### END WASKIT ####################################################################################


    //---- ### START BELI REKENING ANJA ####################################################################################
    public Map<String, Object> beliAnja_TampilGrid( String unitup, String sqlKriteria);
    public Map<String, Object> beliAnja_LunasiDPP21( Map<String, Object> dtrans, String tTransaksiBy, String tTglBayar, String tKdPP, String tKdPembayar);
    public Map<String, Object> rptVIEW_BA21_ANJA( String unitup, String tgltransaksi, String tglbayar, String kdpp, String transaksiby);
    public Map<String, Object> rptVIEW_BA21Daftar_ANJA( String unitup, String tgltransaksi, String tglbayar, String kdpp, String transaksiby);
    //---- ### END BELI REKENING ANJA ####################################################################################


    //---- ### START UPLOAD LUNAS REKENING ANJA ####################################################################################
    public Map<String, Object> SetData_21LUNASIANJA(Map<String, Object> dtrans, String tTransaksiBy,  String tTglBayar, String tKdPP);
    public Map<String, Object> SetData_21INSERTANJA(Map<String, Object> dtrans, String tTransaksiBy);
    public Map<String, Object> DeleteDPHOFFLINE(Map<String, Object> dr, String tTRANSAKSIBY);
    public Map<String, Object> InsertTempDPHOFFLINE(Map<String, Object> dr, String tTRANSAKSIBY);
    public Map<String, Object> SetData_21UPDATEANJA(String tTransaksiBy,  String tTglBayar, String tKdPP);
    public Map<String, Object>  Convert2SQL_DKRP(Object Value );
    public Map<String, Object>  Convert2SQL_DKRP(Object Value , Boolean UsedLongDate);
    public Map<String, Object> rptVIEW_BA21_LUNASIANJA( String unitup, String tgltransaksi, String tglbayar, String kdpp, String transaksiby);
    //---- ### END UPLOAD LUNAS REKENING ANJA ####################################################################################

}
