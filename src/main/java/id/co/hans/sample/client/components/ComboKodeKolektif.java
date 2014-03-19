package id.co.hans.sample.client.components;

import java.util.Map;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class ComboKodeKolektif extends AbstractComboComponent {

    private HorizontalPanel hp;
    private IconComboBox cb;
    private TextField tfDescription;
    @SuppressWarnings("unused")
	private String storeUrl;

    private Boolean hideLabel = false;

    private String cbSelectedValue = "";

    public IconComboBox getComboBox() {
        return this.cb;
    }

    public TextField getTfDescription() {
        return this.tfDescription;
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
        cb.setStoreUrl("BasicProject/thuGetComboTahun.json");
        cb.setComboWidth(79);

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
        tfDescription.setText("KODE BELUM DIPILIH.");

        HorizontalPanel hl = new HorizontalPanel();
        hl.add(cb);

        hp = new HorizontalPanel();
        hp.add(hl);
        hp.add(new Label(" "));
        hp.add(tfDescription);

        cb.loadStore();

        if (this.hideLabel) {
            return hp;
        }
        return new FieldLabel(hp, "Kode Kolektif");
    }
}
