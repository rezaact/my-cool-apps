package id.co.hans.sample.client.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.client.loader.HttpProxy;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.data.shared.loader.*;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridView;

import java.util.*;

public class IconDynamicGrid implements IsWidget {
    /*----------------------------------------------------------------------------------------------------------------*/
    private class StringValueProvider implements ValueProvider<Map<String, String>, String> {
        protected String property;

        public StringValueProvider(String property){
            this.property = property;
        }

        @Override
        public String getValue(Map<String, String> object) {
            return object.get(property);
        }

        @Override
        public void setValue(Map<String, String> object, String value) {
            object.put(property, value);
        }

        @Override
        public String getPath() {
            return property;
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
    List<ColumnConfig<Map<String, String>, ?>> columnConfigs = new ArrayList<ColumnConfig<Map<String, String>, ?>>();
    HashMap<Integer, HashMap> columnProperties = new HashMap<Integer, HashMap>();
    Integer columnIndex = -1;

    private String storeUrl = "";
    private String storeUrlParameters = "";
    private String gridHeader;
    private Integer gridHeight, gridWidth;

    private Grid<Map<String, String>> grid;
    /*----------------------------------------------------------------------------------------------------------------*/

    /*----------------------------------------------------------------------------------------------------------------*/
    public void addColumn(String columnName, Integer columnLength){
        this.columnIndex++;

        HashMap _columnProperties = new HashMap<String, String>();
        _columnProperties.put("name", columnName);
        _columnProperties.put("length", columnLength.toString());

        this.columnProperties.put(this.columnIndex, _columnProperties);
    }

    public void setStoreUrl(String storeUrl){
        this.storeUrl = storeUrl;
    }

    public int getDataCount(){
        return this.grid.getStore().size();
    }

    public void setGridHeader(String gridHeader){
        this.gridHeader = gridHeader;
    }

    public void setGridHeight(Integer gridHeight){
        this.gridHeight = gridHeight;
    }

    public void setGridWidth(Integer gridWidth){
        this.gridWidth = gridWidth;
    }

    public void setGridDimension(Integer gridWidth, Integer gridHeight) {
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
    }

    public GridView<Map<String,String>> getView(){
        return this.grid.getView();
    }

    public void setUrlParameters(String parameters) {
        this.storeUrlParameters = parameters;
    }

    public void load() {

        GridAutoBeanFactory factory = GWT.create(GridAutoBeanFactory.class);

        requestBuilder = new RequestBuilder(RequestBuilder.GET, this.storeUrl + this.storeUrlParameters);
        proxy = new HttpProxy<ListLoadConfig>(requestBuilder);


        reader = new DataRecordJsonReader(factory, RecordResult.class);
        loader = new ListLoader<ListLoadConfig, ListLoadResult<Map<String, String>>>(proxy, reader);
        loader.addLoadHandler(new LoadResultListStoreBinding<ListLoadConfig, Map<String, String>, ListLoadResult<Map<String, String>>>(store));


        grid.setLoader(loader);

        this.loader.load();
    }
    /*----------------------------------------------------------------------------------------------------------------*/

    private ListStore<Map<String, String>> store;
    private RequestBuilder requestBuilder;
    private HttpProxy<ListLoadConfig> proxy;
    private DataRecordJsonReader reader;
    private ListLoader<ListLoadConfig, ListLoadResult<Map<String, String>>> loader;
    private ColumnConfig<Map<String, String>, String> columnConfig;
    private ColumnModel<Map<String, String>> cm;


    @Override
    public Widget asWidget() {

        GridAutoBeanFactory factory = GWT.create(GridAutoBeanFactory.class);

        store = new ListStore<Map<String, String>>(new ModelKeyProvider<Map<String,String>>() {
            @Override
            public String getKey(Map<String, String> item) {
                return null;
            }
        });

        requestBuilder = new RequestBuilder(RequestBuilder.GET, this.storeUrl);
        proxy = new HttpProxy<ListLoadConfig>(requestBuilder);


        reader = new DataRecordJsonReader(factory, RecordResult.class);
        loader = new ListLoader<ListLoadConfig, ListLoadResult<Map<String, String>>>(proxy, reader);
        loader.addLoadHandler(new LoadResultListStoreBinding<ListLoadConfig, Map<String, String>, ListLoadResult<Map<String, String>>>(store));


        for(Map.Entry<Integer, HashMap> entry : this.columnProperties.entrySet())
        {
            Integer columnIndex = entry.getKey();
            HashMap value = entry.getValue();

            String columnName = "";
            Integer columnLength = 0;

            Iterator it = value.entrySet().iterator();

            while (it.hasNext())
            {
                Map.Entry pairs = (Map.Entry) it.next();

                if(pairs.getKey() == "name"){
                    columnName = pairs.getValue().toString();
                }
                if(pairs.getKey() == "length"){
                    columnLength = Integer.valueOf(pairs.getValue().toString());
                }
                it.remove();
            }

            columnConfig = new ColumnConfig<Map<String, String>, String>(new StringValueProvider(columnName), columnLength, columnName);
            columnConfigs.add(columnConfig);
        }


        cm = new ColumnModel<Map<String, String>>(columnConfigs);

        grid = new Grid<Map<String, String>>(store, cm);
//        grid.getView().setForceFit(true);
        grid.setLoader(loader);
        grid.setLoadMask(true);
        grid.setBorders(true);
        grid.getView().setEmptyText("Please hit the load button.");

        grid.getView().setStripeRows(true);
        grid.getView().setColumnLines(true);


        FramedPanel fp = new FramedPanel();
        fp.setHeadingText(this.gridHeader);
        fp.setCollapsible(false);
        fp.setAnimCollapse(false);
        fp.setWidget(grid);
        fp.setPixelSize(this.gridWidth, this.gridHeight);
        fp.addStyleName("margin-0");
        fp.setButtonAlign(BoxLayoutContainer.BoxLayoutPack.CENTER);

//        fp.addButton(new TextButton("Load Json", new SelectEvent.SelectHandler() {
//            @Override
//            public void onSelect(SelectEvent event) {
//                loader.load();
//            }
//        }));

        return fp;
    }
}

//todo: selection model untuk checkbox
