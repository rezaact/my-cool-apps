package id.co.hans.sample.client.form.prr;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.http.client.*;
import com.google.gwt.json.client.*;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.*;
import com.sencha.gxt.widget.core.client.toolbar.SeparatorToolItem;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import id.co.hans.sample.client.components.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class NewCetak_106 {
    private VerticalPanel vp;

    final FormPanel form = new FormPanel();

    private ComboTahunBulan comboTahunBulan;
    private ComboUnits comboUnits;

    TextField tIdPel;
    private TextButton bttnCetak, bttnFilter;

    IconDynamicGrid gpData;

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
        panel.setHeadingText("Cetak I-06");
        panel.setBodyStyle("background: none; padding: 0px");
        panel.setWidth(650);

        form.setAction("URLtoSave.json");
        form.setEncoding(FormPanel.Encoding.MULTIPART);
        form.setMethod(FormPanel.Method.POST);
        panel.add(form);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        form.add(p);

        ToolBar toolBar = new ToolBar();

        tIdPel = new TextField();
        toolBar.add(new FieldLabel(tIdPel, "ID Pelanggan"));

        toolBar.add(new SeparatorToolItem());

        bttnFilter = new TextButton("Filter");
        toolBar.add(bttnFilter);

        toolBar.add(new SeparatorToolItem());

        bttnCetak = new TextButton("Cetak");
        toolBar.add(bttnCetak);

        p.add(toolBar);

        gpData = new IconDynamicGrid();
        gpData.setStoreUrl("/Ws_Null");

        gpData.setGridHeader("Data Pelanggan");
        gpData.setGridDimension(638, 300);

        gpData.addColumn("ID", 100);
        gpData.addColumn("IDPEL", 100);
        gpData.addColumn("BLTH", 100);
        gpData.addColumn("RP_PRR", 100);

        p.add(gpData);

        return panel;
    }

    private void initEvent() {
        bttnFilter.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                gpData.setStoreUrl("/Ws_PRR/getPRR_VIEW_CETAK106.json?no_pelanggan=");
                gpData.load();
            }
        });

        bttnCetak.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi, blth;
                petugas = idUser;

                String lampiran = "", no = "";

                //unitUpi = comboUnits.getUnitUpiValue();
                //unitAp = comboUnits.getUnitApValue();
                //parUp = comboUnits.getUnitUpValue();
                //blth = comboTahunBulan.getCbTahunSelectedValue()+comboTahunBulan.getCbBulanSelectedValue();
                lampiran = "Lampiran I06";

                String url = "";

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=prr_getLampiran"
                        +"&unitupi="
                        +"&unitap="
                        +"&unitup="
                        +"&blth="
                        +"&lampiran="+lampiran
                        +"&no="+""
                        +"&idpel="+tIdPel.getText()
                        +"&unsur="+""
                        +"&pembukuan="+""
                        +"&tglmulai="+""
                        +"&tglsampai="+""
                ;

                url+="&report=report/ReportPRR/rptI06koreksi.rpt";

                com.google.gwt.user.client.Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
