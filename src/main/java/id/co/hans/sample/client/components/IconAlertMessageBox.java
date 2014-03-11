package id.co.hans.sample.client.components;

import com.sencha.gxt.widget.core.client.box.AlertMessageBox;

public class IconAlertMessageBox {
    private AlertMessageBox alertMessageBox = new AlertMessageBox("","");

    public IconAlertMessageBox(String judul, String pesan) {
        alertMessageBox = new AlertMessageBox(judul, pesan);
    }

    public IconAlertMessageBox(String pesan) {
        alertMessageBox = new AlertMessageBox("Peringatan", pesan);
    }

    public IconAlertMessageBox(String judul, String pesan, Boolean autoShow) {
        alertMessageBox = new AlertMessageBox(judul, pesan);
        if (autoShow) {
            alertMessageBox.show();
        }
    }

    public void show() {
        alertMessageBox.show();
    }
}
