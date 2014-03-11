package id.co.hans.sample.server.dao;

import java.util.Map;

public interface ws_502Dao {

    public Map<String, Object> ambilLaporanV02(String parUp, String parGol, String thbl, String petugas);

    public Map<String, Object> IsAp(String Unit);
    
}
