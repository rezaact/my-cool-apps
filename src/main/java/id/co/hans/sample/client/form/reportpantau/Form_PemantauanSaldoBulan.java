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

public class Form_PemantauanSaldoBulan {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    ComboTahunBulan cbTahunBulan;

    TextButton bBottomRekapSaldoRekeningLancar;
    TextButton bBottomRekapSaldoRekeningRagu2;
    TextButton bBottomRekapSaldoRekeningPerGolTarip;

    TextButton bBottomRekapSaldoRekeningLancarPerGol;
    TextButton bBottomRekapSaldoRekgLancarPerBlthrek;
    TextButton bBottomRekapSaldoPerBlthrekPerTarip;


    TextButton bBottomRekapSaldoRekeningPerUnsur;
    TextButton bBottomRekapSaldoRekeningPerUmurPiutang;
    TextButton bBottomRekapSaldoRekeningPerBLTHdanGol;

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
        panel.setHeadingText("Saldo Bulan Lalu");
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

        cbTahunBulan = new ComboTahunBulan();
        vlcPReferensiTgl.add(cbTahunBulan);

        p.add(panelReferensiTgl);



        FramedPanel panelButton = new FramedPanel();
        panelButton.setBodyStyle("background: none; padding: 5px");
        panelButton.setWidth(620);

        VerticalLayoutContainer vlcPButton = new VerticalLayoutContainer();
        panelButton.add(vlcPButton);

        bBottomRekapSaldoRekeningLancar = new TextButton("Rekap Saldo Rekening Lancar");
        bBottomRekapSaldoRekeningRagu2 = new TextButton("Rekap Saldo Rekening Ragu2");
        bBottomRekapSaldoRekeningPerGolTarip = new TextButton("Rekap Saldo Rekening Per Gol Tarip");

        bBottomRekapSaldoRekeningLancarPerGol = new TextButton("Rekap Saldo Rekening Lancar Per Gol");
        bBottomRekapSaldoRekgLancarPerBlthrek = new TextButton("Rekap Saldo Rekg Lancar per BLTHREK");
        bBottomRekapSaldoPerBlthrekPerTarip = new TextButton("Rekap Saldo per BLTHREK per Tarip");

        bBottomRekapSaldoRekeningLancar.setWidth(220);
        bBottomRekapSaldoRekeningRagu2.setWidth(220);
        bBottomRekapSaldoRekeningPerGolTarip.setWidth(220);

        bBottomRekapSaldoRekeningLancarPerGol.setWidth(220);
        bBottomRekapSaldoRekgLancarPerBlthrek.setWidth(220);
        bBottomRekapSaldoPerBlthrekPerTarip.setWidth(220);

        HorizontalPanel hp1 = new HorizontalPanel();

        hp1.add(bBottomRekapSaldoRekeningLancar);
        hp1.add(bBottomRekapSaldoRekeningLancarPerGol);

        vlcPButton.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomRekapSaldoRekeningRagu2);
        hp1.add(bBottomRekapSaldoRekgLancarPerBlthrek);

        vlcPButton.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomRekapSaldoRekeningPerGolTarip);
        hp1.add(bBottomRekapSaldoPerBlthrekPerTarip);

        vlcPButton.add(hp1);

        p.add(panelButton);


        FramedPanel panelButton2 = new FramedPanel();
        panelButton2.setBodyStyle("background: none; padding: 5px");
        panelButton2.setWidth(620);

        VerticalLayoutContainer vlcPButton2 = new VerticalLayoutContainer();
        panelButton2.add(vlcPButton2);

        bBottomRekapSaldoRekeningPerUnsur = new TextButton("Rekap Saldo Rekening per Unsur");

        bBottomRekapSaldoRekeningPerUmurPiutang = new TextButton("Rekap Saldo Rekening per Umur Piutang");
        bBottomRekapSaldoRekeningPerBLTHdanGol = new TextButton("Rekap Saldo Rekening per BLTH dan Gol");

        bBottomRekapSaldoRekeningPerUnsur.setWidth(220);

        bBottomRekapSaldoRekeningPerUmurPiutang.setWidth(220);
        bBottomRekapSaldoRekeningPerBLTHdanGol.setWidth(220);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomRekapSaldoRekeningPerUnsur);
        hp1.add(bBottomRekapSaldoRekeningPerUmurPiutang);

        vlcPButton2.add(hp1);

        hp1 = new HorizontalPanel();

        hp1.add(bBottomRekapSaldoRekeningPerBLTHdanGol);

        vlcPButton2.add(hp1);

        p.add(panelButton2);


        return panel;
    }


    private void initEvent() {
        bBottomRekapSaldoRekeningLancar.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();
                petugas = idUser;
                String url = "";

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=PemantauanSaldo"
                        +"&vPilihSaldo="+"BULAN"
                        +"&vPilihRep="+"LANCAR"
                        +"&tUnitUP="+cbUnits.getUnitUpValue()
                        +"&tUnitAP="+cbUnits.getUnitApValue()
                        +"&tTglmulai="+""
                        +"&tTglsampai="+""
                        +"&tBlTh="+cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue()
                        +"&in_unitupi="+cbUnits.getUnitUpiValue()
                        +"&judulsatu="+"SALDO REKENING LISTRIK"
                        +"&juduldua="+"LANCAR"
                        +"&tparupi="+unitUpi
                        +"&tparap="+unitAp
                        +"&tparup="+parUp
                        +"&tpetugas="+petugas
                        ;


                url+="&report=report/ReportPantau/Saldo/cr_saldobulan_LR.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomRekapSaldoRekeningRagu2.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();
                petugas = idUser;
                String url = "";

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=PemantauanSaldo"
                        +"&vPilihSaldo="+"BULAN"
                        +"&vPilihRep="+"RAGU"
                        +"&tUnitUP="+cbUnits.getUnitUpValue()
                        +"&tUnitAP="+cbUnits.getUnitApValue()
                        +"&tTglmulai="+""
                        +"&tTglsampai="+""
                        +"&tBlTh="+cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue()
                        +"&in_unitupi="+cbUnits.getUnitUpiValue()
                        +"&judulsatu="+"SALDO REKENING LISTRIK"
                        +"&juduldua="+"RAGU-RAGU"
                        +"&tparupi="+unitUpi
                        +"&tparap="+unitAp
                        +"&tparup="+parUp
                        +"&tpetugas="+petugas
                ;


                url+="&report=report/ReportPantau/Saldo/cr_saldobulan_LR.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomRekapSaldoRekeningPerGolTarip.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();
                petugas = idUser;
                String url = "";

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=PemantauanSaldo"
                        +"&vPilihSaldo="+"BULAN"
                        +"&vPilihRep="+"LANCAR_JLNTGK_TARIP"
                        +"&tUnitUP="+cbUnits.getUnitUpValue()
                        +"&tUnitAP="+cbUnits.getUnitApValue()
                        +"&tTglmulai="+""
                        +"&tTglsampai="+""
                        +"&tBlTh="+cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue()
                        +"&in_unitupi="+cbUnits.getUnitUpiValue()
                        +"&judulsatu="+"SALDO PIUTANG PELANGGAN BERDASARKAN TARIP"
                        +"&juduldua="+"BULAN : " + cbTahunBulan.getCbBulanSelectedValue() + " " +cbTahunBulan.getCbTahunSelectedValue()
                        +"&tparupi="+unitUpi
                        +"&tparap="+unitAp
                        +"&tparup="+parUp
                        +"&tpetugas="+petugas
                ;


                url+="&report=report/ReportPantau/Saldo/cr_saldobulan_L_jlntgk_tarip.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });


        bBottomRekapSaldoRekeningLancarPerGol.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();
                petugas = idUser;
                String url = "";

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=PemantauanSaldo"
                        +"&vPilihSaldo="+"BULAN"
                        +"&vPilihRep="+"LANCAR_GOL"
                        +"&tUnitUP="+cbUnits.getUnitUpValue()
                        +"&tUnitAP="+cbUnits.getUnitApValue()
                        +"&tTglmulai="+""
                        +"&tTglsampai="+""
                        +"&tBlTh="+cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue()
                        +"&in_unitupi="+cbUnits.getUnitUpiValue()
                        +"&judulsatu="+"SALDO REKENING LISTRIK"
                        +"&juduldua="+"LANCAR per GOLONGAN"
                        +"&tparupi="+unitUpi
                        +"&tparap="+unitAp
                        +"&tparup="+parUp
                        +"&tpetugas="+petugas
                ;


                url+="&report=report/ReportPantau/Saldo/cr_saldobulan_L_gol.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomRekapSaldoRekgLancarPerBlthrek.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();
                petugas = idUser;
                String url = "";

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=PemantauanSaldo"
                        +"&vPilihSaldo="+"BULAN"
                        +"&vPilihRep="+"LANCAR_BLTH"
                        +"&tUnitUP="+cbUnits.getUnitUpValue()
                        +"&tUnitAP="+cbUnits.getUnitApValue()
                        +"&tTglmulai="+""
                        +"&tTglsampai="+""
                        +"&tBlTh="+cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue()
                        +"&in_unitupi="+cbUnits.getUnitUpiValue()
                        +"&judulsatu="+"SALDO REKENING LISTRIK"
                        +"&juduldua="+"LANCAR per BLTH REKENING"
                        +"&tparupi="+unitUpi
                        +"&tparap="+unitAp
                        +"&tparup="+parUp
                        +"&tpetugas="+petugas
                ;


                url+="&report=report/ReportPantau/Saldo/cr_saldobulan_L_blth.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomRekapSaldoPerBlthrekPerTarip.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();
                petugas = idUser;
                String url = "";

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=PemantauanSaldo"
                        +"&vPilihSaldo="+"BULAN"
                        +"&vPilihRep="+"LANCAR_JLNTGK_TARIP_BLTH"
                        +"&tUnitUP="+cbUnits.getUnitUpValue()
                        +"&tUnitAP="+cbUnits.getUnitApValue()
                        +"&tTglmulai="+""
                        +"&tTglsampai="+""
                        +"&tBlTh="+cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue()
                        +"&in_unitupi="+cbUnits.getUnitUpiValue()
                        +"&judulsatu="+"SALDO PIUTANG PELANGGAN BERDASARKAN TARIP"
                        +"&juduldua="+"BULAN : " + cbTahunBulan.getCbBulanSelectedValue() + " " +cbTahunBulan.getCbTahunSelectedValue()
                        +"&tparupi="+unitUpi
                        +"&tparap="+unitAp
                        +"&tparup="+parUp
                        +"&tpetugas="+petugas
                ;


                url+="&report=report/ReportPantau/Saldo/cr_saldobulan_L_jlntgk_tarip_blth.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });


        bBottomRekapSaldoRekeningPerUnsur.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();
                petugas = idUser;
                String url = "";

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=PemantauanSaldo"
                        +"&vPilihSaldo="+"BULAN"
                        +"&vPilihRep="+"JLN_TGK_UNSUR"
                        +"&tUnitUP="+cbUnits.getUnitUpValue()
                        +"&tUnitAP="+cbUnits.getUnitApValue()
                        +"&tTglmulai="+""
                        +"&tTglsampai="+""
                        +"&tBlTh="+cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue()
                        +"&in_unitupi="+cbUnits.getUnitUpiValue()
                        +"&judulsatu="+"SALDO PIUTANG PELANGGAN BERDASARKAN UNSUR PIUTANG"
                        +"&juduldua="+"BULAN : " + cbTahunBulan.getCbBulanSelectedValue() + " " +cbTahunBulan.getCbTahunSelectedValue()
                        +"&tparupi="+unitUpi
                        +"&tparap="+unitAp
                        +"&tparup="+parUp
                        +"&tpetugas="+petugas
                ;


                url+="&report=report/ReportPantau/Saldo/cr_saldobulan_unsur.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomRekapSaldoRekeningPerUmurPiutang.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();
                petugas = idUser;
                String url = "";

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=PemantauanSaldo"
                        +"&vPilihSaldo="+"BULAN"
                        +"&vPilihRep="+"UMUR_PIUTANG"
                        +"&tUnitUP="+cbUnits.getUnitUpValue()
                        +"&tUnitAP="+cbUnits.getUnitApValue()
                        +"&tTglmulai="+""
                        +"&tTglsampai="+""
                        +"&tBlTh="+cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue()
                        +"&in_unitupi="+cbUnits.getUnitUpiValue()
                        +"&judulsatu="+"SALDO REKENING LISTRIK"
                        +"&juduldua="+"LANCAR (PER LEMBAR)"
                        +"&tparupi="+unitUpi
                        +"&tparap="+unitAp
                        +"&tparup="+parUp
                        +"&tpetugas="+petugas
                ;


                url+="&report=report/ReportPantau/Saldo/cr_saldobulan_L_lembar.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
        bBottomRekapSaldoRekeningPerBLTHdanGol.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                parUp = cbUnits.getUnitUpValue();
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();
                petugas = idUser;
                String url = "";

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=PemantauanSaldo"
                        +"&vPilihSaldo="+"BULAN"
                        +"&vPilihRep="+"PER_GOL_BLTH"
                        +"&tUnitUP="+cbUnits.getUnitUpValue()
                        +"&tUnitAP="+cbUnits.getUnitApValue()
                        +"&tTglmulai="+""
                        +"&tTglsampai="+""
                        +"&tBlTh="+cbTahunBulan.getCbTahunSelectedValue() + cbTahunBulan.getCbBulanSelectedValue()
                        +"&in_unitupi="+cbUnits.getUnitUpiValue()
                        +"&judulsatu="+"SALDO REKENING LISTRIK"
                        +"&juduldua="+"LANCAR per GOLONGAN DAN PER BLTH REKENING"
                        +"&tparupi="+unitUpi
                        +"&tparap="+unitAp
                        +"&tparup="+parUp
                        +"&tpetugas="+petugas
                ;


                url+="&report=report/ReportPantau/Saldo/cr_saldobulan_L_gol_blth.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
