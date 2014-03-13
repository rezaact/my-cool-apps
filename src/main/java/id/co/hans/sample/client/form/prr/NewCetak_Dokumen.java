package id.co.hans.sample.client.form.prr;

import com.google.gwt.http.client.*;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.*;
import com.sencha.gxt.widget.core.client.toolbar.SeparatorToolItem;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import id.co.hans.sample.client.components.*;

public class NewCetak_Dokumen {
    private VerticalPanel vp;

    final FormPanel form = new FormPanel();

    private ComboTahunBulan comboTahunBulan;
    private ComboUnits comboUnits;

    private TextButton bttnSimpan, bttnFilter;

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
        panel.setHeadingText("Cetak Dokumen");
        panel.setBodyStyle("background: none; padding: 0px");
        panel.setWidth(650);

        form.setAction("URLtoSave.json");
        form.setEncoding(FormPanel.Encoding.MULTIPART);
        form.setMethod(FormPanel.Method.POST);
        panel.add(form);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        form.add(p);

        ToolBar toolBar = new ToolBar();

        //combobox

        toolBar.add(new SeparatorToolItem());

        TextField tKriteria = new TextField();
        toolBar.add(new FieldLabel(tKriteria, "Kriteria"));

        toolBar.add(new SeparatorToolItem());

        bttnFilter = new TextButton("Filter");
        toolBar.add(bttnFilter);

        toolBar.add(new SeparatorToolItem());

        bttnSimpan = new TextButton("Simpan");
        toolBar.add(bttnSimpan);

        p.add(toolBar);

        VerticalLayoutContainer vlc = new VerticalLayoutContainer();

        HorizontalPanel hp = new HorizontalPanel();

        TextField tVI01 = new TextField();
        TextField tKVI01 = new TextField();

        hp.add(tVI01);
        hp.add(tKVI01);

        vlc.add(new FieldLabel(hp, "VI-01"));

        p.add(vlc);

        vlc = new VerticalLayoutContainer();

        hp = new HorizontalPanel();

        TextField tVI03 = new TextField();
        TextField tKVI03 = new TextField();

        hp.add(tVI03);
        hp.add(tKVI03);

        vlc.add(new FieldLabel(hp, "VI-03"));

        p.add(vlc);

        vlc = new VerticalLayoutContainer();

        hp = new HorizontalPanel();

        TextField tI09 = new TextField();
        TextField tKI09 = new TextField();

        hp.add(tI09);
        hp.add(tKI09);

        vlc.add(new FieldLabel(hp, "I-09"));

        p.add(vlc);

        vlc = new VerticalLayoutContainer();

        hp = new HorizontalPanel();

        TextField tI10 = new TextField();
        TextField tKI10 = new TextField();

        hp.add(tI10);
        hp.add(tKI10);

        vlc.add(new FieldLabel(hp, "I-10"));

        p.add(vlc);

        vlc = new VerticalLayoutContainer();

        hp = new HorizontalPanel();

        TextField tI11 = new TextField();
        TextField tKI11 = new TextField();

        hp.add(tI11);
        hp.add(tKI11);

        vlc.add(new FieldLabel(hp, "I-11"));

        p.add(vlc);

        vlc = new VerticalLayoutContainer();

        hp = new HorizontalPanel();

        TextField tTUG10 = new TextField();
        TextField tKTUG10 = new TextField();

        hp.add(tTUG10);
        hp.add(tKTUG10);

        vlc.add(new FieldLabel(hp, "Kode 3"));

        p.add(vlc);


        IconDynamicGrid gpData = new IconDynamicGrid();
        gpData.setStoreUrl("/Ws_Null");

        gpData.setGridHeader("Data Pelanggan");
        gpData.setGridDimension(638, 300);

        gpData.addColumn("ID", 100);
        gpData.addColumn("NO_USULANDUPR", 100);
        gpData.addColumn("IDPEL", 100);
        gpData.addColumn("BLTH", 100);
        gpData.addColumn("UNITUP", 100);
        gpData.addColumn("NAMA", 100);
        gpData.addColumn("NAMAPNJ", 100);
        gpData.addColumn("RPTUNGGAKAN", 100);

        p.add(gpData);

        return panel;
    }

    private void initEvent() {
        bttnFilter.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
            }
        });

        bttnSimpan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
            }
        });
    }
}
