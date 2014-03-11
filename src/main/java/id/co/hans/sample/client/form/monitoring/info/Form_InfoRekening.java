package id.co.hans.sample.client.form.monitoring.info;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.IconComboBox;
import id.co.hans.sample.client.components.IconDynamicGrid;

public class Form_InfoRekening {


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
        panel.setHeadingText("Info Rekening");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        // panel "Berdasarkan Kode PP"


        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);


        TextField tfTopIdPelanggan = new TextField();
        tfTopIdPelanggan.setAllowBlank(true);
        p.add(new FieldLabel(tfTopIdPelanggan, "ID Pelanggan"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField tfTopNoPelanggan = new TextField();
        tfTopNoPelanggan.setAllowBlank(true);
        p.add(new FieldLabel(tfTopNoPelanggan, "NO Pelanggan"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField tfTopNamaPelanggan = new TextField();
        p.add(new FieldLabel(tfTopNamaPelanggan, "Nama Pelanggan"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        HorizontalPanel hp = new HorizontalPanel();

        Radio radioTopNamaDepan = new Radio();
        radioTopNamaDepan.setValue(true);
        radioTopNamaDepan.setBoxLabel("Nama Depan");

        Radio radioTopNamaLengkap = new Radio();
        radioTopNamaLengkap.setBoxLabel("Nama Lengkap");

        Radio radioTopMengandungKata = new Radio();
        radioTopMengandungKata.setBoxLabel("Mengandung Kata");

        hp.add(radioTopNamaDepan);
        hp.add(radioTopNamaLengkap);
        hp.add(radioTopMengandungKata);

        ToggleGroup toggle = new ToggleGroup();
        toggle.add(radioTopNamaDepan);
        toggle.add(radioTopNamaLengkap);
        toggle.add(radioTopMengandungKata);

        p.add(hp, new VerticalLayoutContainer.VerticalLayoutData(1,-1, new Margins(0,0,5,100)));


        TextField tfTopAlamat = new TextField();
        p.add(new FieldLabel(tfTopAlamat, "Alamat"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        // panel "Data CN"

        IconDynamicGrid gpDataMaster = new IconDynamicGrid();
        gpDataMaster.setGridHeader("Data Master");
        gpDataMaster.setGridDimension(620, 200);
        gpDataMaster.setStoreUrl("BasicProject/thuGetString.json?name=store1");
        gpDataMaster.addColumn("STAT", 100);
        gpDataMaster.addColumn("BLTH", 100);
        gpDataMaster.addColumn("IDPEL", 100);
        gpDataMaster.addColumn("NOPEL", 100);
        gpDataMaster.addColumn("KDGERAKMASUK", 100);
        gpDataMaster.addColumn("KDGERAKKELUAR", 100);
        gpDataMaster.addColumn("WKTBAYAR", 100);
        gpDataMaster.addColumn("KDKOREKSI", 100);
        gpDataMaster.addColumn("TGKOREKSI", 100);
        gpDataMaster.addColumn("STATUS", 100);
        gpDataMaster.addColumn("KDPEMBPP", 100);
        gpDataMaster.addColumn("UNITUP", 100);
        gpDataMaster.addColumn("PEMDA", 100);
        gpDataMaster.addColumn("NAMA", 100);
        gpDataMaster.addColumn("NAMAPNJ", 100);
        gpDataMaster.addColumn("KETNODLMRT", 100);
        gpDataMaster.addColumn("IDTARIP", 100);
        gpDataMaster.addColumn("TARIP", 100);
        gpDataMaster.addColumn("KDPEMBTRF", 100);
        gpDataMaster.addColumn("ABONMETER", 100);
        gpDataMaster.addColumn("DAYA", 100);
        gpDataMaster.addColumn("KDAYA", 100);
        gpDataMaster.addColumn("KOGOL", 100);
        gpDataMaster.addColumn("SUBKOGOL", 100);
        gpDataMaster.addColumn("FRT", 100);
        gpDataMaster.addColumn("FJN", 100);
        gpDataMaster.addColumn("KDPPJ", 100);
        gpDataMaster.addColumn("UNITKJ", 100);
        gpDataMaster.addColumn("KDINKASO", 100);
        gpDataMaster.addColumn("KDKELOMPOK", 100);
        gpDataMaster.addColumn("TGLJTTEMPO", 100);
        gpDataMaster.addColumn("KDDK", 100);
        gpDataMaster.addColumn("TGLBACA", 100);
        gpDataMaster.addColumn("SLALWBP", 100);
        gpDataMaster.addColumn("SAHLWBP", 100);
        gpDataMaster.addColumn("SLAWBP", 100);
        gpDataMaster.addColumn("SAHWBP", 100);
        gpDataMaster.addColumn("SLAKVARH", 100);
        gpDataMaster.addColumn("SAHKVARH", 100);
        gpDataMaster.addColumn("SKVAMAX", 100);
        gpDataMaster.addColumn("FAKM", 100);
        gpDataMaster.addColumn("FAKMKVARH", 100);
        gpDataMaster.addColumn("FAKMKVAMAX", 100);
        gpDataMaster.addColumn("KWHLWBP", 100);
        gpDataMaster.addColumn("KWHWBP", 100);
        gpDataMaster.addColumn("BLOK3", 100);
        gpDataMaster.addColumn("PEMKWH", 100);
        gpDataMaster.addColumn("KWHKVARH", 100);
        gpDataMaster.addColumn("KELBKVARH", 100);
        gpDataMaster.addColumn("RPLWBP", 100);
        gpDataMaster.addColumn("RPWBP", 100);
        gpDataMaster.addColumn("RPBLOK3", 100);
        gpDataMaster.addColumn("RPKVARH", 100);
        gpDataMaster.addColumn("RPBEBAN", 100);
        gpDataMaster.addColumn("CTTLB", 100);
        gpDataMaster.addColumn("RPTTLB", 100);
        gpDataMaster.addColumn("RPPTL", 100);
        gpDataMaster.addColumn("RPTB", 100);
        gpDataMaster.addColumn("RPPPN", 100);
        gpDataMaster.addColumn("RPBPJU", 100);
        gpDataMaster.addColumn("RPTRAFO", 100);
        gpDataMaster.addColumn("RPSEWATRAFO", 100);
        gpDataMaster.addColumn("RPSEWAKAP", 100);
        gpDataMaster.addColumn("KDANGSA", 100);
        gpDataMaster.addColumn("RPANGSA", 100);
        gpDataMaster.addColumn("KDANGSB", 100);
        gpDataMaster.addColumn("RPANGSB", 100);
        gpDataMaster.addColumn("KDANGSC", 100);
        gpDataMaster.addColumn("RPANGSC", 100);
        gpDataMaster.addColumn("RPMAT", 100);
        gpDataMaster.addColumn("RPPLN", 100);
        gpDataMaster.addColumn("RPTAG", 100);
        gpDataMaster.addColumn("RPPRODUKSI", 100);
        gpDataMaster.addColumn("RPSUBSIDI", 100);
        gpDataMaster.addColumn("RPREDUKSI", 100);
        gpDataMaster.addColumn("RPINSENTIF", 100);
        gpDataMaster.addColumn("RPDISINSENTIF", 100);
        gpDataMaster.addColumn("RPBK1", 100);
        gpDataMaster.addColumn("RPBK2", 100);
        gpDataMaster.addColumn("RPBK3", 100);
        gpDataMaster.addColumn("RPTDLLAMA", 100);
        gpDataMaster.addColumn("RPTDLBARU", 100);
        gpDataMaster.addColumn("RPSELISIH", 100);
        gpDataMaster.addColumn("NOREK", 100);
        gpDataMaster.addColumn("NOAGENDA", 100);
        gpDataMaster.addColumn("FLAGSOPP", 100);
        gpDataMaster.addColumn("FLAGANJA", 100);
        gpDataMaster.addColumn("CETAK", 100);
        gpDataMaster.addColumn("TGLBAYAR", 100);
        gpDataMaster.addColumn("KDPP", 100);
        gpDataMaster.addColumn("KDPEMBAYAR", 100);
        gpDataMaster.addColumn("ANGSURAN", 100);
        gpDataMaster.addColumn("XXBK", 100);
        gpDataMaster.addColumn("RPBK", 100);
        gpDataMaster.addColumn("RPTOTAL", 100);

        p.add(gpDataMaster);

        return panel;
    }
}
