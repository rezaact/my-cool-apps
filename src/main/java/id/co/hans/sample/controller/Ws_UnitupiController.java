package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.clsUNITUPI;
import id.co.hans.sample.server.dao.clsUsers;
import id.co.hans.sample.server.dao.ws_UnitupiDao;
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
public class Ws_UnitupiController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_UnitupiController.class);

    @Autowired
    private ws_UnitupiDao ws_unitupiDao;

    @RequestMapping(value = "**/Ws_Unitupi/getUNITUPI.json", method = RequestMethod.GET, produces = "application/json")
     public @ResponseBody
     JSONObject getUNITUPI() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_unitupiDao.GetUNITUPI();
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


    @RequestMapping(value = "**/Ws_Unitupi/insertUNITUPI.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject insertUNITUPI(@RequestParam(value = "UNITUPI", defaultValue = "")clsUNITUPI UNITUPI) {

//        Map<String, Object> retValue = new HashMap<String, Object>();
        String retValue="";
        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//        ObjectMapper mapper = new ObjectMapper();
//        List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
        String retVal = "Init";


        try {
            retValue=  ws_unitupiDao.InsertUNITUPI(UNITUPI);
            obj.put("result", retValue);
//            obj.writeJSONString(out);
//            retVal = out.toString();

        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Unitupi/updateUNITUPI.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject updateUNITUPI(@RequestParam(value = "UNITUPI", defaultValue = "")clsUNITUPI UNITUPI) {

//        Map<String, Object> retValue = new HashMap<String, Object>();
        String retValue="";
        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//        ObjectMapper mapper = new ObjectMapper();
//        List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
        String retVal = "Init";


        try {
            retValue=  ws_unitupiDao.UpdateUNITUPI(UNITUPI);
            obj.put("result", retValue);
//            obj.writeJSONString(out);
//            retVal = out.toString();

        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

      @RequestMapping(value = "**/Ws_Unitupi/deleteUNITUPI.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject deleteUNITUPI(@RequestParam(value = "UNITUPI", defaultValue = "")clsUNITUPI UNITUPI) {

//        Map<String, Object> retValue = new HashMap<String, Object>();
        String retValue="";
        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//        ObjectMapper mapper = new ObjectMapper();
//        List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
        String retVal = "Init";


        try {
            retValue=  ws_unitupiDao.DeleteUNITUPI(UNITUPI);
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
