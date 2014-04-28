package id.co.hans.sample.client.components;

import java.util.Map;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class ComboUnit extends AbstractComboComponent {

  @SuppressWarnings("unused")
  private static final String DUMMY_URL = "BasicProject/thuGetComboData.json";

  private HorizontalPanel hp;
  private IconComboBox cbUnitUp;
  private TextField tfDescription;
  private String selectedValue;
  private Integer addUpSemua = 0;
  private String levelUnits = "";
  private String userUnit = "";

  public ComboUnit() {}

  public ComboUnit(String levelUnits, String userUnits) {
    this.levelUnits = levelUnits;
    this.userUnit = userUnits;
  }

  public ComboUnit(String levelUnits, String userUnits, Integer addUpSemua) {
    this.levelUnits = levelUnits;
    this.userUnit = userUnits;
    this.addUpSemua = addUpSemua;
  }

  @Override
  public Widget asWidget() {
    cbUnitUp = new IconComboBox();
    cbUnitUp.setStoreUrl("components/getComboUnitPelayanan.json?levelUnits=" + levelUnits
        + "&userUnit=" + userUnit + "&addUpSemua=" + addUpSemua + "&selectedUnitAp=" + userUnit);
    cbUnitUp.setComboWidth(200);
    cbUnitUp.setLabelWidth(180);

    cbUnitUp.addSelectionHandler(new SelectionHandler<Map<String, String>>() {
      @Override
      public void onSelection(SelectionEvent<Map<String, String>> event) {
        Map<String, String> data = event.getSelectedItem();

        tfDescription.setText(data.get("fieldValue"));
        selectedValue = data.get("fieldValue");

        onComboChange(data.get("fieldValue"));
      }
    });

    tfDescription = new TextField();

    Label spacer1 = new Label("");
    spacer1.setPixelSize(10, 1);

    hp = new HorizontalPanel();
    hp.add(cbUnitUp);
    hp.add(spacer1);
    hp.add(tfDescription);

    cbUnitUp.loadStore();

    return new FieldLabel(hp, "Unit");
  }

  public Integer getAddUpSemua() {
    return addUpSemua;
  }

  public IconComboBox getCbUnitUp() {
    return this.cbUnitUp;
  }

  public TextField getCbUnitUpDesc() {
    return this.tfDescription;
  }

  public String getLevelUnits() {
    return levelUnits;
  }

  public String getSelectedValue() {
    return this.selectedValue;
  }

  public void setSelectedValue(String inValue) {
    this.selectedValue = inValue;
  }

  public String getUserUnit() {
    return userUnit;
  }

  public void setAddUpSemua(Integer addUpSemua) {
    this.addUpSemua = addUpSemua;
  }

  public void setLevelUnits(String levelUnits) {
    this.levelUnits = levelUnits;
  }

  public void setUserUnit(String userUnit) {
    this.userUnit = userUnit;
  }



}
