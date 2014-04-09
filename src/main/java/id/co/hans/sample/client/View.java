package id.co.hans.sample.client;

import id.co.hans.sample.client.form.creditnote.Form_BatalCN;
import id.co.hans.sample.client.form.creditnote.Form_DataDana;
import id.co.hans.sample.client.form.creditnote.Form_EntryCN;
import id.co.hans.sample.client.form.proses.Form_12Manual;
import id.co.hans.sample.client.form.proses.Form_21Entri;
import id.co.hans.sample.client.form.proses.Form_21Upload;
import id.co.hans.sample.client.form.proses.Form_23AnggotaNotaBuku;
import id.co.hans.sample.client.form.proses.Form_23AnggotaNotaTerpusat;
import id.co.hans.sample.client.form.proses.Form_23EntriLunasRestitusi;
import id.co.hans.sample.client.form.proses.Form_23KodeNotaBuku;
import id.co.hans.sample.client.form.proses.Form_23KodeNotaTerpusat;
import id.co.hans.sample.client.form.proses.Form_23PelunasanBebanKantor;
import id.co.hans.sample.client.form.proses.Form_23PelunasanNotaTerpusat;
import id.co.hans.sample.client.form.proses.Form_31Idpel;
import id.co.hans.sample.client.form.proses.Form_BatalNotaKolektif;
import id.co.hans.sample.client.form.proses.Form_MonitoringPending;
import id.co.hans.sample.client.form.prr.Lampiran;
import id.co.hans.sample.client.form.prr.Monitoring_Hapus_PRR;
import id.co.hans.sample.client.form.prr.NewCetak_106;
import id.co.hans.sample.client.form.prr.NewLaporan_DaftarPRR;
import id.co.hans.sample.client.form.prr.NewLaporan_LPPRH;
import id.co.hans.sample.client.form.prr.NewMonitoring_LunasExPRR;
import id.co.hans.sample.client.form.prr.NewMonitoring_LunasPRR;
import id.co.hans.sample.client.form.reportmain.Form_Report11_Rekap;
import id.co.hans.sample.client.form.reportmain.Form_Report12_Rekap;
import id.co.hans.sample.client.form.reportmain.Form_Report13_Rekap;
import id.co.hans.sample.client.form.reportmain.Form_Report2122_DoubleBayar;
import id.co.hans.sample.client.form.reportmain.Form_Report21Giral_Kode;
import id.co.hans.sample.client.form.reportmain.Form_Report21_BA;
import id.co.hans.sample.client.form.reportmain.Form_Report21_Kdpp;
import id.co.hans.sample.client.form.reportmain.Form_Report21_Petugas;
import id.co.hans.sample.client.form.reportmain.Form_Report21_Restitusi;
import id.co.hans.sample.client.form.reportmain.Form_Report21_Unit;
import id.co.hans.sample.client.form.reportmain.Form_Report21_Upload;
import id.co.hans.sample.client.form.reportmain.Form_Report22_AP;
import id.co.hans.sample.client.form.reportmain.Form_Report22_Kdpp;
import id.co.hans.sample.client.form.reportmain.Form_Report22_Petugas;
import id.co.hans.sample.client.form.reportmain.Form_Report22_Unit;
import id.co.hans.sample.client.form.reportmain.Form_Report23BebanKantor_Kode;
import id.co.hans.sample.client.form.reportmain.Form_Report23Dlt_Rekap;
import id.co.hans.sample.client.form.reportmain.Form_Report23NotaTerpusat_Kode;
import id.co.hans.sample.client.form.reportmain.Form_Report23Nota_Kode;
import id.co.hans.sample.client.form.reportmain.Form_Report23Nota_Rekap;
import id.co.hans.sample.client.form.reportmain.Form_Report23_Kirim;
import id.co.hans.sample.client.form.reportmain.Form_Report23_Terima;
import id.co.hans.sample.client.form.reportmain.Form_Report24Nota_Rekap;
import id.co.hans.sample.client.form.reportmain.Form_Report31_Rekap;
import id.co.hans.sample.client.form.reportmain.Form_Report32_Rekap;
import id.co.hans.sample.client.form.reportmain.Form_Report41_Rekap;
import id.co.hans.sample.client.form.reportmain.Form_ReportBK_212223_Rekap;
import id.co.hans.sample.client.form.reportmain.Form_ReportPenetapanBK_Rekap;
import id.co.hans.sample.client.form.reportmain.Form_Report_Pemda;
import id.co.hans.sample.client.form.reportmain.Form_Report_Restitusi;
import id.co.hans.sample.client.form.reportpantau.Form_MonitoringSaldoTunggakan;
import id.co.hans.sample.client.form.reportpantau.Form_MonitoringTunggakanPemda;
import id.co.hans.sample.client.form.reportpantau.Form_PemantauanBatalTransaksi;
import id.co.hans.sample.client.form.reportpantau.Form_PemantauanJurnal;
import id.co.hans.sample.client.form.reportpantau.Form_PemantauanSaldoBulan;
import id.co.hans.sample.client.form.reportpantau.Form_PemantauanSaldoHari;
import id.co.hans.sample.client.form.reportpantau.Form_PemantauanSaldoIni;
import id.co.hans.sample.client.form.reportpantau.Form_PemantauanTransaksi;
import id.co.hans.sample.client.form.reporttul.report309.Form_LaporanIII09;
import id.co.hans.sample.client.form.reporttul.report404.Form_LaporanIV04_New;
import id.co.hans.sample.client.form.reporttul.report502.Form_LaporanV02;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class View implements IsWidget {
  private static View instance;
  protected static final String ID_USER = "id_user";

  public static View getInstance() {
    if (instance == null) {
      instance = new View();
    }
    return instance;
  }

  @Override
  public Widget asWidget() {
    return asWidget();
  }

  // public BaseServices getService(){
  // return BaseServices.getInstance();
  // }
  //
  // public BaseProperties getProperties(){
  // return BaseProperties.getInstance();
  // }

  public Widget getViewByIdMenu(String id_menu, String idUser, String unitupUser, String levelUser) {
    Widget widgetMenu = null;


    //  menu testing
    if (id_menu.toUpperCase().equals("Form_Report11_Rekap".toUpperCase())){
    widgetMenu =new Form_Report11_Rekap().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report12_Rekap".toUpperCase())){
    widgetMenu =new Form_Report12_Rekap().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report13_Rekap".toUpperCase())){
    widgetMenu =new Form_Report13_Rekap().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report21_BA".toUpperCase())){
    widgetMenu =new Form_Report21_BA().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report21_Kdpp".toUpperCase())){
    widgetMenu =new Form_Report21_Kdpp().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report21_Petugas".toUpperCase())){
    widgetMenu =new Form_Report21_Petugas().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report21_Restitusi".toUpperCase())){
    widgetMenu =new Form_Report21_Restitusi().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report21_Unit".toUpperCase())){
    widgetMenu =new Form_Report21_Unit().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report21_Upload".toUpperCase())){
    widgetMenu =new Form_Report21_Upload().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report21Giral_Kode".toUpperCase())){
    widgetMenu =new Form_Report21Giral_Kode().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report22_AP".toUpperCase())){
    widgetMenu =new Form_Report22_AP().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report22_Kdpp".toUpperCase())){
    widgetMenu =new Form_Report22_Kdpp().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report22_Petugas".toUpperCase())){
    widgetMenu =new Form_Report22_Petugas().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report22_Unit".toUpperCase())){
    widgetMenu =new Form_Report22_Unit().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report23_Kirim".toUpperCase())){
    widgetMenu =new Form_Report23_Kirim().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report23_Terima".toUpperCase())){
    widgetMenu =new Form_Report23_Terima().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report23BebanKantor_Kode".toUpperCase())){
    widgetMenu =new Form_Report23BebanKantor_Kode().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report23Dlt_Rekap".toUpperCase())){
    widgetMenu =new Form_Report23Dlt_Rekap().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report23Nota_Kode".toUpperCase())){
    widgetMenu =new Form_Report23Nota_Kode().asWidget(idUser,unitupUser,levelUser, 0);
    } else if (id_menu.toUpperCase().equals("Form_Report23Nota_Rekap".toUpperCase())){
    widgetMenu =new Form_Report23Nota_Rekap().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report23NotaTerpusat_Kode".toUpperCase())){
    widgetMenu =new Form_Report23NotaTerpusat_Kode().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report24Nota_Rekap".toUpperCase())){
    widgetMenu =new Form_Report24Nota_Rekap().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report31_Rekap".toUpperCase())){
    widgetMenu =new Form_Report31_Rekap().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report32_Rekap".toUpperCase())){
    widgetMenu =new Form_Report32_Rekap().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report41_Rekap".toUpperCase())){
    widgetMenu =new Form_Report41_Rekap().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report2122_DoubleBayar".toUpperCase())){
    widgetMenu =new Form_Report2122_DoubleBayar().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report_Pemda".toUpperCase())){
    widgetMenu =new Form_Report_Pemda().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report_Restitusi".toUpperCase())){
    widgetMenu =new Form_Report_Restitusi().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_ReportBK_212223_Rekap".toUpperCase())){
    widgetMenu =new Form_ReportBK_212223_Rekap().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_ReportBK_212223_Rekap".toUpperCase())){
    widgetMenu =new Form_ReportBK_212223_Rekap().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_ReportPenetapanBK_Rekap".toUpperCase())){
    widgetMenu =new Form_ReportPenetapanBK_Rekap().asWidget(idUser,unitupUser,levelUser);
    }

    //report pantau
    else if (id_menu.toUpperCase().equals("Form_MonitoringSaldoTunggakan".toUpperCase())){
    widgetMenu =new Form_MonitoringSaldoTunggakan().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_MonitoringTunggakanPemda".toUpperCase())){
    widgetMenu =new Form_MonitoringTunggakanPemda().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_PemantauanBatalTransaksi".toUpperCase())){
    widgetMenu =new Form_PemantauanBatalTransaksi().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_PemantauanJurnal".toUpperCase())){
    widgetMenu =new Form_PemantauanJurnal().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_PemantauanSaldoBulan".toUpperCase())){
    widgetMenu =new Form_PemantauanSaldoBulan().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_PemantauanSaldoHari".toUpperCase())){
    widgetMenu =new Form_PemantauanSaldoHari().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_PemantauanSaldoIni".toUpperCase())){
    widgetMenu =new Form_PemantauanSaldoIni().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_PemantauanTransaksi".toUpperCase())){
    widgetMenu =new Form_PemantauanTransaksi().asWidget(idUser,unitupUser,levelUser);
    }

    //report tul
    else if (id_menu.toUpperCase().equals("Form_LaporanIII09".toUpperCase())){
    widgetMenu =new Form_LaporanIII09().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_LaporanIV04_New".toUpperCase())){
    widgetMenu =new Form_LaporanIV04_New().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("Form_LaporanV02".toUpperCase())){
    widgetMenu =new Form_LaporanV02().asWidget(idUser,unitupUser,levelUser);
    }

    // PRR
    else if (id_menu.toUpperCase().equals("prr_Lampiran".toUpperCase())){
    widgetMenu =new Lampiran().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("prr_Monitoring_Hapus_PRR".toUpperCase())){
    widgetMenu =new Monitoring_Hapus_PRR().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("prr_NewCetak_106".toUpperCase())){
    widgetMenu =new NewCetak_106().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("prr_NewLaporan_DaftarPRR".toUpperCase())){
    widgetMenu =new NewLaporan_DaftarPRR().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("prr_NewLaporan_LPPRH".toUpperCase())){
    widgetMenu =new NewLaporan_LPPRH().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("prr_NewMonitoring_LunasExPRR".toUpperCase())){
    widgetMenu =new NewMonitoring_LunasExPRR().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("prr_NewMonitoring_LunasPRR".toUpperCase())){
    widgetMenu =new NewMonitoring_LunasPRR().asWidget(idUser,unitupUser,levelUser);
    } else if (id_menu.toUpperCase().equals("prr_NewLaporan_PRR".toUpperCase())){
    //widgetMenu =new NewLaporan_PRR().asWidget(idUser,unitupUser,levelUser);

    }else if (id_menu.toUpperCase().equals("Form_EntryCN".toUpperCase())){
    widgetMenu =new Form_EntryCN().asWidget(idUser,unitupUser,levelUser);
    }
    // end menu untuk testing


    // menu production
    if (id_menu.toUpperCase().equals("mnuRekap11".toUpperCase())) {
      widgetMenu = new Form_Report11_Rekap().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekap12".toUpperCase())) {
      widgetMenu = new Form_Report12_Rekap().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekap13".toUpperCase())) {
      widgetMenu = new Form_Report13_Rekap().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report21_BA".toUpperCase())) {
      widgetMenu = new Form_Report21_BA().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekap21PerKDPP".toUpperCase())) {
      widgetMenu = new Form_Report21_Kdpp().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekap21PerPetugas".toUpperCase())) {
      widgetMenu = new Form_Report21_Petugas().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuLaporan21Restitusi".toUpperCase())) {
      widgetMenu = new Form_Report21_Restitusi().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekap21PerUnit".toUpperCase())) {
      widgetMenu = new Form_Report21_Unit().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekap21Upload".toUpperCase())) {
      widgetMenu = new Form_Report21_Upload().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report21Giral_Kode".toUpperCase())) {
      widgetMenu = new Form_Report21Giral_Kode().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report22_AP".toUpperCase())) {
      widgetMenu = new Form_Report22_AP().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekap22PerKDPP".toUpperCase())) {
      widgetMenu = new Form_Report22_Kdpp().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report22_Petugas".toUpperCase())) {
      widgetMenu = new Form_Report22_Petugas().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekap22PerUnit".toUpperCase())) {
      widgetMenu = new Form_Report22_Unit().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekap23Kirim".toUpperCase())) {
      widgetMenu = new Form_Report23_Kirim().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekap23Terima".toUpperCase())) {
      widgetMenu = new Form_Report23_Terima().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_Report23BebanKantor_Kode".toUpperCase())) {
      widgetMenu = new Form_Report23BebanKantor_Kode().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekap23Terpusat".toUpperCase())) {
      widgetMenu = new Form_Report23Dlt_Rekap().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuTagihanNotaBuku".toUpperCase())) {
      widgetMenu = new Form_Report23Nota_Kode().asWidget(idUser, unitupUser, levelUser, 0);
    } else if (id_menu.toUpperCase().equals("mnuTagihanBebanKantor".toUpperCase())) {
      widgetMenu = new Form_Report23Nota_Kode().asWidget(idUser, unitupUser, levelUser, 1);
    } else if (id_menu.toUpperCase().equals("mnuTagihanMemoDUPR".toUpperCase())) {
      widgetMenu = new Form_Report23Nota_Kode().asWidget(idUser, unitupUser, levelUser, 2);
    } else if (id_menu.toUpperCase().equals("mnuRekap23NotaBuku".toUpperCase())) {
      widgetMenu = new Form_Report23Nota_Rekap().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuTagihanLunasTerpusat".toUpperCase())) {
      widgetMenu = new Form_Report23NotaTerpusat_Kode().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekap24BebanKantor".toUpperCase())) {
      widgetMenu = new Form_Report24Nota_Rekap().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekap31".toUpperCase())) {
      widgetMenu = new Form_Report31_Rekap().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekap32".toUpperCase())) {
      widgetMenu = new Form_Report32_Rekap().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekap41".toUpperCase())) {
      widgetMenu = new Form_Report41_Rekap().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekapDoubleBayar".toUpperCase())) {
      widgetMenu = new Form_Report2122_DoubleBayar().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekapPemda".toUpperCase())) {
      widgetMenu = new Form_Report_Pemda().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuLaporanRestitusi".toUpperCase())) {
      widgetMenu = new Form_Report_Restitusi().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekapBK".toUpperCase())) {
      widgetMenu = new Form_ReportBK_212223_Rekap().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuRekapPenetapanBK".toUpperCase())) {
      widgetMenu = new Form_ReportPenetapanBK_Rekap().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_BatalCN".toUpperCase())) {
      widgetMenu = new Form_BatalCN().asWidget(idUser, unitupUser, levelUser);
    }

    else if (id_menu.toUpperCase().equals("Form_DataDana".toUpperCase())) {
      widgetMenu = new Form_DataDana().asWidget(idUser, unitupUser, levelUser);
    }

    // report pantau
    else if (id_menu.toUpperCase().equals("mnuMonitoringSaldoTunggakan".toUpperCase())) {
      widgetMenu = new Form_MonitoringSaldoTunggakan().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuMonitoringTunggakanPemda".toUpperCase())) {
      widgetMenu = new Form_MonitoringTunggakanPemda().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_PemantauanBatalTransaksi".toUpperCase())) {
      widgetMenu = new Form_PemantauanBatalTransaksi().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuJurnalTransaksi".toUpperCase())) {
      widgetMenu = new Form_PemantauanJurnal().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuSaldoBulanLalu".toUpperCase())) {
      widgetMenu = new Form_PemantauanSaldoBulan().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuSaldoperTanggal".toUpperCase())) {
      widgetMenu = new Form_PemantauanSaldoHari().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuSaldoSaatIni".toUpperCase())) {
      widgetMenu = new Form_PemantauanSaldoIni().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuTransaksiPiutang".toUpperCase())) {
      widgetMenu = new Form_PemantauanTransaksi().asWidget(idUser, unitupUser, levelUser);
    }

    // report tul
    else if (id_menu.toUpperCase().equals("Form_LaporanIII09".toUpperCase())) {
      widgetMenu = new Form_LaporanIII09().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuLaporan404RNR".toUpperCase())) {
      widgetMenu = new Form_LaporanIV04_New().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuLaporan404".toUpperCase())) {
      widgetMenu = new Form_LaporanIV04_New().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("mnuLaporanMutasiHarian".toUpperCase())) {
      widgetMenu = new Form_LaporanV02().asWidget(idUser, unitupUser, levelUser);
    }

    // yk
    else if (id_menu.toUpperCase().equals("Form_23AnggotaNotaBuku".toUpperCase())) {
      widgetMenu = new Form_23AnggotaNotaBuku().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_23AnggotaNotaTerpusat".toUpperCase())) {
      widgetMenu = new Form_23AnggotaNotaTerpusat().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_23KodeNotaTerpusat".toUpperCase())) {
      widgetMenu = new Form_23KodeNotaTerpusat().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_BatalNotaKolektif".toUpperCase())) {
      widgetMenu = new Form_BatalNotaKolektif().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_31Idpel".toUpperCase())) {
      widgetMenu = new Form_31Idpel().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_21Upload".toUpperCase())) {
      widgetMenu = new Form_21Upload().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_23KodeNotaBuku".toUpperCase())) {
      widgetMenu = new Form_23KodeNotaBuku().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_MonitoringPending".toUpperCase())) {
      widgetMenu = new Form_MonitoringPending().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_12Manual".toUpperCase())) {
      widgetMenu = new Form_12Manual().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_23PelunasanNotaTerpusat".toUpperCase())) {
      widgetMenu = new Form_23PelunasanNotaTerpusat().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_23PelunasanBebanKantor".toUpperCase())) {
      widgetMenu = new Form_23PelunasanBebanKantor().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_21Entri".toUpperCase())) {
      widgetMenu = new Form_21Entri().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("Form_23EntriLunasRestitusi".toUpperCase())) {
      widgetMenu = new Form_23EntriLunasRestitusi().asWidget(idUser, unitupUser, levelUser);
    }
    // PRR
    else if (id_menu.toUpperCase().equals("prr_Lampiran".toUpperCase())) {
      widgetMenu = new Lampiran().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("prr_Monitoring_Hapus_PRR".toUpperCase())) {
      widgetMenu = new Monitoring_Hapus_PRR().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("prr_NewCetak_106".toUpperCase())) {
      widgetMenu = new NewCetak_106().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("prr_NewLaporan_DaftarPRR".toUpperCase())) {
      widgetMenu = new NewLaporan_DaftarPRR().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("prr_NewLaporan_LPPRH".toUpperCase())) {
      widgetMenu = new NewLaporan_LPPRH().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("prr_NewMonitoring_LunasExPRR".toUpperCase())) {
      widgetMenu = new NewMonitoring_LunasExPRR().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("prr_NewMonitoring_LunasPRR".toUpperCase())) {
      widgetMenu = new NewMonitoring_LunasPRR().asWidget(idUser, unitupUser, levelUser);
    } else if (id_menu.toUpperCase().equals("prr_NewLaporan_PRR".toUpperCase())) {
      // widgetMenu =new NewLaporan_PRR().asWidget(idUser,unitupUser,levelUser);
    }
    return widgetMenu;
  }
}
