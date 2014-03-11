package id.co.hans.sample.server.dao;

import java.util.List;
import java.util.Map;

public interface ws_JateliconDao {

//    public String HelloWorld();

    public Map<String, Object> getPelangganKoreksi(String sIdpel,
                                                   String sBlth,
                                                   String sKDKoreksi);

    public Map<String, Object> setPelangganKoreksi(List<Map<String, String>> sRsXML,
                                                   String sUserTrans,
                                                   String sKDKoreksi);

    public Map<String, Object> setBatalKoreksi(String sIdpel,
                                               String sBlth,
                                               String sUserKoreksi,
                                               String sTglKoreksi,
                                               String sAlasan);

    public Map<String, Object> getInfoPelanggan(String sIdpel);

    public Map<String, Object> getNotul603(String sIdpel);

    public Map<String, Object> getPelangganLunas(String sIdpel,
                                                 String sBlth);

    public Map<String, Object> setLunasKoreksi(String sIdpel,
                                               String sBlth,
                                               String sPetugas,
                                               String sKdpp,
                                               Double dRptag,
                                               String sTglBayar,
                                               String sWktBayar,
                                               String sUnitlunas);

    public Map<String, Object> getPelangganBatalLunasKoreksi(String sIdpel,
                                                             String sBlth);


    public Map<String, Object> setBatalLunasKoreksi(String sIdpel,
                                                    String sBlth,
                                                    String sPetugasLns,
                                                    String sPetugasBatal,
                                                    String sAlasan);

    public Map<String, Object> getInfoDPPPelanggan(String sIdpel,
                                            String sBlth);

}
