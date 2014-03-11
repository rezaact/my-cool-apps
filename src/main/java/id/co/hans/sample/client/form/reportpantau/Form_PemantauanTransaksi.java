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

public class Form_PemantauanTransaksi {


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
        panel.setHeadingText("Transaksi Piutang");
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

        ComboUnit cbUnit = new ComboUnit();
        vlcPReferensi.add(cbUnit);

        ComboJenisTransaksi cbJenisTransaksi = new ComboJenisTransaksi();
        cbJenisTransaksi.setFormAsal("Form_PemantauanTransaksi");
        vlcPReferensi.add(cbJenisTransaksi);

        p.add(panelReferensi);


        FramedPanel panelReferensiTgl = new FramedPanel();
        panelReferensiTgl.setBodyStyle("background: none; padding: 5px");
        panelReferensiTgl.setWidth(620);

        VerticalLayoutContainer vlcPReferensiTgl = new VerticalLayoutContainer();
        panelReferensiTgl.add(vlcPReferensiTgl);

        Radio radioTopJenisPemantauanDaftar = new Radio();
        radioTopJenisPemantauanDaftar.setBoxLabel("Daftar");
        radioTopJenisPemantauanDaftar.setValue(true);

        Radio radioTopJenisPemantauanRekap = new Radio();
        radioTopJenisPemantauanRekap.setBoxLabel("Rekap");

        HorizontalPanel hp1 = new HorizontalPanel();
        hp1.add(radioTopJenisPemantauanDaftar);
        hp1.add(radioTopJenisPemantauanRekap);

        vlcPReferensiTgl.add(new FieldLabel(hp1, "Pilih Jenis Pemantauan"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1, new Margins(0,0,0,0)));

        p.add(panelReferensiTgl);


        FramedPanel panelReferensiJnsTgl = new FramedPanel();
        panelReferensiJnsTgl.setBodyStyle("background: none; padding: 5px");
        panelReferensiJnsTgl.setWidth(620);

        VerticalLayoutContainer vlcPReferensiJnsTgl = new VerticalLayoutContainer();
        panelReferensiJnsTgl.add(vlcPReferensiJnsTgl);

        Radio radioTopJenisTanggalTransaksi = new Radio();
        radioTopJenisTanggalTransaksi.setBoxLabel("Transaksi");
        radioTopJenisTanggalTransaksi.setValue(true);

        Radio radioTopJenisTanggalPembukuan = new Radio();
        radioTopJenisTanggalPembukuan.setBoxLabel("Pembukuan");

        hp1 = new HorizontalPanel();
        hp1.add(radioTopJenisTanggalTransaksi);
        hp1.add(radioTopJenisTanggalPembukuan);

        vlcPReferensiJnsTgl.add(new FieldLabel(hp1, "Pilih Jenis Tanggal"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1, new Margins(0,0,0,0)));

        p.add(panelReferensiJnsTgl);


        FramedPanel panelReferensiTgl2 = new FramedPanel();
        panelReferensiTgl2.setBodyStyle("background: none; padding: 5px");
        panelReferensiTgl2.setWidth(620);

        VerticalLayoutContainer vlcPReferensiJnsTgl2 = new VerticalLayoutContainer();
        panelReferensiTgl2.add(vlcPReferensiJnsTgl2);

        DateField dfTopTanggalAwal = new DateField();
        DateField dfTopTanggalAkhir = new DateField();

        TextButton bTopTampilkan = new TextButton("Tampilkan");

        hp1 = new HorizontalPanel();
        hp1.add(dfTopTanggalAwal);
        hp1.add(bTopTampilkan);

        vlcPReferensiJnsTgl2.add(new FieldLabel(hp1, "Tanggal"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1, new Margins(0,0,0,0)));

        hp1 = new HorizontalPanel();
        hp1.add(dfTopTanggalAkhir);

        vlcPReferensiJnsTgl2.add(new FieldLabel(hp1, "Tanggal Akhir"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1, new Margins(0,0,0,0)));

        p.add(panelReferensiTgl2);


        IconDynamicGrid gpData = new IconDynamicGrid();
        gpData.setGridHeader("Data");
        gpData.setGridDimension(620, 150);
        gpData.setStoreUrl("url");

        gpData.addColumn("No", 100);

        p.add(gpData);



        FramedPanel panelButton = new FramedPanel();
        panelButton.setBodyStyle("background: none; padding: 5px");
        panelButton.setWidth(620);

        VerticalLayoutContainer vlcPButton = new VerticalLayoutContainer();
        panelButton.add(vlcPButton);

        TextField tfBottomRpTagihan = new TextField();
        TextField tfBottomRpBK = new TextField();

        TextButton btnCetak = new TextButton("Cetak");
        btnCetak.setWidth(220);


        hp1 = new HorizontalPanel();
        hp1.add(new FieldLabel(tfBottomRpTagihan, "RP TAGIHAN"));
        vlcPButton.add(hp1);

        hp1 = new HorizontalPanel();
        hp1.add(new FieldLabel(tfBottomRpBK, "RP BK"));
        vlcPButton.add(hp1);

        hp1 = new HorizontalPanel();
        hp1.add(btnCetak);
        vlcPButton.add(hp1);

        p.add(panelButton);


        ToggleGroup tg = new ToggleGroup();
        tg.add(radioTopJenisPemantauanDaftar);
        tg.add(radioTopJenisPemantauanRekap);

        ToggleGroup tg2 = new ToggleGroup();
        tg2.add(radioTopJenisTanggalPembukuan);
        tg2.add(radioTopJenisTanggalTransaksi);

        return panel;
    }
}
