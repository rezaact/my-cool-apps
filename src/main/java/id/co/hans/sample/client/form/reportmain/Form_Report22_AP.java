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

public class Form_Report22_AP {


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
        panel.setHeadingText("Laporan Pelunasan Rekening Online");
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

        ComboTanggal dfTanggalPelunasanAwal = new ComboTanggal();
        dfTanggalPelunasanAwal.hideLabel();

        Label lbl = new Label(" s/d ");

        ComboTanggal dfTanggalPelunasanAkhir = new ComboTanggal();
        dfTanggalPelunasanAkhir.hideLabel();

        hp1.add(dfTanggalPelunasanAwal);
        hp1.add(lbl);
        hp1.add(dfTanggalPelunasanAkhir);

        vlcPParameter.add(new FieldLabel(hp1, "Pilih Tanggal Pelunasan"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1,new Margins(0,0,0,0)));

        p.add(panelParameter);


        FramedPanel panelParameterRadio = new FramedPanel();
        panelParameterRadio.setBodyStyle("background: none; padding: 5px");
        panelParameterRadio.setWidth(620);

        VerticalLayoutContainer vlcPParameterRadio = new VerticalLayoutContainer();
        panelParameterRadio.add(vlcPParameterRadio);


        HorizontalPanel hpRadio = new HorizontalPanel();

        Radio radioUnitFilter = new Radio();
        radioUnitFilter.setBoxLabel("Unit Filter");

        Radio radioUnitDiBawahUnitFilter = new Radio();
        radioUnitDiBawahUnitFilter.setBoxLabel("Unit Dibawah Unit Filter");

        hpRadio.add(radioUnitFilter);
        hpRadio.add(radioUnitDiBawahUnitFilter);

        vlcPParameterRadio.add(hpRadio);

        p.add(panelParameterRadio);


        TextButton bBottomRekapitulasiPerKodeGolongan = new TextButton("Rekapitulasi per Kode Golongan");
        TextButton bBottomRekapitulasiPerTanggalLunas = new TextButton("Rekapitulasi per Tanggal Lunas");
        TextButton bBottomRekapitulasiPerKdpp = new TextButton("Rekapitulasi per KDPP");

        panel.addButton(bBottomRekapitulasiPerKodeGolongan);
        panel.addButton(bBottomRekapitulasiPerTanggalLunas);
        panel.addButton(bBottomRekapitulasiPerKdpp);

        return panel;
    }
}
