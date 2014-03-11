package id.co.hans.sample.server.dao;

import java.util.Map;

public interface ws_BatalTransaksiDao {


    public Map<String, Object> HelloWorld();
    public Map<String, Object> BatalTransaksi_idpel(String Transaksi,
                                                    String tpel,
                                                    String vJenis,
                                                    String tKode,
                                                    String tPetugas,
                                                    String tblthbuku);
    public Map<String, Object> SetDataIdpelBatal_11(Map<String, Object> dtrans,
                                             String tTransaksiBy,
                                             String tAlasan,
                                             String tglTransaksi);
    public Map<String, Object> SetDataIdpelBatal_12ABCG(Map<String, Object> dtrans,
                                                        String tTransaksiBy,
                                                        String tAlasan,
                                                        String tglTransaksi);
    public Map<String, Object> SetDataIdpelBatal_12DSuplisi(Map<String, Object> dtrans,
                                                            String tTransaksiBy,
                                                            String tAlasan,
                                                            String tglTransaksi);
    public Map<String, Object> SetDataIdpelBatal_12DRestitusi(Map<String, Object> dtrans,
                                                              String tTransaksiBy,
                                                              String tAlasan,
                                                              String tglTransaksi);
    public Map<String, Object> SetDataIdpelBatal_13(Map<String, Object> dtrans,
                                                    String tTransaksiBy,
                                                    String tAlasan,
                                                    String tglTransaksi);
    public Map<String, Object> SetDataIdpelBatal_21(Map<String, Object> dtrans,
                                                    String tTransaksiBy,
                                                    String tAlasan,
                                                    String tglTransaksi);
    public Map<String, Object> SetDataIdpelBatal_21Suplisi(Map<String, Object> dtrans,
                                                           String tTransaksiBy,
                                                           String tAlasan,
                                                           String tglTransaksi);
    public Map<String, Object> SetDataIdpelBatal_23NOTA(Map<String, Object> dtrans,
                                                        String tTransaksiBy,
                                                        String tAlasan,
                                                        String tglTransaksi);
    public Map<String, Object> SetDataIdpelBatal_23DLT(Map<String, Object> dtrans,
                                                       String tTransaksiBy,
                                                       String tAlasan,
                                                       String tglTransaksi);
    public Map<String, Object> SetDataIdpelBatal_31(Map<String, Object> dtrans,
                                                    String tTransaksiBy,
                                                    String tAlasan,
                                                    String tglTransaksi);
    public Map<String, Object> SetDataIdpelBatal_41(Map<String, Object> dtrans,
                                                    String tTransaksiBy,
                                                    String tAlasan,
                                                    String tglTransaksi);
    public Map<String, Object> SetDataIdpelBatal_32(Map<String, Object> dtrans,
                                                    String tTransaksiBy,
                                                    String tAlasan,
                                                    String tglTransaksi);
    public Map<String, Object> SetDataIdpelBatal_23Kirim(Map<String, Object> dtrans,
                                                         String tTransaksiBy,
                                                         String tAlasan,
                                                         String tglTransaksi);
    public Map<String, Object> SetDataIdpelBatal_23Terima(Map<String, Object> dtrans,
                                                          String tTransaksiBy,
                                                          String tAlasan,
                                                          String tglTransaksi);
    public Map<String, Object> SetDataIdpelBatal_CicilRek(Map<String, Object> dtrans,
                                                          String tTransaksiBy,
                                                          String tAlasan,
                                                          String tglTransaksi);
    public Map<String, Object> SetDataIdpelBatal_23NOTA_Each(String _inTransaksiBy,
                                                             String _inIdpel,
                                                             String _inKdPembPP,
                                                             String _inKdGerakKeluar,
                                                             String _inBlth,
                                                             String _inStatus,
                                                             String _inNorek,
                                                             String _inAlasan,
                                                             String _inTglBayar,
                                                             String _inTransaksiId);
}
