package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.ws_JateliconDao;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Ws_JateliconController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_JateliconController.class);

    @Autowired
    ws_JateliconDao ws_jateliconDao;

     @RequestMapping(value = "**/WsJatelicon/getPelangganKoreksi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getPelangganKoreksi(@RequestParam(value = "sIdpel", defaultValue = "")String sIdpel,
                                   @RequestParam(value = "sBlth", defaultValue = "")String sBlth,
                                   @RequestParam(value = "sKDKoreksi", defaultValue = "")String sKDKoreksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_jateliconDao.getPelangganKoreksi(sIdpel,sBlth,sKDKoreksi);
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


    @RequestMapping(value = "**/WsJatelicon/setPelangganKoreksi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject setPelangganKoreksi(@RequestParam(value = "sRsXML", defaultValue = "")String sRsXML,
                                   @RequestParam(value = "sUserTrans", defaultValue = "")String sUserTrans,
                                   @RequestParam(value = "sKDKoreksi", defaultValue = "")String sKDKoreksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
//            retValue=  ws_jateliconDao.setPelangganKoreksi(sRsXML,sUserTrans,sKDKoreksi);
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


    @RequestMapping(value = "**/WsJatelicon/setBatalKoreksi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject setBatalKoreksi(@RequestParam(value = "sIdpel", defaultValue = "")String sIdpel,
                                   @RequestParam(value = "sBlth", defaultValue = "")String sBlth,
                                   @RequestParam(value = "sUserKoreksi", defaultValue = "")String sUserKoreksi,
                                   @RequestParam(value = "sTglKoreksi", defaultValue = "")String sTglKoreksi,
                                   @RequestParam(value = "sAlasan", defaultValue = "")String sAlasan) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_jateliconDao.setBatalKoreksi(sIdpel,sBlth,sUserKoreksi,sTglKoreksi,sAlasan);
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

    @RequestMapping(value = "**/WsJatelicon/getInfoPelanggan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getInfoPelanggan(@RequestParam(value = "sIdpel", defaultValue = "")String sIdpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_jateliconDao.getInfoPelanggan(sIdpel);
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


    @RequestMapping(value = "**/WsJatelicon/getNotul603.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getNotul603(@RequestParam(value = "sIdpel", defaultValue = "")String sIdpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_jateliconDao.getNotul603(sIdpel);
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

    @RequestMapping(value = "**/WsJatelicon/getPelangganLunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getPelangganLunas(@RequestParam(value = "sIdpel", defaultValue = "")String sIdpel,
                                   @RequestParam(value = "sBlth", defaultValue = "")String sBlth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_jateliconDao.getPelangganLunas(sIdpel,sBlth);
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

    @RequestMapping(value = "**/WsJatelicon/setLunasKoreksi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject setLunasKoreksi(@RequestParam(value = "sIdpel", defaultValue = "")String sIdpel,
                                   @RequestParam(value = "sBlth", defaultValue = "")String sBlth,
                                   @RequestParam(value = "sPetugas", defaultValue = "")String sPetugas,
                                   @RequestParam(value = "sKdpp", defaultValue = "")String sKdpp,
                                   @RequestParam(value = "dRptag", defaultValue = "")Double dRptag,
                                   @RequestParam(value = "sTglBayar", defaultValue = "")String sTglBayar,
                                   @RequestParam(value = "sWktBayar", defaultValue = "")String sWktBayar,
                                   @RequestParam(value = "sUnitlunas", defaultValue = "")String sUnitlunas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_jateliconDao.setLunasKoreksi(sIdpel,sBlth,sPetugas,sKdpp,dRptag,sTglBayar,sWktBayar,sUnitlunas);
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


    @RequestMapping(value = "**/WsJatelicon/getPelangganBatalLunasKoreksi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getPelangganBatalLunasKoreksi(@RequestParam(value = "sIdpel", defaultValue = "")String sIdpel,
                                   @RequestParam(value = "sBlth", defaultValue = "")String sBlth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_jateliconDao.getPelangganBatalLunasKoreksi(sIdpel,sBlth);
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


    @RequestMapping(value = "**/WsJatelicon/setBatalLunasKoreksi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject setBatalLunasKoreksi(@RequestParam(value = "sIdpel", defaultValue = "")String sIdpel,
                                   @RequestParam(value = "sBlth", defaultValue = "")String sBlth,
                                   @RequestParam(value = "sPetugasLns", defaultValue = "")String sPetugasLns,
                                   @RequestParam(value = "sPetugasBatal", defaultValue = "")String sPetugasBatal,
                                   @RequestParam(value = "sAlasan", defaultValue = "")String sAlasan) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_jateliconDao.setBatalLunasKoreksi(sIdpel,sBlth,sPetugasLns,sPetugasBatal,sAlasan);
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


    @RequestMapping(value = "**/WsJatelicon/getInfoDPPPelanggan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getInfoDPPPelanggan(@RequestParam(value = "sIdpel", defaultValue = "")String sIdpel,
                                   @RequestParam(value = "sBlth", defaultValue = "")String sBlth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_jateliconDao.getInfoDPPPelanggan(sIdpel,sBlth);
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
