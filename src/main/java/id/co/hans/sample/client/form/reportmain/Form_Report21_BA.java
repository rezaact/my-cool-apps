package id.co.hans.sample.client.form.reportmain;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
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

import java.util.Map;


public class Form_Report21_BA {


    private VerticalPanel vp;

    ComboUnits cbUnits;
    ComboKodePP cbTopKodePengelolaPaymentPoint;
    DateField dfBeritaAcaraTanggalPelunasan;
    DateField dfTopTanggalAwal;
    DateField dfTopTanggalAkhir;
    TextButton bCetakBeritaAcara;
    TextButton bCetakRekapPelunasanTotal;

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
        panel.setHeadingText("Rekap 22 - Lunas Online Per KDPP");
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

        cbTopKodePengelolaPaymentPoint = new ComboKodePP();
        vlcPReferensi.add(cbTopKodePengelolaPaymentPoint);

        p.add(panelReferensi);


        FramedPanel panelReferensiTgl = new FramedPanel();
        panelReferensiTgl.setHeadingText("Pilih Referensi");
        panelReferensiTgl.setBodyStyle("background: none; padding: 5px");
        panelReferensiTgl.setWidth(620);

        VerticalLayoutContainer vlcPReferensiTgl = new VerticalLayoutContainer();
        panelReferensiTgl.add(vlcPReferensiTgl);


        dfBeritaAcaraTanggalPelunasan = new DateField();
        vlcPReferensiTgl.add(new FieldLabel(dfBeritaAcaraTanggalPelunasan, "Pilih Tanggal Pelunasan"));

        bCetakBeritaAcara = new TextButton("Cetak Berita Acara");

        vlcPReferensiTgl.add(bCetakBeritaAcara);

        p.add(panelReferensiTgl);


        FramedPanel panelParameter = new FramedPanel();
        panelParameter.setHeadingText("Pilih Parameter");
        panelParameter.setBodyStyle("background: none; padding: 5px");
        panelParameter.setWidth(620);

        VerticalLayoutContainer vlcPParameter = new VerticalLayoutContainer();
        panelParameter.add(vlcPParameter);


        HorizontalPanel hp1 = new HorizontalPanel();

        dfTopTanggalAwal = new DateField();
        dfTopTanggalAwal.setWidth(100);

        Label lbl = new Label("Sampai");

        dfTopTanggalAkhir = new DateField();
        dfTopTanggalAkhir.setWidth(100);

        hp1.add(dfTopTanggalAwal);
        hp1.add(lbl);
        hp1.add(dfTopTanggalAkhir);

        vlcPParameter.add(new FieldLabel(hp1, "Pilih Tanggal Pelunasan"), new VerticalLayoutContainer.VerticalLayoutData(-1,-1,new Margins(0,0,0,0)));

        p.add(panelParameter);


        bCetakRekapPelunasanTotal = new TextButton("Rekap Pelunasan Total");

        panel.addButton(bCetakRekapPelunasanTotal);

        return panel;
    }

    private void initEvent() {
        bCetakBeritaAcara.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                DateTimeFormat formatThbl = DateTimeFormat.getFormat("YYYYmm");
                DateTimeFormat formatDate = DateTimeFormat.getFormat("dd");

                parUp = cbUnits.getUnitUpValue();
                thbl = formatThbl.format(dfBeritaAcaraTanggalPelunasan.getValue());
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21_BA"
                        +"&vJenis="+"21BA"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+formatDate.format(dfBeritaAcaraTanggalPelunasan.getValue())
                        +"&tanggalend="+""
                        +"&kode="+""
                        +"&pengelola="+cbTopKodePengelolaPaymentPoint.getSelectedValue();

                url+="&report=report/ReportMain/21/cr_BALunasOffline.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });

        bCetakRekapPelunasanTotal.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, thbl, petugas, unitAp, unitUpi;

                DateTimeFormat formatThbl = DateTimeFormat.getFormat("YYYYmm");
                DateTimeFormat formatDate = DateTimeFormat.getFormat("dd");

                parUp = cbUnits.getUnitUpValue();
                thbl = formatThbl.format(dfTopTanggalAwal.getValue());
                petugas = idUser;
                unitAp = cbUnits.getUnitApValue();
                unitUpi = cbUnits.getUnitUpiValue();

                String url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=GetReport_21_BA"
                        +"&vJenis="+"21REKAPLUNASOFFLINE"
                        +"&tBLTH="+thbl
                        +"&tparUp="+parUp
                        +"&tPetugas="+petugas
                        +"&tanggal="+formatDate.format(dfTopTanggalAwal.getValue())
                        +"&tanggalend="+formatDate.format(dfTopTanggalAkhir.getValue())
                        +"&kode="+""
                        +"&pengelola="+cbTopKodePengelolaPaymentPoint.getSelectedValue();

                url+="&report=report/ReportMain/21/cr_RekapTotalPelunasan.rpt";

                Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");
            }
        });


        cbUnits.getComboUnitUp().addSelectionHandler(new SelectionHandler<Map<String, String>>() {
            @Override
            public void onSelection(SelectionEvent<Map<String, String>> event) {
                Map<String, String> data = (Map<String, String>)event.getSelectedItem();
                cbUnits.setUnitUpValue(data.get("fieldValue"));

                cbTopKodePengelolaPaymentPoint.getComboBox().setStoreUrl("components/getComboKodePaymentPoint.json?unitUp=" + cbUnits.getUnitUpValue());
                cbTopKodePengelolaPaymentPoint.getComboBox().loadStore();
            }
        });
    }
}
