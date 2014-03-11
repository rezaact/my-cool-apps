package id.co.hans.sample.client.form;

import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.ButtonCell;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.*;
import com.sencha.gxt.widget.core.client.form.validator.MaxLengthValidator;
import id.co.hans.sample.client.components.ComboTahunBulan;
import id.co.hans.sample.client.components.ComboUnits;
import id.co.hans.sample.client.components.IconDynamicGrid;
import id.co.hans.sample.client.components.TextFieldsInfoPelanggan;

public class FormPelangganBtoB {

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

        TabPanel tabMain = new TabPanel();
        tabMain.setWidth("650");

        tabMain.add(panelEntry(), "Entry");
        tabMain.add(panelFilter(), "List");

        vp.add(tabMain);

        windowDetil();
    }

    private FormPanel panelEntry() {
        FormPanel panel = new FormPanel();

        FramedPanel framePelanggan = new FramedPanel();
        framePelanggan.setHeadingText("Pelanggan B to B");
        framePelanggan.setBodyStyle("background: none; padding: 5px");

        panel.setWidget(framePelanggan);

        VerticalLayoutContainer vlMain = new VerticalLayoutContainer();
        framePelanggan.add(vlMain);

        FieldSet fsCari = new FieldSet();
        fsCari.setCollapsible(false);
        fsCari.setHeadingText("Pencarian");

        vlMain.add(fsCari, new VerticalLayoutContainer.VerticalLayoutData(1, 65));

        HorizontalLayoutContainer hlCari = new HorizontalLayoutContainer();
        fsCari.add(hlCari);

        TextField tfCariIdpel = new TextField();
        tfCariIdpel.setWidth(150);
        tfCariIdpel.setAllowBlank(false);
        tfCariIdpel.setEmptyText("Masukkan Id Pelanggan");

        hlCari.add(tfCariIdpel);

        TextButton bCari = new TextButton("Cari");
//        bCari.setIcon(ImagesCollection.INSTANCE.find());
        bCari.setIconAlign(ButtonCell.IconAlign.LEFT);

        hlCari.add(bCari);

        FieldSet fsInfo = new FieldSet();
        fsInfo.setCollapsible(true);
        fsInfo.setHeadingText("Info Pelanggan");

        vlMain.add(fsInfo, new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextFieldsInfoPelanggan tfInfoPelanggan = new TextFieldsInfoPelanggan();
        fsInfo.add(tfInfoPelanggan);

        FieldSet fsDaya = new FieldSet();
        fsDaya.setCollapsible(false);
        fsDaya.setHeadingText("Daya");

        VerticalLayoutContainer vlDaya = new VerticalLayoutContainer();
        fsDaya.add(vlDaya);

        NumberField nfDayaBtoB = new NumberField(new NumberPropertyEditor.BigDecimalPropertyEditor());
        vlDaya.add(new FieldLabel(nfDayaBtoB, "Daya BToB"));

        vlMain.add(fsDaya, new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        HorizontalPanel hpButton = new HorizontalPanel();
        hpButton.setSpacing(5);

        TextButton bHapus = new TextButton("Hapus");
//        bHapus.setIcon(ImagesCollection.INSTANCE.delete());
        bHapus.setIconAlign(ButtonCell.IconAlign.LEFT);

        hpButton.add(bHapus);

        TextButton bSimpan = new TextButton("Simpan");
//        bHapus.setIcon(ImagesCollection.INSTANCE.save());
        bSimpan.setIconAlign(ButtonCell.IconAlign.LEFT);

        hpButton.add(bSimpan);

        vlMain.add(hpButton);

        SafeStyles textStyles = SafeStylesUtils.fromTrustedString("padding: 1px 3px;");

        IconDynamicGrid gridPelangganBtoBDetil = new IconDynamicGrid();
        gridPelangganBtoBDetil.setGridHeader("Detil Pelanggan");
        gridPelangganBtoBDetil.setGridHeight(150);
        gridPelangganBtoBDetil.setGridWidth(500);
        gridPelangganBtoBDetil.setStoreUrl("BasicProject/thuGetString.json?name=store1");

        gridPelangganBtoBDetil.addColumn("IDPEL", 100);
        gridPelangganBtoBDetil.addColumn("NAMA", 150);
        gridPelangganBtoBDetil.addColumn("DAYABTOB", 90);
        gridPelangganBtoBDetil.addColumn("THBLREK", 70);
        gridPelangganBtoBDetil.addColumn("KWHLWBP", 70);
        gridPelangganBtoBDetil.addColumn("KWHWBP", 70);
        gridPelangganBtoBDetil.addColumn("NOMORBA", 70);
        gridPelangganBtoBDetil.addColumn("PTGENTRI", 70);
        gridPelangganBtoBDetil.addColumn("TGLENTRI", 70);

        vlMain.add(gridPelangganBtoBDetil);

        gridPelangganBtoBDetil.getView().setStripeRows(true);
        gridPelangganBtoBDetil.getView().setColumnLines(true);

        return panel;
    }

    private FormPanel panelFilter(){
        FormPanel panel = new FormPanel();

        VerticalLayoutContainer vlFilter = new VerticalLayoutContainer();
        panel.setWidget(vlFilter);

        FramedPanel frameReferensi = new FramedPanel();
        frameReferensi.setHeadingText("Pilih Referensi");
        frameReferensi.setHeaderVisible(true);
        frameReferensi.setBodyStyle("background: none; padding: 5px");

        ComboUnits cbUnits = new ComboUnits();
        frameReferensi.add(cbUnits);

        vlFilter.add(frameReferensi);

        /* -----  BLTH ----- */
        FramedPanel frameBlth = new FramedPanel();
        frameBlth.setHeadingText("Pilih Parameter");
        frameBlth.setHeaderVisible(true);
        frameBlth.setBodyStyle("background: none; padding: 5px");

        ComboTahunBulan cbTahunBulan = new ComboTahunBulan();
        frameBlth.add(cbTahunBulan);

        vlFilter.add(frameBlth);
        /* -----  BLTH ----- */

        FramedPanel frameButton = new FramedPanel();
        frameButton.setHeadingText("List Button");
        frameButton.setHeaderVisible(false);
        frameButton.setBodyStyle("background: none; padding: 0px");

        TextButton bFilter = new TextButton("Filter");
//        bFilter.setIcon(ImagesCollection.INSTANCE.print());
        bFilter.setIconAlign(ButtonCell.IconAlign.LEFT);
        frameButton.add(bFilter);

        vlFilter.add(frameButton);

//        FramedPanel frameGrid = new FramedPanel();
//        frameGrid.setHeadingText("List Pelanggan");
//        frameGrid.setHeaderVisible(true);
//        frameGrid.setHeight(310);
//        frameGrid.setBodyStyle("background: none; padding: 0px");
//        vlFilter.add(frameGrid);


        IconDynamicGrid gridMon = new IconDynamicGrid();
        gridMon.setGridHeader("Detil Pelanggan");
        gridMon.setGridHeight(150);
        gridMon.setGridWidth(500);
        gridMon.setStoreUrl("BasicProject/thuGetString.json?name=store1");

        gridMon.addColumn("IDPEL", 100);
        gridMon.addColumn("NAMA", 150);
        gridMon.addColumn("DAYABTOB", 90);
        gridMon.addColumn("THBLREK", 70);
        gridMon.addColumn("KWHLWBP", 70);
        gridMon.addColumn("KWHWBP", 70);
        gridMon.addColumn("NOMORBA", 70);
        gridMon.addColumn("PTGENTRI", 70);
        gridMon.addColumn("TGLENTRI", 70);

//        frameGrid.add(gridMon);
        vlFilter.add(gridMon);

        gridMon.getView().setStripeRows(true);
        gridMon.getView().setColumnLines(true);


        return panel;
    }

    private void windowDetil() {
        Window windowDetil = new Window();
        windowDetil.setWidth(500);
        windowDetil.setMaximizable(false);
        windowDetil.setClosable(true);
        windowDetil.setModal(true);
        windowDetil.setBodyStyle("background: none; padding: 5px");
        windowDetil.setBlinkModal(true);
        windowDetil.setHeadingText("Detil Rekening");



        VerticalLayoutContainer vlmaindetil = new VerticalLayoutContainer();
        windowDetil.add(vlmaindetil);



        FieldSet fsInfo = new FieldSet();
        fsInfo.setCollapsible(true);
        fsInfo.setHeadingText("Info Pelanggan");

        vlmaindetil.add(fsInfo, new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextFieldsInfoPelanggan tfInfoPelanggan = new TextFieldsInfoPelanggan();
        fsInfo.add(tfInfoPelanggan);



        FieldSet fsInputDetil = new FieldSet();
        fsInputDetil.setCollapsible(false);
        fsInputDetil.setHeadingText("");

        vlmaindetil.add(fsInputDetil, new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        VerticalLayoutContainer vlinputDetil = new VerticalLayoutContainer();
        fsInputDetil.add(vlinputDetil);

        HorizontalPanel hpthbl = new HorizontalPanel();
        hpthbl.setSpacing(5);

//        FramedPanel frameBlth = new FramedPanel();
//        frameBlth.setHeadingText("Pilih Parameter");
//        frameBlth.setHeaderVisible(true);
//        frameBlth.setBodyStyle("background: none; padding: 5px");

        ComboTahunBulan cbTahunBulan = new ComboTahunBulan();
        //frameBlth.add(cbTahunBulan);

        vlinputDetil.add(cbTahunBulan);



        NumberField txtKwhLwbpBtoB = new NumberField(new NumberPropertyEditor.BigDecimalPropertyEditor());
        txtKwhLwbpBtoB.setAllowBlank(false);
        vlinputDetil.add(new FieldLabel( txtKwhLwbpBtoB, "LWBP BToB"));

        NumberField txtKwhWbpBtoB = new NumberField(new NumberPropertyEditor.BigDecimalPropertyEditor());
        txtKwhWbpBtoB.setAllowBlank(false);
        vlinputDetil.add(new FieldLabel( txtKwhWbpBtoB, "WBP BToB"));

        TextField txtNomorBaWindowDetil = new TextField();
        txtNomorBaWindowDetil.setWidth(250);
        txtNomorBaWindowDetil.setAllowBlank(false);
        txtNomorBaWindowDetil.addValidator(new MaxLengthValidator(100));

        vlinputDetil.add(new FieldLabel(txtNomorBaWindowDetil,"Nomor BA"));

        TextButton btnBatalDetil = new TextButton("Tutup");
//        btnBatalDetil.setIcon(ImagesCollection.INSTANCE.back());
        btnBatalDetil.setIconAlign(ButtonCell.IconAlign.LEFT);

        windowDetil.addButton(btnBatalDetil);

        TextButton btnSimpanDetil = new TextButton("Simpan");
//        btnSimpanDetil.setIcon(ImagesCollection.INSTANCE.save());
        btnSimpanDetil.setIconAlign(ButtonCell.IconAlign.LEFT);

        windowDetil.addButton(btnSimpanDetil);

//        vp.add(windowDetil);
    }

}
