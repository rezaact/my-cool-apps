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

public class Monitoring_Hapus_PRR {
    private VerticalPanel vp;

    final FormPanel form = new FormPanel();

    private ComboTahunBulan comboTahunBulan;
    private ComboUnits comboUnits;

    Radio rUmum, rNonUmum;

    private TextButton bttnCetak, bttnFilterl;

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
        panel.setHeadingText("Monitoring Hapus PRR");
        panel.setBodyStyle("background: none; padding: 5px");
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

        comboUnits = new ComboUnits(levelUser, unitUser, 1, 1, 1);
        p.add(comboUnits);

        comboTahunBulan = new ComboTahunBulan();
        p.add(comboTahunBulan);

        return panel;
    }

    private void initEvent() {
        bttnCetak.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi, blth;
                petugas = idUser;

                String lampiran = "", no = "";

                unitUpi = comboUnits.getUnitUpiValue();
                unitAp = comboUnits.getUnitApValue();
                parUp = comboUnits.getUnitUpValue();
                blth = comboTahunBulan.getCbTahunSelectedValue()+comboTahunBulan.getCbBulanSelectedValue();
                lampiran = "Laporan Daftar Penghapusan PRR";

                String url = "";

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=prr_getLampiran"
                        +"&unitupi="+unitUpi
                        +"&unitap="+unitAp
                        +"&unitup="+parUp
                        +"&blth="+comboTahunBulan.getCbTahunSelectedValue()+comboTahunBulan.getCbBulanSelectedValue()
                        +"&lampiran="+lampiran
                        +"&no="+no
                        +"&idpel="+""
                        +"&unsur="+""
                        +"&pembukuan="+""
                        +"&tglmulai="+""
                        +"&tglsampai="+""
                ;

                url+="&report=report/ReportPRR/Laporan_Daftar_DUPPR.rpt";

                com.google.gwt.user.client.Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
