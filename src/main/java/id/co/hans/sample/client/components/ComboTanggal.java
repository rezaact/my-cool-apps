package id.co.hans.sample.client.components;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

import java.util.Map;

public class ComboTanggal implements IsWidget {

    private HorizontalPanel hp;
    private IconComboBox cb;

    private String cbSelectedValue;
    private Boolean hideLabel = false;

    public IconComboBox getComboBox() {
        return this.cb;
    }

    public String getSelectedValue() {
        return this.cbSelectedValue;
    }

    public void hideLabel() {
        this.hideLabel = true;
    }

    @Override
    public Widget asWidget() {
        cb = new IconComboBox();
        cb.setStoreUrl("components/getComboTanggal.json?year=2014&month=01");
        cb.setComboWidth(79);

        cb.addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                cbSelectedValue = data.get("fieldValue");
            }
        });

        HorizontalPanel hl = new HorizontalPanel();
        hl.add(cb);

        hp = new HorizontalPanel();
        hp.add(hl);

        cb.loadStore();

        if (!this.hideLabel){
            return new FieldLabel(hp, "Tanggal");
        } else {
            return hp;
        }
    }
}
