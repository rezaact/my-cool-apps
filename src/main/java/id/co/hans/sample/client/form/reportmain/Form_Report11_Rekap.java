package id.co.hans.sample.client.form.reportmain;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
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

import java.util.Map;

public class Form_Report11_Rekap {


    private VerticalPanel vp;

    IconAlertMessageBox mb;

    ComboUnits cbUnits;
    ComboKodeSiklis cbKdSiklis;
    Radio rGolTaripDaya;
    Radio rTanggalUpload;
    ComboTahunBulan cbTahunBulan;
    DateField dfTopTanggalAwal;
    DateField dfTopTanggalAkhir;

    TextButton bBottomRekapitulasiPerGolongan;
    TextButton bBottomRekapitulasiPerTglUpload;
    TextButton bBottomRekapitulasiPerTaripDaya;
    TextButton bBottomRekapitulasiPerInkaso;

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
        panel.setHeadingText("Rekap 11 - Rekening Baru");
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


        cbUnits = new ComboUnits(levelUser, unitUser, 0, 0, 0);
        vlcPReferensi.add(cbUnits);

        cbKdSiklis = new ComboKodeSiklis();
        vlcPReferensi.add(cbKdSiklis);

        p.add(panelReferensi);


        FramedPanel panelParameter = new FramedPanel();
        panelParameter.setHeadingText("Pilih Parameter");
        panelParameter.setBodyStyle("background: none; padding: 5px");
        panelParameter.setWidth(620);

        VerticalLayoutContainer vlcPParameter = new VerticalLayoutContainer();
        panelParameter.add(vlcPParameter);


        HorizontalPanel hp1 = new HorizontalPanel();

        rGolTaripDaya = new Radio();
        rGolTaripDaya.setBoxLabel("Pilih Bulan dan Tahun Rekening untuk Rekap per Golongan/tarip/daya");
        rGolTaripDaya.setValue(true);
        rGolTaripDaya.setWidth(80);

        hp1.add(rGolTaripDaya);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        cbTahunBulan = new ComboTahunBulan();
        cbTahunBulan.hideLabel();

        hp1.add(cbTahunBulan);
        vlcPParameter.add(hp1, new VerticalLayoutContainer.VerticalLayoutData(1,1,new Margins(0,0,0,20)));


        HorizontalPanel hp2 = new HorizontalPanel();

        rTanggalUpload = new Radio();
        rTanggalUpload.setBoxLabel("Pilih rentang tanggal untuk rekap per tanggal upload");
        rTanggalUpload.setWidth(80);

        hp2.add(rTanggalUpload);

        vlcPParameter.add(hp2);

        hp2 = new HorizontalPanel();

        dfTopTanggalAwal = new DateField();
        dfTopTanggalAwal.setWidth(100);

        Label lbl = new Label("Sampai");

        dfTopTanggalAkhir = new DateField();
        dfTopTanggalAkhir.setWidth(100);

        hp2.add(dfTopTanggalAwal);
        hp2.add(lbl);
        hp2.add(dfTopTanggalAkhir);

        vlcPParameter.add(hp2, new VerticalLayoutContainer.VerticalLayoutData(-1,-1, new Margins(0,0,0,20)));

        p.add(panelParameter);


        bBottomRekapitulasiPerGolongan = new TextButton("Rekapitulasi per Golongan");
        bBottomRekapitulasiPerTglUpload = new TextButton("Rekapitulasi per Tanggal Upload");
        bBottomRekapitulasiPerTaripDaya = new TextButton("Rekapitulasi per Tarip Daya");
        bBottomRekapitulasiPerInkaso = new TextButton("Rekapitulasi per Inkaso");

        panel.addButton(bBottomRekapitulasiPerGolongan);
        panel.addButton(bBottomRekapitulasiPerTglUpload);
        panel.addButton(bBottomRekapitulasiPerTaripDaya);
        panel.addButton(bBottomRekapitulasiPerInkaso);

        ToggleGroup tg = new ToggleGroup();
        tg.add(rGolTaripDaya);
        tg.add(rTanggalUpload);

        return panel;
    }

    private void initEvent() {
        bBottomRekapitulasiPerGolongan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, tgl, tglEnd, kdSiklis, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                tgl = "";
                tglEnd = "";
                kdSiklis = cbKdSiklis.getSelectedValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_11rekap"
                        +"&vJenis="+"11rekap_gol"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&kode="+kdSiklis
                        +"&tparAP="+unitAp
                        +"&in_unitupi="+unitUpi;

                url+="&report=report/ReportMain/11/cr_11_gol.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerTglUpload.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                if (!rTanggalUpload.getValue()) {
                    mb = new IconAlertMessageBox("Kesalahan","Pilih terlebih dahulu tanggal yang akan di rekap.", true);
                    return;
                }

                String parUp, thbl, petugas, tgl, tglEnd, kdSiklis, unitAp, unitUpi;
                String tglAwal, tglAkhir;

                parUp = cbUnits.getUnitUpValue();

                DateTimeFormat format = DateTimeFormat.getFormat("MMddYYYY");

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=cetak_rekap11TglUpload"
                        +"&vJenis="  + "11rekap_perTanggalUpload"
                        +"&tparUp="  + parUp
                        +"&tglAwal=" + format.format(dfTopTanggalAwal.getValue())
                        +"&tglAkhir="+ format.format(dfTopTanggalAkhir.getValue());

                url+="&report=report/ReportMain/11/cr_11_tglUpload.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerTaripDaya.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, tgl, tglEnd, kdSiklis, unitAp, unitUpi;
                String tglAwal, tglAkhir;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                tgl = "";
                tglEnd = "";
                kdSiklis = cbKdSiklis.getSelectedValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                DateTimeFormat format = DateTimeFormat.getFormat("MMddYYYY");

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_11rekap"
                        +"&vJenis="     + "11rekap_taripdaya"
                        +"&tBLTH="      + thbl
                        +"&tparUp="     + parUp
                        +"&tPetugas="   + petugas
                        +"&kode="       + kdSiklis
                        +"&tparAP="     + unitAp
                        +"&in_unitupi=" + unitUpi;

                url+="&report=report/ReportMain/11/cr_11_tarip.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerInkaso.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, tgl, tglEnd, kdSiklis, unitAp, unitUpi;
                String tglAwal, tglAkhir;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                tgl = "";
                tglEnd = "";
                kdSiklis = cbKdSiklis.getSelectedValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                DateTimeFormat format = DateTimeFormat.getFormat("MMddYYYY");

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_11rekap"
                        +"&vJenis="     + "11rekap_inkaso"
                        +"&tBLTH="      + thbl
                        +"&tparUp="     + parUp
                        +"&tPetugas="   + petugas
                        +"&kode="       + kdSiklis
                        +"&tparAP="     + unitAp
                        +"&in_unitupi=" + unitUpi;

                url+="&report=report/ReportMain/11/cr_11_inkaso.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        cbUnits.getComboUnitUp().addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                cbKdSiklis.getComboBox().setStoreUrl("components/getComboKodeSiklis.json?unitUp=" + cbUnits.getUnitUpValue() + "&addSemua=1");
                cbKdSiklis.getComboBox().loadStore();
            }
        });
    }
}
