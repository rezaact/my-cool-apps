package id.co.hans.sample.client.form.reportpantau;

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

public class Form_MonitoringTunggakanPemda {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    ComboTahunBulan cbTahunBulan;
    ComboJenisLaporan cbJenisLaporan;

    TextButton btnCetak;

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
        panel.setHeadingText("Monitoring Saldo Tunggakan");
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

        cbJenisLaporan = new ComboJenisLaporan();
        cbJenisLaporan.setFormAsal("Form_MonitoringTunggakanPemda");
        vlcPReferensiTgl.add(cbJenisLaporan);

        p.add(panelReferensiTgl);



        FramedPanel panelParameter = new FramedPanel();
        panelParameter.setBodyStyle("background: none; padding: 5px");
        panelParameter.setWidth(620);

        VerticalLayoutContainer vlcPParameter = new VerticalLayoutContainer();
        panelParameter.add(vlcPParameter);

        btnCetak = new TextButton("Cetak");

        btnCetak.setWidth(220);

        HorizontalPanel hp1 = new HorizontalPanel();

        hp1.add(btnCetak);

        vlcPParameter.add(hp1);

        p.add(panelParameter);


        return panel;
    }


    private void initEvent() {
        btnCetak.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();
                petugas = idUser;

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetTunggakanPemda"
                        +"&in_jenis="+cbJenisLaporan.getSelectedValue()
                        +"&in_unitupi="+cbUnits.getUnitUpiValue()
                        +"&in_unitap="+cbUnits.getUnitApValue()
                        +"&in_unitup="+cbUnits.getUnitUpValue()
                        +"&in_blth="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tblth="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tparup="+parUp
                        +"&tpetugas="+petugas
                        +"&tparupi="+unitUpi
                        +"&tparap="+unitAp
                        ;

                if (cbJenisLaporan.getSelectedValue().equals("PEMDAN1"))
                    url += "&judul=TAGIHAN LISTRIK S.D BULAN " + cbTahunBulan.getCbBulanSelectedValue() + " " + cbTahunBulan.getCbTahunSelectedValue() + " YANG MASIH MENUNGGAK";
                else if (cbJenisLaporan.getSelectedValue().equals("PEMDAN"))
                    url += "&judul=TAGIHAN LISTRIK BULAN " + cbTahunBulan.getCbBulanSelectedValue() + " " + cbTahunBulan.getCbTahunSelectedValue() + " YANG MASIH MENUNGGAK";
                else if (cbJenisLaporan.getSelectedValue().equals("SELURUH"))
                    url += "&judul=TAGIHAN LISTRIK YANG MASIH MENUNGGAK KESELURUHAN";
                else if (cbJenisLaporan.getSelectedValue().equals("DAFTAR"))
                    url += "&judul=DAFTAR";

                if (cbJenisLaporan.getSelectedValue().equals("DAFTAR"))
                    url+="&report=report/ReportPantau/Saldo/cr_TunggakanPemdaDetail.rpt";
                else
                    url+="&report=report/ReportPantau/Saldo/cr_TunggakanPemda.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
