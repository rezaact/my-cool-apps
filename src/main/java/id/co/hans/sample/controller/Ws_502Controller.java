package id.co.hans.sample.controller;


import id.co.hans.sample.server.dao.ws_502Dao;
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
public class Ws_502Controller {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_502Controller.class);

    @Autowired
    ws_502Dao ws_502Dao;

    @RequestMapping(value = "**/Ws_502Controller/ambilLaporanV02.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilLaporanV02(@RequestParam(value = "parUp", defaultValue = "")String parUp,
                               @RequestParam(value = "parGol", defaultValue = "")String parGol,
                               @RequestParam(value = "thbl", defaultValue = "")String thbl,
                               @RequestParam(value = "petugas", defaultValue = "")String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_502Dao.ambilLaporanV02(parUp,parGol,thbl,petugas);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_502Controller/IsAp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject IsAp(@RequestParam(value = "Unit", defaultValue = "")String Unit) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_502Dao.IsAp(Unit);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

}
