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
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import id.co.hans.sample.client.AbstractForm;
import id.co.hans.sample.client.components.ComboKodeProses;
import id.co.hans.sample.client.components.ComboTahunBulan;
import id.co.hans.sample.client.components.ComboUnits;

import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import id.co.hans.sample.client.components.IconAlertMessageBox;

import java.util.Map;

public class Form_11RekeningBaru extends AbstractForm {

    ComboUnits cbUnits;
    ComboTahunBulan cbBlth;
    ComboKodeProses cbKdProses;

    TextButton btnUploadSorek;

    private RequestBuilder rb;
    private String wsReturn;
    private String wsByRefError;
    private IconAlertMessageBox mb;

    @Override
    protected void initEvent() {
        cbUnits.getComboUnitUp().addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                cbUnits.setUnitUpValue(data.get("fieldValue"));

                //update
                cbKdProses.setUnitUp(cbUnits.getUnitUpValue());
                cbKdProses.reloadStore();
            }
        });

        cbBlth.getCbTahun().addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                cbBlth.setCbTahunSelectedValue(data.get("fieldValue"));

                cbKdProses.setBlth(cbBlth.getCbTahunSelectedValue() + cbBlth.getCbBulanSelectedValue());
                cbKdProses.reloadStore();
            }
        });

        cbBlth.getCbBulan().addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                cbBlth.setCbBulanSelectedValue(data.get("fieldValue"));

                cbKdProses.setBlth(cbBlth.getCbTahunSelectedValue() + cbBlth.getCbBulanSelectedValue());
                cbKdProses.reloadStore();
            }
        });

        btnUploadSorek.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                try {
                    progressBox.show();
                    rb = new RequestBuilder(RequestBuilder.POST, "Ws_Transaksi/SetData_11_New.json");
                    rb.setHeader("Content-type", "application/x-www-form-urlencoded");

                    StringBuilder sb = new StringBuilder();
                    sb.append("unitap=" + cbUnits.getUnitApValue());
                    sb.append("&unitup="+ cbUnits.getUnitUpValue());
                    sb.append("&kdprosesklp="+ cbKdProses.getSelectedValue());
                    sb.append("&thbl="+ cbBlth.getCbTahunSelectedValue() + cbBlth.getCbBulanSelectedValue());
                    sb.append("&strglobalkodepetugas="+ getIdUser());

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
    }

    @Override
    protected FramedPanel panelMain() {
        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Upload Piutang Baru (SOREK) (11)");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        cbUnits = new ComboUnits(getLevelUser(), getUnitupUser(), 0, 0, 0);
        p.add(cbUnits);

        cbBlth = new ComboTahunBulan();
        p.add(cbBlth);

        cbKdProses = new ComboKodeProses();
        cbKdProses.setComboWidth(120);
        cbKdProses.setHideDescription(true);
        p.add(cbKdProses);

        //TextField tNorekAwal = new TextField();
        //p.add(new FieldLabel(tNorekAwal, "NOREK Awal Rekening"));

        btnUploadSorek = new TextButton("UPLOAD");
        panel.addButton(btnUploadSorek);

        return panel;
    }
}
