package id.co.hans.sample.client.form.prr;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.http.client.*;
import com.google.gwt.json.client.*;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Lampiran {
    private VerticalPanel vp;

    final FormPanel form = new FormPanel();

    private ComboTahunBulan comboTahunBulan;
    private ComboUnits comboUnits;

    Radio rUmum, rNonUmum;

    private TextButton bttnCetak, bExcel;

    private IconAlertMessageBox mb;
    private RequestBuilder rb;

    private String wsResult;
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
//        AutoProgressMessageBox progressBox = new AutoProgressMessageBox("Progress", "please wait");
//        progressBox.setProgressText("wait...");

        vp.add(panelMain());
    }

    private FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("LAPORAN KHUSUS PIUTANG RAGU-RAGU");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        form.setAction("URLtoSave.json");
        form.setEncoding(FormPanel.Encoding.MULTIPART);
        form.setMethod(FormPanel.Method.POST);
        panel.add(form);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        form.add(p);

        comboUnits = new ComboUnits();
        p.add(comboUnits);

        comboTahunBulan = new ComboTahunBulan();
        p.add(comboTahunBulan);

        TextField tNoBA = new TextField();
        p.add(new FieldLabel(tNoBA, "No BA"));

        FieldSet fsGolongan = new FieldSet();
        fsGolongan.setHeadingText("Golongan Pelanggan");

        VerticalLayoutContainer vlcFsGolongan = new VerticalLayoutContainer();

        rUmum = new Radio();
        rUmum.setBoxLabel("Pelanggan Umum");

        rNonUmum = new Radio();
        rNonUmum.setBoxLabel("Pelaggan Pemerintah,PEMDA,BUMN, BUMD");

        vlcFsGolongan.add(rUmum);
        vlcFsGolongan.add(rNonUmum);

        fsGolongan.setWidget(vlcFsGolongan);

        p.add(fsGolongan);

        ComboJenisLaporan cLaporan = new ComboJenisLaporan();
        cLaporan.setFormAsal("prr.lampiran_ia");
        p.add(cLaporan);

        bttnCetak = new TextButton("Cetak");
        bExcel = new TextButton("To Excel");

        panel.addButton(bttnCetak);
        panel.addButton(bExcel);

        return panel;
    }

    private void initEvent() {
        bttnCetak.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
            }
        });

        bExcel.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
            }
        });
    }
}
