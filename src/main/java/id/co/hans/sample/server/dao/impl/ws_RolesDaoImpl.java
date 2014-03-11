package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.ws_RolesDao;
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
public class ws_RolesDaoImpl implements ws_RolesDao{
    public static final Log log = LogFactory.getLog(ws_RolesDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> GetRolesMenus(Integer RoleID) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql;
            ResultSet rs;

            sql = "select * from ROLESMENUS where ROLEID = " + RoleID;

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapPetugas);
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
    public Map<String, Object> GetMenus() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql;
            ResultSet rs;

            sql = "select * from MENUS";
            cst = con.prepareCall(sql);

            rs = cst.executeQuery();
            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapPetugas);
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
    public Map<String, Object> GetRoles() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql;
            ResultSet rs;

            sql = "select * from ROLES";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapPetugas);
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
    public Map<String, Object> UpdateRoles(Integer RoleID, List<Map<String, String>> arr) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        boolean errCode = true;
        String errMessage = "";

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cst;
            String sql;
            ResultSet rs;

            sql = "Delete ROLESMENUS Where ROLEID = " + RoleID;

            cst = con.prepareCall(sql);
            cst.execute();

            for (Map<String, String> rowData : arr) {
                sql = "Insert into ROLESMENUS (ROLEID,MENUSID) Values (" + RoleID + ",'" + rowData.get(0) + "')";
                cst = con.prepareCall(sql);
                cst.execute();
            }

            retValue.put("wsReturn", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
        }

        return retValue;
    }
}
