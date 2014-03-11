package id.co.hans.sample.client.form.reportpantau;

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

public class Form_PemantauanSaldoBulan {


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
        panel.setHeadingText("Saldo Bulan Lalu");
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

        p.add(panelReferensi);


        FramedPanel panelReferensiTgl = new FramedPanel();
        panelReferensiTgl.setHeadingText("Pilih Parameter");
        panelReferensiTgl.setBodyStyle("background: none; padding: 5px");
        panelReferensiTgl.setWidth(620);

        VerticalLayoutContainer vlcPReferensiTgl = new VerticalLayoutContainer();
        panelReferensiTgl.add(vlcPReferensiTgl);

        ComboTahunBulan cbTahunBulan = new ComboTahunBulan();
        vlcPReferensiTgl.add(cbTahunBulan);

        p.add(panelReferensiTgl);



        FramedPanel panelButton = new FramedPanel();
        panelButton.setBodyStyle("background: none; padding: 5px");
        panelButton.setWidth(620);

        VerticalLayoutContainer vlcPButton = new VerticalLayoutContainer();
        panelButton.add(vlcPButton);

        TextButton bBottomRekapSaldoRekeningLancar = new TextButton("Rekap Saldo Rekening Lancar");
        TextButton bBottomRekapSaldoRekeningRagu2 = new TextButton("Rekap Saldo Rekening Ragu2");
        TextButton bBottomRekapSaldoRekeningPerGolTarip = new TextButton("Rekap Saldo Rekening Per Gol Tarip");

        TextButton bBottomRekapSaldoRekeningLancarPerGol = new TextButton("Rekap Saldo Rekening Lancar Per Gol");
        TextButton bBottomRekapSaldoRekgLancarPerBlthrek = new TextButton("Rekap Saldo Rekg Lancar per BLTHREK");
        TextButton bBottomRekapSaldoPerBlthrekPerTarip = new TextButton("Rekap Saldo per BLTHREK per Tarip");

        bBottomRekapSaldoRekeningLancar.setWidth(220);
        bBottomRekapSaldoRekeningRagu2.setWidth(220);
        bBottomRekapSaldoRekeningPerGolTarip.setWidth(220);

        bBottomRekapSaldoRekeningLancarPerGol.setWidth(220);
        bBottomRekapSaldoRekgLancarPerBlthrek.setWidth(220);
        bBottomRekapSaldoPerBlthrekPerTarip.setWidth(220);

        HorizontalPanel hp1 = new HorizontalPanel();

        hp1.add(bBottomRekapSaldoRekeningLancar);
        hp1.add(bBottomRekapSaldoRekeningLancarPerGol);

        vlcPButton.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomRekapSaldoRekeningRagu2);
        hp1.add(bBottomRekapSaldoRekgLancarPerBlthrek);

        vlcPButton.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomRekapSaldoRekeningPerGolTarip);
        hp1.add(bBottomRekapSaldoPerBlthrekPerTarip);

        vlcPButton.add(hp1);

        p.add(panelButton);


        FramedPanel panelButton2 = new FramedPanel();
        panelButton2.setBodyStyle("background: none; padding: 5px");
        panelButton2.setWidth(620);

        VerticalLayoutContainer vlcPButton2 = new VerticalLayoutContainer();
        panelButton2.add(vlcPButton2);

        TextButton bBottomRekapSaldoRekeningPerUnsur = new TextButton("Rekap Saldo Rekening per Unsur");

        TextButton bBottomRekapSaldoRekeningPerUmurPiutang = new TextButton("Rekap Saldo Rekening per Umur Piutang");
        TextButton bBottomRekapSaldoRekeningPerBLTHdanGol = new TextButton("Rekap Saldo Rekening per BLTH dan Gol");

        bBottomRekapSaldoRekeningPerUnsur.setWidth(220);

        bBottomRekapSaldoRekeningPerUmurPiutang.setWidth(220);
        bBottomRekapSaldoRekeningPerBLTHdanGol.setWidth(220);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomRekapSaldoRekeningPerUnsur);
        hp1.add(bBottomRekapSaldoRekeningPerUmurPiutang);

        vlcPButton2.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomRekapSaldoRekeningPerBLTHdanGol);

        vlcPButton2.add(hp1);

        p.add(panelButton2);


        return panel;
    }
}
