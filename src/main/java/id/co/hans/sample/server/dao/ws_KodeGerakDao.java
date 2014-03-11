package id.co.hans.sample.server.dao;

import java.util.Map;

public interface ws_KodeGerakDao {
    public Map<String, Object> GetKODE_GERAK();
    public Map<String, Object> InsertKODE_GERAK(clsKODE_GERAK KODE_GERAK);
    public Map<String, Object> UpdateKODE_GERAK(clsKODE_GERAK KODE_GERAK);
    public Map<String, Object> DeleteKODE_GERAK(clsKODE_GERAK KODE_GERAK);
}
