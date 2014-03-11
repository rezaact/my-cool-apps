package id.co.hans.sample.server.dao;

import java.util.Map;

public interface ws_JatuhTempoDao {
    public Map<String, Object> GetJatuhTempo();
    public Map<String, Object> InsertJatuhTempo(clsJatuhTempo JatuhTempo);
    public Map<String, Object> UpdateJatuhTempo(clsJatuhTempo JatuhTempo);
    public Map<String, Object> DeleteJatuhTempo(clsJatuhTempo JatuhTempo);
}
