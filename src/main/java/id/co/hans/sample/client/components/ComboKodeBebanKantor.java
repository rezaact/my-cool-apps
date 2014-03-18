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

public class ComboKodeBebanKantor implements IsWidget {

    private HorizontalPanel hp;
    private IconComboBox cb;
    private TextField tfDescription;

    private String unitUp;
    private String iBebanKantor;

    private String cbSelectedValue;

    public IconComboBox getComboBox() {
        return this.cb;
    }

    public String getSelectedValue() {
        return this.cbSelectedValue;
    }

    public void setUnitUp(String unitUp) {
        this.unitUp = unitUp;
    }

    public void setIBebanKantor(String iBebanKantor) {
        this.iBebanKantor = iBebanKantor;
    }

    @Override
    public Widget asWidget() {
        cb = new IconComboBox();
        cb.setStoreUrl("components/getComboDataKolektifNotaBuku.json?unitUp=" + this.unitUp + "&iBebanKantor=" + this.iBebanKantor);
        cb.setComboWidth(79);

        cb.addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                cbSelectedValue = data.get("fieldValue");

                tfDescription.setText(data.get("fieldValue"));
            }
        });

        tfDescription = new TextField();

        HorizontalPanel hl = new HorizontalPanel();
        hl.add(cb);

        hp = new HorizontalPanel();
        hp.add(hl);
        hp.add(new Label(" "));
        hp.add(tfDescription);

        cb.loadStore();

        return new FieldLabel(hp, "Kode Beban Kantor");
    }
}
