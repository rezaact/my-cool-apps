package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.clsUNITAP;
import id.co.hans.sample.server.dao.ws_UnitapDao;
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
public class Ws_UnitapController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_UnitapController.class);

    @Autowired
    private ws_UnitapDao ws_unitapDao;



    @RequestMapping(value = "**/Ws_Unitap/getUNITAP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getUNITAP() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_unitapDao.GetUNITAP();
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


    @RequestMapping(value = "**/Ws_Unitap/insertUNITAP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject insertUNITAP(@RequestParam(value = "UNITAP", defaultValue = "")clsUNITAP UNITAP) {

        Map<String, Object> retValue = new HashMap<String, Object>();
//        String retValue="";
        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//        ObjectMapper mapper = new ObjectMapper();
//        List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
        String retVal = "Init";


        try {
            retValue=  ws_unitapDao.InsertUNITAP(UNITAP);
            obj.put("result", retValue);
//            obj.writeJSONString(out);
//            retVal = out.toString();

        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Unitap/updateUNITAP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject updateUNITAP(@RequestParam(value = "UNITAP", defaultValue = "")clsUNITAP UNITAP) {

        Map<String, Object> retValue = new HashMap<String, Object>();
//        String retValue="";
        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//        ObjectMapper mapper = new ObjectMapper();
//        List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
        String retVal = "Init";


        try {
            retValue=  ws_unitapDao.UpdateUNITAP(UNITAP);
            obj.put("result", retValue);
//            obj.writeJSONString(out);
//            retVal = out.toString();

        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Unitap/deleteUNITAP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject deleteUNITAP(@RequestParam(value = "UNITAP", defaultValue = "")clsUNITAP UNITAP) {

        Map<String, Object> retValue = new HashMap<String, Object>();
//        String retValue="";
        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//        ObjectMapper mapper = new ObjectMapper();
//        List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
        String retVal = "Init";


        try {
            retValue=  ws_unitapDao.DeleteUNITAP(UNITAP);
            obj.put("result", retValue);
//            obj.writeJSONString(out);
//            retVal = out.toString();

        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

}
