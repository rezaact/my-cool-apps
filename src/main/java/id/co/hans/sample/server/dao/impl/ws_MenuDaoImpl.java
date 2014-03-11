package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.ws_MenuDao;
import id.co.hans.sample.server.utility.CommonModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ws_MenuDaoImpl implements ws_MenuDao{

    public static final Log log = LogFactory.getLog(ws_MenuDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> getRolesMenus(Integer RoleID) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SELECT MenusID, ParentMenusID, Menus, FORM_NAME, ImageTiny, " + 
                        "(SELECT RoleID FROM RolesMenusBaru WHERE " +
                        "(RolesMenusBaru.MenusID = MenusBaru.MenusID) AND " +
                        "(RolesMenusBaru.RoleID = " + RoleID + ") " +
                        ") as hidden " +
                        "FROM MenusBaru LEFT OUTER JOIN FORMSBaru ON MenusBaru.FORMID = FORMSBaru.FORMID ORDER BY MenuSort, MenusID ASC";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }
        return retValue;
    }


    @Override
    public Map<String, Object> getRolesMenusAsp(Integer RoleID) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select menusid as ID,ParentMenusID as ROOT_ID,Menus as TEXT,CASE WHEN EXPANDED='0' THEN 'FALSE' WHEN EXPANDED='1' THEN 'TRUE' END AS EXPANDED , " +
                        " BLOCKID AS BLOCKID,FORM_ASP AS CSS_ID, " +
                        " CASE WHEN LEAF='0' THEN 'FALSE' WHEN LEAF='1' THEN 'TRUE' END AS LEAF,IMAGETINY AS ICON_STYLE,MENUSORT AS MENU_ORDER,(SELECT RoleID FROM RolesMenusBaru WHERE (RolesMenusBaru.MenusID = MenusBaru.MenusID) " +
                        " AND (RolesMenusBaru.RoleID = '" + RoleID + "') ) as hidden FROM MENUSBARU LEFT OUTER JOIN FORMSBaru ON MenusBaru.FORMID = FORMSBaru.FORMID " +
                        " ORDER BY MenuSort, MenusID ASC ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapRecords);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }
        return retValue;
    }
}
