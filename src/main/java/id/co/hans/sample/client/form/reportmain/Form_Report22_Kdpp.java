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

public class Form_Report22_Kdpp {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    ComboKodePP cbKdPP;
    ComboTahunBulan cbTahunBulan;
    ComboTanggal cbMiddlePilihTanggalAwal;
    ComboTanggal cbMiddelPilihTanggalAkhir;

    TextButton bBottomRekapitulasiPerTanggal;
    TextButton bBottomRekapPerTanggalBjlnTgk;
    TextButton bBottomRekapitulasiPerGolongan;

    TextButton bBottomDaftarRekening;


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
        panel.setHeadingText("Rekap 22 - Lunas Online Per KDPP");
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

        cbKdPP = new ComboKodePP();
        vlcPReferensi.add(cbKdPP);

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


        FramedPanel panelParameter = new FramedPanel();
        panelParameter.setBodyStyle("background: none; padding: 5px");
        panelParameter.setWidth(620);

        VerticalLayoutContainer vlcPParameter = new VerticalLayoutContainer();
        panelParameter.add(vlcPParameter);


        HorizontalPanel hp1 = new HorizontalPanel();

        cbMiddlePilihTanggalAwal = new ComboTanggal();
        cbMiddlePilihTanggalAwal.hideLabel();

        Label lbl = new Label(" s/d ");

        cbMiddelPilihTanggalAkhir = new ComboTanggal();
        cbMiddelPilihTanggalAkhir.hideLabel();

        hp1.add(cbMiddlePilihTanggalAwal);
        hp1.add(lbl);
        hp1.add(cbMiddelPilihTanggalAkhir);

        vlcPParameter.add(new FieldLabel(hp1, "Pilih Tanggal"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1,new Margins(0,0,0,0)));

        p.add(panelParameter);


        bBottomRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        bBottomRekapPerTanggalBjlnTgk = new TextButton("Rekap Per Tanggal Bjln-Tgk");
        bBottomRekapitulasiPerGolongan = new TextButton("Rekapitulasi Per Golongan");

        bBottomDaftarRekening = new TextButton("Daftar Rekening");

        panel.addButton(bBottomRekapitulasiPerTanggal);
        panel.addButton(bBottomRekapPerTanggalBjlnTgk);
        panel.addButton(bBottomRekapitulasiPerGolongan);

        panel.addButton(bBottomDaftarRekening);

        return panel;
    }

    private void initEvent() {
        bBottomRekapitulasiPerTanggal.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22kdpp_v3"
                        +"&vJenis="+"22kdpp_pptglrekap"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&tparUp="+parUp
                        +"&kode="+cbKdPP.getSelectedValue();

                url+="&report=report/ReportMain/22/cr_22kdpp_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapPerTanggalBjlnTgk.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22kdpp_v3"
                        +"&vJenis="+"22KDPP_PPTGLREKAP_JLNTGK"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&tparUp="+parUp
                        +"&kode="+cbKdPP.getSelectedValue();

                url+="&report=report/ReportMain/22/cr_22unit_404.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerGolongan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22kdpp_v3"
                        +"&vJenis="+"22kdpp_pptglrekapgol"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&tparUp="+parUp
                        +"&kode="+cbKdPP.getSelectedValue();

                url+="&report=report/ReportMain/22/cr_22kdpp_gol_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomDaftarRekening.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22kdpp_v3"
                        +"&vJenis="+"22kdpp_pptgldaftar"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&tparUp="+parUp
                        +"&kode="+cbKdPP.getSelectedValue();

                url+="&report=report/ReportMain/22/cr_22unit_ppcbo_daftar.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        cbUnits.getComboUnitUp().addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>) event.getSelectedItem();
                cbUnits.setUnitUpValue(data.get("fieldValue"));

                cbKdPP.getComboBox().setStoreUrl("components/getComboKodePaymentPoint.json?unitUp=" + cbUnits.getUnitUpValue());
                cbKdPP.getComboBox().loadStore();
            }
        });
    }
}
