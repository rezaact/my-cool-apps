package id.co.hans.sample.controller.components;

import id.co.hans.sample.server.dao.MasterDao;
import id.co.hans.sample.server.dao.ws_TransaksiDao;
import id.co.hans.sample.server.dao.ws_UsersDao;
import id.co.hans.sample.server.utility.CommonModule;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ComboController {
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(ComboController.class);

    @Autowired
    private ws_TransaksiDao ws_transaksiDao;

    @Autowired
    private MasterDao masterDao;

    @Autowired
    private ws_UsersDao ws_usersDao;

    @RequestMapping(value = "**/components/testHitUrl.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String testHitUrl() {
        return "ACK-OK";
    }

    @RequestMapping(value = "**/components/getComboTanggal.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONObject getComboTanggal(@RequestParam("year") int year, @RequestParam("month") int month) {
        JSONObject retVal = new JSONObject();

        Calendar firstDate = new GregorianCalendar(),
                lastDate = new GregorianCalendar();

        // untuk gregorian calendar. Bulan Januari = 0, bukan 1
        firstDate.set(Calendar.YEAR, year);
        firstDate.set(Calendar.MONTH, month -1);
        firstDate.set(Calendar.DAY_OF_MONTH, 1);

        lastDate.set(Calendar.YEAR, year);
        lastDate.set(Calendar.MONTH, month -1);
        lastDate.set(Calendar.DAY_OF_MONTH, 1);

        // jadikan lastDate menjadi tanggal terakhir di bulan yang sama
        lastDate.add(Calendar.MONTH, 1);
        lastDate.add(Calendar.DAY_OF_MONTH, -1);

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> currDateData;

        for (int currDate = firstDate.get(Calendar.DAY_OF_MONTH); currDate <= lastDate.get(Calendar.DAY_OF_MONTH); currDate++) {
            currDateData = new HashMap<>();
            currDateData.put("fieldValue", ("0" + String.valueOf(currDate)).substring(("0" + String.valueOf(currDate)).length() - 2, ("0" + String.valueOf(currDate)).length()));
            currDateData.put("displayValue", String.valueOf(currDate));

            dataList.add(currDateData);
        }

        retVal.put("records", dataList);

        return retVal;
    }

    @RequestMapping(value = "**/components/getComboBulan.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONObject getComboBulan() {
        JSONObject retVal = new JSONObject();

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> currData;

        currData = new HashMap<>();
        currData.put("fieldValue", "01");
        currData.put("displayValue", "JANUARI");
        dataList.add(currData);

        currData = new HashMap<>();
        currData.put("fieldValue", "02");
        currData.put("displayValue", "FEBRUARI");
        dataList.add(currData);

        currData = new HashMap<>();
        currData.put("fieldValue", "03");
        currData.put("displayValue", "MARET");
        dataList.add(currData);

        currData = new HashMap<>();
        currData.put("fieldValue", "04");
        currData.put("displayValue", "APRIL");
        dataList.add(currData);

        currData = new HashMap<>();
        currData.put("fieldValue", "05");
        currData.put("displayValue", "MEI");
        dataList.add(currData);

        currData = new HashMap<>();
        currData.put("fieldValue", "06");
        currData.put("displayValue", "JUNI");
        dataList.add(currData);

        currData = new HashMap<>();
        currData.put("fieldValue", "07");
        currData.put("displayValue", "JULI");
        dataList.add(currData);

        currData = new HashMap<>();
        currData.put("fieldValue", "08");
        currData.put("displayValue", "AGUSTUS");
        dataList.add(currData);

        currData = new HashMap<>();
        currData.put("fieldValue", "09");
        currData.put("displayValue", "SEPTEMBER");
        dataList.add(currData);

        currData = new HashMap<>();
        currData.put("fieldValue", "10");
        currData.put("displayValue", "OKTOBER");
        dataList.add(currData);

        currData = new HashMap<>();
        currData.put("fieldValue", "11");
        currData.put("displayValue", "NOVEMBER");
        dataList.add(currData);

        currData = new HashMap<>();
        currData.put("fieldValue", "12");
        currData.put("displayValue", "DESEMBER");
        dataList.add(currData);

        retVal.put("records", dataList);

        return retVal;
    }

    @RequestMapping(value = "**/components/getComboTahun.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONObject getComboTahun() {
        JSONObject retVal = new JSONObject();

        Calendar firstDate = new GregorianCalendar(),
                 lastDate = new GregorianCalendar();


        firstDate = Calendar.getInstance();
        lastDate = Calendar.getInstance();

        // jadikan firstDate menjadi 5 tahun terakhir
        firstDate.add(Calendar.YEAR, -4);

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> currYearData;

        for (int currYear = lastDate.get(Calendar.YEAR); currYear >= firstDate.get(Calendar.YEAR); currYear--) {
            currYearData = new HashMap<>();
            currYearData.put("fieldValue", String.valueOf(currYear));
            currYearData.put("displayValue", String.valueOf(currYear));

            dataList.add(currYearData);
        }

        CommonModule.getLogger(this).info(dataList);

        retVal.put("records", dataList);

        return retVal;
    }


    @RequestMapping(value = "**/components/getJenisLaporan.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONObject getJenisLaporan(@RequestParam("formOriginalName") String formOriginalName) {
        JSONObject retVal = new JSONObject();

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> currData;

        switch (formOriginalName) {
            case "Form_Report21_Restitusi":
                currData = new HashMap<>();
                currData.put("fieldValue", "REKAP");
                currData.put("displayValue", "REKAP PELUNASAN RESTIUSI");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "DAFTAR");
                currData.put("displayValue", "DAFTAR PELUNASAN RESTITUSI");
                dataList.add(currData);

                break;

            case "Form_Report24Nota_Rekap":
                currData = new HashMap<>();
                currData.put("fieldValue", "24notarekapkode");
                currData.put("displayValue", "REKAPITULASI PER KODE");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "24notarekap502");
                currData.put("displayValue", "REKAPITULASI PER TANGGAL");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "24notarekap404");
                currData.put("displayValue", "REKAPITULASI UNTUK BAHAN 404");
                dataList.add(currData);

                break;

            case "Form_Report_Restitusi":
                currData = new HashMap<>();
                currData.put("fieldValue", "REKAP_RESTITUSI_N");
                currData.put("displayValue", "REKAPITULASI RESTITUSI TAGIHAN TIDAK WAJAR");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "DAFTAR_KOREKSI_BLM_RESTITUSI");
                currData.put("displayValue", "DAFTAR KOREKSI RESTITUSI BELUM DIRESTITUSI");
                dataList.add(currData);

                break;

            case "Form_MonitoringSaldoTunggakan":
                currData = new HashMap<>();
                currData.put("fieldValue", "KOGOL");
                currData.put("displayValue", "PER GOLONGAN");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "PP");
                currData.put("displayValue", "PER PP");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "GARDU");
                currData.put("displayValue", "PER GARDU");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "KP");
                currData.put("displayValue", "PER KP");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "RBM");
                currData.put("displayValue", "PER RBM");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "TARIF");
                currData.put("displayValue", "PER TARIF");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "CATER");
                currData.put("displayValue", "PER CATER");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "UNIT");
                currData.put("displayValue", "PER UNIT");
                dataList.add(currData);

                break;

            case "Form_MonitoringTunggakanPemda":
                currData = new HashMap<>();
                currData.put("fieldValue", "PEMDAN1");
                currData.put("displayValue", "PER PEMDA s.d BULAN (N-1)");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "PEMDAN");
                currData.put("displayValue", "PER PEMDA BULAN (N)");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "SELURUH");
                currData.put("displayValue", "PER PEMDA TUNGGAKAN KESELURUHAN");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "DAFTAR");
                currData.put("displayValue", "PER PEMDA DAFTAR TUNGGAKAN");
                dataList.add(currData);

                /*currData = new HashMap<>();
                currData.put("fieldValue", "REKAPKD");
                currData.put("displayValue", "REKAP PER UNIT WILAYAH/DISTRIBUSI");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "PROVINSI");
                currData.put("displayValue", "REKAP PER PROVINSI");
                dataList.add(currData);
                */
                break;

            case "Form_PemantauanSaldoIni":
                currData = new HashMap<>();
                currData.put("fieldValue", "Rekap Saldo Rekening Lancar Per Gol");
                currData.put("displayValue", "Rekap Saldo Rekening Lancar Per Gol");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "Rekap Saldo Rekening Ragu2 Per Gol");
                currData.put("displayValue", "Rekap Saldo Rekening Ragu2 Per Gol");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "Rekap Saldo Rekening Per Lembar");
                currData.put("displayValue", "Rekap Saldo Rekening Per Lembar");
                dataList.add(currData);

                /*currData = new HashMap<>();
                currData.put("fieldValue", "Rekap Saldo >= 200kVA");
                currData.put("displayValue", "Rekap Saldo >= 200kVA");
                dataList.add(currData);*/

                currData = new HashMap<>();
                currData.put("fieldValue", "Saldo Rekening Lancar Berjalan Tgk");
                currData.put("displayValue", "Saldo Rekening Lancar Berjalan Tgk");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "Saldo Rekening Lancar BlTh Rekg.");
                currData.put("displayValue", "Saldo Rekening Lancar BlTh Rekg.");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "Rekap Saldo Rekening Per Tarip");
                currData.put("displayValue", "Rekap Saldo Rekening Per Tarip");
                dataList.add(currData);

                /*currData = new HashMap<>();
                currData.put("fieldValue", "Rekap Saldo Rekening Per Gol Tarip");
                currData.put("displayValue", "Rekap Saldo Rekening Per Gol Tarip");
                dataList.add(currData);*/

                /*currData = new HashMap<>();
                currData.put("fieldValue", "Daftar Saldo Rekening Lancar");
                currData.put("displayValue", "Daftar Saldo Rekening Lancar");
                dataList.add(currData);*/

                currData = new HashMap<>();
                currData.put("fieldValue", "Daftar Saldo Rekening Ragu2");
                currData.put("displayValue", "Daftar Saldo Rekening Ragu2");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "Daftar Saldo Rekening Lancar > 2 Juta");
                currData.put("displayValue", "Daftar Saldo Rekening Lancar > 2 Juta");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "Daftar Saldo Rekening Ragu2 > 2 Juta");
                currData.put("displayValue", "Daftar Saldo Rekening Ragu2 > 2 Juta");
                dataList.add(currData);

                /*currData = new HashMap<>();
                currData.put("fieldValue", "Daftar Saldo 10 Besar");
                currData.put("displayValue", "Daftar Saldo 10 Besar");
                dataList.add(currData); */

                break;

            default:
                currData = new HashMap<>();
                currData.put("fieldValue", "_");
                currData.put("displayValue", "JENIS LAPORAN TIDAK DITEMUKAN");
                dataList.add(currData);

                break;
        }

        retVal.put("records", dataList);

        return retVal;
    }

    @RequestMapping(value = "**/components/getJenisTransaksi.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONObject getJenisTransaksi(@RequestParam("formOriginalName") String formOriginalName) {
        JSONObject retVal = new JSONObject();

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> currData;

        switch (formOriginalName) {
            case "Form_PemantauanTransaksi":
                currData = new HashMap<>();
                currData.put("fieldValue", "11 Rekening Baru");
                currData.put("displayValue", "11 Rekening Baru");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "12 Koreksi Rekening");
                currData.put("displayValue", "12 Koreksi Rekening");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "13 Rekening Susulan");
                currData.put("displayValue", "13 Rekening Susulan");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "21 Pelunasan Off-Line");
                currData.put("displayValue", "21 Pelunasan Off-Line");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "22 Pelunasan On-Line");
                currData.put("displayValue", "22 Pelunasan On-Line");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "23 Pelunasan NotaBuku");
                currData.put("displayValue", "23 Pelunasan NotaBuku");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "23 Pelunasan Terpusat");
                currData.put("displayValue", "23 Pelunasan Terpusat");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "31 Pembatalan Rekening");
                currData.put("displayValue", "31 Pembatalan Rekening");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "41 Pindah Lancar ke Ragu2");
                currData.put("displayValue", "41 Pindah Lancar ke Ragu2");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "32 Penghapusan Rekening");
                currData.put("displayValue", "32 Penghapusan Rekening");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "---------------");
                currData.put("displayValue", "---------------");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "Pembatalan BK");
                currData.put("displayValue", "Pembatalan BK");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "---------------");
                currData.put("displayValue", "---------------");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "a. Cicilan Rekening KWH");
                currData.put("displayValue", "a. Cicilan Rekening KWH");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "b. Kirim Rekening ke Unit Lain");
                currData.put("displayValue", "b. Kirim Rekening ke Unit Lain");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "c. Terima Rekening dari Unit Lain");
                currData.put("displayValue", "c. Terima Rekening dari Unit Lain");
                dataList.add(currData);

                break;

            default:
                currData = new HashMap<>();
                currData.put("fieldValue", "_");
                currData.put("displayValue", "JENIS TRANSAKSI TIDAK DITEMUKAN");
                dataList.add(currData);

                break;
        }

        retVal.put("records", dataList);

        return retVal;
    }

    @RequestMapping(value = "**/components/getJenisPembukuan.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONObject getJenisPembukuan(@RequestParam("formOriginalName") String formOriginalName) {
        JSONObject retVal = new JSONObject();

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> currData;

        switch (formOriginalName) {
            case "Form_PemantauanTransaksi":
                currData = new HashMap<>();
                currData.put("fieldValue", "plus");
                currData.put("displayValue", "Plus");
                dataList.add(currData);

                currData = new HashMap<>();
                currData.put("fieldValue", "nonplus");
                currData.put("displayValue", "Non Plus");
                dataList.add(currData);

                break;

            default:
                currData = new HashMap<>();
                currData.put("fieldValue", "_");
                currData.put("displayValue", "JENIS PEMBUKUAN TIDAK DITEMUKAN");
                dataList.add(currData);

                break;
        }

        retVal.put("records", dataList);

        return retVal;
    }

    @RequestMapping(value = "**/components/getKodeBebanKantor.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONObject getKodeBebanKantor(@RequestParam("strGlobalUnitupPetugas") String strGlobalUnitupPetugas) {
        JSONObject retVal = new JSONObject();

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> currData;

        //todo: fire ke wstransaksi.GetDataKolektifNotaBukuUnitup(Err, strGlobalUnitupPetugas, iBebanKantor)
        //Err : passByReference
        //strGlobalUnitupPetugas : Session("unitup_user")
        //iBebanKantor : String.empty
//        Map<String, Object> wsData = ws_transaksiDao.GetDataKolektifNotaBukuUnitup("53577","0");
//        Map<String, Object> wsData = ws_transaksiDao.GetViewIdPel_21entri("537316334606","IdPel","","");
        Map<String, Object> wsData = ws_transaksiDao.GetView21("53551","01122010","31122010");

        for (Map<String, String> tmp : (List<Map<String,String>>)wsData.get("wsData")) {
            currData = new HashMap<>();

            currData.put("fieldValue", tmp.get("kodekolektif"));
            currData.put("displayValue", tmp.get("kodekolektif"));

            dataList.add(currData);
        }

        retVal.put("records", dataList);
        retVal.put("errmsg", wsData.get("wsError"));

        wsData = null;

        return retVal;
    }


    @RequestMapping(value = "**/components/getComboUnitPelayananInduk.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONObject getComboUnitPelayananInduk(@RequestParam(value = "levelUnits", defaultValue = "")String levelUnits,
                                                 @RequestParam(value = "userUnit", defaultValue = "")String userUnit,
                                                 @RequestParam(value = "addUpiSemua", defaultValue = "0")String addUpiSemua) {
        JSONObject retVal = new JSONObject();

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> currData;

        Map<String, Object> wsData = masterDao.getMasterUnit("UPI", userUnit.substring(1,2));

        if (addUpiSemua.equals("1")) {
            currData = new HashMap<>();
            currData.put("fieldValue", "SEMUA");
            currData.put("displayValue", "SEMUA");
            dataList.add(currData);
        }

        for (Map<String, String> tmp : (List<Map<String,String>>)wsData.get("wsReturn")) {
            currData = new HashMap<>();
            currData.put("fieldValue", tmp.get("unitupi"));
            currData.put("displayValue", tmp.get("unitupi") + "-" + tmp.get("nama"));
            dataList.add(currData);
        }

        retVal.put("records", dataList);
        retVal.put("wsByRefError", wsData.get("wsByRefError"));
        wsData = null;
        return retVal;
    }

    @RequestMapping(value = "**/components/getComboAreaPelayanan.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONObject getComboAreaPelayanan(@RequestParam(value = "levelUnits", defaultValue = "")String levelUnits,
                                            @RequestParam(value = "userUnit", defaultValue = "")String userUnit,
                                            @RequestParam(value = "addApSemua", defaultValue = "0")String addApSemua,
                                            @RequestParam(value = "selectedUnitUpi", defaultValue = "")String selectedUnitUpi) {
        JSONObject retVal = new JSONObject();

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> currData;

        Map<String, Object> wsData = masterDao.getMasterUnit("APbyUPI", selectedUnitUpi);

        if (addApSemua.equals("1")) {
            currData = new HashMap<>();
            currData.put("fieldValue", "SEMUA");
            currData.put("displayValue", "SEMUA");
            dataList.add(currData);
        }

        for (Map<String, String> tmp : (List<Map<String,String>>)wsData.get("wsReturn")) {
            currData = new HashMap<>();
            currData.put("fieldValue", tmp.get("unitap"));
            currData.put("displayValue", tmp.get("unitap") + "-" + tmp.get("nama"));
            dataList.add(currData);
        }

        retVal.put("records", dataList);
        retVal.put("wsByRefError", wsData.get("wsByRefError"));
        wsData = null;
        return retVal;
    }

    @RequestMapping(value = "**/components/getComboUnitPelayanan.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONObject getComboUnitPelayanan(@RequestParam(value = "levelUnits", defaultValue = "")String levelUnits,
                                            @RequestParam(value = "userUnit", defaultValue = "")String userUnit,
                                            @RequestParam(value = "addUpSemua", defaultValue = "0")String addUpSemua,
                                            @RequestParam(value = "selectedUnitAp", defaultValue = "")String selectedUnitAp) {
        JSONObject retVal = new JSONObject();

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> currData;

        Map<String, Object> wsData = masterDao.getMasterUnit("UPbyAP", selectedUnitAp);

        if (addUpSemua.equals("1")) {
            currData = new HashMap<>();
            currData.put("fieldValue", "SEMUA");
            currData.put("displayValue", "SEMUA");
            dataList.add(currData);
        }

        for (Map<String, String> tmp : (List<Map<String,String>>)wsData.get("wsReturn")) {
            currData = new HashMap<>();
            currData.put("fieldValue", tmp.get("unitup"));
            currData.put("displayValue", tmp.get("unitup") + "-" + tmp.get("nama"));
            dataList.add(currData);
        }

        retVal.put("records", dataList);
        retVal.put("wsByRefError", wsData.get("wsByRefError"));
        wsData = null;
        return retVal;
    }

    @RequestMapping(value = "**/components/getComboKodeSiklis.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONObject getComboKodeSiklis(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                         @RequestParam(value = "addSemua", defaultValue = "0")String addSemua) {
        JSONObject retVal = new JSONObject();

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> currData;

        Map<String, Object> wsData = masterDao.getKodeSiklis(unitUp);

        if (addSemua.equals("1")) {
            currData = new HashMap<>();
            currData.put("fieldValue", "SEMUA");
            currData.put("displayValue", "SEMUA");
            dataList.add(currData);
        }

        for (Map<String, String> tmp : (List<Map<String,String>>)wsData.get("wsReturn")) {
            currData = new HashMap<>();
            currData.put("fieldValue", tmp.get("unitup"));
            currData.put("displayValue", tmp.get("unitup") + "-" + tmp.get("kodesiklis"));
            dataList.add(currData);
        }

        retVal.put("records", dataList);
        retVal.put("wsByRefError", wsData.get("wsByRefError"));
        wsData = null;
        return retVal;
    }

    @RequestMapping(value = "**/components/getComboKodePaymentPoint.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONObject getComboKodePaymentPoint(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        JSONObject retVal = new JSONObject();

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> currData;

        Map<String, Object> wsData = masterDao.getKodePaymentPoint(unitUp);

        if (wsData.containsKey("wsReturn")) {
            if (wsData.get("wsReturn") != null) {
                for (Map<String, String> tmp : (List<Map<String,String>>)wsData.get("wsReturn")) {
                    currData = new HashMap<>();
                    currData.put("fieldValue", tmp.get("kodepp"));
                    currData.put("displayValue", tmp.get("namapp"));
                    dataList.add(currData);
                }
            }
        }

        retVal.put("records", dataList);
        retVal.put("wsByRefError", wsData.get("wsByRefError"));
        wsData = null;
        return retVal;
    }

    @RequestMapping(value = "**/components/getComboPetugas.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONObject getComboPetugas(@RequestParam(value = "kodePP", defaultValue = "")String kodePP) {
        JSONObject retVal = new JSONObject();

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> currData;

        Map<String, Object> wsData = masterDao.getKodePetugas(kodePP);

        if (wsData.containsKey("wsReturn")) {
            if (wsData.get("wsReturn") != null) {
                for (Map<String, String> tmp : (List<Map<String,String>>)wsData.get("wsReturn")) {
                    currData = new HashMap<>();
                    currData.put("fieldValue", tmp.get("id_user"));
                    currData.put("displayValue", tmp.get("nama_user"));
                    dataList.add(currData);
                }
            }
        }

        retVal.put("records", dataList);
        retVal.put("wsByRefError", wsData.get("wsByRefError"));
        wsData = null;
        return retVal;
    }

    @RequestMapping(value = "**/components/getComboDataKolektifGiralisasi.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONObject getComboDataKolektifGiralisasi(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        JSONObject retVal = new JSONObject();

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> currData;

        Map<String, Object> wsData = masterDao.getDataKolektifGiralisasi(unitUp);

        if (wsData.containsKey("wsReturn")) {
            if (wsData.get("wsReturn") != null) {
                for (Map<String, String> tmp : (List<Map<String,String>>)wsData.get("wsReturn")) {
                    currData = new HashMap<>();
                    currData.put("fieldValue", tmp.get("kodekolektif"));
                    currData.put("displayValue", tmp.get("namakolektif"));
                    dataList.add(currData);
                }
            }
        }

        retVal.put("records", dataList);
        retVal.put("wsByRefError", wsData.get("wsByRefError"));
        wsData = null;
        return retVal;
    }

    @RequestMapping(value = "**/components/getComboDataKolektifNotaBuku.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONObject getComboDataKolektifNotaBuku(@RequestParam(value = "unitUp", defaultValue = "")String unitUp,
                                                   @RequestParam(value = "iBebanKantor", defaultValue = "")String iBebanKantor) {
        JSONObject retVal = new JSONObject();

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> currData;

        Map<String, Object> wsData = masterDao.getDataKolektifNotaBuku(unitUp, iBebanKantor);

        if (wsData.containsKey("wsReturn")) {
            if (wsData.get("wsReturn") != null) {
                for (Map<String, String> tmp : (List<Map<String,String>>)wsData.get("wsReturn")) {
                    currData = new HashMap<>();
                    currData.put("fieldValue", tmp.get("kodekolektif"));
                    currData.put("displayValue", tmp.get("namakolektif"));
                    dataList.add(currData);
                }
            }
        }

        retVal.put("records", dataList);
        retVal.put("wsByRefError", wsData.get("wsByRefError"));
        wsData = null;
        return retVal;
    }

    @RequestMapping(value = "**/components/getComboDataKolektifNotaTerpusat.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONObject getComboDataKolektifNotaTerpusat(@RequestParam(value = "unitUp", defaultValue = "")String unitUp) {
        JSONObject retVal = new JSONObject();

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> currData;

        Map<String, Object> wsData = masterDao.getDataKolektifNotaTerpusat(unitUp);

        if (wsData.containsKey("wsReturn")) {
            if (wsData.get("wsReturn") != null) {
                for (Map<String, String> tmp : (List<Map<String,String>>)wsData.get("wsReturn")) {
                    currData = new HashMap<>();
                    currData.put("fieldValue", tmp.get("kodekolektif"));
                    currData.put("displayValue", tmp.get("namakolektif"));
                    dataList.add(currData);
                }
            }
        }

        retVal.put("records", dataList);
        retVal.put("wsByRefError", wsData.get("wsByRefError"));
        wsData = null;
        return retVal;
    }

}
