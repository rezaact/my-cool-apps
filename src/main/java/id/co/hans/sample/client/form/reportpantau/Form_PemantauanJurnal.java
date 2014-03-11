package id.co.hans.sample.client.form.reportpantau;

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

public class Form_PemantauanJurnal {


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
        panel.setHeadingText("Jurnal Transaksi");
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


        HorizontalPanel hp1 = new HorizontalPanel();

        ComboTanggal cbMiddlePilihTanggalAwal = new ComboTanggal();
        cbMiddlePilihTanggalAwal.hideLabel();

        Label lbl = new Label(" s/d ");

        ComboTanggal cbMiddelPilihTanggalAkhir = new ComboTanggal();
        cbMiddelPilihTanggalAkhir.hideLabel();

        hp1.add(cbMiddlePilihTanggalAwal);
        hp1.add(lbl);
        hp1.add(cbMiddelPilihTanggalAkhir);

        vlcPReferensiTgl.add(new FieldLabel(hp1, "Pilih Tanggal"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1,new Margins(0,0,0,0)));

        p.add(panelReferensiTgl);


        FramedPanel panelParameter = new FramedPanel();
        panelParameter.setBodyStyle("background: none; padding: 5px");
        panelParameter.setWidth(620);

        VerticalLayoutContainer vlcPParameter = new VerticalLayoutContainer();
        panelParameter.add(vlcPParameter);


        hp1 = new HorizontalPanel();

        Radio radioBerdasarkanTanggalTransaksi = new Radio();
        radioBerdasarkanTanggalTransaksi.setBoxLabel("Transaksi");
        radioBerdasarkanTanggalTransaksi.setValue(true);

        Radio radioBerdasarkanTanggalPembukuan = new Radio();
        radioBerdasarkanTanggalPembukuan.setBoxLabel("Pembukuan");

        hp1.add(radioBerdasarkanTanggalTransaksi);
        hp1.add(radioBerdasarkanTanggalPembukuan);

        vlcPParameter.add(hp1);

        p.add(panelParameter);



        FramedPanel panelButton = new FramedPanel();
        panelButton.setBodyStyle("background: none; padding: 5px");
        panelButton.setWidth(620);

        VerticalLayoutContainer vlcPButton = new VerticalLayoutContainer();
        panelButton.add(vlcPButton);

        TextButton bBottomTampilkan = new TextButton("Tampilkan");

        bBottomTampilkan.setWidth(220);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomTampilkan);

        vlcPButton.add(hp1);

        p.add(panelButton);

        ToggleGroup tg = new ToggleGroup();
        tg.add(radioBerdasarkanTanggalPembukuan);
        tg.add(radioBerdasarkanTanggalTransaksi);


        return panel;
    }
}
