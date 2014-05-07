package id.co.hans.sample.client.form.proses;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
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
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.toolbar.FillToolItem;
import com.sencha.gxt.widget.core.client.toolbar.SeparatorToolItem;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.AbstractForm;
import id.co.hans.sample.client.components.*;

public class Form_21PelunasanGiralisasi  extends AbstractForm {


    ComboKodeGiralisasi cbKdKlf;
    ComboKodePP cbKodePP;

    TextButton bAmbilData = new TextButton("Ambil Data");
    DateField dfTanggalLunas = new DateField();

    TextField tTIDPEL = new TextField();
    TextField tTRekBul = new TextField();
    TextField tTTDaya = new TextField();
    TextField tTNoPEL = new TextField();
    TextField tTKel = new TextField();
    TextField tTKog = new TextField();
    TextField tTNama = new TextField();
    TextField tTTJatuhTempo = new TextField();
    TextField tTInkaso = new TextField();
    TextField tTAlamat = new TextField();
    TextField tTFrt = new TextField();
    TextField tTKedudukan = new TextField();
    TextField tTUUP = new TextField();
    TextField tTFjn = new TextField();
    TextField tTKdppj = new TextField();
    TextField tTU = new TextField();
    TextField tTAbonM = new TextField();
    TextField tTPemda = new TextField();

    TextField tTRpPTL = new TextField();
    TextField tTStrafo = new TextField();
    TextField tTReduksi = new TextField();
    TextField tTSelisih = new TextField();
    TextField tTRpTb = new TextField();
    TextField tTSKap = new TextField();
    TextField tTInsentif = new TextField();
    TextField tTTdlLama = new TextField();
    TextField tTRpPPN = new TextField();
    TextField tTKdAngA = new TextField();
    TextField tTKdAngA0 = new TextField();
    TextField tTDisInsentif = new TextField();
    TextField tTTdlbaru = new TextField();
    TextField tTRpBPJU = new TextField();
    TextField tTKdAngB = new TextField();
    TextField tTKdAngB0 = new TextField();
    TextField tTRpTAG = new TextField();
    TextField tTRpBK1 = new TextField();
    TextField tTRpMat = new TextField();
    TextField tTKdAngC = new TextField();
    TextField tTKdAngC0 = new TextField();
    TextField tTProduksi = new TextField();
    TextField tTRpBK2 = new TextField();
    TextField tTRpTrafo = new TextField();
    TextField tTRpPLN = new TextField();
    TextField tTRpSubsidi = new TextField();
    TextField tTRpBK3 = new TextField();

    TextField tTRpWBP = new TextField();
    TextField tTLWBP = new TextField();
    TextField tTLWBP0 = new TextField();
    TextField tTLWBP1 = new TextField();
    TextField tTRpLWBP = new TextField();
    TextField tTWBP = new TextField();
    TextField tTWBP0 = new TextField();
    TextField tTWBP1 = new TextField();
    TextField tTRpWBP2 = new TextField();
    TextField tTKvArh = new TextField();
    TextField tTKvArh1 = new TextField();
    TextField tTBlok3 = new TextField();
    TextField tTRpKvArh = new TextField();
    TextField tTFKKwh = new TextField();
    TextField tTTotal = new TextField();
    TextField tTTTLB = new TextField();
    TextField tTFKKvArh = new TextField();
    TextField tTKebKvArh = new TextField();
    TextField tTRpBeban = new TextField();

    IconDynamicGrid gpData;

    private String sLabel = "";

    private RequestBuilder rb;
    private String wsReturn;
    private String wsByRefError;
    private IconAlertMessageBox mb;

    @Override
    protected FramedPanel panelMain() {

        sLabel = "Giralisasi";

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Pelunasan " + sLabel);
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(850);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);
        FieldSet fieldSet = new FieldSet();

        VerticalLayoutContainer FieldAtas = new VerticalLayoutContainer();
        fieldSet.add(FieldAtas);
        cbKdKlf = new ComboKodeGiralisasi();
        cbKdKlf.setUnitUp(getUnitupUser());

        bAmbilData = new TextButton("Ambil Data");
        dfTanggalLunas = new DateField();

        HBoxLayoutContainer hp4 = new HBoxLayoutContainer();
        hp4.add(cbKdKlf);
        hp4.add(bAmbilData);
        FieldAtas.add(hp4);

        cbKodePP = new ComboKodePP();
        cbKodePP.setJenisPP("OFFLINE");
        cbKodePP.setUnitUp(getUnitupUser());
        FieldAtas.add(cbKodePP);

        FieldAtas.add(new FieldLabel(dfTanggalLunas, "Pilih Tanggal Lunas"));
        p.add(fieldSet);


        //TabPanel
        TabPanel tabs = new TabPanel();
        VerticalLayoutContainer VTab = new VerticalLayoutContainer();
        VTab.setLayoutData(new MarginData(8));

        tabs.add(VTab, "Detail Pelanggan");

        tTIDPEL = new TextField();
        tTIDPEL.setWidth(80);
        tTRekBul = new TextField();
        tTRekBul.setWidth(80);
        tTTDaya = new TextField();
        tTTDaya.setWidth(80);
        tTNoPEL = new TextField();
        tTNoPEL.setWidth(80);
        tTKel = new TextField();
        tTKel.setWidth(80);
        tTKog = new TextField();
        tTKog.setWidth(80);
        tTNama = new TextField();
        tTNama.setWidth(80);
        tTTJatuhTempo = new TextField();
        tTTJatuhTempo.setWidth(80);
        tTInkaso = new TextField();
        tTInkaso.setWidth(80);
        tTAlamat = new TextField();
        tTAlamat.setWidth(80);
        tTFrt = new TextField();
        tTFrt.setWidth(80);
        tTKedudukan = new TextField();
        tTKedudukan.setWidth(80);
        tTUUP = new TextField();
        tTUUP.setWidth(80);
        tTFjn = new TextField();
        tTFjn.setWidth(80);
        tTKdppj = new TextField();
        tTKdppj.setWidth(80);
        tTU = new TextField();
        tTU.setWidth(80);
        tTAbonM = new TextField();
        tTAbonM.setWidth(80);
        tTPemda = new TextField();
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

        tTRpPTL = new TextField();
        tTRpPTL.setWidth(70);
        tTStrafo = new TextField();
        tTStrafo.setWidth(70);
        tTReduksi = new TextField();
        tTReduksi.setWidth(70);
        tTSelisih = new TextField();
        tTSelisih.setWidth(70);
        tTRpTb = new TextField();
        tTRpTb.setWidth(70);
        tTSKap = new TextField();
        tTSKap.setWidth(70);
        tTInsentif = new TextField();
        tTInsentif.setWidth(70);
        tTTdlLama = new TextField();
        tTTdlLama.setWidth(70);
        tTRpPPN = new TextField();
        tTRpPPN.setWidth(70);
        tTKdAngA = new TextField();
        tTKdAngA.setWidth(45);
        tTKdAngA0 = new TextField();
        tTKdAngA0.setWidth(20);
        tTDisInsentif = new TextField();
        tTDisInsentif.setWidth(70);
        tTTdlbaru = new TextField();
        tTTdlbaru.setWidth(70);
        tTRpBPJU = new TextField();
        tTRpBPJU.setWidth(70);
        tTKdAngB = new TextField();
        tTKdAngB.setWidth(45);
        tTKdAngB0 = new TextField();
        tTKdAngB0.setWidth(20);
        tTRpTAG = new TextField();
        tTRpTAG.setWidth(70);
        tTRpBK1 = new TextField();
        tTRpBK1.setWidth(70);
        tTRpMat = new TextField();
        tTRpMat.setWidth(70);
        tTKdAngC = new TextField();
        tTKdAngC.setWidth(45);
        tTKdAngC0 = new TextField();
        tTKdAngC0.setWidth(20);
        tTProduksi = new TextField();
        tTProduksi.setWidth(70);
        tTRpBK2 = new TextField();
        tTRpBK2.setWidth(70);
        tTRpTrafo = new TextField();
        tTRpTrafo.setWidth(70);
        tTRpPLN = new TextField();
        tTRpPLN.setWidth(70);
        tTRpSubsidi = new TextField();
        tTRpSubsidi.setWidth(70);
        tTRpBK3 = new TextField();
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
        tTRpWBP = new TextField();
        tTRpWBP.setWidth(70);
        tTLWBP = new TextField();
        tTLWBP.setWidth(70);
        tTLWBP0 = new TextField();
        tTLWBP0.setWidth(70);
        tTLWBP1 = new TextField();
        tTLWBP1.setWidth(70);
        tTRpLWBP = new TextField();
        tTRpLWBP.setWidth(70);
        tTWBP = new TextField();
        tTWBP.setWidth(70);
        tTWBP0 = new TextField();
        tTWBP0.setWidth(70);
        tTWBP1 = new TextField();
        tTWBP1.setWidth(70);
        tTRpWBP2 = new TextField();
        tTRpWBP2.setWidth(70);
        tTKvArh = new TextField();
        tTKvArh.setWidth(70);
        tTKvArh1 = new TextField();
        tTKvArh1.setWidth(70);
        tTBlok3 = new TextField();
        tTBlok3.setWidth(70);
        tTRpKvArh = new TextField();
        tTRpKvArh.setWidth(70);
        tTFKKwh = new TextField();
        tTFKKwh.setWidth(70);
        tTTotal = new TextField();
        tTTotal.setWidth(70);
        tTTTLB = new TextField();
        tTTTLB.setWidth(70);
        tTFKKvArh = new TextField();
        tTFKKvArh.setWidth(70);
        tTKebKvArh = new TextField();
        tTKebKvArh.setWidth(70);
        tTRpBeban = new TextField();
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
        gpData = new IconDynamicGrid();
        gpData.setGridHeader("Array Grid");
        gpData.setGridDimension(990, 200);
        gpData.setStoreUrl("dummy/dummy.json");

        gpData.addColumn("NOMOR", 100);
        gpData.addColumn("IDPEL", 100);
        gpData.addColumn("BLTH", 100);
        gpData.addColumn("RPTAG", 100);
        gpData.addColumn("RPBK", 100);
        gpData.addColumn("TGLJTTEMPO", 100);

        p.add(gpData);

        return panel;
    }

    @Override
    protected void initEvent() {
        bAmbilData.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                try {
                    progressBox.show();

                    rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/GetViewKolektif_21giralisasi.json");
                    rb.setHeader("Content-type", "application/x-www-form-urlencoded");

                    StringBuilder sb = new StringBuilder();
                    sb.append("&tkodekolektif=" + cbKdKlf.getSelectedValue());
                    sb.append("&tBLTH=" + "");
                    sb.append("&tPetugas=" + getIdUser());

                    // ***** send request
                    rb.sendRequest(sb.toString(), new RequestCallback() {
                        @Override
                        public void onResponseReceived(Request request, Response response) {
                            if (200 == response.getStatusCode()) {
                                progressBox.hide();

                                JSONValue value = JSONParser.parse(response.getText());
                                JSONObject jsonObject = value.isObject();

                                wsByRefError = jsonObject.get("result").isObject().get("wsByRefError").isString().stringValue();

                                if (!wsByRefError.equals("")) {
                                    mb = new IconAlertMessageBox("Kesalahan", wsByRefError, true);
                                    return;
                                }

                                JSONObject wsReturnData = jsonObject.get("result").isObject();

                                gpData.setJsonData(wsReturnData);

                            } else {
                                progressBox.hide();
                                mb = new IconAlertMessageBox("Kesalahan", "HTTP Error code: " + response.getStatusCode(), true);
                            }
                        }

                        @Override
                        public void onError(Request request, Throwable throwable) {
                            progressBox.hide();
                            mb = new IconAlertMessageBox("Kesalahan", throwable.getMessage(), true);
                        }
                    });
                } catch (RequestException ex) {
                    progressBox.hide();
                    mb = new IconAlertMessageBox("Kesalahan", ex.getMessage(), true);
                }
            }
        });
    }
}


