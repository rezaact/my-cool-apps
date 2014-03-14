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

public class Form_Report21_Upload {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    ComboKodePP cbKdPP;
    ComboTahunBulan cbTahunBulan;
    ComboTanggal cbMiddlePilihTanggalAwal;
    ComboTanggal cbMiddelPilihTanggalAkhir;

    TextButton bBottomRekapitulasiUploadRekgLunas;
    TextButton bBottomDaftarRekgBerhasilUpdateDPP;
    TextButton bBottomDaftarRekgGagalUpdateDPP;

    TextButton bBottomRekapitulasiDoubleUpload;
    TextButton bBottomDaftarRekeningDoubleUpload;

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
        panel.setHeadingText("Report 21 - Lunas Offline Upload");
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


        bBottomRekapitulasiUploadRekgLunas = new TextButton("Rekapitulasi Upload Rekg. Lunas");
        bBottomDaftarRekgBerhasilUpdateDPP = new TextButton("Daftar Rekg Berhasil Update DPP");
        bBottomDaftarRekgGagalUpdateDPP = new TextButton("Daftar Rekg Gagal Update DPP");

        bBottomRekapitulasiDoubleUpload = new TextButton("Rekapitulasi Double Upload");
        bBottomDaftarRekeningDoubleUpload = new TextButton("Daftar Rekening Double Upload");

        panel.addButton(bBottomRekapitulasiUploadRekgLunas);
        panel.addButton(bBottomDaftarRekgBerhasilUpdateDPP);
        panel.addButton(bBottomDaftarRekgGagalUpdateDPP);

        panel.addButton(bBottomRekapitulasiDoubleUpload);
        panel.addButton(bBottomDaftarRekeningDoubleUpload);

        return panel;
    }

    private void initEvent() {
        bBottomRekapitulasiUploadRekgLunas.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21upload"
                        +"&vJenis="+"21upload_rekap"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbKdPP.getSelectedValue();

                url+="&report=report/ReportMain/21/21Upload/cr_21upload_behasil.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomDaftarRekgBerhasilUpdateDPP.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21upload"
                        +"&vJenis="+"21upload_daftarberhasil"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbKdPP.getSelectedValue();

                url+="&report=report/ReportMain/21/21Upload/cr_21upload_berhasil_lunasdpp.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomDaftarRekgGagalUpdateDPP.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21upload"
                        +"&vJenis="+"21upload_daftargagal"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbKdPP.getSelectedValue();

                url+="&report=report/ReportMain/21/21Upload/cr_21upload_berhasil_gagaldpp.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });


        bBottomRekapitulasiDoubleUpload.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21upload"
                        +"&vJenis="+"21upload_doublerekap"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbKdPP.getSelectedValue();

                url+="&report=report/ReportMain/21/21Upload/cr_21upload_gagal.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomDaftarRekeningDoubleUpload.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21upload"
                        +"&vJenis="+"21upload_doubledaftar"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+cbMiddlePilihTanggalAwal.getSelectedValue()
                        +"&tanggalend="+cbMiddelPilihTanggalAkhir.getSelectedValue()
                        +"&kode="+cbKdPP.getSelectedValue();

                url+="&report=report/ReportMain/21/21Upload/cr_21upload_gagal_daftar.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
