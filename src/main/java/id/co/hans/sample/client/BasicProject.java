package id.co.hans.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.MessageBox;

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
        Widget widgetMenu = View.getInstance().getViewByIdMenu(page, idUser, unitupUser, levelUser);

        if (widgetMenu != null) {
            RootPanel.get().add(widgetMenu);
        } else {
            AlertMessageBox box = new AlertMessageBox("Error", "Message error : Menu belum teridentifikasi pada aplikasi, "+ page);
            box.setIcon(MessageBox.ICONS.warning());
            box.show();
        }

        //RootPanel.get().add(new Form_Report11_Rekap().asWidget(idUser, unitupUser, levelUser));
    }
}
