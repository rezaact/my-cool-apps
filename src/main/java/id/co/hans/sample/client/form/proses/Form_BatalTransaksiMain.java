package id.co.hans.sample.client.form.proses;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.sencha.gxt.widget.core.client.form.Radio;
import com.sencha.gxt.widget.core.client.form.TextField;
import id.co.hans.sample.client.AbstractForm;
import id.co.hans.sample.client.components.IconComboBox;
import id.co.hans.sample.client.components.IconDynamicGrid;

public class Form_BatalTransaksiMain  extends AbstractForm {

    private Radio radioTopTglLunas;
    private HorizontalPanel hlcBatalNotaBuku;

    protected FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Batal Transaksi Nota Buku");
        panel.setBodyStyle("background: none; padding: 5px");
//        panel.setWidth(650);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);


        // panel "Batal Nota Buku"
        FramedPanel panelBatalNotaBuku = new FramedPanel();
        panelBatalNotaBuku.setHeadingText("Pembatalan Transaksi Nota Buku");
        panelBatalNotaBuku.setBodyStyle("background: none; padding: 5px");
//        panelAnggotaNotaBuku.setWidth(623);
//        panelAnggotaNotaBuku.setHeight(400);

        VerticalLayoutContainer vlcBatalNotaBuku = new VerticalLayoutContainer();
        panelBatalNotaBuku.add(vlcBatalNotaBuku);

        hlcBatalNotaBuku = new HorizontalPanel();

        // panel " batal data"
        FramedPanel panelBatalData = new FramedPanel();
        FieldSet fsPembatalan=new FieldSet();
        panelBatalData.setHeadingText("Tambah Data");
        panelBatalData.setBodyStyle("background: none; padding: 5px");
//        panelTambahData.setWidth(400);
//        panelTambahData.setHeight(250);

//        VerticalLayoutContainer vlcTambahData= new VerticalLayoutContainer();
        HorizontalPanel hlcPembatalan = new HorizontalPanel();

        Label lbl01 = new Label("Pilih Kode Kolektif: ");
//        lbl01.getElement().getStyle().setMarginLeft(5, Style.Unit.PX);
//        lbl01.getElement().getStyle().setMarginRight(5, Style.Unit.PX);
//        lbl01.getElement().getStyle().setMarginTop(3, Style.Unit.PX);
        hlcPembatalan.add(lbl01);

        IconComboBox cbPilihKode = new IconComboBox();
//         cbPilihKode.setComboWidth(20);
        hlcPembatalan.add(cbPilihKode);

        TextField txKodeKolektif= new TextField();
        hlcPembatalan.add(txKodeKolektif);
        TextButton btnKodeKolektif= new TextButton("Ambil Data");
        hlcPembatalan.add(btnKodeKolektif);


        fsPembatalan.add(hlcPembatalan);
        panelBatalData.add(fsPembatalan);

//        hlcNota.add(panelTambahData);

        vlcBatalNotaBuku.add(panelBatalData);


//        vlcAnggotaNotaBuku.add(fs);

        p.add(panelBatalNotaBuku);


        // panel "Data CN"

        IconDynamicGrid gpDataCN = new IconDynamicGrid();
        gpDataCN.setGridHeader("Data Tagihan");
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

        FieldSet fs=new FieldSet();
        VerticalLayoutContainer vclBk = new VerticalLayoutContainer();
        TextField txRpTagihan = new TextField();
        vclBk.add(new FieldLabel(txRpTagihan, "RP Tagihan"));

        TextField txRpBk = new TextField();
        vclBk.add(new FieldLabel(txRpBk, "RP BK"));
        fs.add(vclBk);


        p.add(fs);
        HorizontalPanel hlcButton = new HorizontalPanel();
        TextButton btnProses= new TextButton("Proses");
        TextButton btnReset= new TextButton("Reset");
//        btnProses.setIconAlign(ButtonCell.IconAlign.LEFT);
        hlcButton.add(btnProses);
        hlcButton.add(btnReset);

        p.add(hlcButton);
        return panel;
    }

    @Override
    protected void initEvent() {

    }

}

