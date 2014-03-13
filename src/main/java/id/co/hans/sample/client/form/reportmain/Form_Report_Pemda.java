package id.co.hans.sample.client.form.reportmain;

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

public class Form_Report_Pemda {


    private VerticalPanel vp;

    private String idUser, levelUser, unitUser;

    public Widget asWidget(String idUser, String unitupUser, String levelUser) {
        this.idUser=idUser;
        this.unitUser=unitUser;
        this.levelUser=levelUser;

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
        panel.setHeadingText("Rekap Pemda");
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

        ComboJenisLaporan cbJenisLaporan = new ComboJenisLaporan();
        vlcPReferensiTgl.add(cbJenisLaporan);

        p.add(panelReferensiTgl);


        FramedPanel panelParameter = new FramedPanel();
        panelParameter.setBodyStyle("background: none; padding: 5px");
        panelParameter.setWidth(620);

        VerticalLayoutContainer vlcPParameter = new VerticalLayoutContainer();
        panelParameter.add(vlcPParameter);

        TextButton bBottom11RekeningBaru = new TextButton("11. Rekening Baru");
        TextButton bBottom12KoreksiRekening = new TextButton("12. Koreksi Rekening");
        TextButton bBottomSaldoPerPemda = new TextButton("Saldo Per Pemda");

        TextButton bBottom21PelunasanOffline = new TextButton("21. Pelunasan Offline");
        TextButton bBottom22PelunasanOnline = new TextButton("22. Pelunasan Online");
        TextButton bBottom23PelunasanNota = new TextButton("23. Pelunasan Nota");

        bBottom11RekeningBaru.setWidth(220);
        bBottom12KoreksiRekening.setWidth(220);
        bBottomSaldoPerPemda.setWidth(220);

        bBottom21PelunasanOffline.setWidth(220);
        bBottom22PelunasanOnline.setWidth(220);
        bBottom23PelunasanNota.setWidth(220);

        HorizontalPanel hp1 = new HorizontalPanel();

        hp1.add(bBottom11RekeningBaru);
        hp1.add(bBottom21PelunasanOffline);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottom12KoreksiRekening);
        hp1.add(bBottom22PelunasanOnline);

        vlcPParameter.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomSaldoPerPemda);
        hp1.add(bBottom23PelunasanNota);

        vlcPParameter.add(hp1);

        p.add(panelParameter);


        return panel;
    }
}
