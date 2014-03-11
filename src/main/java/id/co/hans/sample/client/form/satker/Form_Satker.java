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

public class Form_Satker {


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
        panel.setHeadingText("Manajemen Kode Satker");
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

        ComboKotama cbKotama = new ComboKotama();
        vlcPReferensi.add(cbKotama);

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

        ComboSatuanKerja cbSatker = new ComboSatuanKerja();

        TextButton btnSimpan = new TextButton("Simpan");

        vlcPKotamaCombo.add(cbSatker);
        vlcPKotamaCombo.add(btnSimpan);

        hlc.add(panelKotamaRadio);
        hlc.add(panelKotamaCombo);

        vlcPKotama.add(hlc);

        p.add(panelKotama);


        FramedPanel panelDetailSatker = new FramedPanel();
        panelDetailSatker.setHeadingText("Detail Satker");
        panelDetailSatker.setBodyStyle("background: none; padding: 5px");
        panelDetailSatker.setWidth(620);

        VerticalLayoutContainer vlcPDetailSatker = new VerticalLayoutContainer();
        panelDetailSatker.add(vlcPDetailSatker);

        TextField tKesatuan = new TextField();
        vlcPDetailSatker.add(new FieldLabel(tKesatuan, "Kesatuan"));

        TextField tNoSurat = new TextField();
        vlcPDetailSatker.add(new FieldLabel(tNoSurat, "No Surat"));

        TextField tKodeSatker = new TextField();
        vlcPDetailSatker.add(new FieldLabel(tKodeSatker, "Kode Satker"));

        TextField tAlamat = new TextField();
        vlcPDetailSatker.add(new FieldLabel(tAlamat, "Alamat"));

        TextField tNoForm = new TextField();
        vlcPDetailSatker.add(new FieldLabel(tNoForm, "No Form"));

        p.add(panelDetailSatker);


        FramedPanel panelMengetahuiKiri = new FramedPanel();
        panelMengetahuiKiri.setHeadingText("Mengetahui Kiri");
        panelMengetahuiKiri.setBodyStyle("background: none; padding: 5px");
        panelMengetahuiKiri.setWidth(620);

        VerticalLayoutContainer vlcPMengetahuiKiri = new VerticalLayoutContainer();
        panelMengetahuiKiri.add(vlcPMengetahuiKiri);

        TextField tSetuju1Nama = new TextField();
        vlcPMengetahuiKiri.add(new FieldLabel(tSetuju1Nama, "Nama"));

        TextField tSetuju1Kesatuan = new TextField();
        vlcPMengetahuiKiri.add(new FieldLabel(tSetuju1Kesatuan, "Kesatuan"));

        TextField tSetuju1Jabatan = new TextField();
        vlcPMengetahuiKiri.add(new FieldLabel(tSetuju1Jabatan, "Jabatan"));

        TextField tSetuju1Pangkat = new TextField();
        vlcPMengetahuiKiri.add(new FieldLabel(tSetuju1Pangkat, "Pangkat"));

        TextField tSetuju1NIP = new TextField();
        vlcPMengetahuiKiri.add(new FieldLabel(tSetuju1NIP, "NRP"));

        p.add(panelMengetahuiKiri);


        FramedPanel panelMengetahuiTengah = new FramedPanel();
        panelMengetahuiTengah.setHeadingText("Mengetahui Kiri");
        panelMengetahuiTengah.setBodyStyle("background: none; padding: 5px");
        panelMengetahuiTengah.setWidth(620);

        VerticalLayoutContainer vlcPMengetahuiTengah = new VerticalLayoutContainer();
        panelMengetahuiTengah.add(vlcPMengetahuiTengah);

        TextField tSetuju2Nama = new TextField();
        vlcPMengetahuiTengah.add(new FieldLabel(tSetuju2Nama, "Nama"));

        TextField tSetuju2Kesatuan = new TextField();
        vlcPMengetahuiTengah.add(new FieldLabel(tSetuju2Kesatuan, "Kesatuan"));

        TextField tSetuju2Jabatan = new TextField();
        vlcPMengetahuiTengah.add(new FieldLabel(tSetuju2Jabatan, "Jabatan"));

        TextField tSetuju2Pangkat = new TextField();
        vlcPMengetahuiTengah.add(new FieldLabel(tSetuju2Pangkat, "Pangkat"));

        TextField tSetuju2NIP = new TextField();
        vlcPMengetahuiTengah.add(new FieldLabel(tSetuju2NIP, "NRP"));

        p.add(panelMengetahuiTengah);


        FramedPanel panelMengetahuiKanan = new FramedPanel();
        panelMengetahuiKanan.setHeadingText("Mengetahui Kiri");
        panelMengetahuiKanan.setBodyStyle("background: none; padding: 5px");
        panelMengetahuiKanan.setWidth(620);

        VerticalLayoutContainer vlcPMengetahuiKanan = new VerticalLayoutContainer();
        panelMengetahuiKanan.add(vlcPMengetahuiKanan);

        TextField tSetuju3Nama = new TextField();
        vlcPMengetahuiKanan.add(new FieldLabel(tSetuju3Nama, "Nama"));

        TextField tSetuju3Jabatan = new TextField();
        vlcPMengetahuiKanan.add(new FieldLabel(tSetuju3Jabatan, "Jabatan"));

        TextField tSetuju3Unit = new TextField();
        vlcPMengetahuiKanan.add(new FieldLabel(tSetuju3Unit, "Unit"));

        TextField tSetuju3Kota = new TextField();
        vlcPMengetahuiKanan.add(new FieldLabel(tSetuju3Kota, "Kota"));

        p.add(panelMengetahuiKanan);


        return panel;
    }
}
