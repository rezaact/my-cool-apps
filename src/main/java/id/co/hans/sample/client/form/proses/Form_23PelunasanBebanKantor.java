package id.co.hans.sample.client.form.proses;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.Padding;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer.HBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer.VBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.toolbar.FillToolItem;
import com.sencha.gxt.widget.core.client.toolbar.SeparatorToolItem;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.*;

public class Form_23PelunasanBebanKantor {


    private VerticalPanel vp;
    ComboKodeKolektif cbKdKlf;

    private String idUser, levelUser, unitUser;

    public Widget asWidget(String idUser, String unitupUser, String levelUser) {
        this.idUser=idUser;
        this.unitUser=unitupUser;
        this.levelUser=levelUser;

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
        panel.setHeadingText("Pelunasan Beban Kantor");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(850);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);
        FieldSet fieldSet = new FieldSet();

        VerticalLayoutContainer FieldAtas = new VerticalLayoutContainer();
        fieldSet.add(FieldAtas);
        cbKdKlf = new ComboKodeKolektif();

        HBoxLayoutContainer hp4 = new HBoxLayoutContainer();
        hp4.add(cbKdKlf);
        hp4.add(new TextButton("Ambil Data"));
        FieldAtas.add(hp4);
        FieldAtas.add(new FieldLabel(new DateField(), "Pilih Tanggal Lunas"));
        p.add(fieldSet);


        //TabPanel
        TabPanel tabs = new TabPanel();
        VerticalLayoutContainer VTab = new VerticalLayoutContainer();
        VTab.setLayoutData(new MarginData(8));

        tabs.add(VTab, "Detail Pelanggan");

        TextField tTIDPEL = new TextField();
        tTIDPEL.setWidth(80);
        TextField tTRekBul = new TextField();
        tTRekBul.setWidth(80);
        TextField tTTDaya = new TextField();
        tTTDaya.setWidth(80);
        TextField tTNoPEL = new TextField();
        tTNoPEL.setWidth(80);
        TextField tTKel = new TextField();
        tTKel.setWidth(80);
        TextField tTKog = new TextField();
        tTKog.setWidth(80);
        TextField tTNama = new TextField();
        tTNama.setWidth(80);
        TextField tTTJatuhTempo = new TextField();
        tTTJatuhTempo.setWidth(80);
        TextField tTInkaso = new TextField();
        tTInkaso.setWidth(80);
        TextField tTAlamat = new TextField();
        tTAlamat.setWidth(80);
        TextField tTFrt = new TextField();
        tTFrt.setWidth(80);
        TextField tTKedudukan = new TextField();
        tTKedudukan.setWidth(80);
        TextField tTUUP = new TextField();
        tTUUP.setWidth(80);
        TextField tTFjn = new TextField();
        tTFjn.setWidth(80);
        TextField tTKdppj = new TextField();
        tTKdppj.setWidth(80);
        TextField tTU = new TextField();
        tTU.setWidth(80);
        TextField tTAbonM = new TextField();
        tTAbonM.setWidth(80);
        TextField tTPemda = new TextField();
        tTPemda.setWidth(80);

        FieldSet fieldSTengahKiri0 = new FieldSet();
        VerticalLayoutContainer vTengahKiri0 = new VerticalLayoutContainer();
        fieldSTengahKiri0.add(vTengahKiri0);
        FieldSet fieldSTengahTengah0 = new FieldSet();
        VerticalLayoutContainer vTengahTengah0 = new VerticalLayoutContainer();
        fieldSTengahTengah0.add(vTengahTengah0);
        FieldSet fieldSTengahKanan0= new FieldSet();
        VerticalLayoutContainer vTengahKanan0 = new VerticalLayoutContainer();
        fieldSTengahKanan0.add(vTengahKanan0);

        vTengahKiri0.add(new FieldLabel(tTIDPEL, "ID Pelanggan"));
        vTengahKiri0.add(new FieldLabel(tTNoPEL, "No Pelanggan"));
        vTengahKiri0.add(new FieldLabel(tTNama, "Nama"));
        vTengahKiri0.add(new FieldLabel(tTAlamat, "Alamat"));
        vTengahKiri0.add(new FieldLabel(tTUUP, "Unit UP"));
        vTengahKiri0.add(new FieldLabel(tTU, "Unit"));

        vTengahTengah0.add(new FieldLabel(tTRekBul, "Rekening Bulan"));
        vTengahTengah0.add(new FieldLabel(tTKel, "Kelompok"));
        vTengahTengah0.add(new FieldLabel(tTTJatuhTempo, "Tgl Jatuh Tempo"));
        vTengahTengah0.add(new FieldLabel(tTFrt, "FRT"));
        vTengahTengah0.add(new FieldLabel(tTFjn, "FJN"));
        vTengahTengah0.add(new FieldLabel(tTAbonM, "Abonemen"));

        vTengahKanan0.add(new FieldLabel(tTTDaya, "Tarif/Daya"));
        vTengahKanan0.add(new FieldLabel(tTKog, "Kogol"));
        vTengahKanan0.add(new FieldLabel(tTInkaso, "Inkaso"));
        vTengahKanan0.add(new FieldLabel(tTKedudukan, "Kendudukan"));
        vTengahKanan0.add(new FieldLabel(tTKdppj, "KDPPJ"));
        vTengahKanan0.add(new FieldLabel(tTPemda, "Pemda"));

        HBoxLayoutContainer hp1 = new HBoxLayoutContainer();
        hp1.add(fieldSTengahKiri0);
        hp1.add(fieldSTengahTengah0);
        hp1.add(fieldSTengahKanan0);
        VTab.add(hp1);

        VTab = new VerticalLayoutContainer();
        VTab.setLayoutData(new MarginData(8));

        tabs.add(VTab, "Detail Rupiah");

        TextField tTRpPTL = new TextField();
        tTRpPTL.setWidth(70);
        TextField tTStrafo = new TextField();
        tTStrafo.setWidth(70);
        TextField tTReduksi = new TextField();
        tTReduksi.setWidth(70);
        TextField tTSelisih = new TextField();
        tTSelisih.setWidth(70);
        TextField tTRpTb = new TextField();
        tTRpTb.setWidth(70);
        TextField tTSKap = new TextField();
        tTSKap.setWidth(70);
        TextField tTInsentif = new TextField();
        tTInsentif.setWidth(70);
        TextField tTTdlLama = new TextField();
        tTTdlLama.setWidth(70);
        TextField tTRpPPN = new TextField();
        tTRpPPN.setWidth(70);
        TextField tTKdAngA = new TextField();
        tTKdAngA.setWidth(45);
        TextField tTKdAngA0 = new TextField();
        tTKdAngA0.setWidth(20);
        TextField tTDisInsentif = new TextField();
        tTDisInsentif.setWidth(70);
        TextField tTTdlbaru = new TextField();
        tTTdlbaru.setWidth(70);
        TextField tTRpBPJU = new TextField();
        tTRpBPJU.setWidth(70);
        TextField tTKdAngB = new TextField();
        tTKdAngB.setWidth(45);
        TextField tTKdAngB0 = new TextField();
        tTKdAngB0.setWidth(20);
        TextField tTRpTAG = new TextField();
        tTRpTAG.setWidth(70);
        TextField tTRpBK1 = new TextField();
        tTRpBK1.setWidth(70);
        TextField tTRpMat = new TextField();
        tTRpMat.setWidth(70);
        TextField tTKdAngC = new TextField();
        tTKdAngC.setWidth(45);
        TextField tTKdAngC0 = new TextField();
        tTKdAngC0.setWidth(20);
        TextField tTProduksi = new TextField();
        tTProduksi.setWidth(70);
        TextField tTRpBK2 = new TextField();
        tTRpBK2.setWidth(70);
        TextField tTRpTrafo = new TextField();
        tTRpTrafo.setWidth(70);
        TextField tTRpPLN = new TextField();
        tTRpPLN.setWidth(70);
        TextField tTRpSubsidi = new TextField();
        tTRpSubsidi.setWidth(70);
        TextField tTRpBK3 = new TextField();
        tTRpBK3.setWidth(70);

        FieldSet fieldSTengahKiri1 = new FieldSet();
        VerticalLayoutContainer vTengahKiri1 = new VerticalLayoutContainer();
        fieldSTengahKiri1.add(vTengahKiri1);
        FieldSet fieldSTengahTengah1 = new FieldSet();
        VerticalLayoutContainer vTengahTengah1 = new VerticalLayoutContainer();
        fieldSTengahTengah1.add(vTengahTengah1);
        FieldSet fieldSTengahKanan1= new FieldSet();
        VerticalLayoutContainer vTengahKanan1 = new VerticalLayoutContainer();
        fieldSTengahKanan1.add(vTengahKanan1);
        FieldSet fieldSTengahKanann1= new FieldSet();
        VerticalLayoutContainer vTengahKanann1 = new VerticalLayoutContainer();
        fieldSTengahKanann1.add(vTengahKanann1);

        vTengahKiri1.add(new FieldLabel(tTRpPTL, "Rp PTL"));
        vTengahKiri1.add(new FieldLabel(tTRpTb, "Rp TB"));
        vTengahKiri1.add(new FieldLabel(tTRpPPN, "Rp PPN"));
        vTengahKiri1.add(new FieldLabel(tTRpBPJU, "Rp BPJU"));
        vTengahKiri1.add(new FieldLabel(tTRpMat, "Rp Mat"));
        vTengahKiri1.add(new FieldLabel(tTRpTrafo, "Rp Trafo"));


        vTengahTengah1.add(new FieldLabel(tTStrafo, "Rp Sewa Trafo"));
        vTengahTengah1.add(new FieldLabel(tTSKap, "Rp Sewa Kap"));
        vTengahTengah1.add(new FieldLabel(tTKdAngA, "Rp/Kd Angs A"));
        vTengahTengah1.add(new FieldLabel(tTKdAngB, "Rp/Kd Angs B"));
        vTengahTengah1.add(new FieldLabel(tTKdAngC, "Rp/Kd Angs C"));
        /*vTengahTengah1.add(tTKdAngA0);
          vTengahTengah1.add(tTKdAngB0);
          vTengahTengah1.add(tTKdAngC0);*/
        vTengahTengah1.add(new FieldLabel(tTRpTAG, "Rp TAG"));

        vTengahKanan1.add(new FieldLabel(tTRpPLN, "Rp PLN"));
        vTengahKanan1.add(new FieldLabel(tTReduksi, "Rp Reduksi"));
        vTengahKanan1.add(new FieldLabel(tTInsentif, "Rp Insentif"));
        vTengahKanan1.add(new FieldLabel(tTDisInsentif, "Rp DisInsentif"));
        vTengahKanan1.add(new FieldLabel(tTProduksi, "Rp Produksi"));
        vTengahKanan1.add(new FieldLabel(tTRpSubsidi, "Rp Subsidi"));

        vTengahKanann1.add(new FieldLabel(tTSelisih, "Rp Selisih"));
        vTengahKanann1.add(new FieldLabel(tTTdlLama, "Rp TDL Lama"));
        vTengahKanann1.add(new FieldLabel(tTTdlbaru, "Rp TDL Baru"));
        vTengahKanann1.add(new FieldLabel(tTRpBK1, "Rp BK 1"));
        vTengahKanann1.add(new FieldLabel(tTRpBK2, "Rp BK 2"));
        vTengahKanann1.add(new FieldLabel(tTRpBK3, "Rp BK 3"));

        //Tab 2
        HBoxLayoutContainer hp2 = new HBoxLayoutContainer();
        hp2.add(fieldSTengahKiri1);
        hp2.add(fieldSTengahTengah1);
        hp2.add(fieldSTengahKanan1);
        hp2.add(fieldSTengahKanann1);
        VTab.add(hp2);

        VTab = new VerticalLayoutContainer();
        VTab.setLayoutData(new MarginData(8));

        tabs.add(VTab, "Detail Kwh");

        Label Awal = new Label("St. Awal");
        Label Awal1 = new Label("St. Akhir");
        Label Awal2 = new Label("Pemakaian");
        TextField tTRpWBP = new TextField();
        tTRpWBP.setWidth(70);
        TextField tTLWBP = new TextField();
        tTLWBP.setWidth(70);
        TextField tTLWBP0 = new TextField();
        tTLWBP0.setWidth(70);
        TextField tTLWBP1 = new TextField();
        tTLWBP1.setWidth(70);
        TextField tTRpLWBP = new TextField();
        tTRpLWBP.setWidth(70);
        TextField tTWBP = new TextField();
        tTWBP.setWidth(70);
        TextField tTWBP0 = new TextField();
        tTWBP0.setWidth(70);
        TextField tTWBP1 = new TextField();
        tTWBP1.setWidth(70);
        TextField tTRpWBP2 = new TextField();
        tTRpWBP2.setWidth(70);
        TextField tTKvArh = new TextField();
        tTKvArh.setWidth(70);
        TextField tTKvArh1 = new TextField();
        tTKvArh1.setWidth(70);
        TextField tTBlok3 = new TextField();
        tTBlok3.setWidth(70);
        TextField tTRpKvArh = new TextField();
        tTRpKvArh.setWidth(70);
        TextField tTFKKwh = new TextField();
        tTFKKwh.setWidth(70);
        TextField tTTotal = new TextField();
        tTTotal.setWidth(70);
        TextField tTTTLB = new TextField();
        tTTTLB.setWidth(70);
        TextField tTFKKvArh = new TextField();
        tTFKKvArh.setWidth(70);
        TextField tTKebKvArh = new TextField();
        tTKebKvArh.setWidth(70);
        TextField tTRpBeban = new TextField();
        tTRpBeban.setWidth(70);

        //Tab 3
        HBoxLayoutContainer hp3 = new HBoxLayoutContainer();
        hp3.add(Awal, new BoxLayoutData(new Margins(0, 5, 0, 110)));
        hp3.add(Awal1, new BoxLayoutData(new Margins(0, 5, 0, 18)));
        hp3.add(Awal2, new BoxLayoutData(new Margins(0, 5, 0, 120)));
        hp3.add(new FieldLabel(tTRpWBP, "Rp WBP"), new BoxLayoutData(new Margins(0, 5, 0, 7)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        hp3.add(new FieldLabel(tTLWBP, "LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(tTLWBP0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTLWBP1, "LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTRpLWBP, "Rp LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        hp3.add(new FieldLabel(tTWBP, "WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(tTWBP0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTWBP1, "WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTRpWBP2, "Rp WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        hp3.add(new FieldLabel(tTKvArh, "KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(tTKvArh1, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTBlok3, "Blok 3"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTRpKvArh, "Rp KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        hp3.add(new FieldLabel(tTFKKwh, "FK Kwh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTTotal, "Total"), new BoxLayoutData(new Margins(0, 5, 0, 75)));
        hp3.add(new FieldLabel(tTTTLB, "TTLB"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        hp3.add(new FieldLabel(tTFKKvArh, "FK KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTKebKvArh, "Keb KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 75)));
        hp3.add(new FieldLabel(tTRpBeban, "Rp Beban"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        p.add(tabs);

        //Grid
        IconDynamicGrid gpDataCN = new IconDynamicGrid();
        gpDataCN.setGridHeader("Array Grid");
        gpDataCN.setGridDimension(990, 200);
        gpDataCN.setStoreUrl("BasicProject/thuGetString.json?name=store1");

        p.add(gpDataCN);

        return panel;
    }
}
