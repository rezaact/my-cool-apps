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
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.*;

public class Form_21Entri {
    private VerticalPanel vp;
    ComboKodePP cbKdPP;

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
        panel.setHeadingText("Entri Pelunasan Konvensional Piutang Rekening");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(1024);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        FieldSet fieldSet = new FieldSet();
        fieldSet.setHeadingText("");

        VerticalLayoutContainer FieldAtas = new VerticalLayoutContainer();
        fieldSet.add(FieldAtas);
        cbKdPP = new ComboKodePP();
        DateField dTglLunas = new DateField();
        dTglLunas.setWidth(100);
        TextField IDPel = new TextField();
        IDPel.setWidth(80);

        HBoxLayoutContainer hpT = new HBoxLayoutContainer();
        hpT.add(cbKdPP, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hpT.add(new FieldLabel(dTglLunas, "Tanggal Lunas"), new BoxLayoutData(new Margins(0, 5, 0, 10)));
        hpT.add(new FieldLabel(IDPel, "ID Pelanggan"), new BoxLayoutData(new Margins(0, 5, 0, 10)));
        FieldAtas.add(hpT);

        hpT = new HBoxLayoutContainer();
        TextField tKodePP = new TextField();
        tKodePP.setEmptyText("Kode Belum Dipilih.");
        tKodePP.setWidth(645);
        hpT.add(tKodePP, new BoxLayoutData(new Margins(0, 5, 0, 105)));
        FieldAtas.add(hpT);

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
        TextField tTKBK1 = new TextField();
        tTKBK1.setWidth(80);
        CheckBox check1 = new CheckBox();
        check1.setBoxLabel("Hapus BK1");

        //Tab 1

        HBoxLayoutContainer hp1 = new HBoxLayoutContainer();
        hp1.add(new FieldLabel(tTIDPEL, "IDPEL"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTRekBul, "REK Bulan"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTTDaya, "Tarif/Daya"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKBK1, "Rp BK1"), new BoxLayoutData(new Margins(0, 5, 0, 50)));
        hp1.add(check1, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        TextField tTNoPEL = new TextField();
        tTNoPEL.setWidth(80);
        TextField tTKel = new TextField();
        tTKel.setWidth(80);
        TextField tTKog = new TextField();
        tTKog.setWidth(80);
        TextField tTKBK2 = new TextField();
        tTKBK2.setWidth(80);
        CheckBox check2 = new CheckBox();
        check2.setBoxLabel("Hapus BK2");

        hp1.add(new FieldLabel(tTNoPEL, "NOPEL"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKel, "Kelompok"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKog, "Kogol"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKBK2, "Rp BK2"), new BoxLayoutData(new Margins(0, 5, 0, 50)));
        hp1.add(check2, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        TextField tTNama = new TextField();
        tTNama.setWidth(80);
        TextField tTTJatuhTempo = new TextField();
        tTTJatuhTempo.setWidth(80);
        TextField tTInkaso = new TextField();
        tTInkaso.setWidth(80);
        TextField tTKBK3 = new TextField();
        tTKBK3.setWidth(80);
        TextField tTKdppj = new TextField();
        tTKdppj.setWidth(80);
        CheckBox check3 = new CheckBox();
        check3.setBoxLabel("Hapus BK3");
        hp1.add(new FieldLabel(tTNama, "Nama"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTTJatuhTempo, "Tgl Jatuh Tempo"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKdppj, "KDPPJ"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKBK3, "Rp BK3"), new BoxLayoutData(new Margins(0, 5, 0, 50)));
        hp1.add(check3, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        TextField tTAlamat = new TextField();
        tTAlamat.setWidth(80);
        TextField tTFrt = new TextField();
        tTFrt.setWidth(80);
        TextField tTKedudukan = new TextField();
        tTKedudukan.setWidth(80);
        TextField tTPemda = new TextField();
        tTPemda.setWidth(80);
        hp1.add(new FieldLabel(tTAlamat, "Alamat"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKedudukan, "Kendudukan"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTPemda, "Pemda"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        TextField tTUUP = new TextField();
        tTUUP.setWidth(80);
        hp1.add(new FieldLabel(tTUUP, "Unit UP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTInkaso, "Inkaso"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        TextField tTU = new TextField();
        tTU.setWidth(80);
        hp1.add(new FieldLabel(tTU, "Unit"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        VTab = new VerticalLayoutContainer();
        VTab.setLayoutData(new MarginData(8));

        tabs.add(VTab, "Detail Rupiah");

        TextField tTRpPTL = new TextField();
        tTRpPTL.setWidth(70);
        TextField tTRpBeban0 = new TextField();
        tTRpBeban0.setWidth(70);
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
        TextField tTRpMat = new TextField();
        tTRpMat.setWidth(70);
        TextField tTKdAngC = new TextField();
        tTKdAngC.setWidth(45);
        TextField tTKdAngC0 = new TextField();
        tTKdAngC0.setWidth(20);
        TextField tTProduksi = new TextField();
        tTProduksi.setWidth(70);
        TextField tTRpTrafo = new TextField();
        tTRpTrafo.setWidth(70);
        TextField tTRpPLN = new TextField();
        tTRpPLN.setWidth(70);
        TextField tTRpSubsidi = new TextField();
        tTRpSubsidi.setWidth(70);

        //Tab 2
        HBoxLayoutContainer hp2 = new HBoxLayoutContainer();
        hp2.add(new FieldLabel(tTRpBeban0, "Rp Beban"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTRpMat, "Rp Mat"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTStrafo, "Rp Sewa Trafo"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTReduksi, "Rp Reduksi"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTProduksi, "Rp Produksi"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        hp2 = new HBoxLayoutContainer();
        hp2.add(new FieldLabel(tTRpPTL, "Rp PTL"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTRpTrafo, "Rp Trafo"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTSKap, "Rp Sewa Kap"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTSelisih, "Rp Selisih"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTRpPLN, "Rp PLN"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        hp2 = new HBoxLayoutContainer();
        hp2.add(new FieldLabel(tTRpTb, "Rp TB"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTKdAngA, "Rp/Kd Angs A"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(tTKdAngA0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTInsentif, "Rp Insentif"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTTdlLama, "Rp TDL Lama"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        hp2 = new HBoxLayoutContainer();
        hp2.add(new FieldLabel(tTRpPPN, "Rp PPN"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTKdAngB, "Rp/Kd Angs B"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(tTKdAngB0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTDisInsentif, "Rp DisInsentif"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTTdlbaru, "Rp TDL Baru"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        hp2 = new HBoxLayoutContainer();
        hp2.add(new FieldLabel(tTRpBPJU, "Rp BPJU"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTKdAngC, "Rp/Kd Angs C"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(tTKdAngC0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTRpTAG, "Rp TAG"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTRpSubsidi, "Rp Subsidi"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        VTab = new VerticalLayoutContainer();
        VTab.setLayoutData(new MarginData(8));

        tabs.add(VTab, "Detail Kwh");

        Label Awal = new Label("St. Awal");
        Label Awal1 = new Label("St. Akhir");
        Label Awal2 = new Label("Pemakaian");
        TextField tTRpWBP = new TextField();
        tTRpWBP.setWidth(70);

        //Tab 3
        HBoxLayoutContainer hp3 = new HBoxLayoutContainer();
        hp3.add(Awal, new BoxLayoutData(new Margins(0, 5, 0, 110)));
        hp3.add(Awal1, new BoxLayoutData(new Margins(0, 5, 0, 18)));
        hp3.add(Awal2, new BoxLayoutData(new Margins(0, 5, 0, 120)));
        hp3.add(new FieldLabel(tTRpWBP, "Rp WBP"), new BoxLayoutData(new Margins(0, 5, 0, 7)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        TextField tTLWBP = new TextField();
        tTLWBP.setWidth(70);
        TextField tTLWBP0 = new TextField();
        tTLWBP0.setWidth(70);
        TextField tTLWBP1 = new TextField();
        tTLWBP1.setWidth(70);
        TextField tTRpLWBP = new TextField();
        tTRpLWBP.setWidth(70);
        hp3.add(new FieldLabel(tTLWBP, "LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(tTLWBP0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTLWBP1, "LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTRpLWBP, "Rp LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        TextField tTWBP = new TextField();
        tTWBP.setWidth(70);
        TextField tTWBP0 = new TextField();
        tTWBP0.setWidth(70);
        TextField tTWBP1 = new TextField();
        tTWBP1.setWidth(70);
        TextField tTRpWBP2 = new TextField();
        tTRpWBP2.setWidth(70);
        hp3.add(new FieldLabel(tTWBP, "WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(tTWBP0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTWBP1, "WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTRpWBP2, "Rp WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        TextField tTKvArh = new TextField();
        tTKvArh.setWidth(70);
        TextField tTKvArh1 = new TextField();
        tTKvArh1.setWidth(70);
        TextField tTBlok3 = new TextField();
        tTBlok3.setWidth(70);
        TextField tTRpKvArh = new TextField();
        tTRpKvArh.setWidth(70);
        hp3.add(new FieldLabel(tTKvArh, "KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(tTKvArh1, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTBlok3, "Blok 3"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTRpKvArh, "Rp KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        TextField tTFKKwh = new TextField();
        tTFKKwh.setWidth(70);
        TextField tTTotal = new TextField();
        tTTotal.setWidth(70);
        TextField tTTTLB = new TextField();
        tTTTLB.setWidth(70);
        hp3.add(new FieldLabel(tTFKKwh, "FK Kwh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTTotal, "Total"), new BoxLayoutData(new Margins(0, 5, 0, 75)));
        hp3.add(new FieldLabel(tTTTLB, "TTLB"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        TextField tTFKKvArh = new TextField();
        tTFKKvArh.setWidth(70);
        TextField tTKebKvArh = new TextField();
        tTKebKvArh.setWidth(70);
        TextField tTRpBeban = new TextField();
        tTRpBeban.setWidth(70);
        hp3.add(new FieldLabel(tTFKKvArh, "FK KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTKebKvArh, "Keb KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 75)));
        hp3.add(new FieldLabel(tTRpBeban, "Rp Beban"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        p.add(tabs);

        //Grid
        IconDynamicGrid gpDataCN = new IconDynamicGrid();
        gpDataCN.setGridHeader("Data Tagihan");
        gpDataCN.setGridDimension(990, 200);
        gpDataCN.setStoreUrl("BasicProject/thuGetString.json?name=store1");

        p.add(gpDataCN);

        //FieldBawah
        FieldSet fieldSet1 = new FieldSet();
        fieldSet1.setHeadingText("");

        VerticalLayoutContainer FieldBawah = new VerticalLayoutContainer();
        fieldSet1.add(FieldBawah);

        TextButton bBottomReset = new TextButton("Reset");
        bBottomReset.setWidth(100);
        TextButton bBottomSimpan = new TextButton("Simpan");
        bBottomSimpan.setWidth(100);
        bBottomSimpan.setEnabled(false);
        TextButton bBottomCetak = new TextButton("Cetak Rekg");
        bBottomCetak.setWidth(100);
        TextButton bBottomCetakBA = new TextButton("Cetak Rekg");
        bBottomCetakBA.setWidth(100);

        TextField tRpTag = new TextField();
        TextField tRpBK = new TextField();

        HBoxLayoutContainer hp0 = new HBoxLayoutContainer();
        hp0.add(new FieldLabel(tRpTag, "RP Tagihan"));
        hp0.add(bBottomReset, new BoxLayoutData(new Margins(0, 5, 0, 20)));
        hp0.add(bBottomSimpan, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldBawah.add(hp0);

        hp0 = new HBoxLayoutContainer();
        hp0.add(new FieldLabel(tRpBK, "RP BK"));
        hp0.add(bBottomCetak, new BoxLayoutData(new Margins(0, 5, 0, 20)));
        hp0.add(bBottomCetakBA, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldBawah.add(hp0);
        p.add(fieldSet1);

        return panel;
    }
}
