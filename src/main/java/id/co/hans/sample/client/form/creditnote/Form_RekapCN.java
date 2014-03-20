package id.co.hans.sample.client.form.creditnote;

import id.co.hans.sample.client.AbstractForm;
import id.co.hans.sample.client.components.ComboKodePP;
import id.co.hans.sample.client.components.ComboUnit;
import id.co.hans.sample.constants.WsUmumUrlConstants;

import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;

public class Form_RekapCN extends AbstractForm {


    private ComboUnit cbTopPilihUnitUp;
	private ComboKodePP cbTopPilihKodePp;

	protected FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("Laporan Credit Note");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);
        panel.setHeight(300);


        VerticalLayoutContainer vlc = new VerticalLayoutContainer();
        panel.add(vlc);


        cbTopPilihUnitUp = new ComboUnit();
        vlc.add(cbTopPilihUnitUp);

        cbTopPilihKodePp = new ComboKodePP();
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

	@Override
	@SuppressWarnings("unchecked")
	protected void initEvent() {
		cbTopPilihUnitUp.getChangesComboBoxStore().put(
				cbTopPilihKodePp.getComboBox().getComboBox(),
				WsUmumUrlConstants.KODE_PP_DARI_UNIT_UP_URL);
		
	}
}
