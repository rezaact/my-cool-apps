package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.ws_tul6waskitDao;
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
public class Ws_tul6waskitController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_tul6waskitController.class);

    @Autowired
    private ws_tul6waskitDao ws_tul6waskitDao;

    @RequestMapping(value = "**/Ws_Tul6Waskit/sp_waskit_verifikasi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject sp_waskit_verifikasi(@RequestParam(value = "nav", defaultValue = "")Integer nav) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.sp_waskit_verifikasi(nav);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

   @RequestMapping(value = "**/Ws_Tul6Waskit/sp_waskit_verifikasi_up.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject sp_waskit_verifikasi_up(@RequestParam(value = "nav", defaultValue = "")Integer nav,
                                       @RequestParam(value = "unitup", defaultValue = "")String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.sp_waskit_verifikasi_up(nav,unitup);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //---tambahan cari stand di sorekbaru terakhir dan saat putus

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilstand_sorekakhir.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilstand_sorekakhir(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                       @RequestParam(value = "tgl_tul601", defaultValue = "")String tgl_tul601,
                                       @RequestParam(value = "no_tul601", defaultValue = "")String no_tul601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilstand_sorekakhir(unitUp,tgl_tul601,no_tul601);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

      @RequestMapping(value = "**/Ws_Tul6Waskit/ambilstand_putus.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilstand_putus(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                     @RequestParam(value = "tgl_tul601", defaultValue = "")String tgl_tul601,
                                     @RequestParam(value = "no_tul601", defaultValue = "")String no_tul601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilstand_putus(unitUp,tgl_tul601,no_tul601);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }
    //---end tambahan cari stand di sorekbaru terakhir

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilNomerTulVI01.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNomerTulVI01(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilNomerTulVI01(unitUp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/insertTulVI01.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject insertTulVI01(@RequestParam(value = "No_60", defaultValue = "")Integer No_60,
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
            retValue=  ws_tul6waskitDao.insertTulVI01(No_60,UnitUP,ThBlRek,IdPelanggan,NoKontrak,NoKontrol,Nama,Alamat,ThBlRek_akhir,Lembar_601,Tagihan_601,NOtul601);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilTul601.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul601(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                           @RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilTul601(unitUp,sqlKriteria);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilTul601_Deposit.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul601_Deposit(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                           @RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilTul601_Deposit(unitUp,sqlKriteria);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilTul601_incl_sdh_ctk.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul601_incl_sdh_ctk(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                   @RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilTul601_incl_sdh_ctk(unitUp,sqlKriteria);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilTul601_incl_sdh_ctk_Deposit.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul601_incl_sdh_ctk_Deposit(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                   @RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilTul601_incl_sdh_ctk_Deposit(unitUp,sqlKriteria);
            obj.put("result", retValue);
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
    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilDaftarPantauCetak603.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDaftarPantauCetak603(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                         @RequestParam(value = "awal", defaultValue = "")Date awal,
                                         @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilDaftarPantauCetak603(unitUp,awal,akhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilDaftarPantauCetak603Lunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDaftarPantauCetak603Lunas(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                         @RequestParam(value = "awal", defaultValue = "")Date awal,
                                         @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilDaftarPantauCetak603Lunas(unitUp,awal,akhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilRekapPantauCetak603.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilRekapPantauCetak603(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                         @RequestParam(value = "awal", defaultValue = "")Date awal,
                                         @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilRekapPantauCetak603(unitUp,awal,akhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilRekapPantauCetak603lunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilRekapPantauCetak603lunas(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                         @RequestParam(value = "awal", defaultValue = "")Date awal,
                                         @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilRekapPantauCetak603lunas(unitUp,awal,akhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambil603BelumLunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambil603BelumLunas(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                         @RequestParam(value = "awal", defaultValue = "")Date awal,
                                         @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambil603BelumLunas(unitUp,awal,akhir);
            obj.put("result", retValue);
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
    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilDaftarPantauCetak601.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDaftarPantauCetak601(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                  @RequestParam(value = "awal", defaultValue = "")Date awal,
                                  @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilDaftarPantauCetak601(unitUp,awal,akhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilDaftarPantauCetak601_kriteria.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDaftarPantauCetak601_kriteria(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                         @RequestParam(value = "awal", defaultValue = "")Date awal,
                                         @RequestParam(value = "akhir", defaultValue = "")Date akhir,
                                         @RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilDaftarPantauCetak601_kriteria(unitUp,awal,akhir,sqlKriteria);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilRekapPantauCetak601.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilRekapPantauCetak601(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                         @RequestParam(value = "awal", defaultValue = "")Date awal,
                                         @RequestParam(value = "akhir", defaultValue = "")Date akhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilRekapPantauCetak601(unitUp,awal,akhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilRekapPantauCetak601_kriteria.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilRekapPantauCetak601_kriteria(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                                  @RequestParam(value = "awal", defaultValue = "")Date awal,
                                                  @RequestParam(value = "akhir", defaultValue = "")Date akhir,
                                                  @RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilRekapPantauCetak601_kriteria(unitUp,awal,akhir,sqlKriteria);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilDaftar601Lunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDaftar601Lunas(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                                 @RequestParam(value = "awalPk", defaultValue = "")Date awalPk,
                                                 @RequestParam(value = "akhirPk", defaultValue = "")Date akhirPk,
                                                 @RequestParam(value = "awalLns", defaultValue = "")Date awalLns,
                                                 @RequestParam(value = "akhirLns", defaultValue = "")Date akhirLns,
                                                 @RequestParam(value = "kriteria", defaultValue = "")String kriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilDaftar601Lunas(unitUp,awalPk,akhirPk,awalLns,akhirLns,kriteria);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilDaftar601Lunas_kriteria.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDaftar601Lunas_kriteria(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                   @RequestParam(value = "awalPk", defaultValue = "")Date awalPk,
                                   @RequestParam(value = "akhirPk", defaultValue = "")Date akhirPk,
                                   @RequestParam(value = "awalLns", defaultValue = "")Date awalLns,
                                   @RequestParam(value = "akhirLns", defaultValue = "")Date akhirLns,
                                   @RequestParam(value = "kriteria", defaultValue = "")String kriteria,
                                   @RequestParam(value = "sqlkriteria", defaultValue = "")String sqlkriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilDaftar601Lunas_kriteria(unitUp,awalPk,akhirPk,awalLns,akhirLns,kriteria,sqlkriteria);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilRekap601Lunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilRekap601Lunas(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                            @RequestParam(value = "awalPk", defaultValue = "")Date awalPk,
                                            @RequestParam(value = "akhirPk", defaultValue = "")Date akhirPk,
                                            @RequestParam(value = "awalLns", defaultValue = "")Date awalLns,
                                            @RequestParam(value = "akhirLns", defaultValue = "")Date akhirLns) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilRekap601Lunas(unitUp,awalPk,akhirPk,awalLns,akhirLns);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilRekap601Lunas_kriteria.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilRekap601Lunas_kriteria(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                            @RequestParam(value = "awalPk", defaultValue = "")Date awalPk,
                                            @RequestParam(value = "akhirPk", defaultValue = "")Date akhirPk,
                                            @RequestParam(value = "awalLns", defaultValue = "")Date awalLns,
                                            @RequestParam(value = "akhirLns", defaultValue = "")Date akhirLns,
                                            @RequestParam(value = "sqlkriteria", defaultValue = "")String sqlkriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilRekap601Lunas_kriteria(unitUp,awalPk,akhirPk,awalLns,akhirLns,sqlkriteria);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilTulVIperNamaPutus.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilTulVIperNamaPutus(@RequestParam(value = "nama", defaultValue = "")String nama,
                                           @RequestParam(value = "tglAwal", defaultValue = "")Date tglAwal,
                                           @RequestParam(value = "tglAkhir", defaultValue = "")Date tglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilTulVIperNamaPutus(nama,tglAwal,tglAkhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilDetailTulVIperNamaPetugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDetailTulVIperNamaPetugas(@RequestParam(value = "nama", defaultValue = "")String nama,
                                      @RequestParam(value = "tglAwal", defaultValue = "")Date tglAwal,
                                      @RequestParam(value = "tglAkhir", defaultValue = "")Date tglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilDetailTulVIperNamaPetugas(nama,tglAwal,tglAkhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilTulVIRekapKinerja.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilTulVIRekapKinerja(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                                              @RequestParam(value = "tglAwal", defaultValue = "")Date tglAwal,
                                              @RequestParam(value = "tglAkhir", defaultValue = "")Date tglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilTulVIRekapKinerja(unitup,tglAwal,tglAkhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

   @RequestMapping(value = "**/Ws_Tul6Waskit/ambilTulVIperIdPel.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilTulVIperIdPel(@RequestParam(value = "idpel", defaultValue = "")String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilTulVIperIdPel(idpel);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/ambil601BelumLunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambil601BelumLunas(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                      @RequestParam(value = "tglAwal", defaultValue = "")Date tglAwal,
                                      @RequestParam(value = "tglAkhir", defaultValue = "")Date tglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambil601BelumLunas(unitUp,tglAwal,tglAkhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

     @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilTul601CetakUlang.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul601CetakUlang(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                  @RequestParam(value = "tglPk", defaultValue = "")Date tglPk,
                                  @RequestParam(value = "noAwal", defaultValue = "")Integer noAwal,
                                  @RequestParam(value = "noAkhir", defaultValue = "")Integer noAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilTul601CetakUlang(unitUp,tglPk,noAwal,noAkhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //---tambahan cetak PK Penyambungan Weleri 20090115

    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilTul601Penyambungan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul601Penyambungan(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                     @RequestParam(value = "tglPk", defaultValue = "")Date tglPk,
                                     @RequestParam(value = "noAwal", defaultValue = "")Integer noAwal,
                                     @RequestParam(value = "noAkhir", defaultValue = "")Integer noAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilTul601Penyambungan(unitUp,tglPk,noAwal,noAkhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //---end tambahan cetak PK Penyambungan

    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilTul601CetakUlang_Deposit.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul601CetakUlang_Deposit(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                       @RequestParam(value = "tglPk", defaultValue = "")Date tglPk,
                                       @RequestParam(value = "noAwal", defaultValue = "")Integer noAwal,
                                       @RequestParam(value = "noAkhir", defaultValue = "")Integer noAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilTul601CetakUlang_Deposit(unitUp,tglPk,noAwal,noAkhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilTul601CetakUlangKriteria.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul601CetakUlangKriteria(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                             @RequestParam(value = "tglPk", defaultValue = "")Date tglPk,
                                             @RequestParam(value = "noAwal", defaultValue = "")Integer noAwal,
                                             @RequestParam(value = "noAkhir", defaultValue = "")Integer noAkhir,
                                             @RequestParam(value = "tglpk2", defaultValue = "")Date tglpk2,
                                             @RequestParam(value = "kolok", defaultValue = "")String kolok) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilTul601CetakUlangKriteria(unitUp,tglPk,noAwal,noAkhir,tglpk2,kolok);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }



    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilTul601CetakUlangKriteria_Deposit.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul601CetakUlangKriteria_Deposit(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                             @RequestParam(value = "tglPk", defaultValue = "")Date tglPk,
                                             @RequestParam(value = "noAwal", defaultValue = "")Integer noAwal,
                                             @RequestParam(value = "noAkhir", defaultValue = "")Integer noAkhir,
                                             @RequestParam(value = "tglpk2", defaultValue = "")Date tglpk2,
                                             @RequestParam(value = "kolok", defaultValue = "")String kolok) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilTul601CetakUlangKriteria_Deposit(unitUp,tglPk,noAwal,noAkhir,tglpk2,kolok);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilTul601Lampiran.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul601Lampiran(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                                     @RequestParam(value = "tglPk", defaultValue = "")Date tglPk,
                                                     @RequestParam(value = "noTul", defaultValue = "")Integer noTul) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilTul601Lampiran(unitUp,tglPk,noTul);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilTul601LampiranKriteria.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul601LampiranKriteria(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                                     @RequestParam(value = "tglPk", defaultValue = "")Date tglPk,
                                                     @RequestParam(value = "noTul", defaultValue = "")Integer noTul,
                                                     @RequestParam(value = "tglpk2", defaultValue = "")Date tglpk2,
                                                     @RequestParam(value = "kolok", defaultValue = "")String kolok) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilTul601LampiranKriteria(unitUp,tglPk,noTul,tglpk2,kolok);
            obj.put("result", retValue);
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
    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilNomerTulVI03.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilNomerTulVI03(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilNomerTulVI03(unitUp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilTul603.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul603(@RequestParam(value = "is60hari", defaultValue = "")Boolean is60hari,
                                 @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                 @RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilTul603(is60hari,unitUp,sqlKriteria);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilTul603_Incl_Sdhcetak.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul603_Incl_Sdhcetak(@RequestParam(value = "is60hari", defaultValue = "")Boolean is60hari,
                           @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                           @RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilTul603_Incl_Sdhcetak(is60hari,unitUp,sqlKriteria);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }



    @RequestMapping(value = "**/Ws_Tul6Waskit/insertTulVI03.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject insertTulVI03(@RequestParam(value = "No_60", defaultValue = "")Integer No_60,
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
                             @RequestParam(value = "NOtul603", defaultValue = "")String NOtul603,
                             @RequestParam(value = "NOtul601", defaultValue = "")String NOtul601,
                             @RequestParam(value = "tglTul601", defaultValue = "")Date tglTul601) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.insertTulVI03( No_60,
                                                       no_601,
                                                       UnitUP,
                                                       ThBlRek,
                                                       IdPelanggan,
                                                       NoKontrak,
                                                       NoKontrol,
                                                       Nama,
                                                       Alamat,
                                                       ThBlRek_akhir,
                                                       Lembar_603,
                                                       Tagihan_603,
                                                       NOtul603,
                                                       NOtul601,
                                                       tglTul601);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilCetakKertasTulVI.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilCetakKertasTulVI() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilCetakKertasTulVI();
            obj.put("result", retValue);
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

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilDetailTul601.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDetailTul601(@RequestParam(value = "strtgl", defaultValue = "")String strtgl,
                                         @RequestParam(value = "noTul", defaultValue = "")String noTul,
                                         @RequestParam(value = "unitup", defaultValue = "")String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilDetailTul601(strtgl,noTul,unitup);
            obj.put("result", retValue);
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
    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilDetailTul603.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDetailTul603(@RequestParam(value = "strtgl", defaultValue = "")String strtgl,
                                 @RequestParam(value = "noTul", defaultValue = "")String noTul,
                                 @RequestParam(value = "unitup", defaultValue = "")String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilDetailTul603(strtgl,noTul,unitup);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilDetailTul601SdhPutus.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDetailTul601SdhPutus(@RequestParam(value = "strtgl", defaultValue = "")String strtgl,
                                 @RequestParam(value = "noTul", defaultValue = "")String noTul,
                                 @RequestParam(value = "unitup", defaultValue = "")String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilDetailTul601SdhPutus(strtgl,noTul,unitup);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilDetailTul601SdhPutusLunas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDetailTul601SdhPutusLunas(@RequestParam(value = "strtgl", defaultValue = "")String strtgl,
                                 @RequestParam(value = "noTul", defaultValue = "")String noTul,
                                 @RequestParam(value = "unitup", defaultValue = "")String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilDetailTul601SdhPutusLunas(strtgl,noTul,unitup);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/simpanPutus.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanPutus(@RequestParam(value = "tglPutus", defaultValue = "")Date tglPutus,
                           @RequestParam(value = "namaPutus", defaultValue = "")String namaPutus,
                           @RequestParam(value = "lwbp", defaultValue = "")String lwbp,
                           @RequestParam(value = "wbp", defaultValue = "")String wbp,
                           @RequestParam(value = "kvarh", defaultValue = "")String kvarh,
                           @RequestParam(value = "tgl601", defaultValue = "")Date tgl601,
                           @RequestParam(value = "no601", defaultValue = "")String no601,
                           @RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.simpanPutus( tglPutus,
                                                     namaPutus,
                                                     lwbp,
                                                     wbp,
                                                     kvarh,
                                                     tgl601,
                                                     no601,
                                                     unitUp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }
    @RequestMapping(value = "**/Ws_Tul6Waskit/simpanSambung.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanSambung(@RequestParam(value = "tglsambung", defaultValue = "")Date tglsambung,
                           @RequestParam(value = "namasambung", defaultValue = "")String namasambung,
                           @RequestParam(value = "lwbp", defaultValue = "")String lwbp,
                           @RequestParam(value = "wbp", defaultValue = "")String wbp,
                           @RequestParam(value = "kvarh", defaultValue = "")String kvarh,
                           @RequestParam(value = "tgl601", defaultValue = "")Date tgl601,
                           @RequestParam(value = "no601", defaultValue = "")String no601,
                           @RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.simpanSambung( tglsambung,
                                                        namasambung,
                                                        lwbp,
                                                        wbp,
                                                        kvarh,
                                                        tgl601,
                                                        no601,
                                                        unitUp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/simpanBongkar.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanBongkar(@RequestParam(value = "tglbongkar", defaultValue = "")Date tglbongkar,
                             @RequestParam(value = "namabongkar", defaultValue = "")String namabongkar,
                             @RequestParam(value = "lwbp", defaultValue = "")String lwbp,
                             @RequestParam(value = "wbp", defaultValue = "")String wbp,
                             @RequestParam(value = "kvarh", defaultValue = "")String kvarh,
                             @RequestParam(value = "tgl603", defaultValue = "")Date tgl603,
                             @RequestParam(value = "no603", defaultValue = "")String no603,
                             @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                             @RequestParam(value = "tglkode3", defaultValue = "")Date tglkode3,
                             @RequestParam(value = "nokode3", defaultValue = "")String nokode3) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.simpanBongkar(tglbongkar,
                                                      namabongkar,
                                                      lwbp,
                                                      wbp,
                                                      kvarh,
                                                      tgl603,
                                                      no603,
                                                      unitUp,
                                                      tglkode3,
                                                      nokode3);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/UPDATE_DIL_N.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject UPDATE_DIL_N(@RequestParam(value = "p_unitup", defaultValue = "")String p_unitup,
                             @RequestParam(value = "p_idpel", defaultValue = "")String p_idpel,
                             @RequestParam(value = "p_catatby", defaultValue = "")String p_catatby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.UPDATE_DIL_N(p_unitup,
                                                    p_idpel,
                                                    p_catatby);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/UPDATE_DIL_O.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject UPDATE_DIL_O(@RequestParam(value = "p_unitup", defaultValue = "")String p_unitup,
                            @RequestParam(value = "p_idpel", defaultValue = "")String p_idpel,
                            @RequestParam(value = "p_catatby", defaultValue = "")String p_catatby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.UPDATE_DIL_O(p_unitup,
                                                    p_idpel,
                                                    p_catatby);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilBuatCetakTul603.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilBuatCetakTul603(@RequestParam(value = "txtIdpel", defaultValue = "")String txtIdpel,
                                    @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                    @RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilBuatCetakTul603(txtIdpel,
                                                            unitUp,
                                                            sqlKriteria);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilBuatCetakTul603_BA.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilBuatCetakTul603_BA(@RequestParam(value = "txtIdpel", defaultValue = "")String txtIdpel,
                                    @RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                    @RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilBuatCetakTul603_BA(txtIdpel,
                                                                unitUp,
                                                                sqlKriteria);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilBuatCetakUlangTul603.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilBuatCetakUlangTul603(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                       @RequestParam(value = "TglPk", defaultValue = "")Date TglPk,
                                       @RequestParam(value = "noTul", defaultValue = "")Integer noTul) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilBuatCetakUlangTul603(unitUp,
                                                                    TglPk,
                                                                    noTul);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilBuatCetakUlangTul603Kriteria.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilBuatCetakUlangTul603Kriteria(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                                 @RequestParam(value = "TglPk", defaultValue = "")Date TglPk,
                                                 @RequestParam(value = "noTul", defaultValue = "")Integer noTul,
                                                 @RequestParam(value = "TglPk2", defaultValue = "")Date TglPk2,
                                                 @RequestParam(value = "kolok", defaultValue = "")String kolok) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilBuatCetakUlangTul603Kriteria(unitUp,
                                                                          TglPk,
                                                                          noTul,
                                                                          TglPk2,
                                                                          kolok);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //--- Penanganan Petugas

    @RequestMapping(value = "**/Ws_Tul6Waskit/simpanGroup.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanGroup(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                                                 @RequestParam(value = "namagroup", defaultValue = "")String namagroup,
                                                 @RequestParam(value = "deskripsi", defaultValue = "")String deskripsi,
                                                 @RequestParam(value = "jenisgroup", defaultValue = "")String jenisgroup,
                                                 @RequestParam(value = "statusaktif", defaultValue = "")String statusaktif,
                                                 @RequestParam(value = "created_by", defaultValue = "")String created_by) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.simpanGroup( unitup,
                                                        namagroup,
                                                        deskripsi,
                                                        jenisgroup,
                                                        statusaktif,
                                                        created_by);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/simpanPetugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanPetugas(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                           @RequestParam(value = "namapetugas", defaultValue = "")String namapetugas,
                           @RequestParam(value = "keterangan", defaultValue = "")String keterangan,
                           @RequestParam(value = "namagroup", defaultValue = "")String namagroup,
                           @RequestParam(value = "statusaktif", defaultValue = "")String statusaktif,
                           @RequestParam(value = "created_by", defaultValue = "")String created_by) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.simpanPetugas( unitup,
                                                        namapetugas,
                                                        keterangan,
                                                        namagroup,
                                                        statusaktif,
                                                        created_by);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/lihatGroup.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject lihatGroup() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.lihatGroup();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/lihatGroup_ByUnitup.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject lihatGroup_ByUnitup(@RequestParam(value = "sUNITUP", defaultValue = "")String sUNITUP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.lihatGroup_ByUnitup(sUNITUP);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/lihatPetugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject lihatPetugas() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.lihatPetugas();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/lihatPetugas_ByUnitup.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject lihatPetugas_ByUnitup(@RequestParam(value = "sUNITUP", defaultValue = "")String sUNITUP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.lihatPetugas_ByUnitup( sUNITUP);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/nonAktifGroup.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject nonAktifGroup(@RequestParam(value = "group", defaultValue = "")String group) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.nonAktifGroup( group);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/aktifkanGroup.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject aktifkanGroup(@RequestParam(value = "group", defaultValue = "")String group) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.aktifkanGroup( group);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/nonAktifPetugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject nonAktifPetugas(@RequestParam(value = "petugas", defaultValue = "")String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.nonAktifPetugas( petugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/aktifkanPetugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject aktifkanPetugas(@RequestParam(value = "petugas", defaultValue = "")String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.aktifkanPetugas( petugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilPetugasWaskit.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilPetugasWaskit() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilPetugasWaskit();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilPetugasWaskit_up.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilPetugasWaskit_up(@RequestParam(value = "unitup", defaultValue = "")String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilPetugasWaskit_up( unitup);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilPetugasWaskit_up_group.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilPetugasWaskit_up_group(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                                           @RequestParam(value = "group", defaultValue = "")String group) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilPetugasWaskit_up_group( unitup,group);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilGroupPetugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilGroupPetugas() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilGroupPetugas();
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilGroupPetugas_ByUnitup.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilGroupPetugas_ByUnitup(@RequestParam(value = "sUNITUP", defaultValue = "")String sUNITUP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilGroupPetugas_ByUnitup( sUNITUP);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/simpanPenugasan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanPenugasan(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                               @RequestParam(value = "no_pk_sambung", defaultValue = "")String no_pk_sambung,
                               @RequestParam(value = "pemberi_material", defaultValue = "")String pemberi_material,
                               @RequestParam(value = "no_pk_tul6", defaultValue = "")String no_pk_tul6,
                               @RequestParam(value = "petugas_sambung", defaultValue = "")String petugas_sambung,
                               @RequestParam(value = "material1", defaultValue = "")String material1,
                               @RequestParam(value = "material2", defaultValue = "")String material2,
                               @RequestParam(value = "material3", defaultValue = "")String material3,
                               @RequestParam(value = "keterangan", defaultValue = "")String keterangan,
                               @RequestParam(value = "created_by", defaultValue = "")String created_by) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.simpanPenugasan(unitup,
                                                        no_pk_sambung,
                                                        pemberi_material,
                                                        no_pk_tul6,
                                                        petugas_sambung,
                                                        material1,
                                                        material2,
                                                        material3,
                                                        keterangan,
                                                        created_by);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

   @RequestMapping(value = "**/Ws_Tul6Waskit/hapusPenugasan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject hapusPenugasan(@RequestParam(value = "noPkSambung", defaultValue = "")String noPkSambung) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.hapusPenugasan( noPkSambung);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/lihatPenugasan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject lihatPenugasan(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.lihatPenugasan(unitUp);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    //--- Distribusi PK per-Petugas

    @RequestMapping(value = "**/Ws_Tul6Waskit/simpanDistribusiPKPutus.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanDistribusiPKPutus(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                                       @RequestParam(value = "tgltul", defaultValue = "")String tgltul,
                                       @RequestParam(value = "notul", defaultValue = "")String notul,
                                       @RequestParam(value = "iKodePetugas", defaultValue = "")String iKodePetugas,
                                       @RequestParam(value = "petugas", defaultValue = "")String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.simpanDistribusiPKPutus(unitup,
                                                                tgltul,
                                                                notul,
                                                                iKodePetugas,
                                                                petugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/simpanDistribusiPKBongkar.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject simpanDistribusiPKBongkar(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                                       @RequestParam(value = "tgltul", defaultValue = "")String tgltul,
                                       @RequestParam(value = "notul", defaultValue = "")String notul,
                                       @RequestParam(value = "iKodePetugas", defaultValue = "")String iKodePetugas,
                                       @RequestParam(value = "petugas", defaultValue = "")String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.simpanDistribusiPKBongkar(unitup,
                                                                    tgltul,
                                                                    notul,
                                                                    iKodePetugas,
                                                                    petugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/lihatDistribusiPKPutus.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject lihatDistribusiPKPutus(@RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.lihatDistribusiPKPutus(sqlKriteria);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/lihatDistribusiPKBongkar.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject lihatDistribusiPKBongkar(@RequestParam(value = "sqlKriteria", defaultValue = "")String sqlKriteria) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.lihatDistribusiPKBongkar(sqlKriteria);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/getView_ReportPantauTULVI01.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getView_ReportPantauTULVI01(@RequestParam(value = "sTglAwal", defaultValue = "")String sTglAwal,
                                         @RequestParam(value = "sTglAkhir", defaultValue = "")String sTglAkhir,
                                         @RequestParam(value = "sUnitup", defaultValue = "")String sUnitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.getView_ReportPantauTULVI01(sTglAwal,
                                                                    sTglAkhir,
                                                                    sUnitup);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilBuatCetakUlangTul601Kriteria_pkg.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilBuatCetakUlangTul601Kriteria_pkg(@RequestParam(value = "_unitup", defaultValue = "")String _unitup,
                                           @RequestParam(value = "_idpelAwal_A", defaultValue = "")String _idpelAwal_A,
                                           @RequestParam(value = "_idpelAwal_B", defaultValue = "")String _idpelAwal_B,
                                           @RequestParam(value = "_idpelAkhir_A", defaultValue = "")String _idpelAkhir_A,
                                           @RequestParam(value = "_idpelAkhir_B", defaultValue = "")String _idpelAkhir_B,
                                           @RequestParam(value = "_jumlahLembarAwal", defaultValue = "")String _jumlahLembarAwal,
                                           @RequestParam(value = "_jumlahLembarAkhir", defaultValue = "")String _jumlahLembarAkhir,
                                           @RequestParam(value = "_rupiahTagihAwal", defaultValue = "")String _rupiahTagihAwal,
                                           @RequestParam(value = "_rupiahTagihAkhir", defaultValue = "")String _rupiahTagihAkhir,
                                           @RequestParam(value = "_dayaAwal", defaultValue = "")String _dayaAwal,
                                           @RequestParam(value = "_dayaAkhir", defaultValue = "")String _dayaAkhir,
                                           @RequestParam(value = "_kogolAwal", defaultValue = "")String _kogolAwal,
                                           @RequestParam(value = "_kogolAkhir", defaultValue = "")String _kogolAkhir,
                                           @RequestParam(value = "_noRBM", defaultValue = "")String _noRBM,
                                           @RequestParam(value = "_kantorPelayanan", defaultValue = "")String _kantorPelayanan,
                                           @RequestParam(value = "_noGardu", defaultValue = "")String _noGardu,
                                           @RequestParam(value = "_paymentPoint", defaultValue = "")String _paymentPoint,
                                           @RequestParam(value = "_tarip", defaultValue = "")String _tarip,
                                           @RequestParam(value = "_petugasPemutusan", defaultValue = "")String _petugasPemutusan,
                                           @RequestParam(value = "_cekUrutanKolom", defaultValue = "")String _cekUrutanKolom,
                                           @RequestParam(value = "_cekUrutan", defaultValue = "")String _cekUrutan,
                                           @RequestParam(value = "_maxJmlPK", defaultValue = "")String _maxJmlPK,
                                           @RequestParam(value = "_cekCetakanTiap", defaultValue = "")String _cekCetakanTiap
                                           ) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilBuatCetakUlangTul601Kriteria_pkg(_unitup,
                                                                                _idpelAwal_A,
                                                                                _idpelAwal_B,
                                                                                _idpelAkhir_A,
                                                                                _idpelAkhir_B,
                                                                                _jumlahLembarAwal,
                                                                                _jumlahLembarAkhir,
                                                                                _rupiahTagihAwal,
                                                                                _rupiahTagihAkhir,
                                                                                _dayaAwal,
                                                                                _dayaAkhir,
                                                                                _kogolAwal,
                                                                                _kogolAkhir,
                                                                                _noRBM,
                                                                                _kantorPelayanan,
                                                                                _noGardu,
                                                                                _paymentPoint,
                                                                                _tarip,
                                                                                _petugasPemutusan,
                                                                                _cekUrutanKolom,
                                                                                _cekUrutan,
                                                                                _maxJmlPK,
                                                                                _cekCetakanTiap);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilBuatCetakUlangTul603Kriteria_pkg.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilBuatCetakUlangTul603Kriteria_pkg(@RequestParam(value = "_unitup", defaultValue = "")String _unitup,
                                                     @RequestParam(value = "_idpelAwal_A", defaultValue = "")String _idpelAwal_A,
                                                     @RequestParam(value = "_idpelAwal_B", defaultValue = "")String _idpelAwal_B,
                                                     @RequestParam(value = "_idpelAkhir_A", defaultValue = "")String _idpelAkhir_A,
                                                     @RequestParam(value = "_idpelAkhir_B", defaultValue = "")String _idpelAkhir_B,
                                                     @RequestParam(value = "_jumlahLembarAwal", defaultValue = "")String _jumlahLembarAwal,
                                                     @RequestParam(value = "_jumlahLembarAkhir", defaultValue = "")String _jumlahLembarAkhir,
                                                     @RequestParam(value = "_rupiahTagihAwal", defaultValue = "")String _rupiahTagihAwal,
                                                     @RequestParam(value = "_rupiahTagihAkhir", defaultValue = "")String _rupiahTagihAkhir,
                                                     @RequestParam(value = "_dayaAwal", defaultValue = "")String _dayaAwal,
                                                     @RequestParam(value = "_dayaAkhir", defaultValue = "")String _dayaAkhir,
                                                     @RequestParam(value = "_kogolAwal", defaultValue = "")String _kogolAwal,
                                                     @RequestParam(value = "_kogolAkhir", defaultValue = "")String _kogolAkhir,
                                                     @RequestParam(value = "_noRBM", defaultValue = "")String _noRBM,
                                                     @RequestParam(value = "_kantorPelayanan", defaultValue = "")String _kantorPelayanan,
                                                     @RequestParam(value = "_noGardu", defaultValue = "")String _noGardu,
                                                     @RequestParam(value = "_paymentPoint", defaultValue = "")String _paymentPoint,
                                                     @RequestParam(value = "_tarip", defaultValue = "")String _tarip,
                                                     @RequestParam(value = "_petugasPemutusan", defaultValue = "")String _petugasPemutusan,
                                                     @RequestParam(value = "_cekUrutanKolom", defaultValue = "")String _cekUrutanKolom,
                                                     @RequestParam(value = "_cekUrutan", defaultValue = "")String _cekUrutan,
                                                     @RequestParam(value = "_maxJmlPK", defaultValue = "")String _maxJmlPK,
                                                     @RequestParam(value = "_cekCetakanTiap", defaultValue = "")String _cekCetakanTiap,
                                                     @RequestParam(value = "_is60hari", defaultValue = "")String _is60hari
    ) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilBuatCetakUlangTul603Kriteria_pkg(_unitup,
                                                                            _idpelAwal_A,
                                                                            _idpelAwal_B,
                                                                            _idpelAkhir_A,
                                                                            _idpelAkhir_B,
                                                                            _jumlahLembarAwal,
                                                                            _jumlahLembarAkhir,
                                                                            _rupiahTagihAwal,
                                                                            _rupiahTagihAkhir,
                                                                            _dayaAwal,
                                                                            _dayaAkhir,
                                                                            _kogolAwal,
                                                                            _kogolAkhir,
                                                                            _noRBM,
                                                                            _kantorPelayanan,
                                                                            _noGardu,
                                                                            _paymentPoint,
                                                                            _tarip,
                                                                            _petugasPemutusan,
                                                                            _cekUrutanKolom,
                                                                            _cekUrutan,
                                                                            _maxJmlPK,
                                                                            _cekCetakanTiap,
                                                                            _is60hari);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilTul601Penyambungan_pkg.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul601Penyambungan_pkg(@RequestParam(value = "_unitup", defaultValue = "")String _unitup,
                                                     @RequestParam(value = "_idpelAwal_A", defaultValue = "")String _idpelAwal_A,
                                                     @RequestParam(value = "_idpelAwal_B", defaultValue = "")String _idpelAwal_B,
                                                     @RequestParam(value = "_idpelAkhir_A", defaultValue = "")String _idpelAkhir_A,
                                                     @RequestParam(value = "_idpelAkhir_B", defaultValue = "")String _idpelAkhir_B,
                                                     @RequestParam(value = "_jumlahLembarAwal", defaultValue = "")String _jumlahLembarAwal,
                                                     @RequestParam(value = "_jumlahLembarAkhir", defaultValue = "")String _jumlahLembarAkhir,
                                                     @RequestParam(value = "_rupiahTagihAwal", defaultValue = "")String _rupiahTagihAwal,
                                                     @RequestParam(value = "_rupiahTagihAkhir", defaultValue = "")String _rupiahTagihAkhir,
                                                     @RequestParam(value = "_dayaAwal", defaultValue = "")String _dayaAwal,
                                                     @RequestParam(value = "_dayaAkhir", defaultValue = "")String _dayaAkhir,
                                                     @RequestParam(value = "_kogolAwal", defaultValue = "")String _kogolAwal,
                                                     @RequestParam(value = "_kogolAkhir", defaultValue = "")String _kogolAkhir,
                                                     @RequestParam(value = "_noRBM", defaultValue = "")String _noRBM,
                                                     @RequestParam(value = "_kantorPelayanan", defaultValue = "")String _kantorPelayanan,
                                                     @RequestParam(value = "_noGardu", defaultValue = "")String _noGardu,
                                                     @RequestParam(value = "_paymentPoint", defaultValue = "")String _paymentPoint,
                                                     @RequestParam(value = "_tarip", defaultValue = "")String _tarip,
                                                     @RequestParam(value = "_petugasPemutusan", defaultValue = "")String _petugasPemutusan,
                                                     @RequestParam(value = "_cekUrutanKolom", defaultValue = "")String _cekUrutanKolom,
                                                     @RequestParam(value = "_cekUrutan", defaultValue = "")String _cekUrutan,
                                                     @RequestParam(value = "_maxJmlPK", defaultValue = "")String _maxJmlPK,
                                                     @RequestParam(value = "_cekCetakanTiap", defaultValue = "")String _cekCetakanTiap) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilTul601Penyambungan_pkg(_unitup,
                                                                    _idpelAwal_A,
                                                                    _idpelAwal_B,
                                                                    _idpelAkhir_A,
                                                                    _idpelAkhir_B,
                                                                    _jumlahLembarAwal,
                                                                    _jumlahLembarAkhir,
                                                                    _rupiahTagihAwal,
                                                                    _rupiahTagihAkhir,
                                                                    _dayaAwal,
                                                                    _dayaAkhir,
                                                                    _kogolAwal,
                                                                    _kogolAkhir,
                                                                    _noRBM,
                                                                    _kantorPelayanan,
                                                                    _noGardu,
                                                                    _paymentPoint,
                                                                    _tarip,
                                                                    _petugasPemutusan,
                                                                    _cekUrutanKolom,
                                                                    _cekUrutan,
                                                                    _maxJmlPK,
                                                                    _cekCetakanTiap);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilTul601LampiranKriteria_pkg.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul601LampiranKriteria_pkg(@RequestParam(value = "_unitup", defaultValue = "")String _unitup,
                                           @RequestParam(value = "_idpelAwal_A", defaultValue = "")String _idpelAwal_A,
                                           @RequestParam(value = "_idpelAwal_B", defaultValue = "")String _idpelAwal_B,
                                           @RequestParam(value = "_idpelAkhir_A", defaultValue = "")String _idpelAkhir_A,
                                           @RequestParam(value = "_idpelAkhir_B", defaultValue = "")String _idpelAkhir_B,
                                           @RequestParam(value = "_jumlahLembarAwal", defaultValue = "")String _jumlahLembarAwal,
                                           @RequestParam(value = "_jumlahLembarAkhir", defaultValue = "")String _jumlahLembarAkhir,
                                           @RequestParam(value = "_rupiahTagihAwal", defaultValue = "")String _rupiahTagihAwal,
                                           @RequestParam(value = "_rupiahTagihAkhir", defaultValue = "")String _rupiahTagihAkhir,
                                           @RequestParam(value = "_dayaAwal", defaultValue = "")String _dayaAwal,
                                           @RequestParam(value = "_dayaAkhir", defaultValue = "")String _dayaAkhir,
                                           @RequestParam(value = "_kogolAwal", defaultValue = "")String _kogolAwal,
                                           @RequestParam(value = "_kogolAkhir", defaultValue = "")String _kogolAkhir,
                                           @RequestParam(value = "_noRBM", defaultValue = "")String _noRBM,
                                           @RequestParam(value = "_kantorPelayanan", defaultValue = "")String _kantorPelayanan,
                                           @RequestParam(value = "_noGardu", defaultValue = "")String _noGardu,
                                           @RequestParam(value = "_paymentPoint", defaultValue = "")String _paymentPoint,
                                           @RequestParam(value = "_tarip", defaultValue = "")String _tarip,
                                           @RequestParam(value = "_petugasPemutusan", defaultValue = "")String _petugasPemutusan,
                                           @RequestParam(value = "_cekUrutanKolom", defaultValue = "")String _cekUrutanKolom,
                                           @RequestParam(value = "_cekUrutan", defaultValue = "")String _cekUrutan,
                                           @RequestParam(value = "_maxJmlPK", defaultValue = "")String _maxJmlPK,
                                           @RequestParam(value = "_cekCetakanTiap", defaultValue = "")String _cekCetakanTiap) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilTul601LampiranKriteria_pkg(_unitup,
                                                                        _idpelAwal_A,
                                                                        _idpelAwal_B,
                                                                        _idpelAkhir_A,
                                                                        _idpelAkhir_B,
                                                                        _jumlahLembarAwal,
                                                                        _jumlahLembarAkhir,
                                                                        _rupiahTagihAwal,
                                                                        _rupiahTagihAkhir,
                                                                        _dayaAwal,
                                                                        _dayaAkhir,
                                                                        _kogolAwal,
                                                                        _kogolAkhir,
                                                                        _noRBM,
                                                                        _kantorPelayanan,
                                                                        _noGardu,
                                                                        _paymentPoint,
                                                                        _tarip,
                                                                        _petugasPemutusan,
                                                                        _cekUrutanKolom,
                                                                        _cekUrutan,
                                                                        _maxJmlPK,
                                                                        _cekCetakanTiap);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilTul603LampiranKriteria_pkg.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilTul603LampiranKriteria_pkg(@RequestParam(value = "_unitup", defaultValue = "")String _unitup,
                                               @RequestParam(value = "_idpelAwal_A", defaultValue = "")String _idpelAwal_A,
                                               @RequestParam(value = "_idpelAwal_B", defaultValue = "")String _idpelAwal_B,
                                               @RequestParam(value = "_idpelAkhir_A", defaultValue = "")String _idpelAkhir_A,
                                               @RequestParam(value = "_idpelAkhir_B", defaultValue = "")String _idpelAkhir_B,
                                               @RequestParam(value = "_jumlahLembarAwal", defaultValue = "")String _jumlahLembarAwal,
                                               @RequestParam(value = "_jumlahLembarAkhir", defaultValue = "")String _jumlahLembarAkhir,
                                               @RequestParam(value = "_rupiahTagihAwal", defaultValue = "")String _rupiahTagihAwal,
                                               @RequestParam(value = "_rupiahTagihAkhir", defaultValue = "")String _rupiahTagihAkhir,
                                               @RequestParam(value = "_dayaAwal", defaultValue = "")String _dayaAwal,
                                               @RequestParam(value = "_dayaAkhir", defaultValue = "")String _dayaAkhir,
                                               @RequestParam(value = "_kogolAwal", defaultValue = "")String _kogolAwal,
                                               @RequestParam(value = "_kogolAkhir", defaultValue = "")String _kogolAkhir,
                                               @RequestParam(value = "_noRBM", defaultValue = "")String _noRBM,
                                               @RequestParam(value = "_kantorPelayanan", defaultValue = "")String _kantorPelayanan,
                                               @RequestParam(value = "_noGardu", defaultValue = "")String _noGardu,
                                               @RequestParam(value = "_paymentPoint", defaultValue = "")String _paymentPoint,
                                               @RequestParam(value = "_tarip", defaultValue = "")String _tarip,
                                               @RequestParam(value = "_petugasPemutusan", defaultValue = "")String _petugasPemutusan,
                                               @RequestParam(value = "_cekUrutanKolom", defaultValue = "")String _cekUrutanKolom,
                                               @RequestParam(value = "_cekUrutan", defaultValue = "")String _cekUrutan,
                                               @RequestParam(value = "_maxJmlPK", defaultValue = "")String _maxJmlPK,
                                               @RequestParam(value = "_cekCetakanTiap", defaultValue = "")String _cekCetakanTiap,
                                               @RequestParam(value = "_is60hari", defaultValue = "")String _is60hari) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilTul603LampiranKriteria_pkg(_unitup,
                                                                        _idpelAwal_A,
                                                                        _idpelAwal_B,
                                                                        _idpelAkhir_A,
                                                                        _idpelAkhir_B,
                                                                        _jumlahLembarAwal,
                                                                        _jumlahLembarAkhir,
                                                                        _rupiahTagihAwal,
                                                                        _rupiahTagihAkhir,
                                                                        _dayaAwal,
                                                                        _dayaAkhir,
                                                                        _kogolAwal,
                                                                        _kogolAkhir,
                                                                        _noRBM,
                                                                        _kantorPelayanan,
                                                                        _noGardu,
                                                                        _paymentPoint,
                                                                        _tarip,
                                                                        _petugasPemutusan,
                                                                        _cekUrutanKolom,
                                                                        _cekUrutan,
                                                                        _maxJmlPK,
                                                                        _cekCetakanTiap,
                                                                        _is60hari);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/TulVI_Main_Eksekusi601_pkg.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject TulVI_Main_Eksekusi601_pkg(@RequestParam(value = "_unitup", defaultValue = "")String _unitup,
                                               @RequestParam(value = "_idpelAwal_A", defaultValue = "")String _idpelAwal_A,
                                               @RequestParam(value = "_idpelAwal_B", defaultValue = "")String _idpelAwal_B,
                                               @RequestParam(value = "_idpelAkhir_A", defaultValue = "")String _idpelAkhir_A,
                                               @RequestParam(value = "_idpelAkhir_B", defaultValue = "")String _idpelAkhir_B,
                                               @RequestParam(value = "_jumlahLembarAwal", defaultValue = "")String _jumlahLembarAwal,
                                               @RequestParam(value = "_jumlahLembarAkhir", defaultValue = "")String _jumlahLembarAkhir,
                                               @RequestParam(value = "_rupiahTagihAwal", defaultValue = "")String _rupiahTagihAwal,
                                               @RequestParam(value = "_rupiahTagihAkhir", defaultValue = "")String _rupiahTagihAkhir,
                                               @RequestParam(value = "_dayaAwal", defaultValue = "")String _dayaAwal,
                                               @RequestParam(value = "_dayaAkhir", defaultValue = "")String _dayaAkhir,
                                               @RequestParam(value = "_kogolAwal", defaultValue = "")String _kogolAwal,
                                               @RequestParam(value = "_kogolAkhir", defaultValue = "")String _kogolAkhir,
                                               @RequestParam(value = "_noRBM", defaultValue = "")String _noRBM,
                                               @RequestParam(value = "_kantorPelayanan", defaultValue = "")String _kantorPelayanan,
                                               @RequestParam(value = "_noGardu", defaultValue = "")String _noGardu,
                                               @RequestParam(value = "_paymentPoint", defaultValue = "")String _paymentPoint,
                                               @RequestParam(value = "_tarip", defaultValue = "")String _tarip,
                                               @RequestParam(value = "_petugasPemutusan", defaultValue = "")String _petugasPemutusan,
                                               @RequestParam(value = "_cekUrutanKolom", defaultValue = "")String _cekUrutanKolom,
                                               @RequestParam(value = "_cekUrutan", defaultValue = "")String _cekUrutan,
                                               @RequestParam(value = "_maxJmlPK", defaultValue = "")String _maxJmlPK,
                                               @RequestParam(value = "_cekCetakanTiap", defaultValue = "")String _cekCetakanTiap) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.TulVI_Main_Eksekusi601_pkg(_unitup,
                    _idpelAwal_A,
                    _idpelAwal_B,
                    _idpelAkhir_A,
                    _idpelAkhir_B,
                    _jumlahLembarAwal,
                    _jumlahLembarAkhir,
                    _rupiahTagihAwal,
                    _rupiahTagihAkhir,
                    _dayaAwal,
                    _dayaAkhir,
                    _kogolAwal,
                    _kogolAkhir,
                    _noRBM,
                    _kantorPelayanan,
                    _noGardu,
                    _paymentPoint,
                    _tarip,
                    _petugasPemutusan,
                    _cekUrutanKolom,
                    _cekUrutan,
                    _maxJmlPK,
                    _cekCetakanTiap);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/TulVI_Main_Eksekusi601_RowCount_pkg.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject TulVI_Main_Eksekusi601_RowCount_pkg(@RequestParam(value = "_unitup", defaultValue = "")String _unitup,
                                               @RequestParam(value = "_idpelAwal_A", defaultValue = "")String _idpelAwal_A,
                                               @RequestParam(value = "_idpelAwal_B", defaultValue = "")String _idpelAwal_B,
                                               @RequestParam(value = "_idpelAkhir_A", defaultValue = "")String _idpelAkhir_A,
                                               @RequestParam(value = "_idpelAkhir_B", defaultValue = "")String _idpelAkhir_B,
                                               @RequestParam(value = "_jumlahLembarAwal", defaultValue = "")String _jumlahLembarAwal,
                                               @RequestParam(value = "_jumlahLembarAkhir", defaultValue = "")String _jumlahLembarAkhir,
                                               @RequestParam(value = "_rupiahTagihAwal", defaultValue = "")String _rupiahTagihAwal,
                                               @RequestParam(value = "_rupiahTagihAkhir", defaultValue = "")String _rupiahTagihAkhir,
                                               @RequestParam(value = "_dayaAwal", defaultValue = "")String _dayaAwal,
                                               @RequestParam(value = "_dayaAkhir", defaultValue = "")String _dayaAkhir,
                                               @RequestParam(value = "_kogolAwal", defaultValue = "")String _kogolAwal,
                                               @RequestParam(value = "_kogolAkhir", defaultValue = "")String _kogolAkhir,
                                               @RequestParam(value = "_noRBM", defaultValue = "")String _noRBM,
                                               @RequestParam(value = "_kantorPelayanan", defaultValue = "")String _kantorPelayanan,
                                               @RequestParam(value = "_noGardu", defaultValue = "")String _noGardu,
                                               @RequestParam(value = "_paymentPoint", defaultValue = "")String _paymentPoint,
                                               @RequestParam(value = "_tarip", defaultValue = "")String _tarip,
                                               @RequestParam(value = "_petugasPemutusan", defaultValue = "")String _petugasPemutusan,
                                               @RequestParam(value = "_cekUrutanKolom", defaultValue = "")String _cekUrutanKolom,
                                               @RequestParam(value = "_cekUrutan", defaultValue = "")String _cekUrutan,
                                               @RequestParam(value = "_maxJmlPK", defaultValue = "")String _maxJmlPK,
                                               @RequestParam(value = "_cekCetakanTiap", defaultValue = "")String _cekCetakanTiap) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.TulVI_Main_Eksekusi601_RowCount_pkg(_unitup,
                                                                            _idpelAwal_A,
                                                                            _idpelAwal_B,
                                                                            _idpelAkhir_A,
                                                                            _idpelAkhir_B,
                                                                            _jumlahLembarAwal,
                                                                            _jumlahLembarAkhir,
                                                                            _rupiahTagihAwal,
                                                                            _rupiahTagihAkhir,
                                                                            _dayaAwal,
                                                                            _dayaAkhir,
                                                                            _kogolAwal,
                                                                            _kogolAkhir,
                                                                            _noRBM,
                                                                            _kantorPelayanan,
                                                                            _noGardu,
                                                                            _paymentPoint,
                                                                            _tarip,
                                                                            _petugasPemutusan,
                                                                            _cekUrutanKolom,
                                                                            _cekUrutan,
                                                                            _maxJmlPK,
                                                                            _cekCetakanTiap);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }



    @RequestMapping(value = "**/Ws_Tul6Waskit/TulVI_Main_Eksekusi603_pkg.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject TulVI_Main_Eksekusi603_pkg(@RequestParam(value = "_unitup", defaultValue = "")String _unitup,
                                               @RequestParam(value = "_idpelAwal_A", defaultValue = "")String _idpelAwal_A,
                                               @RequestParam(value = "_idpelAwal_B", defaultValue = "")String _idpelAwal_B,
                                               @RequestParam(value = "_idpelAkhir_A", defaultValue = "")String _idpelAkhir_A,
                                               @RequestParam(value = "_idpelAkhir_B", defaultValue = "")String _idpelAkhir_B,
                                               @RequestParam(value = "_jumlahLembarAwal", defaultValue = "")String _jumlahLembarAwal,
                                               @RequestParam(value = "_jumlahLembarAkhir", defaultValue = "")String _jumlahLembarAkhir,
                                               @RequestParam(value = "_rupiahTagihAwal", defaultValue = "")String _rupiahTagihAwal,
                                               @RequestParam(value = "_rupiahTagihAkhir", defaultValue = "")String _rupiahTagihAkhir,
                                               @RequestParam(value = "_dayaAwal", defaultValue = "")String _dayaAwal,
                                               @RequestParam(value = "_dayaAkhir", defaultValue = "")String _dayaAkhir,
                                               @RequestParam(value = "_kogolAwal", defaultValue = "")String _kogolAwal,
                                               @RequestParam(value = "_kogolAkhir", defaultValue = "")String _kogolAkhir,
                                               @RequestParam(value = "_noRBM", defaultValue = "")String _noRBM,
                                               @RequestParam(value = "_kantorPelayanan", defaultValue = "")String _kantorPelayanan,
                                               @RequestParam(value = "_noGardu", defaultValue = "")String _noGardu,
                                               @RequestParam(value = "_paymentPoint", defaultValue = "")String _paymentPoint,
                                               @RequestParam(value = "_tarip", defaultValue = "")String _tarip,
                                               @RequestParam(value = "_petugasPemutusan", defaultValue = "")String _petugasPemutusan,
                                               @RequestParam(value = "_cekUrutanKolom", defaultValue = "")String _cekUrutanKolom,
                                               @RequestParam(value = "_cekUrutan", defaultValue = "")String _cekUrutan,
                                               @RequestParam(value = "_maxJmlPK", defaultValue = "")String _maxJmlPK,
                                               @RequestParam(value = "_cekCetakanTiap", defaultValue = "")String _cekCetakanTiap,
                                               @RequestParam(value = "_is60hari", defaultValue = "")String _is60hari,
                                               @RequestParam(value = "noUrutAwal", defaultValue = "")String noUrutAwal,
                                               @RequestParam(value = "noUrutAkhir", defaultValue = "")String noUrutAkhir) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.TulVI_Main_Eksekusi603_pkg(_unitup,
                                                                    _idpelAwal_A,
                                                                    _idpelAwal_B,
                                                                    _idpelAkhir_A,
                                                                    _idpelAkhir_B,
                                                                    _jumlahLembarAwal,
                                                                    _jumlahLembarAkhir,
                                                                    _rupiahTagihAwal,
                                                                    _rupiahTagihAkhir,
                                                                    _dayaAwal,
                                                                    _dayaAkhir,
                                                                    _kogolAwal,
                                                                    _kogolAkhir,
                                                                    _noRBM,
                                                                    _kantorPelayanan,
                                                                    _noGardu,
                                                                    _paymentPoint,
                                                                    _tarip,
                                                                    _petugasPemutusan,
                                                                    _cekUrutanKolom,
                                                                    _cekUrutan,
                                                                    _maxJmlPK,
                                                                    _cekCetakanTiap,
                                                                    _is60hari,
                                                                    noUrutAwal,
                                                                    noUrutAkhir);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }




    @RequestMapping(value = "**/Ws_Tul6Waskit/TulVI_Main_Eksekusi603_RowCount_pkg.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject TulVI_Main_Eksekusi603_RowCount_pkg(@RequestParam(value = "_unitup", defaultValue = "")String _unitup,
                                               @RequestParam(value = "_idpelAwal_A", defaultValue = "")String _idpelAwal_A,
                                               @RequestParam(value = "_idpelAwal_B", defaultValue = "")String _idpelAwal_B,
                                               @RequestParam(value = "_idpelAkhir_A", defaultValue = "")String _idpelAkhir_A,
                                               @RequestParam(value = "_idpelAkhir_B", defaultValue = "")String _idpelAkhir_B,
                                               @RequestParam(value = "_jumlahLembarAwal", defaultValue = "")String _jumlahLembarAwal,
                                               @RequestParam(value = "_jumlahLembarAkhir", defaultValue = "")String _jumlahLembarAkhir,
                                               @RequestParam(value = "_rupiahTagihAwal", defaultValue = "")String _rupiahTagihAwal,
                                               @RequestParam(value = "_rupiahTagihAkhir", defaultValue = "")String _rupiahTagihAkhir,
                                               @RequestParam(value = "_dayaAwal", defaultValue = "")String _dayaAwal,
                                               @RequestParam(value = "_dayaAkhir", defaultValue = "")String _dayaAkhir,
                                               @RequestParam(value = "_kogolAwal", defaultValue = "")String _kogolAwal,
                                               @RequestParam(value = "_kogolAkhir", defaultValue = "")String _kogolAkhir,
                                               @RequestParam(value = "_noRBM", defaultValue = "")String _noRBM,
                                               @RequestParam(value = "_kantorPelayanan", defaultValue = "")String _kantorPelayanan,
                                               @RequestParam(value = "_noGardu", defaultValue = "")String _noGardu,
                                               @RequestParam(value = "_paymentPoint", defaultValue = "")String _paymentPoint,
                                               @RequestParam(value = "_tarip", defaultValue = "")String _tarip,
                                               @RequestParam(value = "_petugasPemutusan", defaultValue = "")String _petugasPemutusan,
                                               @RequestParam(value = "_cekUrutanKolom", defaultValue = "")String _cekUrutanKolom,
                                               @RequestParam(value = "_cekUrutan", defaultValue = "")String _cekUrutan,
                                               @RequestParam(value = "_maxJmlPK", defaultValue = "")String _maxJmlPK,
                                               @RequestParam(value = "_cekCetakanTiap", defaultValue = "")String _cekCetakanTiap,
                                               @RequestParam(value = "_is60hari", defaultValue = "")String _is60hari) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.TulVI_Main_Eksekusi603_RowCount_pkg(_unitup,
                                                                            _idpelAwal_A,
                                                                            _idpelAwal_B,
                                                                            _idpelAkhir_A,
                                                                            _idpelAkhir_B,
                                                                            _jumlahLembarAwal,
                                                                            _jumlahLembarAkhir,
                                                                            _rupiahTagihAwal,
                                                                            _rupiahTagihAkhir,
                                                                            _dayaAwal,
                                                                            _dayaAkhir,
                                                                            _kogolAwal,
                                                                            _kogolAkhir,
                                                                            _noRBM,
                                                                            _kantorPelayanan,
                                                                            _noGardu,
                                                                            _paymentPoint,
                                                                            _tarip,
                                                                            _petugasPemutusan,
                                                                            _cekUrutanKolom,
                                                                            _cekUrutan,
                                                                            _maxJmlPK,
                                                                            _cekCetakanTiap,
                                                                            _is60hari);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/TulVI_Main_Eksekusi601_RPT_pkg.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject TulVI_Main_Eksekusi601_RPT_pkg(@RequestParam(value = "_unitup", defaultValue = "")String _unitup,
                                               @RequestParam(value = "_idpelAwal_A", defaultValue = "")String _idpelAwal_A,
                                               @RequestParam(value = "_idpelAwal_B", defaultValue = "")String _idpelAwal_B,
                                               @RequestParam(value = "_idpelAkhir_A", defaultValue = "")String _idpelAkhir_A,
                                               @RequestParam(value = "_idpelAkhir_B", defaultValue = "")String _idpelAkhir_B,
                                               @RequestParam(value = "_jumlahLembarAwal", defaultValue = "")String _jumlahLembarAwal,
                                               @RequestParam(value = "_jumlahLembarAkhir", defaultValue = "")String _jumlahLembarAkhir,
                                               @RequestParam(value = "_rupiahTagihAwal", defaultValue = "")String _rupiahTagihAwal,
                                               @RequestParam(value = "_rupiahTagihAkhir", defaultValue = "")String _rupiahTagihAkhir,
                                               @RequestParam(value = "_dayaAwal", defaultValue = "")String _dayaAwal,
                                               @RequestParam(value = "_dayaAkhir", defaultValue = "")String _dayaAkhir,
                                               @RequestParam(value = "_kogolAwal", defaultValue = "")String _kogolAwal,
                                               @RequestParam(value = "_kogolAkhir", defaultValue = "")String _kogolAkhir,
                                               @RequestParam(value = "_noRBM", defaultValue = "")String _noRBM,
                                               @RequestParam(value = "_kantorPelayanan", defaultValue = "")String _kantorPelayanan,
                                               @RequestParam(value = "_noGardu", defaultValue = "")String _noGardu,
                                               @RequestParam(value = "_paymentPoint", defaultValue = "")String _paymentPoint,
                                               @RequestParam(value = "_tarip", defaultValue = "")String _tarip,
                                               @RequestParam(value = "_petugasPemutusan", defaultValue = "")String _petugasPemutusan,
                                               @RequestParam(value = "_cekUrutanKolom", defaultValue = "")String _cekUrutanKolom,
                                               @RequestParam(value = "_cekUrutan", defaultValue = "")String _cekUrutan,
                                               @RequestParam(value = "_maxJmlPK", defaultValue = "")String _maxJmlPK,
                                               @RequestParam(value = "_cekCetakanTiap", defaultValue = "")String _cekCetakanTiap,
                                               @RequestParam(value = "_isCetakUlang", defaultValue = "")String _isCetakUlang) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.TulVI_Main_Eksekusi601_RPT_pkg(_unitup,
                                                                        _idpelAwal_A,
                                                                        _idpelAwal_B,
                                                                        _idpelAkhir_A,
                                                                        _idpelAkhir_B,
                                                                        _jumlahLembarAwal,
                                                                        _jumlahLembarAkhir,
                                                                        _rupiahTagihAwal,
                                                                        _rupiahTagihAkhir,
                                                                        _dayaAwal,
                                                                        _dayaAkhir,
                                                                        _kogolAwal,
                                                                        _kogolAkhir,
                                                                        _noRBM,
                                                                        _kantorPelayanan,
                                                                        _noGardu,
                                                                        _paymentPoint,
                                                                        _tarip,
                                                                        _petugasPemutusan,
                                                                        _cekUrutanKolom,
                                                                        _cekUrutan,
                                                                        _maxJmlPK,
                                                                        _cekCetakanTiap,
                                                                        _isCetakUlang);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/TulVI_Main_Eksekusi603_RPT_pkg.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject TulVI_Main_Eksekusi603_RPT_pkg(@RequestParam(value = "_unitup", defaultValue = "")String _unitup,
                                               @RequestParam(value = "_idpelAwal_A", defaultValue = "")String _idpelAwal_A,
                                               @RequestParam(value = "_idpelAwal_B", defaultValue = "")String _idpelAwal_B,
                                               @RequestParam(value = "_idpelAkhir_A", defaultValue = "")String _idpelAkhir_A,
                                               @RequestParam(value = "_idpelAkhir_B", defaultValue = "")String _idpelAkhir_B,
                                               @RequestParam(value = "_jumlahLembarAwal", defaultValue = "")String _jumlahLembarAwal,
                                               @RequestParam(value = "_jumlahLembarAkhir", defaultValue = "")String _jumlahLembarAkhir,
                                               @RequestParam(value = "_rupiahTagihAwal", defaultValue = "")String _rupiahTagihAwal,
                                               @RequestParam(value = "_rupiahTagihAkhir", defaultValue = "")String _rupiahTagihAkhir,
                                               @RequestParam(value = "_dayaAwal", defaultValue = "")String _dayaAwal,
                                               @RequestParam(value = "_dayaAkhir", defaultValue = "")String _dayaAkhir,
                                               @RequestParam(value = "_kogolAwal", defaultValue = "")String _kogolAwal,
                                               @RequestParam(value = "_kogolAkhir", defaultValue = "")String _kogolAkhir,
                                               @RequestParam(value = "_noRBM", defaultValue = "")String _noRBM,
                                               @RequestParam(value = "_kantorPelayanan", defaultValue = "")String _kantorPelayanan,
                                               @RequestParam(value = "_noGardu", defaultValue = "")String _noGardu,
                                               @RequestParam(value = "_paymentPoint", defaultValue = "")String _paymentPoint,
                                               @RequestParam(value = "_tarip", defaultValue = "")String _tarip,
                                               @RequestParam(value = "_petugasPemutusan", defaultValue = "")String _petugasPemutusan,
                                               @RequestParam(value = "_cekUrutanKolom", defaultValue = "")String _cekUrutanKolom,
                                               @RequestParam(value = "_cekUrutan", defaultValue = "")String _cekUrutan,
                                               @RequestParam(value = "_maxJmlPK", defaultValue = "")String _maxJmlPK,
                                               @RequestParam(value = "_cekCetakanTiap", defaultValue = "")String _cekCetakanTiap,
                                               @RequestParam(value = "_is60hari", defaultValue = "")String _is60hari,
                                               @RequestParam(value = "_isCetakUlang", defaultValue = "")String _isCetakUlang) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.TulVI_Main_Eksekusi603_RPT_pkg(_unitup,
                                                                        _idpelAwal_A,
                                                                        _idpelAwal_B,
                                                                        _idpelAkhir_A,
                                                                        _idpelAkhir_B,
                                                                        _jumlahLembarAwal,
                                                                        _jumlahLembarAkhir,
                                                                        _rupiahTagihAwal,
                                                                        _rupiahTagihAkhir,
                                                                        _dayaAwal,
                                                                        _dayaAkhir,
                                                                        _kogolAwal,
                                                                        _kogolAkhir,
                                                                        _noRBM,
                                                                        _kantorPelayanan,
                                                                        _noGardu,
                                                                        _paymentPoint,
                                                                        _tarip,
                                                                        _petugasPemutusan,
                                                                        _cekUrutanKolom,
                                                                        _cekUrutan,
                                                                        _maxJmlPK,
                                                                        _cekCetakanTiap,
                                                                        _is60hari,
                                                                        _isCetakUlang);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilBuatCetakUlangTul601Kriteria_usingRef_pkg.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilBuatCetakUlangTul601Kriteria_usingRef_pkg(@RequestParam(value = "_unitup", defaultValue = "")String _unitup,
                                               @RequestParam(value = "_idpelAwal_A", defaultValue = "")String _idpelAwal_A,
                                               @RequestParam(value = "_idpelAwal_B", defaultValue = "")String _idpelAwal_B,
                                               @RequestParam(value = "_idpelAkhir_A", defaultValue = "")String _idpelAkhir_A,
                                               @RequestParam(value = "_idpelAkhir_B", defaultValue = "")String _idpelAkhir_B,
                                               @RequestParam(value = "_jumlahLembarAwal", defaultValue = "")String _jumlahLembarAwal,
                                               @RequestParam(value = "_jumlahLembarAkhir", defaultValue = "")String _jumlahLembarAkhir,
                                               @RequestParam(value = "_rupiahTagihAwal", defaultValue = "")String _rupiahTagihAwal,
                                               @RequestParam(value = "_rupiahTagihAkhir", defaultValue = "")String _rupiahTagihAkhir,
                                               @RequestParam(value = "_besarDayaAwal", defaultValue = "")String _besarDayaAwal,
                                               @RequestParam(value = "_besarDayaAkhir", defaultValue = "")String _besarDayaAkhir,
                                               @RequestParam(value = "_kodeGolonganAwal", defaultValue = "")String _kodeGolonganAwal,
                                               @RequestParam(value = "_kodeGolonganAkhir", defaultValue = "")String _kodeGolonganAkhir,
                                               @RequestParam(value = "_noRBM", defaultValue = "")String _noRBM,
                                               @RequestParam(value = "_kantorPelayanan", defaultValue = "")String _kantorPelayanan,
                                               @RequestParam(value = "_noGardu", defaultValue = "")String _noGardu,
                                               @RequestParam(value = "_paymentPoint", defaultValue = "")String _paymentPoint,
                                               @RequestParam(value = "_tarip", defaultValue = "")String _tarip,
                                               @RequestParam(value = "_petugasPemutusan", defaultValue = "")String _petugasPemutusan,
                                               @RequestParam(value = "_cekUrutanKolom", defaultValue = "")String _cekUrutanKolom,
                                               @RequestParam(value = "_cekUrutan", defaultValue = "")String _cekUrutan,
                                               @RequestParam(value = "_maxJmlPK", defaultValue = "")String _maxJmlPK,
                                               @RequestParam(value = "_cekCetakanTiap", defaultValue = "")String _cekCetakanTiap) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilBuatCetakUlangTul601Kriteria_usingRef_pkg(_unitup,
                                                                                        _idpelAwal_A,
                                                                                        _idpelAwal_B,
                                                                                        _idpelAkhir_A,
                                                                                        _idpelAkhir_B,
                                                                                        _jumlahLembarAwal,
                                                                                        _jumlahLembarAkhir,
                                                                                        _rupiahTagihAwal,
                                                                                        _rupiahTagihAkhir,
                                                                                        _besarDayaAwal,
                                                                                        _besarDayaAkhir,
                                                                                        _kodeGolonganAwal,
                                                                                        _kodeGolonganAkhir,
                                                                                        _noRBM,
                                                                                        _kantorPelayanan,
                                                                                        _noGardu,
                                                                                        _paymentPoint,
                                                                                        _tarip,
                                                                                        _petugasPemutusan,
                                                                                        _cekUrutanKolom,
                                                                                        _cekUrutan,
                                                                                        _maxJmlPK,
                                                                                        _cekCetakanTiap);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/PetugasWaskitRBM_AmbilData.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject PetugasWaskitRBM_AmbilData(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                                       @RequestParam(value = "_group", defaultValue = "")String _group,
                                       @RequestParam(value = "_petugas", defaultValue = "")String _petugas) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.PetugasWaskitRBM_AmbilData(unitup,
                                                                    _group,
                                                                    _petugas);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/PetugasWaskitRBM_Simpan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject PetugasWaskitRBM_Simpan(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                                         @RequestParam(value = "namagroup", defaultValue = "")String namagroup,
                                         @RequestParam(value = "namapetugas", defaultValue = "")String namapetugas,
                                         @RequestParam(value = "noRbm", defaultValue = "")String noRbm,
                                         @RequestParam(value = "statusaktif", defaultValue = "") String statusaktif,
                                         @RequestParam(value = "keterangan", defaultValue = "")String keterangan,
                                         @RequestParam(value = "created_by", defaultValue = "")String created_by) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.PetugasWaskitRBM_Simpan(unitup,
                                                                namagroup,
                                                                namapetugas,
                                                                noRbm,
                                                                statusaktif ,
                                                                keterangan,
                                                                created_by);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/PetugasWaskitRBM_Aktifkan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject PetugasWaskitRBM_Aktifkan(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                                            @RequestParam(value = "namagroup", defaultValue = "")String namagroup,
                                            @RequestParam(value = "namapetugas", defaultValue = "")String namapetugas,
                                            @RequestParam(value = "noRbm", defaultValue = "")String noRbm) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.PetugasWaskitRBM_Aktifkan(unitup,
                    namagroup,
                    namapetugas,
                    noRbm);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/PetugasWaskitRBM_NonAktifkan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject PetugasWaskitRBM_NonAktifkan(@RequestParam(value = "unitup", defaultValue = "")String unitup,
                                           @RequestParam(value = "namagroup", defaultValue = "")String namagroup,
                                           @RequestParam(value = "namapetugas", defaultValue = "")String namapetugas,
                                           @RequestParam(value = "noRbm", defaultValue = "")String noRbm) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.PetugasWaskitRBM_NonAktifkan(unitup,
                                                                        namagroup,
                                                                        namapetugas,
                                                                        noRbm);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }
    //waskit


    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilDetailTul601_Pemutusan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDetailTul601_Pemutusan(@RequestParam(value = "strtgl", defaultValue = "")String strtgl,
                                              @RequestParam(value = "_noTulAwal", defaultValue = "")String _noTulAwal,
                                              @RequestParam(value = "_noTulAkhir", defaultValue = "")String _noTulAkhir,
                                              @RequestParam(value = "_unitup", defaultValue = "")String _unitup) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilDetailTul601_Pemutusan(strtgl,
                                                                    _noTulAwal,
                                                                    _noTulAkhir,
                                                                    _unitup);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }

    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilDetailTul603_Pembongkaran.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDetailTul603_Pembongkaran(@RequestParam(value = "strtgl", defaultValue = "")String strtgl,
                                              @RequestParam(value = "_noTulAwal", defaultValue = "")String _noTulAwal,
                                              @RequestParam(value = "_noTulAkhir", defaultValue = "")String _noTulAkhir,
                                              @RequestParam(value = "_unitup", defaultValue = "")String _unitup) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilDetailTul603_Pembongkaran(strtgl,
                                                                        _noTulAwal,
                                                                        _noTulAkhir,
                                                                        _unitup);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/ambilDetailTul601_Penyambungan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject ambilDetailTul601_Penyambungan(@RequestParam(value = "strtgl", defaultValue = "")String strtgl,
                                                              @RequestParam(value = "noTul", defaultValue = "")String noTul,
                                                              @RequestParam(value = "unitup", defaultValue = "")String unitup) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.ambilDetailTul601_Penyambungan(strtgl,
                    noTul,
                    unitup);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/TulVI_Eksekusi_Lapangan_Bongkar_Simpan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject TulVI_Eksekusi_Lapangan_Bongkar_Simpan(@RequestParam(value = "_tglbongkar", defaultValue = "")Date _tglbongkar,
                                                              @RequestParam(value = "_namabongkar", defaultValue = "")String _namabongkar,
                                                              @RequestParam(value = "_lwbp", defaultValue = "")String _lwbp,
                                                              @RequestParam(value = "_wbp", defaultValue = "")String _wbp,
                                                              @RequestParam(value = "_kvarh", defaultValue = "")String _kvarh,
                                                              @RequestParam(value = "_idpelanggan", defaultValue = "")String _idpelanggan,
                                                              @RequestParam(value = "_no60", defaultValue = "")String _no60,
                                                              @RequestParam(value = "_tgl603", defaultValue = "")Date _tgl603,
                                                              @RequestParam(value = "_no603", defaultValue = "")String _no603,
                                                              @RequestParam(value = "_unitUp", defaultValue = "")String _unitUp,
                                                              @RequestParam(value = "_tglkode3", defaultValue = "")Date _tglkode3,
                                                              @RequestParam(value = "_nokode3", defaultValue = "")String _nokode3,
                                                              @RequestParam(value = "_transaksiby", defaultValue = "")String _transaksiby) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.TulVI_Eksekusi_Lapangan_Bongkar_Simpan(_tglbongkar,
                                                                                _namabongkar,
                                                                                _lwbp,
                                                                                _wbp,
                                                                                _kvarh,
                                                                                _idpelanggan,
                                                                                _no60,
                                                                                _tgl603,
                                                                                _no603,
                                                                                _unitUp,
                                                                                _tglkode3,
                                                                                _nokode3,
                                                                                _transaksiby);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }


    @RequestMapping(value = "**/Ws_Tul6Waskit/AmbilBuatCetakUlangTul601Kriteria_usingRef_pkg2.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject AmbilBuatCetakUlangTul601Kriteria_usingRef_pkg2(@RequestParam(value = "_unitup", defaultValue = "")String _unitup,
                                                              @RequestParam(value = "_idpelAwal_A", defaultValue = "")String _idpelAwal_A,
                                                              @RequestParam(value = "_idpelAwal_B", defaultValue = "")String _idpelAwal_B,
                                                              @RequestParam(value = "_idpelAkhir_A", defaultValue = "")String _idpelAkhir_A,
                                                              @RequestParam(value = "_idpelAkhir_B", defaultValue = "")String _idpelAkhir_B,
                                                              @RequestParam(value = "_jumlahLembarAwal", defaultValue = "")String _jumlahLembarAwal,
                                                              @RequestParam(value = "_jumlahLembarAkhir", defaultValue = "")String _jumlahLembarAkhir,
                                                              @RequestParam(value = "_rupiahTagihAwal", defaultValue = "")String _rupiahTagihAwal,
                                                              @RequestParam(value = "_rupiahTagihAkhir", defaultValue = "")String _rupiahTagihAkhir,
                                                              @RequestParam(value = "_besarDayaAwal", defaultValue = "")String _besarDayaAwal,
                                                              @RequestParam(value = "_besarDayaAkhir", defaultValue = "")String _besarDayaAkhir,
                                                              @RequestParam(value = "_kodeGolonganAwal", defaultValue = "")String _kodeGolonganAwal,
                                                              @RequestParam(value = "_kodeGolonganAkhir", defaultValue = "")String _kodeGolonganAkhir,
                                                              @RequestParam(value = "_noRBM", defaultValue = "")String _noRBM,
                                                              @RequestParam(value = "_kantorPelayanan", defaultValue = "")String _kantorPelayanan,
                                                              @RequestParam(value = "_noGardu", defaultValue = "")String _noGardu,
                                                              @RequestParam(value = "_paymentPoint", defaultValue = "")String _paymentPoint,
                                                              @RequestParam(value = "_tarip", defaultValue = "")String _tarip) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_tul6waskitDao.AmbilBuatCetakUlangTul601Kriteria_usingRef_pkg(_unitup,
                    _idpelAwal_A,
                    _idpelAwal_B,
                    _idpelAkhir_A,
                    _idpelAkhir_B,
                    _jumlahLembarAwal,
                    _jumlahLembarAkhir,
                    _rupiahTagihAwal,
                    _rupiahTagihAkhir,
                    _besarDayaAwal,
                    _besarDayaAkhir,
                    _kodeGolonganAwal,
                    _kodeGolonganAkhir,
                    _noRBM,
                    _kantorPelayanan,
                    _noGardu,
                    _paymentPoint,
                    _tarip);
            obj.put("result", retValue);
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
