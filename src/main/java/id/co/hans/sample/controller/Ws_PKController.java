package id.co.hans.sample.controller;


import id.co.hans.sample.server.dao.ws_PKDao;
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
public class Ws_PKController {
//    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_PKController.class);
//
//    @Autowired
//    ws_PKDao ws_pkDao;
//
//
//    @RequestMapping(value = "**/setSimpanCreditNote.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject setSimpanCreditNote(@RequestParam(value = "nocn", defaultValue = "")String nocn,
//                           @RequestParam(value = "tgl", defaultValue = "")Date tgl,
//                           @RequestParam(value = "kodebank", defaultValue = "")String kodebank,
//                           @RequestParam(value = "kodepp", defaultValue = "")String kodepp,
//                           @RequestParam(value = "mutasi", defaultValue = "")Double mutasi,
//                           @RequestParam(value = "kodePetugas", defaultValue = "")String kodePetugas,
//                           @RequestParam(value = "kb", defaultValue = "")String kb,
//                           @RequestParam(value = "blth", defaultValue = "")String blth) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.setSimpanCreditNote(nocn,tgl,kodebank,kodepp,mutasi,kodePetugas,kb,blth);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//
//    @RequestMapping(value = "**/getRanting.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject getRanting(@RequestParam(value = "strKodeCabang", defaultValue = "")String strKodeCabang) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.getRanting(strKodeCabang);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//    @RequestMapping(value = "**/getPP.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject getPP(@RequestParam(value = "strKodeRanting", defaultValue = "")String strKodeRanting) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.getPP(strKodeRanting);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//    @RequestMapping(value = "**/getInduk.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject getInduk() {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.getInduk();
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//    @RequestMapping(value = "**/getCabang.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject getCabang() {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.getCabang();
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//    @RequestMapping(value = "**/setVerifikasiPiutang.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject setVerifikasiPiutang(@RequestParam(value = "strKodeInduk", defaultValue = "")String strKodeInduk,
//                           @RequestParam(value = "strKodeCabang", defaultValue = "")String strKodeCabang,
//                           @RequestParam(value = "strKodeRanting", defaultValue = "")String strKodeRanting) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.setVerifikasiPiutang(strKodeInduk,strKodeCabang,strKodeRanting);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//
//    @RequestMapping(value = "**/getBongkar.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject getBongkar(@RequestParam(value = "Nomor", defaultValue = "")String Nomor,
//                           @RequestParam(value = "bytTypeNo", defaultValue = "")Byte bytTypeNo) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.getBongkar(Nomor,bytTypeNo);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//
//    @RequestMapping(value = "**/setBongkar.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject setBongkar(@RequestParam(value = "strNomor", defaultValue = "")String strNomor,
//                           @RequestParam(value = "strPelaksana", defaultValue = "")String strPelaksana,
//                           @RequestParam(value = "Byte", defaultValue = "")String Byte,
//                           @RequestParam(value = "NoPelanggan", defaultValue = "")String NoPelanggan) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.setBongkar(strNomor,strPelaksana,Byte,NoPelanggan);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//
//    @RequestMapping(value = "**/getTusBung.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject getTusBung(@RequestParam(value = "Nomor", defaultValue = "")String Nomor,
//                           @RequestParam(value = "bytType", defaultValue = "")Byte bytType,
//                           @RequestParam(value = "bytTypeNo", defaultValue = "")Byte bytTypeNo) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.getTusBung(Nomor,bytType,bytTypeNo);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//    @RequestMapping(value = "**/setTusBung.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject setTusBung(@RequestParam(value = "strNomor", defaultValue = "")String strNomor,
//                           @RequestParam(value = "strPelaksana", defaultValue = "")String strPelaksana,
//                           @RequestParam(value = "strWBP", defaultValue = "")String strWBP,
//                           @RequestParam(value = "strLWBP", defaultValue = "")String strLWBP,
//                           @RequestParam(value = "strKVARH", defaultValue = "")String strKVARH,
//                           @RequestParam(value = "bytType", defaultValue = "")Byte bytType,
//                           @RequestParam(value = "bytTypeNo", defaultValue = "")String bytTypeNo) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.setTusBung(strNomor,strPelaksana,strWBP,strLWBP,strKVARH,bytType,bytTypeNo);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//
//    @RequestMapping(value = "**/getCustomer.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject getCustomer(@RequestParam(value = "strNomor", defaultValue = "")String strNomor,
//                           @RequestParam(value = "bytType", defaultValue = "")Byte bytType) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.getCustomer(strNomor,bytType);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//
//    @RequestMapping(value = "**/formatINDO.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject formatINDO(@RequestParam(value = "strTgl", defaultValue = "")Date strTgl) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.formatINDO(strTgl);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//
//    @RequestMapping(value = "**/getMasterInduk.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject getMasterInduk() {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.getMasterInduk();
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//    @RequestMapping(value = "**/setMasterInduk.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject setMasterInduk(@RequestParam(value = "dsChanged", defaultValue = "")Map<String, Object> dsChanged) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.setMasterInduk(dsChanged);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//    @RequestMapping(value = "**/getTablePejabat.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject getTablePejabat(@RequestParam(value = "strKode", defaultValue = "")String strKode) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.getTablePejabat(strKode);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//    @RequestMapping(value = "**/getData.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject getData(@RequestParam(value = "strQuery", defaultValue = "")String strQuery) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.getData(strQuery);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//    @RequestMapping(value = "**/setData.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject setData(@RequestParam(value = "strQuery", defaultValue = "")String strQuery) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.setData(strQuery);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//    @RequestMapping(value = "**/CekPenghapusanTUL63.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject CekPenghapusanTUL63(@RequestParam(value = "strKodeRanting", defaultValue = "")String strKodeRanting) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.CekPenghapusanTUL63(strKodeRanting);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//    @RequestMapping(value = "**/CekPenghapusanTUL62.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject CekPenghapusanTUL62(@RequestParam(value = "strKodeRanting", defaultValue = "")String strKodeRanting) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.CekPenghapusanTUL62(strKodeRanting);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//
//    @RequestMapping(value = "**/CekPenghapusanTUL61.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject CekPenghapusanTUL61(@RequestParam(value = "strKodeRanting", defaultValue = "")String strKodeRanting) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.CekPenghapusanTUL61(strKodeRanting);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//    @RequestMapping(value = "**/setTUL61.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject setTUL61(@RequestParam(value = "strKodeInduk", defaultValue = "")String strKodeInduk,
//                           @RequestParam(value = "strKodeCabang", defaultValue = "")String strKodeCabang,
//                           @RequestParam(value = "strKodeRanting", defaultValue = "")String strKodeRanting) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.setTUL61(strKodeInduk,strKodeCabang,strKodeRanting);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//    @RequestMapping(value = "**/SetTUL62.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject SetTUL62(@RequestParam(value = "strKodeInduk", defaultValue = "")String strKodeInduk,
//                        @RequestParam(value = "strKodeCabang", defaultValue = "")String strKodeCabang,
//                        @RequestParam(value = "strKodeRanting", defaultValue = "")String strKodeRanting) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.SetTUL62(strKodeInduk,strKodeCabang,strKodeRanting);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//    @RequestMapping(value = "**/SetTUL63.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject SetTUL63(@RequestParam(value = "strKodeInduk", defaultValue = "")String strKodeInduk,
//                           @RequestParam(value = "strKodeCabang", defaultValue = "")String strKodeCabang,
//                           @RequestParam(value = "strKodeRanting", defaultValue = "")String strKodeRanting) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.SetTUL63(strKodeInduk,strKodeCabang,strKodeRanting);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
//
//    @RequestMapping(value = "**/IsiTULVILAPORANSemuaTunggakan.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject IsiTULVILAPORANSemuaTunggakan(@RequestParam(value = "strKodeRanting", defaultValue = "")String strKodeRanting) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_pkDao.IsiTULVILAPORANSemuaTunggakan(strKodeRanting);
//            obj.put("result", retValue);
////            obj.put("records", ws_usersDao.getPengelola());
////            obj.writeJSONString(out);
////            retVal = out.toString();
//        }
//        catch (Exception ex) {
//            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
//        }
//
//        return obj;
//
//    }
}
