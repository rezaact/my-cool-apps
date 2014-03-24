package id.co.hans.sample.client.form.proses;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.Radio;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;
import id.co.hans.sample.client.AbstractForm;
import id.co.hans.sample.client.components.IconComboBox;
import id.co.hans.sample.client.components.IconDynamicGrid;

public class Form_23AnggotaNotaTerpusat  extends AbstractForm {

    private Radio radioTopTglLunas;
    private HorizontalPanel hlcAnggotaNotaTerpusat;

    protected FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Anggota Lunas Terpusat (PgDT)");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);


        // panel "Anggota Nota Terpusat"
        FramedPanel panelAnggotaNotaTerpusat = new FramedPanel();
        panelAnggotaNotaTerpusat.setHeadingText("Manajemen Anggota Nota Terpusat");
        panelAnggotaNotaTerpusat.setBodyStyle("background: none; padding: 5px");
        panelAnggotaNotaTerpusat.setWidth(623);
        panelAnggotaNotaTerpusat.setHeight(400);

        VerticalLayoutContainer vlcAnggotaNotaTerpusat = new VerticalLayoutContainer();
        panelAnggotaNotaTerpusat.add(vlcAnggotaNotaTerpusat);

        hlcAnggotaNotaTerpusat = new HorizontalPanel();

        Label lbl01 = new Label("Pilih Kode");
        lbl01.getElement().getStyle().setMarginLeft(5, Style.Unit.PX);
        lbl01.getElement().getStyle().setMarginRight(5, Style.Unit.PX);
        lbl01.getElement().getStyle().setMarginTop(3, Style.Unit.PX);
        hlcAnggotaNotaTerpusat.add(lbl01);

        IconComboBox cbPilihKode = new IconComboBox();
        cbPilihKode.setComboWidth(20);
        hlcAnggotaNotaTerpusat.add(cbPilihKode);

        vlcAnggotaNotaTerpusat.add(hlcAnggotaNotaTerpusat, new VerticalLayoutContainer.VerticalLayoutData(-1,1));

        HorizontalPanel hlcNota = new HorizontalPanel();

        // panel " tambah data"
        FramedPanel panelTambahData = new FramedPanel();
        panelTambahData.setHeadingText("Tambah Data");
        panelTambahData.setBodyStyle("background: none; padding: 5px");
//        panelTambahData.setWidth(400);
//        panelTambahData.setHeight(250);

        hlcNota.add(panelTambahData);

        VerticalLayoutContainer vlcTambahData= new VerticalLayoutContainer();

        HorizontalPanel hlcIdpelTambah = new HorizontalPanel();
        Radio radioIdpelTambah = new Radio();
        radioIdpelTambah.setBoxLabel("ID Pelanggan");
        hlcIdpelTambah.add(radioIdpelTambah);

        TextField txIdpelTambah = new TextField();
        hlcIdpelTambah.add(txIdpelTambah);
        vlcTambahData.add(hlcIdpelTambah);

        HorizontalPanel hlcNopelTambah = new HorizontalPanel();
        Radio radioNopelTambah = new Radio();
        radioNopelTambah.setBoxLabel("No Pelanggan");
        hlcNopelTambah.add(radioNopelTambah);

        TextField txNopelTambah = new TextField();
        hlcNopelTambah.add(txNopelTambah);

        vlcTambahData.add(hlcNopelTambah);

        TextArea txket= new TextArea();

        vlcTambahData.add(new FieldLabel(txket, "Keterangan"), new VerticalLayoutContainer.VerticalLayoutData(1, 100));

        TextButton btnTambah = new TextButton("Tambah");
        vlcTambahData.add(btnTambah);

        panelTambahData.add(vlcTambahData);

        hlcNota.add(panelTambahData);

        // panel " hapus data"
        FramedPanel panelHapusData = new FramedPanel();
        panelHapusData.setHeadingText("Hapus Data");
        panelHapusData.setBodyStyle("background: none; padding: 5px");
//        panelTambahData.setWidth(400);
//        panelTambahData.setHeight(250);

        VerticalLayoutContainer vlcHapusData= new VerticalLayoutContainer();

        HorizontalPanel hlcIdpelHapus = new HorizontalPanel();
        Radio radioIdpelHapus = new Radio();
        radioIdpelHapus.setBoxLabel("ID Pelanggan");
        hlcIdpelHapus.add(radioIdpelHapus);

        TextField txIdpelHapus = new TextField();
        hlcIdpelHapus.add(txIdpelHapus);
        vlcHapusData.add(hlcIdpelHapus);

        HorizontalPanel hlcNopelHapus = new HorizontalPanel();

        Radio radioNopeHapus = new Radio();
        radioNopeHapus.setBoxLabel("No Pelanggan");
        hlcNopelHapus.add(radioNopeHapus);

        TextField txNopelHapus = new TextField();
        hlcNopelHapus.add(txNopelHapus);

        vlcHapusData.add(hlcNopelHapus);

        TextButton btnHapus = new TextButton("Hapus");
        vlcHapusData.add(btnHapus);

//        HorizontalPanel hlctxket = new HorizontalPanel();
//        Label lblKet = new Label("Keterangan");
//        lblKet.setWidth("25");
//        hlctxket.add(lblKet);
        panelHapusData.add(vlcHapusData);
        hlcNota.add(panelHapusData);

        vlcAnggotaNotaTerpusat.add(hlcNota);


        HorizontalPanel hlcNamaKode = new HorizontalPanel();
        Label lbl03 = new Label("Nama Kode");
        lbl03.getElement().getStyle().setMarginLeft(5, Style.Unit.PX);
        lbl03.getElement().getStyle().setMarginRight(5, Style.Unit.PX);
        lbl03.getElement().getStyle().setMarginTop(3, Style.Unit.PX);
        hlcNamaKode.add(lbl03);

        TextField txtNamaKode= new TextField();
        hlcNamaKode.add(txtNamaKode);
        TextButton btnTampilData = new TextButton("Tampil Data");
        hlcNamaKode.add(btnTampilData);
//        vlcAnggotaNotaTerpusat.add(new Label("_"));
        vlcAnggotaNotaTerpusat.add(hlcNamaKode);

//        vlcAnggotaNotaTerpusat.add(new Label("_"));

        p.add(panelAnggotaNotaTerpusat);


        // panel "Data CN"

        IconDynamicGrid gpDataCN = new IconDynamicGrid();
        gpDataCN.setGridHeader("Data Master");
        gpDataCN.setGridDimension(623, 200);
        gpDataCN.setStoreUrl("BasicProject/thuGetString.json?name=store1");
        gpDataCN.addColumn("CEK", 100);
        gpDataCN.addColumn("KDPP", 100);
        gpDataCN.addColumn("NO_BATULV06", 100);
        gpDataCN.addColumn("TGLTRANSAKSI", 100);
        gpDataCN.addColumn("TRANSAKSIID", 100);
        gpDataCN.addColumn("TRANSAKSIBY", 100);
        gpDataCN.addColumn("TGL_PELUNASAN", 100);
        gpDataCN.addColumn("TGL_SETOR", 100);
        gpDataCN.addColumn("RPTOTAL", 100);

        p.add(gpDataCN);




        return panel;
    }

    @Override
    protected void initEvent() {

    }
}
