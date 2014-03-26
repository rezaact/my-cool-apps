package id.co.hans.sample.client.form.proses;


import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.Padding;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer.HBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.*;

public class Form_21Upload {
    private VerticalPanel vp;
    ComboKodePP cbKdPP;

    private String idUser, levelUser, unitUser;
    public Widget asWidget(String idUser, String unitupUser, String levelUser) {
        this.idUser=idUser;
        this.unitUser=unitupUser;
        this.levelUser=levelUser;

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
        panel.setHeadingText("Pembatalan Piutang (31)");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        FieldSet fieldSet = new FieldSet();
        fieldSet.setHeadingText("");

        VerticalLayoutContainer FieldAtas = new VerticalLayoutContainer();
        fieldSet.add(FieldAtas);
        TextField IDPelunasan = new TextField();
        TextButton bUploadPelunasan = new TextButton("Pilih Pelunasan File");

        HBoxLayoutContainer UPLOAD = new HBoxLayoutContainer();
        FieldAtas.add(UPLOAD);
        UPLOAD.add(bUploadPelunasan, new BoxLayoutData(new Margins(0, 5, 0, 105)));
        UPLOAD.add(IDPelunasan);
        cbKdPP = new ComboKodePP();
        FieldAtas.add(cbKdPP);

        HBoxLayoutContainer Date = new HBoxLayoutContainer();
        FieldAtas.add(Date);
        DateField tgllunas = new DateField();
        TextField tUpload = new TextField();
        Date.add(new FieldLabel(tgllunas, "Tanggal Lunas"));
        Date.add(new FieldLabel(tUpload, "Upload Per"));

        p.add(fieldSet);

        FieldSet fieldSet1 = new FieldSet();
        fieldSet1.setHeadingText("");

        VerticalLayoutContainer FieldBawah = new VerticalLayoutContainer();
        fieldSet1.add(FieldBawah);

        HBoxLayoutContainer Bawah = new HBoxLayoutContainer();
        Bawah.setPadding(new Padding(5));
        Bawah.setHBoxLayoutAlign(HBoxLayoutAlign.MIDDLE);
        FieldBawah.add(Bawah);

        TextField tLembar = new TextField();
        tLembar.setWidth(60);
        TextField tTagih = new TextField();
        tTagih.setWidth(60);
        TextField tBK = new TextField();
        tBK.setWidth(60);
        TextButton bLihatFile = new TextButton("Lihat File");
        Bawah.add(new FieldLabel(tLembar, "Lembar"));
        Bawah.add(new FieldLabel(tTagih, "Rp Tagih"));
        Bawah.add(new FieldLabel(tBK, "Rp BK"));
        Bawah.add(bLihatFile);
        p.add(fieldSet1);



        //Grid
        IconDynamicGrid gpDataCN = new IconDynamicGrid();
        gpDataCN.setGridHeader("Data Master");
        gpDataCN.setGridDimension(623, 200);
        gpDataCN.setStoreUrl("BasicProject/thuGetString.json?name=store1");
        gpDataCN.addColumn("No", 50);
        gpDataCN.addColumn("ID Pel", 100);
        gpDataCN.addColumn("BLH", 50);
        gpDataCN.addColumn("KDPP", 100);
        gpDataCN.addColumn("TGLBAYAR", 80);
        gpDataCN.addColumn("RPTAG", 100);
        gpDataCN.addColumn("KD", 100);
        gpDataCN.addColumn("RPBK", 100);
        gpDataCN.addColumn("KDP", 100);
        gpDataCN.addColumn("UNITUP", 100);
        gpDataCN.addColumn("USERID", 100);

        p.add(gpDataCN);

        FramedPanel panelParameter = new FramedPanel();
        panelParameter.setBodyStyle("background: none; padding: 5px");
        panelParameter.setWidth(620);

        VerticalLayoutContainer vlcPParameter = new VerticalLayoutContainer();
        panelParameter.add(vlcPParameter);

        HBoxLayoutContainer hp1 = new HBoxLayoutContainer();
        hp1.add(new Label("Berhasil"), new BoxLayoutData(new Margins(0, 20, 0, 110)));
        hp1.add(new Label("Gagal"), new BoxLayoutData(new Margins(0, 20, 0, 0)));
        hp1.add(new Label("Berhasil"), new BoxLayoutData(new Margins(0, 35, 0, 0)));
        hp1.add(new Label("Gagal"), new BoxLayoutData(new Margins(0, 20, 0, 0)));
        vlcPParameter.add(hp1);

        hp1 = new HBoxLayoutContainer();
        TextButton bBReset = new TextButton("Reset");
        TextButton bBUpload = new TextButton("Upload");
        bBUpload.setEnabled(false);
        TextButton bBCetakBA = new TextButton("Lihat File");
        hp1.add(new Label("Upload"), new BoxLayoutData(new Margins(0, 20, 0, 110)));
        hp1.add(new Label("Upload"), new BoxLayoutData(new Margins(0, 15, 0, 6)));
        hp1.add(new Label("Update DPP"), new BoxLayoutData(new Margins(0, 10, 0, 0)));
        hp1.add(new Label("Update DPP"), new BoxLayoutData(new Margins(0)));
        hp1.add(bBReset, new BoxLayoutData(new Margins(0, 0, 0, 30)));
        hp1.add(bBUpload);
        hp1.add(bBCetakBA);
        vlcPParameter.add(hp1);

        hp1 = new HBoxLayoutContainer();
        hp1.setPadding(new Padding(5));
        TextField tBUpload = new TextField();
        tBUpload.setEnabled(false);
        tBUpload.setEmptyText("0");
        tBUpload.setWidth(60);
        TextField tGUpload = new TextField();
        tGUpload.setEnabled(false);
        tGUpload.setEmptyText("0");
        tGUpload.setWidth(60);
        TextField tBUpdate = new TextField();
        tBUpdate.setEnabled(false);
        tBUpdate.setEmptyText("0");
        tBUpdate.setWidth(60);
        TextField tGUpdate = new TextField();
        tGUpdate.setEnabled(false);
        tGUpdate.setEmptyText("0");
        tGUpdate.setWidth(60);
        hp1.add(tBUpload, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(tGUpload, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(tBUpdate, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(tGUpdate, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        vlcPParameter.add(new FieldLabel(hp1,"Lembar"));

        hp1 = new HBoxLayoutContainer();
        hp1.setPadding(new Padding(5));
        TextField tBUpload0 = new TextField();
        tBUpload0.setEnabled(false);
        tBUpload0.setEmptyText("0");
        tBUpload0.setWidth(60);
        TextField tGUpload0 = new TextField();
        tGUpload0.setEnabled(false);
        tGUpload0.setEmptyText("0");
        tGUpload0.setWidth(60);
        TextField tBUpdate0 = new TextField();
        tBUpdate0.setEnabled(false);
        tBUpdate0.setEmptyText("0");
        tBUpdate0.setWidth(60);
        TextField tGUpdate0 = new TextField();
        tGUpdate0.setEnabled(false);
        tGUpdate0.setEmptyText("0");
        tGUpdate0.setWidth(60);
        hp1.add(tBUpload0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(tGUpload0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(tBUpdate0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(tGUpdate0, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        vlcPParameter.add(new FieldLabel(hp1,"Rp Tagihan"));

        hp1 = new HBoxLayoutContainer();
        hp1.setPadding(new Padding(5));
        TextField tBUpload1 = new TextField();
        tBUpload1.setEnabled(false);
        tBUpload1.setEmptyText("0");
        tBUpload1.setWidth(60);
        TextField tGUpload1 = new TextField();
        tGUpload1.setEnabled(false);
        tGUpload1.setEmptyText("0");
        tGUpload1.setWidth(60);
        TextField tBUpdate1 = new TextField();
        tBUpdate1.setEnabled(false);
        tBUpdate1.setEmptyText("0");
        tBUpdate1.setWidth(60);
        TextField tGUpdate1 = new TextField();
        tGUpdate1.setEnabled(false);
        tGUpdate1.setEmptyText("0");
        tGUpdate1.setWidth(60);
        hp1.add(tBUpload1, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(tGUpload1, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(tBUpdate1, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        hp1.add(tGUpdate1, new BoxLayoutData(new Margins(0, 5, 0, 0)));
        vlcPParameter.add(new FieldLabel(hp1,"Rp BK"));

        p.add(panelParameter);


        return panel;
    }
}
