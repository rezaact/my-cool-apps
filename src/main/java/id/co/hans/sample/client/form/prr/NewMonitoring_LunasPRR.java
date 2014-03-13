package id.co.hans.sample.client.form.prr;

import com.google.gwt.http.client.*;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.*;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import id.co.hans.sample.client.components.*;

public class NewMonitoring_LunasPRR {
    private VerticalPanel vp;

    final FormPanel form = new FormPanel();

    private ComboTahunBulan comboTahunBulan;
    private ComboUnits comboUnits;

    private TextButton bttnCetak, bttnFilter, bttnReset;

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
        panel.setHeadingText("Monitoring Lunas PRR");
        panel.setBodyStyle("background: none; padding: 0px");
        panel.setWidth(650);

        form.setAction("URLtoSave.json");
        form.setEncoding(FormPanel.Encoding.MULTIPART);
        form.setMethod(FormPanel.Method.POST);
        panel.add(form);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        form.add(p);

        ToolBar toolBar = new ToolBar();

        bttnCetak = new TextButton("Cetak");
        toolBar.add(bttnCetak);

        p.add(toolBar);

        comboUnits = new ComboUnits();
        p.add(comboUnits);

        VerticalLayoutContainer vlc = new VerticalLayoutContainer();
        HorizontalPanel hp = new HorizontalPanel();

        DateField deAwal = new DateField();
        Label label = new Label(" - ");
        DateField deAkhir = new DateField();

        hp.add(deAwal);
        hp.add(label);
        hp.add(deAkhir);

        vlc.add(new FieldLabel(hp, "Tanggal"));
        p.add(vlc);

        return panel;
    }

    private void initEvent() {
        bttnCetak.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
            }
        });
    }
}
