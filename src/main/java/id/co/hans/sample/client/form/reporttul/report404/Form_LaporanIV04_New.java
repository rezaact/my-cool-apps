package id.co.hans.sample.client.form.reporttul.report404;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.*;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.*;

public class Form_LaporanIV04_New {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    ComboJenisPembukuan cbPembukuan;
    ComboTahunBulan cbTahunBulan;
    ComboUnsurLaporan404 cbTopPilihUnsurLaporanIV04;

    CheckBox chkSorek;
    CheckBox chkLunasOffline;
    CheckBox chkLunasTerpusat;
    CheckBox chkLunasSuplisi;
    CheckBox chkSusulan;
    CheckBox chkLunasOnline;
    CheckBox chkLunasNota;
    CheckBox chkBk;
    CheckBox chkKoreksiRekening;
    CheckBox chkKirimTerima;
    CheckBox chkBatalPiutang;

    TextButton bBottomTampilkanLaporan;
    TextButton bBottomRekapUlang;

    private RequestBuilder rb;
    private Boolean wsReturn;
    private String wsByRefError;
    private IconAlertMessageBox mb;

    AutoProgressMessageBox progressBox;

    private String idUser, levelUser, unitUser;

    public Widget asWidget(String idUser, String unitupUser, String levelUser) {
        this.idUser=idUser;
        this.unitUser=unitupUser;
        this.levelUser=levelUser;

        if (vp == null) {
            vp = new VerticalPanel();
            vp.setSpacing(5);
            initKomponen();
            initEvent();
        }
        return vp;
    }

    private void initKomponen(){
        progressBox = new AutoProgressMessageBox("Progress", "please wait");
        progressBox.setProgressText("wait...");

        vp.add(panelMain());
    }

    private FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Laporan Piutang Pelanggan Lancar (TUL IV-04)");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);


        FramedPanel panelReferensi = new FramedPanel();
        panelReferensi.setHeadingText("Pilih Referensi");
        panelReferensi.setBodyStyle("background: none; padding: 5px");
        panelReferensi.setWidth(620);

        VerticalLayoutContainer vlcPReferensi = new VerticalLayoutContainer();
        panelReferensi.add(vlcPReferensi);

        cbUnits = new ComboUnits(levelUser, unitUser, 1, 1, 1);
        vlcPReferensi.add(cbUnits);

        p.add(panelReferensi);


        FramedPanel panelPembukuan = new FramedPanel();
        panelPembukuan.setHeadingText("Pilih Parameter");
        panelPembukuan.setBodyStyle("background: none; padding: 5px");
        panelPembukuan.setWidth(620);

        VerticalLayoutContainer vlcPPembukuan = new VerticalLayoutContainer();
        panelPembukuan.add(vlcPPembukuan);

        cbPembukuan = new ComboJenisPembukuan();
        cbPembukuan.setFormAsal("Form_LaporanIV04_New");
        vlcPPembukuan.add(cbPembukuan);

        p.add(panelPembukuan);

        FramedPanel panelReferensiTgl = new FramedPanel();
        panelReferensiTgl.setHeadingText("Pilih Parameter");
        panelReferensiTgl.setBodyStyle("background: none; padding: 5px");
        panelReferensiTgl.setWidth(620);

        VerticalLayoutContainer vlcPReferensiTgl = new VerticalLayoutContainer();
        panelReferensiTgl.add(vlcPReferensiTgl);

        cbTahunBulan = new ComboTahunBulan();
        vlcPReferensiTgl.add(cbTahunBulan);

        cbTopPilihUnsurLaporanIV04 = new ComboUnsurLaporan404();
        vlcPReferensiTgl.add(cbTopPilihUnsurLaporanIV04);

        p.add(panelReferensiTgl);


        FramedPanel panelReferensiJnsLaporan = new FramedPanel();
        panelReferensiJnsLaporan.setHeadingText("Jenis Transaksi Untuk Direkap Ulang");
        panelReferensiJnsLaporan.setBodyStyle("background: none; padding: 5px");
        panelReferensiJnsLaporan.setWidth(620);

        VerticalLayoutContainer vlcPReferensiJnsLaporan = new VerticalLayoutContainer();
        panelReferensiJnsLaporan.add(vlcPReferensiJnsLaporan);

        chkSorek = new CheckBox();
        chkSorek.setBoxLabel("Sorek");

        chkLunasOffline = new CheckBox();
        chkLunasOffline.setBoxLabel("Lunas Offline");

        chkLunasTerpusat = new CheckBox();
        chkLunasTerpusat.setBoxLabel("Lunas Terpusat");

        chkLunasSuplisi = new CheckBox();
        chkLunasSuplisi.setBoxLabel("Lunas Suplisi");

        chkSusulan = new CheckBox();
        chkSusulan.setBoxLabel("Susulan");

        chkLunasOnline = new CheckBox();
        chkLunasOnline.setBoxLabel("Lunas Online");

        chkLunasNota = new CheckBox();
        chkLunasNota.setBoxLabel("Lunas Nota/Beban Kantor/Memo");

        chkBk = new CheckBox();
        chkBk.setBoxLabel("BK");

        chkKoreksiRekening = new CheckBox();
        chkKoreksiRekening.setBoxLabel("Koreksi Rekening");

        chkKirimTerima = new CheckBox();
        chkKirimTerima.setBoxLabel("Kirim / Terima");

        chkBatalPiutang = new CheckBox();
        chkBatalPiutang.setBoxLabel("Batal Piutang");

        chkSorek.setWidth(120);
        chkLunasSuplisi.setWidth(120);
        chkLunasNota.setWidth(220);
        chkKirimTerima.setWidth(120);

        chkLunasOffline.setWidth(120);
        chkSusulan.setWidth(120);
        chkBk.setWidth(220);
        chkBatalPiutang.setWidth(120);

        chkLunasTerpusat.setWidth(120);
        chkLunasOnline.setWidth(120);
        chkKoreksiRekening.setWidth(120);

        HorizontalPanel hp1 = new HorizontalPanel();
        hp1.add(chkSorek);
        hp1.add(chkLunasSuplisi);
        hp1.add(chkLunasNota);
        hp1.add(chkKirimTerima);

        vlcPReferensiJnsLaporan.add(hp1);

        hp1 = new HorizontalPanel();
        hp1.add(chkLunasOffline);
        hp1.add(chkSusulan);
        hp1.add(chkBk);
        hp1.add(chkBatalPiutang);

        vlcPReferensiJnsLaporan.add(hp1);

        vlcPReferensiJnsLaporan.add(hp1);

        hp1 = new HorizontalPanel();
        hp1.add(chkLunasTerpusat);
        hp1.add(chkLunasOnline);
        hp1.add(chkKoreksiRekening);

        vlcPReferensiJnsLaporan.add(hp1);

        p.add(panelReferensiJnsLaporan);


        FramedPanel panelButton = new FramedPanel();
        panelButton.setBodyStyle("background: none; padding: 5px");
        panelButton.setWidth(620);

        VerticalLayoutContainer vlcPButton = new VerticalLayoutContainer();
        panelButton.add(vlcPButton);

        bBottomTampilkanLaporan = new TextButton("Tampilkan Laporan");
        bBottomTampilkanLaporan.setWidth(220);

        bBottomRekapUlang = new TextButton("Rekap Ulang");
        bBottomRekapUlang.setWidth(220);

        hp1 = new HorizontalPanel();
        hp1.add(bBottomTampilkanLaporan);
        hp1.add(bBottomRekapUlang);
        vlcPButton.add(hp1);

        p.add(panelButton);

        return panel;
    }


    private void initEvent() {
        bBottomTampilkanLaporan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                if (cbPembukuan.getSelectedValue().equals("")) {
                    mb = new IconAlertMessageBox("Kesalahan", "Jenis pembukuan belum dipilih", true);
                    return;
                }

                String parUp, jenis="", petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();
                petugas = idUser;

                String satuan = "";

                if (cbUnits.getUnitUpiValue().equals("SEMUA")) {
                    parUp = cbUnits.getUnitUpiValue();
                    satuan = "UPI";
                } else if (cbUnits.getUnitApValue().equals("SEMUA")) {
                    parUp = cbUnits.getUnitApValue();
                    satuan = "AP";
                } else {
                    parUp = cbUnits.getUnitUpValue();
                    satuan = "UP";
                }

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=ambilLaporan404"
                        +"&parUp="+parUp
                        +"&parUnsur="+cbTopPilihUnsurLaporanIV04.getSelectedValue()
                        +"&thbl="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&petugas="+petugas
                        +"&pembukuan="+cbPembukuan.getSelectedValue()
                        +"&satuan="+satuan
                        +"&tparupi="+unitUpi
                        +"&tparap="+unitAp
                        +"&tparup="+parUp
                        +"&tblth="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        ;

                url+="&report=report/ReportTUL/TUL4/rptTul404.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bBottomRekapUlang.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {

                StringBuilder sTrans = new StringBuilder();
                if (chkSorek.getValue())
                    if (sTrans.length() == 0) sTrans.append("").append("sorek"); else sTrans.append(",").append("sorek");

                if (chkKoreksiRekening.getValue())
                    if (sTrans.length() == 0) sTrans.append("").append("koreksi"); else sTrans.append(",").append("koreksi");

                if (chkSusulan.getValue())
                    if (sTrans.length() == 0) sTrans.append("").append("susulan"); else sTrans.append(",").append("susulan");

                if (chkLunasOffline.getValue())
                    if (sTrans.length() == 0) sTrans.append("").append("dphoffline"); else sTrans.append(",").append("dphoffline");

                if (chkLunasOnline.getValue())
                    if (sTrans.length() == 0) sTrans.append("").append("dphbaru"); else sTrans.append(",").append("dphbaru");

                if (chkLunasNota.getValue())
                    if (sTrans.length() == 0) sTrans.append("").append("dphnota"); else sTrans.append(",").append("dphnota");

                if (chkLunasTerpusat.getValue())
                    if (sTrans.length() == 0) sTrans.append("").append("dltbaru"); else sTrans.append(",").append("dltbaru");

                if (chkLunasSuplisi.getValue())
                    if (sTrans.length() == 0) sTrans.append("").append("dphresup"); else sTrans.append(",").append("dphresup");

                if (chkKirimTerima.getValue())
                    if (sTrans.length() == 0) sTrans.append("").append("kirimterima"); else sTrans.append(",").append("kirimterima");

                if (chkBatalPiutang.getValue())
                    if (sTrans.length() == 0) sTrans.append("").append("dbpbaru"); else sTrans.append(",").append("dbpbaru");

                if (chkBk.getValue())
                    if (sTrans.length() == 0) sTrans.append("").append("bk"); else sTrans.append(",").append("bk");

                if (sTrans.length() == 0) {
                    mb = new IconAlertMessageBox("Kesalahan", "Transaksi yang akan direkap ulang belum ditentukan !", true);
                }

                String parUp, jenis="", petugas, unitAp, unitUpi;
                petugas = idUser;
                String satuan = "";

                if (cbUnits.getUnitUpiValue().equals("SEMUA")) {
                    parUp = cbUnits.getUnitUpiValue();
                    satuan = "UPI";
                } else if (cbUnits.getUnitApValue().equals("SEMUA")) {
                    parUp = cbUnits.getUnitApValue();
                    satuan = "AP";
                } else {
                    parUp = cbUnits.getUnitUpValue();
                    satuan = "UP";
                }


                try {
                    rb = new RequestBuilder(RequestBuilder.POST, "Ws_404Controller/RekapUlang404.json");
                    rb.setHeader("Content-type", "application/x-www-form-urlencoded");

                    StringBuilder sb = new StringBuilder();
                    sb.append("parBLTH=" + cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue());
                    sb.append("&parUnit="+parUp);
                    sb.append("&parPetugas="+petugas);
                    sb.append("&parJenisTrans="+sTrans.toString());
                    sb.append("&parSatuan="+satuan);

                    rb.sendRequest(sb.toString(), new RequestCallback() {
                        @Override
                        public void onResponseReceived(Request request, Response response) {

                            progressBox.hide();

                            if (200 == response.getStatusCode()) {
                                JSONValue value = JSONParser.parse(response.getText());
                                JSONObject jsonObject = value.isObject();

                                wsReturn = jsonObject.get("result").isObject().get("wsReturn").isBoolean().booleanValue();

                                if (wsReturn) {
                                    mb = new IconAlertMessageBox("Informasi", "Proses rekap ulang berhasil dilakukan", true);
                                } else {
                                    wsByRefError = jsonObject.get("result").isObject().get("wsByRefError").isString().stringValue();
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

                    progressBox.show();
                } catch (RequestException ex) {
                    mb = new IconAlertMessageBox("Kesalahan", ex.getMessage(), true);
                }
            }
        });
    }
}
