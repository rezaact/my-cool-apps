package id.co.hans.sample.client.components;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.FieldLabel;

import java.util.Map;

public class ComboKodeSiklis implements IsWidget {

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

    public void setEnabled(Boolean flag) {
        this.cb.getComboBox().setEnabled(flag);
    }

    @Override
    public Widget asWidget() {
        cb = new IconComboBox();
        cb.setStoreUrl("components/getComboKodeSiklis.json?unitUp=&addSemua=1");
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

        if (this.hideLabel) {
            return hp;
        }
        return new FieldLabel(hp, "Kode Siklis");
    }
}
