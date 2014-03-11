package id.co.hans.sample.server.dao;

import java.util.Map;

public interface ws_UnitapDao {

    
    public Map<String, Object> GetUNITAP();
    
    public Map<String, Object> InsertUNITAP(clsUNITAP UNITAP);
    public Map<String, Object> UpdateUNITAP(clsUNITAP UNITAP);
    public Map<String, Object> DeleteUNITAP(clsUNITAP UNITAP);
    
}
