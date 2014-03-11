package id.co.hans.sample.server.dao;

import java.util.Map;

public interface ws_UsersDao {


    public Map<String, Object> GetPetugas();


    public Map<String, Object> getPengelola();


    public Map<String, Object> ubahPengelola(Integer jnstrans,
                                             String kode,
                                             String nama,
                                             String alamat,
                                             String notelp);



    public Map<String, Object> InsertPetugas(clsUsers Users);


    public Map<String, Object> UpdatePetugas(clsUsers Users);


    public Map<String, Object> DeletePetugas(String KodePetugas);

}
