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

public class Form_TulVI_CetakUlang {


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
        panel.setHeadingText("Cetak Penyambungan Dan Lampiran");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(750);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

            FramedPanel panelReferensi = new FramedPanel();
            panelReferensi.setBodyStyle("background: none; padding: 5px");
            panelReferensi.setHeaderVisible(false);
            panelReferensi.setWidth(720);

            VerticalLayoutContainer vlcPReferensi = new VerticalLayoutContainer();
            panelReferensi.add(vlcPReferensi);

            ComboUnit cbUnit = new ComboUnit();
            vlcPReferensi.add(cbUnit);

        p.add(panelReferensi);

            HorizontalLayoutContainer hlcPanel3 = new HorizontalLayoutContainer();
            hlcPanel3.setWidth(320);
            hlcPanel3.setHeight(530);

                FramedPanel panel3PilihProses = new FramedPanel();
                panel3PilihProses.setHeadingText("Pilih Proses");
                panel3PilihProses.setBodyStyle("background: none; padding: 5px");
                panel3PilihProses.setWidth(300);
                panel3PilihProses.setHeight(330);

                hlcPanel3.add(panel3PilihProses);

                    VerticalLayoutContainer vlcPanel3 = new VerticalLayoutContainer();
                    panel3PilihProses.add(vlcPanel3);

                        Radio radioTopPemutusan = new Radio();
                        Radio radioTopPembongkaran = new Radio();
                        Radio radioTopPemutusanLampiran = new Radio();
                        Radio radioTopPembongkaranLampiran = new Radio();

                        radioTopPemutusan.setBoxLabel("Cetak Tul VI-01 (Pemutusan)");
                        radioTopPembongkaran.setBoxLabel("Cetak Tul VI-03 (Pembongkaran)");
                        radioTopPemutusanLampiran.setBoxLabel("Cetak Lampiran Tul VI-01");
                        radioTopPembongkaranLampiran.setBoxLabel("Cetak Lampiran Tul VI-03 (I-09)");

                        radioTopPemutusan.setValue(true);

                        ToggleGroup tgPanel3Radio = new ToggleGroup();
                        tgPanel3Radio.add(radioTopPemutusan);
                        tgPanel3Radio.add(radioTopPembongkaran);
                        tgPanel3Radio.add(radioTopPemutusanLampiran);
                        tgPanel3Radio.add(radioTopPembongkaranLampiran);

                        vlcPanel3.add(radioTopPemutusan);
                        vlcPanel3.add(radioTopPembongkaran);
                        vlcPanel3.add(radioTopPemutusanLampiran);
                        vlcPanel3.add(radioTopPembongkaranLampiran);

                        //== nama pejabat
                        TextField tfTopNamaPejabat = new TextField();
                        vlcPanel3.add(new FieldLabel(tfTopNamaPejabat, "Nama Pejabat"));

                        //== pejabat ttd
                        TextField tfTopJabatan = new TextField();
                        tfTopJabatan.setText("MANAGER");
                        vlcPanel3.add(new FieldLabel(tfTopJabatan, "Jabatan Penanda Tangan"));

                        //== petugas
                        ComboNamaPetugas cbTopNamaPetugas = new ComboNamaPetugas();
                        vlcPanel3.add(cbTopNamaPetugas);


                        // column layout
                        HorizontalLayoutContainer hlcPanel3JenisKertasCekTiap = new HorizontalLayoutContainer();
                        hlcPanel3JenisKertasCekTiap.setWidth(300);

                            FramedPanel panel3JenisKertas = new FramedPanel();
                            panel3JenisKertas.setHeadingText("Pilih Jenis Kertas");
                            panel3JenisKertas.setWidth(150);

                            hlcPanel3JenisKertasCekTiap.add(panel3JenisKertas);

                                VerticalPanel vpPanel3JenisKertas = new VerticalPanel();
                                panel3JenisKertas.add(vpPanel3JenisKertas);

                                Radio radioTopJenisKertasKosong = new Radio();
                                Radio radioTopJenisKertasBlankoII = new Radio();

                                radioTopJenisKertasKosong.setBoxLabel("Kosong");
                                radioTopJenisKertasBlankoII.setBoxLabel("Blanko II");

                                radioTopJenisKertasKosong.setValue(true);

                                ToggleGroup tgPanel3JenisKertas = new ToggleGroup();
                                tgPanel3JenisKertas.add(radioTopJenisKertasKosong);
                                tgPanel3JenisKertas.add(radioTopJenisKertasBlankoII);

                                vpPanel3JenisKertas.add(radioTopJenisKertasKosong);
                                vpPanel3JenisKertas.add(radioTopJenisKertasBlankoII);

                            FramedPanel panel3CekTiap = new FramedPanel();
                            panel3CekTiap.setHeadingText("Cek Tiap");
                            panel3CekTiap.setWidth(120);

                            hlcPanel3JenisKertasCekTiap.add(panel3CekTiap);

                                VerticalPanel vpPanel3CekTiap = new VerticalPanel();
                                panel3CekTiap.add(vpPanel3CekTiap);

                                    HorizontalPanel hpPanel3CekTiap = new HorizontalPanel();

                                    NumberField<Integer> tfTopCekTiap = new NumberField<Integer>(new NumberPropertyEditor.IntegerPropertyEditor());
                                    tfTopCekTiap.setWidth(50);
                                    tfTopCekTiap.setText("10");

                                    Label lblCekTiap = new Label();
                                    lblCekTiap.setText("Lb");

                                    hpPanel3CekTiap.add(tfTopCekTiap);
                                    hpPanel3CekTiap.add(lblCekTiap);

                                vpPanel3CekTiap.add(hpPanel3CekTiap);


                FramedPanel panel3PilihKriteria = new FramedPanel();
                panel3PilihKriteria.setHeadingText("Pilih Kriteria");
                panel3PilihKriteria.setWidth(420);
                panel3PilihKriteria.setHeight(530);

                hlcPanel3.add(panel3PilihKriteria);

                    VerticalLayoutContainer vlcPanel3PilihKriteria = new VerticalLayoutContainer();
                    vlcPanel3PilihKriteria.setWidth(420);

                        FramedPanel panel3PilihKriteria_KriteriaPencetakan = new FramedPanel();
                        panel3PilihKriteria_KriteriaPencetakan.setHeaderVisible(false);
                        panel3PilihKriteria_KriteriaPencetakan.setWidth(400);

                        vlcPanel3PilihKriteria.add(panel3PilihKriteria_KriteriaPencetakan);

                            VerticalLayoutContainer vlcPanel3PilihKriteria_KriteriaPencetakan = new VerticalLayoutContainer();
                            panel3PilihKriteria_KriteriaPencetakan.add(vlcPanel3PilihKriteria_KriteriaPencetakan);

                                HorizontalPanel hpPanel3PilihKriteria_KetAwalAkhir = new HorizontalPanel();

                                    Label lblPanel3PilihKriteria_KetAwalAkhir_AwalDummy = new Label("");
                                    lblPanel3PilihKriteria_KetAwalAkhir_AwalDummy.setPixelSize(180, 1);

                                    Label lblPanel3PilihKriteria_KetAwalAkhir_Awal = new Label("Awal");

                                    Label lblPanel3PilihKriteria_KetAwalAkhir_AkhirDummy = new Label("");
                                    lblPanel3PilihKriteria_KetAwalAkhir_Awal.setPixelSize(120, 1);

                                    Label lblPanel3PilihKriteria_KetAwalAkhir_Akhir = new Label("Akhir");
                                    lblPanel3PilihKriteria_KetAwalAkhir_Akhir.setWidth("100");

                                hpPanel3PilihKriteria_KetAwalAkhir.add(lblPanel3PilihKriteria_KetAwalAkhir_AwalDummy);
                                hpPanel3PilihKriteria_KetAwalAkhir.add(lblPanel3PilihKriteria_KetAwalAkhir_Awal);
                                hpPanel3PilihKriteria_KetAwalAkhir.add(lblPanel3PilihKriteria_KetAwalAkhir_AkhirDummy);
                                hpPanel3PilihKriteria_KetAwalAkhir.add(lblPanel3PilihKriteria_KetAwalAkhir_Akhir);

                            vlcPanel3PilihKriteria_KriteriaPencetakan.add(hpPanel3PilihKriteria_KetAwalAkhir);

                                HorizontalPanel hpPanel3PilihKriteria_NoPelanggan = new HorizontalPanel();

                                    CheckBox cbKriteriaNoPelanggan = new CheckBox();
                                    cbKriteriaNoPelanggan.setBoxLabel("No Pelanggan");

                                    Label lblPanel3PilihKriteria_NoPelanggan_AwalDummy = new Label("");
                                    lblPanel3PilihKriteria_NoPelanggan_AwalDummy.setPixelSize(35, 1);

                                    TextField tfKriteriaNoPelangganAwal = new TextField();
                                    tfKriteriaNoPelangganAwal.setWidth(100);

                                    Label lblPanel3PilihKriteria_NoPelanggan_AkhirDummy = new Label("");
                                    lblPanel3PilihKriteria_NoPelanggan_AkhirDummy.setPixelSize(10, 1);

                                    TextField tfKriteriaNoPelangganAkhir = new TextField();
                                    tfKriteriaNoPelangganAkhir.setWidth(100);

                                hpPanel3PilihKriteria_NoPelanggan.add(cbKriteriaNoPelanggan);
                                hpPanel3PilihKriteria_NoPelanggan.add(lblPanel3PilihKriteria_NoPelanggan_AwalDummy);
                                hpPanel3PilihKriteria_NoPelanggan.add(tfKriteriaNoPelangganAwal);
                                hpPanel3PilihKriteria_NoPelanggan.add(lblPanel3PilihKriteria_NoPelanggan_AkhirDummy);
                                hpPanel3PilihKriteria_NoPelanggan.add(tfKriteriaNoPelangganAkhir);

                            vlcPanel3PilihKriteria_KriteriaPencetakan.add(hpPanel3PilihKriteria_NoPelanggan);

                                HorizontalPanel hpPanel3PilihKriteria_JmlLembar = new HorizontalPanel();

                                    CheckBox cbKriteriaJumlahLembar = new CheckBox();
                                    cbKriteriaJumlahLembar.setBoxLabel("Jumlah Lembar");

                                    Label lblPanel3PilihKriteria_JumlahLembar_AwalDummy = new Label("");
                                    lblPanel3PilihKriteria_JumlahLembar_AwalDummy.setPixelSize(29, 1);

                                    TextField tfKriteriaJumlahLembarAwal = new TextField();
                                    tfKriteriaJumlahLembarAwal.setWidth(100);

                                    Label lblPanel3PilihKriteria_JumlahLembar_AkhirDummy = new Label("");
                                    lblPanel3PilihKriteria_JumlahLembar_AkhirDummy.setPixelSize(10, 1);

                                    TextField tfKriteriaJumlahLembarAkhir = new TextField();
                                    tfKriteriaJumlahLembarAkhir.setWidth(100);

                                hpPanel3PilihKriteria_JmlLembar.add(cbKriteriaJumlahLembar);
                                hpPanel3PilihKriteria_JmlLembar.add(lblPanel3PilihKriteria_JumlahLembar_AwalDummy);
                                hpPanel3PilihKriteria_JmlLembar.add(tfKriteriaJumlahLembarAwal);
                                hpPanel3PilihKriteria_JmlLembar.add(lblPanel3PilihKriteria_JumlahLembar_AkhirDummy);
                                hpPanel3PilihKriteria_JmlLembar.add(tfKriteriaJumlahLembarAkhir);

                            vlcPanel3PilihKriteria_KriteriaPencetakan.add(hpPanel3PilihKriteria_JmlLembar);

                                HorizontalPanel hpPanel3PilihKriteria_RupiahTagih = new HorizontalPanel();

                                    CheckBox cbKriteriaRupiahTagih = new CheckBox();
                                    cbKriteriaRupiahTagih.setBoxLabel("Rupiah Tagih");

                                    Label lblPanel3PilihKriteria_RupiahTagih_AwalDummy = new Label("");
                                    lblPanel3PilihKriteria_RupiahTagih_AwalDummy.setPixelSize(39, 1);

                                    NumberField tfKriteriaRupiahTagihAwal = new NumberField(new NumberPropertyEditor.IntegerPropertyEditor());
                                    tfKriteriaRupiahTagihAwal.setWidth(100);

                                    Label lblPanel3PilihKriteria_RupiahTagih_AkhirDummy = new Label("");
                                    lblPanel3PilihKriteria_RupiahTagih_AkhirDummy.setPixelSize(10, 1);

                                    NumberField tfKriteriaRupiahTagihAkhir = new NumberField(new NumberPropertyEditor.IntegerPropertyEditor());
                                    tfKriteriaRupiahTagihAkhir.setWidth(100);

                                hpPanel3PilihKriteria_RupiahTagih.add(cbKriteriaRupiahTagih);
                                hpPanel3PilihKriteria_RupiahTagih.add(lblPanel3PilihKriteria_RupiahTagih_AwalDummy);
                                hpPanel3PilihKriteria_RupiahTagih.add(tfKriteriaRupiahTagihAwal);
                                hpPanel3PilihKriteria_RupiahTagih.add(lblPanel3PilihKriteria_RupiahTagih_AkhirDummy);
                                hpPanel3PilihKriteria_RupiahTagih.add(tfKriteriaRupiahTagihAkhir);

                            vlcPanel3PilihKriteria_KriteriaPencetakan.add(hpPanel3PilihKriteria_RupiahTagih);

                                HorizontalPanel hpPanel3PilihKriteria_BesarDaya = new HorizontalPanel();

                                    CheckBox cbKriteriaBesarDaya = new CheckBox();
                                    cbKriteriaBesarDaya.setBoxLabel("Besar Daya");

                                    Label lblPanel3PilihKriteria_BesarDaya_AwalDummy = new Label("");
                                    lblPanel3PilihKriteria_BesarDaya_AwalDummy.setPixelSize(52, 1);

                                    NumberField tfKriteriaBesarDayaAwal = new NumberField(new NumberPropertyEditor.IntegerPropertyEditor());
                                    tfKriteriaBesarDayaAwal.setWidth(100);

                                    Label lblPanel3PilihKriteria_BesarDaya_AkhirDummy = new Label("");
                                    lblPanel3PilihKriteria_BesarDaya_AkhirDummy.setPixelSize(10, 1);

                                    NumberField tfKriteriaBesarDayaAkhir = new NumberField(new NumberPropertyEditor.IntegerPropertyEditor());
                                    tfKriteriaBesarDayaAkhir.setWidth(100);

                                hpPanel3PilihKriteria_BesarDaya.add(cbKriteriaBesarDaya);
                                hpPanel3PilihKriteria_BesarDaya.add(lblPanel3PilihKriteria_BesarDaya_AwalDummy);
                                hpPanel3PilihKriteria_BesarDaya.add(tfKriteriaBesarDayaAwal);
                                hpPanel3PilihKriteria_BesarDaya.add(lblPanel3PilihKriteria_BesarDaya_AkhirDummy);
                                hpPanel3PilihKriteria_BesarDaya.add(tfKriteriaBesarDayaAkhir);

                            vlcPanel3PilihKriteria_KriteriaPencetakan.add(hpPanel3PilihKriteria_BesarDaya);

                                HorizontalPanel hpPanel3PilihKriteria_KodeGolongan = new HorizontalPanel();

                                    CheckBox cbKriteriaKodeGolongan = new CheckBox();
                                    cbKriteriaKodeGolongan.setBoxLabel("Kode Golongan");

                                    Label lblPanel3PilihKriteria_KodeGolongan_AwalDummy = new Label("");
                                    lblPanel3PilihKriteria_KodeGolongan_AwalDummy.setPixelSize(27, 1);

                                    NumberField tfKriteriaKodeGolonganAwal = new NumberField(new NumberPropertyEditor.IntegerPropertyEditor());
                                    tfKriteriaKodeGolonganAwal.setWidth(100);

                                    Label lblPanel3PilihKriteria_KodeGolongan_AkhirDummy = new Label("");
                                    lblPanel3PilihKriteria_KodeGolongan_AkhirDummy.setPixelSize(10, 1);

                                    NumberField tfKriteriaKodeGolonganAkhir = new NumberField(new NumberPropertyEditor.IntegerPropertyEditor());
                                    tfKriteriaKodeGolonganAkhir.setWidth(100);

                                hpPanel3PilihKriteria_KodeGolongan.add(cbKriteriaKodeGolongan);
                                hpPanel3PilihKriteria_KodeGolongan.add(lblPanel3PilihKriteria_KodeGolongan_AwalDummy);
                                hpPanel3PilihKriteria_KodeGolongan.add(tfKriteriaKodeGolonganAwal);
                                hpPanel3PilihKriteria_KodeGolongan.add(lblPanel3PilihKriteria_KodeGolongan_AkhirDummy);
                                hpPanel3PilihKriteria_KodeGolongan.add(tfKriteriaKodeGolonganAkhir);

                            vlcPanel3PilihKriteria_KriteriaPencetakan.add(hpPanel3PilihKriteria_KodeGolongan);

                                HorizontalPanel hpPanel3PilihKriteria_KoKed = new HorizontalPanel();

                                    CheckBox cbKriteriaNoRBM = new CheckBox();
                                    cbKriteriaNoRBM.setBoxLabel("No. RBM/KOKED");

                                    Label lblPanel3PilihKriteria_KoKed_AwalDummy = new Label("");
                                    lblPanel3PilihKriteria_KoKed_AwalDummy.setPixelSize(22, 1);

                                    NumberField tfKriteriaNoRBM = new NumberField(new NumberPropertyEditor.IntegerPropertyEditor());
                                    tfKriteriaNoRBM.setWidth(100);

                                    Label lblPanel3PilihKriteria_KoKed_AkhirDummy = new Label("");
                                    lblPanel3PilihKriteria_KoKed_AkhirDummy.setPixelSize(10, 1);

                                    Label lblPanel3PilihKriteria_KoKed_AkhirLabel = new Label("-> (Sebagian / Seluruh)");
                                    lblPanel3PilihKriteria_KoKed_AkhirLabel.setPixelSize(200, 1);

                                hpPanel3PilihKriteria_KoKed.add(cbKriteriaNoRBM);
                                hpPanel3PilihKriteria_KoKed.add(lblPanel3PilihKriteria_KoKed_AwalDummy);
                                hpPanel3PilihKriteria_KoKed.add(tfKriteriaNoRBM);
                                hpPanel3PilihKriteria_KoKed.add(lblPanel3PilihKriteria_KoKed_AkhirDummy);
                                hpPanel3PilihKriteria_KoKed.add(lblPanel3PilihKriteria_KoKed_AkhirLabel);

                            vlcPanel3PilihKriteria_KriteriaPencetakan.add(hpPanel3PilihKriteria_KoKed);

                                HorizontalPanel hpPanel3PilihKriteria_KantorPelayanan = new HorizontalPanel();

                                    CheckBox cbKriteriaKantorPelayanan = new CheckBox();
                                    cbKriteriaKantorPelayanan.setBoxLabel("Kantor Pelayanan");

                                    Label lblPanel3PilihKriteria_KantorPelayanan_AwalDummy = new Label("");
                                    lblPanel3PilihKriteria_KantorPelayanan_AwalDummy.setPixelSize(17, 1);

                                    NumberField tfKriteriaKantorPelayanan = new NumberField(new NumberPropertyEditor.IntegerPropertyEditor());
                                    tfKriteriaKantorPelayanan.setWidth(50);

                                    Label lblPanel3PilihKriteria_KantorPelayanan_AkhirDummy = new Label("");
                                    lblPanel3PilihKriteria_KantorPelayanan_AkhirDummy.setPixelSize(10, 1);

                                    Label lblPanel3PilihKriteria_KantorPelayanan_AkhirLabel = new Label("-> (3 digit pertama koked)");
                                    lblPanel3PilihKriteria_KantorPelayanan_AkhirLabel.setPixelSize(200, 1);

                                hpPanel3PilihKriteria_KantorPelayanan.add(cbKriteriaKantorPelayanan);
                                hpPanel3PilihKriteria_KantorPelayanan.add(lblPanel3PilihKriteria_KantorPelayanan_AwalDummy);
                                hpPanel3PilihKriteria_KantorPelayanan.add(tfKriteriaKantorPelayanan);
                                hpPanel3PilihKriteria_KantorPelayanan.add(lblPanel3PilihKriteria_KantorPelayanan_AkhirDummy);
                                hpPanel3PilihKriteria_KantorPelayanan.add(lblPanel3PilihKriteria_KantorPelayanan_AkhirLabel);

                            vlcPanel3PilihKriteria_KriteriaPencetakan.add(hpPanel3PilihKriteria_KantorPelayanan);

                                HorizontalPanel hpPanel3PilihKriteria_PetugasPemutusan = new HorizontalPanel();

                                    CheckBox cbKriteriaPetugasPemutusan = new CheckBox();
                                    cbKriteriaPetugasPemutusan.setBoxLabel("Petugas Pemutusan");

                                    Label lblPanel3PilihKriteria_PetugasPemutusan_AwalDummy = new Label("");
                                    lblPanel3PilihKriteria_PetugasPemutusan_AwalDummy.setPixelSize(5, 1);

                                    TextField tfKriteriaPetugasPemutusan = new TextField();
                                    tfKriteriaPetugasPemutusan.setWidth(100);

                                    Label lblPanel3PilihKriteria_PetugasPemutusan_AkhirDummy = new Label("");
                                    lblPanel3PilihKriteria_PetugasPemutusan_AkhirDummy.setPixelSize(10, 1);

                                    Label lblPanel3PilihKriteria_PetugasPemutusan_AkhirLabel = new Label("-> (Sebagian / Seluruh)");
                                    lblPanel3PilihKriteria_PetugasPemutusan_AkhirLabel.setPixelSize(200, 1);

                                hpPanel3PilihKriteria_PetugasPemutusan.add(cbKriteriaPetugasPemutusan);
                                hpPanel3PilihKriteria_PetugasPemutusan.add(lblPanel3PilihKriteria_PetugasPemutusan_AwalDummy);
                                hpPanel3PilihKriteria_PetugasPemutusan.add(tfKriteriaPetugasPemutusan);
                                hpPanel3PilihKriteria_PetugasPemutusan.add(lblPanel3PilihKriteria_PetugasPemutusan_AkhirDummy);
                                hpPanel3PilihKriteria_PetugasPemutusan.add(lblPanel3PilihKriteria_PetugasPemutusan_AkhirLabel);

                            vlcPanel3PilihKriteria_KriteriaPencetakan.add(hpPanel3PilihKriteria_PetugasPemutusan);

                                HorizontalPanel hpPanel3PilihKriteria_NoKontrol = new HorizontalPanel();

                                    CheckBox cbKriteriaNoKontrol = new CheckBox();
                                    cbKriteriaNoKontrol.setBoxLabel("No. Kontrol");

                                    Label lblPanel3PilihKriteria_NoKontrol_AwalDummy = new Label("");
                                    lblPanel3PilihKriteria_NoKontrol_AwalDummy.setPixelSize(48, 1);

                                    TextField tfKriteriaNoKontrol = new TextField();
                                    tfKriteriaNoKontrol.setWidth(100);

                                    Label lblPanel3PilihKriteria_NoKontrol_AkhirDummy = new Label("");
                                    lblPanel3PilihKriteria_NoKontrol_AkhirDummy.setPixelSize(10, 1);

                                    Label lblPanel3PilihKriteria_NoKontrol_AkhirLabel = new Label("-> (Sebagian / Seluruh)");
                                    lblPanel3PilihKriteria_NoKontrol_AkhirLabel.setPixelSize(200, 1);

                                hpPanel3PilihKriteria_NoKontrol.add(cbKriteriaNoKontrol);
                                hpPanel3PilihKriteria_NoKontrol.add(lblPanel3PilihKriteria_NoKontrol_AwalDummy);
                                hpPanel3PilihKriteria_NoKontrol.add(tfKriteriaNoKontrol);
                                hpPanel3PilihKriteria_NoKontrol.add(lblPanel3PilihKriteria_NoKontrol_AkhirDummy);
                                hpPanel3PilihKriteria_NoKontrol.add(lblPanel3PilihKriteria_NoKontrol_AkhirLabel);

                            vlcPanel3PilihKriteria_KriteriaPencetakan.add(hpPanel3PilihKriteria_NoKontrol);

                                HorizontalPanel hpPanel3PilihKriteria_NamaGardu = new HorizontalPanel();

                                    CheckBox cbKriteriaNamaGardu = new CheckBox();
                                    cbKriteriaNamaGardu.setBoxLabel("Nama Gardu");

                                    Label lblPanel3PilihKriteria_NamaGardu_AwalDummy = new Label("");
                                    lblPanel3PilihKriteria_NamaGardu_AwalDummy.setPixelSize(44, 1);

                                    TextField tfKriteriaNamaGardu = new TextField();
                                    tfKriteriaNamaGardu.setWidth(100);

                                    Label lblPanel3PilihKriteria_NamaGardu_AkhirDummy = new Label("");
                                    lblPanel3PilihKriteria_NamaGardu_AkhirDummy.setPixelSize(10, 1);

                                    Label lblPanel3PilihKriteria_NamaGardu_AkhirLabel = new Label("-> (Sebagian / Seluruh)");
                                    lblPanel3PilihKriteria_NamaGardu_AkhirLabel.setPixelSize(200, 1);

                                hpPanel3PilihKriteria_NamaGardu.add(cbKriteriaNamaGardu);
                                hpPanel3PilihKriteria_NamaGardu.add(lblPanel3PilihKriteria_NamaGardu_AwalDummy);
                                hpPanel3PilihKriteria_NamaGardu.add(tfKriteriaNamaGardu);
                                hpPanel3PilihKriteria_NamaGardu.add(lblPanel3PilihKriteria_NamaGardu_AkhirDummy);
                                hpPanel3PilihKriteria_NamaGardu.add(lblPanel3PilihKriteria_NamaGardu_AkhirLabel);

                            vlcPanel3PilihKriteria_KriteriaPencetakan.add(hpPanel3PilihKriteria_NamaGardu);

                                HorizontalPanel hpPanel3PilihKriteria_PaymentPoint = new HorizontalPanel();

                                    CheckBox cbKriteriaPaymentPoint = new CheckBox();
                                    cbKriteriaPaymentPoint.setBoxLabel("Payment Point");

                                    Label lblPanel3PilihKriteria_PaymentPoint_AwalDummy = new Label("");
                                    lblPanel3PilihKriteria_PaymentPoint_AwalDummy.setPixelSize(32, 1);

                                    TextField tfKriteriaPaymentPoint = new TextField();
                                    tfKriteriaPaymentPoint.setWidth(100);

                                    Label lblPanel3PilihKriteria_PaymentPoint_AkhirDummy = new Label("");
                                    lblPanel3PilihKriteria_PaymentPoint_AkhirDummy.setPixelSize(10, 1);

                                    Label lblPanel3PilihKriteria_PaymentPoint_AkhirLabel = new Label("-> (Sebagian / Seluruh)");
                                    lblPanel3PilihKriteria_PaymentPoint_AkhirLabel.setPixelSize(200, 1);

                                hpPanel3PilihKriteria_PaymentPoint.add(cbKriteriaPaymentPoint);
                                hpPanel3PilihKriteria_PaymentPoint.add(lblPanel3PilihKriteria_PaymentPoint_AwalDummy);
                                hpPanel3PilihKriteria_PaymentPoint.add(tfKriteriaPaymentPoint);
                                hpPanel3PilihKriteria_PaymentPoint.add(lblPanel3PilihKriteria_PaymentPoint_AkhirDummy);
                                hpPanel3PilihKriteria_PaymentPoint.add(lblPanel3PilihKriteria_PaymentPoint_AkhirLabel);

                            vlcPanel3PilihKriteria_KriteriaPencetakan.add(hpPanel3PilihKriteria_PaymentPoint);

                                HorizontalPanel hpPanel3PilihKriteria_Tarif = new HorizontalPanel();

                                    CheckBox cbKriteriaTarif = new CheckBox();
                                    cbKriteriaTarif.setBoxLabel("Tarif");

                                    Label lblPanel3PilihKriteria_Tarif_AwalDummy = new Label("");
                                    lblPanel3PilihKriteria_Tarif_AwalDummy.setPixelSize(86, 1);

                                    NumberField tfKriteriaTarif = new NumberField(new NumberPropertyEditor.IntegerPropertyEditor());
                                    tfKriteriaTarif.setWidth(100);

                                    Label lblPanel3PilihKriteria_Tarif_AkhirDummy = new Label("");
                                    lblPanel3PilihKriteria_Tarif_AkhirDummy.setPixelSize(10, 1);

                                    Label lblPanel3PilihKriteria_Tarif_AkhirLabel = new Label("-> (Sebagian / Seluruh)");
                                    lblPanel3PilihKriteria_Tarif_AkhirLabel.setPixelSize(200, 1);

                                hpPanel3PilihKriteria_Tarif.add(cbKriteriaTarif);
                                hpPanel3PilihKriteria_Tarif.add(lblPanel3PilihKriteria_Tarif_AwalDummy);
                                hpPanel3PilihKriteria_Tarif.add(tfKriteriaTarif);
                                hpPanel3PilihKriteria_Tarif.add(lblPanel3PilihKriteria_Tarif_AkhirDummy);
                                hpPanel3PilihKriteria_Tarif.add(lblPanel3PilihKriteria_Tarif_AkhirLabel);

                            vlcPanel3PilihKriteria_KriteriaPencetakan.add(hpPanel3PilihKriteria_Tarif);

                    panel3PilihKriteria.add(vlcPanel3PilihKriteria);


                        FramedPanel panel3PilihKriteria_Preview = new FramedPanel();
                        panel3PilihKriteria_Preview.setHeaderVisible(false);
                        panel3PilihKriteria_Preview.setWidth(400);

                            VerticalLayoutContainer vlcPanel3PilihKriteria_Preview = new VerticalLayoutContainer();

                                CheckBox cbTopPreview = new CheckBox();
                                cbTopPreview.setBoxLabel("Preview ?");

                                vlcPanel3PilihKriteria_Preview.add(cbTopPreview);

                            panel3PilihKriteria_Preview.add(vlcPanel3PilihKriteria_Preview);

                    vlcPanel3PilihKriteria.add(panel3PilihKriteria_Preview);


                        FramedPanel panel3PilihKriteria_CetakUlangLampiran = new FramedPanel();
                        panel3PilihKriteria_CetakUlangLampiran.setHeaderVisible(false);
                        panel3PilihKriteria_CetakUlangLampiran.setWidth(400);

                            VerticalLayoutContainer vlcPanel3PilihKriteria_CetakUlangLampiran = new VerticalLayoutContainer();

                                TextButton bTopCetakUlangDanLampiran = new TextButton("Cetak Ulang dan Lampiran");

                                vlcPanel3PilihKriteria_CetakUlangLampiran.add(bTopCetakUlangDanLampiran);

                            panel3PilihKriteria_CetakUlangLampiran.add(vlcPanel3PilihKriteria_CetakUlangLampiran);

                    vlcPanel3PilihKriteria.add(panel3PilihKriteria_CetakUlangLampiran);


                        FramedPanel panel3PilihKriteria_CetakPenyambungan = new FramedPanel();
                        panel3PilihKriteria_CetakPenyambungan.setHeaderVisible(false);
                        panel3PilihKriteria_CetakPenyambungan.setWidth(400);

                            VerticalLayoutContainer vlcPanel3PilihKriteria_CetakPenyambungan = new VerticalLayoutContainer();

                                TextButton bTopCetakPKPenyambungan = new TextButton("Cetak PK Penyambungan");

                                vlcPanel3PilihKriteria_CetakPenyambungan.add(bTopCetakPKPenyambungan);

                            panel3PilihKriteria_CetakPenyambungan.add(vlcPanel3PilihKriteria_CetakPenyambungan);

                    vlcPanel3PilihKriteria.add(panel3PilihKriteria_CetakPenyambungan);


                        FramedPanel panel3PilihKriteria_ProgressPencetakan = new FramedPanel();
                        panel3PilihKriteria_ProgressPencetakan.setHeaderVisible(false);
                        panel3PilihKriteria_ProgressPencetakan.setWidth(400);

                            VerticalLayoutContainer vlcPanel3PilihKriteria_ProgressPencetakan = new VerticalLayoutContainer();

                                TextField tfTopProgressPencetakan = new TextField();

                                vlcPanel3PilihKriteria_ProgressPencetakan.add(new FieldLabel(tfTopProgressPencetakan, "Progress Pencetakan"));

                                Label lTopProgressPencetakanDari = new Label();
                                lTopProgressPencetakanDari.setText("Total");

                                vlcPanel3PilihKriteria_ProgressPencetakan.add(new FieldLabel(lTopProgressPencetakanDari, "Dari"));

                            panel3PilihKriteria_ProgressPencetakan.add(vlcPanel3PilihKriteria_ProgressPencetakan);

                    vlcPanel3PilihKriteria.add(panel3PilihKriteria_ProgressPencetakan);



        vlcPanel3.add(hlcPanel3JenisKertasCekTiap);

        p.add(hlcPanel3);


        return panel;
    }
}
