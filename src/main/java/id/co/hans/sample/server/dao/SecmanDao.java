package id.co.hans.sample.server.dao;

import java.util.List;
import java.util.Map;

public interface SecmanDao {
	public  Map<String, Object> getUserMenuByIdsesion(String idSesion, String page);
}
