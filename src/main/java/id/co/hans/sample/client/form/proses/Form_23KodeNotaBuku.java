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
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.grid.CellSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridSelectionModel;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.validator.MinLengthValidator;
import com.sencha.gxt.widget.core.client.form.*;
import id.co.hans.sample.client.components.*;

public class Form_23KodeNotaBuku {


    private VerticalPanel vp;

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
        panel.setHeadingText("Manajemen Kode Pelunasan Beban Kantor");
        panel.setBodyStyle("background: none; padding: 5px");
        panel.setWidth(650);

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        panel.add(p);

        //From Kiri
        HorizontalPanel Top = new HorizontalPanel();

        FramedPanel panel1 = new FramedPanel();
        panel1.setBodyStyle("background: none; padding: 5px");
        panel1.setHeadingText("Entri Kode Pelunasan Beban Kantor");
        panel1.setWidth(300);

        VerticalLayoutContainer Kiri = new VerticalLayoutContainer();
        panel1.add(Kiri);

        TextField KBebanK = new TextField();
        Kiri.add(new FieldLabel(KBebanK, "Kode Beban Kantor"));

        TextArea description = new TextArea();
        description.setAllowBlank(false);
        description.addValidator(new MinLengthValidator(10));
        Kiri.add(new FieldLabel(description, "Nama Beban Kantor"));
        TextButton bKiriTambah = new TextButton("Tambah");
        TextButton bKiriReset = new TextButton("Reset");
        panel1.addButton(bKiriTambah);
        panel1.addButton(bKiriReset);
        Top.add(panel1);
        p.add(Top);

        //Form Kanan
        FramedPanel panel2 = new FramedPanel();
        panel2.setBodyStyle("background: none; padding: 5px");
        panel2.setHeadingText("Hapus Kode Pelunasan Beban Kantor");
        panel2.setWidth(300);

        VerticalLayoutContainer Kanan = new VerticalLayoutContainer();
        panel2.add(Kanan);

        TextField KKBebanK = new TextField();
        Kanan.add(new FieldLabel(KKBebanK, "Kode Beban Kantor"));

        TextArea Kdescription = new TextArea();
        Kdescription.setAllowBlank(false);
        Kdescription.addValidator(new MinLengthValidator(10));
        Kanan.add(new FieldLabel(Kdescription, "Nama Beban Kantor"));
        TextButton bKananTambah = new TextButton("Tambah");
        TextButton bKananReset = new TextButton("Reset");
        panel2.addButton(bKananTambah);
        panel2.addButton(bKananReset);
        Top.add(panel2);
        p.add(Top, new VerticalLayoutContainer.VerticalLayoutData(1,1,new Margins(0,0,0,0)));

        //Grid
        IconDynamicGrid gpDataCN = new IconDynamicGrid();
        gpDataCN.setGridHeader("Data Master");
        gpDataCN.setGridDimension(623, 200);
        gpDataCN.setStoreUrl("BasicProject/thuGetString.json?name=store1");
        gpDataCN.addColumn("KODE KOLEKTIF", 100);
        gpDataCN.addColumn("NAMA KOLEKTIF", 100);
        gpDataCN.addColumn("TRANSAKSI BY", 100);
        gpDataCN.addColumn("TGLTRANSAKSI", 100);
        gpDataCN.addColumn("THRU BY", 100);
        gpDataCN.addColumn("TGL THRU", 100);
        gpDataCN.addColumn("UNIT UP", 100);
        gpDataCN.addColumn("BEBAN KANTOR", 100);

        p.add(gpDataCN);


        return panel;
    }
}
