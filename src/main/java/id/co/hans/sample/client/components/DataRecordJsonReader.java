package id.co.hans.sample.client.components;

import id.co.hans.sample.client.components.IconComboBox.RecordResult;

import java.util.Map;

import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.sencha.gxt.data.shared.loader.JsonReader;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.ListLoadResultBean;

public class DataRecordJsonReader extends JsonReader<ListLoadResult<Map<String, String>>, RecordResult> {
    public DataRecordJsonReader(AutoBeanFactory factory, Class<RecordResult> rootBeanType) {
        super(factory, rootBeanType);
    }

    @Override
    protected ListLoadResult<Map<String, String>> createReturnData(Object loadConfig, RecordResult incomingData) {
        return new ListLoadResultBean<Map<String,String>>(incomingData.getRecords());
    }
}