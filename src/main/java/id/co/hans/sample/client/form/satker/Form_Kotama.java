package id.co.hans.sample.client.form.satker;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.*;

public class Form_Kotama {


    private VerticalPanel vp;

    public Widget asWidget() {
        if (vp == null) {
            vp = new VerticalPanel();
            vp.setSpacing(5);
            initKomponen();
        }
        return vp;
    }

    private void initKomponen(){
        AutoProgressMessageBox progressBox = new AutoProgressMessageBox("Progress", "please wait");
        progressBox.setProgressText("wait...");

        vp.add(panelMain());
    }

    private FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Manajemen Kode Kotama");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);


        FramedPanel panelReferensi = new FramedPanel();
        panelReferensi.setHeadingText("Pilih Referensi");
        panelReferensi.setBodyStyle("background: none; padding: 5px");
        panelReferensi.setWidth(620);

        VerticalLayoutContainer vlcPReferensi = new VerticalLayoutContainer();
        panelReferensi.add(vlcPReferensi);

        ComboUnits cbUnits = new ComboUnits();
        vlcPReferensi.add(cbUnits);

        ComboTingkatSatuanKerja cbTingkatSatKer = new ComboTingkatSatuanKerja();
        vlcPReferensi.add(cbTingkatSatKer);

        p.add(panelReferensi);


        FramedPanel panelKotama = new FramedPanel();
        panelKotama.setHeadingText("Nama Kotama");
        panelKotama.setBodyStyle("background: none; padding: 5px");
        panelKotama.setWidth(620);
        panelKotama.setHeight(150);

        VerticalLayoutContainer vlcPKotama = new VerticalLayoutContainer();
        panelKotama.add(vlcPKotama);


        HorizontalLayoutContainer hlc = new HorizontalLayoutContainer();

        FramedPanel panelKotamaRadio = new FramedPanel();
        panelKotamaRadio.setBodyStyle("background: none; padding: 5px");
        panelKotamaRadio.setWidth(130);
        panelKotamaRadio.setHeight(100);

        VerticalLayoutContainer vlcPKotamaRadio = new VerticalLayoutContainer();
        panelKotamaRadio.add(vlcPKotamaRadio);

        Radio rbUbah = new Radio();
        rbUbah.setBoxLabel("Ubah");

        Radio rbTambah = new Radio();
        rbTambah.setValue(true);
        rbTambah.setBoxLabel("Tambah");

        ToggleGroup tg = new ToggleGroup();
        tg.add(rbUbah);
        tg.add(rbTambah);

        vlcPKotamaRadio.add(rbUbah);
        vlcPKotamaRadio.add(rbTambah);

        FramedPanel panelKotamaCombo = new FramedPanel();
        panelKotamaCombo.setBodyStyle("background: none; padding: 5px");
        panelKotamaCombo.setWidth(460);
        panelKotamaCombo.setHeight(100);

        VerticalLayoutContainer vlcPKotamaCombo = new VerticalLayoutContainer();
        panelKotamaCombo.add(vlcPKotamaCombo);

        ComboKotama cbKotama = new ComboKotama();

        TextButton btnSimpan = new TextButton("Simpan");

        vlcPKotamaCombo.add(cbKotama);
        vlcPKotamaCombo.add(btnSimpan);

        hlc.add(panelKotamaRadio);
        hlc.add(panelKotamaCombo);

        vlcPKotama.add(hlc);

        p.add(panelKotama);


        FramedPanel panelPejabatKotama = new FramedPanel();
        panelPejabatKotama.setHeadingText("Mengetahui Pejabat Kotama");
        panelPejabatKotama.setBodyStyle("background: none; padding: 5px");
        panelPejabatKotama.setWidth(620);

        VerticalLayoutContainer vlcPPejabatKotama = new VerticalLayoutContainer();
        panelPejabatKotama.add(vlcPPejabatKotama);

        TextField tSetuju1Nama = new TextField();
        vlcPPejabatKotama.add(new FieldLabel(tSetuju1Nama, "Nama"));

        TextField tSetuju1Kesatuan = new TextField();
        vlcPPejabatKotama.add(new FieldLabel(tSetuju1Kesatuan, "Kesatuan"));

        TextField tSetuju1Jabatan = new TextField();
        vlcPPejabatKotama.add(new FieldLabel(tSetuju1Jabatan, "Jabatan"));

        TextField tSetuju1Pangkat = new TextField();
        vlcPPejabatKotama.add(new FieldLabel(tSetuju1Pangkat, "Pangkat"));

        TextField tSetuju1NIP = new TextField();
        vlcPPejabatKotama.add(new FieldLabel(tSetuju1NIP, "NRP"));

        p.add(panelPejabatKotama);


        FramedPanel panelPejabatPLN = new FramedPanel();
        panelPejabatPLN.setHeadingText("Mengetahui Pejabat PLN");
        panelPejabatPLN.setBodyStyle("background: none; padding: 5px");
        panelPejabatPLN.setWidth(620);

        VerticalLayoutContainer vlcPPejabatPLN = new VerticalLayoutContainer();
        panelPejabatPLN.add(vlcPPejabatPLN);

        TextField tSetuju2Nama = new TextField();
        vlcPPejabatPLN.add(new FieldLabel(tSetuju2Nama, "Nama"));

        TextField tSetuju2Jabatan = new TextField();
        vlcPPejabatPLN.add(new FieldLabel(tSetuju2Jabatan, "Jabatan"));

        TextField tSetuju2Unit = new TextField();
        vlcPPejabatPLN.add(new FieldLabel(tSetuju2Unit, "Unit"));

        TextField tSetuju2Kota = new TextField();
        vlcPPejabatPLN.add(new FieldLabel(tSetuju2Kota, "Kota"));

        p.add(panelPejabatPLN);


        return panel;
    }
}
