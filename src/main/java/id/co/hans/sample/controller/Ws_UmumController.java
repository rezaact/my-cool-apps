package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.clsDPP;
import id.co.hans.sample.server.dao.clsPelunasan;
import id.co.hans.sample.server.dao.ws_UmumDao;
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
public class Ws_UmumController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_UmumController.class);

    @Autowired
    private ws_UmumDao ws_umumDao;


    @RequestMapping(value = "**/Ws_Umum/ambilTanggalHariIni.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilTanggalHariIni() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilTanggalHariIni();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    // To do,, query ne ga jelas,,,,
    @RequestMapping(value = "**/Ws_Umum/cariUraian.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cariUraian(@RequestParam(value = "jthtempo", defaultValue = "")Date jthtempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.cariUraian(jthtempo);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    //query geje cariUraianAsli
    @RequestMapping(value = "**/Ws_Umum/cariUraianAsli.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cariUraianAsli(@RequestParam(value = "jthtempo", defaultValue = "")Date jthtempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.cariUraianAsli(jthtempo);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/cariNoKont_dari_Nopel.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cariNoKont_dari_Nopel(@RequestParam(value = "nopel", defaultValue = "")String nopel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.cariNoKont_dari_Nopel(nopel);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //query geje CariTerbilang
    @RequestMapping(value = "**/Ws_Umum/cariTerbilang.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cariTerbilang(@RequestParam(value = "numerik", defaultValue = "")Double numerik) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.CariTerbilang(numerik);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //query geje CariTerbilang
    @RequestMapping(value = "**/Ws_Umum/uraianKeTahunBulan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject uraianKeTahunBulan(@RequestParam(value = "Uraianinput", defaultValue = "")String Uraianinput) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.UraianKeTahunBulan(Uraianinput);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/cariIDPELdariKONTRAK.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cariIDPELdariKONTRAK(@RequestParam(value = "kont", defaultValue = "")String kont) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.CariIDPELdariKONTRAK(kont);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

     @RequestMapping(value = "**/Ws_Umum/cariIDPELdariKONTROL.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cariIDPELdariKONTROL(@RequestParam(value = "kont", defaultValue = "")String kont) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.CariIDPELdariKONTROL(kont);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Umum/ambilDILPelanggan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDILPelanggan(@RequestParam(value = "idpel", defaultValue = "")String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.AmbilDILPelanggan(idpel);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Umum/lihatNAMAPPdariKODEPP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject lihatNAMAPPdariKODEPP(@RequestParam(value = "kodepp", defaultValue = "")String kodepp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.lihatNAMAPPdariKODEPP(kodepp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //query geje RubahTanggal
    @RequestMapping(value = "**/Ws_Umum/rubahTanggal.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject rubahTanggal(@RequestParam(value = "picker", defaultValue = "")Date picker) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.RubahTanggal(picker);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    //query geje createNoAgenda
    @RequestMapping(value = "**/Ws_Umum/createNoAgenda.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject createNoAgenda(@RequestParam(value = "ikdupnumerik", defaultValue = "")String ikdupnumerik) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.createNoAgenda(ikdupnumerik);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/cariJatuhTempo.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cariJatuhTempo(@RequestParam(value = "tgl", defaultValue = "")Date tgl,
                              @RequestParam(value = "kdupnumerik", defaultValue = "")String ikdupnumerik) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.cariJatuhTempo(tgl, ikdupnumerik);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/cariJatuhTempoSiklis.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cariJatuhTempoSiklis(@RequestParam(value = "idpel", defaultValue = "")String idpel,
                              @RequestParam(value = "tgl", defaultValue = "")Date tgl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.cariJatuhTempoSiklis(idpel, tgl);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/ambilUNITUPdariIDPEL.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilUNITUPdariIDPEL(@RequestParam(value = "idpel", defaultValue = "")String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilUNITUPdariIDPEL(idpel);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

     @RequestMapping(value = "**/Ws_Umum/ambilKODESIKLISdariIDPEL.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilKODESIKLISdariIDPEL(@RequestParam(value = "idpel", defaultValue = "")String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilKODESIKLISdariIDPEL(idpel);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Umum/AmbilKodePP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilKodePP() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.AmbilKodePP();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/ambilBulanMinusSatu.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilBulanMinusSatu(@RequestParam(value = "thbl", defaultValue = "")String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilBulanMinusSatu(thbl);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Umum/ambilBulanTambahSatu.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilBulanTambahSatu(@RequestParam(value = "thbl", defaultValue = "")String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilBulanTambahSatu(thbl);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/cariJatuhTempoDariBulan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cariJatuhTempoDariBulan(@RequestParam(value = "thbl", defaultValue = "")String thbl,
                                       @RequestParam(value = "kdupnumerik", defaultValue = "")String kdupnumerik) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.cariJatuhTempoDariBulan(thbl, kdupnumerik);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/ambilDataSetRANTINGRAYONsemua.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDataSetRANTINGRAYONsemua() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilDataSetRANTINGRAYONsemua();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

   @RequestMapping(value = "**/Ws_Umum/ambilDataSetRANTINGRAYONunitdefault.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDataSetRANTINGRAYONunitdefault() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilDataSetRANTINGRAYONunitdefault();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //==================== PARAMETERE Rak ono =================================
    @RequestMapping(value = "**/Ws_Umum/ambilKODEUNITdefault.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilKODEUNITdefault() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilKODEUNITdefault();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/ambilKODECABANGdefault.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilKODECABANGdefault() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilKODECABANGdefault();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/ambilKODEWILAYAHdefault.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilKODEWILAYAHdefault() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilKODEWILAYAHdefault();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }
    //====================================END Paramatere =====================

    //================== Parameter Report  ==============================

     @RequestMapping(value = "**/Ws_Umum/ambilNAMAUNITdefault.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNAMAUNITdefault() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilNAMAUNITdefault();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/ambilNAMACABANGdefault.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNAMACABANGdefault() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilNAMACABANGdefault();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

     @RequestMapping(value = "**/Ws_Umum/ambilNAMAWILAYAHdefault.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNAMAWILAYAHdefault() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilNAMAWILAYAHdefault();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

     @RequestMapping(value = "**/Ws_Umum/ambilALAMATdefault.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilALAMATdefault() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilALAMATdefault();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }
    //===================== End Report  ================================

    //querryy Geje
    @RequestMapping(value = "**/Ws_Umum/ambilTanggalDariTHBL.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilTanggalDariTHBL(@RequestParam(value = "thbl", defaultValue = "")String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilTanggalDariTHBL(thbl);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

     //querryy Geje
      @RequestMapping(value = "**/Ws_Umum/ambilNamaUnitDariKodeUnit.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNamaUnitDariKodeUnit(@RequestParam(value = "kodeunit", defaultValue = "")String kodeunit) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilNamaUnitDariKodeUnit(kodeunit);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }
    //================query geje start referensi
    @RequestMapping(value = "**/Ws_Umum/ref_AmbilInduk.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ref_AmbilInduk() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ref_AmbilInduk();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

   @RequestMapping(value = "**/Ws_Umum/ref_AmbilCabang.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ref_AmbilCabang(@RequestParam(value = "induk", defaultValue = "")String induk) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ref_AmbilCabang(induk);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    //query geje
      @RequestMapping(value = "**/Ws_Umum/ref_AmbilRanting.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ref_AmbilRanting(@RequestParam(value = "cabang", defaultValue = "")String cabang) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ref_AmbilRanting(cabang);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }
    //query geje
    @RequestMapping(value = "**/Ws_Umum/ref_AmbilRantingDngnSemua.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ref_AmbilRantingDngnSemua(@RequestParam(value = "cabang", defaultValue = "")String cabang) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ref_AmbilRantingDngnSemua(cabang);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //query geje
    @RequestMapping(value = "**/Ws_Umum/ref_AmbilPaymentPoint.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ref_AmbilPaymentPoint(@RequestParam(value = "ranting", defaultValue = "")String ranting) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ref_AmbilPaymentPoint(ranting);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //query geje
    @RequestMapping(value = "**/Ws_Umum/ref_AmbilPetugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ref_AmbilPetugas(@RequestParam(value = "pp", defaultValue = "")String pp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ref_AmbilPetugas(pp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //query geje
    @RequestMapping(value = "**/Ws_Umum/ambilTanggalDatabase.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilTanggalDatabase() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilTanggalDatabase();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //query geje
    @RequestMapping(value = "**/Ws_Umum/ambilNamaApdariUp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNamaApdariUp(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilNamaApdariUp(unitUp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //query geje
    @RequestMapping(value = "**/Ws_Umum/getNamaApDariUP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getNamaApDariUP(@RequestParam(value = "unitUP", defaultValue = "")String unitUP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.getNamaApDariUP(unitUP);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //query geje
    @RequestMapping(value = "**/Ws_Umum/ambilNamaKddariUp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNamaKddariUp(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilNamaKddariUp(unitUp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //query geje
    @RequestMapping(value = "**/Ws_Umum/getNamaKdDariUP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getNamaKdDariUP(@RequestParam(value = "UnitUp", defaultValue = "")String UnitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.getNamaKdDariUP(UnitUp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }
    //query geje
    @RequestMapping(value = "**/Ws_Umum/ambilNamaKddariAP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNamaKddariAP(@RequestParam(value = "unitAp", defaultValue = "")String unitAp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilNamaKddariAP(unitAp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    //query geje
    @RequestMapping(value = "**/Ws_Umum/ambilNamaAP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNamaAP(@RequestParam(value = "unitAp", defaultValue = "")String unitAp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilNamaAP(unitAp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


     //query geje
    @RequestMapping(value = "**/Ws_Umum/ambilAlamatdariUp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilAlamatdariUp(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilAlamatdariUp(unitUp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


     //query geje
    @RequestMapping(value = "**/Ws_Umum/getAlamatdariUP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getAlamatdariUP(@RequestParam(value = "Unitup", defaultValue = "")String Unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.getAlamatdariUP(Unitup);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    //query geje
    @RequestMapping(value = "**/Ws_Umum/ambilIDPELfromKONTRAKKONTROLDIL.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilIDPELfromKONTRAKKONTROLDIL(@RequestParam(value = "kontrak", defaultValue = "")String kontrak,
                                               @RequestParam(value = "kontrol", defaultValue = "")String kontrol) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilIDPELfromKONTRAKKONTROLDIL(kontrak, kontrol);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    //query geje
    @RequestMapping(value = "**/Ws_Umum/ambilUnitUPdariPetugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilUnitUPdariPetugas(@RequestParam(value = "petugas", defaultValue = "")String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilUnitUPdariPetugas(petugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //query geje
    @RequestMapping(value = "**/Ws_Umum/ambilKodePPdariUnitUP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilKodePPdariUnitUP(@RequestParam(value = "unitup", defaultValue = "")String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilKodePPdariUnitUP(unitup);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    //query geje
    @RequestMapping(value = "**/Ws_Umum/ambilUnitUp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilUnitUp() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilUnitUp();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    //query geje
    @RequestMapping(value = "**/Ws_Umum/ambilNamaUp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNamaUp(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilNamaUp(unitUp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    //query geje
    @RequestMapping(value = "**/Ws_Umum/getNamaUP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getNamaUP(@RequestParam(value = "UnitUP", defaultValue = "")String UnitUP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.getNamaUP(UnitUP);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/ambilNamaPaymentPointdariKodePp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNamaPaymentPointdariKodePp(@RequestParam(value = "kodepp", defaultValue = "")String kodepp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilNamaPaymentPointdariKodePp(kodepp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

   @RequestMapping(value = "**/Ws_Umum/getPetugasDariTableUsers.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getPetugasDariTableUsers(@RequestParam(value = "strData", defaultValue = "")String strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.getPetugasDariTableUsers(strData);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

   @RequestMapping(value = "**/Ws_Umum/getPiutangInfo.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getPiutangInfo(@RequestParam(value = "clsAR", defaultValue = "")String[] clsAR) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.getPiutangInfo(clsAR);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/getPelunasanIndividu.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getPelunasanIndividu(@RequestParam(value = "JENPIUTANG", defaultValue = "")String JENPIUTANG,
                                    @RequestParam(value = "clsAR", defaultValue = "") String[] clsAR) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.getPelunasanIndividu(JENPIUTANG,clsAR);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/Inform.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject Inform(@RequestParam(value = "idpel", defaultValue = "")String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.Inform(idpel);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

   @RequestMapping(value = "**/Ws_Umum/dsOracle.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject dsOracle(@RequestParam(value = "mSql", defaultValue = "")String mSql,
                        @RequestParam(value = "dsName", defaultValue = "")String dsName) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.dsOracle(mSql,dsName);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/cariPelIndividu.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cariPelIndividu(@RequestParam(value = "clsPel", defaultValue = "")clsPelunasan clsPel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.cariPelIndividu(clsPel);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Umum/carMasterPelangganIndividu.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject carMasterPelangganIndividu(@RequestParam(value = "clsPel", defaultValue = "")clsPelunasan clsPel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.carMasterPelangganIndividu(clsPel);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/getDil.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getDil(@RequestParam(value = "clsdpp", defaultValue = "")clsDPP clsdpp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.getDil(clsdpp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/getDPPIndividu.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getDPPIndividu(@RequestParam(value = "clsdpp", defaultValue = "")clsDPP clsdpp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.getDPPIndividu(clsdpp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/ConnOracle.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ConnOracle() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ConnOracle();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Umum/caridilinfo.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject caridilinfo(@RequestParam(value = "clsPel", defaultValue = "")clsPelunasan clsPel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.caridilinfo(clsPel);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Umum/carDPPInfo.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject carDPPInfo(@RequestParam(value = "clsdpp", defaultValue = "")clsPelunasan clsPel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.carDPPInfo(clsPel);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/getDPPinfo.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getDPPinfo(@RequestParam(value = "clsdpp", defaultValue = "")clsDPP clsdpp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.getDPPinfo(clsdpp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/getDilinfo.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getDilinfo(@RequestParam(value = "clsdpp", defaultValue = "")clsDPP clsdpp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.getDilinfo(clsdpp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Umum/ambilKodesiklis.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilKodesiklis(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilKodesiklis(unitUp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Umum/ambilPejabatID01.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilPejabatID01(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilPejabatID01(unitUp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Umum/ambilPejabatID02.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilPejabatID02(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.ambilPejabatID02(unitUp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Umum/cetakInfo.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cetakInfo(@RequestParam(value = "Idpel", defaultValue = "")String Idpel,
                         @RequestParam(value = "BlnAwal", defaultValue = "")String BlnAwal,
                         @RequestParam(value = "BlnAkhir", defaultValue = "")String BlnAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.cetakInfo(Idpel,BlnAwal,BlnAkhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Umum/cetakInvoice.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cetakInvoice(@RequestParam(value = "Idpel", defaultValue = "")String Idpel,
                            @RequestParam(value = "BlnAwal", defaultValue = "")String BlnAwal,
                            @RequestParam(value = "BlnAkhir", defaultValue = "")String BlnAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.cetakInvoice(Idpel,BlnAwal,BlnAkhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Umum/getMasterKolektif.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getMasterKolektif() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.getMasterKolektif();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


     @RequestMapping(value = "**/Ws_Umum/LihatHistoTrans.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject LihatHistoTrans(@RequestParam(value = "Idpel", defaultValue = "")String Idpel,
                               @RequestParam(value = "BLTH", defaultValue = "")String BLTH) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_umumDao.LihatHistoTrans(Idpel,BLTH);
            obj.put("result", retValue);
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
