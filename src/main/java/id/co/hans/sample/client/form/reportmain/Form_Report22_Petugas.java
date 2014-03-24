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

public class Form_Report22_Petugas {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    ComboKodePP cbTopKodePP;
    ComboKodePetugas cbTopKodePetugas;
    ComboTahunBulan cbTahunBulan;
    ComboTanggal cbMiddlePilihTanggalAwal;
    ComboTanggal cbMiddelPilihTanggalAkhir;

    TextButton bMiddleRekapitulasiPerTanggal;
    TextButton bMiddleRekapitulasiPerGolongan;
    TextButton bMiddleDaftarRekening;

    TextButton bMiddleRekapitulasiPerUnitUP;
    TextButton bMiddleRekapitulasiPerUnitUPPerGol;
    TextButton bMiddleDaftarRekeningPerUnit;

    NumberField<Integer> tfBottomDayaAwal;
    NumberField<Integer> tfBottomDayaAkhir;

    TextButton bBottomRekapitulasiPerTanggal;
    TextButton bBottomRekapitulasiPerGolongan;
    TextButton bBottomDaftarRekening;

    TextButton bBottomRekapitulasiPerUnitUp;
    TextButton bBottomRekapitulasiPerUnitUpPerGol;
    TextButton bBottomDaftarRekeningPerUnit;



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
        panel.setHeadingText("Rekap 22 - Lunas Online per Petugas");
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

        cbTopKodePP = new ComboKodePP();
        vlcPReferensi.add(cbTopKodePP);

        cbTopKodePetugas = new ComboKodePetugas();
        vlcPReferensi.add(cbTopKodePetugas);

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
//        panelParameter.setHeadingText("Pilih Tanggal");
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

        vlcPParameter.add(new FieldLabel(hp1, "Pilih Rentang Tanggal"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1,new Margins(0,0,0,0)));

        bMiddleRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        bMiddleRekapitulasiPerTanggal.setWidth(150);
        bMiddleRekapitulasiPerGolongan = new TextButton("Rekapitulasi Per Golongan");
        bMiddleRekapitulasiPerGolongan.setWidth(150);
        bMiddleDaftarRekening = new TextButton("Daftar Rekening");
        bMiddleDaftarRekening.setWidth(150);

        bMiddleRekapitulasiPerUnitUP = new TextButton("Rekapitulasi Per UnituP");
        bMiddleRekapitulasiPerUnitUP.setWidth(150);
        bMiddleRekapitulasiPerUnitUPPerGol = new TextButton("Rekapitulasi Per UnituP Per Gol");
        bMiddleRekapitulasiPerUnitUPPerGol.setWidth(150);
        bMiddleDaftarRekeningPerUnit = new TextButton("Daftar Rekening Per Unit");
        bMiddleDaftarRekeningPerUnit.setWidth(150);

        hp1 = new HorizontalPanel();

        hp1.add(bMiddleRekapitulasiPerTanggal);
        hp1.add(bMiddleRekapitulasiPerUnitUP);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bMiddleRekapitulasiPerGolongan);
        hp1.add(bMiddleRekapitulasiPerUnitUPPerGol);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bMiddleDaftarRekening);
        hp1.add(bMiddleDaftarRekeningPerUnit);

        vlcPParameter.add(hp1);

        p.add(panelParameter);


        FramedPanel panelParameterDaya = new FramedPanel();
        panelParameterDaya.setHeadingText("Input Parameter Daya");
        panelParameterDaya.setBodyStyle("background: none; padding: 5px");
        panelParameterDaya.setWidth(620);

        VerticalLayoutContainer vlcPParameterDaya = new VerticalLayoutContainer();
        panelParameterDaya.add(vlcPParameterDaya);


        HorizontalPanel hpDaya = new HorizontalPanel();

        tfBottomDayaAwal = new NumberField<Integer>(new NumberPropertyEditor.IntegerPropertyEditor());
        tfBottomDayaAwal.setWidth(80);

        Label lblDaya = new Label(" s/d ");

        tfBottomDayaAkhir = new NumberField<Integer>(new NumberPropertyEditor.IntegerPropertyEditor());
        tfBottomDayaAkhir.setWidth(80);

        hpDaya.add(tfBottomDayaAwal);
        hpDaya.add(lblDaya);
        hpDaya.add(tfBottomDayaAkhir);

        vlcPParameterDaya.add(new FieldLabel(hpDaya, "Daya"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1,new Margins(0,0,0,0)));


        bBottomRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        bBottomRekapitulasiPerTanggal.setWidth(150);
        bBottomRekapitulasiPerGolongan = new TextButton("Rekapitulasi Per Golongan");
        bBottomRekapitulasiPerGolongan.setWidth(150);
        bBottomDaftarRekening = new TextButton("Daftar Rekening");
        bBottomDaftarRekening.setWidth(150);

        bBottomRekapitulasiPerUnitUp = new TextButton("Rekapitulasi Per UnituP");
        bBottomRekapitulasiPerUnitUp.setWidth(150);
        bBottomRekapitulasiPerUnitUpPerGol = new TextButton("Rekapitulasi Per UnituP Per Gol");
        bBottomRekapitulasiPerUnitUpPerGol.setWidth(150);
        bBottomDaftarRekeningPerUnit = new TextButton("Daftar Rekening Per Unit");
        bBottomDaftarRekeningPerUnit.setWidth(150);

        hpDaya = new HorizontalPanel();

        hpDaya.add(bBottomRekapitulasiPerTanggal);
        hpDaya.add(bBottomRekapitulasiPerUnitUp);

        vlcPParameterDaya.add(hpDaya);

        hpDaya = new HorizontalPanel();

        hpDaya.add(bBottomRekapitulasiPerGolongan);
        hpDaya.add(bBottomRekapitulasiPerUnitUpPerGol);

        vlcPParameterDaya.add(hpDaya);

        hpDaya = new HorizontalPanel();

        hpDaya.add(bBottomDaftarRekening);
        hpDaya.add(bBottomDaftarRekeningPerUnit);

        vlcPParameterDaya.add(hpDaya);

        p.add(panelParameterDaya);

        return panel;
    }

    private void initEvent() {
        bMiddleRekapitulasiPerTanggal.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22petugas"
                        +"&vJenis="+"22petugas_pptglrekap"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparUp="+cbUnits.getUnitUpValue()
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue()
                        +"&sATM="+cbTopKodePP.getSelectedValue().substring(cbTopKodePP.getSelectedValue().length() - 2, cbTopKodePP.getSelectedValue().length());

                url+="&report=report/ReportMain/22/cr_22petugas_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bMiddleRekapitulasiPerGolongan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22petugas"
                        +"&vJenis="+"22petugas_pptglrekapgol"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparUp="+cbUnits.getUnitUpValue()
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue()
                        +"&sATM="+cbTopKodePP.getSelectedValue().substring(cbTopKodePP.getSelectedValue().length() - 2, cbTopKodePP.getSelectedValue().length());

                url+="&report=report/ReportMain/22/cr_22petugas_gol_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bMiddleDaftarRekening.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22petugas"
                        +"&vJenis="+"22petugas_pptgldaftar"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparUp="+cbUnits.getUnitUpValue()
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue()
                        +"&sATM="+cbTopKodePP.getSelectedValue().substring(cbTopKodePP.getSelectedValue().length() - 2, cbTopKodePP.getSelectedValue().length());

                url+="&report=report/ReportMain/22/cr_22petugas_daftar.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });


        bMiddleRekapitulasiPerUnitUP.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22petugas"
                        +"&vJenis="+"22petugas_unittglrekap"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparUp="+cbUnits.getUnitUpValue()
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue()
                        +"&sATM="+cbTopKodePP.getSelectedValue().substring(cbTopKodePP.getSelectedValue().length() - 2, cbTopKodePP.getSelectedValue().length());

                url+="&report=report/ReportMain/22/cr_22petugas_unit_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bMiddleRekapitulasiPerUnitUPPerGol.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22petugas"
                        +"&vJenis="+"22petugas_unittglrekapgol"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparUp="+cbUnits.getUnitUpValue()
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue()
                        +"&sATM="+cbTopKodePP.getSelectedValue().substring(cbTopKodePP.getSelectedValue().length() - 2, cbTopKodePP.getSelectedValue().length());

                url+="&report=report/ReportMain/22/cr_22petugas_unitgol_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bMiddleDaftarRekeningPerUnit.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22petugas"
                        +"&vJenis="+"22petugas_unittgldaftar"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparUp="+cbUnits.getUnitUpValue()
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue()
                        +"&sATM="+cbTopKodePP.getSelectedValue().substring(cbTopKodePP.getSelectedValue().length() - 2, cbTopKodePP.getSelectedValue().length());

                url+="&report=report/ReportMain/22/cr_22petugas_unit_daftar.rpt";

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

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22petugasDaya"
                        +"&vJenis="+"22petugas_pptglrekap"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparUp="+cbUnits.getUnitUpValue()
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue()
                        +"&sATM="+cbTopKodePP.getSelectedValue().substring(cbTopKodePP.getSelectedValue().length() - 2, cbTopKodePP.getSelectedValue().length())
                        +"&vDayaAwal="+tfBottomDayaAwal.getValue()
                        +"&vDayaAkhir="+tfBottomDayaAwal.getValue();

                url+="&report=report/ReportMain/22/cr_22petugas_tgl.rpt";

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

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22petugasDaya"
                        +"&vJenis="+"22petugas_pptglrekapgol"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparUp="+cbUnits.getUnitUpValue()
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue()
                        +"&sATM="+cbTopKodePP.getSelectedValue().substring(cbTopKodePP.getSelectedValue().length() - 2, cbTopKodePP.getSelectedValue().length())
                        +"&vDayaAwal="+tfBottomDayaAwal.getValue()
                        +"&vDayaAkhir="+tfBottomDayaAwal.getValue();

                url+="&report=report/ReportMain/22/cr_22petugas_gol_tgl.rpt";

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

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22petugasDaya"
                        +"&vJenis="+"22petugas_pptgldaftar"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparUp="+cbUnits.getUnitUpValue()
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue()
                        +"&sATM="+cbTopKodePP.getSelectedValue().substring(cbTopKodePP.getSelectedValue().length() - 2, cbTopKodePP.getSelectedValue().length())
                        +"&vDayaAwal="+tfBottomDayaAwal.getValue()
                        +"&vDayaAkhir="+tfBottomDayaAwal.getValue();

                url+="&report=report/ReportMain/22/cr_22petugas_daftar.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });


        bBottomRekapitulasiPerUnitUp.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22petugasDaya"
                        +"&vJenis="+"22petugas_unittglrekap"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparUp="+cbUnits.getUnitUpValue()
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue()
                        +"&sATM="+cbTopKodePP.getSelectedValue().substring(cbTopKodePP.getSelectedValue().length() - 2, cbTopKodePP.getSelectedValue().length())
                        +"&vDayaAwal="+tfBottomDayaAwal.getValue()
                        +"&vDayaAkhir="+tfBottomDayaAwal.getValue();

                url+="&report=report/ReportMain/22/cr_22petugas_unit_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomRekapitulasiPerUnitUpPerGol.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22petugasDaya"
                        +"&vJenis="+"22petugas_unittglrekapgol"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparUp="+cbUnits.getUnitUpValue()
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue()
                        +"&sATM="+cbTopKodePP.getSelectedValue().substring(cbTopKodePP.getSelectedValue().length() - 2, cbTopKodePP.getSelectedValue().length())
                        +"&vDayaAwal="+tfBottomDayaAwal.getValue()
                        +"&vDayaAkhir="+tfBottomDayaAwal.getValue();

                url+="&report=report/ReportMain/22/cr_22petugas_unitgol_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomDaftarRekeningPerUnit.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_22petugasDaya"
                        +"&vJenis="+"22petugas_unittgldaftar"
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparUp="+cbUnits.getUnitUpValue()
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue()
                        +"&sATM="+cbTopKodePP.getSelectedValue().substring(cbTopKodePP.getSelectedValue().length() - 2, cbTopKodePP.getSelectedValue().length())
                        +"&vDayaAwal="+tfBottomDayaAwal.getValue()
                        +"&vDayaAkhir="+tfBottomDayaAwal.getValue();

                url+="&report=report/ReportMain/22/cr_22petugas_unit_daftar.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        cbUnits.getComboUnitUp().addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>) event.getSelectedItem();
                cbUnits.setUnitUpValue(data.get("fieldValue"));

                cbTopKodePP.getComboBox().setStoreUrl("components/getComboKodePaymentPoint.json?unitUp=" + cbUnits.getUnitUpValue());
                cbTopKodePP.getComboBox().loadStore();
            }
        });

        cbTopKodePP.getComboBox().addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>) event.getSelectedItem();
                cbTopKodePP.setSelectedValue(data.get("fieldValue"));

                cbTopKodePetugas.getComboBox().setStoreUrl("components/getComboPetugas.json?kodePP=" + cbTopKodePP.getSelectedValue());
                cbTopKodePetugas.getComboBox().loadStore();
            }
        });
    }
}
