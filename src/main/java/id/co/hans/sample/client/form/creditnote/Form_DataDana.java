package id.co.hans.sample.client.form.creditnote;

import id.co.hans.sample.client.AbstractForm;
import id.co.hans.sample.client.components.ComboKodePP;
import id.co.hans.sample.client.components.ComboUnit;
import id.co.hans.sample.client.helper.WsUmumUrlHelper;

import java.util.Date;

import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;

public class Form_DataDana extends AbstractForm {

  private ComboUnit cbTopPilihUnitUp;
  private DateField dfMiddleTanggalAwal;
  private DateField dfMiddleTanggalAkhir;
  private ComboKodePP cbTopPilihKodePp;


  @Override
  @SuppressWarnings("unchecked")
  protected void initEvent() {
    sendRequest(RequestBuilder.GET, WsUmumUrlHelper.getTanggalDatabaseURL(), null,
        new RequestCallback() {

          @Override
          public void onError(Request request, Throwable exception) {}

          @Override
          public void onResponseReceived(Request request, Response response) {
            JSONObject json = new JSONObject(JsonUtils.safeEval(response.getText()));
            GWT.log("json object : " + json.get("result"));
            Date tanggalDatabase = DEFAULT_DATETIME_FORMATER.parse(json.get("result").toString());
            dfMiddleTanggalAwal.setValue(tanggalDatabase);
            dfMiddleTanggalAkhir.setValue(tanggalDatabase);
          }
        });

    cbTopPilihUnitUp.getChangesComboBoxStore().put(cbTopPilihKodePp.getComboBox().getComboBox(),
        WsUmumUrlHelper.getKodePPURL(getUnitupUser()));

  }

  @Override
  protected FramedPanel panelMain() {

    FramedPanel panel = new FramedPanel();
    panel.setHeadingText("Perbandingan Data dan Dana");
    panel.setBodyStyle("background: none; padding: 5px");
    panel.setWidth(650);

    VerticalLayoutContainer p = new VerticalLayoutContainer();
    panel.add(p);

    cbTopPilihUnitUp = new ComboUnit();
    p.add(cbTopPilihUnitUp);

    Label label1 = new Label("Pemantauan per-Tanggal Pelunasan berdasarkan Payment Point :");
    p.add(label1);

    cbTopPilihKodePp = new ComboKodePP();
    p.add(cbTopPilihKodePp);

    dfMiddleTanggalAwal = new DateField();
    p.add(new FieldLabel(dfMiddleTanggalAwal, "Tanggal Awal"),
        new VerticalLayoutContainer.VerticalLayoutData(1, -1));

    dfMiddleTanggalAkhir = new DateField();
    p.add(new FieldLabel(dfMiddleTanggalAkhir, "Tanggal Akhir"),
        new VerticalLayoutContainer.VerticalLayoutData(1, -1));

    TextButton bMiddleTampilkan = new TextButton("Tampilkan");
    panel.addButton(bMiddleTampilkan);

    return panel;
  }

}
