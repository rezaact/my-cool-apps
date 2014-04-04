package id.co.hans.sample.client;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;

public abstract class AbstractForm {
	
	protected static final String DATE_FORMAT_PATTERN = "dd-MMM-yy";
	protected static final DateTimeFormat DEFAULT_DATETIME_FORMATER = DateTimeFormat.getFormat(DATE_FORMAT_PATTERN);

	private String idUser;
	private String unitupUser;
	private String levelUser;
	private VerticalPanel vp;

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getUnitupUser() {
		return unitupUser;
	}

	public void setUnitupUser(String unitupUser) {
		this.unitupUser = unitupUser;
	}

	public String getLevelUser() {
		return levelUser;
	}

	public void setLevelUser(String levelUser) {
		this.levelUser = levelUser;
	}

	public Widget asWidget(String idUser, String unitupUser, String levelUser) {
		this.idUser = idUser;
		this.unitupUser = unitupUser;
		this.levelUser = levelUser;
		
		if (vp == null) {
            vp = new VerticalPanel();
            vp.setSpacing(5);
            initKomponen();
            initEvent();
        }
        return vp;
	}
	
	protected void initKomponen(){
        AutoProgressMessageBox progressBox = new AutoProgressMessageBox("Progress", "please wait");
        progressBox.setProgressText("wait...");
        vp.add(panelMain());
    }

	protected abstract void initEvent();
	protected abstract FramedPanel panelMain();
	
}
