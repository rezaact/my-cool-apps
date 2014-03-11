package id.co.hans.sample.client.form.administrasi;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import id.co.hans.sample.client.components.*;

public class Form_SettingRole {
    private VerticalPanel vp;

    final FormPanel form = new FormPanel();

    private ComboUnit cb_unitup;
    private ComboTahunBulan comboTahunBulan;
    private ComboUnits comboUnits;
    private IconDynamicGrid dgDILMUM;

    private TextButton bttnNew, bttnEdit, bttnDelete;


    final Window window = new Window();
    final FormPanel formWindow = new FormPanel();

    private ComboUnit cb_kodeunit;
    private ComboTahunBulan childcboTahunBulan;
    private ComboKodeSiklis cb_KlpSiklis;



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
        panel.setHeadingText("Setting Kewenangan User");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        form.setAction("URLtoSave.json");
        form.setEncoding(FormPanel.Encoding.MULTIPART);
        form.setMethod(FormPanel.Method.POST);
        panel.add(form);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        form.add(p);

        cb_unitup = new ComboUnit();
        p.add(cb_unitup);

        comboTahunBulan = new ComboTahunBulan();
        p.add(comboTahunBulan);

        dgDILMUM = new IconDynamicGrid();
        dgDILMUM.setGridHeader("Tab Jatuh Tempo");
        dgDILMUM.setGridHeight(150);
        dgDILMUM.setGridWidth(620);
        dgDILMUM.setStoreUrl("BasicProject/thuGetString.json?name=store1");

        dgDILMUM.addColumn("UNITUP", 100);
        dgDILMUM.addColumn("KODESIKLIS", 100);
        dgDILMUM.addColumn("PERIODE", 100);
        dgDILMUM.addColumn("JATUHTEMPO", 100);
        dgDILMUM.addColumn("THBL", 100);
        dgDILMUM.addColumn("BK1", 100);
        dgDILMUM.addColumn("BK1", 100);
        dgDILMUM.addColumn("BK1", 100);

        p.add(dgDILMUM);

        bttnNew = new TextButton("New");
        bttnDelete = new TextButton("Delete");
        bttnEdit = new TextButton("Edit");

        panel.addButton(bttnNew);
        panel.addButton(bttnDelete);
        panel.addButton(bttnEdit);

        return panel;
    }
    private void initEvent() {
        bttnNew.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
//                if(!form.isValid()) {
//                    return;
//                }

//                MessageBox messageBox = new MessageBox("New", comboTahunBulan.getCbTahunSelectedValue());
//                messageBox.show();

                window.setVisible(true);
            }
        });
    }
}
