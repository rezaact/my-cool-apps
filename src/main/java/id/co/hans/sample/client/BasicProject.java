package id.co.hans.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import id.co.hans.sample.client.components.IconDynamicGrid;
import id.co.hans.sample.client.form.TulVI.*;
import id.co.hans.sample.client.form.administrasi.*;
import id.co.hans.sample.client.form.cetakulang.*;
import id.co.hans.sample.client.form.creditnote.*;
import id.co.hans.sample.client.form.monitoring.*;
import id.co.hans.sample.client.form.monitoring.info.*;
import id.co.hans.sample.client.form.proses.*;
import id.co.hans.sample.client.form.reportmain.*;
import id.co.hans.sample.client.form.reportpantau.*;
import id.co.hans.sample.client.form.reporttul.report309.*;
import id.co.hans.sample.client.form.reporttul.report404.*;
import id.co.hans.sample.client.form.reporttul.report502.*;
import id.co.hans.sample.client.form.satker.*;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BasicProject implements EntryPoint {
    public void onModuleLoad() {
        getPageByIdSession(Window.Location.getParameter("keyId"),
                Window.Location.getParameter("page"),
                Window.Location.getParameter("idUser"),
                Window.Location.getParameter("unitupUser"),
                Window.Location.getParameter("levelUser"));
    }

    private void getPageByIdSession(String idSession, String page, String idUser, String unitupUser, String levelUser) {

//        IconDynamicGrid grid = new IconDynamicGrid();
//        grid.setGridHeader("Grid 1");
//        grid.setGridDimension(300, 200);
//        grid.setStoreUrl("BasicProject/thuGetString.json?name=store1");
//        grid.addColumn("kolom1", 100);
//        grid.addColumn("kolom2", 100);
//        grid.addColumn("kolom3", 100);
//
//        RootPanel.get().add(grid);
//
//        IconDynamicGrid grid2 = new IconDynamicGrid();
//        grid2.setGridHeader("Grid 2");
//        grid2.setGridDimension(300, 200);
//        grid2.setStoreUrl("BasicProject/thuGetString2.json");
//        grid2.addColumn("kolomA", 100);
//        grid2.addColumn("kolomB", 100);
//        grid2.addColumn("kolomC", 100);
//        grid2.addColumn("kolomD", 100);
//        grid2.addColumn("kolomE", 100);
//
//        RootPanel.get().add(grid2);

//        RequestBuilder rb = new RequestBuilder(RequestBuilder.POST, URL.encode("BasicProject/thuGetStringPost.json"));
//        try {
//
//            rb.setHeader("Content-type", "application/x-www-form-urlencoded");
//            rb.sendRequest("param_satu=ok&param_dua=tidakok", new RequestCallback() {
//                @Override
//                public void onResponseReceived(Request request, Response response) {
//                    if(response.getStatusCode() == 200) {
//                        System.out.println(response.getText());
//                    }
//                }
//
//                @Override
//                public void onError(Request request, Throwable ex) {
//                    System.out.println(ex.getMessage());
//                }
//            });
//        } catch (RequestException e) {
//            System.out.println(e.getMessage());
//        }


//
//        IconComboBox comboBox = new IconComboBox();
//        comboBox.setStoreUrl("BasicProject/thuGetComboData.json");
//        comboBox.setComboFieldName("combo 1");
//        comboBox.setComboWidth(250);
//        comboBox.setLabelWidth(180);
//        RootPanel.get().add(comboBox);
//
//        IconComboBox comboBox2 = new IconComboBox();
//        comboBox2.setStoreUrl("BasicProject/thuGetComboData2.json");
//        comboBox2.setComboFieldName("combo 2");
//        comboBox2.setComboWidth(250);
//        comboBox2.setLabelWidth(180);
//        RootPanel.get().add(comboBox2);

//        ComboUnits comboBox2 = new ComboUnits();
//        RootPanel.get().add(comboBox2);

//        RootPanel.get().add(new FormPelangganBtoB().asWidget());

        RootPanel.get().add(new Form_CetakUlangBebanKantor().asWidget());
    }
}
