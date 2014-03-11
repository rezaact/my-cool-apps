package id.co.hans.sample.client.form.cetakulang;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.*;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import id.co.hans.sample.client.components.ComboKodeKolektif;
import id.co.hans.sample.client.components.IconDynamicGrid;

public class Form_CetakUlangTerpusat {


    private VerticalPanel vp;

    public Widget asWidget() {
        if (vp == null) {
            vp = new VerticalPanel();
            vp.setSpacing(5);
            initKomponen();
        }
        return vp;
    }

    private void initKomponen() {
//        AutoProgressMessageBox progressBox = new AutoProgressMessageBox("Progress", "please wait");
//        progressBox.setProgressText("wait...");

        vp.add(panelMain());
    }

    private FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Cetak Ulang Beban Kantor");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);


        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        ComboKodeKolektif cb_Kolektif = new ComboKodeKolektif();
        p.add(cb_Kolektif);

        DateField duPelunasan = new DateField();
        p.add(new FieldLabel(duPelunasan, "Pilih Tanggal Lunas"));

        TextField txtalasan = new TextField();
        p.add(new FieldLabel(txtalasan, "Alasan"));

        TextButton bAmbilData = new TextButton("Ambil Data");
        TextButton bCetak303 = new TextButton("Cetak III-03");

        panel.addButton(bAmbilData);
        panel.addButton(bCetak303);


        IconDynamicGrid GdCetakUlang = new IconDynamicGrid();
        GdCetakUlang.setGridHeader("Data pelanggan yang akan dicetak ulang");
        GdCetakUlang.setGridHeight(150);
        GdCetakUlang.setGridWidth(620);
        GdCetakUlang.setStoreUrl("BasicProject/thuGetString.json?name=store1");

        GdCetakUlang.addColumn("Simpan", 100);
        GdCetakUlang.addColumn("HASIL", 150);
        GdCetakUlang.addColumn("BLTHTAG", 90);
        GdCetakUlang.addColumn("NO_PELANGGAN", 70);
        GdCetakUlang.addColumn("NAMA_PELANGGAN", 70);
        GdCetakUlang.addColumn("NAMA_JALAN", 70);
        GdCetakUlang.addColumn("STATUS", 70);
        GdCetakUlang.addColumn("RPTAG", 70);
        GdCetakUlang.addColumn("RPBK", 70);
        GdCetakUlang.addColumn("KODEPP", 70);
        GdCetakUlang.addColumn("TGLLUNAS", 70);
        GdCetakUlang.addColumn("TARIP", 70);
        GdCetakUlang.addColumn("DAYA", 70);
        GdCetakUlang.addColumn("TOTALKWH", 70);
        GdCetakUlang.addColumn("STANDAKHIRLWBPKWH", 70);
        GdCetakUlang.addColumn("STANDAKHIRWBP", 70);
        GdCetakUlang.addColumn("STANDAKHIRKVARH", 70);
        GdCetakUlang.addColumn("TOTAL", 70);
        GdCetakUlang.addColumn("PPJU", 70);
        GdCetakUlang.addColumn("RPPPN", 70);
        GdCetakUlang.addColumn("RPMATERAIREK", 70);
        GdCetakUlang.addColumn("STANDAWALLWBPKWH", 70);
        GdCetakUlang.addColumn("STANDAWALWBP", 70);
        GdCetakUlang.addColumn("STANDAWALKVARH", 70);
        GdCetakUlang.addColumn("REF", 70);
        GdCetakUlang.addColumn("ANGSURAN", 70);
        GdCetakUlang.addColumn("RPBIAYABEBAN", 70);
        GdCetakUlang.addColumn("RPPTL", 70);
        GdCetakUlang.addColumn("FAKTOR_KALI_METER", 70);
        GdCetakUlang.addColumn("PERIODEBAYAR", 70);
        GdCetakUlang.addColumn("JENIS", 70);
        GdCetakUlang.addColumn("UNITUP", 70);
        GdCetakUlang.addColumn("NOMOR", 70);

        p.add(GdCetakUlang);

        GdCetakUlang.getView().setStripeRows(true);
        GdCetakUlang.getView().setColumnLines(true);

        return panel;
    }
}
