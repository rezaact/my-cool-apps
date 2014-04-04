package id.co.hans.sample.client.form.proses;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.*;

    public class Form_11RekeningBaru {


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
        panel.setHeadingText("Form 11 Rekening Baru");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        ComboUnits cbUnits = new ComboUnits();
        p.add(cbUnits);

        ComboTahunBulan cbBlth = new ComboTahunBulan();
        p.add(cbBlth);

        ComboKodeProses cbKdProses = new ComboKodeProses();
        p.add(cbKdProses);

        TextField tNorekAwal = new TextField();
        p.add(new FieldLabel(tNorekAwal, "NOREK Awal Rekening"));

        TextButton btnUploadSorek = new TextButton("UPLOAD");
        panel.addButton(btnUploadSorek);

        return panel;
    }
}
