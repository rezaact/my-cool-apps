package id.co.hans.sample.client.form.monitoring;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.*;

public class Form_MonitoringKirimTerima {


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
        panel.setHeadingText("Monitoring Transaksi (Jurnal)");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(770);
//        panel.setHeight(500);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        HorizontalPanel h1 = new HorizontalPanel();

        // panel "Pilih Referensi"
        FramedPanel panel1_1 = new FramedPanel();
        panel1_1.setHeadingText("Pilih Referensi");
        panel1_1.setBodyStyle("background: none; padding: 5px");
        panel1_1.setWidth(390);
        panel1_1.setHeight(100);

        VerticalLayoutContainer p1_1 = new VerticalLayoutContainer();
        panel1_1.add(p1_1);

        ComboUnit cbUnitKirim = new ComboUnit();
        p1_1.add(cbUnitKirim);

        ComboUnit cbUnitTerima = new ComboUnit();
        p1_1.add(cbUnitTerima);

        h1.add(panel1_1);



        // panel Title="Pilih Parameter"
        FramedPanel panel1_2 = new FramedPanel();
        panel1_2.setHeadingText("Pilih Parameter");
        panel1_2.setBodyStyle("background: none; padding: 5px");
        panel1_2.setWidth(350);
        panel1_2.setHeight(100);

        VerticalLayoutContainer p1_2 = new VerticalLayoutContainer();
        panel1_2.add(p1_2);

        HorizontalPanel hp = new HorizontalPanel();

        Radio radioTopBulan = new Radio();
        radioTopBulan.setBoxLabel("Bulan :");
        radioTopBulan.setValue(true);
        radioTopBulan.setWidth(80);

        ComboTahunBulan cbTahunBulan = new ComboTahunBulan();
        cbTahunBulan.hideLabel();

        hp.add(radioTopBulan);
        hp.add(cbTahunBulan);

        p1_2.add(hp);

        HorizontalPanel hp2 = new HorizontalPanel();

        Radio radioTopTanggal = new Radio();
        radioTopTanggal.setBoxLabel("Tanggal :");
        radioTopTanggal.setWidth(80);

        DateField dfTopTanggalAwal = new DateField();
        dfTopTanggalAwal.setWidth(100);

        Label lbl = new Label("Sampai");

        DateField dfTopTanggalAkhir = new DateField();
        dfTopTanggalAkhir.setWidth(100);

        hp2.add(radioTopTanggal);
        hp2.add(dfTopTanggalAwal);
        hp2.add(lbl);
        hp2.add(dfTopTanggalAkhir);

        p1_2.add(hp2);

        h1.add(panel1_2);

        p.add(h1);

        ToggleGroup tg = new ToggleGroup();
        tg.add(radioTopBulan);
        tg.add(radioTopTanggal);


        // panel Title="Grouping Filter"

        FramedPanel panel2_0 = new FramedPanel();
        panel2_0.setBodyStyle("background: none; padding: 5px");
        panel2_0.setWidth(740);
        panel2_0.setHeight(80);

        VerticalLayoutContainer p2_0 = new VerticalLayoutContainer();
        panel2_0.add(p2_0);
        p2_0.add(new TextButton("Filter"));

        p.add(panel2_0);

        // panel "Data CN"

        IconDynamicGrid gpTransaksi = new IconDynamicGrid();
        gpTransaksi.setGridHeader("Data Master");
        gpTransaksi.setGridDimension(740, 200);
        gpTransaksi.setStoreUrl("BasicProject/thuGetString.json?name=store1");

        gpTransaksi.addColumn("BOOL", 100);
        gpTransaksi.addColumn("BLTH", 100);
        gpTransaksi.addColumn("IDPEL", 100);
        gpTransaksi.addColumn("UPLOADTIME", 100);
        gpTransaksi.addColumn("TGLBAYAR", 100);
        gpTransaksi.addColumn("UNITUP", 100);
        gpTransaksi.addColumn("KDKIRIM", 100);
        gpTransaksi.addColumn("KDTERIMA", 100);

        p.add(gpTransaksi);

        return panel;
    }
}
