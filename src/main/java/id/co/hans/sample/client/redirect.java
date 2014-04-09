package id.co.hans.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import id.co.hans.sample.client.components.IconAlertMessageBox;

public class redirect implements EntryPoint {
    private String keyId = "", page = "",
            idUser = "", unitupUser = "", levelUser = "",
            namaUser = "", unitapUser = "", kdppUser = "";

    private RequestBuilder rb;
    private JSONObject wsReturn;
    private String wsByRefError;
    private IconAlertMessageBox mb;

    public void onModuleLoad() {
        this.keyId = Window.Location.getParameter("keyId");
        this.page = Window.Location.getParameter("page");


        try {
            rb = new RequestBuilder(RequestBuilder.POST, "SecmanController/getUserDataByIdSession.json");
            rb.setHeader("Content-type", "application/x-www-form-urlencoded");

            StringBuilder sb = new StringBuilder();
            sb.append("idSession=" + this.keyId);

            rb.sendRequest(sb.toString(), new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {

                    if (200 == response.getStatusCode()) {
                        JSONValue value = JSONParser.parse(response.getText());
                        JSONObject jsonObject = value.isObject();

                        wsByRefError = jsonObject.get("result").isObject().get("wsByRefError").isString().stringValue();


                        if (wsByRefError.equals("")) {
                            wsReturn = jsonObject.get("result").isObject().get("wsReturn").isArray().get(0).isObject();

                            idUser = wsReturn.get("id_user").isString().stringValue();
                            unitupUser = wsReturn.get("unitup").isString().stringValue();
                            levelUser = wsReturn.get("leveluser").isString().stringValue();
                            namaUser = wsReturn.get("nama_user").isString().stringValue();
                            unitapUser = wsReturn.get("unitap").isString().stringValue();
                            kdppUser = wsReturn.get("kdpp").isString().stringValue();

                            getPageByIdSession(page, idUser, unitupUser, levelUser);
                        } else {
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

    private void getPageByIdSession(String page, String idUser, String unitupUser, String levelUser) {
        Widget widgetMenu = View.getInstance().getViewByIdMenu(page, idUser, unitupUser, levelUser);

        if (widgetMenu != null) {
            RootPanel.get().add(widgetMenu);
        } else {
            AlertMessageBox box = new AlertMessageBox("Error", "Message error : Menu belum teridentifikasi pada aplikasi, "+ page);
            box.setIcon(MessageBox.ICONS.warning());
            box.show();
        }
    }
}
