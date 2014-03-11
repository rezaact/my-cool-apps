package id.co.hans.sample.client.form.reporttul;

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

public class Form_RekapUlang {

    //todo: salah form broo....

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
        panel.setHeadingText("Laporan Piutang Pelanggan Lancar (TUL IV-04)");
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

        ComboUnit cbUnit = new ComboUnit();
        vlcPReferensi.add(cbUnit);

        p.add(panelReferensi);


        FramedPanel panelPembukuan = new FramedPanel();
        panelPembukuan.setHeadingText("Pilih Parameter");
        panelPembukuan.setBodyStyle("background: none; padding: 5px");
        panelPembukuan.setWidth(620);

        VerticalLayoutContainer vlcPPembukuan = new VerticalLayoutContainer();
        panelPembukuan.add(vlcPPembukuan);

        ComboJenisPembukuan cbPembukuan = new ComboJenisPembukuan();
        cbPembukuan.setFormAsal("Form_LaporanIV04_New");
        vlcPPembukuan.add(cbPembukuan);

        p.add(panelPembukuan);

        FramedPanel panelReferensiTgl = new FramedPanel();
        panelReferensiTgl.setHeadingText("Pilih Parameter");
        panelReferensiTgl.setBodyStyle("background: none; padding: 5px");
        panelReferensiTgl.setWidth(620);

        VerticalLayoutContainer vlcPReferensiTgl = new VerticalLayoutContainer();
        panelReferensiTgl.add(vlcPReferensiTgl);

        ComboTahunBulan cbTahunBulan = new ComboTahunBulan();
        vlcPReferensiTgl.add(cbTahunBulan);

        ComboUnsurLaporan404 cbTopPilihUnsurLaporanIV04 = new ComboUnsurLaporan404();
        vlcPReferensiTgl.add(cbTopPilihUnsurLaporanIV04);

        p.add(panelReferensiTgl);


        FramedPanel panelReferensiJnsLaporan = new FramedPanel();
        panelReferensiJnsLaporan.setHeadingText("Jenis Transaksi Untuk Direkap Ulang");
        panelReferensiJnsLaporan.setBodyStyle("background: none; padding: 5px");
        panelReferensiJnsLaporan.setWidth(620);

        VerticalLayoutContainer vlcPReferensiJnsLaporan = new VerticalLayoutContainer();
        panelReferensiJnsLaporan.add(vlcPReferensiJnsLaporan);

        CheckBox chkSorek = new CheckBox();
        chkSorek.setBoxLabel("Sorek");

        CheckBox chkLunasOffline = new CheckBox();
        chkLunasOffline.setBoxLabel("Lunas Offline");

        CheckBox chkLunasTerpusat = new CheckBox();
        chkLunasTerpusat.setBoxLabel("Lunas Terpusat");

        CheckBox chkLunasSuplisi = new CheckBox();
        chkLunasSuplisi.setBoxLabel("Lunas Suplisi");

        CheckBox chkSusulan = new CheckBox();
        chkSusulan.setBoxLabel("Susulan");

        CheckBox chkLunasOnline = new CheckBox();
        chkLunasOnline.setBoxLabel("Lunas Online");

        CheckBox chkLunasNota = new CheckBox();
        chkLunasNota.setBoxLabel("Lunas Nota/Beban Kantor/Memo");

        CheckBox chkBk = new CheckBox();
        chkBk.setBoxLabel("BK");

        CheckBox chkKoreksiRekening = new CheckBox();
        chkKoreksiRekening.setBoxLabel("Koreksi Rekening");

        CheckBox chkKirimTerima = new CheckBox();
        chkKirimTerima.setBoxLabel("Kirim / Terima");

        CheckBox chkBatalPiutang = new CheckBox();
        chkBatalPiutang.setBoxLabel("Batal Piutang");

        chkSorek.setWidth(120);
        chkLunasSuplisi.setWidth(120);
        chkLunasNota.setWidth(220);
        chkKirimTerima.setWidth(120);

        chkLunasOffline.setWidth(120);
        chkSusulan.setWidth(120);
        chkBk.setWidth(220);
        chkBatalPiutang.setWidth(120);

        chkLunasTerpusat.setWidth(120);
        chkLunasOnline.setWidth(120);
        chkKoreksiRekening.setWidth(120);

        HorizontalPanel hp1 = new HorizontalPanel();
        hp1.add(chkSorek);
        hp1.add(chkLunasSuplisi);
        hp1.add(chkLunasNota);
        hp1.add(chkKirimTerima);

        vlcPReferensiJnsLaporan.add(hp1);

        hp1 = new HorizontalPanel();
        hp1.add(chkLunasOffline);
        hp1.add(chkSusulan);
        hp1.add(chkBk);
        hp1.add(chkBatalPiutang);

        vlcPReferensiJnsLaporan.add(hp1);

        vlcPReferensiJnsLaporan.add(hp1);

        hp1 = new HorizontalPanel();
        hp1.add(chkLunasTerpusat);
        hp1.add(chkLunasOnline);
        hp1.add(chkKoreksiRekening);

        vlcPReferensiJnsLaporan.add(hp1);

        p.add(panelReferensiJnsLaporan);


        FramedPanel panelButton = new FramedPanel();
        panelButton.setBodyStyle("background: none; padding: 5px");
        panelButton.setWidth(620);

        VerticalLayoutContainer vlcPButton = new VerticalLayoutContainer();
        panelButton.add(vlcPButton);

        TextButton bBottomTampilkanLaporan = new TextButton("Tampilkan Laporan");
        bBottomTampilkanLaporan.setWidth(220);

        TextButton bBottomRekapUlang = new TextButton("Rekap Ulang");
        bBottomRekapUlang.setWidth(220);

        hp1 = new HorizontalPanel();
        hp1.add(bBottomTampilkanLaporan);
        hp1.add(bBottomRekapUlang);
        vlcPButton.add(hp1);

        p.add(panelButton);

        return panel;
    }
}
