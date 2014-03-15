package id.co.hans.sample.client.form.reportmain;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.*;

public class Form_Report32_Rekap {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    ComboTahunBulan cbTahunBulan;
    ComboJenisLaporan cbJenisLaporan;

    TextButton bBottomDaftarRekeningRagu2YangDihapus;
    TextButton bBottomDaftarPerPelangganRekgRagu2Dihapus;
    TextButton bBottomBeritaAcaraPenelitianPenghapusan;
    TextButton bBottomRekapitulasiPerTanggal;
    TextButton bBottomRekapitulasiPerGolongan;
    TextButton bBottomLaporanRekapUntukBahan406;

    TextButton bBottomDaftarPerPelangganRekgRagu2DihapusKurang2Juta;
    TextButton bBottomDaftarPerPelangganRekgRagu2DihapusLebih2Juta;
    TextButton bBottomBeritaAcaraPenelitianPenghapusanTagihanLebihUjl;
    TextButton bBottomBeritaAcaraPenelitianPenghapusanTagihanKurangUjl;
    TextButton bBottomRekapitulasiPerTarip;


    private String idUser, levelUser, unitUser;

    public Widget asWidget(String idUser, String unitupUser, String levelUser) {
        this.idUser=idUser;
        this.unitUser=unitupUser;
        this.levelUser=levelUser;

        if (vp == null) {
            vp = new VerticalPanel();
            vp.setSpacing(5);
            initKomponen();
            initEvent();
        }
        return vp;
    }

    private void initKomponen(){
        AutoProgressMessageBox progressBox = new AutoProgressMessageBox("Progress", "please wait");
        progressBox.setProgressText("wait...");

        vp.add(panelMain());
    }

    private FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Rekap 32 - Penghapusan Piutang");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);


        FramedPanel panelReferensi = new FramedPanel();
        panelReferensi.setHeadingText("Pilih Referensi");
        panelReferensi.setBodyStyle("background: none; padding: 5px");
        panelReferensi.setWidth(620);

        VerticalLayoutContainer vlcPReferensi = new VerticalLayoutContainer();
        panelReferensi.add(vlcPReferensi);

        cbUnits = new ComboUnits();
        vlcPReferensi.add(cbUnits);

        p.add(panelReferensi);


        FramedPanel panelReferensiTgl = new FramedPanel();
        panelReferensiTgl.setHeadingText("Pilih Parameter");
        panelReferensiTgl.setBodyStyle("background: none; padding: 5px");
        panelReferensiTgl.setWidth(620);

        VerticalLayoutContainer vlcPReferensiTgl = new VerticalLayoutContainer();
        panelReferensiTgl.add(vlcPReferensiTgl);

        cbTahunBulan = new ComboTahunBulan();
        vlcPReferensiTgl.add(cbTahunBulan);

        cbJenisLaporan = new ComboJenisLaporan();
        vlcPReferensiTgl.add(cbJenisLaporan);

        p.add(panelReferensiTgl);


        FramedPanel panelParameter = new FramedPanel();
        panelParameter.setBodyStyle("background: none; padding: 5px");
        panelParameter.setWidth(620);

        VerticalLayoutContainer vlcPParameter = new VerticalLayoutContainer();
        panelParameter.add(vlcPParameter);

        bBottomDaftarRekeningRagu2YangDihapus = new TextButton("Daftar Rekening Ragu2 yang Dihapus");
        bBottomDaftarPerPelangganRekgRagu2Dihapus = new TextButton("Daftar per Pelanggan Rekg Ragu2 Dihapus");
        bBottomBeritaAcaraPenelitianPenghapusan = new TextButton("Berita Acara Penelitian Penghapusan");
        bBottomRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        bBottomRekapitulasiPerGolongan = new TextButton("Rekapitulasi Per Golongan");
        bBottomLaporanRekapUntukBahan406 = new TextButton("Laporan Rekapitulasi u/ Bahan 406");

        bBottomDaftarPerPelangganRekgRagu2DihapusKurang2Juta = new TextButton("Daftar per Pelanggan Rekg Ragu2 Dihapus < 2juta");
        bBottomDaftarPerPelangganRekgRagu2DihapusLebih2Juta = new TextButton("Daftar per Pelanggan Rekg Ragu2 Dihapus > 2juta");
        bBottomBeritaAcaraPenelitianPenghapusanTagihanLebihUjl = new TextButton("Berita Acara Penelitian Penghapusan Tagihan > UJL");
        bBottomBeritaAcaraPenelitianPenghapusanTagihanKurangUjl = new TextButton("Berita Acara Penelitian Penghapusan Tagihan < UJL");
        bBottomRekapitulasiPerTarip = new TextButton("Rekapitulasi Per Tarip");

        bBottomDaftarRekeningRagu2YangDihapus.setWidth(220);
        bBottomDaftarPerPelangganRekgRagu2Dihapus.setWidth(220);
        bBottomBeritaAcaraPenelitianPenghapusan.setWidth(220);
        bBottomRekapitulasiPerTanggal.setWidth(220);
        bBottomRekapitulasiPerGolongan.setWidth(220);
        bBottomLaporanRekapUntukBahan406.setWidth(220);

        bBottomDaftarPerPelangganRekgRagu2DihapusKurang2Juta.setWidth(220);
        bBottomDaftarPerPelangganRekgRagu2DihapusLebih2Juta.setWidth(220);
        bBottomBeritaAcaraPenelitianPenghapusanTagihanLebihUjl.setWidth(220);
        bBottomBeritaAcaraPenelitianPenghapusanTagihanKurangUjl.setWidth(220);
        bBottomRekapitulasiPerTarip.setWidth(220);

        HorizontalPanel hp1 = new HorizontalPanel();

        hp1.add(bBottomDaftarRekeningRagu2YangDihapus);
        hp1.add(bBottomDaftarPerPelangganRekgRagu2DihapusKurang2Juta);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomDaftarPerPelangganRekgRagu2Dihapus);
        hp1.add(bBottomDaftarPerPelangganRekgRagu2DihapusLebih2Juta);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomBeritaAcaraPenelitianPenghapusan);
        hp1.add(bBottomBeritaAcaraPenelitianPenghapusanTagihanLebihUjl);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomRekapitulasiPerTanggal);
        hp1.add(bBottomBeritaAcaraPenelitianPenghapusanTagihanKurangUjl);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomRekapitulasiPerGolongan);
        hp1.add(bBottomRekapitulasiPerTarip);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomLaporanRekapUntukBahan406);

        vlcPParameter.add(hp1);

        p.add(panelParameter);


        return panel;
    }


    private void initEvent() {
        bBottomDaftarRekeningRagu2YangDihapus.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                petugas = idUser;

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_32rekap"
                        +"&vjenis="+"32daftarrekg"
                        +"&tblth="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparup="+cbUnits.getUnitUpValue()
                        +"&tpetugas="+petugas;

                url+="&report=report/ReportMain/32/cr_32_daftar.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomDaftarPerPelangganRekgRagu2Dihapus.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                petugas = idUser;

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_32rekap"
                        +"&vjenis="+"32rekapdaftar"
                        +"&tblth="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparup="+cbUnits.getUnitUpValue()
                        +"&tpetugas="+petugas;

                url+="&report=report/ReportMain/32/cr_32_plg_daftar.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomBeritaAcaraPenelitianPenghapusan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                petugas = idUser;

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_32rekap"
                        +"&vjenis="+"32rekapdaftar_BA"
                        +"&tblth="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparup="+cbUnits.getUnitUpValue()
                        +"&tpetugas="+petugas;

                url+="&report=report/ReportMain/32/cr_32_plg_daftar_BA.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerTanggal.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                petugas = idUser;

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_32rekap"
                        +"&vjenis="+"32rekap502"
                        +"&tblth="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparup="+cbUnits.getUnitUpValue()
                        +"&tpetugas="+petugas;

                url+="&report=report/ReportMain/32/cr_32_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerGolongan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
            }
        });

        bBottomLaporanRekapUntukBahan406.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                petugas = idUser;

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_32rekap"
                        +"&vjenis="+"32rekap406"
                        +"&tblth="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparup="+cbUnits.getUnitUpValue()
                        +"&tpetugas="+petugas;

                //url+="&report=report/ReportMain/32/cr_32_tgl.rpt";

                //Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });


        //=====
        bBottomDaftarPerPelangganRekgRagu2DihapusKurang2Juta.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                petugas = idUser;

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_32rekap"
                        +"&vjenis="+"32rekapdaftar_kurang2juta"
                        +"&tblth="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparup="+cbUnits.getUnitUpValue()
                        +"&tpetugas="+petugas;

                url+="&report=report/ReportMain/32/cr_32_plg_daftar_kurang2juta.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomDaftarPerPelangganRekgRagu2DihapusLebih2Juta.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                petugas = idUser;

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_32rekap"
                        +"&vjenis="+"32rekapdaftar_lebih2juta"
                        +"&tblth="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparup="+cbUnits.getUnitUpValue()
                        +"&tpetugas="+petugas;

                url+="&report=report/ReportMain/32/cr_32_plg_daftar_lebih2juta.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomBeritaAcaraPenelitianPenghapusanTagihanLebihUjl.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                petugas = idUser;

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_32rekap"
                        +"&vjenis="+"32rekapdaftar_BA"
                        +"&tblth="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparup="+cbUnits.getUnitUpValue()
                        +"&tpetugas="+petugas;

                url+="&report=report/ReportMain/32/cr_32_plg_daftar_BA.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomBeritaAcaraPenelitianPenghapusanTagihanKurangUjl.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                petugas = idUser;

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_32rekap"
                        +"&vjenis="+"32rekapdaftar_BA"
                        +"&tblth="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparup="+cbUnits.getUnitUpValue()
                        +"&tpetugas="+petugas;

                url+="&report=report/ReportMain/32/cr_32_plg_daftar_BA.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerTarip.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                petugas = idUser;

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_32rekap"
                        +"&vjenis="+"32rekapdaftar_BA"
                        +"&tblth="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparup="+cbUnits.getUnitUpValue()
                        +"&tpetugas="+petugas;

                //url+="&report=report/ReportMain/32/cr_32_plg_daftar_BA.rpt";

                //Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
