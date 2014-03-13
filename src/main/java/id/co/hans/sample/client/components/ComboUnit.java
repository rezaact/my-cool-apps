package id.co.hans.sample.client.components;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

import java.util.Map;

public class ComboUnit implements IsWidget {

    private HorizontalPanel hp;
    private IconComboBox cbUnitUp;
    private TextField tfDescription;
    private String selectedValue;

    @Override
    public Widget asWidget() {
        cbUnitUp = new IconComboBox();
        cbUnitUp.setStoreUrl("BasicProject/thuGetComboData.json");
        cbUnitUp.setComboWidth(200);
        cbUnitUp.setLabelWidth(180);

        cbUnitUp.addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();

                tfDescription.setText(data.get("fieldValue"));
                selectedValue = data.get("fieldValue");
            }
        });

        tfDescription = new TextField();

        Label spacer1 = new Label("");
        spacer1.setPixelSize(10,1);

        hp = new HorizontalPanel();
        hp.add(cbUnitUp);
        hp.add(spacer1);
        hp.add(tfDescription);

        cbUnitUp.loadStore();

        return new FieldLabel(hp, "Unit");
    }

    public String getSelectedValue() {
        return this.selectedValue;
    }

    public IconComboBox getCbUnitUp() {
        return this.cbUnitUp;
    }

    public TextField getCbUnitUpDesc() {
        return this.tfDescription;
    }
}