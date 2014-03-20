package id.co.hans.sample.client.form.creditnote;

import id.co.hans.sample.client.AbstractForm;
import id.co.hans.sample.client.components.IconComboBox;
import id.co.hans.sample.constants.WsUmumUrlConstants;

import java.util.Date;
import java.util.Map;

import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONObject;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;


//todo: skipped. work on later
public class Form_EntryCN extends AbstractForm {

	private static final String DUMMY_URL = "BasicProject/thuGetComboData2.json?";
	private static final String BUKTI_SETOR_PREFIX_CODE = "BACN-";
	private static final String BUKTI_SETOR_SEPARATOR = "/";
	
    private IconComboBox cb_UnitUP;
	private DateField dt_Pelunasan;
	private DateField dt_Penyetoran;
	private TextField txt_UnitUP;
	private IconComboBox cb_KodePP;
	private TextField txt_KodePp;
	private TextField txt_BABuktiSetor;
	private TextButton btn_Buat;
	private TextButton btn_Simpan;

	@Override
    protected FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Entry Credit Note");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);


        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        cb_UnitUP = new IconComboBox();
        cb_UnitUP.setStoreUrl(DUMMY_URL);
        cb_UnitUP.setComboFieldName("Unit UP");
        cb_UnitUP.setComboWidth(250);
        cb_UnitUP.setLabelWidth(180);
        p.add(cb_UnitUP);

        txt_UnitUP = new TextField();
        txt_UnitUP.setAllowBlank(false);
        p.add(new FieldLabel(txt_UnitUP, "Unit UP"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        cb_KodePP = new IconComboBox();
        cb_KodePP.setStoreUrl(DUMMY_URL);
        cb_KodePP.setComboFieldName("Kode PP");
        cb_KodePP.setComboWidth(250);
        cb_KodePP.setLabelWidth(180);
        p.add(cb_KodePP);

        txt_KodePp = new TextField();
        txt_KodePp.setAllowBlank(false);
        p.add(new FieldLabel(txt_KodePp, "Kode PP"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        IconComboBox cbTopPilihKodePp = new IconComboBox();
        cbTopPilihKodePp.setStoreUrl("BasicProject/thuGetComboData2.json");
        cbTopPilihKodePp.setComboFieldName("Kode PP");
        cbTopPilihKodePp.setComboWidth(250);
        cbTopPilihKodePp.setLabelWidth(180);
        p.add(cbTopPilihKodePp);

        TextField tfTopPilihKodePp = new TextField();
        tfTopPilihKodePp.setAllowBlank(false);
        p.add(new FieldLabel(tfTopPilihKodePp, "Kode PP"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        dt_Pelunasan = new DateField();
        dt_Pelunasan.setAllowBlank(false);
        p.add(new FieldLabel(dt_Pelunasan, "Tanggal Pelunasan"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        dt_Penyetoran = new DateField();
        dt_Penyetoran.setAllowBlank(false);
        p.add(new FieldLabel(dt_Penyetoran, "Tanggal Penyetoran"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        txt_BABuktiSetor = new TextField();
        txt_BABuktiSetor.setAllowBlank(false);
        p.add(new FieldLabel(txt_BABuktiSetor, "Nomor BA Bukti Setor"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        btn_Buat = new TextButton("Buat");
        panel.addButton(btn_Buat);

        return panel;
    }

//	TODO: ini mo ditaro mana? koq ga ada yg panggil.
    @SuppressWarnings("unused")
	private FramedPanel center() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Entry Credit Note");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        //todo: add label "Masukkan Penyetoran Uang ke Bank berdasarkan Unsur Rekening :"


        // layout column 0.3
        //todo: add label "Unsur Rek: "
        //todo: add label "Rupiah: "

        TextField rpPTL = new TextField();
        rpPTL.setAllowBlank(false);
        p.add(new FieldLabel(rpPTL, "PTL"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField rpBPJU = new TextField();
        rpBPJU.setAllowBlank(false);
        p.add(new FieldLabel(rpBPJU, "BPJU"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField rpPPN = new TextField();
        rpPPN.setAllowBlank(false);
        p.add(new FieldLabel(rpPPN, "PPN"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField rpMaterai = new TextField();
        rpMaterai.setAllowBlank(false);
        p.add(new FieldLabel(rpMaterai, "Materai"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField rpTrafo = new TextField();
        rpTrafo.setAllowBlank(false);
        p.add(new FieldLabel(rpTrafo, "Trafo"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField rpLain = new TextField();
        rpLain.setAllowBlank(false);
        p.add(new FieldLabel(rpLain, "Lain-lain"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField rpBk = new TextField();
        rpBk.setAllowBlank(false);
        p.add(new FieldLabel(rpBk, "BK"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));



        // layout column 0.3

        //todo: add label "Kode Bank: "
        //todo: add label "Nama Bank: "


        IconComboBox cbKodeBank01 = new IconComboBox();
        cbKodeBank01.setStoreUrl("BasicProject/thuGetComboData2.json");
        cbKodeBank01.setComboFieldName("Kode Bank 01");
        cbKodeBank01.setComboWidth(250);
        cbKodeBank01.setLabelWidth(180);
        p.add(cbKodeBank01);

        TextField tfKodeBank01 = new TextField();
        tfKodeBank01.setAllowBlank(false);
        p.add(new FieldLabel(tfKodeBank01, "Kode Bank 01"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        IconComboBox cbKodeBank02 = new IconComboBox();
        cbKodeBank02.setStoreUrl("BasicProject/thuGetComboData2.json");
        cbKodeBank02.setComboFieldName("Kode Bank 02");
        cbKodeBank02.setComboWidth(250);
        cbKodeBank02.setLabelWidth(180);
        p.add(cbKodeBank02);

        TextField tfKodeBank02 = new TextField();
        tfKodeBank02.setAllowBlank(false);
        p.add(new FieldLabel(tfKodeBank02, "Kode Bank 02"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        IconComboBox cbKodeBank03 = new IconComboBox();
        cbKodeBank03.setStoreUrl("BasicProject/thuGetComboData2.json");
        cbKodeBank03.setComboFieldName("Kode Bank 03");
        cbKodeBank03.setComboWidth(250);
        cbKodeBank03.setLabelWidth(180);
        p.add(cbKodeBank03);

        TextField tfKodeBank03 = new TextField();
        tfKodeBank03.setAllowBlank(false);
        p.add(new FieldLabel(tfKodeBank03, "Kode Bank 03"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        IconComboBox cbKodeBank04 = new IconComboBox();
        cbKodeBank04.setStoreUrl("BasicProject/thuGetComboData2.json");
        cbKodeBank04.setComboFieldName("Kode Bank 04");
        cbKodeBank04.setComboWidth(250);
        cbKodeBank04.setLabelWidth(180);
        p.add(cbKodeBank04);

        TextField tfKodeBank04 = new TextField();
        tfKodeBank04.setAllowBlank(false);
        p.add(new FieldLabel(tfKodeBank04, "Kode Bank 04"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        IconComboBox cbKodeBank05 = new IconComboBox();
        cbKodeBank05.setStoreUrl("BasicProject/thuGetComboData2.json");
        cbKodeBank05.setComboFieldName("Kode Bank 05");
        cbKodeBank05.setComboWidth(250);
        cbKodeBank05.setLabelWidth(180);
        p.add(cbKodeBank05);

        TextField tfKodeBank05 = new TextField();
        tfKodeBank05.setAllowBlank(false);
        p.add(new FieldLabel(tfKodeBank05, "Kode Bank 05"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        IconComboBox cbKodeBank06 = new IconComboBox();
        cbKodeBank06.setStoreUrl("BasicProject/thuGetComboData2.json");
        cbKodeBank06.setComboFieldName("Kode Bank 06");
        cbKodeBank06.setComboWidth(250);
        cbKodeBank06.setLabelWidth(180);
        p.add(cbKodeBank06);

        TextField tfKodeBank06 = new TextField();
        tfKodeBank06.setAllowBlank(false);
        p.add(new FieldLabel(tfKodeBank06, "Kode Bank 06"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        IconComboBox cbKodeBank07 = new IconComboBox();
        cbKodeBank07.setStoreUrl("BasicProject/thuGetComboData2.json");
        cbKodeBank07.setComboFieldName("Kode Bank 07");
        cbKodeBank07.setComboWidth(250);
        cbKodeBank07.setLabelWidth(180);
        p.add(cbKodeBank07);

        TextField tfKodeBank07 = new TextField();
        tfKodeBank07.setAllowBlank(false);
        p.add(new FieldLabel(tfKodeBank07, "Kode Bank 07"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        // layout column 0.3
        //todo: add label "No Credit Note: "

        TextField cnPtl = new TextField();
        cnPtl.setAllowBlank(false);
        p.add(new FieldLabel(cnPtl, "cnPtl"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextButton btn_Copy = new TextButton("Copy");
        p.add(btn_Copy);

        TextField cnBPJU = new TextField();
        cnBPJU.setAllowBlank(false);
        p.add(new FieldLabel(cnBPJU, "BPJU"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField cnPPN = new TextField();
        cnPPN.setAllowBlank(false);
        p.add(new FieldLabel(cnPPN, "PPN"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField cnMaterai = new TextField();
        cnMaterai.setAllowBlank(false);
        p.add(new FieldLabel(cnMaterai, "Materai"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField cnTrafo = new TextField();
        cnTrafo.setAllowBlank(false);
        p.add(new FieldLabel(cnTrafo, "Trafo"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField cnLain = new TextField();
        cnLain.setAllowBlank(false);
        p.add(new FieldLabel(cnLain, "Lain"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextField cnBK = new TextField();
        cnBK.setAllowBlank(false);
        p.add(new FieldLabel(cnBK, "BK"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        // layout column 0.3
        //todo: add label "Lembar: "

        TextField lembar = new TextField();
        lembar.setAllowBlank(false);
        p.add(new FieldLabel(lembar, "Lembar"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        // layout column 0.3
        //todo: add label "Total RP "

        TextField rpTag = new TextField();
        rpTag.setAllowBlank(false);
        p.add(new FieldLabel(rpTag, "Lembar"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        TextButton btn_Hitung = new TextButton("Hitung");
        p.add(btn_Hitung);


        panel.addButton(new TextButton("Reset"));
        panel.addButton(new TextButton("Hapus"));
        btn_Simpan = new TextButton("Simpan");
        panel.addButton(btn_Simpan);

        return panel;
    }

	@Override
	protected void initEvent() {
		cb_UnitUP.setStoreUrl(WsUmumUrlConstants.UNIT_UP_URL);
		cb_UnitUP.loadStore();
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(WsUmumUrlConstants.TANGGAL_DATABASE_URL));
		try {
			builder.sendRequest(null, new RequestCallback() {
				
				@Override
				public void onResponseReceived(Request request, Response response) {
					JSONObject json = new JSONObject(JsonUtils.safeEval(response.getText()));
					GWT.log("json object : "+ json.get("result"));
					Date tanggalDatabase = DEFAULT_DATETIME_FORMATER.parse(json.get("result").toString());
					dt_Pelunasan.setValue(tanggalDatabase);
					dt_Penyetoran.setValue(tanggalDatabase);
				}
				
				@Override
				public void onError(Request request, Throwable exception) {
				}
			});
		} catch (RequestException e) {
			GWT.log("request exception catched", e);
		}
		
		cb_UnitUP.addSelectionHandler(new SelectionHandler<Map<String,String>>() {
			
			@Override
			public void onSelection(SelectionEvent<Map<String, String>> event) {
				Map<String, String> data = (Map<String, String>) event
						.getSelectedItem();
				txt_UnitUP.setValue(data.get("fieldValue"));
				
			}
		});
		
		cb_KodePP.addSelectionHandler(new SelectionHandler<Map<String,String>>() {

			@Override
			public void onSelection(SelectionEvent<Map<String, String>> event) {
				Map<String, String> data = (Map<String, String>) event
						.getSelectedItem();
				txt_KodePp.setValue(data.get("fieldValue"));
			}
		});
		
		btn_Buat.addSelectHandler(new SelectEvent.SelectHandler() {
			/*
			 * "BACN-" & cb_UnitUP.SelectedItem.Text & "/" & 
			 * cb_KodePP.SelectedItem.Text & "/" & 
			 * Format(dt_Pelunasan.Value, "yyyyMMdd") & "/" & 
			 * Format(dt_Penyetoran.Value, "yyyyMMdd") & ""
			 */
			@Override
			public void onSelect(SelectEvent event) {
				StringBuilder kodeBuktiSetor = new StringBuilder(BUKTI_SETOR_PREFIX_CODE);
				kodeBuktiSetor
						.append(cb_UnitUP.getComboBox().getSelectedText())
						.append(BUKTI_SETOR_SEPARATOR)
						.append(cb_KodePP.getComboBox().getSelectedText())
						.append(BUKTI_SETOR_SEPARATOR)
						.append(DateTimeFormat.getFormat("yyyyMMdd").format(dt_Pelunasan.getValue()))
						.append(BUKTI_SETOR_SEPARATOR)
						.append(DateTimeFormat.getFormat("yyyyMMdd").format(dt_Penyetoran.getValue()))
						.append("");
				txt_BABuktiSetor.setValue(kodeBuktiSetor.toString());
			}
		});
		
		btn_Simpan.addSelectHandler(new SelectEvent.SelectHandler() {
			
			@Override
			public void onSelect(SelectEvent event) {
				JSONObject dsJsonObject = new JSONObject();
//				TODO : create dsValue
				String dsValue = "{}";
				dsJsonObject.put("ds", new JSONObject(JsonUtils.safeEval(dsValue)));
				
				RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(WsUmumUrlConstants.TANGGAL_DATABASE_URL));
				try {
					builder.sendRequest(null, new RequestCallback() {
						
						@Override
						public void onResponseReceived(Request request, Response response) {
							JSONObject json = new JSONObject(JsonUtils.safeEval(response.getText()));
							GWT.log("json object : "+ json.get("result"));
							Date tanggalDatabase = DEFAULT_DATETIME_FORMATER.parse(json.get("result").toString());
							dt_Pelunasan.setValue(tanggalDatabase);
							dt_Penyetoran.setValue(tanggalDatabase);
						}
						
						@Override
						public void onError(Request request, Throwable exception) {
						}
					});
				} catch (RequestException e) {
					GWT.log("request exception catched", e);
				}
			}
		});
	}
}
