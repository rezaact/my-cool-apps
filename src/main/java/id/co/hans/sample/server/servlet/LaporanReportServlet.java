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
}
