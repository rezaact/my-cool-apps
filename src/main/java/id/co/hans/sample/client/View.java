package id.co.hans.sample.client;

import id.co.hans.sample.client.form.creditnote.Form_BatalCN;
import id.co.hans.sample.client.form.creditnote.Form_DataDana;
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

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class View implements IsWidget {
    private static View instance;
    protected static final String ID_USER = "id_user";
    @Override
    public Widget asWidget() {
        return asWidget();
    }

    public static View getInstance(){
        if (instance==null){
            instance = new View();
        }
        return instance;
    }

//    public BaseServices getService(){
//        return BaseServices.getInstance();
//    }
//
//    public BaseProperties getProperties(){
//        return BaseProperties.getInstance();
//    }

    public Widget getViewByIdMenu(String id_menu,String idUser, String unitupUser, String levelUser) {
        Widget widgetMenu = null;

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
            widgetMenu =new Form_Report23Nota_Kode().asWidget(idUser,unitupUser,levelUser);
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
        } else if (id_menu.toUpperCase().equals("Form_BatalCN".toUpperCase())) {
        	widgetMenu = new Form_BatalCN().asWidget(idUser, unitupUser, levelUser);
        } 
        
        else if (id_menu.toUpperCase().equals("Form_DataDana".toUpperCase())) {
        	widgetMenu = new Form_DataDana().asWidget(idUser, unitupUser, levelUser);
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

        return widgetMenu;
    }
}
