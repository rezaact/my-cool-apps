package id.co.hans.sample.client.form.TulVI;

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

public class Form_TulVI_DistribusiPK {


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
        panel.setHeadingText("Distribusi PK Tul VI");
        panel.setBodyStyle("background: none; padding: 0px");
        panel.setWidth(800);

            VerticalLayoutContainer p = new VerticalLayoutContainer();
            panel.add(p);

                FramedPanel panelNorth = new FramedPanel();
                panelNorth.setBodyStyle("background: none; padding: 0px");
                panelNorth.setHeaderVisible(true);
                panelNorth.setWidth(788);
                panelNorth.setHeight(230);

                    HorizontalLayoutContainer hlcPNorth = new HorizontalLayoutContainer();

                        FramedPanel panelNorthPutusBongkar = new FramedPanel();
                        panelNorthPutusBongkar.setBodyStyle("background: none; padding: 2px");
                        panelNorthPutusBongkar.setHeadingText("Putus / Bongkar");
                        panelNorthPutusBongkar.setHeaderVisible(true);
                        panelNorthPutusBongkar.setWidth(150);
                        panelNorthPutusBongkar.setHeight(190);

                            VerticalLayoutContainer vlcPNorthPutusBongkar = new VerticalLayoutContainer();

                                Label lblTopSuratPemutusanPembongkaran = new Label("Pilih Jenis Surat :");

                                Radio radioTopSuratPemutusan = new Radio();
                                radioTopSuratPemutusan.setBoxLabel("Surat Pemutusan");
                                radioTopSuratPemutusan.setValue(true);

                                Radio radioTopSuratPembongkaran = new Radio();
                                radioTopSuratPembongkaran.setBoxLabel("Surat Pembongkaran");

                                ToggleGroup tgRadioTopSuratPemutusanPembongkaran = new ToggleGroup();
                                tgRadioTopSuratPemutusanPembongkaran.add(radioTopSuratPemutusan);
                                tgRadioTopSuratPemutusanPembongkaran.add(radioTopSuratPembongkaran);

                            vlcPNorthPutusBongkar.add(lblTopSuratPemutusanPembongkaran);
                            vlcPNorthPutusBongkar.add(radioTopSuratPemutusan);
                            vlcPNorthPutusBongkar.add(radioTopSuratPembongkaran);

                        panelNorthPutusBongkar.add(vlcPNorthPutusBongkar);

                    hlcPNorth.add(panelNorthPutusBongkar);

                        FramedPanel panelNorthKriteria = new FramedPanel();
                        panelNorthKriteria.setBodyStyle("background: none; padding: 2px");
                        panelNorthKriteria.setHeadingText("Kriteria");
                        panelNorthKriteria.setHeaderVisible(true);
                        panelNorthKriteria.setWidth(440);
                        panelNorthKriteria.setHeight(190);

                            HorizontalLayoutContainer hlcPNorthKriteria = new HorizontalLayoutContainer();

                                FramedPanel panelNorthKriteriaNoSuratNoKontrol = new FramedPanel();
                                panelNorthKriteriaNoSuratNoKontrol.setBodyStyle("background: none; padding: 2px");
                                panelNorthKriteriaNoSuratNoKontrol.setHeaderVisible(false);
                                panelNorthKriteriaNoSuratNoKontrol.setWidth(100);
                                panelNorthKriteriaNoSuratNoKontrol.setHeight(150);

                                    VerticalLayoutContainer vlcPanelNorthKriteriaNoSuratNoKontrol = new VerticalLayoutContainer();

                                        Label lblTopSuratNoSuratNoKontrol_desc = new Label("");

                                        Radio radioTopNoSurat = new Radio();
                                        radioTopNoSurat.setBoxLabel("No Surat :");
                                        radioTopNoSurat.setValue(true);

                                        Radio radioTopNoKontrol = new Radio();
                                        radioTopNoKontrol.setBoxLabel("No Kontrol :");

                                        ToggleGroup tgRadioTopSuratNoSuratNoKontrol = new ToggleGroup();
                                        tgRadioTopSuratPemutusanPembongkaran.add(radioTopNoSurat);
                                        tgRadioTopSuratPemutusanPembongkaran.add(radioTopNoKontrol);

                                    vlcPanelNorthKriteriaNoSuratNoKontrol.add(lblTopSuratNoSuratNoKontrol_desc);
                                    vlcPanelNorthKriteriaNoSuratNoKontrol.add(radioTopNoSurat);
                                    vlcPanelNorthKriteriaNoSuratNoKontrol.add(radioTopNoKontrol);

                                panelNorthKriteriaNoSuratNoKontrol.add(vlcPanelNorthKriteriaNoSuratNoKontrol);

                            hlcPNorthKriteria.add(panelNorthKriteriaNoSuratNoKontrol);

                                FramedPanel panelNorthKriteriaTglPkNoTul = new FramedPanel();
                                panelNorthKriteriaTglPkNoTul.setBodyStyle("background: none; padding: 2px");
                                panelNorthKriteriaTglPkNoTul.setHeaderVisible(false);
                                panelNorthKriteriaTglPkNoTul.setWidth(320);
                                panelNorthKriteriaTglPkNoTul.setHeight(150);

                                    VerticalLayoutContainer vlcPanelNorthKriteriaTglPkNoTul = new VerticalLayoutContainer();

                                        HorizontalPanel hpPanelNorthKriteriaTglPkNoTul = new HorizontalPanel();

                                            Label lblTopSuratTglPkNoTul_descAwal = new Label("Tgl PK :");
                                            lblTopSuratTglPkNoTul_descAwal.setPixelSize(60,1);

                                            DateField dfTopTglPK = new DateField();
                                            dfTopTglPK.setWidth(100);

                                            Label lblTopSuratTglPkNoTul_descMid = new Label("");
                                            lblTopSuratTglPkNoTul_descMid.setPixelSize(10,1);

                                            Label lblTopSuratTglPkNoTul_descMid2 = new Label("Nomor Tul :");
                                            lblTopSuratTglPkNoTul_descMid2.setPixelSize(80,1);

                                            TextField tfTopNomorTul = new TextField();
                                            tfTopNomorTul.setWidth(50);

                                        hpPanelNorthKriteriaTglPkNoTul.add(lblTopSuratTglPkNoTul_descAwal);
                                        hpPanelNorthKriteriaTglPkNoTul.add(dfTopTglPK);
                                        hpPanelNorthKriteriaTglPkNoTul.add(lblTopSuratTglPkNoTul_descMid);
                                        hpPanelNorthKriteriaTglPkNoTul.add(lblTopSuratTglPkNoTul_descMid2);
                                        hpPanelNorthKriteriaTglPkNoTul.add(tfTopNomorTul);

                                    vlcPanelNorthKriteriaTglPkNoTul.add(hpPanelNorthKriteriaTglPkNoTul);

                                        HorizontalPanel hpPanelNorthKriteriaNoKontrol = new HorizontalPanel();

                                            TextField tfTopNoKontrol_Awal = new TextField();
                                            tfTopNoKontrol_Awal.setWidth(30);

                                            Label lblTopSuratNoKontrol_descMid1 = new Label("");
                                            lblTopSuratNoKontrol_descMid1.setPixelSize(8,1);

                                            Label lblTopSuratNoKontrol_descMid2 = new Label("-");
                                            lblTopSuratNoKontrol_descMid2.setPixelSize(10,1);

                                            TextField tfTopNoKontrol_Akhir = new TextField();
                                            tfTopNoKontrol_Akhir.setWidth(50);

                                            Label lblTopSuratNoKontrol_descMid3 = new Label("");
                                            lblTopSuratNoKontrol_descMid3.setPixelSize(10,1);

                                            Label lblTopSuratNoKontrol_descMid4 = new Label("Tgl Cetak :");
                                            lblTopSuratNoKontrol_descMid4.setPixelSize(80,1);

                                            DateField dfTopTglCetak = new DateField();
                                            dfTopTglCetak.setWidth(100);

                                        hpPanelNorthKriteriaNoKontrol.add(tfTopNoKontrol_Awal);
                                        hpPanelNorthKriteriaNoKontrol.add(lblTopSuratNoKontrol_descMid1);
                                        hpPanelNorthKriteriaNoKontrol.add(lblTopSuratNoKontrol_descMid2);
                                        hpPanelNorthKriteriaNoKontrol.add(tfTopNoKontrol_Akhir);
                                        hpPanelNorthKriteriaNoKontrol.add(lblTopSuratNoKontrol_descMid3);
                                        hpPanelNorthKriteriaNoKontrol.add(lblTopSuratNoKontrol_descMid4);
                                        hpPanelNorthKriteriaNoKontrol.add(dfTopTglCetak);

                                    vlcPanelNorthKriteriaTglPkNoTul.add(hpPanelNorthKriteriaNoKontrol);

                                panelNorthKriteriaTglPkNoTul.add(vlcPanelNorthKriteriaTglPkNoTul);

                            hlcPNorthKriteria.add(panelNorthKriteriaTglPkNoTul);

                        panelNorthKriteria.add(hlcPNorthKriteria);

                    hlcPNorth.add(panelNorthKriteria);

                        FramedPanel panelNorthButtonCari = new FramedPanel();
                        panelNorthButtonCari.setBodyStyle("background: none; padding: 2px");
                        panelNorthButtonCari.setHeaderVisible(true);
                        panelNorthButtonCari.setWidth(50);
                        panelNorthButtonCari.setHeight(190);

                            VerticalLayoutContainer vlcPNorthButtonCari = new VerticalLayoutContainer();

                                TextButton bTopCari = new TextButton("Cari");

                            vlcPNorthButtonCari.add(bTopCari);

                        panelNorthButtonCari.add(vlcPNorthButtonCari);

                    hlcPNorth.add(panelNorthButtonCari);

                        FramedPanel panelNorthNotes = new FramedPanel();
                        panelNorthNotes.setBodyStyle("background: none; padding: 2px");
                        panelNorthNotes.setHeaderVisible(true);
                        panelNorthNotes.setWidth(130);
                        panelNorthNotes.setHeight(190);

                            VerticalLayoutContainer vlcPNorthNotes = new VerticalLayoutContainer();

                                Label lblPNorthNotesLine1 = new Label("NB :");
                                Label lblPNorthNotesLine2 = new Label("Kosongkan No Kontrol pada Kriteria untuk menampilkan semua data surat VI-01/VI-03 per tanggal cetak.");

                            vlcPNorthNotes.add(lblPNorthNotesLine1);
                            vlcPNorthNotes.add(lblPNorthNotesLine2);

                        panelNorthNotes.add(vlcPNorthNotes);

                    hlcPNorth.add(panelNorthNotes);

                panelNorth.add(hlcPNorth);

            p.add(panelNorth);

                IconDynamicGrid gpDataPelanggan = new IconDynamicGrid();
                gpDataPelanggan.setGridDimension(788, 300);
                gpDataPelanggan.setGridHeader("Pemutusan");
                gpDataPelanggan.setStoreUrl("/test.json");

                gpDataPelanggan.addColumn("NO_TUL",100);
                gpDataPelanggan.addColumn("NO_PELANGGAN",100);
                gpDataPelanggan.addColumn("NAMA_PELANGGAN",100);
                gpDataPelanggan.addColumn("LBR",100);
                gpDataPelanggan.addColumn("TAGIHAN",100);
                gpDataPelanggan.addColumn("CETAK",100);
                gpDataPelanggan.addColumn("PERINTAH_KERJA",100);
                gpDataPelanggan.addColumn("EKSEKUSI",100);
                gpDataPelanggan.addColumn("PELAKSANA",100);
                gpDataPelanggan.addColumn("STATUS",100);
                gpDataPelanggan.addColumn("CEK",100);

            p.add(gpDataPelanggan);


                FramedPanel panelSouth = new FramedPanel();
                panelSouth.setBodyStyle("background: none; padding: 0px");
                panelSouth.setHeaderVisible(true);
                panelSouth.setWidth(788);
                panelSouth.setHeight(140);

                    HorizontalLayoutContainer hlcPSouth = new HorizontalLayoutContainer();

                        FramedPanel panelSouthPetugasPelaksana = new FramedPanel();
                        panelSouthPetugasPelaksana.setBodyStyle("background: none; padding: 2px");
                        panelSouthPetugasPelaksana.setHeadingText("Petugas Pelaksana");
                        panelSouthPetugasPelaksana.setHeaderVisible(true);
                        panelSouthPetugasPelaksana.setWidth(230);
                        panelSouthPetugasPelaksana.setHeight(100);

                            VerticalLayoutContainer vlcPSouthPetugasPelaksana = new VerticalLayoutContainer();

                                ComboNamaPetugas cbBottomPetugasPelaksana = new ComboNamaPetugas();

                                TextButton bBottomSimpan = new TextButton("Simpan");

                            vlcPSouthPetugasPelaksana.add(cbBottomPetugasPelaksana);
                            vlcPSouthPetugasPelaksana.add(bBottomSimpan);

                        panelSouthPetugasPelaksana.add(vlcPSouthPetugasPelaksana);

                    hlcPSouth.add(panelSouthPetugasPelaksana);

                        FramedPanel panelSouthDicetakDiserahkan = new FramedPanel();
                        panelSouthDicetakDiserahkan.setBodyStyle("background: none; padding: 2px");
                        panelSouthDicetakDiserahkan.setHeaderVisible(true);
                        panelSouthDicetakDiserahkan.setWidth(230);
                        panelSouthDicetakDiserahkan.setHeight(100);

                            VerticalLayoutContainer vlcPSouthDicetakDiserahkan = new VerticalLayoutContainer();

                                Label lBottomDicetak = new Label();

                                Label lBottomDiserahkan = new Label();

                            vlcPSouthDicetakDiserahkan.add(new FieldLabel(lBottomDicetak, "Dicetak"));
                            vlcPSouthDicetakDiserahkan.add(new FieldLabel(lBottomDiserahkan, "Diserahkan"));

                        panelSouthDicetakDiserahkan.add(vlcPSouthDicetakDiserahkan);

                    hlcPSouth.add(panelSouthDicetakDiserahkan);

                        FramedPanel panelSouthDieksekusi = new FramedPanel();
                        panelSouthDieksekusi.setBodyStyle("background: none; padding: 2px");
                        panelSouthDieksekusi.setHeaderVisible(true);
                        panelSouthDieksekusi.setWidth(230);
                        panelSouthDieksekusi.setHeight(100);

                            VerticalLayoutContainer vlcPSouthDieksekusi = new VerticalLayoutContainer();

                                    HorizontalPanel hpVlcPSouthDieksekusi = new HorizontalPanel();

                                    Label lBottomDieksekusi = new Label();
                                    Label lBottomCek = new Label();

                                hpVlcPSouthDieksekusi.add(lBottomDieksekusi);
                                hpVlcPSouthDieksekusi.add(lBottomCek);

                            vlcPSouthDieksekusi.add(new FieldLabel(hpVlcPSouthDieksekusi, "Dieksekusi"));

                        panelSouthDieksekusi.add(vlcPSouthDieksekusi);

                    hlcPSouth.add(panelSouthDieksekusi);

                panelSouth.add(hlcPSouth);

            p.add(panelSouth);



        return panel;
    }
}
