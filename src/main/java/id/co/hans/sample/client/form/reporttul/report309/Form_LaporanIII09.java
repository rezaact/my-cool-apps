package id.co.hans.sample.client.form.reporttul.report309;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
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
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.*;

public class Form_LaporanIII09 {


    private VerticalPanel vp;

    ComboUnit cbUnit;
    Radio radioTopPilihReferensiMurni;
    Radio radioTopPilihReferensiPerUnit;
    ComboTahunBulan cbTahunBulan;

    Radio radioTulIII07;
    Radio radioKoreksiLbrI;
    Radio radioKoreksiLbrII;

    TextButton bBottomBuatLaporan;
    TextButton bBottomTampilkanLaporan;

    private String idUser, levelUser, unitUser;

    public Widget asWidget(String idUser, String unitupUser, String levelUser) {
        this.idUser=idUser;
        this.unitUser=unitupUser;
        this.levelUser=levelUser;

        if (vp == null) {
            vp = new VerticalPanel();
            vp.setSpacing(5);
            initKomponen();
            initEvent();
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
        panel.setHeadingText("Laporan Penjualan Tenaga Listrik (TUL III-09)");
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

        cbUnit = new ComboUnit(levelUser, unitUser);
        vlcPReferensi.add(cbUnit);

        radioTopPilihReferensiMurni = new Radio();
        radioTopPilihReferensiMurni.setValue(true);
        radioTopPilihReferensiMurni.setBoxLabel("Murni");

        radioTopPilihReferensiPerUnit = new Radio();
        radioTopPilihReferensiPerUnit.setBoxLabel("per Unit");

        HorizontalPanel hp1 = new HorizontalPanel();
        hp1.add(radioTopPilihReferensiMurni);
        hp1.add(radioTopPilihReferensiPerUnit);

        vlcPReferensi.add(hp1, new VerticalLayoutContainer.VerticalLayoutData(-1,-1,new Margins(0,0,0,100)));

        p.add(panelReferensi);


        FramedPanel panelReferensiTgl = new FramedPanel();
        panelReferensiTgl.setHeadingText("Pilih Parameter");
        panelReferensiTgl.setBodyStyle("background: none; padding: 5px");
        panelReferensiTgl.setWidth(620);

        VerticalLayoutContainer vlcPReferensiTgl = new VerticalLayoutContainer();
        panelReferensiTgl.add(vlcPReferensiTgl);

        cbTahunBulan = new ComboTahunBulan();
        vlcPReferensiTgl.add(cbTahunBulan);

        p.add(panelReferensiTgl);


        FramedPanel panelReferensiJnsLaporan = new FramedPanel();
        panelReferensiJnsLaporan.setHeadingText("Jenis");
        panelReferensiJnsLaporan.setBodyStyle("background: none; padding: 5px");
        panelReferensiJnsLaporan.setWidth(620);

        VerticalLayoutContainer vlcPReferensiJnsLaporan = new VerticalLayoutContainer();
        panelReferensiJnsLaporan.add(vlcPReferensiJnsLaporan);

        radioTulIII07 = new Radio();
        radioTulIII07.setBoxLabel("TUL III-07");
        radioTulIII07.setValue(true);

        radioKoreksiLbrI = new Radio();
        radioKoreksiLbrI.setBoxLabel("Koreksi Lbr I");

        radioKoreksiLbrII = new Radio();
        radioKoreksiLbrII.setBoxLabel("Koreksi Lbr II");

        Radio radioTulIII09 = new Radio();
        radioTulIII09.setBoxLabel("TUL III-09");

        hp1 = new HorizontalPanel();
        hp1.add(radioTulIII07);
        hp1.add(radioKoreksiLbrI);
        hp1.add(radioKoreksiLbrII);
        hp1.add(radioTulIII09);

        vlcPReferensiJnsLaporan.add(hp1);

        p.add(panelReferensiJnsLaporan);


        FramedPanel panelButton = new FramedPanel();
        panelButton.setBodyStyle("background: none; padding: 5px");
        panelButton.setWidth(620);

        VerticalLayoutContainer vlcPButton = new VerticalLayoutContainer();
        panelButton.add(vlcPButton);

        bBottomBuatLaporan = new TextButton("Buat Laporan");
        bBottomBuatLaporan.setWidth(220);

        bBottomTampilkanLaporan = new TextButton("Tampilkan Laporan");
        bBottomTampilkanLaporan.setWidth(220);

        hp1 = new HorizontalPanel();
        hp1.add(bBottomBuatLaporan);
        hp1.add(bBottomTampilkanLaporan);
        vlcPButton.add(hp1);

        p.add(panelButton);


        ToggleGroup tg = new ToggleGroup();
        tg.add(radioTopPilihReferensiMurni);
        tg.add(radioTopPilihReferensiPerUnit);

        ToggleGroup tg2 = new ToggleGroup();
        tg2.add(radioTulIII07);
        tg2.add(radioKoreksiLbrI);
        tg2.add(radioKoreksiLbrII);
        tg2.add(radioTulIII09);

        return panel;
    }


    private void initEvent() {
        bBottomBuatLaporan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {

            }
        });


        bBottomTampilkanLaporan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
            }
        });
    }
}
