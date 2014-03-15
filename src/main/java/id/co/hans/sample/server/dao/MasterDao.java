package id.co.hans.sample.server.dao;

import java.util.List;
import java.util.Map;

public interface MasterDao {
	public Map<String, Object> getMasterUnit(String inTipe, String inValue);
    public Map<String, Object> getKodeSiklis(String parUp);
}
