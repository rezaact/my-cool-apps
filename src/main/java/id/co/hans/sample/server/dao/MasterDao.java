package id.co.hans.sample.server.dao;

import java.util.List;
import java.util.Map;

public interface MasterDao {
    public Map<String, Object> getMasterUser(String idUser);
	public Map<String, Object> getMasterUnit(String inTipe, String userUnit, String selectedUnit);
    public Map<String, Object> getKodeSiklis(String parUp, String parTHBL);
    public Map<String, Object> getKodePaymentPoint(String parUp);
    public Map<String, Object> getKodePaymentPoint(String parUp, String jenisPP);
    public Map<String, Object> getKodePetugas(String kodePP);
    public Map<String, Object> getDataKolektifGiralisasi(String unitUp);
    public Map<String, Object> getDataKolektifNotaBuku(String sUnitup, String IBEBANKANTOR);
    public Map<String, Object> getDataKolektifNotaTerpusat(String sUnitup);
    public Map<String, Object> getKodeProses(String parUp, String blth);
}
