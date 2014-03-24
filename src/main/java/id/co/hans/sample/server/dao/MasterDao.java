package id.co.hans.sample.server.dao;

import java.util.List;
import java.util.Map;

public interface MasterDao {
	public Map<String, Object> getMasterUnit(String inTipe, String inValue);
    public Map<String, Object> getKodeSiklis(String parUp);
    public Map<String, Object> getKodePaymentPoint(String parUp);
    public Map<String, Object> getKodePetugas(String kodePP);
    public Map<String, Object> getDataKolektifGiralisasi(String unitUp);
    public Map<String, Object> getDataKolektifNotaBuku(String sUnitup, String IBEBANKANTOR);
    public Map<String, Object> getDataKolektifNotaTerpusat(String sUnitup);
}
