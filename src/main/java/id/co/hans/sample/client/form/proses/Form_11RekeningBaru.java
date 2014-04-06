package id.co.hans.sample.client.form.proses;

import id.co.hans.sample.client.AbstractForm;
import id.co.hans.sample.client.components.ComboKodeProses;
import id.co.hans.sample.client.components.ComboTahunBulan;
import id.co.hans.sample.client.components.ComboUnits;

import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class Form_11RekeningBaru extends AbstractForm {

  @Override
  protected void initEvent() {

  }

  @Override
  protected FramedPanel panelMain() {
    FramedPanel panel = new FramedPanel();
    panel.setHeadingText("Form 11 Rekening Baru");
    panel.setBodyStyle("background: none; padding: 5px");
    panel.setWidth(650);

    VerticalLayoutContainer p = new VerticalLayoutContainer();
    panel.add(p);

    ComboUnits cbUnits = new ComboUnits();
    p.add(cbUnits);

    ComboTahunBulan cbBlth = new ComboTahunBulan();
    p.add(cbBlth);

    ComboKodeProses cbKdProses = new ComboKodeProses();
    p.add(cbKdProses);

    TextField tNorekAwal = new TextField();
    p.add(new FieldLabel(tNorekAwal, "NOREK Awal Rekening"));

    TextButton btnUploadSorek = new TextButton("UPLOAD");
    panel.addButton(btnUploadSorek);

    return panel;
  }
}
