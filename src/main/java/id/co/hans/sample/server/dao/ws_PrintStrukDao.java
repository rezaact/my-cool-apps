package id.co.hans.sample.server.dao;

import java.util.Map;

public interface ws_PrintStrukDao {
    public Map<String, Object> cetakRekg12(String tTgKoreksi, String tIdpel, String tBlth, String tNorek);
    public Map<String, Object> cetakRekg41(String tTgKoreksi, String tIdpel, String tBlth, String tNorek);
    public Map<String, Object> cetakRekg12D(String tKodePetugas,
                                     String tIDPEL,
                                     String tBLTH);
    public Map<String, Object> cetakRekg23(String tTglbayar, String tIdpel, String tBlth, String tNorek);
    public Map<String, Object> cetakRekg31(String tTglbayar, String tIdpel, String tBlth, String tNorek);
    public Map<String, Object> cetakRekg32(String tTglbayar, String tIdpel, String tBlth, String tNorek);
    public Map<String, Object> cetakRekg21(String tTglbayar, String tIdpel, String tBlth, String tNorek);
    public Map<String, Object> cetakRekg21Giralisasi(String tTglBayar,
                                              String tKDPP,
                                              String tKodeGiral);
    public Map<String, Object> cetakRekg21NotaBuku( String tKodePetugas,
                                             String tKodeNota, String tUnitup);
    public Map<String, Object> cetakRekg21NotaTerpusat(String tKodePetugas,
                                                String tKodeNota,
                                                String tUnitup);
    public Map<String, Object> cetakRekg21EntriLunas(String tKodePetugas,
                                              String tIDPEL,
                                              String tBLTH);
    public Map<String, Object> getCetul_21Giralisasi(String strPetugas,
                                              String sKodeKolektif, String sTglLunas,
                                              String sKDPP);
    public Map<String, Object> SetCetul_21Giralisasi(Map<String, Object> dsTrans);
    public Map<String, Object> getCetul_23NotaBuku(String strPetugas,
                                            String sKodeKolektif,
                                            String sTglLunas, String tUnitup);
    public Map<String, Object> SetCetul_23NotaBuku(Map<String, Object> dsTrans);
    public Map<String, Object> getCetul_23Terpusat(String strPetugas,
                                            String sKodeKolektif, String sTglLunas,
                                            String sUnitup);
    public Map<String, Object> SetCetul_23Perpusat(Map<String, Object> dsTrans);
}
