package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.SecmanDao;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SecmanController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(SecmanController.class);

    @Autowired
    SecmanDao secmanDao;


    @RequestMapping(value = "**/SecmanController/getUserMenuByIdsesion.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getUserMenuByIdsesion(@RequestParam(value = "idSesion", defaultValue = "")String idSesion,
                           @RequestParam(value = "page", defaultValue = "")String page) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        //List<Map<String, String>> retValue = new ArrayList<Map<String, String>>();

        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue = secmanDao.getUserMenuByIdsesion(idSesion,page);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/SecmanController/getUserDataByIdSession.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject getUserDataByIdSession(@RequestParam(value = "idSession", defaultValue = "")String idSession) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        //List<Map<String, String>> retValue = new ArrayList<Map<String, String>>();

        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue = secmanDao.getUserDataByIdSession(idSession);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }
}
