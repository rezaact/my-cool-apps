package id.co.hans.sample.controller;


import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import id.co.hans.sample.server.dao.ws_TransaksiDao;
import id.co.hans.sample.server.utility.CommonModule;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.StringWriter;
import java.util.*;

@Controller
public class Ws_TransaksiController {

    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_TransaksiController.class);

    @Autowired
    ws_TransaksiDao ws_transaksiDao;


    @RequestMapping(value = "**/Ws_Transaksi/cekVersiAplikasi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cekVersiAplikasi(@RequestParam(value = "versi", defaultValue = "")String versi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.cekVersiAplikasi(versi);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_21entri.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_21entri(@RequestParam(value = "tpel", defaultValue = "")String tpel,
                                    @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                    @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                    @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_21entri(tpel,vJenis,tBLTH,tPetugas);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }



    @RequestMapping(value = "**/Ws_Transaksi/GetView21.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetView21(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                                    @RequestParam(value = "tglAwal", defaultValue = "")String tglAwal,
                                    @RequestParam(value = "tglAkhir", defaultValue = "")String tglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetView21(unitup,tglAwal,tglAkhir);
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



    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_21Suplisi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_21Suplisi(@RequestParam(value = "tpel", defaultValue = "")String tpel,
                                      @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                      @RequestParam(value = "tKoreksi", defaultValue = "")String tKoreksi,
                                      @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_21Suplisi(tpel,tBLTH,tKoreksi,tPetugas);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_21HapusGagal.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_21HapusGagal(@RequestParam(value = "tpel", defaultValue = "")String tpel,
                                         @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                         @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                         @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                         @RequestParam(value = "tTglBayar", defaultValue = "")String tTglBayar,
                                         @RequestParam(value = "tKodePp", defaultValue = "")String tKodePp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_21HapusGagal(tpel,vJenis,tBLTH,tPetugas,tTglBayar,tKodePp);
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



    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_PembatalanDenda.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_PembatalanDenda(@RequestParam(value = "tpel", defaultValue = "")String tpel,
                                         @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                         @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                         @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_PembatalanDenda(tpel,vJenis,tBLTH,tPetugas);
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



    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_31.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_31(@RequestParam(value = "tpel", defaultValue = "")String tpel,
                                            @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                            @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                            @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_31(tpel,vJenis,tBLTH,tPetugas);

            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }



    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_41DUPR.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_41DUPR(@RequestParam(value = "tpel", defaultValue = "")String tpel,
                                            @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                            @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                            @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_41DUPR(tpel,vJenis,tBLTH,tPetugas);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_32DUPP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_32DUPP(@RequestParam(value = "tpel", defaultValue = "")String tpel,
                                   @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                   @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                   @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_32DUPP(tpel,vJenis,tBLTH,tPetugas);
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

    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_41.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_41(@RequestParam(value = "tpel", defaultValue = "")String tpel,
                                   @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                   @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                   @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_41(tpel,vJenis,tBLTH,tPetugas);
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



    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_32.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_32(@RequestParam(value = "tpel", defaultValue = "")String tpel,
                                   @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                   @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                   @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_32(tpel,vJenis,tBLTH,tPetugas);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetViewKolektif_32DUPP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKolektif_32DUPP(@RequestParam(value = "tkodekolektif", defaultValue = "")String tkodekolektif,
                                   @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                   @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKolektif_32DUPP(tkodekolektif,tBLTH,tPetugas);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetViewKolektif_41DUPR.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKolektif_41DUPR(@RequestParam(value = "tkodekolektif", defaultValue = "")String tkodekolektif,
                                      @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                      @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKolektif_41DUPR(tkodekolektif,tBLTH,tPetugas);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetViewKolektif_21giralisasi.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKolektif_21giralisasi(@RequestParam(value = "tkodekolektif", defaultValue = "")String tkodekolektif,
                                            @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                            @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKolektif_21giralisasi(tkodekolektif,tBLTH,tPetugas);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Transaksi/GetViewKolektif_23pusat.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKolektif_23pusat(@RequestParam(value = "tkodekolektif", defaultValue = "")String tkodekolektif,
                                      @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                      @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKolektif_23pusat(tkodekolektif,tBLTH,tPetugas);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetViewKolektif_23NOTA.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKolektif_23NOTA(@RequestParam(value = "tkodekolektif", defaultValue = "")String tkodekolektif,
                                      @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                      @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKolektif_23NOTA(tkodekolektif,tBLTH,tPetugas);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_12ABC.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_12ABC(@RequestParam(value = "tpel", defaultValue = "")String tpel,
                                      @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                      @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                      @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_12ABC(tpel,vJenis,tBLTH,tPetugas);
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

    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_12ABCORATOORA.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_12ABCORATOORA(@RequestParam(value = "tpel", defaultValue = "")String tpel,
                                  @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                  @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                  @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                  @RequestParam(value = "ORATOORA", defaultValue = "")Boolean ORATOORA,
                                  @RequestParam(value = "kdkrs", defaultValue = "")String kdkrs) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_12ABCORATOORA(tpel,vJenis,tBLTH,tPetugas,ORATOORA,kdkrs);
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

    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_12DE.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_12DE(@RequestParam(value = "tpel", defaultValue = "")String tpel,
                                  @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                  @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                  @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_12DE(tpel,vJenis,tBLTH,tPetugas);
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

    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_12D.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_12D(@RequestParam(value = "tpel", defaultValue = "")String tpel,
                                  @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                  @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                  @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_12D(tpel,vJenis,tBLTH,tPetugas);
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
    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_13LAMA.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_13LAMA(@RequestParam(value = "tpel", defaultValue = "")String tpel,
                                  @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                  @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                  @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_13LAMA(tpel,vJenis,tBLTH,tPetugas);
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

    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_13BARU.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_13BARU(@RequestParam(value = "tpel", defaultValue = "")String tpel,
                                  @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                  @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                  @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_13BARU(tpel,vJenis,tBLTH,tPetugas);
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

       @RequestMapping(value = "**/Ws_Transaksi/Getview_SOREKORATOORA.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject Getview_SOREKORATOORA(@RequestParam(value = "unitap", defaultValue = "")String unitap,
                                  @RequestParam(value = "unitup", defaultValue = "")String unitup,
                                  @RequestParam(value = "thbl", defaultValue = "")String thbl,
                                  @RequestParam(value = "KDKELOMPOK", defaultValue = "")String KDKELOMPOK,
                                  @RequestParam(value = "strglobalkodepetugas", defaultValue = "")String strglobalkodepetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.Getview_SOREKORATOORA(unitap,unitup,thbl,KDKELOMPOK,strglobalkodepetugas);
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


    @RequestMapping(value = "**/Ws_Transaksi/Getview_SOREKORATOORANEW.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject Getview_SOREKORATOORANEW(@RequestParam(value = "unitap", defaultValue = "")String unitap,
                                  @RequestParam(value = "unitup", defaultValue = "")String unitup,
                                  @RequestParam(value = "thbl", defaultValue = "")String thbl,
                                  @RequestParam(value = "KDKELOMPOK", defaultValue = "")String KDKELOMPOK,
                                  @RequestParam(value = "strglobalkodepetugas", defaultValue = "")String strglobalkodepetugas,
                                  @RequestParam(value = "_package", defaultValue = "")String _package) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.Getview_SOREKORATOORANEW(unitap,unitup,thbl,KDKELOMPOK,strglobalkodepetugas,_package);
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


    @RequestMapping(value = "**/Ws_Transaksi/Getview_SUSULANORATOORA.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject Getview_SUSULANORATOORA(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                                  @RequestParam(value = "thbl", defaultValue = "")String thbl,
                                  @RequestParam(value = "KDKELOMPOK", defaultValue = "")String KDKELOMPOK,
                                  @RequestParam(value = "strglobalkodepetugas", defaultValue = "")String strglobalkodepetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.Getview_SUSULANORATOORA(unitup,thbl,KDKELOMPOK,strglobalkodepetugas);
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

    //---tambahan untuk cari idpel dari nopel
      @RequestMapping(value = "**/Ws_Transaksi/GetIdpel.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetIdpel(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                       @RequestParam(value = "tPEL", defaultValue = "")String tPEL) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetIdpel(vJenis,tPEL);
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
    //---end tambahan untuk cari idpel dari nopel

    //------------Transaksi Proc-------------------------------

    @RequestMapping(value = "**/Ws_Transaksi/SetData_11.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetData_11(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                        @RequestParam(value = "thbl", defaultValue = "")String thbl,
                        @RequestParam(value = "strglobalkodepetugas", defaultValue = "")String strglobalkodepetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetData_11(unitup,thbl,strglobalkodepetugas);
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


    @RequestMapping(value = "**/Ws_Transaksi/SetData_11_New.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject SetData_11_New(@RequestParam(value = "unitap", defaultValue = "")String unitap,
                              @RequestParam(value = "unitup", defaultValue = "")String unitup,
                              @RequestParam(value = "kdprosesklp", defaultValue = "")String kdprosesklp,
                              @RequestParam(value = "thbl", defaultValue = "")String thbl,
                              @RequestParam(value = "strglobalkodepetugas", defaultValue = "")String strglobalkodepetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetData_11_New(unitap,unitup,kdprosesklp,thbl,strglobalkodepetugas);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Transaksi/SetData_11_Cutoff.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetData_11_Cutoff(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                          @RequestParam(value = "thbl", defaultValue = "")String thbl,
                          @RequestParam(value = "strglobalkodepetugas", defaultValue = "")String strglobalkodepetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetData_11_Cutoff(unitup,thbl,strglobalkodepetugas);
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

    @RequestMapping(value = "**/Ws_Transaksi/SetData_13.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetData_13(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                          @RequestParam(value = "thbl", defaultValue = "")String thbl,
                          @RequestParam(value = "strglobalkodepetugas", defaultValue = "")String strglobalkodepetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetData_13(unitup,thbl,strglobalkodepetugas);
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

    // strData : {"strData":[{"BLTH":"201008", "ABONMETER":"M", ... }]}
    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_31.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_31(@RequestParam(value = "lbrproses", defaultValue = "")Integer lbrproses,
                          @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                          @RequestParam(value = "strData", defaultValue = "")String strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {

            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            Object sourceDataJsonObject = parser.parse(strData);

            List<Map<String, String>> sourceDataObject = (List<Map<String, String>>) sourceDataJsonObject;

            retValue =  ws_transaksiDao.SetDataIdpel_31(lbrproses,tTransaksiBy,sourceDataObject);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retValue.put("wsReturn", null);
            retValue.put("wsByRefError", ex.getMessage());
            obj.put("result", retValue);
        }

        return obj;
    }

     @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_41DUPR.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_41DUPR(@RequestParam(value = "dtrans", defaultValue = "")List<Map<String, String>> dtrans,
                                   @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_41DUPR(dtrans,tTransaksiBy);
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

    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_32DUPP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_32DUPP(@RequestParam(value = "dtrans", defaultValue = "")List<Map<String,String>>  dtrans,
                          @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_32DUPP(dtrans,tTransaksiBy);
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


    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_41.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_41(@RequestParam(value = "dtrans", defaultValue = "")List<Map<String,String>>  dtrans,
                                   @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_41(dtrans,tTransaksiBy);
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

    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_32.json", method = RequestMethod.GET, produces = "application/json")
     public @ResponseBody
     JSONObject SetDataIdpel_32(@RequestParam(value = "dtrans", defaultValue = "")List<Map<String,String>>  dtrans,
                                    @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_32(dtrans,tTransaksiBy);
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



    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_21entri.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_21entri(@RequestParam(value = "lbrproses", defaultValue = "")Integer  lbrproses,
            @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
            @RequestParam(value = "tTglBayar", defaultValue = "")String tTglBayar,
            @RequestParam(value = "tKdPP", defaultValue = "")String tKdPP,
            @RequestParam(value = "tKDPEMBAYAR", defaultValue = "")String tKDPEMBAYAR,
            @RequestParam(value = "strData", defaultValue = "")String strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();

        try {

            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            Object sourceDataJsonObject = parser.parse(strData);

            List<Map<String, String>> sourceDataObject = (List<Map<String, String>>) sourceDataJsonObject;

            retValue=  ws_transaksiDao.SetDataIdpel_21entri(lbrproses, tTransaksiBy, tTglBayar, tKdPP, tKDPEMBAYAR, sourceDataObject);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retValue.put("wsReturn", null);
            retValue.put("wsByRefError", ex.getMessage());
            obj.put("result", retValue);
        }

        return obj;
    }


    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_21HapusGagal.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_21HapusGagal(@RequestParam(value = "dtrans", defaultValue = "")List<Map<String,String>>  dtrans,
                                    @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                    @RequestParam(value = "tTglBayar", defaultValue = "")String tTglBayar,
                                    @RequestParam(value = "tKdPP", defaultValue = "")String tKdPP,
                                    @RequestParam(value = "tKDPEMBAYAR", defaultValue = "")String tKDPEMBAYAR) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_21HapusGagal(dtrans,tTransaksiBy,tTglBayar,tKdPP,tKDPEMBAYAR);
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


    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_21Suplisi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_21Suplisi(@RequestParam(value = "dtrans", defaultValue = "")List<Map<String,String>>  dtrans,
                                         @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_21Suplisi(dtrans,tTransaksiBy);
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


    @RequestMapping(value = "**/Ws_Transaksi/SetData_21upload.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetData_21upload(@RequestParam(value = "dtrans", defaultValue = "")List<Map<String,String>>  dtrans,
                                         @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                         @RequestParam(value = "tTglBayar", defaultValue = "")String tTglBayar,
                                         @RequestParam(value = "tKdPP", defaultValue = "")String tKdPP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetData_21upload(dtrans,tTransaksiBy,tTglBayar,tKdPP);
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


    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_PembatalanDenda.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_PembatalanDenda(@RequestParam(value = "dtrans", defaultValue = "")List<Map<String,String>>  dtrans,
                                         @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                         @RequestParam(value = "tTglBayar", defaultValue = "")String tTglBayar,
                                         @RequestParam(value = "tKdPP", defaultValue = "")String tKdPP,
                                         @RequestParam(value = "tKDPEMBAYAR", defaultValue = "")String tKDPEMBAYAR) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_PembatalanDenda(dtrans,tTransaksiBy,tTglBayar,tKdPP,tKDPEMBAYAR);
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


    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_23NOTABUKU.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_23NOTABUKU(@RequestParam(value = "lbrproses", defaultValue = "")Integer  lbrproses,
                                    @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                    @RequestParam(value = "tKirim", defaultValue = "")String tKirim,
                                    @RequestParam(value = "strData", defaultValue = "")List<Map<String,String>> strData,
                                    @RequestParam(value = "tBebanKantor", defaultValue = "")Integer tBebanKantor) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_23NOTABUKU(lbrproses,tTransaksiBy,tKirim,strData,tBebanKantor);
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

    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_23NOTATERPUSAT.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_23NOTATERPUSAT(@RequestParam(value = "lbrproses", defaultValue = "")Integer  lbrproses,
                                    @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                    @RequestParam(value = "tKirim", defaultValue = "")String tKirim,
                                    @RequestParam(value = "strData", defaultValue = "")List<Map<String,String>> strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_23NOTATERPUSAT(lbrproses,tTransaksiBy,tKirim,strData);
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



    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_21GIRALISASI.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_21GIRALISASI(@RequestParam(value = "lbrproses", defaultValue = "")Integer  lbrproses,
                                    @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                    @RequestParam(value = "tKirim", defaultValue = "")String tKirim,
                                    @RequestParam(value = "tKodePP", defaultValue = "")String tKodePP,
                                    @RequestParam(value = "tTglBayar", defaultValue = "")String tTglBayar,
                                    @RequestParam(value = "strData", defaultValue = "")List<Map<String,String>> strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_21GIRALISASI(lbrproses,tTransaksiBy,tKirim,tKodePP,tTglBayar,strData);
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



    @RequestMapping(value = "**/Ws_Transaksi/Server_Download_DPH_AJN.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject Server_Download_DPH_AJN(@RequestParam(value = "parUNITUP", defaultValue = "")String  parUNITUP,
                                    @RequestParam(value = "parTglMulai", defaultValue = "")Date parTglMulai,
                                    @RequestParam(value = "parTglSampai", defaultValue = "")Date parTglSampai) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.Server_Download_DPH_AJN(parUNITUP,parTglMulai,parTglSampai);
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


    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_32DHPfromDUPP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_32DHPfromDUPP(@RequestParam(value = "lbrproses", defaultValue = "")Integer  lbrproses,
                                    @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                    @RequestParam(value = "tKirim", defaultValue = "")String tKirim,
                                    @RequestParam(value = "strData", defaultValue = "")List<Map<String,String>> strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_32DHPfromDUPP(lbrproses,tTransaksiBy,tKirim,strData);
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



    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_41PRRfromDUPR.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_41PRRfromDUPR(@RequestParam(value = "lbrproses", defaultValue = "")Integer  lbrproses,
                                    @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                    @RequestParam(value = "tKirim", defaultValue = "")String tKirim,
                                    @RequestParam(value = "strData", defaultValue = "")List<Map<String,String>> strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_41PRRfromDUPR(lbrproses,tTransaksiBy,tKirim,strData);
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




    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_12ABC.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_12ABC(@RequestParam(value = "dtrans", defaultValue = "")List<Map<String,String>>  dtrans,
                                         @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                         @RequestParam(value = "tKdkoreksi", defaultValue = "")String tKdkoreksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_12ABC(dtrans,tTransaksiBy,tKdkoreksi);
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


    @RequestMapping(value = "**/Ws_Transaksi/New_SetDataIdpel_12ABC.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject New_SetDataIdpel_12ABC(@RequestParam(value = "dtrans", defaultValue = "")List<Map<String,String>>  dtrans,
                                         @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                         @RequestParam(value = "tKdkoreksi", defaultValue = "")String tKdkoreksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.New_SetDataIdpel_12ABC(dtrans,tTransaksiBy,tKdkoreksi);
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


    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_12ABCNew.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_12ABCNew(     @RequestParam(value = "hasil", defaultValue = "")Integer  hasil,
                                          @RequestParam(value = "idpel", defaultValue = "")String  idpel,
                                          @RequestParam(value = "SLALWBP", defaultValue = "")Integer SLALWBP,
                                          @RequestParam(value = "SAHLWBP", defaultValue = "")Integer SAHLWBP,
                                          @RequestParam(value = "SLAWBP", defaultValue = "")Integer SLAWBP,
                                          @RequestParam(value = "SAHWBP", defaultValue = "")Integer SAHWBP,
                                          @RequestParam(value = "SLAKVARH", defaultValue = "")Integer SLAKVARH,
                                          @RequestParam(value = "SAHKVARH", defaultValue = "")Integer SAHKVARH,
                                          @RequestParam(value = "SAHKVAMAKS", defaultValue = "")Integer SAHKVAMAKS,
                                          @RequestParam(value = "HITUNGBY", defaultValue = "")String HITUNGBY) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            //todo: datatype
            retValue=  ws_transaksiDao.SetDataIdpel_12ABCNew(hasil,idpel,"",SLALWBP,SAHLWBP,SLAWBP,SAHWBP,SLAKVARH,SAHKVARH,SAHKVAMAKS,HITUNGBY);
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

    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_12ABCNewJabar.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_12ABCNewJabar(@RequestParam(value = "idpel", defaultValue = "")String  idpel,
                                         @RequestParam(value = "THBLREK", defaultValue = "")String thblrek,
                                         @RequestParam(value = "SLALWBP", defaultValue = "")Integer SLALWBP,
                                         @RequestParam(value = "SAHLWBP", defaultValue = "")Integer SAHLWBP,
                                         @RequestParam(value = "SLAWBP", defaultValue = "")Integer SLAWBP,
                                         @RequestParam(value = "SAHWBP", defaultValue = "")Integer SAHWBP,
                                         @RequestParam(value = "SLAKVARH", defaultValue = "")Integer SLAKVARH,
                                         @RequestParam(value = "SAHKVARH", defaultValue = "")Integer SAHKVARH,
                                         @RequestParam(value = "SAHKVAMAKS", defaultValue = "")Integer SAHKVAMAKS,
                                         @RequestParam(value = "HITUNGBY", defaultValue = "")String HITUNGBY,
                                         @RequestParam(value = "SLALWBP_PASANG", defaultValue = "")Integer SLALWBP_PASANG,
                                         @RequestParam(value = "SAHLWBP_CABUT", defaultValue = "")Integer SAHLWBP_CABUT,
                                         @RequestParam(value = "SLAWBP_PASANG", defaultValue = "")Integer SLAWBP_PASANG,
                                         @RequestParam(value = "SAHWBP_CABUT", defaultValue = "")Integer SAHWBP_CABUT,
                                         @RequestParam(value = "SLAKVARH_PASANG", defaultValue = "")Integer SLAKVARH_PASANG,
                                         @RequestParam(value = "SAHKVARH_CABUT", defaultValue = "")Integer SAHKVARH_CABUT,
                                         @RequestParam(value = "SAHKVAMAKS_CABUT", defaultValue = "")Integer SAHKVAMAKS_CABUT,
                                         @RequestParam(value = "_package", defaultValue = "")String _package) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_12ABCNewJabar(idpel,thblrek,SLALWBP,SAHLWBP,SLAWBP,SAHWBP,SLAKVARH,SAHKVARH,SAHKVAMAKS,
                                                                 HITUNGBY,SLALWBP_PASANG,SAHLWBP_CABUT,SLAWBP_PASANG,SAHWBP_CABUT,
                                                                 SLAKVARH_PASANG,SAHKVARH_CABUT,SAHKVAMAKS_CABUT,_package);
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


    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_12DE.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_12DE(@RequestParam(value = "dtrans", defaultValue = "")List<Map<String, String>>  dtrans,
                                         @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                         @RequestParam(value = "tKdkoreksi", defaultValue = "")String tKdkoreksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_12DE(dtrans,tTransaksiBy,tKdkoreksi);
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



    @RequestMapping(value = "**/Ws_Transaksi/exeprocORA.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject exeprocORA(@RequestParam(value = "exec", defaultValue = "")Boolean  exec,
                                         @RequestParam(value = "procedurename", defaultValue = "")String procedurename,
                                         @RequestParam(value = "paramvalue", defaultValue = "")List<Map<String,String>> paramvalue) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.exeprocORA(exec,procedurename,paramvalue);
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


    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_12D.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_12D(@RequestParam(value = "dtrans", defaultValue = "")List<Map<String,String>>  dtrans,
                                         @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                         @RequestParam(value = "tKdkoreksi", defaultValue = "")String tKdkoreksi,
                                         @RequestParam(value = "tKdPP", defaultValue = "")Boolean bSuplisi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_12D(dtrans,tTransaksiBy,tKdkoreksi,bSuplisi);
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



     @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_13.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_13(@RequestParam(value = "dtrans", defaultValue = "")List<Map<String,String>>  dtrans,
                                         @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                         @RequestParam(value = "tJenis", defaultValue = "")String tJenis) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_13(dtrans,tTransaksiBy,tJenis);
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

    //----tambahan sumbar sorek oratoora
     @RequestMapping(value = "**/Ws_Transaksi/SetData_13UPLOAD.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetData_13UPLOAD(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                               @RequestParam(value = "thbl", defaultValue = "")String thbl,
                               @RequestParam(value = "strglobalkodepetugas", defaultValue = "")String strglobalkodepetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetData_13UPLOAD(unitup,thbl,strglobalkodepetugas);
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


    //----end tambahan sumbar sorek oratoora


    //---------------------------LAporan Pemantauan

    @RequestMapping(value = "**/Ws_Transaksi/PemantauanTransaksi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject PemantauanTransaksi(@RequestParam(value = "Transaksi", defaultValue = "")String Transaksi,
                                @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                @RequestParam(value = "vPilihTgl", defaultValue = "")String vPilihTgl,
                                @RequestParam(value = "tUnitKJ", defaultValue = "")String tUnitKJ,
                                @RequestParam(value = "tUnitUP", defaultValue = "")String tUnitUP,
                                @RequestParam(value = "tUnitAP", defaultValue = "")String tUnitAP,
                                @RequestParam(value = "tTglmulai", defaultValue = "")String tTglmulai,
                                @RequestParam(value = "tTglsampai", defaultValue = "")String tTglsampai,
                                @RequestParam(value = "tKdpp", defaultValue = "")String tKdpp,
                                @RequestParam(value = "tKdPembayar", defaultValue = "")String tKdPembayar,
                                @RequestParam(value = "tKode", defaultValue = "")String tKode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.PemantauanTransaksi(Transaksi,vJenis,vPilihTgl,tUnitKJ,tUnitUP,tUnitAP,tTglmulai,tTglsampai,tKdpp,tKdPembayar,tKode);
            obj.put("result", retValue.get("wsReturn"));
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }




    @RequestMapping(value = "**/Ws_Transaksi/PemantauanJurnal.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject PemantauanJurnal(@RequestParam(value = "vPilihTgl", defaultValue = "")String vPilihTgl,
                                   @RequestParam(value = "tUnitUP", defaultValue = "")String tUnitUP,
                                   @RequestParam(value = "tUnitAP", defaultValue = "")String tUnitAP,
                                   @RequestParam(value = "tTglmulai", defaultValue = "")String tTglmulai,
                                   @RequestParam(value = "tTglsampai", defaultValue = "")String tTglsampai,
                                   @RequestParam(value = "tBlTh", defaultValue = "")String tBlTh) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.PemantauanJurnal(vPilihTgl,tUnitUP,tUnitAP,tTglmulai,tTglsampai,tBlTh);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;
    }


    @RequestMapping(value = "**/Ws_Transaksi/PemantauanSaldo.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject PemantauanSaldo(@RequestParam(value = "vPilihSaldo", defaultValue = "")String vPilihSaldo,
                                   @RequestParam(value = "vPilihRep", defaultValue = "")String vPilihRep,
                                   @RequestParam(value = "tUnitUP", defaultValue = "")String tUnitUP,
                                   @RequestParam(value = "tUnitAP", defaultValue = "")String tUnitAP,
                                   @RequestParam(value = "tTglmulai", defaultValue = "")String tTglmulai,
                                   @RequestParam(value = "tTglsampai", defaultValue = "")String tTglsampai,
                                   @RequestParam(value = "tBlTh", defaultValue = "")String tBlTh,
                                   @RequestParam(value = "in_unitupi", defaultValue = "")String in_unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.PemantauanSaldo(vPilihSaldo,vPilihRep,tUnitUP,tUnitAP,tTglmulai,tTglsampai,tBlTh,in_unitup);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;
    }


    @RequestMapping(value = "**/Ws_Transaksi/PemantauanSaldo_v2.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject PemantauanSaldo_v2(@RequestParam(value = "vPilihSaldo", defaultValue = "")String vPilihSaldo,
                               @RequestParam(value = "vPilihRep", defaultValue = "")String vPilihRep,
                               @RequestParam(value = "tUnitUP", defaultValue = "")String tUnitUP,
                               @RequestParam(value = "tUnitAP", defaultValue = "")String tUnitAP,
                               @RequestParam(value = "tUnitUPI", defaultValue = "")String tUnitUPI,
                               @RequestParam(value = "tTglmulai", defaultValue = "")String tTglmulai,
                               @RequestParam(value = "tTglsampai", defaultValue = "")String tTglsampai,
                               @RequestParam(value = "tBlTh", defaultValue = "")String tBlTh,
                               @RequestParam(value = "in_unitupi", defaultValue = "")String in_unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.PemantauanSaldo_v2(vPilihSaldo,vPilihRep,tUnitUP,tUnitAP,tUnitUPI,tTglmulai,tTglsampai,tBlTh,in_unitup);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;
    }


    //-------GENERAL Transaksi dan Laporan-------------------
    @RequestMapping(value = "**/Ws_Transaksi/GetViewALASANHAPUSBK.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewALASANHAPUSBK(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                   @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewALASANHAPUSBK(vJenis,tPetugas);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Transaksi/ambilTanggalHariIni.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilTanggalHariIni() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilTanggalHariIni();
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Transaksi/GetViewKODEPP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKODEPP(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                    @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKODEPP(vJenis,tPetugas);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Transaksi/GetViewKODEKOLEKTIF21GIRALISASI.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKODEKOLEKTIF21GIRALISASI(){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKODEKOLEKTIF21GIRALISASI();
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


      @RequestMapping(value = "**/Ws_Transaksi/GetViewKODEKOLEKTIF21GIRALISASIUNITUP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKODEKOLEKTIF21GIRALISASIUNITUP(@RequestParam(value = "sUnitup", defaultValue = "")String sUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKODEKOLEKTIF21GIRALISASIUNITUP(sUnitup);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Transaksi/GetViewKODEKOLEKTIF23PUSAT.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKODEKOLEKTIF23PUSAT() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKODEKOLEKTIF23PUSAT();
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Transaksi/GetViewKODEKOLEKTIF23PUSATUNITUP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKODEKOLEKTIF23PUSATUNITUP(@RequestParam(value = "sUnitup", defaultValue = "")String sUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKODEKOLEKTIF23PUSATUNITUP(sUnitup);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Transaksi/GetViewKODEKOLEKTIF23NOTA.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKODEKOLEKTIF23NOTA() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKODEKOLEKTIF23NOTA();
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

      @RequestMapping(value = "**/Ws_Transaksi/GetViewKODEKOLEKTIF23NOTAUNITUP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    //JSONObject GetViewKODEKOLEKTIF23NOTAUNITUP(@RequestParam(value = "sunitup", defaultValue = "")String sunitup,
     Map<String, Object> GetViewKODEKOLEKTIF23NOTAUNITUP(@RequestParam(value = "sunitup", defaultValue = "")String sunitup,
                                    @RequestParam(value = "iBebanKantor", defaultValue = "")Integer iBebanKantor) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKODEKOLEKTIF23NOTAUNITUP(sunitup,iBebanKantor);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return retValue;

    }


    @RequestMapping(value = "**/Ws_Transaksi/GetViewKODEKELOMPOK.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKODEKELOMPOK(@RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                    @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKODEKELOMPOK(tTHBL,tPetugas);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Transaksi/GetViewKODEKELOMPOKUNIT.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKODEKELOMPOKUNIT(@RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                    @RequestParam(value = "tUNIT", defaultValue = "")String tUNIT) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKODEKELOMPOKUNIT(tTHBL,tUNIT);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Transaksi/GetViewKODEKELOMPOKBYSIKLIS.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKODEKELOMPOKBYSIKLIS(@RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                    @RequestParam(value = "tSIKLIS", defaultValue = "")String tSIKLIS) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKODEKELOMPOKBYSIKLIS(tTHBL,tSIKLIS);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Transaksi/GetViewKODERR.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKODERR(@RequestParam(value = "vJenis", defaultValue = "")String tUNIT) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKODERR(tUNIT);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Transaksi/GetTempSorek.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetTempSorek() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetTempSorek();
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Transaksi/GetViewKODEKOREKSI.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKODEKOREKSI() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewKODEKOREKSI();
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Transaksi/GetTempDKRP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetTempDKRP() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetTempDKRP();
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //--------kolektif23nota


    @RequestMapping(value = "**/Ws_Transaksi/GetDataKolektifNotaBuku.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataKolektifNotaBuku() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataKolektifNotaBuku();
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


       @RequestMapping(value = "**/Ws_Transaksi/GetDataKolektifNotaBukuUnitup.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataKolektifNotaBukuUnitup(@RequestParam(value = "sUnitUp", defaultValue = "")String sUnitUp,
                                    @RequestParam(value = "iBebanKantor", defaultValue = "")String iBebanKantor) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataKolektifNotaBukuUnitup(sUnitUp,iBebanKantor);
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


    //--------kolektif23KIRIM


    @RequestMapping(value = "**/Ws_Transaksi/GetDataKolektifKirim.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataKolektifKirim() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataKolektifKirim();
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

    @RequestMapping(value = "**/Ws_Transaksi/GetDataKolektifNotaTerpusat.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataKolektifNotaTerpusat() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataKolektifNotaTerpusat();
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


   @RequestMapping(value = "**/Ws_Transaksi/GetDataKolektifNotaTerpusatUnitup.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataKolektifNotaTerpusatUnitup(@RequestParam(value = "sUnitUP", defaultValue = "")String sUnitUP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataKolektifNotaTerpusatUnitup(sUnitUP);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetDataKolektifGiralisasi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataKolektifGiralisasi() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataKolektifGiralisasi();
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


    @RequestMapping(value = "**/Ws_Transaksi/GetDataKolektifGiralisasiUnitup.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataKolektifGiralisasiUnitup(@RequestParam(value = "sUnitUp", defaultValue = "")String sUnitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataKolektifGiralisasiUnitup(sUnitUp);
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



    @RequestMapping(value = "**/Ws_Transaksi/GetDataIdPelNotaBuku.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataIdPelNotaBuku(@RequestParam(value = "tkodekolektif", defaultValue = "")String tkodekolektif) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataIdPelNotaBuku(tkodekolektif);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }
        return obj;
    }


    @RequestMapping(value = "**/Ws_Transaksi/GetDataIdPelKirim.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataIdPelKirim(@RequestParam(value = "tkodekolektif", defaultValue = "")String tkodekolektif) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataIdPelKirim(tkodekolektif);
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



    @RequestMapping(value = "**/Ws_Transaksi/GetDataIdPelNotaTerpusat.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataIdPelNotaTerpusat(@RequestParam(value = "tkodekolektif", defaultValue = "")String tkodekolektif) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataIdPelNotaTerpusat(tkodekolektif);
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

   @RequestMapping(value = "**/Ws_Transaksi/GetDataIdPelDil.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataIdPelDil(@RequestParam(value = "tidpel", defaultValue = "")String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataIdPelDil(tidpel);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }
    @RequestMapping(value = "**/Ws_Transaksi/GetDataNoPelDil.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataNoPelDil(@RequestParam(value = "tNopel", defaultValue = "")String tNopel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataNoPelDil(tNopel);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Transaksi/GetDataIdPelDPP.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataIdPelDPP(@RequestParam(value = "tidpel", defaultValue = "")String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataIdPelDPP(tidpel);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Transaksi/GetDataIdPelDPPNotaTerpusat.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataIdPelDPPNotaTerpusat(@RequestParam(value = "tidpel", defaultValue = "")String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataIdPelDPPNotaTerpusat(tidpel);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetDataIdPelDPPGiralisasi.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataIdPelDPPGiralisasi(@RequestParam(value = "tidpel", defaultValue = "")String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataIdPelDPPGiralisasi(tidpel);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Transaksi/GetDataIdPelGiralisasi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataIdPelGiralisasi(@RequestParam(value = "tkodekolektif", defaultValue = "")String tkodekolektif) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataIdPelGiralisasi(tkodekolektif);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }
        return obj;
    }



    @RequestMapping(value = "**/Ws_Transaksi/simpandatapel.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject simpandatapel(@RequestParam(value = "tidpel", defaultValue = "")String tidpel,
                             @RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                             @RequestParam(value = "ket", defaultValue = "")String ket,
                             @RequestParam(value = "Atransaksiby", defaultValue = "")String Atransaksiby,
                             @RequestParam(value = "Atgl_transaksi", defaultValue = "")String Atgl_transaksi,
                             @RequestParam(value = "tNopel", defaultValue = "")String tNopel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.simpandatapel(tidpel,tKdKolektif,ket,Atransaksiby,Atgl_transaksi,tNopel);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;
    }


    @RequestMapping(value = "**/Ws_Transaksi/simpandatapelKirim.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpandatapelKirim(@RequestParam(value = "tidpel", defaultValue = "")String tidpel,
                             @RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                             @RequestParam(value = "ket", defaultValue = "")String ket,
                             @RequestParam(value = "Atransaksiby", defaultValue = "")String Atransaksiby,
                             @RequestParam(value = "Atgl_transaksi", defaultValue = "")String Atgl_transaksi,
                             @RequestParam(value = "tNopel", defaultValue = "")String tNopel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.simpandatapelKirim(tidpel,tKdKolektif,ket,Atransaksiby,Atgl_transaksi,tNopel);
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


    @RequestMapping(value = "**/Ws_Transaksi/simpandatapelNotaTerpusat.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpandatapelNotaTerpusat(@RequestParam(value = "tidpel", defaultValue = "")String tidpel,
                                  @RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                  @RequestParam(value = "ket", defaultValue = "")String ket,
                                  @RequestParam(value = "Atransaksiby", defaultValue = "")String Atransaksiby,
                                  @RequestParam(value = "Atgl_transaksi", defaultValue = "")String Atgl_transaksi,
                                  @RequestParam(value = "tNopel", defaultValue = "")String tNopel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.simpandatapelNotaTerpusat(tidpel,tKdKolektif,ket,Atransaksiby,Atgl_transaksi,tNopel);
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


    @RequestMapping(value = "**/Ws_Transaksi/simpandatapelGIRALISASI.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpandatapelGIRALISASI(@RequestParam(value = "tidpel", defaultValue = "")String tidpel,
                                         @RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                         @RequestParam(value = "ket", defaultValue = "")String ket,
                                         @RequestParam(value = "Atransaksiby", defaultValue = "")String Atransaksiby,
                                         @RequestParam(value = "Atgl_transaksi", defaultValue = "")String Atgl_transaksi,
                                         @RequestParam(value = "tNopel", defaultValue = "")String tNopel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.simpandatapelGIRALISASI(tidpel,tKdKolektif,ket,Atransaksiby,Atgl_transaksi,tNopel);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

  @RequestMapping(value = "**/Ws_Transaksi/GetDataValidasiKolektifNotaBuku.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataValidasiKolektifNotaBuku(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                               @RequestParam(value = "tidpel", defaultValue = "")String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataValidasiKolektifNotaBuku(tKdKolektif,tidpel);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }
        return obj;
    }


    @RequestMapping(value = "**/Ws_Transaksi/GetDataValidasiKolektifKirim.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataValidasiKolektifKirim(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                               @RequestParam(value = "tidpel", defaultValue = "")String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataValidasiKolektifKirim(tKdKolektif,tidpel);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetDataValidasiKolektifNotaTerpusat.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataValidasiKolektifNotaTerpusat(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                            @RequestParam(value = "tidpel", defaultValue = "")String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataValidasiKolektifNotaTerpusat(tKdKolektif,tidpel);
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

    @RequestMapping(value = "**/Ws_Transaksi/GetDataValidasiKolektifGiralisasi.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataValidasiKolektifGiralisasi(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                                 @RequestParam(value = "tidpel", defaultValue = "")String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataValidasiKolektifGiralisasi(tKdKolektif,tidpel);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Transaksi/deletedatapelNotaTerpusat.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject deletedatapelNotaTerpusat(@RequestParam(value = "tidpel", defaultValue = "")String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.deletedatapelNotaTerpusat(tidpel);
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


     @RequestMapping(value = "**/Ws_Transaksi/deletedatapelGiralisasi.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject deletedatapelGiralisasi(@RequestParam(value = "tidpel", defaultValue = "")String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.deletedatapelGiralisasi(tidpel);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Transaksi/deletedatapel.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject deletedatapel(@RequestParam(value = "tidpel", defaultValue = "")String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.deletedatapel(tidpel);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }



    @RequestMapping(value = "**/Ws_Transaksi/deletedatapelkirimkolektif.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject deletedatapelkirimkolektif(@RequestParam(value = "tidpel", defaultValue = "")String tidpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.deletedatapelkirimkolektif(tidpel);
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



    @RequestMapping(value = "**/Ws_Transaksi/GetNamaKolektifNotabuku.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject GetNamaKolektifNotabuku(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                       @RequestParam(value = "nulll", defaultValue = "")String nulll) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetNamaKolektifNotabuku(tKdKolektif,nulll);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }
        return obj;
    }


    @RequestMapping(value = "**/Ws_Transaksi/GetNamaKolektifKirim.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetNamaKolektifKirim(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                       @RequestParam(value = "nulll", defaultValue = "")String nulll) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetNamaKolektifKirim(tKdKolektif,nulll);
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

    @RequestMapping(value = "**/Ws_Transaksi/GetNamaKolektifNotaTerpusat.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetNamaKolektifNotaTerpusat(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                    @RequestParam(value = "nulll", defaultValue = "")String nulll) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetNamaKolektifNotaTerpusat(tKdKolektif,nulll);
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



    @RequestMapping(value = "**/Ws_Transaksi/GetNamaKolektifGiralisasi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetNamaKolektifGiralisasi(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                           @RequestParam(value = "nulll", defaultValue = "")String nulll) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetNamaKolektifGiralisasi(tKdKolektif,nulll);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Transaksi/simpandatakolektifNotaPusat.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpandatakolektifNotaPusat(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                         @RequestParam(value = "tnamakolektif", defaultValue = "")String tnamakolektif,
                                         @RequestParam(value = "tpetugas", defaultValue = "")String tpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.simpandatakolektifNotaPusat(tKdKolektif,tnamakolektif,tpetugas);
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

   @RequestMapping(value = "**/Ws_Transaksi/simpandatakolektifNotaPusatunitup.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpandatakolektifNotaPusatunitup(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                           @RequestParam(value = "tnamakolektif", defaultValue = "")String tnamakolektif,
                                           @RequestParam(value = "tpetugas", defaultValue = "")String tpetugas,
                                           @RequestParam(value = "tUnitup", defaultValue = "")String tUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.simpandatakolektifNotaPusatunitup(tKdKolektif,tnamakolektif,tpetugas,tUnitup);
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


    @RequestMapping(value = "**/Ws_Transaksi/simpandatakolektifGiralisasi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpandatakolektifGiralisasi(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                                 @RequestParam(value = "tnamakolektif", defaultValue = "")String tnamakolektif,
                                                 @RequestParam(value = "tpetugas", defaultValue = "")String tpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.simpandatakolektifGiralisasi(tKdKolektif,tnamakolektif,tpetugas);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Transaksi/simpandatakolektifGiralisasiunitup.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpandatakolektifGiralisasiunitup(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                                 @RequestParam(value = "tnamakolektif", defaultValue = "")String tnamakolektif,
                                                 @RequestParam(value = "tpetugas", defaultValue = "")String tpetugas,
                                                 @RequestParam(value = "tUnitup", defaultValue = "")String tUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.simpandatakolektifGiralisasiunitup(tKdKolektif,tnamakolektif,tpetugas,tUnitup);
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

    @RequestMapping(value = "**/Ws_Transaksi/simpandatakolektifNotaBuku.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpandatakolektifNotaBuku(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                                 @RequestParam(value = "tnamakolektif", defaultValue = "")String tnamakolektif,
                                                 @RequestParam(value = "tpetugas", defaultValue = "")String tpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.simpandatakolektifNotaBuku(tKdKolektif,tnamakolektif,tpetugas);
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

      @RequestMapping(value = "**/Ws_Transaksi/simpandatakolektifNotaBukuUnitup.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject simpandatakolektifNotaBukuUnitup(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                                 @RequestParam(value = "tnamakolektif", defaultValue = "")String tnamakolektif,
                                                 @RequestParam(value = "tpetugas", defaultValue = "")String tpetugas,
                                                 @RequestParam(value = "tUnitup", defaultValue = "")String tUnitup,
                                                 @RequestParam(value = "tBebanKantor", defaultValue = "")Integer tBebanKantor) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.simpandatakolektifNotaBukuUnitup(tKdKolektif,tnamakolektif,tpetugas,tUnitup,tBebanKantor);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }
        return obj;
    }

    @RequestMapping(value = "**/Ws_Transaksi/simpandatakolektifKirim.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpandatakolektifKirim(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                                 @RequestParam(value = "tnamakolektif", defaultValue = "")String tnamakolektif,
                                                 @RequestParam(value = "tpetugas", defaultValue = "")String tpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.simpandatakolektifKirim(tKdKolektif,tnamakolektif,tpetugas);
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


    @RequestMapping(value = "**/Ws_Transaksi/hapusdatakolektifNotaBuku.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject hapusdatakolektifNotaBuku(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                         @RequestParam(value = "tpetugas", defaultValue = "")String tpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.hapusdatakolektifNotaBuku(tKdKolektif,tpetugas);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }
        return obj;
    }



    @RequestMapping(value = "**/Ws_Transaksi/hapusdatakolektifKirim.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject hapusdatakolektifKirim(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                         @RequestParam(value = "tpetugas", defaultValue = "")String tpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.hapusdatakolektifKirim(tKdKolektif,tpetugas);
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


    @RequestMapping(value = "**/Ws_Transaksi/hapusdatakolektifNotaTerpusat.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject hapusdatakolektifNotaTerpusat(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                         @RequestParam(value = "tpetugas", defaultValue = "")String tpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.hapusdatakolektifNotaTerpusat(tKdKolektif,tpetugas);
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

      @RequestMapping(value = "**/Ws_Transaksi/hapusdatakolektifGiralisasi.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject hapusdatakolektifGiralisasi(@RequestParam(value = "tKdKolektif", defaultValue = "")String tKdKolektif,
                                         @RequestParam(value = "tpetugas", defaultValue = "")String tpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.hapusdatakolektifGiralisasi(tKdKolektif,tpetugas);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Transaksi/tampilkodekolektifNotaBuku.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject tampilkodekolektifNotaBuku() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.tampilkodekolektifNotaBuku();
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


    @RequestMapping(value = "**/Ws_Transaksi/tampilkodekolektifNotaBukuUnitup.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JSONObject tampilkodekolektifNotaBukuUnitup(@RequestParam(value = "sUnitup", defaultValue = "")String sUnitup,
                                         @RequestParam(value = "iBebanKantor", defaultValue = "")Integer iBebanKantor) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.tampilkodekolektifNotaBukuUnitup(sUnitup,iBebanKantor);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }
        return obj;
    }


    @RequestMapping(value = "**/Ws_Transaksi/tampilkodekolektifKirim.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject tampilkodekolektifKirim() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.tampilkodekolektifKirim();
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

    @RequestMapping(value = "**/Ws_Transaksi/tampilkodekolektifNotaPusat.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject tampilkodekolektifNotaPusat(){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.tampilkodekolektifNotaPusat();
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


    @RequestMapping(value = "**/Ws_Transaksi/tampilkodekolektifNotaPusatUnitup.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject tampilkodekolektifNotaPusatUnitup(@RequestParam(value = "sUnitUp", defaultValue = "")String sUnitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.tampilkodekolektifNotaPusatUnitup(sUnitUp);
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


    @RequestMapping(value = "**/Ws_Transaksi/tampilkodekolektifGiralisasi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject tampilkodekolektifGiralisasi() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.tampilkodekolektifGiralisasi();
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


    @RequestMapping(value = "**/Ws_Transaksi/tampilkodekolektifGiralisasiUnitup.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject tampilkodekolektifGiralisasiUnitup(@RequestParam(value = "sUnitup", defaultValue = "")String sUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.tampilkodekolektifGiralisasiUnitup(sUnitup);
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


    //---------------------------------Upload Sorek

    @RequestMapping(value = "**/Ws_Transaksi/CetakBeritaAcaraUpload.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject CetakBeritaAcaraUpload(@RequestParam(value = "sUnitup", defaultValue = "")String sUnitup,
                                      @RequestParam(value = "siklis", defaultValue = "")String siklis,
                                      @RequestParam(value = "blth", defaultValue = "")String blth,
                                      @RequestParam(value = "tempo", defaultValue = "")Date tempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.CetakBeritaAcaraUpload(sUnitup,siklis,blth,tempo);
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


    @RequestMapping(value = "**/Ws_Transaksi/ambilstructureclsSorek.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilstructureclsSorek() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilstructureclsSorek();
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

    @RequestMapping(value = "**/Ws_Transaksi/Server_executeSQLsWithConnection.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject Server_executeSQLsWithConnection(@RequestParam(value = "SQLs", defaultValue = "")String[] SQLs) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.Server_executeSQLsWithConnection(SQLs);
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


    @RequestMapping(value = "**/Ws_Transaksi/DELETETEMPSOREK.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject DELETETEMPSOREK(@RequestParam(value = "FileName", defaultValue = "")String FileName,
                                      @RequestParam(value = "unitup", defaultValue = "")String unitup,
                                      @RequestParam(value = "thbl", defaultValue = "")String thbl,
                                      @RequestParam(value = "TglServer", defaultValue = "")Date TglServer,
                                      @RequestParam(value = "strGlobalKodePetugas", defaultValue = "")String strGlobalKodePetugas,
                                      @RequestParam(value = "KDKELOMPOK", defaultValue = "")String KDKELOMPOK,
                                      @RequestParam(value = "TGLJTTEMPO", defaultValue = "")String TGLJTTEMPO) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.DELETETEMPSOREK(FileName,unitup,thbl,TglServer,strGlobalKodePetugas,KDKELOMPOK,TGLJTTEMPO);
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

    @RequestMapping(value = "**/Ws_Transaksi/iNSERTTEMPSOREK.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject iNSERTTEMPSOREK(@RequestParam(value = "tDTRANS", defaultValue = "")Map<String, Object> tDTRANS,
                                      @RequestParam(value = "TglServer", defaultValue = "")String TglServer,
                                      @RequestParam(value = "strGlobalKodePetugas", defaultValue = "")String strGlobalKodePetugas,
                                      @RequestParam(value = "KDKELOMPOK", defaultValue = "")String KDKELOMPOK,
                                      @RequestParam(value = "TGLJTTEMPO", defaultValue = "")String TGLJTTEMPO) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.iNSERTTEMPSOREK(tDTRANS,TglServer,strGlobalKodePetugas,KDKELOMPOK,TGLJTTEMPO);
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

       @RequestMapping(value = "**/Ws_Transaksi/iNSERTTEMPSOREKup13.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject iNSERTTEMPSOREKup13(@RequestParam(value = "tDTRANS", defaultValue = "")Map<String, Object> tDTRANS,
                               @RequestParam(value = "TglServer", defaultValue = "")Date TglServer,
                               @RequestParam(value = "strGlobalKodePetugas", defaultValue = "")String strGlobalKodePetugas,
                               @RequestParam(value = "KDKELOMPOK", defaultValue = "")String KDKELOMPOK,
                               @RequestParam(value = "TGLJTTEMPO", defaultValue = "")String TGLJTTEMPO) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.iNSERTTEMPSOREKup13(tDTRANS,TglServer,strGlobalKodePetugas,KDKELOMPOK,TGLJTTEMPO);
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


    //----tambahan sumbar sorek oratoora

    @RequestMapping(value = "**/Ws_Transaksi/INSERTTEMPSOREK_ORATOORA.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject INSERTTEMPSOREK_ORATOORA(@RequestParam(value = "unitap", defaultValue = "")String unitap,
                                   @RequestParam(value = "unitup", defaultValue = "")String unitup,
                                   @RequestParam(value = "thbl", defaultValue = "")String thbl,
                                   @RequestParam(value = "KDKELOMPOK", defaultValue = "")String KDKELOMPOK,
                                   @RequestParam(value = "strglobalkodepetugas", defaultValue = "")String strglobalkodepetugas,
                                   @RequestParam(value = "tgljatuhtempo", defaultValue = "")String tgljatuhtempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.INSERTTEMPSOREK_ORATOORA(unitap,unitup,thbl,KDKELOMPOK,strglobalkodepetugas,tgljatuhtempo);
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

      @RequestMapping(value = "**/Ws_Transaksi/INSERTTEMPSOREKSUSULAN_ORATOORA.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject INSERTTEMPSOREKSUSULAN_ORATOORA(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                                        @RequestParam(value = "thbl", defaultValue = "")String thbl,
                                        @RequestParam(value = "KDKELOMPOK", defaultValue = "")String KDKELOMPOK,
                                        @RequestParam(value = "strglobalkodepetugas", defaultValue = "")String strglobalkodepetugas,
                                        @RequestParam(value = "tgljatuhtempo", defaultValue = "")String tgljatuhtempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.INSERTTEMPSOREKSUSULAN_ORATOORA(unitup,thbl,KDKELOMPOK,strglobalkodepetugas,tgljatuhtempo);
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


    @RequestMapping(value = "**/Ws_Transaksi/iNSERTTEMPSOREKsusulan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject iNSERTTEMPSOREKsusulan(@RequestParam(value = "tDTRANS", defaultValue = "")Map<String, Object> tDTRANS,
                                        @RequestParam(value = "TglServer", defaultValue = "")Date TglServer,
                                        @RequestParam(value = "strGlobalKodePetugas", defaultValue = "")String strGlobalKodePetugas,
                                        @RequestParam(value = "KDKELOMPOK", defaultValue = "")String KDKELOMPOK,
                                        @RequestParam(value = "TGLJTTEMPO", defaultValue = "")String TGLJTTEMPO) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.iNSERTTEMPSOREKsusulan(tDTRANS,TglServer,strGlobalKodePetugas,KDKELOMPOK,TGLJTTEMPO);
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
    //----end tambahan sumbar sorek oratoora

    //------------------bATAL TRANSAKSI
       @RequestMapping(value = "**/Ws_Transaksi/BatalTransaksi_idpel.json", method = RequestMethod.GET, produces = "application/json")
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
            retValue=  ws_transaksiDao.BatalTransaksi_idpel(Transaksi,tpel,vJenis,tKode,tPetugas,tblthbuku);
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


    //----------------General TUL6 Waskit sorek

    @RequestMapping(value = "**/Ws_Transaksi/ambilTanggalDatabase.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilTanggalDatabase() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilTanggalDatabase();
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

    @RequestMapping(value = "**/Ws_Transaksi/ambilUnitUp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilUnitUp() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilUnitUp();
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

    @RequestMapping(value = "**/Ws_Transaksi/ambilNamaUp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNamaUp( @RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilNamaUp(unitUp);
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

   @RequestMapping(value = "**/Ws_Transaksi/ambilNamaApdariUp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNamaApdariUp( @RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilNamaApdariUp(unitUp);
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

    @RequestMapping(value = "**/Ws_Transaksi/ambilNamaKddariUp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNamaKddariUp( @RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilNamaKddariUp(unitUp);
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

     @RequestMapping(value = "**/Ws_Transaksi/ambilAlamatdariUp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilAlamatdariUp( @RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilAlamatdariUp(unitUp);
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


   @RequestMapping(value = "**/Ws_Transaksi/ambilKelompokSiklis.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilKelompokSiklis( @RequestParam(value = "unitup", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilKelompokSiklis(unitUp);
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

    //----------------Waskit transaksi dan laporan
  @RequestMapping(value = "**/Ws_Transaksi/sp_waskit_verifikasi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject sp_waskit_verifikasi( @RequestParam(value = "nav", defaultValue = "")Integer nav) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.sp_waskit_verifikasi(nav);
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

    @RequestMapping(value = "**/Ws_Transaksi/ambilNomerTulVI01.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNomerTulVI01( @RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilNomerTulVI01(unitUp);
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

    @RequestMapping(value = "**/Ws_Transaksi/insertTulVI01.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject insertTulVI01( @RequestParam(value = "No_60", defaultValue = "")Integer No_60,
                              @RequestParam(value = "UnitUP", defaultValue = "")String UnitUP,
                              @RequestParam(value = "ThBlRek", defaultValue = "")String ThBlRek,
                              @RequestParam(value = "IdPelanggan", defaultValue = "")String IdPelanggan,
                              @RequestParam(value = "NoKontrak", defaultValue = "")String NoKontrak,
                              @RequestParam(value = "NoKontrol", defaultValue = "")String NoKontrol,
                              @RequestParam(value = "Nama", defaultValue = "")String Nama,
                              @RequestParam(value = "Alamat", defaultValue = "")String Alamat,
                              @RequestParam(value = "ThBlRek_akhir", defaultValue = "")String ThBlRek_akhir,
                              @RequestParam(value = "Lembar_601", defaultValue = "")String Lembar_601,
                              @RequestParam(value = "Tagihan_601", defaultValue = "")String Tagihan_601,
                              @RequestParam(value = "NOtul601", defaultValue = "")String NOtul601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.insertTulVI01(No_60,UnitUP,ThBlRek,IdPelanggan,NoKontrak,NoKontrol,Nama,Alamat,ThBlRek_akhir,Lembar_601,Tagihan_601,NOtul601);
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

      @RequestMapping(value = "**/Ws_Transaksi/AmbilTul601.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul601( @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                            @RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.AmbilTul601(unitUp,sqlKriteria);
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


    //--- Laporan VI-01

    @RequestMapping(value = "**/Ws_Transaksi/ambilDaftarPantauCetak601.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDaftarPantauCetak601( @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                          @RequestParam(value = "awal", defaultValue = "")Date awal,
                                          @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilDaftarPantauCetak601(unitUp,awal,akhir);
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

    //--- Laporan VI-03
    //--- Added by H.Intellisys 27 June 2006

    @RequestMapping(value = "**/Ws_Transaksi/ambilDaftarPantauCetak603.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDaftarPantauCetak603( @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                          @RequestParam(value = "awal", defaultValue = "")Date awal,
                                          @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilDaftarPantauCetak603(unitUp,awal,akhir);
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




    @RequestMapping(value = "**/Ws_Transaksi/ambilRekapPantauCetak601.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilRekapPantauCetak601( @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                          @RequestParam(value = "awal", defaultValue = "")Date awal,
                                          @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilRekapPantauCetak601(unitUp,awal,akhir);
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


    @RequestMapping(value = "**/Ws_Transaksi/ambilRekapPantauCetak603.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilRekapPantauCetak603( @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                          @RequestParam(value = "awal", defaultValue = "")Date awal,
                                          @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilRekapPantauCetak603(unitUp,awal,akhir);
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


    @RequestMapping(value = "**/Ws_Transaksi/ambilDaftar601Lunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDaftar601Lunas( @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                          @RequestParam(value = "awalPk", defaultValue = "")Date awalPk,
                                          @RequestParam(value = "akhirPk", defaultValue = "")Date akhirPk,
                                          @RequestParam(value = "awalLns", defaultValue = "")Date awalLns,
                                          @RequestParam(value = "akhirLns", defaultValue = "")Date akhirLns) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilDaftar601Lunas(unitUp,awalPk,akhirPk,awalLns,akhirLns);
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


    @RequestMapping(value = "**/Ws_Transaksi/ambilDaftar603Lunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDaftar603Lunas( @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                    @RequestParam(value = "awalPk", defaultValue = "")Date awalPk,
                                    @RequestParam(value = "akhirPk", defaultValue = "")Date akhirPk,
                                    @RequestParam(value = "awalLns", defaultValue = "")Date awalLns,
                                    @RequestParam(value = "akhirLns", defaultValue = "")Date akhirLns) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilDaftar603Lunas(unitUp,awalPk,akhirPk,awalLns,akhirLns);
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


    @RequestMapping(value = "**/Ws_Transaksi/ambilRekap601Lunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilRekap601Lunas( @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                    @RequestParam(value = "awalPk", defaultValue = "")Date awalPk,
                                    @RequestParam(value = "akhirPk", defaultValue = "")Date akhirPk,
                                    @RequestParam(value = "awalLns", defaultValue = "")Date awalLns,
                                    @RequestParam(value = "akhirLns", defaultValue = "")Date akhirLns) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilRekap601Lunas(unitUp,awalPk,akhirPk,awalLns,akhirLns);
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



    @RequestMapping(value = "**/Ws_Transaksi/ambilRekap603Lunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilRekap603Lunas( @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                    @RequestParam(value = "awalPk", defaultValue = "")Date awalPk,
                                    @RequestParam(value = "akhirPk", defaultValue = "")Date akhirPk,
                                    @RequestParam(value = "awalLns", defaultValue = "")Date awalLns,
                                    @RequestParam(value = "akhirLns", defaultValue = "")Date akhirLns) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilRekap603Lunas(unitUp,awalPk,akhirPk,awalLns,akhirLns);
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


    @RequestMapping(value = "**/Ws_Transaksi/ambilTulVIperIdPel.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilTulVIperIdPel( @RequestParam(value = "idpel", defaultValue = "")String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilTulVIperIdPel(idpel);
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


    @RequestMapping(value = "**/Ws_Transaksi/ambilTulVI03perIdPel.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilTulVI03perIdPel( @RequestParam(value = "idpel", defaultValue = "")String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilTulVI03perIdPel(idpel);
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


    @RequestMapping(value = "**/Ws_Transaksi/ambil601BelumLunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambil601BelumLunas( @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                         @RequestParam(value = "awal", defaultValue = "")Date awal,
                                         @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambil601BelumLunas(unitUp,awal,akhir);
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


   @RequestMapping(value = "**/Ws_Transaksi/ambil603BelumLunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambil603BelumLunas( @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                         @RequestParam(value = "awal", defaultValue = "")Date awal,
                                         @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambil603BelumLunas(unitUp,awal,akhir);
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



    @RequestMapping(value = "**/Ws_Transaksi/AmbilTul601CetakUlang.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul601CetakUlang( @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                         @RequestParam(value = "tglPk", defaultValue = "")Date tglPk,
                                         @RequestParam(value = "noAwal", defaultValue = "")Integer noAwal,
                                         @RequestParam(value = "noAkhir", defaultValue = "")Integer noAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.AmbilTul601CetakUlang(unitUp,tglPk,noAwal,noAkhir);
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


    @RequestMapping(value = "**/Ws_Transaksi/AmbilTul601Lampiran.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul601Lampiran( @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                         @RequestParam(value = "tglPk", defaultValue = "")Date tglPk,
                                         @RequestParam(value = "noTul", defaultValue = "")Integer noTul) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.AmbilTul601Lampiran(unitUp,tglPk,noTul);
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



    //--- Tul VI-03
    @RequestMapping(value = "**/Ws_Transaksi/ambilNomerTulVI03.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNomerTulVI03( @RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilNomerTulVI03(unitUp);
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


    @RequestMapping(value = "**/Ws_Transaksi/AmbilTul603.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul603( @RequestParam(value = "is60hari", defaultValue = "")Boolean is60hari,
                                         @RequestParam(value = "unitUp", defaultValue = "")String  unitUp,
                                         @RequestParam(value = "sqlKriteria", defaultValue = "")String  sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.AmbilTul603(is60hari,unitUp,sqlKriteria);
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


    @RequestMapping(value = "**/Ws_Transaksi/insertTulVI03.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject insertTulVI03( @RequestParam(value = "No_60", defaultValue = "")Integer No_60,
                              @RequestParam(value = "no_601", defaultValue = "")Integer no_601,
                              @RequestParam(value = "UnitUP", defaultValue = "")String UnitUP,
                              @RequestParam(value = "ThBlRek", defaultValue = "")String ThBlRek,
                              @RequestParam(value = "IdPelanggan", defaultValue = "")String IdPelanggan,
                              @RequestParam(value = "NoKontrak", defaultValue = "")String NoKontrak,
                              @RequestParam(value = "NoKontrol", defaultValue = "")String NoKontrol,
                              @RequestParam(value = "Nama", defaultValue = "")String Nama,
                              @RequestParam(value = "Alamat", defaultValue = "")String Alamat,
                              @RequestParam(value = "ThBlRek_akhir", defaultValue = "")String ThBlRek_akhir,
                              @RequestParam(value = "Lembar_603", defaultValue = "")String Lembar_603,
                              @RequestParam(value = "Tagihan_603", defaultValue = "")String Tagihan_603,
                              @RequestParam(value = "NOtul603", defaultValue = "")String  NOtul603,
                              @RequestParam(value = "NOtul601", defaultValue = "")String  NOtul601,
                              @RequestParam(value = "tglTul601", defaultValue = "")Date   tglTul601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.insertTulVI03(No_60,no_601,UnitUP,ThBlRek,IdPelanggan,NoKontrak,NoKontrol,
                    Nama,Alamat,ThBlRek_akhir,Lembar_603,Tagihan_603,NOtul603,NOtul601,tglTul601);
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


    @RequestMapping(value = "**/Ws_Transaksi/ambilCetakKertasTulVI.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilCetakKertasTulVI() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilCetakKertasTulVI();
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


    //--- Pemutusan Penyambungan
       @RequestMapping(value = "**/Ws_Transaksi/ambilDetailTul601.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDetailTul601( @RequestParam(value = "strtgl", defaultValue = "")String strtgl,
                                         @RequestParam(value = "noTul", defaultValue = "")String  noTul) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilDetailTul601(strtgl,noTul);
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



    //--- Pembongkaran
    //--- Added By H.Intellisys 27 June 2006

    @RequestMapping(value = "**/Ws_Transaksi/ambilDetailTul603.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDetailTul603( @RequestParam(value = "strtgl", defaultValue = "")String strtgl,
                                  @RequestParam(value = "noTul", defaultValue = "")String  noTul) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ambilDetailTul603(strtgl,noTul);
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

        @RequestMapping(value = "**/Ws_Transaksi/simpanPutus.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanPutus( @RequestParam(value = "tglPutus", defaultValue = "")Date  tglPutus,
                                         @RequestParam(value = "namaPutus", defaultValue = "")String  namaPutus,
                                         @RequestParam(value = "lwbp", defaultValue = "")String  lwbp,
                                         @RequestParam(value = "wbp", defaultValue = "")String  wbp,
                                         @RequestParam(value = "kvarh", defaultValue = "")String  kvarh,
                                         @RequestParam(value = "tgl601", defaultValue = "")Date   tgl601,
                                         @RequestParam(value = "no601", defaultValue = "")String  no601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.simpanPutus(tglPutus,namaPutus,lwbp,wbp,kvarh,tgl601,no601);
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

    @RequestMapping(value = "**/Ws_Transaksi/simpanBongkar.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanBongkar( @RequestParam(value = "tglPutus", defaultValue = "")Date  tglPutus,
                            @RequestParam(value = "namaPutus", defaultValue = "")String  namaPutus,
                            @RequestParam(value = "lwbp", defaultValue = "")String  lwbp,
                            @RequestParam(value = "wbp", defaultValue = "")String  wbp,
                            @RequestParam(value = "kvarh", defaultValue = "")String  kvarh,
                            @RequestParam(value = "tgl601", defaultValue = "")Date   tgl601,
                            @RequestParam(value = "no601", defaultValue = "")String  no601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.simpanBongkar(tglPutus,namaPutus,lwbp,wbp,kvarh,tgl601,no601);
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


    @RequestMapping(value = "**/Ws_Transaksi/simpanSambung.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanSambung( @RequestParam(value = "tglsambung", defaultValue = "")Date  tglsambung,
                            @RequestParam(value = "namasambung", defaultValue = "")String  namasambung,
                            @RequestParam(value = "lwbp", defaultValue = "")String  lwbp,
                            @RequestParam(value = "wbp", defaultValue = "")String  wbp,
                            @RequestParam(value = "kvarh", defaultValue = "")String  kvarh,
                            @RequestParam(value = "tgl601", defaultValue = "")Date   tgl601,
                            @RequestParam(value = "no601", defaultValue = "")String  no601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.simpanSambung(tglsambung,namasambung,lwbp,wbp,kvarh,tgl601,no601);
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


    //--- Ambil Cetakan Tul VI-03
      @RequestMapping(value = "**/Ws_Transaksi/AmbilBuatCetakTul603.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilBuatCetakTul603( @RequestParam(value = "txtIdpel", defaultValue = "")String txtIdpel,
                                         @RequestParam(value = "unitUp", defaultValue = "")String  unitUp,
                                         @RequestParam(value = "sqlKriteria", defaultValue = "")String  sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.AmbilBuatCetakTul603(txtIdpel,unitUp,sqlKriteria);
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


     @RequestMapping(value = "**/Ws_Transaksi/AmbilBuatCetakUlangTul603.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilBuatCetakUlangTul603( @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                         @RequestParam(value = "TglPk", defaultValue = "")Date TglPk,
                                         @RequestParam(value = "noTul", defaultValue = "")Integer noTul) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.AmbilBuatCetakUlangTul603(unitUp,TglPk,noTul);
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

    @RequestMapping(value = "**/Ws_Transaksi/cekBKSudahDibuat.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cekBKSudahDibuat() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.cekBKSudahDibuat();
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

    @RequestMapping(value = "**/Ws_Transaksi/login.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject login( @RequestParam(value = "uname", defaultValue = "")String uname) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.login(uname);
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

    @RequestMapping(value = "**/Ws_Transaksi/getMasterUnit.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getMasterUnit( @RequestParam(value = "in_unitpetugas", defaultValue = "")String in_unitpetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.getMasterUnit(in_unitpetugas);
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


    @RequestMapping(value = "**/Ws_Transaksi/ubahPassword.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ubahPassword( @RequestParam(value = "uname", defaultValue = "")String uname,
                                         @RequestParam(value = "pwd", defaultValue = "")String  pwd) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.ubahPassword(uname,pwd);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_R2CICILAN.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_R2CICILAN( @RequestParam(value = "tpel", defaultValue = "")String tpel,
                                         @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                         @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                         @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_R2CICILAN(tpel,vJenis,tBLTH,tPetugas);
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


    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_R2cicilan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_R2cicilan( @RequestParam(value = "tIDPel", defaultValue = "")String tIDPel,
                                         @RequestParam(value = "tBlTh", defaultValue = "")String  tBlTh,
                                         @RequestParam(value = "tStatus", defaultValue = "")String  tStatus,
                                         @RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                         @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                         @RequestParam(value = "tnorek", defaultValue = "")String  tnorek,
                                         @RequestParam(value = "v_NOAGENDA", defaultValue = "")String  v_NOAGENDA,
                                         @RequestParam(value = "v_KALICICIL", defaultValue = "")Integer  v_KALICICIL,
                                         @RequestParam(value = "v_rptag", defaultValue = "")Double  v_rptag,
                                         @RequestParam(value = "v_rpbk", defaultValue = "")Double v_rpbk) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_R2cicilan(tIDPel,tBlTh,tStatus,dtrans,tTransaksiBy,tnorek,v_NOAGENDA,v_KALICICIL,v_rptag,v_rpbk);
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


    //=== KIRIM UNIT ===


    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_23KIRIMUNIT.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_23KIRIMUNIT( @RequestParam(value = "tpel", defaultValue = "")String tpel,
                                                 @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                                 @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                                 @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_23KIRIMUNIT(tpel,vJenis,tBLTH,tPetugas);
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

    //=== KIRIM UNIT KOLEKTIF ===


    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_23KIRIMUNITKolektif.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_23KIRIMUNITKolektif( @RequestParam(value = "kodekolektif", defaultValue = "")String kodekolektif,
                                         @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                         @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                         @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_23KIRIMUNITKolektif(kodekolektif,vJenis,tBLTH,tPetugas);
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

    @RequestMapping(value = "**/Ws_Transaksi/SaveTemp_23KIRIMUNIT.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SaveTemp_23KIRIMUNIT( @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                         @RequestParam(value = "tUnitKirim", defaultValue = "")String tUnitKirim,
                                         @RequestParam(value = "tTglKirim", defaultValue = "")String tTglKirim) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SaveTemp_23KIRIMUNIT(tPetugas,tUnitKirim,tTglKirim);
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

    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_23KIRIMUNIT.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_23KIRIMUNIT( @RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                     @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                     @RequestParam(value = "tKDTERIMA", defaultValue = "")String tKDTERIMA) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_23KIRIMUNIT(dtrans,tTransaksiBy,tKDTERIMA);
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


    @RequestMapping(value = "**/Ws_Transaksi/PemantauanBatalTransaksi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject PemantauanBatalTransaksi( @RequestParam(value = "Transaksi", defaultValue = "")String Transaksi,
                                       @RequestParam(value = "vpilihtglsama", defaultValue = "")String  vpilihtglsama,
                                       @RequestParam(value = "vJenis", defaultValue = "")String  vJenis,
                                       @RequestParam(value = "vPilihTgl", defaultValue = "")String vPilihTgl,
                                       @RequestParam(value = "tUnitKJ", defaultValue = "")String tUnitKJ,
                                       @RequestParam(value = "tUnitUP", defaultValue = "")String  tUnitUP,
                                       @RequestParam(value = "tUnitAP", defaultValue = "")String  tUnitAP,
                                       @RequestParam(value = "tTglmulai", defaultValue = "")String   tTglmulai,
                                       @RequestParam(value = "tTglsampai", defaultValue = "")String   tTglsampai,
                                       @RequestParam(value = "tKdpp", defaultValue = "")String  tKdpp,
                                       @RequestParam(value = "tKdPembayar", defaultValue = "")String  tKdPembayar,
                                       @RequestParam(value = "tKode", defaultValue = "")String  tKode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.PemantauanBatalTransaksi(Transaksi,vpilihtglsama,vJenis,vPilihTgl,tUnitKJ,tUnitUP,
                    tUnitAP,tTglmulai,tTglsampai,tKdpp,tKdPembayar,tKode);
            obj.put("result", retValue.get("wsReturn"));
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    ////=== END KIRIM UNIT ===

    //====TERIMA UNIT====
    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_23TERIMAUNIT.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_23TERIMAUNIT( @RequestParam(value = "tpel", defaultValue = "")String tpel,
                                         @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                         @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                         @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                         @RequestParam(value = "tKdTerima", defaultValue = "")String tKdTerima) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_23TERIMAUNIT(tpel,vJenis,tBLTH,tPetugas,tKdTerima);
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

    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_23TERIMAUNIT.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_23TERIMAUNIT( @RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
                                         @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_23TERIMAUNIT(dtrans,tTransaksiBy);
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

    @RequestMapping(value = "**/Ws_Transaksi/SaveTemp_23TERIMAUNIT.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SaveTemp_23TERIMAUNIT( @RequestParam(value = "dtrans", defaultValue = "")String dtrans,
                                         @RequestParam(value = "tUnitUpDari", defaultValue = "")String tUnitUpDari,
                                         @RequestParam(value = "tUnitUpUntuk", defaultValue = "")String tUnitUpUntuk,
                                         @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SaveTemp_23TERIMAUNIT(dtrans,tUnitUpDari,tUnitUpUntuk,tPetugas);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetVersion.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetVersion() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetVersion();
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


    @RequestMapping(value = "**/Ws_Transaksi/DaftarUpdateVersi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject DaftarUpdateVersi() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.DaftarUpdateVersi();
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

    //====END TERIMA UNIT===

   @RequestMapping(value = "**/Ws_Transaksi/SetImportUJL_File.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetImportUJL_File( @RequestParam(value = "dsPass", defaultValue = "")Map<String, Object> dsPass,
                                      @RequestParam(value = "tUnitUpDari", defaultValue = "")String tUnitUpDari,
                                      @RequestParam(value = "tUnitUpUntuk", defaultValue = "")String tUnitUpUntuk,
                                      @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetImportUJL_File(dsPass);
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

    @RequestMapping(value = "**/Ws_Transaksi/SetImportUJL_Oracle.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetImportUJL_Oracle() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetImportUJL_Oracle();
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


    @RequestMapping(value = "**/Ws_Transaksi/getDataHapusKolektif.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getDataHapusKolektif( @RequestParam(value = "dsFilter", defaultValue = "")Map<String, Object> dsFilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.getDataHapusKolektif(dsFilter);
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

    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_21HapusGagalKolektif.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_21HapusGagalKolektif( @RequestParam(value = "strDatarec", defaultValue = "")String strDatarec,
                                      @RequestParam(value = "strXMLschema", defaultValue = "")String strXMLschema,
                                      @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_21HapusGagalKolektif(strDatarec,strXMLschema,tTransaksiBy);
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


    @RequestMapping(value = "**/Ws_Transaksi/setRekap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject setRekap( @RequestParam(value = "dsFilter", defaultValue = "")Map<String, Object> dsFilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.setRekap(dsFilter);
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

   @RequestMapping(value = "**/Ws_Transaksi/setLap_502_404.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject setLap_502_404( @RequestParam(value = "sUnitup", defaultValue = "")String sUnitup,
                                      @RequestParam(value = "sBlthLap", defaultValue = "")String sBlthLap,
                                      @RequestParam(value = "sKodePetugas", defaultValue = "")String sKodePetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.setLap_502_404(sUnitup,sBlthLap,sKodePetugas);
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

    @RequestMapping(value = "**/Ws_Transaksi/setLap_404.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject setLap_404( @RequestParam(value = "sBlthLap", defaultValue = "")String sBlthLap,
                               @RequestParam(value = "sKodePetugas", defaultValue = "")String sKodePetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.setLap_404(sBlthLap,sKodePetugas);
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

    @RequestMapping(value = "**/Ws_Transaksi/getViewDppNonrek.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getViewDppNonrek( @RequestParam(value = "unitup", defaultValue = "")String unitup,
                                 @RequestParam(value = "sTglMulai", defaultValue = "")String sTglMulai,
                                 @RequestParam(value = "sTglSelesai", defaultValue = "")String sTglSelesai) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.getViewDppNonrek(unitup,sTglMulai,sTglSelesai);
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


    @RequestMapping(value = "**/Ws_Transaksi/getViewDphNonrek.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getViewDphNonrek( @RequestParam(value = "unitup", defaultValue = "")String unitup,
                                     @RequestParam(value = "sTglMulai", defaultValue = "")String sTglMulai,
                                     @RequestParam(value = "sTglSelesai", defaultValue = "")String sTglSelesai) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.getViewDphNonrek(unitup,sTglMulai,sTglSelesai);
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


    @RequestMapping(value = "**/Ws_Transaksi/setDownloadDppNonrek.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject setDownloadDppNonrek( @RequestParam(value = "unitup", defaultValue = "")String unitup,
                               @RequestParam(value = "sTglMulai", defaultValue = "")String sTglMulai,
                               @RequestParam(value = "sTglSelesai", defaultValue = "")String sTglSelesai) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.setDownloadDppNonrek(unitup,sTglMulai,sTglSelesai);
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

    @RequestMapping(value = "**/Ws_Transaksi/SetKdGerak.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetKdGerak( @RequestParam(value = "vKdGerak", defaultValue = "")String vKdGerak) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetKdGerak(vKdGerak);
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

    @RequestMapping(value = "**/Ws_Transaksi/setDownloadDphNonrek.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject setDownloadDphNonrek( @RequestParam(value = "unitup", defaultValue = "")String unitup,
                               @RequestParam(value = "sTglMulai", defaultValue = "")String sTglMulai,
                               @RequestParam(value = "sTglSelesai", defaultValue = "")String sTglSelesai) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.setDownloadDphNonrek(unitup,sTglMulai,sTglSelesai);
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


    @RequestMapping(value = "**/Ws_Transaksi/getview212223Down.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getview212223Down( @RequestParam(value = "TglMulai", defaultValue = "")String TglMulai,
                               @RequestParam(value = "TglSampai", defaultValue = "")String TglSampai,
                               @RequestParam(value = "Unitup", defaultValue = "")String Unitup,
                               @RequestParam(value = "sView", defaultValue = "")String sView) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.getview212223Down(TglMulai,TglSampai,Unitup,sView);
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

   @RequestMapping(value = "**/Ws_Transaksi/GetParamDownload.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetParamDownload( @RequestParam(value = "NmTabel", defaultValue = "")String NmTabel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetParamDownload(NmTabel);
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

    @RequestMapping(value = "**/Ws_Transaksi/GetDowndLunasBlmLunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDowndLunasBlmLunas( @RequestParam(value = "TglMulai", defaultValue = "")String TglMulai,
                               @RequestParam(value = "TglSampai", defaultValue = "")String TglSampai,
                               @RequestParam(value = "Unitup", defaultValue = "")String Unitup,
                               @RequestParam(value = "Command", defaultValue = "")String Command,
                               @RequestParam(value = "thblrep", defaultValue = "")String thblrep,
                               @RequestParam(value = "kdkirim", defaultValue = "")String kdkirim) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDowndLunasBlmLunas(TglMulai,TglSampai,Unitup,Command,thblrep,kdkirim);
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

    @RequestMapping(value = "**/Ws_Transaksi/GetBKxml.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetBKxml( @RequestParam(value = "vIDpel", defaultValue = "")String vIDpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetBKxml(vIDpel);
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

    @RequestMapping(value = "**/Ws_Transaksi/GetTunggakan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetTunggakan( @RequestParam(value = "vIDpel", defaultValue = "")String vIDpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetTunggakan(vIDpel);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetInfoPlgXML.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetInfoPlgXML( @RequestParam(value = "vIDpel", defaultValue = "")String vIDpel,
                               @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetInfoPlgXML(vIDpel,tBLTH);
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


    @RequestMapping(value = "**/Ws_Transaksi/setKirimDBPTemp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject setKirimDBPTemp( @RequestParam(value = "sUnitup", defaultValue = "")String sUnitup,
                               @RequestParam(value = "sIdpel", defaultValue = "")String sIdpel,
                               @RequestParam(value = "sStatuskirim", defaultValue = "")String sStatuskirim) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.setKirimDBPTemp(sUnitup,sIdpel,sStatuskirim);
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

    @RequestMapping(value = "**/Ws_Transaksi/getTerimaDBPResp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getTerimaDBPResp( @RequestParam(value = "sIdpel", defaultValue = "")String sIdpel,
                               @RequestParam(value = "sunitup", defaultValue = "")String sunitup,
                               @RequestParam(value = "sStatus_terima", defaultValue = "")String sStatus_terima) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.getTerimaDBPResp(sIdpel,sunitup,sStatus_terima);
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


    @RequestMapping(value = "**/Ws_Transaksi/SetSorektoDJBB.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetSorektoDJBB( @RequestParam(value = "unitap", defaultValue = "")String unitap,
                                 @RequestParam(value = "thbl", defaultValue = "")String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetSorektoDJBB(unitap,thbl);
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


    @RequestMapping(value = "**/Ws_Transaksi/SetSorektoDJBB_UP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetSorektoDJBB_UP( @RequestParam(value = "unitup", defaultValue = "")String unitup,
                               @RequestParam(value = "thbl", defaultValue = "")String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetSorektoDJBB_UP(unitup,thbl);
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


    @RequestMapping(value = "**/Ws_Transaksi/getMonitoringStatusPending.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getMonitoringStatusPending( @RequestParam(value = "unitup", defaultValue = "")String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.getMonitoringStatusPending(unitup);
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


    @RequestMapping(value = "**/Ws_Transaksi/getMonitoringUploadSorek.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getMonitoringUploadSorek( @RequestParam(value = "unit", defaultValue = "")String unit,
                               @RequestParam(value = "blth", defaultValue = "")String blth,
                               @RequestParam(value = "satuan", defaultValue = "")String satuan) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.getMonitoringUploadSorek(unit,blth,satuan);
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



    @RequestMapping(value = "**/Ws_Transaksi/SetBatalStatusPending.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetBatalStatusPending( @RequestParam(value = "lbrproses", defaultValue = "")Integer  lbrproses,
                                         @RequestParam(value = "tKirim", defaultValue = "")String tKirim,
                                         @RequestParam(value = "strData", defaultValue = "")String strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetBatalStatusPending(lbrproses,tKirim,strData);
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

    @RequestMapping(value = "**/Ws_Transaksi/getunitap_user.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getunitap_user( @RequestParam(value = "unitup", defaultValue = "")String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.getunitap_user(unitup);
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


    //" Region ====== Form Nota (23) ============ "


    @RequestMapping(value = "**/Ws_Transaksi/GetDataKolektifNotaBukuUserid.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataKolektifNotaBukuUserid( @RequestParam(value = "userId", defaultValue = "")String userId) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataKolektifNotaBukuUserid(userId);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetDataIdPelNotaBukuBatal.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataIdPelNotaBukuBatal( @RequestParam(value = "tkodekolektif", defaultValue = "")String tkodekolektif,
                                         @RequestParam(value = "tuserid", defaultValue = "")String tuserid) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataIdPelNotaBukuBatal(tkodekolektif,tuserid);
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

    @RequestMapping(value = "**/Ws_Transaksi/Batal_23NotaKolektif.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject Batal_23NotaKolektif( @RequestParam(value = "_idpel", defaultValue = "")String _idpel,
                                         @RequestParam(value = "_blth", defaultValue = "")String _blth,
                                         @RequestParam(value = "_transaksiid", defaultValue = "")String _transaksiid,
                                         @RequestParam(value = "_transaksiby", defaultValue = "")String _transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.Batal_23NotaKolektif(_idpel,_blth,_transaksiid,_transaksiby);
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
    //End Region


    @RequestMapping(value = "**/Ws_Transaksi/INSERTTEMPSOREK_ORATOORATEST.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject INSERTTEMPSOREK_ORATOORATEST( @RequestParam(value = "unitup", defaultValue = "")String unitup,
                                         @RequestParam(value = "thbl", defaultValue = "")String thbl,
                                         @RequestParam(value = "KDKELOMPOK", defaultValue = "")String KDKELOMPOK,
                                         @RequestParam(value = "strglobalkodepetugas", defaultValue = "")String strglobalkodepetugas,
                                         @RequestParam(value = "tgljatuhtempo", defaultValue = "")String tgljatuhtempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.INSERTTEMPSOREK_ORATOORATEST(unitup,thbl,KDKELOMPOK,strglobalkodepetugas,tgljatuhtempo);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetViewIdPel_21entriRestitusi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewIdPel_21entriRestitusi( @RequestParam(value = "tpel", defaultValue = "")String tpel,
                                         @RequestParam(value = "vJenis", defaultValue = "")String vJenis) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetViewIdPel_21entriRestitusi(tpel,vJenis);
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
    @RequestMapping(value = "**/Ws_Transaksi/SetDataIdpel_21entriRestitusi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SetDataIdpel_21entriRestitusi( @RequestParam(value = "lbrproses", defaultValue = "")Integer lbrproses,
                                             @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
                                             @RequestParam(value = "tTglBayar", defaultValue = "")String tTglBayar,
                                             @RequestParam(value = "tKDPEMBAYAR", defaultValue = "")String tKDPEMBAYAR,
                                             @RequestParam(value = "strData", defaultValue = "")String strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SetDataIdpel_21entriRestitusi(lbrproses,tTransaksiBy,tTglBayar,tKDPEMBAYAR,strData);
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

    @RequestMapping(value = "**/Ws_Transaksi/getTingkatSatker.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getTingkatSatker( ) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.getTingkatSatker();
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

    @RequestMapping(value = "**/Ws_Transaksi/GetKotama.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetKotama( @RequestParam(value = "vUnitap", defaultValue = "")String vUnitap) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetKotama(vUnitap);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetSatker.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetSatker( @RequestParam(value = "vUnitap", defaultValue = "")String vUnitap,
                                             @RequestParam(value = "vIDKotama", defaultValue = "")String vIDKotama) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetSatker(vUnitap,vIDKotama);
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


      @RequestMapping(value = "**/Ws_Transaksi/GetdataSatker.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetdataSatker( @RequestParam(value = "vIDSatker", defaultValue = "")String vIDSatker) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetdataSatker(vIDSatker);
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

    @RequestMapping(value = "**/Ws_Transaksi/GetdataKotama.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetdataKotama( @RequestParam(value = "vIDKotama", defaultValue = "")String vIDKotama) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetdataKotama(vIDKotama);
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



    @RequestMapping(value = "**/Ws_Transaksi/InsertKotama.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject InsertKotama( @RequestParam(value = "vIDSatker", defaultValue = "")String vIDSatker,
                                             @RequestParam(value = "vUnitap", defaultValue = "")String vUnitap,
                                             @RequestParam(value = "vSetuju1Nama", defaultValue = "")String vSetuju1Nama,
                                             @RequestParam(value = "vSetuju1Kesatuan", defaultValue = "")String vSetuju1Kesatuan,
                                             @RequestParam(value = "vSetuju1Jabatan", defaultValue = "")String vSetuju1Jabatan,
                                             @RequestParam(value = "vSetuju1Pangkat", defaultValue = "")String vSetuju1Pangkat,
                                             @RequestParam(value = "vSetuju1NIP", defaultValue = "")String vSetuju1NIP,
                                             @RequestParam(value = "vSetuju2Nama", defaultValue = "")String vSetuju2Nama,
                                             @RequestParam(value = "vSetuju2Jabatan", defaultValue = "")String vSetuju2Jabatan,
                                             @RequestParam(value = "vSetuju2Unit", defaultValue = "")String vSetuju2Unit,
                                             @RequestParam(value = "vSetuju2Kota", defaultValue = "")String vSetuju2Kota,
                                             @RequestParam(value = "vNamaKotama", defaultValue = "")String vNamaKotama,
                                             @RequestParam(value = "vSETUJU3NAMA", defaultValue = "")String vSETUJU3NAMA,
                                             @RequestParam(value = "vSETUJU3KESATUAN", defaultValue = "")String vSETUJU3KESATUAN,
                                             @RequestParam(value = "vSETUJU3JABATAN", defaultValue = "")String vSETUJU3JABATAN,
                                             @RequestParam(value = "vSETUJU3PANGKAT", defaultValue = "")String vSETUJU3PANGKAT,
                                             @RequestParam(value = "vSETUJU3NIP", defaultValue = "")String vSETUJU3NIP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.InsertKotama(vIDSatker,vUnitap,vSetuju1Nama,vSetuju1Kesatuan,vSetuju1Jabatan,vSetuju1Pangkat,vSetuju1NIP,
                    vSetuju2Nama,vSetuju2Jabatan,vSetuju2Unit,vSetuju2Kota,vNamaKotama,vSETUJU3NAMA,vSETUJU3KESATUAN,vSETUJU3JABATAN,vSETUJU3PANGKAT,vSETUJU3NIP );
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


    @RequestMapping(value = "**/Ws_Transaksi/UpdateKotama.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject UpdateKotama( @RequestParam(value = "vIDSatker", defaultValue = "")String vIDSatker,
                             @RequestParam(value = "vUnitap", defaultValue = "")String vUnitap,
                             @RequestParam(value = "vSetuju1Nama", defaultValue = "")String vSetuju1Nama,
                             @RequestParam(value = "vSetuju1Kesatuan", defaultValue = "")String vSetuju1Kesatuan,
                             @RequestParam(value = "vSetuju1Jabatan", defaultValue = "")String vSetuju1Jabatan,
                             @RequestParam(value = "vSetuju1Pangkat", defaultValue = "")String vSetuju1Pangkat,
                             @RequestParam(value = "vSetuju1NIP", defaultValue = "")String vSetuju1NIP,
                             @RequestParam(value = "vSetuju2Nama", defaultValue = "")String vSetuju2Nama,
                             @RequestParam(value = "vSetuju2Jabatan", defaultValue = "")String vSetuju2Jabatan,
                             @RequestParam(value = "vSetuju2Unit", defaultValue = "")String vSetuju2Unit,
                             @RequestParam(value = "vSetuju2Kota", defaultValue = "")String vSetuju2Kota,
                             @RequestParam(value = "vIdKotama", defaultValue = "")String vIdKotama,
                             @RequestParam(value = "vNamaKotama", defaultValue = "")String vNamaKotama,
                             @RequestParam(value = "vSETUJU3NAMA", defaultValue = "")String vSETUJU3NAMA,
                             @RequestParam(value = "vSETUJU3KESATUAN", defaultValue = "")String vSETUJU3KESATUAN,
                             @RequestParam(value = "vSETUJU3JABATAN", defaultValue = "")String vSETUJU3JABATAN,
                             @RequestParam(value = "vSETUJU3PANGKAT", defaultValue = "")String vSETUJU3PANGKAT,
                             @RequestParam(value = "vSETUJU3NIP", defaultValue = "")String vSETUJU3NIP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.UpdateKotama(vIDSatker,vUnitap,vSetuju1Nama,vSetuju1Kesatuan,vSetuju1Jabatan,vSetuju1Pangkat,vSetuju1NIP,
                    vSetuju2Nama,vSetuju2Jabatan,vSetuju2Unit,vSetuju2Kota,vIdKotama,vNamaKotama,vSETUJU3NAMA,vSETUJU3KESATUAN,vSETUJU3JABATAN,vSETUJU3PANGKAT,vSETUJU3NIP );
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



    @RequestMapping(value = "**/Ws_Transaksi/InsertSatker.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject InsertSatker( @RequestParam(value = "vIDSatker", defaultValue = "")String vIDSatker,
                             @RequestParam(value = "vNoSurat", defaultValue = "")String vNoSurat,
                             @RequestParam(value = "vNoForm", defaultValue = "")String vNoForm,
                             @RequestParam(value = "vUnitap", defaultValue = "")String vUnitap,
                             @RequestParam(value = "vIDKotama", defaultValue = "")String vIDKotama,
                             @RequestParam(value = "vKesatuan", defaultValue = "")String vKesatuan,
                             @RequestParam(value = "vKodeSatker", defaultValue = "")String vKodeSatker,
                             @RequestParam(value = "vAlamat", defaultValue = "")String vAlamat,
                             @RequestParam(value = "vSetuju1Nama", defaultValue = "")String vSetuju1Nama,
                             @RequestParam(value = "vSetuju1Kesatuan", defaultValue = "")String vSetuju1Kesatuan,
                             @RequestParam(value = "vSetuju1Jabatan", defaultValue = "")String vSetuju1Jabatan,
                             @RequestParam(value = "vSetuju1Pangkat", defaultValue = "")String vSetuju1Pangkat,
                             @RequestParam(value = "vSetuju1NIP", defaultValue = "")String vSetuju1NIP,
                             @RequestParam(value = "vSetuju2Nama", defaultValue = "")String vSetuju2Nama,
                             @RequestParam(value = "vSetuju2Kesatuan", defaultValue = "")String vSetuju2Kesatuan,
                             @RequestParam(value = "vSetuju2Jabatan", defaultValue = "")String vSetuju2Jabatan,
                             @RequestParam(value = "vSetuju2Pangkat", defaultValue = "")String vSetuju2Pangkat,
                             @RequestParam(value = "vSetuju2NIP", defaultValue = "")String vSetuju2NIP,
                             @RequestParam(value = "vSetuju3Nama", defaultValue = "")String vSetuju3Nama,
                             @RequestParam(value = "vSetuju3Jabatan", defaultValue = "")String vSetuju3Jabatan,
                             @RequestParam(value = "vSetuju3Unit", defaultValue = "")String vSetuju3Unit,
                             @RequestParam(value = "vSetuju3Kota", defaultValue = "")String vSetuju3Kota) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.InsertSatker(vIDSatker,vNoSurat,vNoForm,vUnitap,vIDKotama,vKesatuan,vKodeSatker,vAlamat,vSetuju1Nama,vSetuju1Kesatuan,vSetuju1Jabatan,vSetuju1Pangkat,vSetuju1NIP,
                    vSetuju2Nama,vSetuju2Kesatuan,vSetuju2Jabatan,vSetuju2Pangkat,vSetuju2NIP,vSetuju3Nama,vSetuju3Jabatan,vSetuju3Unit,vSetuju3Kota );
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




    @RequestMapping(value = "**/Ws_Transaksi/UpdateSatker.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject UpdateSatker( @RequestParam(value = "vNoSurat", defaultValue = "")String vNoSurat,
                             @RequestParam(value = "vNoForm", defaultValue = "")String vNoForm,
                             @RequestParam(value = "vIDKotama", defaultValue = "")String vIDKotama,
                             @RequestParam(value = "vKesatuan", defaultValue = "")String vKesatuan,
                             @RequestParam(value = "vKodeSatker", defaultValue = "")String vKodeSatker,
                             @RequestParam(value = "vAlamat", defaultValue = "")String vAlamat,
                             @RequestParam(value = "vSetuju1Nama", defaultValue = "")String vSetuju1Nama,
                             @RequestParam(value = "vSetuju1Kesatuan", defaultValue = "")String vSetuju1Kesatuan,
                             @RequestParam(value = "vSetuju1Jabatan", defaultValue = "")String vSetuju1Jabatan,
                             @RequestParam(value = "vSetuju1Pangkat", defaultValue = "")String vSetuju1Pangkat,
                             @RequestParam(value = "vSetuju1NIP", defaultValue = "")String vSetuju1NIP,
                             @RequestParam(value = "vSetuju2Nama", defaultValue = "")String vSetuju2Nama,
                             @RequestParam(value = "vSetuju2Kesatuan", defaultValue = "")String vSetuju2Kesatuan,
                             @RequestParam(value = "vSetuju2Jabatan", defaultValue = "")String vSetuju2Jabatan,
                             @RequestParam(value = "vSetuju2Pangkat", defaultValue = "")String vSetuju2Pangkat,
                             @RequestParam(value = "vSetuju2NIP", defaultValue = "")String vSetuju2NIP,
                             @RequestParam(value = "vSetuju3Nama", defaultValue = "")String vSetuju3Nama,
                             @RequestParam(value = "vSetuju3Jabatan", defaultValue = "")String vSetuju3Jabatan,
                             @RequestParam(value = "vSetuju3Unit", defaultValue = "")String vSetuju3Unit,
                             @RequestParam(value = "vSetuju3Kota", defaultValue = "")String vSetuju3Kota) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.UpdateSatker(vNoSurat,vNoForm,vIDKotama,vKesatuan,vKodeSatker,vAlamat,vSetuju1Nama,vSetuju1Kesatuan,vSetuju1Jabatan,vSetuju1Pangkat,vSetuju1NIP,
                    vSetuju2Nama,vSetuju2Kesatuan,vSetuju2Jabatan,vSetuju2Pangkat,vSetuju2NIP,vSetuju3Nama,vSetuju3Jabatan,vSetuju3Unit,vSetuju3Kota );
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


    @RequestMapping(value = "**/Ws_Transaksi/GetNoForm.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetNoForm(    @RequestParam(value = "vUnitap", defaultValue = "")String vUnitap) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetNoForm(vUnitap);
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



    @RequestMapping(value = "**/Ws_Transaksi/getAnggotaSatket.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getAnggotaSatket(    @RequestParam(value = "vNoForm", defaultValue = "")String vNoForm) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.getAnggotaSatket(vNoForm);
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


    @RequestMapping(value = "**/Ws_Transaksi/getDataPelanggan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getDataPelanggan(    @RequestParam(value = "vIdpel", defaultValue = "")String vIdpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.getDataPelanggan(vIdpel);
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


    @RequestMapping(value = "**/Ws_Transaksi/HapusAnggotaSatker.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject HapusAnggotaSatker(    @RequestParam(value = "vNoForm", defaultValue = "")String vNoForm,
                             @RequestParam(value = "vIDPel", defaultValue = "")String vIDPel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.HapusAnggotaSatker(vNoForm,vIDPel);
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


    @RequestMapping(value = "**/Ws_Transaksi/TambahAnggotaSatker.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject TambahAnggotaSatker(    @RequestParam(value = "vUnitap", defaultValue = "")String vUnitap,
                             @RequestParam(value = "vIDPel", defaultValue = "")String vIDPel,
                             @RequestParam(value = "vNoForm", defaultValue = "")String vNoForm) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.TambahAnggotaSatker(vUnitap,vIDPel,vNoForm);
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



    @RequestMapping(value = "**/Ws_Transaksi/cekSatker.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cekSatker(    @RequestParam(value = "vNoForm", defaultValue = "")String vNoForm,
                             @RequestParam(value = "vBlth", defaultValue = "")String vBlth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.cekSatker(vNoForm,vBlth);
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


    @RequestMapping(value = "**/Ws_Transaksi/SahSatker.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject SahSatker(    @RequestParam(value = "vNoForm", defaultValue = "")String vNoForm,
                             @RequestParam(value = "vBlth", defaultValue = "")String vBlth,
                             @RequestParam(value = "SahBy", defaultValue = "")String SahBy) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.SahSatker(vNoForm,vBlth,SahBy);
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


    @RequestMapping(value = "**/Ws_Transaksi/GetDataKoreksiBongkar.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetDataKoreksiBongkar( @RequestParam(value = "vIdpel", defaultValue = "")String vIdpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetDataKoreksiBongkar(vIdpel);
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



    @RequestMapping(value = "**/Ws_Transaksi/InsertLogGagalDKRPBongkar.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject InsertLogGagalDKRPBongkar( @RequestParam(value = "in_unitup", defaultValue = "")String in_unitup,
                                          @RequestParam(value = "in_idpel", defaultValue = "")String in_idpel,
                                          @RequestParam(value = "in_blth", defaultValue = "")String in_blth,
                                          @RequestParam(value = "in_lwbp_bongkar", defaultValue = "")String in_lwbp_bongkar,
                                          @RequestParam(value = "in_wbp_bongkar", defaultValue = "")String in_wbp_bongkar,
                                          @RequestParam(value = "in_kvarh_bongkar", defaultValue = "")String in_kvarh_bongkar,
                                          @RequestParam(value = "in_notul603", defaultValue = "")String in_notul603,
                                          @RequestParam(value = "in_tgltul603", defaultValue = "")String in_tgltul603,
                                          @RequestParam(value = "in_petugas", defaultValue = "")String in_petugas,
                                          @RequestParam(value = "in_no60", defaultValue = "")String in_no60,
                                          @RequestParam(value = "in_Log_Id", defaultValue = "")String in_Log_Id,
                                          @RequestParam(value = "ErrMsg", defaultValue = "")String ErrMsg) {
                Map<String, Object> retValue = new HashMap<String, Object>();
                JSONObject obj = new JSONObject();
                StringWriter out = new StringWriter();

                String retVal = "Init";
                try {
                    retValue=  ws_transaksiDao.InsertLogGagalDKRPBongkar(in_unitup,in_idpel,in_blth,in_lwbp_bongkar,in_wbp_bongkar,in_kvarh_bongkar,
                                                                           in_notul603,in_tgltul603,in_petugas,in_no60,in_Log_Id, ErrMsg );
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




    @RequestMapping(value = "**/Ws_Transaksi/GetLogDKRPBongkar.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetLogDKRPBongkar( @RequestParam(value = "_strtgl", defaultValue = "")String _strtgl,
                             @RequestParam(value = "_noTulAwal", defaultValue = "")String _noTulAwal,
                             @RequestParam(value = "_noTulAkhir", defaultValue = "")String _noTulAkhir,
                             @RequestParam(value = "_unitup", defaultValue = "")String _unitup,
                             @RequestParam(value = "_LogID", defaultValue = "")String _LogID) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.GetLogDKRPBongkar(_strtgl,_noTulAwal,_noTulAkhir,_unitup,_LogID);
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




    @RequestMapping(value = "**/Ws_Transaksi/Create_LogId.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject Create_LogId( @RequestParam(value = "in_unitup", defaultValue = "")String in_unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_transaksiDao.Create_LogId(in_unitup);
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
