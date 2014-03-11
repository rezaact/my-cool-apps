package id.co.hans.sample.controller;


import id.co.hans.sample.server.dao.ws_BatalTransaksiDao;
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
public class Ws_BatalTransaksiController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_BatalTransaksiController.class);

    @Autowired
    ws_BatalTransaksiDao ws_batalTransaksiDao;

//    public Map<String, Object> HelloWorld();


    @RequestMapping(value = "**/Ws_BatalTransaksi/BatalTransaksi_idpel.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject BatalTransaksi_idpel(@RequestParam(value = "Transaksi", defaultValue = "")String Transaksi,
                            @RequestParam(value = "tpel", defaultValue = "")String tpel,
                            @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                            @RequestParam(value = "tKode", defaultValue = "")String tKode,
                            @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                            @RequestParam(value = "tblthbuku", defaultValue = "")String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_batalTransaksiDao.BatalTransaksi_idpel(Transaksi,tpel,vJenis,tKode,tPetugas,tblthbuku);
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


    @RequestMapping(value = "**/Ws_BatalTransaksi/SetDataIdpelBatal_11.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpelBatal_11(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                    @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                    @RequestParam(value = "tAlasan", defaultValue = "")String tAlasan,
                                    @RequestParam(value = "tglTransaksi", defaultValue = "")String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_batalTransaksiDao.SetDataIdpelBatal_11(dtrans,tTransaksiBy,tAlasan,tglTransaksi);
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


    @RequestMapping(value = "**/Ws_BatalTransaksi/SetDataIdpelBatal_12ABCG.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpelBatal_12ABCG(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                    @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                    @RequestParam(value = "tAlasan", defaultValue = "")String tAlasan,
                                    @RequestParam(value = "tglTransaksi", defaultValue = "")String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_batalTransaksiDao.SetDataIdpelBatal_12ABCG(dtrans,tTransaksiBy,tAlasan,tglTransaksi);
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

    @RequestMapping(value = "**/Ws_BatalTransaksi/SetDataIdpelBatal_12DSuplisi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpelBatal_12DSuplisi(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                        @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                        @RequestParam(value = "tAlasan", defaultValue = "")String tAlasan,
                                        @RequestParam(value = "tglTransaksi", defaultValue = "")String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_batalTransaksiDao.SetDataIdpelBatal_12DSuplisi(dtrans,tTransaksiBy,tAlasan,tglTransaksi);
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

    @RequestMapping(value = "**/Ws_BatalTransaksi/SetDataIdpelBatal_12DRestitusi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpelBatal_12DRestitusi(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                        @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                        @RequestParam(value = "tAlasan", defaultValue = "")String tAlasan,
                                        @RequestParam(value = "tglTransaksi", defaultValue = "")String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_batalTransaksiDao.SetDataIdpelBatal_12DRestitusi(dtrans,tTransaksiBy,tAlasan,tglTransaksi);
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

    @RequestMapping(value = "**/Ws_BatalTransaksi/SetDataIdpelBatal_13.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpelBatal_13(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                        @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                        @RequestParam(value = "tAlasan", defaultValue = "")String tAlasan,
                                        @RequestParam(value = "tglTransaksi", defaultValue = "")String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_batalTransaksiDao.SetDataIdpelBatal_13(dtrans,tTransaksiBy,tAlasan,tglTransaksi);
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

       @RequestMapping(value = "**/Ws_BatalTransaksi/SetDataIdpelBatal_21.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpelBatal_21(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                        @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                        @RequestParam(value = "tAlasan", defaultValue = "")String tAlasan,
                                        @RequestParam(value = "tglTransaksi", defaultValue = "")String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_batalTransaksiDao.SetDataIdpelBatal_21(dtrans,tTransaksiBy,tAlasan,tglTransaksi);
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

    @RequestMapping(value = "**/Ws_BatalTransaksi/SetDataIdpelBatal_21Suplisi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpelBatal_21Suplisi(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                        @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                        @RequestParam(value = "tAlasan", defaultValue = "")String tAlasan,
                                        @RequestParam(value = "tglTransaksi", defaultValue = "")String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_batalTransaksiDao.SetDataIdpelBatal_21Suplisi(dtrans,tTransaksiBy,tAlasan,tglTransaksi);
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

    @RequestMapping(value = "**/Ws_BatalTransaksi/SetDataIdpelBatal_23NOTA.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpelBatal_23NOTA(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                        @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                        @RequestParam(value = "tAlasan", defaultValue = "")String tAlasan,
                                        @RequestParam(value = "tglTransaksi", defaultValue = "")String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_batalTransaksiDao.SetDataIdpelBatal_23NOTA(dtrans,tTransaksiBy,tAlasan,tglTransaksi);
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

    @RequestMapping(value = "**/Ws_BatalTransaksi/SetDataIdpelBatal_23DLT.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpelBatal_23DLT(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                        @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                        @RequestParam(value = "tAlasan", defaultValue = "")String tAlasan,
                                        @RequestParam(value = "tglTransaksi", defaultValue = "")String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_batalTransaksiDao.SetDataIdpelBatal_23DLT(dtrans,tTransaksiBy,tAlasan,tglTransaksi);
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


    @RequestMapping(value = "**/Ws_BatalTransaksi/SetDataIdpelBatal_31.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpelBatal_31(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                        @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                        @RequestParam(value = "tAlasan", defaultValue = "")String tAlasan,
                                        @RequestParam(value = "tglTransaksi", defaultValue = "")String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_batalTransaksiDao.SetDataIdpelBatal_31(dtrans,tTransaksiBy,tAlasan,tglTransaksi);
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


    @RequestMapping(value = "**/Ws_BatalTransaksi/SetDataIdpelBatal_41.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpelBatal_41(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                        @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                        @RequestParam(value = "tAlasan", defaultValue = "")String tAlasan,
                                        @RequestParam(value = "tglTransaksi", defaultValue = "")String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_batalTransaksiDao.SetDataIdpelBatal_41(dtrans,tTransaksiBy,tAlasan,tglTransaksi);
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

    @RequestMapping(value = "**/Ws_BatalTransaksi/SetDataIdpelBatal_32.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpelBatal_32(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                        @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                        @RequestParam(value = "tAlasan", defaultValue = "")String tAlasan,
                                        @RequestParam(value = "tglTransaksi", defaultValue = "")String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_batalTransaksiDao.SetDataIdpelBatal_32(dtrans,tTransaksiBy,tAlasan,tglTransaksi);
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


    @RequestMapping(value = "**/Ws_BatalTransaksi/SetDataIdpelBatal_23Kirim.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpelBatal_23Kirim(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                        @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                        @RequestParam(value = "tAlasan", defaultValue = "")String tAlasan,
                                        @RequestParam(value = "tglTransaksi", defaultValue = "")String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_batalTransaksiDao.SetDataIdpelBatal_23Kirim(dtrans,tTransaksiBy,tAlasan,tglTransaksi);
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


    @RequestMapping(value = "**/Ws_BatalTransaksi/SetDataIdpelBatal_23Terima.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpelBatal_23Terima(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                        @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                        @RequestParam(value = "tAlasan", defaultValue = "")String tAlasan,
                                        @RequestParam(value = "tglTransaksi", defaultValue = "")String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_batalTransaksiDao.SetDataIdpelBatal_23Terima(dtrans,tTransaksiBy,tAlasan,tglTransaksi);
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


    @RequestMapping(value = "**/Ws_BatalTransaksi/SetDataIdpelBatal_CicilRek.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpelBatal_CicilRek(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                        @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                        @RequestParam(value = "tAlasan", defaultValue = "")String tAlasan,
                                        @RequestParam(value = "tglTransaksi", defaultValue = "")String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_batalTransaksiDao.SetDataIdpelBatal_CicilRek(dtrans,tTransaksiBy,tAlasan,tglTransaksi);
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



    @RequestMapping(value = "**/Ws_BatalTransaksi/SetDataIdpelBatal_23NOTA_Each.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpelBatal_23NOTA_Each(@RequestParam(value = "_inTransaksiBy", defaultValue = "")String  _inTransaksiBy,
                                        @RequestParam(value = "_inIdpel", defaultValue = "")String _inIdpel,
                                        @RequestParam(value = "_inKdPembPP", defaultValue = "")String _inKdPembPP,
                                        @RequestParam(value = "_inKdGerakKeluar", defaultValue = "")String _inKdGerakKeluar,
                                        @RequestParam(value = "_inBlth", defaultValue = "")String _inBlth,
                                        @RequestParam(value = "_inStatus", defaultValue = "")String _inStatus,
                                        @RequestParam(value = "_inNorek", defaultValue = "")String _inNorek,
                                        @RequestParam(value = "_inAlasan", defaultValue = "")String _inAlasan,
                                        @RequestParam(value = "_inTglBayar", defaultValue = "")String _inTglBayar,
                                        @RequestParam(value = "_inTransaksiId", defaultValue = "")String _inTransaksiId) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            //todo: controller disuspend dulu
//            retValue=  ws_batalTransaksiDao.SetDataIdpelBatal_23NOTA_Each(_inTransaksiBy,_inIdpel,_inKdPembPP,_inKdGerakKeluar,
//                                                                          _inBlth,_inStatus,_inNorek,_inAlasan,_inTglBayar,_inTransaksiId);
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
