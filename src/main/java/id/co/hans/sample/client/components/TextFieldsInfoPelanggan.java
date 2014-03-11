package id.co.hans.sample.client.components;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class TextFieldsInfoPelanggan implements IsWidget {

    private VerticalLayoutContainer vlc;
    private IconComboBox cbUnitUpi, cbUnitAp, cbUnitUp;

    @Override
    public Widget asWidget() {
        TextField tfIdpel = new TextField();
        tfIdpel.setWidth(110);
        tfIdpel.setReadOnly(true);

        TextField tfNama = new TextField();
        tfNama.setWidth(110);
        tfNama.setReadOnly(true);

        TextField tfAlamat = new TextField();
        tfAlamat.setWidth(110);
        tfAlamat.setReadOnly(true);

        TextField tfTarifDaya = new TextField();
        tfTarifDaya.setWidth(110);
        tfTarifDaya.setReadOnly(true);


        vlc = new VerticalLayoutContainer();
        vlc.add(new FieldLabel(tfIdpel, "Id Pelanggan"));
        vlc.add(new FieldLabel(tfNama, "Nama"));
        vlc.add(new FieldLabel(tfAlamat, "Alamat"));
        vlc.add(new FieldLabel(tfTarifDaya, "Tarif / Daya"));

        return vlc;
    }
}
