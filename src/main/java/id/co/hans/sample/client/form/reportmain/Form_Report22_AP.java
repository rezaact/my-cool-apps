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

public class Form_Report22_AP {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    DateField dfTanggalPelunasanAwal;
    DateField dfTanggalPelunasanAkhir;
    Radio radioUnitFilter;
    Radio radioUnitDiBawahUnitFilter;


    TextButton bBottomRekapitulasiPerKodeGolongan;
    TextButton bBottomRekapitulasiPerTanggalLunas;
    TextButton bBottomRekapitulasiPerKdpp;


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
        panel.setHeadingText("Laporan Pelunasan Rekening Online");
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

        dfTanggalPelunasanAwal = new DateField();

        Label lbl = new Label(" s/d ");

        dfTanggalPelunasanAkhir = new DateField();

        hp1.add(dfTanggalPelunasanAwal);
        hp1.add(lbl);
        hp1.add(dfTanggalPelunasanAkhir);

        vlcPParameter.add(new FieldLabel(hp1, "Pilih Tanggal Pelunasan"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1,new Margins(0,0,0,0)));

        p.add(panelParameter);


        FramedPanel panelParameterRadio = new FramedPanel();
        panelParameterRadio.setBodyStyle("background: none; padding: 5px");
        panelParameterRadio.setWidth(620);

        VerticalLayoutContainer vlcPParameterRadio = new VerticalLayoutContainer();
        panelParameterRadio.add(vlcPParameterRadio);


        HorizontalPanel hpRadio = new HorizontalPanel();

        radioUnitFilter = new Radio();
        radioUnitFilter.setBoxLabel("Unit Filter");

        radioUnitDiBawahUnitFilter = new Radio();
        radioUnitDiBawahUnitFilter.setBoxLabel("Unit Dibawah Unit Filter");

        hpRadio.add(radioUnitFilter);
        hpRadio.add(radioUnitDiBawahUnitFilter);

        vlcPParameterRadio.add(hpRadio);

        p.add(panelParameterRadio);


        bBottomRekapitulasiPerKodeGolongan = new TextButton("Rekapitulasi per Kode Golongan");
        bBottomRekapitulasiPerTanggalLunas = new TextButton("Rekapitulasi per Tanggal Lunas");
        bBottomRekapitulasiPerKdpp = new TextButton("Rekapitulasi per KDPP");

        panel.addButton(bBottomRekapitulasiPerKodeGolongan);
        panel.addButton(bBottomRekapitulasiPerTanggalLunas);
        panel.addButton(bBottomRekapitulasiPerKdpp);

        return panel;
    }

    private void initEvent() {
        bBottomRekapitulasiPerKodeGolongan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                if (parUp == "SEMUA")
                    parUp = "";

                if (unitAp == "SEMUA")
                    unitAp = "";

                if (radioUnitFilter.getValue())
                    jnsunit = "unit";
                else jnsunit = "detil";

                DateTimeFormat format = DateTimeFormat.getFormat("yyyyMMdd");

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22rekap_Global"
                        +"&vJenis="+"kogol"
                        +"&vFilterUnit="+jnsunit
                        +"&tparUpi="+unitUpi
                        +"&tparAp="+unitAp
                        +"&tparUp="+parUp
                        +"&tanggal="+format.format(dfTanggalPelunasanAwal.getValue())
                        +"&tanggalend="+format.format(dfTanggalPelunasanAkhir.getValue());

                url+="&report=report/ReportMain/22/cr_22unit_kogol.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerTanggalLunas.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                if (parUp == "SEMUA")
                    parUp = "";

                if (unitAp == "SEMUA")
                    unitAp = "";

                if (radioUnitFilter.getValue())
                    jnsunit = "unit";
                else jnsunit = "detil";

                DateTimeFormat format = DateTimeFormat.getFormat("yyyyMMdd");

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22rekap_Global"
                        +"&vJenis="+"tgllunas"
                        +"&vFilterUnit="+jnsunit
                        +"&tparUpi="+unitUpi
                        +"&tparAp="+unitAp
                        +"&tparUp="+parUp
                        +"&tanggal="+format.format(dfTanggalPelunasanAwal.getValue())
                        +"&tanggalend="+format.format(dfTanggalPelunasanAkhir.getValue());

                url+="&report=report/ReportMain/22/cr_22unit_pertgllunas.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerKdpp.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                if (parUp == "SEMUA")
                    parUp = "";

                if (unitAp == "SEMUA")
                    unitAp = "";

                if (radioUnitFilter.getValue())
                    jnsunit = "unit";
                else jnsunit = "detil";

                DateTimeFormat format = DateTimeFormat.getFormat("yyyyMMdd");

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22rekap_Global"
                        +"&vJenis="+"kdpp"
                        +"&vFilterUnit="+jnsunit
                        +"&tparUpi="+unitUpi
                        +"&tparAp="+unitAp
                        +"&tparUp="+parUp
                        +"&tanggal="+format.format(dfTanggalPelunasanAwal.getValue())
                        +"&tanggalend="+format.format(dfTanggalPelunasanAkhir.getValue());

                url+="&report=report/ReportMain/22/cr_22unit_perkdpp.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
