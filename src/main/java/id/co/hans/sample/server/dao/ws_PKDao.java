package id.co.hans.sample.server.dao;

import java.util.Date;
import java.util.Map;

public interface ws_PKDao {
    public Map<String, Object> setSimpanCreditNote(String nocn,
                                      Date tgl,
                                      String kodebank,
                                      String kodepp,
                                      Double mutasi,
                                      String kodePetugas,
                                      String kb,
                                      String blth);
    public Map<String, Object> getRanting(String strKodeCabang);
    public Map<String, Object> getPP(String strKodeRanting);
    public Map<String, Object> getInduk();
    public Map<String, Object> getCabang();
    public Map<String, Object> setVerifikasiPiutang(String strKodeInduk,
                                        String strKodeCabang,
                                        String strKodeRanting);
    public Map<String, Object> getBongkar(String Nomor,
                                          Byte bytTypeNo);
    public Map<String, Object> setBongkar(String strNomor,
                              String strPelaksana,
                              String Byte,
                              String NoPelanggan);
    public Map<String, Object> getTusBung(String Nomor,
                                          Byte bytType,
                                          Byte bytTypeNo);
    public Map<String, Object> setTusBung(String strNomor,
                              String strPelaksana,
                              String strWBP,
                              String strLWBP,
                              String strKVARH,
                              Byte bytType,
                              String bytTypeNo);
    public Map<String, Object> getCustomer(String strNomor,
                              Byte bytType);
    public Map<String, Object> formatINDO(Date strTgl);
    public Map<String, Object> getMasterInduk();
    public Map<String, Object> setMasterInduk(Map<String, Object> dsChanged);
    public Map<String, Object> getTablePejabat(String strKode);
    public Map<String, Object> getData(String strQuery);
    public Map<String, Object> setData(String strQuery);
    public Map<String, Object> CekPenghapusanTUL63(String strKodeRanting);
    public Map<String, Object> CekPenghapusanTUL62(String strKodeRanting);
    public Map<String, Object> CekPenghapusanTUL61(String strKodeRanting);
    public Map<String, Object> setTUL61(String strKodeInduk,
                            String strKodeCabang,
                            String strKodeRanting);
    public Map<String, Object> SetTUL62(String strKodeInduk,
                            String strKodeCabang,
                            String strKodeRanting);
    public Map<String, Object> SetTUL63(String strKodeInduk,
                            String strKodeCabang,
                            String strKodeRanting);
    public Map<String, Object>  IsiTULVILAPORANSemuaTunggakan(String strKodeRanting);
}
