package id.co.hans.sample.client.components;

import java.util.Map;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class ComboKodePP extends AbstractComboComponent {

    private HorizontalPanel hp;
    private IconComboBox cb;
    private TextField tfDescription;

    private String cbSelectedValue;

    private String jenisPP = "";
    private String unitUp = "";
    private Integer comboWidth = 79;
    private Integer descriptionWidth = 120;

    public IconComboBox getComboBox() {
        return this.cb;
    }

    public String getSelectedValue() {
        return this.cbSelectedValue;
    }

    public void setSelectedValue(String value) {
        this.cbSelectedValue = value;
    }

    public void setJenisPP(String value) {
        jenisPP = value;
    }

    public void setUnitUp(String value) {
        unitUp = value;
    }

    public void setComboWidth(Integer value) {
        comboWidth = value;
    }

    public void setDescriptionWidth(Integer value) {
        descriptionWidth = value;
    }

    @Override
    public Widget asWidget() {
        cb = new IconComboBox();
        cb.setStoreUrl("components/getComboKodePaymentPoint.json?unitUp=" + unitUp + "&jenisPP=" + jenisPP);
        cb.setComboWidth(comboWidth);

        cb.addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                cbSelectedValue = data.get("fieldValue");

                tfDescription.setText(data.get("fieldValue") + " - " + data.get("displayValue"));
                
                onComboChange(data.get("fieldValue"));
            }
        });

        tfDescription = new TextField();
        tfDescription.setWidth(descriptionWidth);

        HorizontalPanel hl = new HorizontalPanel();
        hl.add(cb);

        hp = new HorizontalPanel();
        hp.add(hl);
        hp.add(new Label(" "));
        hp.add(tfDescription);

        cb.loadStore();

        return new FieldLabel(hp, "Kode PP");
    }
}
