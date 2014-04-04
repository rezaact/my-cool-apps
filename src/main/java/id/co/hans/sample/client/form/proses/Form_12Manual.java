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
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.*;

public class Form_12Manual {

    private VerticalPanel vp;
    ComboKodeKolektif cbKdKlf;
    ComboTahunBulan cbthnbln;

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
        panel.setHeadingText("Pembatalan Piutang (31)");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(1024);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        FieldSet fieldSetMenu = new FieldSet();
        fieldSetMenu.setHeadingText("Pilih Data Baru :");
        VerticalLayoutContainer FieldAtas1 = new VerticalLayoutContainer();

        cbKdKlf = new ComboKodeKolektif();
        cbthnbln = new ComboTahunBulan();
        TextField IDPel = new TextField();

        HBoxLayoutContainer topAtas1 = new HBoxLayoutContainer();
        topAtas1.add(cbKdKlf, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldAtas1.add(topAtas1);

        topAtas1 = new HBoxLayoutContainer();
        topAtas1.add(cbthnbln, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        topAtas1.add(new FieldLabel(IDPel, "ID Pelanggan"), new BoxLayoutData(new Margins(0, 5, 0, 300)));
        FieldAtas1.add(topAtas1);

        topAtas1 = new HBoxLayoutContainer();
        topAtas1.add(new TextButton("Pending Request"), new BoxLayoutData(new Margins(0, 5, 0, 600)));
        topAtas1.add(new TextButton("unPending"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldAtas1.add(topAtas1);
        fieldSetMenu.add(FieldAtas1);
        p.add(fieldSetMenu);

        //TabPanel
        TabPanel tabs = new TabPanel();
        VerticalLayoutContainer VTab = new VerticalLayoutContainer();
        VTab.setLayoutData(new MarginData(8));

        tabs.add(VTab, "Detail Pelanggan");
        TextField tTpelKdKoreksi = new TextField();
        tTpelKdKoreksi.setWidth(80);
        TextField tTpelFKKwh = new TextField();
        tTpelFKKwh.setWidth(80);
        TextField tTpelFKKvARH = new TextField();
        tTpelFKKvARH.setWidth(80);
        TextField tTpelFKKvAMAX = new TextField();
        tTpelFKKvAMAX.setWidth(80);
        TextField tTIDPEL = new TextField();
        tTIDPEL.setWidth(80);
        TextField tTRekBul = new TextField();
        tTRekBul.setWidth(80);
        TextField tTTDaya = new TextField();
        tTTDaya.setWidth(40);
        TextField tTTDaya1 = new TextField();
        tTTDaya1.setWidth(20);
        TextField tTTDaya2 = new TextField();
        tTTDaya2.setWidth(50);
        TextField tTNoPEL = new TextField();
        tTNoPEL.setWidth(80);
        TextField tTKel = new TextField();
        tTKel.setWidth(120);
        TextField tTKog = new TextField();
        tTKog.setWidth(120);
        TextField tTNama = new TextField();
        tTNama.setWidth(80);
        TextField tTTJatuhTempo = new TextField();
        tTTJatuhTempo.setWidth(80);
        TextField tTInkaso = new TextField();
        tTInkaso.setWidth(120);
        TextField tTAlamat = new TextField();
        tTAlamat.setWidth(80);
        TextField tTFrt = new TextField();
        tTFrt.setWidth(80);
        TextField tTKedudukan = new TextField();
        tTKedudukan.setWidth(120);
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

        //Tab 1
        HBoxLayoutContainer hp1 = new HBoxLayoutContainer();
        hp1.add(new FieldLabel(tTpelKdKoreksi, "Kd Koreksi"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTRekBul, "REK Bulan"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKel, "Kelompok"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTTJatuhTempo, "Tgl Jatuh Tempo"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        hp1.add(new FieldLabel(tTIDPEL, "IDPEL"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTFrt, "FRT"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTTDaya, "Tarif/Daya"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(tTTDaya1, new BoxLayoutData(new Margins(0, 0, 0, 0)));
        hp1.add(new Label("/"), new BoxLayoutData(new Margins(0, 1, 0, 0)));
        hp1.add(tTTDaya2, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTAbonM, "AbonM"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        hp1.add(new FieldLabel(tTNoPEL, "NOPEL"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTFjn, "FJN"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKog, "Kogol"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTpelFKKwh, "FK KWH"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        hp1.add(new FieldLabel(tTNama, "Nama"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKdppj, "KDPPJ"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTInkaso, "Inkaso"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTpelFKKvARH, "FK KvARH"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        hp1.add(new FieldLabel(tTAlamat, "Alamat"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTPemda, "Pemda"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKedudukan, "Kendudukan"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTpelFKKvAMAX, "FK KvAMAX"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        hp1.add(new FieldLabel(tTUUP, "Unit UP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTU, "Unit KJ"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        TextField tTpelNama = new TextField();
        tTpelNama.setWidth(300);
        TextField tTpelAlamat = new TextField();
        tTpelAlamat.setWidth(300);
        TextField tTpelFKKwh1 = new TextField();
        tTpelFKKwh1.setWidth(80);
        TextField tTpelFKKvARH1 = new TextField();
        tTpelFKKvARH1.setWidth(80);
        TextField tTpelFKKvAMAX1 = new TextField();
        tTpelFKKvAMAX1.setWidth(80);
        TextField tTpelKdppj = new TextField();
        tTpelKdppj.setWidth(80);
        TextField tTpelPemda = new TextField();
        tTpelPemda.setWidth(80);
        TextField tTpelFJN = new TextField();
        tTpelFJN.setWidth(80);
        TextField tTpelFRT = new TextField();
        tTpelFRT.setWidth(80);
        TextField tTpelAbonM = new TextField();
        tTpelAbonM.setWidth(80);
        TextField tTpelTDaya = new TextField();
        tTpelTDaya.setWidth(40);
        TextField tTpelTDaya1 = new TextField();
        tTpelTDaya1.setWidth(20);
        TextField tTpelTDaya2 = new TextField();
        tTpelTDaya2.setWidth(50);
        TextField tTpelKogol = new TextField();
        tTpelKogol.setWidth(80);
        TextField tTpelInkaso = new TextField();
        tTpelInkaso.setWidth(80);
        TextField tTpelKedudukan = new TextField();
        tTpelKedudukan.setWidth(80);

        FramedPanel ataspanel = new FramedPanel();
        ataspanel.setHeadingText("Data Baru");
        VerticalLayoutContainer FieldpelTengah = new VerticalLayoutContainer();
        HBoxLayoutContainer hppel1 = new HBoxLayoutContainer();
        hppel1.add(new FieldLabel(tTpelNama, "Nama"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hppel1.add(new FieldLabel(tTpelTDaya, "Tarif/Daya"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hppel1.add(tTpelTDaya1, new BoxLayoutData(new Margins(0, 0, 0, 0)));
        hppel1.add(new Label("/"), new BoxLayoutData(new Margins(0, 1, 0, 0)));
        hppel1.add(tTpelTDaya2, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldpelTengah.add(hppel1);

        hppel1 = new HBoxLayoutContainer();
        hppel1.add(new FieldLabel(tTpelAlamat, "Alamat"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hppel1.add(new FieldLabel(tTpelKogol, "Kogol"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldpelTengah.add(hppel1);

        hppel1 = new HBoxLayoutContainer();
        hppel1.add(new FieldLabel(tTpelFRT, "FRT"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hppel1.add(new FieldLabel(tTpelKdppj, "KdPPJ"), new BoxLayoutData(new Margins(0, 5, 0, 30)));
        hppel1.add(new FieldLabel(tTpelInkaso, "Inkaso"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldpelTengah.add(hppel1);

        hppel1 = new HBoxLayoutContainer();
        hppel1.add(new FieldLabel(tTpelFJN, "FJN"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hppel1.add(new FieldLabel(tTpelPemda, "Pemda"), new BoxLayoutData(new Margins(0, 5, 0, 30)));
        hppel1.add(new FieldLabel(tTpelKedudukan, "Kedudukan"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldpelTengah.add(hppel1);

        hppel1 = new HBoxLayoutContainer();
        hppel1.add(new FieldLabel(tTpelAbonM, "AbonM"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hppel1.add(new FieldLabel(tTpelFKKwh1, "FK KWH"), new BoxLayoutData(new Margins(0, 5, 0, 30)));
        FieldpelTengah.add(hppel1);

        hppel1 = new HBoxLayoutContainer();
        hppel1.add(new FieldLabel(tTpelFKKvARH1, "FK KvARH"), new BoxLayoutData(new Margins(0, 5, 0, 220)));
        FieldpelTengah.add(hppel1);

        hppel1 = new HBoxLayoutContainer();
        hppel1.add(new FieldLabel(tTpelFKKvAMAX1, "FK KvARHMAX"), new BoxLayoutData(new Margins(0, 5, 0, 220)));
        FieldpelTengah.add(hppel1);
        ataspanel.add(FieldpelTengah);
        VTab.add(ataspanel);

        VTab = new VerticalLayoutContainer();
        VTab.setLayoutData(new MarginData(8));

        tabs.add(VTab, "Detail Kwh");

        Label Awal = new Label("St. Awal");
        Label Awal1 = new Label("St. Akhir");
        Label Awal2 = new Label("Pemakaian");
        TextField tTtglbaca = new TextField();
        tTtglbaca.setWidth(70);

        //Tab 2
        HBoxLayoutContainer hp3 = new HBoxLayoutContainer();
        hp3.add(Awal, new BoxLayoutData(new Margins(0, 5, 0, 110)));
        hp3.add(Awal1, new BoxLayoutData(new Margins(0, 5, 0, 18)));
        hp3.add(Awal2, new BoxLayoutData(new Margins(0, 5, 0, 120)));
        hp3.add(new FieldLabel(tTtglbaca, "Tanggal Baca"), new BoxLayoutData(new Margins(0, 5, 0, 7)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        TextField tTLWBP = new TextField();
        tTLWBP.setWidth(70);
        TextField tTLWBP0 = new TextField();
        tTLWBP0.setWidth(70);
        TextField tTLWBP1 = new TextField();
        tTLWBP1.setWidth(70);
        hp3.add(new FieldLabel(tTLWBP, "LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(tTLWBP0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTLWBP1, "LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        TextField tTWBP = new TextField();
        tTWBP.setWidth(70);
        TextField tTWBP0 = new TextField();
        tTWBP0.setWidth(70);
        TextField tTWBP1 = new TextField();
        tTWBP1.setWidth(70);
        hp3.add(new FieldLabel(tTWBP, "WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(tTWBP0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTWBP1, "WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        TextField tTKvArh = new TextField();
        tTKvArh.setWidth(70);
        TextField tTKvArh1 = new TextField();
        tTKvArh1.setWidth(70);
        TextField tTBlok3 = new TextField();
        tTBlok3.setWidth(70);
        hp3.add(new FieldLabel(tTKvArh, "KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(tTKvArh1, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTBlok3, "Blok 3"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        TextField tTSKVAMAX = new TextField();
        tTSKVAMAX.setWidth(70);
        TextField tTTotal = new TextField();
        tTTotal.setWidth(70);
        hp3.add(new FieldLabel(tTSKVAMAX, "SKVAMAX"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTTotal, "Total"), new BoxLayoutData(new Margins(0, 5, 0, 75)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        TextField tTKebKvArh = new TextField();
        tTKebKvArh.setWidth(70);
        hp3.add(new FieldLabel(tTKebKvArh, "Kelb KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 255)));

        hp3 = new HBoxLayoutContainer();
        TextField tTkwhKvArh = new TextField();
        tTkwhKvArh.setWidth(70);
        hp3.add(new FieldLabel(tTkwhKvArh, "KWH KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 255)));
        VTab.add(hp3);


        FramedPanel tengahpanel = new FramedPanel();
        tengahpanel.setHeadingText("Data Baru");
        VerticalLayoutContainer FieldkwhTengah = new VerticalLayoutContainer();
        HBoxLayoutContainer hpkwh3 = new HBoxLayoutContainer();
        TextField tTtglbacakwh = new TextField();
        tTtglbacakwh.setWidth(70);
        hpkwh3.add(new Label("St. Awal"), new BoxLayoutData(new Margins(0, 5, 0, 110)));
        hpkwh3.add(new Label("St. Akhir"), new BoxLayoutData(new Margins(0, 5, 0, 18)));
        hpkwh3.add(new Label("Pemakaian"), new BoxLayoutData(new Margins(0, 5, 0, 120)));
        hpkwh3.add(new FieldLabel(tTtglbacakwh, "Tanggal Baca"), new BoxLayoutData(new Margins(0, 5, 0, 7)));
        FieldkwhTengah.add(hpkwh3);

        hpkwh3 = new HBoxLayoutContainer();
        TextField tTLWBPkwh1 = new TextField();
        tTLWBPkwh1.setWidth(70);
        TextField tTLWBP01 = new TextField();
        tTLWBP01.setWidth(70);
        TextField tTLWBPkwh11 = new TextField();
        tTLWBPkwh11.setWidth(70);
        hpkwh3.add(new FieldLabel(tTLWBPkwh1, "LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hpkwh3.add(tTLWBP01, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hpkwh3.add(new FieldLabel(tTLWBPkwh11, "LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hpkwh3.add(new Label("(YYYYMMDD)"), new BoxLayoutData(new Margins(0, 5, 0, 105)));
        FieldkwhTengah.add(hpkwh3);

        hpkwh3 = new HBoxLayoutContainer();
        TextField tTWBPkwh1 = new TextField();
        tTWBPkwh1.setWidth(70);
        TextField tTWBPkwh10 = new TextField();
        tTWBPkwh10.setWidth(70);
        TextField tTWBPkwh11 = new TextField();
        tTWBPkwh11.setWidth(70);
        hpkwh3.add(new FieldLabel(tTWBPkwh1, "WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hpkwh3.add(tTWBPkwh10, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hpkwh3.add(new FieldLabel(tTWBPkwh11, "WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldkwhTengah.add(hpkwh3);

        hpkwh3 = new HBoxLayoutContainer();
        TextField tTKvArhkwh1 = new TextField();
        tTKvArhkwh1.setWidth(70);
        TextField tTKvArhkwh11 = new TextField();
        tTKvArhkwh11.setWidth(70);
        TextField tTBlok31 = new TextField();
        tTBlok31.setWidth(70);
        hpkwh3.add(new FieldLabel(tTKvArhkwh1, "KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hpkwh3.add(tTKvArhkwh11, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hpkwh3.add(new FieldLabel(tTBlok31, "Blok 3"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldkwhTengah.add(hpkwh3);

        hpkwh3 = new HBoxLayoutContainer();
        TextField tTSKVAMAX1 = new TextField();
        tTSKVAMAX1.setWidth(70);
        TextField tTTotal1 = new TextField();
        tTTotal1.setWidth(70);
        hpkwh3.add(new FieldLabel(tTSKVAMAX1, "SKVAMAX"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hpkwh3.add(new FieldLabel(tTTotal1, "Total"), new BoxLayoutData(new Margins(0, 5, 0, 75)));
        FieldkwhTengah.add(hpkwh3);

        hpkwh3 = new HBoxLayoutContainer();
        TextField tTKebKvArh1 = new TextField();
        tTKebKvArh1.setWidth(70);
        hpkwh3.add(new FieldLabel(tTKebKvArh1, "Kelb KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 255)));
        FieldkwhTengah.add(hpkwh3);

        hpkwh3 = new HBoxLayoutContainer();
        TextField tTkwhKvArh1 = new TextField();
        tTkwhKvArh1.setWidth(70);
        hpkwh3.add(new FieldLabel(tTkwhKvArh1, "KWH KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 255)));
        FieldkwhTengah.add(hpkwh3);
        tengahpanel.add(FieldkwhTengah);
        VTab.add(tengahpanel);



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
        TextField tTRP1Beban = new TextField();
        tTRP1Beban.setWidth(70);
        TextField tTRP1Blok3 = new TextField();
        tTRP1Blok3.setWidth(70);
        TextField tTRP1LWBP = new TextField();
        tTRP1LWBP.setWidth(70);
        TextField tTRP1WBP = new TextField();
        tTRP1WBP.setWidth(70);
        TextField tTRP1KvARH = new TextField();
        tTRP1KvARH.setWidth(70);
        TextField tTRP1TTLB = new TextField();
        tTRP1TTLB.setWidth(70);
        TextField tTRP1Diskon = new TextField();
        tTRP1Diskon.setWidth(70);
        TextField tTRpTrafo = new TextField();
        tTRpTrafo.setWidth(70);
        TextField tTRpPLN = new TextField();
        tTRpPLN.setWidth(70);
        TextField tTRpTb = new TextField();
        tTRpTb.setWidth(70);
        TextField tTSKap = new TextField();
        tTSKap.setWidth(70);
        TextField tTInsentif = new TextField();
        tTInsentif.setWidth(70);
        TextField tTRpPPN = new TextField();
        tTRpPPN.setWidth(70);
        TextField tTKdAngA = new TextField();
        tTKdAngA.setWidth(45);
        TextField tTKdAngA0 = new TextField();
        tTKdAngA0.setWidth(20);
        TextField tTDisInsentif = new TextField();
        tTDisInsentif.setWidth(70);
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

        //Tab 2
        HBoxLayoutContainer hp2 = new HBoxLayoutContainer();
        hp2.add(new FieldLabel(tTRP1Beban, "Rp Beban"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTRpPTL, "Rp PTL"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTStrafo, "Rp Sewa Trafo"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTReduksi, "Rp Reduksi"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        hp2 = new HBoxLayoutContainer();
        hp2.add(new FieldLabel(tTRP1LWBP, "Rp LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTRpTb, "Rp TB"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTSKap, "Rp Sewa Kap"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTSelisih, "Rp Selisih"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        hp2 = new HBoxLayoutContainer();
        hp2.add(new FieldLabel(tTRP1WBP, "Rp WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTRpPPN, "Rp PPN"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTKdAngA, "Rp/Kd Angs A"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(tTKdAngA0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTInsentif, "Rp Insentif"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        hp2 = new HBoxLayoutContainer();
        hp2.add(new FieldLabel(tTRP1Blok3, "Rp Block3"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTRpBPJU, "Rp BPJU"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTKdAngB, "Rp/Kd Angs B"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(tTKdAngB0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTDisInsentif, "Rp DisInsentif"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        hp2 = new HBoxLayoutContainer();
        hp2.add(new FieldLabel(tTRP1KvARH, "Rp KvARH"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTRpMat, "Rp Mat"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTKdAngC, "Rp/Kd Angs C"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(tTKdAngC0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTRpTAG, "Rp TAG"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        hp2 = new HBoxLayoutContainer();
        hp2.add(new FieldLabel(tTRP1TTLB, "Rp TTLB"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTRpTrafo, "Rp Trafo"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tTRpPLN, "Rp PLN"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        hp2 = new HBoxLayoutContainer();
        hp2.add(new FieldLabel(tTRP1Diskon, "Rp Diskon"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        FramedPanel tengahpanelrp1 = new FramedPanel();
        tengahpanelrp1.setHeadingText("Data Baru");
        VerticalLayoutContainer FieldrpTengah1 = new VerticalLayoutContainer();
        HBoxLayoutContainer hprp2 = new HBoxLayoutContainer();

        TextField tTRp1PTL = new TextField();
        tTRp1PTL.setWidth(70);
        TextField tTRp1Strafo = new TextField();
        tTRp1Strafo.setWidth(70);
        TextField tTRp1Reduksi = new TextField();
        tTRp1Reduksi.setWidth(70);
        TextField  tTRp1Selisih = new TextField();
        tTRp1Selisih.setWidth(70);
        TextField tTRp11Beban = new TextField();
        tTRp11Beban.setWidth(70);
        TextField tTRp11Blok3 = new TextField();
        tTRp11Blok3.setWidth(70);
        TextField tTRp11LWBP = new TextField();
        tTRp11LWBP.setWidth(70);
        TextField tTRp11WBP = new TextField();
        tTRp11WBP.setWidth(70);
        TextField tTRp11KvARH = new TextField();
        tTRp11KvARH.setWidth(70);
        TextField tTRp11TTLB = new TextField();
        tTRp11TTLB.setWidth(70);
        TextField tTRp11Diskon = new TextField();
        tTRp11Diskon.setWidth(70);
        TextField tTRp1RpTrafo = new TextField();
        tTRp1RpTrafo.setWidth(70);
        TextField tTRp1RpPLN = new TextField();
        tTRp1RpPLN.setWidth(70);
        TextField tTRp1RpTb = new TextField();
        tTRp1RpTb.setWidth(70);
        TextField tTRp1SKap = new TextField();
        tTRp1SKap.setWidth(70);
        TextField tTRp2Insentif = new TextField();
        tTRp2Insentif.setWidth(70);
        TextField tTRp1RpPPN = new TextField();
        tTRp1RpPPN.setWidth(70);
        TextField tTRp1KdAngA = new TextField();
        tTRp1KdAngA.setWidth(45);
        TextField tTRp1KdAngA0 = new TextField();
        tTRp1KdAngA0.setWidth(20);
        TextField tTRp1DisInsentif = new TextField();
        tTRp1DisInsentif.setWidth(70);
        TextField tTRp1RpBPJU = new TextField();
        tTRp1RpBPJU.setWidth(70);
        TextField tTRp1KdAngB = new TextField();
        tTRp1KdAngB.setWidth(45);
        TextField tTRp1KdAngB0 = new TextField();
        tTRp1KdAngB0.setWidth(20);
        TextField tTRp1RpTAG = new TextField();
        tTRp1RpTAG.setWidth(70);
        TextField tTRp1RpMat = new TextField();
        tTRp1RpMat.setWidth(70);
        TextField tTRp1KdAngC = new TextField();
        tTRp1KdAngC.setWidth(45);
        TextField tTRp1KdAngC0 = new TextField();
        tTRp1KdAngC0.setWidth(20);
        TextField tTRp1Insentif = new TextField();
        tTRp1Insentif.setWidth(70);
        TextField tTRp2DisInsentif = new TextField();
        tTRp2DisInsentif.setWidth(70);
        TextField tTRp1InsentifKVA = new TextField();
        tTRp1InsentifKVA.setWidth(70);
        TextField tTRp1DisInsentifKVA = new TextField();
        tTRp1DisInsentifKVA.setWidth(70);
        TextField tTRp1InsentifKWH = new TextField();
        tTRp1InsentifKWH.setWidth(70);
        TextField tTRp1DisInsentifKWH = new TextField();
        tTRp1DisInsentifKWH.setWidth(70);

        hprp2.add(new FieldLabel(tTRp11Beban, "Rp Beban"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp2Insentif, "Rp Insentif"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1PTL, "Rp PTL"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1Strafo, "Rp Sewa Trafo"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1Reduksi, "Rp Reduksi"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldrpTengah1.add(hprp2);

        hprp2 = new HBoxLayoutContainer();
        hprp2.add(new FieldLabel(tTRp11LWBP, "Rp LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp2DisInsentif, "Rp DisInsentif"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1RpTb, "Rp TB"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1SKap, "Rp Sewa Kap"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1Selisih, "Rp Selisih"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldrpTengah1.add(hprp2);

        hprp2 = new HBoxLayoutContainer();
        hprp2.add(new FieldLabel(tTRp11WBP, "Rp WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1InsentifKVA, "Rp Insentif KVA"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1RpPPN, "Rp PPN"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1KdAngA, "Rp/Kd Angs A"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(tTRp1KdAngA0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1Insentif, "Rp Insentif"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldrpTengah1.add(hprp2);

        hprp2 = new HBoxLayoutContainer();
        hprp2.add(new FieldLabel(tTRp11Blok3, "Rp Block3"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1DisInsentifKVA, "Rp DisInsentif KVA"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1RpBPJU, "Rp BPJU"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1KdAngB, "Rp/Kd Angs B"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(tTRp1KdAngB0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1DisInsentif, "Rp DisInsentif"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldrpTengah1.add(hprp2);

        hprp2 = new HBoxLayoutContainer();
        hprp2.add(new FieldLabel(tTRp11KvARH, "Rp KvARH"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1InsentifKWH, "Rp Insentif KWH"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1RpMat, "Rp Mat"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1KdAngC, "Rp/Kd Angs C"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(tTRp1KdAngC0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1RpTAG, "Rp TAG"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldrpTengah1.add(hprp2);

        hprp2 = new HBoxLayoutContainer();
        hprp2.add(new FieldLabel(tTRp11TTLB, "Rp TTLB"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1DisInsentifKWH, "Rp DisInsentif KWH"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1RpTrafo, "Rp Trafo"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp2.add(new FieldLabel(tTRp1RpPLN, "Rp PLN"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldrpTengah1.add(hprp2);

        hprp2 = new HBoxLayoutContainer();
        hprp2.add(new FieldLabel(tTRp11Diskon, "Rp Diskon"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldrpTengah1.add(hprp2);
        tengahpanelrp1.add(FieldrpTengah1);
        VTab.add(tengahpanelrp1);

        VTab = new VerticalLayoutContainer();
        VTab.setLayoutData(new MarginData(8));

        tabs.add(VTab, "Detail Rupiah");
        TextField tTRpBK1 = new TextField();
        tTRpBK1.setWidth(70);
        TextField tTRpBK2 = new TextField();
        tTRpBK2.setWidth(70);
        TextField tTRpBK3 = new TextField();
        tTRpBK3.setWidth(70);
        TextField tTRpSubsidi = new TextField();
        tTRpSubsidi.setWidth(70);
        TextField tTProduksi = new TextField();
        tTProduksi.setWidth(70);
        TextField tTTdlLama = new TextField();
        tTTdlLama.setWidth(70);
        TextField tTTdlbaru = new TextField();
        tTTdlbaru.setWidth(70);
        TextField tTrpRpBK1 = new TextField();
        tTrpRpBK1.setWidth(70);
        TextField tTrpRpBK2 = new TextField();
        tTrpRpBK2.setWidth(70);
        TextField tTrpRpBK3 = new TextField();
        tTrpRpBK3.setWidth(70);
        TextField tTrpRpSubsidi = new TextField();
        tTrpRpSubsidi.setWidth(70);
        TextField tTrpProduksi = new TextField();
        tTrpProduksi.setWidth(70);
        TextField tTrpTdlLama = new TextField();
        tTrpTdlLama.setWidth(70);
        TextField tTrpTdlbaru = new TextField();
        tTrpTdlbaru.setWidth(70);

        HBoxLayoutContainer hp4 = new HBoxLayoutContainer();
        hp4.add(new FieldLabel(tTProduksi, "Rp Produksi"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp4.add(new FieldLabel(tTRpBK1, "Rp BK 1"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp4);

        hp4 = new HBoxLayoutContainer();
        hp4.add(new FieldLabel(tTRpSubsidi, "Rp Subsidi"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp4.add(new FieldLabel(tTRpBK2, "Rp BK 2"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp4);

        hp4 = new HBoxLayoutContainer();
        hp4.add(new FieldLabel(tTTdlLama, "Rp TDL Lama"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp4.add(new FieldLabel(tTRpBK3, "Rp BK 3"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp4);

        hp4 = new HBoxLayoutContainer();
        hp4.add(new FieldLabel(tTTdlbaru, "Rp TDL Baru"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp4);

        FramedPanel tengahpanelrp = new FramedPanel();
        tengahpanelrp.setHeadingText("Data Baru");
        VerticalLayoutContainer FieldrpTengah = new VerticalLayoutContainer();
        HBoxLayoutContainer hprp3 = new HBoxLayoutContainer();
        hprp3.add(new FieldLabel(tTrpProduksi, "Rp Produksi"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp3.add(new FieldLabel(tTrpRpBK1, "Rp BK 1"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldrpTengah.add(hprp3);

        hprp3 = new HBoxLayoutContainer();
        hprp3.add(new FieldLabel(tTrpRpSubsidi, "Rp Subsidi"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp3.add(new FieldLabel(tTrpRpBK2, "Rp BK 2"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldrpTengah.add(hprp3);

        hprp3 = new HBoxLayoutContainer();
        hprp3.add(new FieldLabel(tTrpTdlLama, "Rp TDL Lama"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hprp3.add(new FieldLabel(tTrpRpBK3, "Rp BK 3"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldrpTengah.add(hprp3);

        hprp3 = new HBoxLayoutContainer();
        hprp3.add(new FieldLabel(tTrpTdlbaru, "Rp TDL Baru"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldrpTengah.add(hprp3);
        tengahpanelrp.add(FieldrpTengah);
        VTab.add(tengahpanelrp);

        VTab = new VerticalLayoutContainer();
        VTab.setLayoutData(new MarginData(8));

        tabs.add(VTab, "Detail Mutasi");
        TextField tTmuRpBP = new TextField();
        tTmuRpBP.setWidth(70);
        TextField tTmuJMutasi = new TextField();
        tTmuJMutasi.setWidth(70);
        TextField tTmuRpUJL = new TextField();
        tTmuRpUJL.setWidth(70);
        TextField tTmuBLHMutasi = new TextField();
        tTmuBLHMutasi.setWidth(70);
        TextField tTmuKDGardu = new TextField();
        tTmuKDGardu.setWidth(70);
        TextField tTmuKDMutasi = new TextField();
        tTmuKDMutasi.setWidth(70);
        TextField tTmuNoTiang = new TextField();
        tTmuNoTiang.setWidth(70);
        TextField tTmuTglNyala = new TextField();
        tTmuTglNyala.setWidth(70);
        TextField tTmuNoMeter = new TextField();
        tTmuNoMeter.setWidth(70);
        HBoxLayoutContainer hp5 = new HBoxLayoutContainer();
        hp5.add(new FieldLabel(tTmuRpBP, "Rp BP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp5.add(new FieldLabel(tTmuJMutasi, "Jenis Mutasi"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp5);

        hp5 = new HBoxLayoutContainer();
        hp5.add(new FieldLabel(tTmuRpUJL, "Rp UJL"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp5.add(new FieldLabel(tTmuBLHMutasi, "BLH Mutasi"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp5);

        hp5 = new HBoxLayoutContainer();
        hp5.add(new FieldLabel(tTmuKDGardu, "Kode Gardu"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp5.add(new FieldLabel(tTmuKDMutasi, "Kode Mutasi"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp5);

        hp5 = new HBoxLayoutContainer();
        hp5.add(new FieldLabel(tTmuNoTiang, "No Tiang"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp5.add(new FieldLabel(tTmuTglNyala, "Tgl Nyala/Perubahan"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp5);

        hp5 = new HBoxLayoutContainer();
        hp5.add(new FieldLabel(tTmuNoMeter, "No Meter"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp5);

        VTab = new VerticalLayoutContainer();
        VTab.setLayoutData(new MarginData(8));

        tabs.add(VTab, "Detail Cabut Pasang");
        DateField dTglCabut = new DateField();
        DateField dTglPasang = new DateField();
        TextField tTcbLWBP = new TextField();
        tTcbLWBP.setWidth(60);
        TextField tTcbLWBP1 = new TextField();
        tTcbLWBP1.setWidth(60);
        TextField tTcbWBP = new TextField();
        tTcbWBP.setWidth(60);
        TextField tTcbWBP1 = new TextField();
        tTcbWBP1.setWidth(60);
        TextField tTcbKVARH = new TextField();
        tTcbKVARH.setWidth(60);
        TextField tTcbKVARH1 = new TextField();
        tTcbKVARH1.setWidth(60);
        HBoxLayoutContainer hp6 = new HBoxLayoutContainer();
        hp6.add(new FieldLabel(dTglCabut, "Tanggal Cabut"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp6);
        hp6 = new HBoxLayoutContainer();
        hp6.add(new FieldLabel(dTglPasang, "Tanggal Pasang"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp6);
        hp6 = new HBoxLayoutContainer();
        hp6.add(new Label("Cabut"), new BoxLayoutData(new Margins(0, 5, 0, 110)));
        VTab.add(hp6);
        hp6.add(new Label("Pasang"), new BoxLayoutData(new Margins(0, 5, 0, 20)));
        VTab.add(hp6);
        hp6 = new HBoxLayoutContainer();
        hp6.add(new FieldLabel(tTcbLWBP, "LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp6.add(tTcbLWBP1, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp6);
        hp6 = new HBoxLayoutContainer();
        hp6.add(new FieldLabel(tTcbWBP, "WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp6.add(tTcbWBP1, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp6);
        hp6 = new HBoxLayoutContainer();
        hp6.add(new FieldLabel(tTcbKVARH, "KVARH"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp6.add(tTcbKVARH1, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp6);

        p.add(tabs);

        return panel;
    }
}
