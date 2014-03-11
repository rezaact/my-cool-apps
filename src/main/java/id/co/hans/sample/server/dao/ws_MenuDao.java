package id.co.hans.sample.server.dao;

import java.util.Map;

public interface ws_MenuDao {
    public Map<String, Object> getRolesMenus(Integer RoleID);
    public Map<String, Object> getRolesMenusAsp(Integer RoleID);
}
