package id.co.hans.sample.client.components;

import id.co.hans.sample.client.components.IconComboBox.GridAutoBeanFactory;
import id.co.hans.sample.client.components.IconComboBox.RecordResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.data.client.loader.HttpProxy;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.TriggerField;
import com.sencha.gxt.widget.core.client.grid.Grid;

public abstract class AbstractComboComponent implements IsWidget {
	
	@SuppressWarnings("rawtypes")
	private List<TriggerField> changesFieldValue = new ArrayList<TriggerField>();
	private Map<ComboBox<Map<String, String>>, String> changesComboBoxStore = new HashMap<ComboBox<Map<String, String>>, String>();
	private Map<Grid<Map<String, String>>, String> changesGridStore = new HashMap<Grid<Map<String, String>>, String>();

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void onComboChange(String value) {
		for (TriggerField field : changesFieldValue) {
			field.setText(value);
		}
		
		for (Entry<ComboBox<Map<String, String>>, String> entry : changesComboBoxStore.entrySet()) {
			GridAutoBeanFactory factory = GWT.create(GridAutoBeanFactory.class);
			RequestBuilder requestBuilder = new RequestBuilder(
					RequestBuilder.GET, URL.encode(entry.getValue()));
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
	        GWT.log("url : " + entry.getValue());
		}
		/*
		 * later please do support for grid update because combo box value has been changed
		 */
//		for (Entry<Grid<Map<String, String>>, String> entry : changesGridStore.entrySet()) {
//			entry.getKey().setStore(entry.getValue());
//		}
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
