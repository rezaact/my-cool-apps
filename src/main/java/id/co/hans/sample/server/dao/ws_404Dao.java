package id.co.hans.sample.server.dao;

import java.util.Map;

public interface ws_404Dao {

    public Map<String, Object> cekTabel404(String petugas,
                                           String thbl);

    public Map<String, Object> ambilUnsur404();

    public Map<String, Object> ambilUnsur404_Baru();

    public Map<String, Object> verifikasi404_hapus(String thbl,
                                                   String petugas);

    public Map<String, Object> verifikasi404_pengurangan(String thbl,
                                                         String petugas);

    public Map<String, Object> verifikasi404_penambahan(String thbl,
                                                        String petugas);

    public Map<String, Object> verifikasi404_saldoawal(String thbl,
                                                       String petugas) ;

    public Map<String, Object> verifikasi404_saldoakhir(String thbl,
                                                        String petugas);

    public Map<String, Object> ambilLaporan(String parUp,
                                            String parUnsur,
                                            String thbl,
                                            String petugas);

    public Map<String, Object> ambilLaporan404(String parUp,
                                               String parUnsur,
                                               String thbl,
                                               String petugas,
                                               String pembukuan,
                                               String satuan,
                                               String Err);

    public Map<String, Object>  RekapUlang404(String parBLTH,
                                              String parUnit,
                                              String parPetugas,
                                              String parJenisTrans,
                                              String parSatuan);
}
