package id.co.hans.sample.server.servlet;

import id.co.hans.sample.server.dao.MasterDao;
import id.co.hans.sample.server.utility.CommonModule;
import id.co.hans.sample.server.utility.SessionHelper;
import id.co.hans.sample.server.service.BaseService;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.inet.report.Engine;
import com.inet.report.ReportException;
import com.inet.report.ReportServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

@SuppressWarnings("serial")
public class LaporanReportServlet extends ReportServlet{

    private BaseService baseService;

    @Autowired
    private MasterDao masterDao;

    String upiHeader = "upiHeader", apHeader = "apHeader", upHeader = "upHeader",
            alamat = "alamat", petugas = "petugas", blthDesc = "blthDesc";

    final String SATUAN = "satuan",
            NAMA = "nama",
            ALAMAT = "alamat",
            NAMAUSER = "nama_user",
            UNITUPI = "unitupi",
            UNITAP = "unitap",
            UNITUP = "unitup";

    final String ERRORCODE = "errorCode",
            ERRORMSG = "errorMsg",
            REPORTDATA = "reportData";

    final int FIRSTRECORD = 0;

    int errorCode = 0;
    String errorMsg = "";


    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
        super.init(config);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void checkProperties(Engine engine, Properties prop, Object serviceRequest) throws ReportException {
        String idjenislaporan=(String) prop.get("idjenislaporan");
        baseService = WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(BaseService.class);

        //11
        if(idjenislaporan.endsWith("GetReport_11rekap")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("in_unitupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("cabang",  apHeader);
            engine.setPrompt("ranting", upHeader);
            engine.setPrompt("alamat",  alamat);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("petugascetak",petugas);

            GetReport_11rekap(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tparup"),
                    (String) prop.get("tpetugas"), (String) prop.get("kode"), (String) prop.get("tparap"),
                    (String) prop.get("in_unitupi"));
        } else if(idjenislaporan.endsWith("cetak_rekap11TglUpload")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("in_unitupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("cabang",  apHeader);
            engine.setPrompt("ranting", upHeader);
            engine.setPrompt("alamat",  alamat);
            engine.setPrompt("tglupawal",(String) prop.get("tglawal") + " SAMPAI " + (String) prop.get("tglakhir"));

            cetak_rekap11TglUpload(engine,
                    (String) prop.get("tparup"), (String) prop.get("tglawal"), (String) prop.get("tglakhir"));
        }

        //12
        else if(idjenislaporan.endsWith("GetReport_12rekapGabungan")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("in_unitupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("cabang",  apHeader);
            engine.setPrompt("ranting", upHeader);
            engine.setPrompt("alamat",  alamat);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("BULAN",blthDesc);
            engine.setPrompt("bulantahun",blthDesc);

            GetReport_12rekapGabungan(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tparup"),
                    (String) prop.get("tpetugas"), (String) prop.get("kode"), (String) prop.get("tparap"),
                    (String) prop.get("in_unitupi"));
        }

        //13
        else if(idjenislaporan.endsWith("GetReport_13rekap")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("in_unitupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("cabang",  apHeader);
            engine.setPrompt("ranting", upHeader);
            engine.setPrompt("alamat",  alamat);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);

            GetReport_13rekap(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tparap"),
                    (String) prop.get("tparup"), (String) prop.get("tpetugas"));
        }

        //21
        else if(idjenislaporan.endsWith("GetReport_21_BA")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("in_unitupi"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("unit", upHeader);
            engine.setPrompt("pengelola",  (String) prop.get("pengelola"));
            engine.setPrompt("bulantahun",blthDesc);

            GetReport_21_BA(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tparup"),
                    (String) prop.get("tpetugas"), (String) prop.get("tanggal"), (String) prop.get("tanggalend"),
                    (String) prop.get("kode"), (String) prop.get("pengelola"));
        } else if(idjenislaporan.endsWith("GetReport_21kdpp")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("in_unitupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("cabang",  apHeader);
            engine.setPrompt("ranting", upHeader);
            engine.setPrompt("alamat",  alamat);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);

            engine.setPrompt("tanggalend",(String) prop.get("tanggalend"));
            engine.setPrompt("tanggal",(String) prop.get("tanggal"));

            GetReport_21kdpp(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tparup"),
                    (String) prop.get("tpetugas"), (String) prop.get("tanggal"), (String) prop.get("tanggalend"),
                    (String) prop.get("kode"));

        } else if(idjenislaporan.equals("GetReport_21Petugas")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("in_unitupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("cabang",  apHeader);
            engine.setPrompt("ranting", upHeader);
            engine.setPrompt("alamat",  alamat);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);

            engine.setPrompt("tanggalend",(String) prop.get("tanggalend"));
            engine.setPrompt("tanggal",(String) prop.get("tanggal"));
            engine.setPrompt("kdPembayar",(String) prop.get("kdpembayar"));
            engine.setPrompt("unit",upHeader);

            GetReport_21Petugas(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tparup"),
                    (String) prop.get("tpetugas"), (String) prop.get("tanggal"), (String) prop.get("tanggalend"),
                    (String) prop.get("kode"), (String) prop.get("kdpembayar"));

        } else if(idjenislaporan.endsWith("GetReport21Restitusi")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("in_unitupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("in_unitap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("in_unitup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("in_blth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("cabang",  apHeader);
            engine.setPrompt("ranting", upHeader);
            engine.setPrompt("alamat",  alamat);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);

            GetReport21Restitusi(engine,
                    (String) prop.get("in_unitupi"), (String) prop.get("in_unitap"), (String) prop.get("in_unitup"),
                    (String) prop.get("in_blth"), (String) prop.get("in_jenis"));
        } else if(idjenislaporan.endsWith("GetReport_21rekap")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("in_unitupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("cabang",  apHeader);
            engine.setPrompt("ranting", upHeader);
            engine.setPrompt("alamat",  alamat);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);

            GetReport_21rekap(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tparup"),
                    (String) prop.get("tpetugas"), (String) prop.get("tanggal"), (String) prop.get("tanggalend"), (String) prop.get("kode"));

        } else if(idjenislaporan.endsWith("GetReport_21upload")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("in_unitupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("cabang",  apHeader);
            engine.setPrompt("ranting", upHeader);
            engine.setPrompt("alamat",  alamat);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);

            engine.setPrompt("tanggalend",(String) prop.get("tanggalend"));
            engine.setPrompt("tanggal",(String) prop.get("tanggal"));

            GetReport_21upload(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tparup"),
                    (String) prop.get("tpetugas"), (String) prop.get("tanggal"), (String) prop.get("tanggalend"), (String) prop.get("kode"));

        } else if(idjenislaporan.endsWith("GetReport_21Giral_Kode")){

            String vUnitUpUser = "", vUnitApUser = "", vUnitUpiUser = "";
            vUnitUpUser = (String) prop.get("unitpetugas");

            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", vUnitUpUser);
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                vUnitApUser = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(UNITAP);
            }

            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", vUnitApUser);
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                vUnitUpiUser = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(UNITUPI);
            }

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", vUnitUpiUser);
            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }

            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            String jenis = (String) prop.get("jenis");

            if (jenis.toUpperCase().equals("21GIRALISASIKODE")) {
                engine.setPrompt("PAR_UPI", upiHeader);
                engine.setPrompt("PAR_AP",  apHeader);
                engine.setPrompt("PAR_UP", upHeader);
                engine.setPrompt("bulan", blthDesc);
                engine.setPrompt("kode", (String) prop.get("kode"));
            } else if (jenis.toUpperCase().equals("21GIRALKODELUNAS")){
                engine.setPrompt("wilayah", upiHeader);
                engine.setPrompt("UNIT",  apHeader + " " + upHeader);
                engine.setPrompt("bulantahun", blthDesc);
                engine.setPrompt("petugascetak", petugas);
                engine.setPrompt("JUDUL", "DAFTAR GIRALISASI YANG SUDAH LUNAS");
            } else if (jenis.toUpperCase().equals("21GIRALKODEBLMLUNAS")){
                engine.setPrompt("wilayah", upiHeader);
                engine.setPrompt("UNIT",  apHeader + " " + upHeader);
                engine.setPrompt("bulantahun", blthDesc);
                engine.setPrompt("petugascetak", petugas);
                engine.setPrompt("JUDUL", "DAFTAR GIRALISASI YANG BELUM LUNAS");
            }

            GetReport_21Giral_Kode(engine,
                    (String) prop.get("tblth"), (String) prop.get("tpetugas"), (String) prop.get("kode"), (String) prop.get("jenis"));
        }

        // 22
        else if(idjenislaporan.endsWith("GetReport_22rekap_Global")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("in_unitupi"));
            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }

            if (!((String) prop.get("tparap")).equals("")) {
                Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
                if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                    apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                            " : " +
                            ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                }
            } else
                apHeader = "";

            if (!((String) prop.get("tparup")).equals("")) {
                Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
                if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                    upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                            " : " +
                            ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                }
            } else upHeader = "";

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("unit",  apHeader + " " + upHeader);
            engine.setPrompt("judul1", (String) prop.get("judul1"));

            GetReport_22rekap_Global(engine,
                    (String) prop.get("vjenis"), (String) prop.get("vfilterunit"), (String) prop.get("tparupi"), (String) prop.get("tparap")
                    , (String) prop.get("tparup"), (String) prop.get("tanggal"), (String) prop.get("tanggalend"));
        }

        else if(idjenislaporan.endsWith("GetReport_22kdpp")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("in_unitupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("cabang",  apHeader);
            engine.setPrompt("ranting", upHeader);
            engine.setPrompt("alamat",  alamat);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);

            engine.setPrompt("tanggalend",(String) prop.get("tanggalend"));
            engine.setPrompt("tanggal",(String) prop.get("tanggal"));

            GetReport_22kdpp(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tanggal"), (String) prop.get("tanggalend")
                    , (String) prop.get("tparup"), (String) prop.get("kode"));
        }

        else if(idjenislaporan.endsWith("GetReport_22petugas")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("in_unitupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("UNIT",  apHeader + " " + upHeader);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);

            engine.setPrompt("tanggalend",(String) prop.get("tanggalend"));
            engine.setPrompt("tanggal",(String) prop.get("tanggal"));
            engine.setPrompt("KDPEMBAYAR",(String) prop.get("kdpembayar"));

            GetReport_22petugas(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tparup"), (String) prop.get("tpetugas")
                    , (String) prop.get("tanggal"), (String) prop.get("tanggalend"), (String) prop.get("kode"),
                    (String) prop.get("kdpembayar"), (String) prop.get("satm"));

        }
        else if(idjenislaporan.endsWith("GetReport_22petugasDaya")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("in_unitupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("UNIT",  apHeader + " " + upHeader);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);

            engine.setPrompt("tanggalend",(String) prop.get("tanggalend"));
            engine.setPrompt("tanggal",(String) prop.get("tanggal"));
            engine.setPrompt("KDPEMBAYAR",(String) prop.get("kdpembayar"));

            GetReport_22petugasDaya(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tparup"), (String) prop.get("tpetugas")
                    , (String) prop.get("tanggal"), (String) prop.get("tanggalend"), (String) prop.get("kode"),
                    (String) prop.get("kdpembayar"), (String) prop.get("satm"), (String) prop.get("vdayaawal"), (String) prop.get("vdayaakhir"));

        }
        else if(idjenislaporan.endsWith("GetReport_22rekap_V3")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("cabang",  apHeader);
            engine.setPrompt("ranting", upHeader);
            engine.setPrompt("alamat",  alamat);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);

            GetReport_22rekap_V2(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tparup"), (String) prop.get("tparap")
                    , (String) prop.get("tparupi"), (String) prop.get("tpetugas"), (String) prop.get("kode"));
        }

        //23
        else if(idjenislaporan.endsWith("GetReport_23Kirim_Rekap")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tthbl"));

            engine.setPrompt("par_upi", upiHeader);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("judul",(String) prop.get("judul"));
            engine.setPrompt("unit",apHeader + " " + upHeader);

            GetReport_23Kirim_Rekap(engine,
                    (String) prop.get("tthbl"), (String) prop.get("tparup"), (String) prop.get("tpetugas"));

        }
        else if(idjenislaporan.endsWith("GetReport_23Kirim_Daftar")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tthbl"));

            engine.setPrompt("par_upi", upiHeader);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("judul",(String) prop.get("judul"));
            engine.setPrompt("unit",apHeader + " " + upHeader);

            GetReport_23Kirim_Daftar(engine,
                    (String) prop.get("tthbl"), (String) prop.get("tparup"), (String) prop.get("tpetugas"));
        }
        else if(idjenislaporan.endsWith("GetReport_23Terima_Rekap")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tthbl"));

            engine.setPrompt("par_upi", upiHeader);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("judul",(String) prop.get("judul"));
            engine.setPrompt("unit",apHeader + " " + upHeader);

            GetReport_23Terima_Rekap(engine,
                    (String) prop.get("tthbl"), (String) prop.get("tparup"), (String) prop.get("tpetugas"));
        }
        else if(idjenislaporan.endsWith("GetReport_23Terima_Daftar")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tthbl"));

            engine.setPrompt("par_upi", upiHeader);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("judul",(String) prop.get("judul"));
            engine.setPrompt("unit",apHeader + " " + upHeader);

            GetReport_23Terima_Daftar(engine,
                    (String) prop.get("tthbl"), (String) prop.get("tparup"), (String) prop.get("tpetugas"));
        }
        else if(idjenislaporan.endsWith("GetReport_23Nota_Kode")){

            String vUnitUpUser = "", vUnitApUser = "", vUnitUpiUser = "";
            vUnitUpUser = (String) prop.get("unitpetugas");

            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", vUnitUpUser);
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                vUnitApUser = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(UNITAP);
            }

            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", vUnitApUser);
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                vUnitUpiUser = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(UNITUPI);
            }

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", vUnitUpiUser);
            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }

            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            String jenis = (String) prop.get("jenis");

            if (jenis.toUpperCase().equals("23NOTAKODESEMUA")) {
                engine.setPrompt("PAR_UPI", upiHeader);
                engine.setPrompt("UNIT",  apHeader + " " + upHeader);
                engine.setPrompt("kota", "");
                engine.setPrompt("bulan", blthDesc);
                engine.setPrompt("kode", (String) prop.get("kode"));
                engine.setPrompt("judul", (String) prop.get("judul"));
            } else if (jenis.toUpperCase().equals("23NOTAKODELUNAS")){
                engine.setPrompt("wilayah", upiHeader);
                engine.setPrompt("UNIT",  apHeader + " " + upHeader);
                engine.setPrompt("bulantahun", blthDesc);
                engine.setPrompt("petugascetak", petugas);
                engine.setPrompt("JUDUL", "DAFTAR YANG SUDAH LUNAS");
            } else if (jenis.toUpperCase().equals("23NOTAKODEBLMLUNAS")){
                engine.setPrompt("wilayah", upiHeader);
                engine.setPrompt("UNIT",  apHeader + " " + upHeader);
                engine.setPrompt("bulantahun", blthDesc);
                engine.setPrompt("petugascetak", petugas);
                engine.setPrompt("JUDUL", "DAFTAR YANG BELUM LUNAS");
            }
            GetReport_23Nota_Kode(engine,
                    (String) prop.get("tblth"), (String) prop.get("tpetugas"), (String) prop.get("kode")
                    , (String) prop.get("jenis"), (String) prop.get("ibebankantor"));
        }
        else if(idjenislaporan.endsWith("GetReport_23dltrekap")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("cabang",apHeader);
            engine.setPrompt("ranting",upHeader);
            engine.setPrompt("alamat",alamat);
            engine.setPrompt("judul","DAFTAR PELUNASAN TERPUSAT");
            engine.setPrompt("judul2","TERPUSAT");

            GetReport_23dltrekap(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tparap")
                    , (String) prop.get("tparup"), (String) prop.get("tpetugas"), (String) prop.get("tanggal")
                    , (String) prop.get("kode"), (String) prop.get("tparupi"));
        }
        else if(idjenislaporan.endsWith("GetReport_23notarekap")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("cabang",apHeader);
            engine.setPrompt("ranting",upHeader);
            engine.setPrompt("alamat",alamat);
            engine.setPrompt("judul","DAFTAR PELUNASAN NOTA BUKU");
            engine.setPrompt("judul2","NOTA BUKU");

            GetReport_23notarekap(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tparap")
                    , (String) prop.get("tparup"), (String) prop.get("tpetugas"), (String) prop.get("tanggal")
                    , (String) prop.get("kode"));
        }
        else if(idjenislaporan.endsWith("GetReport_23Terpusat_Kode")){

            String vUnitUpUser = "", vUnitApUser = "", vUnitUpiUser = "";
            vUnitUpUser = (String) prop.get("unitpetugas");

            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", vUnitUpUser);
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                vUnitApUser = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(UNITAP);
            }

            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", vUnitApUser);
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                vUnitUpiUser = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(UNITUPI);
            }

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", vUnitUpiUser);
            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }

            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            String jenis = (String) prop.get("jenis");

            if (jenis.toUpperCase().equals("23TERPUSATKODE")) {
                engine.setPrompt("PAR_UPI", upiHeader);
                engine.setPrompt("UNIT",  apHeader + " " + upHeader);
                engine.setPrompt("kota", "");
                engine.setPrompt("bulan", blthDesc);
                engine.setPrompt("kode", (String) prop.get("kode"));
                //engine.setPrompt("judul", (String) prop.get("judul"));
            } else if (jenis.toUpperCase().equals("23NOTAKODELUNAS")){
                engine.setPrompt("wilayah", upiHeader);
                engine.setPrompt("unit",  apHeader + " " + upHeader);
                engine.setPrompt("bulantahun", blthDesc);
                engine.setPrompt("petugascetak", petugas);
                engine.setPrompt("JUDUL", "DAFTAR YANG SUDAH LUNAS");
            } else if (jenis.toUpperCase().equals("23NOTAKODEBLMLUNAS")){
                engine.setPrompt("wilayah", upiHeader);
                engine.setPrompt("unit",  apHeader + " " + upHeader);
                engine.setPrompt("bulantahun", blthDesc);
                engine.setPrompt("petugascetak", petugas);
                engine.setPrompt("JUDUL", "DAFTAR YANG BELUM LUNAS");
            } else if (jenis.toUpperCase().equals("23TERPUSATKODELUNAS")){
                engine.setPrompt("wilayah", upiHeader);
                engine.setPrompt("unit",  apHeader + " " + upHeader);
                engine.setPrompt("bulantahun", blthDesc);
                engine.setPrompt("petugascetak", petugas);
                engine.setPrompt("JUDUL", "DAFTAR YANG BELUM LUNAS");
            } else if (jenis.toUpperCase().equals("23TERPUSATKODEBLMLUNAS")){
                engine.setPrompt("wilayah", upiHeader);
                engine.setPrompt("unit",  apHeader + " " + upHeader);
                engine.setPrompt("bulantahun", blthDesc);
                engine.setPrompt("petugascetak", petugas);
                engine.setPrompt("JUDUL", "DAFTAR YANG BELUM LUNAS");
            }
            GetReport_23Terpusat_Kode(engine,
                    (String) prop.get("tblth"), (String) prop.get("tpetugas"), (String) prop.get("kode")
                    , (String) prop.get("jenis"));
        }

        //24
        else if(idjenislaporan.endsWith("GetReport_24notarekap")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("cabang",apHeader);
            engine.setPrompt("ranting",upHeader);
            engine.setPrompt("alamat",alamat);
            engine.setPrompt("judul",(String) prop.get("judul"));
            engine.setPrompt("judul2",(String) prop.get("juduldua"));

            GetReport_24notarekap(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tparupi")
                    , (String) prop.get("tparap"), (String) prop.get("tparup"), (String) prop.get("tpetugas")
                    , (String) prop.get("tanggal"), (String) prop.get("kode"));
        }

        //31
        else if(idjenislaporan.endsWith("GetReport_31rekap")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("cabang",apHeader);
            engine.setPrompt("ranting",upHeader);
            engine.setPrompt("alamat",alamat);

            GetReport_31rekap(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tparap")
                    , (String) prop.get("tparup"), (String) prop.get("tpetugas"));
        }

        //32
        else if(idjenislaporan.endsWith("GetReport_32rekap")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("cabang",apHeader);
            engine.setPrompt("ranting",upHeader);
            engine.setPrompt("alamat",alamat);

            if (((String) prop.get("vjenis")).equals("32rekapdaftar_BA"))
                engine.setPrompt("unit",apHeader + " " + upHeader);

            GetReport_32rekap(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth")
                    , (String) prop.get("tparup"), (String) prop.get("tpetugas"));
        }

        //41
        else if(idjenislaporan.endsWith("GetReport_41rekap")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("cabang",apHeader);
            engine.setPrompt("ranting",upHeader);
            engine.setPrompt("alamat",alamat);

            GetReport_41rekap(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth")
                    , (String) prop.get("tparap"), (String) prop.get("tparup"), (String) prop.get("tpetugas"));
        }

        //2122dobelbayar
        else if(idjenislaporan.endsWith("GetReport_2122DoubleBayarNew")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            //Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            //if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
            //    petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            //}

            //blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("kogol",(String) prop.get("kogol"));
            engine.setPrompt("unit",apHeader + " " + upHeader);

            GetReport_2122DoubleBayarNew(engine,
                    (String) prop.get("sunit"), (String) prop.get("sblnbayar"));
        }

        //pemda
        else if(idjenislaporan.endsWith("GetReport_Pemda")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("cabang",apHeader);
            engine.setPrompt("ranting",upHeader);

            engine.setPrompt("judul1",(String) prop.get("judulsatu"));
            engine.setPrompt("judul2",(String) prop.get("juduldua"));

            GetReport_Pemda(engine,
                    (String) prop.get("tparap"), (String) prop.get("tparup"), (String) prop.get("tblth")
                    , (String) prop.get("vjenis"), (String) prop.get("tpetugas"), (String) prop.get("in_unitupi"));
        }

        //restitusi
        else if(idjenislaporan.endsWith("GetReportRestitusi")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            //engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("alamat",alamat);
            engine.setPrompt("ranting",upHeader);
            engine.setPrompt("cabang",apHeader);
            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("blth",blthDesc);

            GetReportRestitusi(engine,
                    (String) prop.get("in_unitap"), (String) prop.get("in_unitup"), (String) prop.get("in_blth")
                    , (String) prop.get("in_jenis"));
        }

        //212223
        else if(idjenislaporan.endsWith("GetReport_BK_212223rekap")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("cabang",apHeader);
            engine.setPrompt("ranting",upHeader);
            engine.setPrompt("alamat",alamat);

            GetReport_BK_212223rekap(engine,
                    (String) prop.get("vjenis"), (String) prop.get("tblth"), (String) prop.get("tparup")
                    , (String) prop.get("tpetugas"), (String) prop.get("kode"));
        }

        //reportpantau
        else if(idjenislaporan.endsWith("getMonitoringLapSaldoTunggakan")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            //blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("bulantahun","");
            engine.setPrompt("cabang",apHeader);
            engine.setPrompt("ranting",upHeader);
            engine.setPrompt("alamat",alamat);

            engine.setPrompt("tanggal","");
            engine.setPrompt("judulsatu",(String) prop.get("judulsatu"));
            engine.setPrompt("juduldua",(String) prop.get("juduldua"));

            getMonitoringLapSaldoTunggakan(engine,
                    (String) prop.get("in_jenis"), (String) prop.get("in_unitupi"), (String) prop.get("in_unitap")
                    , (String) prop.get("in_unitup"));
        }
        else if(idjenislaporan.endsWith("GetTunggakanPemda")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("blth",blthDesc);
            engine.setPrompt("cabang",apHeader);
            engine.setPrompt("ranting",upHeader);
            engine.setPrompt("alamat",alamat);

            engine.setPrompt("judul",(String) prop.get("judul"));

            GetTunggakanPemda(engine,
                    (String) prop.get("in_unitupi"), (String) prop.get("in_unitap"), (String) prop.get("in_unitup")
                    , (String) prop.get("in_blth"), (String) prop.get("in_jenis"));
        }
        else if(idjenislaporan.endsWith("PemantauanJurnal")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("cabang",apHeader);
            engine.setPrompt("ranting",upHeader);
            engine.setPrompt("alamat",alamat);
            engine.setPrompt("petugascetak",petugas);

            engine.setPrompt("judulsatu",(String) prop.get("judulsatu"));
            engine.setPrompt("juduldua",(String) prop.get("juduldua"));
            engine.setPrompt("tanggal",(String) prop.get("ttglmulai"));
            engine.setPrompt("tanggalend",(String) prop.get("ttglsampai"));

            PemantauanJurnal(engine,
                    (String) prop.get("vpilihtgl"), (String) prop.get("tunitup"), (String) prop.get("tunitap")
                    , (String) prop.get("ttglmulai"), (String) prop.get("ttglsampai"), (String) prop.get("tblth"));
        }
        else if(idjenislaporan.endsWith("PemantauanSaldo")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("cabang",apHeader);
            engine.setPrompt("ranting",upHeader);
            engine.setPrompt("alamat",alamat);
            engine.setPrompt("petugascetak",petugas);

            engine.setPrompt("judulsatu",(String) prop.get("judulsatu"));
            engine.setPrompt("juduldua",(String) prop.get("juduldua"));
            engine.setPrompt("tanggal",(String) prop.get("ttglmulai"));
            engine.setPrompt("tanggalend",(String) prop.get("ttglsampai"));

            PemantauanSaldo(engine,
                    (String) prop.get("vpilihsaldo"), (String) prop.get("vpilihrep"), (String) prop.get("tunitup")
                    , (String) prop.get("tunitap"), (String) prop.get("ttglmulai"), (String) prop.get("tbltttglsampai")
                    , (String) prop.get("tblth"), (String) prop.get("in_unitupi"));
        }
        else if(idjenislaporan.endsWith("PemantauanTransaksi")){
            String vUnitUpUser = "", vUnitApUser = "", vUnitUpiUser = "";
            vUnitUpUser = (String) prop.get("tparup");

            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", vUnitUpUser);
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
                vUnitApUser = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(UNITAP);
            }

            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", vUnitApUser);
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                vUnitUpiUser = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(UNITUPI);
            }

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", vUnitUpiUser);
            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }

            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("cabang",apHeader);
            engine.setPrompt("ranting",upHeader);
            engine.setPrompt("alamat",alamat);

            engine.setPrompt("judulsatu",(String) prop.get("judulsatu"));
            engine.setPrompt("juduldua",(String) prop.get("juduldua"));
            engine.setPrompt("tanggal",(String) prop.get("ttglmulai"));
            engine.setPrompt("tanggalend",(String) prop.get("ttglsampai"));

            PemantauanTransaksi(engine,
                    (String) prop.get("transaksi"), (String) prop.get("vjenis"), (String) prop.get("vpilihtgl")
                    , (String) prop.get("tunitkj"), (String) prop.get("tunitup"), (String) prop.get("tunitap")
                    , (String) prop.get("ttglmulai"), (String) prop.get("ttglsampai"), (String) prop.get("tkdpp")
                    , (String) prop.get("tkdpembayar")
                    , (String) prop.get("tkode"));
        }
        else if(idjenislaporan.endsWith("PemantauanBatalTransaksi")){
            String vUnitUpUser = "", vUnitApUser = "", vUnitUpiUser = "";
            vUnitUpUser = (String) prop.get("tparup");

            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", vUnitUpUser);
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                vUnitApUser = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(UNITAP);
            }

            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", vUnitApUser);
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                vUnitUpiUser = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(UNITUPI);
            }

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", vUnitUpiUser);
            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }

            Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));
            if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
                petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("petugascetak",petugas);
            engine.setPrompt("cabang",apHeader);
            engine.setPrompt("ranting",upHeader);
            engine.setPrompt("alamat",alamat);

            engine.setPrompt("judulsatu",(String) prop.get("judulsatu"));
            engine.setPrompt("juduldua",(String) prop.get("juduldua"));
            engine.setPrompt("tanggal",((String) prop.get("ttglmulai")).substring(6,8));
            engine.setPrompt("tanggalend",((String) prop.get("ttglsampai")).substring(6,8));

            PemantauanBatalTransaksi(engine,
                    (String) prop.get("transaksi"), (String) prop.get("vjenis"), (String) prop.get("vpilihtgl")
                    , (String) prop.get("tunitkj"), (String) prop.get("tunitup"), (String) prop.get("tunitap")
                    , (String) prop.get("ttglmulai"), (String) prop.get("ttglsampai"), (String) prop.get("tkdpp")
                    , (String) prop.get("tkdpembayar")
                    , (String) prop.get("tkode"));
        }

        //tul
        else if(idjenislaporan.endsWith("ambilLaporan404")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            //Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            //if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
            //    petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            //}

            blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("wilayah", upiHeader);
            engine.setPrompt("bulantahun",blthDesc);
            engine.setPrompt("cabang",apHeader);
            engine.setPrompt("ranting",upHeader);
            engine.setPrompt("alamat",alamat);

            engine.setPrompt("pembukuan",(String) prop.get("pembukuan"));

            ambilLaporan404(engine,
                    (String) prop.get("parup"), (String) prop.get("parunsur"), (String) prop.get("thbl")
                    , (String) prop.get("petugas"), (String) prop.get("pembukuan"), (String) prop.get("satuan"));
        }
        else if(idjenislaporan.endsWith("ambilLaporanV02")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("tparupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("tparap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("tparup"));
            //Map<String, Object> wsDataUser = masterDao.getMasterUser((String) prop.get("tpetugas"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }
            //if ((List<Map<String,String>>)wsDataUser.get("wsReturn") != null) {
            //    petugas = ((List<Map<String,String>>)wsDataUser.get("wsReturn")).get(FIRSTRECORD).get(NAMAUSER);
            //}

            //blthDesc = getBulanTahunDesc((String) prop.get("tblth"));

            engine.setPrompt("par_upi", upiHeader);
            engine.setPrompt("unit",apHeader + " " + upHeader);
            engine.setPrompt("judul",(String) prop.get("judul"));

            ambilLaporanV02(engine,
                    (String) prop.get("parup"), (String) prop.get("pargol"), (String) prop.get("thbl")
                    , (String) prop.get("petugas"));
        }

        //PRR
        else if(idjenislaporan.endsWith("prr_getLampiran")){

            Map<String, Object> wsDataUpi = masterDao.getMasterUnit("UPI_BY_REPORT", "", (String) prop.get("unitupi"));
            Map<String, Object> wsDataAp = masterDao.getMasterUnit("AP_BY_REPORT", "", (String) prop.get("unitap"));
            Map<String, Object> wsDataUp = masterDao.getMasterUnit("UP_BY_REPORT", "", (String) prop.get("unitup"));

            if ((List<Map<String,String>>)wsDataUpi.get("wsReturn") != null) {
                upiHeader = ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUpi.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataAp.get("wsReturn") != null) {
                apHeader = ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataAp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
            }
            if ((List<Map<String,String>>)wsDataUp.get("wsReturn") != null) {
                upHeader = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(SATUAN) +
                        " : " +
                        ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(NAMA);
                alamat = ((List<Map<String,String>>)wsDataUp.get("wsReturn")).get(FIRSTRECORD).get(ALAMAT);
            }

            blthDesc = getBulanTahunDesc((String) prop.get("blth"));

            String lampiran = (String) prop.get("lampiran");

            if (lampiran.equals("Lampiran VIIIA")) {
                engine.setPrompt("KD", upiHeader);
                engine.setPrompt("UNITAPJ", apHeader);
                engine.setPrompt("UNITUP", upHeader);
                engine.setPrompt("THBL", blthDesc);
                engine.setPrompt("UNSUR", (String) prop.get("unsur"));
                engine.setPrompt("PEMBUKUAN", (String) prop.get("pembukuan"));
            } else if (lampiran.equals("Laporan Pelunasan PRR")) {
                engine.setPrompt("NAMAUPI", upiHeader);
                engine.setPrompt("NAMAAP", apHeader);
                engine.setPrompt("NAMAUP", upHeader);
                engine.setPrompt("TGLMULAI", (String) prop.get("tglmulai"));
                engine.setPrompt("TGLSAMPAI", (String) prop.get("tglsampai"));
            } else if (lampiran.equals("Laporan Pelunasan Ex PRR")) {
                engine.setPrompt("NAMAUPI", upiHeader);
                engine.setPrompt("NAMAAP", apHeader);
                engine.setPrompt("NAMAUP", upHeader);
                engine.setPrompt("TGLMULAI", (String) prop.get("tglmulai"));
                engine.setPrompt("TGLSAMPAI", (String) prop.get("tglsampai"));
            } else if (lampiran.equals("Laporan Daftar PRR")) {
                engine.setPrompt("KD", upiHeader);
                engine.setPrompt("UNITAP", apHeader);
                engine.setPrompt("UNITUP", upHeader);
                engine.setPrompt("BLTH", blthDesc);
            } else if (lampiran.equals("Laporan Daftar Penghapusan PRR")) {
                engine.setPrompt("NAMAUPI", upiHeader);
                engine.setPrompt("NAMAAP", apHeader);
                engine.setPrompt("NAMAUP", upHeader);
                engine.setPrompt("BLTH", blthDesc);
            } else if (lampiran.equals("Pendukung Daftar Penghapusan PRRA")) {
                engine.setPrompt("NAMAUPI", upiHeader);
                engine.setPrompt("NAMAAP", apHeader);
                engine.setPrompt("NAMAUP", upHeader);
                engine.setPrompt("BLTH", blthDesc);
            } else if (lampiran.equals("Pendukung Daftar Penghapusan PRRB")) {
                engine.setPrompt("NAMAUPI", upiHeader);
                engine.setPrompt("NAMAAP", apHeader);
                engine.setPrompt("NAMAUP", upHeader);
                engine.setPrompt("BLTH", blthDesc);
            } else if (lampiran.equals("Lampiran VIIIB")) {
                engine.setPrompt("NAMAUPI", upiHeader);
                engine.setPrompt("NAMAAP", apHeader);
                engine.setPrompt("NAMAUP", upHeader);
                engine.setPrompt("BLTH", blthDesc);
            }

            prr_getLampiran(engine,
                    (String) prop.get("unitupi"), (String) prop.get("unitap"), (String) prop.get("unitup")
                    , (String) prop.get("blth"), (String) prop.get("lampiran"), (String) prop.get("no")
                    , (String) prop.get("idpel"), (String) prop.get("unsur"), (String) prop.get("pembukuan")
                    , (String) prop.get("tglmulai"), (String) prop.get("tglsampai"));
        }
    }

    @Override
    public void checkHtmlPageProperties(Properties props)
            throws ReportException {
        props.put("title", "ICON+ : Report Viewer");
    }

    private String getBulanTahunDesc(String blth) {
        String returnValue = "";

        if (blth.trim().length() == 0)
            return "";

        String bulan = blth.substring(4,6);
        String tahun = blth.substring(0,4);

        if (bulan.equals("01")) {
            returnValue = "JANUARI " + tahun;
        } else if (bulan.equals("02")) {
            returnValue = "FEBRUARI " + tahun;
        } else if (bulan.equals("03")) {
            returnValue = "MARET " + tahun;
        } else if (bulan.equals("04")) {
            returnValue = "APRIL " + tahun;
        } else if (bulan.equals("05")) {
            returnValue = "MEI " + tahun;
        } else if (bulan.equals("06")) {
            returnValue = "JUNI " + tahun;
        } else if (bulan.equals("07")) {
            returnValue = "JULI " + tahun;
        } else if (bulan.equals("08")) {
            returnValue = "AGUSTUS " + tahun;
        } else if (bulan.equals("09")) {
            returnValue = "SEPTEMBER " + tahun;
        } else if (bulan.equals("10")) {
            returnValue = "OKTOBER " + tahun;
        } else if (bulan.equals("11")) {
            returnValue = "NOPEMBER " + tahun;
        } else if (bulan.equals("12")) {
            returnValue = "DESEMBER " + tahun;
        } else {
            returnValue = blth;
        }

        return returnValue;
    }

    //11
    private void GetReport_11rekap(Engine engine,
                                   String vJenis, String tBLTH, String tparUp,
                                   String tPetugas, String kode, String tparAP,
                                   String in_unitupi) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_11rekap(engine, vJenis, tBLTH, tparUp, tPetugas, kode, tparAP, in_unitupi);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }

    private void cetak_rekap11TglUpload(Engine engine, String tparUp, String tglAwal, String tglAkhir) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().cetak_rekap11TglUpload(engine, tparUp, tglAwal, tglAkhir);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }

    //12
    private void GetReport_12rekapGabungan(Engine engine,
                                           String vJenis, String tBLTH, String tparUp,
                                           String tPetugas, String kode, String tparAP,
                                           String in_unitupi) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_12rekapGabungan(engine, vJenis, tBLTH, tparUp, tPetugas, kode, tparAP, in_unitupi);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }

    //13
    private void GetReport_13rekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp,
                                   String tPetugas) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_13rekap(engine, vJenis, tBLTH, tparAp, tparUp, tPetugas);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }

    //21
    private void GetReport_21_BA(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                String tanggal, String tanggalend, String kode, String pengelola) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_21_BA(engine, vJenis, tBLTH, tparUp, tPetugas,
                                                           tanggal, tanggalend, kode, pengelola);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    private void GetReport_21kdpp(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                  String tanggal, String tanggalend, String kode) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_21kdpp(engine, vJenis, tBLTH, tparUp, tPetugas,
                                                            tanggal, tanggalend, kode);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    private void GetReport_21Petugas(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                     String tanggal, String tanggalend, String kode, String kdPembayar) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_21Petugas(engine, vJenis, tBLTH, tparUp, tPetugas,
                                                               tanggal, tanggalend, kode, kdPembayar);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    private void GetReport21Restitusi(Engine engine, String in_unitupi, String in_unitap, String in_unitup, String in_blth,
                                      String in_jenis) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport21Restitusi(engine, in_unitupi, in_unitap, in_unitup, in_blth, in_jenis);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    private void GetReport_21rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                  String tanggal, String tanggalend, String kode) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_21rekap(engine, vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void GetReport_21upload(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas,
                                   String tanggal, String tanggalend, String kode) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_21upload(engine, vJenis, tBLTH, tparUp, tPetugas,
                    tanggal, tanggalend, kode);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void GetReport_21Giral_Kode(Engine engine, String tBLTH, String tPetugas, String kode,
                                       String jenis) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_21Giral_Kode(engine, tBLTH, tPetugas, kode,
                    jenis);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }


    //22
    public void GetReport_22rekap_Global(Engine engine, String vJenis, String vFilterUnit, String tparUpi,
                                         String tparAp, String tparUp, String tanggal, String tanggalend) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_22rekap_Global(engine, vJenis, vFilterUnit, tparUpi,
                    tparAp, tparUp, tanggal, tanggalend);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void GetReport_22kdpp(Engine engine, String vJenis, String tBLTH, String tanggal,
                                 String tanggalend, String tparUp, String kode) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_22kdpp(engine, vJenis, tBLTH, tanggal,
                    tanggalend, tparUp, kode);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void GetReport_22petugas(Engine engine, String vJenis, String tBLTH, String tparUp,
                                    String tPetugas, String tanggal, String tanggalend,
                                    String kode, String kdPembayar, String sATM) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_22petugas(engine, vJenis, tBLTH, tparUp,
                    tPetugas, tanggal, tanggalend,
                    kode, kdPembayar, sATM);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void GetReport_22petugasDaya(Engine engine, String vJenis, String tBLTH, String tparUp,
                                        String tPetugas, String tanggal, String tanggalend,
                                        String kode, String kdPembayar, String sATM,
                                        String vDayaAwal, String vDayaAkhir) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_22petugasDaya(engine, vJenis, tBLTH, tparUp,
                    tPetugas, tanggal, tanggalend,
                    kode, kdPembayar, sATM, vDayaAwal, vDayaAkhir);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void GetReport_22rekap_V2(Engine engine, String vJenis, String tBLTH, String tparUp,
                                     String tparAp, String tparUpi, String tPetugas,
                                     String kode) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_22rekap_V2(engine, vJenis, tBLTH, tparUp,
                    tparAp, tparUpi, tPetugas,
                    kode);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }


    //23
    public void GetReport_23Kirim_Rekap(Engine engine, String tThbl, String tParUp, String tPetugas) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_23Kirim_Rekap(engine, tThbl, tParUp, tPetugas);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void GetReport_23Kirim_Daftar(Engine engine, String tThbl, String tParUp, String tPetugas) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_23Kirim_Daftar(engine, tThbl, tParUp, tPetugas);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void GetReport_23Terima_Rekap(Engine engine, String tThbl, String tParUp, String tPetugas) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_23Terima_Rekap(engine, tThbl, tParUp, tPetugas);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void GetReport_23Terima_Daftar(Engine engine, String tThbl, String tParUp, String tPetugas) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_23Terima_Daftar(engine, tThbl, tParUp, tPetugas);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void GetReport_23Nota_Kode(Engine engine, String tBLTH, String tPetugas, String kode, String jenis, String iBebanKantor) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_23Nota_Kode(engine, tBLTH, tPetugas, kode, jenis, iBebanKantor);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void GetReport_23dltrekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp, String tPetugas,
                                     String tanggal, String kode, String tparUPI) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_23dltrekap(engine, vJenis, tBLTH, tparAp, tparUp, tPetugas,
                     tanggal, kode, tparUPI);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void GetReport_23notarekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp, String tPetugas,
                                      String tanggal, String kode) throws ReportException {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_23notarekap(engine, vJenis, tBLTH, tparAp, tparUp, tPetugas,
                     tanggal, kode);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void GetReport_23Terpusat_Kode(Engine engine, String tBLTH, String tPetugas, String kode, String jenis) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_23Terpusat_Kode(engine, tBLTH, tPetugas, kode, jenis);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }

    //24
    public void GetReport_24notarekap(Engine engine, String vJenis, String tBLTH, String tparUPI, String tparAp, String tparUp,
                                      String tPetugas, String tanggal, String kode) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_24notarekap( engine, vJenis, tBLTH, tparUPI, tparAp, tparUp,
                    tPetugas, tanggal, kode);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }

    //31
    public void GetReport_31rekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp, String tPetugas) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_31rekap(engine, vJenis, tBLTH, tparAp, tparUp, tPetugas);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }

    //32
    public void GetReport_32rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_32rekap(engine, vJenis, tBLTH, tparUp, tPetugas);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }

    //41
    public void GetReport_41rekap(Engine engine, String vJenis, String tBLTH, String tparAp, String tparUp, String tPetugas) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_41rekap(engine, vJenis, tBLTH, tparAp, tparUp, tPetugas);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }

    //2122dobelbayar
    public void GetReport_2122DoubleBayarNew(Engine engine, String sUnit, String sBlnBayar) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_2122DoubleBayarNew(engine, sUnit, sBlnBayar);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }

    //pemda
    public void GetReport_Pemda(Engine engine, String tparAP, String tparUp, String tBLTH, String vJenis, String tPetugas, String in_unitupi) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_Pemda( engine, tparAP, tparUp, tBLTH, vJenis, tPetugas, in_unitupi);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }

    //restitusi
    public void GetReportRestitusi(Engine engine, String in_unitap, String in_unitup, String in_blth, String in_jenis) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReportRestitusi(engine, in_unitap, in_unitup, in_blth, in_jenis);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }

    //212223
    public void GetReport_BK_212223rekap(Engine engine, String vJenis, String tBLTH, String tparUp, String tPetugas, String kode) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetReport_BK_212223rekap(engine, vJenis, tBLTH, tparUp, tPetugas, kode);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }

    //reportpantau
    public void getMonitoringLapSaldoTunggakan(Engine engine, String in_jenis, String in_unitupi, String in_unitap, String in_unitup) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().getLaporanMonitoringTunggakan(engine, in_jenis, in_unitupi, in_unitap, in_unitup);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void GetTunggakanPemda(Engine engine, String in_unitupi, String in_unitap, String in_unitup, String in_blth, String in_jenis) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().GetTunggakanPemda(engine, in_unitupi, in_unitap, in_unitup, in_blth, in_jenis);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void PemantauanJurnal(Engine engine, String vPilihTgl, String tUnitUP, String tUnitAP, String tTglmulai, String tTglsampai
            , String tBlTh) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().PemantauanJurnal(engine, vPilihTgl, tUnitUP, tUnitAP, tTglmulai, tTglsampai, tBlTh);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void PemantauanSaldo(Engine engine, String vPilihSaldo, String vPilihRep, String tUnitUP, String tUnitAP, String tTglmulai
            , String tTglsampai, String tBlTh, String in_unitupi) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().PemantauanSaldo( engine, vPilihSaldo, vPilihRep, tUnitUP, tUnitAP, tTglmulai
                    , tTglsampai, tBlTh, in_unitupi);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void PemantauanTransaksi(Engine engine, String Transaksi, String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP
            , String tUnitAP, String tTglmulai, String tTglsampai, String tKdpp, String tKdPembayar, String tKode) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().PemantauanTransaksi( engine, Transaksi, vJenis, vPilihTgl, tUnitKJ, tUnitUP
                    , tUnitAP, tTglmulai, tTglsampai, tKdpp, tKdPembayar, tKode);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void PemantauanBatalTransaksi(Engine engine, String Transaksi, String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP
            , String tUnitAP, String tTglmulai, String tTglsampai, String tKdpp, String tKdPembayar, String tKode) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().PemantauanBatalTransaksi( engine, Transaksi, vJenis, vPilihTgl, tUnitKJ, tUnitUP
                    , tUnitAP, tTglmulai, tTglsampai, tKdpp, tKdPembayar, tKode);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }

    //tul
    public void ambilLaporan404(Engine engine, String parUp, String parUnsur, String thbl, String petugas, String pembukuan
            , String satuan) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().ambilLaporan404( engine, parUp, parUnsur, thbl, petugas, pembukuan
                    , satuan);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }
    public void ambilLaporanV02(Engine engine, String parUp, String parGol, String thbl, String petugas) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().ambilLaporanV02(engine, parUp, parGol, thbl, petugas);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }

    //PRR
    public void prr_getLampiran(Engine engine, String unitupi, String unitap, String unitup, String blth, String lampiran, String no,
                                String idpel, String unsur, String pembukuan, String tglmulai, String tglsampai) throws ReportException  {
        try{
            Map<String, Object> dataStatus = baseService.getReportService().prr_getLampiran( engine, unitupi, unitap, unitup, blth, lampiran, no,
                    idpel, unsur, pembukuan, tglmulai, tglsampai);

            errorCode = 0;
            if ((Integer)dataStatus.get(ERRORCODE) != 0) {
                errorCode = (Integer)dataStatus.get(ERRORCODE);
                errorMsg = (String)dataStatus.get(ERRORMSG);
                throw new Exception(errorMsg);
            }
        }catch(Exception ex){
            CommonModule.getLogger(this).info("Servlet Error : "+ ex.getMessage());
        }

        if (errorCode != 0)
            throw new ReportException(errorMsg, errorCode);
    }

}
