package id.co.hans.sample.client.form.proses;

import com.google.gwt.dom.client.Style;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.AbstractForm;
import id.co.hans.sample.client.components.ComboKodePP;
import id.co.hans.sample.client.components.ComboNotaBukuUnitUPiBebanKantor;
import id.co.hans.sample.client.components.IconAlertMessageBox;
import id.co.hans.sample.client.components.IconComboBox;
import id.co.hans.sample.client.components.IconDynamicGrid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Form_23AnggotaNotaBuku extends AbstractForm {

    ComboNotaBukuUnitUPiBebanKantor cbPilihKode;
    Radio radioIdpelTambah;
    TextField txIdpelTambah;
    Radio radioNopelTambah;
    TextField txNopelTambah;
    TextArea txket;
    TextButton btnTambah;

    Radio radioIdpelHapus;
    TextField txIdpelHapus;
    Radio radioNopeHapus;
    TextField txNopelHapus;
    TextButton btnHapus;

    TextField txtNamaKode;
    TextButton btnTampilData;

    IconDynamicGrid gpData;

    private String sLabel = "";

    private RequestBuilder rb;
    private String wsReturn;
    private String wsByRefError;
    private IconAlertMessageBox mb;

    String strIdPel = "";
    String strNoPel = "";

    protected FramedPanel panelMain() {

        if (getIBebanKantor() == 0)
            sLabel = "Nota Buku";
        else if (getIBebanKantor() == 1)
            sLabel = "Beban Kantor";
        else if (getIBebanKantor() == 2)
            sLabel = "Memo DUPR";
        else if (getIBebanKantor() == 3)
            sLabel = "Bayar di Muka";

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Anggota " + sLabel);
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);


        // panel "Anggota Nota Buku"
        FramedPanel panelAnggotaNotaBuku = new FramedPanel();
        panelAnggotaNotaBuku.setHeadingText("Manajemen Anggota Kode " + sLabel);
        panelAnggotaNotaBuku.setBodyStyle("background: none; padding: 5px");
        panelAnggotaNotaBuku.setWidth(623);
        panelAnggotaNotaBuku.setHeight(250);

        VerticalLayoutContainer vlcAnggotaNotaBuku = new VerticalLayoutContainer();
        panelAnggotaNotaBuku.add(vlcAnggotaNotaBuku);

        HorizontalPanel hlcAnggotaNotaBuku = new HorizontalPanel();

        cbPilihKode = new ComboNotaBukuUnitUPiBebanKantor();
        cbPilihKode.setLabelCombo("Kode " + sLabel);
        cbPilihKode.setUnitUp(getUnitupUser());
        cbPilihKode.setIBebanKantor(String.valueOf(getIBebanKantor()));
        hlcAnggotaNotaBuku.add(cbPilihKode);

        btnTampilData = new TextButton("Tampil Data");
        hlcAnggotaNotaBuku.add(btnTampilData);

        vlcAnggotaNotaBuku.add(hlcAnggotaNotaBuku, new VerticalLayoutContainer.VerticalLayoutData(-1,1));

        HorizontalPanel hlcNota = new HorizontalPanel();

        // panel " tambah data"
        FramedPanel panelTambahData = new FramedPanel();
        panelTambahData.setHeadingText("Tambah Data");
        panelTambahData.setBodyStyle("background: none; padding: 5px");

        hlcNota.add(panelTambahData);

        VerticalLayoutContainer vlcTambahData= new VerticalLayoutContainer();

        HorizontalPanel hlcIdpelTambah = new HorizontalPanel();
        radioIdpelTambah = new Radio();
        radioIdpelTambah.setWidth(105);
        radioIdpelTambah.setBoxLabel("ID Pelanggan");
        hlcIdpelTambah.add(radioIdpelTambah);

        txIdpelTambah = new TextField();
        hlcIdpelTambah.add(txIdpelTambah);
        vlcTambahData.add(hlcIdpelTambah);

        HorizontalPanel hlcNopelTambah = new HorizontalPanel();
        radioNopelTambah = new Radio();
        radioNopelTambah.setWidth(105);
        radioNopelTambah.setBoxLabel("No Pelanggan");
        hlcNopelTambah.add(radioNopelTambah);

        txNopelTambah = new TextField();
        hlcNopelTambah.add(txNopelTambah);

        vlcTambahData.add(hlcNopelTambah);

        txket= new TextArea();

        vlcTambahData.add(new FieldLabel(txket, "Keterangan"), new VerticalLayoutContainer.VerticalLayoutData(1, 50));

        btnTambah = new TextButton("Tambah");
        vlcTambahData.add(btnTambah);

        panelTambahData.add(vlcTambahData);

        hlcNota.add(panelTambahData);

        // panel " hapus data"
        FramedPanel panelHapusData = new FramedPanel();
        panelHapusData.setHeadingText("Hapus Data");
        panelHapusData.setBodyStyle("background: none; padding: 5px");

        VerticalLayoutContainer vlcHapusData= new VerticalLayoutContainer();

        HorizontalPanel hlcIdpelHapus = new HorizontalPanel();
        radioIdpelHapus = new Radio();
        radioIdpelHapus.setWidth(105);
        radioIdpelHapus.setBoxLabel("ID Pelanggan");
        hlcIdpelHapus.add(radioIdpelHapus);

        txIdpelHapus = new TextField();
        hlcIdpelHapus.add(txIdpelHapus);
        vlcHapusData.add(hlcIdpelHapus);

        HorizontalPanel hlcNopelHapus = new HorizontalPanel();

        radioNopeHapus = new Radio();
        radioNopeHapus.setWidth(105);
        radioNopeHapus.setBoxLabel("No Pelanggan");
        hlcNopelHapus.add(radioNopeHapus);

        txNopelHapus = new TextField();
        hlcNopelHapus.add(txNopelHapus);

        vlcHapusData.add(hlcNopelHapus);

        btnHapus = new TextButton("Hapus");
        vlcHapusData.add(btnHapus);

        panelHapusData.add(vlcHapusData);

        Label separator = new Label();
        separator.setPixelSize(10, 1);

        hlcNota.add(separator);
        hlcNota.add(panelHapusData);

        vlcAnggotaNotaBuku.add(hlcNota);

        p.add(panelAnggotaNotaBuku);


        // panel "Data"

        gpData = new IconDynamicGrid();
        gpData.setGridHeader("Data Master");
        gpData.setGridDimension(623, 200);
        gpData.setStoreUrl("BasicProject/dummy.json");
        gpData.addColumn("IDPEL", 100);
        gpData.addColumn("NOPEL", 100);
        gpData.addColumn("NAMA", 100);
        gpData.addColumn("NAMAPNJ", 100);
        gpData.addColumn("TARIP", 100);
        gpData.addColumn("DAYA", 100);
        gpData.addColumn("KOGOL", 100);
        gpData.addColumn("KDKELOMPOK", 100);

        p.add(gpData);

        ToggleGroup tg1 = new ToggleGroup();
        tg1.add(radioIdpelTambah);
        tg1.add(radioNopelTambah);
        radioIdpelTambah.setValue(true);

        ToggleGroup tg2 = new ToggleGroup();
        tg2.add(radioIdpelHapus);
        tg2.add(radioNopeHapus);
        radioIdpelHapus.setValue(true);

        return panel;
    }

    @Override
    protected void initEvent() {
        btnTambah.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                try {

                    if (cbPilihKode.getSelectedValue().equals("")) {
                        mb = new IconAlertMessageBox("Kesalahan", "Kode kolektif belum dipilih", true);
                        return;
                    }

                    progressBox.show();

                    if (radioNopelTambah.getValue())
                        rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/GetDataNoPelDil.json");
                    else
                        rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/GetDataIdPelDil.json");


                    rb.setHeader("Content-type", "application/x-www-form-urlencoded");

                    StringBuilder sb = new StringBuilder();

                    if (radioNopelTambah.getValue())
                        sb.append("tNopel=" + txNopelTambah.getText());
                    else
                        sb.append("tidpel=" + txIdpelTambah.getText());


                    // ***** send request
                    rb.sendRequest(sb.toString(), new RequestCallback() {
                        @Override
                        public void onResponseReceived(Request request, Response response) {
                            if (200 == response.getStatusCode()) {
                                JSONValue value = JSONParser.parse(response.getText());
                                JSONObject jsonObject = value.isObject();

                                wsByRefError = jsonObject.get("result").isObject().get("wsByRefError").isString().stringValue();

                                if (!wsByRefError.equals("")) {
                                    progressBox.hide();
                                    mb = new IconAlertMessageBox("Kesalahan", wsByRefError, true);
                                    return;
                                }

                                JSONArray array = jsonObject.get("result").isObject().get("wsReturn").isArray();
                                if(array.size() == 0) {
                                    progressBox.hide();
                                    mb = new IconAlertMessageBox("Kesalahan", "Tidak ditemukan data Pelanggan tersebut.", true);
                                    return;
                                }


                                List<Map<String, String>> datas = new ArrayList<Map<String, String>>();
                                Map<String, String> rowData;

                                if (jsonObject.get("result").isObject().containsKey("wsReturn")) {

                                    for (int idx = 0; idx < 1; idx++) {
                                        rowData = new HashMap<String, String>();

                                        JSONObject sourceRowData = array.get(idx).isObject();

                                        for (Object obj : sourceRowData.keySet()) {
                                            rowData.put(obj.toString().toUpperCase(), sourceRowData.get(obj.toString()).isString().stringValue());
                                        }
                                        datas.add(rowData);
                                    }
                                }

                                strNoPel = datas.get(0).get("nopel");

                                if (radioNopelTambah.getValue())
                                    strIdPel = datas.get(0).get("idpel");
                                else
                                    strIdPel = txIdpelTambah.getValue();

                                cekDataIdpelDPP(strIdPel);
                            } else {
                                progressBox.hide();
                                mb = new IconAlertMessageBox("Kesalahan", "HTTP Error code: " + response.getStatusCode(), true);
                                return;
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

        btnHapus.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                final ConfirmMessageBox cmb = new ConfirmMessageBox("Hapus ?", "Anda yakin menghapus pelanggan tersebut..??");
                cmb.addHideHandler(new HideEvent.HideHandler() {
                    @Override
                    public void onHide(HideEvent event) {
                        if (cmb.getHideButton() == cmb.getButtonById(Dialog.PredefinedButton.YES.name())) {
                            deleteRecord();
                        } else if (cmb.getHideButton() == cmb.getButtonById(Dialog.PredefinedButton.NO.name())) {
                            mb = new IconAlertMessageBox("Kesalahan", "Batal Hapus", true);
                        }
                    }
                });
                cmb.show();
            }
        });

        btnTampilData.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                try {

                    progressBox.show();

                    rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/GetDataIdPelNotaBuku.json");
                    rb.setHeader("Content-type", "application/x-www-form-urlencoded");

                    StringBuilder sb = new StringBuilder();
                    sb.append("tkodekolektif=" + cbPilihKode.getSelectedValue());

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

    private void cekDataIdpelDPP(String idPel) {
        try {

            progressBox.show();

            rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/GetDataIdPelDPP.json");
            rb.setHeader("Content-type", "application/x-www-form-urlencoded");

            StringBuilder sb = new StringBuilder();
            sb.append("tidpel=" + idPel);


            // ***** send request
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

                        JSONArray array = jsonObject.get("result").isObject().get("wsReturn").isArray();
                        if (array.size() != 0) {
                            mb = new IconAlertMessageBox("Kesalahan", "Id Pelanggan sudah ada di kolektif lain", true);
                            progressBox.hide();
                            return;
                        } else {
                            simpanDataIdPel();
                        }

                        //mb = new IconAlertMessageBox("Hasil", wsReturn, true);
                    } else {
                        progressBox.hide();
                        mb = new IconAlertMessageBox("Kesalahan", "HTTP Error code: " + response.getStatusCode(), true);
                        return;
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


    private void simpanDataIdPel() {
        try {

            progressBox.show();

            rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/simpandatapel.json");
            rb.setHeader("Content-type", "application/x-www-form-urlencoded");

            StringBuilder sb = new StringBuilder();
            sb.append("&tidpel=" + strIdPel);
            sb.append("&tKdKolektif=" + cbPilihKode.getSelectedValue());
            sb.append("&ket=" + txket.getValue());
            sb.append("&Atransaksiby=" + getIdUser());
            sb.append("&Atgl_transaksi=" + "");
            sb.append("&tNopel=" + strNoPel);

            // ***** send request
            rb.sendRequest(sb.toString(), new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    if (200 == response.getStatusCode()) {
                        JSONValue value = JSONParser.parse(response.getText());
                        JSONObject jsonObject = value.isObject();

                        wsByRefError = jsonObject.get("result").isObject().get("wsByRefError").isString().stringValue();

                        if (!wsByRefError.equals("")) {
                            progressBox.hide();
                            mb = new IconAlertMessageBox("Kesalahan", wsByRefError, true);
                            return;
                        }

                        wsReturn = jsonObject.get("result").isObject().get("wsReturn").isString().stringValue();

                        if (!wsReturn.equals("true")) {
                            progressBox.hide();
                            mb = new IconAlertMessageBox("Kesalahan", "Pelanggan gagal disimpan", true);
                            return;
                        } else {
                            progressBox.hide();
                            mb = new IconAlertMessageBox("Informasi", "Pelanggan berhasil disimpan", true);
                            getDataIdPelNotaBuku();
                        }

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


    private void getDataIdPelNotaBuku() {
        try {

            progressBox.show();

            rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/GetDataIdPelNotaBuku.json");
            rb.setHeader("Content-type", "application/x-www-form-urlencoded");

            StringBuilder sb = new StringBuilder();
            sb.append("tkodekolektif=" + cbPilihKode.getSelectedValue());

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

    private void deleteRecord() {
        try {

            if (cbPilihKode.getSelectedValue().equals("")) {
                mb = new IconAlertMessageBox("Kesalahan", "Kode kolektif belum dipilih", true);
                return;
            }

            progressBox.show();

            if (radioNopelTambah.getValue())
                rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/GetDataNoPelDil.json");
            else
                rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/GetDataIdPelDil.json");


            rb.setHeader("Content-type", "application/x-www-form-urlencoded");

            StringBuilder sb = new StringBuilder();

            if (radioNopelTambah.getValue())
                sb.append("tNopel=" + txNopelTambah.getText());
            else
                sb.append("tidpel=" + txIdpelTambah.getText());


            // ***** send request
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

                        List<Map<String, String>> datas = new ArrayList<Map<String, String>>();
                        Map<String, String> rowData;

                        JSONArray array = jsonObject.get("result").isObject().get("wsReturn").isArray();

                        if (array.size() == 0) {
                            progressBox.hide();
                            mb = new IconAlertMessageBox("Kesalahan", "Pelanggan tidak ditemukan", true);
                            return;
                        }

                        for (int idx = 0; idx < 1; idx++) {
                            rowData = new HashMap<String, String>();

                            JSONObject sourceRowData = array.get(idx).isObject();

                            for (Object obj : sourceRowData.keySet()) {
                                rowData.put(obj.toString().toUpperCase(), sourceRowData.get(obj.toString()).isString().stringValue());
                            }
                            datas.add(rowData);
                        }

                        if (radioNopelTambah.getValue())
                            strIdPel = datas.get(0).get("idpel");
                        else
                            strIdPel = txIdpelTambah.getValue();

                        getDataValidasiKolektifNotaBuku();
                    } else {
                        progressBox.hide();
                        mb = new IconAlertMessageBox("Kesalahan", "HTTP Error code: " + response.getStatusCode(), true);
                        return;
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

    private void getDataValidasiKolektifNotaBuku() {
        try {
            progressBox.show();

            rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/GetDataValidasiKolektifNotaBuku.json");
            rb.setHeader("Content-type", "application/x-www-form-urlencoded");

            StringBuilder sb = new StringBuilder();
            sb.append("&tKdKolektif=" + cbPilihKode.getSelectedValue());
            sb.append("&tidpel=" + strIdPel);

            // ***** send request
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

                        List<Map<String, String>> datas = new ArrayList<Map<String, String>>();
                        Map<String, String> rowData;

                        JSONArray array = jsonObject.get("result").isObject().get("wsReturn").isArray();

                        if (array.size() == 0) {
                            progressBox.hide();
                            mb = new IconAlertMessageBox("Kesalahan", "Pelanggan tidak ada di daftar kolektif ini.", true);
                        } else {
                            deletedatapel();
                        }

                    } else {
                        progressBox.hide();
                        mb = new IconAlertMessageBox("Kesalahan", "HTTP Error code: " + response.getStatusCode(), true);
                        return;
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

    private void deletedatapel() {
        try {
            progressBox.show();

            rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/deletedatapel.json");
            rb.setHeader("Content-type", "application/x-www-form-urlencoded");

            StringBuilder sb = new StringBuilder();
            sb.append("&tKdKolektif=" + cbPilihKode.getSelectedValue());
            sb.append("&tidpel=" + strIdPel);

            // ***** send request
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

                        wsReturn = jsonObject.get("result").isObject().get("wsReturn").isString().stringValue();

                        if (wsReturn.equals("true")) {
                            progressBox.hide();
                            mb = new IconAlertMessageBox("Informasi", "Pelanggan berhasil dihapus", true);
                            getDataIdPelNotaBuku();
                        } else {
                            progressBox.hide();
                            mb = new IconAlertMessageBox("Kesalahan", "Pelanggan gagal dihapus", true);
                        }

                    } else {
                        progressBox.hide();
                        mb = new IconAlertMessageBox("Kesalahan", "HTTP Error code: " + response.getStatusCode(), true);
                        return;
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