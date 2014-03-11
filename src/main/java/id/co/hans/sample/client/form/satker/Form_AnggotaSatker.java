package id.co.hans.sample.client.form.satker;

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

public class Form_AnggotaSatker {


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
        panel.setHeadingText("Manajemen Anggota Satker");
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

        ComboTingkatSatuanKerja cbTingkatSatKer = new ComboTingkatSatuanKerja();
        vlcPReferensi.add(cbTingkatSatKer);

        ComboKotama cbKotama = new ComboKotama();
        vlcPReferensi.add(cbKotama);

        ComboSatuanKerja cbSatKer = new ComboSatuanKerja();
        vlcPReferensi.add(cbSatKer);

        p.add(panelReferensi);



        FramedPanel panelDataAnggotaSatker = new FramedPanel();
        panelDataAnggotaSatker.setHeadingText("Data Anggota Satker");
        panelDataAnggotaSatker.setBodyStyle("background: none; padding: 5px");
        panelDataAnggotaSatker.setWidth(620);

        VerticalLayoutContainer vlcPDataAnggotaSatker = new VerticalLayoutContainer();
        panelDataAnggotaSatker.add(vlcPDataAnggotaSatker);

        TextField tIDPel = new TextField();
        vlcPDataAnggotaSatker.add(new FieldLabel(tIDPel, "ID Pelanggan"));

        TextField tNama = new TextField();
        vlcPDataAnggotaSatker.add(new FieldLabel(tNama, "Nama"));

        TextArea tKeterangan = new TextArea();
        vlcPDataAnggotaSatker.add(new FieldLabel(tKeterangan, "Alamat"));

        TextField tTarip = new TextField();
        vlcPDataAnggotaSatker.add(new FieldLabel(tTarip, "Tarip"));

        TextField tDaya = new TextField();
        vlcPDataAnggotaSatker.add(new FieldLabel(tDaya, "Daya"));

        TextField tKogol = new TextField();
        vlcPDataAnggotaSatker.add(new FieldLabel(tKogol, "Kogol"));

        TextButton bBottomTampilkanLaporan = new TextButton("Tampilkan Laporan");
        bBottomTampilkanLaporan.setWidth(220);

        TextButton btnCari = new TextButton("Cari");
        btnCari.setWidth(150);

        TextButton btnTambah = new TextButton("Tambah");
        btnTambah.setWidth(150);

        TextButton btnHapusAnggota = new TextButton("Hapus");
        btnHapusAnggota.setWidth(150);

        HorizontalPanel hp1 = new HorizontalPanel();
        hp1.add(btnCari);
        hp1.add(btnTambah);
        hp1.add(btnHapusAnggota);
        vlcPDataAnggotaSatker.add(hp1);

        p.add(panelDataAnggotaSatker);

        IconDynamicGrid gpAnggotaSatker = new IconDynamicGrid();
        gpAnggotaSatker.setStoreUrl("url");
        gpAnggotaSatker.setGridDimension(620, 150);
        gpAnggotaSatker.setGridHeader("Data");
        gpAnggotaSatker.addColumn("IDPEL", 100);
        gpAnggotaSatker.addColumn("NAMA", 100);
        gpAnggotaSatker.addColumn("ALAMAT", 100);
        gpAnggotaSatker.addColumn("TARIP", 100);
        gpAnggotaSatker.addColumn("DAYA", 100);

        p.add(gpAnggotaSatker);

        return panel;
    }
}
