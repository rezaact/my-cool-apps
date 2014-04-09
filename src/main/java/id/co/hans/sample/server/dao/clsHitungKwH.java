package id.co.hans.sample.server.dao;

import id.co.hans.sample.server.utility.CommonModule;
import oracle.jdbc.OracleTypes;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class clsHitungKwH {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private Integer BlnRek;
    private Integer ThRek;
    private String KdRantingNumerik;
    private Date TglSvr;

    public String prmNoPelanggan() {
        return NoPelanggan;
    }

    public void prmNoPelanggan(String noPelanggan) {
        NoPelanggan = noPelanggan;
    }

    public Integer prmBlnRek() {
        return BlnRek;
    }

    public void prmBlnRek(Integer blnRek) {
        BlnRek = blnRek;
    }

    public Integer prmThRek() {
        return ThRek;
    }

    public void prmThRek(Integer thRek) {
        ThRek = thRek;
    }

    public String prmKdRantingNumerik() {
        return KdRantingNumerik;
    }

    public void prmKdRantingNumerik(String kdRantingNumerik) {
        KdRantingNumerik = kdRantingNumerik;
    }

    private String NoPelanggan;



    public Map<String, Object> Hitung_kWh(String prmUserName,
                                          String prmStandAwalLWBPBaru, String prmStandAkhirLWBPBaru,
                                          String prmStandAwalWBPBaru, String prmStandAkhirWBPBaru,
                                          String prmStandAwalKVARHBaru, String prmStandAkhirKVARHBaru) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();
        List<Map<String,String>> lMapDataTarip = new ArrayList<Map<String,String>>();

        String VBlThRekening;
        String VBulan;
        String VNoKontrak;
        Double vkwhlwbp;
        Double VkWhWBP;
        String vfaktorkali;
        Double VkWhBlok3;
        Double VTotalkWh;
        Double VkWhKVARH;
        String vtarif;
        Double PanjangStandAwallwbp;
        Double PanjangStandAwalwbp;
        Double PanjangStandAwallkvarh;
        Double PenguranganStand = 0D;
        Double PenguranganStandwbp = 0D;
        Double PenguranganStandkvarh = 0D;
        Double HitungkWhLWBP;
        Double HitungkWhWBP;
        Double PenguranganBlok2;
        Double Koefisien;
        Double TotalkWhLwbp;
        Double SatuankWhLwbp;
        Double lwbpsisa;
        Double wbpsisa;
        clsPendekatankWh A = new clsPendekatankWh();
        clsPerbandingan B = new clsPerbandingan();
        String VTglCatatMeterString;
        Double VCosPhiKVAmax;
        Double VkWhKVAmax;
        String Npelanggan;

        //String ds, ds1, ds2, ds3 As DataSet
        Integer rowCount;
        Integer i;
        Double PanjangStandAwal;
        Double Masukankwh;
        Double PanjangStandAwalKVARH;

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            ResultSet rs;
            CallableStatement cst;
            String sql;
            
            
            TglSvr = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            VTglCatatMeterString = formatter.format(TglSvr);

            if (BlnRek.toString().trim().length() > 1) {
                VBulan = BlnRek.toString().trim();
            } else {
                VBulan = "0" + BlnRek.toString().trim();
            }

            VBlThRekening = ThRek.toString().trim() + VBulan;
            //=======================================
            //===Masuk Ke DilDataStandmeterKoreksi===
            //=======================================
            sql = "insert into dildatastandmeterkoreksi";
            sql = sql + " select dm.*";
            sql = sql + " FROM dildatastandmeter dm,dil dl";
            sql = sql + " where dm.no_pelanggan = dl.no_pelanggan ";
            sql = sql + " and dl.kode_Ranting_numerik ='" + KdRantingNumerik + "'";
            sql = sql + " and dm.bl_th_rekening ='" + VBlThRekening + "'";
            sql = sql + " and dl.No_Pelanggan ='" + NoPelanggan + "'";

            cst = con.prepareCall(sql);
            cst.execute();


            //==============================
            //===Delete dildatastandmeter===
            //==============================
            //sql = "delete "
            //sql = sql + " FROM dildatastandmeter dm,dil dl"
            //sql = sql + " where dm.no_kontrak = dl.no_kontrak "
            //sql = sql + " and dl.kode_Ranting_numerik ='" + KdRantingNumerik + "'"
            //sql = sql + " and dm.bl_th_rekening ='" + VBlThRekening + "'"
            //sql = sql + " and dl.No_Kontrak ='" + NoKontrak + "'"

            sql = "delete ";
            sql = sql + " FROM dildatastandmeter dm";
            sql = sql + " where dm.no_Pelanggan = '" + NoPelanggan + "'";
            sql = sql + " and dm.bl_th_rekening ='" + VBlThRekening + "'";

            cst = con.prepareCall(sql);
            cst.execute();


            sql = "select dk.Kode_Abunemen_Meter,";
            sql = sql + " dmt.Faktor_Kali_kWh,";
            sql = sql + " dmt.faktor_kali_kvarh,";
            sql = sql + " dmt.Faktor_Kali_KVAmax  ,";
            sql = sql + " dl.no_kontrak,";
            sql = sql + " dl.no_Pelanggan,";
            sql = sql + " dl.tarip,";
            sql = sql + " dl.daya,";
            sql = sql + " DL.KD_PT,";
            sql = sql + " dl.Jenis_Mutasi_Koreksi_terakhir,";
            sql = sql + " trp.Jamblok1,";
            sql = sql + " trp.Jamblok2,";
            sql = sql + " ds.Kode_Faktor_Rugi_Trafo";
            sql = sql + " FROM  dilmeter dmt right outer join dil dl on dmt.no_pelanggan = dl.no_pelanggan";
            sql = sql + " left outer join dilkolok dk on dmt.no_pelanggan = dk.no_pelanggan";
            sql = sql + " left outer join dilsl ds on dmt.no_pelanggan= ds.no_pelanggan";
            //=============================================================================================
            sql = sql + " inner join tarip trp on trp.tarip = dl.tarip";
            //=============================================================================================
            sql = sql + " where dl.kode_Ranting_numerik ='" + KdRantingNumerik + "'";
            sql = sql + " and dL.no_pelanggan='" + NoPelanggan + "'";

            cst = con.prepareCall(sql);
            cst.execute();

            //============================ cari kode kva
            sql = "select dk.Kode_Abunemen_Meter,";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (!lMapData.get(0).get("kode_kva").equals("")) {
                if (lMapData.get(0).get("kode_kva") == "K") {
                    sql = sql + " and trp.daya_max >= (dl.daya*1000) and trp.daya_min <= (dl.daya*1000)";
                }
            } else {
                sql = sql + " and trp.daya_max >= dl.daya and trp.daya_min <= dl.daya";
            }


            //=====================================
            String jtarip = "";
            String strBl_Th_Berlaku = "";
            String sqlTarip = "select tarip from dil where no_pelanggan = '" + NoPelanggan + "'";
            cst = con.prepareCall(sqlTarip);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);
            if (lMapData.size() > 0) {
                jtarip = lMapData.get(0).get("Tarip");
            }

            sqlTarip = "select distinct bl_th_berlaku from tarip where tarip ='" + jtarip + "' order by bl_th_berlaku desc ";
            cst = con.prepareCall(sqlTarip);
            rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);
            for (Map<String, String> rowData : lMapData) {
                if (!rowData.get("Bl_th_Berlaku").equals("")) {
                    if (Double.parseDouble(VBlThRekening) >= Double.parseDouble(rowData.get("Bl_th_Berlaku"))) {
                        strBl_Th_Berlaku = rowData.get("Bl_th_Berlaku");
                        break;
                    }
                }
            }

            sql = sql + " and TRP.Tarip = '" + jtarip + "' and trp.BL_TH_BERLAKU = '" + strBl_Th_Berlaku + "'";

            cst = con.prepareCall(sql);
            rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.size() > 0) {
                for (Map<String, String> rowData : lMapData) {
                    vkwhlwbp = 0D;
                    VkWhWBP = 0D;
                    VkWhBlok3 = 0D;
                    VkWhKVARH = 0D;
                    VTotalkWh = 0D;
                    HitungkWhLWBP = 0D;
                    HitungkWhWBP = 0D;
                    vfaktorkali = rowData.get("faktor_kali_kwh");
                    vtarif = rowData.get("tarip");
                    VNoKontrak = rowData.get("no_kontrak");
                    Npelanggan = rowData.get("no_pelanggan");

                    if (rowData.get("jenis_mutasi_koreksi_terakhir") == "J") {
                        sql = "INSERT INTO DILDATASTANDMETER";
                        sql = sql + " (no_kontrak,";
                        sql = sql + " no_pelanggan,";
                        sql = sql + " Bl_th_rekening,";
                        sql = sql + " kWhLWBP,";
                        sql = sql + " StandAwalLWBPkWh,";
                        sql = sql + " StandAkhirLWBPkWh,";
                        sql = sql + " StandAwalWBP,";
                        sql = sql + " StandAkhirWBP,";
                        sql = sql + " StandAwalkVARh,";
                        sql = sql + " StandAkhirkVARh,";
                        sql = sql + " tgl_transaksi_kwh,";
                        sql = sql + " tgl_catat_meter,";
                        sql = sql + " Tgl_Catat_Meter_StandAwal,";
                        sql = sql + " kWhWBP,";
                        sql = sql + " kWhBlok3,";
                        sql = sql + " TotalkWh,";
                        sql = sql + " kVARh,";
                        sql = sql + " kodepetugaspencatatan,";
                        sql = sql + " faktor_kali_meter,";
                        sql = sql + " tarif, ";
                        sql = sql + " PetugasKoreksi)";
                        sql = sql + " Double.parseDoubleues('" + VNoKontrak + "',";
                        sql = sql + " '" + Npelanggan + "',";
                        sql = sql + " '" + VBlThRekening + "',";
                        sql = sql + vkwhlwbp + ",";
                        sql = sql + "0,";
                        sql = sql + "0,";
                        sql = sql + "0,";
                        sql = sql + "0,";
                        sql = sql + "0,";
                        sql = sql + "0,";
                        sql = sql + " to_date('" + VTglCatatMeterString + "','yyyy/mm/dd'),";
                        sql = sql + " to_date('" + VTglCatatMeterString + "','yyyy/mm/dd'),";
                        sql = sql + " to_date('" + VTglCatatMeterString + "','yyyy/mm/dd'),";
                        sql = sql + VkWhWBP + ",";
                        sql = sql + VkWhBlok3 + ",";
                        sql = sql + VTotalkWh + ",";
                        sql = sql + VkWhKVARH + ",";
                        sql = sql + " 'Krs Rek',";
                        sql = sql + vfaktorkali + ",";
                        sql = sql + "'" + vtarif + "',";
                        sql = sql + " '" + prmUserName + "')";

                        cst = con.prepareCall(sql);
                        cst.execute();
                    } else if (rowData.get("Tarip") == "S1") {
                        vkwhlwbp = ((500 * Double.parseDouble(rowData.get("Daya"))) / 1000);

                        sql = "INSERT INTO DILDATASTANDMETER";
                        sql = sql + " (no_kontrak,";
                        sql = sql + " no_pelanggan,";
                        sql = sql + " Bl_th_rekening,";
                        sql = sql + " kWhLWBP,";
                        sql = sql + " StandAwalLWBPkWh,";
                        sql = sql + " StandAkhirLWBPkWh,";
                        sql = sql + " StandAwalWBP,";
                        sql = sql + " StandAkhirWBP,";
                        sql = sql + " StandAwalkVARh,";
                        sql = sql + " StandAkhirkVARh,";
                        sql = sql + " tgl_transaksi_kwh,";
                        sql = sql + " tgl_catat_meter,";
                        sql = sql + " Tgl_Catat_Meter_StandAwal,";
                        sql = sql + " kWhWBP,";
                        sql = sql + " kWhBlok3,";
                        sql = sql + " TotalkWh,";
                        sql = sql + " kVARh,";
                        sql = sql + " kodepetugaspencatatan,";
                        sql = sql + " faktor_kali_meter,";
                        sql = sql + " tarif ,";
                        sql = sql + " PetugasKoreksi)";
                        sql = sql + " Double.parseDoubleues('" + VNoKontrak + "',";
                        sql = sql + " '" + Npelanggan + "',";
                        sql = sql + " '" + VBlThRekening + "',";
                        sql = sql + vkwhlwbp + ",";
                        sql = sql + "0,";
                        sql = sql + "0,";
                        sql = sql + "0,";
                        sql = sql + "0,";
                        sql = sql + "0,";
                        sql = sql + "0,";
                        sql = sql + " to_date('" + VTglCatatMeterString + "','yyyy/mm/dd'),";
                        sql = sql + " to_date('" + VTglCatatMeterString + "','yyyy/mm/dd'),";
                        sql = sql + " to_date('" + VTglCatatMeterString + "','yyyy/mm/dd'),";
                        sql = sql + VkWhWBP + ",";
                        sql = sql + VkWhBlok3 + ",";
                        sql = sql + vkwhlwbp + ",";
                        sql = sql + VkWhKVARH + ",";
                        sql = sql + " 'Krs Rek',";
                        sql = sql + vfaktorkali + ",";
                        sql = sql + "'" + vtarif + " ',";
                        sql = sql + " '" + prmUserName + "')";

                        cst = con.prepareCall(sql);
                        cst.execute();
                    } else {
                        PanjangStandAwal = prmStandAwalLWBPBaru.trim().length() * 1D;
                        if (Double.parseDouble(prmStandAkhirLWBPBaru) < Double.parseDouble(prmStandAwalLWBPBaru)) {
                        switch (Integer.parseInt(PanjangStandAwal.toString())) {
                            case 1:
                                PenguranganStand = ((10 + Double.parseDouble(prmStandAkhirLWBPBaru)) - Double.parseDouble(prmStandAwalLWBPBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh"));
                            case 2:
                                PenguranganStand = ((100 + Double.parseDouble(prmStandAkhirLWBPBaru)) - Double.parseDouble(prmStandAwalLWBPBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh"));
                            case 3:
                                PenguranganStand = ((1000 + Double.parseDouble(prmStandAkhirLWBPBaru)) - Double.parseDouble(prmStandAwalLWBPBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh"));
                            case 4:
                                PenguranganStand = ((10000 + Double.parseDouble(prmStandAkhirLWBPBaru)) - Double.parseDouble(prmStandAwalLWBPBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh"));
                            case 5:
                                PenguranganStand = ((100000 + Double.parseDouble(prmStandAkhirLWBPBaru)) - Double.parseDouble(prmStandAwalLWBPBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh"));
                            case 6:
                                PenguranganStand = ((1000000 + Double.parseDouble(prmStandAkhirLWBPBaru)) - Double.parseDouble(prmStandAwalLWBPBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh"));
                        }
                        } else {
                            PenguranganStand = (Double.parseDouble(prmStandAkhirLWBPBaru) - Double.parseDouble(prmStandAwalLWBPBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh"));
                        }


                        if (rowData.get("Tarip").toString() == "R1" && Double.parseDouble(rowData.get("Daya")) <= 1000) {
                            //HitungkWhLWBP = ((60 * Double.parseDouble(rowData.get("Daya"))) / 1000)
                            HitungkWhLWBP = Double.parseDouble(rowData.get("jamblok1"));
                            A.MasukanKwh(HitungkWhLWBP);
                            HitungkWhLWBP = A.Keluarankwh();
                            if (PenguranganStand <= HitungkWhLWBP) {
                                vkwhlwbp = PenguranganStand;
                            } else {
                                HitungkWhWBP = PenguranganStand - HitungkWhLWBP;
                                vkwhlwbp = HitungkWhLWBP;
                                //VkWhWBP = HitungkWhWBP
                                //==================================begin
                                if (HitungkWhWBP <= (Double.parseDouble(rowData.get("jamblok2")) - Double.parseDouble(rowData.get("jamblok1")))) {
                                    VkWhWBP = HitungkWhWBP;
                                } else {
                                    HitungkWhWBP = HitungkWhWBP - (Double.parseDouble(rowData.get("jamblok2")) - Double.parseDouble(rowData.get("jamblok1")));
                                    VkWhWBP = (Double.parseDouble(rowData.get("jamblok2")) - Double.parseDouble(rowData.get("jamblok1")));
                                    VkWhBlok3 = HitungkWhWBP;
                                }
                                //===================================tambahan blok 2 dan blok 3 end
                            }
                        } else if (
                                    (rowData.get("Tarip") == "S2" && (Double.parseDouble(rowData.get("Daya")) >= 250 && Double.parseDouble(rowData.get("Daya")) <= 900))
                                    || (rowData.get("Tarip") == "S2" && (Double.parseDouble(rowData.get("Daya")) >= 901 && Double.parseDouble(rowData.get("Daya")) <= 1299))
                                    || (rowData.get("Tarip") == "S2" && (Double.parseDouble(rowData.get("Daya")) >= 1300 && Double.parseDouble(rowData.get("Daya")) <= 2200))
                                    || (rowData.get("Tarip") == "S2" && (Double.parseDouble(rowData.get("Daya")) >= 0 && Double.parseDouble(rowData.get("Daya")) <= 450))
                                  ) {
                            HitungkWhLWBP = Double.parseDouble(rowData.get("jamblok1"));
                            A.MasukanKwh(HitungkWhLWBP);
                            HitungkWhLWBP = A.Keluarankwh();
                            if (PenguranganStand <= HitungkWhLWBP) {
                                vkwhlwbp = PenguranganStand;
                            } else {
                                HitungkWhWBP = PenguranganStand - HitungkWhLWBP;
                                vkwhlwbp = HitungkWhLWBP;
                                if (HitungkWhWBP <= (Double.parseDouble(rowData.get("jamblok2")) - Double.parseDouble(rowData.get("jamblok1")))) {
                                    VkWhWBP = HitungkWhWBP;
                                } else {
                                    Double jamblok1, jamblok2;
                                    jamblok1 = Double.parseDouble(rowData.get("jamblok1"));
                                    jamblok2 = Double.parseDouble(rowData.get("jamblok2"));
                                    // HitungkWhWBP = PenguranganStand - (rowData.get("jamblok2") - rowData.get("jamblok1"))
                                    HitungkWhWBP = PenguranganStand - jamblok2 - jamblok1;
                                    VkWhWBP = (Double.parseDouble(rowData.get("jamblok1")));
                                    VkWhBlok3 = HitungkWhWBP;
                                }
                            }
                        } else if (rowData.get("Tarip") == "R1" && Double.parseDouble(rowData.get("Daya")) > 1000 && Double.parseDouble(rowData.get("Daya")) < 2200) {
                            if (PenguranganStand > Double.parseDouble(rowData.get("jamblok1"))) {
                                vkwhlwbp = Double.parseDouble(rowData.get("jamblok1"));
                                PenguranganBlok2 = PenguranganStand - Double.parseDouble(rowData.get("jamblok1"));
                                if (PenguranganBlok2 > Double.parseDouble(rowData.get("jamblok2"))) {
                                    VkWhWBP = Double.parseDouble(rowData.get("jamblok2")) - Double.parseDouble(rowData.get("jamblok1"));
                                    VkWhBlok3 = PenguranganStand - Double.parseDouble(rowData.get("jamblok2"));
                                } else {
                                        VkWhWBP = PenguranganBlok2;
                                }
                            } else {
                                vkwhlwbp = PenguranganStand;
                            }
                        } else if (rowData.get("Tarip") == "R1" && Double.parseDouble(rowData.get("Daya")) >= 2200) {
                            if (PenguranganStand > Double.parseDouble(rowData.get("jamblok1"))) {
                                vkwhlwbp = Double.parseDouble(rowData.get("jamblok1"));
                                PenguranganBlok2 = PenguranganStand - Double.parseDouble(rowData.get("jamblok1"));
                                if (PenguranganBlok2 > Double.parseDouble(rowData.get("jamblok2"))) {
                                    VkWhWBP = Double.parseDouble(rowData.get("jamblok2")) - Double.parseDouble(rowData.get("jamblok1"));
                                    VkWhBlok3 = PenguranganStand - Double.parseDouble(rowData.get("jamblok2"));
                                } else {
                                    VkWhWBP = PenguranganBlok2;
                                }
                            } else {
                                    vkwhlwbp = PenguranganStand;
                            }
                        } else if (rowData.get("Tarip") == "B1") {
                            //HitungkWhLWBP = ((rowData.get("jamblok1") * Double.parseDouble(rowData.get("Daya"))) / 1000)
                            //A.MasukanKwh = HitungkWhLWBP
                            //HitungkWhLWBP = A.Keluarankwh
                            if (PenguranganStand < Double.parseDouble(rowData.get("jamblok1"))) {
                                vkwhlwbp = PenguranganStand;
                            } else {
                                HitungkWhLWBP = Double.parseDouble(rowData.get("jamblok1"));
                                A.MasukanKwh(HitungkWhLWBP);
                                HitungkWhLWBP = A.Keluarankwh();

                                HitungkWhWBP = PenguranganStand - HitungkWhLWBP;
                                vkwhlwbp = HitungkWhLWBP;
                                VkWhWBP = HitungkWhWBP;
                            }
                        } else if (rowData.get("Tarip") == "B2" || (rowData.get("Tarip") == "S2"
                                && Double.parseDouble(rowData.get("Daya")) > 2200 && Double.parseDouble(rowData.get("Daya")) <= 200000)) {
                            HitungkWhLWBP = (Double.parseDouble(rowData.get("jamblok1")) * Double.parseDouble(rowData.get("Daya"))) / 1000;
                            A.MasukanKwh(HitungkWhLWBP);
                            HitungkWhLWBP = A.Keluarankwh();

                            if (PenguranganStand < HitungkWhLWBP) {
                                vkwhlwbp = PenguranganStand;
                            } else {
                                HitungkWhWBP = PenguranganStand - HitungkWhLWBP;
                                vkwhlwbp = HitungkWhLWBP;
                                VkWhWBP = HitungkWhWBP;
                            }
                        } else if (rowData.get("Tarip") == "I1") {
                            HitungkWhLWBP = Double.parseDouble(rowData.get("jamblok1"));
                            if (PenguranganStand < HitungkWhLWBP) {
                                vkwhlwbp = PenguranganStand;
                            } else {
                                HitungkWhLWBP = Double.parseDouble(rowData.get("jamblok1"));
                                A.MasukanKwh(HitungkWhLWBP);
                                HitungkWhLWBP = A.Keluarankwh();

                                HitungkWhWBP = PenguranganStand - HitungkWhLWBP;
                                vkwhlwbp = HitungkWhLWBP;
                                VkWhWBP = HitungkWhWBP;
                            }
                            if (Double.parseDouble(rowData.get("Daya")) <= 14000 && Double.parseDouble(rowData.get("Daya")) > 2200) {
                                HitungkWhLWBP = (Double.parseDouble(rowData.get("jamblok1")) * Double.parseDouble(rowData.get("Daya"))) / 1000;
                                A.MasukanKwh(HitungkWhLWBP);
                                HitungkWhLWBP = A.Keluarankwh();

                                if (PenguranganStand < HitungkWhLWBP) {
                                    vkwhlwbp = PenguranganStand;
                                } else {
                                    HitungkWhWBP = PenguranganStand - HitungkWhLWBP;
                                    vkwhlwbp = HitungkWhLWBP;
                                    VkWhWBP = HitungkWhWBP;
                                }
                            }
                        } else if (rowData.get("Tarip") == "P1" || rowData.get("Tarip") == "R2" || rowData.get("Tarip") == "R3") {
                            vkwhlwbp = PenguranganStand;
                        } else if (rowData.get("Tarip") == "P3") {
                            if (!rowData.get("Kode_Abunemen_Meter").equals("")) {
                                if (rowData.get("Kode_Abunemen_Meter") == "3" || Double.parseDouble(rowData.get("Kode_Abunemen_Meter")) == 3) {
                                    vkwhlwbp = ((375 * Double.parseDouble(rowData.get("Daya"))) / 1000);
                                } else if (rowData.get("Kode_Abunemen_Meter") == "2" || Double.parseDouble(rowData.get("Kode_Abunemen_Meter")) == 2) {
                                    vkwhlwbp = ((720 * Double.parseDouble(rowData.get("Daya"))) / 1000);
                                }else {
                                    vkwhlwbp = PenguranganStand;
                                }
                            } else {
                                vkwhlwbp = PenguranganStand;
                            }

                            A.MasukanKwh(vkwhlwbp);
                            vkwhlwbp = A.Keluarankwh();
                        } else if (rowData.get("Tarip") == "S3" || rowData.get("Tarip") == "B3" || rowData.get("Tarip") == "I2"
                                   || rowData.get("Tarip") == "I3" || rowData.get("Tarip") == "I4" || rowData.get("Tarip") == "P2") {
                            Koefisien = 1D;
                            if (rowData.get("Tarip") == "S3" || rowData.get("Tarip") == "B3"
                                || rowData.get("Tarip") == "I3" || rowData.get("Tarip") == "I4" || rowData.get("Tarip") == "P2") {
                                //If rowData.get("Kode_Faktor_Rugi_Trafo") = "R" Or rowData.get("Kode_Faktor_Rugi_Trafo") = "S" Then
                                //Koefisien = 1.02
                                //Koefisien = 1.0
                                Koefisien = 1D;
                                //ElseIf rowData.get("Kode_Faktor_Rugi_Trafo") = "L" Or rowData.get("Kode_Faktor_Rugi_Trafo") = "N" Then
                                // Koefisien = 1.05
                                // End If
                            }

                            //PanjangStandAwalwbp = Len(Trim(prmStandAwalWBPBaru))
                            PanjangStandAwalwbp = prmStandAwalWBPBaru.length() * 1D;
                            if (Double.parseDouble(prmStandAkhirWBPBaru) < Double.parseDouble(prmStandAwalWBPBaru)) {
                                switch (Integer.parseInt(PanjangStandAwalwbp.toString())) {
                                    case 1:
                                        PenguranganStandwbp = ((10 + Double.parseDouble(prmStandAkhirWBPBaru)) - Double.parseDouble(prmStandAwalWBPBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh"));
                                    case 2:
                                        PenguranganStandwbp = ((100 + Double.parseDouble(prmStandAkhirWBPBaru)) - Double.parseDouble(prmStandAwalWBPBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh"));
                                    case 3:
                                        PenguranganStandwbp = ((1000 + Double.parseDouble(prmStandAkhirWBPBaru)) - Double.parseDouble(prmStandAwalWBPBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh"));
                                    case 4:
                                        PenguranganStandwbp = ((10000 + Double.parseDouble(prmStandAkhirWBPBaru)) - Double.parseDouble(prmStandAwalWBPBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh"));
                                    case 5:
                                        PenguranganStandwbp = ((100000 + Double.parseDouble(prmStandAkhirWBPBaru)) - Double.parseDouble(prmStandAwalWBPBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh"));
                                    case 6:
                                        PenguranganStandwbp = ((1000000 + Double.parseDouble(prmStandAkhirWBPBaru)) - Double.parseDouble(prmStandAwalWBPBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh"));
                                }
                            } else {
                                PenguranganStandwbp = (Double.parseDouble(prmStandAkhirWBPBaru) - Double.parseDouble(prmStandAwalWBPBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh"));
                            }

                            if (!rowData.get("KD_PT").equals("")) {
                                if (rowData.get("KD_PT") == "1") {
                                    TotalkWhLwbp = (PenguranganStand * Koefisien);
                                    A.MasukanKwh(TotalkWhLwbp);
                                    TotalkWhLwbp = A.Keluarankwh();
                                    SatuankWhLwbp = (PenguranganStand * Koefisien) / 6;

                                    vkwhlwbp = SatuankWhLwbp * 5;
                                    B.MasukanKwh(vkwhlwbp);
                                    lwbpsisa = B.Keluarankwh();

                                    VkWhWBP = SatuankWhLwbp * 1;
                                    B.MasukanKwh(VkWhWBP);
                                    wbpsisa = B.Keluarankwh();
                                    if (lwbpsisa < wbpsisa) {
                                        VkWhWBP = SatuankWhLwbp * 1;
                                        A.MasukanKwh(VkWhWBP);
                                        VkWhWBP = A.Keluarankwh();
                                        vkwhlwbp = TotalkWhLwbp - VkWhWBP;
                                    } else {
                                        vkwhlwbp = SatuankWhLwbp * 5;
                                        A.MasukanKwh(vkwhlwbp);
                                        vkwhlwbp = A.Keluarankwh();
                                        VkWhWBP = TotalkWhLwbp - vkwhlwbp;
                                    }
                                } else if (rowData.get("KD_PT") == "2") {
                                    TotalkWhLwbp = (PenguranganStand * Koefisien);
                                    A.MasukanKwh(TotalkWhLwbp);
                                    TotalkWhLwbp = A.Keluarankwh();
                                    SatuankWhLwbp = (PenguranganStand * Koefisien) / 9;
                                    vkwhlwbp = SatuankWhLwbp * 8;
                                    B.MasukanKwh(vkwhlwbp);
                                    lwbpsisa = B.Keluarankwh();

                                    VkWhWBP = SatuankWhLwbp * 1;
                                    B.MasukanKwh(VkWhWBP);
                                    wbpsisa = B.Keluarankwh();
                                    if (lwbpsisa < wbpsisa) {
                                        VkWhWBP = SatuankWhLwbp * 1;
                                        A.MasukanKwh(VkWhWBP);
                                        VkWhWBP = A.Keluarankwh();
                                        vkwhlwbp = TotalkWhLwbp - VkWhWBP;
                                    } else {
                                        vkwhlwbp = SatuankWhLwbp * 8;
                                        A.MasukanKwh(vkwhlwbp);
                                        vkwhlwbp = A.Keluarankwh();
                                        VkWhWBP = TotalkWhLwbp - vkwhlwbp;
                                    }
                                } else if (rowData.get("KD_PT") == "3") {
                                    TotalkWhLwbp = (PenguranganStand * Koefisien);
                                    A.MasukanKwh(TotalkWhLwbp);
                                    TotalkWhLwbp = A.Keluarankwh();
                                    SatuankWhLwbp = (PenguranganStand * Koefisien) / 7;
                                    vkwhlwbp = SatuankWhLwbp * 5;
                                    B.MasukanKwh(vkwhlwbp);
                                    lwbpsisa = B.Keluarankwh();

                                    VkWhWBP = SatuankWhLwbp * 2;
                                    B.MasukanKwh(VkWhWBP);
                                    wbpsisa = B.Keluarankwh();
                                    if (lwbpsisa < wbpsisa) {
                                        VkWhWBP = SatuankWhLwbp * 2;
                                        A.MasukanKwh(VkWhWBP);
                                        VkWhWBP = A.Keluarankwh();
                                        vkwhlwbp = TotalkWhLwbp - VkWhWBP;
                                    } else {
                                        vkwhlwbp = SatuankWhLwbp * 5;
                                        A.MasukanKwh(vkwhlwbp);
                                        vkwhlwbp = A.Keluarankwh();
                                        VkWhWBP = TotalkWhLwbp - vkwhlwbp;
                                    }
                                }
                            } else {
                                vkwhlwbp = PenguranganStand * Koefisien;
                                A.MasukanKwh(vkwhlwbp);
                                vkwhlwbp = A.Keluarankwh();
                                VkWhWBP = PenguranganStandwbp * Koefisien;
                                A.MasukanKwh(VkWhWBP);
                                VkWhWBP = A.Keluarankwh();
                            }

                            VTotalkWh = vkwhlwbp + VkWhWBP;
                            //If MyRecset1!Kode_kVARh = "A" Then
                            //PanjangStandAwalKVARH = Len(Trim(prmStandAwalKVARHBaru))
                            PanjangStandAwalKVARH = prmStandAwalKVARHBaru.trim().length() * 1D;
                            if (Double.parseDouble(prmStandAkhirKVARHBaru) < Double.parseDouble(prmStandAwalKVARHBaru)) {
                                switch (Integer.parseInt(PanjangStandAwalKVARH.toString())) {
                                    case 1:
                                        if (!rowData.get("Faktor_kali_kvarh").equals("")) {
                                            VkWhKVARH = ((10 + Double.parseDouble(prmStandAkhirKVARHBaru)) - Double.parseDouble(prmStandAwalKVARHBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh")) * 1D;
                                        } else {
                                            VkWhKVARH = ((10 + Double.parseDouble(prmStandAkhirKVARHBaru)) - Double.parseDouble(prmStandAwalKVARHBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kvarh")) * 1D;
                                        }
                                    case 2:
                                        if (!rowData.get("Faktor_kali_kvarh").equals("")) {
                                            VkWhKVARH = ((100 + Double.parseDouble(prmStandAkhirKVARHBaru)) - Double.parseDouble(prmStandAwalKVARHBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh")) * 1D;
                                        } else {
                                            VkWhKVARH = ((100 + Double.parseDouble(prmStandAkhirKVARHBaru)) - Double.parseDouble(prmStandAwalKVARHBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kvarh")) * 1D;
                                        }
                                    case 3:
                                        if (!rowData.get("Faktor_kali_kvarh").equals("")) {
                                            VkWhKVARH = ((1000 + Double.parseDouble(prmStandAkhirKVARHBaru)) - Double.parseDouble(prmStandAwalKVARHBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh")) * 1D;
                                        } else {
                                            VkWhKVARH = ((1000 + Double.parseDouble(prmStandAkhirKVARHBaru)) - Double.parseDouble(prmStandAwalKVARHBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kvarh")) * 1D;
                                        }
                                    case 4:
                                        if (!rowData.get("Faktor_kali_kvarh").equals("")) {
                                            VkWhKVARH = ((10000 + Double.parseDouble(prmStandAkhirKVARHBaru)) - Double.parseDouble(prmStandAwalKVARHBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh")) * 1D;
                                        } else {
                                            VkWhKVARH = ((10000 + Double.parseDouble(prmStandAkhirKVARHBaru)) - Double.parseDouble(prmStandAwalKVARHBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kvarh")) * 1D;
                                        }
                                    case 5:
                                        if (!rowData.get("Faktor_kali_kvarh").equals("")) {
                                            VkWhKVARH = ((100000 + Double.parseDouble(prmStandAkhirKVARHBaru)) - Double.parseDouble(prmStandAwalKVARHBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh")) * 1D;
                                        } else {
                                            VkWhKVARH = ((100000 + Double.parseDouble(prmStandAkhirKVARHBaru)) - Double.parseDouble(prmStandAwalKVARHBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kvarh")) * 1D;
                                        }
                                    case 6:
                                        if (!rowData.get("Faktor_kali_kvarh").equals("")) {
                                            VkWhKVARH = ((1000000 + Double.parseDouble(prmStandAkhirKVARHBaru)) - Double.parseDouble(prmStandAwalKVARHBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh")) * 1D;
                                        } else {
                                            VkWhKVARH = ((1000000 + Double.parseDouble(prmStandAkhirKVARHBaru)) - Double.parseDouble(prmStandAwalKVARHBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kvarh")) * 1D;
                                        }
                                }
                            } else {
                                if (!rowData.get("Faktor_kali_kvarh").equals("")) {
                                    VkWhKVARH = (Double.parseDouble(prmStandAkhirKVARHBaru) - Double.parseDouble(prmStandAwalKVARHBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kwh")) * 1D;
                                } else {
                                    VkWhKVARH = (Double.parseDouble(prmStandAkhirKVARHBaru) - Double.parseDouble(prmStandAwalKVARHBaru)) * Double.parseDouble(rowData.get("Faktor_kali_kvarh")) * 1D;
                                }
                            }
                            //If IsNull(MyRecset1!Faktor_kali_kvarh) = True Then
                            //    VkWhKVARH = (Double.parseDouble(prmStandAkhirKVARHBaru) - Double.parseDouble(prmStandAwalKVARHBaru)) * MyRecset1!Faktor_kali_kwh
                            //Else
                            //    VkWhKVARH = (Double.parseDouble(prmStandAkhirKVARHBaru) - Double.parseDouble(prmStandAwalKVARHBaru)) * MyRecset1!Faktor_kali_kvarh
                            //End If
                            if ((VkWhKVARH * Koefisien) - (0.62 * VTotalkWh) < 0) {
                                VkWhKVARH = 0D;
                            } else {
                                VkWhKVARH = ((VkWhKVARH * Koefisien) - (0.62 * VTotalkWh));
                                A.MasukanKwh(VkWhKVARH);
                                VkWhKVARH = A.Keluarankwh()  * 1D;
                            }
                            //Else
                            //    VkWhKVARH = 0
                            //End If
                            //If MyRecset1!Kode_kVA_Maks = "V" Then
                            //    If IsNull(MyRecset1!Cos_Phi_KVAmax) = True Then
                            //        VCosPhiKVAmax = 1
                            //    Else
                            //        VCosPhiKVAmax = MyRecset1!Cos_Phi_KVAmax
                            //    End If
                            //    If IsNull(MyRecset1!Faktor_Kali_KVAmax) = True Then
                            //        VkWhKVAmax = (MyRecset1!StandKvaMaks) * 1 * VCosPhiKVAmax
                            //    Else
                            //        VkWhKVAmax = (MyRecset1!StandKvaMaks) * MyRecset1!Faktor_Kali_KVAmax * VCosPhiKVAmax
                            //    End If
                            //Else
                            //    VkWhKVAmax = 0
                            //End If
                        }

                        VTotalkWh = vkwhlwbp + VkWhWBP + VkWhBlok3;
                        sql = "INSERT INTO DILDATASTANDMETER";
                        sql = sql + " (no_kontrak,";
                        sql = sql + " no_pelanggan,";
                        sql = sql + " Bl_th_rekening,";
                        sql = sql + " kWhLWBP,";
                        sql = sql + " StandAwalLWBPkWh,";
                        sql = sql + " StandAkhirLWBPkWh,";
                        sql = sql + " StandAwalWBP,";
                        sql = sql + " StandAkhirWBP,";
                        sql = sql + " StandAwalkVARh,";
                        sql = sql + " StandAkhirkVARh,";
                        sql = sql + " tgl_transaksi_kwh,";
                        sql = sql + " tgl_catat_meter,";
                        sql = sql + " Tgl_Catat_Meter_StandAwal,";
                        sql = sql + " kWhWBP,";
                        sql = sql + " kWhBlok3,";
                        sql = sql + " TotalkWh,";
                        sql = sql + " kVARh,";
                        sql = sql + " kodepetugaspencatatan,";
                        sql = sql + " faktor_kali_meter,";
                        sql = sql + " tarif,";
                        sql = sql + " PetugasKoreksi)";
                        sql = sql + " values('" + VNoKontrak + "',";
                        sql = sql + " '" + Npelanggan + "',";
                        sql = sql + " '" + VBlThRekening + "',";
                        sql = sql + vkwhlwbp + ",";

                        if (
                                !rowData.get("Tarip").equals("S3") &&
                                !rowData.get("Tarip").equals("B3") &&
                                !rowData.get("Tarip").equals("P2") &&
                                !rowData.get("Tarip").equals("I2") &&
                                !rowData.get("Tarip").equals("I3") &&
                                !rowData.get("Tarip").equals("I4")
                            ) {
                            sql = sql + prmStandAwalLWBPBaru + ",";
                            sql = sql + prmStandAkhirLWBPBaru + ",";
                            sql = sql + "0,";
                            sql = sql + "0,";
                            sql = sql + "0,";
                            sql = sql + "0,";
                        } else {
                            sql = sql + prmStandAwalLWBPBaru + ",";
                            sql = sql + prmStandAkhirLWBPBaru + ",";
                            sql = sql + prmStandAwalWBPBaru + ",";
                            sql = sql + prmStandAkhirWBPBaru + ",";
                            sql = sql + prmStandAwalKVARHBaru + ",";
                            sql = sql + prmStandAkhirKVARHBaru + ",";
                        }
                        
                        sql = sql + " to_date('" + VTglCatatMeterString + "','yyyy/mm/dd'),";
                        sql = sql + " to_date('" + VTglCatatMeterString + "','yyyy/mm/dd'),";
                        sql = sql + " to_date('" + VTglCatatMeterString + "','yyyy/mm/dd'),";
                        sql = sql + VkWhWBP + ",";
                        sql = sql + VkWhBlok3 + ",";
                        sql = sql + VTotalkWh + ",";
                        sql = sql + VkWhKVARH + ",";
                        sql = sql + " 'Krs Rek',";
                        sql = sql + vfaktorkali + ",";
                        sql = sql + "'" + vtarif + "',";
                        sql = sql + " '" + prmUserName + "')";

                        cst = con.prepareCall(sql);
                        cst.execute();
                    }
                }
            }


            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Double Keluarankwh(Double InputRp) {
        Integer masukan;
        String ancho;
        Integer AUrut = 0;
        Double Bronx;

        masukan = InputRp.toString().length();

        while (masukan > 0) {
            AUrut++;
            ancho = InputRp.toString().substring(masukan, 0);
            if (InputRp.toString().substring(masukan,1) == "," || InputRp.toString().substring(masukan,1) == ".") {
                Bronx = Double.parseDouble(InputRp.toString().substring(masukan+1,1));
                if (Double.parseDouble(InputRp.toString().substring(masukan+1,1)) < 5) {
                    masukan--;
                    InputRp = Double.parseDouble(InputRp.toString().substring(1, masukan));
                } else {
                    masukan--;
                    InputRp = Double.parseDouble(InputRp.toString().substring(1, masukan)) + 1;
                }
            } else {
                masukan--;
            }
        }

        return InputRp;
    }
}
