package id.co.hans.sample.client.components;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.FieldLabel;

import java.util.Map;

public class ComboTahunBulan implements IsWidget {

    private HorizontalPanel hp;
    private IconComboBox cbTahun, cbBulan;

    private String cbTahunSelectedValue, cbBulanSelectedValue;
    private Boolean hideLabel = false;

    public IconComboBox getCbTahun() {
        return this.cbTahun;
    }

    public IconComboBox getCbBulan() {
        return this.cbBulan;
    }

    public String getCbTahunSelectedValue() {
        return this.cbTahunSelectedValue;
    }

    public String getCbBulanSelectedValue() {
        return this.cbBulanSelectedValue;
    }

    public void hideLabel() {
        this.hideLabel = true;
    }

    @Override
    public Widget asWidget() {
        cbTahun = new IconComboBox();
        cbTahun.setStoreUrl("BasicProject/thuGetComboTahun.json");
        cbTahun.setComboWidth(79);

        cbTahun.addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                cbTahunSelectedValue = data.get("fieldValue");
            }
        });

        cbBulan = new IconComboBox();
        cbBulan.setStoreUrl("BasicProject/thuGetComboBulan.json");
        cbBulan.setComboWidth(120);

        cbBulan.addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                cbBulanSelectedValue = data.get("fieldValue");
            }
        });



        HorizontalPanel hl = new HorizontalPanel();
        hl.add(cbTahun);
        hl.add(new Label(" "));
        hl.add(cbBulan);

        hp = new HorizontalPanel();
        hp.add(hl);

        cbTahun.loadStore();
        cbBulan.loadStore();

        if (!this.hideLabel){
            return new FieldLabel(hp, "BLTH");
        } else {
            return hp;
        }
    }
}
