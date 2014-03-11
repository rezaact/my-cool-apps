package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.clsJatuhTempo;
import id.co.hans.sample.server.dao.ws_JatuhTempoDao;
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
public class Ws_JatuhTempoController {
//
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_JatuhTempoController.class);

    @Autowired
    ws_JatuhTempoDao ws_jatuhTempoDao;

    @RequestMapping(value = "**/Ws_JatuhTempo/GetJatuhTempo.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetJatuhTempo() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_jatuhTempoDao.GetJatuhTempo();
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


     @RequestMapping(value = "**/Ws_JatuhTempo/InsertJatuhTempo.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject InsertJatuhTempo(@RequestParam(value = "JatuhTempo", defaultValue = "")clsJatuhTempo JatuhTempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_jatuhTempoDao.InsertJatuhTempo(JatuhTempo);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_JatuhTempo/UpdateJatuhTempo.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject UpdateJatuhTempo(@RequestParam(value = "JatuhTempo", defaultValue = "")clsJatuhTempo JatuhTempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_jatuhTempoDao.UpdateJatuhTempo(JatuhTempo);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_JatuhTempo/DeleteJatuhTempo.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject DeleteJatuhTempo(@RequestParam(value = "UNITUP", defaultValue = "")String UNITUP,
                                @RequestParam(value = "KODESIKLIS", defaultValue = "")String KODESIKLIS,
                                @RequestParam(value = "JATUHTEMPO", defaultValue = "")String JATUHTEMPO) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        clsJatuhTempo JatuhTempo = new clsJatuhTempo();
        JatuhTempo.UNITUP = UNITUP;
        JatuhTempo.KODESIKLIS = KODESIKLIS;
        JatuhTempo.JATUHTEMPO = JATUHTEMPO;

        String retVal = "Init";
        try {
            retValue=  ws_jatuhTempoDao.DeleteJatuhTempo(JatuhTempo);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

}
