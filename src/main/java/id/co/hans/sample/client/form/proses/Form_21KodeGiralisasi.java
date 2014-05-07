package id.co.hans.sample.client.form.proses;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.Style;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.event.RowClickEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.grid.CellSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridSelectionModel;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.validator.MinLengthValidator;
import com.sencha.gxt.widget.core.client.form.*;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;
import id.co.hans.sample.client.AbstractForm;
import id.co.hans.sample.client.components.*;

import java.util.HashMap;

public class Form_21KodeGiralisasi  extends AbstractForm {

    TextField KBebanK;
    TextArea description;
    TextButton bKiriTambah = new TextButton("Tambah");
    TextButton bKiriReset = new TextButton("Reset");

    TextField KKBebanK;
    TextArea Kdescription;
    TextButton bKananTambah = new TextButton("Tambah");
    TextButton bKananReset = new TextButton("Reset");

    IconDynamicGrid gpData;

    private String sLabel = "";

    private RequestBuilder rb;
    private String wsReturn;
    private String wsByRefError;
    private IconAlertMessageBox mb;

    protected FramedPanel panelMain() {

        sLabel = "Giralisasi";

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Manajemen Kode " + sLabel);
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        //From Kiri
        HorizontalPanel Top = new HorizontalPanel();

        FramedPanel panel1 = new FramedPanel();
        panel1.setBodyStyle("background: none; padding: 5px");
        panel1.setHeadingText("Entri Kode " + sLabel);
        panel1.setWidth(300);

        VerticalLayoutContainer Kiri = new VerticalLayoutContainer();
        panel1.add(Kiri);

        KBebanK = new TextField();
        Kiri.add(new FieldLabel(KBebanK, "Kode " + sLabel));

        description = new TextArea();
        description.setAllowBlank(false);
        description.addValidator(new MinLengthValidator(10));
        Kiri.add(new FieldLabel(description, "Nama " + sLabel));
        bKiriTambah = new TextButton("Tambah");
        bKiriReset = new TextButton("Reset");
        panel1.addButton(bKiriTambah);
        panel1.addButton(bKiriReset);
        Top.add(panel1);
        p.add(Top);

        //Form Kanan
        FramedPanel panel2 = new FramedPanel();
        panel2.setBodyStyle("background: none; padding: 5px");
        panel2.setHeadingText("Hapus Kode " + sLabel);
        panel2.setWidth(300);

        VerticalLayoutContainer Kanan = new VerticalLayoutContainer();
        panel2.add(Kanan);

        KKBebanK = new TextField();
        Kanan.add(new FieldLabel(KKBebanK, "Kode " + sLabel));

        Kdescription = new TextArea();
        Kdescription.setAllowBlank(false);
        Kdescription.addValidator(new MinLengthValidator(10));
        Kanan.add(new FieldLabel(Kdescription, "Nama " + sLabel));
        bKananTambah = new TextButton("Hapus");
        bKananReset = new TextButton("Reset");
        panel2.addButton(bKananTambah);
        panel2.addButton(bKananReset);
        Top.add(panel2);
        p.add(Top, new VerticalLayoutContainer.VerticalLayoutData(1,1,new Margins(0,0,0,0)));

        //Grid
        gpData = new IconDynamicGrid();
        gpData.setGridHeader("Data Master");
        gpData.setGridDimension(623, 200);
        gpData.setStoreUrl("dummy/dummy.json");
        gpData.addColumn("KODEKOLEKTIF", 100);
        gpData.addColumn("NAMAKOLEKTIF", 100);
        gpData.addColumn("TRANSAKSIBY", 100);
        gpData.addColumn("TGLTRANSAKSI", 100);
        gpData.addColumn("THRUBY", 100);
        gpData.addColumn("TGLTHRU", 100);
        gpData.addColumn("UNITUP", 100);

        p.add(gpData);

        loadData();

        return panel;
    }

    @Override
    protected void initEvent() {
        bKiriTambah.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                if (KBebanK.getValue().equals("") || description.getValue().equals("")) {
                    mb = new IconAlertMessageBox("Kesalahan", "Lengkapi data kolektif...", true);
                    return;
                }

                try {

                    progressBox.show();

                    rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/GetNamaKolektifGiralisasi.json");
                    rb.setHeader("Content-type", "application/x-www-form-urlencoded");

                    StringBuilder sb = new StringBuilder();
                    sb.append("&tKdKolektif=" + KBebanK.getValue());
                    sb.append("&nulll=" + "TAMBAH");

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

                                if (array.size() > 0) {
                                    progressBox.hide();
                                    mb = new IconAlertMessageBox("Cek Kode Kolektif", "Kode Kolektif sudah ada", true);
                                    return;
                                }

                                simpanDataKolektif();

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

        bKiriReset.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                KBebanK.clear();
                description.clear();
            }
        });

        bKananTambah.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                try {

                    progressBox.show();

                    rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/GetDataIdPelGiralisasi.json");
                    rb.setHeader("Content-type", "application/x-www-form-urlencoded");

                    StringBuilder sb = new StringBuilder();
                    sb.append("&tkodekolektif=" + KKBebanK.getValue());

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

                                if (array.size() > 0) {
                                    progressBox.hide();
                                    mb = new IconAlertMessageBox("kesalahan", "Kode Kolektif tidak bisa dihapus karena sudah mempunyai pelanggan", true);
                                    return;
                                }

                                hapusDataKolektif();

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

        bKananReset.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                KKBebanK.clear();
                Kdescription.clear();
            }
        });


        gpData.getGrid().getSelectionModel().setSelectionMode(Style.SelectionMode.SINGLE);
        gpData.getGrid().getSelectionModel().addSelectionChangedHandler(new SelectionChangedEvent.SelectionChangedHandler<HashMap<String, String>>() {
            @Override
            public void onSelectionChanged(SelectionChangedEvent event) {

                if (event.getSelection().size() > 0) {
                    HashMap<String, String> selectedData = (HashMap<String,String>)event.getSelection().get(0);
                    KKBebanK.setValue(selectedData.get("KODEKOLEKTIF"));
                    Kdescription.setValue(selectedData.get("NAMAKOLEKTIF"));
                }
            }
        });

        loadData();
    }

    private void loadData() {
        try {

            progressBox.show();

            rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/tampilkodekolektifGiralisasiUnitup.json");
            rb.setHeader("Content-type", "application/x-www-form-urlencoded");

            StringBuilder sb = new StringBuilder();
            sb.append("&sUnitup=" + getUnitupUser());

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

    private void simpanDataKolektif() {
        try {
            progressBox.show();

            rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/simpandatakolektifGiralisasi.json");
            rb.setHeader("Content-type", "application/x-www-form-urlencoded");

            StringBuilder sb = new StringBuilder();
            sb.append("&tKdKolektif=" + KBebanK.getValue());
            sb.append("&tnamakolektif=" + description.getValue());
            sb.append("&tpetugas=" + getIdUser());

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
                            mb = new IconAlertMessageBox("Informasi", "Data Kolektif berhasil disimpan", true);
                            loadData();
                        } else {
                            progressBox.hide();
                            mb = new IconAlertMessageBox("Kesalahan", "Data Kolektif Gagal disimpan", true);
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

    private void hapusDataKolektif() {
        try {
            progressBox.show();

            rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/hapusdatakolektifGiralisasi.json");
            rb.setHeader("Content-type", "application/x-www-form-urlencoded");

            StringBuilder sb = new StringBuilder();
            sb.append("&tKdKolektif=" + KKBebanK.getValue());
            sb.append("&tpetugas=" + getIdUser());

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
                            mb = new IconAlertMessageBox("Informasi", "Data Kolektif berhasil dihapus", true);
                            loadData();
                        } else {
                            progressBox.hide();
                            mb = new IconAlertMessageBox("Kesalahan", "Data Kolektif Gagal dihapus", true);
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
