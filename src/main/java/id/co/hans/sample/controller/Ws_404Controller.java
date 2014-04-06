package id.co.hans.sample.controller;


import id.co.hans.sample.server.dao.ws_404Dao;
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
public class Ws_404Controller {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_404Controller.class);

    @Autowired
    ws_404Dao ws_404Dao;


    @RequestMapping(value = "**/Ws_404Controller/cekTabel404.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cekTabel404(@RequestParam(value = "petugas", defaultValue = "")String petugas,
                               @RequestParam(value = "thbl", defaultValue = "")String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_404Dao.cekTabel404(petugas,thbl);
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

    @RequestMapping(value = "**/Ws_404Controller/ambilUnsur404.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilUnsur404() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_404Dao.ambilUnsur404();
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

    @RequestMapping(value = "**/Ws_404Controller/ambilUnsur404_Baru.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilUnsur404_Baru() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_404Dao.ambilUnsur404_Baru();
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

    @RequestMapping(value = "**/Ws_404Controller/verifikasi404_hapus.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject verifikasi404_hapus(@RequestParam(value = "petugas", defaultValue = "")String petugas,
                           @RequestParam(value = "thbl", defaultValue = "")String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_404Dao.verifikasi404_hapus(petugas,thbl);
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


    @RequestMapping(value = "**/Ws_404Controller/verifikasi404_pengurangan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject verifikasi404_pengurangan(@RequestParam(value = "petugas", defaultValue = "")String petugas,
                           @RequestParam(value = "thbl", defaultValue = "")String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_404Dao.verifikasi404_pengurangan(petugas,thbl);
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

    @RequestMapping(value = "**/Ws_404Controller/verifikasi404_penambahan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject verifikasi404_penambahan(@RequestParam(value = "petugas", defaultValue = "")String petugas,
                           @RequestParam(value = "thbl", defaultValue = "")String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_404Dao.verifikasi404_penambahan(petugas,thbl);
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


    @RequestMapping(value = "**/Ws_404Controller/verifikasi404_saldoawal.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject verifikasi404_saldoawal(@RequestParam(value = "petugas", defaultValue = "")String petugas,
                           @RequestParam(value = "thbl", defaultValue = "")String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_404Dao.verifikasi404_saldoawal(petugas,thbl);
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


    @RequestMapping(value = "**/Ws_404Controller/verifikasi404_saldoakhir.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject verifikasi404_saldoakhir(@RequestParam(value = "petugas", defaultValue = "")String petugas,
                           @RequestParam(value = "thbl", defaultValue = "")String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_404Dao.verifikasi404_saldoakhir(petugas,thbl);
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

    @RequestMapping(value = "**/Ws_404Controller/ambilLaporan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilLaporan(@RequestParam(value = "parUp", defaultValue = "")String parUp,
                            @RequestParam(value = "parUnsur", defaultValue = "")String parUnsur,
                           @RequestParam(value = "thbl", defaultValue = "")String thbl,
                           @RequestParam(value = "petugas", defaultValue = "")String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_404Dao.ambilLaporan(parUp,parUnsur,thbl,petugas);
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


    @RequestMapping(value = "**/Ws_404Controller/ambilLaporan404.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilLaporan404(@RequestParam(value = "parUp", defaultValue = "")String parUp,
                            @RequestParam(value = "parUnsur", defaultValue = "")String parUnsur,
                            @RequestParam(value = "thbl", defaultValue = "")String thbl,
                            @RequestParam(value = "petugas", defaultValue = "")String petugas,
                            @RequestParam(value = "pembukuan", defaultValue = "")String pembukuan,
                            @RequestParam(value = "satuan", defaultValue = "")String satuan,
                            @RequestParam(value = "Err", defaultValue = "")String Err) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_404Dao.ambilLaporan404(parUp,parUnsur,thbl,petugas,pembukuan,satuan,Err);
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



    @RequestMapping(value = "**/Ws_404Controller/RekapUlang404.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject RekapUlang404(@RequestParam(value = "parBLTH", defaultValue = "")String parBLTH,
                               @RequestParam(value = "parUnit", defaultValue = "")String parUnit,
                               @RequestParam(value = "parPetugas", defaultValue = "")String parPetugas,
                               @RequestParam(value = "parJenisTrans", defaultValue = "")String parJenisTrans,
                               @RequestParam(value = "parSatuan", defaultValue = "")String parSatuan) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_404Dao.RekapUlang404(parBLTH,parUnit,parPetugas,parJenisTrans,parSatuan);
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

