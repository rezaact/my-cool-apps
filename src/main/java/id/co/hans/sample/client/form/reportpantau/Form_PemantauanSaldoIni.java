package id.co.hans.sample.client.form.reportpantau;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
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
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.*;

public class Form_PemantauanSaldoIni {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    ComboJenisLaporan cbJenisLaporan;

    TextButton btnExportExcel;
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
        panel.setHeadingText("Saldo Saat Ini");
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

        cbUnits = new ComboUnits(levelUser, unitUser, 1, 1, 1);
        vlcPReferensi.add(cbUnits);

        p.add(panelReferensi);


        FramedPanel panelReferensiTgl = new FramedPanel();
        panelReferensiTgl.setHeadingText("Pilih Parameter");
        panelReferensiTgl.setBodyStyle("background: none; padding: 5px");
        panelReferensiTgl.setWidth(620);

        VerticalLayoutContainer vlcPReferensiTgl = new VerticalLayoutContainer();
        panelReferensiTgl.add(vlcPReferensiTgl);

        cbJenisLaporan = new ComboJenisLaporan();
        cbJenisLaporan.setFormAsal("Form_PemantauanSaldoIni");
        vlcPReferensiTgl.add(cbJenisLaporan);

        p.add(panelReferensiTgl);



        FramedPanel panelButton = new FramedPanel();
        panelButton.setBodyStyle("background: none; padding: 5px");
        panelButton.setWidth(620);

        VerticalLayoutContainer vlcPButton = new VerticalLayoutContainer();
        panelButton.add(vlcPButton);

        btnExportExcel = new TextButton("Excel");
        btnCetak = new TextButton("Cetak");

        btnExportExcel.setWidth(220);

        btnCetak.setWidth(220);

        HorizontalPanel hp1 = new HorizontalPanel();

        hp1.add(btnExportExcel);
        hp1.add(btnCetak);

        vlcPButton.add(hp1);

        p.add(panelButton);


        return panel;
    }


    private void initEvent() {
        btnExportExcel.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                petugas = idUser;
                String url = "";

                String pilihSaldo = "", pilihRep = "";

                if ( cbJenisLaporan.getSelectedValue().equals("Rekap Saldo Rekening Lancar Per Gol") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "LANCAR";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Rekap Saldo Rekening Ragu2 Per Gol") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "RAGU";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Rekap Saldo Rekening Per Lembar") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "LANCAR_LEMBAR";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Rekap Saldo >= 200kVA") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "LANCAR200";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Saldo Rekening Lancar Berjalan Tgk") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "LANCAR_JLNTGK";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Saldo Rekening Lancar BlTh Rekg.") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "LANCAR_BLTH";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Rekap Saldo Rekening Per Tarip") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "LANCAR_JLNTGK_TARIP";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Rekap Saldo Rekening Per Gol Tarip") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "LANCAR_JLNTGK_GOLTARIP";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Daftar Saldo Rekening Lancar") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "DAFTAR_LANCAR";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Daftar Saldo Rekening Ragu2") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "DAFTAR_RAGU2";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Daftar Saldo Rekening Lancar > 2 Juta") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "DAFTAR_LANCAR_DIATAS2JUTA";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Daftar Saldo Rekening Ragu2 > 2 Juta") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "DAFTAR_RAGU2_DIATAS2JUTA";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Daftar Saldo 10 Besar") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "DAFTAR_10BESAR";
                }

                String sRptName = "", judulsatu = "", juduldua = "";
                if ( pilihRep.equals("LANCAR") ) {
                    //'rep = New cr_saldoini_LR
                    sRptName = "cr_saldoini_LR";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "LANCAR";
                } else if ( pilihRep.equals("LANCAR200") ) {
                    //'rep = New cr_saldoini_LR
                    sRptName = "cr_saldoini_LR200";
                    judulsatu = "SALDO REKENING LISTRIK DI ATAS 200 KVA";
                    juduldua = "LANCAR";
                } else if ( pilihRep.equals("RAGU") ) {
                    //'rep = New cr_saldoini_LR
                    sRptName = "cr_saldoini_LR";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "RAGU-RAGU";
                } else if ( pilihRep.equals("LANCAR_JLNTGK") ) {
                    //'rep = New cr_saldoini_L_jlntgk
                    sRptName = "cr_saldoini_L_jlntgk";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "LANCAR (BERJALAN TUNGGAKAN)";
                } else if ( pilihRep.equals("LANCAR_BLTH") ) {
                    //'rep = New cr_saldoini_L_blth
                    sRptName = "cr_saldoini_L_blth";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "LANCAR (BLTH REKENING)";
                    //'---tambahan untuk sumbar
                } else if ( pilihRep.equals("LANCAR_JLNTGK_TARIP") ) {
                    //'rep = New cr_saldoini_L_jlntgk_tarip
                    sRptName = "cr_saldoini_L_jlntgk_tarip";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "LANCAR (PER TARIP)";
                } else if ( pilihRep.equals("LANCAR_JLNTGK_GOLTARIP") ) {
                    //'rep = New cr_saldoini_L_jlntgk_tarip
                    sRptName = "cr_saldoini_L_jlntgk_goltarip";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "LANCAR (PER GOLONGAN TARIP)";
                } else if ( pilihRep.equals("LANCAR_LEMBAR") ) {
                    //'rep = New cr_saldoini_L_lembar
                    sRptName = "cr_saldoini_L_lembar";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "LANCAR (PER LEMBAR)";
                    //'--daftar
                } else if ( pilihRep.equals("DAFTAR_LANCAR") ) {
                    //'rep = New cr_L_daftar_saldo
                    sRptName = "cr_L_daftar_saldo";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "DAFTAR V-04 SALDO LANCAR";
                } else if ( pilihRep.equals("DAFTAR_RAGU2") ) {
                    //'rep = New cr_R_daftar_saldo
                    sRptName = "cr_R_daftar_saldo";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "DAFTAR V-04 SALDO RAGU2";
                } else if ( pilihRep.equals("DAFTAR_LANCAR_DIATAS2JUTA") ) {
                    //'rep = New cr_L_daftar_saldo
                    sRptName = "cr_L_daftar_saldo";
                    judulsatu = "SALDO REKENING LISTRIK DIATAS 2 JUTA";
                    juduldua = "DAFTAR V-04 SALDO LANCAR";
                } else if ( pilihRep.equals("DAFTAR_RAGU2_DIATAS2JUTA") ) {
                    //'rep = New cr_R_daftar_saldo
                    sRptName = "cr_R_daftar_saldo";
                    judulsatu = "SALDO REKENING LISTRIK LISTRIK DIATAS 2 JUTA";
                    juduldua = "DAFTAR V-04 SALDO RAGU2";
                } else if ( pilihRep.equals("DAFTAR_10BESAR") ) {
                    //'rep = New cr_L_daftar_saldo
                    sRptName = "cr_L_daftar_saldo";
                    judulsatu = "SALDO REKENING LISTRIK 10 BESAR";
                    juduldua = "DAFTAR V-04 SALDO";
                    //'--end daftar
                    //'---end tambahan sumbar
                }

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=PemantauanSaldo"
                        +"&vPilihSaldo="+pilihSaldo
                        +"&vPilihRep="+pilihRep
                        +"&tUnitUP="+cbUnits.getUnitUpValue()
                        +"&tUnitAP="+cbUnits.getUnitApValue()
                        +"&tTglmulai="+""
                        +"&tTglsampai="+""
                        +"&tBlTh="+""
                        +"&in_unitupi="+cbUnits.getUnitUpiValue()
                        +"&judulsatu="+judulsatu
                        +"&juduldua="+juduldua
                ;

                url+="&report=report/ReportPantau/Saldo/" + sRptName + ".rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        btnCetak.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();
                petugas = idUser;
                String url = "";

                String pilihSaldo = "", pilihRep =  "";

                if ( cbJenisLaporan.getSelectedValue().equals("Rekap Saldo Rekening Lancar Per Gol") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "LANCAR";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Rekap Saldo Rekening Ragu2 Per Gol") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "RAGU";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Rekap Saldo Rekening Per Lembar") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "LANCAR_LEMBAR";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Rekap Saldo >= 200kVA") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "LANCAR200";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Saldo Rekening Lancar Berjalan Tgk") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "LANCAR_JLNTGK";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Saldo Rekening Lancar BlTh Rekg.") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "LANCAR_BLTH";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Rekap Saldo Rekening Per Tarip") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "LANCAR_JLNTGK_TARIP";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Rekap Saldo Rekening Per Gol Tarip") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "LANCAR_JLNTGK_GOLTARIP";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Daftar Saldo Rekening Lancar") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "DAFTAR_LANCAR";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Daftar Saldo Rekening Ragu2") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "DAFTAR_RAGU2";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Daftar Saldo Rekening Lancar > 2 Juta") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "DAFTAR_LANCAR_DIATAS2JUTA";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Daftar Saldo Rekening Ragu2 > 2 Juta") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "DAFTAR_RAGU2_DIATAS2JUTA";
                } else if ( cbJenisLaporan.getSelectedValue().equals("Daftar Saldo 10 Besar") ) {
                    pilihSaldo = "SAAT_INI";
                    pilihRep = "DAFTAR_10BESAR";
                }

                String sRptName = "", judulsatu = "", juduldua = "";
                if ( pilihRep.equals("LANCAR") ) {
                    //'rep = New cr_saldoini_LR
                    sRptName = "cr_saldoini_LR";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "LANCAR";
                } else if ( pilihRep.equals("LANCAR200") ) {
                    //'rep = New cr_saldoini_LR
                    sRptName = "cr_saldoini_LR200";
                    judulsatu = "SALDO REKENING LISTRIK DI ATAS 200 KVA";
                    juduldua = "LANCAR";
                } else if ( pilihRep.equals("RAGU") ) {
                    //'rep = New cr_saldoini_LR
                    sRptName = "cr_saldoini_LR";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "RAGU-RAGU";
                } else if ( pilihRep.equals("LANCAR_JLNTGK") ) {
                    //'rep = New cr_saldoini_L_jlntgk
                    sRptName = "cr_saldoini_L_jlntgk";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "LANCAR (BERJALAN TUNGGAKAN)";
                } else if ( pilihRep.equals("LANCAR_BLTH") ) {
                    //'rep = New cr_saldoini_L_blth
                    sRptName = "cr_saldoini_L_blth";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "LANCAR (BLTH REKENING)";
                    //'---tambahan untuk sumbar
                } else if ( pilihRep.equals("LANCAR_JLNTGK_TARIP") ) {
                    //'rep = New cr_saldoini_L_jlntgk_tarip
                    sRptName = "cr_saldoini_L_jlntgk_tarip";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "LANCAR (PER TARIP)";
                } else if ( pilihRep.equals("LANCAR_JLNTGK_GOLTARIP") ) {
                    //'rep = New cr_saldoini_L_jlntgk_tarip
                    sRptName = "cr_saldoini_L_jlntgk_goltarip";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "LANCAR (PER GOLONGAN TARIP)";
                } else if ( pilihRep.equals("LANCAR_LEMBAR") ) {
                    //'rep = New cr_saldoini_L_lembar
                    sRptName = "cr_saldoini_L_lembar";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "LANCAR (PER LEMBAR)";
                    //'--daftar
                } else if ( pilihRep.equals("DAFTAR_LANCAR") ) {
                    //'rep = New cr_L_daftar_saldo
                    sRptName = "cr_L_daftar_saldo";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "DAFTAR V-04 SALDO LANCAR";
                } else if ( pilihRep.equals("DAFTAR_RAGU2") ) {
                    //'rep = New cr_R_daftar_saldo
                    sRptName = "cr_R_daftar_saldo";
                    judulsatu = "SALDO REKENING LISTRIK";
                    juduldua = "DAFTAR V-04 SALDO RAGU2";
                } else if ( pilihRep.equals("DAFTAR_LANCAR_DIATAS2JUTA") ) {
                    //'rep = New cr_L_daftar_saldo
                    sRptName = "cr_L_daftar_saldo";
                    judulsatu = "SALDO REKENING LISTRIK DIATAS 2 JUTA";
                    juduldua = "DAFTAR V-04 SALDO LANCAR";
                } else if ( pilihRep.equals("DAFTAR_RAGU2_DIATAS2JUTA") ) {
                    //'rep = New cr_R_daftar_saldo
                    sRptName = "cr_R_daftar_saldo";
                    judulsatu = "SALDO REKENING LISTRIK LISTRIK DIATAS 2 JUTA";
                    juduldua = "DAFTAR V-04 SALDO RAGU2";
                } else if ( pilihRep.equals("DAFTAR_10BESAR") ) {
                    //'rep = New cr_L_daftar_saldo
                    sRptName = "cr_L_daftar_saldo";
                    judulsatu = "SALDO REKENING LISTRIK 10 BESAR";
                    juduldua = "DAFTAR V-04 SALDO";
                    //'--end daftar
                    //'---end tambahan sumbar
                }

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=PemantauanSaldo"
                        +"&vPilihSaldo="+pilihSaldo
                        +"&vPilihRep="+pilihRep
                        +"&tUnitUP="+cbUnits.getUnitUpValue()
                        +"&tUnitAP="+cbUnits.getUnitApValue()
                        +"&tTglmulai="+""
                        +"&tTglsampai="+""
                        +"&tBlTh="+""
                        +"&in_unitupi="+cbUnits.getUnitUpiValue()
                        +"&judulsatu="+judulsatu
                        +"&juduldua="+juduldua
                        +"&tparupi="+unitUpi
                        +"&tparap="+unitAp
                        +"&tparup="+parUp
                        +"&tpetugas="+petugas
                ;

                url+="&report=report/ReportPantau/Saldo/" + sRptName + ".rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
