package id.co.hans.sample.client;

import id.co.hans.sample.client.components.IconAlertMessageBox;

import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestBuilder.Method;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;

public abstract class AbstractForm {

  protected static final String DATE_FORMAT_PATTERN = "dd-MMM-yy";
  protected static final DateTimeFormat DEFAULT_DATETIME_FORMATER = DateTimeFormat
      .getFormat(DATE_FORMAT_PATTERN);

  private String idUser;
  private String unitupUser;
  private String levelUser;
  private VerticalPanel vp;

  public Widget asWidget(String idUser, String unitupUser, String levelUser) {
    this.idUser = idUser;
    this.unitupUser = unitupUser;
    this.levelUser = levelUser;

    if (vp == null) {
      vp = new VerticalPanel();
      vp.setSpacing(5);
      initKomponen();
      initEvent();
    }
    return vp;
  }

  public String getIdUser() {
    return idUser;
  }

  public String getLevelUser() {
    return levelUser;
  }

  public String getUnitupUser() {
    return unitupUser;
  }

  protected abstract void initEvent();

  protected void initKomponen() {
    AutoProgressMessageBox progressBox = new AutoProgressMessageBox("Progress", "please wait");
    progressBox.setProgressText("wait...");
    vp.add(panelMain());
  }

  protected abstract FramedPanel panelMain();

  protected void sendRequest(Method method, String url, final AutoProgressMessageBox progressBox) {
    sendRequest(method, url, progressBox, new RequestCallback() {
      @Override
      public void onError(Request request, Throwable throwable) {
        new IconAlertMessageBox("Kesalahan", throwable.getMessage(), true);
      }

      @Override
      public void onResponseReceived(Request request, Response response) {
        Boolean wsReturn;
        String wsByRefError;
        if (progressBox != null) {
          progressBox.hide();
        }

        if (200 == response.getStatusCode()) {
          JSONObject jsonObject = transformResponseToJSON(response.getText());
          wsReturn = jsonObject.get("result").isObject().get("wsReturn").isBoolean().booleanValue();

          if (wsReturn) {
            new IconAlertMessageBox("Informasi", "Proses rekap ulang berhasil dilakukan", true);
          } else {
            wsByRefError =
                jsonObject.get("result").isObject().get("wsByRefError").isString().stringValue();
            new IconAlertMessageBox("Kesalahan", wsByRefError, true);
          }
        } else {
          new IconAlertMessageBox("Kesalahan", "HTTP Error code: " + response.getStatusCode(), true);
        }
      }
    });
  }

  protected void sendRequest(Method method, String url, final AutoProgressMessageBox progressBox,
      RequestCallback callback) {

    try {
      RequestBuilder rb = new RequestBuilder(method, URL.encode(url));
      rb.setHeader("Content-type", "application/x-www-form-urlencoded");

      rb.sendRequest(null, callback);
      if (progressBox != null) {
        progressBox.show();
      }
    } catch (RequestException ex) {
      new IconAlertMessageBox("Kesalahan", ex.getMessage(), true);
    }
  }

  public void setIdUser(String idUser) {
    this.idUser = idUser;
  }

  public void setLevelUser(String levelUser) {
    this.levelUser = levelUser;
  }

  public void setUnitupUser(String unitupUser) {
    this.unitupUser = unitupUser;
  }

  protected JSONObject transformResponseToJSON(String jsonResult) {
    return new JSONObject(JsonUtils.safeEval(jsonResult));
  }
  
}
