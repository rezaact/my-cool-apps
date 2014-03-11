package id.co.hans.sample.server.dao;

import java.util.Date;
import java.util.Map;

public interface ws_tul6generalDao {
    public Map<String, Object> ambilTanggalDatabase();
    public Map<String, Object> ambilUnitUp();
    public Map<String, Object> isicbUnitup(String unitUp);
    public Map<String, Object> ambilNamaUp(String unitUp);
    public Map<String, Object> ambilKota(String unitUp);
    public Map<String, Object> ambilPejabat(String unitUp);
    public Map<String, Object> ambilNamaApdariUp(String unitUp);
    public Map<String, Object> ambilNamaKddariUp(String unitUp);
    public Map<String, Object> ambilAlamatdariUp(String unitUp);
    public Map<String, Object> ambilKodeKolektif();
    public Map<String, Object> ambilKodePaymentPoint(String unitUp);
    public Map<String, Object> ambilKodeSiklis(String unitUp);
}
