package id.co.hans.sample.client.form.reportpantau;

//todo: kayaknya salah form bro..  Form_PemantauanBatalTransaksi

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.Radio;
import com.sencha.gxt.widget.core.client.form.TextField;
import id.co.hans.sample.client.components.ComboJenisTransaksi;
import id.co.hans.sample.client.components.ComboUnit;
import id.co.hans.sample.client.components.IconDynamicGrid;

public class Form_PemantauanBatalTransaksi {


    private VerticalPanel vp;

    ComboUnit cbUnit;
    ComboJenisTransaksi cbJenisTransaksi;
    Radio radioTopJenisPemantauanDaftar;
    Radio radioTopJenisPemantauanRekap;

    Radio radioTopJenisTanggalTransaksi;
    Radio radioTopJenisTanggalPembukuan;

    DateField dfTopTanggalAwal;
    DateField dfTopTanggalAkhir;

    TextField tfBottomRpTagihan;
    TextField tfBottomRpBK;

    TextButton btnCetak;

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
        panel.setHeadingText("Transaksi Piutang");
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

        cbUnit = new ComboUnit();
        vlcPReferensi.add(cbUnit);

        cbJenisTransaksi = new ComboJenisTransaksi();
        cbJenisTransaksi.setFormAsal("Form_PemantauanTransaksi");
        vlcPReferensi.add(cbJenisTransaksi);

        p.add(panelReferensi);


        FramedPanel panelReferensiTgl = new FramedPanel();
        panelReferensiTgl.setBodyStyle("background: none; padding: 5px");
        panelReferensiTgl.setWidth(620);

        VerticalLayoutContainer vlcPReferensiTgl = new VerticalLayoutContainer();
        panelReferensiTgl.add(vlcPReferensiTgl);

        radioTopJenisPemantauanDaftar = new Radio();
        radioTopJenisPemantauanDaftar.setBoxLabel("Daftar");
        radioTopJenisPemantauanDaftar.setValue(true);

        radioTopJenisPemantauanRekap = new Radio();
        radioTopJenisPemantauanRekap.setBoxLabel("Rekap");

        HorizontalPanel hp1 = new HorizontalPanel();
        hp1.add(radioTopJenisPemantauanDaftar);
        hp1.add(radioTopJenisPemantauanRekap);

        vlcPReferensiTgl.add(new FieldLabel(hp1, "Pilih Jenis Pemantauan"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1, new Margins(0,0,0,0)));

        p.add(panelReferensiTgl);


        FramedPanel panelReferensiJnsTgl = new FramedPanel();
        panelReferensiJnsTgl.setBodyStyle("background: none; padding: 5px");
        panelReferensiJnsTgl.setWidth(620);

        VerticalLayoutContainer vlcPReferensiJnsTgl = new VerticalLayoutContainer();
        panelReferensiJnsTgl.add(vlcPReferensiJnsTgl);

        radioTopJenisTanggalTransaksi = new Radio();
        radioTopJenisTanggalTransaksi.setBoxLabel("Transaksi");
        radioTopJenisTanggalTransaksi.setValue(true);

        radioTopJenisTanggalPembukuan = new Radio();
        radioTopJenisTanggalPembukuan.setBoxLabel("Pembukuan");

        hp1 = new HorizontalPanel();
        hp1.add(radioTopJenisTanggalTransaksi);
        hp1.add(radioTopJenisTanggalPembukuan);

        vlcPReferensiJnsTgl.add(new FieldLabel(hp1, "Pilih Jenis Tanggal"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1, new Margins(0,0,0,0)));

        p.add(panelReferensiJnsTgl);


        FramedPanel panelReferensiTgl2 = new FramedPanel();
        panelReferensiTgl2.setBodyStyle("background: none; padding: 5px");
        panelReferensiTgl2.setWidth(620);

        VerticalLayoutContainer vlcPReferensiJnsTgl2 = new VerticalLayoutContainer();
        panelReferensiTgl2.add(vlcPReferensiJnsTgl2);

        dfTopTanggalAwal = new DateField();
        dfTopTanggalAkhir = new DateField();

        TextButton bTopTampilkan = new TextButton("Tampilkan");

        hp1 = new HorizontalPanel();
        hp1.add(dfTopTanggalAwal);
        hp1.add(bTopTampilkan);

        vlcPReferensiJnsTgl2.add(new FieldLabel(hp1, "Tanggal"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1, new Margins(0,0,0,0)));

        hp1 = new HorizontalPanel();
        hp1.add(dfTopTanggalAkhir);

        vlcPReferensiJnsTgl2.add(new FieldLabel(hp1, "Tanggal Akhir"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1, new Margins(0,0,0,0)));

        p.add(panelReferensiTgl2);


        IconDynamicGrid gpData = new IconDynamicGrid();
        gpData.setGridHeader("Data");
        gpData.setGridDimension(620, 150);
        gpData.setStoreUrl("url");

        gpData.addColumn("No", 100);

        p.add(gpData);



        FramedPanel panelButton = new FramedPanel();
        panelButton.setBodyStyle("background: none; padding: 5px");
        panelButton.setWidth(620);

        VerticalLayoutContainer vlcPButton = new VerticalLayoutContainer();
        panelButton.add(vlcPButton);

        tfBottomRpTagihan = new TextField();
        tfBottomRpBK = new TextField();

        btnCetak = new TextButton("Cetak");
        btnCetak.setWidth(220);


        hp1 = new HorizontalPanel();
        hp1.add(new FieldLabel(tfBottomRpTagihan, "RP TAGIHAN"));
        vlcPButton.add(hp1);

        hp1 = new HorizontalPanel();
        hp1.add(new FieldLabel(tfBottomRpBK, "RP BK"));
        vlcPButton.add(hp1);

        hp1 = new HorizontalPanel();
        hp1.add(btnCetak);
        vlcPButton.add(hp1);

        p.add(panelButton);


        ToggleGroup tg = new ToggleGroup();
        tg.add(radioTopJenisPemantauanDaftar);
        tg.add(radioTopJenisPemantauanRekap);

        ToggleGroup tg2 = new ToggleGroup();
        tg2.add(radioTopJenisTanggalPembukuan);
        tg2.add(radioTopJenisTanggalTransaksi);

        return panel;
    }


    private void initEvent() {
        btnCetak.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                petugas = idUser;
                String url = "";

//                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=PemantauanTransaksi"
//                        +"&vPilihSaldo="+pilihSaldo
//                        +"&vPilihRep="+pilihRep
//                        +"&tUnitUP="+cbUnits.getUnitUpValue()
//                        +"&tUnitAP="+cbUnits.getUnitApValue()
//                        +"&tTglmulai="+""
//                        +"&tTglsampai="+""
//                        +"&tBlTh="+""
//                        +"&in_unitupi="+cbUnits.getUnitUpiValue()
//                        +"&judulsatu="+judulsatu
//                        +"&juduldua="+juduldua
//                ;

//                url+="&report=report/ReportPantau/Saldo/" + sRptName + ".rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
