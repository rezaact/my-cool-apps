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

public class Form_Report12_Rekap {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    Radio rGolTaripDaya;
    ComboTahunBulan cbTahunBulan;

    TextButton bBottomDaftarRekeningKoreksi;
    TextButton bBottomRekapitulasiPerTaripDiperbaikiSebelum;
    TextButton bBottomRekapitulasiPerTaripPerbaikanSesudah;
    TextButton bBottomRekapitulasiPerTanggalDiperbaikiSebelum;
    TextButton bBottomRekapitulasiPerTanggalPerbaikanSesudah;
    TextButton bBottomRekapitulasiBahan404DiperbaikiSebelum;
    TextButton bBottomRekapitulasiBahan404PerbaikanSesudah;
    TextButton bBottomRekapitulasiKoreksiRekening;
    TextButton bBottomRekapitulasiPerKodeKoreksi;

    private String idUser, levelUser, unitUser;

    public Widget asWidget(String idUser, String unitupUser, String levelUser) {
        this.idUser=idUser;
        this.unitUser=unitUser;
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
        panel.setHeadingText("Rekap 12 - Koreksi Rekening");
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


        FramedPanel panelParameter = new FramedPanel();
        panelParameter.setHeadingText("Pilih Parameter");
        panelParameter.setBodyStyle("background: none; padding: 5px");
        panelParameter.setWidth(620);

        VerticalLayoutContainer vlcPParameter = new VerticalLayoutContainer();
        panelParameter.add(vlcPParameter);


        HorizontalPanel hp1 = new HorizontalPanel();

        rGolTaripDaya = new Radio();
        rGolTaripDaya.setBoxLabel("Pilih Tahun dan Bulan Laporan");
        rGolTaripDaya.setValue(true);
        rGolTaripDaya.setWidth(80);

        hp1.add(rGolTaripDaya);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        cbTahunBulan = new ComboTahunBulan();
        cbTahunBulan.hideLabel();

        hp1.add(cbTahunBulan);
        vlcPParameter.add(hp1, new VerticalLayoutContainer.VerticalLayoutData(1,1,new Margins(0,0,0,20)));

        p.add(panelParameter);


        bBottomDaftarRekeningKoreksi = new TextButton("Daftar Rekening Koreksi");
        bBottomRekapitulasiPerTaripDiperbaikiSebelum = new TextButton("Rekapitulasi per Tarip (Diperbaiki/Sebelum)");
        bBottomRekapitulasiPerTaripPerbaikanSesudah = new TextButton("Rekapitulasi per Tarip (Perbaikan/Sesudah)");
        bBottomRekapitulasiPerTanggalDiperbaikiSebelum = new TextButton("Rekapitulasi per Tanggal (Diperbaiki/Sebelum)");
        bBottomRekapitulasiPerTanggalPerbaikanSesudah = new TextButton("Rekapitulasi per Tanggal (Perbaikan/Sesudah)");
        bBottomRekapitulasiBahan404DiperbaikiSebelum = new TextButton("Rekapitulasi u/ Bahan 404 (Diperbaiki/Sebelum)");
        bBottomRekapitulasiBahan404PerbaikanSesudah = new TextButton("Rekapitulasi u/ Bahan 404 (Perbaikan/Sesudah)");
        bBottomRekapitulasiKoreksiRekening = new TextButton("Rekapitulasi Koreksi Rekening");
        bBottomRekapitulasiPerKodeKoreksi = new TextButton("Rekapitulasi Per Kode Koreksi");

        panel.addButton(bBottomDaftarRekeningKoreksi);
        panel.addButton(bBottomRekapitulasiPerTaripDiperbaikiSebelum);
        panel.addButton(bBottomRekapitulasiPerTaripPerbaikanSesudah);
        panel.addButton(bBottomRekapitulasiPerTanggalDiperbaikiSebelum);
        panel.addButton(bBottomRekapitulasiPerTanggalPerbaikanSesudah);
        panel.addButton(bBottomRekapitulasiBahan404DiperbaikiSebelum);
        panel.addButton(bBottomRekapitulasiBahan404PerbaikanSesudah);
        panel.addButton(bBottomRekapitulasiKoreksiRekening);
        panel.addButton(bBottomRekapitulasiPerKodeKoreksi);

        ToggleGroup tg = new ToggleGroup();
        tg.add(rGolTaripDaya);

        return panel;
    }

    private void initEvent() {
        bBottomDaftarRekeningKoreksi.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_12rekapGabungan"
                        +"&vJenis="+"12RekapKoreksiRekening"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tparAP="+unitAp
                        +"&in_unitupi="+unitUpi;

                url+="&report=report/ReportMain/12/cr_RekapitulasiRekening.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerTaripDiperbaikiSebelum.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_12rekapGabungan"
                        +"&vJenis="+"12koreksipertaripsebelum"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tparAP="+unitAp
                        +"&in_unitupi="+unitUpi;

                url+="&report=report/ReportMain/12/cr_12DLAMA_tarip.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerTaripPerbaikanSesudah.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_12rekapGabungan"
                        +"&vJenis="+"12koreksipertaripsesudah"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tparAP="+unitAp
                        +"&in_unitupi="+unitUpi;

                url+="&report=report/ReportMain/12/cr_12DBARU_tarip.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerTanggalDiperbaikiSebelum.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_12rekapGabungan"
                        +"&vJenis="+"12rekap502sebelum"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tparAP="+unitAp
                        +"&in_unitupi="+unitUpi;

                url+="&report=report/ReportMain/12/cr_12DLAMA_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerTanggalPerbaikanSesudah.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_12rekapGabungan"
                        +"&vJenis="+"12rekap502sesudah"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tparAP="+unitAp
                        +"&in_unitupi="+unitUpi;

                url+="&report=report/ReportMain/12/cr_12DBARU_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiBahan404DiperbaikiSebelum.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_12rekapGabungan"
                        +"&vJenis="+"12rekap404sebelum"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tparAP="+unitAp
                        +"&in_unitupi="+unitUpi;

                url+="&report=report/ReportMain/12/cr_12DLAMA_404.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiBahan404PerbaikanSesudah.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_12rekapGabungan"
                        +"&vJenis="+"12rekap404sesudah"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tparAP="+unitAp
                        +"&in_unitupi="+unitUpi;

                url+="&report=report/ReportMain/12/cr_12DBARU_404.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiKoreksiRekening.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_12rekapGabungan"
                        +"&vJenis="+"12RekapKoreksiRekeningNew"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tparAP="+unitAp
                        +"&in_unitupi="+unitUpi;

                url+="&report=report/ReportMain/12/cr_12_Rekap.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerKodeKoreksi.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_12rekapGabungan"
                        +"&vJenis="+"12KoreksiPerKodeKoreksi"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tparAP="+unitAp
                        +"&in_unitupi="+unitUpi;

                url+="&report=report/ReportMain/12/cr_12_RekapKdKoreksi.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
