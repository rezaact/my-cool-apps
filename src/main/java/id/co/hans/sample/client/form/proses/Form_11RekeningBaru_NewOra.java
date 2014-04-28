package id.co.hans.sample.client.form.proses;

import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.AbstractForm;
import id.co.hans.sample.client.components.ComboKodeSiklis;
import id.co.hans.sample.client.components.ComboSourceSorex;
import id.co.hans.sample.client.components.ComboTahunBulan;
import id.co.hans.sample.client.components.ComboUnit;
import id.co.hans.sample.client.components.ComboUnits;
import id.co.hans.sample.client.components.IconAlertMessageBox;
import id.co.hans.sample.client.components.IconComboBox;
import id.co.hans.sample.client.components.IconDynamicGrid;
import id.co.hans.sample.client.helper.WsUmumUrlHelper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Form_11RekeningBaru_NewOra extends AbstractForm {

    private VerticalPanel vp;

    Date tanggalDatabase;

    ComboUnit cbKodeUnit;
    TextField tfKodeUnitDesc;
    ComboTahunBulan cbTahunBulan;
    ComboKodeSiklis cbKodeSiklis;
    TextButton bSetSiklis = new TextButton("Set Siklis");
    TextField tfPeriodeBayar;
    Radio radioSourceSorexFile;
    Radio radioSourceSorexOracle;
    ComboSourceSorex cbPilihSourceSorex;
    CheckBox cbKirimSorekDJBB;
    NumberField tfUploadPer;
    DateField dfTanggalJatuhTempo;
    DateField dfTglJtBk1;
    DateField dfTglJtBk2;
    DateField dfTglJtBk3;
    CheckBox cbMiddleFileDiServer;
    TextField tfMiddleFileDiServer;
    IconDynamicGrid gpTagihan;
    TextField lMiddleJmlPelanggan;
    TextField lMiddleJmlRpTag;
    TextField lBottomStatus;
    TextField tfBottomBerhasil;
    TextField tfBottomGagal;
    TextButton bCetakBA = new TextButton("Cetak BA");

    @Override
    protected void initEvent() {
        //GWT.log("url : " + WsUmumUrlHelper.getTanggalDatabaseURL());
        sendRequest(RequestBuilder.GET, WsUmumUrlHelper.getTanggalDatabaseURL(), null,
            new RequestCallback() {

                @Override
                public void onError(Request request, Throwable exception) {
                }

                @Override
                public void onResponseReceived(Request request, Response response) {
                    JSONObject json = new JSONObject(JsonUtils.safeEval(response.getText()));

                    String wsByRefError = json.get("result").isObject().get("wsByRefError").isString().stringValue();

                    if (!wsByRefError.equals("")) {
                        new IconAlertMessageBox("Kesalahan", wsByRefError, true);
                    } else {
                        tanggalDatabase = DEFAULT_DATETIME_FORMATER.parse(json.get("result").isObject().get("wsReturn").isArray().get(0).isObject().get("tanggal_database").isString().stringValue());
                    }
                }
            });

        //Map<ComboBox<Map<String, String>>, String> changesComboboxStore = new HashMap<ComboBox<Map<String, String>>, String>();
        //changesComboboxStore.put(cbKodeSiklis.getComboBox().getComboBox(), "");

        cbKodeUnit.getCbUnitUp().addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                cbKodeUnit.setSelectedValue(data.get("fieldValue"));

                if (cbTahunBulan.getCbTahunSelectedValue().equals("")) {
                    new IconAlertMessageBox("Kesalahan", "Tahun belum dipilih", true);
                    return;
                }

                if (cbTahunBulan.getCbBulanSelectedValue().equals("")) {
                    new IconAlertMessageBox("Kesalahan", "Bulan belum dipilih", true);
                    return;
                }

                cbKodeSiklis.reloadWithParams(cbKodeUnit.getSelectedValue(), cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue());
            }
        });

        cbTahunBulan.getCbTahun().addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                cbTahunBulan.setCbTahunSelectedValue(data.get("fieldValue"));

                if (cbKodeUnit.getSelectedValue().equals("")) {
                    new IconAlertMessageBox("Kesalahan", "Unit belum dipilih", true);
                    return;
                }

                if (cbTahunBulan.getCbBulanSelectedValue().equals("")) {
                    new IconAlertMessageBox("Kesalahan", "Bulan belum dipilih", true);
                    return;
                }

                cbKodeSiklis.reloadWithParams(cbKodeUnit.getSelectedValue(), cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue());
            }
        });
        cbTahunBulan.getCbBulan().addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                cbTahunBulan.setCbBulanSelectedValue(data.get("fieldValue"));

                if (cbKodeUnit.getSelectedValue().equals("")) {
                    new IconAlertMessageBox("Kesalahan", "Unit belum dipilih", true);
                    return;
                }

                if (cbTahunBulan.getCbTahunSelectedValue().equals("")) {
                    new IconAlertMessageBox("Kesalahan", "Tahun belum dipilih", true);
                    return;
                }

                cbKodeSiklis.reloadWithParams(cbKodeUnit.getSelectedValue(), cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue());
            }
        });

    }

    @Override
    protected FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("11 Rekening Baru - New Ora");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        // panel Title="Pilih Referensi"


        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        cbKodeUnit = new ComboUnit(getLevelUser(), getUnitupUser());
        p.add(cbKodeUnit);

        //tfKodeUnitDesc = new TextField();
        //p.add(new FieldLabel(tfKodeUnitDesc, "Kode Unit"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        cbTahunBulan = new ComboTahunBulan();
        p.add(cbTahunBulan);


        cbKodeSiklis = new ComboKodeSiklis();
        p.add(cbKodeSiklis);

        p.add(bSetSiklis);

        tfPeriodeBayar = new TextField();
        p.add(new FieldLabel(tfPeriodeBayar, "Periode Bayar"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        radioSourceSorexFile = new Radio();
        radioSourceSorexFile.setBoxLabel("File");
        p.add(radioSourceSorexFile);

        radioSourceSorexOracle = new Radio();
        radioSourceSorexOracle.setBoxLabel("Oracle");
        p.add(radioSourceSorexOracle);



        cbPilihSourceSorex = new ComboSourceSorex();
        p.add(cbPilihSourceSorex);


        cbKirimSorekDJBB = new CheckBox();
        cbKirimSorekDJBB.setBoxLabel("Kirim Sorek ke P2APST");


        tfUploadPer = new NumberField(new NumberPropertyEditor.IntegerPropertyEditor());
        tfUploadPer.setText("500");
        p.add((new FieldLabel(tfUploadPer, "Upload Per")));


        dfTanggalJatuhTempo = new DateField();
        p.add(new FieldLabel(dfTanggalJatuhTempo, "Tanggal Jatuh Tempo"));


        dfTglJtBk1 = new DateField();
        p.add(new FieldLabel(dfTglJtBk1, "Tanggal JT BK 1"));

        dfTglJtBk2 = new DateField();
        p.add(new FieldLabel(dfTglJtBk2, "Tanggal JT BK 2"));

        dfTglJtBk3 = new DateField();
        p.add(new FieldLabel(dfTglJtBk3, "Tanggal JT BK 3"));


        // button upload file

        cbMiddleFileDiServer = new CheckBox();
        p.add(new FieldLabel(cbMiddleFileDiServer, "File di Server"));

        tfMiddleFileDiServer = new TextField();
        p.add(new FieldLabel(tfMiddleFileDiServer, "Nama File"));


        // panel "Data Upload Sorek"

        gpTagihan = new IconDynamicGrid();
        gpTagihan.setGridHeader("Data Tagihan (Sampel data record 1 s/d 100)");
        gpTagihan.setGridDimension(300, 200);
        gpTagihan.setStoreUrl("BasicProject/thuGetString.json?name=store1");

        gpTagihan.addColumn("BOOL", 100);

        p.add(gpTagihan);


        // panel south
        lMiddleJmlPelanggan = new TextField();
        p.add(new FieldLabel(lMiddleJmlPelanggan, "Jml Pelanggan"));

        lMiddleJmlRpTag = new TextField();
        p.add(new FieldLabel(lMiddleJmlRpTag, "Jml RPTAG"));


        lBottomStatus = new TextField();
        p.add(new FieldLabel(lBottomStatus, "Progress Uploading"));

        // add progress bar


        tfBottomBerhasil = new TextField();
        p.add(new FieldLabel(tfBottomBerhasil, "Jml Berhasil"));

        tfBottomGagal = new TextField();
        p.add(new FieldLabel(tfBottomGagal, "Jml Gagal"));


        p.add(bCetakBA);

        // task runner UploadToTempSorek
        // on update untuk merefresh progress upload

        return panel;
    }
}
