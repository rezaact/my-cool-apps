package id.co.hans.sample.client.form.proses;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.Padding;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer.HBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.*;


public class Form_23PelunasanNotaTerpusat {
    private VerticalPanel vp;
    ComboKodeNotaBuku cbKdNtBk;
    ComboTahunBulan cbThnBln;

    private String idUser, levelUser, unitUser;
    public Widget asWidget(String idUser, String unitupUser, String levelUser) {
        this.idUser=idUser;
        this.unitUser=unitupUser;
        this.levelUser=levelUser;

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
        panel.setHeadingText("Laporan Tagihan per-Kode Nota BUku Tpst");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        FramedPanel fieldSet = new FramedPanel();
        fieldSet.setHeadingText("Pilih Referensi");

        VerticalLayoutContainer FieldAtas = new VerticalLayoutContainer();
        fieldSet.add(FieldAtas);
        cbKdNtBk = new ComboKodeNotaBuku();
        FieldAtas.add(cbKdNtBk);

        p.add(fieldSet, new VerticalLayoutData(1, .2d, new Margins(0, 0, 10, 0)));

        cbThnBln = new ComboTahunBulan();
        p.add(cbThnBln);

        FieldSet fieldSet1 = new FieldSet();
        fieldSet1.setWidth(250);

        Radio radio = new Radio();
        radio.setBoxLabel("Semua");
        radio.setValue(true);

        Radio radio2 = new Radio();
        radio2.setBoxLabel("Belum Lunas");

        Radio radio3 = new Radio();
        radio3.setBoxLabel("Lunas");
        VerticalLayoutContainer FieldBawah = new VerticalLayoutContainer();
        fieldSet1.add(FieldBawah);
        FieldBawah.add(radio);
        FieldBawah.add(radio2);
        FieldBawah.add(radio3);

        HBoxLayoutContainer hp1 = new HBoxLayoutContainer();
        hp1.add(fieldSet1);
        hp1.add(new TextButton("Tampilkan"), new BoxLayoutData(new Margins(0, 0, 0, 10)));
        p.add(hp1, new VerticalLayoutData(1, 1, new Margins(0, 0, 10, 0)));

        ToggleGroup toggle = new ToggleGroup();
        toggle.add(radio);
        toggle.add(radio2);
        toggle.add(radio3);

        return panel;
    }
}
