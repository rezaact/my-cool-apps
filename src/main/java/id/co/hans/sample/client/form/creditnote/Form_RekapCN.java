package id.co.hans.sample.client.form.creditnote;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.ComboKodePP;
import id.co.hans.sample.client.components.ComboUnit;
import id.co.hans.sample.client.components.IconComboBox;
import id.co.hans.sample.client.components.IconDynamicGrid;

public class Form_RekapCN {


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
        panel.setHeadingText("Laporan Credit Note");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);
        panel.setHeight(300);


        VerticalLayoutContainer vlc = new VerticalLayoutContainer();
        panel.add(vlc);


        ComboUnit cbTopPilihUnitUp = new ComboUnit();
        vlc.add(cbTopPilihUnitUp);

        ComboKodePP cbTopPilihKodePp = new ComboKodePP();
        vlc.add(cbTopPilihKodePp);

        //LayoutColumn 300px
        //label Berdasarkan Tanggal Pelunasan:

        HorizontalLayoutContainer hlcBerdasarkan = new HorizontalLayoutContainer();
        vlc.add(hlcBerdasarkan);

        FramedPanel panelTglPelunasan = new FramedPanel();
        panelTglPelunasan.setHeadingText("Berdasarkan Tanggal Pelunasan");
        panelTglPelunasan.setBodyStyle("background: none; padding: 5px;");
        panelTglPelunasan.setWidth(300);
        panelTglPelunasan.setHeight(130);

        VerticalLayoutContainer vlcTglPelunasan = new VerticalLayoutContainer();
        panelTglPelunasan.add(vlcTglPelunasan);

        DateField dfMiddleTanggalPelunasanTanggalAwal = new DateField();
        vlcTglPelunasan.add(new FieldLabel(dfMiddleTanggalPelunasanTanggalAwal, "Tanggal Awal"));

        DateField dfMiddleTanggalPelunasanTanggalAkhir = new DateField();
        vlcTglPelunasan.add(new FieldLabel(dfMiddleTanggalPelunasanTanggalAkhir, "Tanggal Akhir"));

        panelTglPelunasan.addButton(new TextButton("Tampilkan"));
        panelTglPelunasan.addButton(new TextButton("Format (II)"));
        panelTglPelunasan.addButton(new TextButton("Format (III)"));

        hlcBerdasarkan.add(panelTglPelunasan);


        //LayoutColumn 300px
        //label Berdasarkan Tanggal Penyetoran:

        FramedPanel panelTglPenyetoran = new FramedPanel();
        panelTglPenyetoran.setHeadingText("Berdasarkan Tanggal Penyetoran");
        panelTglPenyetoran.setBodyStyle("background: none; padding: 5px;");
        panelTglPenyetoran.setWidth(300);
        panelTglPenyetoran.setHeight(130);

        VerticalLayoutContainer vlcTglPenyetoran = new VerticalLayoutContainer();
        panelTglPenyetoran.add(vlcTglPenyetoran);


        DateField dfMiddleTanggalPenyetoranTanggalAwal = new DateField();
        vlcTglPenyetoran.add(new FieldLabel(dfMiddleTanggalPenyetoranTanggalAwal, "Tanggal Awal"));

        DateField dfMiddleTanggalPenyetoranTanggalAkhir = new DateField();
        vlcTglPenyetoran.add(new FieldLabel(dfMiddleTanggalPenyetoranTanggalAkhir, "Tanggal Akhir"));

        panelTglPenyetoran.addButton(new TextButton("Tampilkan"));

        hlcBerdasarkan.add(panelTglPenyetoran);

        return panel;
    }
}
