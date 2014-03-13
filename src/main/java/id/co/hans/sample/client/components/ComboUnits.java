package id.co.hans.sample.client.components;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;

import java.util.Map;

public class ComboUnits implements IsWidget {

    private VerticalLayoutContainer vlc;
    private IconComboBox cbUnitUpi, cbUnitAp, cbUnitUp;
    String levelUnits, userUnit;
    String unitUpi, unitAp, unitUp;
    Integer addUpiSemua, addApSemua, addUpSemua;

    public ComboUnits (){
        this.levelUnits = "";
        this.userUnit = "";
        this.addUpiSemua = 0;
        this.addApSemua = 0;
        this.addUpSemua = 0;
    }

    public ComboUnits (String levelUnits,String userUnit){
        this.levelUnits = levelUnits;
        this.userUnit = userUnit;
        this.addUpiSemua = 0;
        this.addApSemua = 0;
        this.addUpSemua = 0;
    }

    public ComboUnits (String levelUnits, String userUnit, Integer addUpiSemua, Integer addApSemua, Integer addUpSemua){
        this.levelUnits = levelUnits;
        this.userUnit = userUnit;
        this.addUpiSemua = addUpiSemua;
        this.addApSemua = addApSemua;
        this.addUpSemua = addUpSemua;
    }

    public String getUnitUpiValue() {
        return this.unitUpi;
    }

    public String getUnitApValue() {
        return this.unitAp;
    }

    public String getUnitUpValue() {
        return this.unitUp;
    }

    @Override
    public Widget asWidget() {
        HorizontalPanel hlUnitUpi = new HorizontalPanel();
        HorizontalPanel hlUnitAp = new HorizontalPanel();
        HorizontalPanel hlUnitUp = new HorizontalPanel();


        cbUnitUpi = new IconComboBox();
        cbUnitUpi.setStoreUrl("components/getComboUnitPelayananInduk.json?levelUnits=" + levelUnits + "&userUnit=" + userUnit + "&addUpiSemua=" + addUpiSemua);
        cbUnitUpi.setComboWidth(250);
        cbUnitUpi.addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                unitUpi = data.get("fieldValue");

                cbUnitAp.getComboBox().clear();
                cbUnitUp.getComboBox().clear();

                cbUnitAp.setStoreUrl("components/getComboAreaPelayanan.json?levelUnits=" + levelUnits + "&userUnit=" + userUnit + "&addApSemua=" + addApSemua + "&selectedUnitUpi=" + unitUpi);
                cbUnitAp.loadStore();
            }
        });

        cbUnitAp = new IconComboBox();
        cbUnitAp.setStoreUrl("components/getComboAreaPelayanan.json?levelUnits=" + levelUnits + "&userUnit=" + userUnit + "&addApSemua=" + addApSemua);
        cbUnitAp.setComboWidth(250);
        cbUnitAp.addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                unitAp = data.get("fieldValue");

                cbUnitUp.getComboBox().clear();

                cbUnitUp.setStoreUrl("components/getComboUnitPelayanan.json?levelUnits=" + levelUnits + "&userUnit=" + userUnit + "&addUpSemua=" + addApSemua + "&selectedUnitUpi=" + unitUpi);
                cbUnitUp.loadStore();
            }
        });

        cbUnitUp = new IconComboBox();
        cbUnitUp.setStoreUrl("components/getComboUnitPelayanan.json?levelUnits=" + levelUnits + "&userUnit=" + userUnit + "&addUpSemua=" + addUpSemua);
        cbUnitUp.setComboWidth(250);
        cbUnitUp.addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                unitUp = data.get("fieldValue");
                //System.out.println(data.get("fieldValue"));
                //System.out.println(data.get("displayValue"));
            }
        });

        hlUnitUpi.add(cbUnitUpi);
        hlUnitAp.add(cbUnitAp);
        hlUnitUp.add(cbUnitUp);

        vlc = new VerticalLayoutContainer();
        vlc.add(new FieldLabel(hlUnitUpi, "Unit UPI"));
        vlc.add(new FieldLabel(hlUnitAp, "Unit AP"));
        vlc.add(new FieldLabel(hlUnitUp, "Unit UP"));

        //cbUnitUpi.loadStore();

        return vlc;
    }
}