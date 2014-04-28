package id.co.hans.sample.client.form.proses;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
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
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.AbstractForm;
import id.co.hans.sample.client.components.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Form_21Entri extends AbstractForm {

    ComboKodePP cbKdPP;
    DateField dTglLunas;
    TextField IDPel;
    TextField tKodePP;

    TextField tTIDPEL = new TextField();
    TextField tTRekBul = new TextField();
    TextField tTTDaya = new TextField();
    TextField tTKBK1 = new TextField();
    CheckBox check1 = new CheckBox();

    TextField tTNoPEL = new TextField();
    TextField tTKel = new TextField();
    TextField tTKog = new TextField();
    TextField tTKBK2 = new TextField();
    CheckBox check2 = new CheckBox();

    TextField tTNama = new TextField();
    TextField tTTJatuhTempo = new TextField();
    TextField tTInkaso = new TextField();
    TextField tTKBK3 = new TextField();
    TextField tTKdppj = new TextField();
    CheckBox check3 = new CheckBox();

    TextField tTAlamat = new TextField();
    TextField tTFrt = new TextField();
    TextField tTKedudukan = new TextField();
    TextField tTPemda = new TextField();

    TextField tTUUP = new TextField();

    TextField tTU = new TextField();


    TextField tTRpPTL = new TextField();
    TextField tTRpBeban0 = new TextField();
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
    TextField tTRpMat = new TextField();
    TextField tTKdAngC = new TextField();
    TextField tTKdAngC0 = new TextField();
    TextField tTProduksi = new TextField();
    TextField tTRpTrafo = new TextField();
    TextField tTRpPLN = new TextField();
    TextField tTRpSubsidi = new TextField();

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


    TextButton bBottomReset = new TextButton("Reset");
    TextButton bBottomSimpan = new TextButton("Simpan");
    TextButton bBottomCetak = new TextButton("Cetak Rekg");
    TextButton bBottomCetakBA = new TextButton("Cetak Rekg");

    TextField tRpTag = new TextField();
    TextField tRpBK = new TextField();

    private RequestBuilder rb;
    private Boolean wsReturn;
    private String wsByRefError;
    private IconAlertMessageBox mb;

    private String jenisPP = "OFFLINE";

    @Override
    protected void initEvent() {
        IDPel.addKeyDownHandler(new KeyDownHandler() {
            @Override
            public void onKeyDown(KeyDownEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    if (IDPel.getText().equals("")) {
                        IconAlertMessageBox mb = new IconAlertMessageBox("Kesalahan", "Masukkan ID Pelanggan", true);
                        return;
                    }

                    if (IDPel.getText().length() != 12) {
                        IconAlertMessageBox mb = new IconAlertMessageBox("Kesalahan", "ID Pelanggan 12 digit", true);
                        return;
                    }

                    try {
                        progressBox.show();
                        gpData.getGrid().getStore().clear();

                        rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/GetViewIdPel_21entri.json");
                        rb.setHeader("Content-type", "application/x-www-form-urlencoded");

                        StringBuilder sb = new StringBuilder();
                        sb.append("tpel=" + IDPel.getText().trim());
                        sb.append("&vJenis="+"IdPel");
                        sb.append("&tBLTH="+"");
                        sb.append("&tPetugas="+getIdUser());

                        rb.sendRequest(sb.toString(), new RequestCallback() {
                            @Override
                            public void onResponseReceived(Request request, Response response) {
                                progressBox.hide();

                                if (200 == response.getStatusCode()) {
                                    JSONValue value = JSONParser.parse(response.getText());
                                    JSONObject jsonObject = value.isObject();

                                    wsByRefError = jsonObject.get("result").isObject().get("wsByRefError").isString().stringValue();

                                    if (!wsByRefError.equals("")) {
                                        mb = new IconAlertMessageBox("Kesalahan", wsByRefError, true);
                                        return;
                                    }

                                    if (jsonObject.get("result").isObject().get("wsReturn").isArray().size() == 0) {
                                        mb = new IconAlertMessageBox("Kesalahan", "Piutang tidak ditemukan.", true);
                                        return;
                                    }

                                    gpData.setJsonData(jsonObject.get("result").isObject());

                                    List<Map<String, String>> datas = new ArrayList<Map<String, String>>();
                                    Map<String, String> rowData;
                                    Double rpTag = 0d, rpBK = 0d;

                                    if (jsonObject.get("result").isObject().containsKey("wsReturn")) {
                                        JSONArray array = jsonObject.get("result").isObject().get("wsReturn").isArray();

                                        for (int idx = 0; idx < array.size(); idx++) {
                                            JSONObject sourceRowData = array.get(idx).isObject();

                                            rpTag += Double.parseDouble(sourceRowData.get("rptag").isString().stringValue());
                                            rpBK += Double.parseDouble(sourceRowData.get("rpbk1").isString().stringValue());
                                            rpBK += Double.parseDouble(sourceRowData.get("rpbk2").isString().stringValue());
                                            rpBK += Double.parseDouble(sourceRowData.get("rpbk3").isString().stringValue());
                                        }
                                    }

                                    tRpTag.setValue(String.valueOf(rpTag));
                                    tRpBK.setValue(String.valueOf(rpBK));

                                } else {
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
            }
        });

        bBottomReset.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        bBottomSimpan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                String _kodePP = "", _tglBayar = "", _tKdPembayar = "";


                DateTimeFormat formatter = DateTimeFormat.getFormat("yyyyMMdd");

                _kodePP = cbKdPP.getSelectedValue();
                _tglBayar = formatter.format(dTglLunas.getValue());
                _tKdPembayar = getIdUser();

                if (_kodePP.equals("")) {
                    mb = new IconAlertMessageBox("Kesalahan", "Kode PP belum dipilih!", true);
                    return;
                }


                JSONObject jsonObjectRowSourceData = new JSONObject();
                JSONArray jsonArray = new JSONArray();

                List sourceData = gpData.getGrid().getStore().getAll();
                for (int idx = 0; idx < sourceData.size(); idx++) {
                    Map<String, String> rowSourceData = (Map<String, String>)sourceData.get(idx);
                    rowSourceData.put("SIMPAN", "true");
                    rowSourceData.put("HASIL", "");


                    for (Map.Entry<String, String> entry : rowSourceData.entrySet()) {
                        jsonObjectRowSourceData.put(entry.getKey(), new JSONString(entry.getValue()));
                    }
                    jsonArray.set(idx, jsonObjectRowSourceData);
                }


                try {
                    progressBox.show();
                    rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/SetDataIdpel_21entri.json");
                    rb.setHeader("Content-type", "application/x-www-form-urlencoded");

                    StringBuilder sb = new StringBuilder();
                    sb.append("lbrproses=" + "0");
                    sb.append("&tTransaksiBy="+getIdUser());
                    sb.append("&tTglBayar="+_tglBayar);
                    sb.append("&tKdPP="+_kodePP);
                    sb.append("&tKDPEMBAYAR="+_tKdPembayar);
                    sb.append("&strData="+jsonArray);

                    rb.sendRequest(sb.toString(), new RequestCallback() {
                        @Override
                        public void onResponseReceived(Request request, Response response) {
                            progressBox.hide();

                            if (200 == response.getStatusCode()) {
                                JSONValue value = JSONParser.parse(response.getText());
                                JSONObject jsonObject = value.isObject();

                                wsByRefError = jsonObject.get("result").isObject().get("wsByRefError").isString().stringValue();

                                if (!wsByRefError.equals("")) {
                                    mb = new IconAlertMessageBox("Kesalahan", wsByRefError, true);
                                    return;
                                }

                                gpData.setJsonData(jsonObject.get("result").isObject());
                            } else {
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

        bBottomCetak.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        bBottomCetakBA.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }

    protected FramedPanel panelMain() {

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
        cbKdPP.setJenisPP(this.jenisPP);
        cbKdPP.setUnitUp(getUnitupUser());
        cbKdPP.setComboWidth(100);
        cbKdPP.setDescriptionWidth(300);

        dTglLunas = new DateField();
        dTglLunas.setWidth(100);
        IDPel = new TextField();
        IDPel.setWidth(120);

        HBoxLayoutContainer hpT = new HBoxLayoutContainer();
        hpT.add(cbKdPP, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldAtas.add(hpT);

        hpT = new HBoxLayoutContainer();
        tKodePP = new TextField();
        tKodePP.setEmptyText("Kode Belum Dipilih.");
        tKodePP.setWidth(645);
        //hpT.add(tKodePP, new BoxLayoutData(new Margins(0, 5, 0, 105)));
        hpT.add(new FieldLabel(dTglLunas, "Tanggal Lunas"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hpT.add(new FieldLabel(IDPel, "ID Pelanggan"), new BoxLayoutData(new Margins(0, 5, 0, 10)));
        FieldAtas.add(hpT);

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
        tTKBK1 = new TextField();
        tTKBK1.setWidth(80);
        check1 = new CheckBox();
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
        tTNoPEL = new TextField();
        tTNoPEL.setWidth(80);
        tTKel = new TextField();
        tTKel.setWidth(80);
        tTKog = new TextField();
        tTKog.setWidth(80);
        tTKBK2 = new TextField();
        tTKBK2.setWidth(80);
        check2 = new CheckBox();
        check2.setBoxLabel("Hapus BK2");

        hp1.add(new FieldLabel(tTNoPEL, "NOPEL"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKel, "Kelompok"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKog, "Kogol"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKBK2, "Rp BK2"), new BoxLayoutData(new Margins(0, 5, 0, 50)));
        hp1.add(check2, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        tTNama = new TextField();
        tTNama.setWidth(80);
        tTTJatuhTempo = new TextField();
        tTTJatuhTempo.setWidth(80);
        tTInkaso = new TextField();
        tTInkaso.setWidth(80);
        tTKBK3 = new TextField();
        tTKBK3.setWidth(80);
        tTKdppj = new TextField();
        tTKdppj.setWidth(80);
        check3 = new CheckBox();
        check3.setBoxLabel("Hapus BK3");
        hp1.add(new FieldLabel(tTNama, "Nama"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTTJatuhTempo, "Tgl Jatuh Tempo"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKdppj, "KDPPJ"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKBK3, "Rp BK3"), new BoxLayoutData(new Margins(0, 5, 0, 50)));
        hp1.add(check3, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        tTAlamat = new TextField();
        tTAlamat.setWidth(80);
        tTFrt = new TextField();
        tTFrt.setWidth(80);
        tTKedudukan = new TextField();
        tTKedudukan.setWidth(80);
        tTPemda = new TextField();
        tTPemda.setWidth(80);
        hp1.add(new FieldLabel(tTAlamat, "Alamat"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTKedudukan, "Kendudukan"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTPemda, "Pemda"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        tTUUP = new TextField();
        tTUUP.setWidth(80);
        hp1.add(new FieldLabel(tTUUP, "Unit UP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tTInkaso, "Inkaso"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        tTU = new TextField();
        tTU.setWidth(80);
        hp1.add(new FieldLabel(tTU, "Unit"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        VTab = new VerticalLayoutContainer();
        VTab.setLayoutData(new MarginData(8));

        tabs.add(VTab, "Detail Rupiah");

        tTRpPTL = new TextField();
        tTRpPTL.setWidth(70);
        tTRpBeban0 = new TextField();
        tTRpBeban0.setWidth(70);
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
        tTRpMat = new TextField();
        tTRpMat.setWidth(70);
        tTKdAngC = new TextField();
        tTKdAngC.setWidth(45);
        tTKdAngC0 = new TextField();
        tTKdAngC0.setWidth(20);
        tTProduksi = new TextField();
        tTProduksi.setWidth(70);
        tTRpTrafo = new TextField();
        tTRpTrafo.setWidth(70);
        tTRpPLN = new TextField();
        tTRpPLN.setWidth(70);
        tTRpSubsidi = new TextField();
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
        tTRpWBP = new TextField();
        tTRpWBP.setWidth(70);

        //Tab 3
        HBoxLayoutContainer hp3 = new HBoxLayoutContainer();
        hp3.add(Awal, new BoxLayoutData(new Margins(0, 5, 0, 110)));
        hp3.add(Awal1, new BoxLayoutData(new Margins(0, 5, 0, 18)));
        hp3.add(Awal2, new BoxLayoutData(new Margins(0, 5, 0, 120)));
        hp3.add(new FieldLabel(tTRpWBP, "Rp WBP"), new BoxLayoutData(new Margins(0, 5, 0, 7)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        tTLWBP = new TextField();
        tTLWBP.setWidth(70);
        tTLWBP0 = new TextField();
        tTLWBP0.setWidth(70);
        tTLWBP1 = new TextField();
        tTLWBP1.setWidth(70);
        tTRpLWBP = new TextField();
        tTRpLWBP.setWidth(70);
        hp3.add(new FieldLabel(tTLWBP, "LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(tTLWBP0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTLWBP1, "LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTRpLWBP, "Rp LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        tTWBP = new TextField();
        tTWBP.setWidth(70);
        tTWBP0 = new TextField();
        tTWBP0.setWidth(70);
        tTWBP1 = new TextField();
        tTWBP1.setWidth(70);
        tTRpWBP2 = new TextField();
        tTRpWBP2.setWidth(70);
        hp3.add(new FieldLabel(tTWBP, "WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(tTWBP0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTWBP1, "WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTRpWBP2, "Rp WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        tTKvArh = new TextField();
        tTKvArh.setWidth(70);
        tTKvArh1 = new TextField();
        tTKvArh1.setWidth(70);
        tTBlok3 = new TextField();
        tTBlok3.setWidth(70);
        tTRpKvArh = new TextField();
        tTRpKvArh.setWidth(70);
        hp3.add(new FieldLabel(tTKvArh, "KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(tTKvArh1, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTBlok3, "Blok 3"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTRpKvArh, "Rp KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        tTFKKwh = new TextField();
        tTFKKwh.setWidth(70);
        tTTotal = new TextField();
        tTTotal.setWidth(70);
        tTTTLB = new TextField();
        tTTTLB.setWidth(70);
        hp3.add(new FieldLabel(tTFKKwh, "FK Kwh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTTotal, "Total"), new BoxLayoutData(new Margins(0, 5, 0, 75)));
        hp3.add(new FieldLabel(tTTTLB, "TTLB"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        tTFKKvArh = new TextField();
        tTFKKvArh.setWidth(70);
        tTKebKvArh = new TextField();
        tTKebKvArh.setWidth(70);
        tTRpBeban = new TextField();
        tTRpBeban.setWidth(70);
        hp3.add(new FieldLabel(tTFKKvArh, "FK KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tTKebKvArh, "Keb KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 75)));
        hp3.add(new FieldLabel(tTRpBeban, "Rp Beban"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        p.add(tabs);

        //Grid
        gpData = new IconDynamicGrid();
        gpData.setGridHeader("Data Tagihan");
        gpData.setGridDimension(990, 200);
        gpData.setStoreUrl("dummy/dummy.json?");
        gpData.addColumn("SIMPAN", 50);
        gpData.addColumn("HASIL", 50);
        gpData.addColumn("NOMOR", 50);
        gpData.addColumn("IDPEL", 100);
        gpData.addColumn("BLTH", 80);
        gpData.addColumn("RPTAG", 100);
        gpData.addColumn("RPBK1", 100);
        gpData.addColumn("RPBK2", 100);
        gpData.addColumn("RPBK3", 100);
        gpData.addColumn("TGLJTTEMPO", 100);
        gpData.addColumn("STATUS", 100);
        gpData.addColumn("KDPEMBPP", 100);
        gpData.addColumn("KDGERAKMASUK", 100);
        gpData.addColumn("KDKOREKSI", 100);
        gpData.addColumn("TGKOREKSI", 100);
        gpData.addColumn("NOREK", 100);

        p.add(gpData);

        //FieldBawah
        FieldSet fieldSet1 = new FieldSet();
        fieldSet1.setHeadingText("");

        VerticalLayoutContainer FieldBawah = new VerticalLayoutContainer();
        fieldSet1.add(FieldBawah);

        bBottomReset = new TextButton("Reset");
        bBottomReset.setWidth(100);
        bBottomSimpan = new TextButton("Simpan");
        bBottomSimpan.setWidth(100);
        bBottomCetak = new TextButton("Cetak Rekg");
        bBottomCetak.setWidth(100);
        bBottomCetakBA = new TextButton("Cetak BA");
        bBottomCetakBA.setWidth(100);

        tRpTag = new TextField();
        tRpBK = new TextField();

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
