package id.co.hans.sample.server.dao;

import java.util.List;
import java.util.Map;

public interface ws_RolesDao {
    public Map<String, Object> GetRolesMenus(Integer RoleID);
    public Map<String, Object> GetMenus();
    public Map<String, Object> GetRoles();
    public Map<String, Object> UpdateRoles(Integer RoleID, List<Map<String, String>> arr);
}
