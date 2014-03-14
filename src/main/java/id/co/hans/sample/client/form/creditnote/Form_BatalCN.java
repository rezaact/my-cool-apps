package id.co.hans.sample.client.form.creditnote;

import id.co.hans.sample.client.AbstractForm;
import id.co.hans.sample.client.components.ComboKodePP;
import id.co.hans.sample.client.components.IconDynamicGrid;

import java.util.Date;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.Radio;
import com.sencha.gxt.widget.core.client.form.TextField;

public class Form_BatalCN extends AbstractForm {

    private static final String EMPTY_STRING = "";
	private static final Date TODAY = new Date();
	private Radio radioTopTglLunas;
	private HorizontalPanel hlcRentangRaktuCNTanggalPelunasan;
	private TextField tfBottomNoBA;
	private TextField tfBottomTglPelunasan;
	private TextField tfBottomTglPenyetoran;
	private TextField tfBottomRpTotal;
	private DateField dfMiddleTglLunasAwal;
	private DateField dfMiddleTglLunasAkhir;
	private DateField dfMiddleTglSetorAwal;
	private DateField dfMiddleTglSetorAkhir;
	private ComboKodePP cbTopPilihKodePp;

	@Override
    protected FramedPanel panelMain() {

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


        cbTopPilihKodePp = new ComboKodePP();
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

        hlcRentangRaktuCNTanggalPelunasan = new HorizontalPanel();

        radioTopTglLunas = new Radio();
        radioTopTglLunas.setBoxLabel("Tanggal Pelunasan");
        hlcRentangRaktuCNTanggalPelunasan.add(radioTopTglLunas);

        dfMiddleTglLunasAwal = new DateField();
        dfMiddleTglLunasAwal.getElement().getStyle().setMarginLeft(6, Style.Unit.PX);
        hlcRentangRaktuCNTanggalPelunasan.add(dfMiddleTglLunasAwal);

        Label lbl01 = new Label("Sampai");
        lbl01.getElement().getStyle().setMarginLeft(5, Style.Unit.PX);
        lbl01.getElement().getStyle().setMarginRight(5, Style.Unit.PX);
        lbl01.getElement().getStyle().setMarginTop(3, Style.Unit.PX);
        hlcRentangRaktuCNTanggalPelunasan.add(lbl01);

        dfMiddleTglLunasAkhir = new DateField();
        hlcRentangRaktuCNTanggalPelunasan.add(dfMiddleTglLunasAkhir);

        vlcRentangWaktuCN.add(hlcRentangRaktuCNTanggalPelunasan, new VerticalLayoutContainer.VerticalLayoutData(-1,1));


        HorizontalPanel hlcRentangRaktuCNTanggalSetoran = new HorizontalPanel();

        Radio radioTopTglSetor = new Radio();
        radioTopTglSetor.setBoxLabel("Tanggal Penyetoran");
        hlcRentangRaktuCNTanggalSetoran.add(radioTopTglSetor);

        dfMiddleTglSetorAwal = new DateField();
        hlcRentangRaktuCNTanggalSetoran.add(dfMiddleTglSetorAwal);

        Label lbl02 = new Label("Sampai");
        lbl02.getElement().getStyle().setMarginLeft(5, Style.Unit.PX);
        lbl02.getElement().getStyle().setMarginRight(5, Style.Unit.PX);
        lbl02.getElement().getStyle().setMarginTop(3, Style.Unit.PX);
        hlcRentangRaktuCNTanggalSetoran.add(lbl02);

        dfMiddleTglSetorAkhir = new DateField();
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

        tfBottomNoBA = new TextField();
        hlcDataCNYangAkanDihapus.add(new FieldLabel(tfBottomNoBA, "No BA"));

        hlcDataCNYangAkanDihapus.add(new TextButton("Hapus Data"));

        vlcDataCNYangAkanDihapus.add(hlcDataCNYangAkanDihapus);

        HorizontalPanel hlcDataCNYangAkanDihapus2 = new HorizontalPanel();
        tfBottomTglPelunasan = new TextField();
        hlcDataCNYangAkanDihapus2.add(new FieldLabel(tfBottomTglPelunasan, "Tanggal Pelunasan"));
        vlcDataCNYangAkanDihapus.add(hlcDataCNYangAkanDihapus2);

        tfBottomTglPenyetoran = new TextField();
        vlcDataCNYangAkanDihapus.add(new FieldLabel(tfBottomTglPenyetoran, "Tanggal Penyetoran"));

        tfBottomRpTotal = new TextField();
        vlcDataCNYangAkanDihapus.add(new FieldLabel(tfBottomRpTotal, "Rp Total"));

        p.add(panelDataCNYangAkanDihapus);

        return panel;
    }

	@Override
	protected void initEvent() {
		radioTopTglLunas.setValue(true);
		tfBottomNoBA.setValue(EMPTY_STRING);
		tfBottomTglPelunasan.setValue(EMPTY_STRING);
		tfBottomTglPenyetoran.setValue(EMPTY_STRING);
		tfBottomRpTotal.setValue(EMPTY_STRING);
		dfMiddleTglLunasAwal.setValue(TODAY);
		dfMiddleTglLunasAkhir.setValue(TODAY);
		dfMiddleTglSetorAwal.setValue(TODAY);
		dfMiddleTglSetorAkhir.setValue(TODAY);
	}
}
