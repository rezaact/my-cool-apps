package id.co.hans.sample.client.form.cetakulang;

import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.http.client.*;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.*;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import id.co.hans.sample.client.components.ComboKodeKolektif;
import id.co.hans.sample.client.components.IconAlertMessageBox;
import id.co.hans.sample.client.components.IconDynamicGrid;
import id.co.hans.sample.client.components.JsonHelper;
import org.apache.commons.logging.LogFactory;

//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.*;

public class Form_CetakUlangBebanKantor {
//    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Form_CetakUlangBebanKantor.class);

    String strGlobalUnitupPetugas, strGlobalKodePetugas;
    Integer iBebanKantor = 1;

    private VerticalPanel vp;

    private IconDynamicGrid GdCetakUlang;
    private ComboKodeKolektif cb_Kolektif;
    private DateField duPelunasan;
    private TextField txtalasan;
    private TextButton bAmbilData, bCetak303;


    private IconAlertMessageBox mb;
    private RequestBuilder rb;

    private String wsResult;
    private List<Map<String, String>> wsReturn;
    private String wsByRefError;

    private List<Map<String, String>> dsKolektif = new ArrayList<Map<String, String>>();
    private List<Map<String, String>> dsPayment = new ArrayList<Map<String, String>>();
    private List<Map<String, String>> dsCetak = new ArrayList<Map<String, String>>();

    public Widget asWidget() {
        if (vp == null) {
            vp = new VerticalPanel();
            vp.setSpacing(5);
            initKomponen();
            initEvent();
            Page_Load();
        }
        return vp;
    }

    private void initKomponen() {
//        AutoProgressMessageBox progressBox = new AutoProgressMessageBox("Progress", "please wait");
//        progressBox.setProgressText("wait...");

        vp.add(panelMain());
    }

    private FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Cetak Ulang Beban Kantor");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);


        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        cb_Kolektif = new ComboKodeKolektif();
        p.add(cb_Kolektif);

        duPelunasan = new DateField();
        p.add(new FieldLabel(duPelunasan, "Pilih Tanggal Lunas"));

        txtalasan = new TextField();
        p.add(new FieldLabel(txtalasan, "Alasan"));

        bAmbilData = new TextButton("Ambil Data");
        bCetak303 = new TextButton("Cetak III-03");

        panel.addButton(bAmbilData);
        panel.addButton(bCetak303);


        GdCetakUlang = new IconDynamicGrid();
        GdCetakUlang.setGridHeader("Data pelanggan yang akan dicetak ulang");
        GdCetakUlang.setGridHeight(150);
        GdCetakUlang.setGridWidth(620);
        GdCetakUlang.setStoreUrl("empty.json");

        GdCetakUlang.addColumn("Simpan", 100);
        GdCetakUlang.addColumn("HASIL", 150);
        GdCetakUlang.addColumn("BLTHTAG", 90);
        GdCetakUlang.addColumn("NO_PELANGGAN", 70);
        GdCetakUlang.addColumn("NAMA_PELANGGAN", 70);
        GdCetakUlang.addColumn("NAMA_JALAN", 70);
        GdCetakUlang.addColumn("STATUS", 70);
        GdCetakUlang.addColumn("RPTAG", 70);
        GdCetakUlang.addColumn("RPBK", 70);
        GdCetakUlang.addColumn("KODEPP", 70);
        GdCetakUlang.addColumn("TGLLUNAS", 70);
        GdCetakUlang.addColumn("TARIP", 70);
        GdCetakUlang.addColumn("DAYA", 70);
        GdCetakUlang.addColumn("TOTALKWH", 70);
        GdCetakUlang.addColumn("STANDAKHIRLWBPKWH", 70);
        GdCetakUlang.addColumn("STANDAKHIRWBP", 70);
        GdCetakUlang.addColumn("STANDAKHIRKVARH", 70);
        GdCetakUlang.addColumn("TOTAL", 70);
        GdCetakUlang.addColumn("PPJU", 70);
        GdCetakUlang.addColumn("RPPPN", 70);
        GdCetakUlang.addColumn("RPMATERAIREK", 70);
        GdCetakUlang.addColumn("STANDAWALLWBPKWH", 70);
        GdCetakUlang.addColumn("STANDAWALWBP", 70);
        GdCetakUlang.addColumn("STANDAWALKVARH", 70);
        GdCetakUlang.addColumn("REF", 70);
        GdCetakUlang.addColumn("ANGSURAN", 70);
        GdCetakUlang.addColumn("RPBIAYABEBAN", 70);
        GdCetakUlang.addColumn("RPPTL", 70);
        GdCetakUlang.addColumn("FAKTOR_KALI_METER", 70);
        GdCetakUlang.addColumn("PERIODEBAYAR", 70);
        GdCetakUlang.addColumn("JENIS", 70);
        GdCetakUlang.addColumn("UNITUP", 70);
        GdCetakUlang.addColumn("NOMOR", 70);

        p.add(GdCetakUlang);

        GdCetakUlang.getView().setStripeRows(true);
        GdCetakUlang.getView().setColumnLines(true);

        return panel;
    }


    private void initEvent() {
        bAmbilData.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                if (cb_Kolektif.getSelectedValue() == "") {
                    mb = new IconAlertMessageBox("Kesalahan", "Kode Kolektif belum dipilih!", true);
                    return;
                }

                if (txtalasan.getText().trim() == "") {
                    mb = new IconAlertMessageBox("Kesalahan", "Alasan cetak ulang harus ditentukan !", true);
                    return;
                }

                GdCetakUlang.setStoreUrl("Ws_PrintStruk/getCetul_23NotaBuku.json?" + "strPetugas=aaa&sKodeKolektif=1&sTglLunas=1&tUnitup=1");
                GdCetakUlang.setUrlParameters("ganteng=1");
                GdCetakUlang.load();
            }
        });
    }

    private void Page_Load() {
        String url;
        url = "Ws_Transaksi/GetViewKODEKOLEKTIF23NOTAUNITUP.json?";

        StringBuilder sb = new StringBuilder();
        sb.append("sunitup=" + strGlobalUnitupPetugas);
        sb.append("&iBebanKantor=" + iBebanKantor);

        try {
            rb = new RequestBuilder(RequestBuilder.GET, url + URL.encode(sb.toString()));
            rb.setHeader("Content-type", "application/x-www-form-urlencoded");

            rb.sendRequest(null, new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    if (200 == response.getStatusCode()) {
                        try {
//                            JSONObject jsonObject = new JSONObject(response.getText());

                            JSONObject jsonObject = new JSONObject(JsonUtils.safeEval(response.getText()));

                            console(jsonObject.get("wsReturn").toString());

                            Map<String, Object> obj = new HashMap<String, Object>();
//                            obj = JsonHelper.toMap(jsonObject);

                            mb = new IconAlertMessageBox("debug", obj.get("result").toString(), true);
                        } catch (JSONException ex) {
                            mb = new IconAlertMessageBox("ERROR", "JSON Parser --> Lihat JsonHelper.", true);
                        }


                        if (wsByRefError == "") {
                            //dsKolektif = (List<Map<String,String>>) jsonObject.get("result").isObject().get("wsReturn").isObject();

                            //mb = new IconAlertMessageBox("debug", "size dsKolektif: " + jsonObject.get("result").isObject().get("wsReturn").isString(), true);

                            //wsReturn = (List<Map<String, String>>)jsonObject.get("result").isObject().get("wsReturn").isObject();
                        } else {
                            mb = new IconAlertMessageBox("Kesalahan1", wsByRefError, true);
                            cb_Kolektif.getTfDescription().setText("KODE KOLEKTIF BELUM DIPILIH");
                        }
                    } else {
                        mb = new IconAlertMessageBox("Kesalahan2", "HTTP Error code: " + response.getStatusCode(), true);
                    }
                }

                @Override
                public void onError(Request request, Throwable throwable) {
                    mb = new IconAlertMessageBox("Kesalahan3", throwable.getMessage(), true);
                }
            });
        } catch (RequestException ex) {
            mb = new IconAlertMessageBox("Kesalahan4", ex.getMessage(), true);
        }

        bCetak303.setEnabled(false);
    }

    public static native void console(String text)
    /*-{
        console.log(text);
    }-*/;
}
