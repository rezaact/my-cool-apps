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

public class Form_Report23_Kirim {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    ComboTahunBulan cbTahunBulan;

    TextButton bBottomRekapPengirimanRekeningListrikKeUnitLain;
    TextButton bBottomDaftarPengirimanRekeningListrikKeUnitLain;


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
        panel.setHeadingText("Rekap 23 - Kirim Rekening");
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


        bBottomRekapPengirimanRekeningListrikKeUnitLain = new TextButton("Rekap Pengiriman Rekening Listrik ke Unit Lain");
        bBottomDaftarPengirimanRekeningListrikKeUnitLain = new TextButton("Daftar Pengirirman Rekening Listrik ke Unit Lain");

        panel.addButton(bBottomRekapPengirimanRekeningListrikKeUnitLain);
        panel.addButton(bBottomDaftarPengirimanRekeningListrikKeUnitLain);

        return panel;
    }


    private void initEvent() {
        bBottomRekapPengirimanRekeningListrikKeUnitLain.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_23Kirim_Rekap"
                        +"&vJenis="+"23KirimRekap"
                        +"&tThbl="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tParUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tPetugas="+petugas
                        +"&tParUpi="+unitUpi
                        +"&tParAp="+unitAp
                        +"&judul="+"Laporan Pengiriman Rekening ke Unit Lain"
                        ;

                url+="&report=report/ReportMain/23KirTer/rpt_23KirTer_Rekap.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomDaftarPengirimanRekeningListrikKeUnitLain.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jnsunit, petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_23Kirim_Daftar"
                        +"&vJenis="+"23KirimDaftar"
                        +"&tThbl="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tParUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tParUpi="+unitUpi
                        +"&tParAp="+unitAp
                        +"&judul="+"Laporan Pengiriman Rekening ke Unit Lain";

                url+="&report=report/ReportMain/23KirTer/rpt_23KirTer_Daftar.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
