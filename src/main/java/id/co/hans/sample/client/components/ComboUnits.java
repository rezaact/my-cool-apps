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
    }

    public ComboUnits (String levelUnits,String userUnit){
        this.levelUnits = levelUnits;
        this.userUnit = userUnit;
    }

    public ComboUnits (String levelUnits, String userUnit, Integer addUpiSemua, Integer addApSemua, Integer addUpSemua){
        this.levelUnits = levelUnits;
        this.userUnit = userUnit;
        this.addUpiSemua = addUpiSemua;
        this.addApSemua = addApSemua;
        this.addUpSemua = addUpSemua;
    }

    @Override
    public Widget asWidget() {
        HorizontalPanel hlUnitUpi = new HorizontalPanel();
        HorizontalPanel hlUnitAp = new HorizontalPanel();
        HorizontalPanel hlUnitUp = new HorizontalPanel();


        cbUnitUpi = new IconComboBox();
        cbUnitUpi.setStoreUrl("components/getComboUnitPelayananInduk.json");
        cbUnitUpi.setComboWidth(250);
        cbUnitUpi.addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                cbUnitAp.loadStore();
            }
        });

        cbUnitAp = new IconComboBox();
        cbUnitAp.setStoreUrl("components/getComboAreaPelayanan.json");
        cbUnitAp.setComboWidth(250);
        cbUnitAp.addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                cbUnitUp.loadStore();
            }
        });

        cbUnitUp = new IconComboBox();
        cbUnitUp.setStoreUrl("components/getComboUnitPelayanan.json");
        cbUnitUp.setComboWidth(250);
        cbUnitUp.addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                System.out.println(data.get("fieldValue"));
                System.out.println(data.get("displayValue"));
            }
        });


        hlUnitUpi.add(cbUnitUpi);
        hlUnitAp.add(cbUnitAp);
        hlUnitUp.add(cbUnitUp);

        vlc = new VerticalLayoutContainer();
        vlc.add(new FieldLabel(hlUnitUpi, "Nama KD - Wilayah"));
        vlc.add(new FieldLabel(hlUnitAp, "Nama AP - Cabang"));
        vlc.add(new FieldLabel(hlUnitUp, "Nama UP - Ranting"));

        cbUnitUpi.loadStore();

        return vlc;
    }
}