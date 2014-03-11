package id.co.hans.sample.client.form.monitoring;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.ComboTahunBulan;
import id.co.hans.sample.client.components.ComboUnits;
import id.co.hans.sample.client.components.IconComboBox;
import id.co.hans.sample.client.components.IconDynamicGrid;

public class Form_MonitoringLunas_QA1 {


    private VerticalPanel vp;

    public Widget asWidget() {
        if (vp == null) {
            vp = new VerticalPanel();
            vp.setSpacing(5);
            initKomponen();
        }
        return vp;
    }

    private void initKomponen(){
        AutoProgressMessageBox progressBox = new AutoProgressMessageBox("Progress", "please wait");
        progressBox.setProgressText("wait...");

        vp.add(panelMain());
    }

    private FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Monitoring Lunas QA 1");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        // panel Title="Pilih Referensi"


        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        ComboUnits cbUnit = new ComboUnits();
        p.add(cbUnit);


        DateField dfTopTanggalAwal = new DateField();
        p.add(new FieldLabel(dfTopTanggalAwal, "Tanggal Awal"));

        DateField dfTopTanggalAkhir = new DateField();
        p.add(new FieldLabel(dfTopTanggalAkhir, "Tanggal Akhir"));

        p.add(new TextButton("Filter"));


        // panel "Data CN"

        IconDynamicGrid GdMonitoringLunasQA1 = new IconDynamicGrid();
        GdMonitoringLunasQA1.setGridHeader("Data Lunas QA 1");
        GdMonitoringLunasQA1.setGridDimension(620, 200);
        GdMonitoringLunasQA1.setStoreUrl("BasicProject/thuGetString.json?name=store1");

        GdMonitoringLunasQA1.addColumn("BOOL", 100);

        p.add(GdMonitoringLunasQA1);

        return panel;
    }
}
