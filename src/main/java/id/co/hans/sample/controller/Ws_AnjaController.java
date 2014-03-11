package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.clsBANK;
import id.co.hans.sample.server.dao.ws_AnjaDao;
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
public class Ws_AnjaController {
//    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_AnjaController.class);
//
//    @Autowired
//    ws_AnjaDao ws_anjaDao;
//
//    //---- ### START WASKIT ####################################################################################
//
//    @RequestMapping(value = "**/sp_waskit_verifikasi.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject sp_waskit_verifikasi(@RequestParam(value = "nav", defaultValue = "")Integer nav) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.sp_waskit_verifikasi(nav);
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
//    @RequestMapping(value = "**/ambilNomerTulVI01.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilNomerTulVI01(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.ambilNomerTulVI01(unitUp);
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
//    @RequestMapping(value = "**/insertTulVI01.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject insertTulVI01(@RequestParam(value = "No_60", defaultValue = "")Integer No_60,
//                             @RequestParam(value = "UnitUP", defaultValue = "")String UnitUP,
//                             @RequestParam(value = "ThBlRek", defaultValue = "")String ThBlRek,
//                             @RequestParam(value = "IdPelanggan", defaultValue = "")String IdPelanggan,
//                             @RequestParam(value = "NoKontrak", defaultValue = "")String NoKontrak,
//                             @RequestParam(value = "NoKontrol", defaultValue = "")String NoKontrol,
//                             @RequestParam(value = "Nama", defaultValue = "")String Nama,
//                             @RequestParam(value = "Alamat", defaultValue = "")String Alamat,
//                             @RequestParam(value = "ThBlRek_akhir", defaultValue = "")String ThBlRek_akhir,
//                             @RequestParam(value = "Lembar_601", defaultValue = "")String Lembar_601,
//                             @RequestParam(value = "Tagihan_601", defaultValue = "")String Tagihan_601,
//                             @RequestParam(value = "NOtul601", defaultValue = "")String NOtul601) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.insertTulVI01(No_60,UnitUP,ThBlRek,IdPelanggan,NoKontrak,NoKontrol,
//                                    Nama,Alamat,ThBlRek_akhir,Lembar_601,Tagihan_601,NOtul601);
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
//    @RequestMapping(value = "**/AmbilTul601.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject AmbilTul601(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
//                             @RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.AmbilTul601(unitUp,sqlKriteria);
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
//    //---- Laporan VI-03
//    @RequestMapping(value = "**/ambilDaftarPantauCetak603.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilDaftarPantauCetak603(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
//                           @RequestParam(value = "awal", defaultValue = "")Date awal,
//                           @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.ambilDaftarPantauCetak603(unitUp,awal,akhir);
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
//    //---- Laporan VI-01
//      @RequestMapping(value = "**/ambilDaftarPantauCetak601.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilDaftarPantauCetak601(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
//                                         @RequestParam(value = "awal", defaultValue = "")Date awal,
//                                         @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.ambilDaftarPantauCetak601(unitUp,awal,akhir);
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
//    @RequestMapping(value = "**/ambilRekapPantauCetak601.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilRekapPantauCetak601(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
//                                         @RequestParam(value = "awal", defaultValue = "")Date awal,
//                                         @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.ambilRekapPantauCetak601(unitUp,awal,akhir);
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
//    @RequestMapping(value = "**/ambilDaftar601Lunas.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilDaftar601Lunas(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
//                                        @RequestParam(value = "awalPk", defaultValue = "")Date awalPk,
//                                        @RequestParam(value = "akhirPk", defaultValue = "")Date akhirPk,
//                                        @RequestParam(value = "awalLns", defaultValue = "")Date awalLns,
//                                        @RequestParam(value = "akhirLns", defaultValue = "")Date akhirLns) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.ambilDaftar601Lunas(unitUp,awalPk,akhirPk,awalLns,akhirLns);
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
//    @RequestMapping(value = "**/ambilRekap601Lunas.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilRekap601Lunas(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
//                                   @RequestParam(value = "awalPk", defaultValue = "")Date awalPk,
//                                   @RequestParam(value = "akhirPk", defaultValue = "")Date akhirPk,
//                                   @RequestParam(value = "awalLns", defaultValue = "")Date awalLns,
//                                   @RequestParam(value = "akhirLns", defaultValue = "")Date akhirLns) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.ambilRekap601Lunas(unitUp,awalPk,akhirPk,awalLns,akhirLns);
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
//    @RequestMapping(value = "**/ambilTulVIperNamaPutus.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilTulVIperNamaPutus(@RequestParam(value = "nama", defaultValue = "")String nama,
//                                  @RequestParam(value = "tglAwal", defaultValue = "")Date tglAwal,
//                                  @RequestParam(value = "tglAkhir", defaultValue = "")Date tglAkhir) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.ambilTulVIperNamaPutus(nama,tglAwal,tglAkhir);
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
//       @RequestMapping(value = "**/ambilDetailTulVIperNamaPetugas.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilDetailTulVIperNamaPetugas(@RequestParam(value = "nama", defaultValue = "")String nama,
//                                      @RequestParam(value = "tglAwal", defaultValue = "")Date tglAwal,
//                                      @RequestParam(value = "tglAkhir", defaultValue = "")Date tglAkhir) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.ambilDetailTulVIperNamaPetugas(nama,tglAwal,tglAkhir);
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
//    @RequestMapping(value = "**/ambilTulVIRekapKinerja.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilTulVIRekapKinerja(@RequestParam(value = "nama", defaultValue = "")String nama,
//                                              @RequestParam(value = "tglAwal", defaultValue = "")Date tglAwal,
//                                              @RequestParam(value = "tglAkhir", defaultValue = "")Date tglAkhir) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.ambilTulVIRekapKinerja(nama,tglAwal,tglAkhir);
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
//    @RequestMapping(value = "**/ambilTulVIperIdPel.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilTulVIperIdPel(@RequestParam(value = "idpel", defaultValue = "")String idpel) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.ambilTulVIperIdPel(idpel);
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
//    @RequestMapping(value = "**/ambil601BelumLunas.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambil601BelumLunas(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
//                                      @RequestParam(value = "awal", defaultValue = "")Date awal,
//                                      @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.ambil601BelumLunas(unitUp,awal,akhir);
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
//    @RequestMapping(value = "**/AmbilTul601CetakUlang.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject AmbilTul601CetakUlang(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
//                                      @RequestParam(value = "tglPk", defaultValue = "")Date tglPk,
//                                      @RequestParam(value = "noAwal", defaultValue = "")Date noAwal,
//                                      @RequestParam(value = "noAkhir", defaultValue = "")Integer noAkhir) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.AmbilTul601CetakUlang(unitUp,tglPk,noAwal,noAkhir);
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
//    @RequestMapping(value = "**/AmbilTul601Lampiran.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject AmbilTul601Lampiran(@RequestParam(value = "nama", defaultValue = "")String nama,
//                                      @RequestParam(value = "tglPk", defaultValue = "")Date tglPk,
//                                      @RequestParam(value = "noTul", defaultValue = "")Integer noTul) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.AmbilTul601Lampiran(nama,tglPk,noTul);
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
//    //---- Tul VI-03
//
//    @RequestMapping(value = "**/ambilNomerTulVI03.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilNomerTulVI03(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.ambilNomerTulVI03(unitUp);
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
//    @RequestMapping(value = "**/AmbilTul603.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject AmbilTul603(@RequestParam(value = "is60hari", defaultValue = "")Boolean is60hari,
//                                   @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
//                                   @RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.AmbilTul603(is60hari,unitUp,sqlKriteria);
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
//    @RequestMapping(value = "**/insertTulVI03.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject insertTulVI03(@RequestParam(value = "No_60", defaultValue = "")Integer No_60,
//                                   @RequestParam(value = "no_601", defaultValue = "")Integer no_601,
//                                   @RequestParam(value = "UnitUP", defaultValue = "")String UnitUP,
//                                   @RequestParam(value = "ThBlRek", defaultValue = "")String ThBlRek,
//                                   @RequestParam(value = "IdPelanggan", defaultValue = "")String IdPelanggan,
//                                   @RequestParam(value = "NoKontrak", defaultValue = "")String NoKontrak,
//                                   @RequestParam(value = "NoKontrol", defaultValue = "")String NoKontrol,
//                                   @RequestParam(value = "Nama", defaultValue = "")String Nama,
//                                   @RequestParam(value = "Alamat", defaultValue = "")String Alamat,
//                                   @RequestParam(value = "ThBlRek_akhir", defaultValue = "")String ThBlRek_akhir,
//                                   @RequestParam(value = "Lembar_603", defaultValue = "")String Lembar_603,
//                                   @RequestParam(value = "Tagihan_603", defaultValue = "")String Tagihan_603,
//                                   @RequestParam(value = "NOtul603", defaultValue = "")String NOtul603,
//                                   @RequestParam(value = "NOtul601", defaultValue = "")String NOtul601,
//                                   @RequestParam(value = "tglTul601", defaultValue = "")Date tglTul601){
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.insertTulVI03(No_60,no_601,UnitUP,ThBlRek,IdPelanggan,NoKontrak,NoKontrol,
//                    Nama,Alamat,ThBlRek_akhir,Lembar_603,Tagihan_603,NOtul603,NOtul601,tglTul601);
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
//    @RequestMapping(value = "**/ambilCetakKertasTulVI.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilCetakKertasTulVI() {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.ambilCetakKertasTulVI();
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
//    //---- Pemutusan Penyambungan
//
//    @RequestMapping(value = "**/ambilDetailTul601.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilDetailTul601(@RequestParam(value = "strtgl", defaultValue = "")String strtgl,
//                                   @RequestParam(value = "noTul", defaultValue = "")String noTul) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.ambilDetailTul601(strtgl,noTul);
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
//    @RequestMapping(value = "**/simpanPutus.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject simpanPutus(@RequestParam(value = "tglPutus", defaultValue = "")Date tglPutus,
//                           @RequestParam(value = "namaPutus", defaultValue = "")String namaPutus,
//                           @RequestParam(value = "lwbp", defaultValue = "")String lwbp,
//                           @RequestParam(value = "wbp", defaultValue = "")String wbp,
//                           @RequestParam(value = "kvarh", defaultValue = "")String kvarh,
//                           @RequestParam(value = "tgl601", defaultValue = "")Date tgl601,
//                           @RequestParam(value = "no601", defaultValue = "")String no601,
//                           @RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.simpanPutus(tglPutus,namaPutus,lwbp,wbp,kvarh,tgl601,no601,unitUp);
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
//    @RequestMapping(value = "**/simpanSambung.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject simpanSambung(@RequestParam(value = "tglsambung", defaultValue = "")Date tglsambung,
//                                   @RequestParam(value = "namasambung", defaultValue = "")String namasambung,
//                                   @RequestParam(value = "lwbp", defaultValue = "")String lwbp,
//                                   @RequestParam(value = "wbp", defaultValue = "")String wbp,
//                                   @RequestParam(value = "kvarh", defaultValue = "")String kvarh,
//                                   @RequestParam(value = "tgl601", defaultValue = "")Date tgl601,
//                                   @RequestParam(value = "no601", defaultValue = "")String no601,
//                                   @RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.simpanSambung(tglsambung,namasambung,lwbp,wbp,kvarh,tgl601,no601,unitUp);
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
//    @RequestMapping(value = "**/AmbilBuatCetakTul603.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject AmbilBuatCetakTul603(@RequestParam(value = "txtIdpel", defaultValue = "")String txtIdpel,
//                                   @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
//                                   @RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.AmbilBuatCetakTul603(txtIdpel,unitUp,sqlKriteria);
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
//    @RequestMapping(value = "**/AmbilBuatCetakUlangTul603.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject AmbilBuatCetakUlangTul603(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
//                                   @RequestParam(value = "TglPk", defaultValue = "")Date TglPk,
//                                   @RequestParam(value = "noTul", defaultValue = "")Integer noTul) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.AmbilBuatCetakUlangTul603(unitUp,TglPk,noTul);
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
//    //---- Penanganan Petugas
//
//    @RequestMapping(value = "**/simpanGroup.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject simpanGroup(@RequestParam(value = "unitup", defaultValue = "")String unitup,
//                                   @RequestParam(value = "namagroup", defaultValue = "")String namagroup,
//                                   @RequestParam(value = "deskripsi", defaultValue = "")String deskripsi,
//                                   @RequestParam(value = "jenisgroup", defaultValue = "")String jenisgroup,
//                                   @RequestParam(value = "statusaktif", defaultValue = "")String statusaktif,
//                                   @RequestParam(value = "created_by", defaultValue = "")String created_by) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.simpanGroup(unitup,namagroup,deskripsi,jenisgroup,statusaktif,created_by);
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
//    @RequestMapping(value = "**/simpanPetugas.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject simpanPetugas(@RequestParam(value = "unitup", defaultValue = "")String unitup,
//                                   @RequestParam(value = "namapetugas", defaultValue = "")String namapetugas,
//                                   @RequestParam(value = "keterangan", defaultValue = "")String keterangan,
//                                   @RequestParam(value = "namagroup", defaultValue = "")String namagroup,
//                                   @RequestParam(value = "statusaktif", defaultValue = "")String statusaktif,
//                                   @RequestParam(value = "created_by", defaultValue = "")String created_by) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.simpanPetugas(unitup,namapetugas,keterangan,namagroup,statusaktif,created_by);
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
//    @RequestMapping(value = "**/lihatGroup.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject lihatGroup() {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.lihatGroup();
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
//    @RequestMapping(value = "**/lihatPetugas.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject lihatPetugas() {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.lihatPetugas();
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
//    @RequestMapping(value = "**/nonAktifGroup.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject nonAktifGroup(@RequestParam(value = "group", defaultValue = "")String group) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.nonAktifGroup(group);
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
//    @RequestMapping(value = "**/nonAktifPetugas.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject nonAktifPetugas(@RequestParam(value = "petugas", defaultValue = "")String petugas) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.nonAktifPetugas(petugas);
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
//    @RequestMapping(value = "**/ambilPetugasWaskit.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilPetugasWaskit() {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.ambilPetugasWaskit();
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
//    @RequestMapping(value = "**/ambilGroupPetugas.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject ambilGroupPetugas() {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.ambilGroupPetugas();
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
//    @RequestMapping(value = "**/simpanPenugasan.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject simpanPenugasan(@RequestParam(value = "unitup", defaultValue = "")String unitup,
//                                   @RequestParam(value = "no_pk_sambung", defaultValue = "")String no_pk_sambung,
//                                   @RequestParam(value = "pemberi_material", defaultValue = "")String pemberi_material,
//                                   @RequestParam(value = "no_pk_tul6", defaultValue = "")String no_pk_tul6,
//                                   @RequestParam(value = "petugas_sambung", defaultValue = "")String petugas_sambung,
//                                   @RequestParam(value = "material1", defaultValue = "")String material1,
//                                   @RequestParam(value = "material2", defaultValue = "")String material2,
//                                   @RequestParam(value = "material3", defaultValue = "")String material3,
//                                   @RequestParam(value = "keterangan", defaultValue = "")String keterangan,
//                                   @RequestParam(value = "created_by", defaultValue = "")String created_by) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.simpanPenugasan(unitup,no_pk_sambung,pemberi_material,no_pk_tul6,
//                                petugas_sambung,material1,material2,material3,keterangan,created_by);
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
//    @RequestMapping(value = "**/hapusPenugasan.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject hapusPenugasan(@RequestParam(value = "noPkSambung", defaultValue = "")String noPkSambung) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.hapusPenugasan(noPkSambung);
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
//    @RequestMapping(value = "**/lihatPenugasan.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject lihatPenugasan(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.lihatPenugasan(unitUp);
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
//    //---- Distribusi PK per-Petugas
//
//    @RequestMapping(value = "**/simpanDistribusiPKPutus.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject simpanDistribusiPKPutus(@RequestParam(value = "unitup", defaultValue = "")String unitup,
//                                       @RequestParam(value = "tgltul", defaultValue = "")String tgltul,
//                                       @RequestParam(value = "notul", defaultValue = "")String noTul,
//                                       @RequestParam(value = "iKodePetugas", defaultValue = "")String iKodePetugas,
//                                       @RequestParam(value = "petugas", defaultValue = "")String petugas) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.simpanDistribusiPKPutus(unitup,tgltul,noTul,iKodePetugas,petugas);
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
//    @RequestMapping(value = "**/simpanDistribusiPKBongkar.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject simpanDistribusiPKBongkar(@RequestParam(value = "unitup", defaultValue = "")String unitup,
//                                   @RequestParam(value = "tgltul", defaultValue = "")String tgltul,
//                                   @RequestParam(value = "notul", defaultValue = "")String noTul,
//                                   @RequestParam(value = "iKodePetugas", defaultValue = "")String iKodePetugas,
//                                   @RequestParam(value = "petugas", defaultValue = "")String petugas) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.simpanDistribusiPKBongkar(unitup,tgltul,noTul,iKodePetugas,petugas);
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
//    @RequestMapping(value = "**/lihatDistribusiPKPutus.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject lihatDistribusiPKPutus(@RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.lihatDistribusiPKPutus(sqlKriteria);
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
//    @RequestMapping(value = "**/lihatDistribusiPKBongkar.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject lihatDistribusiPKBongkar(@RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.lihatDistribusiPKBongkar(sqlKriteria);
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
//    @RequestMapping(value = "**/AmbilTul601_incl_sdh_ctk.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject AmbilTul601_incl_sdh_ctk(@RequestParam(value = "unitup", defaultValue = "")String unitup,
//                                        @RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.AmbilTul601_incl_sdh_ctk(unitup,sqlKriteria);
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
//    //---- ### END WASKIT ####################################################################################
//
//
//    //---- ### START BELI REKENING ANJA ####################################################################################
//
//
//    @RequestMapping(value = "**/beliAnja_TampilGrid.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject beliAnja_TampilGrid(@RequestParam(value = "unitup", defaultValue = "")String unitup,
//                                   @RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.beliAnja_TampilGrid(unitup,sqlKriteria);
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
//    @RequestMapping(value = "**/beliAnja_LunasiDPP21.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject beliAnja_LunasiDPP21(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
//                                   @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
//                                   @RequestParam(value = "tTglBayar", defaultValue = "")String tTglBayar,
//                                   @RequestParam(value = "tKdPP", defaultValue = "")String tKdPP,
//                                   @RequestParam(value = "tKdPembayar", defaultValue = "")String tKdPembayar) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.beliAnja_LunasiDPP21(dtrans,tTransaksiBy,tTglBayar,tKdPP,tKdPembayar);
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
//    @RequestMapping(value = "**/rptVIEW_BA21_ANJA.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject rptVIEW_BA21_ANJA(@RequestParam(value = "unitup", defaultValue = "")String unitup,
//                                    @RequestParam(value = "tgltransaksi", defaultValue = "")String tgltransaksi,
//                                    @RequestParam(value = "tglbayar", defaultValue = "")String tglbayar,
//                                    @RequestParam(value = "kdpp", defaultValue = "")String kdpp,
//                                    @RequestParam(value = "transaksiby", defaultValue = "")String transaksiby) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.rptVIEW_BA21_ANJA(unitup,tgltransaksi,tglbayar,kdpp,transaksiby);
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
//    @RequestMapping(value = "**/rptVIEW_BA21Daftar_ANJA.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject rptVIEW_BA21Daftar_ANJA(@RequestParam(value = "unitup", defaultValue = "")String unitup,
//                                    @RequestParam(value = "tgltransaksi", defaultValue = "")String tgltransaksi,
//                                    @RequestParam(value = "tglbayar", defaultValue = "")String tglbayar,
//                                    @RequestParam(value = "tKdPP", defaultValue = "")String tKdPP,
//                                    @RequestParam(value = "transaksiby", defaultValue = "")String transaksiby) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.rptVIEW_BA21Daftar_ANJA(unitup,tgltransaksi,tglbayar,tKdPP,transaksiby);
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
//    //---- ### END BELI REKENING ANJA ####################################################################################
//
//
//    //---- ### START UPLOAD LUNAS REKENING ANJA ####################################################################################
//
//    @RequestMapping(value = "**/SetData_21LUNASIANJA.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject SetData_21LUNASIANJA(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
//                                    @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
//                                    @RequestParam(value = "tTglBayar", defaultValue = "")String tTglBayar,
//                                    @RequestParam(value = "tKdPP", defaultValue = "")String tKdPP) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.SetData_21LUNASIANJA(dtrans,tTransaksiBy,tTglBayar,tKdPP);
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
//    @RequestMapping(value = "**/SetData_21INSERTANJA.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject SetData_21INSERTANJA(@RequestParam(value = "dtrans", defaultValue = "")Map<String, Object> dtrans,
//                                    @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.SetData_21INSERTANJA(dtrans,tTransaksiBy);
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
//    @RequestMapping(value = "**/DeleteDPHOFFLINE.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject DeleteDPHOFFLINE(@RequestParam(value = "dr", defaultValue = "")Map<String, Object> dr,
//                                    @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.DeleteDPHOFFLINE(dr,tTransaksiBy);
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
//    @RequestMapping(value = "**/InsertTempDPHOFFLINE.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject InsertTempDPHOFFLINE(@RequestParam(value = "dr", defaultValue = "")Map<String, Object> dr,
//                                    @RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.InsertTempDPHOFFLINE(dr,tTransaksiBy);
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
//    @RequestMapping(value = "**/SetData_21UPDATEANJA.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject SetData_21UPDATEANJA(@RequestParam(value = "tTransaksiBy", defaultValue = "")String tTransaksiBy,
//                                    @RequestParam(value = "tTglBayar", defaultValue = "")String tTglBayar,
//                                    @RequestParam(value = "tKdPP", defaultValue = "")String tKdPP) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.SetData_21UPDATEANJA(tTransaksiBy,tTglBayar,tKdPP);
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
//    @RequestMapping(value = "**/Convert2SQL_DKRP.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject Convert2SQL_DKRP(@RequestParam(value = "Value", defaultValue = "")Object Value) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.Convert2SQL_DKRP(Value);
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
//    @RequestMapping(value = "**/Convert2SQL_DKRP.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject Convert2SQL_DKRP(@RequestParam(value = "Value", defaultValue = "")Object Value,
//                                    @RequestParam(value = "UsedLongDate", defaultValue = "")Boolean UsedLongDate) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.Convert2SQL_DKRP(Value,UsedLongDate);
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
//   @RequestMapping(value = "**/rptVIEW_BA21_LUNASIANJA.json", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JSONObject rptVIEW_BA21_LUNASIANJA(@RequestParam(value = "unitup", defaultValue = "")String unitup,
//                                    @RequestParam(value = "tgltransaksi", defaultValue = "")String tgltransaksi,
//                                    @RequestParam(value = "tglbayar", defaultValue = "")String tglbayar,
//                                    @RequestParam(value = "tKdPP", defaultValue = "")String tKdPP,
//                                    @RequestParam(value = "transaksiby", defaultValue = "")String transaksiby) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        JSONObject obj = new JSONObject();
//        StringWriter out = new StringWriter();
//
//        String retVal = "Init";
//        try {
//            retValue=  ws_anjaDao.rptVIEW_BA21_LUNASIANJA(unitup,tgltransaksi,tglbayar,tKdPP,transaksiby);
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
//    //---- ### END UPLOAD LUNAS REKENING ANJA ####################################################################################

}
