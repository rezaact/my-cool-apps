package id.co.hans.sample.client.form.creditnote;

import id.co.hans.sample.client.AbstractForm;
import id.co.hans.sample.client.components.ComboKodePP;
import id.co.hans.sample.client.components.ComboUnit;

import java.util.Map;

import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;


public class Form_DataDana extends AbstractForm {
    
	private static final String HTTP_URL_TANGGAL_DATABASE = "Ws_Umum/ambilTanggalDatabase.json?";
	private static final String HTTP_URL_AMBIL_UNIT_UP_DARI_PETUGAS = "Ws_Umum/ambilUnitUPdariPetugas.json?";
	private String tanggalDatabaseResult;
	private ComboUnit cbTopPilihUnitUp;

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

        ComboKodePP cbTopPilihKodePp = new ComboKodePP();
        p.add(cbTopPilihKodePp);

        DateField dfMiddleTanggalAwal = new DateField();
        p.add(new FieldLabel(dfMiddleTanggalAwal, "Tanggal Awal"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        DateField dfMiddleTanggalAkhir = new DateField();
        p.add(new FieldLabel(dfMiddleTanggalAkhir, "Tanggal Akhir"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        TextButton bMiddleTampilkan = new TextButton("Tampilkan");
        panel.addButton(bMiddleTampilkan);

        return panel;
    }

	@Override
	protected void initEvent() {
		cbTopPilihUnitUp.getCbUnitUp().addSelectionHandler(new SelectionHandler<Map<String,String>>() {
			
			@Override
			public void onSelection(SelectionEvent<Map<String, String>> event) {
				
			}
		});
	}
	
	private String getTanggalDatabase() {
		final StringBuilder tanggalDB = new StringBuilder();
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(HTTP_URL_TANGGAL_DATABASE));
		try {
			builder.sendRequest(null, new RequestCallback() {
				
				@Override
				public void onResponseReceived(Request request, Response response) {
					JSONObject json = new JSONObject(JsonUtils.safeEval(response.getText()));
					tanggalDB.append(json.get("result").toString());
				}
				
				@Override
				public void onError(Request request, Throwable exception) {
				}
			});
		} catch (RequestException e) {
		}
		return tanggalDB.toString();
	}

	public String getTanggalDatabaseResult() {
		if(tanggalDatabaseResult == null) {
			tanggalDatabaseResult = getTanggalDatabase();
		}
		return tanggalDatabaseResult;
	}

	public void setTanggalDatabaseResult(String tanggalDatabaseResult) {
		this.tanggalDatabaseResult = tanggalDatabaseResult;
	}
}
