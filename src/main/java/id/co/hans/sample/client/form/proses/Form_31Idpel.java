package id.co.hans.sample.client.form.proses;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.*;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;
import id.co.hans.sample.client.AbstractForm;
import id.co.hans.sample.client.components.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Form_31Idpel extends AbstractForm  {

    TextField tfTopIdPelanggan;

    TextField tfDetailPelangganDescIDPEL;
    TextField tfDetailPelangganDescRekBulan;
    TextField tfDetailPelangganDescTarifDaya;
    TextField tfDetailPelangganDescNOPEL;
    TextField tfDetailPelangganDescKelompok;
    TextField tfDetailPelangganDescKogol;

    TextField tfDetailPelangganDescNama;
    TextField tfDetailPelangganDescTglJatuhTempo;
    TextField tfDetailPelangganDescInkaso;

    TextField tfDetailPelangganDescAlamat;
    TextField tfDetailPelangganDescFRT;
    TextField tfDetailPelangganDescKedudukan;

    TextField tfDetailPelangganDescUnitUP;
    TextField tfDetailPelangganDescFJN;
    TextField tfDetailPelangganDescKdPPJ;

    TextField tfDetailPelangganDescUnit;
    TextField tfDetailPelangganDescAbonM;
    TextField tfDetailPelangganDescPemda;

    TextField tfDetailRupiahRpPTL;
    TextField tfDetailRupiahRpSewaTrafo;
    TextField tfDetailRupiahRpReduksi;
    TextField tfDetailRupiahRpSelisih;

    TextField tfDetailRupiahRpTB;
    TextField tfDetailRupiahRpSewaKap;
    TextField tfDetailRupiahRpInsentif;
    TextField tfDetailRupiahRpTDLLama;

    TextField tfDetailRupiahRpPPN;
    TextField tfDetailRupiahRpKdAngsARp;
    TextField tfDetailRupiahRpKdAngsAKd;
    TextField tfDetailRupiahRpDisinsentif;
    TextField tfDetailRupiahRpTDLBaru;

    TextField tfDetailRupiahRpBPJU;
    TextField tfDetailRupiahRpKdAngsBRp;
    TextField tfDetailRupiahRpKdAngsBKd;
    TextField tfDetailRupiahRpTAG;
    TextField tfDetailRupiahRpBK1;

    TextField tfDetailRupiahRpMat;
    TextField tfDetailRupiahRpKdAngsCRp;
    TextField tfDetailRupiahRpKdAngsCKd;
    TextField tfDetailRupiahRpProduksi;
    TextField tfDetailRupiahRpBK2;

    TextField tfDetailRupiahRpTrafo;
    TextField tfDetailRupiahRpPLN;
    TextField tfDetailRupiahRpSubsidi;
    TextField tfDetailRupiahRpBK3;

    TextField tfDetailkWhLWBPAwal;
    TextField tfDetailkWhLWBPAkhir;
    TextField tfDetailkWhPemakaianLWBP;
    TextField tfDetailkWhPemakaianRpLWBP;

    TextField tfDetailkWhWBPAwal;
    TextField tfDetailkWhWBPAkhir;
    TextField tfDetailkWhPemakaianWBP;
    TextField tfDetailkWhPemakaianRpBlok3;

    TextField tfDetailkWhKVArhAwal;
    TextField tfDetailkWhKVArhAkhir;
    TextField tfDetailkWhPemakaianBlok3;
    TextField tfDetailkWhPemakaianRpkVArh;

    TextField tfDetailkWhFK_kWh;
    TextField tfDetailkWhPemakaianTotal;
    TextField tfDetailkWhPemakaianRpTTLB;

    TextField tfDetailkWhFK_kVArh;
    TextField tfDetailkWhPemakaianKelb_kVArh;
    TextField tfDetailkWhPemakaianRpBeban;

    IconDynamicGrid gpData;

    TextButton bBottomReset;
    TextButton bBottomSimpan;
    TextButton bBottomCetak;

    TextField tfBottomRpTagihan;
    TextField tfBottomRpBK;

    private RequestBuilder rb;
    private Boolean wsReturn;
    private String wsByRefError;
    private IconAlertMessageBox mb;

    @Override
    protected void initEvent() {
        tfTopIdPelanggan.addKeyDownHandler(new KeyDownHandler() {
            @Override
            public void onKeyDown(KeyDownEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    if (tfTopIdPelanggan.getText().equals("")) {
                        IconAlertMessageBox mb = new IconAlertMessageBox("Kesalahan", "Masukkan ID Pelanggan", true);
                        return;
                    }

                    if (tfTopIdPelanggan.getText().length() != 12) {
                        IconAlertMessageBox mb = new IconAlertMessageBox("Kesalahan", "ID Pelanggan 12 digit", true);
                        return;
                    }

                    try {
                        rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/GetViewIdPel_31.json");
                        rb.setHeader("Content-type", "application/x-www-form-urlencoded");

                        StringBuilder sb = new StringBuilder();
                        sb.append("tpel=" + tfTopIdPelanggan.getText().trim());
                        sb.append("&vJenis="+"IdPel");
                        sb.append("&tBLTH="+"201010");
                        sb.append("&tPetugas="+getIdUser());

                        rb.sendRequest(sb.toString(), new RequestCallback() {
                            @Override
                            public void onResponseReceived(Request request, Response response) {

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

                                            GWT.log(sourceRowData.get("RPTAG").isString().stringValue());

                                            rpTag += Double.parseDouble(sourceRowData.get("RPTAG").isString().stringValue());
                                            rpBK += Double.parseDouble(sourceRowData.get("RPBK1").isString().stringValue());
                                            rpBK += Double.parseDouble(sourceRowData.get("RPBK2").isString().stringValue());
                                            rpBK += Double.parseDouble(sourceRowData.get("RPBK3").isString().stringValue());
                                        }
                                    }

                                    tfBottomRpTagihan.setValue(String.valueOf(rpTag));
                                    tfBottomRpBK.setValue(String.valueOf(rpBK));

                                } else {
                                    mb = new IconAlertMessageBox("Kesalahan", "HTTP Error code: " + response.getStatusCode(), true);
                                }
                            }

                            @Override
                            public void onError(Request request, Throwable throwable) {
                                mb = new IconAlertMessageBox("Kesalahan", throwable.getMessage(), true);
                            }
                        });
                    } catch (RequestException ex) {
                        mb = new IconAlertMessageBox("Kesalahan", ex.getMessage(), true);
                    }

                }
            }
        });

        gpData.getGrid().getSelectionModel().addSelectionChangedHandler(new SelectionChangedEvent.SelectionChangedHandler() {
            @Override
            public void onSelectionChanged(SelectionChangedEvent event) {
                HashMap<String, String> rowData = (HashMap<String, String>)event.getSelection().get(0);

                tfDetailPelangganDescIDPEL.setValue(rowData.get("IDPEL"));
                tfDetailPelangganDescNOPEL.setValue(rowData.get("NOPEL"));
                tfDetailPelangganDescAlamat.setValue(rowData.get("NAMAPNJ"));
                tfDetailPelangganDescRekBulan.setValue(rowData.get("BLTH")); //.substring(4, 2)); // + "-" + rowData.get("BLTH").substring(0, 4));
                tfDetailPelangganDescTarifDaya.setValue(rowData.get("TARIP") + " - " + rowData.get("KDPEMBTRF") + "/" + rowData.get("DAYA"));
                tfDetailPelangganDescFJN.setValue(rowData.get("FJN"));
                tfDetailPelangganDescFRT.setValue(rowData.get("FRT"));
                tfDetailPelangganDescInkaso.setValue(rowData.get("KDINKASO"));
                tfDetailPelangganDescKdPPJ.setValue(rowData.get("KDPPJ"));
                tfDetailPelangganDescKedudukan.setValue(rowData.get("KDDK"));
                tfDetailPelangganDescKelompok.setValue(rowData.get("KDKELOMPOK"));
                tfDetailPelangganDescKogol.setValue(rowData.get("KOGOL") + " - " + rowData.get("SUBKOGOL"));
                tfDetailPelangganDescNama.setValue(rowData.get("NAMA"));
                tfDetailPelangganDescPemda.setValue(rowData.get("PEMDA"));
                tfDetailPelangganDescTglJatuhTempo.setValue(rowData.get("TGLJTTEMPO")); //.substring(6, 2) + "-" + rowData.get("TglJTTEMPO").substring(4, 2) + "-" + rowData.get("TglJTTEMPO").substring(0, 4));
                tfDetailPelangganDescUnitUP.setValue(rowData.get("UNITUP"));
                tfDetailPelangganDescUnit.setValue(rowData.get("UNITKJ"));
                tfDetailPelangganDescAbonM.setValue(rowData.get("ABONMETER"));

                tfDetailkWhFK_kVArh.setValue(rowData.get("FAKMKVARH"));
                tfDetailkWhFK_kWh.setValue(rowData.get("FAKM"));

                tfDetailkWhPemakaianBlok3.setValue(rowData.get("BLOK3"));
                tfDetailkWhPemakaianLWBP.setValue(rowData.get("KWHLWBP"));
                tfDetailkWhPemakaianKelb_kVArh.setValue(rowData.get("KELBKVARH"));
                tfDetailkWhPemakaianTotal.setValue(rowData.get("PEMKWH"));
                tfDetailkWhPemakaianWBP.setValue(rowData.get("KWHWBP"));
                tfDetailkWhKVArhAkhir.setValue(rowData.get("SAHKVARH"));
                tfDetailkWhLWBPAkhir.setValue(rowData.get("SAHLWBP"));
                tfDetailkWhWBPAkhir.setValue(rowData.get("SAHWBP"));
                tfDetailkWhKVArhAwal.setValue(rowData.get("SLAKVARH"));
                tfDetailkWhLWBPAwal.setValue(rowData.get("SLALWBP"));
                tfDetailkWhWBPAwal.setValue(rowData.get("SLAWBP"));

                tfDetailkWhPemakaianRpBeban.setValue(rowData.get("RPBEBAN"));
                //tfDetailkWhPemakaianRpWBP.setValue(rowData.get("RPWBP"));
                tfDetailkWhPemakaianRpLWBP.setValue(rowData.get("RPLWBP"));
                tfDetailkWhPemakaianRpBlok3.setValue(rowData.get("RPBLOK3"));
                tfDetailkWhPemakaianRpkVArh.setValue(rowData.get("RPKVARH"));
                tfDetailkWhPemakaianRpTTLB.setValue(rowData.get("RPTTLB"));

                tfDetailRupiahRpPTL.setValue(rowData.get("RPPTL"));
                tfDetailRupiahRpTB.setValue(rowData.get("RPTB"));
                tfDetailRupiahRpPPN.setValue(rowData.get("RPPPN"));
                tfDetailRupiahRpBPJU.setValue(rowData.get("RPBPJU"));
                tfDetailRupiahRpMat.setValue(rowData.get("RPMAT"));
                tfDetailRupiahRpTrafo.setValue(rowData.get("RPTRAFO"));
                tfDetailRupiahRpSewaTrafo.setValue(rowData.get("RPSEWATRAFO"));
                tfDetailRupiahRpSewaKap.setValue(rowData.get("RPSEWAKAP"));
                tfDetailRupiahRpKdAngsARp.setValue(rowData.get("RPANGSA"));
                tfDetailRupiahRpKdAngsBRp.setValue(rowData.get("RPANGSB"));
                tfDetailRupiahRpKdAngsCRp.setValue(rowData.get("RPANGSC"));
                tfDetailRupiahRpPLN.setValue(rowData.get("RPPLN"));
                tfDetailRupiahRpReduksi.setValue(rowData.get("RPREDUKSI"));
                tfDetailRupiahRpInsentif.setValue(rowData.get("RPINSENTIF"));
                tfDetailRupiahRpDisinsentif.setValue(rowData.get("RPDISINSENTIF"));
                tfDetailRupiahRpTAG.setValue(rowData.get("RPTAG"));
                tfDetailRupiahRpProduksi.setValue(rowData.get("RPPRODUKSI"));
                tfDetailRupiahRpSubsidi.setValue(rowData.get("RPSUBSIDI"));
                tfDetailRupiahRpSelisih.setValue(rowData.get("RPSELISIH"));
                tfDetailRupiahRpTDLLama.setValue(rowData.get("RPTDLLAMA"));
                tfDetailRupiahRpTDLBaru.setValue(rowData.get("RPTDLBARU"));
                tfDetailRupiahRpBK1.setValue(rowData.get("RPBK1"));
                tfDetailRupiahRpBK2.setValue(rowData.get("RPBK2"));
                tfDetailRupiahRpBK3.setValue(rowData.get("RPBK3"));

                tfDetailRupiahRpKdAngsAKd.setValue(rowData.get("KDANSGA"));
                tfDetailRupiahRpKdAngsBKd.setValue(rowData.get("KDANSGB"));
                tfDetailRupiahRpKdAngsCKd.setValue(rowData.get("KDANSGC"));
            }
        });

        bBottomReset.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                gpData.getGrid().getStore().clear();
                tfTopIdPelanggan.setValue("");

                tfDetailPelangganDescIDPEL.setValue("");
                tfDetailPelangganDescNOPEL.setValue("");
                tfDetailPelangganDescAlamat.setValue("");
                tfDetailPelangganDescRekBulan.setValue("");
                tfDetailPelangganDescTarifDaya.setValue("");
                tfDetailPelangganDescFJN.setValue("");
                tfDetailPelangganDescFRT.setValue("");
                tfDetailPelangganDescInkaso.setValue("");
                tfDetailPelangganDescKdPPJ.setValue("");
                tfDetailPelangganDescKedudukan.setValue("");
                tfDetailPelangganDescKelompok.setValue("");
                tfDetailPelangganDescKogol.setValue("");
                tfDetailPelangganDescNama.setValue("");
                tfDetailPelangganDescPemda.setValue("");
                tfDetailPelangganDescTglJatuhTempo.setValue("");
                tfDetailPelangganDescUnitUP.setValue("");
                tfDetailPelangganDescUnit.setValue("");
                tfDetailPelangganDescAbonM.setValue("");

                tfDetailkWhFK_kVArh.setValue("");
                tfDetailkWhFK_kWh.setValue("");

                tfDetailkWhPemakaianBlok3.setValue("");
                tfDetailkWhPemakaianLWBP.setValue("");
                tfDetailkWhPemakaianKelb_kVArh.setValue("");
                tfDetailkWhPemakaianTotal.setValue("");
                tfDetailkWhPemakaianWBP.setValue("");
                tfDetailkWhKVArhAkhir.setValue("");
                tfDetailkWhLWBPAkhir.setValue("");
                tfDetailkWhWBPAkhir.setValue("");
                tfDetailkWhKVArhAwal.setValue("");
                tfDetailkWhLWBPAwal.setValue("");
                tfDetailkWhWBPAwal.setValue("");

                tfDetailkWhPemakaianRpBeban.setValue("");
                //tfDetailkWhPemakaianRpWBP.setValue("RPWBP");
                tfDetailkWhPemakaianRpLWBP.setValue("");
                tfDetailkWhPemakaianRpBlok3.setValue("");
                tfDetailkWhPemakaianRpkVArh.setValue("");
                tfDetailkWhPemakaianRpTTLB.setValue("");

                tfDetailRupiahRpPTL.setValue("");
                tfDetailRupiahRpTB.setValue("");
                tfDetailRupiahRpPPN.setValue("");
                tfDetailRupiahRpBPJU.setValue("");
                tfDetailRupiahRpMat.setValue("");
                tfDetailRupiahRpTrafo.setValue("");
                tfDetailRupiahRpSewaTrafo.setValue("");
                tfDetailRupiahRpSewaKap.setValue("");
                tfDetailRupiahRpKdAngsARp.setValue("");
                tfDetailRupiahRpKdAngsBRp.setValue("");
                tfDetailRupiahRpKdAngsCRp.setValue("");
                tfDetailRupiahRpPLN.setValue("");
                tfDetailRupiahRpReduksi.setValue("");
                tfDetailRupiahRpInsentif.setValue("");
                tfDetailRupiahRpDisinsentif.setValue("");
                tfDetailRupiahRpTAG.setValue("");
                tfDetailRupiahRpProduksi.setValue("");
                tfDetailRupiahRpSubsidi.setValue("");
                tfDetailRupiahRpSelisih.setValue("");
                tfDetailRupiahRpTDLLama.setValue("");
                tfDetailRupiahRpTDLBaru.setValue("");
                tfDetailRupiahRpBK1.setValue("");
                tfDetailRupiahRpBK2.setValue("");
                tfDetailRupiahRpBK3.setValue("");

                tfDetailRupiahRpKdAngsAKd.setValue("");
                tfDetailRupiahRpKdAngsBKd.setValue("");
                tfDetailRupiahRpKdAngsCKd.setValue("");
            }
        });

        bBottomSimpan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {

                JSONObject jsonObjectSendData = new JSONObject();
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

                jsonObjectSendData.put("strData", jsonArray);

                try {
                    rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/SetDataIdpel_31.json");
                    rb.setHeader("Content-type", "application/x-www-form-urlencoded");

                    StringBuilder sb = new StringBuilder();
                    sb.append("lbrproses=" + "0");
                    sb.append("&tTransaksiBy="+getIdUser());
                    sb.append("&strData="+jsonArray);

                    rb.sendRequest(sb.toString(), new RequestCallback() {
                        @Override
                        public void onResponseReceived(Request request, Response response) {

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
                            mb = new IconAlertMessageBox("Kesalahan", throwable.getMessage(), true);
                        }
                    });
                } catch (RequestException ex) {
                    mb = new IconAlertMessageBox("Kesalahan", ex.getMessage(), true);
                }

            }
        });

        bBottomCetak.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {

            }
        });
    }

    protected FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Pembatalan Piutang (31)");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(800);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        FieldSet fieldSet = new FieldSet();
        fieldSet.setHeadingText("");

        VerticalLayoutContainer FieldAtas = new VerticalLayoutContainer();
        fieldSet.add(FieldAtas);

        tfTopIdPelanggan = new TextField();
        FieldAtas.add(new FieldLabel(tfTopIdPelanggan, "ID Pelanggan"));

        p.add(fieldSet);

        //TabPanel
        TabPanel tabs = new TabPanel();
        VerticalLayoutContainer VTab = new VerticalLayoutContainer();
        VTab.setLayoutData(new MarginData(8));

        tabs.add(VTab, "Detail Pelanggan");

        tfDetailPelangganDescIDPEL = new TextField();
        tfDetailPelangganDescIDPEL.setWidth(80);
        tfDetailPelangganDescRekBulan = new TextField();
        tfDetailPelangganDescRekBulan.setWidth(80);
        tfDetailPelangganDescTarifDaya = new TextField();
        tfDetailPelangganDescTarifDaya.setWidth(80);

        //Tab 1
        HBoxLayoutContainer hp1 = new HBoxLayoutContainer();
        hp1.add(new FieldLabel(tfDetailPelangganDescIDPEL, "tfTopIdPelanggan"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tfDetailPelangganDescRekBulan, "REK Bulan"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tfDetailPelangganDescTarifDaya, "Tarif/Daya"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        tfDetailPelangganDescNOPEL = new TextField();
        tfDetailPelangganDescNOPEL.setWidth(80);
        tfDetailPelangganDescKelompok = new TextField();
        tfDetailPelangganDescKelompok.setWidth(80);
        tfDetailPelangganDescKogol = new TextField();
        tfDetailPelangganDescKogol.setWidth(80);
        hp1.add(new FieldLabel(tfDetailPelangganDescNOPEL, "NOPEL"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tfDetailPelangganDescKelompok, "Kelompok"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tfDetailPelangganDescKogol, "Kogol"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        tfDetailPelangganDescNama = new TextField();
        tfDetailPelangganDescNama.setWidth(80);
        tfDetailPelangganDescTglJatuhTempo = new TextField();
        tfDetailPelangganDescTglJatuhTempo.setWidth(80);
        tfDetailPelangganDescInkaso = new TextField();
        tfDetailPelangganDescInkaso.setWidth(80);
        hp1.add(new FieldLabel(tfDetailPelangganDescNama, "Nama"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tfDetailPelangganDescTglJatuhTempo, "Tgl Jatuh Tempo"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tfDetailPelangganDescInkaso, "Inkaso"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        tfDetailPelangganDescAlamat = new TextField();
        tfDetailPelangganDescAlamat.setWidth(80);
        tfDetailPelangganDescFRT = new TextField();
        tfDetailPelangganDescFRT.setWidth(80);
        tfDetailPelangganDescKedudukan = new TextField();
        tfDetailPelangganDescKedudukan.setWidth(80);
        hp1.add(new FieldLabel(tfDetailPelangganDescAlamat, "Alamat"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tfDetailPelangganDescFRT, "FRT"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tfDetailPelangganDescKedudukan, "Kendudukan"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        tfDetailPelangganDescUnitUP = new TextField();
        tfDetailPelangganDescUnitUP.setWidth(80);
        tfDetailPelangganDescFJN = new TextField();
        tfDetailPelangganDescFJN.setWidth(80);
        tfDetailPelangganDescKdPPJ = new TextField();
        tfDetailPelangganDescKdPPJ.setWidth(80);
        hp1.add(new FieldLabel(tfDetailPelangganDescUnitUP, "Unit UP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tfDetailPelangganDescFJN, "FJN"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tfDetailPelangganDescKdPPJ, "KDPPJ"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        hp1 = new HBoxLayoutContainer();
        tfDetailPelangganDescUnit = new TextField();
        tfDetailPelangganDescUnit.setWidth(80);
        tfDetailPelangganDescAbonM = new TextField();
        tfDetailPelangganDescAbonM.setWidth(80);
        tfDetailPelangganDescPemda = new TextField();
        tfDetailPelangganDescPemda.setWidth(80);
        hp1.add(new FieldLabel(tfDetailPelangganDescUnit, "Unit"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tfDetailPelangganDescAbonM, "AbonM"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(new FieldLabel(tfDetailPelangganDescPemda, "Pemda"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp1);

        VTab = new VerticalLayoutContainer();
        VTab.setLayoutData(new MarginData(8));

        tabs.add(VTab, "Detail Rupiah");

        tfDetailRupiahRpPTL = new TextField();
        tfDetailRupiahRpPTL.setWidth(70);
        tfDetailRupiahRpSewaTrafo = new TextField();
        tfDetailRupiahRpSewaTrafo.setWidth(70);
        tfDetailRupiahRpReduksi = new TextField();
        tfDetailRupiahRpReduksi.setWidth(70);
        tfDetailRupiahRpSelisih = new TextField();
        tfDetailRupiahRpSelisih.setWidth(70);

        //Tab 2
        HBoxLayoutContainer hp2 = new HBoxLayoutContainer();
        hp2.add(new FieldLabel(tfDetailRupiahRpPTL, "Rp PTL"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpSewaTrafo, "Rp Sewa Trafo"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpReduksi, "Rp Reduksi"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpSelisih, "Rp Selisih"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        hp2 = new HBoxLayoutContainer();
        tfDetailRupiahRpTB = new TextField();
        tfDetailRupiahRpTB.setWidth(70);
        tfDetailRupiahRpSewaKap = new TextField();
        tfDetailRupiahRpSewaKap.setWidth(70);
        tfDetailRupiahRpInsentif = new TextField();
        tfDetailRupiahRpInsentif.setWidth(70);
        tfDetailRupiahRpTDLLama = new TextField();
        tfDetailRupiahRpTDLLama.setWidth(70);
        hp2.add(new FieldLabel(tfDetailRupiahRpTB, "Rp TB"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpSewaKap, "Rp Sewa Kap"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpInsentif, "Rp Insentif"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpTDLLama, "Rp TDL Lama"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        hp2 = new HBoxLayoutContainer();
        tfDetailRupiahRpPPN = new TextField();
        tfDetailRupiahRpPPN.setWidth(70);
        tfDetailRupiahRpKdAngsARp = new TextField();
        tfDetailRupiahRpKdAngsARp.setWidth(45);
        tfDetailRupiahRpKdAngsAKd = new TextField();
        tfDetailRupiahRpKdAngsAKd.setWidth(20);
        tfDetailRupiahRpDisinsentif = new TextField();
        tfDetailRupiahRpDisinsentif.setWidth(70);
        tfDetailRupiahRpTDLBaru = new TextField();
        tfDetailRupiahRpTDLBaru.setWidth(70);
        hp2.add(new FieldLabel(tfDetailRupiahRpPPN, "Rp PPN"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpKdAngsARp, "Rp/Kd Angs A"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(tfDetailRupiahRpKdAngsAKd, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpDisinsentif, "Rp DisInsentif"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpTDLBaru, "Rp TDL Baru"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        hp2 = new HBoxLayoutContainer();
        tfDetailRupiahRpBPJU = new TextField();
        tfDetailRupiahRpBPJU.setWidth(70);
        tfDetailRupiahRpKdAngsBRp = new TextField();
        tfDetailRupiahRpKdAngsBRp.setWidth(45);
        tfDetailRupiahRpKdAngsBKd = new TextField();
        tfDetailRupiahRpKdAngsBKd.setWidth(20);
        tfDetailRupiahRpTAG = new TextField();
        tfDetailRupiahRpTAG.setWidth(70);
        tfDetailRupiahRpBK1 = new TextField();
        tfDetailRupiahRpBK1.setWidth(70);
        hp2.add(new FieldLabel(tfDetailRupiahRpBPJU, "Rp BPJU"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpKdAngsBRp, "Rp/Kd Angs B"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(tfDetailRupiahRpKdAngsBKd, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpTAG, "Rp TAG"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpBK1, "Rp BK 1"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        hp2 = new HBoxLayoutContainer();
        tfDetailRupiahRpMat = new TextField();
        tfDetailRupiahRpMat.setWidth(70);
        tfDetailRupiahRpKdAngsCRp = new TextField();
        tfDetailRupiahRpKdAngsCRp.setWidth(45);
        tfDetailRupiahRpKdAngsCKd = new TextField();
        tfDetailRupiahRpKdAngsCKd.setWidth(20);
        tfDetailRupiahRpProduksi = new TextField();
        tfDetailRupiahRpProduksi.setWidth(70);
        tfDetailRupiahRpBK2 = new TextField();
        tfDetailRupiahRpBK2.setWidth(70);
        hp2.add(new FieldLabel(tfDetailRupiahRpMat, "Rp Mat"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpKdAngsCRp, "Rp/Kd Angs C"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(tfDetailRupiahRpKdAngsCKd, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpProduksi, "Rp Produksi"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpBK2, "Rp BK 2"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        hp2 = new HBoxLayoutContainer();
        tfDetailRupiahRpTrafo = new TextField();
        tfDetailRupiahRpTrafo.setWidth(70);
        tfDetailRupiahRpPLN = new TextField();
        tfDetailRupiahRpPLN.setWidth(70);
        tfDetailRupiahRpSubsidi = new TextField();
        tfDetailRupiahRpSubsidi.setWidth(70);
        tfDetailRupiahRpBK3 = new TextField();
        tfDetailRupiahRpBK3.setWidth(70);
        hp2.add(new FieldLabel(tfDetailRupiahRpTrafo, "Rp Trafo"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpPLN, "Rp PLN"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpSubsidi, "Rp Subsidi"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp2.add(new FieldLabel(tfDetailRupiahRpBK3, "Rp BK 3"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp2);

        VTab = new VerticalLayoutContainer();
        VTab.setLayoutData(new MarginData(8));

        tabs.add(VTab, "Detail Kwh");

        Label Awal = new Label("St. Awal");
        Label Awal1 = new Label("St. Akhir");
        Label Awal2 = new Label("Pemakaian");
        tfDetailkWhPemakaianRpBlok3 = new TextField();
        tfDetailkWhPemakaianRpBlok3.setWidth(70);

        //Tab 3
        HBoxLayoutContainer hp3 = new HBoxLayoutContainer();
        hp3.add(Awal, new BoxLayoutData(new Margins(0, 5, 0, 110)));
        hp3.add(Awal1, new BoxLayoutData(new Margins(0, 5, 0, 18)));
        hp3.add(Awal2, new BoxLayoutData(new Margins(0, 5, 0, 120)));
        hp3.add(new FieldLabel(tfDetailkWhPemakaianRpBlok3, "Rp WBP"), new BoxLayoutData(new Margins(0, 5, 0, 7)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        tfDetailkWhLWBPAwal = new TextField();
        tfDetailkWhLWBPAwal.setWidth(70);
        tfDetailkWhLWBPAkhir = new TextField();
        tfDetailkWhLWBPAkhir.setWidth(70);
        tfDetailkWhPemakaianLWBP = new TextField();
        tfDetailkWhPemakaianLWBP.setWidth(70);
        tfDetailkWhPemakaianRpLWBP = new TextField();
        tfDetailkWhPemakaianRpLWBP.setWidth(70);
        hp3.add(new FieldLabel(tfDetailkWhLWBPAwal, "LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(tfDetailkWhLWBPAkhir, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tfDetailkWhPemakaianLWBP, "LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tfDetailkWhPemakaianRpLWBP, "Rp LWBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        tfDetailkWhWBPAwal = new TextField();
        tfDetailkWhWBPAwal.setWidth(70);
        tfDetailkWhWBPAkhir = new TextField();
        tfDetailkWhWBPAkhir.setWidth(70);
        tfDetailkWhPemakaianWBP = new TextField();
        tfDetailkWhPemakaianWBP.setWidth(70);
        tfDetailkWhPemakaianRpBlok3 = new TextField();
        tfDetailkWhPemakaianRpBlok3.setWidth(70);
        hp3.add(new FieldLabel(tfDetailkWhWBPAwal, "WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(tfDetailkWhWBPAkhir, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tfDetailkWhPemakaianWBP, "WBP"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tfDetailkWhPemakaianRpBlok3, "Rp Blok 3"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        tfDetailkWhKVArhAwal = new TextField();
        tfDetailkWhKVArhAwal.setWidth(70);
        tfDetailkWhKVArhAkhir = new TextField();
        tfDetailkWhKVArhAkhir.setWidth(70);
        tfDetailkWhPemakaianBlok3 = new TextField();
        tfDetailkWhPemakaianBlok3.setWidth(70);
        tfDetailkWhPemakaianRpkVArh = new TextField();
        tfDetailkWhPemakaianRpkVArh.setWidth(70);
        hp3.add(new FieldLabel(tfDetailkWhKVArhAwal, "KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(tfDetailkWhKVArhAkhir, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tfDetailkWhPemakaianBlok3, "Blok 3"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tfDetailkWhPemakaianRpkVArh, "Rp KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        hp3 = new HBoxLayoutContainer();
        tfDetailkWhFK_kWh = new TextField();
        tfDetailkWhFK_kWh.setWidth(70);
        tfDetailkWhPemakaianTotal = new TextField();
        tfDetailkWhPemakaianTotal.setWidth(70);
        tfDetailkWhPemakaianRpTTLB = new TextField();
        tfDetailkWhPemakaianRpTTLB.setWidth(70);
        hp3.add(new FieldLabel(tfDetailkWhFK_kWh, "FK Kwh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tfDetailkWhPemakaianTotal, "Total"), new BoxLayoutData(new Margins(0, 5, 0, 75)));
        hp3.add(new FieldLabel(tfDetailkWhPemakaianRpTTLB, "TTLB"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);


        hp3 = new HBoxLayoutContainer();
        tfDetailkWhFK_kVArh = new TextField();
        tfDetailkWhFK_kVArh.setWidth(70);
        tfDetailkWhPemakaianKelb_kVArh = new TextField();
        tfDetailkWhPemakaianKelb_kVArh.setWidth(70);
        tfDetailkWhPemakaianRpBeban = new TextField();
        tfDetailkWhPemakaianRpBeban.setWidth(70);
        hp3.add(new FieldLabel(tfDetailkWhFK_kVArh, "FK KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp3.add(new FieldLabel(tfDetailkWhPemakaianKelb_kVArh, "Kelb KvArh"), new BoxLayoutData(new Margins(0, 5, 0, 75)));
        hp3.add(new FieldLabel(tfDetailkWhPemakaianRpBeban, "Rp Beban"), new BoxLayoutData(new Margins(0, 5, 0, 0)));
        VTab.add(hp3);

        p.add(tabs);

        //Grid
        gpData = new IconDynamicGrid();
        gpData.setGridHeader("Data Tagihan");
        gpData.setGridDimension(768, 200);
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

        tfBottomRpTagihan = new TextField();
        tfBottomRpBK = new TextField();

        HBoxLayoutContainer hp0 = new HBoxLayoutContainer();
        hp0.add(new FieldLabel(tfBottomRpTagihan, "RP Tagihan"));
        hp0.add(bBottomReset, new BoxLayoutData(new Margins(0, 5, 0, 20)));
        hp0.add(bBottomSimpan, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp0.add(bBottomCetak, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        FieldBawah.add(hp0);

        hp0 = new HBoxLayoutContainer();
        hp0.add(new FieldLabel(tfBottomRpBK, "RP BK"));
        FieldBawah.add(hp0);
        p.add(fieldSet1);

        return panel;
    }
}
