package id.co.hans.sample.client.form.administrasi;

import com.google.gwt.http.client.*;
import com.google.gwt.json.client.*;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.TextField;
import id.co.hans.sample.client.components.IconAlertMessageBox;

import java.util.List;

public class Form_UbahPassword {
    private VerticalPanel vp;

    final FormPanel form = new FormPanel();

    private Label lTopUserID;
    private TextField tfTopPasswordSaatIni, tfTopPasswordBaru, tfTopKonfirmPasswordBaru;
    private TextButton bTopUpdate;
    private IconAlertMessageBox mb;

    private RequestBuilder rb;
    private Boolean wsReturn;
    private String wsByRefError;

    public Widget asWidget() {
        if (vp == null) {
            vp = new VerticalPanel();
            vp.setSpacing(5);
            initKomponen();
            initEvent();
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
        panel.setHeadingText("Ganti Password");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        form.setAction("URLtoSave");
        form.setEncoding(FormPanel.Encoding.MULTIPART);
        form.setMethod(FormPanel.Method.POST);
        panel.add(form);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        form.add(p);

        lTopUserID = new Label();
        p.add(new FieldLabel(lTopUserID, "User ID"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        tfTopPasswordSaatIni = new TextField();
        p.add(new FieldLabel(tfTopPasswordSaatIni, "Password Saat Ini"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        tfTopPasswordBaru = new TextField();
        p.add(new FieldLabel(tfTopPasswordBaru, "Password Baru"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        tfTopKonfirmPasswordBaru = new TextField();
        p.add(new FieldLabel(tfTopKonfirmPasswordBaru, "Konfirm Password Baru"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        bTopUpdate = new TextButton("Update");

        panel.addButton(bTopUpdate);

        return panel;
    }

    private void initEvent() {
        bTopUpdate.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                if(!form.isValid()) {
                    mb = new IconAlertMessageBox("","");
                    mb.show();
                    return;
                }

                try {
                    rb = new RequestBuilder(RequestBuilder.POST, "Ws_Administrasi/SaveNewPassword");
                    rb.sendRequest(null, new RequestCallback() {
                        @Override
                        public void onResponseReceived(Request request, Response response) {
                            if (200 == response.getStatusCode()) {
                                JSONValue value = JSONParser.parse(response.getText());
                                JSONObject jsonObject = value.isObject();

                                wsReturn = jsonObject.get("wsReturn").isBoolean().booleanValue();

                                if (wsReturn) {
                                    mb = new IconAlertMessageBox("Informasi", "Password sudah berubah", true);
                                } else {
                                    wsByRefError = jsonObject.get("wsByRefError").isString().stringValue();
                                    mb = new IconAlertMessageBox("Kesalahan", wsByRefError, true);
                                }
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
    }
}
