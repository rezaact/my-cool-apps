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

public class Form_UnitUpi {


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
        panel.setHeadingText("Master Unit Pelayanan Induk");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);


        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        TextField tfUnit = new TextField();
        tfUnit.setAllowBlank(false);
        p.add(new FieldLabel(tfUnit, "Unit UPI"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField tfSatuan = new TextField();
        tfSatuan.setAllowBlank(false);
        p.add(new FieldLabel(tfSatuan, "Satuan"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField tfAlamat = new TextField();
        tfAlamat.setAllowBlank(false);
        p.add(new FieldLabel(tfAlamat, "Alamat"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField tfTelepon = new TextField();
        tfTelepon.setAllowBlank(false);
        p.add(new FieldLabel(tfTelepon, "Telepon"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField tfFaximile = new TextField();
        tfFaximile.setAllowBlank(false);
        p.add(new FieldLabel(tfFaximile, "Faximile"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField tfManager = new TextField();
        tfManager.setAllowBlank(false);
        p.add(new FieldLabel(tfManager, "Manager"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField tfKota = new TextField();
        tfKota.setAllowBlank(false);
        p.add(new FieldLabel(tfKota, "Kota"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        panel.addButton(new TextButton("Tambah Baru"));
        panel.addButton(new TextButton("Simpan"));


        IconDynamicGrid gridPelangganBtoBDetil = new IconDynamicGrid();
        gridPelangganBtoBDetil.setGridHeader("Data Master Unit Pelayanan Induk");
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
