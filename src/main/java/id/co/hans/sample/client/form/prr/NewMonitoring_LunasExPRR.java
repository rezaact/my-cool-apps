package id.co.hans.sample.client.form.prr;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.*;
import com.google.gwt.i18n.client.DateTimeFormat;
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

public class NewMonitoring_LunasExPRR {
    private VerticalPanel vp;

    final FormPanel form = new FormPanel();

    private ComboTahunBulan comboTahunBulan;
    private ComboUnits comboUnits;

    private TextButton bttnCetak, bttnFilter, bttnReset;

    DateField deAwal;
    DateField deAkhir;

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
        panel.setHeadingText("Monitoring Lunas Ex PRR");
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

        comboUnits = new ComboUnits(levelUser, unitUser, 1, 1, 1);
        p.add(comboUnits);

        VerticalLayoutContainer vlc = new VerticalLayoutContainer();
        HorizontalPanel hp = new HorizontalPanel();

        deAwal = new DateField();
        Label label = new Label(" - ");
        deAkhir = new DateField();

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
                String parUp, jenis="", petugas, unitAp, unitUpi, blth;
                petugas = idUser;

                String lampiran = "", no = "";

                //unitUpi = comboUnits.getUnitUpiValue();
                //unitAp = comboUnits.getUnitApValue();
                //parUp = comboUnits.getUnitUpValue();
                //blth = comboTahunBulan.getCbTahunSelectedValue()+comboTahunBulan.getCbBulanSelectedValue();
                lampiran = "Laporan Pelunasan Ex PRR";

                String url = "";

                DateTimeFormat formatter = DateTimeFormat.getFormat("yyyyMMdd");

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=prr_getLampiran"
                        +"&unitupi="
                        +"&unitap="
                        +"&unitup="
                        +"&blth="+""
                        +"&lampiran="+lampiran
                        +"&no="+""
                        +"&idpel="+""
                        +"&unsur="+""
                        +"&pembukuan="+""
                        +"&tglmulai="+formatter.format(deAwal.getValue())
                        +"&tglsampai="+formatter.format(deAkhir.getValue())
                ;

                url+="&report=report/ReportPRR/Laporan_LunasExPRR.rpt";

                com.google.gwt.user.client.Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
