package id.co.hans.sample.client.form.prr;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.http.client.*;
import com.google.gwt.json.client.*;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Lampiran {
    private VerticalPanel vp;

    final FormPanel form = new FormPanel();

    private ComboTahunBulan comboTahunBulan;
    private ComboUnits comboUnits;
    TextField tNoBA;
    ComboJenisLaporan cLaporan;

    Radio rUmum, rNonUmum;

    private TextButton bttnCetak, bExcel;

    private IconAlertMessageBox mb;
    private RequestBuilder rb;

    private String wsResult;
    private Boolean wsReturn;
    private String wsByRefError;


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
//        AutoProgressMessageBox progressBox = new AutoProgressMessageBox("Progress", "please wait");
//        progressBox.setProgressText("wait...");

        vp.add(panelMain());
    }

    private FramedPanel panelMain() {

        FramedPanel panel = new FramedPanel();
        panel.setHeadingText("LAPORAN KHUSUS PIUTANG RAGU-RAGU");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        form.setAction("URLtoSave.json");
        form.setEncoding(FormPanel.Encoding.MULTIPART);
        form.setMethod(FormPanel.Method.POST);
        panel.add(form);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        form.add(p);

        comboUnits = new ComboUnits(levelUser, unitUser, 1, 1, 1);
        p.add(comboUnits);

        comboTahunBulan = new ComboTahunBulan();
        p.add(comboTahunBulan);

        tNoBA = new TextField();
        p.add(new FieldLabel(tNoBA, "No BA"));

        FieldSet fsGolongan = new FieldSet();
        fsGolongan.setHeadingText("Golongan Pelanggan");

        VerticalLayoutContainer vlcFsGolongan = new VerticalLayoutContainer();

        rUmum = new Radio();
        rUmum.setBoxLabel("Pelanggan Umum");
        rUmum.setVisible(true);

        rNonUmum = new Radio();
        rNonUmum.setBoxLabel("Pelaggan Pemerintah,PEMDA,BUMN, BUMD");

        vlcFsGolongan.add(rUmum);
        vlcFsGolongan.add(rNonUmum);

        fsGolongan.setWidget(vlcFsGolongan);

        p.add(fsGolongan);

        cLaporan = new ComboJenisLaporan();
        cLaporan.setFormAsal("prr.lampiran_ia");
        p.add(cLaporan);

        bttnCetak = new TextButton("Cetak");
        bExcel = new TextButton("To Excel");

        panel.addButton(bttnCetak);
        panel.addButton(bExcel);


        ToggleGroup tg = new ToggleGroup();
        tg.add(rUmum);
        tg.add(rNonUmum);

        return panel;
    }

    private void initEvent() {
        bttnCetak.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                String parUp, jenis="", petugas, unitAp, unitUpi, blth;

                petugas = idUser;

                String lampiran = "", no = "";

                unitUpi = comboUnits.getUnitUpiValue();
                unitAp = comboUnits.getUnitApValue();
                parUp = comboUnits.getUnitUpValue();
                blth = comboTahunBulan.getCbTahunSelectedValue()+comboTahunBulan.getCbBulanSelectedValue();

                if (cLaporan.getSelectedValue().equals("Daftar Usulan PRR"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran IA";
                    else
                        lampiran = "Lampiran IB";
                }
                else if (cLaporan.getSelectedValue().equals("Pendukung Daftar Usulan PRR"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran IA1";
                    else
                        lampiran = "Lampiran IB1";
                }
                else if (cLaporan.getSelectedValue().equals("B.A Penelitian Piutang Ragu"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran IIA";
                    else
                        lampiran = "Lampiran IIB";
                }
                else if (cLaporan.getSelectedValue().equals("Pendukung B.A Penelitian Piutang Ragu"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran IIA1";
                    else
                        lampiran = "Lampiran IIB1";
                }
                else if (cLaporan.getSelectedValue().equals("Daftar Piutang Ragu-Ragu"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran IIIA";
                    else
                        lampiran = "Lampiran IIIB";
                }
                else if (cLaporan.getSelectedValue().equals("Daftar Piutang Pelanggan < UJL"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran IVA";
                    else
                        lampiran = "Lampiran IVB";
                }
                else if (cLaporan.getSelectedValue().equals("Pendukung Daftar Piutang Pelanggan < UJL"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran IVA1";
                    else
                        lampiran = "Lampiran IVB1";
                }
                else if (cLaporan.getSelectedValue().equals("Daftar Usulan Penghapusan PRR"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran VA";
                    else
                        lampiran = "Lampiran VB";
                }
                else if (cLaporan.getSelectedValue().equals("Pendukung Daftar Usulan Penghapusan PRR"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran VA1";
                    else
                        lampiran = "Lampiran VB1";
                }
                else if (cLaporan.getSelectedValue().equals("Formulir SUPPR-UP"))
                {
                    lampiran = "Lampiran VI";
                    no = tNoBA.getText();
                }
                else if (cLaporan.getSelectedValue().equals("Formulir SUPPR-UPI"))
                {
                    lampiran = "Lampiran VII";
                    no = tNoBA.getText();
                }
                else if (cLaporan.getSelectedValue().equals("Daftar Penghapusan PRR"))
                {
                    if (rUmum.getValue())
                    {
                        lampiran = "Daftar Penghapusan PRRA";
                        unitUpi = comboUnits.getUnitUpiValue();
                        parUp = comboUnits.getUnitUpValue();
                        unitAp = comboUnits.getUnitApValue();
                    }
                    else
                    {
                        lampiran = "Daftar Penghapusan PRRB";
                        unitUpi = comboUnits.getUnitUpiValue();
                        parUp = comboUnits.getUnitUpValue();
                        unitAp = comboUnits.getUnitApValue();
                    }
                }
                else if (cLaporan.getSelectedValue().equals("Pendukung Daftar Penghapusan PRR"))
                {
                    if (rUmum.getValue())
                    {
                        lampiran = "Pendukung Daftar Penghapusan PRRA";
                        unitUpi = comboUnits.getUnitUpiValue();
                        parUp = comboUnits.getUnitUpValue();
                        unitAp = comboUnits.getUnitApValue();
                    }
                    else
                    {
                        lampiran = "Pendukung Daftar Penghapusan PRRB";
                        unitUpi = comboUnits.getUnitUpiValue();
                        parUp = comboUnits.getUnitUpValue();
                        unitAp = comboUnits.getUnitApValue();
                    }
                }


                String url = "";

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=prr_getLampiran"
                        +"&unitupi="+unitUpi
                        +"&unitap="+unitAp
                        +"&unitup="+parUp
                        +"&blth="+comboTahunBulan.getCbTahunSelectedValue()+comboTahunBulan.getCbBulanSelectedValue()
                        +"&lampiran="+lampiran
                        +"&no="+no
                        +"&idpel="+""
                        +"&unsur="+""
                        +"&pembukuan="+""
                        +"&tglmulai="+""
                        +"&tglsampai="+""
                        ;

                if (lampiran.equals("Lampiran IA"))
                {
                    url+="&report=report/ReportPRR/DaftarUsulanPrr_baru.rpt";
                }
                else if (lampiran.equals("Lampiran IA DUPR"))
                {
                    url+="&report=report/ReportPRR/DaftarUsulanPrr_baru.rpt";
                }
                else if (lampiran.equals("Lampiran IA1"))
                {
                    url+="&report=report/ReportPRR/DataPendukungDaftarUsulanPrrPU_baru.rpt";
                }
                else if (lampiran.equals("Lampiran IA1 DUPR"))
                {
                    url+="&report=report/ReportPRR/DataPendukungDaftarUsulanPrrPU_baru.rpt";
                }
                else if (lampiran.equals("Lampiran IB"))
                {
                    url+="&report=report/ReportPRR/DaftarUsulanPrrPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IB DUPR"))
                {
                    url+="&report=report/ReportPRR/DaftarUsulanPrrPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IB1"))
                {
                    url+="&report=report/ReportPRR/DtPndukungDftrUsulPrrPelnggnInstansiPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IB1 DUPR"))
                {
                    url+="&report=report/ReportPRR/DtPndukungDftrUsulPrrPelnggnInstansiPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IIA"))
                {
                    url+="&report=report/ReportPRR/PenelitianPrrPU_baru.rpt";
                }
                else if (lampiran.equals("Lampiran IIA DUPR"))
                {
                    url+="&report=report/ReportPRR/PenelitianPrrPU_baru.rpt";
                }
                else if (lampiran.equals("Lampiran IIA1"))
                {
                    url+="&report=report/ReportPRR/LapDataPendukungBeritaAcaraPrrPU_baru.rpt";
                }
                else if (lampiran.equals("Lampiran IIA1 DUPR"))
                {
                    url+="&report=report/ReportPRR/LapDataPendukungBeritaAcaraPrrPU_baru.rpt";
                }
                else if (lampiran.equals("Lampiran IIB"))
                {
                    url+="&report=report/ReportPRR/BAPenelitianPrrPelPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IIB DUPR"))
                {
                    url+="&report=report/ReportPRR/BAPenelitianPrrPelPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IIB1"))
                {
                    url+="&report=report/ReportPRR/DataPendukungBeritaAcaraPrrPelInsPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IIB1 DUPR"))
                {
                    url+="&report=report/ReportPRR/DataPendukungBeritaAcaraPrrPelInsPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IIIA"))
                {
                    url+="&report=report/ReportPRR/DaftarPrrPU_Baru.rpt";
                }
                else if (lampiran.equals("Lampiran IIIA DUPR"))
                {
                    url+="&report=report/ReportPRR/DaftarPrrPU_Baru.rpt";
                }
                else if (lampiran.equals("Lampiran IIIB"))
                {
                    url+="&report=report/ReportPRR/DaftarPrrPelInsPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IIIB DUPR"))
                {
                    url+="&report=report/ReportPRR/DaftarPrrPelInsPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IVA"))
                {
                    url+="&report=report/ReportPRR/DaftrPiutangPelLbhKecilDariUangJaminanPelPU_Baru.rpt";
                }
                else if (lampiran.equals("Lampiran IVA DUPR"))
                {
                    url+="&report=report/ReportPRR/DaftrPiutangPelLbhKecilDariUangJaminanPelPU_Baru.rpt";
                }
                else if (lampiran.equals("Lampiran IVB"))
                {
                    url+="&report=report/ReportPRR/DaftarPiutang PelLbhKecilPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IVB DUPR"))
                {
                    url+="&report=report/ReportPRR/DaftarPiutang PelLbhKecilPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IVA1"))
                {
                    url+="&report=report/ReportPRR/dATApENDUKUNGpplBHkECILuANGjAMuANGmUKAtlpuZ.rpt";
                }
                else if (lampiran.equals("Lampiran IVA1 DUPR"))
                {
                    url+="&report=report/ReportPRR/dATApENDUKUNGpplBHkECILuANGjAMuANGmUKAtlpuZ.rpt";
                }
                else if (lampiran.equals("Lampiran IVB1"))
                {
                    url+="&report=report/ReportPRR/DataPendukungLbhKecilPEMDAzz.rpt";
                }
                else if (lampiran.equals("Lampiran IVB1 DUPR"))
                {
                    url+="&report=report/ReportPRR/DataPendukungLbhKecilPEMDAzz.rpt";
                }
                else if (lampiran.equals("Lampiran VA"))
                {
                    url+="&report=report/ReportPRR/duprr_umum.rpt";
                }
                else if (lampiran.equals("Lampiran VA.NO_DUPPR")) //tdk ada
                {
                    url+="&report=report/ReportPRR/duprr_umum.rpt";
                }
                else if (lampiran.equals("Lampiran VA1"))
                {
                    url+="&report=report/ReportPRR/dp_duprr_umum.rpt";
                }
                else if (lampiran.equals("Lampiran VA1.NO_DUPPR")) //tidak ada
                {
                    url+="&report=report/ReportPRR/duprr_umum.rpt";
                }
                else if (lampiran.equals("Lampiran VB"))
                {
                    url+="&report=report/ReportPRR/duprr_nonumum.rpt";
                }
                else if (lampiran.equals("Lampiran VB.NO_DUPPR")) //tidak ada
                {
                    url+="&report=report/ReportPRR/duprr_umum.rpt";
                }
                else if (lampiran.equals("Lampiran VB1"))
                {
                    url+="&report=report/ReportPRR/dp_duprr_nonumum.rpt";
                }
                else if (lampiran.equals("Lampiran VB1.NO_DUPPR")) //tidak ada
                {
                    url+="&report=report/ReportPRR/duprr_umum.rpt";
                }
                else if (lampiran.equals("Lampiran VI"))
                {
                    url+="&report=report/ReportPRR/suppr_up.rpt";
                }
                else if (lampiran.equals("Lampiran VII"))
                {
                    url+="&report=report/ReportPRR/suppr_upi.rpt";
                }

                else if (lampiran.equals("Lampiran VIIIA"))
                {
                    url+="&report=report/ReportPRR/tul_pr.rpt";
                }
                else if (lampiran.equals("Lampiran I06"))
                {
                    url+="&report=report/ReportPRR/rptI06koreksi.rpt";
                }
                else if (lampiran.equals("Laporan Pelunasan PRR"))
                {
                    url+="&report=report/ReportPRR/Laporan_LunasPRR.rpt";
                }
                else if (lampiran.equals("Laporan Pelunasan Ex PRR"))
                {
                    url+="&report=report/ReportPRR/Laporan_LunasExPRR.rpt";
                }

                else if (lampiran.equals("Laporan Daftar PRR"))
                {
                    url+="&report=report/ReportPRR/Laporan_Daftar_PRR.rpt";
                }
                else if (lampiran.equals("Laporan Daftar Penghapusan PRR"))
                {
                    url+="&report=report/ReportPRR/Laporan_Daftar_DUPPR.rpt";
                }
                else if (lampiran.equals("Daftar Penghapusan PRRA"))
                {
                    url+="&report=report/ReportPRR/Laporan_Daftar_DUPPR_Umum.rpt";
                }
                else if (lampiran.equals("Daftar Penghapusan PRRB"))
                {
                    url+="&report=report/ReportPRR/Laporan_Daftar_DUPPR_NonUmum.rpt";
                }
                else if (lampiran.equals("Pendukung Daftar Penghapusan PRRA"))
                {
                    url+="&report=report/ReportPRR/dataPendukung_duprr_umum.rpt";
                }
                else if (lampiran.equals("Pendukung Daftar Penghapusan PRRB"))
                {
                    url+="&report=report/ReportPRR/dataPendukung_duprr_nonumum.rpt";
                }
                else if (lampiran.equals("Lampiran VIIIB"))
                {
                    url+="&report=report/ReportPRR/tul_lpprh.rpt";
                }


                  com.google.gwt.user.client.Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");

            }
        });

        bExcel.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {

                String parUp, jenis="", petugas, unitAp, unitUpi, blth;
                petugas = idUser;

                String lampiran = "", no = "";

                unitUpi = comboUnits.getUnitUpiValue();
                unitAp = comboUnits.getUnitApValue();
                parUp = comboUnits.getUnitUpValue();
                blth = comboTahunBulan.getCbTahunSelectedValue()+comboTahunBulan.getCbBulanSelectedValue();

                if (cLaporan.getSelectedValue().equals("Daftar Usulan PRR"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran IA";
                    else
                        lampiran = "Lampiran IB";
                }
                else if (cLaporan.getSelectedValue().equals("Pendukung Daftar Usulan PRR"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran IA1";
                    else
                        lampiran = "Lampiran IB1";
                }
                else if (cLaporan.getSelectedValue().equals("B.A Penelitian Piutang Ragu"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran IIA";
                    else
                        lampiran = "Lampiran IIB";
                }
                else if (cLaporan.getSelectedValue().equals("Pendukung B.A Penelitian Piutang Ragu"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran IIA1";
                    else
                        lampiran = "Lampiran IIB1";
                }
                else if (cLaporan.getSelectedValue().equals("Daftar Piutang Ragu-Ragu"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran IIIA";
                    else
                        lampiran = "Lampiran IIIB";
                }
                else if (cLaporan.getSelectedValue().equals("Daftar Piutang Pelanggan < UJL"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran IVA";
                    else
                        lampiran = "Lampiran IVB";
                }
                else if (cLaporan.getSelectedValue().equals("Pendukung Daftar Piutang Pelanggan < UJL"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran IVA1";
                    else
                        lampiran = "Lampiran IVB1";
                }
                else if (cLaporan.getSelectedValue().equals("Daftar Usulan Penghapusan PRR"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran VA";
                    else
                        lampiran = "Lampiran VB";
                }
                else if (cLaporan.getSelectedValue().equals("Pendukung Daftar Usulan Penghapusan PRR"))
                {
                    if (rUmum.getValue())
                        lampiran = "Lampiran VA1";
                    else
                        lampiran = "Lampiran VB1";
                }
                else if (cLaporan.getSelectedValue().equals("Formulir SUPPR-UP"))
                {
                    lampiran = "Lampiran VI";
                    no = tNoBA.getText();
                }
                else if (cLaporan.getSelectedValue().equals("Formulir SUPPR-UPI"))
                {
                    lampiran = "Lampiran VII";
                    no = tNoBA.getText();
                }
                else if (cLaporan.getSelectedValue().equals("Daftar Penghapusan PRR"))
                {
                    if (rUmum.getValue())
                    {
                        lampiran = "Daftar Penghapusan PRRA";
                        unitUpi = comboUnits.getUnitUpiValue();
                        parUp = comboUnits.getUnitUpValue();
                        unitAp = comboUnits.getUnitApValue();
                    }
                    else
                    {
                        lampiran = "Daftar Penghapusan PRRB";
                        unitUpi = comboUnits.getUnitUpiValue();
                        parUp = comboUnits.getUnitUpValue();
                        unitAp = comboUnits.getUnitApValue();
                    }
                }
                else if (cLaporan.getSelectedValue().equals("Pendukung Daftar Penghapusan PRR"))
                {
                    if (rUmum.getValue())
                    {
                        lampiran = "Pendukung Daftar Penghapusan PRRA";
                        unitUpi = comboUnits.getUnitUpiValue();
                        parUp = comboUnits.getUnitUpValue();
                        unitAp = comboUnits.getUnitApValue();
                    }
                    else
                    {
                        lampiran = "Pendukung Daftar Penghapusan PRRB";
                        unitUpi = comboUnits.getUnitUpiValue();
                        parUp = comboUnits.getUnitUpValue();
                        unitAp = comboUnits.getUnitApValue();
                    }
                }


                String url = "";

                url= GWT.getHostPageBaseURL()+ "ReportServlet?idjenislaporan=prr_getLampiran"
                        +"&unitupi="+unitUpi
                        +"&unitap="+unitAp
                        +"&unitup="+parUp
                        +"&blth="+comboTahunBulan.getCbTahunSelectedValue()+comboTahunBulan.getCbBulanSelectedValue()
                        +"&lampiran="+lampiran
                        +"&no="+no
                        +"&idpel="+""
                        +"&unsur="+""
                        +"&pembukuan="+""
                        +"&tglmulai="+""
                        +"&tglsampai="+""
                ;

                if (lampiran.equals("Lampiran IA"))
                {
                    url+="&report=report/ReportPRR/DaftarUsulanPrr_baru.rpt";
                }
                else if (lampiran.equals("Lampiran IA DUPR"))
                {
                    url+="&report=report/ReportPRR/DaftarUsulanPrr_baru.rpt";
                }
                else if (lampiran.equals("Lampiran IA1"))
                {
                    url+="&report=report/ReportPRR/DataPendukungDaftarUsulanPrrPU_baru.rpt";
                }
                else if (lampiran.equals("Lampiran IA1 DUPR"))
                {
                    url+="&report=report/ReportPRR/DataPendukungDaftarUsulanPrrPU_baru.rpt";
                }
                else if (lampiran.equals("Lampiran IB"))
                {
                    url+="&report=report/ReportPRR/DaftarUsulanPrrPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IB DUPR"))
                {
                    url+="&report=report/ReportPRR/DaftarUsulanPrrPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IB1"))
                {
                    url+="&report=report/ReportPRR/DtPndukungDftrUsulPrrPelnggnInstansiPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IB1 DUPR"))
                {
                    url+="&report=report/ReportPRR/DtPndukungDftrUsulPrrPelnggnInstansiPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IIA"))
                {
                    url+="&report=report/ReportPRR/PenelitianPrrPU_baru.rpt";
                }
                else if (lampiran.equals("Lampiran IIA DUPR"))
                {
                    url+="&report=report/ReportPRR/PenelitianPrrPU_baru.rpt";
                }
                else if (lampiran.equals("Lampiran IIA1"))
                {
                    url+="&report=report/ReportPRR/LapDataPendukungBeritaAcaraPrrPU_baru.rpt";
                }
                else if (lampiran.equals("Lampiran IIA1 DUPR"))
                {
                    url+="&report=report/ReportPRR/LapDataPendukungBeritaAcaraPrrPU_baru.rpt";
                }
                else if (lampiran.equals("Lampiran IIB"))
                {
                    url+="&report=report/ReportPRR/BAPenelitianPrrPelPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IIB DUPR"))
                {
                    url+="&report=report/ReportPRR/BAPenelitianPrrPelPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IIB1"))
                {
                    url+="&report=report/ReportPRR/DataPendukungBeritaAcaraPrrPelInsPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IIB1 DUPR"))
                {
                    url+="&report=report/ReportPRR/DataPendukungBeritaAcaraPrrPelInsPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IIIA"))
                {
                    url+="&report=report/ReportPRR/DaftarPrrPU_Baru.rpt";
                }
                else if (lampiran.equals("Lampiran IIIA DUPR"))
                {
                    url+="&report=report/ReportPRR/DaftarPrrPU_Baru.rpt";
                }
                else if (lampiran.equals("Lampiran IIIB"))
                {
                    url+="&report=report/ReportPRR/DaftarPrrPelInsPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IIIB DUPR"))
                {
                    url+="&report=report/ReportPRR/DaftarPrrPelInsPemPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IVA"))
                {
                    url+="&report=report/ReportPRR/DaftrPiutangPelLbhKecilDariUangJaminanPelPU_Baru.rpt";
                }
                else if (lampiran.equals("Lampiran IVA DUPR"))
                {
                    url+="&report=report/ReportPRR/DaftrPiutangPelLbhKecilDariUangJaminanPelPU_Baru.rpt";
                }
                else if (lampiran.equals("Lampiran IVB"))
                {
                    url+="&report=report/ReportPRR/DaftarPiutang PelLbhKecilPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IVB DUPR"))
                {
                    url+="&report=report/ReportPRR/DaftarPiutang PelLbhKecilPEMDABUMN.rpt";
                }
                else if (lampiran.equals("Lampiran IVA1"))
                {
                    url+="&report=report/ReportPRR/dATApENDUKUNGpplBHkECILuANGjAMuANGmUKAtlpuZ.rpt";
                }
                else if (lampiran.equals("Lampiran IVA1 DUPR"))
                {
                    url+="&report=report/ReportPRR/dATApENDUKUNGpplBHkECILuANGjAMuANGmUKAtlpuZ.rpt";
                }
                else if (lampiran.equals("Lampiran IVB1"))
                {
                    url+="&report=report/ReportPRR/DataPendukungLbhKecilPEMDAzz.rpt";
                }
                else if (lampiran.equals("Lampiran IVB1 DUPR"))
                {
                    url+="&report=report/ReportPRR/DataPendukungLbhKecilPEMDAzz.rpt";
                }
                else if (lampiran.equals("Lampiran VA"))
                {
                    url+="&report=report/ReportPRR/duprr_umum.rpt";
                }
                else if (lampiran.equals("Lampiran VA.NO_DUPPR")) //tdk ada
                {
                    url+="&report=report/ReportPRR/duprr_umum.rpt";
                }
                else if (lampiran.equals("Lampiran VA1"))
                {
                    url+="&report=report/ReportPRR/dp_duprr_umum.rpt";
                }
                else if (lampiran.equals("Lampiran VA1.NO_DUPPR")) //tidak ada
                {
                    url+="&report=report/ReportPRR/duprr_umum.rpt";
                }
                else if (lampiran.equals("Lampiran VB"))
                {
                    url+="&report=report/ReportPRR/duprr_nonumum.rpt";
                }
                else if (lampiran.equals("Lampiran VB.NO_DUPPR")) //tidak ada
                {
                    url+="&report=report/ReportPRR/duprr_umum.rpt";
                }
                else if (lampiran.equals("Lampiran VB1"))
                {
                    url+="&report=report/ReportPRR/dp_duprr_nonumum.rpt";
                }
                else if (lampiran.equals("Lampiran VB1.NO_DUPPR")) //tidak ada
                {
                    url+="&report=report/ReportPRR/duprr_umum.rpt";
                }
                else if (lampiran.equals("Lampiran VI"))
                {
                    url+="&report=report/ReportPRR/suppr_up.rpt";
                }
                else if (lampiran.equals("Lampiran VII"))
                {
                    url+="&report=report/ReportPRR/suppr_upi.rpt";
                }

                else if (lampiran.equals("Lampiran VIIIA"))
                {
                    url+="&report=report/ReportPRR/tul_pr.rpt";
                }
                else if (lampiran.equals("Lampiran I06"))
                {
                    url+="&report=report/ReportPRR/rptI06koreksi.rpt";
                }
                else if (lampiran.equals("Laporan Pelunasan PRR"))
                {
                    url+="&report=report/ReportPRR/Laporan_LunasPRR.rpt";
                }
                else if (lampiran.equals("Laporan Pelunasan Ex PRR"))
                {
                    url+="&report=report/ReportPRR/Laporan_LunasExPRR.rpt";
                }

                else if (lampiran.equals("Laporan Daftar PRR"))
                {
                    url+="&report=report/ReportPRR/Laporan_Daftar_PRR.rpt";
                }
                else if (lampiran.equals("Laporan Daftar Penghapusan PRR"))
                {
                    url+="&report=report/ReportPRR/Laporan_Daftar_DUPPR.rpt";
                }
                else if (lampiran.equals("Daftar Penghapusan PRRA"))
                {
                    url+="&report=report/ReportPRR/Laporan_Daftar_DUPPR_Umum.rpt";
                }
                else if (lampiran.equals("Daftar Penghapusan PRRB"))
                {
                    url+="&report=report/ReportPRR/Laporan_Daftar_DUPPR_NonUmum.rpt";
                }
                else if (lampiran.equals("Pendukung Daftar Penghapusan PRRA"))
                {
                    url+="&report=report/ReportPRR/dataPendukung_duprr_umum.rpt";
                }
                else if (lampiran.equals("Pendukung Daftar Penghapusan PRRB"))
                {
                    url+="&report=report/ReportPRR/dataPendukung_duprr_nonumum.rpt";
                }
                else if (lampiran.equals("Lampiran VIIIB"))
                {
                    url+="&report=report/ReportPRR/tul_lpprh.rpt";
                }


                com.google.gwt.user.client.Window.open(url, "Report Viewer", "directories=no,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=no,status=yes");

            }
        });
    }
}
