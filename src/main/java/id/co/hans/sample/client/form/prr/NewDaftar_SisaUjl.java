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

public class NewDaftar_SisaUjl {
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
//        AutoProgressMessageBox progressBox = new AutoProgressMessageBox("Progress", "please wait");
//        progressBox.setProgressText("wait...");

        vp.add(panelMain());
    }

    private FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Daftar Sisa UJL");
        panel.setBodyStyle("background: none; padding: 0px");
        panel.setWidth(650);

        form.setAction("URLtoSave.json");
        form.setEncoding(FormPanel.Encoding.MULTIPART);
        form.setMethod(FormPanel.Method.POST);
        panel.add(form);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        form.add(p);

        ToolBar toolBar = new ToolBar();

        bttnFilter = new TextButton("Filter");
        toolBar.add(bttnFilter);

        p.add(toolBar);


        comboUnits = new ComboUnits(levelUser, unitUser, 1, 1, 1);
        p.add(comboUnits);


        IconDynamicGrid gpData = new IconDynamicGrid();
        gpData.setStoreUrl("/Ws_Null");

        gpData.setGridHeader("Data Pelanggan");
        gpData.setGridDimension(638, 300);

        gpData.addColumn("IDPEL", 100);
        gpData.addColumn("RPUJL", 100);
        gpData.addColumn("RPTAG", 100);
        gpData.addColumn("SISA", 100);

        p.add(gpData);

        return panel;
    }

    private void initEvent() {
        bttnFilter.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
            }
        });
    }
}
