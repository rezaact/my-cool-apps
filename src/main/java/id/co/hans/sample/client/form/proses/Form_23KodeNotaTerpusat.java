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

public class Form_23KodeNotaTerpusat extends AbstractForm {

    private Radio radioTopTglLunas;
    private HorizontalPanel hlcAnggotaNotaTerpusat;

    protected FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Kode Lunas Terpusat");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);


        // panel "Anggota Nota Terpusat"
        FramedPanel panelAnggotaNotaTerpusat = new FramedPanel();
        panelAnggotaNotaTerpusat.setHeadingText("Manajemen Kode Pelunasan Terpusat");
        panelAnggotaNotaTerpusat.setBodyStyle("background: none; padding: 5px");
        panelAnggotaNotaTerpusat.setWidth(623);
        panelAnggotaNotaTerpusat.setHeight(400);

        VerticalLayoutContainer vlcAnggotaNotaTerpusat = new VerticalLayoutContainer();
        panelAnggotaNotaTerpusat.add(vlcAnggotaNotaTerpusat);

        hlcAnggotaNotaTerpusat = new HorizontalPanel();

        HorizontalPanel hlcNota = new HorizontalPanel();

        // panel " tambah data"
        FramedPanel panelTambahData = new FramedPanel();
        panelTambahData.setHeadingText("Entri Nota Buku");
        panelTambahData.setBodyStyle("background: none; padding: 5px");
//        panelTambahData.setWidth(400);
//        panelTambahData.setHeight(250);

        hlcNota.add(panelTambahData);

        VerticalLayoutContainer vlcTambahData= new VerticalLayoutContainer();

        TextField txEntriKdNotaBuku=new TextField();
        vlcTambahData.add(new FieldLabel(txEntriKdNotaBuku, "Kode Nota Buku"));

        TextArea txaEntriNamaNotaBuku= new TextArea();

        vlcTambahData.add(new FieldLabel(txaEntriNamaNotaBuku, "Nama Nota Buku"));

        HorizontalPanel hlcBtnEntriTambah = new HorizontalPanel();
        TextButton btnTambah = new TextButton("Tambah");
        hlcBtnEntriTambah.add(btnTambah);
        TextButton btnReset = new TextButton("Reset");
        hlcBtnEntriTambah.add(btnReset);
        vlcTambahData.add(hlcBtnEntriTambah);

        panelTambahData.add(vlcTambahData);

        hlcNota.add(panelTambahData);

        // panel " hapus data"
        FramedPanel panelHapusData = new FramedPanel();
        panelHapusData.setHeadingText("Hapus Nota Buku");
        panelHapusData.setBodyStyle("background: none; padding: 5px");
//        panelTambahData.setWidth(400);
//        panelTambahData.setHeight(250);

        VerticalLayoutContainer vlcHapusData= new VerticalLayoutContainer();

        TextField txHpsKdNotaBuku=new TextField();
        vlcHapusData.add(new FieldLabel(txHpsKdNotaBuku, "Kode Nota Buku"));

        TextArea txaHapusNamaNotaBuku= new TextArea();

        vlcHapusData.add(new FieldLabel(txaHapusNamaNotaBuku, "Nama Nota Buku"));


        HorizontalPanel hlcBtnEntriHapus= new HorizontalPanel();
        TextButton btnHapus = new TextButton("Hapus");
        hlcBtnEntriHapus.add(btnHapus);
        TextButton btnHapusReset = new TextButton("Reset");
        hlcBtnEntriHapus.add(btnHapusReset);
        vlcHapusData.add(hlcBtnEntriHapus);

//        HorizontalPanel hlctxket = new HorizontalPanel();
//        Label lblKet = new Label("Keterangan");
//        lblKet.setWidth("25");
//        hlctxket.add(lblKet);
        panelHapusData.add(vlcHapusData);
        hlcNota.add(panelHapusData);

        vlcAnggotaNotaTerpusat.add(hlcNota);



        // panel "Data CN"

        IconDynamicGrid gpDataCN = new IconDynamicGrid();
        gpDataCN.setGridHeader("Data");
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
        vlcAnggotaNotaTerpusat.add(gpDataCN);
        p.add(panelAnggotaNotaTerpusat);




        return panel;
    }

    @Override
    protected void initEvent() {

    }
}
