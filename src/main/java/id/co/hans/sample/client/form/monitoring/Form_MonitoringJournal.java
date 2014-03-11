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
import id.co.hans.sample.client.components.ComboTahunBulan;
import id.co.hans.sample.client.components.ComboUnits;
import id.co.hans.sample.client.components.IconComboBox;
import id.co.hans.sample.client.components.IconDynamicGrid;

public class Form_MonitoringJournal {


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
//        panel.setHeight(700);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        HorizontalPanel h1 = new HorizontalPanel();

        // panel "Pilih Referensi"
        FramedPanel panel1_1 = new FramedPanel();
        panel1_1.setHeadingText("Pilih Referensi");
        panel1_1.setBodyStyle("background: none; padding: 5px");
        panel1_1.setWidth(390);
        panel1_1.setHeight(160);

        VerticalLayoutContainer p1_1 = new VerticalLayoutContainer();
        panel1_1.add(p1_1);

        ComboUnits cbUnits = new ComboUnits();
        p1_1.add(cbUnits);

        h1.add(panel1_1);



        // panel Title="Pilih Parameter"
        FramedPanel panel1_2 = new FramedPanel();
        panel1_2.setHeadingText("Pilih Parameter");
        panel1_2.setBodyStyle("background: none; padding: 5px");
        panel1_2.setWidth(350);
        panel1_2.setHeight(160);

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
        panel2_0.setHeadingText("Grouping Filter");
        panel2_0.setBodyStyle("background: none; padding: 5px");
        panel2_0.setWidth(740);
        panel2_0.setHeight(300);

        VerticalLayoutContainer p2_0 = new VerticalLayoutContainer();
        panel2_0.add(p2_0);

        Radio radioMiddlePerTanggalBukuSemuaTransaksi = new Radio();
        radioMiddlePerTanggalBukuSemuaTransaksi.setBoxLabel("Per Tanggal Buku Semua Transaksi");
        radioMiddlePerTanggalBukuSemuaTransaksi.setValue(true);
        p2_0.add(radioMiddlePerTanggalBukuSemuaTransaksi);

        Radio radioMiddlePerTanggalTransaksiSemuaTransaksi = new Radio();
        radioMiddlePerTanggalTransaksiSemuaTransaksi.setBoxLabel("Per Tanggal Transaksi Semua Transaksi");
        p2_0.add(radioMiddlePerTanggalTransaksiSemuaTransaksi);

        Radio radioMiddlePerTanggalBukuSemuaTransaksiPerKogol = new Radio();
        radioMiddlePerTanggalBukuSemuaTransaksiPerKogol.setBoxLabel("Per Tanggal Buku Semua Transaksi Per Kogol");
        p2_0.add(radioMiddlePerTanggalBukuSemuaTransaksiPerKogol);

        Radio radioMiddlePerTanggalTransaksiSemuaTransaksiPerKogol = new Radio();
        radioMiddlePerTanggalTransaksiSemuaTransaksiPerKogol.setBoxLabel("Per Tanggal Transaksi Semua Transaksi Per Kogol");
        p2_0.add(radioMiddlePerTanggalTransaksiSemuaTransaksiPerKogol);

        Radio radioMiddlePerTanggalBukuSemuaTransaksiPerKogolPerJnsRek = new Radio();
        radioMiddlePerTanggalBukuSemuaTransaksiPerKogolPerJnsRek.setBoxLabel("Per Tanggal Buku Semua Transaksi Per Kogol Per Jns Rek");
        p2_0.add(radioMiddlePerTanggalBukuSemuaTransaksiPerKogolPerJnsRek);

        Radio radioMiddlePerTanggalTransaksiSemuaTransaksiPerKogolPerJnsRek = new Radio();
        radioMiddlePerTanggalTransaksiSemuaTransaksiPerKogolPerJnsRek.setBoxLabel("Per Tanggal Transaksi Semua Transaksi Per Kogol Per Jns Rek");
        p2_0.add(radioMiddlePerTanggalTransaksiSemuaTransaksiPerKogolPerJnsRek);

        Radio radioMiddlePerTanggalBukuSemuaTransaksiGerakTransaksi = new Radio();
        radioMiddlePerTanggalBukuSemuaTransaksiGerakTransaksi.setBoxLabel("Per Tanggal Buku Semua Transaksi (Gerak Transaksi)");
        p2_0.add(radioMiddlePerTanggalBukuSemuaTransaksiGerakTransaksi);

        Radio radioMiddlePerTanggalTransaksiSemuaTransaksiGerakTransaksi = new Radio();
        radioMiddlePerTanggalTransaksiSemuaTransaksiGerakTransaksi.setBoxLabel("Per Tanggal Transaksi Semua Transaksi (Gerak Transaksi)");
        p2_0.add(radioMiddlePerTanggalTransaksiSemuaTransaksiGerakTransaksi);

        Radio radioMiddlePerTanggalBukuSemuaTransaksiPerKogolGerakTransaksi = new Radio();
        radioMiddlePerTanggalBukuSemuaTransaksiPerKogolGerakTransaksi.setBoxLabel("Per Tanggal Buku Semua Transaksi Per Kogol (Gerak Transaksi)");
        p2_0.add(radioMiddlePerTanggalBukuSemuaTransaksiPerKogolGerakTransaksi);

        Radio radioMiddlePerTanggalTransaksiSemuaTransaksiPerKogolGerakTransaksi = new Radio();
        radioMiddlePerTanggalTransaksiSemuaTransaksiPerKogolGerakTransaksi.setBoxLabel("Per Tanggal Transaksi Semua Transaksi Per Kogol (Gerak Transaksi)");
        p2_0.add(radioMiddlePerTanggalTransaksiSemuaTransaksiPerKogolGerakTransaksi);

        Radio radioMiddlePerTanggalBukuSemuaTransaksiPerKogolPerJnsRekGerakTransaksi = new Radio();
        radioMiddlePerTanggalBukuSemuaTransaksiPerKogolPerJnsRekGerakTransaksi.setBoxLabel("Per Tanggal Buku Semua Transaksi Per Kogol Per Jns Rek (Gerak Transaksi)");
        p2_0.add(radioMiddlePerTanggalBukuSemuaTransaksiPerKogolPerJnsRekGerakTransaksi);

        Radio radioMiddlePerTanggalTransaksiSemuaTransaksiPerKogolPerJnsRekGerakTransaksi = new Radio();
        radioMiddlePerTanggalTransaksiSemuaTransaksiPerKogolPerJnsRekGerakTransaksi.setBoxLabel("Per Tanggal Transaksi Semua Transaksi Per Kogol Per Jns Rek (Gerak Transaksi)");
        p2_0.add(radioMiddlePerTanggalTransaksiSemuaTransaksiPerKogolPerJnsRekGerakTransaksi);

        p2_0.add(new TextButton("Filter"));

        p.add(panel2_0);

        ToggleGroup tg2 = new ToggleGroup();
        tg2.add(radioMiddlePerTanggalBukuSemuaTransaksi);
        tg2.add(radioMiddlePerTanggalBukuSemuaTransaksiGerakTransaksi);
        tg2.add(radioMiddlePerTanggalBukuSemuaTransaksiPerKogol);
        tg2.add(radioMiddlePerTanggalBukuSemuaTransaksiPerKogolGerakTransaksi);
        tg2.add(radioMiddlePerTanggalBukuSemuaTransaksiPerKogolPerJnsRek);
        tg2.add(radioMiddlePerTanggalBukuSemuaTransaksiPerKogolPerJnsRekGerakTransaksi);
        tg2.add(radioMiddlePerTanggalTransaksiSemuaTransaksi);
        tg2.add(radioMiddlePerTanggalTransaksiSemuaTransaksiGerakTransaksi);
        tg2.add(radioMiddlePerTanggalTransaksiSemuaTransaksiPerKogol);
        tg2.add(radioMiddlePerTanggalTransaksiSemuaTransaksiPerKogolGerakTransaksi);
        tg2.add(radioMiddlePerTanggalTransaksiSemuaTransaksiPerKogolPerJnsRek);
        tg2.add(radioMiddlePerTanggalTransaksiSemuaTransaksiPerKogolPerJnsRekGerakTransaksi);


        // panel "Data CN"

        IconDynamicGrid gpTransaksi = new IconDynamicGrid();
        gpTransaksi.setGridHeader("Data Master");
        gpTransaksi.setGridDimension(740, 200);
        gpTransaksi.setStoreUrl("BasicProject/thuGetString.json?name=store1");

        gpTransaksi.addColumn("KDPEMBPP", 100);
        gpTransaksi.addColumn("DATAPIUTANG", 100);
        gpTransaksi.addColumn("TGLBUKU", 100);
        gpTransaksi.addColumn("TANGGAL", 100);
        gpTransaksi.addColumn("KDGERAK", 100);
        gpTransaksi.addColumn("KET", 100);
        gpTransaksi.addColumn("UNITUP", 100);
        gpTransaksi.addColumn("GERAKPIUTANG", 100);
        gpTransaksi.addColumn("LEMBAR", 100);
        gpTransaksi.addColumn("RPPTL", 100);
        gpTransaksi.addColumn("RPPTB", 100);
        gpTransaksi.addColumn("RPPPN", 100);
        gpTransaksi.addColumn("RPBPJU", 100);
        gpTransaksi.addColumn("RPTRAFO", 100);
        gpTransaksi.addColumn("RPSEWATRAFO", 100);
        gpTransaksi.addColumn("RPSEWAKAP", 100);
        gpTransaksi.addColumn("RPANGSA", 100);
        gpTransaksi.addColumn("RPANGSB", 100);
        gpTransaksi.addColumn("RPANGSC", 100);
        gpTransaksi.addColumn("RPMAT", 100);
        gpTransaksi.addColumn("RPPLN", 100);
        gpTransaksi.addColumn("RPTAG", 100);
        gpTransaksi.addColumn("RPREDUKSI", 100);
        gpTransaksi.addColumn("RPINSENTIF", 100);
        gpTransaksi.addColumn("RPDISINSENTIF", 100);
        gpTransaksi.addColumn("RPBK1", 100);
        gpTransaksi.addColumn("RPBK2", 100);
        gpTransaksi.addColumn("RPBK3", 100);

        p.add(gpTransaksi);

        return panel;
    }
}
