package id.co.hans.sample.server.dao;

import java.util.Map;

public interface ws_CreditNoteDao {

    public Map<String, Object> ambilNamaBank(String unitup);

    public Map<String, Object> ambilDataCN(String unitup,
                                           String kdpp, String tglbayar);

    public Map<String, Object> ambilDataCNPengelola(String unitup,
                                                    String kdpengelola, String tglbayar);

    public Map<String, Object> ambilDataCNPetugas(String unitup,
                                                  String kdpp, String tglbayar, String ptgbayar);

    public Map<String, Object> isCNExist(String kdpp, String tglbayar);
    public Map<String, Object> isCNPengelolaExist(String kdpengelola, String tglbayar);
    public Map<String, Object> isCNPetugasExist(String kdpp, String tglbayar, String ptglunas);
    public Map<String, Object> isCNPetugasExist(String kdpp, String tglbayar);

    public Map<String, Object> simpanDataCN(Map<String, Object> ds, Boolean bEdit);
    public Map<String, Object> simpanDataCNPengelola(Map<String, Object> ds, Boolean bEdit);
    public Map<String, Object> simpanDataCNPerPetugas(Map<String, Object> ds, Boolean bEdit);
    public Map<String, Object> ambilFormatCN();
    public Map<String, Object> ambilFormatCNPengelola();
    public Map<String, Object> ambilFormatCNPerPlg();
    public Map<String, Object> ambilRekapCN(String Jenis, String unitup, String kodepp, String tglAwal, String tglAkhir);
    public Map<String, Object> ambilDataDanaperTglPp(String unitup, String kodepp, String tglAwal, String tglAkhir);
}
