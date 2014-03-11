package id.co.hans.sample.server.dao;

import java.util.Date;
import java.util.Map;

public interface ws_UmumDao {
    public Map<String, Object> ambilTanggalHariIni();
    public Map<String, Object> cariUraian(Date jthtempo);
    public Map<String, Object> cariUraianAsli(Date jthtempo);
    public Map<String, Object> cariNoKont_dari_Nopel(String nopel);
    public Map<String, Object> CariTerbilang(Double numerik);
    public Map<String, Object> UraianKeTahunBulan(String Uraianinput);
    public Map<String, Object> CariIDPELdariKONTRAK(String kont);
    public Map<String, Object> CariIDPELdariKONTROL(String kont);
    public Map<String, Object> AmbilDILPelanggan(String idpel);
    public Map<String, Object> lihatNAMAPPdariKODEPP(String kodepp);
    public Map<String, Object> RubahTanggal(Date picker);
    public Map<String, Object> createNoAgenda(String ikdupnumerik);
    public Map<String, Object> cariJatuhTempo(Date tgl, String kdupnumerik);
    public Map<String, Object> cariJatuhTempoSiklis(String idpel, Date tgl);
    public Map<String, Object> ambilUNITUPdariIDPEL(String idpel);
    public Map<String, Object> ambilKODESIKLISdariIDPEL(String idpel);
    public Map<String, Object> AmbilKodePP();
    public Map<String, Object> ambilBulanMinusSatu(String thbl);
    public Map<String, Object> ambilBulanTambahSatu(String thbl);
    public Map<String, Object> cariJatuhTempoDariBulan(String thbl, String kdupnumerik);
    public Map<String, Object> ambilDataSetRANTINGRAYONsemua();
    public Map<String, Object> ambilDataSetRANTINGRAYONunitdefault();

    //--- Parameter Euy
    public Map<String, Object> ambilKODEUNITdefault();
    public Map<String, Object> ambilKODECABANGdefault();
    public Map<String, Object> ambilKODEWILAYAHdefault();
    //--- End Euy

    //--- Parameter Report
    public Map<String, Object> ambilNAMAUNITdefault();
    public Map<String, Object> ambilNAMACABANGdefault();
    public Map<String, Object> ambilNAMAWILAYAHdefault();
    public Map<String, Object> ambilALAMATdefault();
    //--- End Report

    public Map<String, Object> ambilTanggalDariTHBL(String thbl);
    public Map<String, Object> ambilNamaUnitDariKodeUnit(String kodeunit);

    //--- Start REFERENSI
    public Map<String, Object> ref_AmbilInduk();
    public Map<String, Object> ref_AmbilCabang(String induk);
    public Map<String, Object> ref_AmbilRanting(String cabang);
    public Map<String, Object> ref_AmbilRantingDngnSemua(String cabang);
    public Map<String, Object> ref_AmbilPaymentPoint(String ranting);
    public Map<String, Object> ref_AmbilPetugas(String pp);
    public Map<String, Object> ambilTanggalDatabase();
    public Map<String, Object> ambilNamaApdariUp(String unitUp);
    public Map<String, Object> getNamaApDariUP(String unitUP);
    public Map<String, Object> ambilNamaKddariUp(String unitUp);
    public Map<String, Object> getNamaKdDariUP(String UnitUp);
    public Map<String, Object> ambilNamaKddariAP(String unitAp);
    public Map<String, Object> ambilNamaAP(String unitAp);
    public Map<String, Object> ambilAlamatdariUp(String unitUp);
    public Map<String, Object> getAlamatdariUP(String Unitup);
    public Map<String, Object> ambilIDPELfromKONTRAKKONTROLDIL(String kontrak, String kontrol);
    public Map<String, Object> ambilUnitUPdariPetugas(String petugas);
    public Map<String, Object> ambilKodePPdariUnitUP(String unitup);
    public Map<String, Object> ambilUnitUp();
    public Map<String, Object> ambilNamaUp(String unitUp);
    public Map<String, Object> getNamaUP(String UnitUP);
    //public String getNamaUP(String UnitUP);
    public Map<String, Object> ambilNamaPaymentPointdariKodePp(String kodepp);
    public Map<String, Object> getPetugasDariTableUsers(String strData);
    public Map<String, Object> getPiutangInfo(String[] clsAR); //SOPPserver_vb.clsReturnValue
    public Map<String, Object> getPelunasanIndividu(String JENPIUTANG, String[] clsAR); //SOPPserver_vb.clsReturnValue
    public Map<String, Object> Inform(String idpel);
    public Map<String, Object> dsOracle(String mSql, String dsName);
    public Map<String, Object> cariPelIndividu(clsPelunasan clsPel);
    public Map<String, Object> carMasterPelangganIndividu(clsPelunasan clsPel);
    public Map<String, Object> getDil(clsDPP clsdpp);
    public Map<String, Object> getDPPIndividu(clsDPP clsdpp);

    public Map<String, Object> ConnOracle();

    public Map<String, Object> caridilinfo(clsPelunasan clsPel);
    public Map<String, Object> carDPPInfo(clsPelunasan clsPel);
    public Map<String, Object> getDPPinfo(clsDPP clsdpp);
    public Map<String, Object> getDilinfo(clsDPP clsdpp);
    public  Map<String, Object>  ambilKodesiklis(String unitUp);
    public Map<String, Object>  ambilPejabatID01(String unitUp);
    public Map<String, Object>  ambilPejabatID02(String unitUp);
    public Map<String, Object> cetakInfo(String Idpel, String BlnAwal, String BlnAkhir);
    public Map<String, Object> cetakInvoice(String Idpel, String BlnAwal, String BlnAkhir);
    public Map<String, Object> getMasterKolektif();
    public Map<String, Object> LihatHistoTrans(String Idpel, String BLTH);
}
