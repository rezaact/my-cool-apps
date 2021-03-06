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

public class Form_Report23Nota_Rekap {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    ComboTahunBulan cbTahunBulan;

    TextButton bBottomRekapitulasiPerKode;
    TextButton bBottomRekapitulasiPerTanggal;
    TextButton bBottomRekapitulasiBahan404;


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
        panel.setHeadingText("Rekap 23 - Lunas Nota Buku");
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


        bBottomRekapitulasiPerKode = new TextButton("Rekapitulasi Per Kode");
        bBottomRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        bBottomRekapitulasiBahan404 = new TextButton("Rekapitulasi u/ Bahan 404");

        panel.addButton(bBottomRekapitulasiPerKode);
        panel.addButton(bBottomRekapitulasiPerTanggal);
        panel.addButton(bBottomRekapitulasiBahan404);

        return panel;
    }

    private void initEvent() {
        bBottomRekapitulasiPerKode.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, tgl, tglEnd, kdSiklis, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                tgl = "";
                tglEnd = "";
                //kdSiklis = cbKdSiklis.getSelectedValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_23notarekap"
                        +"&vJenis="+"23notarekapkode"
                        +"&tBLTH="+thbl
                        +"&tparAp="+unitAp
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+""
                        +"&tparupi="+unitUpi
                        +"&kode="+"";

                url+="&report=report/ReportMain/23/cr_23nota_kode.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiPerTanggal.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, tgl, tglEnd, kdSiklis, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                tgl = "";
                tglEnd = "";
                //kdSiklis = cbKdSiklis.getSelectedValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_23notarekap"
                        +"&vJenis="+"23notarekap502"
                        +"&tBLTH="+thbl
                        +"&tparAp="+unitAp
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+""
                        +"&kode="+""
                        +"&tparupi="+unitUpi
                        +"&kode="+"";

                url+="&report=report/ReportMain/23/cr_23nota_tgl.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapitulasiBahan404.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, tgl, tglEnd, kdSiklis, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                thbl = cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue();
                petugas = idUser;
                tgl = "";
                tglEnd = "";
                //kdSiklis = cbKdSiklis.getSelectedValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_23notarekap"
                        +"&vJenis="+"23notarekap404"
                        +"&tBLTH="+thbl
                        +"&tparAp="+unitAp
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+""
                        +"&kode="+""
                        +"&tparupi="+unitUpi
                        +"&kode="+"";

                url+="&report=report/ReportMain/23/cr_23nota_404.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
