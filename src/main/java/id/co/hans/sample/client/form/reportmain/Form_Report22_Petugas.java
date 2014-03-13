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

public class Form_Report22_Petugas {


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
        panel.setHeadingText("Rekap 22 - Lunas Online per Petugas");
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

        ComboKodePP cbTopKodePP = new ComboKodePP();
        vlcPReferensi.add(cbTopKodePP);

        ComboKodePetugas cbTopKodePetugas = new ComboKodePetugas();
        vlcPReferensi.add(cbTopKodePetugas);

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

        vlcPParameter.add(new FieldLabel(hp1, "Pilih Rentang Tanggal"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1,new Margins(0,0,0,0)));

        TextButton bMiddleRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        bMiddleRekapitulasiPerTanggal.setWidth(150);
        TextButton bMiddleRekapitulasiPerGolongan = new TextButton("Rekapitulasi Per Golongan");
        bMiddleRekapitulasiPerGolongan.setWidth(150);
        TextButton bMiddleDaftarRekening = new TextButton("Daftar Rekening");
        bMiddleDaftarRekening.setWidth(150);

        TextButton bMiddleRekapitulasiPerUnitUP = new TextButton("Rekapitulasi Per UnituP");
        bMiddleRekapitulasiPerUnitUP.setWidth(150);
        TextButton bMiddleRekapitulasiPerUnitUPPerGol = new TextButton("Rekapitulasi Per UnituP Per Gol");
        bMiddleRekapitulasiPerUnitUPPerGol.setWidth(150);
        TextButton bMiddleDaftarRekeningPerUnit = new TextButton("Daftar Rekening Per Unit");
        bMiddleDaftarRekeningPerUnit.setWidth(150);

        hp1 = new HorizontalPanel();

        hp1.add(bMiddleRekapitulasiPerTanggal);
        hp1.add(bMiddleRekapitulasiPerUnitUP);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bMiddleRekapitulasiPerGolongan);
        hp1.add(bMiddleRekapitulasiPerUnitUPPerGol);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bMiddleDaftarRekening);
        hp1.add(bMiddleDaftarRekeningPerUnit);

        vlcPParameter.add(hp1);

        p.add(panelParameter);


        FramedPanel panelParameterDaya = new FramedPanel();
        panelParameterDaya.setHeadingText("Input Parameter Daya");
        panelParameterDaya.setBodyStyle("background: none; padding: 5px");
        panelParameterDaya.setWidth(620);

        VerticalLayoutContainer vlcPParameterDaya = new VerticalLayoutContainer();
        panelParameterDaya.add(vlcPParameterDaya);


        HorizontalPanel hpDaya = new HorizontalPanel();

        NumberField<Integer> tfBottomDayaAwal = new NumberField<Integer>(new NumberPropertyEditor.IntegerPropertyEditor());
        tfBottomDayaAwal.setWidth(80);

        Label lblDaya = new Label(" s/d ");

        NumberField<Integer> tfBottomDayaAkhir = new NumberField<Integer>(new NumberPropertyEditor.IntegerPropertyEditor());
        tfBottomDayaAkhir.setWidth(80);

        hpDaya.add(tfBottomDayaAwal);
        hpDaya.add(lblDaya);
        hpDaya.add(tfBottomDayaAkhir);

        vlcPParameterDaya.add(new FieldLabel(hpDaya, "Daya"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1,new Margins(0,0,0,0)));


        TextButton bBottomRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        bBottomRekapitulasiPerTanggal.setWidth(150);
        TextButton bBottomRekapitulasiPerGolongan = new TextButton("Rekapitulasi Per Golongan");
        bBottomRekapitulasiPerGolongan.setWidth(150);
        TextButton bBottomDaftarRekening = new TextButton("Daftar Rekening");
        bBottomDaftarRekening.setWidth(150);

        TextButton bBottomRekapitulasiPerUnitUp = new TextButton("Rekapitulasi Per UnituP");
        bBottomRekapitulasiPerUnitUp.setWidth(150);
        TextButton bBottomRekapitulasiPerUnitUpPerGol = new TextButton("Rekapitulasi Per UnituP Per Gol");
        bBottomRekapitulasiPerUnitUpPerGol.setWidth(150);
        TextButton bBottomDaftarRekeningPerUnit = new TextButton("Daftar Rekening Per Unit");
        bBottomDaftarRekeningPerUnit.setWidth(150);

        hpDaya = new HorizontalPanel();

        hpDaya.add(bBottomRekapitulasiPerTanggal);
        hpDaya.add(bBottomRekapitulasiPerUnitUp);

        vlcPParameterDaya.add(hpDaya);

        hpDaya = new HorizontalPanel();

        hpDaya.add(bBottomRekapitulasiPerGolongan);
        hpDaya.add(bBottomRekapitulasiPerUnitUpPerGol);

        vlcPParameterDaya.add(hpDaya);

        hpDaya = new HorizontalPanel();

        hpDaya.add(bBottomDaftarRekening);
        hpDaya.add(bBottomDaftarRekeningPerUnit);

        vlcPParameterDaya.add(hpDaya);

        p.add(panelParameterDaya);

        return panel;
    }
}
