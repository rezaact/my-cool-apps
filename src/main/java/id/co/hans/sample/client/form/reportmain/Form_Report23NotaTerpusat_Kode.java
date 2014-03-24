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

public class Form_Report23NotaTerpusat_Kode {


    private VerticalPanel vp;

    ComboKodeNotaBuku cbKdNotaBuku;
    ComboTahunBulan cbTahunBulan;
    Radio radioSemua;
    Radio radioBelumLunas;
    Radio radioLunas;

    TextButton bBottomTampilkan;

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
        panel.setHeadingText("Laporan Tagihan per-Kode Nota Buku Tpst");
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

        cbKdNotaBuku = new ComboKodeNotaBuku();
        cbKdNotaBuku.setUnitUp(unitUser);
        vlcPReferensi.add(cbKdNotaBuku);

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

        radioSemua = new Radio();
        radioSemua.setBoxLabel("Semua");

        radioBelumLunas = new Radio();
        radioBelumLunas.setBoxLabel("Belum Lunas");

        radioLunas = new Radio();
        radioLunas.setBoxLabel("Lunas");

        hp1.add(radioSemua);
        hp1.add(radioBelumLunas);
        hp1.add(radioLunas);

        vlcPParameter.add(hp1);

        p.add(panelParameter);


        bBottomTampilkan = new TextButton("Tampilkan");

        panel.addButton(bBottomTampilkan);

        ToggleGroup tg = new ToggleGroup();
        tg.add(radioLunas);
        tg.add(radioBelumLunas);
        tg.add(radioLunas);

        return panel;
    }

    private void initEvent() {
        bBottomTampilkan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                petugas = idUser;

                if (radioSemua.getValue())
                    jenis = "23TERPUSATKODE";
                else if (radioLunas.getValue())
                    jenis = "23TERPUSATKODELUNAS";
                else if (radioBelumLunas.getValue())
                    jenis = "23TERPUSATKODEBLMLUNAS";

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_23Terpusat_Kode"
                        +"&jenis="+jenis
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tPetugas="+petugas
                        +"&kode="+cbKdNotaBuku.getSelectedValue();

                if (radioSemua.getValue())
                    url+="&report=report/ReportMain/23/cr_22NotaTerpusat_kode.rpt";
                else
                    url+="&report=report/ReportMain/23/cr_DaftarLunasKolektif.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
