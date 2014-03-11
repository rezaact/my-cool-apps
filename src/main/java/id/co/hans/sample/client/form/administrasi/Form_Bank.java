package id.co.hans.sample.client.form.administrasi;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.TextField;
import id.co.hans.sample.client.components.IconDynamicGrid;

public class Form_Bank {

    private VerticalPanel vp;

    final FormPanel form = new FormPanel();
    private TextField tfKodeRanting, tfKodeRantingNumerik, tfKodeBank, tfNamaBank, tfAlamat, tfJenisBank,
            tfKodeGerakKeluar, tfPengelola, tfRekNo, tfBank;
    private TextButton bTopAddNew, bTopSave;
    private IconDynamicGrid gridPelangganBtoBDetil;


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
        panel.setHeadingText("Master Bank");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        form.setAction("URLtoSave");
        form.setEncoding(FormPanel.Encoding.MULTIPART);
        form.setMethod(FormPanel.Method.POST);
        panel.add(form);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        form.add(p);

        tfKodeRanting = new TextField();
        tfKodeRanting.setAllowBlank(false);
        p.add(new FieldLabel(tfKodeRanting, "Kode Ranting"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        tfKodeRantingNumerik = new TextField();
        tfKodeRantingNumerik.setAllowBlank(false);
        p.add(new FieldLabel(tfKodeRantingNumerik, "Kode Ranting Numerik"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        tfKodeBank = new TextField();
        tfKodeBank.setAllowBlank(false);
        p.add(new FieldLabel(tfKodeBank, "Kode Bank"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        tfNamaBank = new TextField();
        tfNamaBank.setAllowBlank(false);
        p.add(new FieldLabel(tfNamaBank, "Nama Bank"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        tfAlamat = new TextField();
        tfAlamat.setAllowBlank(false);
        p.add(new FieldLabel(tfAlamat, "Alamat"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        tfJenisBank = new TextField();
        tfJenisBank.setAllowBlank(false);
        p.add(new FieldLabel(tfJenisBank, "Jenis Bank"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        tfKodeGerakKeluar = new TextField();
        tfKodeGerakKeluar.setAllowBlank(false);
        p.add(new FieldLabel(tfKodeGerakKeluar, "Kode Gerak Keluar"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        tfPengelola = new TextField();
        tfPengelola.setAllowBlank(false);
        p.add(new FieldLabel(tfPengelola, "Pengelola"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        tfRekNo = new TextField();
        tfRekNo.setAllowBlank(false);
        p.add(new FieldLabel(tfRekNo, "RekNo"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        tfBank = new TextField();
        tfBank.setAllowBlank(false);
        p.add(new FieldLabel(tfBank, "Bank"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        bTopAddNew = new TextButton("Tambah Baru");
        bTopSave = new TextButton("Simpan");

        panel.addButton(bTopAddNew);
        panel.addButton(bTopSave);


        gridPelangganBtoBDetil = new IconDynamicGrid();
        gridPelangganBtoBDetil.setGridHeader("Data Master");
        gridPelangganBtoBDetil.setGridHeight(150);
        gridPelangganBtoBDetil.setGridWidth(620);
        gridPelangganBtoBDetil.setStoreUrl("BasicProject/thuGetString.json?name=store1");

        gridPelangganBtoBDetil.addColumn("UNITUPI", 100);
        gridPelangganBtoBDetil.addColumn("SATUAN", 150);
        gridPelangganBtoBDetil.addColumn("NAMA", 90);
        gridPelangganBtoBDetil.addColumn("ALAMAT", 70);
        gridPelangganBtoBDetil.addColumn("TELEPON", 70);
        gridPelangganBtoBDetil.addColumn("FAXIMILE", 70);
        gridPelangganBtoBDetil.addColumn("MANAGER", 70);
        gridPelangganBtoBDetil.addColumn("KOTA", 70);
        gridPelangganBtoBDetil.addColumn("UNITUPIERP", 70);

        p.add(gridPelangganBtoBDetil);

        gridPelangganBtoBDetil.getView().setStripeRows(true);
        gridPelangganBtoBDetil.getView().setColumnLines(true);

        return panel;
    }
}
