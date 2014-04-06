package id.co.hans.sample.client.form.reporttul.report502;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.*;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
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

public class Form_LaporanV02 {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    ComboTahunBulan cbTahunBulan;
    ComboKodeGolongan cbKodeGolongan;
    TextButton btn_Tampil;
    TextButton btn_Tampil2;


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
        panel.setHeadingText("Laporan Mutasi Harian (TUL V-02)");
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

        cbKodeGolongan = new ComboKodeGolongan();
        vlcPReferensiTgl.add(cbKodeGolongan);

        p.add(panelReferensiTgl);


        FramedPanel panelButton = new FramedPanel();
        panelButton.setBodyStyle("background: none; padding: 5px");
        panelButton.setWidth(620);

        VerticalLayoutContainer vlcPButton = new VerticalLayoutContainer();
        panelButton.add(vlcPButton);

        btn_Tampil = new TextButton("Tampilkan Laporan Gabungan 1");
        btn_Tampil.setWidth(220);

        btn_Tampil2 = new TextButton("Tampilkan Laporan Gabungan 2");
        btn_Tampil2.setWidth(220);

        HorizontalPanel hp1 = new HorizontalPanel();
        hp1.add(btn_Tampil);
        hp1.add(btn_Tampil2);
        vlcPButton.add(hp1);

        p.add(panelButton);

        return panel;
    }


    private void initEvent() {
        btn_Tampil.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();
                petugas = idUser;

                if (cbUnits.getUnitUpiValue().equals("SEMUA")) {
                    parUp = cbUnits.getUnitUpiValue();
                } else if (cbUnits.getUnitApValue().equals("SEMUA")) {
                    parUp = cbUnits.getUnitApValue();
                } else {
                    parUp = cbUnits.getUnitUpValue();
                }

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=ambilLaporanV02"
                        +"&parUp="+parUp
                        +"&parGol="+cbKodeGolongan.getSelectedValue()
                        +"&thbl="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&petugas="+petugas
                        +"&judul="+"LAPORAN TUL V-02"
                        +"&tparupi="+unitUpi
                        +"&tparap="+unitAp
                        +"&tparup="+parUp
                        +"&tblth="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        ;

                url+="&report=report/ReportTUL/TUL5/cr_laporan502gab_1.rpt";
                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        btn_Tampil2.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();
                petugas = idUser;

                if (cbUnits.getUnitUpiValue().equals("SEMUA")) {
                    parUp = cbUnits.getUnitUpiValue();
                } else if (cbUnits.getUnitApValue().equals("SEMUA")) {
                    parUp = cbUnits.getUnitApValue();
                } else {
                    parUp = cbUnits.getUnitUpValue();
                }

                String url2= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=ambilLaporanV02"
                        +"&parUp="+parUp
                        +"&parGol="+cbKodeGolongan.getSelectedValue()
                        +"&thbl="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&petugas="+petugas
                        +"&judul="+"LAPORAN TUL V-02"
                        +"&tparupi="+unitUpi
                        +"&tparap="+unitAp
                        +"&tparup="+parUp
                        +"&tblth="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        ;

                url2+="&report=report/ReportTUL/TUL5/cr_laporan502gab_2.rpt";
                Window.open(url2, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
