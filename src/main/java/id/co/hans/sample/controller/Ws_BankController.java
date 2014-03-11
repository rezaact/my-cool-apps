package id.co.hans.sample.controller;


import id.co.hans.sample.server.dao.clsBANK;
import id.co.hans.sample.server.dao.ws_BankDao;
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
public class Ws_BankController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_BankController.class);

    @Autowired
    ws_BankDao ws_bankDao;

   @RequestMapping(value = "**/Ws_Bank/GetBANK.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetBANK() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_bankDao.GetBANK();
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


    @RequestMapping(value = "**/Ws_Bank/InsertBANK.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject InsertBANK(@RequestParam(value = "BANK", defaultValue = "")clsBANK BANK) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_bankDao.InsertBANK(BANK);
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


    @RequestMapping(value = "**/Ws_Bank/UpdateBANK.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject UpdateBANK(@RequestParam(value = "BANK", defaultValue = "")clsBANK BANK) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_bankDao.UpdateBANK(BANK);
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


    @RequestMapping(value = "**/Ws_Bank/DeleteBANK.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject DeleteBANK(@RequestParam(value = "BANK", defaultValue = "")clsBANK BANK) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_bankDao.DeleteBANK(BANK);
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
