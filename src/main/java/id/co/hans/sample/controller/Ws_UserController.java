package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.clsUsers;
import id.co.hans.sample.server.dao.ws_UsersDao;
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
public class Ws_UserController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_UserController.class);

    @Autowired
    private ws_UsersDao ws_usersDao;


    @RequestMapping(value = "**/Ws_User/getPengelola.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JSONObject getPengelola() {
       Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_usersDao.getPengelola();
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


    @RequestMapping(value = "**/Ws_User/GetPetugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JSONObject GetPetugas() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_usersDao.GetPetugas();
            obj.put("result", retValue);
//            obj.put("result", ws_usersDao.GetPetugas());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_User/ubahPengelola.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ubahPengelola(@RequestParam(value = "jnstrans", defaultValue = "")Integer jnstrans,
                                              @RequestParam(value = "kode", defaultValue = "")String kode,
                                              @RequestParam(value = "nama", defaultValue = "")String nama,
                                              @RequestParam(value = "alamat", defaultValue = "")String alamat,
                                              @RequestParam(value = "notelp", defaultValue = "")String notelp) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//        ObjectMapper mapper = new ObjectMapper();
//        List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
        String retVal = "Init";


        try {
            retValue=  ws_usersDao.ubahPengelola(jnstrans,kode,nama,alamat, notelp);
            obj.put("result", retValue);
//            obj.writeJSONString(out);
//            retVal = out.toString();

        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_User/insertPetugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject insertPetugas(@RequestParam(value = "Users", defaultValue = "")clsUsers Users) {

        Map<String, Object> retValue = new HashMap<String, Object>();
//        String retValue="";
        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//        ObjectMapper mapper = new ObjectMapper();
//        List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
        String retVal = "Init";


        try {
            retValue=  ws_usersDao.InsertPetugas(Users);
            obj.put("result", retValue);
//            obj.writeJSONString(out);
//            retVal = out.toString();

        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_User/updatePetugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject updatePetugas(@RequestParam(value = "Users", defaultValue = "")clsUsers Users) {

        Map<String, Object> retValue = new HashMap<String, Object>();
//        String retValue="";
        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//        ObjectMapper mapper = new ObjectMapper();
//        List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
        String retVal = "Init";


        try {
            retValue=  ws_usersDao.UpdatePetugas(Users);
            obj.put("result", retValue);
//            obj.writeJSONString(out);
//            retVal = out.toString();

        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_User/deletePetugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject deletePetugas(@RequestParam(value = "kodePetugas", defaultValue = "")String kodePetugas) {

        Map<String, Object> retValue = new HashMap<String, Object>();
//        String retValue="";
        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//        ObjectMapper mapper = new ObjectMapper();
//        List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
        String retVal = "Init";


        try {
            retValue=  ws_usersDao.DeletePetugas(kodePetugas);
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
