package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.ws_InfoRekeningDao;
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
public class Ws_InfoRekeningController {
//    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_InfoRekeningController.class);
//
//    @Autowired
//    ws_InfoRekeningDao ws_infoRekeningDao;
//
//
//    @RequestMapping(value = "**/ambilDilWhere.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilDilWhere(@RequestParam(value = "sqlWhere", defaultValue = "")String sqlWhere) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_infoRekeningDao.ambilDilWhere(sqlWhere);
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
//    // #Region "view info"
//    @RequestMapping(value = "**/getPiutangInfo.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject getPiutangInfo(@RequestParam(value = "clsAR", defaultValue = "")String[] clsAR,
//                                   @RequestParam(value = "strXMLschema", defaultValue = "")String strXMLschema) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_infoRekeningDao.getPiutangInfo(clsAR,strXMLschema);
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
//    // #End Region
//
//    @RequestMapping(value = "**/cariIdPelDIL.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject cariIdPelDIL(@RequestParam(value = "idpel", defaultValue = "")String idpel) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_infoRekeningDao.cariIdPelDIL(idpel);
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
//    @RequestMapping(value = "**/cariIdPelDIS.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject cariIdPelDIS(@RequestParam(value = "idpel", defaultValue = "")String idpel) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_infoRekeningDao.cariIdPelDIS(idpel);
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
//    @RequestMapping(value = "**/ambilDil.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilDil(@RequestParam(value = "idpel", defaultValue = "")String idpel) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_infoRekeningDao.ambilDil(idpel);
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
//    @RequestMapping(value = "**/ambilDis1.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilDis1(@RequestParam(value = "idpel", defaultValue = "")String idpel) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_infoRekeningDao.ambilDis1(idpel);
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
//    @RequestMapping(value = "**/ambilDis2.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilDis2(@RequestParam(value = "idpel", defaultValue = "")String idpel) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_infoRekeningDao.ambilDis2(idpel);
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
//    @RequestMapping(value = "**/ambilDis3.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilDis3(@RequestParam(value = "idpel", defaultValue = "")String idpel) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_infoRekeningDao.ambilDis3(idpel);
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
//    @RequestMapping(value = "**/ambilDis4.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilDis4(@RequestParam(value = "idpel", defaultValue = "")String idpel) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_infoRekeningDao.ambilDis4(idpel);
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
//    @RequestMapping(value = "**/ambilDis5.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilDis5(@RequestParam(value = "idpel", defaultValue = "")String idpel,
//                         @RequestParam(value = "bulanrek", defaultValue = "")String bulanrek,
//                         @RequestParam(value = "kdgerak", defaultValue = "")String kdgerak) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_infoRekeningDao.ambilDis5(idpel,bulanrek,kdgerak);
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
//    @RequestMapping(value = "**/ambilDis6.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilDis6(@RequestParam(value = "idpel", defaultValue = "")String idpel,
//                         @RequestParam(value = "bulanrek", defaultValue = "")String bulanrek,
//                         @RequestParam(value = "kdgerak", defaultValue = "")String kdgerak) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_infoRekeningDao.ambilDis6(idpel,bulanrek,kdgerak);
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
//    @RequestMapping(value = "**/ambilDildata.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilDildata(@RequestParam(value = "idpel", defaultValue = "")String idpel,
//                            @RequestParam(value = "thbl", defaultValue = "")String thbl) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_infoRekeningDao.ambilDildata(idpel,thbl);
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
//    @RequestMapping(value = "**/ambilInfo.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilInfo(@RequestParam(value = "idpel", defaultValue = "")String idpel,
//                         @RequestParam(value = "blnawal", defaultValue = "")String blnawal,
//                         @RequestParam(value = "blnakhir", defaultValue = "")String blnakhir) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_infoRekeningDao.ambilInfo(idpel,blnawal,blnakhir);
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
//    @RequestMapping(value = "**/ambilTunggakan.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilTunggakan(@RequestParam(value = "idpel", defaultValue = "")String idpel) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_infoRekeningDao.ambilTunggakan(idpel);
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

}
