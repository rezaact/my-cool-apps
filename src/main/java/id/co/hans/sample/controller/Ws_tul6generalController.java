package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.ws_tul6generalDao;
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
public class Ws_tul6generalController {

    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_tul6generalController.class);

    @Autowired
    ws_tul6generalDao ws_tul6generalDao;

    @RequestMapping(value = "**/Ws_Tul6General/ambilTanggalDatabase.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilTanggalDatabase() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6generalDao.ambilTanggalDatabase();
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


    @RequestMapping(value = "**/Ws_Tul6General/ambilUnitUp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilUnitUp() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6generalDao.ambilUnitUp();
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


    @RequestMapping(value = "**/Ws_Tul6General/isicbUnitup.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject isicbUnitup(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6generalDao.isicbUnitup(unitUp);
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


    @RequestMapping(value = "**/Ws_Tul6General/ambilNamaUp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNamaUp(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6generalDao.ambilNamaUp(unitUp);
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


    @RequestMapping(value = "**/Ws_Tul6General/ambilKota.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilKota(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6generalDao.ambilKota(unitUp);
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


    @RequestMapping(value = "**/Ws_Tul6General/ambilPejabat.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilPejabat(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6generalDao.ambilPejabat(unitUp);
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


    @RequestMapping(value = "**/Ws_Tul6General/ambilNamaApdariUp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNamaApdariUp(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6generalDao.ambilNamaApdariUp(unitUp);
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


    @RequestMapping(value = "**/Ws_Tul6General/ambilNamaKddariUp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNamaKddariUp(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6generalDao.ambilNamaKddariUp(unitUp);
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


    @RequestMapping(value = "**/Ws_Tul6General/ambilAlamatdariUp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilAlamatdariUp(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6generalDao.ambilAlamatdariUp(unitUp);
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


    @RequestMapping(value = "**/Ws_Tul6General/ambilKodeKolektif.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilKodeKolektif() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6generalDao.ambilKodeKolektif();
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


    @RequestMapping(value = "**/Ws_Tul6General/ambilKodePaymentPoint.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilKodePaymentPoint(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6generalDao.ambilKodePaymentPoint(unitUp);
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

    @RequestMapping(value = "**/Ws_Tul6General/ambilKodeSiklis.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilKodeSiklis(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6generalDao.ambilKodeSiklis(unitUp);
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
