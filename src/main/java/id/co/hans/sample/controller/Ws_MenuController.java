package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.ws_MenuDao;
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
public class Ws_MenuController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_MenuController.class);

    @Autowired
    ws_MenuDao ws_menuDao;

    @RequestMapping(value = "**/Ws_Menu/getRolesMenus.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getRolesMenus(@RequestParam(value = "RoleID", defaultValue = "")Integer RoleID) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_menuDao.getRolesMenus(RoleID);
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
    @RequestMapping(value = "**/Ws_Menu/getRolesMenusAsp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getRolesMenusAsp(@RequestParam(value = "RoleID", defaultValue = "")Integer RoleID) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_menuDao.getRolesMenusAsp(RoleID);
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
