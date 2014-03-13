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

public class Form_Report21_Unit {


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
        panel.setHeadingText("Report 21 - Restitusi");
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

        p.add(panelReferensiTgl);


        TextButton bBottomRekapitulasiPerPaymentPoint = new TextButton("Rekapitulasi Per Payment Point");
        TextButton bBottomRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        TextButton bBottomRekapitulasiRekgBerjalanTunggakan = new TextButton("Rekapitulasi Rekg Berjalan Tunggakan");
        TextButton bBottomRekapitulasiPerGolonganTarip = new TextButton("Rekapitulasi Per Golongan Tarip");

        TextButton bBottomMilikSendiriRekapitulasiPerPaymentPoint = new TextButton("Rekapitulasi Per Payment Point");
        TextButton bBottomMilikSendiriRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        TextButton bBottomMilikSendiriRekapitulasiBahan404 = new TextButton("Rekapitulasi u/ Bahan 404");

        TextButton bBottomDiRoamingRekapitulasiPerUnitUpKirim = new TextButton("Rekapitulasi Per Unit UP Kirim");
        TextButton bBottomDiRoamingRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        TextButton bBottomDiRoamingRekapitulasiBahan404 = new TextButton("Rekapitulasi u/ Bahan 404");

        TextButton bBottomMeRoamingRekapitulasiPerUnitUpTerima = new TextButton("Rekapitulasi Per Unit UP Terima");
        TextButton bBottomMeRoamingRekapitulasiPerTanggal = new TextButton("Rekapitulasi Per Tanggal");
        TextButton bBottomMeRoamingRekapitulasiBahan404 = new TextButton("Rekapitulasi u/ Bahan 404");

        panel.addButton(bBottomRekapitulasiPerPaymentPoint);
        panel.addButton(bBottomRekapitulasiPerTanggal);
        panel.addButton(bBottomRekapitulasiRekgBerjalanTunggakan);
        panel.addButton(bBottomRekapitulasiPerGolonganTarip);

        panel.addButton(bBottomMilikSendiriRekapitulasiPerPaymentPoint);
        panel.addButton(bBottomMilikSendiriRekapitulasiPerTanggal);
        panel.addButton(bBottomMilikSendiriRekapitulasiBahan404);

        panel.addButton(bBottomDiRoamingRekapitulasiPerUnitUpKirim);
        panel.addButton(bBottomDiRoamingRekapitulasiPerTanggal);
        panel.addButton(bBottomDiRoamingRekapitulasiBahan404);

        panel.addButton(bBottomMeRoamingRekapitulasiPerUnitUpTerima);
        panel.addButton(bBottomMeRoamingRekapitulasiPerTanggal);
        panel.addButton(bBottomMeRoamingRekapitulasiBahan404);

        return panel;
    }
}
