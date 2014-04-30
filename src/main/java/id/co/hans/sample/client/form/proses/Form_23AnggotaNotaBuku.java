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
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
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
        panel.setHeadingText("Anggota Nota Buku");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);


        // panel "Anggota Nota Buku"
        FramedPanel panelAnggotaNotaBuku = new FramedPanel();
        panelAnggotaNotaBuku.setHeadingText("Manajemen Anggota Kode " + sLabel);
        panelAnggotaNotaBuku.setBodyStyle("background: none; padding: 5px");
        panelAnggotaNotaBuku.setWidth(623);
        panelAnggotaNotaBuku.setHeight(400);

        VerticalLayoutContainer vlcAnggotaNotaBuku = new VerticalLayoutContainer();
        panelAnggotaNotaBuku.add(vlcAnggotaNotaBuku);

        HorizontalPanel hlcAnggotaNotaBuku = new HorizontalPanel();

        Label lbl01 = new Label("Pilih Kode");
        lbl01.getElement().getStyle().setMarginLeft(5, Style.Unit.PX);
        lbl01.getElement().getStyle().setMarginRight(5, Style.Unit.PX);
        lbl01.getElement().getStyle().setMarginTop(3, Style.Unit.PX);
        hlcAnggotaNotaBuku.add(lbl01);

        cbPilihKode = new ComboNotaBukuUnitUPiBebanKantor();
        cbPilihKode.setUnitUp(getUnitupUser());
        cbPilihKode.setIBebanKantor(String.valueOf(getIBebanKantor()));
        hlcAnggotaNotaBuku.add(cbPilihKode);

        vlcAnggotaNotaBuku.add(hlcAnggotaNotaBuku, new VerticalLayoutContainer.VerticalLayoutData(-1,1));

        HorizontalPanel hlcNota = new HorizontalPanel();

        // panel " tambah data"
        FramedPanel panelTambahData = new FramedPanel();
        panelTambahData.setHeadingText("Tambah Data");
        panelTambahData.setBodyStyle("background: none; padding: 5px");
//        panelTambahData.setWidth(400);
//        panelTambahData.setHeight(250);

        hlcNota.add(panelTambahData);

        VerticalLayoutContainer vlcTambahData= new VerticalLayoutContainer();

        HorizontalPanel hlcIdpelTambah = new HorizontalPanel();
        radioIdpelTambah = new Radio();
        radioIdpelTambah.setBoxLabel("ID Pelanggan");
        hlcIdpelTambah.add(radioIdpelTambah);

        txIdpelTambah = new TextField();
        hlcIdpelTambah.add(txIdpelTambah);
        vlcTambahData.add(hlcIdpelTambah);

        HorizontalPanel hlcNopelTambah = new HorizontalPanel();
        radioNopelTambah = new Radio();
        radioNopelTambah.setBoxLabel("No Pelanggan");
        hlcNopelTambah.add(radioNopelTambah);

        txNopelTambah = new TextField();
        hlcNopelTambah.add(txNopelTambah);

        vlcTambahData.add(hlcNopelTambah);

        txket= new TextArea();

        vlcTambahData.add(new FieldLabel(txket, "Keterangan"), new VerticalLayoutContainer.VerticalLayoutData(1, 100));

        btnTambah = new TextButton("Tambah");
        vlcTambahData.add(btnTambah);

        panelTambahData.add(vlcTambahData);

        hlcNota.add(panelTambahData);

        // panel " hapus data"
        FramedPanel panelHapusData = new FramedPanel();
        panelHapusData.setHeadingText("Hapus Data");
        panelHapusData.setBodyStyle("background: none; padding: 5px");
//        panelTambahData.setWidth(400);
//        panelTambahData.setHeight(250);

        VerticalLayoutContainer vlcHapusData= new VerticalLayoutContainer();

        HorizontalPanel hlcIdpelHapus = new HorizontalPanel();
        radioIdpelHapus = new Radio();
        radioIdpelHapus.setBoxLabel("ID Pelanggan");
        hlcIdpelHapus.add(radioIdpelHapus);

        txIdpelHapus = new TextField();
        hlcIdpelHapus.add(txIdpelHapus);
        vlcHapusData.add(hlcIdpelHapus);

        HorizontalPanel hlcNopelHapus = new HorizontalPanel();

        radioNopeHapus = new Radio();
        radioNopeHapus.setBoxLabel("No Pelanggan");
        hlcNopelHapus.add(radioNopeHapus);

        txNopelHapus = new TextField();
        hlcNopelHapus.add(txNopelHapus);

        vlcHapusData.add(hlcNopelHapus);

        btnHapus = new TextButton("Hapus");
        vlcHapusData.add(btnHapus);

//        HorizontalPanel hlctxket = new HorizontalPanel();
//        Label lblKet = new Label("Keterangan");
//        lblKet.setWidth("25");
//        hlctxket.add(lblKet);
        panelHapusData.add(vlcHapusData);
        hlcNota.add(panelHapusData);

        vlcAnggotaNotaBuku.add(hlcNota);


        HorizontalPanel hlcNamaKode = new HorizontalPanel();
        Label lbl03 = new Label("Nama Kode");
        lbl03.getElement().getStyle().setMarginLeft(5, Style.Unit.PX);
        lbl03.getElement().getStyle().setMarginRight(5, Style.Unit.PX);
        lbl03.getElement().getStyle().setMarginTop(3, Style.Unit.PX);
        hlcNamaKode.add(lbl03);

        txtNamaKode= new TextField();
        hlcNamaKode.add(txtNamaKode);
        btnTampilData = new TextButton("Tampil Data");
        hlcNamaKode.add(btnTampilData);
        vlcAnggotaNotaBuku.add(new Label("_"));
        vlcAnggotaNotaBuku.add(hlcNamaKode);

        vlcAnggotaNotaBuku.add(new Label("_"));

        p.add(panelAnggotaNotaBuku);


        // panel "Data"

        gpData = new IconDynamicGrid();
        gpData.setGridHeader("Data Master");
        gpData.setGridDimension(623, 200);
        gpData.setStoreUrl("BasicProject/dummy.json");
        gpData.addColumn("CEK", 100);
        gpData.addColumn("KDPP", 100);
        gpData.addColumn("NO_BATULV06", 100);
        gpData.addColumn("TGLTRANSAKSI", 100);
        gpData.addColumn("TRANSAKSIID", 100);
        gpData.addColumn("TRANSAKSIBY", 100);
        gpData.addColumn("TGL_PELUNASAN", 100);
        gpData.addColumn("TGL_SETOR", 100);
        gpData.addColumn("RPTOTAL", 100);

        p.add(gpData);

        return panel;
    }

    @Override
    protected void initEvent() {
        btnTambah.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                try {
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
                            progressBox.hide();

                            if (200 == response.getStatusCode()) {
                                JSONValue value = JSONParser.parse(response.getText());
                                JSONObject jsonObject = value.isObject();

                                wsByRefError = jsonObject.get("result").isObject().get("wsByRefError").isString().stringValue();

                                if (!wsByRefError.equals("")) {
                                    mb = new IconAlertMessageBox("Kesalahan", wsByRefError, true);
                                    return;
                                }

                                wsReturn = jsonObject.get("result").isObject().get("wsReturn").isString().stringValue();


                                List<Map<String, String>> datas = new ArrayList<Map<String, String>>();
                                Map<String, String> rowData;

                                if (jsonObject.containsKey("wsReturn")) {
                                    JSONArray array = jsonObject.get("wsReturn").isArray();

                                    for (int idx = 0; idx < array.size(); idx++) {
                                        rowData = new HashMap<String, String>();
                                        rowData.put("id", String.valueOf(idx));

                                        JSONObject sourceRowData = array.get(idx).isObject();

                                        for (Object obj : sourceRowData.keySet()) {
                                            rowData.put(obj.toString().toUpperCase(), sourceRowData.get(obj.toString()).isString().stringValue());
                                        }
                                        datas.add(rowData);
                                    }
                                }


                                mb = new IconAlertMessageBox("Hasil", wsReturn, true);
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

        btnHapus.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        btnTampilData.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }

}