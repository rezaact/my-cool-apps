package id.co.hans.sample.client.form.reportpantau;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
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
import id.co.hans.sample.client.components.IconAlertMessageBox;
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

    IconDynamicGrid gpData;

    TextButton bTopTampilkan;
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

        cbUnit = new ComboUnit(levelUser, unitUser);
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

        bTopTampilkan = new TextButton("Tampilkan");

        hp1 = new HorizontalPanel();
        hp1.add(dfTopTanggalAwal);
        hp1.add(bTopTampilkan);

        vlcPReferensiJnsTgl2.add(new FieldLabel(hp1, "Tanggal"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1, new Margins(0,0,0,0)));

        hp1 = new HorizontalPanel();
        hp1.add(dfTopTanggalAkhir);

        vlcPReferensiJnsTgl2.add(new FieldLabel(hp1, "Tanggal Akhir"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1, new Margins(0,0,0,0)));

        p.add(panelReferensiTgl2);


        gpData = new IconDynamicGrid();
        gpData.setGridHeader("Data");
        gpData.setGridDimension(620, 150);
        gpData.setStoreUrl("url");

        gpData.addColumn("No", 100);
        gpData.addColumn("TGL_CETAK", 100);
        gpData.addColumn("TANGGAL", 100);
        gpData.addColumn("TGL_BUKU", 100);
        gpData.addColumn("ID_PEL", 100);

        gpData.addColumn("WKTLNS", 100);
        gpData.addColumn("KDPP", 100);
        gpData.addColumn("PETUGAS", 100);
        gpData.addColumn("KDGERAK", 100);
        gpData.addColumn("KOGOL", 100);

        gpData.addColumn("UNIT_UP", 100);
        gpData.addColumn("KD_KELOMPOK", 100);
        gpData.addColumn("TARIP", 100);
        gpData.addColumn("DAYA", 100);
        gpData.addColumn("BLTH", 100);

        gpData.addColumn("KD_PEMBPP", 100);
        gpData.addColumn("STATUS", 100);
        gpData.addColumn("NOREK", 100);
        gpData.addColumn("UNIT_KJ", 100);
        gpData.addColumn("KD_INKASO", 100);

        gpData.addColumn("PEMDA", 100);
        gpData.addColumn("KD_PPJ", 100);
        gpData.addColumn("KODE", 100);
        gpData.addColumn("RPTAG", 100);
        gpData.addColumn("RPPTL", 100);

        gpData.addColumn("RPTB", 100);
        gpData.addColumn("RPPPN", 100);
        gpData.addColumn("RPBPJU", 100);
        gpData.addColumn("RPTRAFO", 100);
        gpData.addColumn("RPSEWATRAFO", 100);

        gpData.addColumn("RPSEWAKAP", 100);
        gpData.addColumn("RPANGSA", 100);
        gpData.addColumn("RPANGSB", 100);
        gpData.addColumn("RPANGSC", 100);
        gpData.addColumn("RPMAT", 100);

        gpData.addColumn("RPPLN", 100);
        gpData.addColumn("RPREDUKSI", 100);
        gpData.addColumn("RPINSENTIF", 100);
        gpData.addColumn("RDDISINSENTIF", 100);
        gpData.addColumn("RPBK1", 100);

        gpData.addColumn("RPBK2", 100);
        gpData.addColumn("RPBK3", 100);

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

                //if (gpData.getDataCount() == 0) {
                //    IconAlertMessageBox mb = new IconAlertMessageBox("Kesalahan", "Data yang ingin dicetak harus ditampilkan terlebih dahulu ke dalam Grid!");
                //    return;
                //}

                String parUp, jenis="", petugas, unitAp, unitUpi;
                String pilihTgl;
                String rep = "", judulsatu = "", juduldua = "";

                petugas = idUser;

                String url = "";

                if (radioTopJenisTanggalPembukuan.getValue())
                    pilihTgl = "PEMBUKUAN";
                else
                    pilihTgl = "TRANSAKSI";

                if (radioTopJenisPemantauanRekap.getValue()){
                    jenis = "REKAP";

                    if ( cbJenisTransaksi.getSelectedValue().equals("11 Rekening Baru") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_rekap_Bbuku111341";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_rekap_Btgl111341";
                        }
                        judulsatu = "REKAPITULASI REKENING LISTRIK BARU";
                        juduldua = "BATAL TRANSAKSI UPLOAD SOREK";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("12 Koreksi Rekening") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_rekap_Bbuku12";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_rekap_Btgl12";
                        }
                        judulsatu = "DAFTAR REKENING LISTRIK TARIP TUNGGAL DAN GANDA DENGAN KVARH";
                        juduldua = "BATAL TRANSAKSI KOREKSI REKENING";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("13 Rekening Susulan") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_rekap_Bbuku1113";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_rekap_Btgl1113";
                        }
                        judulsatu = "REKAPITULASI REKENING LISTRIK TARIP TUNGGAL DAN GANDA DENGAN KVARH";
                        juduldua = "BATAL TRANSAKSI UPLOAD REKENING SUSULAN";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("21 Pelunasan Off-Line") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_rekap_Bbuku212223314132";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_rekap_Btgl212223314132";
                        }
                        judulsatu = "DAFTAR PELUNASAN REKENING LISTRIK OFFLINE";
                        juduldua = "BATAL TRANSAKSI PELUNASAN PP OFFLINE, MANUAL, GIRALISASI";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("22 Pelunasan On-Line") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_rekap_Bbuku212223314132";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_rekap_Btgl212223314132";
                        }
                        judulsatu = "REKAPITULASI PELUNASAN REKENING LISTRIK ONLINE";
                        juduldua = "BATAL TRANSAKSI PELUNASAN PP ONLINE";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("23 Pelunasan NotaBuku") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_rekap_Bbuku212223314132";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_rekap_Btgl212223314132";
                        }
                        judulsatu = "REKAPITULASI PELUNASAN REKENING LISTRIK NOTA BUKU";
                        juduldua = "BATAL TRANSAKSI Pelunasan Nota Buku";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("23 Pelunasan Terpusat") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_rekap_Bbuku212223314132";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_rekap_Btgl212223314132";
                        }
                        judulsatu = "REKAPITULASI PELUNASAN REKENING LISTRIK NOTA BUKU";
                        juduldua = "BATAL TRANSAKSI Pelunasan Terpusat";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("31 Pembatalan Rekening") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_rekap_Bbuku212223314132";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_rekap_Btgl212223314132";
                        }
                        judulsatu = "REKAPITULASI PEMBATALAN REKENING LISTRIK";
                        juduldua = "BATAL TRANSAKSI PEMBATALAN REKENING TERBIT / GAGAL MUTASI";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("41 Pindah Lancar ke Ragu2") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_rekap_Bbuku212223314132";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_rekap_Btgl212223314132";
                        }
                        judulsatu = "REKAPITULASI MUTASI REKENING LISTRIK LANCAR KE RAGU2";
                        juduldua = "BATAL TRANSAKSI PINDAH LANCAR KE RAGU2";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("32 Penghapusan Rekening") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_rekap_Bbuku212223314132";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_rekap_Btgl212223314132";
                        }
                        judulsatu = "REKAPITULASI PENGHAPUSAN REKENING LISTRIK RAGU-RAGU";
                        juduldua = "BATAL TRANSAKSI HAPUS RAGU-RAGU";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("a. Cicilan Rekening KWH") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_rekap_BbukuCilrek";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_rekap_BtglCilrek";
                        }
                        judulsatu = "REKAPITULASI CICILAN REKENING LISTRIK";
                        juduldua = "BATAL TRANSAKSI CICILAN REKENING";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("b. Kirim Rekening ke Unit Lain") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_rekap_Bbuku23KirTer";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_rekap_Btgl23KirTer";
                        }
                        judulsatu = "REKAPITULASI KIRIM REKENING KE UNIT LAIN";
                        juduldua = "BATAL TRANSAKSI PENGIRIMAN REKENING LISTRIK";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("c. Terima Rekening dari Unit Lain") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_rekap_Bbuku23KirTer";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_rekap_Btgl23KirTer";
                        }
                        judulsatu = "REKAPITULASI TERIMA REKENING DARI UNIT LAIN";
                        juduldua = "BATAL TRANSAKSI PENERIMAAN REKENING LISTRIK";
                    }
                }
                else {
                    jenis = "DAFTAR";

                    if ( cbJenisTransaksi.getSelectedValue().equals("11 Rekening Baru") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_daftar_Bbuku111341";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_daftar_Btgl111341";
                        }
                        judulsatu = "DAFTAR REKENING LISTRIK BARU";
                        juduldua = "BATAL TRANSAKSI UPLOAD SOREK";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("12 Koreksi Rekening") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_daftar_Bbuku12";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_daftar_Btgl12";
                        }
                        judulsatu = "DAFTAR REKENING LISTRIK TARIP TUNGGAL DAN GANDA DENGAN KVARH";
                        juduldua = "BATAL TRANSAKSI KOREKSI REKENING";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("13 Rekening Susulan") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_daftar_Bbuku111341";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_daftar_Btgl111341";
                        }
                        judulsatu = "DAFTAR REKENING LISTRIK TARIP TUNGGAL DAN GANDA DENGAN KVARH";
                        juduldua = "BATAL TRANSAKSI UPLOAD REKENING SUSULAN";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("21 Pelunasan Off-Line") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_daftar_Bbuku2122233132";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_daftar_Btgl2122233132";
                        }
                        judulsatu = "DAFTAR PELUNASAN REKENING LISTRIK OFFLINE";
                        juduldua = "BATAL TRANSAKSI PELUNASAN PP OFFLINE, MANUAL, GIRALISASI";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("22 Pelunasan On-Line") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_daftar_Bbuku2122233132";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_daftar_Btgl2122233132";
                        }
                        judulsatu = "DAFTAR PELUNASAN REKENING LISTRIK ONLINE";
                        juduldua = "BATAL TRANSAKSI PELUNASAN PP ONLINE";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("23 Pelunasan NotaBuku") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_daftar_Bbuku2122233132";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_daftar_Btgl2122233132";
                        }
                        judulsatu = "DAFTAR PELUNASAN REKENING LISTRIK NOTA BUKU";
                        juduldua = "BATAL TRANSAKSI Pelunasan Nota Buku";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("23 Pelunasan Terpusat") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_daftar_Bbuku2122233132";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_daftar_Btgl2122233132";
                        }
                        judulsatu = "DAFTAR PELUNASAN REKENING LISTRIK NOTA BUKU";
                        juduldua = "BATAL TRANSAKSI Pelunasan Terpusat";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("31 Pembatalan Rekening") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_daftar_Bbuku2122233132";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_daftar_Btgl2122233132";
                        }
                        judulsatu = "DAFTAR PEMBATALAN REKENING LISTRIK";
                        juduldua = "BATAL TRANSAKSI PEMBATALAN REKENING TERBIT / GAGAL MUTASI";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("41 Pindah Lancar ke Ragu2") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_daftar_Bbuku111341";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_daftar_Btgl111341";
                        }
                        judulsatu = "DAFTAR MUTASI REKENING LISTRIK LANCAR KE RAGU2";
                        juduldua = "BATAL TRANSAKSI PINDAH LANCAR KE RAGU2";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("32 Penghapusan Rekening") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_daftar_Bbuku2122233132";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_daftar_Btgl2122233132";
                        }
                        judulsatu = "DAFTAR PENGHAPUSAN REKENING LISTRIK RAGU-RAGU";
                        juduldua = "BATAL TRANSAKSI HAPUS RAGU-RAGU";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("a. Cicilan Rekening KWH") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_daftar_BbukuCilrek";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_daftar_BtglCilrek";
                        }
                        judulsatu = "DAFTAR CICILAN REKENING LISTRIK";
                        juduldua = "BATAL TRANSAKSI CICILAN REKENING";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("b. Kirim Rekening ke Unit Lain") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_daftar_Bbuku23KirTer";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_daftar_Btgl23KirTer";
                        }
                        judulsatu = "DAFTAR KIRIM REKENING KE UNIT LAIN";
                        juduldua = "BATAL TRANSAKSI PENGIRIMAN REKENING LISTRIK";
                    } else if ( cbJenisTransaksi.getSelectedValue().equals("c. Terima Rekening dari Unit Lain") ) {
                        if ( pilihTgl.equals("PEMBUKUAN") ) {
                            rep = "cr_pantau_daftar_Bbuku23KirTer";
                        } else if ( pilihTgl.equals("TRANSAKSI") ) {
                            rep = "cr_pantau_daftar_Btgl23KirTer";
                        }
                        judulsatu = "DAFTAR TERIMA REKENING DARI UNIT LAIN";
                        juduldua = "BATAL TRANSAKSI PENERIMAAN REKENING LISTRIK";
                    }

                    rep = "daftar/" + rep;
                }


                DateTimeFormat formatter = DateTimeFormat.getFormat("yyyyMMdd");
                DateTimeFormat formatterThbl = DateTimeFormat.getFormat("yyyyMM");

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=PemantauanBatalTransaksi"
                        +"&transaksi="+cbJenisTransaksi.getSelectedValue()
                        +"&vjenis="+jenis
                        +"&vpilihtgl="+pilihTgl
                        +"&tunitkj="+""
                        +"&tunitup="+cbUnit.getSelectedValue()
                        +"&tunitap="+""
                        +"&ttglmulai="+formatter.format(dfTopTanggalAwal.getValue())
                        +"&ttglsampai="+formatter.format(dfTopTanggalAkhir.getValue())
                        +"&tkdpp="+""
                        +"&tkdpembayar="+""
                        +"&tkode="+""
                        +"&judulsatu="+judulsatu
                        +"&juduldua="+juduldua
                        +"&tpetugas="+idUser
                        +"&tparup="+cbUnit.getSelectedValue()
                        +"&tblth="+formatterThbl.format(dfTopTanggalAwal.getValue())
                ;

                url+="&report=report/ReportPantau/" + rep + ".rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });


        bTopTampilkan.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {

                String parUp, jenis="", petugas, unitAp, unitUpi;
                String pilihTgl;
                String rep = "", judulsatu = "", juduldua = "";

                petugas = idUser;
                String url = "";

                if (radioTopJenisTanggalPembukuan.getValue())
                    pilihTgl = "PEMBUKUAN";
                else
                    pilihTgl = "TRANSAKSI";

                if (radioTopJenisPemantauanRekap.getValue())
                    jenis = "REKAP";
                else
                    jenis = "DAFTAR";

                DateTimeFormat formatter = DateTimeFormat.getFormat("yyyy/MM/dd");

                url= GWT.getHostPageBaseURL()+ "Ws_Transaksi/PemantauanBatalTransaksi.json?"
                        +"&Transaksi="+cbJenisTransaksi.getSelectedValue()
                        +"&vJenis="+jenis
                        +"&vPilihTgl="+pilihTgl
                        +"&tUnitKJ="+""
                        +"&tUnitUP="+cbUnit.getSelectedValue()
                        +"&tUnitAP="+""
                        +"&tTglmulai="+formatter.format(dfTopTanggalAwal.getValue())
                        +"&tTglsampai="+formatter.format(dfTopTanggalAwal.getValue())
                        +"&tKdpp="+""
                        +"&tKdPembayar="+""
                        +"&tKode="+"";

                gpData.setStoreUrl(url);
                gpData.load();
            }
        });
    }
}
