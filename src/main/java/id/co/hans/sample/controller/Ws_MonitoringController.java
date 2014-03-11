package id.co.hans.sample.controller;


import id.co.hans.sample.server.dao.ws_MonitoringDao;
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
public class Ws_MonitoringController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_MonitoringController.class);

    @Autowired
    ws_MonitoringDao ws_monitoringDao;

    @RequestMapping(value = "**/Ws_Monitoring/getMonitoringKirimTerima.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getMonitoringKirimTerima(@RequestParam(value = "unitkrm", defaultValue = "")String unitkrm,
                           @RequestParam(value = "unittrm", defaultValue = "")String unittrm,
                           @RequestParam(value = "dtBln", defaultValue = "")String dtBln,
                           @RequestParam(value = "tglAwal", defaultValue = "")String tglAwal,
                           @RequestParam(value = "tglAkhir", defaultValue = "")String tglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_monitoringDao.getMonitoringKirimTerima(unitkrm,unittrm,dtBln,tglAwal,tglAkhir);
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


    @RequestMapping(value = "**/Ws_Monitoring/getPemantauanJurnal.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getPemantauanJurnal(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                           @RequestParam(value = "tUnitUP", defaultValue = "")String tUnitUP,
                           @RequestParam(value = "tUnitAP", defaultValue = "")String tUnitAP,
                           @RequestParam(value = "tTglmulai", defaultValue = "")String tTglmulai,
                           @RequestParam(value = "tTglsampai", defaultValue = "")String tTglsampai,
                           @RequestParam(value = "dsFilter", defaultValue = "")Map<String, Object> dsFilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_monitoringDao.getPemantauanJurnal(vJenis,tUnitUP,tUnitAP,tTglmulai,tTglsampai,dsFilter);
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


    @RequestMapping(value = "**/Ws_Monitoring/Set_ApprovalERP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject Set_ApprovalERP() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_monitoringDao.Set_ApprovalERP();
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

    @RequestMapping(value = "**/Ws_Monitoring/getCube_MonitoringAnja.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getCube_MonitoringAnja(@RequestParam(value = "dtFilter", defaultValue = "")Map<String, Object> dtFilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_monitoringDao.getCube_MonitoringAnja(dtFilter);
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


    @RequestMapping(value = "**/Ws_Monitoring/getCubeDetil_MonitoringAnja.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getCubeDetil_MonitoringAnja(@RequestParam(value = "dsfilter", defaultValue = "")Map<String, Object> dsfilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_monitoringDao.getCubeDetil_MonitoringAnja(dsfilter);
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


    @RequestMapping(value = "**/Ws_Monitoring/getCube_MonitoringDPH.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getCube_MonitoringDPH(@RequestParam(value = "dtFilter", defaultValue = "")Map<String, Object> dtFilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_monitoringDao.getCube_MonitoringDPH(dtFilter);
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


    @RequestMapping(value = "**/Ws_Monitoring/getCubeDetil_MonitoringDPH.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getCubeDetil_MonitoringDPH(@RequestParam(value = "dsfilter", defaultValue = "")Map<String, Object> dsfilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_monitoringDao.getCubeDetil_MonitoringDPH(dsfilter);
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

    @RequestMapping(value = "**/Ws_Monitoring/getCube_MonitoringSaldo.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getCube_MonitoringSaldo(@RequestParam(value = "dtFilter", defaultValue = "")Map<String, Object> dtFilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_monitoringDao.getCube_MonitoringSaldo(dtFilter);
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

    @RequestMapping(value = "**/Ws_Monitoring/getCubeDetil_MonitoringSaldo.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getCubeDetil_MonitoringSaldo(@RequestParam(value = "dsfilter", defaultValue = "")Map<String, Object> dsfilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_monitoringDao.getCubeDetil_MonitoringSaldo(dsfilter);
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


    @RequestMapping(value = "**/Ws_Monitoring/getCube_MonitoringSorek.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getCube_MonitoringSorek(@RequestParam(value = "dtFilter", defaultValue = "")Map<String, Object> dtFilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_monitoringDao.getCube_MonitoringSorek(dtFilter);
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


    @RequestMapping(value = "**/Ws_Monitoring/getCubeDetil_MonitoringSorek.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getCubeDetil_MonitoringSorek(@RequestParam(value = "dsfilter", defaultValue = "")Map<String, Object> dsfilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_monitoringDao.getCubeDetil_MonitoringSorek(dsfilter);
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



    @RequestMapping(value = "**/Ws_Monitoring/getPemantauanJurnal2.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getPemantauanJurnal2(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                           @RequestParam(value = "tUnitUP", defaultValue = "")String tUnitUP,
                           @RequestParam(value = "tUnitAP", defaultValue = "")String tUnitAP,
                           @RequestParam(value = "tTglmulai", defaultValue = "")String tTglmulai,
                           @RequestParam(value = "tTglsampai", defaultValue = "")String tTglsampai) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_monitoringDao.getPemantauanJurnal(vJenis,tUnitUP,tUnitAP,tTglmulai,tTglsampai);
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
