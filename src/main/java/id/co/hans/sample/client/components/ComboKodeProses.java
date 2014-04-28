package id.co.hans.sample.client.components;

import java.util.Map;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class ComboKodeProses extends AbstractComboComponent {

    private HorizontalPanel hp;
    private IconComboBox cb;
    private TextField tfDescription;

    private String cbSelectedValue;

    private Integer comboWidth = 79;
    private Integer descriptionWidth = 120;
    private boolean hideDescription = false;
    private String unitUp = "";
    private String blth = "";

    public IconComboBox getComboBox() {
        return this.cb;
    }

    public String getSelectedValue() {
        return this.cbSelectedValue;
    }

    public void setHideDescription(boolean value) {
        this.hideDescription = value;
    }

    public void setUnitUp(String value) {
        this.unitUp = value;
    }

    public void setBlth(String value) {
        this.blth = value;
    }

    public void setComboWidth(Integer value) {
        this.comboWidth = value;
    }

    public void reloadStore() {
        cb.setStoreUrl("components/getComboKodeProses.json?unitUp=" + this.unitUp + "&blth=" + this.blth);
        cb.loadStore();
    }

    @Override
    public Widget asWidget() {
        cb = new IconComboBox();
        cb.setStoreUrl("components/getComboKodeProses.json?unitUp=" + this.unitUp + "&blth=" + this.blth);
        cb.setComboWidth(comboWidth);

        cb.addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                cbSelectedValue = data.get("fieldValue");

                tfDescription.setText(data.get("fieldValue"));
                
                onComboChange(data.get("fieldValue"));
            }
        });

        tfDescription = new TextField();
        tfDescription.setWidth(descriptionWidth);

        HorizontalPanel hl = new HorizontalPanel();
        hl.add(cb);

        hp = new HorizontalPanel();
        hp.add(hl);

        if (!hideDescription) {
            hp.add(new Label(" "));
            hp.add(tfDescription);
        }

        cb.loadStore();

        return new FieldLabel(hp, "Kode Proses");
    }
}
