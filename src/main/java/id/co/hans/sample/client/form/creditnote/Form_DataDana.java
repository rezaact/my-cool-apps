package id.co.hans.sample.client.form.creditnote;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.ComboKodePP;
import id.co.hans.sample.client.components.ComboUnit;
import id.co.hans.sample.client.components.IconComboBox;
import id.co.hans.sample.client.components.IconDynamicGrid;


public class Form_DataDana {


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
        panel.setHeadingText("Perbandingan Data dan Dana");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);


        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        ComboUnit cbTopPilihUnitUp = new ComboUnit();
        p.add(cbTopPilihUnitUp);

        Label label1 = new Label("Pemantauan per-Tanggal Pelunasan berdasarkan Payment Point :");
        p.add(label1);

        ComboKodePP cbTopPilihKodePp = new ComboKodePP();
        p.add(cbTopPilihKodePp);

        DateField dfMiddleTanggalAwal = new DateField();
        p.add(new FieldLabel(dfMiddleTanggalAwal, "Tanggal Awal"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));

        DateField dfMiddleTanggalAkhir = new DateField();
        p.add(new FieldLabel(dfMiddleTanggalAkhir, "Tanggal Akhir"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        TextButton bMiddleTampilkan = new TextButton("Tampilkan");
        panel.addButton(bMiddleTampilkan);

        return panel;
    }
}
