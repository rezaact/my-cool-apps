package id.co.hans.sample.server.dao;

import java.util.Date;
import java.util.Map;

public interface ws_InterfaceDao {


    public Map<String, Object> simpanDPHLoad_AJN(String idPel,
                                     String blth,
                                     String tglbayar,
                                     String rptag,
                                     String rpbk,
                                     String ipaddress);

    public Map<String, Object> simpanDPHLoads(String idPel,
                                  String blth,
                                  String kdpembpp,
                                  String unitup,
                                  String kdpp,
                                  String kdgerak,
                                  String tglbayar,
                                  String refno,
                                  String rptag,
                                  String rpbk,
                                  String layerke,
                                  String ipaddress,
                                  String tglupload,
                                  String noupload);

    public Map<String, Object> simpandphload_2(String idPel,
                                   String kdpembpp,
                                   String unitup,
                                   String kdpp,
                                   String kdgerak,
                                   String refno,
                                   String rpbk,
                                   String layerke,
                                   String ipaddress,
                                   String noupload,
                                   Integer type_rekening);

    public Map<String, Object> simpanddphload_Kolektif(String kdpembpp,
                                           String unitup,
                                           String kdpp,
                                           String kdgerak,
                                           String refno,
                                           String rpbk,
                                           String layerke,
                                           String ipaddress,
                                           String noupload,
                                           String kdkol);

    public Map<String, Object> bl_th_tagihan(String blthrek);

    public Map<String, Object> fg_tgl_jatuh_tempo(String blth,
                                     String kode_ranting_numerik);

    public Map<String, Object> getData(String strQuery);

    public Map<String, Object> setData(String strQuery);

    public Map<String, Object> isiDKRPLoad(String no_pelanggan,
                               String uraian,
                               String ipaddress,
                               String tglkonsld,
                               Integer konsldke,
                               Integer layerke);

    public Map<String, Object> rptBaOffline(String TglLunas,
                                String petugas);

    public Map<String, Object> rptRkpPelunasanHarian(String tglmulai,
                                         String tglselesai,
                                         String petugas);

    public Map<String, Object> rptRkpPelunasanPeriode(String tglmulai,
                                          String tglselesai, String petugas);

    public Map<String, Object> simpanDPHLoad(String idPel,
                                 String blth,
                                 String kdpembpp,
                                 String unitup,
                                 String kdpp,
                                 String kdgerak,
                                 String tglbayar,
                                 String refno,
                                 String rptag,
                                 String rpbk,
                                 String layerke,
                                 String ipaddress,
                                 String tglupload,
                                 String noupload);

    public Map<String, Object> simpanDpdtLoad(String idpel,
                                  String blth,
                                  String kdkoreksi,
                                  String ipaddress,
                                  String KRM,
                                  String TRM);

    public Map<String, Object> simpanDpdtLoadTERIMA(String idpel,
                                        String ur);

    public Map<String, Object> simpanDKRPLoadS(String no_pelanggan,
                                   String blth,
                                   String URAIAN,
                                   String ipaddress,
                                   String kodegerak);

    public Map<String, Object> simpanDKRPLoad(String idpel,
                                  String blth,
                                  String kdkoreksi,
                                  String ipaddress);

    public Map<String, Object> simpandkrpload_Krk_kd_golongan(String kdkol,
                                                  String ipaddress);

    public Map<String, Object> simpanDKRPL(String idpel,
                               String no_kwitansi,
                               String IPADDRESS);

    public Map<String, Object> simpanDBPLoad(String nopelanggan,
                          String blth,
                          String ipaddress,
                          String kodegerak);

    public Map<String, Object> uploadKe(String jenisdata);

    public Map<String, Object> uploadKeAJN();

    public Map<String, Object> kodeKoreksi(String alasan);

    public Map<String, Object> bl_th(String blth);

    public Map<String, Object> setRek_Sorek(String procedureName,
                               String unitup,
                               String blth);

    public Map<String, Object> setLunas(String petugas);

    public Map<String, Object> setSaldo(String baris_txt);

    public Map<String, Object> getUraian(String blth);

    public Map<String, Object> getBlThRekening(String blth);

    public Map<String, Object> cekrekbermasalah(String tgllunas,
                                    String idpel,
                                    String sbb);

    public Map<String, Object> setPelunasanOffline(String strread,
                                      String strGlobalKodePetugas,
                                      String ipaddress);

    //ADDED BY DJAINUL
    public Map<String, Object> InsertDPPfromSOREK(String CustomConnectionString,
                                      String pUNITUP,
                                      String pBLTH);

    public Map<String, Object> doRekapSOREK(String CustomConnectionString,
                                String pUNITUP,
                                Date pTGLKONSLD);

    public Map<String, Object> doRekapDPP(String CustomConnectionString,
                              String pUNITUP,
                              Date pTGLKONSLD);

}
