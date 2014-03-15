package id.co.hans.sample.client.form.reportmain;

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

public class Form_Report24Nota_Rekap {


    private VerticalPanel vp;

    ComboKodeNotaBuku cbKdNotaBuku;
    ComboTahunBulan cbTahunBulan;
    ComboJenisLaporan cbJenisLaporan;

    TextButton bCetak;

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
        panel.setHeadingText("Laporan Tagihan per-Kode Nota Buku Tpst");
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

        cbKdNotaBuku = new ComboKodeNotaBuku();
        vlcPReferensi.add(cbKdNotaBuku);

        p.add(panelReferensi);


        FramedPanel panelReferensiTgl = new FramedPanel();
        panelReferensiTgl.setHeadingText("Pilih Parameter");
        panelReferensiTgl.setBodyStyle("background: none; padding: 5px");
        panelReferensiTgl.setWidth(620);

        VerticalLayoutContainer vlcPReferensiTgl = new VerticalLayoutContainer();
        panelReferensiTgl.add(vlcPReferensiTgl);

        cbTahunBulan = new ComboTahunBulan();
        vlcPReferensiTgl.add(cbTahunBulan);

        cbJenisLaporan = new ComboJenisLaporan();
        vlcPReferensiTgl.add(cbJenisLaporan);

        p.add(panelReferensiTgl);


        bCetak = new TextButton("Cetak");

        panel.addButton(bCetak);

        return panel;
    }

    private void initEvent() {
        bCetak.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi;

                petugas = idUser;

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_23Terpusat_Kode"
                        +"&jenis="+cbJenisLaporan.getSelectedValue()
                        +"&tBLTH="+cbTahunBulan.getCbTahunSelectedValue()+cbTahunBulan.getCbBulanSelectedValue()
                        +"&tPetugas="+petugas
                        +"&kode="+cbKdNotaBuku.getSelectedValue();

                if (cbJenisLaporan.getSelectedValue().equals("24notarekapkode"))
                    url+="&report=report/ReportMain/23/cr_23nota_kode.rpt";
                else if (cbJenisLaporan.getSelectedValue().equals("24notarekap502"))
                    url+="&report=report/ReportMain/23/cr_23nota_tgl.rpt";
                else if (cbJenisLaporan.getSelectedValue().equals("24notarekap404"))
                    url+="&report=report/ReportMain/23/cr_23nota_404.rpt";
                else if (cbJenisLaporan.getSelectedValue().equals("24notadaftarrekg"))
                    url+="&report=report/ReportMain/23/cr_23nota_kode_daftar.rpt";
                else if (cbJenisLaporan.getSelectedValue().equals("24NOTADAFTARKOLEKTIF"))
                    url+="&report=report/ReportMain/23/cr_DaftarLunasKolektif.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });
    }
}
