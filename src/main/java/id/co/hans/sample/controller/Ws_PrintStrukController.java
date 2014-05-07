package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.ws_PrintStrukDao;
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
public class Ws_PrintStrukController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_PrintStrukController.class);

    @Autowired
    ws_PrintStrukDao ws_printStrukDao;


    @RequestMapping(value = "**/Ws_PrintStruk/cetakRekg12.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cetakRekg12(@RequestParam(value = "tTgKoreksi", defaultValue = "")String tTgKoreksi,
                                   @RequestParam(value = "tIdpel", defaultValue = "")String tIdpel,
                                   @RequestParam(value = "tBlth", defaultValue = "")String tBlth,
                                   @RequestParam(value = "tNorek", defaultValue = "")String tNorek) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_printStrukDao.cetakRekg12(tTgKoreksi,tIdpel,tBlth,tNorek);
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


    @RequestMapping(value = "**/Ws_PrintStruk/cetakRekg41.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cetakRekg41(@RequestParam(value = "tTgKoreksi", defaultValue = "")String tTgKoreksi,
                           @RequestParam(value = "tIdpel", defaultValue = "")String tIdpel,
                           @RequestParam(value = "tBlth", defaultValue = "")String tBlth,
                           @RequestParam(value = "tNorek", defaultValue = "")String tNorek) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_printStrukDao.cetakRekg41(tTgKoreksi,tIdpel,tBlth,tNorek);
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

    @RequestMapping(value = "**/Ws_PrintStruk/cetakRekg12D.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cetakRekg12D(@RequestParam(value = "tKodePetugas", defaultValue = "")String tKodePetugas,
                           @RequestParam(value = "tIDPEL", defaultValue = "")String tIDPEL,
                           @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_printStrukDao.cetakRekg12D(tKodePetugas,tIDPEL,tBLTH);
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


    @RequestMapping(value = "**/Ws_PrintStruk/cetakRekg23.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cetakRekg23(@RequestParam(value = "tTglbayar", defaultValue = "")String tTglbayar,
                            @RequestParam(value = "tIdpel", defaultValue = "")String tIdpel,
                            @RequestParam(value = "tBlth", defaultValue = "")String tBlth,
                            @RequestParam(value = "tBlth", defaultValue = "")String tNorek) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_printStrukDao.cetakRekg23(tTglbayar,tIdpel,tBlth,tNorek);
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

    @RequestMapping(value = "**/Ws_PrintStruk/cetakRekg31.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cetakRekg31(@RequestParam(value = "tTglbayar", defaultValue = "")String tTglbayar,
                           @RequestParam(value = "tIdpel", defaultValue = "")String tIdpel,
                           @RequestParam(value = "tBlth", defaultValue = "")String tBlth,
                           @RequestParam(value = "tBlth", defaultValue = "")String tNorek) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_printStrukDao.cetakRekg31(tTglbayar,tIdpel,tBlth,tNorek);
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

    @RequestMapping(value = "**/Ws_PrintStruk/cetakRekg32.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cetakRekg32(@RequestParam(value = "tTglbayar", defaultValue = "")String tTglbayar,
                           @RequestParam(value = "tIdpel", defaultValue = "")String tIdpel,
                           @RequestParam(value = "tBlth", defaultValue = "")String tBlth,
                           @RequestParam(value = "tBlth", defaultValue = "")String tNorek) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_printStrukDao.cetakRekg32(tTglbayar,tIdpel,tBlth,tNorek);
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


    @RequestMapping(value = "**/Ws_PrintStruk/cetakRekg21.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cetakRekg21(@RequestParam(value = "tTglbayar", defaultValue = "")String tTglbayar,
                           @RequestParam(value = "tIdpel", defaultValue = "")String tIdpel,
                           @RequestParam(value = "tBlth", defaultValue = "")String tBlth,
                           @RequestParam(value = "tBlth", defaultValue = "")String tNorek) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_printStrukDao.cetakRekg21(tTglbayar,tIdpel,tBlth,tNorek);
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

    @RequestMapping(value = "**/Ws_PrintStruk/cetakRekg21Giralisasi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cetakRekg21Giralisasi(@RequestParam(value = "tTglBayar", defaultValue = "")String tTglbayar,
                           @RequestParam(value = "tKDPP", defaultValue = "")String tKDPP,
                           @RequestParam(value = "tKodeGiral", defaultValue = "")String tKodeGiral) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_printStrukDao.cetakRekg21Giralisasi(tTglbayar,tKDPP,tKodeGiral);
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

    @RequestMapping(value = "**/Ws_PrintStruk/cetakRekg21NotaBuku.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cetakRekg21NotaBuku(@RequestParam(value = "tKodePetugas", defaultValue = "")String tKodePetugas,
                                     @RequestParam(value = "tKodeNota", defaultValue = "")String tKodeNota,
                                     @RequestParam(value = "tUnitup", defaultValue = "")String tUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_printStrukDao.cetakRekg21NotaBuku(tKodePetugas,tKodeNota,tUnitup);
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

    @RequestMapping(value = "**/Ws_PrintStruk/cetakRekg21NotaTerpusat.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cetakRekg21NotaTerpusat(@RequestParam(value = "tKodePetugas", defaultValue = "")String tKodePetugas,
                                   @RequestParam(value = "tKodeNota", defaultValue = "")String tKodeNota,
                                   @RequestParam(value = "tUnitup", defaultValue = "")String tUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_printStrukDao.cetakRekg21NotaTerpusat(tKodePetugas,tKodeNota,tUnitup);
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

    @RequestMapping(value = "**/Ws_PrintStruk/cetakRekg21EntriLunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cetakRekg21EntriLunas(@RequestParam(value = "tKodePetugas", defaultValue = "")String tKodePetugas,
                                       @RequestParam(value = "tIDPEL", defaultValue = "")String tIDPEL,
                                       @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_printStrukDao.cetakRekg21EntriLunas(tKodePetugas,tIDPEL,tBLTH);
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


    @RequestMapping(value = "**/Ws_PrintStruk/getCetul_21Giralisasi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getCetul_21Giralisasi(@RequestParam(value = "strPetugas", defaultValue = "")String strPetugas,
                                     @RequestParam(value = "sKodeKolektif", defaultValue = "")String sKodeKolektif,
                                     @RequestParam(value = "sTglLunas", defaultValue = "")String sTglLunas,
                                     @RequestParam(value = "sKDPP", defaultValue = "")String sKDPP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_printStrukDao.getCetul_21Giralisasi(strPetugas,sKodeKolektif,sTglLunas,sKDPP);
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


    @RequestMapping(value = "**/Ws_PrintStruk/SetCetul_21Giralisasi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetCetul_21Giralisasi(@RequestParam(value = "dsTrans", defaultValue = "")Map<String, Object> dsTrans) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_printStrukDao.SetCetul_21Giralisasi(dsTrans);
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


    @RequestMapping(value = "**/Ws_PrintStruk/getCetul_23NotaBuku.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject getCetul_23NotaBuku(@RequestParam(value = "strPetugas", defaultValue = "")String strPetugas,
                                     @RequestParam(value = "sKodeKolektif", defaultValue = "")String sKodeKolektif,
                                     @RequestParam(value = "sTglLunas", defaultValue = "")String sTglLunas,
                                     @RequestParam(value = "tUnitup", defaultValue = "")String tUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue =  ws_printStrukDao.getCetul_23NotaBuku(strPetugas,sKodeKolektif,sTglLunas,tUnitup);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            obj.put("result", "Error parsing JSON. Msg: " + ex.getMessage());
        }
        return obj;
    }


    @RequestMapping(value = "**/Ws_PrintStruk/SetCetul_23NotaBuku.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetCetul_23NotaBuku(@RequestParam(value = "dsTrans", defaultValue = "")Map<String, Object> dsTrans) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_printStrukDao.SetCetul_23NotaBuku(dsTrans);
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

    @RequestMapping(value = "**/Ws_PrintStruk/getCetul_23Terpusat.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getCetul_23Terpusat(@RequestParam(value = "strPetugas", defaultValue = "")String strPetugas,
                                     @RequestParam(value = "sKodeKolektif", defaultValue = "")String sKodeKolektif,
                                     @RequestParam(value = "sTglLunas", defaultValue = "")String sTglLunas,
                                     @RequestParam(value = "sUnitup", defaultValue = "")String sUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_printStrukDao.getCetul_23Terpusat(strPetugas,sKodeKolektif,sTglLunas,sUnitup);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_PrintStruk/SetCetul_23Perpusat.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetCetul_23Perpusat(@RequestParam(value = "strPetugas", defaultValue = "")Map<String, Object>  strPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_printStrukDao.SetCetul_23Perpusat(strPetugas);
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
