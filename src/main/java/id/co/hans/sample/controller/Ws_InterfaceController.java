package id.co.hans.sample.controller;


import id.co.hans.sample.server.dao.ws_InterfaceDao;
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
public class Ws_InterfaceController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_InterfaceController.class);

    @Autowired
    ws_InterfaceDao ws_interfaceDao;


    @RequestMapping(value = "**/Ws_Interface/simpanDPHLoad_AJN.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanDPHLoad_AJN(@RequestParam(value = "idPel", defaultValue = "")String idPel,
                                   @RequestParam(value = "blth", defaultValue = "")String blth,
                                   @RequestParam(value = "tglbayar", defaultValue = "")String tglbayar,
                                   @RequestParam(value = "rptag", defaultValue = "")String rptag,
                                   @RequestParam(value = "rpbk", defaultValue = "")String rpbk,
                                   @RequestParam(value = "ipaddress", defaultValue = "")String ipaddress) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.simpanDPHLoad_AJN(idPel,blth,tglbayar,rptag,rpbk,ipaddress);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/simpanDPHLoads.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanDPHLoads(@RequestParam(value = "idPel", defaultValue = "")String idPel,
                                 @RequestParam(value = "blth", defaultValue = "")String blth,
                                 @RequestParam(value = "kdpembpp", defaultValue = "")String kdpembpp,
                                 @RequestParam(value = "unitup", defaultValue = "")String unitup,
                                 @RequestParam(value = "kdpp", defaultValue = "")String kdpp,
                                 @RequestParam(value = "kdgerak", defaultValue = "")String kdgerak,
                                 @RequestParam(value = "tglbayar", defaultValue = "")String tglbayar,
                                 @RequestParam(value = "refno", defaultValue = "")String refno,
                                 @RequestParam(value = "rptag", defaultValue = "")String rptag,
                                 @RequestParam(value = "rpbk", defaultValue = "")String rpbk,
                                 @RequestParam(value = "layerke", defaultValue = "")String layerke,
                                 @RequestParam(value = "ipaddress", defaultValue = "")String ipaddress,
                                 @RequestParam(value = "tglupload", defaultValue = "")String tglupload,
                                 @RequestParam(value = "noupload", defaultValue = "")String noupload) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.simpanDPHLoads(idPel,blth,kdpembpp,unitup,kdpp,kdgerak,tglbayar,refno,rptag,rpbk,layerke,ipaddress,tglupload,noupload);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Interface/simpandphload_2.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpandphload_2(@RequestParam(value = "idPel", defaultValue = "")String idPel,
                              @RequestParam(value = "kdpembpp", defaultValue = "")String kdpembpp,
                              @RequestParam(value = "unitup", defaultValue = "")String unitup,
                              @RequestParam(value = "kdpp", defaultValue = "")String kdpp,
                              @RequestParam(value = "kdgerak", defaultValue = "")String kdgerak,
                              @RequestParam(value = "refno", defaultValue = "")String refno,
                              @RequestParam(value = "rpbk", defaultValue = "")String rpbk,
                              @RequestParam(value = "layerke", defaultValue = "")String layerke,
                              @RequestParam(value = "ipaddress", defaultValue = "")String ipaddress,
                              @RequestParam(value = "noupload", defaultValue = "")String noupload,
                              @RequestParam(value = "type_rekening", defaultValue = "")Integer type_rekening) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.simpandphload_2(idPel,kdpembpp,unitup,kdpp,kdgerak,refno,
                                                      rpbk,layerke,ipaddress,noupload,type_rekening);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/simpanddphload_Kolektif.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanddphload_Kolektif(@RequestParam(value = "kdpembpp", defaultValue = "")String kdpembpp,
                               @RequestParam(value = "unitup", defaultValue = "")String unitup,
                               @RequestParam(value = "kdpp", defaultValue = "")String kdpp,
                               @RequestParam(value = "kdgerak", defaultValue = "")String kdgerak,
                               @RequestParam(value = "refno", defaultValue = "")String refno,
                               @RequestParam(value = "rpbk", defaultValue = "")String rpbk,
                               @RequestParam(value = "layerke", defaultValue = "")String layerke,
                               @RequestParam(value = "ipaddress", defaultValue = "")String ipaddress,
                               @RequestParam(value = "noupload", defaultValue = "")String noupload,
                               @RequestParam(value = "kdkol", defaultValue = "")String kdkol) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.simpanddphload_Kolektif(kdpembpp,unitup,kdpp,kdgerak,refno,
                    rpbk,layerke,ipaddress,noupload,kdkol);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Interface/bl_th_tagihan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject bl_th_tagihan(@RequestParam(value = "blthrek", defaultValue = "")String blthrek) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.bl_th_tagihan(blthrek);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Interface/fg_tgl_jatuh_tempo.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject fg_tgl_jatuh_tempo(@RequestParam(value = "blth", defaultValue = "")String blth,
                                       @RequestParam(value = "kode_ranting_numerik", defaultValue = "")String kode_ranting_numerik) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.fg_tgl_jatuh_tempo(blth,kode_ranting_numerik);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Interface/getData.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getData(@RequestParam(value = "strQuery", defaultValue = "")String strQuery) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.getData(strQuery);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/setData.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject setData(@RequestParam(value = "strQuery", defaultValue = "")String strQuery) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.setData(strQuery);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }



    @RequestMapping(value = "**/Ws_Interface/isiDKRPLoad.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject isiDKRPLoad(@RequestParam(value = "no_pelanggan", defaultValue = "")String no_pelanggan,
                                       @RequestParam(value = "uraian", defaultValue = "")String uraian,
                                       @RequestParam(value = "ipaddress", defaultValue = "")String ipaddress,
                                       @RequestParam(value = "tglkonsld", defaultValue = "")String tglkonsld,
                                       @RequestParam(value = "konsldke", defaultValue = "")Integer konsldke,
                                       @RequestParam(value = "layerke", defaultValue = "")Integer layerke) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.isiDKRPLoad(no_pelanggan,uraian,ipaddress,tglkonsld,konsldke,layerke);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/rptBaOffline.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject rptBaOffline(@RequestParam(value = "TglLunas", defaultValue = "")String TglLunas,
                                       @RequestParam(value = "petugas", defaultValue = "")String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.rptBaOffline(TglLunas,petugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/rptRkpPelunasanHarian.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject rptRkpPelunasanHarian(@RequestParam(value = "tglmulai", defaultValue = "")String tglmulai,
                                       @RequestParam(value = "tglselesai", defaultValue = "")String tglselesai,
                                       @RequestParam(value = "petugas", defaultValue = "")String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.rptRkpPelunasanHarian(tglmulai,tglselesai,petugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/rptRkpPelunasanPeriode.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject rptRkpPelunasanPeriode(@RequestParam(value = "tglmulai", defaultValue = "")String tglmulai,
                                       @RequestParam(value = "tglselesai", defaultValue = "")String tglselesai,
                                       @RequestParam(value = "petugas", defaultValue = "")String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.rptRkpPelunasanPeriode(tglmulai,tglselesai,petugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }



    @RequestMapping(value = "**/Ws_Interface/simpanDPHLoad.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanDPHLoad(@RequestParam(value = "idPel", defaultValue = "")String idPel,
                              @RequestParam(value = "blth", defaultValue = "")String blth,
                              @RequestParam(value = "kdpembpp", defaultValue = "")String kdpembpp,
                              @RequestParam(value = "unitup", defaultValue = "")String unitup,
                              @RequestParam(value = "kdpp", defaultValue = "")String kdpp,
                              @RequestParam(value = "kdgerak", defaultValue = "")String kdgerak,
                              @RequestParam(value = "tglbayar", defaultValue = "")String tglbayar,
                              @RequestParam(value = "refno", defaultValue = "")String refno,
                              @RequestParam(value = "rptag", defaultValue = "")String rptag,
                              @RequestParam(value = "rpbk", defaultValue = "")String rpbk,
                              @RequestParam(value = "layerke", defaultValue = "")String layerke,
                              @RequestParam(value = "ipaddress", defaultValue = "")String ipaddress,
                              @RequestParam(value = "tglupload", defaultValue = "")String tglupload,
                              @RequestParam(value = "noupload", defaultValue = "")String noupload) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.simpanDPHLoad(idPel,blth,kdpembpp,unitup,kdpp,kdgerak,tglbayar,refno,rptag,rpbk,layerke,ipaddress,tglupload,noupload);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/simpanDpdtLoad.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanDpdtLoad(@RequestParam(value = "idPel", defaultValue = "")String idPel,
                              @RequestParam(value = "blth", defaultValue = "")String blth,
                              @RequestParam(value = "kdkoreksi", defaultValue = "")String kdkoreksi,
                              @RequestParam(value = "ipaddress", defaultValue = "")String ipaddress,
                              @RequestParam(value = "KRM", defaultValue = "")String KRM,
                              @RequestParam(value = "TRM", defaultValue = "")String TRM) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.simpanDpdtLoad(idPel,blth,kdkoreksi,ipaddress,KRM,TRM);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/simpanDpdtLoadTERIMA.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanDpdtLoadTERIMA(@RequestParam(value = "idPel", defaultValue = "")String idPel,
                              @RequestParam(value = "ur", defaultValue = "")String ur) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.simpanDpdtLoadTERIMA(idPel,ur);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/simpanDKRPLoadS.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanDKRPLoadS(@RequestParam(value = "no_pelanggan", defaultValue = "")String no_pelanggan,
                              @RequestParam(value = "blth", defaultValue = "")String blth,
                              @RequestParam(value = "URAIAN", defaultValue = "")String URAIAN,
                              @RequestParam(value = "ipaddress", defaultValue = "")String ipaddress,
                              @RequestParam(value = "kodegerak", defaultValue = "")String kodegerak) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.simpanDKRPLoadS(no_pelanggan,blth,URAIAN,ipaddress,kodegerak);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Interface/simpanDKRPLoad.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanDKRPLoad(@RequestParam(value = "idPel", defaultValue = "")String idPel,
                              @RequestParam(value = "blth", defaultValue = "")String blth,
                              @RequestParam(value = "kdkoreksi", defaultValue = "")String kdkoreksi,
                              @RequestParam(value = "ipaddress", defaultValue = "")String ipaddress) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.simpanDKRPLoad(idPel,blth,kdkoreksi,ipaddress);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/simpandkrpload_Krk_kd_golongan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpandkrpload_Krk_kd_golongan(@RequestParam(value = "kdkol", defaultValue = "")String kdkol,
                              @RequestParam(value = "ipaddress", defaultValue = "")String ipaddress) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.simpandkrpload_Krk_kd_golongan(kdkol,ipaddress);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Interface/simpanDKRPL.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanDKRPL(@RequestParam(value = "idPel", defaultValue = "")String idPel,
                              @RequestParam(value = "no_kwitansi", defaultValue = "")String no_kwitansi,
                              @RequestParam(value = "IPADDRESS", defaultValue = "")String IPADDRESS) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.simpanDKRPL(idPel,no_kwitansi,IPADDRESS);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Interface/simpanDBPLoad.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanDBPLoad(@RequestParam(value = "nopelanggan", defaultValue = "")String nopelanggan,
                              @RequestParam(value = "blth", defaultValue = "")String blth,
                              @RequestParam(value = "ipaddress", defaultValue = "")String ipaddress,
                              @RequestParam(value = "kodegerak", defaultValue = "")String kodegerak) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.simpanDBPLoad(nopelanggan,blth,ipaddress,kodegerak);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Interface/uploadKe.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject uploadKe(@RequestParam(value = "jenisdata", defaultValue = "")String jenisdata) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.uploadKe(jenisdata);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/uploadKeAJN.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject uploadKeAJN() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.uploadKeAJN();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/kodeKoreksi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject kodeKoreksi(@RequestParam(value = "alasan", defaultValue = "")String alasan) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.kodeKoreksi(alasan);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/bl_th.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject bl_th(@RequestParam(value = "blth", defaultValue = "")String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.bl_th(blth);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/setRek_Sorek.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject setRek_Sorek(@RequestParam(value = "procedureName", defaultValue = "")String procedureName,
                              @RequestParam(value = "unitup", defaultValue = "")String unitup,
                              @RequestParam(value = "blth", defaultValue = "")String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.setRek_Sorek(procedureName,unitup,blth);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/setLunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject setLunas(@RequestParam(value = "petugas", defaultValue = "")String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.setLunas(petugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/setSaldo.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject setSaldo(@RequestParam(value = "baris_txt", defaultValue = "")String baris_txt) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.setSaldo(baris_txt);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Interface/getUraian.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getUraian(@RequestParam(value = "blth", defaultValue = "")String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.getUraian(blth);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/getBlThRekening.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getBlThRekening(@RequestParam(value = "blth", defaultValue = "")String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.getBlThRekening(blth);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Interface/cekrekbermasalah.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject cekrekbermasalah(@RequestParam(value = "tgllunas", defaultValue = "")String tgllunas,
                              @RequestParam(value = "idpel", defaultValue = "")String idpel,
                              @RequestParam(value = "sbb", defaultValue = "")String sbb) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.cekrekbermasalah(tgllunas,idpel,sbb);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Interface/setPelunasanOffline.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject setPelunasanOffline(@RequestParam(value = "strread", defaultValue = "")String strread,
                              @RequestParam(value = "strGlobalKodePetugas", defaultValue = "")String strGlobalKodePetugas,
                              @RequestParam(value = "ipaddress", defaultValue = "")String ipaddress) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            obj.put("result", retValue);
            retValue=  ws_interfaceDao.setPelunasanOffline(strread,strGlobalKodePetugas,ipaddress);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //ADDED BY DJAINUL
    @RequestMapping(value = "**/Ws_Interface/InsertDPPfromSOREK.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject InsertDPPfromSOREK(@RequestParam(value = "CustomConnectionString", defaultValue = "")String CustomConnectionString,
                              @RequestParam(value = "pUNITUP", defaultValue = "")String pUNITUP,
                              @RequestParam(value = "pBLTH", defaultValue = "")String pBLTH) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            obj.put("result", retValue);
            retValue=  ws_interfaceDao.InsertDPPfromSOREK(CustomConnectionString,pUNITUP,pBLTH);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Interface/doRekapSOREK.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject doRekapSOREK(@RequestParam(value = "CustomConnectionString", defaultValue = "")String CustomConnectionString,
                              @RequestParam(value = "pUNITUP", defaultValue = "")String pUNITUP,
                              @RequestParam(value = "pTGLKONSLD", defaultValue = "")Date  pTGLKONSLD) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.doRekapSOREK(CustomConnectionString,pUNITUP,pTGLKONSLD);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Interface/doRekapDPP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject doRekapDPP(@RequestParam(value = "CustomConnectionString", defaultValue = "")String CustomConnectionString,
                              @RequestParam(value = "pUNITUP", defaultValue = "")String pUNITUP,
                              @RequestParam(value = "pTGLKONSLD", defaultValue = "")Date pTGLKONSLD) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_interfaceDao.doRekapDPP(CustomConnectionString,pUNITUP,pTGLKONSLD);
            obj.put("result", retValue);
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
