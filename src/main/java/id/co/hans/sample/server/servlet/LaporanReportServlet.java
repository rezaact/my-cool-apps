package id.co.hans.sample.server.servlet;

import id.co.hans.sample.server.utility.CommonModule;
import id.co.hans.sample.server.utility.SessionHelper;
import id.co.hans.sample.server.service.BaseService;

import java.util.Properties;

import com.inet.report.Engine;
import com.inet.report.ReportException;
import com.inet.report.ReportServlet;
import org.springframework.web.context.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
public class LaporanReportServlet extends ReportServlet{

    private BaseService baseService;

    @Override
    public void checkProperties(Engine engine, Properties prop, Object serviceRequest) throws ReportException {
        String idjenislaporan=(String) prop.get("idjenislaporan");
        baseService = WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(BaseService.class);

        if(idjenislaporan.endsWith("GetReport_11rekap")){
            GetReport_11rekap(engine,
                    (String) prop.get("vJenis"), (String) prop.get("tBLTH"), (String) prop.get("tparUp"),
                    (String) prop.get("tPetugas"), (String) prop.get("kode"), (String) prop.get("tparAP"),
                    (String) prop.get("in_unitupi"));
        } else if(idjenislaporan.endsWith("cetak_rekap11TglUpload")){
            cetak_rekap11TglUpload(engine,
                    (String) prop.get("tparUp"), (String) prop.get("tglAwal"), (String) prop.get("tglAkhir"));
        } else if(idjenislaporan.endsWith("GetReport_12rekapGabungan")){
            GetReport_12rekapGabungan(engine,
                    (String) prop.get("vJenis"), (String) prop.get("tBLTH"), (String) prop.get("tparUp"),
                    (String) prop.get("tPetugas"), (String) prop.get("kode"), (String) prop.get("tparAP"),
                    (String) prop.get("in_unitupi"));
        } else if(idjenislaporan.endsWith("GetReport_13rekap")){
            GetReport_13rekap(engine,
                    (String) prop.get("vJenis"), (String) prop.get("tBLTH"), (String) prop.get("tparAp"),
                    (String) prop.get("tparUp"), (String) prop.get("tPetugas"));
        } else if(idjenislaporan.endsWith("GetReport_21_BA")){
            GetReport_21_BA(engine,
                    (String) prop.get("vJenis"), (String) prop.get("tBLTH"), (String) prop.get("tparUp"),
                    (String) prop.get("tPetugas"), (String) prop.get("tanggal"), (String) prop.get("tanggalend"),
                    (String) prop.get("kode"), (String) prop.get("pengelola"));
        } else if(idjenislaporan.endsWith("GetReport_21kdpp")){
            GetReport_21kdpp(engine,
                    (String) prop.get("vJenis"), (String) prop.get("tBLTH"), (String) prop.get("tparUp"),
                    (String) prop.get("tPetugas"), (String) prop.get("tanggal"), (String) prop.get("tanggalend"),
                    (String) prop.get("kode"));
        } else if(idjenislaporan.endsWith("GetReport_21Petugas")){
            GetReport_21Petugas(engine,
                    (String) prop.get("vJenis"), (String) prop.get("tBLTH"), (String) prop.get("tparUp"),
                    (String) prop.get("tPetugas"), (String) prop.get("tanggal"), (String) prop.get("tanggalend"),
                    (String) prop.get("kode"), (String) prop.get("kdPembayar"));
        } else if(idjenislaporan.endsWith("GetReport21Restitusi")){
            GetReport21Restitusi(engine,
                    (String) prop.get("in_unitupi"), (String) prop.get("in_unitap"), (String) prop.get("in_unitup"),
                    (String) prop.get("in_blth"), (String) prop.get("in_jenis"));
        } else if(idjenislaporan.endsWith("GetReport_21rekap")){
            GetReport_21rekap(engine,
                    (String) prop.get("vJenis"), (String) prop.get("tBLTH"), (String) prop.get("tparUp"),
                    (String) prop.get("tPetugas"), (String) prop.get("tanggal"), (String) prop.get("tanggalend"), (String) prop.get("kode"));
        } else if(idjenislaporan.endsWith("GetReport_21upload")){
            GetReport_21upload(engine,
                    (String) prop.get("vJenis"), (String) prop.get("tBLTH"), (String) prop.get("tparUp"),
                    (String) prop.get("tPetugas"), (String) prop.get("tanggal"), (String) prop.get("tanggalend"), (String) prop.get("kode"));
        } else if(idjenislaporan.endsWith("GetReport_21Giral_Kode")){
            GetReport_21Giral_Kode(engine,
                    (String) prop.get("tBLTH"), (String) prop.get("tPetugas"), (String) prop.get("kode"), (String) prop.get("jenis"));
        }

        // 22
        else if(idjenislaporan.endsWith("GetReport_22rekap_Global")){
            GetReport_22rekap_Global(engine,
                    (String) prop.get("vJenis"), (String) prop.get("vFilterUnit"), (String) prop.get("tparUpi"), (String) prop.get("tparAp")
                    , (String) prop.get("tparUp"), (String) prop.get("tanggal"), (String) prop.get("tanggalend"));
        }
        else if(idjenislaporan.endsWith("GetReport_22kdpp")){
            GetReport_22kdpp(engine,
                    (String) prop.get("vJenis"), (String) prop.get("tBLTH"), (String) prop.get("tanggal"), (String) prop.get("tanggalend")
                    , (String) prop.get("tparUp"), (String) prop.get("kode"));
        }
        else if(idjenislaporan.endsWith("GetReport_22petugas")){
            GetReport_22petugas(engine,
                    (String) prop.get("vJenis"), (String) prop.get("tBLTH"), (String) prop.get("tparUp"), (String) prop.get("tPetugas")
                    , (String) prop.get("tanggal"), (String) prop.get("tanggalend"), (String) prop.get("kode"),
                    (String) prop.get("kdPembayar"), (String) prop.get("sATM"));
        }
        else if(idjenislaporan.endsWith("GetReport_22petugasDaya")){
            GetReport_22petugasDaya(engine,
                    (String) prop.get("vJenis"), (String) prop.get("tBLTH"), (String) prop.get("tparUp"), (String) prop.get("tPetugas")
                    , (String) prop.get("tanggal"), (String) prop.get("tanggalend"), (String) prop.get("kode"),
                    (String) prop.get("kdPembayar"), (String) prop.get("sATM"), (String) prop.get("vDayaAwal"), (String) prop.get("vDayaAkhir"));
        }
        else if(idjenislaporan.endsWith("GetReport_22rekap_V3")){
            GetReport_22rekap_V2(engine,
                    (String) prop.get("vJenis"), (String) prop.get("tBLTH"), (String) prop.get("tparUp"), (String) prop.get("tparAp")
                    , (String) prop.get("tparUpi"), (String) prop.get("tPetugas"), (String) prop.get("kode"));
        }

        //23
        else if(idjenislaporan.endsWith("GetReport_23Kirim_Rekap")){
            GetReport_23Kirim_Rekap(engine,
                    (String) prop.get("tThbl"), (String) prop.get("tParUp"), (String) prop.get("tPetugas"));
        }
        else if(idjenislaporan.endsWith("GetReport_23Kirim_Daftar")){
            GetReport_23Kirim_Daftar(engine,
                    (String) prop.get("tThbl"), (String) prop.get("tParUp"), (String) prop.get("tPetugas"));
        }
        else if(idjenislaporan.endsWith("GetReport_23Terima_Rekap")){
            GetReport_23Terima_Rekap(engine,
                    (String) prop.get("tThbl"), (String) prop.get("tParUp"), (String) prop.get("tPetugas"));
        }
        else if(idjenislaporan.endsWith("GetReport_23Terima_Daftar")){
            GetReport_23Terima_Daftar(engine,
                    (String) prop.get("tThbl"), (String) prop.get("tParUp"), (String) prop.get("tPetugas"));
        }
        else if(idjenislaporan.endsWith("GetReport_23Nota_Kode")){
            GetReport_23Nota_Kode(engine,
                    (String) prop.get("tBLTH"), (String) prop.get("tPetugas"), (String) prop.get("kode")
                    , (String) prop.get("jenis"), (String) prop.get("iBebanKantor"));
        }
    }

    @Override
    public void checkHtmlPageProperties(Properties props)
            throws ReportException {
        props.put("title", "ICON+ : Report Viewer");
    }


    //11
    private void GetReport_11rekap(Engine engine,
                                   String vJenis, String tBLTH, String tparUp,
                                   String tPetugas, String kode, String tparAP,
                                   String in_unitupi){
        try{
            baseService.getReportService().GetReport_11rekap(engine, vJenis, tBLTH, tparUp, tPetugas, kode, tparAP, in_unitupi);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }

    private void cetak_rekap11TglUpload(Engine engine, String tparUp, String tglAwal, String tglAkhir){
        try{
            baseService.getReportService().cetak_rekap11TglUpload(engine, tparUp, tglAwal, tglAkhir);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }

    //12
    private void GetReport_12rekapGabungan(Engine engine,
                                           String vJenis, String tBLTH, String tparUp,
                                           String tPetugas, String kode, String tparAP,
                                           String in_unitupi){
        try{
            baseService.getReportService().GetReport_12rekapGabungan(engine, vJenis, tBLTH, tparUp, tPetugas, kode, tparAP, in_unitupi);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }

    //13
    private void GetReport_13rekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp,
                                   String tPetugas){
        try{
            baseService.getReportService().GetReport_13rekap(engine, vJenis, tBLTH, tparAp, tparUp, tPetugas);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }

    //21
    private void GetReport_21_BA(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                String tanggal, String tanggalend, String kode, String pengelola) {
        try{
            baseService.getReportService().GetReport_21_BA(engine, vJenis, tBLTH, tparUp, tPetugas,
                                                           tanggal, tanggalend, kode, pengelola);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }
    private void GetReport_21kdpp(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                  String tanggal, String tanggalend, String kode) {
        try{
            baseService.getReportService().GetReport_21kdpp(engine, vJenis, tBLTH, tparUp, tPetugas,
                                                            tanggal, tanggalend, kode);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }
    private void GetReport_21Petugas(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                     String tanggal, String tanggalend, String kode, String kdPembayar) {
        try{
            baseService.getReportService().GetReport_21Petugas(engine, vJenis, tBLTH, tparUp, tPetugas,
                                                               tanggal, tanggalend, kode, kdPembayar);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }
    private void GetReport21Restitusi(Engine engine, String in_unitupi, String in_unitap, String in_unitup, String in_blth,
                                      String in_jenis) {
        try{
            baseService.getReportService().GetReport21Restitusi(engine, in_unitupi, in_unitap, in_unitup, in_blth, in_jenis);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }
    private void GetReport_21rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                  String tanggal, String tanggalend, String kode) {
        try{
            baseService.getReportService().GetReport_21rekap(engine, vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }
    public void GetReport_21upload(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                   String tanggal, String tanggalend, String kode){
        try{
            baseService.getReportService().GetReport_21upload(engine, vJenis, tBLTH, tparUp, tPetugas,
                    tanggal, tanggalend, kode);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }
    public void GetReport_21Giral_Kode(Engine engine, String tBLTH, String tPetugas, String kode,
                                       String jenis){
        try{
            baseService.getReportService().GetReport_21Giral_Kode(engine, tBLTH, tPetugas, kode,
                    jenis);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }


    //22
    public void GetReport_22rekap_Global(Engine engine, String vJenis, String vFilterUnit, String tparUpi,
                                         String tparAp, String tparUp, String tanggal, String tanggalend){
        try{
            baseService.getReportService().GetReport_22rekap_Global(engine, vJenis, vFilterUnit, tparUpi,
                    tparAp, tparUp, tanggal, tanggalend);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }
    public void GetReport_22kdpp(Engine engine, String vJenis, String tBLTH, String tanggal,
                                 String tanggalend, String tparUp, String kode){
        try{
            baseService.getReportService().GetReport_22kdpp(engine, vJenis, tBLTH, tanggal,
                    tanggalend, tparUp, kode);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }
    public void GetReport_22petugas(Engine engine, String vJenis, String tBLTH, String tparUp,
                                    String tPetugas, String tanggal, String tanggalend,
                                    String kode, String kdPembayar, String sATM){
        try{
            baseService.getReportService().GetReport_22petugas(engine, vJenis, tBLTH, tparUp,
                    tPetugas, tanggal, tanggalend,
                    kode, kdPembayar, sATM);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }
    public void GetReport_22petugasDaya(Engine engine, String vJenis, String tBLTH, String tparUp,
                                        String tPetugas, String tanggal, String tanggalend,
                                        String kode, String kdPembayar, String sATM,
                                        String vDayaAwal, String vDayaAkhir){
        try{
            baseService.getReportService().GetReport_22petugasDaya(engine, vJenis, tBLTH, tparUp,
                    tPetugas, tanggal, tanggalend,
                    kode, kdPembayar, sATM, vDayaAwal, vDayaAkhir);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }
    public void GetReport_22rekap_V2(Engine engine, String vJenis, String tBLTH, String tparUp,
                                     String tparAp, String tparUpi, String tPetugas,
                                     String kode){
        try{
            baseService.getReportService().GetReport_22rekap_V2(engine, vJenis, tBLTH, tparUp,
                    tparAp, tparUpi, tPetugas,
                    kode);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }


    //23
    public void GetReport_23Kirim_Rekap(Engine engine, String tThbl, String tParUp, String tPetugas){
        try{
            baseService.getReportService().GetReport_23Kirim_Rekap(engine, tThbl, tParUp, tPetugas);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }
    public void GetReport_23Kirim_Daftar(Engine engine, String tThbl, String tParUp, String tPetugas){
        try{
            baseService.getReportService().GetReport_23Kirim_Daftar(engine, tThbl, tParUp, tPetugas);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }
    public void GetReport_23Terima_Rekap(Engine engine, String tThbl, String tParUp, String tPetugas){
        try{
            baseService.getReportService().GetReport_23Terima_Rekap(engine, tThbl, tParUp, tPetugas);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }
    public void GetReport_23Terima_Daftar(Engine engine, String tThbl, String tParUp, String tPetugas){
        try{
            baseService.getReportService().GetReport_23Terima_Daftar(engine, tThbl, tParUp, tPetugas);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }
    public void GetReport_23Nota_Kode(Engine engine, String tBLTH, String tPetugas, String kode, String jenis, String iBebanKantor){
        try{
            baseService.getReportService().GetReport_23Nota_Kode(engine, tBLTH, tPetugas, kode, jenis, iBebanKantor);
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }
    }

}
