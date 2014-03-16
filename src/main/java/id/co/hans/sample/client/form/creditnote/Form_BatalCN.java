package id.co.hans.sample.client.form.creditnote;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.resources.ThemeStyles;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.ComboKodePP;
import id.co.hans.sample.client.components.IconComboBox;
import id.co.hans.sample.client.components.IconDynamicGrid;

public class Form_BatalCN {


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
        panel.setHeadingText("Laporan Pembatalan Credit Note");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        // panel "Berdasarkan Kode PP"
        FramedPanel panelBerdasarkanKodePP = new FramedPanel();
        panelBerdasarkanKodePP.setHeadingText("Berdasarkan Kode PP");
        panelBerdasarkanKodePP.setBodyStyle("background: none; padding: 5px");
        panelBerdasarkanKodePP.setWidth(623);

        VerticalLayoutContainer vlcBerdasarkanKodePP = new VerticalLayoutContainer();
        panelBerdasarkanKodePP.add(vlcBerdasarkanKodePP);


        CheckBox chkPP = new CheckBox();
        chkPP.setBoxLabel("Pilih Kode PP");
        vlcBerdasarkanKodePP.add(chkPP);


        ComboKodePP cbTopPilihKodePp = new ComboKodePP();
        vlcBerdasarkanKodePP.add(cbTopPilihKodePp);

        p.add(panelBerdasarkanKodePP);

        // panel "Parameter Rentang Waktu CN"
        FramedPanel panelParameterRentangWaktuCN = new FramedPanel();
        panelParameterRentangWaktuCN.setHeadingText("Parameter Rentang Waktu CN");
        panelParameterRentangWaktuCN.setBodyStyle("background: none; padding: 5px");
        panelParameterRentangWaktuCN.setWidth(623);
        panelParameterRentangWaktuCN.setHeight(135);

        VerticalLayoutContainer vlcRentangWaktuCN = new VerticalLayoutContainer();
        panelParameterRentangWaktuCN.add(vlcRentangWaktuCN);

        HorizontalPanel hlcRentangRaktuCNTanggalPelunasan = new HorizontalPanel();

        Radio radioTopTglLunas = new Radio();
        radioTopTglLunas.setBoxLabel("Tanggal Pelunasan");
        hlcRentangRaktuCNTanggalPelunasan.add(radioTopTglLunas);

        DateField dfMiddleTglLunasAwal = new DateField();
        dfMiddleTglLunasAwal.getElement().getStyle().setMarginLeft(6, Style.Unit.PX);
        hlcRentangRaktuCNTanggalPelunasan.add(dfMiddleTglLunasAwal);

        Label lbl01 = new Label("Sampai");
        lbl01.getElement().getStyle().setMarginLeft(5, Style.Unit.PX);
        lbl01.getElement().getStyle().setMarginRight(5, Style.Unit.PX);
        lbl01.getElement().getStyle().setMarginTop(3, Style.Unit.PX);
        hlcRentangRaktuCNTanggalPelunasan.add(lbl01);

        DateField dfMiddleTglLunasAkhir = new DateField();
        hlcRentangRaktuCNTanggalPelunasan.add(dfMiddleTglLunasAkhir);

        vlcRentangWaktuCN.add(hlcRentangRaktuCNTanggalPelunasan, new VerticalLayoutContainer.VerticalLayoutData(-1,1));


        HorizontalPanel hlcRentangRaktuCNTanggalSetoran = new HorizontalPanel();

        Radio radioTopTglSetor = new Radio();
        radioTopTglSetor.setBoxLabel("Tanggal Penyetoran");
        hlcRentangRaktuCNTanggalSetoran.add(radioTopTglSetor);

        DateField dfMiddleTglSetorAwal = new DateField();
        hlcRentangRaktuCNTanggalSetoran.add(dfMiddleTglSetorAwal);

        Label lbl02 = new Label("Sampai");
        lbl02.getElement().getStyle().setMarginLeft(5, Style.Unit.PX);
        lbl02.getElement().getStyle().setMarginRight(5, Style.Unit.PX);
        lbl02.getElement().getStyle().setMarginTop(3, Style.Unit.PX);
        hlcRentangRaktuCNTanggalSetoran.add(lbl02);

        DateField dfMiddleTglSetorAkhir = new DateField();
        hlcRentangRaktuCNTanggalSetoran.add(dfMiddleTglSetorAkhir);

        vlcRentangWaktuCN.add(hlcRentangRaktuCNTanggalSetoran, new VerticalLayoutContainer.VerticalLayoutData(-1,1));

        TextButton bMiddleCekData = new TextButton("Cek Data");

        vlcRentangWaktuCN.add(bMiddleCekData);
        vlcRentangWaktuCN.add(new Label("_"));
        vlcRentangWaktuCN.add(new Label("_"));

        p.add(panelParameterRentangWaktuCN);


        // panel "Data CN"

        IconDynamicGrid gpDataCN = new IconDynamicGrid();
        gpDataCN.setGridHeader("Data CN");
        gpDataCN.setGridDimension(623, 200);
        gpDataCN.setStoreUrl("BasicProject/thuGetString.json?name=store1");
        gpDataCN.addColumn("CEK", 100);
        gpDataCN.addColumn("KDPP", 100);
        gpDataCN.addColumn("NO_BATULV06", 100);
        gpDataCN.addColumn("TGLTRANSAKSI", 100);
        gpDataCN.addColumn("TRANSAKSIID", 100);
        gpDataCN.addColumn("TRANSAKSIBY", 100);
        gpDataCN.addColumn("TGL_PELUNASAN", 100);
        gpDataCN.addColumn("TGL_SETOR", 100);
        gpDataCN.addColumn("RPTOTAL", 100);

        p.add(gpDataCN);


        // panel "Data CN yang akan dihapus"
        FramedPanel panelDataCNYangAkanDihapus = new FramedPanel();
        panelDataCNYangAkanDihapus.setHeadingText("Data CN yang akan dihapus");
        panelDataCNYangAkanDihapus.setBodyStyle("background: none; padding: 5px");
        panelDataCNYangAkanDihapus.setWidth(623);
        panelDataCNYangAkanDihapus.setHeight(200);

        VerticalLayoutContainer vlcDataCNYangAkanDihapus = new VerticalLayoutContainer();
        panelDataCNYangAkanDihapus.add(vlcDataCNYangAkanDihapus);

        HorizontalPanel hlcDataCNYangAkanDihapus = new HorizontalPanel();

        TextField tfBottomNoBA = new TextField();
        hlcDataCNYangAkanDihapus.add(new FieldLabel(tfBottomNoBA, "No BA"));

        hlcDataCNYangAkanDihapus.add(new TextButton("Hapus Data"));

        vlcDataCNYangAkanDihapus.add(hlcDataCNYangAkanDihapus);

        HorizontalPanel hlcDataCNYangAkanDihapus2 = new HorizontalPanel();
        TextField tfBottomTglPelunasan = new TextField();
        hlcDataCNYangAkanDihapus2.add(new FieldLabel(tfBottomTglPelunasan, "Tanggal Pelunasan"));
        vlcDataCNYangAkanDihapus.add(hlcDataCNYangAkanDihapus2);

        TextField tfBottomTglPenyetoran = new TextField();
        vlcDataCNYangAkanDihapus.add(new FieldLabel(tfBottomTglPenyetoran, "Tanggal Penyetoran"));

        TextField tfBottomRpTotal = new TextField();
        vlcDataCNYangAkanDihapus.add(new FieldLabel(tfBottomRpTotal, "Rp Total"));

        p.add(panelDataCNYangAkanDihapus);

        return panel;
    }
}
