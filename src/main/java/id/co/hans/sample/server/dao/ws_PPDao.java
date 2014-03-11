package id.co.hans.sample.server.dao;

import java.util.Date;
import java.util.Map;

public interface ws_PPDao {

    public Map<String, Object> getData(String strQuery);
    public Map<String, Object> setData(String strQuery);

    public Map<String, Object> getKodeRanting(String namaranting);

    public Map<String, Object> savedistempbakirim(Map<String, Object> d,
                                     String blth);

    public Map<String, Object> getNoPelanggan(String s);

    public Map<String, Object> insertdilmeter(String s);

    public Map<String, Object> insertdilsl(String s);


    public Map<String, Object> insertDil(String s);

    public Map<String, Object> getDataDILmeter(String no_pelanggan);


    public Map<String, Object> getDataDILsl(String no_pelanggan);

    public Map<String, Object> getDataDIL(String no_pelanggan);

    public Map<String, Object> saveDisTemp4(String NO_PELANGGAN,
                                            Integer BULAN,
                                            Integer TAHUN);

    public Map<String, Object> saveDisTemp3(String no_agenda,
                               Date tanggal);



    public Map<String, Object> saveDisTemp2(String no_pelanggan,
                               String nmpiutang);

    public Map<String, Object> getCustomersInfo(String strParam,
                                                Byte bytIDX);

    public Map<String, Object> getCustomersPDLPB(String strParam);

    public Map<String, Object> getCustomersPiutang(String strNoPelanggan);

    public Map<String, Object> setSimpanPDLPB(clsPiutangLain objPiutang);

    public clsPiutangLain getInfoPDLPB(String strNoAgenda );

    public Map<String, Object> setSimpanDIS(clsPiutangLain objPiutang);

    public Map<String, Object> setSimpanREKAPPLL(clsPll objPll);

    public Map<String, Object> setSimpanDISBaru(clsPiutangLain objPiutang,
                                   String atasDasar);

    public Map<String, Object> validatePelanggan(String No_pelanggan);

    public Map<String, Object> saveBeritaAcaraNonRekening(clsPiutangLain objPiutang);

    public Map<String, Object> setSimpanDISManual(String noplg,
                                     String noktr,
                                     String tgljatuhtempo,
                                     String uraian,
                                     String petugas,
                                     Map<String, Object> dsPiutang,
                                     String Status,
                                     String ket);


    public Map<String, Object> setSimpanDISRaguManual(String noplg,
                                         String noktr,
                                         String tgljatuhtempo,
                                         String uraian,
                                         String petugas,
                                         Map<String, Object> dsPiutang);


    public Map<String, Object> setSimpanDILDATASTANDMETERManual(String noplg,
                                                   String noktr,
                                                   String faktor_kali,
                                                   String blth,
                                                   Float awal1,
                                                   Float akhir1,
                                                   Float awal2,
                                                   Float akhir2,
                                                   Float awal3,
                                                   Float akhir3,
                                                   Float total1,
                                                   Float total2,
                                                   Float total3,
                                                   Float totalkwh,
                                                   String tarif,
                                                   String petugas,
                                                   String norek);

    public Map<String, Object> setSimpanDetilBA(clsPiutangLain objPiutang,
                                   Map<String, Object> dsCicilan);



    public Map<String, Object> setSimpanDISCicilan(clsPiutangLain objPiutang,
                                      Map<String, Object> dsCicilan);

    public Map<String, Object> setSimpanDILDataStandMeter(String no_agenda,
                                             String no_pelanggan,
                                             String no_kontrak,
                                             String kode_petugas,
                                             Integer total_kwH,
                                             String blthrek);

    public Map<String, Object> getGenerateNoAgendaPDLPB(String NAMA_RANTING);

    public Map<String, Object> getNoAgendaUntukAdministrasiOPAL(String no_pelanggan);
    public Map<String, Object> getGenerateNoAgenda(Date tgl);

    public Map<String, Object> getKodePerkiraan(String kodeGolongan,
                                   String namaPiutang);

    public Map<String, Object> getKodePerkiraanManual(String kodeGolongan);

    public Map<String, Object> cleardistempbakirim();
    public Map<String, Object> cleardistemp3();
    public Map<String, Object> cleardistemp2();
    public Map<String, Object> cekTanggalJatuhTempo(String no_pelanggan,
                                       String thn,
                                       String bln);
    public Map<String, Object> getRincian();
    public Map<String, Object> setSimpanKoreksiStatusPiutang(String sJenisKoreksi,
                                                String sIdPel,
                                                String sTglLunas,
                                                String nTotalMutasi,
                                                String sPetugas,
                                                String sBlthRek,
                                                String sDasarStatus);
    public Map<String, Object> setSimpanKoreksiStatusPiutang2(String sJenisKoreksi,
                                                 String sIdPel,
                                                 String sTglLunas,
                                                 String nTotalMutasi,
                                                 String sPetugas,
                                                 String sBlthRek,
                                                 String sDasarStatus);


    public Map<String, Object> getnmkirim(String kdkrm);

    public Map<String, Object> Getcekadakirim(String kdkirim,
                                  String noplg,
                                  String bl_th_rek);


    public Map<String, Object> setinsertdatakirim(String kdkirim,
                                      String nmkirim,
                                      String noplg,
                                      String bl_th_rek);

    public Map<String, Object> setinsertdatakirim1(String kdkirim,
                                       String nmkirim,
                                       String noplg,
                                       String bl_th_rek);

    public Map<String, Object> sethapusdatakirim(String kdkirim,
                                     String noplg,
                                     String bulanrek);

    public Map<String, Object> ValidateDilDSMeter(String no_pelanggan,
                                      String BlnTahun);


    public String[] GetDilDSMeterGanda(String BlnThnRek,
                                       String No_Pelanggan);


    public Map<String, Object> GetDilDSMeterTunggal(String BlnThnRek,
                                       String No_Pelanggan);

    public Map<String, Object> getKodeCabang(String namaranting);

    public Map<String, Object> ExecuteSQL(String strSQL);

}
