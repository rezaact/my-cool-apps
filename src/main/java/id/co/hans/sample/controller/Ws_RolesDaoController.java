package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.ws_RolesDao;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Ws_RolesDaoController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_RolesDaoController.class);

    @Autowired
    ws_RolesDao ws_rolesDao;


    @RequestMapping(value = "**/Ws_Roles/GetRolesMenus.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetRolesMenus(@RequestParam(value = "RoleID", defaultValue = "")Integer RoleID) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_rolesDao.GetRolesMenus(RoleID);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Roles/GetMenus.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetMenus() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_rolesDao.GetMenus();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Roles/GetRoles.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetRoles() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_rolesDao.GetRoles();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Roles/UpdateRoles.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject UpdateRoles(@RequestParam(value = "RoleID", defaultValue = "")Integer RoleID,
                           @RequestParam(value = "arr", defaultValue = "")Map<String, Object> arr) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
//            retValue=  ws_rolesDao.UpdateRoles(RoleID,arr);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }
}
