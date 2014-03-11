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

public class Form_MonitoringUploadSorek {


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
        panel.setHeadingText("Monitoring Upload Sorek");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        // panel Title="Pilih Referensi"


        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        ComboUnits cbUnit = new ComboUnits();
        p.add(cbUnit);

        ComboTahunBulan cbTahunBulan = new ComboTahunBulan();
        p.add(cbTahunBulan);

        p.add(new TextButton("Tampil"));


        // panel "Data Upload Sorek"

        IconDynamicGrid gpDataUpload = new IconDynamicGrid();
        gpDataUpload.setGridHeader("Data Upload Sorek");
        gpDataUpload.setGridDimension(620, 200);
        gpDataUpload.setStoreUrl("BasicProject/thuGetString.json?name=store1");

        gpDataUpload.addColumn("BOOL", 100);

        p.add(gpDataUpload);

        return panel;
    }
}
