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

public class Form_Report13_Rekap {


    private VerticalPanel vp;

    public Widget asWidget() {
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
        panel.setHeadingText("Rekap 13 - Rekening Susulan");
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


        FramedPanel panelParameter = new FramedPanel();
        panelParameter.setHeadingText("Pilih Parameter");
        panelParameter.setBodyStyle("background: none; padding: 5px");
        panelParameter.setWidth(620);

        VerticalLayoutContainer vlcPParameter = new VerticalLayoutContainer();
        panelParameter.add(vlcPParameter);


        HorizontalPanel hp1 = new HorizontalPanel();

        Radio rGolTaripDaya = new Radio();
        rGolTaripDaya.setBoxLabel("Pilih Tahun dan Bulan Laporan");
        rGolTaripDaya.setValue(true);
        rGolTaripDaya.setWidth(80);

        hp1.add(rGolTaripDaya);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        ComboTahunBulan cbTahunBulan = new ComboTahunBulan();
        cbTahunBulan.hideLabel();

        hp1.add(cbTahunBulan);
        vlcPParameter.add(hp1, new VerticalLayoutContainer.VerticalLayoutData(1,1,new Margins(0,0,0,20)));

        p.add(panelParameter);


        TextButton bBottomDaftarRekeningSusulan = new TextButton("Daftar Rekening Susulan");
        TextButton bBottomRekapitulasiPerTanggal = new TextButton("Rekapitulasi per Tanggal");
        TextButton bBottomRekapitulasiBahan404 = new TextButton("Rekapitulasi u/ Bahan 404");

        panel.addButton(bBottomDaftarRekeningSusulan);
        panel.addButton(bBottomRekapitulasiPerTanggal);
        panel.addButton(bBottomRekapitulasiBahan404);

        ToggleGroup tg = new ToggleGroup();
        tg.add(rGolTaripDaya);

        return panel;
    }
}
