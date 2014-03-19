package id.co.hans.sample.client.components;

import id.co.hans.sample.client.components.IconComboBox.GridAutoBeanFactory;
import id.co.hans.sample.client.components.IconComboBox.RecordResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.client.loader.HttpProxy;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.TriggerField;
import com.sencha.gxt.widget.core.client.grid.Grid;

public class ComboUnit implements IsWidget {

	private HorizontalPanel hp;
	private IconComboBox cbUnitUp;
	private TextField tfDescription;
	private String selectedValue;
	@SuppressWarnings("rawtypes")
	private List<TriggerField> changesFieldValue = new ArrayList<TriggerField>();
	private Map<ComboBox<Map<String, String>>, String> changesComboBoxStore = new HashMap<ComboBox<Map<String, String>>, String>();
	private Map<Grid<Map<String, String>>, String> changesGridStore = new HashMap<Grid<Map<String, String>>, String>();

	@Override
	public Widget asWidget() {
		cbUnitUp = new IconComboBox();
		cbUnitUp.setStoreUrl("BasicProject/thuGetComboData.json");
		cbUnitUp.setComboWidth(200);
		cbUnitUp.setLabelWidth(180);

		cbUnitUp.addSelectionHandler(new SelectionHandler<Map<String, String>>() {
			@Override
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public void onSelection(SelectionEvent<Map<String, String>> event) {
				Map<String, String> data = (Map<String, String>) event
						.getSelectedItem();

				tfDescription.setText(data.get("fieldValue"));
				selectedValue = data.get("fieldValue");
				
				for (TriggerField field : changesFieldValue) {
					field.setText(data.get("fieldValue"));
				}
				
				for (Entry<ComboBox<Map<String, String>>, String> entry : changesComboBoxStore.entrySet()) {
					GridAutoBeanFactory factory = GWT.create(GridAutoBeanFactory.class);
					String url = entry.getValue().replace("%s",data.get("fieldValue"));
					RequestBuilder requestBuilder = new RequestBuilder(
							RequestBuilder.GET, url);
					HttpProxy<ListLoadConfig> proxy = new HttpProxy<ListLoadConfig>(requestBuilder);

			        DataRecordJsonReader reader = new DataRecordJsonReader(factory, RecordResult.class);
			        PagingLoader loader = new PagingLoader(proxy, reader);
			        
			        loader.addLoadHandler(
			        		new LoadResultListStoreBinding<ListLoadConfig, Map<String, String>, 
			        		ListLoadResult<Map<String, String>>>(
			        				new ListStore<Map<String, String>>(
			        						new ModelKeyProvider<Map<String,String>>() {
					            @Override
					            public String getKey(Map<String, String> item) {
					                return null;
					            }
			        		}))
			        );
			        
			        entry.getKey().getLoader().load();
			        GWT.log("url : " + url);
				}
				
//				for (Entry<Grid<Map<String, String>>, String> entry : changesGridStore.entrySet()) {
//					entry.getKey().setStore(entry.getValue());
//				}
				
			}
		});

		tfDescription = new TextField();

		Label spacer1 = new Label("");
		spacer1.setPixelSize(10, 1);

		hp = new HorizontalPanel();
		hp.add(cbUnitUp);
		hp.add(spacer1);
		hp.add(tfDescription);

		cbUnitUp.loadStore();

		return new FieldLabel(hp, "Unit");
	}

	public String getSelectedValue() {
		return this.selectedValue;
	}

	public IconComboBox getCbUnitUp() {
		return this.cbUnitUp;
	}

	public TextField getCbUnitUpDesc() {
		return this.tfDescription;
	}

	@SuppressWarnings("rawtypes")
	public List<TriggerField> getChangesFieldValue() {
		return changesFieldValue;
	}

	@SuppressWarnings("rawtypes")
	public void setChangesFieldValue(List<TriggerField> changesFieldValue) {
		this.changesFieldValue = changesFieldValue;
	}

	public Map<ComboBox<Map<String, String>>, String> getChangesComboBoxStore() {
		return changesComboBoxStore;
	}

	public void setChangesComboBoxStore(
			Map<ComboBox<Map<String, String>>, String> changesComboBoxStore) {
		this.changesComboBoxStore = changesComboBoxStore;
	}

	public Map<Grid<Map<String, String>>, String> getChangesGridStore() {
		return changesGridStore;
	}

	public void setChangesGridStore(
			Map<Grid<Map<String, String>>, String> changesGridStore) {
		this.changesGridStore = changesGridStore;
	}
	
}
