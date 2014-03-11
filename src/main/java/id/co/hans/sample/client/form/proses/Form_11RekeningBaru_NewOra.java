package id.co.hans.sample.client.form.proses;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.ComboTahunBulan;
import id.co.hans.sample.client.components.ComboUnits;
import id.co.hans.sample.client.components.IconComboBox;
import id.co.hans.sample.client.components.IconDynamicGrid;

public class Form_11RekeningBaru_NewOra {


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
        panel.setHeadingText("11 Rekening Baru - New Ora");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        // panel Title="Pilih Referensi"


        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        IconComboBox cbKodeUnit = new IconComboBox();
        cbKodeUnit.setStoreUrl("BasicProject/thuGetComboData2.json");
        cbKodeUnit.setComboFieldName("Kode Unit");
        cbKodeUnit.setComboWidth(250);
        cbKodeUnit.setLabelWidth(180);
        p.add(cbKodeUnit);

        TextField tfKodeUnitDesc = new TextField();
        p.add(new FieldLabel(tfKodeUnitDesc, "Kode Unit"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        ComboTahunBulan cbTahunBulan = new ComboTahunBulan();
        p.add(cbTahunBulan);


        IconComboBox cbKodeSiklis = new IconComboBox();
        cbKodeSiklis.setStoreUrl("BasicProject/thuGetComboData2.json");
        cbKodeSiklis.setComboFieldName("Kode Siklis");
        cbKodeSiklis.setComboWidth(250);
        cbKodeSiklis.setLabelWidth(180);
        p.add(cbKodeSiklis);

        p.add(new TextButton("Set Siklis"));

        TextField tfPeriodeBayar = new TextField();
        p.add(new FieldLabel(tfPeriodeBayar, "Kode Siklis"), new VerticalLayoutContainer.VerticalLayoutData(1, -1));


        Radio radioSourceSorexFile = new Radio();
        radioSourceSorexFile.setBoxLabel("File");
        p.add(radioSourceSorexFile);

        Radio radioSourceSorexOracle = new Radio();
        radioSourceSorexOracle.setBoxLabel("Oracle");
        p.add(radioSourceSorexOracle);



        IconComboBox cbPilihSourceSorex = new IconComboBox();
        cbPilihSourceSorex.setStoreUrl("BasicProject/thuGetComboData2.json");
        cbPilihSourceSorex.setComboFieldName("File Sorek");
        cbPilihSourceSorex.setComboWidth(250);
        cbPilihSourceSorex.setLabelWidth(180);
        p.add(cbPilihSourceSorex);


        CheckBox cbKirimSorekDJBB = new CheckBox();
        cbKirimSorekDJBB.setBoxLabel("Kirim Sorek ke P2APST");


        NumberField tfUploadPer = new NumberField(new NumberPropertyEditor.IntegerPropertyEditor());
        tfUploadPer.setText("500");
        p.add((new FieldLabel(tfUploadPer, "Upload Per")));


        DateField dfTanggalJatuhTempo = new DateField();
        p.add(new FieldLabel(dfTanggalJatuhTempo, "Tanggal Jatuh Tempo"));


        DateField dfTglJtBk1 = new DateField();
        p.add(new FieldLabel(dfTglJtBk1, "Tanggal JT BK 1"));

        DateField dfTglJtBk2 = new DateField();
        p.add(new FieldLabel(dfTglJtBk2, "Tanggal JT BK 2"));

        DateField dfTglJtBk3 = new DateField();
        p.add(new FieldLabel(dfTglJtBk3, "Tanggal JT BK 3"));


        // button upload file

        CheckBox cbMiddleFileDiServer = new CheckBox();
        p.add(new FieldLabel(cbMiddleFileDiServer, "File di Server"));

        TextField tfMiddleFileDiServer = new TextField();
        p.add(new FieldLabel(tfMiddleFileDiServer, "Nama File"));


        // panel "Data Upload Sorek"

        IconDynamicGrid gpTagihan = new IconDynamicGrid();
        gpTagihan.setGridHeader("Data Tagihan (Sampel data record 1 s/d 100)");
        gpTagihan.setGridDimension(300, 200);
        gpTagihan.setStoreUrl("BasicProject/thuGetString.json?name=store1");

        gpTagihan.addColumn("BOOL", 100);

        p.add(gpTagihan);


        // panel south
        TextField lMiddleJmlPelanggan = new TextField();
        p.add(new FieldLabel(lMiddleJmlPelanggan, "Jml Pelanggan"));

        TextField lMiddleJmlRpTag = new TextField();
        p.add(new FieldLabel(lMiddleJmlRpTag, "Jml RPTAG"));


        TextField lBottomStatus = new TextField();
        p.add(new FieldLabel(lBottomStatus, "Progress Uploading"));

        // add progress bar


        TextField tfBottomBerhasil = new TextField();
        p.add(new FieldLabel(tfBottomBerhasil, "Jml Berhasil"));

        TextField tfBottomGagal = new TextField();
        p.add(new FieldLabel(tfBottomGagal, "Jml Gagal"));


        p.add(new TextButton("Cetak BA"));

        // task runner UploadToTempSorek
        // on update untuk merefresh progress upload




        return panel;
    }
}
