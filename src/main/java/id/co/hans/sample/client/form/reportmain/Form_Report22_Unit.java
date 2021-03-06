package id.co.hans.sample.client.form.reportmain;

import com.google.gwt.core.client.GWT;
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

public class Form_Report22_Unit {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    ComboTahunBulan cbTahunBulan;

    TextButton bBottomRekapitulasiPerPaymentPoint;
    TextButton bBottomRekapitulasiPerTanggal;
    TextButton bBottomRekapitulasiRekgBerjalanTunggakan;
    TextButton bBottomRekapitulasiPerGolonganTarip;


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
        panel.setHeadingText("Rekap 22 - Lunas Online per-Unit");
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

        panel.addButton(bBottomRekapitulasiPerPaymentPoint);
        panel.addButton(bBottomRekapitulasiPerTanggal);
        panel.addButton(bBottomRekapitulasiRekgBerjalanTunggakan);
        panel.addButton(bBottomRekapitulasiPerGolonganTarip);

        return panel;
    }

    private void initEvent() {
        bBottomRekapitulasiPerPaymentPoint.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22rekap_V3"
                        +"&vJenis="+"22unit_pp"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparUp="+parUp
                        +"&tparAp="+unitAp
                        +"&tparUpi="+unitUpi
                        +"&tPetugas="+petugas
                        +"&tanggalstart="+""
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/22/cr_22unit_pp_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerTanggal.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22rekap_V3"
                        +"&vJenis="+"22unit_502"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparUp="+parUp
                        +"&tparAp="+unitAp
                        +"&tparUpi="+unitUpi
                        +"&tPetugas="+petugas
                        +"&tanggalstart="+""
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/22/cr_22unit_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiRekgBerjalanTunggakan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22rekap_V3"
                        +"&vJenis="+"22unit_404"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparUp="+parUp
                        +"&tparAp="+unitAp
                        +"&tparUpi="+unitUpi
                        +"&tPetugas="+petugas
                        +"&tanggalstart="+""
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/22/cr_22unit_404.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerGolonganTarip.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22rekap_V3"
                        +"&vJenis="+"22unit_502b"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparUp="+parUp
                        +"&tparAp="+unitAp
                        +"&tparUpi="+unitUpi
                        +"&tPetugas="+petugas
                        +"&tanggalstart="+""
                        +"&tanggalend="+""
                        +"&kode="+"";

                url+="&report=report/ReportMain/22/cr_22unit_tarip.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
