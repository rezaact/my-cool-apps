package id.co.hans.sample.client.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.data.client.loader.HttpProxy;
import com.sencha.gxt.data.shared.*;
import com.sencha.gxt.data.shared.loader.*;
import com.sencha.gxt.widget.core.client.form.FieldLabel;

import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.form.ComboBox;

import java.util.*;

public class IconComboBox implements IsWidget{
    /*----------------------------------------------------------------------------------------------------------------*/
    private class StringLabelProvider implements LabelProvider<Map<String, String>>{
        protected String property;

        public StringLabelProvider(String property) {
            this.property = property;
        }

        @Override
        public String getLabel(Map<String, String> object) {
            return object.get(property);
        }
    }

    private class DataRecordJsonReader extends JsonReader<ListLoadResult<Map<String, String>>, RecordResult> {
        public DataRecordJsonReader(AutoBeanFactory factory, Class<RecordResult> rootBeanType) {
            super(factory, rootBeanType);
        }

        @Override
        protected ListLoadResult<Map<String, String>> createReturnData(Object loadConfig, RecordResult incomingData) {
            return new ListLoadResultBean<Map<String,String>>(incomingData.getRecords());
        }
    }
    public interface RecordResult {
        List<Map<String, String>> getRecords();
    }
    public interface GridAutoBeanFactory extends AutoBeanFactory {
        AutoBean<RecordResult> items();
        AutoBean<ListLoadConfig> loadConfig();
    }
    /*----------------------------------------------------------------------------------------------------------------*/


    /*----------------------------------------------------------------------------------------------------------------*/
    private String storeUrl;
    private String comboFieldName;
    private Integer labelWidth, comboWidth;

    private ComboBox<Map<String, String>> comboBox;
    private SelectionHandler<Map<String,String>> selectionHandler;

    private ListStore<Map<String, String>> store;
    private RequestBuilder requestBuilder;
    private HttpProxy<ListLoadConfig> proxy;
    private DataRecordJsonReader reader;
    private ListLoader<ListLoadConfig, ListLoadResult<Map<String, String>>> loader;
    /*----------------------------------------------------------------------------------------------------------------*/


    /*----------------------------------------------------------------------------------------------------------------*/
    public void setStoreUrl(String storeUrl){
        this.storeUrl = storeUrl;


        GridAutoBeanFactory factory = GWT.create(GridAutoBeanFactory.class);

        this.requestBuilder = new RequestBuilder(RequestBuilder.GET, this.storeUrl);
        this.proxy = new HttpProxy<ListLoadConfig>(this.requestBuilder);

        this.reader = new DataRecordJsonReader(factory, RecordResult.class);
        this.loader = new ListLoader<ListLoadConfig, ListLoadResult<Map<String, String>>>(proxy, reader);
        this.loader.addLoadHandler(new LoadResultListStoreBinding<ListLoadConfig, Map<String, String>, ListLoadResult<Map<String, String>>>(this.store));

        this.comboBox.setLoader(loader);
    }

    public void setComboFieldName(String comboFieldName){
        this.comboFieldName = comboFieldName;
    }

    public void setLabelWidth(Integer labelWidth){
        this.labelWidth = labelWidth;
    }

    public void setComboWidth(Integer comboWidth){
        this.comboWidth = comboWidth;
    }

    public void addSelectionHandler(SelectionHandler<Map<String, String>> handler) {
        this.selectionHandler = handler;
        if (this != null) {
            comboBox.addSelectionHandler(this.selectionHandler);
        }
    }

    public void loadStore(){
        this.comboBox.getLoader().load();
    }
    /*----------------------------------------------------------------------------------------------------------------*/

    public IconComboBox(){
        this.store = new ListStore<Map<String, String>>(new ModelKeyProvider<Map<String,String>>() {
            @Override
            public String getKey(Map<String, String> item) {
                return null;
            }
        });

        this.comboBox = new ComboBox<Map<String, String>>(this.store, new StringLabelProvider("displayValue"));
    }

    @Override
    public Widget asWidget() {
        comboBox.setEmptyText("Pilih...");
        comboBox.setAllowBlank(false);
        comboBox.setTypeAhead(true);
        comboBox.setEditable(true);
        comboBox.setWidth(this.comboWidth);

        comboBox.setTriggerAction(ComboBoxCell.TriggerAction.ALL);

        if(this.selectionHandler != null) {
            comboBox.addSelectionHandler(this.selectionHandler);
        }

        return comboBox;
    }

    public ComboBox getComboBox() {
        return this.comboBox;
    }
}