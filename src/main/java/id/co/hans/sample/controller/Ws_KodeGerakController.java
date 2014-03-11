package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.clsKODE_GERAK;
import id.co.hans.sample.server.dao.ws_KodeGerakDao;
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
public class Ws_KodeGerakController {
//    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_KodeGerakController.class);
//
//    @Autowired
//    ws_KodeGerakDao ws_kodeGerakDao;
//
//
//    @RequestMapping(value = "**/GetKODE_GERAK.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject GetKODE_GERAK() {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_kodeGerakDao.GetKODE_GERAK();
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//    @RequestMapping(value = "**/InsertKODE_GERAK.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject InsertKODE_GERAK(@RequestParam(value = "KODE_GERAK", defaultValue = "")clsKODE_GERAK KODE_GERAK) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_kodeGerakDao.InsertKODE_GERAK(KODE_GERAK);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//
//    @RequestMapping(value = "**/UpdateKODE_GERAK.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject UpdateKODE_GERAK(@RequestParam(value = "KODE_GERAK", defaultValue = "")clsKODE_GERAK KODE_GERAK) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_kodeGerakDao.UpdateKODE_GERAK(KODE_GERAK);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//
//    @RequestMapping(value = "**/DeleteKODE_GERAK.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject DeleteKODE_GERAK(@RequestParam(value = "KODE_GERAK", defaultValue = "")clsKODE_GERAK KODE_GERAK) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_kodeGerakDao.DeleteKODE_GERAK(KODE_GERAK);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }

}
