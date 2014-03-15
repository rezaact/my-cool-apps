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

public class Form_Report21_Petugas {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    ComboTahunBulan cbTahunBulan;
    ComboKodePP cbTopKodePP;
    ComboKodePetugas cbTopKodePetugas;
    ComboTanggal cbMiddlePilihTanggalAwal;
    ComboTanggal cbMiddelPilihTanggalAkhir;

    TextButton bBottomRekapitulasiPerTanggal;
    TextButton bBottomRekapitulasiPerGolongan;
    TextButton bBottomDaftarRekening;

    TextButton bBottomRekapitulasiPerUnitUP;
    TextButton bBottomRekapitulasiPerUnitUPPerGol;
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
        panel.setHeadingText("Rekap 21 - Lunas Ofline per-Petugas");
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

        vlcPParameter.add(new FieldLabel(hp1, "Pilih Tanggal"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1,new Margins(0,0,0,0)));

        p.add(panelParameter);


        bBottomRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        bBottomRekapitulasiPerGolongan = new TextButton("Rekapitulasi Per Golongan");
        bBottomDaftarRekening = new TextButton("Daftar Rekening");

        bBottomRekapitulasiPerUnitUP = new TextButton("Rekapitulasi Per UnituP");
        bBottomRekapitulasiPerUnitUPPerGol = new TextButton("Rekapitulasi Per UnituP Per Gol");
        bBottomDaftarRekeningPerUnit = new TextButton("Daftar Rekening Per Unit");

        panel.addButton(bBottomRekapitulasiPerTanggal);
        panel.addButton(bBottomRekapitulasiPerGolongan);
        panel.addButton(bBottomDaftarRekening);

        panel.addButton(bBottomRekapitulasiPerUnitUP);
        panel.addButton(bBottomRekapitulasiPerUnitUPPerGol);
        panel.addButton(bBottomDaftarRekeningPerUnit);

        return panel;
    }


    private void initEvent() {
        bBottomRekapitulasiPerTanggal.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21petugas"
                        +"&vJenis="+"21petugas_pptglrekap"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue();

                url+="&report=report/ReportMain/21/cr_21petugas_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerGolongan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21petugas"
                        +"&vJenis="+"21petugas_pptglrekapgol"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue();

                url+="&report=report/ReportMain/21/cr_21petugas_gol_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomDaftarRekening.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21petugas"
                        +"&vJenis="+"21petugas_pptgldaftar"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue();

                url+="&report=report/ReportMain/21/cr_21petugas_daftar.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });


        bBottomRekapitulasiPerUnitUP.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21petugas"
                        +"&vJenis="+"21petugas_unittglrekap"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue();

                url+="&report=report/ReportMain/21/cr_21petugas_unit_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomRekapitulasiPerUnitUPPerGol.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21petugas"
                        +"&vJenis="+"21petugas_unittglrekapgol"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue();

                url+="&report=report/ReportMain/21/cr_21petugas_unitgol_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomDaftarRekeningPerUnit.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21petugas"
                        +"&vJenis="+"21petugas_unittgldaftar"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbTopKodePP.getSelectedValue()
                        +"&kdPembayar="+cbTopKodePetugas.getSelectedValue();

                url+="&report=report/ReportMain/21/cr_21petugas_unit_daftar.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
