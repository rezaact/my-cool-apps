package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.ws_ReportTransaksiDao;
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
public class Ws_ReportTransaksiController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_ReportTransaksiController.class);

    @Autowired
    ws_ReportTransaksiDao ws_reportTransaksiDao;

    @RequestMapping(value = "**/Ws_ReportTransaksi/ref_AmbilInduk.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ref_AmbilInduk() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.ref_AmbilInduk();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/ref_AmbilCabang.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ref_AmbilCabang(@RequestParam(value = "induk", defaultValue = "")String induk) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.ref_AmbilCabang(induk);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


   @RequestMapping(value = "**/Ws_ReportTransaksi/ref_AmbilRanting.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ref_AmbilRanting(@RequestParam(value = "cabang", defaultValue = "")String cabang) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.ref_AmbilRanting(cabang);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }



    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_41rekap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_41rekap(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                 @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                 @RequestParam(value = "tparAp", defaultValue = "")String tparAp,
                                 @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                 @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_41rekap(vJenis,tBLTH,tparAp,tparUp,tPetugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_32rekap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_32rekap(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                 @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                 @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                 @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_32rekap(vJenis,tBLTH,tparUp,tPetugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }



    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_23notarekap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_23notarekap(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                 @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                 @RequestParam(value = "tparAp", defaultValue = "")String tparAp,
                                 @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                 @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                 @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                                 @RequestParam(value = "kode", defaultValue = "")String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_23notarekap(vJenis,tBLTH,tparAp,tparUp,tPetugas,tanggal,kode);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_24notarekap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_24notarekap(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                     @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                     @RequestParam(value = "tparUPI", defaultValue = "")String tparUPI,
                                     @RequestParam(value = "tparAp", defaultValue = "")String tparAp,
                                     @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                     @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                     @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                                     @RequestParam(value = "kode", defaultValue = "")String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_24notarekap(vJenis,tBLTH,tparUPI,tparAp,tparUp,tPetugas,tanggal,kode);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //---tgl 26 jan 07 00.00.00

       @RequestMapping(value = "**/Ws_ReportTransaksi/Get_KODEPP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject Get_KODEPP(@RequestParam(value = "unitup", defaultValue = "")String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.Get_KODEPP(unitup);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportTransaksi/GetViewKODEKOLEKTIF23NOTA.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKODEKOLEKTIF23NOTA() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetViewKODEKOLEKTIF23NOTA();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetViewKODEsiklisUNIT.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKODEsiklisUNIT(@RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                     @RequestParam(value = "tUNIT", defaultValue = "")String tUNIT) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetViewKODEsiklisUNIT(tTHBL,tUNIT);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportTransaksi/GetViewKODEsiklisUNITWithSemua.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKODEsiklisUNITWithSemua(@RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                              @RequestParam(value = "tUNIT", defaultValue = "")String tUNIT) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetViewKODEsiklisUNITWithSemua(tTHBL,tUNIT);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_21rekap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_21rekap(@RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                 @RequestParam(value = "tUNIT", defaultValue = "")String tUNIT,
                                 @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                 @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                 @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                                 @RequestParam(value = "tanggalend", defaultValue = "")String tanggalend,
                                 @RequestParam(value = "kode", defaultValue = "")String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_21rekap(tTHBL,tUNIT,tparUp,tPetugas,tanggal,tanggalend,kode);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_21_BA.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_21_BA(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                 @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                 @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                 @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                 @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                                 @RequestParam(value = "tanggalend", defaultValue = "")String tanggalend,
                                 @RequestParam(value = "kode", defaultValue = "")String kode,
                                 @RequestParam(value = "pengelola", defaultValue = "")String pengelola) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_21_BA(vJenis,tTHBL,tparUp,tPetugas,tanggal,tanggalend,kode,pengelola);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_21kdpp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_21kdpp(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                               @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                               @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                               @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                               @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                               @RequestParam(value = "tanggalend", defaultValue = "")String tanggalend,
                               @RequestParam(value = "kode", defaultValue = "")String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_21kdpp(vJenis,tTHBL,tparUp,tPetugas,tanggal,tanggalend,kode);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_21upload.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_21upload(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                               @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                               @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                               @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                               @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                               @RequestParam(value = "tanggalend", defaultValue = "")String tanggalend,
                               @RequestParam(value = "kode", defaultValue = "")String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_21upload(vJenis,tTHBL,tparUp,tPetugas,tanggal,tanggalend,kode);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_31rekap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_31rekap(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                               @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                               @RequestParam(value = "tparAp", defaultValue = "")String tparAp,
                               @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                               @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_31rekap(vJenis,tTHBL,tparAp,tparUp,tPetugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_22kdpp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_22kdpp(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                               @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                               @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                               @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                               @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                               @RequestParam(value = "tanggalend", defaultValue = "")String tanggalend,
                               @RequestParam(value = "kode", defaultValue = "")String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_22kdpp(vJenis,tTHBL,tparUp,tPetugas,tanggal,tanggalend,kode);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_22kdpp_v2.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_22kdpp_v2(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                                @RequestParam(value = "tanggalend", defaultValue = "")String tanggalend,
                                @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                @RequestParam(value = "kode", defaultValue = "")String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_22kdpp_v2(vJenis,tTHBL,tanggal,tanggalend,tparUp,kode);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_22kdpp_v3.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_22kdpp_v3(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                   @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                   @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                                   @RequestParam(value = "tanggalend", defaultValue = "")String tanggalend,
                                   @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                   @RequestParam(value = "tparAp", defaultValue = "")String tparap,
                                   @RequestParam(value = "tparUpi", defaultValue = "")String tparupi,
                                   @RequestParam(value = "kode", defaultValue = "")String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_22kdpp_v3(vJenis,tTHBL,tanggal,tanggalend,tparUp,tparap,tparupi,kode);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_22rekap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_22rekap(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                   @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                   @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                   @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                   @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                                   @RequestParam(value = "tanggalend", defaultValue = "")String tanggalend,
                                   @RequestParam(value = "kode", defaultValue = "")String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_22rekap(vJenis,tTHBL,tparUp,tPetugas,tanggal,tanggalend,kode);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_22rekap_V2.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_22rekap_V2(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                 @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                 @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                 @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                 @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                                 @RequestParam(value = "tanggalend", defaultValue = "")String tanggalend,
                                 @RequestParam(value = "kode", defaultValue = "")String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_22rekap_V2(vJenis,tTHBL,tparUp,tPetugas,tanggal,tanggalend,kode);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_22rekap_V3.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_22rekap_V3(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                    @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                    @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                    @RequestParam(value = "tparAp", defaultValue = "")String tparAp,
                                    @RequestParam(value = "tparUpi", defaultValue = "")String tparUpi,
                                    @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                    @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                                    @RequestParam(value = "tanggalend", defaultValue = "")String tanggalend,
                                    @RequestParam(value = "kode", defaultValue = "")String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_22rekap_V3(vJenis,tTHBL,tparUp,tparAp,tparUpi,tPetugas,tanggal,tanggalend,kode);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_22rekap_ap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_22rekap_ap(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                    @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                    @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                    @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                    @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                                    @RequestParam(value = "tanggalend", defaultValue = "")String tanggalend,
                                    @RequestParam(value = "kode", defaultValue = "")String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_22rekap_ap(vJenis,tTHBL,tparUp,tPetugas,tanggal,tanggalend,kode);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_13rekap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_13rekap(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                    @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                    @RequestParam(value = "tparAp", defaultValue = "")String tparAp,
                                    @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                    @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_13rekap(vJenis,tTHBL,tparAp,tparUp,tPetugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_12rekap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_12rekap(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                 @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                 @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                 @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_12rekap(vJenis,tTHBL,tparUp,tPetugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_12RekapGabungan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_12RekapGabungan(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                 @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                 @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                 @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                 @RequestParam(value = "tParAP", defaultValue = "")String tParAP,
                                 @RequestParam(value = "in_unitupi", defaultValue = "")String in_unitupi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_12RekapGabungan(vJenis,tTHBL,tparUp,tPetugas,tParAP,in_unitupi);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_12jnskoreksi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_12jnskoreksi(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                         @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                         @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                         @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                         @RequestParam(value = "kdKoreksi", defaultValue = "")String kdKoreksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_12jnskoreksi(vJenis,tTHBL,tparUp,tPetugas,kdKoreksi);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_12Jenis.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_12Jenis(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                      @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                      @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                      @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_12Jenis(vJenis,tTHBL,tparUp,tPetugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_11rekap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_11rekap(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                 @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                 @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                 @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                 @RequestParam(value = "kode", defaultValue = "")String kode,
                                 @RequestParam(value = "tparAp", defaultValue = "")String tparAp,
                                 @RequestParam(value = "in_unitupi", defaultValue = "")String in_unitupi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_11rekap(vJenis,tTHBL,tparUp,tPetugas,kode,tparAp,in_unitupi);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //---tambahan BK
    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_BK_212223rekap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_BK_212223rekap(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                 @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                 @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                 @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                 @RequestParam(value = "kode", defaultValue = "")String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_BK_212223rekap(vJenis,tTHBL,tparUp,tPetugas,kode);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }
    //---end BK

    //------------------------------


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_23dltrekap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_23dltrekap(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                        @RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                        @RequestParam(value = "tparAp", defaultValue = "")String tparAp,
                                        @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                        @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                        @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                                        @RequestParam(value = "kode", defaultValue = "")String kode,
                                        @RequestParam(value = "tparUPI", defaultValue = "")String tparUPI) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_23dltrekap(vJenis,tTHBL,tparAp,tparUp,tPetugas,tanggal,kode,tparUPI);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetViewKODEKOLEKTIF23NOTATERPUSAT.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetViewKODEKOLEKTIF23NOTATERPUSAT() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetViewKODEKOLEKTIF23NOTATERPUSAT();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //--- Laporan Kolektif

    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_21Giral_Kode.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_21Giral_Kode(@RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                                 @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                                 @RequestParam(value = "kode", defaultValue = "")String kode,
                                                 @RequestParam(value = "jenis", defaultValue = "")String jenis) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_21Giral_Kode(tTHBL,tPetugas,kode,jenis);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_23Nota_Kode.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_23Nota_Kode(@RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                                 @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                                 @RequestParam(value = "kode", defaultValue = "")String kode,
                                                 @RequestParam(value = "jenis", defaultValue = "")String jenis,
                                                 @RequestParam(value = "tBebanKantor", defaultValue = "")Integer tBebanKantor) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_23Nota_Kode(tTHBL,tPetugas,kode,jenis,tBebanKantor);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_23Terpusat_Kode.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_23Terpusat_Kode(@RequestParam(value = "tTHBL", defaultValue = "")String tTHBL,
                                     @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                     @RequestParam(value = "kode", defaultValue = "")String kode,
                                     @RequestParam(value = "jenis", defaultValue = "")String jenis) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_23Terpusat_Kode(tTHBL,tPetugas,kode,jenis);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //--- Cicilan Rekening

    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_Cilrek_Jurnal.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_Cilrek_Jurnal(@RequestParam(value = "tKode", defaultValue = "")String tKode,
                                         @RequestParam(value = "tThbl", defaultValue = "")String tThbl,
                                         @RequestParam(value = "tParUp", defaultValue = "")String tParUp,
                                         @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_Cilrek_Jurnal(tKode,tThbl,tParUp,tPetugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

   @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_Cilrek_Daftar.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_Cilrek_Daftar(@RequestParam(value = "tKode", defaultValue = "")String tKode,
                                       @RequestParam(value = "tThbl", defaultValue = "")String tThbl,
                                       @RequestParam(value = "tParUp", defaultValue = "")String tParUp,
                                       @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_Cilrek_Daftar(tKode,tThbl,tParUp,tPetugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

     @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_Cilrek_Idpel.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_Cilrek_Idpel(@RequestParam(value = "tIdpel", defaultValue = "")String tIdpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_Cilrek_Idpel(tIdpel);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    //----End cicilan rekening

    //----REPORT KIRIM UNIT

    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_23Kirim_Rekap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_23Kirim_Rekap(@RequestParam(value = "tThbl", defaultValue = "")String tThbl,
                                       @RequestParam(value = "tParUp", defaultValue = "")String tParUp,
                                       @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_23Kirim_Rekap(tThbl,tParUp,tPetugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_23Kirim_Daftar.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_23Kirim_Daftar(@RequestParam(value = "tThbl", defaultValue = "")String tThbl,
                                       @RequestParam(value = "tParUp", defaultValue = "")String tParUp,
                                       @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_23Kirim_Daftar(tThbl,tParUp,tPetugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //---END REPORT KIRIM UNIT

    //---REPORT TERIMA UNIT

    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_23Terima_Rekap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_23Terima_Rekap( @RequestParam(value = "tThbl", defaultValue = "")String tThbl,
                                       @RequestParam(value = "tParUp", defaultValue = "")String tParUp,
                                       @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_23Terima_Rekap(tThbl,tParUp,tPetugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }



    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_23Terima_Daftar.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_23Terima_Daftar( @RequestParam(value = "tThbl", defaultValue = "")String tThbl,
                                       @RequestParam(value = "tParUp", defaultValue = "")String tParUp,
                                       @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_23Terima_Daftar(tThbl,tParUp,tPetugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //---END REPORT TERIMA UNIT

    @RequestMapping(value = "**/Ws_ReportTransaksi/getLaporan309.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getLaporan309(@RequestParam(value = "jenis", defaultValue = "")String jenis,
                                       @RequestParam(value = "tparUP", defaultValue = "")String tparUP,
                                       @RequestParam(value = "tParAP", defaultValue = "")String tParAP,
                                       @RequestParam(value = "blth", defaultValue = "")String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.getLaporan309(jenis,tparUP,tParAP,blth);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/getLaporan309perUnit.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getLaporan309perUnit(@RequestParam(value = "jenis", defaultValue = "")String jenis,
                                       @RequestParam(value = "tParUnit", defaultValue = "")String tParUnit,
                                       @RequestParam(value = "blth", defaultValue = "")String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.getLaporan309perUnit(jenis,tParUnit,blth);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/setLaporan309.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject setLaporan309(@RequestParam(value = "jenis", defaultValue = "")String jenis,
                                       @RequestParam(value = "tparUP", defaultValue = "")String tparUP,
                                       @RequestParam(value = "tParAP", defaultValue = "")String tParAP,
                                       @RequestParam(value = "blth", defaultValue = "")String blth,
                                       @RequestParam(value = "transaksiby", defaultValue = "")String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.setLaporan309(jenis,tparUP,tParAP,blth,transaksiby);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_22rekap_Global.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_22rekap_Global(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                             @RequestParam(value = "vFilterUnit", defaultValue = "")String vFilterUnit,
                             @RequestParam(value = "tparUpi", defaultValue = "")String tparUpi,
                             @RequestParam(value = "tparAp", defaultValue = "")String tparAp,
                             @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                             @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                             @RequestParam(value = "tanggalend", defaultValue = "")String tanggalend ) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_22rekap_Global(vJenis,vFilterUnit,tparUpi,tparAp,tparUp,tanggal,tanggalend);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_2122DoubleBayar.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_2122DoubleBayar(@RequestParam(value = "sUnit", defaultValue = "")String sUnit,
                             @RequestParam(value = "sBlnBayar", defaultValue = "")String sBlnBayar,
                             @RequestParam(value = "sKogol", defaultValue = "")String sKogol) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_2122DoubleBayar(sUnit,sBlnBayar,sKogol);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_2122DoubleBayarNew.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_2122DoubleBayarNew(@RequestParam(value = "sUnit", defaultValue = "")String sUnit,
                             @RequestParam(value = "sBlnBayar", defaultValue = "")String sBlnBayar) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_2122DoubleBayarNew(sUnit,sBlnBayar);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/ref_AmbilPetugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ref_AmbilPetugas(@RequestParam(value = "kodePP", defaultValue = "")String kodePP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.ref_AmbilPetugas(kodePP);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_21petugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_21petugas(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                   @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                   @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                   @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                   @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                                   @RequestParam(value = "tanggalend", defaultValue = "")String tanggalend,
                                   @RequestParam(value = "kode", defaultValue = "")String kode,
                                   @RequestParam(value = "kdPembayar", defaultValue = "")String kdPembayar) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_21petugas(vJenis,tBLTH,tparUp,tPetugas,tanggal,tanggalend,kode,kdPembayar);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_22petugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_22petugas(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                                       @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                                       @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                                       @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                                       @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                                       @RequestParam(value = "tanggalend", defaultValue = "")String tanggalend,
                                       @RequestParam(value = "kode", defaultValue = "")String kode,
                                       @RequestParam(value = "kdPembayar", defaultValue = "")String kdPembayar,
                                       @RequestParam(value = "sATM", defaultValue = "")String sATM) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_22petugas(vJenis,tBLTH,tparUp,tPetugas,tanggal,tanggalend,kode,kdPembayar,sATM);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_22petugasDaya.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_22petugasDaya(@RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                             @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                             @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                             @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                             @RequestParam(value = "tanggal", defaultValue = "")String tanggal,
                             @RequestParam(value = "tanggalend", defaultValue = "")String tanggalend,
                             @RequestParam(value = "kode", defaultValue = "")String kode,
                             @RequestParam(value = "kdPembayar", defaultValue = "")String kdPembayar,
                             @RequestParam(value = "sATM", defaultValue = "")String sATM,
                             @RequestParam(value = "vDayaAwal", defaultValue = "")String vDayaAwal,
                             @RequestParam(value = "vDayaAkhir", defaultValue = "")String vDayaAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_22petugasDaya(vJenis,tBLTH,tparUp,tPetugas,tanggal,tanggalend,kode,kdPembayar,sATM,vDayaAwal,vDayaAkhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport_Pemda.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport_Pemda(@RequestParam(value = "tparAP", defaultValue = "")String tparAP,
                             @RequestParam(value = "tparUp", defaultValue = "")String tparUp,
                             @RequestParam(value = "tBLTH", defaultValue = "")String tBLTH,
                             @RequestParam(value = "vJenis", defaultValue = "")String vJenis,
                             @RequestParam(value = "tPetugas", defaultValue = "")String tPetugas,
                             @RequestParam(value = "in_unitupi", defaultValue = "")String in_unitupi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport_Pemda(tparAP,tparUp,tBLTH,vJenis,tPetugas,in_unitupi);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportTransaksi/cetak_rekap11TglUpload.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cetak_rekap11TglUpload(@RequestParam(value = "Unitup", defaultValue = "")String Unitup,
                             @RequestParam(value = "TglMulai", defaultValue = "")String TglMulai,
                             @RequestParam(value = "TglAkhir", defaultValue = "")String TglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.cetak_rekap11TglUpload(Unitup,TglMulai,TglAkhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/getMonitoringSorekDJBB.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getMonitoringSorekDJBB(@RequestParam(value = "vUNITAP", defaultValue = "")String vUNITAP,
                             @RequestParam(value = "vTGLKIRIM", defaultValue = "")String vTGLKIRIM) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.getMonitoringSorekDJBB(vUNITAP,vTGLKIRIM);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/getMonitoringLapSaldoTunggakan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getMonitoringLapSaldoTunggakan(@RequestParam(value = "in_jenis", defaultValue = "")String in_jenis,
                             @RequestParam(value = "in_Unitupi", defaultValue = "")String in_Unitupi,
                             @RequestParam(value = "in_Unitap", defaultValue = "")String in_Unitap,
                             @RequestParam(value = "in_Unitup", defaultValue = "")String in_Unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue =  ws_reportTransaksiDao.getMonitoringLapSaldoTunggakan(in_jenis,in_Unitupi,in_Unitap,in_Unitup);
            obj.put("result", retValue);
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }



    @RequestMapping(value = "**/Ws_ReportTransaksi/GetTunggakanPemda.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetTunggakanPemda(@RequestParam(value = "in_unitupi", defaultValue = "")String in_unitupi,
                             @RequestParam(value = "in_unitap", defaultValue = "")String in_unitap,
                             @RequestParam(value = "in_unitup", defaultValue = "")String in_unitup,
                             @RequestParam(value = "in_blth", defaultValue = "")String in_blth,
                             @RequestParam(value = "in_jenis", defaultValue = "")String in_jenis) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetTunggakanPemda(in_unitupi,in_unitap,in_unitup,in_blth,in_jenis);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReportRestitusi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReportRestitusi(@RequestParam(value = "in_unitap", defaultValue = "")String in_unitap,
                             @RequestParam(value = "in_unitup", defaultValue = "")String in_unitup,
                             @RequestParam(value = "in_blth", defaultValue = "")String in_blth,
                             @RequestParam(value = "in_jenis", defaultValue = "")String in_jenis) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReportRestitusi(in_unitap,in_unitup,in_blth,in_jenis);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportTransaksi/ambilLaporan508.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilLaporan508(@RequestParam(value = "vNoForm", defaultValue = "")String vNoForm,
                             @RequestParam(value = "thbl", defaultValue = "")String thbl,
                             @RequestParam(value = "CekSatker", defaultValue = "")String CekSatker) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.ambilLaporan508(vNoForm,thbl,CekSatker);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportTransaksi/ambilLaporan509.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilLaporan509(@RequestParam(value = "vIDKotama", defaultValue = "")String vIDKotama,
                             @RequestParam(value = "thbl", defaultValue = "")String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.ambilLaporan509(vIDKotama,thbl);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_ReportTransaksi/ambilLaporan509Rekap.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilLaporan509Rekap(@RequestParam(value = "vIDKotama", defaultValue = "")String vIDKotama,
                             @RequestParam(value = "thbl", defaultValue = "")String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.ambilLaporan509Rekap(vIDKotama,thbl);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_ReportTransaksi/GetReport21Restitusi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject GetReport21Restitusi(@RequestParam(value = "in_unitupi", defaultValue = "")String in_unitupi,
                             @RequestParam(value = "in_unitap", defaultValue = "")String in_unitap,
                             @RequestParam(value = "in_unitup", defaultValue = "")String in_unitup,
                             @RequestParam(value = "in_blth", defaultValue = "")String in_blth,
                             @RequestParam(value = "in_jenis", defaultValue = "")String in_jenis) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_reportTransaksiDao.GetReport21Restitusi(in_unitupi,in_unitap,in_unitup,in_blth,in_jenis);
            obj.put("result", retValue);
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
