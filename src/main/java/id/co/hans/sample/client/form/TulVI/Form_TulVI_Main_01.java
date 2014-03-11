package id.co.hans.sample.client.form.TulVI;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.ComboKodeKolektif;
import id.co.hans.sample.client.components.ComboKodeSiklis;
import id.co.hans.sample.client.components.ComboNamaPetugas;
import id.co.hans.sample.client.components.ComboUnit;

public class Form_TulVI_Main_01 {


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
        panel.setHeadingText("Cetak Pemutusan (Tul VI-01)");
        panel.setBodyStyle("background: none; padding: 0px");
        panel.setWidth(1000);

            VerticalLayoutContainer p = new VerticalLayoutContainer();

                FramedPanel panelNorth = new FramedPanel();
                panelNorth.setBodyStyle("background: none; padding: 5px");
                panelNorth.setHeaderVisible(false);
                panelNorth.setWidth(988);
                panelNorth.setHeight(50);

                    VerticalLayoutContainer vlcPNorth = new VerticalLayoutContainer();

                        HorizontalPanel hpVlcPNorth = new HorizontalPanel();

                            Label lblVlcPNorth_desc = new Label("Klik Proses Ini Untuk Memperbaharui Data Tunggakan dan Pelunasan");

                            Label lblVlcPNorth_descHidden = new Label("");
                            lblVlcPNorth_descHidden.setPixelSize(10,1);

                            TextButton bTopVerifikasiTulVI = new TextButton("Verifikasi Tul VI");

                        hpVlcPNorth.add(lblVlcPNorth_desc);
                        hpVlcPNorth.add(lblVlcPNorth_descHidden);
                        hpVlcPNorth.add(bTopVerifikasiTulVI);

                    vlcPNorth.add(hpVlcPNorth);

                panelNorth.add(vlcPNorth);

            p.add(panelNorth);

                FramedPanel panelCenter = new FramedPanel();
                panelCenter.setBodyStyle("background: none; padding: 1px");
                panelCenter.setHeaderVisible(true);
                panelCenter.setWidth(988);
                panelCenter.setHeight(600);

                    HorizontalLayoutContainer hlcPCenter = new HorizontalLayoutContainer();

                        VerticalLayoutContainer vlcPCenter = new VerticalLayoutContainer();

                            FramedPanel panelCenterPilihKriteria = new FramedPanel();
                            panelCenterPilihKriteria.setHeadingText("Pilih Kriteria");
                            panelCenterPilihKriteria.setBodyStyle("background: none; padding: 1px");
                            panelCenterPilihKriteria.setWidth(600);
                            panelCenterPilihKriteria.setHeight(480);

                                VerticalLayoutContainer vlcPanelCenterPilihKriteria = new VerticalLayoutContainer();

                                    ComboUnit cbTopUnitUP = new ComboUnit();

                                vlcPanelCenterPilihKriteria.add(cbTopUnitUP);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line1 = new HorizontalPanel();

                                        Label lblPanelCenterPilihKriteria_desc1 = new Label("Kriteria Pencetakan:");
                                        Label lblPanelCenterPilihKriteria_desc2 = new Label("Awal");
                                        Label lblPanelCenterPilihKriteria_desc3 = new Label("Akhir");

                                        Label lblPanelCenterPilihKriteria_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_spacer1.setPixelSize(125,1);
                                        lblPanelCenterPilihKriteria_spacer2.setPixelSize(195,1);

                                    hpPanelCenterPilihKriteria_line1.add(lblPanelCenterPilihKriteria_desc1);
                                    hpPanelCenterPilihKriteria_line1.add(lblPanelCenterPilihKriteria_spacer1);
                                    hpPanelCenterPilihKriteria_line1.add(lblPanelCenterPilihKriteria_desc2);
                                    hpPanelCenterPilihKriteria_line1.add(lblPanelCenterPilihKriteria_spacer2);
                                    hpPanelCenterPilihKriteria_line1.add(lblPanelCenterPilihKriteria_desc3);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line1);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line2 = new HorizontalPanel();

                                        CheckBox cbTopNoPelanggan = new CheckBox();
                                        cbTopNoPelanggan.setBoxLabel("No Pelanggan");

                                        TextField tfTopNoPelangganAwal_1 = new TextField();
                                        TextField tfTopNoPelangganAwal_2 = new TextField();
                                        TextField tfTopNoPelangganAkhir_1 = new TextField();
                                        TextField tfTopNoPelangganAkhir_2 = new TextField();

                                        tfTopNoPelangganAwal_1.setWidth(100);
                                        tfTopNoPelangganAwal_2.setWidth(100);
                                        tfTopNoPelangganAkhir_1.setWidth(100);
                                        tfTopNoPelangganAkhir_2.setWidth(100);

                                        Label lblPanelCenterPilihKriteria_line2_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_line2_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_line2_spacer1.setPixelSize(60,1);
                                        lblPanelCenterPilihKriteria_line2_spacer2.setPixelSize(20,1);

                                    hpPanelCenterPilihKriteria_line2.add(cbTopNoPelanggan);
                                    hpPanelCenterPilihKriteria_line2.add(lblPanelCenterPilihKriteria_line2_spacer1);
                                    hpPanelCenterPilihKriteria_line2.add(tfTopNoPelangganAwal_1);
                                    hpPanelCenterPilihKriteria_line2.add(tfTopNoPelangganAwal_2);
                                    hpPanelCenterPilihKriteria_line2.add(lblPanelCenterPilihKriteria_line2_spacer2);
                                    hpPanelCenterPilihKriteria_line2.add(tfTopNoPelangganAkhir_1);
                                    hpPanelCenterPilihKriteria_line2.add(tfTopNoPelangganAkhir_2);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line2);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line3 = new HorizontalPanel();

                                        CheckBox cbTopJumlahLembar = new CheckBox();
                                        cbTopJumlahLembar.setBoxLabel("Jumlah Lembar");

                                        TextField tfTopJumlahLembarAwal = new TextField();
                                        TextField tfTopJumlahLembarAkhir = new TextField();

                                        tfTopJumlahLembarAwal.setWidth(100);
                                        tfTopJumlahLembarAkhir.setWidth(100);

                                        Label lblPanelCenterPilihKriteria_line3_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_line3_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_line3_spacer1.setPixelSize(100,1);
                                        lblPanelCenterPilihKriteria_line3_spacer2.setPixelSize(120,1);

                                    hpPanelCenterPilihKriteria_line3.add(cbTopJumlahLembar);
                                    hpPanelCenterPilihKriteria_line3.add(lblPanelCenterPilihKriteria_line3_spacer1);
                                    hpPanelCenterPilihKriteria_line3.add(tfTopJumlahLembarAwal);
                                    hpPanelCenterPilihKriteria_line3.add(lblPanelCenterPilihKriteria_line3_spacer2);
                                    hpPanelCenterPilihKriteria_line3.add(tfTopJumlahLembarAkhir);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line3);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line4 = new HorizontalPanel();

                                        CheckBox cbTopRupiahTagih = new CheckBox();
                                        cbTopRupiahTagih.setBoxLabel("Rupiah Tagih");

                                        TextField tfTopRupiahTagihAwal = new TextField();
                                        TextField tfTopRupiahTagihAkhir = new TextField();

                                        tfTopRupiahTagihAwal.setWidth(100);
                                        tfTopRupiahTagihAkhir.setWidth(100);

                                        Label lblPanelCenterPilihKriteria_line4_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_line4_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_line4_spacer1.setPixelSize(110,1);
                                        lblPanelCenterPilihKriteria_line4_spacer2.setPixelSize(120,1);

                                    hpPanelCenterPilihKriteria_line4.add(cbTopRupiahTagih);
                                    hpPanelCenterPilihKriteria_line4.add(lblPanelCenterPilihKriteria_line4_spacer1);
                                    hpPanelCenterPilihKriteria_line4.add(tfTopRupiahTagihAwal);
                                    hpPanelCenterPilihKriteria_line4.add(lblPanelCenterPilihKriteria_line4_spacer2);
                                    hpPanelCenterPilihKriteria_line4.add(tfTopRupiahTagihAkhir);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line4);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line5 = new HorizontalPanel();

                                        CheckBox cbTopBesarDaya = new CheckBox();
                                        cbTopBesarDaya.setBoxLabel("Besar Daya");

                                        TextField tfTopBesarDayaAwal = new TextField();
                                        TextField tfTopBesarDayaAkhir = new TextField();

                                        tfTopBesarDayaAwal.setWidth(100);
                                        tfTopBesarDayaAkhir.setWidth(100);

                                        Label lblPanelCenterPilihKriteria_line5_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_line5_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_line5_spacer1.setPixelSize(123,1);
                                        lblPanelCenterPilihKriteria_line5_spacer2.setPixelSize(120,1);

                                    hpPanelCenterPilihKriteria_line5.add(cbTopBesarDaya);
                                    hpPanelCenterPilihKriteria_line5.add(lblPanelCenterPilihKriteria_line5_spacer1);
                                    hpPanelCenterPilihKriteria_line5.add(tfTopBesarDayaAwal);
                                    hpPanelCenterPilihKriteria_line5.add(lblPanelCenterPilihKriteria_line5_spacer2);
                                    hpPanelCenterPilihKriteria_line5.add(tfTopBesarDayaAkhir);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line5);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line6 = new HorizontalPanel();

                                        CheckBox cbTopKodeGolongan = new CheckBox();
                                        cbTopKodeGolongan.setBoxLabel("Kode Golongan");

                                        TextField tfTopKodeGolonganAwal = new TextField();
                                        TextField tfTopKodeGolonganAkhir = new TextField();

                                        tfTopKodeGolonganAwal.setWidth(100);
                                        tfTopKodeGolonganAkhir.setWidth(100);

                                        Label lblPanelCenterPilihKriteria_line6_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_line6_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_line6_spacer1.setPixelSize(98,1);
                                        lblPanelCenterPilihKriteria_line6_spacer2.setPixelSize(120,1);

                                    hpPanelCenterPilihKriteria_line6.add(cbTopKodeGolongan);
                                    hpPanelCenterPilihKriteria_line6.add(lblPanelCenterPilihKriteria_line6_spacer1);
                                    hpPanelCenterPilihKriteria_line6.add(tfTopKodeGolonganAwal);
                                    hpPanelCenterPilihKriteria_line6.add(lblPanelCenterPilihKriteria_line6_spacer2);
                                    hpPanelCenterPilihKriteria_line6.add(tfTopKodeGolonganAkhir);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line6);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line7 = new HorizontalPanel();

                                        CheckBox cbTopNoRBM_KOKED = new CheckBox();
                                        cbTopNoRBM_KOKED.setBoxLabel("No. RBM/KOKED");

                                        TextField tfTopNoRBM_KOKED = new TextField();
                                        Label lblPanelCenterPilihKriteria_line7_desc = new Label("-> (Sebagian / Seluruh)");

                                        tfTopNoRBM_KOKED.setWidth(100);

                                        Label lblPanelCenterPilihKriteria_line7_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_line7_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_line7_spacer1.setPixelSize(65,1);
                                        lblPanelCenterPilihKriteria_line7_spacer2.setPixelSize(20,1);

                                    hpPanelCenterPilihKriteria_line7.add(cbTopNoRBM_KOKED);
                                    hpPanelCenterPilihKriteria_line7.add(lblPanelCenterPilihKriteria_line7_spacer1);
                                    hpPanelCenterPilihKriteria_line7.add(tfTopNoRBM_KOKED);
                                    hpPanelCenterPilihKriteria_line7.add(lblPanelCenterPilihKriteria_line7_spacer2);
                                    hpPanelCenterPilihKriteria_line7.add(lblPanelCenterPilihKriteria_line7_desc);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line7);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line8 = new HorizontalPanel();

                                        CheckBox cbTopKP = new CheckBox();
                                        cbTopKP.setBoxLabel("Kantor Pelayanan");

                                        TextField tfTopKP = new TextField();
                                        Label lblPanelCenterPilihKriteria_line8_desc = new Label("-> (Kode KP = 3 digit pertama Kode Kedudukan)");

                                        tfTopKP.setWidth(100);

                                        Label lblPanelCenterPilihKriteria_line8_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_line8_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_line8_spacer1.setPixelSize(60,1);
                                        lblPanelCenterPilihKriteria_line8_spacer2.setPixelSize(20,1);

                                    hpPanelCenterPilihKriteria_line8.add(cbTopKP);
                                    hpPanelCenterPilihKriteria_line8.add(lblPanelCenterPilihKriteria_line8_spacer1);
                                    hpPanelCenterPilihKriteria_line8.add(tfTopKP);
                                    hpPanelCenterPilihKriteria_line8.add(lblPanelCenterPilihKriteria_line8_spacer2);
                                    hpPanelCenterPilihKriteria_line8.add(lblPanelCenterPilihKriteria_line8_desc);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line8);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line9 = new HorizontalPanel();

                                        CheckBox cbTopPP = new CheckBox();
                                        cbTopPP.setBoxLabel("Petugas Pemutusan");

                                        TextField tfTopPP = new TextField();
                                        Label lblPanelCenterPilihKriteria_line9_desc = new Label("-> (Sebagian / Seluruh)");

                                        tfTopPP.setWidth(100);

                                        Label lblPanelCenterPilihKriteria_line9_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_line9_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_line9_spacer1.setPixelSize(48,1);
                                        lblPanelCenterPilihKriteria_line9_spacer2.setPixelSize(20,1);

                                    hpPanelCenterPilihKriteria_line9.add(cbTopPP);
                                    hpPanelCenterPilihKriteria_line9.add(lblPanelCenterPilihKriteria_line9_spacer1);
                                    hpPanelCenterPilihKriteria_line9.add(tfTopPP);
                                    hpPanelCenterPilihKriteria_line9.add(lblPanelCenterPilihKriteria_line9_spacer2);
                                    hpPanelCenterPilihKriteria_line9.add(lblPanelCenterPilihKriteria_line9_desc);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line9);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line10 = new HorizontalPanel();

                                        CheckBox cbTopNoKontrol = new CheckBox();
                                        cbTopNoKontrol.setBoxLabel("No. Kontrol");

                                        TextField tfTopNoKontrol = new TextField();
                                        Label lblPanelCenterPilihKriteria_line10_desc = new Label("-> (Sebagian / Seluruh)");

                                        tfTopNoKontrol.setWidth(100);

                                        Label lblPanelCenterPilihKriteria_line10_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_line10_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_line10_spacer1.setPixelSize(91,1);
                                        lblPanelCenterPilihKriteria_line10_spacer2.setPixelSize(20,1);

                                    hpPanelCenterPilihKriteria_line10.add(cbTopNoKontrol);
                                    hpPanelCenterPilihKriteria_line10.add(lblPanelCenterPilihKriteria_line10_spacer1);
                                    hpPanelCenterPilihKriteria_line10.add(tfTopNoKontrol);
                                    hpPanelCenterPilihKriteria_line10.add(lblPanelCenterPilihKriteria_line10_spacer2);
                                    hpPanelCenterPilihKriteria_line10.add(lblPanelCenterPilihKriteria_line10_desc);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line10);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line11 = new HorizontalPanel();

                                        CheckBox cbTopKodeInkaso = new CheckBox();
                                        cbTopKodeInkaso.setBoxLabel("Kode Inkaso");

                                        TextField tfTopKodeInkaso = new TextField();
                                        Label lblPanelCenterPilihKriteria_line11_desc = new Label("-> (Sebagian / Seluruh)");

                                        tfTopKodeInkaso.setWidth(100);

                                        Label lblPanelCenterPilihKriteria_line11_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_line11_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_line11_spacer1.setPixelSize(87,1);
                                        lblPanelCenterPilihKriteria_line11_spacer2.setPixelSize(20,1);

                                    hpPanelCenterPilihKriteria_line11.add(cbTopKodeInkaso);
                                    hpPanelCenterPilihKriteria_line11.add(lblPanelCenterPilihKriteria_line11_spacer1);
                                    hpPanelCenterPilihKriteria_line11.add(tfTopKodeInkaso);
                                    hpPanelCenterPilihKriteria_line11.add(lblPanelCenterPilihKriteria_line11_spacer2);
                                    hpPanelCenterPilihKriteria_line11.add(lblPanelCenterPilihKriteria_line11_desc);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line11);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line12 = new HorizontalPanel();

                                        CheckBox cbTopNoGardu = new CheckBox();
                                        cbTopNoGardu.setBoxLabel("Nama Gardu");

                                        TextField tfTopNoGardu = new TextField();
                                        Label lblPanelCenterPilihKriteria_line12_desc = new Label("-> (Sebagian / Seluruh)");

                                        tfTopNoGardu.setWidth(100);

                                        Label lblPanelCenterPilihKriteria_line12_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_line12_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_line12_spacer1.setPixelSize(87,1);
                                        lblPanelCenterPilihKriteria_line12_spacer2.setPixelSize(20,1);

                                    hpPanelCenterPilihKriteria_line12.add(cbTopNoGardu);
                                    hpPanelCenterPilihKriteria_line12.add(lblPanelCenterPilihKriteria_line12_spacer1);
                                    hpPanelCenterPilihKriteria_line12.add(tfTopNoGardu);
                                    hpPanelCenterPilihKriteria_line12.add(lblPanelCenterPilihKriteria_line12_spacer2);
                                    hpPanelCenterPilihKriteria_line12.add(lblPanelCenterPilihKriteria_line12_desc);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line12);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line13 = new HorizontalPanel();

                                        CheckBox cbTopKdpp = new CheckBox();
                                        cbTopKdpp.setBoxLabel("Payment Point");

                                        TextField tfTopKdpp = new TextField();
                                        Label lblPanelCenterPilihKriteria_line13_desc = new Label("-> (Sebagian / Seluruh)");

                                        tfTopKdpp.setWidth(100);

                                        Label lblPanelCenterPilihKriteria_line13_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_line13_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_line13_spacer1.setPixelSize(75,1);
                                        lblPanelCenterPilihKriteria_line13_spacer2.setPixelSize(20,1);

                                    hpPanelCenterPilihKriteria_line13.add(cbTopKdpp);
                                    hpPanelCenterPilihKriteria_line13.add(lblPanelCenterPilihKriteria_line13_spacer1);
                                    hpPanelCenterPilihKriteria_line13.add(tfTopKdpp);
                                    hpPanelCenterPilihKriteria_line13.add(lblPanelCenterPilihKriteria_line13_spacer2);
                                    hpPanelCenterPilihKriteria_line13.add(lblPanelCenterPilihKriteria_line13_desc);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line13);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line14 = new HorizontalPanel();

                                        CheckBox cbTopTarif = new CheckBox();
                                        cbTopTarif.setBoxLabel("Tarif");

                                        TextField tfTopTarif = new TextField();

                                        tfTopTarif.setWidth(100);

                                        Label lblPanelCenterPilihKriteria_line14_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_line14_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_line14_spacer1.setPixelSize(129,1);
                                        lblPanelCenterPilihKriteria_line14_spacer2.setPixelSize(20,1);

                                    hpPanelCenterPilihKriteria_line14.add(cbTopTarif);
                                    hpPanelCenterPilihKriteria_line14.add(lblPanelCenterPilihKriteria_line14_spacer1);
                                    hpPanelCenterPilihKriteria_line14.add(tfTopTarif);
                                    hpPanelCenterPilihKriteria_line14.add(lblPanelCenterPilihKriteria_line14_spacer2);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line14);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line15 = new HorizontalPanel();

                                        CheckBox cbTopGroupKolektif = new CheckBox();
                                        cbTopGroupKolektif.setBoxLabel("Group Kolektif");

                                        ComboKodeKolektif cbTopGroupKolektif_ans = new ComboKodeKolektif();
                                        cbTopGroupKolektif_ans.hideLabel();

                                        Label lblPanelCenterPilihKriteria_line15_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_line15_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_line15_spacer1.setPixelSize(76,1);
                                        lblPanelCenterPilihKriteria_line15_spacer2.setPixelSize(20,1);

                                    hpPanelCenterPilihKriteria_line15.add(cbTopGroupKolektif);
                                    hpPanelCenterPilihKriteria_line15.add(lblPanelCenterPilihKriteria_line15_spacer1);
                                    hpPanelCenterPilihKriteria_line15.add(cbTopGroupKolektif_ans);
                                    hpPanelCenterPilihKriteria_line15.add(lblPanelCenterPilihKriteria_line15_spacer2);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line15);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line16 = new HorizontalPanel();

                                        CheckBox cbTopKodeSiklis = new CheckBox();
                                        cbTopKodeSiklis.setBoxLabel("Kode Siklis");

                                        ComboKodeSiklis cbTopKodeSiklis_ans = new ComboKodeSiklis();
                                        cbTopKodeSiklis_ans.hideLabel();

                                        Label lblPanelCenterPilihKriteria_line16_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_line16_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_line16_spacer1.setPixelSize(95,1);
                                        lblPanelCenterPilihKriteria_line16_spacer2.setPixelSize(20,1);

                                    hpPanelCenterPilihKriteria_line16.add(cbTopKodeSiklis);
                                    hpPanelCenterPilihKriteria_line16.add(lblPanelCenterPilihKriteria_line16_spacer1);
                                    hpPanelCenterPilihKriteria_line16.add(cbTopKodeSiklis_ans);
                                    hpPanelCenterPilihKriteria_line16.add(lblPanelCenterPilihKriteria_line16_spacer2);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line16);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line17 = new HorizontalPanel();

                                        Label lblPanelCenterPilihKriteria_line17_desc = new Label("Petugas Pelaksana :");

                                        ComboNamaPetugas cbTopPetugasPelaksana = new ComboNamaPetugas();
                                        cbTopPetugasPelaksana.hideLabel();

                                        Label lblPanelCenterPilihKriteria_line17_spacer1 = new Label("");
                                        Label lblPanelCenterPilihKriteria_line17_spacer2 = new Label("");

                                        lblPanelCenterPilihKriteria_line17_spacer1.setPixelSize(58,1);
                                        lblPanelCenterPilihKriteria_line17_spacer2.setPixelSize(20,1);

                                    hpPanelCenterPilihKriteria_line17.add(lblPanelCenterPilihKriteria_line17_desc);
                                    hpPanelCenterPilihKriteria_line17.add(lblPanelCenterPilihKriteria_line17_spacer1);
                                    hpPanelCenterPilihKriteria_line17.add(cbTopPetugasPelaksana);
                                    hpPanelCenterPilihKriteria_line17.add(lblPanelCenterPilihKriteria_line17_spacer2);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line17);

                                    HorizontalPanel hpPanelCenterPilihKriteria_line18 = new HorizontalPanel();

                                        TextButton bTopResetKriteria = new TextButton("Reset Kriteria");

                                    hpPanelCenterPilihKriteria_line18.add(bTopResetKriteria);

                                vlcPanelCenterPilihKriteria.add(hpPanelCenterPilihKriteria_line18);

                            panelCenterPilihKriteria.add(vlcPanelCenterPilihKriteria);

                        vlcPCenter.add(panelCenterPilihKriteria);

                                FramedPanel panelCenterKeterangan = new FramedPanel();
                                panelCenterKeterangan.setBodyStyle("background: none; padding: 5px");
                                panelCenterKeterangan.setHeaderVisible(false);
                                panelCenterKeterangan.setWidth(600);
                                panelCenterKeterangan.setHeight(10);

                                    VerticalLayoutContainer vlcPanelCenterKeterangan = new VerticalLayoutContainer();

                                        Label lblVlcPanelCenterKeterangan_line1 = new Label("Catatan :");
                                        Label lblVlcPanelCenterKeterangan_line2 = new Label("1. Kriteria tidak di \"Chek List\" berarti kriteria tersebut diabaikan");
                                        Label lblVlcPanelCenterKeterangan_line3 = new Label("2. Mengisi nilai Awal dan Akhir berarti pencarian di antara nilai Awal dan nilai Akhir");

                                    vlcPanelCenterKeterangan.add(lblVlcPanelCenterKeterangan_line1);
                                    vlcPanelCenterKeterangan.add(lblVlcPanelCenterKeterangan_line2);
                                    vlcPanelCenterKeterangan.add(lblVlcPanelCenterKeterangan_line3);

                                panelCenterKeterangan.add(vlcPanelCenterKeterangan);

                        vlcPCenter.add(panelCenterKeterangan);

                    hlcPCenter.add(vlcPCenter);

                        VerticalLayoutContainer vlcPCenterRight = new VerticalLayoutContainer();

                            FramedPanel panelCenterRight = new FramedPanel();
//                            panelCenterRight.setHeadingText("Pilih Proses");
                            panelCenterRight.setBodyStyle("background: none; padding: 1px");
                            panelCenterRight.setWidth(372);
                            panelCenterRight.setHeight(559);

                                VerticalLayoutContainer vlcPanelCenterRight = new VerticalLayoutContainer();

                                    FramedPanel panelCenterRight_PilihProses = new FramedPanel();
                                    panelCenterRight_PilihProses.setHeadingText("Pilih Proses");
                                    panelCenterRight_PilihProses.setBodyStyle("background: none; padding: 5px");
                                    panelCenterRight_PilihProses.setWidth(357);
                                    panelCenterRight_PilihProses.setHeight(225);

                                        VerticalLayoutContainer vlcPanelCenterRight_PilihProses = new VerticalLayoutContainer();

                                            HorizontalPanel hpVlcPanelCenterRight_PilihProses_Radios1 = new HorizontalPanel();

                                                Radio radioTopPemutusan = new Radio();
                                                radioTopPemutusan.setBoxLabel("Cetak Tul VI-01");
                                                radioTopPemutusan.setValue(true);

                                                Radio radioTopPemutusan_ulang = new Radio();
                                                radioTopPemutusan_ulang.setBoxLabel("Cetak Ulang Tul VI-01");

                                            hpVlcPanelCenterRight_PilihProses_Radios1.add(radioTopPemutusan);
                                            hpVlcPanelCenterRight_PilihProses_Radios1.add(radioTopPemutusan_ulang);

                                        vlcPanelCenterRight_PilihProses.add(hpVlcPanelCenterRight_PilihProses_Radios1);

                                            HorizontalPanel hpVlcPanelCenterRight_PilihProses_Radios2 = new HorizontalPanel();

                                                Radio radioTopPemutusan_lampiran = new Radio();
                                                radioTopPemutusan_lampiran.setBoxLabel("Cetak Lampiran");

                                                Radio radioTopPemutusan_sambung = new Radio();
                                                radioTopPemutusan_sambung.setBoxLabel("Cetak PK Penyambungan");

                                                ToggleGroup tgHpVlcPanelCenterRight_PilihProses_Radios = new ToggleGroup();
                                                tgHpVlcPanelCenterRight_PilihProses_Radios.add(radioTopPemutusan);
                                                tgHpVlcPanelCenterRight_PilihProses_Radios.add(radioTopPemutusan_ulang);
                                                tgHpVlcPanelCenterRight_PilihProses_Radios.add(radioTopPemutusan_lampiran);
                                                tgHpVlcPanelCenterRight_PilihProses_Radios.add(radioTopPemutusan_sambung);

                                            hpVlcPanelCenterRight_PilihProses_Radios2.add(radioTopPemutusan_lampiran);
                                            hpVlcPanelCenterRight_PilihProses_Radios2.add(radioTopPemutusan_sambung);

                                        vlcPanelCenterRight_PilihProses.add(hpVlcPanelCenterRight_PilihProses_Radios2);

                                            TextField tfTopNamaPejabat = new TextField();
                                            tfTopNamaPejabat.setWidth(220);

                                        vlcPanelCenterRight_PilihProses.add(new FieldLabel(tfTopNamaPejabat, "Nama Pejabat"));

                                            TextField tfTopJabatan = new TextField();
                                            tfTopJabatan.setText("MANAGER");
                                            tfTopJabatan.setWidth(220);

                                        vlcPanelCenterRight_PilihProses.add(new FieldLabel(tfTopJabatan, "Jabatan"));

                                            TextField cbTopPilihUrutanPencetakan = new TextField();
                                            cbTopPilihUrutanPencetakan.setWidth(220);

                                        vlcPanelCenterRight_PilihProses.add(new FieldLabel(cbTopPilihUrutanPencetakan, "Pilih Urutan Pencetakan Tul VI"));

                                            HorizontalPanel hpVlcPanelCenterRight_PilihProses_JumlahMaks = new HorizontalPanel();

                                                CheckBox cbTopJumlahMaksPencetakan = new CheckBox();
                                                cbTopJumlahMaksPencetakan.setBoxLabel("Jumlah PK");

                                                NumberField tfTopJumlahMaksPencetakan = new NumberField(new NumberPropertyEditor.IntegerPropertyEditor());
                                                tfTopJumlahMaksPencetakan.setWidth(50);

                                                Label lblHpVlcPanelCenterRight_PilihProses_JumlahMaks = new Label("Lembar");

                                            hpVlcPanelCenterRight_PilihProses_JumlahMaks.add(cbTopJumlahMaksPencetakan);
                                            hpVlcPanelCenterRight_PilihProses_JumlahMaks.add(tfTopJumlahMaksPencetakan);
                                            hpVlcPanelCenterRight_PilihProses_JumlahMaks.add(lblHpVlcPanelCenterRight_PilihProses_JumlahMaks);

                                        vlcPanelCenterRight_PilihProses.add(new FieldLabel(hpVlcPanelCenterRight_PilihProses_JumlahMaks, "Jumlah Maksimal Pencetakan PK"));

                                    panelCenterRight_PilihProses.add(vlcPanelCenterRight_PilihProses);

                                vlcPanelCenterRight.add(panelCenterRight_PilihProses);

                                    FramedPanel panelCenterMiddle = new FramedPanel();
                                    panelCenterMiddle.setBodyStyle("background: none; padding: 1px");
                                    panelCenterMiddle.setWidth(357);
                                    panelCenterMiddle.setHeight(120);

                                        HorizontalLayoutContainer hlcPanelCenterMiddle = new HorizontalLayoutContainer();

                                            FramedPanel panelCenterMiddle_Left = new FramedPanel();
                                            panelCenterMiddle_Left.setHeadingText("Pilih Jenis Kertas");
                                            panelCenterMiddle_Left.setBodyStyle("background: none; padding: 5px");
                                            panelCenterMiddle_Left.setWidth(155);
                                            panelCenterMiddle_Left.setHeight(82);

                                                HorizontalPanel hpPanelCenterMiddle_Left = new HorizontalPanel();

                                                    Radio radioTopJenisKertasKosong = new Radio();
                                                    radioTopJenisKertasKosong.setBoxLabel("Kosong");
                                                    radioTopJenisKertasKosong.setValue(true);

                                                    Radio radioTopJenisKertasBlanko = new Radio();
                                                    radioTopJenisKertasBlanko.setBoxLabel("Blangko");

                                                    ToggleGroup tgHpPanelCenterMiddle_Left = new ToggleGroup();
                                                    tgHpPanelCenterMiddle_Left.add(radioTopJenisKertasKosong);
                                                    tgHpPanelCenterMiddle_Left.add(radioTopJenisKertasBlanko);

                                                hpPanelCenterMiddle_Left.add(radioTopJenisKertasKosong);
                                                hpPanelCenterMiddle_Left.add(radioTopJenisKertasBlanko);

                                            panelCenterMiddle_Left.add(hpPanelCenterMiddle_Left);

                                        hlcPanelCenterMiddle.add(panelCenterMiddle_Left);

                                            FramedPanel panelCenterMiddle_Right = new FramedPanel();
                                            panelCenterMiddle_Right.setHeadingText("Cek Tiap");
                                            panelCenterMiddle_Right.setBodyStyle("background: none; padding: 5px");
                                            panelCenterMiddle_Right.setWidth(155);
                                            panelCenterMiddle_Right.setHeight(82);

                                                VerticalLayoutContainer vlcPanelCenterMiddle_Right = new VerticalLayoutContainer();

                                                    HorizontalPanel hpPanelCenterMiddle_Right = new HorizontalPanel();

                                                        NumberField tfTopCekTiap = new NumberField(new NumberPropertyEditor.IntegerPropertyEditor());
                                                        tfTopCekTiap.setWidth(50);
                                                        tfTopCekTiap.setValue(10);

                                                        Label lblHpPanelCenterMiddle_Right = new Label("Lb");

                                                    hpPanelCenterMiddle_Right.add(tfTopCekTiap);
                                                    hpPanelCenterMiddle_Right.add(lblHpPanelCenterMiddle_Right);

                                                vlcPanelCenterMiddle_Right.add(hpPanelCenterMiddle_Right);

                                                    CheckBox cbTopPreview = new CheckBox();
                                                    cbTopPreview.setBoxLabel("Preview Pencetakan?");

                                                vlcPanelCenterMiddle_Right.add(cbTopPreview);

                                            panelCenterMiddle_Right.add(vlcPanelCenterMiddle_Right);

                                        hlcPanelCenterMiddle.add(panelCenterMiddle_Right);

                                    panelCenterMiddle.add(hlcPanelCenterMiddle);

                                vlcPanelCenterRight.add(panelCenterMiddle);

                                    FramedPanel panelCenterBottom = new FramedPanel();
                                    panelCenterBottom.setBodyStyle("background: none; padding: 5px");
                                    panelCenterBottom.setWidth(357);
                                    panelCenterBottom.setHeight(185);

                                        VerticalLayoutContainer vlcPanelCenterBottom = new VerticalLayoutContainer();

                                            HorizontalPanel hpVlcPanelCenterBottom1 = new HorizontalPanel();

                                                CheckBox cbTopDftIncludeSudahDicetak = new CheckBox();
                                                cbTopDftIncludeSudahDicetak.setBoxLabel("Dft Include Sudah Dicetak");

                                            hpVlcPanelCenterBottom1.add(cbTopDftIncludeSudahDicetak);

                                        vlcPanelCenterBottom.add(hpVlcPanelCenterBottom1);

                                            HorizontalPanel hpVlcPanelCenterBottom2 = new HorizontalPanel();

                                                TextButton bTopTampilkan = new TextButton("Tampilkan Daftar");
                                                TextButton bTopCetakPKTulVI = new TextButton("Cetak PK Tul VI");

                                            hpVlcPanelCenterBottom2.add(bTopTampilkan);
                                            hpVlcPanelCenterBottom2.add(bTopCetakPKTulVI);

                                        vlcPanelCenterBottom.add(hpVlcPanelCenterBottom2);

                                            HorizontalPanel hpVlcPanelCenterBottom3 = new HorizontalPanel();

                                                CheckBox cbTopLampiran603 = new CheckBox();
                                                cbTopLampiran603.setBoxLabel("Lampiran VI-03");

                                                CheckBox cbTopBABongkar = new CheckBox();
                                                cbTopBABongkar.setBoxLabel("BA Bongkar");

                                            hpVlcPanelCenterBottom3.add(cbTopLampiran603);
                                            hpVlcPanelCenterBottom3.add(cbTopBABongkar);

                                        vlcPanelCenterBottom.add(hpVlcPanelCenterBottom3);

                                            HorizontalPanel hpVlcPanelCenterBottom4 = new HorizontalPanel();

                                                Label lblHpVlcPanelCenterBottom4 = new Label("Progres Pencetakan:");

                                                Label lblHpVlcPanelCenterBottom4_Spacer1 = new Label("");
                                                lblHpVlcPanelCenterBottom4_Spacer1.setPixelSize(10,1);

                                                NumberField tfTopProgresPencetakan = new NumberField(new NumberPropertyEditor.IntegerPropertyEditor());
                                                tfTopProgresPencetakan.setWidth(80);

                                            hpVlcPanelCenterBottom4.add(lblHpVlcPanelCenterBottom4);
                                            hpVlcPanelCenterBottom4.add(lblHpVlcPanelCenterBottom4_Spacer1);
                                            hpVlcPanelCenterBottom4.add(tfTopProgresPencetakan);

                                        vlcPanelCenterBottom.add(hpVlcPanelCenterBottom4);

                                            HorizontalPanel hpVlcPanelCenterBottom5 = new HorizontalPanel();

                                                Label lblHpVlcPanelCenterBottom5 = new Label("Dari:");

                                                Label lblHpVlcPanelCenterBottom5_Spacer1 = new Label("");
                                                lblHpVlcPanelCenterBottom5_Spacer1.setPixelSize(105,1);

                                                NumberField tfTopProgresPencetakanDari = new NumberField(new NumberPropertyEditor.IntegerPropertyEditor());
                                                tfTopProgresPencetakanDari.setWidth(80);

                                            hpVlcPanelCenterBottom5.add(lblHpVlcPanelCenterBottom5);
                                            hpVlcPanelCenterBottom5.add(lblHpVlcPanelCenterBottom5_Spacer1);
                                            hpVlcPanelCenterBottom5.add(tfTopProgresPencetakanDari);

                                        vlcPanelCenterBottom.add(hpVlcPanelCenterBottom5);

                                            HorizontalPanel hpVlcPanelCenterBottom6 = new HorizontalPanel();

                                                Label lBottomStatus = new Label("Status:");

                                            hpVlcPanelCenterBottom6.add(lBottomStatus);

                                        vlcPanelCenterBottom.add(hpVlcPanelCenterBottom6);

                                    panelCenterBottom.add(vlcPanelCenterBottom);

                                vlcPanelCenterRight.add(panelCenterBottom);

                            panelCenterRight.add(vlcPanelCenterRight);

                        vlcPCenterRight.add(panelCenterRight);

                    hlcPCenter.add(vlcPCenterRight);

                panelCenter.add(hlcPCenter);

            p.add(panelCenter);

        panel.add(p);

        return panel;
    }
}
