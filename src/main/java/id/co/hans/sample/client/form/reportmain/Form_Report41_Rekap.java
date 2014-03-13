package id.co.hans.sample.client.form.reportmain;

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
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.*;

public class Form_Report41_Rekap {


    private VerticalPanel vp;

    private String idUser, levelUser, unitUser;

    public Widget asWidget(String idUser, String unitupUser, String levelUser) {
        this.idUser=idUser;
        this.unitUser=unitUser;
        this.levelUser=levelUser;

        if (vp == null) {
            vp = new VerticalPanel();
            vp.setSpacing(5);
            initKomponen();
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
        panel.setHeadingText("Rekap 41 - Mutasi Lancar ke Ragu");
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

        ComboUnits cbUnits = new ComboUnits();
        vlcPReferensi.add(cbUnits);

        p.add(panelReferensi);


        FramedPanel panelReferensiTgl = new FramedPanel();
        panelReferensiTgl.setHeadingText("Pilih Parameter");
        panelReferensiTgl.setBodyStyle("background: none; padding: 5px");
        panelReferensiTgl.setWidth(620);

        VerticalLayoutContainer vlcPReferensiTgl = new VerticalLayoutContainer();
        panelReferensiTgl.add(vlcPReferensiTgl);

        ComboTahunBulan cbTahunBulan = new ComboTahunBulan();
        vlcPReferensiTgl.add(cbTahunBulan);

        ComboJenisLaporan cbJenisLaporan = new ComboJenisLaporan();
        vlcPReferensiTgl.add(cbJenisLaporan);

        p.add(panelReferensiTgl);


        FramedPanel panelParameter = new FramedPanel();
        panelParameter.setBodyStyle("background: none; padding: 5px");
        panelParameter.setWidth(620);

        VerticalLayoutContainer vlcPParameter = new VerticalLayoutContainer();
        panelParameter.add(vlcPParameter);

        TextButton bBottomDaftarRekeningLancarKeRagu2 = new TextButton("Daftar Rekening Lancar ke Ragu2");
        TextButton bBottomDaftarPerPelangganRekgLancarKeRagu2 = new TextButton("Daftar per Pelanggan Rekg Lancar ke Ragu2");
        TextButton bBottomRekapitulasiPerTanggal = new TextButton("Rekapitulasi per Tanggal");
        TextButton bBottomRekapitulasiBahan404 = new TextButton("Rekapitulasi u/ Bahan 404");

        bBottomDaftarRekeningLancarKeRagu2.setWidth(220);
        bBottomDaftarPerPelangganRekgLancarKeRagu2.setWidth(220);
        bBottomRekapitulasiPerTanggal.setWidth(220);
        bBottomRekapitulasiBahan404.setWidth(220);

        HorizontalPanel hp1 = new HorizontalPanel();

        hp1.add(bBottomDaftarRekeningLancarKeRagu2);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomDaftarPerPelangganRekgLancarKeRagu2);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomRekapitulasiPerTanggal);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomRekapitulasiPerTanggal);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomRekapitulasiBahan404);

        vlcPParameter.add(hp1);

        p.add(panelParameter);


        return panel;
    }
}
