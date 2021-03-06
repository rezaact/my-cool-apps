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

public class Form_Report21_Unit {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    ComboTahunBulan cbTahunBulan;

    TextButton bBottomRekapitulasiPerPaymentPoint;
    TextButton bBottomRekapitulasiPerTanggal;
    TextButton bBottomRekapitulasiRekgBerjalanTunggakan;
    TextButton bBottomRekapitulasiPerGolonganTarip;

    TextButton bBottomMilikSendiriRekapitulasiPerPaymentPoint;
    TextButton bBottomMilikSendiriRekapitulasiPerTanggal;
    TextButton bBottomMilikSendiriRekapitulasiBahan404;

    TextButton bBottomDiRoamingRekapitulasiPerUnitUpKirim;
    TextButton bBottomDiRoamingRekapitulasiPerTanggal;
    TextButton bBottomDiRoamingRekapitulasiBahan404;

    TextButton bBottomMeRoamingRekapitulasiPerUnitUpTerima;
    TextButton bBottomMeRoamingRekapitulasiPerTanggal;
    TextButton bBottomMeRoamingRekapitulasiBahan404;


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
        panel.setHeadingText("Report 21 - Unit");
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


        cbUnits = new ComboUnits(levelUser, unitUser, 1, 1, 1);
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

        p.add(panelReferensiTgl);


        bBottomRekapitulasiPerPaymentPoint = new TextButton("Rekapitulasi Per Payment Point");
        bBottomRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        bBottomRekapitulasiRekgBerjalanTunggakan = new TextButton("Rekapitulasi Rekg Berjalan Tunggakan");
        bBottomRekapitulasiPerGolonganTarip = new TextButton("Rekapitulasi Per Golongan Tarip");

        bBottomMilikSendiriRekapitulasiPerPaymentPoint = new TextButton("Rekapitulasi Per Payment Point");
        bBottomMilikSendiriRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        bBottomMilikSendiriRekapitulasiBahan404 = new TextButton("Rekapitulasi u/ Bahan 404");

        bBottomDiRoamingRekapitulasiPerUnitUpKirim = new TextButton("Rekapitulasi Per Unit UP Kirim");
        bBottomDiRoamingRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        bBottomDiRoamingRekapitulasiBahan404 = new TextButton("Rekapitulasi u/ Bahan 404");

        bBottomMeRoamingRekapitulasiPerUnitUpTerima = new TextButton("Rekapitulasi Per Unit UP Terima");
        bBottomMeRoamingRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        bBottomMeRoamingRekapitulasiBahan404 = new TextButton("Rekapitulasi u/ Bahan 404");

        bBottomRekapitulasiPerPaymentPoint.setWidth(250);
        bBottomRekapitulasiPerTanggal.setWidth(250);
        bBottomRekapitulasiRekgBerjalanTunggakan.setWidth(250);
        bBottomRekapitulasiPerGolonganTarip.setWidth(250);

        bBottomMilikSendiriRekapitulasiPerPaymentPoint.setWidth(250);
        bBottomMilikSendiriRekapitulasiPerTanggal.setWidth(250);
        bBottomMilikSendiriRekapitulasiBahan404.setWidth(250);

        bBottomDiRoamingRekapitulasiPerUnitUpKirim.setWidth(250);
        bBottomDiRoamingRekapitulasiPerTanggal.setWidth(250);
        bBottomDiRoamingRekapitulasiBahan404.setWidth(250);

        bBottomMeRoamingRekapitulasiPerUnitUpTerima.setWidth(250);
        bBottomMeRoamingRekapitulasiPerTanggal.setWidth(250);
        bBottomMeRoamingRekapitulasiBahan404.setWidth(250);

        FramedPanel panelButton = new FramedPanel();
        panelButton.setHeadingText("Rekapitulasi");
        panelButton.setBodyStyle("background: none; padding: 5px");
        panelButton.setWidth(620);

        VerticalLayoutContainer vlcPButton = new VerticalLayoutContainer();
        panelButton.add(vlcPButton);

        HorizontalPanel hpButton = new HorizontalPanel();

        hpButton = new HorizontalPanel();
        hpButton.add(bBottomRekapitulasiPerPaymentPoint);
        hpButton.add(bBottomRekapitulasiPerTanggal);
        vlcPButton.add(hpButton);

        hpButton = new HorizontalPanel();
        hpButton.add(bBottomRekapitulasiRekgBerjalanTunggakan);
        hpButton.add(bBottomRekapitulasiPerGolonganTarip);
        vlcPButton.add(hpButton);

        p.add(panelButton);

        FramedPanel panelButtonMs = new FramedPanel();
        panelButtonMs.setHeadingText("Rekening Milik Sendiri");
        panelButtonMs.setBodyStyle("background: none; padding: 5px");
        panelButtonMs.setWidth(620);

        VerticalLayoutContainer vlcPButtonMs = new VerticalLayoutContainer();
        panelButtonMs.add(vlcPButtonMs);

        HorizontalPanel hpButtonMs = new HorizontalPanel();

        hpButtonMs = new HorizontalPanel();
        hpButtonMs.add(bBottomMilikSendiriRekapitulasiPerPaymentPoint);
        hpButtonMs.add(bBottomMilikSendiriRekapitulasiPerTanggal);
        vlcPButtonMs.add(hpButtonMs);

        hpButtonMs = new HorizontalPanel();
        hpButtonMs.add(bBottomMilikSendiriRekapitulasiBahan404);
        vlcPButtonMs.add(hpButtonMs);

        p.add(panelButtonMs);


        FramedPanel panelButtonMr = new FramedPanel();
        panelButtonMr.setHeadingText("Rekening Me-Roaming");
        panelButtonMr.setBodyStyle("background: none; padding: 5px");
        panelButtonMr.setWidth(620);

        VerticalLayoutContainer vlcPButtonMr = new VerticalLayoutContainer();
        panelButtonMr.add(vlcPButtonMr);

        HorizontalPanel hpButtonMr = new HorizontalPanel();

        hpButtonMr = new HorizontalPanel();
        hpButtonMr.add(bBottomMeRoamingRekapitulasiPerUnitUpTerima);
        hpButtonMr.add(bBottomMeRoamingRekapitulasiPerTanggal);
        vlcPButtonMr.add(hpButtonMr);

        hpButtonMr = new HorizontalPanel();
        hpButtonMr.add(bBottomMeRoamingRekapitulasiBahan404);
        vlcPButtonMr.add(hpButtonMr);

        p.add(panelButtonMr);


        FramedPanel panelButtonDr = new FramedPanel();
        panelButtonDr.setHeadingText("Rekening Di-Roaming");
        panelButtonDr.setBodyStyle("background: none; padding: 5px");
        panelButtonDr.setWidth(620);

        VerticalLayoutContainer vlcPButtonDr = new VerticalLayoutContainer();
        panelButtonDr.add(vlcPButtonDr);

        HorizontalPanel hpButtonDr = new HorizontalPanel();

        hpButtonDr = new HorizontalPanel();
        hpButtonDr.add(bBottomDiRoamingRekapitulasiPerUnitUpKirim);
        hpButtonDr.add(bBottomDiRoamingRekapitulasiPerTanggal);
        vlcPButtonDr.add(hpButtonDr);

        hpButtonDr = new HorizontalPanel();
        hpButtonDr.add(bBottomDiRoamingRekapitulasiBahan404);
        vlcPButtonDr.add(hpButtonDr);

        p.add(panelButtonDr);

        return panel;
    }

    private void initEvent() {
        bBottomRekapitulasiPerPaymentPoint.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21rekap"
                        +"&vJenis="+"21unit_pp"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+"01"
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/21/cr_21unit_pp_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomRekapitulasiPerTanggal.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21rekap"
                        +"&vJenis="+"21unit_502"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+""
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/21/cr_21unit_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomRekapitulasiRekgBerjalanTunggakan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21rekap"
                        +"&vJenis="+"21unit_404"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+""
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/21/cr_21unit_404.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomRekapitulasiPerGolonganTarip.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21rekap"
                        +"&vJenis="+"21unit_502b"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+""
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/21/cr_21unit_tarip.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomMilikSendiriRekapitulasiPerPaymentPoint.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21rekap"
                        +"&vJenis="+"21unit_mypp"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+""
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/21/cr_21unitmy_pp_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomMilikSendiriRekapitulasiPerTanggal.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21rekap"
                        +"&vJenis="+"21unit_my502"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+""
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/21/cr_21unitmy_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomMilikSendiriRekapitulasiBahan404.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21rekap"
                        +"&vJenis="+"21unit_my404"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+""
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/21/cr_21unitmy_404.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });


        bBottomDiRoamingRekapitulasiPerUnitUpKirim.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21rekap"
                        +"&vJenis="+"21unit_kirimunit"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+""
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/21/cr_21unitdiroaming_unitkirim_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomDiRoamingRekapitulasiPerTanggal.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21rekap"
                        +"&vJenis="+"21unit_kirim502"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+""
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/21/cr_21unitdiroaming_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomDiRoamingRekapitulasiBahan404.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21rekap"
                        +"&vJenis="+"21unit_kirim404"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+""
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/21/cr_21unitdiroaming_404.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });


        bBottomMeRoamingRekapitulasiPerUnitUpTerima.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21rekap"
                        +"&vJenis="+"21unit_terimaunit"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+""
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/21/cr_21unitmeroaming_unitterima_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomMeRoamingRekapitulasiPerTanggal.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21rekap"
                        +"&vJenis="+"21unit_terima502"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+""
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/21/cr_21unitmeroaming_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomMeRoamingRekapitulasiBahan404.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21rekap"
                        +"&vJenis="+"21unit_terima404"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+""
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/21/cr_21unitmeroaming_404.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
