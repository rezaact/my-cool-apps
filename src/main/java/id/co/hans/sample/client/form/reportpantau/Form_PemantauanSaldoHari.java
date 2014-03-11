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

public class Form_PemantauanSaldoHari {


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
        panel.setHeadingText("Saldo per-Tanggal");
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

        ComboTanggal cbTopPilihTanggalAwal = new ComboTanggal();
        cbTopPilihTanggalAwal.hideLabel();

        Label lbl = new Label(" s/d ");

        ComboTanggal cbTopPilihTanggalAkhir = new ComboTanggal();
        cbTopPilihTanggalAkhir.hideLabel();

        hp1.add(cbTopPilihTanggalAwal);
        hp1.add(lbl);
        hp1.add(cbTopPilihTanggalAkhir);

        vlcPReferensiTgl.add(new FieldLabel(hp1, "Pilih Tanggal"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1,new Margins(0,0,0,0)));

        p.add(panelReferensiTgl);



        FramedPanel panelButton = new FramedPanel();
        panelButton.setBodyStyle("background: none; padding: 5px");
        panelButton.setWidth(620);

        VerticalLayoutContainer vlcPButton = new VerticalLayoutContainer();
        panelButton.add(vlcPButton);

        TextButton bBottomSaldoRekeningLancar = new TextButton("Saldo Rekening Lancar");
        TextButton bBottomSaldoRekeningRagu2 = new TextButton("Saldo Rekening Ragu2");

        TextButton bBottomSaldoRekeningLancarPerGol = new TextButton("Saldo Rekening Lancar Per Gol");

        bBottomSaldoRekeningLancar.setWidth(220);
        bBottomSaldoRekeningRagu2.setWidth(220);

        bBottomSaldoRekeningLancarPerGol.setWidth(220);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomSaldoRekeningLancar);
        hp1.add(bBottomSaldoRekeningLancarPerGol);

        vlcPButton.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomSaldoRekeningRagu2);

        vlcPButton.add(hp1);

        p.add(panelButton);


        return panel;
    }
}
