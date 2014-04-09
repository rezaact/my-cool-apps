package id.co.hans.sample.client.form.administrasi;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.http.client.*;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.*;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.DateCell;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.TextField;
import id.co.hans.sample.client.components.*;

import java.util.Date;
import java.util.Map;

public class Form_MasterJatuhTempo {
    private VerticalPanel vp;

    final FormPanel form = new FormPanel();

    private ComboUnit cb_unitup;
    private ComboTahunBulan comboTahunBulan;
    private ComboUnits comboUnits;
    private IconDynamicGrid dgDILMUM;

    private TextButton bttnNew, bttnEdit, bttnDelete;
    private TextButton bttnSave, bttnCancel;

    private DateField dtJTTempo;
    private TextField txt_Periode;
    private DateField dtBK1, dtBK2, dtBK3;


    final Window window = new Window();
    final FormPanel formWindow = new FormPanel();

    private ComboUnit cb_kodeunit;
    private ComboTahunBulan childcboTahunBulan;
    private ComboKodeSiklis cb_KlpSiklis;

    private IconAlertMessageBox mb;
    private RequestBuilder rb;

    private String wsResult;
    private Boolean wsReturn;
    private String wsByRefError;

    private frmMode MODE;


    private String idUser, levelUser, unitUser;

    public Widget asWidget(String idUser, String unitupUser, String levelUser) {
        this.idUser=idUser;
        this.unitUser=unitupUser;
        this.levelUser=levelUser;

        if (vp == null) {
            vp = new VerticalPanel();
            vp.setSpacing(5);
            initKomponen();
            initWindow();
            initEvent();
        }
        return vp;
    }

    private void initKomponen(){
//        AutoProgressMessageBox progressBox = new AutoProgressMessageBox("Progress", "please wait");
//        progressBox.setProgressText("wait...");

        vp.add(panelMain());
    }

    private FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Master Jadwal Siklis (Tanggal Jatuh Tempo)");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        form.setAction("URLtoSave.json");
        form.setEncoding(FormPanel.Encoding.MULTIPART);
        form.setMethod(FormPanel.Method.POST);
        panel.add(form);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        form.add(p);

        cb_unitup = new ComboUnit(this.levelUser, this.unitUser);
        p.add(cb_unitup);

        comboTahunBulan = new ComboTahunBulan();
        p.add(comboTahunBulan);

        dgDILMUM = new IconDynamicGrid();
        dgDILMUM.setGridHeader("Tab Jatuh Tempo");
        dgDILMUM.setGridHeight(150);
        dgDILMUM.setGridWidth(620);

        StringBuilder sb = new StringBuilder();
        sb.append("tTHBL=" + comboTahunBulan.getCbTahunSelectedValue() + comboTahunBulan.getCbBulanSelectedValue());
        sb.append("&tUNIT=" + cb_unitup.getSelectedValue());

        dgDILMUM.setStoreUrl("Ws_Transaksi/GetViewKODEKELOMPOKUNIT.json?");
        dgDILMUM.setUrlParameters(sb.toString());

        dgDILMUM.addColumn("UNITUP", 100);
        dgDILMUM.addColumn("KODESIKLIS", 100);
        dgDILMUM.addColumn("PERIODE", 100);
        dgDILMUM.addColumn("JATUHTEMPO", 100);
        dgDILMUM.addColumn("THBL", 100);
        dgDILMUM.addColumn("BK1", 100);
        dgDILMUM.addColumn("BK1", 100);
        dgDILMUM.addColumn("BK1", 100);

        p.add(dgDILMUM);

        bttnNew = new TextButton("New");
        bttnDelete = new TextButton("Delete");
        bttnEdit = new TextButton("Edit");

        panel.addButton(bttnNew);
        panel.addButton(bttnDelete);
        panel.addButton(bttnEdit);

        return panel;
    }

    private void initEvent() {
        bttnSave.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String url;

                if (MODE == frmMode.ADD) {
                    url = "Ws_JatuhTempo/InsertJatuhTempo.json?";
                } else {
                    url = "Ws_JatuhTempo/UpdateJatuhTempo.json?";
                }


                StringBuilder sb = new StringBuilder();
                sb.append("UNITUP=" + cb_unitup.getSelectedValue());
                sb.append("&KODESIKLIS=" + cb_KlpSiklis.getSelectedValue());
                sb.append("&PERIODE=" + txt_Periode.getText());
                sb.append("&THBL=" + comboTahunBulan.getCbTahunSelectedValue() + comboTahunBulan.getCbBulanSelectedValue());
                sb.append("&JATUHTEMPO=" + dtJTTempo.getValue());
                sb.append("&BK1=" + dtBK1.getValue());
                sb.append("&BK2=" + dtBK2.getValue());
                sb.append("&BK3=" + dtBK3.getValue());


                try {
                    rb = new RequestBuilder(RequestBuilder.POST, url);
                    rb.setHeader("Content-type", "application/x-www-form-urlencoded");
                    rb.sendRequest(sb.toString(), new RequestCallback() {
                        @Override
                        public void onResponseReceived(Request request, Response response) {
                            if (200 == response.getStatusCode()) {
                                JSONValue value = JSONParser.parse(response.getText());
                                JSONObject jsonObject = value.isObject();

                                wsReturn = jsonObject.get("wsReturn").isBoolean().booleanValue();

                                if (wsReturn) {
                                    mb = new IconAlertMessageBox("Informasi", "Data tersimpan", true);
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

        bttnCancel.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                //do nothing
            }
        });

        bttnNew.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
//                Calendar c = Calendar.getInstance();
//                c.setTime(new Date());

                MODE = frmMode.ADD;
                cb_kodeunit.getCbUnitUpDesc().setText(cb_unitup.getCbUnitUpDesc().getText());
                childcboTahunBulan.getCbBulan().getComboBox().select(comboTahunBulan.getCbBulanSelectedValue());
                childcboTahunBulan.getCbTahun().getComboBox().select(comboTahunBulan.getCbTahunSelectedValue());
                cb_KlpSiklis.setEnabled(true);
                txt_Periode.setText("");

//                dtJTTempo.setValue(c.getTime());
//                dtBK1.setValue(c.getTime());

//                c.add(Calendar.MONTH, 1);
//                dtBK2.setValue(c.getTime());
//
//                c.add(Calendar.MONTH, 1);
//                dtBK3.setValue(c.getTime());

                txt_Periode.setText("INPUT PERIODE");
            }
        });

        bttnDelete.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {

//                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                DateTimeFormat formatter = DateTimeFormat.getFormat("yyyy/MM/dd");
                String url;

                url = "Ws_JatuhTempo/DeleteJatuhTempo.json?";

                StringBuilder sb = new StringBuilder();
                sb.append("UNITUP=" + cb_unitup.getSelectedValue());
                sb.append("&KODESIKLIS=" + cb_KlpSiklis.getSelectedValue());
//                sb.append("&JATUHTEMPO=" + formatter.format(dtJTTempo.getValue()));

                try {
                    rb = new RequestBuilder(RequestBuilder.POST, url);
                    rb.setHeader("Content-type", "application/x-www-form-urlencoded");
                    rb.sendRequest(URL.encode(sb.toString()), new RequestCallback() {
                        @Override
                        public void onResponseReceived(Request request, Response response) {
                            if (200 == response.getStatusCode()) {
                                JSONValue value = JSONParser.parse(response.getText());
                                JSONObject jsonObject = value.isObject();

                                wsByRefError = jsonObject.get("result").isObject().get("wsByRefError").isString().stringValue();

                                if (wsByRefError == "") {
                                    mb = new IconAlertMessageBox("Informasi", "Data tersimpan", true);
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
        });

        bttnEdit.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                MODE = frmMode.EDIT;
                cb_kodeunit.getCbUnitUpDesc().setText(cb_unitup.getCbUnitUpDesc().getText());
                cb_KlpSiklis.setEnabled(false);

                tabjatuh_tempo_lookup();
            }
        });

        dtJTTempo.addValueChangeHandler(new ValueChangeHandler<Date>() {
            @Override
            public void onValueChange(ValueChangeEvent<Date> dateValueChangeEvent) {
//                Calendar c = Calendar.getInstance();
//                c.setTime(dateValueChangeEvent.getValue());
//
//                dtBK1.setValue(c.getTime());
//
//                c.add(Calendar.MONTH, 1);
//                dtBK2.setValue(c.getTime());
//
//                c.add(Calendar.MONTH, 1);
//                dtBK3.setValue(c.getTime());
            }
        });

        comboTahunBulan.getCbBulan().addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> mapSelectionEvent) {
                tabjatuh_tempo_lookup();
            }
        });
    }


    //
    private void initWindow() {
        window.setHeadingText("Form Jatuh Tempo");
        window.setVisible(false);
        window.setModal(true);

        window.add(initFormWindow());
    }

    private FramedPanel initFormWindow() {
        FramedPanel panel = new FramedPanel();
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        formWindow.setAction("URLtoSave.json");
        formWindow.setEncoding(FormPanel.Encoding.MULTIPART);
        formWindow.setMethod(FormPanel.Method.POST);
        panel.add(formWindow);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        formWindow.add(p);

        cb_kodeunit = new ComboUnit();
        p.add(cb_kodeunit);

        childcboTahunBulan = new ComboTahunBulan();
        p.add(childcboTahunBulan);

        cb_KlpSiklis = new ComboKodeSiklis();
        p.add(cb_KlpSiklis);

        dtJTTempo = new DateField();
        p.add(new FieldLabel(dtJTTempo, "Tgl Jatuh Tempo"));

        txt_Periode = new TextField();
        p.add(new FieldLabel(txt_Periode, "Input Periode"));

        dtBK1 = new DateField();
        p.add(new FieldLabel(dtBK1, "Tgl JT BK1"));

        dtBK2 = new DateField();
        p.add(new FieldLabel(dtBK2, "Tgl JT BK2"));

        dtBK3 = new DateField();
        p.add(new FieldLabel(dtBK3, "Tgl JT BK3"));

        bttnSave = new TextButton("OK");
        bttnCancel = new TextButton("CANCEL");

        panel.addButton(bttnSave);
        panel.addButton(bttnCancel);

        return panel;
    }

    public void tabjatuh_tempo_lookup() {
        StringBuilder sb = new StringBuilder();
        sb.append("tTHBL=" + comboTahunBulan.getCbTahunSelectedValue() + comboTahunBulan.getCbBulanSelectedValue());
        sb.append("&tUNIT=" + cb_unitup.getSelectedValue());

        dgDILMUM.setStoreUrl("Ws_Transaksi/GetViewKODEKELOMPOKUNIT.json?");
        dgDILMUM.setUrlParameters(sb.toString());
        dgDILMUM.load();
    }

    public enum frmMode {
        ADD,
        EDIT
    }

}
