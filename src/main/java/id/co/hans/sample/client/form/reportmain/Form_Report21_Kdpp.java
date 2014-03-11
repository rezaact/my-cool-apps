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

public class Form_Report21_Kdpp {


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
        panel.setHeadingText("Rekap 21 - Lunas Ofline per-KDPP");
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

        ComboKodePP cbTopKodePengelolaPaymentPoint = new ComboKodePP();
        vlcPReferensi.add(cbTopKodePengelolaPaymentPoint);

        p.add(panelReferensi);


        FramedPanel panelReferensiTgl = new FramedPanel();
        panelReferensiTgl.setHeadingText("Pilih Parameter");
        panelReferensiTgl.setBodyStyle("background: none; padding: 5px");
        panelReferensiTgl.setWidth(620);

        VerticalLayoutContainer vlcPReferensiTgl = new VerticalLayoutContainer();
        panelReferensiTgl.add(vlcPReferensiTgl);

        ComboTahunBulan cbTahunBulan = new ComboTahunBulan();
        vlcPReferensiTgl.add(cbTahunBulan);

        p.add(panelReferensiTgl);


        FramedPanel panelParameter = new FramedPanel();
//        panelParameter.setHeadingText("Pilih Tanggal");
        panelParameter.setBodyStyle("background: none; padding: 5px");
        panelParameter.setWidth(620);

        VerticalLayoutContainer vlcPParameter = new VerticalLayoutContainer();
        panelParameter.add(vlcPParameter);


        HorizontalPanel hp1 = new HorizontalPanel();

        ComboTanggal cbMiddlePilihTanggalAwal = new ComboTanggal();
        cbMiddlePilihTanggalAwal.hideLabel();

        Label lbl = new Label(" s/d ");

        ComboTanggal cbMiddelPilihTanggalAkhir = new ComboTanggal();
        cbMiddelPilihTanggalAkhir.hideLabel();

        hp1.add(cbMiddlePilihTanggalAwal);
        hp1.add(lbl);
        hp1.add(cbMiddelPilihTanggalAkhir);

        vlcPParameter.add(new FieldLabel(hp1, "Pilih Tanggal"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1,new Margins(0,0,0,0)));

        p.add(panelParameter);


        TextButton bBottomRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        TextButton bBottomRekapitulasiPerGolongan = new TextButton("Rekapitulasi Per Golongan");
        TextButton bBottomDaftarRekeningLunasDPP = new TextButton("Daftar Rekening Lunas DPP");

        TextButton bBottomRekapitulasiPerUnitUP = new TextButton("Rekapitulasi Per UnituP");
        TextButton bBottomRekapitulasiPerUnitUPPerGol = new TextButton("Rekapitulasi Per UnituP Per Gol");
        TextButton bBottomDaftarRekeningPerUnit = new TextButton("Daftar Rekening Per Unit");

        panel.addButton(bBottomRekapitulasiPerTanggal);
        panel.addButton(bBottomRekapitulasiPerGolongan);
        panel.addButton(bBottomDaftarRekeningLunasDPP);

        panel.addButton(bBottomRekapitulasiPerUnitUP);
        panel.addButton(bBottomRekapitulasiPerUnitUPPerGol);
        panel.addButton(bBottomDaftarRekeningPerUnit);

        return panel;
    }
}
