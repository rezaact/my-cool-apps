package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.ws_ReportBADao;
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
public class Ws_ReportBAController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_ReportBAController.class);

    @Autowired
    ws_ReportBADao ws_reportBADao;

    @RequestMapping(value = "**/Ws_ReportBA/ambilUnitPetugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilUnitPetugas(@RequestParam(value = "petugas", defaultValue = "")String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportBADao.ambilUnitPetugas(petugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportBA/rptVIEW_BA21_Upload.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject rptVIEW_BA21_Upload(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                                   @RequestParam(value = "tgltransaksi", defaultValue = "")String tgltransaksi,
                                   @RequestParam(value = "tglbayar", defaultValue = "")String tglbayar,
                                   @RequestParam(value = "kdpp", defaultValue = "")String kdpp,
                                   @RequestParam(value = "transaksiby", defaultValue = "")String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportBADao.rptVIEW_BA21_Upload(unitup,tgltransaksi,tglbayar,kdpp,transaksiby);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportBA/rptVIEW_BA21_Entri.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject rptVIEW_BA21_Entri(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                                  @RequestParam(value = "tgltransaksi", defaultValue = "")String tgltransaksi,
                                  @RequestParam(value = "tglbayar", defaultValue = "")String tglbayar,
                                  @RequestParam(value = "kdpp", defaultValue = "")String kdpp,
                                  @RequestParam(value = "transaksiby", defaultValue = "")String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportBADao.rptVIEW_BA21_Entri(unitup,tgltransaksi,tglbayar,kdpp,transaksiby);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportBA/rptVIEW_BA21Daftar_Entri.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject rptVIEW_BA21Daftar_Entri(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                                @RequestParam(value = "tgltransaksi", defaultValue = "")String tgltransaksi,
                                @RequestParam(value = "tglbayar", defaultValue = "")String tglbayar,
                                @RequestParam(value = "kdpp", defaultValue = "")String kdpp,
                                @RequestParam(value = "transaksiby", defaultValue = "")String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportBADao.rptVIEW_BA21Daftar_Entri(unitup,tgltransaksi,tglbayar,kdpp,transaksiby);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportBA/rptVIEW_BADENDA.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject rptVIEW_BADENDA(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                                @RequestParam(value = "tgltransaksi", defaultValue = "")String tgltransaksi,
                                @RequestParam(value = "transaksiby", defaultValue = "")String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportBADao.rptVIEW_BADENDA(unitup,tgltransaksi,transaksiby);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportBA/rptVIEW_BA11.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject rptVIEW_BA11(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                @RequestParam(value = "siklis", defaultValue = "")String siklis,
                                @RequestParam(value = "blth", defaultValue = "")String blth,
                                @RequestParam(value = "tempo", defaultValue = "")Date tempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportBADao.rptVIEW_BA11(unitUp,siklis,blth,tempo);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    // ----tambahan sumbar sorek oratoora
    @RequestMapping(value = "**/Ws_ReportBA/rptVIEW_BA13upload.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject rptVIEW_BA13upload(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                @RequestParam(value = "siklis", defaultValue = "")String siklis,
                                @RequestParam(value = "blth", defaultValue = "")String blth,
                                @RequestParam(value = "tempo", defaultValue = "")Date tempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportBADao.rptVIEW_BA13upload(unitUp,siklis,blth,tempo);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }
    // ----end tambahan sumbar sorek oratoora

    // TAMBAHAN CICILAN REKENING
    @RequestMapping(value = "**/Ws_ReportBA/rpt_BA_CicilanRek.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject rpt_BA_CicilanRek(@RequestParam(value = "petugas", defaultValue = "")String petugas,
                                @RequestParam(value = "idpel", defaultValue = "")String idpel,
                                @RequestParam(value = "blth", defaultValue = "")String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportBADao.rpt_BA_CicilanRek(petugas,idpel,blth);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    // END TAMBAHAN CICILAN REKENING

    //======BA KIRIM UNIT--
    @RequestMapping(value = "**/Ws_ReportBA/rpt_BA_23KirimUnit.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject rpt_BA_23KirimUnit(@RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                @RequestParam(value = "tUnitKirim", defaultValue = "")String tUnitKirim,
                                @RequestParam(value = "tTglKirim", defaultValue = "")String tTglKirim) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportBADao.rpt_BA_23KirimUnit(tPetugas,tUnitKirim,tTglKirim);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //======END BA KIRIM UNIT

    //=== BA TERIMA UNIT ===
    @RequestMapping(value = "**/Ws_ReportBA/rpt_BA_23TerimaUnit.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject rpt_BA_23TerimaUnit(@RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                @RequestParam(value = "tUnitKirim", defaultValue = "")String tUnitKirim,
                                @RequestParam(value = "tTglKirim", defaultValue = "")String tTglKirim) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportBADao.rpt_BA_23TerimaUnit(tPetugas,tUnitKirim,tTglKirim);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }
    //=== END BA TERIMA UNIT

    //BA Koreksi Rekening
    @RequestMapping(value = "**/Ws_ReportBA/rpt_BA_12KoreksiRekening.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject rpt_BA_12KoreksiRekening(@RequestParam(value = "tIDPEL", defaultValue = "")String tIDPEL,
                                @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportBADao.rpt_BA_12KoreksiRekening(tIDPEL,tBLTH);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportBA/rpt_BA23Pusat_Daftar.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject rpt_BA23Pusat_Daftar(@RequestParam(value = "tglBayar", defaultValue = "")String tglBayar,
                                @RequestParam(value = "petugas", defaultValue = "")String petugas,
                                @RequestParam(value = "kode", defaultValue = "")String kode,
                                @RequestParam(value = "kdkirim", defaultValue = "")String kdkirim) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportBADao.rpt_BA23Pusat_Daftar(tglBayar,petugas,kode,kdkirim);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //Kuitansi Resup
    @RequestMapping(value = "**/Ws_ReportBA/rpt_Kuitansi_RESUP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject rpt_Kuitansi_RESUP(@RequestParam(value = "tIDPEL", defaultValue = "")String tIDPEL) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportBADao.rpt_Kuitansi_RESUP(tIDPEL);
            obj.put("result", retValue);
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
